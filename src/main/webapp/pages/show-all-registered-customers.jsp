
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ccc;
        }

        .red-bg {
            background-color: #ff0000;
        }

        .blue-bg {
            background-color: #0000ff;
        }

        .pink-bg {
            background-color: #ff69b4;
        }

        .green-bg {
            background-color: #00ff00;
        }

        .yellow-bg {
            background-color: #ffff00;
        }

        .red-button {
            background-color: #ff0000;
            color: #ffffff;
        }

        .blue-button {
            background-color: #0000ff;
            color: #ffffff;
        }

        .pink-button {
            background-color: #ff69b4;
            color: #ffffff;
        }

        .green-button {
            background-color: #00ff00;
            color: #ffffff;
        }

        .yellow-button {
            background-color: #ffff00;
            color: #ffffff;
        }
    </style>
</head>
<body>
    <table>
        <tr>
            <th>Id</th>
            <th>Email</th>
            <th>Username</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Phone Number</th>
            <th>Address</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="customer" items="${allCustomers}" varStatus="loop">
            <c:set var="rowColor" value="${loop.index % 5}" />
            <tr class="<c:choose>
                           <c:when test="${rowColor == 0}">red-bg</c:when>
                           <c:when test="${rowColor == 1}">blue-bg</c:when>
                           <c:when test="${rowColor == 2}">pink-bg</c:when>
                           <c:when test="${rowColor == 3}">green-bg</c:when>
                           <c:otherwise>yellow-bg</c:otherwise>
                       </c:choose>">
                <td>${customer.getId()}</td> 
                <td>${customer.getEmail()}</td>
                <td>${customer.getUsername()}</td>
                <td>${customer.getFirstName()}</td>
                <td>${customer.getLastName()}</td>
                <td>${customer.getPhoneNo()}</td>
                <td>${customer.getAddress()}</td>
                <td>
                    <c:if test="${customer.getStatus() == 'Activated'}">
                        <a href="/bus-journey/bookTicket?id=${customer.getId()}" class="red-button">Book Ticket</a>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
      <div>
        <a href="/bus-journey/show_bus_journeys" class="login-btn">show_bus_journeys</a>
      
    </div>
</body>
</html>







