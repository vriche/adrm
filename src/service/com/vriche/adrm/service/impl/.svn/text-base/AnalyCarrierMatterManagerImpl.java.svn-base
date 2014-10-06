package com.vriche.adrm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.vriche.adrm.dao.AnalyDao;

import com.vriche.adrm.model.AnalyzeClass;
import com.vriche.adrm.model.CustomerProduct;
import com.vriche.adrm.service.AnalyCarrierMatterManager;
import com.vriche.adrm.util.AnalyCarrierMatterUtil;
import com.vriche.adrm.util.CustomerProductUtil;

public class AnalyCarrierMatterManagerImpl extends BaseManager implements AnalyCarrierMatterManager {
	private AnalyDao dao;
	


	public AnalyDao getDao() {
		return dao;
	}



	public void setDao(AnalyDao dao) {
		this.dao = dao;
	}

	public void setAnalyDao(AnalyDao dao) {
		// TODO Auto-generated method stub
		this.dao=dao;
	}
	

	public String getAnalyCarrierMatterByDate(String startDate, String endDate, String[] resourceIds) {
		// TODO Auto-generated method stub
		Map mp = new HashMap();
		List resourceIdList =new ArrayList();
		
		CollectionUtils.addAll(resourceIdList, resourceIds);
		
		mp.put("startDate",startDate);
		mp.put("endDate",endDate);
		mp.put("resourceIdList",resourceIdList);
		
		List ls = dao.getAnalyCarrierMatterByDate(mp);
		
		StringBuffer sb = new StringBuffer();
		AnalyCarrierMatterUtil.makeTreeGridXML(sb,ls);
		return sb.toString();
		
	}



	public List getAnalyCarrierMatterList(String startDate, String endDate, String[] pIds) {
		// TODO Auto-generated method stub
		Map mp = new HashMap();
		List resourceIdList =new ArrayList();
		
		CollectionUtils.addAll(resourceIdList, pIds);
		
		mp.put("startDate",startDate);
		mp.put("endDate",endDate);
		mp.put("resourceIdList",resourceIdList);
		
		List ls = dao.getAnalyCarrierMatterByDate(mp);
		return ls;
	}





}