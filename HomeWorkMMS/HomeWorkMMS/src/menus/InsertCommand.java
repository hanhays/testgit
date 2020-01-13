package menus;

import java.util.Scanner;

import inter.face.Command;
import member.MemberDAO;
import member.MemberDTO;

public class InsertCommand implements Command{
	
	public InsertCommand() {}

	@Override
	public void execute(Scanner sc) throws Exception {
		MemberDAO dao = new MemberDAO();
		
		System.out.println("가입을 위해 Id를 입력하세요.");
		String id = sc.nextLine();
		
		boolean result = dao.isDuplicate("id", id);
		if (!result) {
			System.out.println("이름을 입력하세요.");
			String name = sc.nextLine();
			System.out.println("YYYY-MM-DD 형식으로 생년월일을 입력하세요.");
			String birth = sc.nextLine();
			
			dao.insert(new MemberDTO(id, name, birth));
		} else {
			System.out.println("이미 존재하는 ID입니다.");
			
			System.out.println("1. 다시 입력     2. 초기메뉴");
			int menu = Integer.parseInt(sc.nextLine());
			if(menu==1) execute(sc);
			else return;
		}
	}

	@Override
	public String toString() {
		return "가입";
	}
	
}
