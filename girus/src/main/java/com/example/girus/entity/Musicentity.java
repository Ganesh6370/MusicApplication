package com.example.girus.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="music")
public class Musicentity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name="id")
	 int id;
	
	@Column(name="musictitle")
	String musictitle;
	
	@Column(name="artist")
	String artist;
	
	@Column(name="lyrics")
	String lyrics;
	
	@Column(name="albumname")
	String albumname;
	
	@Lob
	@Column(name = "song",  length = 100000)
    private byte[] song;
	
	@Lob
	@Column(name="songImage", length=100000)
	public byte[] songImage;
	
	
	

	public byte[] getSong() {
		return song;
	}
	public void setSong(byte[] song) {
		this.song = song;
	}
	public byte[] getSongImage() {
		return songImage;
	}
	public void setSongImage(byte[] songImage) {
		this.songImage = songImage;
	}
	public String getMusictitle() {
		return musictitle;
	}
	public void setMusictitle(String musictitle) {
		this.musictitle = musictitle;
	}
	public String getArtist() {
		return artist;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getLyrics() {
		return lyrics;
	}
	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}
	public String getAlbumname() {
		return albumname;
	}
	public void setAlbumname(String albumname) {
		this.albumname = albumname;
	}


}
