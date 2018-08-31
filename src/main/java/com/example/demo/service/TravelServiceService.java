package com.example.demo.service;

import java.util.List;

import com.example.demo.models.TravelService;
import com.example.demo.repository.TravelServiceRepository;

public class TravelServiceService {
	TravelServiceRepository travelServiceRepository;
	
	public TravelServiceService(TravelServiceRepository travelServiceRepository) {
		super();
		this.travelServiceRepository = travelServiceRepository;
	}
	
	//======= TRAVEL SERVICE =======
	//GET/FIND
	public TravelService getTravelPackageById(int packageId) {
		return travelServiceRepository.findById(packageId).get();
	}
	//PUT/UPDATE
	public TravelService updateTravelPackage(int serviceId, TravelService travelServiceById) {
		if(travelServiceRepository.existsById(serviceId)) {
			travelServiceRepository.save(travelServiceById);
		}
 		return travelServiceById;
	}
	//DELETE
	public void deleteTravelService(TravelService travelServiceById) {
		travelServiceRepository.delete(travelServiceById);
	}
	
	
	//======== TRAVEL SERVICE (GROUP) ========
	
	//POST/SAVE
	public List<TravelService> saveAllServices(List<TravelService> serviceList) {
		return (List<TravelService>) travelServiceRepository.saveAll(serviceList);
	}
	//DELETE
	public void deleteAllServices(int serviceId) {
			travelServiceRepository.deleteById(serviceId);
	}
	//GET/FIND
	public List<TravelService> getAllServices() {
		return (List<TravelService>) travelServiceRepository.findAll();
	}
	//PUT/UPDATE
	
	
	
}
