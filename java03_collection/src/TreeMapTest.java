import java.util.Collection;
import java.util.Hashtable;
import java.util.Set;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.NavigableSet;

public class TreeMapTest {

	public TreeMapTest() {
		// 트리맵: 키,벨루어 가짐 /키를 기준으로 정렬
		
TreeMap<String,Member > ht=new TreeMap<String,Member>();
		
		Member m1= new Member(100,"홍길동","010-1111-2222","서울시 중구");
		ht.put("홍길동", m1);
		ht.put("김길동", new Member(200,"김길동","010-5555-8888","서울시 종로구"));
		ht.put("라랄",new Member(300,"라랄","010-4567-1234","서울 서대문구"));
		ht.put("루루",new Member(400,"루루","010-2222-1234","서울 마포구"));
		ht.put("밍밍",new Member(500,"밍밍","010-3333-1234","서울 서대문구"));
		ht.put("친구",new Member(600,"친구","010-4444-1234","서울 마포구"));
		
		Member m= ht.get("라랄");
		m.memberPrn();
		
		System.out.println("-------------------------------------key로 목록 구하기");
		Set<String> set = ht.keySet();
		Iterator <String>ii=set.iterator();
		while(ii.hasNext()) {
			Member mm=ht.get(ii.next());
			mm.memberPrn();
		}
		
		
		
		System.out.println("--------------descendingKeySet()---");
		NavigableSet<String>desckey=ht.descendingKeySet();
		Iterator <String>iii=desckey.iterator();
		while(iii.hasNext()) {
			Member mm=ht.get(iii.next());
			mm.memberPrn();
		}
		
		
		
		System.out.println("--------------------values를 이용한 정보 구하기---");
		
		Collection<Member>value = ht.values();
		Iterator<Member>iiih=value.iterator();
		while(iiih.hasNext()) {
			Member vvv=iiih.next();
			vvv.memberPrn();
		}
		
	}

	public static void main(String[] args) {
		new TreeMapTest();
		
		

	}

}
