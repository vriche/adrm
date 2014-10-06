
package com.vriche.adrm.service.impl;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.impl.BaseManager;
import com.vriche.adrm.model.OaProductType;
import com.vriche.adrm.dao.OaProductTypeDao;
import com.vriche.adrm.service.OaProductTypeManager;

public class OaProductTypeManagerImpl extends BaseManager implements OaProductTypeManager {
    private OaProductTypeDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setOaProductTypeDao(OaProductTypeDao dao) {
        this.dao = dao;
    }
   /**
     * @see com.vriche.adrm.service.OaProductTypeManager#getOaProductTypes(com.vriche.adrm.model.OaProductType)
     */
    public List getOaProductTypes(final OaProductType oaProductType) {
        return dao.getOaProductTypes(oaProductType);
    }
   /**
     * @see com.vriche.adrm.service.OaProductTypeManager#getOaProductTypesCount(com.vriche.adrm.model.OaProductType)
     */
    public String getOaProductTypesCount(final OaProductType oaProductType) {
        return dao.getOaProductTypesCount(oaProductType).toString();
    }    

   /**
     * @see com.vriche.adrm.service.OaProductTypeManager#getOaProductTypesCount(com.vriche.adrm.model.OaProductType)
     */    
	public PaginatedList getOaProductTypesPage(final OaProductType oaProductType,String pageIndex, String pageSize) {
		return dao.getOaProductTypesPage(oaProductType,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    

    /**
     * @see com.vriche.adrm.service.OaProductTypeManager#getOaProductType(String id)
     */
    public OaProductType getOaProductType(final String id) {
        return dao.getOaProductType(new Long(id));
    }
    /**
     * @see com.vriche.adrm.service.OaProductTypeManager#getOaProductTypesByIdList(final Map idList)
     */
    public List getOaProductTypesByIdList(final Map idList) {
        return dao.getOaProductTypesByIdList(idList);
    }    

    /**
     * @see com.vriche.adrm.service.OaProductTypeManager#saveOaProductType(OaProductType oaProductType)
     */
    public String saveOaProductType(OaProductType oaProductType) {
        return dao.saveOaProductType(oaProductType).toString();
    }

    /**
     * @see com.vriche.adrm.service.OaProductTypeManager#removeOaProductType(String id)
     */
    public void removeOaProductType(final String id) {
        dao.removeOaProductType(new Long(id));
    }

     /**
     * @see com.vriche.adrm.service.OaProductTypeManager#removeOaProductTypes(String Map)
     */
    public void removeOaProductTypes(final Map idList) {
        dao.removeOaProductTypes(idList);
    }    
}
