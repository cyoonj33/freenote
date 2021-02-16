package innerClass;

//익명의 내부 클래스

public class AnomTest {

	public AnomTest() {
		start();
	}

	
	
	
	public void start() {
		//익명의 내부 클래스
		new Sample() {
			//실행부
			public void oddSum(int max) {//sample 클래스의 메소드 오버라이딩
				int s=0;
				for(int i=1; i<=max; i+=2) {
					s=s+i;
				}
				System.out.println("1~"+max+"까지의 홀수의 합은"+s);
				
			}
		}.oddSum(100);
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		new AnomTest();
		

	}

	
	
	
	
	
	
}
