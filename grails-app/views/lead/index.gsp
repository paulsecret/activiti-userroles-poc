<%--
  Created by IntelliJ IDEA.
  User: ps527
  Date: 29.01.15
  Time: 10:50
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <g:javascript library='jquery' />
        <title>Lead Stylist task manager</title>
        <link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap.css')}" type="text/css">
        <r:layoutResources/>
        <g:javascript src="application.js" />
        <r:layoutResources/>
    </head>
    <body>
        <br /><br />
        <div class="container">
            <div class="row">
                <h2>Lead Stylist task manager</h2>
                <div class="col-xs-6">
                    <div class="list-group">
                        <g:each status="i" in="${tasks}" var="task">
                            <a href="#" class="list-group-item" data-id="${task.id}">${task.name} ${task.id} (${task.assignee?:'unassigned'})</a>
                        </g:each>
                    </div>
                </div>
                <div class="col-xs-6">
                    <ul>
                        <g:each in="${stylists}">
                            <li style="list-style-type: none">
                                <button type="button" class="btn btn-default btn-lg assign" data-id="${it.id}">
                                    <span aria-hidden="true">Assign to stylist ${it.firstName} ${it.lastName}</span>
                                </button>
                            </li>
                        </g:each>
                    </ul>
                </div>
            </div>
            <div class="row">
                <button type="button" class="btn btn-default btn-lg start-flow">
                    Add opportunity
                </button>
            </div>
        </div>
    </body>
</html>