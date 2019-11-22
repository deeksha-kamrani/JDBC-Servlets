<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:useBean id="msg" class="java.lang.String" scope="request"/>
<%
	String id = "";
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("alwaysRemember")) {
				id = cookie.getValue();
			}
		}
	}
%>

<body>
    <h4><%=msg%></h4>
	<fieldset align='center'>
		<legend>Login</legend>
		<form action='./login' method='post'>
			<table align='center'>
				<tr>
					<td>Id:</td>
					<td><input type='number' name='id' value='<%=id%>'></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type='password' name='password'></td>
				</tr>
				<tr>
					<td></td>
					<td><input type='checkbox' name='rememberme' value='checked'>Remember
						Me</td>
				</tr>
				<tr>
					<td><input type=submit value='LogIn'> <input
						type=reset value='Reset'></td>
				</tr>
			</table>
		</form>
	</fieldset>
	<a href='register.html'>Register</a>
</body>
</html>