
package com.vriche.adrm.service.impl;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.MediaOrgDao;
import com.vriche.adrm.model.MediaOrg;
import com.vriche.adrm.model.ResourceType;
import com.vriche.adrm.service.MediaOrgManager;
import com.vriche.adrm.service.impl.BaseManager;

public class MediaOrgManagerImpl extends BaseManager implements MediaOrgManager {
    private MediaOrgDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setMediaOrgDao(MediaOrgDao dao) {
        this.dao = dao;
    }

    /**
     * @see com.vriche.adrm.adres.service.MediaOrgManager#getMediaOrgsByIdList(final Map idList)
     */
    public List getMediaOrgsByIdList(final Map idList) {
        return dao.getMediaOrgsByIdList(idList);
    }
   /**
     * @see com.vriche.adrm.adres.service.MediaOrgManager#getMediaOrgs(com.vriche.adrm.adres.model.MediaOrg)
     */
    public List getMediaOrgs(final MediaOrg mediaOrg) {
        return dao.getMediaOrgs(mediaOrg);
    }

    /**
     * @see com.vriche.adrm.adres.service.MediaOrgManager#getMediaOrg(String id)
     */
    public MediaOrg getMediaOrg(final String id) {
        return dao.getMediaOrg(new Long(id));
    }

    /**
     * @see com.vriche.adrm.adres.service.MediaOrgManager#saveMediaOrg(MediaOrg mediaOrg)
     */
    public void saveMediaOrg(MediaOrg mediaOrg) {
        dao.saveMediaOrg(mediaOrg);
    }

    /**
     * @see com.vriche.adrm.adres.service.MediaOrgManager#removeMediaOrg(String id)
     */
    public void removeMediaOrg(final String id) {
        dao.removeMediaOrg(new Long(id));
    }

     /**
     * @see com.vriche.adrm.adres.service.MediaOrgManager#removeMediaOrgs(String Map)
     */
    public void removeMediaOrgs(final Map idList) {
        dao.removeMediaOrgs(idList);
    }    
    
    
    public Map getMediaOrgsSelectItem(MediaOrg mediaOrg){
		Map reply = new LinkedHashMap();
		
		
    	List mediaOrgs = this.getMediaOrgs(mediaOrg);
    	
    	Iterator ite= mediaOrgs.iterator();

		while(ite.hasNext()){
			
			MediaOrg med =(MediaOrg)ite.next();

			reply.put(med.getId(),med.getName());

		}
		return reply;
    }
    
    
    
}
