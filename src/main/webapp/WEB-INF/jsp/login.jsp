<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
  <link  href="<c:url  value="/css/style.css" /> " rel="stylesheet"   type="text/css" >
</head>

<body >
<div class="login">
  <div class="login-triangle"></div>
  <h2 class="login-header">Log in</h2>
	 <form:form id="loginForm" modelAttribute="login" action="loginProcess"
		method="post"  class="login-container">
		<table align="center">
			<tr>
				<td><form:label path="username" ></form:label></td>
				<td><form:input path="username" placeholder="Username" name="username"  id="username"  />
				</td>
				<td><form:errors path="username" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="password"></form:label></td>
				<td><form:password path="password" name="password"
						id="password"  placeholder="Password"  /></td>
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
				<td><a href="home.jsp" class="button">Home</a></td>
				
			</tr>
			<tr>
			<td></td>
			<td><a href="forgot" class="button">Forgot Password</a></td>
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