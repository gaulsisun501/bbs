package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUDTest_sjkim {

	Connection con = null;
	Statement statement = null;

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
		CRUDTest_sjkim st = new CRUDTest_sjkim();
		
		st.connect();
		st.insert();
		System.out.println("insert 수행 후");
		st.connect();
		st.select();
		
		st.connect();
		st.update();
		System.out.println("update 수행 후");
		st.connect();
		st.select();

		st.connect();
		st.delete();
		System.out.println("delete 수행 후");
		st.connect();
		st.select();				
	}
	
	public void insert(){
		try {
			Statement statement = con.createStatement();			
			String query = "insert into member1 values('aaa','1111','홍길동','22','서울시','a@a.com')";
			int count = statement.executeUpdate(query);
			if(count > 0) {
				System.out.println("insert success!");
			} else {
				System.out.println("insert fail!");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void select(){
		try {
			Statement statement = con.createStatement();
			String query = "select * from member1";
			ResultSet resultset = statement.executeQuery(query);
			while(resultset.next()) {
				String id = resultset.getString("id");
				String password = resultset.getString("password");
				String name = resultset.getString("name");
				String age = resultset.getString("age");
				String addr = resultset.getString("addr");
				String email = resultset.getString("email");
				System.out.println(id+" : "+password+" : "+name+" : "
				+age+" : "+addr+" : "+email);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void update(){
		try {
			Statement statement = con.createStatement();			
			String query = "update member1 set addr = '부산시' where id = 'aaa'";
			int count = statement.executeUpdate(query);
			if(count > 0) {
				System.out.println("update success!");
			} else {
				System.out.println("update fail!");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}		
	}

	public void delete(){
		try {
			Statement statement = con.createStatement();
			String query = "delete member1 where id = 'aaa'";
			int count = statement.executeUpdate(query);
			if(count > 0) {
				System.out.println("delete success!");
			} else {
				System.out.println("delete fail!");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}		
	}
	

}

//Connection Success!
//insert success!
//insert 수행 후
//Connection Success!
//아이디 : aaa,비밀번호 : 1111,이름 : 홍길동,나이 : 22,주소 : 서울시,이메일 : a@a.com
//Connection Success!
//update success!
//update 수행 후
//Connection Success!
//아이디 : aaa,비밀번호 : 1111,이름 : 홍길동,나이 : 22,주소 : 부산시,이메일 : a@a.com
//Connection Success!
//delete success!
//delete 수행 후
//Connection Success!

