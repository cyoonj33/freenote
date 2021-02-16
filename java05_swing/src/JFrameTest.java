import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFrameTest extends JFrame{

	public JFrameTest() {
		//스윙버튼 만들기 awp상속,프레임도 포함
		super("swing 테스트중");
		
		JButton btn = new JButton("swing버튼");
		add(BorderLayout.NORTH,btn);
		
		
		//테두리 없는 컨테이너 : JPANEL
		JPanel pane = new JPanel();
		
		
		//바둑판으로 만들기               행 렬 에이치겟 브이겟
		pane.setLayout(new GridLayout(0,2,20,20));
		
		
		JButton btn2= new JButton("버튼2");
		JButton btn3= new JButton("버튼3");
		JButton btn4= new JButton("버튼4");
		JButton btn5= new JButton("버튼5");
		JButton btn6= new JButton("버튼6");
		
		
		pane.add(btn2);
		pane.add(btn3);
		pane.add(btn4);
		pane.add(btn5);
		pane.add(btn6);
		
		add(BorderLayout.CENTER,pane);
		
		
		
		
		
		setSize(500,500);
		setVisible(true);
		
		
		//이건 x누르면 꺼지는데, 완전히 종료가 된것이 아님
		//프로그램 종료시 자원해제시키는 설정  **중요!!
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//제어판 세부정보에서 자바.exe 보기-->지워짐  /원래는 빨간버튼 눌러야함
		
		
		
		//스윙에 있는거는 제이버튼임(이게 더 기능많음)
		
		
	}

	public static void main(String[] args) {
	  new JFrameTest();

	}

}
