package tech.csm.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtil {

	static Properties p = new Properties();
	static Connection con=null;
	static {
		try (InputStream is = DbUtil.class.getClassLoader().getResourceAsStream("tech/csm/config/db.properties")) {
			p.load(is);
		} catch (IOException ae) {
			System.out.println(ae);
		}
	}
	public static String getDBUrl() {
		return p.getProperty("db.url");
	}
	public static String getUserName() {
		return p.getProperty("db.username");
	}
	public static String getPassword() {
		return p.getProperty("db.password");
	}
	public static Connection getMyConnection() {
		if(con==null) {
			try {
				con=DriverManager.getConnection(getDBUrl(),getUserName(),getPassword());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return con;
	}
	public static void closeMyConnection() {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("no connection is opened");
		}
	}


}
