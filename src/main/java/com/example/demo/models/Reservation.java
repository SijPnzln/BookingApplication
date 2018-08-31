package com.example.demo.models;

import java.time.LocalDate;
import java.util.List;

public class Reservation {
	private int reservationId;
	private List <TravelService> availedServiceList;
	private LocalDate departureDate;
	private Customer customer;
	
	public int getReservationId() {
		return reservationId;
	}
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
	public List<TravelService> getAvailedServiceList() {
		return availedServiceList;
	}
	public void setAvailedServiceList(List<TravelService> availedServiceList) {
		this.availedServiceList = availedServiceList;
	}
	public LocalDate getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
