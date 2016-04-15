package fileSearcher

import org.scalatest._
import java.io.File

class FilterCheckerTests extends FlatSpec {
  "Filter checker passed a list where one file matches the filter" should
    "return a list with that file" in {

      val listOfFiles = List(FileObject(new File("random")),
        FileObject(new File("match")))
      val matchedFiles = FilterChecker("match").findMatchedFiles(listOfFiles)
      assert(matchedFiles == List(FileObject(new File("match"))))
    }

  "FilterChecker passed a list with a directory that matches a filter" should
    "should not return the directory" in {
      val listOfIOObjects = List(FileObject(new File("random")), new DirectoryObject(new File("match")))
      val matchedFiles = FilterChecker("match").findMatchedFiles(listOfIOObjects)
      assert(matchedFiles.length == 0)
    }

  "Filter checker passed a file with content that matches the filer" should
    "return that match successed " in {
      val isContentMatched = FilterChecker("pluralsight")
        .matchesFileContent(new File("C:\\Demo\\Filesearcher\\src\\test\\testFiles\\pluralsight.data"))

      assert(isContentMatched == true)
    }

  "Filter checker passed a file with content that does not match a file" should
    "return that the match failed " in {
      val isContentMatched = FilterChecker("pluralsight")
        .matchesFileContent(new File("C:\\Demo\\Filesearcher\\src\\test\\testFiles\\readme.txt"))

      assert(isContentMatched == false)
    }
}