package BeginningScala

class Rectangle(val width : Double, val hieght : Double) extends Shape {
  
  override def area : Double = width * hieght
  
  def draw(s : Shape) = {
    println("thid is a Rectangle")
  }
  
}