
package com.vriche.adrm.service.impl;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.impl.BaseManager;
import com.vriche.adrm.model.OaWorkFlowMoveType;
import com.vriche.adrm.dao.OaWorkFlowMoveTypeDao;
import com.vriche.adrm.service.OaWorkFlowMoveTypeManager;

public class OaWorkFlowMoveTypeManagerImpl extends BaseManager implements OaWorkFlowMoveTypeManager {
    private OaWorkFlowMoveTypeDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setOaWorkFlowMoveTypeDao(OaWorkFlowMoveTypeDao dao) {
        this.dao = dao;
    }
   /**
     * @see com.vriche.adrm.service.OaWorkFlowMoveTypeManager#getOaWorkFlowMoveTypes(com.vriche.adrm.model.OaWorkFlowMoveType)
     */
    public List getOaWorkFlowMoveTypes(final OaWorkFlowMoveType oaWorkFlowMoveType) {
        return dao.getOaWorkFlowMoveTypes(oaWorkFlowMoveType);
    }
   /**
     * @see com.vriche.adrm.service.OaWorkFlowMoveTypeManager#getOaWorkFlowMoveTypesCount(com.vriche.adrm.model.OaWorkFlowMoveType)
     */
    public String getOaWorkFlowMoveTypesCount(final OaWorkFlowMoveType oaWorkFlowMoveType) {
        return dao.getOaWorkFlowMoveTypesCount(oaWorkFlowMoveType).toString();
    }    

   /**
     * @see com.vriche.adrm.service.OaWorkFlowMoveTypeManager#getOaWorkFlowMoveTypesCount(com.vriche.adrm.model.OaWorkFlowMoveType)
     */    
	public PaginatedList getOaWorkFlowMoveTypesPage(final OaWorkFlowMoveType oaWorkFlowMoveType,String pageIndex, String pageSize) {
		return dao.getOaWorkFlowMoveTypesPage(oaWorkFlowMoveType,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    

    /**
     * @see com.vriche.adrm.service.OaWorkFlowMoveTypeManager#getOaWorkFlowMoveType(String id)
     */
    public OaWorkFlowMoveType getOaWorkFlowMoveType(final String id) {
        return dao.getOaWorkFlowMoveType(new Long(id));
    }
    /**
     * @see com.vriche.adrm.service.OaWorkFlowMoveTypeManager#getOaWorkFlowMoveTypesByIdList(final Map idList)
     */
    public List getOaWorkFlowMoveTypesByIdList(final Map idList) {
        return dao.getOaWorkFlowMoveTypesByIdList(idList);
    }    

    /**
     * @see com.vriche.adrm.service.OaWorkFlowMoveTypeManager#saveOaWorkFlowMoveType(OaWorkFlowMoveType oaWorkFlowMoveType)
     */
    public String saveOaWorkFlowMoveType(OaWorkFlowMoveType oaWorkFlowMoveType) {
        return dao.saveOaWorkFlowMoveType(oaWorkFlowMoveType).toString();
    }

    /**
     * @see com.vriche.adrm.service.OaWorkFlowMoveTypeManager#removeOaWorkFlowMoveType(String id)
     */
    public void removeOaWorkFlowMoveType(final String id) {
        dao.removeOaWorkFlowMoveType(new Long(id));
    }

     /**
     * @see com.vriche.adrm.service.OaWorkFlowMoveTypeManager#removeOaWorkFlowMoveTypes(String Map)
     */
    public void removeOaWorkFlowMoveTypes(final Map idList) {
        dao.removeOaWorkFlowMoveTypes(idList);
    }    
}
