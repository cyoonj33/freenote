
public class MultiPackman {

	public MultiPackman() {
		
		Packman pm1=new Packman();
		Packman pm2=new Packman();
		
		

		Thread tt1=new Thread(pm1);
		Thread tt2=new Thread(pm2);
		
		
		tt1.start();
		tt2.start();
		
	
	}
	
	public static void main(String[] args) {
		new MultiPackman();
}
	
}
