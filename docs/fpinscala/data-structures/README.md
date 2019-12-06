---
sidebar: auto
---

# Functional Data Structures

## Defining Functional Data Structures

A functional data structure is operated on using only **pure functions**.

> A pure function is a function that does not mutate data and performs no side effects.

Consider the following functional data structure, a singly linked list:

```scala
sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {
  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x, xs) => x * product(xs)
  }

  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))
}
```

* A `trait` is an abstract interface that may optionally contain implementations of some methods.
  * Here the trait `List` is defined, without any methods.
* The `sealed` keyword enforces that all implementations of the `trait` must be declared in this file.