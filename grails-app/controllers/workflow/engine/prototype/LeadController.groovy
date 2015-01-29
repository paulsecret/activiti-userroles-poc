package workflow.engine.prototype

import grails.converters.JSON
import groovyx.net.http.HTTPBuilder
import groovyx.net.http.Method

class LeadController {

    def index() {
        /*
            this needs to build a model consisting of:
            - all tasks with candicateGroup=lead_stylists
            - all users with group=stylists
         */
        // http://localhost:8080/activiti-rest/service/runtime/tasks?candidateGroup=lead_stylists
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
        http.request(Method.PUT, JSON) { req ->
            body = [ assignee: stylistId ]

            response.success = { resp, json ->
                // response handling here
            }
        }
        redirect(action: 'index')
    }
}