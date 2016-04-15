package fileSearcher

import org.scalatest._
import java.io.File

class MatcherTests extends FlatSpec {
  "Matcher that is passed a file matching the filter" should 
  "return a file with that file name" in {
    val matcher = new Matcher("fake", "fakePath")
    
    val results = matcher.execute()
    
    assert(results == List("fakePath"))
  }
  
  "Matcher using a directory containing one file amathing the filter" should 
  "return a file with that file name " in {
    val searchSubFolders = true
    val matcher = new Matcher("txt", 
        new File("C:\\Demo\\Filesearcher\\src\\test\\testFiles\\").getCanonicalPath(),
        searchSubFolders)
    
    val results = matcher.execute()
    assert(results == List("test.txt","readme.txt"))
  }
  
  "Matcher given a path that has one file that matches file filter and content filter" should 
  "return a list with that file name " in {
    
    val matcher = new Matcher("data", new File(".").getCanonicalPath(), true,
        Some("pluralsight"))
    
    val matchedFiles = matcher.execute()
    
    assert(matchedFiles == List("pluralsight.data"))
  }
  
  "Matcher given a path that has no file that matches file filter and content filter" should
  "return an empty list " in {
    val matcher = new Matcher("txt", new File(".").getCanonicalPath(), true,
        Some("pluralsight"))
    
    val matchedFiles = matcher.execute()
    
    assert(matchedFiles == List())
  }
  
}