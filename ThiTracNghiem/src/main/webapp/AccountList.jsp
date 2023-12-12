<%@page import="Model.bean.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Danh sách tài khoản</title>
<style>
    table {
        border-collapse: collapse;
        width: 100%;
    }

    th, td {
        text-align: left;
        padding: 8px;
    }

    th {
        background-color: #f2f2f2;
    }

    .button {
        background-color: #4CAF50;
        color: white;
        padding: 8px 12px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        text-decoration: none;
    }
    h2 {
        text-align: center;
    }

    .button:hover {
        background-color: #45a049;
    }

    .search-container {
        margin-top: 20px;
    }

    .search-container input[type=text] {
        padding: 6px;
        margin-right: 10px;
        width: 200px;
        border: 1px solid #ccc;
    }

    .search-container button {
        padding: 6px 10px;
        border: none;
        cursor: pointer;
    }
    p {
        text-align: left;
        margin-top: 20px;
    }
</style>
</head>
<body>

    <h2>Account List</h2>
    <br>
    <table>
        <thead>
            <tr>
                <th>STT</th>
                <th>Username</th>
                <th>Password</th>
                <th>Role</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <%
            List<AccountBEAN> list = (List<AccountBEAN>) request.getAttribute("list");
            for (int i = 0; i < list.size(); i++) {
            %>
            <tr>
                <td><%= i + 1 %></td>
                <td><%= list.get(i).username %></td>
                <td><%= list.get(i).password %></td>
                <td><%= list.get(i).role == 1 ? "user" : "admin" %></td>
                <td>
                	<button class="button" onclick="location.href='<%= "quizzController?mod=UpdatePassForm&ID_Account=" + list.get(i).ID_Account+"&password=" + list.get(i).password %>'">Edit</button>
                    <button class="button">Delete</button>
                </td>
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