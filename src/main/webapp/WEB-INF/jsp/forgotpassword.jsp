<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Forgotpassword</title>
</head>
<body>
	<form action="forgotProcess", method="post">
		<table style="with: 50%">
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" /></td>
			</tr>

		</table>
		<input type="submit" value="Submit" />
	</form>



	<table align="center">
		<tr>
			<td style="font-style: italic; color: red;">${message}</td>
		</tr>
	</table>
</body>
</html>