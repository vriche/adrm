
package com.vriche.adrm.service.impl;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.impl.BaseManager;
import com.vriche.adrm.model.OaInfoType;
import com.vriche.adrm.dao.OaInfoTypeDao;
import com.vriche.adrm.service.OaInfoTypeManager;

public class OaInfoTypeManagerImpl extends BaseManager implements OaInfoTypeManager {
    private OaInfoTypeDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setOaInfoTypeDao(OaInfoTypeDao dao) {
        this.dao = dao;
    }
   /**
     * @see com.vriche.adrm.service.OaInfoTypeManager#getOaInfoTypes(com.vriche.adrm.model.OaInfoType)
     */
    public List getOaInfoTypes(final OaInfoType oaInfoType) {
        return dao.getOaInfoTypes(oaInfoType);
    }
   /**
     * @see com.vriche.adrm.service.OaInfoTypeManager#getOaInfoTypesCount(com.vriche.adrm.model.OaInfoType)
     */
    public String getOaInfoTypesCount(final OaInfoType oaInfoType) {
        return dao.getOaInfoTypesCount(oaInfoType).toString();
    }    

   /**
     * @see com.vriche.adrm.service.OaInfoTypeManager#getOaInfoTypesCount(com.vriche.adrm.model.OaInfoType)
     */    
	public PaginatedList getOaInfoTypesPage(final OaInfoType oaInfoType,String pageIndex, String pageSize) {
		return dao.getOaInfoTypesPage(oaInfoType,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    

    /**
     * @see com.vriche.adrm.service.OaInfoTypeManager#getOaInfoType(String id)
     */
    public OaInfoType getOaInfoType(final String id) {
        return dao.getOaInfoType(new Long(id));
    }
    /**
     * @see com.vriche.adrm.service.OaInfoTypeManager#getOaInfoTypesByIdList(final Map idList)
     */
    public List getOaInfoTypesByIdList(final Map idList) {
        return dao.getOaInfoTypesByIdList(idList);
    }    

    /**
     * @see com.vriche.adrm.service.OaInfoTypeManager#saveOaInfoType(OaInfoType oaInfoType)
     */
    public String saveOaInfoType(OaInfoType oaInfoType) {
        return dao.saveOaInfoType(oaInfoType).toString();
    }

    /**
     * @see com.vriche.adrm.service.OaInfoTypeManager#removeOaInfoType(String id)
     */
    public void removeOaInfoType(final String id) {
        dao.removeOaInfoType(new Long(id));
    }

     /**
     * @see com.vriche.adrm.service.OaInfoTypeManager#removeOaInfoTypes(String Map)
     */
    public void removeOaInfoTypes(final Map idList) {
        dao.removeOaInfoTypes(idList);
    }    
}
