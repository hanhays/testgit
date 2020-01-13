package menus;

import java.util.Scanner;

import inter.face.Command;
import member.MemberDAO;

public class DeleteCommand implements Command{
	
	public DeleteCommand() {}

	@Override
	public void execute(Scanner sc) throws Exception {
		System.out.println("삭제할 ID를 입력하세요.");
		String id = sc.nextLine();
		
		MemberDAO dao = new MemberDAO();
		boolean flag = dao.isDuplicate("id", id);
		if(flag) dao.delete(id);
		else {
			System.out.println(id + "는 없는 ID입니다.");
			System.out.println("1. 다시 입력   2. 처음으로..");
			int menu = Integer.parseInt(sc.nextLine());
			if (menu ==1) execute(sc);
			else return;
		}
	}

	@Override
	public String toString() {
		return "삭제 및 탈퇴";
	}
	
	
}
