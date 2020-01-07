---
sidebar: auto
---

# Functional Programming, Simplified

## Partially-Applied Functions

Scala code won't compile if you don't supply the later parameter groups, i.e.

```scala
def plus(a: Int)(b: Int): Int = a + b
plus(2) // won't compile
```

We have to explicitly use `_` if we want it to return the partially applied function:

```scala
plus(2)(_) // compiles to a curried function
```

The advantage is you don't have to partially apply the functions in the order in which they were defined, e.g. you can omit the middle parameter with `_` and it compiles fine:

```scala
def wrap(prefix: String)(html: String)(suffix: String): String = prefix + html + suffix
val wrapWithDiv = wrap("<div>")(_: String)("</div>")

wrapWithDiv("hi!") // <div>hi!</div>
```

## Opening Curly Brace

One weird scala structure (1):

```scala
val x = FOO { (s: State) =>
    // more code
}
```

Or just (2):

```scala
val x = FOO {
    // more code
}
```

What FOO is depends on whether it is (1) or (2):

1. FOO is either an **anonymous** class or a function that takes a **by-name parameter**.
2. FOO is either a **class that takes a function parameter** or a function that takes a **by-name parameter**.

### Anonymous class

```scala
val mary = new Person {
    val name = "mary"
    val age = 25
}
```

This code creates a new Person instance using Scala's anonymous class syntax.

* We know it's not a `case class` because a `case class` requires at least one constructor parameter and does not allow the `new` keyword.

### By-name parameter

```scala
def timer[A](blockOfCode: => A) = ???

val time = timer {
    // some long code
}
```

Since `blockOfCode` is received by-name, we can use the `timer` function with the open curly brackets.

## IO Monad

The IO monad or IO *container* wraps impure IO functions. Instead of running the impure functions right away, IO allows you to provide a *description* of how you would like to deal with the result of the impure function and defers the actual action to some time *later*.

e.g. This piece of code prints `"Hello, world"` to the console right away:

```scala
object HelloWorld extends App {
    val result = println("Hello, world")
}
```

Whereas this does not print anything:

```scala
object AlmostHelloWorld extends App {
    val result = IO { println("Hello, world") }
}
```

This allows us to pass the IO around, use it in `for` comprehensions, `map` over it, `flatMap` over it, etc.

To "run" the IO, we call its `unsafePerformIO` function:

```scala
object HelloWorld extends App {
    val result = IO { println("Hello, world") }
    result.unsafePerformIO()
}
```
