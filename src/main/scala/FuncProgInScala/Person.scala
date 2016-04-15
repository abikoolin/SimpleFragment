package FuncProgInScala

case class Player(name: String, score: Int)

class Fp {

  def winner(p1: Player, p2: Player): Player =
    if (p1.score > p2.score) p1 else p2

  def declareWinner(p1: Player, p2: Player): Unit =
    printWinner(winner(p1, p2))

  def printWinner(p: Player): Unit =
    println(p.name + " is the winner")
}

