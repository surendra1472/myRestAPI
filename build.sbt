name := """restapi"""
organization := "restapi"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.6"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test

libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.2"

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "restAPI.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "restAPI.binders._"
