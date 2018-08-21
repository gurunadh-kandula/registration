<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Registration</title>
              <link  href="<c:url  value="/css/style2.css" /> " rel="stylesheet"   type="text/css" >
            <style>
.error {
color: #ff0000;
font-style: italic;
}
</style>
        </head>
        <script>  
function validateform()  
{  
var x=document.myform.email.value;  
var name=document.myform.username.value;  
var password=document.myform.password.value;  
var atposition=x.indexOf("@");  
var dotposition=x.lastIndexOf(".");  
if (atposition<1 || dotposition<atposition+2 || dotposition+2>=x.length){  
  alert("Please enter a valid e-mail address");  
  return false;  
  if (name==null || name==""){  
	  alert("Name can't be blank");  
	  return false;  
	}else if(password.length<6){  
	  alert("Password must be at least 6 characters long.");  
	  return false;  
	  }  
	}  
  }  
</script>
        <body>
        <div class="login">
  <div class="login-triangle"></div>
  <h2 class="login-header">Registration</h2>
            <form:form id="regForm" name="myform" modelAttribute="user" action="registerProcess" method="post" onsubmit="return validateform(); ">
                <table align="center">
                    <tr>
                        <td>
                            <form:label path="username"></form:label>
                        </td>
                        <td>
                            <form:input path="username" placeholder="Username" name="username" id="username" />
                        </td>
                        <td><form:errors path="username" cssClass="error" /></td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="password"></form:label>
                        </td>
                        <td>
                            <form:password path="password" placeholder="Password" name="password" id="password" />
                        </td>
                          <td><form:errors path="password" cssClass="error" /></td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="firstname"></form:label>
                        </td>
                        <td>
                            <form:input path="firstname" placeholder="FirstName" name="firstname" id="firstname" />
                        </td>
                        <td><form:errors path="firstname" cssClass="error" /></td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="lastname"></form:label>
                        </td>
                        <td>
                            <form:input path="lastname"  placeholder="LastName" name="lastname" id="lastname" />
                        </td>
                             <td><form:errors path="lastname" cssClass="error" /></td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="email"></form:label>
                        </td>
                        <td>
                            <form:input path="email" placeholder="Email" name="email" id="email" />
                        </td>
                           <td><form:errors path="email" cssClass="error" /></td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="address"></form:label>
                        </td>
                        <td> 
                            <form:input path="address" placeholder="Address" name="address" id="address" />
                        </td>
                              <td><form:errors path="address" cssClass="error" /></td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="phone"></form:label>
                        </td>
                        <td>
                            <form:input path="phone" placeholder="Phone" name="phone" id="phone" />
                        </td>
                        <td><form:errors path="phone" cssClass="error" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                         <input type="submit" value="Register" />
                        </td>
                        
                    </tr>
                    <tr></tr>
                    <tr>
                        <td></td>
                        <td><a href="home.jsp" class="button">Home</a>
                        </td>
                    </tr>
                </table>
            </form:form>
        </body>
        </html>