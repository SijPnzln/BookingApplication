package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Image;

@Repository
public interface ImageRepository extends CrudRepository<Image, Integer>{

}
