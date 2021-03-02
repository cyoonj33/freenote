package chatting;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.StringTokenizer;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class ChatClient extends JFrame implements ActionListener, Runnable{
	// JFrmae - Center
	JPanel centerPane=new JPanel(new BorderLayout());
		JPanel connPane=new JPanel(new BorderLayout());
			JLabel title=new JLabel("");
	

			JTextArea msgTa=new JTextArea();
			JScrollPane msgSp=new JScrollPane(msgTa);
			JPanel sendPane=new JPanel(new BorderLayout());
			JTextField sendTf=new JTextField();
			JButton sendBtn=new JButton("보내기");
	///////////////////////   
	Socket s;
	PrintWriter pw;
	BufferedReader br;
	boolean b=true;
	public ChatClient() {
		//JFrame - Center
		add(centerPane);
	
		title.setText("관리자 문의");
		connPane.add(title);
		centerPane.add("North", connPane);		
		centerPane.add(msgSp);
			msgTa.setBackground(new Color(237,237,237));
			centerPane.add("South", sendPane);
			sendPane.add(sendTf);
			sendPane.add("East", sendBtn);

		setSize(400,400);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      
		sendTf.addActionListener(this);
		sendBtn.addActionListener(this);
 	}
	public void actionPerformed(ActionEvent ae) {
		Object eObj=ae.getSource();
		if(eObj==sendTf || eObj==sendBtn) { // sendTf, sendBtn 이벤트가 들어오면
			if(b==true)
			serverConnection();
			b=false;
			// 문자 보내기
			if(sendTf.getText().equals("")) { // 메세지 입력란에 공백이 들어온 경우
					JOptionPane.showMessageDialog(this, "메세지 내용을 입력 후 보내기 버튼을 눌러주세요");
			}else { // 메세지 입력란에 공백이 들어오지 않은 경우
				pw.println(sendTf.getText()); // 메세지 입력란의 문자열을 가져와 출력
				pw.flush();
				sendTf.setText(""); // 메세지를 보낸 경우 메세지 입력란을 초기화
			}
		}
	}
	public void serverConnection() {
		try {
			InetAddress ia=InetAddress.getByName("192.168.0.113");
			s=new Socket(ia,15000);
			br=new BufferedReader(new InputStreamReader(s.getInputStream())); // 입력
			pw=new PrintWriter(new OutputStreamWriter(s.getOutputStream())); // 출력
        
			Thread t=new Thread(this); // 항시 대기
			t.start();
		}catch(Exception e){
			//연결하다 에러 발생시
			e.printStackTrace();
		}   
		
	}
	public synchronized void run() { // 동기화로 스레드 구현
		while(true) {
			try {
				String inData=br.readLine();   
				if(inData != null) {
					String header=inData.substring(0,6);
					if(header.equals("$$NG##")) { // 접속자 정보 알림
						msgTa.append(inData.substring(6)+"\n");
					}
					else if(header.equals("%^GH&*")) { // 메시지가 오면
            	   msgTa.append(inData.substring(6)+"\n");
					}
				}
			}catch(Exception e) {
				e.printStackTrace();
			}         
		}
	}
	public static void main(String[] args) {
		new ChatClient();

	}
}