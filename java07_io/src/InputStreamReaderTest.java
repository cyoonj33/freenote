import java.io.InputStreamReader;

public class InputStreamReaderTest {

	public InputStreamReaderTest() {
		
		try {
		//3문자단위 처리하는 클래스  InputStreamReader(InputStream in)
			
		InputStreamReader isr = new InputStreamReader(System.in);
		
		System.out.println("=");
		while(true){
			/*
		int inData=isr.read();//한번에 1문자씩읽음
		System.out.println(inData+","+(char)inData);
		
		*/
			//4캐릭터 배열을 이용해 여러문자를 한번에 읽어오기
			char[]inData=new char[30];
			//읽은 문자의 수
			int cnt =isr.read(inData);
			
			String inStr1=new String(inData,0,cnt);
			String inStr2=String.valueOf(inData,0,cnt);
			
			System.out.println(inStr1+"---");
			System.out.println(inStr2+"===");
			
		}
		
	}catch(Exception e) {
		System.out.println(e.getMessage());
		
			
			
	}
	}
	
	public static void main(String[] args) {
		new InputStreamReaderTest();
       
	}

}
