package com.bitcamp.home.member;

import java.io.PrintWriter;
import java.net.http.HttpResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	@RequestMapping("/login")
	public String login() {
		return "member/loginForm";
	}
	
	//로그인
	@RequestMapping(value="/loginOk",method=RequestMethod.POST)
	public ModelAndView loginOk(MemberVO vo, HttpServletRequest req) {
		
		MemberDAO dao=new MemberDAO();
		dao.login(vo);//로그인
		
		
		ModelAndView mav= new ModelAndView();
		
		if(vo.getUsername()!=null) {
			HttpSession ses=req.getSession();
			//아이디 이름 logstatus=y
			ses.setAttribute("logId", vo.getUserid());
			ses.setAttribute("logName", vo.getUsername());
			ses.setAttribute("logStatus", "Y");
			
			//MODELANDVIEW 에서 뷰파일은 다른 컨트롤러를 직접 호출할수있다.
			mav.setViewName("redirect:/");
		}else {
			mav.setViewName("redirect:login");
		}
		
		
		return mav;
		
	}
@RequestMapping("/logout")
public String logout(HttpServletRequest req) {
	HttpSession ses=req.getSession();
	ses.invalidate();
	return "home";
}

@RequestMapping("/member")
public String memberForm() {
	return "member/memberForm";

}

@RequestMapping(value="/memberOk", method=RequestMethod.POST)
	public ModelAndView memberOk(MemberVO vo, HttpServletResponse res) {
		MemberDAO dao= new MemberDAO();
		
		ModelAndView mav=new ModelAndView();
		if(dao.memberInsert(vo)>0) {//회원등록
			mav.setViewName("redirect:login");
		}else {//설정
			/*
			try {
				res.setContentType("text/html; charset=UTF-8");
			PrintWriter pw = res.getWriter();
			pw.println("<html><head><title></title></head><body>");
			pw.println("<script>history.back();</script></body></html>");
			}catch(Exception e) {
				e.printStackTrace();
			}
			*/
			mav.setViewName("member/memberOk");
			
		};
		return mav;
	}

@RequestMapping("/memberEdit")
public ModelAndView memberEdit(HttpServletRequest req) {
	MemberVO vo=new MemberVO();
	vo.setUserid((String)req.getSession().getAttribute("logId"));
	
	MemberDAO dao=new MemberDAO();
	dao.memberSelect(vo);
	 
	ModelAndView mav=new ModelAndView();
	mav.addObject("vo",vo);
	mav.setViewName("member/memberEdit");
	
	return mav;
}
//정보수정
@RequestMapping(value="/memberEditOk", method=RequestMethod.POST)
public ModelAndView memberEditOk(MemberVO vo, HttpServletRequest req) {
	vo.setUserid((String)req.getSession().getAttribute("logId"));
	
	MemberDAO dao=new MemberDAO();
	int result = dao.memberUpdate(vo);
	
	ModelAndView mav=new ModelAndView();
	if(result>0) {
		mav.setViewName("redirect:/");
	}else {
		mav.setViewName("redirect:memberEdit");
	}
	return mav;
}
 
}
