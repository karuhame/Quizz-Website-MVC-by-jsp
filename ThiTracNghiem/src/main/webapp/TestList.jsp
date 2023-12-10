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
                <th>Ma bai thi</th>
                <th>Ten mon hoc</th>
                <th>Cau hoi</th>
                <th>Ket qua</th>
            </tr>
        </thead>
        <tbody>
            <%
            List<TestBEAN> list = (List<TestBEAN>) request.getAttribute("list");
                                                for (int i = 0; i < list.size(); i++) {
            %>
            <tr>
                <td><%= i + 1 %></td>
                <td><%= list.get(i).ID_Test %></td>
                <td><%= list.get(i).Name %></td>
                <%
			    int role = (Integer) session.getAttribute("role");
			    if (role == 0) {
				%>
				        <!-- Admin -->
               			<td><a href="<%= "quizzController?mod=QuestionList&ID_Test=" + list.get(i).ID_Test %>">View Question</a></td>
               			<td><a href="<%= "quizzController?mod=AllList&ID_Test=" + list.get(i).ID_Test %>">View Result</a></td>
               			
				<%
				    } else {
				%>
				        <!-- User-->
               			<td><a href="<%= "quizzController?mod=JoinTest&ID_Test=" + list.get(i).ID_Test %>">Join</a></td>	        
				<%
				    }
				%>
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