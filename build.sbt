name := "proxy-cache-server"

version := "0.1"

scalaVersion := "2.11.8"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8", "-Xlint")

assemblyOutputPath in assembly := file("./proxy-cache-server.jar")

val akkaVersion = "2.4.5"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor"                         % akkaVersion,
  "com.typesafe.akka" %% "akka-stream"                        % akkaVersion,
  "com.typesafe.akka" %% "akka-http-experimental"             % akkaVersion,
  "com.typesafe.akka" %% "akka-http-spray-json-experimental"  % akkaVersion,
  "com.typesafe.akka" %% "akka-http-xml-experimental"         % akkaVersion,
  "com.typesafe.akka" %% "akka-http-testkit"                  % akkaVersion
)