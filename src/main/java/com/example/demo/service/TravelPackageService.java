package com.example.demo.service;

import java.util.List;

import org.springframework.context.annotation.Configuration;

import com.example.demo.models.TravelPackage;
import com.example.demo.repository.TravelPackageRepository;
import com.example.demo.repository.TravelServiceRepository;

@Configuration
public class TravelPackageService {
	private TravelPackageRepository travelPackageRepository;
	private TravelServiceRepository travelServiceRepository;
	
	public TravelPackageService(TravelPackageRepository travelPackageRepository) {
		super();
		this.travelPackageRepository = travelPackageRepository;
	}

	public TravelPackage getTravelPackageById(int packageId) {
		return travelPackageRepository.findById(packageId).get();
	}

	public TravelPackage updateTravelPackage(int packageId, TravelPackage travelPackage) {
		if(travelPackageRepository.existsById(packageId)) {
			travelPackageRepository.save(travelPackage);
		}
 		return travelPackage;
	}

	public void deleteTravelPackage(TravelPackage travelPackageById) {
		travelPackageRepository.delete(travelPackageById);
	}

	public void deleteTravelPackages(TravelPackage travelPackageById) {
		// TODO Auto-generated method stub
		
	}

	public List<TravelPackage> saveTravelPackages(List<TravelPackage> travelPackage) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TravelPackage> updateTravelPackages(List<TravelPackage> travelPackageList) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TravelPackage> getAllTravelPackages() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
