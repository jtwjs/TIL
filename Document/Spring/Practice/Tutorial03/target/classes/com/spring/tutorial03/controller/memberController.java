package com.spring.tutorial03.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.tutorial03.service.memberService;
import com.spring.tutorial03.vo.memberVO;

@Controller
public class memberController {

	@Autowired
	memberService service;
	
	@ModelAttribute("cp")
	public String getContextPath(HttpServletRequest request) {
		return request.getContextPath();
	}
	

	@RequestMapping(value = "joinFrom", method = RequestMethod.POST)
	public String join(memberVO member) {
		 service.memberRegister(member);
		 
		 return "redirect:/main";
	}
	
	
}
