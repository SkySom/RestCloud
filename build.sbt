name := "RestCloud"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  	jdbc,
  	anorm,
  	cache
)

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.+"

libraryDependencies += "ws.securesocial" %% "securesocial" % "2.1.3"

play.Project.playScalaSettings
