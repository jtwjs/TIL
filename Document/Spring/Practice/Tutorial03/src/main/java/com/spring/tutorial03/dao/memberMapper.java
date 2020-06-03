package com.spring.tutorial03.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.spring.tutorial03.vo.memberVO;

@Repository
public interface memberMapper {
	
	memberVO selectMemberById(String account);
	ArrayList<memberVO> selectMemberGroup();
	void insertMember(memberVO member);
	void updateMember(memberVO member);
	int deleteMember(String account);

}
