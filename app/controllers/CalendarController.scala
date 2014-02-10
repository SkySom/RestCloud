package controllers

/**
 * @author Skylar Sommers
 * @version 1.0.0
 */

import play.mvc.Controller
import play.api.mvc.Action
import play.api.mvc.Results._
import play.api.libs.json
import models.Calendar
import play.api.libs.json.{Json, JsValue}

object CalendarController extends Controller {
	def List = Action { request =>
		Ok("Got request [" + request + "]")
	}

	def Create = Action { request =>
		Ok("Here's the body ")
	}

	def Delete(id: Int) = Action { request =>
		Ok("Deleting Calender " + id)
	}


}
