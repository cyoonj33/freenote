import java.util.Enumeration;
import java.util.Properties;

public class PropertiesTest {

	public PropertiesTest() {
		// key,와 value가 스트링인 컬렉션
		Properties prop=new Properties();
		prop.setProperty("네이트", "www.nate.com");
		prop.setProperty("다음", "www.daum.net");
		prop.setProperty("네이버", "www.naver.com");
		prop.setProperty("비트캠프", "www.bit.co.kr");
		
		String url = prop.getProperty("비트캠프");
		System.out.println(url);
		///키 목록 구하기
		Enumeration key = prop.propertyNames();
		while(key.hasMoreElements()) {
			String k=(String)key.nextElement();
			System.out.println("key"+k+", 값="+prop.getProperty(k));
		}
	}

	public static void main(String[] args) {
		new PropertiesTest();
		

	}

}
