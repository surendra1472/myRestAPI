package controllers

import javax.inject._
import play.api._
import play.api.mvc._

import scala.io.Source
import scala.util.parsing.json.JSON

import play.api.libs.json._

//import net.liftweb.json.DefaultFormats
//import net.liftweb.json._


/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  def greet(name: String) = Action {
    Ok("Hello " + name)
  }

  def details(name: String) = Action {
    val personDetails = getJsondetails(name)
    if(personDetails.isDefined) {
      Ok(getJsondetails(name).get.toString())
    } else {
      Ok( s"'$name' is not defined")
    }
  }

//  def greet(name: String) = Action {
//    var jsonString: String = Source.fromFile("/Users/surendragandham/IdeaProjects/restapi/data/details.json").mkString
//    val json = JSON.parseFull
//    val a = json(jsonString).get
//    JSON.parseFull(jsonString) match {
//      case Some(jsonDetails: Map[String, Any]) => Ok("Details: " + jsonDetails(name).toString)
//      case _ => Ok("Details of " + name + " Not found")
//    }
//  }
//
//

  private def getJsondetails(name: String) = {
    var jsonString: String = Source.fromFile("/Users/surendragandham/IdeaProjects/restapi/data/details.json").mkString
    val json: JsValue = Json.parse(jsonString)
    (json \ name)
  }

}
