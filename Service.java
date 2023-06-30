package de.zeroco.album;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.Part;

public class Service {
	
	public static PhotoAlbum storeUploadedPhotoInAlbum(Part part) {
		String fileName = "C:\\Users\\91834\\Desktop\\Projects\\photo-album\\WebContent\\images\\" + part.getSubmittedFileName();
		try {
			part.write(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new PhotoAlbum(fileName, part.getSubmittedFileName());
	}
	
	public static PhotoAlbum storeUploadedPhotoInAlbum(Part part, int id) {
		PhotoAlbum album = storeUploadedPhotoInAlbum(part);
		album.setId(id);
		return album;
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
		return Dao.getGeneratedKey(Service.storeUploadedPhotoInAlbum(filePart));
	}
	
	public static int update(Part part, int id) {
		return Dao.update(Service.storeUploadedPhotoInAlbum(part, id));
	}
	
	public static List<PhotoAlbum> get(int id) {
		return Dao.get(id);
	}
	
	public static List<PhotoAlbum> get(String column, Object value) {
		return Dao.get(column, value);
	}
	
	public static boolean isImageDeleted(int id) {
		File file = new File(Dao.get(id).get(0).getFilePath());
		if (file.exists()) {
			if (file.delete()) {
				Dao.delete(id);
				return true;
			}
		}
		return false;
	}

}
