<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Bus Results</title>
</head>
<body>
    <h1>Bus Results</h1>
    <table>
        <tr>
            <th>Departure City</th><th></th>
            <th>Arrival City</th><th></th>
            <th>Bus Number</th><th></th>
            <th>Fare</th><th></th>
            <th>Booking_status</th><th></th>
            <th>Arrival Time</th><th></th>
             <th>DepartureTime</th>
            
        </tr>
        <c:forEach var="bus" items="${searchBuses}">
            <tr>
                <td>${bus.departureCity}</td><td></td>
                <td>${bus.arrivalCity}</td><td></td>
                <td>${bus.busNumber}</td><td></td>
                 <td>${bus.fee}</td><td></td>
                  <td>${bus.bookingStatus}</td><td></td>
                  <td>${bus.arrivalTime}</td><td></td>
                    <td>${bus.departureTime}</td>
                  
            </tr>
        </c:forEach>
    </table>
    
     <div>
        <a href="/bus-journey/search" class="login-btn">SEARCH BUSES</a>
      
    </div>
     <div>
        <a href="/bus-journey/show_bus_journeys_homepage" class="login-btn">SEARCH BUSES HOMEPAGE</a>
      
    </div>
</body>
</html>
