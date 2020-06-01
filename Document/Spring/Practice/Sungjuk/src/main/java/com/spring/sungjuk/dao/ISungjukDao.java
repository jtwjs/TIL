package com.spring.sungjuk.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.spring.sungjuk.vo.SungjukVO;

public interface ISungjukDao {
	
//	ArrayList<SungjukVO> getMembers();
//	HashMap<String,String> getMember(String hakbun);
	int insertSungjuk(SungjukVO sungjuk);
	SungjukVO selectSungjuk(String hakbun);
	int updateSungjuk(SungjukVO sungjuk);
	int deleteSungjuk(String hakbun);
	
}
