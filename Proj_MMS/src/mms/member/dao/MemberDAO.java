package mms.member.dao;
//9. Oracle DB로 필요한 SQL구문을 전송하는 클래스 구현
import static mms.member.db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import mms.member.vo.Member;

public class MemberDAO {
	
	Connection con;
	public MemberDAO(Connection con) {
		this.con = con;
	}
	
	public int insertNewMember(Member newMember) {

		String sql = "insert~~~"









		
		return 0;	
	}
	
	public ArrayList<Member> selectMemberList() {








		
		
	}
	
	public Member selectOldMember(String name) {













		
	
	}
	
	public int updateMember(Member updateMember) {








		
		
	}
	
	public int deleteMember(String name) {








		
		
	}
}