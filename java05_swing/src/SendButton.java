import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SendButton implements ActionListener{
    JTextArea ta;
    JTextField tf;
    
	public SendButton() {
		
	}
	public SendButton(JTextArea ta,JTextField tf) {
		this.ta=ta;
		this.tf=tf;
		
	}
	
   public void actionPerformed(ActionEvent ae) {
	ta.append(tf.getText()+"\n");
	tf.setText("");
}
   
   
}
