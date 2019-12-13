---
sidebar: auto
---

# Handling Errors Without Exceptions

## The Good and Bad of Exceptions

### Referential Transparency

Exceptions break **referential transparency** (RT). RT expressions can be replaced with the value that they evaluate to while maintaining program meaning.

```scala
def failingFn(i: Int): Int = {
  val y: Int = throw new Exception("fail!")
  try {
    val x = 42 + 5
    x + y
  } catch { case e: Exception => 43 }
}
```

The above function throws a runtime error when run. However if we replace `y` with the expression, i.e. the `throw new Exception` call, the program would return `43`. Since the program behaves differently, RT is not preserved.

### Type Safety

The type of the function (e.g. `Int => Int` above) tells us nothing about the fact that exceptions may occur.

* Java has checked exceptions which kind of gets around this, but generic functions such as `map` or `foldLeft` would somehow have to be aware of exceptions as well.

## Option

The `Option` data type is a solution to this by explicitly suggesting that a function will not always have a result for all inputs.

```scala
sealed trait Option[+A]
case class Some[+A](get: A) extends Option[A]
case object None extends Option[Nothing]
```

The `Option` data type is:

* A `Some` if it contains a value, or
* A `None` if it is empty (i.e. throws an error)

### Lifting Option

When we start using options, it might seem that we have to update our caller's functions to be able to operate on options.

This can be automated through the `lift` function:

```scala
def lift[A, B](f: A => B): Option[A] => Option[B] = _ map f
```

## Either

With the `Option` data type, we retain no information when an error occurs (we only get back `None`). The `Either` data type allows us to pass information for when exceptions occur.

The `Either` type is either a `Left` or a `Right`, with the `Left` type reserved for exceptional cases.

```scala
sealed trait Either[+E, +A]
case class Left[+E](get: E) extends Either[E, Nothing]
case class Right[+A](get: A) extends Either[Nothing, A]
```
