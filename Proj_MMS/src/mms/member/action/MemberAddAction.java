package mms.member.action;
//7-1 회원등록 요청 처리하는 Action 클래스 구현
import java.util.Scanner;
import mms.member.svc.MemberAddService;
import mms.member.util.ConsoleUtil;
import mms.member.vo.Member;

public class MemberAddAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		MemberAddService memberAS = new MemberAddService();
		memberAS.addMember(null);
		






	}
}