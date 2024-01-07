package com.example.girus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.example.girus.entity.Song;

@Repository
public interface SongRepository extends JpaRepository<Song, Long>{

	void save(MultipartFile file);

}
