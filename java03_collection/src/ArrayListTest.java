import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

	public ArrayListTest() {
		//다른 종류의 객체 추가 가능
		ArrayList a1=new ArrayList();
		//member객체만 추가 가능 멤버,멤버,멤버 등 멤버형식으로만
		
		List <Member>lst =new ArrayList<Member>(); //ArrayList가 하위클래스라서 가능// 객체 이름 다르면 상속관계라고 생각하기
		
		Member mem1 =new Member(100,"홍길동","010-1111-2222","서울시 서대문구");
		Member mem2 =new Member(200,"길동","010-2222-2222","서울시 서대문구");
		Member mem3 =new Member(300,"동","010-1234-2222","서울시 서대문구");
				
		a1.add(mem1);
		a1.add(mem2);
		a1.add(mem3);
		
		lst.add(mem1);
		lst.add(mem2);
		lst.add(mem3);
		
		a1.add(new String("세종"));
		//lst.add(new String("gkgk"));--제너릭은 다른객체라서 안들어감/같은 종류의 객체만
		
		for(int i=0;i<lst.size();i++) {
			Member m=lst.get(i); //형변환 안해도 됨 제너릭으로 담겨져 있어서
			//Member m1=(Member)a1.get(i); //형변환하기
			m.memberPrn();
		}
		
	}

	public static void main(String[] args) {
		new ArrayListTest();
	}

}
///////////어레이 리스트와 리스트의 차이

///큐와 데큐?
//백터와 어레이리스트는 순서가 있음,원래 데이터 지워지지 않음
//큐는 넣는것 offer 끄집어내는것 poll,pop한쪽으로 데이터 담고 지움-->큐라고 부름//양쪽으로 넣고 뺄수있음-->데큐(은행-큐)
//링크드리스트가 큐를 상속받음,순서유지도 가능


