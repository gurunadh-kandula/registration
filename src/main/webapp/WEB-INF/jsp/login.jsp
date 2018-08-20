<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
  <link rel="stylesheet" href="/style.css">
</head>

<body >
<div class="login">
  <div class="login-triangle"></div>
  <h2 class="login-header">Log in</h2>
	<form:form id="loginForm" modelAttribute="login" action="loginProcess"
		method="post"  class="login-container">
		<table align="center">
			<tr>
				<td><form:label path="username">Username: </form:label></td>
				<td><form:input path="username" name="username"  id="username"  />
				</td>
				<td><form:errors path="username" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="password">Password:</form:label></td>
				<td><form:password path="password" name="password"
						id="password"  /></td>
				<td><form:errors path="password" cssClass="error" /></td>
			</tr>
			<tr>
				<td></td>
				<td align="left">  <input type="submit" value="Login" />
				</td>
			</tr>
			<tr></tr>
			<tr>
				<td></td>
				<td><a href="home.jsp">Home</a></td>
				
			</tr>
			<tr>
			<td></td>
			<td><a href="forgot">Forgot Password</a></td>
			</tr>
		</table>
	</form:form>
	<table align="center">
		<tr>
			<td style="font-style: italic; color: red;">${message}</td>
		</tr>
	</table>
</body>
</html>