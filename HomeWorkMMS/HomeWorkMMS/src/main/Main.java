package main;

import java.util.Scanner;

import inter.face.Command;
import menus.DeleteCommand;
import menus.GetListCommand;
import menus.GetMemberCommand;
import menus.InsertCommand;
import menus.UpdateCommand;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Command[] com = { new InsertCommand(), new GetListCommand(), new GetMemberCommand(), new UpdateCommand(),
				new DeleteCommand() };

		System.out.println("안녕하세요. 어서오세요^^ 원하시는 메뉴를 고르세요.");
		System.out.println("");

		boolean is = true;
		while (is) {
			int i = 1;
			for (Command list : com) {
				System.out.print(i + ". " + list.toString() + "   ");
				i++;
				if (i == com.length + 1)
					System.out.println(i + ". 종료");
			}
			int menu = Integer.parseInt(sc.nextLine())-1;
			if (menu != com.length) {
				Command c = com[menu];
				if (c != null)
					try {
						c.execute(sc);
					} catch (Exception e) {
						System.out.println("안녕히 계세요..");
						is = false;
						sc.close();
					}
			}
		}
	}

}
