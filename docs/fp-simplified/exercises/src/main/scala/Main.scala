import fpsimplified.io._

object Main extends App {
  val program = for {
    _ <- IO { println("What's your name?") }
    name <- IO { scala.io.StdIn.readLine }
    _ <- IO { println(s"\nHello, $name!") }
  } yield ()

  // program.unsafePerformIO
}
