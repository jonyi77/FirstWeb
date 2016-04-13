package ua.service.impl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileWriterService {
	
	public String writeFile(String directory, String articleId, MultipartFile file){
		File relativePath = new File("C:/Users/Iron/git/FirstWeb/SprCVM/src/main/webapp/resources"+directory);
		try{
			BufferedImage bi = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
			if(file.getOriginalFilename().endsWith(".jpeg")){
				relativePath = new File(relativePath+File.separator+String.valueOf(articleId)+".jpeg");
				ImageIO.write(bi, "jpeg", relativePath);
				return String.valueOf(relativePath);
			} else if(file.getOriginalFilename().endsWith(".jpg")){
				relativePath = new File(relativePath+File.separator+String.valueOf(articleId));
				File path = new File(String.valueOf(articleId)+".jpg");
				ImageIO.write(bi, "jpg", path);
				return String.valueOf(relativePath);
			}
		} catch (IOException e){
			e.printStackTrace();
		}
		return null;
	}

}
