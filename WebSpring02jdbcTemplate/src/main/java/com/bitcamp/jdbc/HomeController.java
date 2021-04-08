package com.bitcamp.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	public JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	
	
	//메소드 자동실행 : servlet-context.xml에 있는 templat 객체를
	//jdbctemplate과 constants.jdbcTemplate에도 셋팅한다.
	
	@Autowired	
	public void setJdbcTemplate(JdbcTemplate template) {
		this.jdbcTemplate = template;
		Constants.jdbcTemplate=template;
	}

	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		return "home";
	}
	
}
