case class MyData(
  name: String,
  tags: String
)

object JsonFormats {
  import play.api.libs.json.Json
  import play.api.data._
  import play.api.data.Forms._

  implicit val dataFormat = Json.format[MyData]
}
