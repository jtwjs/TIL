package com.spring.sungjuk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.sungjuk.dao.SungjukDao;
import com.spring.sungjuk.vo.SungjukVO;

@Service("SungjukService")
public class SungjukService implements ISungjukService{

	@Autowired
	SungjukDao dao;
	
	@Override
	public void sungjukRegister(SungjukVO sungjuk) {
			int result = dao.insertSungjuk(sungjuk);
		if (result == 0) {
			System.out.println("Register Fail!!");
		} else {
			System.out.println("Register Sucecss!!");
		}
	}

	@Override
	public SungjukVO sungjukSearch(String hakbun) {
		SungjukVO sungjuk = dao.selectSungjuk(hakbun);
		if (sungjuk == null) {
			System.out.println("Search Faill!!");
		} else {
			System.out.println("Search Success!!");
		}
		
		return sungjuk;
	}

	@Override
	public SungjukVO sungjukModify(SungjukVO sungjuk) {
		int result = dao.updateSungjuk(sungjuk);
		
		if (result == 0 ) {
			System.out.println("Modify Faill!!");
		} else { 
			System.out.println("Modfiy Success!!");
		}
		
		return sungjuk;
	}

	@Override
	public int sungjukRemove(String hakbun) {
		
		int result = dao.deleteSungjuk(hakbun);
		
		if (result == 0) {
			System.out.println("Remove Fail!!");
		} else {
			System.out.println("Remove Success!!");
		}
	
		return result;
	}

}
