---
sidebar: auto
---

# Purely Functional Parallelism

The fundamental assumption behind designing a purely functional *library* is that the library admits **no side effects**.

## Choosing Data Types and Functions

### Simple Example

An **example** of a parallelizable computation is summing a list of integers.

Summing a list of integers using something like `foldLeft` is typically done sequentially:

```scala
def sum(ints: Seq[Int]): Int =
  ints.foldLeft(0)((x, y) => x + y)
```

We can make this parallelizable by using a divide-and-conquer algorithm:

```scala
def sum(ints: IndexedSeq[Int]): Int =
  if (ints.size <= 1) {
    ints.headOption getOrElse 0
  } else {
    val (l, r) = ints.splitAt(ints.length / 2)
    sum(l) + sum(r)
  }
```

The `sum(l)` and `sum(r)` calls are not dependent on each other and so they can be computed at the same time.

### Choosing a Data Type

By looking at our example above we want our data type to be able to contain a result and also to retrieve that result from some computation.
