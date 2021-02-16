import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;

//익명의 내부 클래스 이벤트로 처리


public class WindowAdapterInnerTest2 extends JFrame{
    JTextField tf = new JTextField("익명의 내부 클래스로 이벤트 처리하기");
    		
	public WindowAdapterInnerTest2() {
		add(BorderLayout.SOUTH,tf);
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		//이벤트 발생대상이 한개일때 사용/이벤트 발생할때 처리할곳이 어디인지 괄호안에 쓰는거
		addWindowListener(new WindowAdapter(){
			
			public void windowClosing(WindowEvent we) {
				tf.setText("처리됨");
				System.exit(0);
				
			}
		});
		
		
	}

	public static void main(String[] args) {
		new WindowAdapterInnerTest2();
	}

}
