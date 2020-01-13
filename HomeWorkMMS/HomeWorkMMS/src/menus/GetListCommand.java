package menus;

import java.util.Scanner;

import inter.face.Command;
import member.MemberDAO;
import member.MemberDTO;

public class GetListCommand implements Command{
	
	public GetListCommand() {}

	@Override
	public void execute(Scanner sc) throws Exception {
		MemberDAO dao = new MemberDAO();
		System.out.println("ID\t\t이름\t\t생년월일");
		for(MemberDTO dto : dao.getList()) {
			System.out.print(dto.getId()+"\t\t");
			System.out.print(dto.getName()+"\t\t");
			System.out.print(dto.getBirth()+"\n");
		}
		System.out.println("");
		System.out.println("");
		
	}

	@Override
	public String toString() {
		return "회원목록";
	}
	
	

}
