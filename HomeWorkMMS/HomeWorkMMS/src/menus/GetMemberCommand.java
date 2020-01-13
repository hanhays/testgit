package menus;

import java.util.Scanner;

import inter.face.Command;
import sub.menus.GetMemberByBirthCommand;
import sub.menus.GetMemberByIdCommand;
import sub.menus.GetMemberByNameCommand;

public class GetMemberCommand implements Command{
	
	public GetMemberCommand() {}

	@Override
	public void execute(Scanner sc) throws Exception {
		inter.face.GetMemberCommand[] gc = { new GetMemberByIdCommand(),
								   			 new GetMemberByNameCommand(),
								   			 new GetMemberByBirthCommand() };
		boolean is = true;
		while(is){
			int i = 1;
			for (inter.face.GetMemberCommand list : gc) {
				System.out.print(i+". " +list+"     ");
				i++;
				if (i == gc.length+1) {
					System.out.println(i+". 처음으로");
				}
			}
			int menu = Integer.parseInt(sc.nextLine())-1;
			try {
				gc[menu = gc.length != menu? menu:gc.length+1].execute(sc);
			} catch (Exception e) {
				System.out.println("처음으로..");
				is=false;
				return;
			}
//			if (menu != gc.length) {
//				inter.face.GetMemberCommand gm = gc[menu];
//				if(gm != null)
//					try {
//						gm.execute(sc);
//					} catch (Exception e) {
//						System.out.println("처음으로..");
//						flag = false;
//					}
//			} 
		}	
	}

	@Override
	public String toString() {
		return "회원확인";
	}
	
	
}
