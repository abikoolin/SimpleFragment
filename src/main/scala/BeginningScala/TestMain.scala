package BeginningScala

object TestMain {
  
  def main(args: Array[String]): Unit = {
    
     def draw (s : Shape)  = {
       
       s.draw(s)
       
     }
     
     val circle = draw(new Circle(3))
     
     val retangle = draw(new Rectangle(3, 4))
     
  }
}