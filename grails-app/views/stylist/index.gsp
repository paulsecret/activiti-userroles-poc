<%--
  Created by IntelliJ IDEA.
  User: ps527
  Date: 29.01.15
  Time: 10:50
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Stylist task manager</title>
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap.css')}" type="text/css">
</head>
<body>
<br /><br />
<div class="container">
    <div class="row">
        <h2>Open tasks for ${stylist.firstName} ${stylist.lastName} - click to open in "Amidala"</h2>
        <div class="col-xs-6">
            <div class="list-group">
                <g:each status="i" in="${tasks}" var="task">
                    <a href="/workflow-engine-prototype/task?taskId=${task.id}&stylistId=${stylist.id}" class="list-group-item stylist">${task.name} ${task.id} (${task.assignee?:'unassigned'})</a>
                </g:each>
            </div>
        </div>
    </div>
</div>
</body>
</html>