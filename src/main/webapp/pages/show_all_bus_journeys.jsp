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
        
        table {
            width: 100%;
            border-collapse: collapse;
        }
        
        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        
        th {
            background-color: #333;
            color: #fff;
        }
        
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        
        tr:nth-child(odd) {
            background-color: #fff;
        }
    </style>
</head>
<body>
    <h2>Bus Journey Details</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Bus Number</th>
            <th>Origin</th>
            <th>Destination</th>
            <th>Departure Time</th>
            <th>Arrival Time</th>
             <th>Actions</th>
        </tr>
        <c:forEach var="busJourney" items="${busJourneys}">
            <tr>
                <td>${busJourney.id}</td>
                <td>${busJourney.busNumber}</td>
                <td>${busJourney.departureCity}</td>
                <td>${busJourney.arrivalCity}</td>
                <td>${busJourney.departureTime}</td>
                <td>${busJourney.arrivalTime}</td>
                
                  <td>
                    <c:if test="${busJourney.getActivationStatus() == 'ACTIVE'}">
                        <a href="/bus-journey/deactivateBus?id=${busJourney.getId()}" class="red-button">DEACTIVATE</a>
                    </c:if>
                    <c:if test="${busJourney.getActivationStatus() == 'INACTIVE'}">
                        <a href="/bus-journey/activateBus?id=${busJourney.getId()}" class="green-button">ACTIVATE</a>
                    </c:if>
                    <a href="/bus-journey/updateBus?id=${busJourney.getId()}" class="blue-button">Update</a>
                    <a href="/bus-journey/deleteBus?id=${busJourney.getId()}" class="pink-button">Delete</a>
                </td> 
            </tr>
        </c:forEach>
    </table>
    
     <div>
        <a href="show_bus_journeys_homepage" class="login-btn">BUS JOURNEY HOME</a>
      
    </div>
</body>
</html>



























