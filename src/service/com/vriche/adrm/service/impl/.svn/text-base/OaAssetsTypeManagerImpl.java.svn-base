
package com.vriche.adrm.service.impl;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.impl.BaseManager;
import com.vriche.adrm.model.OaAssetsType;
import com.vriche.adrm.dao.OaAssetsTypeDao;
import com.vriche.adrm.service.OaAssetsTypeManager;

public class OaAssetsTypeManagerImpl extends BaseManager implements OaAssetsTypeManager {
    private OaAssetsTypeDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setOaAssetsTypeDao(OaAssetsTypeDao dao) {
        this.dao = dao;
    }
   /**
     * @see com.vriche.adrm.service.OaAssetsTypeManager#getOaAssetsTypes(com.vriche.adrm.model.OaAssetsType)
     */
    public List getOaAssetsTypes(final OaAssetsType oaAssetsType) {
        return dao.getOaAssetsTypes(oaAssetsType);
    }
   /**
     * @see com.vriche.adrm.service.OaAssetsTypeManager#getOaAssetsTypesCount(com.vriche.adrm.model.OaAssetsType)
     */
    public String getOaAssetsTypesCount(final OaAssetsType oaAssetsType) {
        return dao.getOaAssetsTypesCount(oaAssetsType).toString();
    }    

   /**
     * @see com.vriche.adrm.service.OaAssetsTypeManager#getOaAssetsTypesCount(com.vriche.adrm.model.OaAssetsType)
     */    
	public PaginatedList getOaAssetsTypesPage(final OaAssetsType oaAssetsType,String pageIndex, String pageSize) {
		return dao.getOaAssetsTypesPage(oaAssetsType,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    

    /**
     * @see com.vriche.adrm.service.OaAssetsTypeManager#getOaAssetsType(String id)
     */
    public OaAssetsType getOaAssetsType(final String id) {
        return dao.getOaAssetsType(new Long(id));
    }
    /**
     * @see com.vriche.adrm.service.OaAssetsTypeManager#getOaAssetsTypesByIdList(final Map idList)
     */
    public List getOaAssetsTypesByIdList(final Map idList) {
        return dao.getOaAssetsTypesByIdList(idList);
    }    

    /**
     * @see com.vriche.adrm.service.OaAssetsTypeManager#saveOaAssetsType(OaAssetsType oaAssetsType)
     */
    public String saveOaAssetsType(OaAssetsType oaAssetsType) {
        return dao.saveOaAssetsType(oaAssetsType).toString();
    }

    /**
     * @see com.vriche.adrm.service.OaAssetsTypeManager#removeOaAssetsType(String id)
     */
    public void removeOaAssetsType(final String id) {
        dao.removeOaAssetsType(new Long(id));
    }

     /**
     * @see com.vriche.adrm.service.OaAssetsTypeManager#removeOaAssetsTypes(String Map)
     */
    public void removeOaAssetsTypes(final Map idList) {
        dao.removeOaAssetsTypes(idList);
    }    
}
