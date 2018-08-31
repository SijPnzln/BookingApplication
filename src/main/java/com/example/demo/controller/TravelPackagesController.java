package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.TravelPackage;
import com.example.demo.service.TravelPackageService;

@RestController
@RequestMapping("/travel-packages")
public class TravelPackagesController {
private TravelPackageService travelPackageService;
	
	public TravelPackagesController(TravelPackageService travelPackageService) {
		super();
		this.travelPackageService = travelPackageService;
	}
	
	@GetMapping
	public List <TravelPackage> getAllTravelPackages() {
		return (List<TravelPackage>) travelPackageService.getAllTravelPackages();
	}
	
	@PutMapping
	public List<TravelPackage> updateTravelPackages(@RequestBody List<TravelPackage> travelPackageList) {
		return travelPackageService.updateTravelPackages(travelPackageList);
	}
	
	@PostMapping
	public List<TravelPackage> saveTravelPackages (@RequestBody List<TravelPackage> travelPackage) {
		return travelPackageService.saveTravelPackages(travelPackage);
	}
	
	@DeleteMapping
	public void deleteTravelPackages(@RequestParam("customerId") int[] travelPackageIds) {
		for(int i=0; i<travelPackageIds.length; i++) {
			travelPackageService.deleteTravelPackages(travelPackageService.getTravelPackageById(travelPackageIds[i]));
		}
	}
	
}
