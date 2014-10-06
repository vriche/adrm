
package com.vriche.adrm.service.impl;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.Constants;
import com.vriche.adrm.dao.OaWorkFlowCheckStateDao;
import com.vriche.adrm.model.OaWorkFlowCheckState;
import com.vriche.adrm.model.User;
import com.vriche.adrm.service.OaWorkFlowCheckStateManager;

public class OaWorkFlowCheckStateManagerImpl extends BaseManager implements OaWorkFlowCheckStateManager {
    private OaWorkFlowCheckStateDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setOaWorkFlowCheckStateDao(OaWorkFlowCheckStateDao dao) {
        this.dao = dao;
    }
   /**
     * @see com.vriche.adrm.service.OaWorkFlowCheckStateManager#getOaWorkFlowCheckStates(com.vriche.adrm.model.OaWorkFlowCheckState)
     */
    public List getOaWorkFlowCheckStates(final OaWorkFlowCheckState oaWorkFlowCheckState) {
        return dao.getOaWorkFlowCheckStates(oaWorkFlowCheckState);
    }
   /**
     * @see com.vriche.adrm.service.OaWorkFlowCheckStateManager#getOaWorkFlowCheckStatesCount(com.vriche.adrm.model.OaWorkFlowCheckState)
     */
    public String getOaWorkFlowCheckStatesCount(final OaWorkFlowCheckState oaWorkFlowCheckState) {
        return dao.getOaWorkFlowCheckStatesCount(oaWorkFlowCheckState).toString();
    }    

   /**
     * @see com.vriche.adrm.service.OaWorkFlowCheckStateManager#getOaWorkFlowCheckStatesCount(com.vriche.adrm.model.OaWorkFlowCheckState)
     */    
	public PaginatedList getOaWorkFlowCheckStatesPage(final OaWorkFlowCheckState oaWorkFlowCheckState,String pageIndex, String pageSize) {
		return dao.getOaWorkFlowCheckStatesPage(oaWorkFlowCheckState,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    

    /**
     * @see com.vriche.adrm.service.OaWorkFlowCheckStateManager#getOaWorkFlowCheckState(String id)
     */
    public OaWorkFlowCheckState getOaWorkFlowCheckState(final String id) {
        return dao.getOaWorkFlowCheckState(new Long(id));
    }
    /**
     * @see com.vriche.adrm.service.OaWorkFlowCheckStateManager#getOaWorkFlowCheckStatesByIdList(final Map idList)
     */
    public List getOaWorkFlowCheckStatesByIdList(final Map idList) {
        return dao.getOaWorkFlowCheckStatesByIdList(idList);
    }    

    /**
     * @see com.vriche.adrm.service.OaWorkFlowCheckStateManager#saveOaWorkFlowCheckState(OaWorkFlowCheckState oaWorkFlowCheckState)
     */
    public String saveOaWorkFlowCheckState(OaWorkFlowCheckState oaWorkFlowCheckState) {
        return dao.saveOaWorkFlowCheckState(oaWorkFlowCheckState).toString();
    }

    /**
     * @see com.vriche.adrm.service.OaWorkFlowCheckStateManager#removeOaWorkFlowCheckState(String id)
     */
    public void removeOaWorkFlowCheckState(final String id) {
        dao.removeOaWorkFlowCheckState(new Long(id));
    }

     /**
     * @see com.vriche.adrm.service.OaWorkFlowCheckStateManager#removeOaWorkFlowCheckStates(String Map)
     */
    public void removeOaWorkFlowCheckStates(final Map idList) {
        dao.removeOaWorkFlowCheckStates(idList);
    }
	public Map getOaWorkFlowCheckStateSelect(OaWorkFlowCheckState oaWorkFlowCheckState) {
		List ls = this.getOaWorkFlowCheckStates(oaWorkFlowCheckState);
		
	    Map reply = new LinkedHashMap();
	    Iterator it = ls.iterator();
	    
	    while(it.hasNext()){
	    	
	    	OaWorkFlowCheckState states =(OaWorkFlowCheckState)it.next();
	    	
	    	reply.put("","==ÉóºË×´Ì¬==");
	    	reply.put("0","Î´Ìá½»");
	    	reply.put(states.getId(),states.getName());
	    }
		return reply;
	} 
	
	public Map getOaWorkFlowCheckStateSelectFromMap() {
		// TODO Auto-generated method stub
//		System.out.println(">>>>>>>>>>>>>>1");
		List ls = (List)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CHECK_STATE);
//		System.out.println(">>>>>>>>>>>>>>ls.size   "+ ls.size());
		Map reply = new LinkedHashMap();
		
	    Iterator it = ls.iterator();
	 	reply.put("","==ÉóºË×´Ì¬==");
    	reply.put("0","Î´Ìá½»");
	    while(it.hasNext()){
	    	
	    	OaWorkFlowCheckState checkState = (OaWorkFlowCheckState) it.next();
	    	
	    	System.out.println(checkState.getId()+">>>>>>>>>>>>>>1"+checkState.getName());
	    	
	    	reply.put(checkState.getId(),checkState.getName());
	    }
		return reply;
		
	}
 }


