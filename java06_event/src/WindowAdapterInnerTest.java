import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

//프레임 상속 받아서 하는 방법,이벤트는 내부 클래스에서 실해
public class WindowAdapterInnerTest extends JFrame{

	JLabel lbl=new JLabel("윈도우");
	
	public WindowAdapterInnerTest() {
		add(lbl);
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		AdapterInner ai=new AdapterInner();
		addWindowListener(new AdapterInner());
		
		
	}
    //내부 클래스에서 윈도우 이벤트 처리하기
	class AdapterInner extends WindowAdapter{
		//다시 오버라이딩
		public void windowClosing(WindowEvent we) {
			lbl.setText("윈도우 이벤트 처리됨");
			System.exit(0);
			
		}
	}
	
	
	public static void main(String[] args) {
		new WindowAdapterInnerTest();
	}

}
//메뉴는 클래스가 3개 필요함

//j메뉴 안에 j메뉴or 아이템들 -->프레임 안에 속함
//파일(새문서 열기 저장 종료)    편집( 오리기 복사하기 붙여넣기 )   실행(크롬 편집기 컴파일) 
//편집기(메모장 에디트플러스)
//메뉴바/제이메뉴/하위제이메뉴/메뉴아이템


