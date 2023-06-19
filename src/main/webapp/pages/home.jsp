<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>
    <title>My Website</title>
    <style>
        /* Inline CSS styles */
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .dropdown {
            display: inline-block;
            margin-bottom: 20px;
        }

        .dropdown button {
            background-color: #4CAF50;
            color: white;
            padding: 10px;
            font-size: 16px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #f9f9f9;
            min-width: 160px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
            z-index: 1;
        }

        .dropdown-content a {
            color: black;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
        }

        .dropdown-content a:hover {
            background-color: #f1f1f1;
        }

        .dropdown:hover .dropdown-content {
            display: block;
        }

        .login-btn {
            float: right;
            background-color: #e91e63;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .login-btn:hover {
            background-color: #c2185b;
        }

        .logout-btn {
            float: right;
            background-color: #2196f3;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .logout-btn:hover {
            background-color: #1976d2;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="dropdown">
            <button>Dropdown</button>
            <div class="dropdown-content">
                <a href="/staff" style="background-color: #ff9800;">STAFF REGISTRATION</a>
                <a href="/customer" style="background-color: #4caf50;">CUSTOMER REGISTRATION</a>
                <a href="/show-all-customers" style="background-color: #2196f3;">LIST CUSTOMERS</a>
                <a href="/show-all-stsff" style="background-color: #f44336;">LIST STAFF</a>
                <a href="/show-all-customers" style="background-color: #9c27b0;">ADD BUSES</a>
                <a href="/controller/method5" style="background-color: #c2185b;">VIEW BUSES</a>
                <a href="/controller/method5" style="background-color: #e91e63;">BOOK BUS TICKETS</a>
                <a href="/controller/method5" style="background-color: #4CAF50;">VIEW BUS TICKETS</a>
                <a href="/controller/method5" style="background-color: #1976d2;">Box 5</a>
            </div>
        </div>
        <a href="/controller/login" class="login-btn">Login</a>
        <a href="/controller/logout" class="logout-btn">Logout</a>
    </div>
</body>
</html>
