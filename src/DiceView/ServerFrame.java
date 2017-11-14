package DiceView;

import java.awt.*;
import java.net.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import DiceController.ServerController;
import main.ServerMain;

public class ServerFrame extends JFrame {

	private static ServerFrame serverFrame = null;

	private JPanel contentPane;
	private static JScrollPane js = null;
	public JTextField portTf; // 사용할 PORT번호 입력
	private JButton StartBt; // 서버를 실행시킨 버튼
	public JTextArea serverTa; // 클라이언트 및 서버 메시지 출력
	JLabel portLb;

	private ServerSocket socket; // 서버소켓
	private Socket soc; // 연결소켓
	public ServerMain sv;
	private Vector vc = new Vector(); // 연결된 사용자를 저장할 벡터

	public ServerFrame() {
		super("서버 메인");
		init();
	}

	public static ServerFrame getInstance() {
		if (serverFrame == null) {
			serverFrame = new ServerFrame();
		}
		return serverFrame;
	}

	private void init() { // GUI를 구성하는 메소드
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 70, 600, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);

		js = new JScrollPane();
		js.setBounds(10, 10, 557, 710);

		serverTa = new JTextArea();
		serverTa.setFont(new Font("Monospaced", Font.PLAIN, 20));
		serverTa.setColumns(20);
		serverTa.setRows(5);
		contentPane.add(js);
		js.setViewportView(serverTa);

		portTf = new JTextField();
		portTf.setBounds(303, 734, 150, 40);
		contentPane.add(portTf);
		portTf.setColumns(10);

		portLb = new JLabel("Port Number");
		portLb.setFont(new Font("굴림", Font.PLAIN, 22));
		portLb.setBounds(174, 732, 125, 40);
		contentPane.add(portLb);

		StartBt = new JButton("서버 실행");
		StartBt.setFont(new Font("나눔고딕", Font.PLAIN, 22));
		StartBt.setBounds(173, 789, 280, 40);

		StartBt.addMouseListener(new ServerController());
		contentPane.add(StartBt);

		serverTa.setEditable(false); // textArea를 사용자가 수정 못하게끔 막는다.
	}
	public void display(String state){
		serverTa.append(state);
	}

}
