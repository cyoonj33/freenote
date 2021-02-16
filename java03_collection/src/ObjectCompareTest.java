import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



public class ObjectCompareTest {

	public ObjectCompareTest() {
		//객체내의 특정 필드로 정렬하기
		List<Member>lst=new ArrayList<Member>();
		
		lst.add(new Member(4,"홍길동","010-111-1234","강원도 삼척시"));
		lst.add(new Member(3,"이순신","010-2222-1234","서울시 종로구"));
		lst.add(new Member(1,"장발장","010-3333-1234","서울시 마포구"));
		lst.add(new Member(2,"룰루","010-5555-1234","경기도 안산시"));
		lst.add(new Member(5,"랄랄라","010-5666-1234","경기도 시흥시"));
		
		System.out.println("==================================");
		for(Member mem : lst) {
			mem.memberPrn();
		}
		
		System.out.println("=================정렬==================");
		//정렬하기
		Collections.sort(lst,new CompareNameDesc());
		for(Member mem:lst) {
			mem.memberPrn();
		}
		
		System.out.println("=========번호 오름차순 정렬============");
		Collections.sort(lst,new CompareNoAsc());
		for(Member mem:lst) {
		mem.memberPrn();
	    
	}
		System.out.println("=========번호를 이용한 내림차순 정렬=============");
		Collections.sort(lst,new CompareNoDesc());
		for(Member mem : lst) {
			mem.memberPrn();
			
		}
		
	}
	class CompareNoDesc implements Comparator <Member>{
		public int compare(Member m1,Member m2) {
			//m1이 작으면 -1,같으면 0,m1이 크면 +1
			    //     4             3                거짓일때 또 조건 넣음
			return (m1.getNo() <  m2.getNo() )? 1 : (m1.getNo()==m2.getNo())? 0 :-1  ;
		}
	}
	
	
	class CompareNoAsc implements Comparator <Member>{
		public int compare(Member m1,Member m2) {
			//m1이 작으면 -1,같으면 0,m1이 크면 +1
			    //     4             3                거짓일때 또 조건 넣음
			return (m1.getNo() <  m2.getNo() )? -1 : (m1.getNo()==m2.getNo())? 0 :1  ;
			
			//(조건)? 참  : 거짓  
		}
	}
	
	
	
	
	//번호를 오름차순으로 정렬
	
	
    //이름을 내림차순으로 정렬하는 내부 클래스
	//**comparator를 상속받아 인터페이스를 만든다. compare메소드를 오버라이딩한다.
	class CompareNameDesc implements Comparator<Member>{
		//<>안에는 제너릭 너줌-->클래스명 넣기
		//음수 ,0,양수 로 넘어감-->음수 리턴함:오른쪽에 있는 객채가 크다.0이나오면 같다,양수:왼쪽이 크다
		//-1,0,1
		public int compare(Member m1, Member m2) {
			        //홍길동                      이순신
		//return m1.getUsername().compareTo(m2.getUsername());//양수나옴
			//       이순신                       홍길동
		return m2.getUsername().compareTo(m1.getUsername());//음수
		}
	}
	//이,홍
	//홍, 이
	
	public static void main(String[] args) {
		new ObjectCompareTest();

	}

}
