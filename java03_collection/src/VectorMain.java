

import java.util.Calendar;
import java.util.Random;
import java.util.Vector;

public class VectorMain {

	public VectorMain() {
		
	}

	public static void main(String[] args) {
		VectorTest vt=new VectorTest();
		Vector vv=vt.getData();
		//이렇게 묶어서 보내지는것이 컬렉션임
		//컬렉션의 객체 얻어오기 - 객체가 지워지지 않음
		//Member m1 =vv.elementAt(2); 상속관계때문에 에러남/ v.add(member); 
		//맴버를 오브젝에 넣는것 -->하위클래스(맴버)가 상위클래스(오브젝트)로 들어감-->오브젝트형임상위클래스가 하위 클래스로 들어가는것이 됨
		//타입캐스팅 해야함-->원래 데이터 타입으로 바꿔주기
		Member m1 =(Member)vv.elementAt(2);
		Calendar date=(Calendar)vv.get(5); //하위클래스인 캘린더로 다시 타입캐스팅
		
		m1.memberPrn();
		System.out.println(date);
		
		//System.out.println("객체의 수"+vv.size());
		//마지막 객체 얻어오기
		Random ran=(Random)vv.lastElement(); //
		System.out.println("난수"+ran.nextInt());
		
		//객체 지우기
		vv.remove(3);
		vv.removeAllElements();
		System.out.println("객체의 수"+vv.size());
		
		//하나의 묶음하는 기능, 중간에 넣고 ,사이즈 신경안쓰고,지울때도 자유
		//제일 많이 쓰는 콜렉션
		
		//리스트-저장순서 유지,벡터랑 기능 같음
		//E을 제너릭클래스라고 함
		
	}

}