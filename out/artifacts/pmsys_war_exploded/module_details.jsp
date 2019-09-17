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
                <li><a href="programme?method=getProgramme"><em class="two"></em>Programmes</a></li>
            </ul>
            <ul>
                <li><a href="module?method=getModule" class="hover"><em class="one"></em>Modules</a></li>
            </ul>
        </div>
    </div>
    <!-- right -->
    <div id="xt-right">
        <p style="font-size: 22px; font-weight: bold; text-align: center; margin: 30px">${module.code}&nbsp;&nbsp;${module.title}</p>
        <p style="font-size: 22px; font-weight: 500; margin-left: 26%; margin-bottom: 18px; margin-top: 8px">Level:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${module.level}</p>
        <p style="font-size: 22px; font-weight: 500; margin-left: 26%; margin-bottom: 18px; margin-top: 8px">Semester:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${module.semester}</p>
        <p style="font-size: 22px; font-weight: 500; margin-left: 26%; margin-bottom: 18px; margin-top: 8px">Coordinator:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${module.coordinator}</p>
        <p style="font-size: 22px; font-weight: 500; margin-left: 26%; margin-bottom: 18px; margin-top: 8px">Department:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${module.department}</p>
        <p style="font-size: 22px; font-weight: 500; margin-left: 26%; margin-bottom: 18px; margin-top: 8px">Faculty:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${module.faculty}</p>
        <p style="font-size: 22px; font-weight: 500; margin-left: 26%; margin-bottom: 18px; margin-top: 8px">Credit:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${module.credit}</p>
        <p style="font-size: 22px; font-weight: 500; margin-left: 26%; margin-bottom: 18px; margin-top: 8px">Assessment:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:forEach items="${module.assessment}" var="assessment" >${assessment}&nbsp;&nbsp;&nbsp;</c:forEach></p>
        <p style="font-size: 22px; font-weight: 500; margin-left: 26%; margin-bottom: 18px; margin-top: 8px">Dependency:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:forEach items="${module.dependency}" var="dependency" >${dependency}&nbsp;&nbsp;&nbsp;</c:forEach></p>
        <p style="font-size: 22px; font-weight: 500; margin-left: 26%; margin-bottom: 18px; margin-top: 8px">Outcomes:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:forEach items="${module.outcomes}" var="outcome" >${outcome}&nbsp;&nbsp;&nbsp;</c:forEach></p>
    </div>
</div>

</body>
</html>