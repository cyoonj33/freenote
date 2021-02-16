
public class ExceptionTestMethod {

	public ExceptionTestMethod() throws ArithmeticException, NumberFormatException, ArrayIndexOutOfBoundsException{ //2
		method1();//3
	}
    public void method1()throws ArithmeticException, NumberFormatException, ArrayIndexOutOfBoundsException {//4
    	int a=100,b=10;
    	int c=a/b;////에러남 트라이 캐치문사용 또는 메소드에 사용(ArithmeticException-0으로 일어나는 오류잡기) 메소드 옆에 throw+예외문쓰기
    	//생성자메소드에도 똑같이쓰기(결국엔 method1(); 라는 오류포함하니까)
    	System.out.println("c="+c);
    	method2();//5
    }
     public void method2() throws NumberFormatException, ArrayIndexOutOfBoundsException{//6
    	 String numStr="12";
    	 int num = Integer.parseInt(numStr);//오류 생김--NumberFormatException
    	 System.out.println("num"+num);
    	 method3();//7
    	 
     }
	 public void method3() throws ArrayIndexOutOfBoundsException{//8
		 int num[]= {10,20,30};
		 System.out.println(num[num.length-1]);//오류 안생기게 -1넣음
	 }
	public static void main(String args[]){
		try {
		    new ExceptionTestMethod();//1
		}catch(ArithmeticException ae) {
			System.out.println("0으로 나눌수 업음"+ae.getMessage());
		}catch(NumberFormatException nf) {
			System.out.println("문자는 숫자로 변경할 수 없습니다"+nf);
		}catch(ArrayIndexOutOfBoundsException ae) {
			System.out.println("배열의 첨자값이 잘못되었습니다"+ae);
			//ae.printStackTrace();//-어디서 오류났는지 추적
		}
		System.out.println("프로그램 종료");//9
	}
	 
}

///위에 메소드에 넣는 방법과/캐치문쓰는 방법 씀

//내가 원하는 예외만들수 있음
