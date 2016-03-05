lazy val root = (project in file(".")).
    settings(
        name := "cookbook",
        version := "0.0.1",
        scalaVersion := "2.11.7",
        libraryDependencies ++= Seq(
            "org.scala-lang" % "scala-reflect" % scalaVersion.value
        )
    )
