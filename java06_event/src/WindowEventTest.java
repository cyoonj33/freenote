import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class WindowEventTest extends JFrame implements WindowListener{
	JLabel lbl=new JLabel("계산기");
    Calculator cal=new Calculator();
    
	public WindowEventTest() {
		add("NORTH",lbl);
		add(cal);
		
		setSize(500,500);
		setVisible(true);
		//프로그램 종료시 자원해재
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//창닫기 금지
		//setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(this);
	}

	
	
	public static void main(String[] args) {
		new WindowEventTest();

	}



	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("Opend()");
		
	}



	@Override
	public void windowClosing(WindowEvent e) {
		int state = JOptionPane.showConfirmDialog(this, "종료하시겠습니까","종료확인",
				JOptionPane.YES_NO_OPTION);
	               
		System.out.println("Closing");
		if(state == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}



	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("Clsed()");
		
	}



	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("Iconified()");
		
	}



	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("Deiconified()");
		
	}



	@Override
	public void windowActivated(WindowEvent e) {
		System.out.println("Activated");
		
	}



	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println("Deactivated");
		
	}

}
///계산기 만들고 넣기
//윈도우 이벤트는 창에대한 이벤트임
//1윈도우 이벤트 상속받아서 하는방법
//3익명의 내부 클래스 형식으로 만들기
//2윈도우 어뎁터로 만들기