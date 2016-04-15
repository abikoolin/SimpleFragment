package BeginningScala

class Circle(val radius : Double) extends Shape {
  override def area : Double = {
    math.Pi * radius * radius
  }
  
  def draw(s : Shape) = {
    println("this is a Circle")
  }
}