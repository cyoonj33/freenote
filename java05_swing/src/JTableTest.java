import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableTest extends JFrame{
    JTable table;
    //제목
    String title[]= {"번호","이름","연락처","이메일"};
    Object data[][]= {
    		{1,"홍길동","010-2525-2222","abcd@naver.com"},
    		{2,"신길동","010-2625-2222","abce@naver.com"},
    		{3,"차길동","010-2725-2222","abcf@naver.com"},
    		{4,"김길동","010-2825-2222","abcg@naver.com"},
    		{5,"박길동","010-2925-2222","abch@naver.com"}
    };
    
    	DefaultTableModel model;
    	JScrollPane sp;
    	
    JLabel lbl=new JLabel("선택한 정보가 표시되는 곳");	
    
	public JTableTest() {
		
		model=new DefaultTableModel(data, title);
		table=new JTable(model);
		sp=new JScrollPane(table);
		
		add(sp);
		add("South",lbl);
		
		setSize(600,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//익명의 내부 클래스
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				//마우스의 버튼 종류 알아내기
				int clickBtn= me.getButton(); //1왼쪽버튼 2휠 3오른쪽버튼
				if(clickBtn==1) {
					//선택한 행의 데이터 가져오기
					int row=table.getSelectedRow();
					String txt="";
					for(int c=0;c<table.getColumnCount();c++) {
						Object obj= table.getValueAt(row, c);
                        txt+=obj+",";
					}
					lbl.setText(txt);
				}
			}
		});
		
		//tableSet();
		
	}
	
	public void tableSet() {
		try { Thread.sleep(3000);}catch(Exception e) {}
		//행추가
		Object[]d= {6,"강감찬","010-1111-2222","aaa@naver.com"};  //3초뒤에 추가됨
		model.addRow(d);
		
		//행삽입-원하는 인덱스위치에 목록 추가
		try { Thread.sleep(2000);}catch(Exception e) {}
		Object[]d2= {7,"세종","010-2222-3333","abcdk@naver.com"};
		model.insertRow(2, d2);//2번째에 삽입
		
		try {Thread.sleep(2000);}catch(Exception e) {}
		//행이동 원하는 위치 여러행 이동
		//start end to
		model.moveRow(3,5,1);
		
		try {Thread.sleep(2000);}catch(Exception e) {}
		//컬럼추가
		model.addColumn("비고");
		
		try {Thread.sleep(2000);}catch(Exception e) {}
		//행삭제
		model.removeRow(2);
		
		try {Thread.sleep(2000);}catch(Exception e) {}
		//컬럼삭제
		table.removeColumn(table.getColumn("비고"));
		
		
		
		
}

	public static void main(String[] args) {
		new JTableTest();

	}

}
