
public class ExceptionTest2 {

	public ExceptionTest2() {
		try {
			//실행부
			int data[]= {10,8,96,32,54};
			System.out.println(data[data.length-1]);/////01234 까지만 있으니, 랭스로 하면 5임->오류//-1하면 오류 없어짐...캐치문은 패스하게됨
		}catch(ArrayIndexOutOfBoundsException ae) {
			System.out.println("배열의 인덱스를 잘못입력하였습니다"+ae.getMessage());
		}finally {
			System.out.println("무조건 실행");
		}
	}

	public static void main(String[] args) {
		 new ExceptionTest2();

	}

}
//1은 트라이 캐치만들기  2메소드로 처리하기 throws