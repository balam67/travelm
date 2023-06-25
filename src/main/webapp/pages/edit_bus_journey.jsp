<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Bus Journey</title>
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
</head>
<body>
    <h1>Edit Bus Journey</h1>
    <div class="form-container">
        <form:form action="/bus-journey/updateBus" method="POST" modelAttribute="busJourney">
        
           <div class="form-group">
                <label class="form-label" for="id">ID:</label>
                <form:input path="id" id="id" class="form-input" readonly="true" />
            </div>
            
            <div class="form-group">
                <label class="form-label" for="departureCity">Departure City:</label>
                <input type="text" id="departureCity" name="departureCity" class="form-control" value="${busJourney.departureCity}" required>
            </div>
            <div class="form-group">
                <label class="form-label" for="arrivalCity">Arrival City:</label>
                <input type="text" id="arrivalCity" name="arrivalCity" class="form-control" value="${busJourney.arrivalCity}" required>
            </div>
            <div class="form-group">
                <label class="form-label" for="fromDate">Departure Time:</label>
                <input type="text" id="fromDate" name="fromDate" class="form-control" value="${busJourney.departureTime}" required>
            </div>
            <div class="form-group">
                <label class="form-label" for="toDate">Arrival Time:</label>
                <input type="text" id="toDate" name="toDate" class="form-control" value="${busJourney.arrivalTime}" required>
            </div>
            <div class="form-group">
                <label class="form-label" for="busNumber">Bus Number:</label>
                <input type="text" id="busNumber" name="busNumber" class="form-control" value="${busJourney.busNumber}" required>
            </div>
            <div class="form-group">
                <label class="form-label" for="fare">Fare:</label>
                <input type="text" id="fare" name="fare" class="form-control" value="${busJourney.fare}" required>
            </div>
            <div class="form-group">
                <label class="form-label" for="bookingStatus">Booking Status:</label>
                <select id="bookingStatus" name="bookingStatus" class="form-control" required>
                    <option value="BOOKED" ${busJourney.getBookingStatus() == 'BOOKED' ? 'selected' : ''}>BOOKED</option>
                    <option value="AVAILABLE" ${busJourney.getBookingStatus() == 'AVAILABLE' ? 'selected' : ''}>AVAILABLE</option>
                </select>
            </div>
            <div class="form-group">
                <label class="form-label" for="customerId">Customer ID:</label>
                <input type="text" id="customerId" name="customerId" class="form-control" value="${busJourney.customerId}" required>
            </div>
            <div class="form-group">
                <label class="form-label" for="activationStatus">Activation Status:</label>
                <select id="activationStatus" name="activationStatus" class="form-control" required>
                    <option value="ACTIVE" ${busJourney.getActivationStatus() == 'ACTIVE' ? 'selected' : ''}>ACTIVE</option>
                    <option value="INACTIVE" ${busJourney.getActivationStatus() == 'INACTIVE' ? 'selected' : ''}>INACTIVE</option>
                </select>
            </div>
            <div class="btn-container">
                <button type="submit" class="btn">Update</button>
            </div>
            
            <form:hidden path="id" />
        </form:form>
    </div>
</body>
</html>
