import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

	public FileReaderTest() {
		try {
		File f= new File("C://download//down//scott2.sql");
		FileReader fr=new FileReader(f); //1파일 객체로 만들어준거임
		// FileReader fr=new FileReader("C://download//down//scott2.sql"); 이것도 가능
		
		BufferedReader br=new BufferedReader(fr);
		while(true){
			
			//int read = fr.read();   // 2
			//if(read==-1)break;
			//System.out.println((char)read);
			
			String read= br.readLine();
			if(read==null)break;
			System.out.println(read);
		}
		
		
		}catch(FileNotFoundException fnfe) {
			System.out.println("파일없음");
		}catch(IOException ie) {
			System.out.println("파일 읽기 에러 발생");
		}
	}

	
	
	
	public static void main(String[] args) {
	  new FileReaderTest();

	}

}
