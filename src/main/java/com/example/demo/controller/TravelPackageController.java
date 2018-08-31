package com.example.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.TravelPackage;
import com.example.demo.service.TravelPackageService;

@RestController
@RequestMapping("/travel-packages")
public class TravelPackageController {
	private TravelPackageService travelPackageService;
	
	public TravelPackageController(TravelPackageService travelPackageService) {
		super();
		this.travelPackageService = travelPackageService;
	}
	
	@GetMapping("/{travelPackageId}")
	public TravelPackage getCustomer(@PathVariable ("travelPackageId") int travelPackageId) {
		return travelPackageService.getTravelPackageById(travelPackageId);
	}
	
	@PutMapping("/{travelPackageId}")
	public TravelPackage updateCustomer(@PathVariable ("travelPackageId") int travelPackageId, @RequestBody TravelPackage travelPackage) {
		return travelPackageService.updateTravelPackageById(travelPackageId, travelPackage);
	}
	
	@DeleteMapping("/{travelPackageId}")
	public void deleteCustomer(@PathVariable ("travelPackageId") int travelPackageId) {
		travelPackageService.deleteTravelPackageById(travelPackageService.getTravelPackageById(travelPackageId));
	}
	
}
