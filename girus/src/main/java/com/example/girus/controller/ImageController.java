package com.example.girus.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.girus.entity.Image;
import com.example.girus.entity.ImageEntity;
import com.example.girus.service.ImageService;



@RestController
@RequestMapping("/api/image")
public class ImageController {

	@Autowired
	 private ImageService imageService;
	
	@PostMapping("/upload")
    public ImageEntity handleFileUpload(@RequestParam("file") MultipartFile file,@RequestParam("audio") MultipartFile audio,
    		@RequestParam("filename") String filename,@RequestParam("fileType") String fileType) throws IOException 
      {
	
    			
    	 return imageService.savedata(file,audio,filename,fileType);
    	
          }
	
	
	
    @GetMapping("getid/{id}")
    public Optional<ImageEntity> getImageById(@PathVariable Long id) {
    	
//        Optional<ImageEntity> imageOptional = imageService.findById(id);
//        if (imageOptional.isPresent()) {
//            ImageEntity imageEntity = imageOptional.get();
//            return ResponseEntity.ok()
//                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"")
//                    .body(imageEntity.getData());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
        return imageService.findById(id);
		}
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImageById(@PathVariable Long id) {
        if (imageService.existsById(id)) {
        	imageService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("/setdata")
    public String savedetails(@RequestParam("file") MultipartFile file) throws IOException
    {
    	return imageService.savedetails(file);
    }
    
    @GetMapping("/getbyimagebyid/{id}")
    public ResponseEntity<Object> getImage(@PathVariable Long id) {
       // Optional<Image> image = imageService.getImage(id);

//        if (image != null) {
//            return ResponseEntity.ok()
//                    .contentType(MediaType.IMAGE_JPEG) // Adjust the content type based on your image type
//                    .body(image);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
        Optional<Image> optionalImage = imageService.getImage(id);

        if (optionalImage.isPresent()) {
            Image image = optionalImage.get();
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG) // Adjust the content type based on your image type
                    .body(image.getImage());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    
}
