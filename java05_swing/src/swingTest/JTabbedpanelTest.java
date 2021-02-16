package swingTest;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class JTabbedpanelTest extends JFrame{
    JTabbedPane tp=new JTabbedPane();
    
	ImageIcon ii1=new ImageIcon("img/2222.jpg");
	ImageIcon ii2=new ImageIcon("icon/001.png");
	ImageIcon ii3=new ImageIcon("icon/002.png");
	ImageIcon ii4=new ImageIcon("icon/003.png");
	ImageIcon ii5=new ImageIcon("icon/004.png");
	
	JLabel lbl=new JLabel(ii1);
	
	CalendarSwing cs=new CalendarSwing();
	Calculator cal=new Calculator();
	Packman packMan= new Packman();
	DigitalClock clock=new DigitalClock();

	
	public JTabbedpanelTest() {
		add(tp);
		
		//텝패널에 컴포넌트 추가
		tp.addTab("이미지",lbl);
		
		
		tp.addTab("계산기",ii2,cal);
		
		
		tp.addTab("팩맨", packMan);
		
		
		tp.addTab("디지털시계",clock);
		
		
		tp.addTab("달력",cs);
		
		pack();
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//시계스레드
		Thread clockThread=new Thread(clock);
		clockThread.start();
		
		//팩맨스레드
		
		packMan.getPacManSize();
		Thread PackmanThread=new Thread(packMan);
		PackmanThread.start();
		
		try {
			Thread.sleep(3000);
		}catch(Exception e) {
			
		}
		///중간에 탭메뉴 추가하기//////////
		tp.insertTab("버튼", ii2, new JButton("클릭"), "tab테스트중", 2);
		
		///활성화하기 true//비활성화하기 false
		//tp.setEnabled(false);
		
		//부분 비활성화
		//tp.setEnabledAt(2,false);
		
		//탭메뉴삭제
		//tp.removeTabAt(3);
		
		//텝메뉴 위치 이동
		//tp.setTabPlacement(JTabbedPane.LEFT);
		
		
	}

	public static void main(String[] args) {
		new JTabbedpanelTest();

	}

}
