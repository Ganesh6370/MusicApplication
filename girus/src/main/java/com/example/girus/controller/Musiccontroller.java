package com.example.girus.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.girus.entity.Musicentity;
import com.example.girus.entity.Song;
import com.example.girus.service.Musicservice;

import jakarta.annotation.Resource;



@RestController
@RequestMapping("/music")

public class Musiccontroller {
	
	@Autowired
	private Musicservice musicservice;
	
	
	
	@PostMapping("/addsong")
	public Musicentity musicmethod(@RequestParam("musictitle")String musictitle,
			@RequestParam("artist")String artist,@RequestParam("lyrics")String lyrics
			,@RequestParam("albumname")String albumname,@RequestParam("song")MultipartFile song,
			@RequestParam("songImage")MultipartFile songImage) throws IOException
	{
		return musicservice.savemusicdata(musictitle,artist,lyrics,albumname,song,songImage);
	}
	
	@GetMapping("getmusic/{id}")
	public Optional<Musicentity> getdetails(@PathVariable long id)
	{
		return musicservice.getdata(id);
		
	}
	
	@PostMapping("/addmusic")
	public String addsong(@RequestParam("file")MultipartFile file) throws IOException 	
	{
//		String uploadDirectory = "D:/Users/Durga Prasad/Downloads/Almost-Padipoya-Pilla(PaglaSongs).mp3";
//		File directory = new File(uploadDirectory);
//
//		if (!directory.exists()) {
//		    boolean created = directory.mkdirs();
//		    if (!created) {
//		        // Handle the case where the directory creation failed
//		        System.out.println("Failed to create the directory: " + uploadDirectory);
//		    }
//		}
//
//		String fileName = "song_" + System.currentTimeMillis() + ".mp3";
//		file.transferTo(new File(uploadDirectory + fileName));

//		 String fileName = "song_" + System.currentTimeMillis() + ".mp3";
//         file.transferTo(new File("/path/to/uploaded/files/" + fileName));

		return musicservice.savedata(file);
	}
	
//	@GetMapping("/download-song")
//    public ResponseEntity<ByteArrayResource> downloadSong(@PathVariable long id) throws IOException
//	{
//        // Replace "path/to/your/song.mp3" with the actual path to your song file
//	
//        java.nio.file.Path songPath = Paths.get("/download/");
//        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(songPath));
//
//        return ResponseEntity
//                .ok()
//                .contentLength(songPath.toFile().length())
//                .header("Content-Disposition", "attachment filename=" + songPath.getFileName().toString())
//                .contentType(MediaType.APPLICATION_OCTET_STREAM)
//                .body(resource);
//    }

	
//    @GetMapping("/getbysong/{id}")
//    public ResponseEntity<Resource> getSongById(@PathVariable Long id) throws IOException {
//        // Fetch the song information from the database based on the given ID
//        Song song = musicservice.getSongById(id);
//
//        if (song == null) {
//            // Return a 404 Not Found response if the song is not found
//            return ResponseEntity.notFound().build();
//        }
//
//        // Use the fetched file path to create a Path object
//        Path songPath = Paths.get(song.getFilePath());
//
//        // Continue with the rest of the code
//        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(songPath));
//
//        return ResponseEntity
//                .ok()
//                .contentLength(((java.nio.file.Path) songPath).toFile().length())
//                .header("Content-Disposition", "attachment; filename=" + songPath.getFileName().toString())
//                .contentType(MediaType.APPLICATION_OCTET_STREAM)
//                .body(resource);
//    }
	
//    @GetMapping(value = "getsongbyid/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
//    public String getSongById(@PathVariable Long id) {
//        // Fetch the song information from the database based on the given ID
//        if (song == null || song.getFile() == null) {
//            // Return a 404 Not Found response if the song or song data is not found
//            return ResponseEntity.notFound().build();
//        }

        // Continue with the rest of the code
      //  byte[] songData = song.getFile();

//        return ResponseEntity
//                .ok()
//                .contentLength(songData.length)
//                .header("Content-Disposition", "attachment; filename=song.mp3")
//                .contentType(MediaType.APPLICATION_OCTET_STREAM)
//                .body(songData);
        
       // return  musicservice.getSongById(id);
//    	
//        Song song = musicservice.getSongById(id);
//
//        
//        if (song != null ) {
//            // Assuming the con	tent is text-based (lyrics), convert byte[] to String
//            return new String(song.getFile(), StandardCharsets.UTF_8);
//        } else {
//            // Handle the case when the song or its content is not found
//            return "Song not found";
//        }
        
//    	@GetMapping(value = "getsongbyid/{id}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
//        public ResponseEntity<ByteArrayResource> getSongFile(@PathVariable Long id) {
//            Song song = musicservice.getSongById(id);
//
//            if (song != null && song.getFile() != null) {
//                ByteArrayResource resource = new ByteArrayResource(song.getFile());
//                return ResponseEntity
//                    .ok()
//                    .contentLength(song.getFile().length)
//                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + song.getId())
//                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
//                    .body(resource);
//            } else {
//                return ResponseEntity.notFound().build();
//            }
//        
//	@GetMapping("/download/{id}")
//    public ResponseEntity<byte[]> downloadMp3() {
//        // Replace this path with the actual path to your MP3 file
//        String mp3FilePath = "/download/";
//
//        try {
//            java.nio.file.Path path = (java.nio.file.Path) Paths.get(mp3FilePath);
//            byte[] mp3Bytes = Files.readAllBytes(path);
//
//            return ResponseEntity.ok()
//                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
//                    .body(mp3Bytes);
//        } catch (Exception e) {
//            // Handle exceptions appropriately (e.g., file not found, IO error)
//            return ResponseEntity.status(500).body(null);
//        }
//    }
    
//    @GetMapping(value = "/getsongbyid/{id}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
//    public ResponseEntity<byte[]> downloadSong(@PathVariable Long id) 
//    {
//        try {
//            Song song = musicservice.findById(id).orElse(null);
//
//            if (song != null) {
//                // Replace this logic with your actual file reading logic
//                byte[] songBytes = readSongBytes(song.getFile());
//
//                return ResponseEntity.ok()
//                        .contentType(MediaType.APPLICATION_OCTET_STREAM)
//                        .body(songBytes);
//            } else {
//                return ResponseEntity.notFound().build();
//            }
//        } catch (Exception e) {
//            // Handle exceptions appropriately
//            return ResponseEntity.status(500).body(null);
//        }
//    }
//    
//   
//
////	private byte[] readSongBytesFromFile(String filePath) {
////        // Replace this with your actual logic to read the song file
////        // Example: Files.readAllBytes(Paths.get(filePath))
////		return filePath.getBytes(); 
////
////    }
//    
//    private byte[] readSongBytes(byte[] content) {
//        // Replace this with your actual logic if needed
//        return content; // Placeholder example, replace with actual logic
//    }
//    
//    
//    @GetMapping(value = "/getsong/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
//    public ResponseEntity<String> downloadSong1(@PathVariable Long id) {
//        try {
//            Song song = musicservice.findById(id).orElse(null);
//
//            if (song != null) {
//                byte[] songBytes = readSongBytes(song.getFile()); // Assuming content is a byte[]
//                String base64Data = Base64.getEncoder().encodeToString(songBytes);
//
//                return ResponseEntity.ok()
//                        .contentType(MediaType.TEXT_PLAIN)
//                        .body(base64Data);
//            } else {
//                return ResponseEntity.notFound().build();
//            }
//        } catch (Exception e) {
//            e.printStackTrace(); // Log the exception or handle it according to your needs
//            return ResponseEntity.status(500).body(null);
//        }
//    }
//
//    // Adjust the parameter type to byte[] if you're dealing with byte[] content directly
//    private byte[] readSongBytes1(byte[] content) {
//        // Replace this with your actual logic if needed
//        return content; // Placeholder example, replace with actual logic
//    }
//
//
//
//
//
	
////    @GetMapping(value = "/getsong2/{id}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
////    public ResponseEntity<Object> downloadSong(@PathVariable Long id) {
////        try {
////            Song song = musicservice.findById(id).orElse(null);
////
////            if (song != null) {
////                byte[] songBytes = readSongBytes(song.getFile()); // Assuming content is a byte[]
////
////                HttpHeaders headers = new HttpHeaders();
////                headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
////                headers.setContentDispositionFormData("attachment", "song.mp3");
////
////                return new ResponseEntity<>(songBytes, headers, org.springframework.http.HttpStatus.OK);
////            } else {
////                return ResponseEntity.notFound().build();
////            }
////        } catch (Exception e) {
////            e.printStackTrace(); // Log the exception or handle it according to your needs
////            return ResponseEntity.status(500).body(null);
////        }
////    }
//
//    // Adjust the parameter type to byte[] if you're dealing with byte[] content directly
//    private byte[] readSongBytes(byte[] content) {
//        // Replace this with your actual logic if needed
//        return content; // Placeholder example, replace with actual logic
//    }
	
    @GetMapping(value = "/getsong3/{id}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<ByteArrayResource> downloadSong(@PathVariable Long id) {
        try {
            Song song = musicservice.findById(id).orElse(null);

            if (song != null) {
                byte[] songBytes = readSongBytes(song.getFile()); // Assuming content is a byte[]

                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.parseMediaType("audio/mpeg"));
                headers.setContentDispositionFormData("attachment", "song.mp3");

                ByteArrayResource resource = new ByteArrayResource(songBytes);

                return ResponseEntity.ok()
                        .headers(headers)
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception or handle it according to your needs
            return ResponseEntity.status(500).body(null);
        }
    }

    // Adjust the parameter type to byte[] if you're dealing with byte[] content directly
    private byte[] readSongBytes(byte[] content) {
        // Replace this with your actual logic if needed
        return content; // Placeholder example, replace with actual logic
    }






    

}
    	
    	
    	


	
	
	
	
	

	



