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

    <h2>Question List</h2>
    <table border="1">
        <thead>
            <tr>
            	<th>STT </th>
                <th>Question</th>
                <th>Option 1</th>
                <th>Option 2</th>
                <th>Option 3</th>
                <th>Option 4</th>
                <th>Answer</th>
                <th>Action</th>
          
                
            </tr>
        </thead>
        <tbody>
            <%
            List<QuestionBEAN> list = (List<QuestionBEAN>) request.getAttribute("list");
                                                for (int i = 0; i < list.size(); i++) {
            %>
            <tr>
                <td><%= i + 1 %></td>
                <td hidden><%= list.get(i).ID_Question %></td>
                <td><%= list.get(i).name %></td>
                <td><%= list.get(i).opt1 %></td>
                <td><%= list.get(i).opt2 %></td>
                <td><%= list.get(i).opt3 %></td>
                <td><%= list.get(i).opt4 %></td>
                <td><%= list.get(i).answer %></td>
         		
         		<td>
                	<button class="button" onclick="location.href='<%= "quizzController?mod=UpdateQuestionForm&ID_Question=" + list.get(i).ID_Question %>'">Edit</button>
                	<button class="button" onclick="location.href='<%= "quizzController?mod=DeleteQuestion&ID_Question=" + list.get(i).ID_Question %>'">Delete</button>
                </td>                
            </tr>
            <%
            }
            %>
        </tbody>
    </table>

    <br>
    <p>
<button class="button" onclick="location.href='<%= "quizzController?mod=CreateQuestionForm&ID_Test=" + request.getAttribute("ID_Test").toString() %>'">Create</button>   	</p>
   	<p>
        <a href="Menu.jsp" class="button">Home page</a>
    </p>
</body>
</html>