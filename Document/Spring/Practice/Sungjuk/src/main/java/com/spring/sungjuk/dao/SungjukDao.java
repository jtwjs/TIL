package com.spring.sungjuk.dao;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.sungjuk.vo.SungjukVO;

@Repository("SungjukDao")
public class SungjukDao implements ISungjukDao{

	@Autowired
	private SqlSession session;
	

	

	@Override
	public int insertSungjuk(SungjukVO sungjuk) {	
		int result = session.insert("sungjukNS.insertSungjuk",sungjuk);
		
		return result;
	}



	@Override
	public int updateSungjuk(SungjukVO sungjuk) {
		int result =	session.update("sungjukNS.updateSungjuk",sungjuk);
		
		return result;
	}

	@Override
	public int deleteSungjuk(String hakbun) {
		int result = session.delete("sungjukNS.updateSungjuk",hakbun);
		
		return result;
	}



	@Override
	public SungjukVO selectSungjuk(String hakbun) {
		SungjukVO sungjuk = session.selectOne("sungjukNS.selectSungjukById",hakbun);
		return sungjuk;
	}





}
