package com.bitcamp.library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
    static {
    	try {
    		Class.forName("oracle.jdbc.driver.OracleDriver");
    		
    	}catch(Exception e) {
    		System.out.println("드라이버 로딩 에러--->"+e.getMessage());
    	}
    	
    	
    }
    protected Connection conn=null;
    protected PreparedStatement pstmt=null;
    protected ResultSet rs=null;
    protected String sql=null;

    protected String url="jdbc:oracle:thin:@localhost:1521:xe";
    
    
    
    
    public void connection() {
    	try {
    		conn=DriverManager.getConnection(url,"c##scott","tiger");
    		
    	}catch(Exception e) {
    		System.out.println("데이터 연결 에러--->"+e.getMessage());
    	}
    }
    
    
    
	public void closeDB() {
		try {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
			
		}catch(Exception e) {
			System.out.println("데이터베이스 닫기 에러--->"+e.getMessage());
		}
	}
	
	
}
