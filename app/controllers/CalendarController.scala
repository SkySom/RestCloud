package controllers

/**
 * @author Skylar Sommers
 * @version 1.0.0
 */

import play.mvc.Controller
import play.api.mvc.Action
import play.api.mvc.Results._
import models.Calendar
import play.api.libs.json._
import play.api.libs.functional.syntax._

object CalendarController extends Controller {

	implicit val rds =
		(__ \ 'name).read[String] and
		(__ \ 'description).read[String]

	def List = Action { request =>
		Ok("Got request [" + request + "]")
	}

	def Create = Action { request =>
		request.body.asJson.map { json =>
			json.validate[(String, String)].map{
				case (name, description) => Ok(Json.obj("status" -> "OK", "message" -> Json.obj("name" -> name,
					"description" -> description)))
			}.recoverTotal{
				e => Status(400)(Json.obj("status" -> "KO", "message" -> JsError.toFlatJson(e)))
			}
		}.getOrElse {
			Status(400)(Json.obj("status" -> "KO", "message" -> "Expecting Json Data"))
		}
	}

	def Delete(id: Int) = Action { request =>
		Ok("Deleting Calender " + id)
	}


}
