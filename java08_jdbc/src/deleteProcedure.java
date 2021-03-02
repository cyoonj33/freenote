import java.sql.CallableStatement;

public class deleteProcedure extends DBConnection{

	
	
	
	public deleteProcedure() {
		try {
			getconn();
			sql="{call mem_delete(?)}";
			CallableStatement cstmt = conn.prepareCall(sql);
			
			cstmt.setString(1, "비둘기");
			
			int r=cstmt.executeUpdate();
			
			if(r>0)
			{System.out.println("회원삭제");}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}
	
	
	

	public static void main(String[] args) {
		new deleteProcedure();

	}

}
