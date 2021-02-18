package chatting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class ChatServer extends Thread{
	// 접속 대기 객체
	ServerSocket ss;
	// 접속자(Socket)를 보관할 객체
	List <ChatService>connAll=new ArrayList<ChatService>();
	public ChatServer() {
		this.start();
	}
	
	// 접속 대기 스레드
	public void run() {
		try {
			ss=new ServerSocket(15000); // 클라이언트가 포트번호 15000으로 접속을 하면
			
			while(true) {
				System.out.println("서버 접속대기중...");
				Socket s=ss.accept(); // 클라이언트가 들어오면 s를 생성
				
				// 클라이언트가 접속을 하면
				ChatService cs=new ChatService(s);
				System.out.println(cs.userid+"가 접속하였습니다...");
				
				
				// 이미 접속자인지 확인
				connectionCheck(cs);
				
				// 모든 접속자 리스트에 추가
				connAll.add(cs);
				
				// 현재 접속중인 접속자에 접속을 알린다
			//	setMessageAll("$$NG##"+cs.userid+"님이 접속하였습니다");
				setMessageAll("$$NG##"+"[서버에 접속하였습니다]");
				// 접속자 수 보내기
				setMessageAll("!%$%^$"+connAll.size());
				
				// 접속자 목록 보내기
				connectionList();
				
				// 클라이언트가 보낸 문자를 받아낼 InputStream 스레드 시작
				cs.start();
			}
		}catch(Exception e) {
			
		}
	}
	//
	public void connectionCheck(ChatService cs) {
		for(int i=0;i<connAll.size();i++) {
			ChatService service=connAll.get(i); // 접속자를 보관한 객체의 내용을 1개씩 가져온다
			if(service.userid.equals(cs.userid)) { // 이미 접속자일 경우
				connAll.remove(i); // 접속자 리스트에서 삭제
				break;
			}
		}
	}
	
	// 접속자 목록 보내기
	public void connectionList() {
		String idList="^^CL*%";
		for(int i=0;i<connAll.size();i++) {
			ChatService cs=connAll.get(i);
			idList+="/"+cs.userid; // 
		}
		setMessageAll(idList);
	}
	
	// 전체 회원에게 메세지 보내기
	public void setMessageAll(String msg) {
		for(int i=0;i<connAll.size();i++) {
			try {
				ChatService cs=connAll.get(i); // ChatService에 입출력이 다 있기 때문
				// 쓰기
				cs.pw.println(msg);
				cs.pw.flush(); // flush를 해야 메세지가 넘어간다
			}catch(Exception e) { // 회원이 채팅창을 껐을 때
				connAll.remove(i);
				i--; // 1번째 회원이 지워지면 2번째 회원이 1번으로 감
			}
		}
	}
	
	// 클라이언트가 접속을 하면 접속자 정보를 가질 객체
	class ChatService extends Thread{
		// socket, inputStream, outputStream, 접속자 이름(ip)
		Socket s;
		BufferedReader br;
		PrintWriter pw;
		String userid;
		InetAddress ia;
		ChatService(){}
		ChatService(Socket s){
			try {
				this.s=s;
				br=new BufferedReader(new InputStreamReader(s.getInputStream())); // 입력
				pw=new PrintWriter(new OutputStreamWriter(s.getOutputStream())); // 출력
				
				// 접속자
				ia=s.getInetAddress(); // 접속자 아이피 받아오기
				userid=ia.getHostAddress(); // 접속자 아이피를 userid에 저장
				
			}catch(Exception e) {
				
			}
		}
		
		// 입력 대기 Thread
		public void run() {
			while(true) {
				try {
					String inData=br.readLine();
					if(inData!=null) {
						// 접속한 모든 접속자에게 문자 보내기
					//	setMessageAll("%^GH&*"+userid+"님 : "+inData);
						setMessageAll("%^GH&*"+"나 : "+inData);
					}
				}catch(Exception e) {}
			}
		}
	}
	public static void main(String[] args) {
		new ChatServer();
	}

}
