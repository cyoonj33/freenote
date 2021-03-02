
public class DeleteTest extends DBConnection{

	public DeleteTest() {
		try {
			getconn();
			sql="delete from member where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,47);
			
			int result=pstmt.executeUpdate();
			if(result>0) {
				System.out.println(result+"개의 레코드가 삭제되었습니다.");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}

	public static void main(String[] args) {
		new DeleteTest();

	}

}
