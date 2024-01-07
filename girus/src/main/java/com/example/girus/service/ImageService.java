package com.example.girus.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.girus.entity.Image;
import com.example.girus.entity.ImageEntity;
import com.example.girus.repository.ImageRepo;
import com.example.girus.repository.ImageRepositroy;

@Service
public class ImageService {

	
	@Autowired 
	private ImageRepositroy imageRepositroy;
	@Autowired
	private ImageRepo imageRepo;
	
//	public String savedata(MultipartFile file) throws IOException {
//		// TODO Auto-generated method stub
//		ModalImage modalImage=new ModalImage();
//		//modalImage.setId(get);
//		modalImage.setData(file.getBytes());
//		
//		imageRepositroy.save(modalImage);
//		if(image!=null)
//		{
//		    status="image add sucessfully add";	
//		}
//		else
//		{
//			status="image add unsucessfully";
//		}
		//return "image add sucessfully";
//	}

	public Optional<ImageEntity> getimagedata(long id) {
		// TODO Auto-generated method stub
	return imageRepositroy.findById(id);
	}
	
	

	public String saveimage(MultipartFile file) throws IOException {
		// TODO Auto-generated method stub
		ImageEntity image=new ImageEntity();
		
		image.setFilename(file.getOriginalFilename());
		image.setFilename(file.getContentType());
		image.setData(file.getBytes());
		
		imageRepositroy.save(image);
			
		return "image add suceessful";
	}
	
	

	public ImageEntity savedata(MultipartFile file,MultipartFile audio, String filename, String fileType) throws IOException {
		// TODO Auto-generated method stub
         ImageEntity image=new ImageEntity();
		image.setData(file.getBytes());
		image.setFilename(filename);
		image.setFileType(fileType);
		image.setAudio(audio.getBytes());
         
		return imageRepositroy.save(image);
		
	}
	

	public Optional<ImageEntity> findById(Long id) {
		// TODO Auto-generated method stub
		return imageRepositroy.findById(id);
	}

	public String deleteById(long id) {
		// TODO Auto-generated method stub
   imageRepositroy.deleteById(id);
		 return "data delecte successfully";
		 
		 
	}



	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}



	public String savedetails(MultipartFile file) throws IOException {
		// TODO Auto-generated method stub
		Image image=new Image();
		image.setImage(file.getBytes());
		 imageRepo.save(image);
		 return "add successfully";
	}



	public Optional<Image> getImage(Long id) {
		// TODO Auto-generated method stub
		return imageRepo.findById(id);
	}

	
	
}
