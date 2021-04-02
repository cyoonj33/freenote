package com.bitcamp.home;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.bitcamp.home.data.DataVO;

public class DBCPConn {
	protected Connection con=null;
	protected PreparedStatement pstmt = null;
	protected ResultSet rs=null;
	protected String sql=null;
	
    //디비연결
	public void getConn() {
		try {
			Context ctx=new InitialContext();
			Context envCtx=(Context)ctx.lookup("java:comp/env");
			
			DataSource ds=(DataSource)envCtx.lookup("jdbc/myoracle");
			con=ds.getConnection();
			
		}catch(Exception e) {
			System.out.println("dbcp에러"+e.getMessage());
		}
	}
	
	//디비 종료
	public void getClose() {
		try {
			sql=null;
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null)con.close();
		}catch(Exception e) {}
	}

	public List<DataVO> dataSelectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
