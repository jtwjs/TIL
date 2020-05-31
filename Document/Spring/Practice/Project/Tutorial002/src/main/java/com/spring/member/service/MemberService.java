package com.spring.member.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.member.dao.MemberDao;
import com.spring.member.ojbect.Member;


@Service
public class MemberService implements IMemberService{

	@Autowired
	MemberDao dao;
	
	@Override
	public void memberRegister(Member member) {
		int result = dao.memberInsert(member);
		
		if(result == 0) {
			System.out.println("Join Faill!!");
		} else {
			System.out.println("Join Success!!");
		}
		
	}

	@Override
	public Member memberSearch(Member member) {
		
		Member mem = dao.memberSelect(member);
		
		if (mem == null) {
			System.out.println("Login Fail!!");
		} else {
			System.out.println("Login Success!!");
		}
		return mem;
	}

	@Override
	public Member memberModify(Member member) {
		int result = dao.memberUpdate(member);
		
		if(result == 0) {
			System.out.println("Modify Faill!!");
			return null;
		} else {
			System.out.println("Modify Success");
		}
		return member;
	}

	@Override
	public int memberRemove(Member member) {
		int result = dao.memberDelete(member);
		
		if(result == 0) {
			System.out.println("Remove Fail!!");
		} else {
			System.out.println("Remove Success!!");
		}
		
		return result;
	}

	@Override
	public int memberUncheck(Member member) {
		int result = dao.userCheck(member);
		
		if(result == 1) {
			System.out.println("Login Success!!");
		}
		else {
			System.out.println("Login Faill!!");
		}
		return result;
	}

	@Override
	public ArrayList<Member> getMemberList() {
		ArrayList<Member> member_list = new ArrayList<>();
		member_list = dao.getMemberList();
		
		return member_list;
	}

}
