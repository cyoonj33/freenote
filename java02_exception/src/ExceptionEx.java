import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionEx {

	public ExceptionEx() {
		
	}
     public void start() {
    	 Scanner sc = new Scanner(System.in);
    	 do {
    		 
    	 
    	 try {
    	 
    	 System.out.println("1수=");
    	 //int num1= sc.nextInt();///---숫자 아닌거 들어왔을때    inputmismatch
    	 //콘솔의 문자열 1줄을 입력받아서
    	 int num1= Integer.parseInt(sc.nextLine()); //parseInt는 오류뜸
    	 
    	 System.out.println("2수=");
    	 //int num2= sc.nextInt();
    	 int num2= Integer.parseInt(sc.nextLine());
    	 
    	 int re= num1 * num2;
    	 int re2=num1/num2; ///--0으로 나누기  Arithmetic
    	 
    	 System.out.println(num1+"*"+num2+"="+re);
    	 System.out.printf("%d/%d=%d\n",num1,num2,re2);
    	 
    	 String names[]= {"세종대왕","이순신"};
    	 for(int i=0; i<=names.length;i++) {///배열 index ArrayIndexOutOfBoundsException
    		 System.out.println(i+names[i]);
    	 }
    	 
    	 }catch(NumberFormatException nfe) { //와일문 반복시킬라고 넥스트인트 대신에 파라스인트사용하여서 밑에꺼 주석처리하고, 새 오류 캐치
    		 System.out.println("숫자만 입력하세요...");
    	 
    	 //catch(InputMismatchException ime) {
    		// System.out.println("숫자만 입력하세요...");
    		 
    	 }catch(ArithmeticException ae) {
    		 System.out.println("두번째값은 0외의 값을 입력하세요");
    	 }catch(ArrayIndexOutOfBoundsException ai) {
    		 System.out.println("배열의 index를 잘못사용하였습니다");   //캐치의 수는 제한이 없음
    	 }
    	 
     }while(true);
}

	public static void main(String[] args) {
		new ExceptionEx().start();

	}

}
