

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest {

			 //2.db연결
			 Connection conn=null;
			 String url="jdbc:oracle:thin:@localhost:1521:xe";
			 String userid="c##scott";
			 String userpwd="tiger";
			
			 //1.jdbc 드라이브 
			 //맴버 영역에 시행문 사용법
				 static{
					 try {
						 Class.forName("oracle.jdbc.driver.OracleDriver");
						 System.out.println("로딩됨");
					 }catch(Exception E) {
						 System.out.println("로딩실패");
					 }
				 }
			 
			 
		    
	public InsertTest() {
		 try {
			
			 Connection conn = DriverManager.getConnection(url,userid,userpwd);
			 
			 conn.setAutoCommit(false);
			 InputStreamReader isr = new InputStreamReader(System.in);
			 BufferedReader br = new BufferedReader(isr);
			 
			 do {
				 
				 System.out.println("이름=");
				 String username=br.readLine();
				 System.out.println("연락처=");
				 String tel = br.readLine();
				 System.out.println("이메일");
				 String email = br.readLine();
				 System.out.println("주소=");
				 String addr = br.readLine();
				
				 
		 //3.preparedStatement를 생성
				String sql="insert into member(num,username,tel,email,addr,writedate) "
						+ " values(memsq.nextval,?,?,?,?,sysdate)";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				//?에 값을 세팅
				pstmt.setString(1,username);
				pstmt.setString(2,tel);
				pstmt.setString(3, email);
				pstmt.setString(4, addr);
				 
				
				//4.실행
				int result=pstmt.executeUpdate();
				
			/*	sql="insert into member(num,username, tel, email, addr, writedate)"+
						" values(memsq.nextval,?,?,?,?,sysdate)";
				
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,"AAAA");  ///에러 발새함
				pstmt.setString(2,"010-2222-4534");
				pstmt.setString(3, "ASD@naver.com");
				pstmt.setString(4, "서울시");
				
			*/	int result2 = pstmt.executeUpdate();
				if(result>0 ) {  //if(result>0 && result2>0) {
					conn.commit();
					System.out.println("회원등록 되었습니다.");
				}else {
					System.out.println("회원등록 실패");
				}
				 
			 }while(true);
			 
		 }catch(Exception e) {
			 //예외발생하면 먼저 정상실행된 쿼리실행문 취소
			try {
				conn.rollback();
			}catch(SQLException se) {
				se.printStackTrace();
			}
			 e.printStackTrace();
		 }
	}

	public static void main(String[] args) {
		new InsertTest();
		
	}

}
