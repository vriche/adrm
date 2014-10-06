package com.vriche.adrm.dao.ibatis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.AnalyDao;


//import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;



public class AnalyDaoiBatis extends BaseDaoiBATIS implements AnalyDao {

 

public List getAnalyCarrierMatterByDate(Map mp) {
	// TODO Auto-generated method stub
	
	return getSqlMapClientTemplate().queryForList("getAnalyCarrierMatterByDate", mp);
}

public List getResourceAdver(Map mp, int pageIndex, int pageSize) {
	 List ls = new ArrayList();
	 int skip = (pageIndex-1) * pageSize;
	 int max =  pageSize;
	 
	if(pageSize >0 ) {
		ls = getSqlMapClientTemplate().queryForList("getResourceAdver", mp,skip,max);
	}else{
		ls = getSqlMapClientTemplate().queryForList("getResourceAdver", mp);
	}
	return ls;
}

public double getResourceAdverSumMoney(Map mp) {
		return  ((Double) getSqlMapClientTemplate().queryForObject("getResourceAdverSumMoney", mp)).doubleValue();
}



public List getBrand(Map mp, int pageIndex, int pageSize) {
	List ls = new ArrayList();
	int skip = (pageIndex-1) * pageSize;
	int max =  pageSize;
	 
	if(pageSize >0 ) {
		ls = getSqlMapClientTemplate().queryForList("getBrandAnalyze", mp,skip,max);
	}else{
		ls = getSqlMapClientTemplate().queryForList("getBrandAnalyze", mp);
	}
	return ls;	
}



public int getResourceAdverPageCount(Map mp) {
	return  ((Integer)getSqlMapClientTemplate().queryForObject("getResourceAdverPageCount", mp)).intValue();
}

public int getBrandPageCount(Map mp) {
	return  ((Integer)getSqlMapClientTemplate().queryForObject("getBrandPageCount", mp)).intValue();
}

public List getOrderCategoryByCarrierType(Map idList) {
    return getSqlMapClientTemplate().queryForList("getOrderCategoryByCarrierType",idList);
}

public List getOrderCategoryByCustomer(Map idList) {
	return getSqlMapClientTemplate().queryForList("getOrderCategoryByCustomer", idList);
}

public List getAreaCustomerByCarrierType(Map idList) {
	return getSqlMapClientTemplate().queryForList("getAreaCustomerByCarrierType", idList);
}

public List getCarrierBasalByBeginAndEndDate(Map idList) {
	return getSqlMapClientTemplate().queryForList("getCarrierBasalByBeginAndEndDate", idList);
}

	
}
