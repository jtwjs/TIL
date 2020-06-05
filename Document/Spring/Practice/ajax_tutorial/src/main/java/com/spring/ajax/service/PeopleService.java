package com.spring.ajax.service;

import java.util.ArrayList;

import com.spring.ajax.vo.PeopleVO;

public interface PeopleService {
	
	ArrayList<PeopleVO> getPeoplejson();
	void insertPeople(PeopleVO people);
	void deletePeople(String id);
	PeopleVO getSelectPeople(String id);
	void updatePeople(PeopleVO people);
}
