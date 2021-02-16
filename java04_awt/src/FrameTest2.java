import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class FrameTest2 extends Frame{

	public FrameTest2() {
		super("상속받은 프레임");//창제목 세팅 또는// setTitle("창제목");
		
		
		//레이아웃 변경, borderlayout(동서남북 센터로,자리 모자르면 덮어버림)  --> flowlayout 으로 변경(제일가운데로 들어감,자리 모자르면 위에서 순서대로 블록처럼 채워줌)
		setLayout(new FlowLayout());
		Button btn=new Button("레이아웃 변경");
		add(btn);
		
		
		setSize(500,500); //왼쪽에 객체명 안써도 됨
		setVisible(true);
		
		
	}

	public static void main(String[] args) {
		new FrameTest2();

	}

}
