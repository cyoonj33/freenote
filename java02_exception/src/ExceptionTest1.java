import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest1 {

	public ExceptionTest1() {
		
		try {
		//예외처리하기
	    //예외발생가능한 코드와 가능성이 없는 코드도 명시 가능
		Scanner sc=new Scanner(System.in);
		System.out.println("정수=");
		int n= sc.nextInt();///// 예외 가능성 코드
		System.out.println(n);
		}catch(InputMismatchException ime) {
			//try 영역의 코드가 예외가 발생하면 실행될 영역
			//ime.printStackTrace();   //요거는 에러가 어떻게 나오는지 볼수있음
			//System.out.println(ime.getMessage());
			System.out.println("숫자 잘못 입력");
		}
		//System.out.println("프로그램 종료");
	}

	public static void main(String[] args) {
		new ExceptionTest1();
		
	}

}


//final - 클래스 상속암함
//- 멤버변수 상수화된 변수 -수정불가
//-메소드 오버라이딩 불가

//컴파일 에러-java.exe에서 일어남/런타임에러-데이터에 따라 발생할수 있고 안발생할수 있음
//입셉션 상속받음
//try {}  catch(){} finally{}
//트라이문에서 오류 안생김-캐치문으로 가기- 파이널리로 종료
//트라이문에서 오류 생김-캐치-파이널리