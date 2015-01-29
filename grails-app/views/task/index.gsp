<%--
  Created by IntelliJ IDEA.
  User: ps527
  Date: 29.01.15
  Time: 14:34
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <g:javascript library='jquery' />
        <title>"Amidala"</title>
        <link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap.css')}" type="text/css">
        <r:layoutResources/>
        <g:javascript src="application.js" />
        <r:layoutResources/>
    </head>
    <body>
    <br /><br />
    <div class="container">
        <div class="row">
            <h2>${task.name} ${task.id}</h2>
            <button type="button" class="btn btn-default btn-lg call-success" data-taskid="${task.id}" data-stylistid="${stylistId}">
                Call successful / order box
            </button>
            <button type="button" class="btn btn-default btn-lg call-failed" data-taskid="${task.id}" data-stylistid="${stylistId}">
                Customer not reached
            </button>
        </div>
    </div>
    </body>
</html>