package de.zeroco.album;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.servlet.http.Part;

public class Service {
	
	public static PhotoAlbum service(Part part) {
		String fileName = "C:\\Users\\91834\\Desktop\\Projects\\photo-album\\WebContent\\images\\" + part.getSubmittedFileName();
		try {
			part.write(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new PhotoAlbum(fileName);
	}

	public static BufferedImage getImage(String filePath) {
		BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
	      try {
			image = ImageIO.read(new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
	
	public static List<PhotoAlbum> list() {
		return Dao.list();
	}
	
	public static int getGeneratedKey(Part filePart) {
		return Dao.getGeneratedKey(Service.service(filePart));
	}
	
}
