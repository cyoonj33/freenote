import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {

	public HashSetTest() {
		//set: 입력순서 유지하지 않음
		//중복데이터 허용하지 않음
		int numData[]= {10,20,30,40,50,60,60,60,70,90};
		String strData[]= {"홍길동","세종대왕","홍길동","이순신","이순신"};
		
		HashSet<Integer>hs1=new HashSet<Integer>();
		for(int n:numData) {
			hs1.add(n);
		}
		System.out.println("hs1의 객체수="+hs1.size());
		
		HashSet<String>hs2 = new HashSet<String>();
		for(String s:strData) {
			hs2.add(s);
		}
		System.out.println("hs1의 객체수="+hs2.size());
		
		/////////////////////
		//에리이리스트는 겟/벡터는 엘리멘트엣이나 겟/스택은 팝으로 써서 빼냄
		//헤스넥스트는 확인해주는거//
		Iterator<Integer> i=hs1.iterator();
		while(i.hasNext()) {
			System.out.println("hs1="+i.next());
		}
		
		Iterator<String> j=hs2.iterator();
		while(j.hasNext()) {
			System.out.println("hs2="+j.next());
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new HashSetTest();

	}

}


//트리셋은 정렬해줌
