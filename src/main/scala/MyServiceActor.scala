import spray.http._
import spray.routing._
import StatusCodes._

class MyServiceActor extends HttpServiceActor {
  def receive = runRoute {
    get {
      complete {
        "Hello world"
      }
    }
  }

}
