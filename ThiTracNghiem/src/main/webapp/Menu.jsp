<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
    #heading {
        text-align: center;
        padding: 20px;
    }

    .header ul {
        list-style-type: none;
        margin: 7px;
        padding: 10px;
        overflow: hidden;
        display: flex;
        justify-content: flex-start;
        text-align: left;
        border: 1px solid #ddd;
        border-radius: 5px;
    }

    .header li {
        margin: 0 10px;
    }

    .header a {
        text-decoration: none;
        padding: 5px 10px;
        color: #000;
        border: 1px solid #ddd;
        border-radius: 5px;
        margin: 0 10px;
    }

    .header a:hover {
        background-color: #ddd;
    }
    img {
        max-width: 100%;
        height: auto;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        padding: 0px 0px 0px 150px;
    }
</style>
</head>
<body>
    <div class="header" id="heading">
        <h1>Menu</h1>
        <ul>
        <%
            int role = (Integer) session.getAttribute("role");
            if (role == 0) {
            %>
            <!-- Admin -->
                <li><a href="quizzController?mod=AccountList">List Account</a></li>
                <li><a href="quizzController?mod=TestList">List Test</a></li>
                <li><a href="quizzController?mod=StudentList">List Student</a></li>
            <%
            } else {
            %>
            <!-- User-->
                <li><a href="quizzController?mod=TestList">List Test</a></li>
        
            <%
            }
        %>
            <li><a href="quizzController?mod=Logout">Logout</a></li>
        </ul>
    </div>
    
    <div>
    	<img src="https://aztest.vn/uploads/news/2022/danh-gia-nhan-su.jpg" alt="anh">
    </div>
    
</body>
</html>