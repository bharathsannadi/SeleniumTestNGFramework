package com.testngframework.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBConnection {

	public Connection connectDB() throws SQLException, ClassNotFoundException {
		Class.forName("DBDriver");
		Connection con = DriverManager.getConnection("URL", "UserName",
				"Password");
		return con;
	}

	public List<Map<String, String>> SQLQuery(String query)
			throws SQLException, ClassNotFoundException {

		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Connection con = connectDB();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);

		ResultSetMetaData meta = rs.getMetaData();
		while (rs.next()) {
			Map<String, String> map = new HashMap<String, String>();
			for (int i = 1; i <= meta.getColumnCount(); i++) {
				String key = meta.getColumnName(i);
				String value = rs.getString(key);
				map.put(key, value);
			}
			list.add(map);
		}
		return list;
	}

}
