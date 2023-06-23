package com.travel.bus_journey.entity;

public class BusSearchForm {

	    private String departureCity;
	    private String arrivalCity;
	    private String busNumber;
	    private Double fee;
		public Double getFee() {
			return fee;
		}
		public void setFee(Double fee) {
			this.fee = fee;
		}
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
		
		@Override
		public String toString() {
			return "BusSearchForm [departureCity=" + departureCity + ", arrivalCity=" + arrivalCity + ", busNumber="
					+ busNumber + "]";
		}
}
