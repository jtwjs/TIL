package com.spring.ajax.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.ajax.service.PeopleService;
import com.spring.ajax.vo.PeopleVO;

@Controller
public class PeopleController {

	@Autowired
	PeopleService service;
	
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String main(PeopleVO people) {
		return "home";
	}
	
	@RequestMapping(value = "/getPeopleJSON.do",
			method = RequestMethod.POST, produces = "application/json;chareset=utf-8")
	@ResponseBody
	public ArrayList<PeopleVO> getPeopleGroupJSON(){
		
		ArrayList<PeopleVO> peopleGroup = service.getPeoplejson();
		
		return peopleGroup;
	}
	
	@RequestMapping(value = "/insertPeople.do",
			method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public HashMap<String, Object> insertPeople(PeopleVO people){
		HashMap<String, Object> result = new HashMap<>();
		try {
			service.insertPeople(people);
			result.put("res","OK");
		} catch(Exception e) {
			result.put("res","FAIL");
			result.put("message","Failure");
		}
		return result;
	}
	
	@RequestMapping(value = "/deletePeople.do",
			method = RequestMethod.GET, produces = "application/json;chareset=utf-8")
	@ResponseBody
	public HashMap<String, Object> deletePeople(PeopleVO people){
		HashMap<String, Object> result = new HashMap<>();
		String id = people.getId();
		try {
			service.deletePeople(id);
			result.put("res","OK");
		} catch(Exception e) {
			result.put("res","Fail");
			result.put("message","Failure");
		}
		return result;
	}
	
	@RequestMapping(value = "/selectPeople.do",
			method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public PeopleVO selectPeople(PeopleVO people) {
		String id = people.getId();
		PeopleVO selectPeople = service.getSelectPeople(id);
		return selectPeople;
		
	}
	
	@RequestMapping(value = "updatePeople.do",
			method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public HashMap<String, Object> updatePeople(PeopleVO people){
		HashMap<String, Object> result = new HashMap<>();
		try {
			service.updatePeople(people);
			result.put("res", "OK");
		} catch(Exception e) {
			result.put("res", "FAIL");
			result.put("message","Failure");
		}
		return result;
	}
	
	
}
