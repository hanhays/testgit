package sub.menus;

import java.util.Scanner;
import inter.face.GetMemberCommand;
import member.MemberDAO;
import member.MemberDTO;

public class GetMemberByBirthCommand implements GetMemberCommand{
	public GetMemberByBirthCommand() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Scanner sc) throws Exception {
		System.out.println("확인하고 싶은 생년월일을 입력해보세요.");
		String birth = sc.nextLine();
		
		MemberDAO dao = new MemberDAO();
		if (dao.isDuplicate("birth", birth)) {
			MemberDTO dto = dao.getMember("birth", birth);
			System.out.println("생년월일\tID\t이름");
			System.out.print(dto.getBirth()+"\t");
			System.out.print(dto.getId()+"\t");
			System.out.print(dto.getName()+"\n");
		} 
	}

	@Override
	public String toString() {
		return "생년월일로 확인";
	}
	
}
