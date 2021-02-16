import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;

public class GraphicsTest extends JFrame{
	
	Mycanvas mc=new Mycanvas();
	public GraphicsTest() {
		setTitle("그림판");
		add(BorderLayout.CENTER,mc);
		
		setSize(800,800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	//그림그리기
	//캔버스 상속받아 패인드()를 오버라이딩하면 처음 객체생성시 별도의 호출없이
	//페인트()메소드는 1번 자동호출된다.
	
	
	class Mycanvas extends Canvas{
		public Mycanvas() {}
		//그림그리는 메소드를 오버라이딩 함  g-->마이 캔버스-->  //생성자 메소드 실행후 자동호출됨
		public void paint(Graphics g) {
			//직선그리기
			g.drawLine(50, 50, 300, 300);
			//사각형그리기
			g.drawRect(80, 50, 200, 300);
			//색 변경
			g.setColor(Color.PINK);
			g.fillRect(400, 50, 200, 300);
			//글자 그리기
			g.setColor(Color.black);
			g.setFont(new Font("굴림", Font.BOLD, 30));
			String str="문자열을 그림으로 그리기";
			g.drawString(str, 50, 400);
			
			//원그리기
			g.drawOval(80, 50, 200, 300);
			g.fillOval(400, 50, 200, 300);
			//둥근원
			g.drawRoundRect(50, 450, 400, 400, 200, 200);
			//다각형
			g.setColor(Color.red);
			int x[]= {300,400,350,100,110};
			int y[]= {100,180,400,600,300};
			g.drawPolygon(x,y,x.length);
			
			}
		}
	

	public static void main(String[] args) {
		new GraphicsTest();

	}

}
