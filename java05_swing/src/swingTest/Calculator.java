package swingTest;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JPanel implements ActionListener{
    Font fnt=new Font("Arial",Font.BOLD,20);
    
	JTextField resultTf = new JTextField("0.0");
	
	JPanel centerPane=new JPanel(new BorderLayout());
	JPanel northPane=new JPanel(new GridLayout(1,3));
	JPanel btnPane=new JPanel(new GridLayout(4,4));
	
	String [] btnLbl = {"Backspace","Clear","End",
			"7","8","9","+",
			"4","5","6","-",
			"1","2","3","*",
			"0",".","=","/"};
	
	
	String operator="";
	double result = 0.0;
	
	public Calculator() {
		//setLayout(new BorderLayout());
	    //레이아웃을 FLOWLayout->borderlayout으로
		setLayout(new BorderLayout());
		
		add("North",resultTf);
		resultTf.setFont(fnt);
		
		resultTf.setHorizontalAlignment(JTextField.RIGHT);
	
		centerPane.add("North",northPane);
		centerPane.add(BorderLayout.CENTER,btnPane);
		add("Center",centerPane);
		 
		for(int i=0 ;i<btnLbl.length;i++) {
			JButton btn = new JButton(btnLbl[i]);
			
			if(i<=2) {
				northPane.add(btn);
				
			}else {
				btnPane.add(btn);
				btn.setBackground(Color.pink);
				
			}
			
			btn.addActionListener(this);
		}
		
		
		//setSize(500,500);
		//setVisible(true);
		//setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}

	
	public void actionPerformed(ActionEvent ae) {
		String eventBtn=ae.getActionCommand();
		switch(eventBtn) {
		case "End":System.exit(0);break;
		case "0":case"1":case "2":case"3":case"4":case"5":
		case"6":case"7":case"8":case "9":
			setNumber(eventBtn);
			break;
		case ".":
			setPoint();
			break;
		case "Backspace":
			break;
		case "+":case"-":case"*":case"/":
			setOperator(eventBtn);
			break;
	    }
	}
	
	public void setClear() {
		result = 0.0;
		operator ="";
		resultTf.setText("0.O");
	}
	
	public void setResult() {
		double secondNum = Double.parseDouble(resultTf.getText());
		switch(operator) {
		case"+" :result = result + secondNum; break;
		case"-" :result -=secondNum; break;
		case"*" :result *=secondNum; break;
		case"/" :result /=secondNum; break;
		}
		resultTf.setText(String.valueOf(result));
		operator = "";
		
	}
	
	
	public void setOperator(String operator) {
		this.operator=operator;
		result=Double.parseDouble(resultTf.getText());
		resultTf.setText("");
		
	}
	
	
	public void setBackSpace() {
		String lblStr = resultTf.getText();
		String cutStr = lblStr.substring(0,lblStr.length()-1);
		resultTf.setText(cutStr);
	}
	
	
	public void setPoint() {
		String lblStr=resultTf.getText();
		int idx =lblStr.indexOf(".");
		if(idx==-1) {
			resultTf.setText(lblStr+".");
		}
	}
	
	public void setNumber(String num) {
		String lblStr = resultTf.getText();
		if(lblStr.equals("0.0")) {
			resultTf.setText(num);
		}else {
			resultTf.setText(lblStr+num);
		}
	}
	
	//public static void main(String[] args) {
	//	new Calculator();

	//}

}
