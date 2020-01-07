package fpsimplified.io

// case class doesn't work for by-name parameters
class IO[A] private (code: => A) {
  def unsafePerformIO = code

  def map[B](f: A => B): IO[B] = IO(f(unsafePerformIO))

  // f(unsafePerformIO) doesn't work because it doesn't
  // correctly delay evaluation
  def flatMap[B](f: A => IO[B]): IO[B] = IO(f(unsafePerformIO).unsafePerformIO)
}

object IO {
  def apply[A](a: => A) = new IO(a)
}
