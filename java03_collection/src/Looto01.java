import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.HashSet;


public class Looto01 {
    Scanner sc=new Scanner(System.in);
    
	public Looto01() {
	}
		
	
	
	public void start() {		
	do {
		int cnt=gameCount();//게임수
		for(int i=1;i<=cnt;i++) {//123
			System.out.println(i+"게임=");
			createLotto();
		}
		//true 는 계속/false는 중지
		if(!qna()) {
			break;
		}
		
	}while(true);
	System.out.println("끝--------------------");
	
	
	}
	
	//1.게임 수 입력
	public int gameCount() {
		
	    int intCnt = 0;
	    do {
	    	
		try {
		System.out.println("게임수=");
		intCnt=Integer.parseInt(sc.nextLine());
		//수가 양수가 아닐경우
		
		if(intCnt<=0){
			throw new Exception("게임수는 1보다 커야합니다");//"5" "Sdf" 문자 입력보기
		     }
		break;//게임수 입력
		}catch(NumberFormatException ne) {
			System.out.println("게임은 정수만 입력해야 합니다");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		
		}
	  }while(true);	
	    return intCnt;
	}
	
	
	
	//2.로또 1게임 만드는 메소드 생성
	public void createLotto() {
		Random ran=new Random();
		TreeSet<Integer> ts=new TreeSet<Integer>();
		int lastNum=0;
		//생성 ->TreeSet -7될때까지
		while(true) {
			lastNum =ran.nextInt(30)+1;//1~45 --마지막으로 만들어진 번호임
			ts.add(lastNum);
			if(ts.size()>=7)break;
			
		}
		//마지막으로 형성된 번호는 보너스이므로 TreeSet에서 제거한다.
		ts.remove(lastNum);
		System.out.print(ts.toString());
	    System.out.println(",bonus="+lastNum);
	    //다나옴 6개까지+1
	}

	public boolean qna() {
		boolean boo =false;
		
		do {
		System.out.println("계속?(y,Y:예/n,N:아니오)");
		String que=sc.nextLine();
		if(que.equalsIgnoreCase("Y")) {//y.equalsIgnoreCase(que)
			gameCount();
		}else if(que.equalsIgnoreCase("N")){
			boo=false;
			break;
			
		}else {System.out.println("다시 입력해 주세요");
			boo=true;
		}
			
	   }while(true);
		return false;
		
}

	public static void main(String[] args) {
		Looto01 lotto = new Looto01();
		lotto.start();
}
	
	
	
	
	
	
	}
