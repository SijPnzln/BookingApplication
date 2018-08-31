package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.demo.models.Image;
import com.example.demo.repository.ImageRepository;

@Transactional
public class ImageService {
	ImageRepository imageRepository;
	
	public ImageService(ImageRepository imageRepository) {
		super();
		this.imageRepository = imageRepository;
	}
	
	//======= TRAVEL SERVICE =======
	//GET/FIND
	public Image getImageById(int imageId) {
		return imageRepository.findById(imageId).get();
	}
	//PUT/UPDATE
	public Image updateImageById(int imageId, Image imageById) {
		if(imageRepository.existsById(imageId)) {
			imageRepository.save(imageById);
		}
 		return imageById;
	}
	//DELETE
	public void deleteImageById(Image imageById) {
		imageRepository.delete(imageById);
	}
	
	
	//======== TRAVEL SERVICE (GROUP) ========
	
	//POST/SAVE
	public List<Image> saveAllImages(List<Image> imageList) {
		return (List<Image>) imageRepository.saveAll(imageList);
	}
	//DELETE
	public void deleteAllImages(int imageId) {
		imageRepository.deleteById(imageId);
	}
	//GET/FIND
	public List<Image> getAllImages() {
		return (List<Image>) imageRepository.findAll();
	}
	//PUT/UPDATE
	public List<Image> updateImages(List<Image> imageList) {
		for(Image imageItem: imageList) {
			if(imageRepository.existsById(imageItem.getImageId())) {
				imageRepository.save(imageItem);
			}
		}
		return imageList;
	}
}
