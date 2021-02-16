import java.util.LinkedList;

public class LinkedListTest {

	public LinkedListTest() {
		//리스트와 큐,데큐를 상속받음
		//객체를 get하면 콜렉션에서 객체가 지워진다. 리스트의 기능도 가지고 있지만
		//que:객체를 한쪽에서 추가 ,다른쪽에서 제거
		//deque:객체를 양쪽에서 추가,제거할수 있다.
		
		LinkedList<String>ll = new LinkedList<String>();//제너릭이 포함//제너릭은 api에서 e로 표기
		//데이터 추가
		ll.offer("djs");
		ll.offer("2332");
		ll.offer("어아");
		ll.offer("호랑이");
		ll.offerFirst("1등");//먼저 나오게하기
		
		//제일 마지막꺼를 pop하고 싶음
		System.out.println(ll.pollLast());
		System.out.println(ll.get(1));//객체가 지워지지 않는다.
		
		while(!ll.isEmpty()) {//컬렉션이 비어있는지 확인후 true,false리턴
			System.out.println(ll.pop());
		}//비어있을때까지 진행
		
		//객체수
		System.out.println("size"+ll.size());//인덱스가 있긴 하지만 순서필요하면 리스트씀
	}//삭제하거나 추가하면 인덱스가 바뀜-->옛 데이터 다 지우는 링크드리스트...

	public static void main(String[] args) {
		new LinkedListTest();
///스택도 리스트 상속받음-->순서유지-->abce있으면 c꺼낼때 abc까지..
		
	}

}
