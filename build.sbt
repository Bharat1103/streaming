
name := "streaming"

version := "0.1"

scalaVersion := "2.12.6"

lazy val streaming = (project in file("."))
  .settings(
    name := "sequencer-framework",
    resolvers += "jitpack" at "https://jitpack.io",
    libraryDependencies ++= Seq(
      Akka.`akka-stream`,
      Akka.`akka-typed`,
      Akka.`akka-typed-testkit`,
      Libs.`akka-http-cors`,
      Akka.`akka-http`,
      Akka.`akka-http-circe`,
      Circe.`circe-core`.value,
      Circe.`circe-generic`.value,
      Circe.`circe-parser`.value,
      Covenant.`covenant-http`.value,
      Covenant.`covenant-ws`.value
    )
  )