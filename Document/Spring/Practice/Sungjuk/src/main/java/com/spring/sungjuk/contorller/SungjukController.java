package com.spring.sungjuk.contorller;

import javax.xml.ws.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.sungjuk.service.SungjukService;
import com.spring.sungjuk.vo.SungjukVO;

@Controller
public class SungjukController {

	@Autowired
	SungjukService service;
	
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String main(SungjukVO sungjuk) {
		String hakbun = sungjuk.getHakbun();
		sungjuk = service.sungjukSearch(hakbun);
		return "list";
	}
	
	@RequestMapping(value = "/insert.do", method = RequestMethod.POST)
	public String insert(SungjukVO sungjuk) {
		service.sungjukRegister(sungjuk);
		return "list";	
	}
	
	@RequestMapping(value = "/updateForm.do", method = RequestMethod.GET)
	public String modify(SungjukVO sungjuk) {
		service.sungjukModify(sungjuk);
			
		return "updateForm";
	}
	
	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	public String delete(SungjukVO sungjuk) {
		String hakbun = sungjuk.getHakbun();
		service.sungjukRemove(hakbun);
		
		return "list";
	}
	
}
