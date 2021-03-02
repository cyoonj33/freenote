import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
    //1 드라이브로딩
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		}catch(Exception e) {
			System.out.println("드라이브 로딩 에러 발생--->"+e.getMessage());
			
		}
	}
	Connection conn=null;
	PreparedStatement pstmt = null;
	ResultSet rs=null;
	
	String sql=null;
	
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String username = "c##scott";
	String userpwd="tiger";
	
	//db연결하는 메소드와/ db접속 종료하는 메소드 만들기
	
	public void getconn() {
		try {
			conn=DriverManager.getConnection(url,username,userpwd);
		}catch(Exception e) {
			System.out.println("db연결에러 발생-->"+e.getMessage());
		}
	}
	//db접속 종료
	public void dbClose() {
		try{
		if(rs!=null) rs.close();
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
		
		}catch(Exception e) {
			System.out.println("종료 에러="+e.getMessage());
		}
	}
	
	public DBConnection() {
		
	}

}
