import spray.http._
import spray.routing._
import StatusCodes._
import reactivemongo.api.MongoDriver
import scala.concurrent.ExecutionContext.Implicits.global

class MyServiceActor extends HttpServiceActor {

  // a mongoDriver instance manages an actor system
  // using existing actorySystem -- context.system
  val driver = new MongoDriver(context.system)

  // a connect manages a pool of connections
  val connection = driver.connection(List("localhost"))

  // gets a reference to the database "spray-reactivemongo-textsearch"
  val db = connection.db("spray-reactivemongo-textsearch")
  val collection = db.collection("testDatas")

  def receive = runRoute {
    path("testDatas") {
      get {
        complete {
          "Hello world"
        }
      }
    }
  }
}
