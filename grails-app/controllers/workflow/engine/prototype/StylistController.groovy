package workflow.engine.prototype

import groovyx.net.http.HTTPBuilder

class StylistController {

    def index() {
        def http = new HTTPBuilder('http://localhost:8080')
        http.auth.basic 'stylist_2', 'kermit'
        def tasks = http.get(
                path: '/activiti-rest/service/runtime/tasks',
                query: [ assignee: 'stylist_2' ]
        )
        render(view: "index", model: [ tasks: tasks.data ])
    }
}
