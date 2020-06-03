name := "gitbucket-bpmn-plugin"
organization := "io.github.gitbucket"
version := "1.0.0"
scalaVersion := "2.13.8"
gitbucketVersion := "4.37.2"

val downloads = Map(
  "bpmn-viewer.js" -> "https://unpkg.com/bpmn-js@9.1.0/dist/bpmn-viewer.production.min.js",
  "diagram-js.css" -> "https://unpkg.com/bpmn-js@9.1.0/dist/assets/diagram-js.css"
).map { case (f, u) => f -> new URL(u) }

lazy val downloadBPMN = taskKey[Seq[File]]("Downlaods BMPN library")

downloadBPMN := downloads.map { case (local, url) =>
  val file = (Compile/resourceManaged).value / "assets" / local
  IO.writeLines(file,IO.readLinesURL(url))
  file
}.toSeq

Compile / resourceGenerators += downloadBPMN.taskValue