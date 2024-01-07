package com.example.girus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.girus.entity.Image;

@Repository
public interface ImageRepo extends JpaRepository<Image, Long>{

}
