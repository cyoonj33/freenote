import java.util.TreeSet;
import java.util.Iterator;

import javax.swing.text.html.HTMLDocument;

public class TreeSetTest {

	public TreeSetTest() {
		//트리셋은 중복허용하지 않음, 입력순서 유지하지 않음 ,크기순서대로 정렬됨
		int numData[]= {10,20,30,40,50,60,60,60,70,90};
		String strData[]= {"홍길동","세종대왕","홍길동","이순신","이순신"};
		
		TreeSet<Integer> ts=new TreeSet<Integer>();
		for(int n:numData) {
			ts.add(n);
		}
		TreeSet<String>ts2=new TreeSet<String>();
		for(String name:strData) {
			ts2.add(name);
			
		}
		
		Iterator<Integer> ii=ts.iterator();//오름차순으로
		while(ii.hasNext()) {
			System.out.println("ts="+ii.next());
		}
		
		Iterator <Integer> iii=ts.descendingIterator();//내림차순
		while(iii.hasNext()) {
			int data=iii.next();
			System.out.println("ts,desc="+data);
		}
		
		
		
	}

	public static void main(String[] args) {
		new  TreeSetTest();

	}

}
///중복제거,정렬해줌