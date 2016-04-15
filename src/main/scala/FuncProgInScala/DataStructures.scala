package FuncProgInScala

sealed trait List[+A]  

case object Nil extends List[Nothing]

case class Cons[+A](head : A, tail : List[A]) extends List[A]

class dataStuct {
  
  def sum(ints : List[Int]) : Int = ints match {
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }
  
  def product(ds : List[Double]) : Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(a, as) => a + product(as)
  }
  
  
  
}