package me.shoma.proxy.cache.server

import akka.actor._
import akka.event.Logging
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.HttpRequest
import akka.stream.ActorMaterializer

object MyApp extends App {

  implicit val actorSystem = ActorSystem("my-system")
  implicit val flowMaterializer = ActorMaterializer()

  import akka.http.scaladsl.server.Directives._

  val logger = Logging(actorSystem, getClass)
  val bindInterface = "0.0.0.0"
  val bindPort = 8080

  info()

  val route = get {
    pathEndOrSingleSlash {
      getFromFile("path/to/index.html")
    }
  } ~ path("test") {
    get {
      handleWith((a: HttpRequest) => s"your request is\n\n${a.headers.mkString("\n")}")
    }
  }

  val serverBinding = Http(actorSystem).bindAndHandle(route ,interface = bindInterface, port = bindPort)

  private def info(): Unit = {
    logger.info(s"  - Configuration: Start server at $bindInterface $bindPort on ActorSystem(${actorSystem.name})")
  }
}