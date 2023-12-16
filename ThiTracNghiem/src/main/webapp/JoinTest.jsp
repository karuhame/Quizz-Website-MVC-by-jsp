<%@page import="Model.bean.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test Page</title>
<style>
    .question-container {
        margin-bottom: 20px;
    }

    .question {
        font-weight: bold;
    }

    .option {
        margin-left: 20px;
    }
</style>
</head>
<body>
    <h2>Question List:</h2>
    <form action="quizzController?mod=SubmitTest" method="post">
        <%
        List<QuestionBEAN> list = (List<QuestionBEAN>) request.getAttribute("list");
        for (int i = 0; i < list.size(); i++) {
        %>
        <div class="question-container">
        	<input type="hidden" name="ID_Test" value="<%= list.get(i).ID_Test %>">
        	
            <div class="question">
                <%= i + 1 %>. <%= list.get(i).name %>
            </div>
            <div class="option">
                <input type="radio" name="answer_<%= list.get(i).ID_Question %>" value="1">
                <%= list.get(i).opt1 %>
            </div>
            <div class="option">
                <input type="radio" name="answer_<%= list.get(i).ID_Question %>" value="2">
                <%= list.get(i).opt2 %>
            </div>
            <div class="option">
                <input type="radio" name="answer_<%= list.get(i).ID_Question %>" value="3">
                <%= list.get(i).opt3 %>
            </div>
            <div class="option">
                <input type="radio" name="answer_<%= list.get(i).ID_Question %>" value="4">
                <%= list.get(i).opt4 %>
            </div>
        </div>
        <%
        }
        %>
        <br>
        <input type="submit" value="Submit">
    </form>

    <br>
    <p>
        <a href="index.jsp">Trang chủ</a>
    </p>
</body>
</html>