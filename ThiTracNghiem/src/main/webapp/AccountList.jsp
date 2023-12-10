<%@page import="Model.bean.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

    <h2>Danh sach tai khoan :</h2>
    <table border="1">
        <thead>
            <tr>
            	<th>STT </th>
                <th>Username</th>
                <th>Password</th>
                <th>Role</th>
                <th>Change Pass</th>
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
                <td><%= list.get(i).role %></td>
				<td><a href="<%= "quizzController?mod=UpdatePassForm&ID_Account=" + list.get(i).ID_Account +"&password=" + list.get(i).password %>">Change</a></td>
            </tr>
            <%
            }
            %>
        </tbody>
    </table>

    <br>
    <p>
        <a href="index.jsp">Trang chu</a>
    </p>
</body>
</html>