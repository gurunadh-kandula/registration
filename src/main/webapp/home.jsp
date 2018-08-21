<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Welcome</title>
          <link  href="<c:url  value="/css/style3.css" /> " rel="stylesheet"   type="text/css" >
    </head>
    <body>
        <div class="login">
  <div class="login-triangle"></div>
  <h2 class="login-header">Home</h2>
        <table align="center">
            <tr>
                <td><a href="login" class="button">Login</a>
                </td>
                <td><a href="register" class="button">Register</a>
                </td>
            </tr>
        </table>
    </body>
    </html>