package innerClass;


public class MethodInnerMain {
     String email = "abcd2nate.com";
     
	public MethodInnerMain() {
		// TODO Auto-generated constructor stub
	}
	
	public void output() {
		System.out.println(email);
	}

	
	public void innerClassMethod() {
		int num =100;
		//메소드에 정의된 내부 클래스
		class InnerCreate{
			String name= "홍길동";
			InnerCreate(){
				
			}
			void innerPrint() {
				System.out.println(name);
				System.out.println(num);
				System.out.println(email);
				output();
			}
		}
		
		//객체생성
		InnerCreate ic=new InnerCreate();
		ic.innerPrint();
	}
	public static void main(String[] args) {
		MethodInnerMain mic=new MethodInnerMain();
		mic.innerClassMethod();

	}

}
