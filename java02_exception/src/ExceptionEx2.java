import java.util.Scanner;

public class ExceptionEx2 {
	Scanner sc = new Scanner(System.in);

	public ExceptionEx2() {
		
	}
    public void start() {
    	try {
    	System.out.println("1수=");
   	    int num1= Integer.parseInt(sc.nextLine()); //parseInt는 오류뜸
   	 
   	 System.out.println("2수=");
   	 //int num2= sc.nextInt();
   	 int num2= Integer.parseInt(sc.nextLine());
   	 
   	 int re= num1 * num2;
   	 int re2=num1/num2; ///---!!! --0으로 나누기  Arithmetic
   	 
   	 System.out.println(num1+"*"+num2+"="+re);
   	 System.out.printf("%d/%d=%d\n",num1,num2,re2);
   	 
   	 String names[]= {"세종대왕","이순신"};
   	 for(int i=0; i<=names.length;i++) {///배열 index ArrayIndexOutOfBoundsException
   		 System.out.println(i+names[i]);
   	 }
    	}catch(ArrayIndexOutOfBoundsException aoe) {
    		System.out.println("배열에서 예외발생...");
    		
    	}catch(Exception e) {
    		System.out.println("0을 제외한 정수를 입력하세요"+e.getMessage());
    	}
    }
	public static void main(String[] args) {
		new ExceptionEx2().start();

	}

}
