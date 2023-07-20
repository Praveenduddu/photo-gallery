package de.zeroco.album;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import de.zeroco.jdbc.DBUtil;
import de.zeroco.util.Utility;

public class Dao {

	public static final String SCHEMA = "zerocode";
	public static final String TABLE_NAME = "photo_album";
	public static final String[] COLUMNS = {"file_location", "file_name"};
	public static final String CONDITION_COLUMN = "pk_id";
	public static final String ASSIGN_OPERATOR = "=";
	
	public static int getGeneratedKey(PhotoAlbum photoAlbum) {
		List<Object> values = getListFromObject(photoAlbum);
		int genereatedKey = 0;
		Connection connection = Utility.getConnection(DBUtil.URL, DBUtil.USER, DBUtil.PASSWORD, Dao.SCHEMA);
		genereatedKey = DBUtil.getGeneratedKey(SCHEMA, TABLE_NAME, Arrays.asList(COLUMNS), values, connection);
		Utility.closeConnection(connection);
		return genereatedKey;
	}
	
	public static List<PhotoAlbum> list() {
		List<PhotoAlbum> photos = null;
		Connection connection = Utility.getConnection(DBUtil.URL, DBUtil.USER, DBUtil.PASSWORD, SCHEMA);
		photos = getListOfObjectFromListOfMaps(DBUtil.list(SCHEMA, TABLE_NAME, Arrays.asList(), connection));
		Utility.closeConnection(connection);
		return photos;
	}
	
	public static int delete(int id) {
		int numOfRowsUpdate = 0;
		Connection connection = Utility.getConnection(DBUtil.URL, DBUtil.USER, DBUtil.PASSWORD, SCHEMA);
		numOfRowsUpdate = DBUtil.delete(SCHEMA, TABLE_NAME, CONDITION_COLUMN, id, connection);
		Utility.closeConnection(connection);
		return numOfRowsUpdate;
	}
	
	public static PhotoAlbum get(String column, Object value) {
		PhotoAlbum photos = null;
		Connection connection = Utility.getConnection(DBUtil.URL, DBUtil.USER, DBUtil.PASSWORD, SCHEMA);
		photos = getObjectFromListOfMaps(DBUtil.gets(SCHEMA, TABLE_NAME, Arrays.asList(), column, ASSIGN_OPERATOR, value, connection));
		Utility.closeConnection(connection);
		return photos;
	}
	
	public static PhotoAlbum get(int id) {
		return get(CONDITION_COLUMN, id);
	}
	
	public static int update(PhotoAlbum photoAlbum) {
		List<Object> values = getListFromObject(photoAlbum);
		int numOfRowsUpdate = 0;
		Connection connection = Utility.getConnection(DBUtil.URL, DBUtil.USER, DBUtil.PASSWORD, SCHEMA);
		numOfRowsUpdate = DBUtil.update(SCHEMA, TABLE_NAME, Arrays.asList(COLUMNS), values, Dao.CONDITION_COLUMN, photoAlbum.getId(), connection);
		Utility.closeConnection(connection);
		return numOfRowsUpdate;
	}
	
	public static List<PhotoAlbum> getListOfObjectFromListOfMaps(List<Map<String, Object>> list) {
		List<PhotoAlbum> photos = new ArrayList<>();
		for (Map<String, Object> map : list) {
			photos.add(new PhotoAlbum((int) map.get(CONDITION_COLUMN),(String) map.get(COLUMNS[0]), (String) map.get(COLUMNS[1])));
		}
		return photos;
	}
	
	public static List<Object> getListFromObject(PhotoAlbum photoAlbum) {
		List<Object> values = new ArrayList<Object>();
		values.add(photoAlbum.getFilePath());
		values.add(photoAlbum.getFileName());
		return values;
	}
	
	public static PhotoAlbum getObjectFromListOfMaps(List<Map<String, Object>> list) {
		for (Map<String, Object> map : list) {
			return new PhotoAlbum((int) map.get(CONDITION_COLUMN),(String) map.get(COLUMNS[0]), (String) map.get(COLUMNS[1]));
		}
		return null;
	}
	
}
