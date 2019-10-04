name := "algorthitmsinscala"

version := "0.1"

scalaVersion := "2.13.1"

resolvers += "Spring" at "https://repo.spring.io/plugins-release/"

// https://mvnrepository.com/artifact/edu.princeton.cs/algs4
libraryDependencies += "edu.princeton.cs" % "algs4" % "1.0.3"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.8"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % "test"