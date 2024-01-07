package com.example.girus.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.girus.entity.ImageEntity;


@Repository
public interface ImageRepositroy  extends JpaRepository<ImageEntity,Long>{

//	String save(ImageEntity image);






}
