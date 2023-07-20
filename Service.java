package de.zeroco.album;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.Part;

public class Service {
	
	public static PhotoAlbum storeUploadedPhotoInAlbum(Part part, String directoryPath) {
		String filePath = directoryPath + part.getSubmittedFileName();
		try {
			part.write(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new PhotoAlbum(filePath, part.getSubmittedFileName());
	}
	
	public static PhotoAlbum storeUploadedPhotoInAlbum(Part part, int id, String directoryPath) {
		PhotoAlbum album = storeUploadedPhotoInAlbum(part, directoryPath);
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
	
	public static int getGeneratedKey(PhotoAlbum photoAlbum) {
		return Dao.getGeneratedKey(photoAlbum);
	}
	
	public static int update(PhotoAlbum photoAlbum) {
		return Dao.update(photoAlbum);
	}
	
	public static PhotoAlbum get(int id) {
		return Dao.get(id);
	}
	
	public static PhotoAlbum get(String column, Object value) {
		return Dao.get(column, value);
	}
	
	public static boolean isImageDeleted(int id) {
		File file = new File(Dao.get(id).getFilePath());
		if (file.exists()) {
			if (file.delete()) {
				Dao.delete(id);
				return true;
			}
		}
		return false;
	}

}
