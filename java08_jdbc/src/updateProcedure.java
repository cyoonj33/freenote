import java.sql.CallableStatement;

public class updateProcedure extends DBConnection {

	public updateProcedure() {
		// 이름을 입력받아 연락처,이메일,주소 입력 수정
		try {
			getconn();
			
			sql="{call mem_update(?,?,?,?)}";
			CallableStatement cstmt = conn.prepareCall(sql);
			
			
			cstmt.setString(1, "5");
			cstmt.setString(2, "010-0000-9999");
			cstmt.setString(3, "bidulgi@naver.com");
			cstmt.setString(4, "구구구");
			//3실행
			int r=cstmt.executeUpdate();
			
			if(r>0)
			{System.out.println("회원수정");}
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		
		
		
		
		
		
		
	}

	public static void main(String[] args) {
		new updateProcedure();

	}

}
