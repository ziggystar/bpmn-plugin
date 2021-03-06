# BPMN-plugin

A GitBucket plugin for rendering BPMN diagrams file using [bpmn.io](https://bpmn.io/).

## Install

1. Download *.jar from Releases.
2. Deploy it to `GITBUCKET_HOME/plugins`.
3. Restart GitBucket.

## Build from source

```sbt
sbt clean package
```

The built package is located at
`target/scala-2.13/gitbucket-bpmn-plugin_2.13-{plugin-version}.jar`.

```sbt
sbt assembly
```

This makes the assembly package
`target/scala-2.13/gitbucket-bpmn-plugin-{plugin-version}.jar`
for deployment.


## Usage

This plugin process files only with its name in the following list.

```bash
"*.bpmn", "*.bpmn2"
```