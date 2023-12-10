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

    <h2>Danh sach thong tin :</h2>
    <table border="1">
        <thead>
            <tr>
            	<th>STT </th>
                <th>Ten hoc sinh</th>
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
                <td><%= list.get(i).Name %></td>
                <td><%= list.get(i).MSSV %></td>
                <td><%= list.get(i).LSH %></td>
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