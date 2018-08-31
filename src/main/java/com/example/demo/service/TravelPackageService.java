package com.example.demo.service;

import java.util.List;

import com.example.demo.models.TravelPackage;
import com.example.demo.repository.TravelPackageRepository;

public class TravelPackageService {
	private TravelPackageRepository travelPackageRepository;
	private TravelServiceService travelServiceService;
	
	public TravelPackageService(TravelPackageRepository travelPackageRepository) {
		super();
		this.travelPackageRepository = travelPackageRepository;
	}
	
	//======== TRAVEL PACKAGE =========
	//GET/FIND
	public TravelPackage getTravelPackageById(int packageId) {
		return travelPackageRepository.findById(packageId).get();
	}
	//PUT/UPDATE
	public TravelPackage updateTravelPackage(int packageId, TravelPackage travelPackage) {
		if(travelPackageRepository.existsById(packageId)) {
			travelPackageRepository.save(travelPackage);
		}
 		return travelPackage;
	}
	//DELETE
	public void deleteTravelPackage(TravelPackage travelPackageById) {
		travelPackageRepository.delete(travelPackageById);
	}

	
	//====== TRAVEL PACKAGES (GROUP) =====
	//Delete
	public void deleteTravelPackages(TravelPackage travelPackageById) {
		travelPackageRepository.delete(travelPackageById);
	}
	//Post
	public List<TravelPackage> saveTravelPackages(List<TravelPackage> travelPackageList) {
		for(TravelPackage travelPackageItem: travelPackageList) {
			travelServiceService.saveAllServices(travelPackageItem.getAvailableServiceList());
			travelPackageRepository.save(travelPackageItem);
		}
		return travelPackageList;
	}
	//Update
	public List<TravelPackage> updateTravelPackages(List<TravelPackage> travelPackageList) {
		for(TravelPackage travelPackageItem: travelPackageList) {
			if(travelPackageRepository.existsById(travelPackageItem.getTravelPackageId())) {
				travelServiceService.saveAllServices(travelPackageItem.getAvailableServiceList());
				travelPackageRepository.save(travelPackageItem);
			}
		}
		return travelPackageList;
	}
	//Find/Get
	public List<TravelPackage> getAllTravelPackages() {
		return (List<TravelPackage>) travelPackageRepository.findAll();
	}
	
	
}
