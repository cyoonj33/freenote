import java.sql.CallableStatement;

public class insertProcedure extends DBConnection{
////////삽입하기/////////////////
	public insertProcedure() {
		try {
			//1연결
			getconn();
			//2preparedStatement
			//프로시저 호출하는 메소드
			sql="{call mem_insert(?,?,?,?)}";
			CallableStatement cstmt = conn.prepareCall(sql);
			cstmt.setString(1, "비둘기");
			cstmt.setString(2, "010-9099-9999");
			cstmt.setString(3, "bbbb@naver.com");
			cstmt.setString(4, "구구구구");
			//3실행
			int r=cstmt.executeUpdate();
			if(r>0)
			{System.out.println("회원등록");}
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			dbClose();
		}
		
		
		
		
		
		
	}

	
	
	
	public static void main(String[] args) {
	    new insertProcedure();

	}

}
