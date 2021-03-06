package mms.member.ui;
//3. 사용자가 메뉴를 선택할수 있는 화면을 구성해 주는 클래스
import java.util.Scanner;
import mms.member.action.Action;
import mms.member.action.MemberAddAction;
import mms.member.action.MemberListAction;
import mms.member.action.MemberModifyAction;
import mms.member.action.MemberRemoveAction;
import mms.member.controller.MemberController;

public class MemberUI {
	public static void main(String[] args) throws Exception {

		boolean isStop = false;
		MemberController memberController = new MemberController();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("1.회원등록\n2.회원등록보기\n3.회원정보수정\n4.회원정보삭제\n5.프로그램종료\n메뉴번호 : ");
			Action action = null;
			
			switch(sc.nextInt()) {
			case 1:
				action = new MemberAddAction();
				memberController.processRequest(action,sc);
				break;
			case 2:
				action = new MemberListAction();
				memberController.processRequest(action,sc);
				break;
			case 3:
				action = new MemberModifyAction();
				memberController.processRequest(action,sc);
				break;
			case 4:
				action = new MemberRemoveAction();
				memberController.processRequest(action,sc);
				break;
			case 5:
				isStop = true;
				break;	
			default:
				System.out.println("다시 입력하기");
			}
		} while (!isStop);
	}
}

