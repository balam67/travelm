<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Search Bus</title>
</head>
<body>
    <h1>Search Bus</h1>
    <form:form method="post" action="/bus-journey/search" modelAttribute="busSearchForm">
        <table>
            <tr>
                <td>Departure City:</td>
               
                <td>
                    <form:select path="arrivalCity">
                        <form:option value="">Select DepartureCity City</form:option>
                        <form:option value="Washington DC">Washington DC</form:option>
                        <form:option value="New York">New York</form:option>
                         <form:option value="Dallas">Dallas</form:option>
                        <form:option value="Boston">Boston</form:option>
                        <form:option value="Seattle">Seattle</form:option>
                        <form:option value="Houston">Houston</form:option>
                        <form:option value="Los Angeles">Los Angeles</form:option>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>Arrival City:</td>
              
                 <td>
                    <form:select path="departureCity">
                        <form:option value="">Select Arrival City</form:option>
                        <form:option value="Chicago DC">Chicago</form:option>
                        <form:option value="New York">New York</form:option>
                       
                        <form:option value="Miami">Miami</form:option>
                        <form:option value="San Francisco">San Francisco</form:option>
                        <form:option value="Las Vegas">Las Vegas</form:option>
                     
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>Bus Number:</td>
               
                 <td>
                    <form:select path="busNumber">
                        <form:option value="">Select Bus Number</form:option>
                        <form:option value="BUS001">BUS001</form:option>
                        <form:option value="BUS002">BUS002</form:option>
                        <form:option value="BUS003">BUS003</form:option>
                        <form:option value="BUS004">BUS004</form:option>
                        <form:option value="BUS005">BUS005</form:option>
                       
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>Fee:</td>
                <td>
                    <form:select path="fee">
                        <form:option value="">Select Fee</form:option>
                        <form:option value="18.75">18.75</form:option>
                        <form:option value="20.00">20.00</form:option>
                        <form:option value="100.00">100.00</form:option>
                        <form:option value="150.00">150.00</form:option>
                        <form:option value="200.00">200.00</form:option>
                        <form:option value="180.00">180.00</form:option>
                        <form:option value="120.00">120.00</form:option>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Search" />
                </td>
            </tr>
        </table>
    </form:form>
</body>
</html>
