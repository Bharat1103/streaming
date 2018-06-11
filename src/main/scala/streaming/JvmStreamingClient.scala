package streaming

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import covenant.ws.WsClient
import chameleon.ext.circe._
import io.circe.generic.auto._
import mycelium.client.WebsocketClientConfig

class JvmStreamingClient(baseUri: String)(implicit system: ActorSystem) {
  private implicit val materializer: ActorMaterializer = ActorMaterializer()
  import monix.execution.Scheduler.Implicits.global
  private val config = WebsocketClientConfig()
  private val client = WsClient.streamable[String, Unit, String](s"ws://localhost:9090/ws", config)
  val api: Streaming = client.sendWith(requestTimeout = None).wire[Streaming]
}
