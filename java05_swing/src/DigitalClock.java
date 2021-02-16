import java.awt.BorderLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class DigitalClock extends JFrame{

	JLabel timeView=new JLabel("00:00:00",JLabel.CENTER);
	Font fnt=new Font("굴림체",Font.BOLD,100);
	
    
	
	
	public DigitalClock() {
		add(timeView);
		timeView.setFont(fnt);
		
		
		pack();
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    
		
		changeTime();
	}
	
	
	public void changeTime() {
		while(true) {
			Calendar now=Calendar.getInstance();
			SimpleDateFormat format=new SimpleDateFormat("HH:mm:ss");
			String txt= format.format(now.getTime());
			timeView.setText(txt);
			try {Thread.sleep(1000);}catch(Exception e) {}
			
		}
	}

	public static void main(String[] args) {
		new DigitalClock();
	}

}
