package p01.db_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//CRUD: Create Read Update Delete
//ResultSet	executeQuery(String sql) : select문 사용시
//int	executeUpdate(String sql) : insert, update, delete문 사용시
public class CRUDConnection {

	public static void main(String[] args) {
		Connection connection = null;//Connection 연결하는 인터페이스
		Statement statement = null;
        try {
			//Class.forName("java.lang.String");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			
			connection = DriverManager.getConnection(url, "javalink", "javalink");
			statement = connection.createStatement();
			String query = "select * from goodsinfo";
			ResultSet resultset = statement.executeQuery(query);
			while(resultset.next()) {
				String code = resultset.getString(1);
				String name = resultset.getString("name");
				String price = resultset.getString(3);
				String maker = resultset.getString("maker");
				System.out.println(code+" : "+name+" : "+price+" : "+maker);
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
