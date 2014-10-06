
package com.vriche.adrm.service.impl;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.impl.BaseManager;
import com.vriche.adrm.model.OaBusinessCardType;
import com.vriche.adrm.dao.OaBusinessCardTypeDao;
import com.vriche.adrm.service.OaBusinessCardTypeManager;

public class OaBusinessCardTypeManagerImpl extends BaseManager implements OaBusinessCardTypeManager {
    private OaBusinessCardTypeDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setOaBusinessCardTypeDao(OaBusinessCardTypeDao dao) {
        this.dao = dao;
    }
   /**
     * @see com.vriche.adrm.service.OaBusinessCardTypeManager#getOaBusinessCardTypes(com.vriche.adrm.model.OaBusinessCardType)
     */
    public List getOaBusinessCardTypes(final OaBusinessCardType oaBusinessCardType) {
        return dao.getOaBusinessCardTypes(oaBusinessCardType);
    }
   /**
     * @see com.vriche.adrm.service.OaBusinessCardTypeManager#getOaBusinessCardTypesCount(com.vriche.adrm.model.OaBusinessCardType)
     */
    public String getOaBusinessCardTypesCount(final OaBusinessCardType oaBusinessCardType) {
        return dao.getOaBusinessCardTypesCount(oaBusinessCardType).toString();
    }    

   /**
     * @see com.vriche.adrm.service.OaBusinessCardTypeManager#getOaBusinessCardTypesCount(com.vriche.adrm.model.OaBusinessCardType)
     */    
	public PaginatedList getOaBusinessCardTypesPage(final OaBusinessCardType oaBusinessCardType,String pageIndex, String pageSize) {
		return dao.getOaBusinessCardTypesPage(oaBusinessCardType,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    

    /**
     * @see com.vriche.adrm.service.OaBusinessCardTypeManager#getOaBusinessCardType(String id)
     */
    public OaBusinessCardType getOaBusinessCardType(final String id) {
        return dao.getOaBusinessCardType(new Long(id));
    }
    /**
     * @see com.vriche.adrm.service.OaBusinessCardTypeManager#getOaBusinessCardTypesByIdList(final Map idList)
     */
    public List getOaBusinessCardTypesByIdList(final Map idList) {
        return dao.getOaBusinessCardTypesByIdList(idList);
    }    

    /**
     * @see com.vriche.adrm.service.OaBusinessCardTypeManager#saveOaBusinessCardType(OaBusinessCardType oaBusinessCardType)
     */
    public String saveOaBusinessCardType(OaBusinessCardType oaBusinessCardType) {
        return dao.saveOaBusinessCardType(oaBusinessCardType).toString();
    }

    /**
     * @see com.vriche.adrm.service.OaBusinessCardTypeManager#removeOaBusinessCardType(String id)
     */
    public void removeOaBusinessCardType(final String id) {
        dao.removeOaBusinessCardType(new Long(id));
    }

     /**
     * @see com.vriche.adrm.service.OaBusinessCardTypeManager#removeOaBusinessCardTypes(String Map)
     */
    public void removeOaBusinessCardTypes(final Map idList) {
        dao.removeOaBusinessCardTypes(idList);
    }    
}
