import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName           = "reefgui"
  val appVersion        = "0.2.0-SNAPSHOT"
  val playVersion       = "2.1.1"
  val totalGridRelease  = "https://repo.totalgrid.org/artifactory/totalgrid-release"
  val totalGridSnapshot = "https://repo.totalgrid.org/artifactory/totalgrid-private-snapshot"
  val reefVersion       = "0.5.0-SNAPSHOT"
  val coralVersion      = "0.1.0-SNAPSHOT"


  lazy val baseSettings = Seq(
    version            := appVersion,
    // Need these scala versions or it tries Scala-2.9.2
    scalaVersion       := "2.10.0",
    //scalaBinaryVersion := "2.10",
    //crossScalaVersions := Seq("2.10.0"),
    organization       := "org.totalgrid",
    scalacOptions += "-feature", // show compiler warnings for language features
    scalacOptions += "-unchecked", // compiler warnings for type aliases and ???
    resolvers += "scala-tools" at "http://repo.typesafe.com/typesafe/scala-tools-releases-cache",
    credentials += Credentials( Path.userHome / ".ivy2" / ".credentials"),
    resolvers += "totalgrid-snapshot" at totalGridSnapshot,
    resolvers += "totalgrid-release" at totalGridRelease//
  )

  val appDependencies = Seq(
    "com.weiglewilczek.slf4s" % "slf4s_2.9.0-1" % "1.0.6",
    "org.totalgrid.coral" %% "coral" % coralVersion,
    "org.totalgrid.coral" %% "coral.test" % coralVersion,
    "org.totalgrid.reef" % "reef-client" % reefVersion,
    "org.totalgrid.reef" % "reef-service-client" % reefVersion
  )


  val main = play.Project(appName, appVersion, appDependencies)
    .settings( baseSettings: _*)
    .settings(
      routesImport += "models.QueryBinders._"
    )

}
