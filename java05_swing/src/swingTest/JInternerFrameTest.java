package swingTest;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JInternerFrameTest extends JFrame implements ActionListener, ChangeListener, ListSelectionListener{
	JDesktopPane dp=new JDesktopPane();
	JInternalFrame if1,if2,if3,if4;
	JTextArea ta=new JTextArea();
	
	
	JToolBar tb=new JToolBar();
	     JButton saveBtn=new JButton("저장");
	     JButton colorBtn=new JButton("색상표-글자색");
	     JButton calBtn=new JButton("계산기");
 
	JSlider redSlider = new JSlider(JSlider.HORIZONTAL,0,225,150);
	
	JList<String> list=new JList<String>();
	DefaultListModel<String>model=new DefaultListModel<String>();
	String flower[]= {"장미","국화","수국","해바라기","델피니움","달리아"};
	JScrollPane sp=new JScrollPane(list);
	
	
	public JInternerFrameTest() {
		add("North",tb);
		tb.add(saveBtn); tb.add(colorBtn); tb.add(calBtn);
		
		add("South",redSlider);
		redSlider.setMajorTickSpacing(50);
		redSlider.setMinorTickSpacing(5);
		//눈금 보여주기
		redSlider.setPaintTicks(true);
		//주눈금
		//보조눈금
		redSlider.setPaintLabels(true);
		///눈금자 딱 맞춰들어가게끔
		redSlider.setSnapToTicks(true);
		
		//////////////
		add(dp);
		/////////////////
		for(String flowerName : flower) {
			model.addElement(flowerName);
			
		}
		list.setModel(model);
		add("East",sp);
		
		if1=new JInternalFrame();
		
		if1.add(ta);
		if1.setSize(300,300);
		if1.setVisible(true);
		dp.add(if1);
		
		if2=new JInternalFrame("달력", true, true, true, true);
		CalendarSwing cs=new CalendarSwing();
		if2.add(cs);
		if2.setBounds(100, 100, 400, 300);
		if2.setVisible(true);
		dp.add(if2);
        
		if3=new JInternalFrame("clock");
		DigitalClock dc= new DigitalClock();
		Thread t=new Thread(dc);
		t.start();
		if3.add(dc);
		if3.setBounds(100,500,500,200);
		if3.setVisible(true);
		dp.add(if3);
		
		/////////////////////////////////////
		
		if4=new JInternalFrame("packman",false,true,false,false);
		Packman pa=new Packman();
		
		if4.add(pa);
		if4.setBounds(150,1,500,500);
		if4.setVisible(true);
		dp.add(if4);
		
		
	
		
		
		
		
		
		setSize(800,800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		try {
			if2.setSelected(true);
			if4.setSelected(true);
			pa.getPacManSize();
			Thread p=new Thread(pa);
			p.start();
			
		}catch(Exception e) {
			
		}
		
		saveBtn.addActionListener(this);
	    colorBtn.addActionListener(this);
	    redSlider.addChangeListener(this);
	    list.addListSelectionListener(this);
	    calBtn.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae) {
		Object obj=ae.getSource();
		if(obj==saveBtn) {
			//활성화되어있는 jinternalframe 얻어오기
			JInternalFrame eventIf=dp.getSelectedFrame();
			if(eventIf==if1) {
				JTextArea eventTa = (JTextArea)eventIf.getFocusOwner();
				String taStr=eventTa.getText();
				
				try {
				FileWriter fw= new FileWriter(new File("C://javaio/internal.txt"));
				fw.write(taStr);
				fw.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}else if(obj==colorBtn) {
			JColorChooser cc=new JColorChooser(Color.PINK);
			Color color=cc.showDialog(this, "색상표", Color.BLUE);
			ta.setForeground(color);
		}else if(obj==calBtn) {
			JDialog dialog=new JDialog(this,"계산기",true);
			Calculator cal=new Calculator();
			dialog.add(cal);
			dialog.setSize(400,500);
			dialog.setVisible(true);
		}
		System.out.println("이벤트발생");
	}
	
	
	public void stateChanged(ChangeEvent ce) {
		if(ce.getSource()==redSlider) {
			ta.setBackground(new Color(redSlider.getValue(),100,100));
			 
		}
	}
	
	public void valueChanged(ListSelectionEvent lse) {
		List<String>selectList=list.getSelectedValuesList();
		String txt="";
		for(int i=0; i<selectList.size();i++) {
			ta.append(selectList.get(i));
			txt +=selectList.get(i)+"\n";
			
		}
		ta.setText(txt);
	}

	public static void main(String[] args) {
		new JInternerFrameTest();

	}

}
