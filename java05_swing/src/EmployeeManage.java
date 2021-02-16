import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class EmployeeManage extends JFrame{
    JPanel bigjp=new JPanel();
    JPanel bigjp2=new JPanel();
    
    
    //
    
		    JPanel bigjpbtn=new JPanel();
		    JPanel bigjptable=new JPanel();
		    JPanel bigjpsearch=new JPanel();
   
    
    //6개 패널들
    JPanel jpnum=new JPanel();
    JPanel jpname=new JPanel();
    JPanel jptel=new JPanel();
    JPanel jpemail=new JPanel();
    JPanel jpaddr=new JPanel();
    JPanel jpdate=new JPanel();
    //라벨들
    JLabel jlnum=new JLabel("번호");
    JLabel jlname=new JLabel("이름");
    JLabel jltel=new JLabel("전화번호");
    JLabel jlemail=new JLabel("이메일");
    JLabel jladdr=new JLabel("주소");
    JLabel jldate=new JLabel("등록일");
	//텍스트필드
    JTextField jtnum=new JTextField(10);
    JTextField jtname=new JTextField(10);
    JTextField jttel=new JTextField(30);
    JTextField jtemail=new JTextField(30);
    JTextField jtaddr=new JTextField(50);
    JTextField jtdate=new JTextField(50);
    
    //버튼
    JButton jbadd = new JButton("추가");
    JButton jbchange = new JButton("수정");
    JButton jbdelete = new JButton("삭제");
    JButton jbclear = new JButton("지우기");
    JButton jbexit = new JButton("종료");
    JButton jbsave = new JButton("저장");
    JButton jbopen = new JButton("불러오기");
    
    //jtable만들기
    DefaultTableModel model;
	JScrollPane sp;
	JTable table;
	

	 String title[]= {"번호","이름","연락처","이메일","주소","등록일"};
	 Object data[][]= {
	    		 };
	 
	
    
    
    //패널안 텍스트 필드
    JTextField intf=new JTextField(30);
    
    //패널안 버튼
    JButton serchbtn=new JButton("SERCH");
    
    
    
    
	
	public EmployeeManage() {
		super("회원관리");
		bigjp.setLayout(new GridLayout(6,1));
	
		
		///맨윗부분 패널1 만들기===========
				bigjp.add(jpnum);
					jpnum.add(jlnum);
					jpnum.add(jtnum);
					jpnum.setLayout((new FlowLayout(FlowLayout.LEFT)));
				
				bigjp.add(jpname);
					jpname.add(jlname);
					jpname.add(jtname);
					jpname.setLayout((new FlowLayout(FlowLayout.LEFT)));
				
				bigjp.add(jptel);
					jptel.add(jltel);
					jptel.add(jttel);
					jptel.setLayout((new FlowLayout(FlowLayout.LEFT)));
				
				bigjp.add(jpemail);
					jpemail.add(jlemail);
					jpemail.add(jtemail);
					jpemail.setLayout((new FlowLayout(FlowLayout.LEFT)));
					
				bigjp.add(jpaddr);
					jpaddr.add(jladdr);
					jpaddr.add(jtaddr);
					jpaddr.setLayout((new FlowLayout(FlowLayout.LEFT)));
				
				bigjp.add(jpdate);
					jpdate.add(jldate);
					jpdate.add(jtdate);
					jpdate.setLayout((new FlowLayout(FlowLayout.LEFT)));
		
		//2패널	============================
			bigjp2.setLayout(new GridLayout(7,3));		
		
	   

		//중간에 버튼 만들기
			       bigjpbtn.setLayout(new GridLayout(1,0));
			 bigjp2.add(BorderLayout.NORTH,bigjpbtn);
			   
			  
					bigjpbtn.add(jbadd);
					bigjpbtn.add(jbchange);
					bigjpbtn.add(jbdelete);
					bigjpbtn.add(jbclear);
					bigjpbtn.add(jbexit);
					bigjpbtn.add(jbsave);
					bigjpbtn.add(jbopen);
					
					
					
					/*
					bigjp2.add(jbadd);
					bigjp2.add(jbchange);
					bigjp2.add(jbdelete);
					bigjp2.add(jbclear);
					bigjp2.add(jbexit);
					bigjp2.add(jbsave);
					bigjp2.add(jbopen);
					*/
					
		   
		//JTable넣기
			/*
					JTableSet();
					bigjp2.add(BorderLayout.CENTER,sp);
					
					*/
				
					model=new DefaultTableModel(data, title);
					
					table=new JTable(model);
					
					sp=new JScrollPane(table);
					
					
					
				
					
				
					
					//setSize(800,800);
					//setVisible(true);
					//setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				
					
					
					bigjp2.add(BorderLayout.SOUTH,sp);
				
			
		//입력버튼
			 add(BorderLayout.SOUTH,bigjpsearch);
					bigjpsearch.add(intf);
					bigjpsearch.add(serchbtn);
				
					
		
		
		
		
		add(BorderLayout.NORTH,bigjp);
		add(BorderLayout.CENTER,bigjp2);
		

	
		
		
		setSize(600,600);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	
		
		
	}
	
	

    	
  
    /*
	public void JTableSet() {
		
		model=new DefaultTableModel(data, title);
		table=new JTable(model);
		sp=new JScrollPane(table);
		
		bigjp2.add("Center",sp);
		
		
		setSize(500,600);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	
		
		
	}
	*/
	

	public static void main(String[] args) {
		new EmployeeManage();

	}

}
