import sbt._
import Def.{setting => dep}
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._

object Akka {
  val Version = "2.5.11"

  val `akka-stream`        = "com.typesafe.akka" %% "akka-stream"        % Version
  val `akka-typed`         = "com.typesafe.akka" %% "akka-actor-typed"   % Version
  val `akka-http`          = "com.typesafe.akka" %% "akka-http"          % "10.1.1"
  val `akka-typed-testkit` = "com.typesafe.akka" %% "akka-testkit-typed" % Version
  val `akka-http-circe`    = "de.heikoseeberger" %% "akka-http-circe"    % "1.20.1" //Apache 2.0
}

object Libs {
  val `akka-http-cors` = "ch.megard" %% "akka-http-cors" % "0.3.0"
}

object Covenant {
  val Version = "0add6d5"

  val `covenant-http` = dep("com.github.cornerman.covenant" %%% "covenant-http" % Version)
  val `covenant-ws`   = dep("com.github.cornerman.covenant" %%% "covenant-ws"   % Version)
}

object Circe {
  val Version = "0.9.3"

  val `circe-core`    = dep("io.circe" %%% "circe-core"    % Version)
  val `circe-generic` = dep("io.circe" %%% "circe-generic" % Version)
  val `circe-parser`  = dep("io.circe" %%% "circe-parser"  % Version)
}
