---
sidebar: auto
---

# Purely Functional State

## Generating Random Numbers

### Using Side Effects

A function that returns random numbers is a typical example of a **non-pure** function. The value that it returns is not consistent:

```scala
val rng = new scala.util.Random

rng.nextDouble // 0.9867076608154569
rng.nextDouble // 0.8455696498024141
```

Number generation typically works through an operation that depends on some **internal state**. This state gets updated every time the function is called.

The existence of this state suggests that the function has *side-effects*, which is updating this internal state. This is not desirable in functional programming because it hinders testability and reliability.

### Purely Functional Generation

The simple way to make the API pure is to *return* the next state, leaving the current state alone:

```scala
trait RNG {
  def nextInt: (Int, RNG)
}
```

This way the caller is in charge of what to do with the next state. Given the same state, `nextInt` will **always** return the same number.

## State Actions

All functions of the form `S => (A, S)` are called **state actions** or *transitions* because they transform states `S` from one to the next. To make it simpler, we can add a type alias or even a class for these functions:

```scala
case class State[S, +A](run: S => (A, S))
```

We can then define functions that operate on this `State` class.
