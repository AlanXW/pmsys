<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Programme and Module System</title>
    <style>
        img {
            border: 0;
        }

        body {
            background: #f7f7f7;
            color: #666;
            font: 12px/150% Arial,Verdana, "microsoft yahei";
        }

        html, body, div, dl, dt, dd, ol, ul, li, h1, h2, h3, h4, h5, h6, p, blockquote, pre, button, fieldset, form, input, legend, textarea, th, td {
            margin: 0;
            padding: 0;
        }

        article,aside,details,figcaption,figure,footer,header,main,menu,nav,section,summary {
            display: block;
            margin: 0;
            padding: 0;
        }

        audio,canvas,progress,video {
            display: inline-block;
            vertical-align: baseline;
        }

        a {
            text-decoration: none;
            color: #08acee;
        }

        a:active,a:hover {
            outline: 0;
        }

        button {
            outline: 0;
        }

        mark {
            color: #000;
            background: #ff0;
        }

        small {
            font-size: 80%;
        }

        img {
            border: 0;
        }

        button,input,optgroup,select,textarea {
            margin: 0;
            font: inherit;
            color: inherit;
            outline: none;
        }

        li {
            list-style: none;
        }

        i {
            font-style: normal;
        }

        a {
            color: #666;
        }

        p {
            margin-bottom: 7px;
        }

        a:hover {
            color: #eee;
        }

        em {
            font-style: normal;
        }

        h2, h3 {
            font-family: "microsoft yahei";
            font-weight: 100;
        }



        /* ------------------- */
        ::-moz-placeholder {
            color: #9fa3a7;
        }

        ::-webkit-input-placeholder {
            color: #9fa3a7;
        }

        :-ms-input-placeholder {
            color: #9fa3a7;
        }


        .pc-kk-form{
            padding:65px 225px;
        }
        .pc-kk-form-check{
            background:#fff;
            border:1px solid #e5e5e5;
            border-radius:5px;
            padding: 10px;
            margin-bottom:20px;
            color:#9fa3a7;
            font-size:14px;
        }
        .pc-kk-form-add{
            background:#fff;
            border:1px solid #e5e5e5;
            border-radius:5px;
            height:44px;
            line-height:44px;
            margin-bottom:10px;
        }
        .pc-kk-form-list{
            background:#fff;
            border:1px solid #e5e5e5;
            border-radius:5px;
            height:44px;
            line-height:44px;
            margin-bottom:20px;
        }
        .pc-kk-form-list input{
            width:100%;
            border:none;
            background:none;
            color:#9fa3a7;
            font-size:14px;
            height: 36px;
            padding: 4px 10px;
        }
        .nice-select{
            position: relative;
            background: #fff url(images/a2.jpg) no-repeat right center;
            background-size:18px;
            width:47%;
            float:left;
            border:1px solid #e5e5e5;
            border-radius:5px;
            height:44px;
            line-height:44px;
        }

        .nice-select ul{
            width: 100%;
            display: none;
            position: absolute;
            left: -1px;
            top: 44px;
            overflow: hidden;
            background-color: #fff;
            max-height: 150px;
            overflow-y: auto;
            border: 1px solid #b9bcbf;
            z-index: 9999;
            border-radius:5px;

        }
        .nice-select ul li{
            padding-left:10px;
        }
        .nice-select ul li:hover{
            background:#f8f4f4;
        }
        .pc-kk-form-list-clear{
            background:none;
            border:none;
        }
        .pc-kk-form-btn button{
            background:#ec5224;
            color:#fff;
            border:none;
            width:70%;
            height:50px;
            line-height:50px;
            font-size:16px;
            border-radius:50px;
            margin-left: 15%;
        }
    </style>
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="css/jquery.richUI.min.css" />

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
        <div class="pc-kk-form">
            <form action="programme" method="post">
                <input type="hidden" name="method" value="addProgramme">
                <div class="pc-kk-form-list">
                    <input type="text" name="title" placeholder="Title">
                </div>
                <div class="pc-kk-form-list">
                    <input type="text" name="proposer" placeholder="Proposer">
                </div>
                <div class="pc-kk-form-list pc-kk-form-list-clear">
                    <div class="nice-select" name="nice-select">
                        <input type="text" name="level" value="Level" readonly>
                        <ul>
                            <li data-value="1">1</li>
                            <li data-value="2">2</li>
                            <li data-value="3">3</li>
                            <li data-value="4">4</li>
                            <li data-value="5">5</li>
                            <li data-value="6">6</li>
                        </ul>

                    </div>
                    <div class="nice-select" name="nice-select" style="float:right">
                        <input type="text" name="type" value="Type" readonly>
                        <ul>
                            <li data-value="male">Bsc</li>
                            <li data-value="female">Msc</li>
                        </ul>

                    </div>
                </div>
                <div class="pc-kk-form-list">
                    <input type="text" name="admin" placeholder="Admin">
                </div>
                <div class="pc-kk-form-list">
                    <input type="text" name="department" placeholder="Department">
                </div>
                <div class="pc-kk-form-list">
                    <input type="text" name="faculty" placeholder="Faculty">
                </div>
                <div class="pc-kk-form-list">
                    <input type="text" name="requirements" placeholder="Requirements">
                </div>
                <!-- generate check box according to data from back-end -->
                <div class="pc-kk-form-check">
                    <p>Outcomes:</p>
                    <c:forEach items="${outcome}" var="outcome">
                        <input name="outcomes" value="${outcome.name}" type="checkbox" lab="${outcome.name}"/>
                    </c:forEach>
                </div>
                <div class="pc-kk-form-check">
                    <p>Core Modules:</p>
                    <c:forEach items="${module}" var="module">
                        <input name="core_modules" value="${module.code} ${module.title}" type="checkbox" lab="${module.code} ${module.title}"/>
                    </c:forEach>
                </div>
                <div class="pc-kk-form-check">
                    <p>Optional Modules:</p>
                    <c:forEach items="${module}" var="module">
                        <input name="optional_modules" value="${module.code} ${module.title}" type="checkbox" lab="${module.code} ${module.title}"/>
                    </c:forEach>
                </div>

                <div class="pc-kk-form-btn">
                    <button>Submit</button>
                </div>
            </form>
        </div>


        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
        <script type="text/javascript" src="js/jquery.richUI.min.js"></script>
        <script type="text/javascript" src="js/jquery.browser.min.js"></script>
        <script>





            $('[name="nice-select"]').click(function(e){

                $('[name="nice-select"]').find('ul').hide();

                $(this).find('ul').show();

                e.stopPropagation();

            });

            $('[name="nice-select"] li').hover(function(e){

                $(this).toggleClass('on');

                e.stopPropagation();

            });

            $('[name="nice-select"] li').click(function(e){

                var val = $(this).text();

                $(this).parents('[name="nice-select"]').find('input').val(val);

                $('[name="nice-select"] ul').hide();

                e.stopPropagation();

            });

            $(document).click(function(){

                $('[name="nice-select"] ul').hide();

            });

        </script>

        <script type="text/javascript">
            $(function() {
                $("input[name='outcomes']").richcheckbox();
                $("input[name='core_modules']").richcheckbox();
                $("input[name='optional_modules']").richcheckbox();
            });
        </script>

    </div>
</div>

</body>
</html>