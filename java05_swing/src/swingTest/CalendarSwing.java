package swingTest;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalendarSwing extends JPanel implements ItemListener, ActionListener{
	 
	
      Font fnt = new Font("굴림체",Font.BOLD,20);
      
		//1.버튼2,콤보박스2,라벨2 만들기-->이것이 들어갈 SELECT패널만들기
   
	JPanel selectPane = new JPanel();
	    JButton prevBtn = new JButton("◀");
	    JButton nextBtn = new JButton("▶");
	    JComboBox <Integer >yearCombo=new JComboBox<Integer>();
	    JComboBox <Integer >monthCombo=new JComboBox<Integer>();
	    JLabel yearLbl=new JLabel("년");
	    JLabel monthLbl=new JLabel("월");
	    
		//2.CENTER패널 만들기
		//TITLE패널 만들기<--여기에 들어갈 TITLR[배열]
	    //DAY패널 만들기
	    JPanel centerPane = new JPanel(new BorderLayout());
	         JPanel titlePane=new JPanel(new GridLayout(1,7));
	         String[] title= {"일","월","화","수","목","금","토"};
	         JPanel dayPane = new JPanel(new GridLayout(0,7));
	         
	    
	  //달력관련 데이터
	    Calendar date;
	    int year;
	    int month;
	    
	    
	    
	    //3.캘린더 가져오기 위해 정리
	public CalendarSwing() {
		//super("달력");
		setLayout(new BorderLayout());
		//4.이름 "달력"이라고 지정
		
		//5.캘린터=DATE  / DATE에서 년도랑 월 정보 가져와서 변수YEAR,MONTH로 정의
		date=Calendar.getInstance();
		year=date.get(Calendar.YEAR);
		month = date.get(Calendar.MONTH)+1;
		
		//6.SELECT패널에 버튼2개와 라벨2개 콤보박스2개 넣기 + 폰트수정 + 배경색 바꾸기
		selectPane.setBackground(new Color(150,200,200));
		selectPane.add(prevBtn);    prevBtn.setFont(fnt);
		selectPane.add(yearCombo);   yearCombo.setFont(fnt);
		selectPane.add(yearLbl);    yearLbl.setFont(fnt);
		selectPane.add(monthCombo);  
		selectPane.add(monthLbl);
		selectPane.add(nextBtn);
		 
		//7.프레임 위쪽에 <----SELECT패널(위) 추가하기
		add(BorderLayout.NORTH,selectPane);
	
		//8.년도,월,제목 다시 설정하겟다.
		setYear();
		setMonth();
		
		setCalendarTitle();
		
		//9.CENTER패널에<--TITLE패널(위)과 DAY패널 추가
		//  프레임에<---CENTER패널 추가
		centerPane.add(BorderLayout.NORTH,titlePane);
		add(centerPane);
		
		centerPane.add(dayPane);
		setDay();
		
		//10.창이 보이고 닫히게 설정
		//setSize(400,300);
		//setVisible(true);
		//setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//11.콤보박스랑 버튼에 이벤트 설정
		yearCombo.addItemListener(this);
		monthCombo.addItemListener(this);
		
		prevBtn.addActionListener(this);
		nextBtn.addActionListener(this);
	}
	    //12.리스너하고 이벤트 설정,오브젝트에 담기,◀  ▶ 각각 눌렀을때 prevMonth();/nextMonth(); 실행되게 만들기
	public void actionPerformed(ActionEvent ae) {
		Object obj=ae.getSource();
		if(obj==prevBtn) {//이전월
			prevMonth();
		}else if(obj==nextBtn) {//다음월
			nextMonth();
		}
	}
	
	////13.12월일때 1년+,1월/ 1월일때 1년-,12월 설정 /각각 setDayReset() 적용해주기
	public void nextMonth() {
		
		if(month==12) {
			year++;
			month=1;
		}else {
			month++;
		
		
	}
		setDayReset();
	}
	
	
	
	////////////
	public void prevMonth() {
		if(month==1) {
			year--;
			month=12;
		}else {
			month--;
		}
		setDayReset();
	}
	
	
	///////////14.콤보박스 이벤트 설정
		public void setDayReset() {
		//년월 이벤트 등록 해제
		yearCombo.removeItemListener(this);//아이템이벤트 발생시
		monthCombo.removeItemListener(this);
		
		yearCombo.setSelectedItem(year);
		monthCombo.setSelectedItem(month);//이벤트 발생
		
		dayPane.setVisible(false);
		dayPane.removeAll();
		setDay();
		dayPane.setVisible(true);
		
		//년월 이벤트 등록 다시등록
		yearCombo.addItemListener(this);
		monthCombo.addItemListener(this);
		
		}	
	
	
	////15.이벤트 발생
	public void itemStateChanged(ItemEvent ie) {
		year =(int)yearCombo.getSelectedItem();
		month=(int)monthCombo.getSelectedItem();
		
		dayPane.setVisible(false);
		dayPane.removeAll();//원래 있는 날짜 지우기
		setDay(); //날짜 처리 함수 호출
		dayPane.setVisible(true);
		
		
	}
	
	//날짜셋팅
	public void setDay() {
		//요일
		date.set(year, month-1,1);
		int week=date.get(Calendar.DAY_OF_WEEK);
		//마지막날
		int lastDay = date.getActualMaximum(Calendar.DATE);
		//공백
		for(int s=1; s<week; s++) {
			JLabel lbl = new JLabel("");
			dayPane.add(lbl);
		 }
		//날짜 추가
		for(int day=1;day<=lastDay; day++) {
			JLabel lbl = new JLabel(String.valueOf(day),JLabel.CENTER);
			lbl.setFont(fnt);
		
			date.set(Calendar.DATE,day); //19->1
			int w=date.get(Calendar.DAY_OF_WEEK);
			if(w==1)lbl.setForeground(Color.RED);
			if(w==7)lbl.setForeground(Color.BLUE);
			dayPane.add(lbl);
		}
	}
	
	//년도 셋팅
		public void setYear() {
			for(int i=year-50; i<year+20; i++) {
				yearCombo.addItem(i);
			}
			yearCombo.setSelectedItem(year);
		}
		
		
	
	//월 셋팅
	public void setMonth() {
		for(int i=1; i<=12; i++) {
			monthCombo.addItem(i);
		}
		monthCombo.setSelectedItem(month);
	}
	
	//월화수목 타이틀 설정
	public void setCalendarTitle() {
		for(int i=0;i<title.length; i++) {
			JLabel lbl = new JLabel(title[i],JLabel.CENTER);
			lbl.setFont(fnt);
			if(i==0)lbl.setForeground(Color.RED);
			if(i==6)lbl.setForeground(Color.BLUE);
			titlePane.add(lbl);
			
		}
	}
	

	//public static void main(String[] args) {
	//	new CalendarSwing();

	//}

}
