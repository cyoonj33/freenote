import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class KeyEventTest extends JFrame implements KeyListener{
	JPanel pane=new JPanel();
	JTextArea ta=new JTextArea();
	JScrollPane sp=new JScrollPane(ta);
	JButton btn=new JButton("보내기");
	JTextField tf=new JTextField(20);
	
	Font fnt = new Font("궁서체",Font.BOLD,20);

	public KeyEventTest() {
		super("키이벤트");//jfram으로 들어감 상속받음
		add(sp);//프레임에 스크롤넣기
		
		add(BorderLayout.SOUTH,pane);//프레임에 패널넣기
		pane.add(tf);//패널의 택스트필드 넣기
		pane.add(btn);//패널에 버튼넣기
		
		
		//ta에 폰트객체 세팅
		ta.setFont(fnt);
		
		
		setSize(400,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//이벤트 등록
		tf.addKeyListener(this);//현재클래스 실행
		btn.addActionListener(new SendButton(ta,tf));//현재 클래스에 없고 다른 클래스에 있음
		
	}//오버라이딩
	
    public void keyPressed(KeyEvent ke) {//키를 누른 상테
    	
    }
    public void keyReleased(KeyEvent ke) {//키를 누른후 놓으면
    	//이벤트 발생한 키 정보 얻어오기
    	char evtChar = ke.getKeyChar();
    	int evtInt = ke.getKeyCode();
    	System.out.println(evtChar+"->"+evtInt);
    	
    	if(evtInt==KeyEvent.VK_ENTER) {
    		ta.append(tf.getText()+"\n");
    		tf.setText("");
    	}else if(evtInt==KeyEvent.VK_ESCAPE) {
    		System.exit(0);
    	}
    	
    }
    public void keyTyped(KeyEvent ke) {//키를 누른후 놓으면
    	
    }
    
    
    
	public static void main(String[] args) {
		new KeyEventTest();

	}

}
