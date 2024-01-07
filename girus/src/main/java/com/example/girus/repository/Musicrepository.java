package com.example.girus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.example.girus.entity.Musicentity;

@Repository
public interface Musicrepository extends JpaRepository<Musicentity, Long> {

	String save(String fileName);

	String save(MultipartFile file);

	

}
