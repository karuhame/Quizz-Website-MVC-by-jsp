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
                <th>ID</th>
                <th>Question</th>
                <th>Option 1</th>
                <th>Option 2</th>
                <th>Option 3</th>
                <th>Option 4</th>
                <th>Answer</th>
          
                
            </tr>
        </thead>
        <tbody>
            <%
            List<QuestionBEAN> list = (List<QuestionBEAN>) request.getAttribute("list");
                                                for (int i = 0; i < list.size(); i++) {
            %>
            <tr>
                <td><%= i + 1 %></td>
                <td><%= list.get(i).ID_Question %></td>
                <td><%= list.get(i).name %></td>
                <td><%= list.get(i).opt1 %></td>
                <td><%= list.get(i).opt2 %></td>
                <td><%= list.get(i).opt3 %></td>
                <td><%= list.get(i).opt4 %></td>
                <td><%= list.get(i).answer %></td>
         		
        		<td><a href="<%= "quizzController?mod=QuestionList&ID_Test=" + list.get(i).ID_Test %>">View Question</a></td>
                
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