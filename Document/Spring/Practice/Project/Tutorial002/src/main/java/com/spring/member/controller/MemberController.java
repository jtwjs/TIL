package com.spring.member.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.member.ojbect.Member;
import com.spring.member.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService service;
	
	@ModelAttribute("cp")
	public String getContextPath(HttpServletRequest request) {
		return request.getContextPath();
	}


	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinREg(Member member) {
		
		service.memberRegister(member);
		
		return "/index";
	}
	
	/*// Login
	@RequestMapping(value = "/loginForm.me", method = RequestMethod.GET)
	public String loginForm(Member member) {
		return "/member/loginForm";
	}
	
	@RequestMapping(value = "/login.me", method = RequestMethod.POST)
	public String memLogin(Member member, HttpSession session) {
		
		Member mem = service.memberSearch(member);
		if(mem == null)
			return "/member/loginForm.me";
		
		session.setAttribute("member", mem);
		
		return "/member/loginOk";
	}
	
	// Logout
	@RequestMapping(value = "/logout.me", method = RequestMethod.GET)
	public String memLogout(Member member, HttpSession session) {
		
		session.invalidate();
	
		return "/member/logoutOk";
	}*/
	
	/*// Modify
	/*@RequestMapping(value = "/modifyForm.me", method = RequestMethod.GET)
	public ModelAndView modifyForm(HttpSession session) {
		
		Member member = (Member)session.getAttribute("member");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("member",service.memberSearch(member));
		
		mav.setViewName("/member/modifyForm");
		
		return mav;
	}
	
	@RequestMapping(value = "/modfiyForm.me", method = RequestMethod.GET)
	public String modifyForm(Member member, HttpSession session) {
		
		member = (Member)session.getAttribute("member");
		
		return "/member/modifyForm";
	}
	
	/*@RequestMapping(value = "/modfiy.me", method = RequestMethod.POST)
	public ModelAndView modify(Member member, HttpSession session) {
		
		ModelAndView mav = new ModelAndView();
		Member mem = service.memberModify(member);
		if(mem == null) {
			mav.setViewName("/member/modifyForm.me");
		} else {
			session.setAttribute("member", mem);
			
			mav.addObject("memAft", mem);
			mav.setViewName("/member/modifyOk");
		}
		
		return mav;
	}
	@RequestMapping(value = "/modfiy.me", method = RequestMethod.POST)
	public String modify(Member member, HttpSession session) {
		
		Member mem = service.memberModify(member);
		if(mem == null) {
			return "/member/modifyForm.me";
		} else {
			session.setAttribute("member", mem);
		}
		return "/member/modifyOk";
	}
	
	// Remove
	@RequestMapping(value = "/removeForm.me", method = RequestMethod.GET)
	public String removeForm(Member member, HttpSession session) {
		
		member = (Member)session.getAttribute("member");
		return "/member/removerForm";
	}
	
	@RequestMapping(value = "remove.me", method = RequestMethod.POST)
	public String memRemove(Member member, HttpSession session) {
		
		int result = service.memberRemove(member);
		
		if(result == 0)
			return "/member/removeForm.me";
		
		session.invalidate();
		
		return "/member/removeOk";
	}
	
	@RequestMapping(value = "memberlist.me", method = RequestMethod.GET)
	public String getMemberlist(Model model) {
		ArrayList<Member> member_list = service.getMemberList();
		model.addAttribute("member_list", member_list);
		
		return "member/member_list";
	}*/
}
