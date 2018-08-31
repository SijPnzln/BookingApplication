package com.example.demo.models;

import java.time.LocalDate;

public class ServiceFee {
	private int serviceFeeId;
	private float amount;
	private TravelService service;
	private LocalDate startDate;
	
	public int getServiceFeeId() {
		return serviceFeeId;
	}
	public void setServiceFeeId(int serviceFeeId) {
		this.serviceFeeId = serviceFeeId;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public TravelService getService() {
		return service;
	}
	public void setService(TravelService service) {
		this.service = service;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
}
