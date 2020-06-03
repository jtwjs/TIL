package com.spring.tutorial03.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.tutorial03.dao.memberMapper;
import com.spring.tutorial03.vo.memberVO;

@Service
public class memberServiceImpl implements memberService{

	@Autowired
	memberMapper memberdao;
	
	@Override
	public ArrayList<memberVO> memberGroup() {
		ArrayList<memberVO> memberGroup = memberdao.selectMemberGroup();
		return memberGroup;
	
		
	}

	@Override
	public memberVO memberSearch(String account) {
		memberVO member = memberdao.selectMemberById(account);
		return member;
	}

	@Override
	public void memberModify(memberVO member) {
		memberdao.updateMember(member);

	}

	@Override
	public int memberRemove(String account) {
		int result = memberdao.deleteMember(account);
		return result;
	}

	@Override
	public void memberRegister(memberVO member) {
		memberdao.insertMember(member);
		
	}

}
