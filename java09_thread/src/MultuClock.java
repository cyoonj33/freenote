
public class MultuClock {

	public MultuClock() {
	
		
	}

	public static void main(String[] args) {
		DigitalClock dc1=new DigitalClock(1,1,500,200);
		DigitalClock dc2=new DigitalClock(501,1,500,200);
		DigitalClock dc3=new DigitalClock(1,201,500,200);
		DigitalClock dc4=new DigitalClock(501,201,500,200);

		Thread t1=new Thread(dc1);
		Thread t2=new Thread(dc2);
		Thread t3=new Thread(dc3);
		Thread t4=new Thread(dc4);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}

	
}
