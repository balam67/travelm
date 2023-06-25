
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
<head>
    <title>Search Results</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
        .btn-container {
            text-align: center;
        }
        .btn {
            padding: 8px 16px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }
        .btn:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1>Search Results</h1>
    <table>
        <thead>
            <tr>
                <th>Departure City</th>
                <th>Arrival City</th>
                <th>Departure Time</th>
                <th>Arrival Time</th>
                <th>Bus Number</th>
                <th>Fare</th>
                <th>Booking Status</th>
                <th>Customer ID</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="busJourney" items="${searchBusJourneys}">
                <tr>
                    <td>${busJourney.departureCity}</td>
                    <td>${busJourney.arrivalCity}</td>
                    <td>${busJourney.fromDate}</td>
                    <td>${busJourney.toDate}</td>
                    <td>${busJourney.busNumber}</td>
                    <td>${busJourney.fare}</td>
                    <td>${busJourney.bookingStatus}</td>
                    <td>${busJourney.getCustomerId()}</td>
                    <td class="btn-container">
                        <a href="/bus-journey/save_booking?busJourneyId=${busJourney.id}" class="btn">Book Now</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
