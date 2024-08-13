package practicle8

import scala.io.StdIn

object lambdaCategorize {
  def run(): Unit = {

    print("Enter a number: ")
    val input = StdIn.readInt()

    val result = input match {
      case n if n % 3 == 0 && n % 5 == 0 && n % 6 == 0 =>
        "Multiple of Six, Three and Five"
      case n if n % 3 == 0 && n % 5 == 0 => "Multiple of Both Three and Five"
      case n if n % 3 == 0 && n % 6 == 0 => "Multiple of Both Six and Three"
      case n if n % 6 == 0 && n % 5 == 0 => "Multiple of Both Six and Five"
      case n if n % 6 == 0               => "Multiple of Six"
      case n if n % 3 == 0               => "Multiple of Three"
      case n if n % 5 == 0               => "Multiple of Five"
      case _ => "Not a Multiple of Three or Five or Six"
    }

    println(result)
  }
}
