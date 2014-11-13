import SonatypeKeys._

sbtPlugin := true

name := "sbt-license-plugin"

organization := "com.github.ashihaby"

version := "1.0.0"

scriptedSettings ++ xerial.sbt.Sonatype.sonatypeSettings ++ publishSbtPlugin

def publishSbtPlugin = Seq(
  publishMavenStyle := true,
  publishTo := {
    val nexus = "https://oss.sonatype.org/"
    if (isSnapshot.value)
      Some("snapshots" at nexus + "content/repositories/snapshots")
    else
      Some("releases"  at nexus + "service/local/staging/deploy/maven2")
  },
  publishArtifact in Test := false,
  pomIncludeRepository := (_ => false),
  pomExtra := extraPom
)

def extraPom = (
    <url>http://your.project.url</url>
    <licenses>
      <license>
        <name>BSD-style</name>
        <url>http://www.opensource.org/licenses/BSD-3-Clause</url>
        <distribution>repo</distribution>
      </license>
    </licenses>
    <scm>
      <url>git@github.com:ashihaby/sbt-license-plugin.git</url>
      <connection>scm:git:git@github.com:ashihaby/sbt-license-plugin.git</connection>
    </scm>
    <developers>
      <developer>
      <id>ashihaby</id>
      <name>Amal Elshihaby</name>
      <url>http://github.com/ashihaby</url>
    </developer>
  </developers>)