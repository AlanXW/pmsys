<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Programme and Module System</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>

<script>
function windowHeight() {
	var de = document.documentElement;
	return self.innerHeight||(de && de.clientHeight)||document.body.clientHeight;
}
window.onload=window.onresize=function(){
	var wh=windowHeight();
	document.getElementById("xt-left").style.height = document.getElementById("xt-right").style.height = (wh-document.getElementById("xt-top").offsetHeight)+"px";
}
</script>

<body>
<!-- top -->
<div id="xt-top">
    <div class="xt-logo"><img src="images/logo.png" /></div>
    <div class="xt-geren">
        <div class="xt-exit"><span class="xt-span">Welcome,<span class="xt-yanse">${sessionScope.user.username}</span></span><a href="login?method=logout" class="exit">exit</a></div>
    </div>
</div>
<!-- left -->
<div class="xt-center">
<div id="xt-left">
    <div class="xt-logo"></div>
    <div class="xt-menu">
        <ul>
            <li><a href="transaction?method=getTransaction"><em class="three"></em>Transaction</a></li>
        </ul>
        <ul>
            <li><a href="programme?method=getProgramme" class="hover"><em class="two"></em>Programmes</a></li>
        </ul>
        <ul>
            <li><a href="module?method=getModule"><em class="one"></em>Modules</a></li>
        </ul>
    </div>
</div>
<!-- right -->
<div id="xt-right">
    <div class="xt-input">
        <form action="outcome" method="post" style="float: left"><input type="text" name="outcome" class="int-text" style="margin-left: 20px;margin-right: 18px"/><input type="submit" value="Add Outcome" class="green-int" style="margin-left: 10px;margin-right: 18px"/></form>
        <input type="button" value="Add Programme" onclick="window.location.href='load?method=loadPM&object=P'" class="yellow-int"  style="margin-left: 10px;margin-right: 18px"/>
    </div>

    <div class="xt-table">
        <table cellpadding="0" cellspacing="0" border="0" bgcolor="#dcdcdc" width="100%">
            <tr>
            <th>Title</th>
            <th>Proposer</th>
            <th>Level</th>
            <th>Type</th>
            <th>Admin</th>
            <th>Department</th>
            <th>Faculty</th>
            <th>Requirements</th>
            <th>Operations</th>
            </tr>
            <!-- display programme list -->
            <% int i = 0;%>
            <c:forEach items="${list}" var="programme">
                <%
                    i++;
                    if(i%2!=0) out.write("<tr>");
                    else out.write("<tr class=\"xt-bg\">");
                %>
                    <td>${programme.title}</td>
                    <td>${programme.proposer}</td>
                    <td>${programme.level}</td>
                    <td>${programme.type}</td>
                    <td>${programme.admin}</td>
                    <td>${programme.department}</td>
                    <td>${programme.faculty}</td>
                    <td>${programme.requirements}</td>
                    <td><a href="programme?method=getDetails&id=${programme.id}" class="green-xt">Details</a><a href="load?method=updateProgramme&id=${programme.id}" class="yellow-xt">Modify</a><a href="programme?method=getRelationship&id=${programme.id}" class="blue-xt">Relationship</a><a href="programme?method=deleteProgramme&id=${programme.id}" class="red-xt">Delete</a></td>
                </tr>
            </c:forEach>

        </table>
    </div>
</div>
</div>

</body>
</html>