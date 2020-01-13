package sub.menus;

import java.util.Scanner;

import inter.face.Command;
import inter.face.GetMemberCommand;
import member.MemberDAO;
import member.MemberDTO;

public class GetMemberByNameCommand implements GetMemberCommand{
	public GetMemberByNameCommand() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Scanner sc) throws Exception {
		System.out.println("확인할 이름을 입력하세요.");
		String name = sc.nextLine();
		
		MemberDAO dao = new MemberDAO();
		if(dao.isDuplicate("name", name)) {
			MemberDTO dto = dao.getMember("name", name);
			System.out.println("이름\tID\t생년월일");
			System.out.print(dto.getName()+"\t");
			System.out.print(dto.getId()+"\t");
			System.out.print(dto.getBirth()+"\n");
		} else {
			System.out.println(name + "는 없는 이름입니다.");
		}
	}

	@Override
	public String toString() {
		return "이름으로 확인";
	}
	

}
