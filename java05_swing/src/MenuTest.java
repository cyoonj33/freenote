import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MenuTest extends JFrame implements ActionListener{
	
	//메뉴만들기
	JTextArea ta=new JTextArea();
	JScrollPane sp=new JScrollPane(ta);
	JMenuBar mb=new JMenuBar();
	JMenu fileMenu = new JMenu("파일");
	   JMenuItem newMenuItem =new JMenuItem("새문서");
	   JMenuItem openMenuItem=new JMenuItem("열기");
	   JMenuItem saveMenuItem=new JMenuItem("저장");
	   JMenuItem endMenuItem=new JMenuItem("종료");
	   
	JMenu editMenu = new JMenu("편집");
	   JMenuItem cutMenuItem =new JMenuItem("오리기");
	   JMenuItem copyMenuItem =new JMenuItem("복사하기");
	   JMenuItem pasteMenuItem =new JMenuItem("붙이기");
	
	JMenu runMenu = new JMenu("실행");
	   JMenuItem chromMenuItem =new JMenuItem("크롬");
	   JMenu editor = new JMenu("editor");
	        JMenuItem memoMenuItem =new JMenuItem("메모장");
	        JMenuItem editplusMenuItem =new JMenuItem("에디트플러스");
	   JMenuItem compileMenuItem =new JMenuItem("컴파일");     
	     
	   //기능 변수선언
	   String textBuffer;

	   //////////////////툴바/////////////////////////
	   JToolBar tb=new JToolBar();
	   //새문서
	   ImageIcon newIcon = new ImageIcon("icon/003.png"); JButton newBtn=new JButton(newIcon);
	   //저장
	   ImageIcon saveIcon = new ImageIcon("icon/002.png"); JButton saveBtn=new JButton(saveIcon);
	   //열기
	   ImageIcon openIcon = new ImageIcon("icon/001.png"); JButton openBtn=new JButton(openIcon);
	   //진하게
	   ImageIcon boldIcon = new ImageIcon("icon/004.png"); JButton boldBtn=new JButton(boldIcon);
	   //이텔릭
	   ImageIcon italicIcon = new ImageIcon("icon/005.png"); JButton italicBtn=new JButton(italicIcon);
	   //글자크기
	   JComboBox<Integer>fontSize = new JComboBox<Integer>();
	   DefaultComboBoxModel<Integer>fontsizeModel = new DefaultComboBoxModel<Integer>();
	   //글씨체설정
	   JComboBox<String> fontName ;
	   ////////////////////////////////////////
	  
	   ///font
	   int bold=0, italic=0;
	   Font fnt = new Font("굴림체",0,12);
	   
	   
	   
	   
	   
	   ///////////////////////////////////////////
	   
	   
	   
	   
	   
	   File nowFile;
	   //메뉴아이템만들기
	public MenuTest(){
		super("메모장");
		add(sp);
		//파일 메뉴에는
		fileMenu.add(newMenuItem);
		fileMenu.add(openMenuItem);
		fileMenu.add(saveMenuItem);
		fileMenu.addSeparator(); //경계선
		fileMenu.add(endMenuItem);
		
		mb.add(fileMenu);
		setJMenuBar(mb);
		
		//편집메뉴
		editMenu.add(cutMenuItem);
		editMenu.add(copyMenuItem);
		editMenu.add(pasteMenuItem);
		
		mb.add(editMenu);
		
		///실행메뉴-편집기 안에또 섭메뉴
		
		runMenu.add(chromMenuItem);
		runMenu.add(editor);
		    editor.add(memoMenuItem);
		    editor.add(editplusMenuItem);
		runMenu.add(compileMenuItem);    
		
		mb.add(runMenu);
		
		
		
	    /////////////툴바/////////////////////
		tb.add(openBtn);
		tb.add(newBtn);
		tb.add(saveBtn);
		
		tb.addSeparator();
		
		tb.add(boldBtn);
		tb.add(italicBtn);
		
		
		
		for(int i=8; i<50 ;i+=3) {
		  	fontsizeModel.addElement(i);
		  	
		}
		
		fontSize.setModel(fontsizeModel);
		fontSize.setSelectedItem(14);
		tb.add(fontSize);
		
		add(BorderLayout.NORTH,tb);
		
		//윈도우 운영체제에 있는 글꼴 생산자가 프로텍이라서 new안됨
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[]fntList=ge.getAvailableFontFamilyNames();
		
		
		//글꼴 만들기
		fontName=new JComboBox<String>(fntList);
		fontName.setSelectedItem("굴림체");
		tb.add(fontName);
		
		
		////////////////////////////////////
		
		///단축기
		setShortCut();
		
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//이벤트 등록
		
		newMenuItem.addActionListener(this);
		openMenuItem.addActionListener(this);
		saveMenuItem.addActionListener(this);
		endMenuItem.addActionListener(this);
		
		cutMenuItem.addActionListener(this);
		copyMenuItem.addActionListener(this);
		pasteMenuItem.addActionListener(this);
		
		chromMenuItem.addActionListener(this);
		memoMenuItem.addActionListener(this);
		editplusMenuItem.addActionListener(this);
		compileMenuItem.addActionListener(this);
		
		newBtn.addActionListener(this);
		openBtn.addActionListener(this);
		saveBtn.addActionListener(this);
		boldBtn.addActionListener(this);
		italicBtn.addActionListener(this);
		
		//
		fontSize.addActionListener(this);
		fontName.addActionListener(this);
		
	}
///눌렀을때 실행할거 jmenu jcombobox jbutton
	public void actionPerformed(ActionEvent ae) {
		String eventMenu = ae.getActionCommand();
		Object eventObj=ae.getSource();
		//이벤트가 발생한 개체가 어떤 클래스로 생성된 것인지 확인
	  if(eventObj instanceof JMenuItem) {
		//obj 가 제이메뉴클래스인가?
						if(eventMenu.equals("열기")) {
							fileOpen();
						}
						else if(eventMenu.equals("종료")) {
							System.exit(0);
						}else if(eventMenu.equals("저장")) {
							fileSave();	
						}else if(eventMenu.equals("새문서")){
						     newFile();
						}else if(eventMenu.equals("오리기")) {
							setCut();	
						}else if(eventMenu.equals("붙여두기")) {
							setpaste();
						}else if(eventMenu.equals("복사하기")) {
							setCopy();
						}else if(eventMenu.equals("메모장")) {
							startRuntime("notepad.exe");
						}else if(eventMenu.equals("크롬")) {
							startRuntime("C://Program Files//Google//Chrome//Application/chrome.exe");
						}else if(eventMenu.equals("에디트플러스")) {
							startRuntime("mspaint.exe");
						}
	    }else if(eventObj instanceof JButton) {
				    	if(eventObj==boldBtn) {
				    		bold=1;
				    	}else {
				    		bold=0;
				    	}
				    	fnt=new Font((String)fontName.getSelectedItem(), bold+italic ,(Integer)fontSize.getSelectedItem());
				    			ta.setFont(fnt);
				    			
	    }else if(eventObj==italicBtn) {
				    	if(italic==0)italic=2;
				    	else italic = 0;
				    	fnt=new Font((String)fontName.getSelectedItem(),bold+italic,(Integer)fontSize.getSelectedItem());
				    	ta.setFont(fnt);
	    }else if(eventObj instanceof JComboBox){
						if(eventObj== fontSize || eventObj == fontName) {
							fnt=new Font((String)fontName.getSelectedItem(),bold+italic,(Integer)fontSize.getSelectedItem());
							ta.setFont(fnt);
						}
	           }
	  
	 
	  
	}
	//////////////새문서 불러오기
	public void newFile(){
		   nowFile=null;
		   ta.setText("");
		  setTitle("메모장");
		  
		  }
		 
	
	//////////////파일 저장
	public void fileSave() {
		  if(nowFile==null){ //새문서 작성후 저장한다
				     //작성
				      JFileChooser fc=new JFileChooser();
				      int state=fc.showSaveDialog(this);  //saveBtn=0,1
				      if(state==0){
				      //저장 버튼 선택시
				      
				      //선택한 드라이브명,경로,파일명
				        File f = fc.getSelectedFile();
				      //글내용
				        String str = ta.getText();
				      //중복된이름 검사
				        if (f.exists()){
				        JOptionPane.showMessageDialog(this,"이미 존재하는 파일명입니다.\n 저장하기가 취소되었습니다." );
				        }else{
						           try{
						        
						      //fileWriter객체
						         FileWriter fw=new FileWriter(f);
						         fw.write(str, 0, str.length());
						         fw.flush();
						         fw.close();
						         
						         nowFile=f;
						         setTitle(f.getPath());
						         
				         
						         
						         
						         
						       }catch(Exception e){
						         e.printStackTrace();
						    }
					 }
						      
			}
				      
		      
		  
		   }else{ //이미 있는 문서를 열어 수정후 저장한다.
				         String writeTxt=ta.getText();
				      try{
				       
				         FileWriter fw =new FileWriter(nowFile);
				         fw.write(writeTxt, 0, writeTxt.length());
				         fw.flush();
				         fw.close();
				         
				      
				      }catch(Exception e){
				         e.printStackTrace();
		  }
		}
    }
		  
	
	/////////////파일열기
	  public void fileOpen() {
		 File f=new File("C://download//docu");
		 JFileChooser fc=new JFileChooser(f); //파일탐색기
		 
		 //여러 파일 선택가능하게 설정
		 fc.setMultiSelectionEnabled(true);//true 다중선택,false단일선택
		 //필터 설정
		 FileFilter ff1 = new FileNameExtensionFilter("이미지","jpg","jpeg","gif","png","bmp");
		 fc.addChoosableFileFilter(ff1);
		 
		 FileFilter ff2=new FileNameExtensionFilter("java","JAVA","JaVa");
		 fc.addChoosableFileFilter(ff2);
		 // 0열기 1취소
		 
		 int state = fc.showOpenDialog(this);//파일탐색기 열기
		 if(state==0) {
			 try {
					ta.setText(""); //원래 있는 컨텐트 지우기
					//File selFile=fc.getSelectedFile();--단일선택
					File selFile[]=fc.getSelectedFiles();//--다중선택
					//현재파일명을 JFrame에 제목으로 설정
					
			                     for(File s: selFile) {	
					         
			                    	 
								FileReader fr= new FileReader(s);
								BufferedReader brr= new BufferedReader(fr);
								
								
								  while(true) {
									String inData = brr.readLine();
									if(inData==null) {
										break;
									}
									else {
									
									ta.append(inData+"\n");
								    }
								
									//ta.append("=====================");
								  }     
									 
								}
					
			 }catch(Exception e) {
				 System.out.println("파일열기 에러 발생");
			 }
			 
		 }
	  }
	  
	//다른 프로그램 실행하기
	public void startRuntime(String process) {
		Runtime run=Runtime.getRuntime();
		try{
			run.exec(process);
		}catch(IOException ie) {
			ie.getStackTrace();
		}
	}
	
	//복사하기
	public void setCopy() {
		textBuffer=ta.getSelectedText();
	}
	
	
	//붙이기
	public void setpaste() {
		if(textBuffer!=null && ! textBuffer.equals("")) {
			ta.replaceSelection(textBuffer);
		}
	}
	
	//오려두기
	public void setCut(){
		textBuffer =ta.getSelectedText();
		ta.replaceSelection("");
	}
	
	
 
	
	
	//단축기 설정
	public void setShortCut() {
		//종료:ctrl+e
		//1 e단축기를 무엇으로 할것인지 설정
        endMenuItem.setMnemonic(KeyEvent.VK_E);
        //2.단축기의 Mask설정
        endMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        
        
        ////////////새문서 N,열기 O,저장 S
        newMenuItem.setMnemonic(KeyEvent.VK_N);
        newMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        ///////////////
        openMenuItem.setMnemonic(KeyEvent.VK_O);
        openMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        /////////////////
        saveMenuItem.setMnemonic(KeyEvent.VK_S);
        saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        
	}
	
	public static void main(String[] args) {
		new MenuTest();

	}

}
