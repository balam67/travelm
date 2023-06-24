<!DOCTYPE html>
<html>
<head>
    <title>Search Bus Journey</title>
    <style>
        /* Inline CSS styles */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            width: 100%;
            height: 100%;
        }

        h1 {
            text-align: center;
        }

        table {
            width: 90%;
            height: 70%;
            margin: 0 auto;
        }

        td {
            padding: 15px;
        }

        .datepicker {
            padding: 7px;
            border: 1px solid #ccc;
            border-radius: 3px;
            width: 100%;
        }

        .button {
            padding: 13px 39px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            width: 100%;
        }

        /* Custom row colors */
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:nth-child(odd) {
            background-color: #e6e6e6;
        }
    </style>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
</head>
<body>
    <h1>Search Bus Journey</h1>
    <form method="post" action="/bus-journey/search" modelAttribute="busSearchForm">
        <table>
            <tr>
                <td>Departure City:</td>
                <td>
                    <select name="departureCity" style="width: 100%;">
                        <option value="">Select Departure City</option>
                        <option value="Washington DC">Washington DC</option>
                        <option value="New York">New York</option>
                        <option value="Dallas">Dallas</option>
                        <option value="Boston">Boston</option>
                        <option value="Seattle">Seattle</option>
                        <option value="Houston">Houston</option>
                        <option value="Los Angeles">Los Angeles</option>
                    </select>
                </td>
                <td>Arrival City:</td>
                <td>
                    <select name="arrivalCity" style="width: 100%;">
                        <option value="">Select Arrival City</option>
                        <option value="Chicago">Chicago</option>
                        <option value="New York">New York</option>
                        <option value="Miami">Miami</option>
                        <option value="San Francisco">San Francisco</option>
                        <option value="Las Vegas">Las Vegas</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Bus Number:</td>
                <td>
                    <select name="busNumber" style="width: 100%;">
                        <option value="">Select Bus Number</option>
                        <option value="BUS001">BUS001</option>
                        <option value="BUS002">BUS002</option>
                        <option value="BUS003">BUS003</option>
                        <option value="BUS004">BUS004</option>
                        <option value="BUS005">BUS005</option>
                    </select>
                </td>
                <td>Fee:</td>
                <td>
                    <select name="fee" style="width: 100%;">
                        <option value="">Select Fee</option>
                        <option value="18.75">18.75</option>
                        <option value="20.00">20.00</option>
                        <option value="100.00">100.00</option>
                        <option value="150.00">150.00</option>
                        <option value="200.00">200.00</option>
                        <option value="180.00">180.00</option>
                        <option value="120.00">120.00</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Booking Status:</td>
                <td>
                    <select name="bookingStatus" style="width: 100%;">
                        <option value="">Select Booking Status</option>
                        <option value="BOOKED">BOOKED</option>
                        <option value="AVAILABLE">AVAILABLE</option>
                    </select>
                </td>
                <td>Customer ID:</td>
                <td>
                    <select name="customerId" style="width: 100%;">
                        <option value="">Select Customer ID</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>From Date:</td>
                <td>
                    <input type="text" class="datepicker" name="fromDate" placeholder="Select From Date" style="width: 100%;" />
                </td>
                <td>To Date:</td>
                <td>
                    <input type="text" class="datepicker" name="toDate" placeholder="Select To Date" style="width: 100%;" />
                </td>
            </tr>
            <tr>
               
                
                 <td colspan="4" align="center">
                    <input type="submit" value="Search" class="button" style="width: 30%; text-align: center;" />
                 </td>
            </tr>
        </table>
    </form>

    <script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
    <script>
        flatpickr(".datepicker", {
            dateFormat: "Y-m-d",
            // Additional configuration options for Flatpickr
        });
    </script>
</body>
</html>
