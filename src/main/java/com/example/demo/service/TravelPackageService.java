package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.example.demo.models.TravelPackage;
import com.example.demo.repository.TravelPackageRepository;
@Transactional
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
	public TravelPackage updateTravelPackageById(int packageId, TravelPackage travelPackage) {
		if(travelPackageRepository.existsById(packageId)) {
			travelPackageRepository.save(travelPackage);
		}
 		return travelPackage;
	}
	//DELETE
	public void deleteTravelPackageById(TravelPackage travelPackageById) {
		travelPackageRepository.delete(travelPackageById);
	}

	
	//====== TRAVEL PACKAGES (GROUP) =====
	//Delete
	public void deleteTravelPackages(TravelPackage travelPackageById) {
		travelPackageRepository.delete(travelPackageById);
	}
	//Post
	public List<TravelPackage> saveTravelPackages(List<TravelPackage> travelPackageList) {
		return (List<TravelPackage>) travelPackageRepository.saveAll(travelPackageList);
	}
	//Update
	public List<TravelPackage> updateTravelPackages(List<TravelPackage> travelPackageList) {
		List<TravelPackage> tempTravelPackage = new ArrayList<TravelPackage>();
		for(TravelPackage travelPackageItem: travelPackageList) {
			if(travelPackageRepository.existsById(travelPackageItem.getTravelPackageId())) {
//				travelPackageItem.setAvailableServiceList(travelServiceService.updateAllTravelService(travelPackageItem.getAvailableServiceList()));
//				travelPackageRepository.save(travelPackageItem);
				tempTravelPackage.add(updateTravelPackageById(travelPackageItem.getTravelPackageId(), travelPackageItem));
			}
		}
		return tempTravelPackage;
	}
	//Find/Get
	public List<TravelPackage> getAllTravelPackages() {
		return (List<TravelPackage>) travelPackageRepository.findAll();
	}
	
	
}
