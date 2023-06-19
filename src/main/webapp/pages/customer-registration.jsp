<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Customer Registration</title>
    <style>
        /* Inline CSS styles */
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
        }
        
        .container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        
        h1 {
            text-align: center;
        }
        
        .form-group {
            margin-bottom: 20px;
        }
        
        .form-group label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        
        .form-group input {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        
        .form-group input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
        }
        
        .form-group input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Staff Registration</h1>
        <form:form  action="/add-customer" modelAttribute="customer" method="post">
            <div class="form-group">
                <label>Email:</label>
                <form:input path="email" />
            </div>
            <div class="form-group">
                <label>Username:</label>
                <form:input path="username" />
            </div>
            <div class="form-group">
                <label>Password:</label>
                <form:input path="password" type="password" />
            </div>
            <div class="form-group">
                <label>First Name:</label>
                <form:input path="firstName" />
            </div>
            <div class="form-group">
                <label>Last Name:</label>
                <form:input path="lastName" />
            </div>
            <div class="form-group">
                <label>Phone Number:</label>
                <form:input path="phoneNo" />
            </div>
            <div class="form-group">
                <label>Address:</label>
                <form:input path="address" />
            </div>
            <div class="form-group">
                <input type="submit" value="Register" />
            </div>
        </form:form>
    </div>
    <div>
        <a href="/" class="login-btn">HOME</a>
      
    </div>
</body>
</html>
