package p02.scott;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
//scanner에서 key를 받아서 empno=7902인 레코드를 출력
public class EmpEx2 {

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;

        try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			
			//2.계정연결
			connection = DriverManager.getConnection(url, "scott", "scott");
			statement = connection.createStatement();
			
			//3.Query
			Scanner sc = new Scanner(System.in);
			System.out.println("empNo : ");
			int empNo = sc.nextInt();
			String query = "select * from emp where empNo=" + empNo;
			
			//4.실행과 리턴
			ResultSet resultset = statement.executeQuery(query);
			while(resultset.next()) {
				int empno = resultset.getInt(1);
				String ename = resultset.getString(2);
				String job = resultset.getString(3);
				int mgr = resultset.getInt(4);
				Date hiredate = resultset.getDate(5);//getDate() 메소드 사용
				String sal = resultset.getString(6);
				String comm = resultset.getString(7);
				String deptno = resultset.getString(8);
				System.out.println(empno+" : "+ename+" : "+job+" : "+mgr+" : "
				+hiredate+" : "+sal+" : "+comm+" : "+deptno);
			}
			//5.DB종료
			resultset.close();
			connection.close();
			statement.close();
			
			
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
