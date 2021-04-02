package com.bitcamp.home.data;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.bitcamp.home.CommandService;

public class MultiUploadOkCommand implements CommandService {

	@Override
	public String processStart(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		//저장할 위치
		String path = req.getServletContext().getRealPath("/upload");
		
		try {
			
			//1.팩토리 객체 생성
			DiskFileItemFactory dfif=new DiskFileItemFactory();
			//2.팩토리에 업로드 위치 샛팅
			File f = new File(path);
			dfif.setRepository(f);
			
			//3.ServletFileUpload 객체생성
			
			ServletFileUpload fileUpload = new ServletFileUpload(dfif);
			
			
			//FileItem객체
			
			//4.폼의 필드수만큼 파일 아이템을 구할 수 있다.
			List<FileItem> items = fileUpload.parseRequest(req);
			//System.out.println("items"+items.size());
			
			
			DataVO vo =new DataVO();
			for(FileItem item:items) {
				//텍스트 필드인지, 첨부파일인지
				if(item.isFormField()) {
					//제목,글내용
					//필드명알아내기
					String fieldName = item.getFieldName();//필드명
					String value = item.getString("UTF-8");//값
					
					if(fieldName.equals("title")) {vo.setTitle(value);}
					if(fieldName.equals("content")) {vo.setContent(value);}
					
				}else {
					//파일의 크기를 구하여 0보다 크명 실행한다
					
					if(item.getSize()>0) {//파일크기
						String oriFilename = item.getName();//원래 파일명  ->aaa.gif
						
						//////////////////////////////////////////////
						//파일명과 확장자를 분리
						int dot=oriFilename.lastIndexOf(".");//.의 위치
						String filename=oriFilename.substring(0,dot);
						String ext = oriFilename.substring(dot+1);
						
						File file = new File(path,oriFilename);
						int idx=1;
						while(file.exists()) {//있으면 true,없으면:false
						  file=new File(path, filename+"_"+idx++ +"."+ext);
						  
							
						}//while
						//업로드 실행
						item.write(file);
						
						
					}//파일if
				}//if
			}//for
			
			System.out.println("제목"+vo.getTitle());
			System.out.println("내용"+vo.getContent());
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "/index.jsp";
		
	
		
		
	}

}
