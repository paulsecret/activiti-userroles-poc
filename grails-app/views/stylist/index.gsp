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
        <div class="col-xs-6">
            <div class="list-group">
                <g:each status="i" in="${tasks}" var="task">
                    <a href="#" class="list-group-item">${task.name} ${i + 1} (${task.assignee?:'unassigned'})</a>
                </g:each>
            </div>
        </div>
    </div>
</div>
</body>
</html>