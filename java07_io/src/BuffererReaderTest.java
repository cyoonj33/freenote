import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BuffererReaderTest {

	public BuffererReaderTest() {
		// 한줄단위로 입력할 수 있는 클래스
		try {
		InputStreamReader isr=new InputStreamReader(System.in); //길
		BufferedReader br = new BufferedReader(isr); //한글 문장 읽어오기(버퍼는 한줄)
		
		System.out.println("문자열입력=");
		
		String inData = br.readLine();
		System.out.println("inData="+inData);
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	}

	public static void main(String[] args) {
		new BuffererReaderTest();

	}

}
