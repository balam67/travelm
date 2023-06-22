<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Search Bus Journey</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        h1 {
            color: #333333;
        }
        .form-container {
            width: 400px;
            margin: 0 auto;
        }
        .form-group {
            margin-bottom: 20px;
        }
        .form-label {
            display: block;
            font-weight: bold;
        }
        .form-control {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            border-radius: 5px;
            border: 1px solid #CCCCCC;
        }
        .btn-container {
            text-align: right;
        }
        .btn {
            padding: 10px 20px;
            font-size: 16px;
            border-radius: 5px;
            background-color: #333333;
            color: #FFFFFF;
            border: none;
            cursor: pointer;
        }
        .btn:hover {
            background-color: #555555;
        }
    </style>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
        $(function() {
            $("#departureTime, #arrivalTime").datepicker({
                dateFormat: "yy-mm-dd",
                changeMonth: true,
                changeYear: true
            });
        });
    </script>
</head>
<body>
    <h1>Search Bus Journey</h1>
    <div class="form-container">
        <form:form action="/bus-journey/search_bus_journey_details" method="POST" modelAttribute="busJourneyByInput" >
            <div class="form-group">
                <label class="form-label" for="departureCity">Departure City:</label>
                <input type="text" id="departureCity" name="departureCity" class="form-control" required>
            </div>
            <div class="form-group">
                <label class="form-label" for="arrivalCity">Arrival City:</label>
                <input type="text" id="arrivalCity" name="arrivalCity" class="form-control" required>
            </div>
           <!--  <div class="form-group">
                <label class="form-label" for="departureTime">Departure Time:</label>
                <input type="text" id="departureTime" name="departureTime" class="form-control" required>
            </div>
            <div class="form-group">
                <label class="form-label" for="arrivalTime">Arrival Time:</label>
                <input type="text" id="arrivalTime" name="arrivalTime" class="form-control" required>
            </div> -->
            <div class="btn-container">
                <button type="submit" class="btn">Search</button>
            </div>
        </form:form>
    </div>
</body>
</html>
