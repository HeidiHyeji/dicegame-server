package DiceModel;

import java.io.FileWriter;
import java.io.IOException;

public class DiceGame {
	//싱글톤 패턴
	private static DiceGame diceGame = null;

	public static DiceGame getInstance() {
		if (diceGame == null) {
			diceGame = new DiceGame();
		}
		return diceGame;
	}
	/////////////////////////////////////////////////////////////
	public void diceGameReset(){
		die1.faceValue=0;
		die2.faceValue=0;
		score = 0;
		turn = 0;
	}

	public Die die1;
	public Die die2;
	public int score = 0;
	public int turn = 0;

	public DiceGame() {
		die1 = new Die();
		die2 = new Die();
		score = 0;
		turn = 0;
	}

	public void play() {// 메인-play버튼-리스너-클릭시실행
		++turn;
		die1.faceValue = die1.roll();
		die2.faceValue = die2.roll();
		if (die1.faceValue + die2.faceValue == 7) {
			score += 10;
		}
		
	}

	public int getScore() {
		return score;
	}

	public void setScore() {
		FileWriter fout = null;
		try {
			fout = new FileWriter("play.txt", true);// 자바 workspace에 있음
			fout.write(score + "\r\n");
			fout.close();
		} catch (IOException e) {
			System.out.println("setScore 시스템 오류");
		}
	}
}
