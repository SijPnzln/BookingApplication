package com.example.demo.models;

import javax.persistence.JoinColumn;

public class Image {
	private int imageId;
	private String description;
	private String imageUrl;
	@JoinColumn(name="travelService_id")
	private TravelService travelService;
	
	
	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
}
