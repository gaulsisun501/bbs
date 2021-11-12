package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
	
	Connection con;
	
	static{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver가 없음:: 해당 클래스를 찾을수 없습니다.");
		}
	}
	
	public void connect(){
        try {
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			con = DriverManager.getConnection(url, "javalink", "javalink");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
        System.out.println("Connection Success!");
	}
	
	public static void main(String[] args) {
		ConnectionTest ct = new ConnectionTest();
		ct.connect();
	}
}