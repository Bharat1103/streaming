package streaming

import akka.actor.ActorSystem

object JvmStreamingApp {
  def main(args: Array[String]): Unit = {
    implicit val actorSystem: ActorSystem = ActorSystem("test")
    import monix.execution.Scheduler.Implicits.global

    val client = new JvmStreamingClient("ws://0.0.0.0:9090/ws")

    client.api.from(10).foreach(println)
  }
}
