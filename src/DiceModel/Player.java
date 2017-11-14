package DiceModel;

import java.io.*;

public class Player {
	private String name;

	public Player() {
		name = null;
	}
	public void setName() {
		FileWriter fout = null;
		try {
			
			fout = new FileWriter("play.txt", true);// 자바 workspace에 있음
			fout.close();
		} catch (IOException e) {
			System.out.println("setName 시스템 오류");
		}
	}
	public void setName(String name) {
		this.name=name;
		FileWriter fout = null;
		try {
			fout = new FileWriter("play.txt", true);// 자바 workspace에 있음
			fout.write("" + name + "\t");
			fout.close();
		} catch (IOException e) {
			System.out.println("setName 시스템 오류");
		}

	}
}