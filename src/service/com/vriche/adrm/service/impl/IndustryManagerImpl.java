
package com.vriche.adrm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.Constants;
import com.vriche.adrm.dao.IndustryDao;
import com.vriche.adrm.model.Industry;
import com.vriche.adrm.service.IndustryManager;
import com.vriche.adrm.util.StringUtilsv;
import com.vriche.adrm.util.SysParamUtil;

public class IndustryManagerImpl extends BaseManager implements IndustryManager {
    private IndustryDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setIndustryDao(IndustryDao dao) {
        this.dao = dao;
    }

    /**
     * @see com.vriche.adrm.crm.service.IndustryManager#getIndustrysByIdList(final Map idList)
     */
    public List getIndustrysByIdList(final Map idList) {
        return dao.getIndustrysByIdList(idList);
    }
   /**
     * @see com.vriche.adrm.crm.service.IndustryManager#getIndustrys(com.vriche.adrm.crm.model.Industry)
     */
    public List getIndustrys(final Industry industry) {
        return dao.getIndustrys(industry);
    }

    
    public PaginatedList getIndustrysPage(Industry industry, String pageSize) {
    	return dao.getIndustrysPage(industry,Integer.parseInt(pageSize));
}

	public String getIndustrysCount(Industry industry) {
    	return  dao.getIndustrysCount(industry).toString();
}

	/**
     * @see com.vriche.adrm.crm.service.IndustryManager#getIndustry(String id)
     */
    public Industry getIndustry(final String id) {
        return dao.getIndustry(new Long(id));
    }

    /**
     * @see com.vriche.adrm.crm.service.IndustryManager#saveIndustry(Industry industry)
     */
    public void saveIndustry(Industry industry) {
        dao.saveIndustry(industry);
    }

    /**
     * @see com.vriche.adrm.crm.service.IndustryManager#removeIndustry(String id)
     */
    public void removeIndustry(final String id) {
        dao.removeIndustry(new Long(id));
    }

     /**
     * @see com.vriche.adrm.crm.service.IndustryManager#removeIndustrys(String Map)
     */
    public void removeIndustrys(final Map idList) {
        dao.removeIndustrys(idList);
    }

	public Map getIndustrySelect(Industry industry) {
		List ls = this.getIndustrys(industry);
		
	    Map reply = new LinkedHashMap();
	    Iterator it = ls.iterator();
	    
	    while(it.hasNext()){
	    	Industry industrys = new Industry();
	    	industrys = (Industry) it.next();
	    	
//	    	reply.put("0","");
	    	reply.put(industrys.getId(),industrys.getName());
	    }
		return reply;
	}

	public Map getIndustrySelectFromMap(Industry industry) {
		// TODO Auto-generated method stub
		List industryList = (List)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_INDUSTRY);
//		System.out.println("<><><><><><><><><><><><>" + orderCategory.getParentId());
//		List industryList = (List)industryMap.get(industry.getId());
		
	    Map reply = new LinkedHashMap();
	    Iterator it = industryList.iterator();
    	reply.put("0","");
    	
	    while(it.hasNext()){
	    	Industry ind =(Industry)it.next();
	    	
	    	reply.put(ind.getId(),ind.getName());
	    }
		return reply;
	}
	
	
	public List getTree(Map searchMap){
		List trees = new ArrayList();
		
		boolean industryLevel2Param = SysParamUtil.getIndustryLevel2Param();
		boolean xmtv = SysParamUtil.isXMTVParam(null);
		
//		System.out.println("searchMap>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+searchMap);
	
		String nodeId = StringUtilsv.getNullValue(searchMap.get("nodeId"),"0");
		
//		System.out.println("nodeId>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+nodeId);
//		System.out.println("nodeId>>>>>>>>>>>111111111111111111111111111111111111111111111111111111111111>>>>>>>>>>>>>>>>>"+nodeId);
		
		Industry industry = new Industry();
		industry.setParentId(new Long(nodeId));
		
		List lsIndustry = dao.getIndustrys(industry);
		Iterator it = lsIndustry.iterator();
		while (it.hasNext()) {
			Map map = new HashMap();
			Industry ind =(Industry)it.next();
			
			Industry industry2 = new Industry();
			industry2.setParentId(ind.getId());
			List ls2 = dao.getIndustrys(industry2);

			boolean isLeaf = (ls2.size() == 0);
			
//			System.out.println("isLeaf>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+ ind.getName() +">>>>>>>>>>>>>>>>>"+ls2.size());
//			System.out.println("industryLevel2Param>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+industryLevel2Param);

			if (!isLeaf && (industryLevel2Param||xmtv)){
				
//				System.out.println("isLeaf>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+isLeaf);
//				System.out.println("industryLevel2Param>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+industryLevel2Param);
//				System.out.println("xmtv>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+xmtv);
				
				Map searchMap2 = new HashMap();
				searchMap2.put("nodeId",ind.getId().toString());
				map.put("children", getTree(searchMap2));
				map.put("childNodesSum", new Integer(ls2.size()));
			}else{
				isLeaf = true;
			}
	       String level ="0";
           if("0".equals(nodeId)){
        	   level ="1";
           }else{
        	   level ="2";
           }

			map.put("id", ind.getId());
			map.put("text", ind.getName());
			map.put("leaf", new Boolean(isLeaf));
			map.put("type", "1");
			map.put("level", level);
			map.put("realId", ind.getId());


	
			 
//			if (!isLeaf) map.put("expanded",  new Boolean(true));
			
			
			
			trees.add(map);
		}
		return trees;
	}
	
//	public Map getTreeChildrens(Map searchMap){
//		String nodeId = StringUtilsv.getNullValue(searchMap.get("nodeId"),"0");
//	}
	
	
}
