package thiennn.pro.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnect {

	private final String serverName = "LIRUNGHI\\SQLEXPRESS";
	private final String dbName = "LTWEBTUXA";
	private final String portNumber = "1433";
	private final String instance = "";
	private final String userID = "sa";
	private final String password = "Thien@123";

	public Connection getConnection() throws Exception {
		String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance + ";encrypt=true;trustServerCertificate=true;databaseName=" + dbName;
		if (instance == null || instance.trim().isEmpty())
			url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";encrypt=true;trustServerCertificate=true;databaseName=" + dbName;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url, userID, password);
	}
	
	public static void main(String[] args) {
		try {
			
			
			Connection conn = new DBConnect().getConnection();
			// crate statement
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO GiaoVien(id, name, address) "
					+ "VALUES (?, ?, ?)");
			
			stmt.setInt(1, 3);
			stmt.setString(2, "Thien");
			stmt.setString(3, "HCM");

			// insert ‘GiaoVien'
			stmt.execute();
			stmt = conn.prepareStatement("SELECT * FROM GiaoVien");
			// get data from table ‘GiaoVien'
			ResultSet rs = stmt.executeQuery();
			// show data
			while (rs.next()) {
			System.out.println(rs.getInt("id") + " " + rs.getString(2)
			+ " " + rs.getString(3));
			}
			conn.close(); // close connection


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
