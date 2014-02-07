package controllers

import play.mvc.Controller
import play.api.mvc.Action
import play.api.mvc.Results._
/**
 * Created by Skylar on 2/6/14.
 */
object CalendarController extends Controller{
	def List = Action {
		request => Ok("Got request [" + request + "]")
	}
}
