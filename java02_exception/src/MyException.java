
public class MyException extends Exception {

	
	//1~10까지 갑만 유효한 값이다. 메세지로 설정
	public MyException() {
		super("바보 멍청이 입니다");
	}

	
	
	//매개변수 값이 예외 메세지로 설정
	//public MyException(String message) {
		//super(message);//Exception(message)랑 같은 말임
		
//	}


}
