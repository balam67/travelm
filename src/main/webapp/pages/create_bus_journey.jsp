<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    

<!DOCTYPE html>
<html>
<head>
    <title>Create Bus Journey</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            padding: 20px;
        }
        
        .container {
            max-width: 500px;
            margin: 0 auto;
            background-color: #fff;
            padding: 30px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        
        h2 {
            text-align: center;
            margin-bottom: 30px;
        }
        
        .form-group {
            margin-bottom: 20px;
        }
        
        label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }
        
        input[type="text"],
        input[type="number"] {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        
        input[type="submit"] {
            background-color: #4CAF50;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 4px;
            cursor: pointer;
        }
        
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        
        .error {
            color: red;
            margin-top: 5px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Create Bus Journey</h2>
        <form action="/bus-journey/create-bus_journey" method="post">
            <div class="form-group">
                <label for="busNumber">Bus Number:</label>
                <input type="text" id="busNumber" name="busNumber" required>
            </div>
            <div class="form-group">
                <label for="departureCity">Origin:</label>
                <input type="text" id="departureCity" name="departureCity" required>
            </div>
            <div class="form-group">
                <label for="arrivalCity">Destination:</label>
                <input type="text" id="arrivalCity" name="arrivalCity" required>
            </div>
            <div class="form-group">
                <label for="fromDate">Departure Time:</label>
                <input type="text" id="fromDate" name="fromDate" required>
            </div>
            <div class="form-group">
                <label for="toDate">Arrival Time:</label>
                <input type="text" id="toDate" name="toDate" required>
            </div>
            <div class="form-group">
                <label for="fare">Fare:</label>
                <input type="text" id="fare" name="fare" required>
            </div>
            
           
            
           
            
            
            
            
            
            
            <div class="form-group">
                <input type="submit" value="Create Bus Journey">
            </div>
        </form>
    </div>
    
     <div>
        <a href="/bus-journey/show_bus_journeys_homepage" class="login-btn">BUS JOURNEY HOME</a>
      
    </div>
</body>
</html>
