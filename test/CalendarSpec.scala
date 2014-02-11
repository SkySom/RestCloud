import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

import play.api.http.HeaderNames
import play.api.libs.json.Json
import play.api.test._
import play.api.test.Helpers._

@RunWith(classOf[JUnitRunner])
class CalendarSpec extends Specification {
	"Calendar Controller" should {
		"Create a new calendar" in {
			running(FakeApplication()) {
				val json = Json.obj("name" -> "name", "description" -> "description")
				val req = FakeRequest(
					POST,
					"/calendars",
					FakeHeaders(Seq("Content-type"->Seq("application/json"))),
					json
				)
				val Some(result) = route(req)

				status(result) must equalTo(OK)
				contentType(result) must beSome("application/json")
				charset(result) must beSome("utf-8")

				val res = Json.parse(contentAsString(result))
				(res \ "status").as[String] must equalTo("OK")
				(res \ "message" \ "name").as[String] must equalTo("name")
				(res \ "message" \ "description").as[String] must equalTo("description")
			}
		}
	}
}
