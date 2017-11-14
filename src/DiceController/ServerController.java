package DiceController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JButton;

import DiceView.ServerFrame;
import main.ServerMain;

public class ServerController extends MouseAdapter{
	public void mouseClicked(MouseEvent arg0){
		JButton btn = (JButton) arg0.getSource();
		int port=0;
		if (btn.getText().equals("서버 실행")) {
			try {
				port=Integer.parseInt(ServerFrame.getInstance().portTf.getText()); // 서버프레임에서 포트번호 얻기
			} catch (Throwable t) {
				//port = DEFAULT_PORT; // Set port to 5555
			}

			try {
				// Actually create the server and start it
				ServerFrame.getInstance().sv = new ServerMain(port);
			
			} catch (IOException e) {
				System.out.println("Could not start listening for clients.");
			}

		}
	}
}
