import java.io.File;
import java.io.FileWriter;

public class FileWriterTest {

	public FileWriterTest() {
		try {
			File f=new File("C://javalo/test_file.txt");
			FileWriter fw=new FileWriter(f);
			String txt = "자바에서 문자열을 파일로 쓰기 연습중!!";
			
			//배열로 저장
			char c[]=txt.toCharArray();
			fw.write(c,  5  ,   c.length-5);
			fw.flush();
			
			//문자열로 쓰기
			fw.write(txt,0,txt.length());
			fw.flush();
		
			
			fw.close();
		    
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("end");
	}

	public static void main(String[] args) {
		new FileWriterTest();

	}

}
