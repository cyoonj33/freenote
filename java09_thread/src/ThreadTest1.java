
//무한루프 동시에 돌리기
public class ThreadTest1 extends Thread{
     String title;
     
	public ThreadTest1(String title) {
		this.title=title;
		
	}
	
	public ThreadTest1() {
		
	}
	
	//2run()메소드 오버라이딩 처리
	
	public void run() {
		for(int i=1;;i++) {
			System.out.println(title+"i="+i);
			try {Thread.sleep(500);}catch(Exception e) {
				
			}
		}
	}

	public static void main(String[] args) {//메인메소드도 스레드임
		ThreadTest1 tt1= new ThreadTest1("첫번째 스레드");
		ThreadTest1 tt2= new ThreadTest1("두번째 스레드");
		
		//3.스레드 등록
		tt1.start();
		tt2.start();
	}

}
