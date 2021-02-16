package swingTest;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

public class JSplitPaneTest2 extends JFrame{
	JSplitPane sp1, sp2, sp3;
	
	
	public JSplitPaneTest2() {
		
		CalendarSwing cs= new CalendarSwing();
		Calculator ct=new Calculator();
		Packman pk= new Packman();
		
		
		
		
		
		
		sp2=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,ct,cs);
		sp1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,sp2,pk);
		
		
				
		add(sp2);
		
		sp2.setDividerLocation(200);
		sp1.setDividerLocation(300);
		
		sp2.setDividerSize(1);
		sp1.setDividerSize(1);
		
		
		setSize(1000,800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		Thread t1= new Thread(pk);
		t1.start();
		
		
	}

	public static void main(String[] args) {
		new JSplitPaneTest2();

	}

}
