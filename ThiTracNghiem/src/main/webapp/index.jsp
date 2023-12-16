<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Login</title>
  <style>
    body {
      font-family: Arial, sans-serif;
    }

    .container-wrapper {
      display: flex;
      justify-content: center;
      align-items: center;
    }
    
    .container {
      max-width: 500px;
      margin: 0 auto;
      padding: 20px;
      border: 1px solid #ccc;
      border-radius: 5px;
      display: flex;
      align-items: center;
    }

    .container .divider {
      width: 1px;
      height: 100%;
      background-color: #ccc;
      margin-right: 20px;
    }

    .container img {
      width: 120px;
      margin-right: 20px;
    }

    .container h2 {
      margin-bottom: 20px;
    }

    .container label {
      display: block;
      margin-bottom: 10px;
    }

    .container input[type="text"],
    .container input[type="password"] {
      width: 93%;
      padding: 10px;
      border: 1px solid #ccc;
      border-radius: 5px;
      margin-bottom: 20px;
    }

    .container button {
      width: 100%;
      padding: 10px;
      background-color: #4CAF50;
      color: white;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      margin-bottom: 10px;
    }

    .container button[type="reset"] {
      background-color: #ccc;
    }
  </style>
</head>
<body>
  <div class="container-wrapper">
    <div>
      <img src="https://aztest.vn/uploads/news/2022/danh-gia-nhan-su.jpg" alt="Logo">
    </div>
    <div class="container">
      <div class="divider"></div>
      <form name="form1" action="quizzController?mod=Login" method="post">
        <h2>Login</h2>
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>

        <button type="submit">Login</button>
        <button type="">Reset</button>
      </form>
    </div>
  </div>
</body>
</html>