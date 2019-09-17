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
            <li><a href="transaction?method=getTransaction" class="hover"><em class="three"></em>Transaction</a></li>
        </ul>
        <ul>
            <li><a href="programme?method=getProgramme"><em class="two"></em>Programmes</a></li>
        </ul>
        <ul>
            <li><a href="module?method=getModule"><em class="one"></em>Modules</a></li>
        </ul>
    </div>
</div>
<!-- right -->
<div id="xt-right">
    <div class="xt-bt"><h2>Transaction</h2></div>
    <div class="xt-table">
        <table cellpadding="0" cellspacing="0" border="0" bgcolor="#dcdcdc" width="100%">
            <tr>
            <th>Order</th>
            <th>Date</th>
            <th>Operator</th>
            <th>Operation Description</th>
            <th>State</th>
            </tr>
            <!-- display transaction list -->
            <% int i = 0;%>
            <c:forEach items="${list}" var="transaction">
            <%
                i++;
                if(i%2!=0) out.write("<tr>");
                else out.write("<tr class=\"xt-bg\">");
            %>
                <td>${transaction.id}</td>
                <td>${transaction.date}</td>
                <td>${transaction.staff}</td>
                <td>${transaction.description}</td>
                <td>${transaction.state}</td>
            </c:forEach>
        </table>
    </div>
</div>
</div>

</body>
</html>