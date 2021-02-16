
public class ATM implements Runnable{
    private int money = 20000; //통장잔액
    
    
	public ATM() {	
	}
	
	
	
    //스레드 처리 - 출금처리
	//스레드의 동기화 sychronized (thread가 구현되는 동안 다른 스레드는 대기하고 있어야 한다.)
	//1.run()메소드의 반환형 왼쪽에 sychronized키를 추가한다.
	//public synchronized void run() { //1번방법
	 public void run() {               //2실행부의 동기화 처리
		 synchronized(this){ 
		for(int i=1; i<=10; i++) {
			getCash(1000);
			//동기화 및 해재
			if(money%2000==0) {
				//동기화 해체
				try {
				this.wait();
				}catch(InterruptedException ie) {}
			}else {
				//동기화
				this.notify();
			}
		  }
	   }
	 }
	
	public void getCash(int cash) {
		if(money>0) {
			money-=cash;
			System.out.println(Thread.currentThread().getName()+", 잔액="+money);
		}else {
			System.out.println("잔액부족");
		}
	}
	
	
	
	
	public static void main(String[] args) {
		ATM atm=new ATM();
		Thread t1=new Thread(atm, "mother");
		Thread t2=new Thread(atm, "son");
		
		t1.start();
		t2.start();

	}

}
