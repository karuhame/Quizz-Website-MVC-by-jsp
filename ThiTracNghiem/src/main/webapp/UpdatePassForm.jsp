<%@page import="Model.bean.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%    
		String currentPass = (String) request.getAttribute("password");
 %>
 <h1>Form Update</h1>
	<form name="form1" action="quizzController?mod=UpdatePass" method="post">
		Current Password: <input type="text" name="oldpassword" value="<%= currentPass %>" > <br>
		New Password: <input type="text" name="password" value="" > <br>		
		<input type="hidden" name="ID_Account" value="<%= (String) request.getAttribute("ID_Account") %>" > <br>		
		
		<input type="submit" value="Submit">
		<input type="reset" value="Reset">
	</form>
</body>
</html>
