<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Question</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f1f1f1;
        }

        form {
            width: 500px;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            border: 1px solid #ddd;
        }

        label {
            display: block;
            margin-bottom: 10px;
        }

        input[type="text"],
        select {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }

        input[type="submit"] {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <form action="quizzController?mod=CreateQuestion" method="post">
        <h2>Create Question</h2>
        <input hidden type="text" id="idTest" name="ID_Test" value ="<%= request.getAttribute("ID_Test") %>">

        <label for="name">Question:</label>
        <input type="text" id="name" name="name" required>

        <label for="opt1">Option 1:</label>
        <input type="text" id="opt1" name="opt1" required>

        <label for="opt2">Option 2:</label>
        <input type="text" id="opt2" name="opt2" required>

        <label for="opt3">Option 3:</label>
        <input type="text" id="opt3" name="opt3" required>

        <label for="opt4">Option 4:</label>
        <input type="text" id="opt4" name="opt4" required>

        <label for="answer">Answer:</label>
        <input type="text" id="answer" name="answer" required>

        <input type="submit" value="Submit">
    </form>
</body>
</html>