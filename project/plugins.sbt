// Comment to get more information during initialization
logLevel := Level.Warn

// The Typesafe repository 
resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

// Use the Play sbt plugin for Play projects
addSbtPlugin("play" % "sbt-plugin" % "2.1.0")

// Run "sbt gen-idea" so IntelliJ has all the dependencies from Build.scala
addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.2.0")
