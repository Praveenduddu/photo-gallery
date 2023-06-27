package de.zeroco.album;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import de.zeroco.jdbc.DBUtil;
import de.zeroco.servlets.Customer;
import de.zeroco.util.Utility;

public class Dao {

	public static final String SCHEMA = "zerocode";
	public static final String TABLE_NAME = "photo_album";
	public static final String[] COLUMNS = {"file_location"};
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
		List<PhotoAlbum> users = null;
		Connection connection = Utility.getConnection(DBUtil.URL, DBUtil.USER, DBUtil.PASSWORD, SCHEMA);
		users = getListOfObjectFromListOfMaps(DBUtil.list(SCHEMA, TABLE_NAME, Arrays.asList(), connection));
		Utility.closeConnection(connection);
		return users;
	}
	
	public static List<PhotoAlbum> getListOfObjectFromListOfMaps(List<Map<String, Object>> list) {
		List<PhotoAlbum> users = new ArrayList<>();
		for (Map<String, Object> map : list) {
			users.add(new PhotoAlbum((int) map.get(CONDITION_COLUMN),(String) map.get(COLUMNS[0])));
		}
		return users;
	}
	
	public static List<Object> getListFromObject(PhotoAlbum photoAlbum) {
		List<Object> values = new ArrayList<Object>();
		values.add(photoAlbum.getFilePath());
		return values;
	}
}
