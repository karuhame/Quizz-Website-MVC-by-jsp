<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="text-align: center;">Menu</h1>
    <!--  
    <h3>
		<a href="quizzController?mod=listVacxin">1. Xem danh sach vac xin</a>
	</h3>
	-->
	<%
    int role = (Integer) session.getAttribute("role");
    if (role == 0) {
	%>
	        <!-- Admin -->
	        <h2>Welcome, Teacher!</h2>
	        <h3>
				<a href="quizzController?mod=StudentList">1. List Student</a>
			</h3>
			<h3>
				<a href="quizzController?mod=AccountList">2. List Account</a>
			</h3>
			<h3>
				<a href="quizzController?mod=TestList">3. List Test</a>
			</h3>
	<%
	    } else {
	%>
	        <!-- User-->
	        <h2>Welcome, Student !</h2>
	        <h3>
				<a href="quizzController?mod=TestList">1. List Test</a>
			</h3>
	<%
	    }
	%>

</body>

</html>