lazy val root = (project in file(".")).
    settings(
        name := "cookbook",
        version := "0.0.1",
        scalaVersion := "2.11.8",
        scalacOptions ++= Seq(
            "-feature",
            "-deprecation"
        ),
        mainClass in Compile := Some("Cooker"),
        libraryDependencies ++= Seq(
            "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.7.2",
            "com.typesafe.scala-logging" %% "scala-logging" % "3.4.0",
            "ch.qos.logback" % "logback-classic" % "1.1.7",
            "org.scala-lang" % "scala-reflect" % scalaVersion.value,
            "org.scala-lang" % "scala-actors" % scalaVersion.value
        )
    )
