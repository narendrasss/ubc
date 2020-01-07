package fpsimplified.wrapper

class Wrapper[A] private (value: A) {
  def map[B](f: A => B): Wrapper[B] = new Wrapper(f(value))

  def flatMap[B](f: A => Wrapper[B]): Wrapper[B] = f(value)

  override def toString(): String = s"Wrapper($value)"
}

object Wrapper {
  def apply[A](value: A): Wrapper[A] = new Wrapper(value)
}
