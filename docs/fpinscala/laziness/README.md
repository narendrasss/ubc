---
sidebar: auto
---

# Strictness and Laziness

Each function that we defined on `List` makes one pass on list and produces a new `List`. If we chain these functions together, we would have to make multiple passes over the list when it might actually be unnecessary.

**Non-strictness** is a way to "fuse" these intermediary lists together into one pass.

## Strict and Non-Strict Functions

Typically the arguments of a function is evaluated prior to that function being called:

```scala
def square(num: Int): Int = num * num

square(6 + 3) // 81
square(throw new Exception("fail!")) // exception
```

These functions are called **strict** functions. **Non-strict** or **lazy** functions are functions where the arguments are only evaluated *when they are used*:

```scala
def square(num: => Int): Int =
  try num * num
  catch { case e: Exception => 0 }

square(throw new Exception("fail!")) // 0
```

The `=>` syntax indicates that the argument is lazy. It is actually a function that gets called when the argument is being used:

```scala
def square(num: () => Int): Int = num() * num()
def square(num: => Int): Int = num * num // same as above
```

:::tip Caching
These parameters are **not** cached. This means that `num` above will be evaluated twice as it is being used twice.

To cache a value we have to add the `lazy` keyword to our variable:

```scala
lazy val arg = num
arg * arg
```
:::

## Streams

Streams are essentially **lazy lists**.

```scala
sealed trait Stream[+A]
case object Empty extends Stream[Nothing]
case class Cons[+A](head: () => A, tail: () => Stream[A]) extends Stream[A]

object Stream {
  def cons[A](head: => A, tail: => Stream[A]): Stream[A] = {
    lazy val hd = head // cache the head
    lazy val tl = tail // cache the tail
    Cons(() => hd, () => tl)
  }

  def empty[A]: Stream[A] = Empty

  def apply[A](as: A*): Stream[A] =
    if (as.isEmpty) Empty else cons(as.head, apply(as.tail: _*))
}
```
