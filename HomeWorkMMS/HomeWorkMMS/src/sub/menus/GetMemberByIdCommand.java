package sub.menus;

import java.util.Scanner;

import inter.face.Command;
import inter.face.GetMemberCommand;
import member.MemberDAO;
import member.MemberDTO;

public class GetMemberByIdCommand implements GetMemberCommand{
	public GetMemberByIdCommand() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Scanner sc) throws Exception {
		System.out.println("확인할 ID를 입력하세요.");
		String id = sc.nextLine();
		
		MemberDAO dao = new MemberDAO();
		if (dao.isDuplicate("id", id)) {
			MemberDTO dto = dao.getMember("id", id);
			System.out.println("ID\t이름\t생년월일");
			System.out.print(dto.getId()+"\t");
			System.out.print(dto.getName()+"\t");
			System.out.print(dto.getBirth()+"\n");
		} else {
			System.out.println(id + "는 미가입 ID입니다.");
		}
	}

	@Override
	public String toString() {
		return "ID로 확인";
	}
	
}
