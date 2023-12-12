<%@page import="Model.bean.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
    body {
        font-family: Arial, sans-serif;
    }

    h2 {
        text-align: center;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }

    th, td {
        padding: 10px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }

    th {
        background-color: #f2f2f2;
    }

    .button {
        display: inline-block;
        background-color: #4CAF50;
        color: white;
        padding: 8px 16px;
        text-decoration: none;
        border-radius: 4px;
    }

    .button:hover {
        background-color: #45a049;
    }

    p {
        text-align: center;
        margin-top: 20px;
    }
    
</style>
</head>
<body>

    <h2>Test Result</h2>
    
    <form action="quizzController?mod=Search" method="post" >
    	<input hidden name="ID_Test" value=<%= request.getAttribute("ID_Test") %>>
	    <input type="text" id="textInput" name="search">
	    <button class="button" type="Submit">Search</button>
	</form>
    <br>
    
    <table border="1">
        <thead>
            <tr>
            	<th>STT </th>
                <th>MSSV</th>
                <th>LSH</th>
                <th>Student Name</th>
                <th>Object</th>
                <th>Mark</th>
                
            </tr>
        </thead>
        <tbody>
            <%
            List<ResultTestAccountInfoBEAN> list = (List<ResultTestAccountInfoBEAN>) request.getAttribute("list");
                                                for (int i = 0; i < list.size(); i++) {
            %>
            <tr>
                <td><%= i + 1 %></td>
                <td><%= list.get(i).info.MSSV %></td>
                <td><%= list.get(i).info.LSH %></td>
                <td><%= list.get(i).info.Name %></td>
                <td><%= list.get(i).test.Name %></td>
                <td><%= list.get(i).result.Mark %></td>
            </tr>
            <%
            }
            %>
        </tbody>
    </table>

    <br>
    <p>
        <a href="Menu.jsp" class="button">Home Page</a>
    </p>
</body>
</html>