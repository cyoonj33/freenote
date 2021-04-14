package com.bitcamp.home.reply;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.home.board.BoardDAOImp;
import com.bitcamp.home.board.BoardVO;
import com.bitcamp.home.member.MemberDAOImp;

@Controller
public class BoardReplyController {

		@Autowired
	    SqlSession sqlSession;
		
		@RequestMapping("/boardReplyList")
		public ModelAndView allList() {
			BoardReplyDAOImp dao = sqlSession.getMapper(BoardReplyDAOImp.class);
			
			ModelAndView mav=new ModelAndView();
			mav.addObject("list" , dao.allList());
			mav.setViewName("reply/boardReplyList");
			return mav;
		}
		
		@RequestMapping("/boardReplyWrite")
		public String boardWrite() {
			return "reply/boardReplyWrite";
			
		}
		
		@RequestMapping(value="/boardWriteOk",method=RequestMethod.POST)
		public ModelAndView boardWriteOk(BoardVO vo,HttpSession session,HttpServletRequest req) {
			vo.setIp(req.getRemoteAddr());
			vo.setUserid((String)session.getAttribute("logId"));
			
			BoardDAOImp dao = sqlSession.getMapper(BoardDAOImp.class);
			int cnt=dao.boardInsert(vo);
			
			ModelAndView mav = new ModelAndView();
			if(cnt>0) {
				mav.setViewName("redirect:boardList");
				
			}else {
				mav.setViewName("redirect:boardWrite");
				
			}
			return mav;
	  }
		
		@RequestMapping("/boardView")
		public String boardView(int no,Model model) {
			BoardDAOImp dao = sqlSession.getMapper(BoardDAOImp.class);
			BoardVO vo = dao.boardSelect(no);
			model.addAttribute("vo",vo); //view 페이지에서 사용한다.
			return "board/boardView";
			
		}
		
}
