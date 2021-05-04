package com.bitcamp.home.claseBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.aop.framework.adapter.DefaultAdvisorAdapterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClaseBoardController {

	@Autowired
	SqlSession sqlSession;
	@Autowired
	private DataSourceTransactionManager transactionManager;
	
	//글목록으로 보기
	@RequestMapping("/claseList")
	public ModelAndView claseList() {
		ModelAndView mav=new ModelAndView();
		ClaseBoardDAOImp dao=sqlSession.getMapper(ClaseBoardDAOImp.class);
		
		mav.addObject("totalRecord",dao.getTotalRecord());//총레코드수
		
		mav.addObject("list",dao.claseAllRecord());
		
		mav.setViewName("claseBoard/claseList");
		return mav;
	}
	
	

	//글쓰기 폼
	@RequestMapping("/claseWrite")
	public String claseWrite() {
		return "claseBoard/claseWrite";
	}
	
	@RequestMapping(value="/claseWriteOk",method=RequestMethod.POST)
	public ModelAndView claseWriteOk(ClaseBoardDTO vo, HttpServletRequest req) {
		vo.setIp(req.getRemoteAddr());
		vo.setUserid((String)req.getSession().getAttribute("logId"));
		
	ClaseBoardDAOImp dao = sqlSession.getMapper(ClaseBoardDAOImp.class);
	
	int cnt = dao.claseInsert(vo);
	
	ModelAndView mav = new ModelAndView();
	
	if(cnt>0) {
		mav.setViewName("redirect:claseList");
	}else {
		mav.setViewName("redirect:claseWrite");	
	}
		return mav;
	}
	
	
	@RequestMapping("/claseView")
	public ModelAndView claseView(int no) {
		ClaseBoardDAOImp dao=sqlSession.getMapper(ClaseBoardDAOImp.class);
		
		ModelAndView mav= new ModelAndView();
		dao.hitCount(no); //조회수 증가
		
		mav.addObject("dto",dao.claseSelect(no));
		mav.setViewName("claseBoard/claseView");
		
		
		//이전글 다음글 넣기//2지일 경우에------
		
	   PrevNextVO vo = dao.lagLeadSelect(no);
	   mav.addObject("vo",vo);
	   return mav;
	   
		
	}
	
	
	
	//답글쓰기 폼
	@RequestMapping("/claseWriteForm")
	public ModelAndView claseWriteForm(int no) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("no",no);
		mav.setViewName("claseBoard/claseWriteForm");
		return mav;
	}
	
	//답글쓰기
	@RequestMapping(value="/claseWriteFormOk", method=RequestMethod.POST)
	@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
	public @ResponseBody ModelAndView claseWriteFormOk(ClaseBoardDTO dto, HttpSession session,HttpServletRequest req) {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
	    def.setPropagationBehavior(DefaultTransactionDefinition.PROPAGATION_REQUIRED);
	    
	    TransactionStatus status =  transactionManager.getTransaction(def);
		
		dto.setIp(req.getRemoteAddr());
		dto.setUserid((String)session.getAttribute("logId"));
		
		
		ModelAndView mav = new ModelAndView();		
		ClaseBoardDAOImp dao = sqlSession.getMapper(ClaseBoardDAOImp.class);		
		try {
			//1.원글의 ref,step,lvl을 선택한다.
			ClaseBoardDTO orgDto = dao.oriInfor(dto.getNo());
			
			//2.LVL증가  원글번호가 같고 LVL이 원글번호의 LVL보다 크면 1증가 한다.
			int lvlCnt = dao.lvlCount(orgDto);
			System.out.println("lvlCnt="+lvlCnt);
			
			//3.답글추가
			dto.setRef(orgDto.getRef());
			dto.setStep(orgDto.getStep()+1);
			dto.setLvl(orgDto.getLvl()+1);
			
			
			int cnt = dao.claseDataInsert(dto);			
			mav.addObject("no",dto.getNo());
			//System.out.println("2");
			if(cnt>0) {
				//원글보기
				
				mav.setViewName("redirect:claseView");
				transactionManager.commit(status);
			}else {
				mav.setViewName("redirect:claseWriteForm");
				transactionManager.rollback(status);
				
			}
			
		}catch(Exception e) {
			mav.addObject("no",dto.getNo());
			mav.setViewName("redirect:claseWriteForm");
		}
		return mav;
	}
	//수정폼으로 이동
	@RequestMapping("/claseEdit")
	public ModelAndView claseEdit(int no) {
		ClaseBoardDAOImp dao= sqlSession.getMapper(ClaseBoardDAOImp.class);
		ModelAndView mav = new ModelAndView();
		mav.addObject("dto",dao.claseSelect(no));
		mav.setViewName("claseBoard/claseEdit");
		return mav;
	}
	
	//글수정
	
	@RequestMapping(value="/claseEditOk", method=RequestMethod.POST)
	public ModelAndView claseEditOk(ClaseBoardDTO dto,  HttpSession session) {
		dto.setUserid((String)session.getAttribute("logId"));
		
		ClaseBoardDAOImp dao = sqlSession.getMapper(ClaseBoardDAOImp.class);
		int result = dao.claseUpdate(dto);
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("no",dto.getNo());
		if(result>0) {//수정시 --글내용보기
			
			mav.setViewName("redirect:claseView");
		}else {//수정페이지--수정페이지로
			mav.setViewName("redirect:claseEdit");
		}
		return mav;
	}
	
	//글삭제
	@RequestMapping("/claseDel")
	public ModelAndView claseDel(int no, HttpSession session) {
		ClaseBoardDAOImp dao = sqlSession.getMapper(ClaseBoardDAOImp.class);
		String userid = (String)session.getAttribute("logId");
		
		//원글은 삭제가 가능하고 답글이 있는경우 답글까지 지운다.
		//답글은 제목과 글내용을 구한다.
		
		//원글의 정보->step가져오거나,no,ref가 같은지 
		ClaseBoardDTO orgData = dao.getStep(no);//스탭 유저아이디 포함
		
		int result=0;		
		if(orgData.getStep()==0 && orgData.getUserid().equals(userid)) {//원글
			result = dao.claseDelete(no);
			
		}else if(orgData.getStep()>0 && orgData.getUserid().equals(userid)){//답글
			result = dao.claseDeleteUpdate(no,userid);
		}
		
		
		ModelAndView mav = new ModelAndView();
		/*
		if(result>0) { //삭제
			mav.setViewName("redirect:claseList");
		}else { //삭제실패
			mav.addObject("no", no);
			mav.setViewName("redirect:claseView");
		}
		*/
		mav.addObject("result",result);
		mav.addObject("no",no);
		mav.setViewName("claseBoard/delCheck");
		return mav;
	}
}
