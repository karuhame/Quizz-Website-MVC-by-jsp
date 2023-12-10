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
                <th>MSSV</th>
                <th>LSH</th>
                <th>Ten sinh vien</th>
                <th>Ten mon hoc</th>
                <th>Diem thi</th>
                
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
        <a href="index.jsp">Trang chu</a>
    </p>
</body>
</html>