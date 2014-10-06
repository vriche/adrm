
package com.vriche.adrm.service.impl;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.impl.BaseManager;
import com.vriche.adrm.model.OaDocumentCatalogPermitType;
import com.vriche.adrm.dao.OaDocumentCatalogPermitTypeDao;
import com.vriche.adrm.service.OaDocumentCatalogPermitTypeManager;

public class OaDocumentCatalogPermitTypeManagerImpl extends BaseManager implements OaDocumentCatalogPermitTypeManager {
    private OaDocumentCatalogPermitTypeDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setOaDocumentCatalogPermitTypeDao(OaDocumentCatalogPermitTypeDao dao) {
        this.dao = dao;
    }
   /**
     * @see com.vriche.adrm.service.OaDocumentCatalogPermitTypeManager#getOaDocumentCatalogPermitTypes(com.vriche.adrm.model.OaDocumentCatalogPermitType)
     */
    public List getOaDocumentCatalogPermitTypes(final OaDocumentCatalogPermitType oaDocumentCatalogPermitType) {
        return dao.getOaDocumentCatalogPermitTypes(oaDocumentCatalogPermitType);
    }
   /**
     * @see com.vriche.adrm.service.OaDocumentCatalogPermitTypeManager#getOaDocumentCatalogPermitTypesCount(com.vriche.adrm.model.OaDocumentCatalogPermitType)
     */
    public String getOaDocumentCatalogPermitTypesCount(final OaDocumentCatalogPermitType oaDocumentCatalogPermitType) {
        return dao.getOaDocumentCatalogPermitTypesCount(oaDocumentCatalogPermitType).toString();
    }    

   /**
     * @see com.vriche.adrm.service.OaDocumentCatalogPermitTypeManager#getOaDocumentCatalogPermitTypesCount(com.vriche.adrm.model.OaDocumentCatalogPermitType)
     */    
	public PaginatedList getOaDocumentCatalogPermitTypesPage(final OaDocumentCatalogPermitType oaDocumentCatalogPermitType,String pageIndex, String pageSize) {
		return dao.getOaDocumentCatalogPermitTypesPage(oaDocumentCatalogPermitType,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    

    /**
     * @see com.vriche.adrm.service.OaDocumentCatalogPermitTypeManager#getOaDocumentCatalogPermitType(String id)
     */
    public OaDocumentCatalogPermitType getOaDocumentCatalogPermitType(final String id) {
        return dao.getOaDocumentCatalogPermitType(new Long(id));
    }
    /**
     * @see com.vriche.adrm.service.OaDocumentCatalogPermitTypeManager#getOaDocumentCatalogPermitTypesByIdList(final Map idList)
     */
    public List getOaDocumentCatalogPermitTypesByIdList(final Map idList) {
        return dao.getOaDocumentCatalogPermitTypesByIdList(idList);
    }    

    /**
     * @see com.vriche.adrm.service.OaDocumentCatalogPermitTypeManager#saveOaDocumentCatalogPermitType(OaDocumentCatalogPermitType oaDocumentCatalogPermitType)
     */
    public String saveOaDocumentCatalogPermitType(OaDocumentCatalogPermitType oaDocumentCatalogPermitType) {
        return dao.saveOaDocumentCatalogPermitType(oaDocumentCatalogPermitType).toString();
    }

    /**
     * @see com.vriche.adrm.service.OaDocumentCatalogPermitTypeManager#removeOaDocumentCatalogPermitType(String id)
     */
    public void removeOaDocumentCatalogPermitType(final String id) {
        dao.removeOaDocumentCatalogPermitType(new Long(id));
    }

     /**
     * @see com.vriche.adrm.service.OaDocumentCatalogPermitTypeManager#removeOaDocumentCatalogPermitTypes(String Map)
     */
    public void removeOaDocumentCatalogPermitTypes(final Map idList) {
        dao.removeOaDocumentCatalogPermitTypes(idList);
    }    
}
