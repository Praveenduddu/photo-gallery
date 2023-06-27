package de.zeroco.album;

public class PhotoAlbum {

	private int id;
	private String filePath;

	public PhotoAlbum(String filePath) {
		this.filePath = filePath;
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

	public PhotoAlbum(int id, String filePath) {
		this.id = id;
		this.filePath = filePath;
	}
}
