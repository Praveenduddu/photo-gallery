package de.zeroco.album;

public class PhotoAlbum {

	private int id;
	private String filePath;
	private String fileName;

	public PhotoAlbum(String filePath, String fileName) {
		this.filePath = filePath;
		this.fileName = fileName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PhotoAlbum() {
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public PhotoAlbum(int id, String filePath, String fileName) {
		this.id = id;
		this.filePath = filePath;
		this.fileName = fileName;
	}
}
