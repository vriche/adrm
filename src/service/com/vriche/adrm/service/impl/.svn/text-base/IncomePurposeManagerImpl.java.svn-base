
package com.vriche.adrm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.vriche.adrm.Constants;
import com.vriche.adrm.dao.IncomePurposeDao;
import com.vriche.adrm.model.IncomePurpose;
import com.vriche.adrm.model.TreeNode;
import com.vriche.adrm.service.IncomePurposeManager;
import com.vriche.adrm.util.StringUtil;
import com.vriche.adrm.util.SysParamUtil;

public class IncomePurposeManagerImpl extends BaseManager implements IncomePurposeManager {
    private IncomePurposeDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setIncomePurposeDao(IncomePurposeDao dao) {
        this.dao = dao;
    }

    /**
     * @see com.vriche.adrm.finance.service.IncomePurposeManager#getIncomePurposesByIdList(final Map idList)
     */
    public List getIncomePurposesByIdList(final Map idList) {
        return dao.getIncomePurposesByIdList(idList);
    }
   /**
     * @see com.vriche.adrm.finance.service.IncomePurposeManager#getIncomePurposes(com.vriche.adrm.finance.model.IncomePurpose)
     */
    public List getIncomePurposes(final IncomePurpose incomePurpose) {
		boolean financialAuditSwitch = SysParamUtil.getFinancialAuditSwitch();
		List fitterList  = new ArrayList();
		if(financialAuditSwitch){
			String version = StringUtil.getNullValue(incomePurpose.getVersion(),"");
			if(!"".equals(version) && !"0".equals(version) && version != null){
				 fitterList  = SysParamUtil.getFitterIncomePours(String.valueOf(version));
//				if(fitterList.size() > 0) incomePurpose.setFitterList(fitterList);
			}
			
			System.out.println("getIncomePurposes 33333333333333333333333333333333333333333333333333333333333333333333>>>>>>>>"+fitterList);
			
			incomePurpose.setFitterList(fitterList);
		} 
		
		
    	
    	
        return dao.getIncomePurposes(incomePurpose);
    }

    /**
     * @see com.vriche.adrm.finance.service.IncomePurposeManager#getIncomePurpose(String id)
     */
    public IncomePurpose getIncomePurpose(final String id) {
//    	System.out.println("id========="+id);
        return dao.getIncomePurpose(new Long(id));
    }

    /**
     * @see com.vriche.adrm.finance.service.IncomePurposeManager#saveIncomePurpose(IncomePurpose incomePurpose)
     */
    public void saveIncomePurpose(IncomePurpose incomePurpose) {
        dao.saveIncomePurpose(incomePurpose);
    }

    /**
     * @see com.vriche.adrm.finance.service.IncomePurposeManager#removeIncomePurpose(String id)
     */
    public void removeIncomePurpose(final String id) {
        dao.removeIncomePurpose(new Long(id));
    }

     /**
     * @see com.vriche.adrm.finance.service.IncomePurposeManager#removeIncomePurposes(String Map)
     */
    public void removeIncomePurposes(final Map idList) {
        dao.removeIncomePurposes(idList);
    }

	public Map getIncomePurposesSelect(IncomePurpose incomePurpose) {
		List ls = this.getIncomePurposes(incomePurpose);
	    Map reply = new LinkedHashMap();
	    Iterator it = ls.iterator();
	    while(it.hasNext()){
	    	IncomePurpose incomePurposes = new IncomePurpose();
	    	incomePurposes = (IncomePurpose) it.next();
	    	reply.put("0","");
	    	reply.put(incomePurposes.getId(),incomePurposes.getName());
	    }
		return reply;
	}

	public Map getIncomePurposesFromMap(IncomePurpose incomePurpose) {
		boolean financialAuditSwitch = SysParamUtil.getFinancialAuditSwitch();
		List fitterList  = new ArrayList();
		if(financialAuditSwitch){
			String version = StringUtil.getNullValue(incomePurpose.getVersion(),"");
			if(!"".equals(version) && !"0".equals(version) && version != null){
				 fitterList  = SysParamUtil.getFitterIncomePoursWithout(String.valueOf(version));
//				if(fitterList.size() > 0) incomePurpose.setFitterList(fitterList);
			}
		}    
		
		
//		System.out.println("getIncomePurposesFromMap 123>****************>>>>>>>>>>>fitterOrderSubCatesList>>>>>>>>" + fitterList);
		
		List ls = (List)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_INCOME_PURPOSE);
		
		
		
		Map reply = new LinkedHashMap();
		reply.put("0","==所有==");
	    Iterator it = ls.iterator();
	    while(it.hasNext()){
	    	IncomePurpose incomePurposes = new IncomePurpose();
	    	incomePurposes = (IncomePurpose) it.next();
	    	String id = incomePurposes.getId().toString();
	    	if(financialAuditSwitch){
	    		if(!fitterList.contains(id)) reply.put(incomePurposes.getId(),incomePurposes.getName());
	    	}else{
	    		reply.put(incomePurposes.getId(),incomePurposes.getName());
	    	}
	    	
	    }
		return reply;
	} 
	
	public Map getIncomePurposesFromMap2(IncomePurpose incomePurpose) {

		List ls = (List)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_INCOME_PURPOSE);

		Map reply = new LinkedHashMap();
		reply.put("0","==所有==");
	    Iterator it = ls.iterator();
	    while(it.hasNext()){
	    	IncomePurpose incomePurposes = new IncomePurpose();
	    	incomePurposes = (IncomePurpose) it.next();
	    	reply.put(incomePurposes.getId(),incomePurposes.getName());
	    }
		return reply;
	} 	
	

	public List getTreeForJosin(TreeNode node,IncomePurpose incomePurpose){
		List trees = new ArrayList();

//		IncomePurpose incomeP= new IncomePurpose();

		List ls = dao.getIncomePurposes(incomePurpose);
		Iterator it = ls.iterator();
		while (it.hasNext()) {
			Map map = new HashMap();
			IncomePurpose  ind =(IncomePurpose)it.next();
			map.put("id",ind.getId().toString());
			map.put("text", ind.getName());
			map.put("leaf", new Boolean(true));
			map.put("type", "1");
			map.put("level", "1");
			map.put("realId", ind.getId().toString());

			trees.add(map);
		}
		return trees;
	}
    
}
