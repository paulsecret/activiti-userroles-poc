package workflow.engine.prototype

import groovyx.net.http.ContentType
import groovyx.net.http.HTTPBuilder
import groovyx.net.http.Method

class TaskController {

    def index() {
        def http = new HTTPBuilder('http://localhost:8080')
        http.auth.basic params.stylistId, 'kermit'
        def task = http.get(
                path: '/activiti-rest/service/runtime/tasks/' + params.taskId
        )
        render(view: "index", model: [ task: task, stylistId: params.stylistId ])
    }

    def finish() {
        def http = new HTTPBuilder('http://localhost:8080/activiti-rest/service/runtime/tasks/' + params.taskId)
        http.auth.basic params.stylistId, 'kermit'
        http.request(Method.POST, ContentType.JSON) { req ->
            body = [ action: 'complete' ]
        }
        render ''
    }
}
