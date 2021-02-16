package swingTest;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

public class JSplitPaneTest extends JFrame{
    JSplitPane sp1, sp2;
    
	public JSplitPaneTest() {
		
		DigitalClock dc= new DigitalClock();
		CalendarSwing cs= new CalendarSwing();
		JTextField ta= new JTextField();
		
		//vertical
		sp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,dc,cs);
		
		//Horizontal
		sp1=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,sp2,ta);
		
		add(sp1);
		
		//sp2에 위쪽 component높이
		sp2.setDividerLocation(300);
		sp1.setDividerLocation(600);
		
		//선두께
		sp2.setDividerSize(1);
		sp1.setDividerSize(10);
		
		sp1.setOneTouchExpandable(true);
		
		setSize(1000,800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		Thread t1= new Thread(dc);
		t1.start();
		
	}

	public static void main(String[] args) {
		new JSplitPaneTest();

	}

}
