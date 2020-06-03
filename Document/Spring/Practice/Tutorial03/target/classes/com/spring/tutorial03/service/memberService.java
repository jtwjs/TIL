package com.spring.tutorial03.service;

import java.util.ArrayList;

import com.spring.tutorial03.vo.memberVO;

public interface memberService {
	ArrayList<memberVO> memberGroup();
	memberVO memberSearch(String account);
	void memberModify(memberVO member);
	int memberRemove(String account);
	void memberRegister(memberVO member);
	
}
