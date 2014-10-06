
package com.vriche.adrm.service.impl;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.OaWorkFlowTypeDao;
import com.vriche.adrm.model.OaWorkFlowType;
import com.vriche.adrm.model.Price;
import com.vriche.adrm.service.OaWorkFlowTypeManager;

public class OaWorkFlowTypeManagerImpl extends BaseManager implements OaWorkFlowTypeManager {
    private OaWorkFlowTypeDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setOaWorkFlowTypeDao(OaWorkFlowTypeDao dao) {
        this.dao = dao;
    }
   /**
     * @see com.vriche.adrm.service.OaWorkFlowTypeManager#getOaWorkFlowTypes(com.vriche.adrm.model.OaWorkFlowType)
     */
    public List getOaWorkFlowTypes(final OaWorkFlowType oaWorkFlowType) {
        return dao.getOaWorkFlowTypes(oaWorkFlowType);
    }
    
/**
     * @see com.vriche.adrm.service.OaWorkFlowTypeManager#getOaWorkFlowTypesCount(com.vriche.adrm.model.OaWorkFlowType)
     */
    public String getOaWorkFlowTypesCount(final OaWorkFlowType oaWorkFlowType) {
        return dao.getOaWorkFlowTypesCount(oaWorkFlowType).toString();
    }    

   /**
     * @see com.vriche.adrm.service.OaWorkFlowTypeManager#getOaWorkFlowTypesCount(com.vriche.adrm.model.OaWorkFlowType)
     */    
	public PaginatedList getOaWorkFlowTypesPage(final OaWorkFlowType oaWorkFlowType,String pageIndex, String pageSize) {
		return dao.getOaWorkFlowTypesPage(oaWorkFlowType,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    

    /**
     * @see com.vriche.adrm.service.OaWorkFlowTypeManager#getOaWorkFlowType(String id)
     */
    public OaWorkFlowType getOaWorkFlowType(final String id) {
        return dao.getOaWorkFlowType(new Long(id));
    }
    /**
     * @see com.vriche.adrm.service.OaWorkFlowTypeManager#getOaWorkFlowTypesByIdList(final Map idList)
     */
    public List getOaWorkFlowTypesByIdList(final Map idList) {
        return dao.getOaWorkFlowTypesByIdList(idList);
    }    

    /**
     * @see com.vriche.adrm.service.OaWorkFlowTypeManager#saveOaWorkFlowType(OaWorkFlowType oaWorkFlowType)
     */
    public String saveOaWorkFlowType(OaWorkFlowType oaWorkFlowType) {
        return dao.saveOaWorkFlowType(oaWorkFlowType).toString();
    }

    /**
     * @see com.vriche.adrm.service.OaWorkFlowTypeManager#removeOaWorkFlowType(String id)
     */
    public void removeOaWorkFlowType(final String id) {
        dao.removeOaWorkFlowType(new Long(id));
    }

     /**
     * @see com.vriche.adrm.service.OaWorkFlowTypeManager#removeOaWorkFlowTypes(String Map)
     */
    public void removeOaWorkFlowTypes(final Map idList) {
        dao.removeOaWorkFlowTypes(idList);
    }    
    
    
    
    /* (non-Javadoc)
	 * @see com.vriche.adrm.dao.OaWorkFlowTypeDao#getOaWorkFlowTypesXml(com.vriche.adrm.model.OaWorkFlowType)
	 */
	public String getOaWorkFlowTypesXml(OaWorkFlowType workFlowType,String IdPrefix) {
		StringBuffer sb = new StringBuffer("");
		sb.append("<?xml version=\"1.0\"?>");
		sb.append("<tree id=\"0\">");
		sb.append("<item text=\"流程类别\" id=\"books\" open=\"1\" im0=\"books_close.gif\" im1=\"tombs.gif\" im2=\"tombs.gif\" call=\"1\" select=\"1\">");
		sb.append("<userdata name=\"type\">1</userdata>");
		getWorkFlowTypesItemsByParentId(workFlowType.getParentId().toString(),sb,IdPrefix);
		sb.append("</item>");
		sb.append("</tree>");
		return new String(sb.toString());
	}
    
	public void getWorkFlowTypesItemsByParentId(String parentId,StringBuffer sb,String IdPrefix){
		   OaWorkFlowType type = new OaWorkFlowType();
		   type.setParentId(new Long(parentId));
		   List ls = this.getOaWorkFlowTypes(type);
			
			for (Iterator it = ls.iterator();it.hasNext();){
				OaWorkFlowType oaWorkFlowType = (OaWorkFlowType) it.next();
				sb.append("<item id='" +IdPrefix
								+ oaWorkFlowType.getId().toString()
								+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
								+ oaWorkFlowType.getName().toString() + "\">");
				sb.append("<userdata name=\"id\">"+ oaWorkFlowType.getId().toString() +"</userdata>");
				sb.append("<userdata name=\"type\">1</userdata>");
				Long pId = oaWorkFlowType.getId();
				getWorkFlowTypesItemsByParentId(pId.toString(),sb,IdPrefix);
				sb.append("</item>");
			}

	}
	
public Map getWorkFlowTypesSelect(OaWorkFlowType oaWorkFlowType){
	   List ls = dao.getOaWorkFlowTypes(oaWorkFlowType);
       Map reply = new LinkedHashMap();
       Iterator it = ls.iterator();
//       reply.put( "0","");
       while (it.hasNext()){
    	   OaWorkFlowType workFlowType = new OaWorkFlowType();
    	   workFlowType = (OaWorkFlowType)it.next();
           reply.put(workFlowType.getId(),workFlowType.getName());
       }
       return reply;
}

	   
}
