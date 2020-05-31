package com.spring.member.dao;

import java.util.ArrayList;

import com.spring.member.ojbect.Member;

public interface IMemberDao {
	int memberInsert(Member member);
	int userCheck(Member member);
	Member memberSelect(Member member);
	int memberUpdate(Member member);
	int memberDelete(Member member);
	ArrayList<Member> getMemberList();
}
