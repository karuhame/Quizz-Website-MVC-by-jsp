<%@page import="Model.bean.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Danh sách thông tin</title>
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

    a.button:hover {
        background-color: #45a049;
    }

    p {
        text-align: left;
        margin-top: 20px;
    }
</style>
</head>

<body>

    <h2>Danh sách thông tin:</h2>
    <table>
        <thead>
            <tr>
            	<th>STT</th>
                <th>Student name</th>
                <th>MSSV</th>
                <th>LSH</th>
            </tr>
        </thead>
        <tbody>
            <%
            List<AccountInfoBEAN> list = (List<AccountInfoBEAN>) request.getAttribute("list");
            for (int i = 0; i < list.size(); i++) {
            %>
            <tr>
                <td><%= i + 1 %></td>
                <td><%= list.get(i).Name  %></td>
                <td><%= list.get(i).MSSV  %></td>
                <td><%= list.get(i).LSH  %></td>
            </tr>
            <%
            }
            %>
        </tbody>
    </table>

    <br>
    <p>
        <a href="Menu.jsp" class="button">Home page</a>
    </p>
</body>
</html>