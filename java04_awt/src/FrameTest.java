import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class FrameTest {
	//객체를 이용하여 컨테이너 생성
	Frame frm= new Frame();
	
	Dimension dim=new Dimension(400,300);
	Point pnt=new Point(200,300);
	Rectangle rect = new Rectangle(pnt,dim);

	public FrameTest() {
		//창 제목 설정
		frm.setTitle("연습용");
		
		
		
		//창의 크기 설정
		//frm.setSize(500,500);
		//창크기 2
		//frm.setBounds(100, 100, 500, 500);
		//창크기3
		//frm.setSize(dim);
		//창크기4
		frm.setBounds(rect);
		//창크기5 컴포넌트 만큼 크기나옴
		//frm.pack();
		
		//버튼만들기/버튼 넣기
		Button btn1 =new Button("버튼1");
		frm.add(btn1);
		
		
		
		//프레임은 보더레이아웃이 세팅 되어있음
		//위치 안잡아줘서 센터로 들어감
        //위치잡기
		Button btn2= new Button("버튼2");
		//보더레이아웃.노스  이렇게 써도 됨
		frm.add("North",btn2);
		frm.add(BorderLayout.EAST,new Button("버튼3"));
		frm.add(BorderLayout.SOUTH,new Button("버튼4"));
		frm.add(BorderLayout.WEST,new Button("버튼5"));
		
		
		//추상클래스는 객체 바로 못만들-->객체만듬
		Toolkit kit= Toolkit.getDefaultToolkit();
		
		//이미지 불러오기,자바프로젝트 위에서 폴더 만들어야함,임폴트.사진끌어오기하기
		Image img=kit.getImage("img/fff.jfif");
		frm.setIconImage(img);
		
		
		
		
		
		
		//창을 보여주어야 함
		frm.setVisible(true);
		
		
		
	}

	public static void main(String[] args) {
		new FrameTest();

	}

}
