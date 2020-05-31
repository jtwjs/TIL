package com.spring.member.service;

import java.util.ArrayList;

import com.spring.member.ojbect.Member;

public interface IMemberService {
	void memberRegister(Member member);
	int memberUncheck(Member member);
	ArrayList<Member> getMemberList();
	Member memberSearch(Member member);
	Member memberModify(Member member);
	int memberRemove(Member member);
}
