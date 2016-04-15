package fileSearcher

import scala.util.control.NonFatal
import java.io.File
import java.lang.Boolean

class FilterChecker(filter: String) {

  def matches(content: String) = content contains filter

  def findMatchedFiles(ioObjects: List[IOObject]) =
    for (
      ioObject <- ioObjects if (ioObject.isInstanceOf[FileObject]) if (matches(ioObject.name))
    ) yield ioObject

  def matchesFileContent(file: File) = {
    import scala.io.Source
    try {

      val fileSource = Source.fromFile(file)
      try {
        fileSource.getLines() exists( line => matches(line) )
      } catch {
        case NonFatal(_) => false
      } finally
        fileSource.close()

    } catch {
      case NonFatal(_) => false
    }
  }
}

object FilterChecker {
  def apply(filter: String) = new FilterChecker(filter)
}