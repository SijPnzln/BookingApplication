package com.example.demo.service;

import com.example.demo.repository.TravelServiceRepository;

public class TravelServiceService {
	TravelServiceRepository travelServiceRepository;
	
	public TravelServiceService(TravelServiceRepository travelServiceRepository) {
		super();
		this.travelServiceRepository = travelServiceRepository;
	}
}
