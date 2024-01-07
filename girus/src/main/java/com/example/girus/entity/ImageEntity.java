package com.example.girus.entity;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;


@Entity
@Table(name="imageEntity")


public class ImageEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String filename;
	
	private String fileType;
	
	@Lob
	@Column(name = "image", length = 100000)
	
    private byte[] data;
	
	@Lob
	@Column(name="audio",length=100000)
	private byte[] audio;
	
	public byte[] getAudio() {
		return audio;
	}

	public void setAudio(byte[] audio) {
		this.audio = audio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public ImageEntity() {
		super();
	}

	public ImageEntity(int id, String filename, String fileType, byte[] data) {
		super();
		this.id = id;
		this.filename = filename;
		this.fileType = fileType;
		this.data = data;
	}

	@Override
	public String toString() {
		return "ImageEntity [id=" + id + ", filename=" + filename + ", fileType=" + fileType + ", data="
				+ Arrays.toString(data) + "]";
	}

	

	

	

	
	

}
