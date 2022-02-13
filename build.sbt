scalaVersion := "2.13.8"
name := "math-service-scala"
organization := "org.jesperancinha"
version := "1.0"
resolvers += Resolver.mavenLocal
resolvers += Resolver.mavenCentral
resolvers +=
  "Maven Central" at "https://repo1.maven.org/maven2/"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.6.18",
  "com.typesafe.akka" %% "akka-stream" % "2.6.18",
  "com.typesafe.akka" %% "akka-http-core" % "10.2.6",
  "com.typesafe.akka" %% "akka-http" % "10.2.6",
  "com.typesafe.akka" %% "akka-http-spray-json" % "10.2.6",
  "com.typesafe.akka" %% "akka-http-testkit" % "10.2.6",
  "org.scalatest" %% "scalatest" % "3.2.9" % Test,
  "org.scalatest" %% "scalatest-flatspec" % "3.3.0-SNAP3" % Test,
  "org.scalatest" %% "scalatest-wordspec" % "3.3.0-SNAP3" % Test,
  "org.scalatest" %% "scalatest-core" % "3.3.0-SNAP3" % Test)
