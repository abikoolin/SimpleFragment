package fileSearcher

import java.io._

trait IOObject {
  val file : File
  val name = file.getName()
}

case class FileObject(val file : File) extends IOObject
case class DirectoryObject(val file : File) extends IOObject {
  def children() = 
    try {
       file.listFiles().toList.map ( file => FileConverter.convertToIOObject(file) )
    } catch {
      case _ : NullPointerException => List()
    }
   
}
