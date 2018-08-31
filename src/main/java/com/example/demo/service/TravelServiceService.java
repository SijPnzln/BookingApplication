package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.example.demo.models.TravelService;
import com.example.demo.repository.TravelServiceRepository;
@Transactional
public class TravelServiceService {
	TravelServiceRepository travelServiceRepository;
	ImageService imageService;
	
	public TravelServiceService(TravelServiceRepository travelServiceRepository) {
		super();
		this.travelServiceRepository = travelServiceRepository;
	}
	
	//======= TRAVEL SERVICE =======
	//GET/FIND
	public TravelService getTravelServiceById(int packageId) {
		return travelServiceRepository.findById(packageId).get();
	}
	//PUT/UPDATE
	public TravelService updateTravelServiceById(int serviceId, TravelService travelServiceById) {
		if(travelServiceRepository.existsById(serviceId)) {
			travelServiceRepository.save(travelServiceById);
		}
 		return travelServiceById;
	}
	//DELETE
	public void deleteTravelServiceById(TravelService travelServiceById) {
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
	public List<TravelService> updateAllTravelService(List<TravelService> travelServiceList) {
		List<TravelService> tempTravelService = new ArrayList<TravelService>();
		for(TravelService travelServiceItem: travelServiceList) {
			if(travelServiceRepository.existsById(travelServiceItem.getServiceId())) {
//				travelServiceItem.setImages(imageService.updateImages(travelServiceItem.getImages()));
//				travelServiceRepository.save(travelServiceItem);
				tempTravelService.add(updateTravelServiceById(travelServiceItem.getServiceId(), travelServiceItem));
			}
		}
		return travelServiceList;
	}
}
