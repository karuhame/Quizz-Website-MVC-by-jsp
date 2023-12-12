<%@page import="Model.bean.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form Update</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
        padding: 20px;
    }

    h1 {
        text-align: center;
        margin-bottom: 20px;
    }

    form {
        max-width: 400px;
        margin: 0 auto;
        background-color: #fff;
        padding: 20px;
        border-radius: 4px;
        box-shadow: 0 2px 4px rgba(0,0,0,0.1);
    }

    label {
        display: block;
        font-weight: bold;
        margin-bottom: 10px;
    }

    input[type="text"] {
        width: 100%;
        padding: 8px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
        margin-bottom: 20px;
    }

    input[type="submit"],
    input[type="reset"] {
        background-color: #4CAF50;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    input[type="submit"]:hover,
    input[type="reset"]:hover {
        background-color: #45a049;
    }
</style>
</head>
<body>
<%    
    String currentPass = (String) request.getAttribute("password");
%>
<h1>Change Password</h1>
<form name="form1" action="quizzController?mod=UpdatePass" method="post">
    <label for="oldpassword">Current Password:</label>
    <input type="text" name="oldpassword" id="oldpassword" value="<%= currentPass %>" >

    <label for="password">New Password:</label>
    <input type="text" name="password" id="password" value="" >

    <input type="hidden" name="ID_Account" value="<%= (String) request.getAttribute("ID_Account") %>" >

    <input type="submit" value="Submit">
    <input type="reset" value="Reset">
</form>
</body>
</html>