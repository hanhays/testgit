package menus;

import java.util.Scanner;

import inter.face.Command;
import member.MemberDAO;
import member.MemberDTO;

public class UpdateCommand implements Command {

	public UpdateCommand() {
	}

	@Override
	public void execute(Scanner sc) throws Exception {
		System.out.println("정보 수정을 위해 ID를 입력해주세요.");
		String id = sc.nextLine();
		System.out.println("이름을 수정하세요.");
		String name = sc.nextLine();
		System.out.println("생년월일을 고쳐주세요.('YYYY-MM-DD')");
		String birth = sc.nextLine();

		MemberDAO dao = new MemberDAO();
		dao.update(new MemberDTO(id, name, birth));
	}

	@Override
	public String toString() {
		return "정보수정";
	}
}
