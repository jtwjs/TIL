package com.spring.sungjuk.service;

import com.spring.sungjuk.vo.SungjukVO;


public interface ISungjukService {
	
	void sungjukRegister(SungjukVO sungjuk);
	SungjukVO sungjukSearch(String hakbun);
	SungjukVO sungjukModify(SungjukVO sungjuk);
	int sungjukRemove(String hakbun);
	
	
	
}
