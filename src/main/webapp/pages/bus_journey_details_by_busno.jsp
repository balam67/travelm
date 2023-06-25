<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Bus Journey Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            padding: 20px;
        }
        
        .bus-record {
            padding: 10px;
            margin-bottom: 10px;
            border-radius: 5px;
            color: #fff;
            font-weight: bold;
        }
        
        .bus-record-blue {
            background-color: #007bff;
        }
        
        .bus-record-green {
            background-color: #28a745;
        }
        
        .bus-record-red {
            background-color: #dc3545;
        }
        
        .bus-record-yellow {
            background-color: #ffc107;
        }
        
        .bus-record-pink {
            background-color: #e83e8c;
        }
        
        .bus-record-purple {
            background-color: #6f42c1;
        }
    </style>
</head>
<body>
    <h2>Bus Journey Details</h2>
    <div class="bus-records">
        <c:forEach var="busJourney" items="${busJourneys}">
            <div class="bus-record ${busJourney.colorClass}">
                <p>Bus Number: ${busJourney.busNumber}</p>
                <p>Origin: ${busJourney.origin}</p>
                <p>Destination: ${busJourney.destination}</p>
                <p>Departure Time: ${busJourney.departureTime}</p>
                <p>Arrival Time: ${busJourney.arrivalTime}</p>
            </div>
        </c:forEach>
    </div>
    
     <div>
        <a href="/bus-journey/show_bus_journeys_homepage" class="login-btn">HOME</a>
      
    </div>
</body>
</html>
