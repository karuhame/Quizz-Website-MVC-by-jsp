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
<script>
    function showInput() {
        var inputContainer = document.getElementById("inputContainer");
        inputContainer.style.display = "block";
    }

    function submitInput() {
        var textInput = document.getElementById("textInput").value;
        // Perform any desired actions with the submitted text
        console.log("Submitted text:", textInput);
    }
</script>

    <h2>Test List</h2>
    <table border="1">
        <thead>
            <tr>
            	<th>STT </th>
                <th>Ten mon hoc</th>
                <th><%= (Integer) session.getAttribute("role") == 1?"Join Test":"Question List" %> </th>
                <th>Result </th>
            </tr>
        </thead>
        <tbody>
            <%
            List<TestBEAN> list = (List<TestBEAN>) request.getAttribute("list");
                                                for (int i = 0; i < list.size(); i++) {
            %>
            <tr>
                <td><%= i + 1 %></td>
                <td hidden><%= list.get(i).ID_Test %></td>
                <td><%= list.get(i).Name %></td>
                <%
			    int role = (Integer) session.getAttribute("role");
			    if (role == 0) {
				%>
				        <!-- Admin -->
               			<td><a href="<%= "quizzController?mod=QuestionList&ID_Test=" + list.get(i).ID_Test %>">View</a></td>
               			<td><a href="<%= "quizzController?mod=AllList&ID_Test=" + list.get(i).ID_Test %>">View</a></td>
               			
				<%
				    } else {
				%>
				        <!-- User-->
               			<td><a href="<%= "quizzController?mod=JoinTest&ID_Test=" + list.get(i).ID_Test %>">Join</a></td>	
               			<td><a href="<%= "quizzController?mod=AllList&ID_Test=" + list.get(i).ID_Test %>">Result</a></td>	        
               			        
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
    <button class="button" onclick="showInput()">Create</button>
    
    <form action="quizzController?mod=CreateTest" method="post" id="inputContainer" style="display: none;">
	    <input type="text" id="textInput" name="name">
	    <button class="button" type="Submit">Submit</button>
	</form>
    <p>    
        <a href="Menu.jsp" class="button">Home page</a>
    </p>
</body>
</html>