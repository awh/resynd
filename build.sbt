name := "resynd"

version := "1.0"

scalaVersion := "2.11.6"

resolvers += "spray repo" at "http://repo.spray.io"

resolvers += "Typesafe Snapshots" at "http://repo.akka.io/snapshots/"

libraryDependencies ++= List(
  "com.typesafe.slick" %% "slick" % "2.1.0",
  "org.slf4j" % "slf4j-simple" % "1.7.10",
  "org.postgresql" % "postgresql" % "9.4-1201-jdbc41",
  "io.spray" %% "spray-routing" % "1.3.3",
  "io.spray" %% "spray-can" % "1.3.3",
  "com.typesafe.akka" %% "akka-actor" % "2.3.9"
)
