package com.example.girus.service;

import java.io.IOException;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.girus.entity.Musicentity;
import com.example.girus.entity.Song;
import com.example.girus.music.Music;
import com.example.girus.repository.Musicrepository;
import com.example.girus.repository.SongRepository;

@Service
public class Musicservice {
	
    @Autowired 
	private Musicrepository musicrepository;
    
    @Autowired
    private SongRepository songRepository;
    
	public String savemusicdata(Music music) {
		
		Musicentity musicentity=new Musicentity();
			
		musicentity.setId(music.getId());
		musicentity.setMusictitle(music.getMusictitle());
		musicentity.setArtist(music.getArtist());
		musicentity.setLyrics(music.getLyrics());
		musicentity.setAlbumname(music.getAlbumname());
		
		Musicentity savedetails=musicrepository.save(musicentity);
		
		
		 String status=null;
			if(savedetails==null)
			{
				status="data not insert ";
			}
			else
			{
				status="data insert sucessfull";
			}
			return status;

		
	
	}
	public Optional<Musicentity> getdata(long id) {
		// TODO Auto-generated method stub
		return musicrepository.findById(id);
	}
	
	public Musicentity savemusicdata(String musictitle, String artist, String lyrics, String albumname, MultipartFile song,
			MultipartFile songImage) throws IOException {
		// TODO Auto-generated method stub
		Musicentity musicentity=new Musicentity();
		musicentity.setMusictitle(musictitle);
		musicentity.setArtist(artist);
		musicentity.setLyrics(lyrics);
		musicentity.setAlbumname(albumname);
		musicentity.setSong(song.getBytes());
		musicentity.setSongImage(songImage.getBytes());
		
		
		return musicrepository.save(musicentity);
	}
	public String savedata(MultipartFile file) throws IOException {
		// TODO Auto-generated method stub
		Song song=new Song();
		song.setFile(file.getBytes());
		songRepository.save(song);
		 return "song add successfully";
	}
	public Song getSongById(Long id) {
		// TODO Auto-generated method stub
		return songRepository.findById(id).orElse(null);
	}
	public Optional<Song> findById(Long id) {
		// TODO Auto-generated method stub
		return songRepository.findById(id);
	}
	
}
