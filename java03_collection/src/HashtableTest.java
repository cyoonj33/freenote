import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class HashtableTest {

	public HashtableTest() {
		
	}

	public void start() {
		//둘다 키와 발루를 가짐
		//헤시테이블; 동기화(동시 노노 대기)
		//해시맵;동기화 안함(동시에 여러명 가능)
		
		//회원정보 4명 헤시테이블에 저장
		//Hashtable<Key, Value> ht=new Hashtable();
		Hashtable<String,Member > ht=new Hashtable<String,Member>();
		//데이터가 한종류이면 제너릭가능
		//발루는 맴버로/키는 중복데이터 안됨
		
		Member m1= new Member(100,"홍길동","010-1111-2222","서울시 중구");
		ht.put("홍길동", m1);
		ht.put("김길동", new Member(200,"세종","010-5555-8888","서울시 종로구"));
		ht.put("라랄",new Member(300,"이순신","010-4567-1234","서울 서대문구"));
		ht.put("루루",new Member(400,"신이","010-4567-1234","서울 마포구"));
		
		Member vo=ht.get("김길동");
		vo.memberPrn();
	
	//key를 기준으로 가져오기:키를 알고잇을경우
//셋으로 리턴된다
	//Set<E-제너릭임> keyList = ht.keySet();
	Set<String> keyList = ht.keySet();
	
	Object[] obj = keyList.toArray();
	for(Object o: obj)
	{System.out.println(o);
	
	}
	System.out.println("---------------------------");
	Iterator<String> ii=keyList.iterator();
	while(ii.hasNext()) {
		//System.out.println(ii.next());
		Member v=ht.get(ii.next());
		v.memberPrn();
	}
	
	//----------전체 벨루어 객체 목록을 얻어오기
	System.out.println("--------------전체목록--------------------");
	Collection<Member>value = ht.values();
	Iterator<Member>iii=value.iterator();
	while(iii.hasNext()) {
		Member vvv=iii.next();
		vvv.memberPrn();
	}
	///앞에는 키를 구해서 한거고 이거는 벨루어로 얻어옴거
	
	
	}
	
	
	public static void main(String[] args) {
		//헤시맵이랑 헤시테이블은 거의 같음
		new HashtableTest().start();
	}

}
