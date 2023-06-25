<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Update Staff</title>
    <style>
        body {
            background-color: #f8f8f8;
            font-family: Arial, sans-serif;
        }

        .container {
            width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: #ffffff;
            border: 1px solid #dddddd;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            margin-bottom: 20px;
        }

        .form-group {
            margin-bottom: 20px;
        }

        .form-label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }

        .form-control {
            width: 100%;
            padding: 8px;
            border: 1px solid #dddddd;
            border-radius: 4px;
            box-sizing: border-box;
        }

        .submit-button {
            background-color: #4caf50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .cancel-button {
            background-color: #f44336;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Update Staff</h1>
        <form:form method="post" action="customer/updateCustomer" modelAttribute="customer">
            
            
            <div class="form-group">
                <label class="form-label" for="id">ID:</label>
                <form:input path="id" id="id" class="form-input" readonly="true" />
            </div>
            
            
            <div class="form-group">
                <label class="form-label">Email:</label>
                <form:input path="email" class="form-control" />
            </div>
            <div class="form-group">
                <label class="form-label">Username:</label>
                <form:input path="username" class="form-control" />
            </div>
            <div class="form-group">
                <label class="form-label">First Name:</label>
                <form:input path="firstName" class="form-control" />
            </div>
            <div class="form-group">
                <label class="form-label">Last Name:</label>
                <form:input path="lastName" class="form-control" />
            </div>
            <div class="form-group">
                <label class="form-label">Phone Number:</label>
                <form:input path="phoneNo" class="form-control" />
            </div>
            <div class="form-group">
                <label class="form-label">Address:</label>
                <form:input path="address" class="form-control" />
            </div>
            <div class="form-group">
                <input type="submit" value="Update" class="submit-button" />
                <a href="/cancelUpdate" class="cancel-button">Cancel</a>
            </div>
            
             <form:hidden path="id" />
        </form:form>
    </div>
    
    
      <div>
        <a href="/" class="login-btn">HOME</a>
      
    </div>
</body>
</html>
