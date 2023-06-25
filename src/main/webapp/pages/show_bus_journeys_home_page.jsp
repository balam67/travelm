<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Bus Journeys Home</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            padding: 20px;
            display: flex;
        }
        
        .sidebar {
            width: 200px;
            background-color: #333;
            color: #fff;
            padding: 20px;
            margin-right: 20px;
        }
        
        .menu-link {
            display: block;
            margin-bottom: 10px;
            color: #fff;
            text-decoration: none;
        }
        
        .box-container {
            display: flex;
            flex-wrap: wrap;
            gap: 20px;
        }
        
        .box {
            width: 150px;
            height: 150px;
            text-align: center;
            line-height: 150px;
            color: #fff;
            font-weight: bold;
            text-decoration: none;
        }
        
        .box-1 {
            background-color: #007bff;
        }
        
        .box-2 {
            background-color: #28a745;
        }
        
        .box-3 {
            background-color: #dc3545;
        }
        
        .box-4 {
            background-color: #ffc107;
        }
        
        .box-5 {
            background-color: #e83e8c;
        }
        
        .box-6 {
            background-color: #6f42c1;
        }
        
        .box-7 {
            background-color: #17a2b8;
        }
        
        .box-8 {
            background-color: #fd7e14;
        }
    </style>
</head>
<body>
   <!--  <div class="sidebar">
        <h2>Menu</h2>
        <ul>
            <li><a class="menu-link" href="#">Link 1</a></li>
            <li><a class="menu-link" href="#">Link 2</a></li>
            <li><a class="menu-link" href="#">Link 3</a></li>
            <li><a class="menu-link" href="#">Link 4</a></li>
            <li><a class="menu-link" href="#">Link 5</a></li>
        </ul>
    </div>
     -->
    <div class="box-container">
        <a class="box box-1" href="/bus-journey/show_bus_journeys">
           SHOW ALL BUS JOURNEYS
        </a>
        <a class="box box-2" href="/bus-journey/create-bus_journey">
            CREATE BUS JOURNEY
        </a>
        <a class="box box-3" href="/bus-journey/search_bus_journey">
            SHOW AVAILABLE BUSES 
        </a>
        <a class="box box-4" href="/bus-journey/search">
            SEARCH
        </a>
    
    </div>
    
    
   
</body>
</html>
