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
                
               
        
                
                
                
                
                
              <td>
                    <c:if test="${staff.getStatus() == 'Activated'}">
                        <a href="/deactivateStaff?id=${staff.getId()}" class="red-button">Deactivate</a>
                    </c:if>
                    <c:if test="${staff.getStatus() == 'DeActivated'}">
                        <a href="/activateStaff?id=${staff.getId()}" class="green-button">Activate</a>
                    </c:if>
                    <a href="/updateStaff?id=${staff.getId()}" class="blue-button">Update</a>
                    <a href="/deleteStaff?id=${staff.getId()}" class="pink-button">Delete</a>
                </td> 
            </tr>
        </c:forEach>
    </table>
    
      <div>
        <a href="/" class="login-btn">HOME</a>
      
    </div>
</body>
</html>


