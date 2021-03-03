

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectTest {
	
	//1드라이브로딩2망연걸3psmt4실행 쿼리문실행-리절트셋이라는 객체 리턴됨
	
	    static {
			    	try {
			    		Class.forName("oracle.jdbc.driver.OracleDriver");
			    	}catch(Exception e) {
			    		System.out.println("드라이브 로딩 에러 발생");
			    	}
			    	
			    }
	    Connection conn = null;
		PreparedStatement pstmt = null;
	
	
		 String url="jdbc:oracle:thin:@localhost:1521:xe";
		 String userid="c##scott";
		 String userpwd="tiger";
	 
	public SelectTest() {
		
	}

	public void recordSelect() {
		try {
			conn= DriverManager.getConnection(url, userid ,userpwd);
			
			String sql=" select num,username,tel,email,writedate,addr from member "+ //꼭 띄어쓰기 해줘야함 ""안에서
			" order by num asc ";
			
			pstmt = conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			//rs객체에서 포인트 이동하여 레코드의 정보를 얻어온다.
			while(rs.next()) {
				int num=rs.getInt(1); //또는 rs.getInt("num");
				String username=rs.getString(2);// rs.getString("username");
				String tel=rs.getString(3);
				String email=rs.getString(4);
				String writedate=rs.getString(5);
				String addr=rs.getString(6);
				System.out.printf("%d,%s,%s,%s,%s,%s\n",num,username,tel,email,writedate,addr);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new SelectTest().recordSelect();

	}

}
