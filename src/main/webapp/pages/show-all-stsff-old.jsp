<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <th>Status</th>
        </tr>
        <c:forEach var="staff" items="${allStaff}" varStatus="loop">
            <c:set var="rowColor" value="${loop.index % 5}" />
            <tr class="<c:choose>
                           <c:when test="${rowColor == 0}">red-bg</c:when>
                           <c:when test="${rowColor == 1}">blue-bg</c:when>
                           <c:when test="${rowColor == 2}">pink-bg</c:when>
                           <c:when test="${rowColor == 3}">green-bg</c:when>
                           <c:otherwise>yellow-bg</c:otherwise>
                       </c:choose>">
                <td>${staff.getId()}</td> 
                <td>${staff.getEmail()}</td>
                <td>${staff.getUsername()}</td>
                <td>${staff.getFirstName()}</td>
                <td>${staff.getLastName()}</td>
                <td>${staff.getPhoneNo()}</td>
                <td>${staff.getAddress()}</td>
                <td>${staff.getStatus()}</td>
            </tr>
        </c:forEach>
    </table>
    
      <div>
        <a href="/" class="login-btn">HOME</a>
      
    </div>
</body>
</html>

