package streaming

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.RouteResult._
import akka.stream.{ActorMaterializer, OverflowStrategy}
import ch.megard.akka.http.cors.scaladsl.CorsDirectives._
import chameleon.ext.circe._
import covenant.ws.AkkaWsRoute
import io.circe.generic.auto._
import monix.reactive.Observable
import mycelium.server.WebsocketServerConfig

object StreamingServer {
  import sloth._

  def main(args: Array[String]): Unit = {
    implicit val system: ActorSystem             = ActorSystem("server")
    implicit val materializer: ActorMaterializer = ActorMaterializer()
    import monix.execution.Scheduler.Implicits.global

    val config = WebsocketServerConfig(
      bufferSize = 5,
      overflowStrategy = OverflowStrategy.fail
    )
    val wsRouter = Router[String, Observable].route[Streaming](StreamingImpl)

    val route = cors() {
      AkkaWsRoute.fromObservableRouter(wsRouter, config, failedRequestError = err => err.toString)
    }

    Http().bindAndHandle(route, interface = "0.0.0.0", port = 9090)
  }
}
