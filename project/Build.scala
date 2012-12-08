import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "admin"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      // Add your project dependencies here,
      "dom4j" % "dom4j" % "1.6.1"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
      // Add your own project settings here
    )

}
