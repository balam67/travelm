<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Bus Results</title>
    <style>
        /* CSS styles for table */
        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 10px;
            text-align: center;
        }

        th {
            background-color: #007bff;
            color: #fff;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:nth-child(odd) {
            background-color: #e6e6e6;
        }

        .button {
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            text-decoration: none;
            display: inline-block;
        }

        .button:hover {
            background-color: #0069d9;
        }

        .green-button {
            padding: 10px 20px;
            background-color: #008000;
            color: #fff;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            text-decoration: none;
            display: inline-block;
        }

        .green-button:hover {
            background-color: #006400;
        }

        .red-button {
            padding: 10px 20px;
            background-color: #FF0000;
            color: #fff;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            text-decoration: none;
            display: inline-block;
        }

        .red-button:hover {
            background-color: #8B0000;
        }
    </style>
</head>
<body>
    <h1>Bus Results</h1>
    <table>
        <tr>
            <th>Id</th>
            <th>Departure City</th>
            <th>Arrival City</th>
            <th>Bus Number</th>
            <th>Fare</th>
            <th>Arrival Time</th>
            <th>Departure Time</th>
            <th>Action</th>
        </tr>
        <c:forEach var="bus" items="${searchBuses}" varStatus="status">
            <tr style="background-color: ${status.index % 2 == 0 ? '#f2f2f2' : '#e6e6e6'};">
                <td>${bus.id}</td>
                <td>${bus.departureCity}</td>
                <td>${bus.arrivalCity}</td>
                <td>${bus.busNumber}</td>
                <td>${bus.fee}</td>
                <td>${bus.fromDate}</td>
                <td>${bus.toDate}</td>
                <td>
                    <c:choose>
                        <c:when test="${bus.bookingStatus eq 'BOOKED'}">
                            <a href="#" class="red-button">Not Available</a>
                        </c:when>
                        <c:otherwise>
                            <a href="/bus-journey/bookTicket?id=${bus.id}" class="green-button">Available</a>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br/><br/>
    <div>
        <a href="/bus-journey/search" style="background-color: #FFC0CB; padding: 10px 20px; color: #fff; text-decoration: none;">SEARCH BUSES</a>&nbsp;&nbsp;&nbsp;
        <a href="/bus-journey/show_bus_journeys_homepage" style="background-color: #008000; padding: 10px 20px; color: #fff; text-decoration: none;">SEARCH BUSES HOMEPAGE</a>
    </div>
</body>
</html>
