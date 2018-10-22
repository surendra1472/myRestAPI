package json

import scala.io.Source


object jsonFileReader {
  def getJsondetails(fileName: String) = {
    var jsonString: String = Source.fromFile(fileName).mkString

  }

}
