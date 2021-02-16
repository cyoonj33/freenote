

import java.util.Calendar;
import java.util.Random;
import java.util.Vector;

public class VectorTest {

	public VectorTest() {
		// TODO Auto-generated constructor stub
	}
     public Vector getData() {
    	 int num=12;
    	 String name="홍길동";
    	 Member member= new Member();
    	 Member member2= new Member(500,"이순신","010-7777-8888","서울시 종로구 동안동");
    	 Calendar now = Calendar.getInstance();
    	 Random ran = new Random();
    	 //백터는 입력 순서 유지,중복,중간에 데이터 추가하고 삭제 수정가능
    	 Vector v= new Vector();
    	 v.add(num);
    	 //add(E e),addElement(E obj),add(int index,E element) E가 오브젝임
    	 //다른수들 랜덤클래스 캘린더 클래스는 오브젝트에 들어감 상속가능
    	 //int string 과 같은 변수들은 클래스가 아님! 상위 클래스도 없음/즉 오브제에도 못 넣음/
    	 //v.add(num); 그러나 int 값 들어감... //v.add(new Integer(num)); 인티저로 넘어감
    	 v.addElement(name);
    	 v.add(member); //맴버를 오브젝에 넣는것 -->하위클래스(맴버)가 상위클래스(오브젝트)로 들어감-->오브젝트형임
    	 v.add(member2);
    	 v.addElement(now);
    	 v.addElement(ran);
    	 
    	 
    	 //중간에 개체 추가하기 add(int index,E element)
    	 v.add(3,new String("hong gill dong"));
    	 
    	 
    	 System.out.println("v.capacity="+v.capacity());//메모리 10나옴 그러나 자동으로 공간 계속 확장됨
    	 
    	 return v; //밖으로 내보냄 백터라는 컬랙션 만들어서 밖으로 보내는거임
     }
}