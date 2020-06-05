package com.spring.ajax.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.spring.ajax.vo.PeopleVO;

@Repository
public interface PeopleMapper {
	ArrayList<PeopleVO> getPeopleGroup();
	void insertPeople(PeopleVO people);
	void deletePeople(String id);
	PeopleVO getPeople(String id);
	void updatePeople(PeopleVO people);
}
