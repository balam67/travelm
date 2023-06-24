package com.travel.bus_journey.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;



public class BusSearchForm {

	    private String departureCity;
	    private String arrivalCity;
	    private String busNumber;
	    private Double fee;
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    private LocalDate fromDate;
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    private LocalDate toDate;
	    private BookingStatus bookingStatus;
	    private Long customerId;
		public String getDepartureCity() {
			return departureCity;
		}
		public void setDepartureCity(String departureCity) {
			this.departureCity = departureCity;
		}
		public String getArrivalCity() {
			return arrivalCity;
		}
		public void setArrivalCity(String arrivalCity) {
			this.arrivalCity = arrivalCity;
		}
		public String getBusNumber() {
			return busNumber;
		}
		public void setBusNumber(String busNumber) {
			this.busNumber = busNumber;
		}
		public Double getFee() {
			return fee;
		}
		public void setFee(Double fee) {
			this.fee = fee;
		}
		public LocalDate getFromDate() {
			return fromDate;
		}
		public void setFromDate(LocalDate fromDate) {
			this.fromDate = fromDate;
		}
		public LocalDate getToDate() {
			return toDate;
		}
		public void setToDate(LocalDate toDate) {
			this.toDate = toDate;
		}
		public BookingStatus getBookingStatus() {
			return bookingStatus;
		}
		public void setBookingStatus(BookingStatus bookingStatus) {
			this.bookingStatus = bookingStatus;
		}
		public Long getCustomerId() {
			return customerId;
		}
		public void setCustomerId(Long customerId) {
			this.customerId = customerId;
		}
		@Override
		public String toString() {
			return "BusSearchForm [departureCity=" + departureCity + ", arrivalCity=" + arrivalCity + ", busNumber="
					+ busNumber + ", fee=" + fee + ", fromDate=" + fromDate + ", toDate=" + toDate + ", bookingStatus="
					+ bookingStatus + ", customerId=" + customerId + "]";
		}
	    
	    
		
	
}
