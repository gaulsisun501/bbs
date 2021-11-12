package mms.member.db;
//1. DB관련 공통 기능 클래스
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
	static{
		//클래스가 로딩될 때 단 한번 호출되는 영역
		//Class.forName : 특정 클래스를 메모리로 로딩하는 메소드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("OracleDriver error!!!");
		}		
	}
	
	public static Connection getConnection(){
		//디비 작업에 필요한 Connection 객체를 생성해 주는 메소드
		Connection con = null;
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		try {
			con = DriverManager.getConnection(url, "javalink", "javalink");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
        System.out.println("Connection Success!");

		return con;
	}
	
	public static void close(Connection con){
		try{
			con.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}


//statement, prepared 닫을 때 쓰겠다. resultset










	
	
	//transaction 처리 메소드
//commit, rollback
	public static void commit(Connection con) {
		try {
			con.commit();//insert,update,delete
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection con) {
		try {
			con.rollback();//insert,update,delete
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	}

