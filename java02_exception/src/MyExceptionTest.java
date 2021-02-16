import java.util.Scanner;

public class MyExceptionTest {
    Scanner sc=new Scanner(System.in);
	public MyExceptionTest() {
		try {
		System.out.println("1~10 정수입력=");
		int data=sc.nextInt(); //InputMismachException
		if (data<1 || data>10) {
			//throw : 강제 예외 발생
			//throw new  MyException();
			throw new MyException();
		}else {
			//정상
			sum(data);
		}
	}catch( MyException e) {
		e.printStackTrace();
	}
	}
    public void sum(int m) {
    	int s=0;
    	for(int i=1; i<m; i++) {
    		s += i;
    	}
    	System.out.println("S="+s);
    	
    }
    
    public void start() {
    	
    }
	public static void main(String[] args) {
		new  MyExceptionTest();

	}

}

//컬렉션 프레임 워크
//서로 다른 데이터타입 묶기
//list  -객체 담으면 저장순서 유지,인덱스가 있음,배열처럼 생각하면됨,   [a,12,5.5,calendar,a]-->요런식으로 순서 유지함/ 리스트를 상속받은 클래스들은 이런 특징을 가짐/데이터 중복도 허용!!!!!!!
//set  - 순서유지 하지 않음,인덱스 없음,중복데이터 허용하지 않음,treeset은 오름차순으로 정렬,(작은데이터 왼쪽 큰데이터 오른쪽)
//map  -key인덱스임 ,value 가 상속받음, 다양한 데이터 씀,

//-------총칭해서 컬렉션이라고 함
//Vector()





