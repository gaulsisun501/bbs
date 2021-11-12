package test3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SampleDAO {

	public ArrayList<SampleDTO> findAll() {
		// DTO를 저장하는 리스트
		ArrayList<SampleDTO> sampleDTOs = new ArrayList<SampleDTO>();
	
        try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			
			Connection connection = DriverManager.getConnection(url, "javalink", "javalink");
			Statement statement  = connection.createStatement();
			String query = "select * from book";
			ResultSet resultset = statement.executeQuery(query);

			while(resultset.next()) {
				String id = resultset.getString(1);
				String name = resultset.getString(2);
				int price = resultset.getInt(3);
				sampleDTOs.add(new SampleDTO(id,name,price));
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Driver가 없음:: 해당 클래스를 찾을수 없습니다.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} 
		return sampleDTOs;
	}
}
