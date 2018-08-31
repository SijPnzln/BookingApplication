package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.TravelPackage;

@Repository
public interface TravelPackageRepository extends CrudRepository<TravelPackage, Integer>{

}
