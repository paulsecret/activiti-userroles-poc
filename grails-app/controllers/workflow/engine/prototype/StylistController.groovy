package workflow.engine.prototype

import groovyx.net.http.HTTPBuilder

class StylistController {

    def index() {
        def http = new HTTPBuilder('http://localhost:8080')
        http.auth.basic params.stylistId, 'kermit'
        def tasks = http.get(
                path: '/activiti-rest/service/runtime/tasks',
                query: [ assignee: params.stylistId ]
        )
        def stylist = http.get(
                path: '/activiti-rest/service/identity/users/' + params.stylistId
        )
        render(view: "index", model: [ tasks: tasks.data, stylist: stylist ])
    }
}
