package com.bitcamp.myapp.ajax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {
	
	@RequestMapping("/ajaxView")
   public String ajaxView() {
	   return "ajax/ajaxView";
   }
	//한글이 리턴되는 경우 인코딩
	
	@RequestMapping(value="/ajaxString", method=RequestMethod.GET,produces="application/text;charset=UTF-8")
	@ResponseBody//아이작스 컨트롤러인경우  return 이 곧 데이터이다.
	public String ajaxString(String num,String name, String id) {
		return num+","+name+","+id;
		
	}
  /* public String ajaxString(HttpServletRequest req) {
		 String num = req.getParameter("num");
		 String name= req.getParameter("name");
		 String id = req.getParameter("id");
		
		 String msg= "num="+num+",name="+name+",id="+id;
		 System.out.println(msg);
		 
		 return "서버에서 받은 데이터"+msg;
	}
	*/
	
	@RequestMapping("/ajaxObject")
	@ResponseBody
	public TestVO ajaxObject(TestVO vo) {
		vo.setTel("010-1111-2222");
		vo.setAddr("서울시 마포구 백범로");
		return vo;
	}
	
	@RequestMapping("/ajaxList")
	@ResponseBody
	public List<TestVO> ajaxList() {
		
		  List<TestVO>list = new ArrayList<TestVO>();
		  list.add(new TestVO("1","바나나","B","010-1112-2222","서울시 과일구"));
		  list.add(new TestVO("2","토마토","T","010-1113-2222","서울시 과일구"));
		  list.add(new TestVO("3","체리","CH","010-1114-2222","서울시 과일구"));
		  list.add(new TestVO("4","오렌지","O","010-1115-2222","서울시 과일구"));
		  list.add(new TestVO("5","자몽","J","010-1116-2222","서울시 과일구"));
		  return list;
	   }
	
	@RequestMapping("/ajaxMap")
	@ResponseBody
   public HashMap<String, TestVO> ajaxMap() {
	   HashMap<String, TestVO> map=new HashMap<String,TestVO>();
	   
	   map.put("p1",new TestVO("2","노랑","Y","010-1111-1111","서울시 물감구"));
	   map.put("p2",new TestVO("3","파랑","Y2","010-1111-1111","서울시 물감구"));
	   map.put("p3",new TestVO("4","핑크","Y3","010-1111-1111","서울시 물감구"));
	   
	   return map;
   }
	
	@RequestMapping(value="/ajaxJson",method=RequestMethod.GET,produces="application/text;charset=UTF-8")
	@ResponseBody
	public String ajaxJson() {
		int no=1234;
		String name="홍길동";
		String tel="010-1234-5677";
		String addr="서울시 마포구";
		
		String jsonStr="{\"no\":\""+no+"\",\"name\":\""+name+"\",\"tel\":\""+tel+"\",\"addr\":\""+addr+"\"}";
		System.out.println(jsonStr);
		return jsonStr;
	}
	
	//{"no":"1234",
	
	
}
