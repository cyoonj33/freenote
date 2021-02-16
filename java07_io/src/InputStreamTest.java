import java.io.IOException;
import java.io.InputStream;

public class InputStreamTest {

	public InputStreamTest() {
		//int a= new int[10];
		//for(int b:a) {
		//	System.out.println(b);
		//}
		
		try {
		//인풋스트림은 =추상메소드로 뉴 안됨-->객체 생성못함
		//인풋스트림은 바이트로 입력받음
			
		InputStream is=System.in;
		System.out.println("입력=");
		//1read()->입력문자를 1바이트씩 읽어온다
		while(true) {
			/*
		int inData =is.read();//읽을 데이터가 없을때 -1
		if(inData==-1) break;
		System.out.println(inData+","+(char)inData);
		*/
			
			
		/*
			//2read(a[]) 배열의 크기만큼 한번에 읽어온다
			byte inData[]= new byte[50];
			//읽은 바이트 배열의 저장
			int cnt=is.read(inData); //String(byte[] bytes) 스트링에서 바이트 바꾸는거 있나 보기
			System.out.println(new String(inData,0,cnt)+"-->"+cnt);
			if(cnt<=0)break;
		
		
			//3read(byte[] b, int off, int len)
		*/
		
			byte inData[]=new byte[10];
			//           읽은 데이터 담을 배열,배열의 저장위치 inDex,읽어올 바이트의 갯수
			int cnt = is.read(inData,3,4);
			for(int i=0; i<inData.length; i++) {
				System.out.println(i+","+inData[i]);
			}
			
			
			
			
		}
	}catch(IOException e) {
		System.out.println(e.getMessage());
	}
		
	}

	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		new InputStreamTest();

	}

}
