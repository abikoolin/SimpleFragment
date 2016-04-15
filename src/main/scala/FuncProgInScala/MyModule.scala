package FuncProgInScala

object MyModule {

  def abs(n: Int): Int =
    if (n < 0) -n
    else n

  private def formatAbs(x: Int) = {
    val msg = "The absolute value of %d is %d"
    msg.format(x, abs(x))
  }

  def main(args: Array[String]): Unit =
    println(formatAbs(-42))

}

object Samples {

  def factorial(n: Int): Int = {

    @annotation.tailrec
    def go(n: Int, accumulated: Int): Int = {

      if (n <= 0) accumulated
      else go(n - 1, n * accumulated)
    }

    go(n, 1)
  }

  def fibonacci(n: Int) = {

    def calcFibo(n: Int, accum: Int): Int = {
      if (n <= 0)
        accum
      else
        calcFibo(n - 1, n + accum)
    }

    calcFibo(n, 0)
  }

  def formatResult(name: String, n: Int, f: Int => Int) = {
    val msg = "The %s of %d is %d."
    msg.format(name, n, f(n))
  }

  def main(args: Array[String]): Unit = {
    println(formatResult("factorial", 5, factorial))
    println(formatResult("fibonacci", 5, fibonacci))
    println(formatResult("increment by one", 5, (x : Int) => x + 1))
  }

}

