package com.bitcamp.myapp.test;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
   @RequestMapping(value="/aLink", method=RequestMethod.GET)//매핑 방법1
   public String test(HttpServletRequest req, Model model) {
	   //믈라이언트에서 서버에로 데이터 가져와서 출력
	   String name =req.getParameter("name");
	   String age=req.getParameter("age");
	   System.out.println(name+","+age);
	   
	   //모델 객체 데이터를 셋팅하면 뷰에서 사용할수 있다.
	   model.addAttribute("username",name);
	   model.addAttribute("age",age);
	   model.addAttribute("msg","서버에 클라이언트에게 데이터 보내기");
	   
	   return "mappingTest/aLinkView";
   }
   //requestParam:클라이언트 측 데이터를 서버 request한다.
   
   @RequestMapping("/aLink2") //매핑방법2
   
   public String test2(@RequestParam("name") String username, @RequestParam("age") int age, Model model) {
	  
	   System.out.println("alin2k-->"+username+age);
	   
	   model.addAttribute("username",username);
	   model.addAttribute("age",age);
	   model.addAttribute("msg","@RequestParam을 이용한 데이터 처리");
	   
	   return "mappingTest/aLinkView";
	   
   }
   
   
   @RequestMapping("/aLink3") //vo에 request하여 변수명이 같은 곳으로 값을 setting한다.
   public String test3(TestVO vo,Model model) {
	   System.out.print("TestVO-->"+vo.getUsername()+","+vo.getAge());
	   		vo.setMsg("vo를 이용한 request테스트중");
	   		
	   		model.addAttribute("vo",vo);
	   		return "mappingTest/aLinkView2";
	   		
	   
	 
	   
   }
   
   @RequestMapping("/aLink4")
   public ModelAndView test4(TestVO vo){
	   System.out.println("TestVO4-->"+vo.getUsername()+","+vo.getAge());
	   
	   vo.setMsg("ModelAndView 테스트중");
	   //데이터와 뷰 파일명을 한번에 가지는 클래스
	   ModelAndView mav=new ModelAndView();
	   mav.addObject("vo",vo);
	   mav.setViewName("mappingTest/aLinkView2");
	   
	   return mav;
	   
	   
   }
   
   @RequestMapping("/formData")
   public String formTest() {
	   return "mappingTest/form";
	   
   }
   
   @RequestMapping(value="/formDataOk",method=RequestMethod.POST)
   public ModelAndView formTestOk(TestVO vo) {
	   System.out.println("formData--->"+vo.getUsername()+","+vo.getAge());
	   
	   vo.setMsg("폼데이터 전송 확인");
	   
	   ModelAndView mav = new ModelAndView();
	   mav.addObject("vo",vo);
	   mav.setViewName("mappingTest/aLinkView2");
	   return mav;
   }
   
   
   
   
   
}
