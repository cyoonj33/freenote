import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileTest {

	public FileTest() {
		//파일 객체 생성 : 드라이브명,폴더명,파일명 반드시 절대 주소(cd..이건 상대주소)
		
		File f1=new File("C://javaIo");//f1만들기
		File f2=new File("C://download//docu");   
		File f3=new File(f1,"test.txt");
		
		
		//폴더 생성하기
		//exite():폴더 또는 파일이 존재하는ㄴ지 확인
		if(!f1.exists()) {
			if(f1.mkdirs()){
				System.out.println("폴더생성");
			}else {
				System.out.println("실패");
			}
		}
	//파일 생성
		if(!f3.exists()) {
			try {
			if(f3.createNewFile()) {
				System.out.println("파일 생성");
			}else {
				System.out.println("파일 생성 실패");
			}
			}catch(IOException e) {
				System.out.println("에러"+e.getMessage());
			}
		}
	//마지막 수정일 가져오기
		
		long lastDate = f2.lastModified();
		        //밀리초로 구해진다.
		System.out.println(lastDate);
		
		
      //밀리초를 날짜로 전환
		Calendar now = Calendar.getInstance();//현재
		//구해놓은 밀리초를 컬린더에 세팅
		now.setTimeInMillis(lastDate);
		//년도 월 일 2021-01-12 오후 03:01
		SimpleDateFormat format=new SimpleDateFormat("YYYY-MM-DD a hh:mm");
		String lastDateStr=format.format(now.getTime());
		System.out.println(lastDateStr);
		
		//파일이 실행가능,읽을수 있는지,쓸수 있는지,파일인지,디렉토리인지 나옴
		System.out.println(f2.canExecute());
		System.out.println(f2.canRead());
		System.out.println(f2.canWrite());
		System.out.println(f2.isFile());
		System.out.println(f2.isDirectory());
		System.out.println("----------------------------");
		
		//특정 드라이브에 또는 특정 폴더의 폴더목록,파일목록을 구한다.
		File f4=new File("c://");
		File file[]=f4.listFiles();
		//getpath() 드라이브명 경로 파일명
		//getname() 파일명
		//getAbsoluteName():드라이브명,경로,파일명
		//getParent():드라이브 경로
		/*
		for(File f : file) {
			System.out.println(f.getPath()+"[폴더]");
			
		}else(f.isFile()) {
			System.out.println(f.getpath()+"[파일]");
		}else(f.isHidden()){
			System.out.println(f.getPath()+"[숨긴파일]");
		}
		
		*/
		
		//현재컴퓨터의 드라이브 목록
		File drive[]= File.listRoots();
		for(File f:drive) {
			System.out.println(f.getPath());
		}
		
		//파일크기구하기
		long size = f2.length();
		System.out.println(size);
		
		//파일삭제
		f3.delete();
		System.out.println("파일삭제");
		
		
		
	}

	public static void main(String[] args) {
		new FileTest();
	}

}
