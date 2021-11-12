package p01.db_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection_Insert {
	
	public static void main(String[] args) {
		Connection connection = null;//Connection 연결하는 인터페이스
		Statement statement = null;
        try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			
			connection = DriverManager.getConnection(url, "javalink", "javalink");
			statement = connection.createStatement();
			String query = "insert into goodsinfo values('33333','OLED TV2',435000,'LG2')";
			int count = statement.executeUpdate(query);
			if(count > 0) {
				System.out.println("데이터가 저장되었습니다.");
			} else {
				System.out.println("데이터가 저장되지 않았습니다.");
			}
			
        } catch (ClassNotFoundException e) {
			System.out.println("Driver가 없음:: 해당 클래스를 찾을수 없습니다.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
        System.out.println("정상종료");
        try {
			connection.close();
		} catch (SQLException e) {
			
		}
		
		
	}
}
