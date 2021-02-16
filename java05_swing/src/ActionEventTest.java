import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ActionEventTest implements ActionListener {
    JFrame frm= new JFrame("actionevent");
    JButton btn=new JButton("클릭");
    JButton btn2=new JButton("3단");
    JTextArea ta=new JTextArea("버튼 누르세요");
    JScrollPane sp=new JScrollPane(ta);
    
	public ActionEventTest() {
		frm.add(BorderLayout.NORTH,btn);
		frm.add(BorderLayout.SOUTH,btn2);
		//frm.add(ta);
		frm.add(sp);
		
		
		//1인터페이스 상속 implements로 위에
		//2추상메소드 오버라이딩-->메소드 하나박에 없음
		
		
		
		frm.setSize(500,500);
		frm.setVisible(true);
		frm.setDefaultCloseOperation(frm.DISPOSE_ON_CLOSE);
		
		//3이벤트 등록
		btn.addActionListener(this);
		btn2.addActionListener(this);
		
		
	}
	
	
	
    //오버라이딩//j버튼에서 발생한 이벤트 ae에 들어감
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		//ta.setText("후후후");//새로운 문자로 생성
		//append():마지막의 문자 추가
		//insert():원하는 위치(index)에 문자추가
		//ta.append("click\n");
		//BTN2,BTN이 AE로 들어옴
		
		//1이벤트가 발생한 버튼 알아내기-->getActionCommand()
		/*String evt= ae.getActionCommand();
		if(evt.equals("클릭")) {
			ta.append(evt+"\n");
		}else if(evt.equals("3단")) {
			 gugudan(3);
		}
		*/
		
		//2.이벤트가 발생한 객체를 이용하여 알아내기
		Object obj = ae.getSource();
		if(obj==btn) {//클릭 버튼 선택시 
			ta.append("btn버튼 클릭");
			
		}else if(obj==btn2) {
			gugudan(9);
		}
		
	}
	
		public void gugudan(int dan) {
			for(int i=2; i<=9; i++) {
				ta.append(dan+"*"+i+"="+(dan*i)+"\n");
			}
		
		
		
		
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		new  ActionEventTest();

	}

}
