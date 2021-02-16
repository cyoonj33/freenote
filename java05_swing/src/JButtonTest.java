import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;

public class JButtonTest extends JFrame{
   ImageIcon ii5=new ImageIcon("img/movie05.png");
   ImageIcon ii4=new ImageIcon("img/movie04.png");
   ImageIcon ii3=new ImageIcon("img/movie03.png");
   ImageIcon ii2=new ImageIcon("img/movie02.png");
   ImageIcon ii1=new ImageIcon("img/movie01.png");
   
	
	public JButtonTest() {
		super("test");
		
		setLayout(new GridLayout(0,3,10,10));//레이아웃변경
		
		//이미지 넣기
		JButton btn5=new JButton("확인",ii5); //글자가 오른쪽에 표시됨, 글자와 이미지 동시에 넣기
		JButton btn4=new JButton(ii4);
		JButton btn3=new JButton(ii3);
		JButton btn2=new JButton(ii2);
		JButton btn1=new JButton(ii1);
		
		
		
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		add(btn5);
		//버튼의 비활성화
		btn1.setEnabled(false);  //true 활성화/폴스 비활성화
		
		//마우스를 올리면 아이콘 ii3으로 바뀌게
		btn2.setRolloverIcon(ii3);
		
		//마우스 누른 상태일때 아이콘 ii2 설정 
		btn2.setPressedIcon(ii1);
		
		//라디오 버튼==여러개중에 하나 고를수 있는 버튼
		//한 묶음으로 묶어줘야함-->버튼 그룹
		//패널이 필요함 한줄에 하나씩+그리드 레이아웃으로 세팅
		
		//레디오 버튼 만들기
		JPanel pane = new JPanel(new GridLayout (3 ,1));
		//pane.setLayout(new GridLayout(3,1));
		
		
		//그룹화 시키기-buttongroup:radiobutton
		//객체를 만들어서 등록
	
		JRadioButton rd1=new JRadioButton("1");
		JRadioButton rd2=new JRadioButton("2");
		JRadioButton rd3=new JRadioButton("3",true);
		
		pane.add(rd1);
		pane.add(rd2);
		pane.add(rd3);
		add(pane);
		
		////레디오 버튼이용해서 하나선택시 다른거 선택못하게 하기
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rd1); bg.add(rd2); bg.add(rd3);
		
		//토글 버튼-눌러진 상태로있는거
		JToggleButton tb1 = new JToggleButton("토글버튼");
		JToggleButton tb2 = new JToggleButton(ii5,true);
		//tb2.setVisible(false);
		tb2.setRolloverSelectedIcon(ii4);
		add(tb1); add(tb2);
		
		//setBackground(): 컨퍼넌트나 컨테이너의 배경색 설정
		btn2.setBackground(Color.pink);
		
		//색을 내가 만들어서 하기
		//Color(int r, int g, int b) 앞에서부터 레드 그린 불루임-->256 256 256씩
		Color clr1 = new Color(80,  200, 152);
		rd1.setBackground(clr1);
		
		//글자색 세팅
		tb1.setForeground(Color.BLUE);
		
		//JLabel:라벨 컴퍼넌트/이미 들어있던 요소들(클릭 되는게 아니라 그냥 표시들)
		 JLabel lbl1=new JLabel(ii3);
		 JLabel lbl2=new JLabel("라벨",JLabel.CENTER);  //라벨 식에서 인트라고 명시됨-->일반 센터 써야함
		 add(lbl1); add(lbl2);
		 
		 //라벨에 색 넣기-->안됨-->투명처리 되어있음
		 Color clr2=new Color(150,110,150);
		 lbl2.setBackground(clr2);
		 //투명처리 해지하는법
		 lbl2.setOpaque(true);//트루-투명해제   폴스-투명
		 
		 //마우스대면 안내박스 살작 뜨는거
		 btn3.setToolTipText("연습중");
		 
		
		setSize(600,400);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	
	
	
	
	
	public static void main(String a[]) {
		new JButtonTest();
	}

}
