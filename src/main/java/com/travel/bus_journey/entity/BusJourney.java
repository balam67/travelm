
package com.travel.bus_journey.entity;
import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "bus_journey")
public class BusJourney {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "departure_city", nullable = false)
    private String departureCity;
    
    @Column(name = "arrival_city", nullable = false)
    private String arrivalCity;
    
    @Column(name = "departure_time", nullable = false)
    private LocalDate fromDate;
    @Column(name = "arrival_time", nullable = false)
    private LocalDate toDate;
    
    @Column(name = "bus_number", nullable = false)
    private String busNumber;
    
  // @Column(name = "fare", nullable = false)
    private Double fee;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "booking_status", nullable = false)
    private BookingStatus bookingStatus;
    
    @Column(name = "customer_id")
    private Long customerId;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "is_active", nullable = false)
    private ActivationStatus activationStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public ActivationStatus getActivationStatus() {
		return activationStatus;
	}

	public void setActivationStatus(ActivationStatus activationStatus) {
		this.activationStatus = activationStatus;
	}

	@Override
	public String toString() {
		return "BusJourney [id=" + id + ", departureCity=" + departureCity + ", arrivalCity=" + arrivalCity
				+ ", fromDate=" + fromDate + ", toDate=" + toDate + ", busNumber=" + busNumber + ", fee=" + fee
				+ ", bookingStatus=" + bookingStatus + ", customerId=" + customerId + ", activationStatus="
				+ activationStatus + "]";
	}

	
}
