import gitbucket.core.controller.Context
import gitbucket.core.plugin.{RenderRequest, Renderer}
import play.twirl.api.Html

class BPMNRenderer extends Renderer {

  def render(request: RenderRequest): Html = {
    import request._
    Html(toHtml(filePath, fileContent)(context))
  }

  def shutdown(): Unit = {
  }

  def toHtml(filePath: List[String], content: String)(implicit context: Context): String = {
    s"""
       |<link rel="stylesheet" href="/plugin-assets/bpmn/diagram-js.css" />
       |<script src="/plugin-assets/bpmn/bpmn-viewer.js"></script>
       |<div id="canvas" style="height: 70vh"/>
       |<script id="spec" type="text/bpmn">$content</script>
       |<script>
       |      var bpmnViewer = new BpmnJS({ container: '#canvas' });
       |      var xml = document.getElementById('spec').innerHTML;
       |      bpmnViewer.importXML(xml).then(viewer => bpmnViewer.get('canvas').zoom('fit-viewport'));
       |</script>
       |""".stripMargin
  }
}
