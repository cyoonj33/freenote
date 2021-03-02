
public class UpdateTest extends DBConnection{

	public UpdateTest() {
		
	}
	public void setUpdate() {
		try {
			getconn();
			
			sql = " update member set tel=? where username=? ";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "010-4344-7777");
			pstmt.setString(2, "차윤주");
			int result= pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println(result+"개의 레코드가 수정되었습니다.");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//finally는 무조건 실행됨
			dbClose();
		}
		
		
	}

	public static void main(String[] args) {
		new UpdateTest().setUpdate();

	}

}
