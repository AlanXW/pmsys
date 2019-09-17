<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

	<head>
		<meta charset="utf-8" />
		<title>Programme and Module System</title>
		<link rel="stylesheet" href="css/login.css" />
	</head>

	<body>
	<!-- Login -->
		<div class="top"><img src="images/shef1.png" /></div>
		<div class="content">
			<div class="login">
				<form action="login" accept-charset="utf-8" id="login" method="post">
					<input type="hidden" name="method" value="login">
					<div class="title">Programmes and Modules Management</div>
						<div class="line">
							<img class="smallImg" src="images/icon1.png" />
							<input placeholder="Please input username" type="text" id="u" name="username"/>
						</div>
						<div class="line">
							<img class="smallImg" src="images/icon2.png" />
							<input placeholder="Please input password" type="password" id="p" name="password"/>
						</div>
					<input type="submit" value="Login" class="logBut">
				</form>
			</div>
		</div>
	</body>

</html>