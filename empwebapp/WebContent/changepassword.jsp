
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:useBean id="msg" class="java.lang.String" scope="request"/>

<body>

	<a href="./home">HOME</a>
	<a style="float: right" href="./logout" class="">LogOut</a>
	<h4><%=msg%></h4>

	<fieldset align="center">

		<legend>Change Password</legend>

		<form action="./changepassword" method="post">
			<table align="center">
				<tr>
					<td>New Password</td>
					<td><input name="newpassword" type="password"></td>
				</tr>
				<tr>
					<td>Confirm Password</td>
					<td><input name="confirmpassword" type="password"></td>
				</tr>
				<tr>
					<td><input type=submit value="Change Password"></td>
					<td><input type=reset value="Reset"></td>
				</tr>
			</table>
		</form>
	</fieldset>
</body>
</html>