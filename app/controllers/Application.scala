package controllers

import play.mvc.Controller
import play.api.mvc.Action
import play.api.mvc.Results._


object Application extends Controller {
  def index = Action { request =>
    Ok("Got request [" + request + "]")
  }
}