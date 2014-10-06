
package com.vriche.adrm.service.impl;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.impl.BaseManager;
import com.vriche.adrm.model.OaWorkFlowCheckResult;
import com.vriche.adrm.model.OaWorkFlowType;
import com.vriche.adrm.dao.OaWorkFlowCheckResultDao;
import com.vriche.adrm.service.OaWorkFlowCheckResultManager;

public class OaWorkFlowCheckResultManagerImpl extends BaseManager implements OaWorkFlowCheckResultManager {
    private OaWorkFlowCheckResultDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setOaWorkFlowCheckResultDao(OaWorkFlowCheckResultDao dao) {
        this.dao = dao;
    }
   /**
     * @see com.vriche.adrm.service.OaWorkFlowCheckResultManager#getOaWorkFlowCheckResults(com.vriche.adrm.model.OaWorkFlowCheckResult)
     */
    public List getOaWorkFlowCheckResults(final OaWorkFlowCheckResult oaWorkFlowCheckResult) {
        return dao.getOaWorkFlowCheckResults(oaWorkFlowCheckResult);
    }
   /**
     * @see com.vriche.adrm.service.OaWorkFlowCheckResultManager#getOaWorkFlowCheckResultsCount(com.vriche.adrm.model.OaWorkFlowCheckResult)
     */
    public String getOaWorkFlowCheckResultsCount(final OaWorkFlowCheckResult oaWorkFlowCheckResult) {
        return dao.getOaWorkFlowCheckResultsCount(oaWorkFlowCheckResult).toString();
    }    

   /**
     * @see com.vriche.adrm.service.OaWorkFlowCheckResultManager#getOaWorkFlowCheckResultsCount(com.vriche.adrm.model.OaWorkFlowCheckResult)
     */    
	public PaginatedList getOaWorkFlowCheckResultsPage(final OaWorkFlowCheckResult oaWorkFlowCheckResult,String pageIndex, String pageSize) {
		return dao.getOaWorkFlowCheckResultsPage(oaWorkFlowCheckResult,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    

    /**
     * @see com.vriche.adrm.service.OaWorkFlowCheckResultManager#getOaWorkFlowCheckResult(String id)
     */
    public OaWorkFlowCheckResult getOaWorkFlowCheckResult(final String id) {
        return dao.getOaWorkFlowCheckResult(new Long(id));
    }
    /**
     * @see com.vriche.adrm.service.OaWorkFlowCheckResultManager#getOaWorkFlowCheckResultsByIdList(final Map idList)
     */
    public List getOaWorkFlowCheckResultsByIdList(final Map idList) {
        return dao.getOaWorkFlowCheckResultsByIdList(idList);
    }    

    /**
     * @see com.vriche.adrm.service.OaWorkFlowCheckResultManager#saveOaWorkFlowCheckResult(OaWorkFlowCheckResult oaWorkFlowCheckResult)
     */
    public String saveOaWorkFlowCheckResult(OaWorkFlowCheckResult oaWorkFlowCheckResult) {
        return dao.saveOaWorkFlowCheckResult(oaWorkFlowCheckResult).toString();
    }

    /**
     * @see com.vriche.adrm.service.OaWorkFlowCheckResultManager#removeOaWorkFlowCheckResult(String id)
     */
    public void removeOaWorkFlowCheckResult(final String id) {
        dao.removeOaWorkFlowCheckResult(new Long(id));
    }

     /**
     * @see com.vriche.adrm.service.OaWorkFlowCheckResultManager#removeOaWorkFlowCheckResults(String Map)
     */
    public void removeOaWorkFlowCheckResults(final Map idList) {
        dao.removeOaWorkFlowCheckResults(idList);
    }
	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.OaWorkFlowCheckResultManager#getWorkFlowCheckResultsSelect(com.vriche.adrm.model.OaWorkFlowCheckResult)
	 */
	public Map getWorkFlowCheckResultsSelect(OaWorkFlowCheckResult oaWorkFlowCheckResult) {
		   List ls = dao.getOaWorkFlowCheckResults(oaWorkFlowCheckResult);
	       Map reply = new LinkedHashMap();
	       Iterator it = ls.iterator();
	       while (it.hasNext()){
	    	   OaWorkFlowCheckResult workFlowCheckResult = new OaWorkFlowCheckResult();
	    	   workFlowCheckResult = (OaWorkFlowCheckResult)it.next();
	           reply.put(workFlowCheckResult.getId(),workFlowCheckResult.getName());
	       }
	       return reply;
	}  
    
    
}
