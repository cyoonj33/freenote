package com.bitcamp.home.data;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitcamp.home.CommandService;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class DataFormOkCommand implements CommandService {

	@Override
	public String processStart(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//파일 업로드 할 위치의 절대경로 구하기
				String path=req.getServletContext().getRealPath("/upload");
				System.out.println("path-->"+path);
				
				//1.request객체 2.서버에 파일업로드가 될 위치(절대경로) 3.업로드 가능 최대크기(byte) 4.Encoding 5.파일명 rename
				int maxSize = 1024*1024*1024;
				DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
				//form의 데이터 파일업로드 완료
				MultipartRequest mr= new MultipartRequest(req, path, maxSize, "UTF-8", policy);
				
				DataVO vo=new DataVO();
				vo.setTitle(mr.getParameter("title"));
				vo.setContent(mr.getParameter("content"));
				
				
				HttpSession ses = req.getSession();
				vo.setUserid((String)ses.getAttribute("userid"));
				
				vo.setIp(req.getRemoteAddr());
				
				//폼의 type='file' 태그의  name 속성의 값을 구한다.
				Enumeration fileList = mr.getFileNames();////filename2,filename1
				int idx=0;
				while(fileList.hasMoreElements()) {
					//System.out.println(fileList.nextElement());
					String nameAttr=(String)fileList.nextElement();//필드명을
					String newFilename=mr.getFilesystemName(nameAttr);//새 파일명 얻어오기
					// mr.getOriginalFileName(nameAttr);//원래 파일명
					System.out.println("newFilename-->"+newFilename);
					
					////////////////////////////////////
					if(newFilename!=null) {
						vo.getFilename()[idx++]=newFilename;
					}
				}
				
				DataDAO dao=new DataDAO();
				int cnt=dao.dataInsert(vo);
				
				//레코드 추가 실패시 업로드 파일 삭제
				if(cnt<=0) {
					for(String delFile:vo.getFilename()) {
						if(delFile!=null) {
							try {
							File f=new File(path,delFile);
							f.delete();
							}catch(Exception e) {System.out.println("파일삭제에러");}
						}
					}
				}
				
				req.setAttribute("cnt", cnt);
				
				return "/data/dataFormOk.jsp";
		
	}

}
