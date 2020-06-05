package com.spring.ajax.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ajax.dao.PeopleMapper;
import com.spring.ajax.vo.PeopleVO;

@Service
public class PeopleServiceImp implements PeopleService{

	@Autowired
	PeopleMapper dao;
	@Override
	public ArrayList<PeopleVO> getPeoplejson() {
		ArrayList<PeopleVO> peopleGroup = dao.getPeopleGroup();
		return peopleGroup;
	}

	@Override
	public void insertPeople(PeopleVO people) {
		dao.insertPeople(people);
		
	}

	@Override
	public void deletePeople(String id) {
		dao.deletePeople(id);
		
	}

	@Override
	public PeopleVO getSelectPeople(String id) {
		PeopleVO people = dao.getPeople(id);
		return people;
	}

	@Override
	public void updatePeople(PeopleVO people) {
		dao.updatePeople(people);
		
	}

}
