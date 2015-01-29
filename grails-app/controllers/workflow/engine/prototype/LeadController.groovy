package workflow.engine.prototype

import grails.converters.JSON
import groovyx.net.http.ContentType
import groovyx.net.http.HTTPBuilder
import groovyx.net.http.Method

class LeadController {

    def index() {
        def http = new HTTPBuilder('http://localhost:8080')
        http.auth.basic 'lead_stylist_1', 'kermit'
        def tasks = http.get(
                path: '/activiti-rest/service/runtime/tasks',
                query: [ candidateGroup: 'lead_stylists' ]
        )
        def stylists = http.get(
                path: '/activiti-rest/service/identity/users',
                query: [ memberOfGroup: 'stylists' ]
        )
        render(view: "index", model: [ tasks: tasks.data, stylists: stylists.data ])
    }

    def assign() {
        def taskId = params.taskId
        def stylistId = params.stylistId
        def http = new HTTPBuilder('http://localhost:8080/activiti-rest/service/runtime/tasks/' + taskId)
        http.auth.basic 'lead_stylist_1', 'kermit'
        http.request(Method.PUT, ContentType.JSON) { req ->
            body = [ assignee: stylistId ]

            response.success = { resp, json ->
                // redirect(uri: '/lead/index')
            }
        }
    }

    def start_process() {
        def http = new HTTPBuilder('http://localhost:8080/activiti-rest/service/runtime/process-instances')
        http.auth.basic 'lead_stylist_1', 'kermit'
        http.request(Method.POST, ContentType.JSON) { req ->
            body = [ processDefinitionId: 'process:7:12516' ]
        }
        // redirect(uri: '/lead/index')
    }
}