package com.bitcamp.home.data;

import java.util.ArrayList;
import java.util.List;

import com.bitcamp.home.DBCPConn;

public class DataDAO extends DBCPConn implements DataDAOIpl {

	@Override
	public int dataInsert(DataVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void dataSelect(DataVO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public int dataUpdate(DataVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int dataDelete(DataVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<DataVO> dataSelectAll() {
		List<DataVO>lst=new ArrayList<DataVO>();
		try {
			getConn();
			sql= " select no, title, userid, filename1, filename2, hit, downcount, to_char(writedate, 'MM-DD HH:MI') "
					+ " from data order by no desc";
			
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				DataVO vo=new DataVO();
				vo.setNo(rs.getInt(1));
				vo.setTitle(rs.getString(1));
				vo.setUserid(rs.getString(1));
				vo.setFilename1(rs.getString(1));
				vo.setFilename2(rs.getString(1));
				vo.setHit(rs.getInt(1));
				vo.setDownCount(rs.getInt(1));
				vo.setWritedate(rs.getString(8));
				lst.add(vo);
				
			}
			
		}catch(Exception e) {
			System.out.println("자료실 레코드 전체선택 에러");
			e.printStackTrace();
		}finally {
			getClose();
		}
		
		return lst;
	}
	
	@Override
	public void hitCount(int no) {
		// TODO Auto-generated method stub

	}

	@Override
	public void downloadCount(int no) {
		// TODO Auto-generated method stub

	}

}
