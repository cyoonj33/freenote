import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

//어뎁터 상속하는 방법으로 만들기
//제이프레임을 상속받을건지/윈도우어뎁터를 상속받을 건지
public class WindowAdapterTest extends WindowAdapter{
    JFrame frm=new JFrame("windowadaptor test");
    
	public WindowAdapterTest() {
		frm.setSize(500,500);
		frm.setVisible(true);
		frm.setDefaultCloseOperation(frm.DO_NOTHING_ON_CLOSE);
		
		frm.addWindowListener(this);
	}

	public void windowClosing(WindowEvent we) {
		System.out.println("윈도우 이벤트");
		frm.dispose();
		System.exit(0);
	}
	
	public static void main(String[] args) {
		new WindowAdapterTest();

	}

}
