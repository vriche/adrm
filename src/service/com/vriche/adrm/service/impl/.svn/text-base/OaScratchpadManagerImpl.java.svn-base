
package com.vriche.adrm.service.impl;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.impl.BaseManager;
import com.vriche.adrm.model.OaScratchpad;
import com.vriche.adrm.dao.OaScratchpadDao;
import com.vriche.adrm.service.OaScratchpadManager;

public class OaScratchpadManagerImpl extends BaseManager implements OaScratchpadManager {
    private OaScratchpadDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setOaScratchpadDao(OaScratchpadDao dao) {
        this.dao = dao;
    }
   /**
     * @see com.vriche.adrm.service.OaScratchpadManager#getOaScratchpads(com.vriche.adrm.model.OaScratchpad)
     */
    public List getOaScratchpads(final OaScratchpad oaScratchpad) {
        return dao.getOaScratchpads(oaScratchpad);
    }
   /**
     * @see com.vriche.adrm.service.OaScratchpadManager#getOaScratchpadsCount(com.vriche.adrm.model.OaScratchpad)
     */
    public String getOaScratchpadsCount(final OaScratchpad oaScratchpad) {
        return dao.getOaScratchpadsCount(oaScratchpad).toString();
    }    

   /**
     * @see com.vriche.adrm.service.OaScratchpadManager#getOaScratchpadsCount(com.vriche.adrm.model.OaScratchpad)
     */    
	public PaginatedList getOaScratchpadsPage(final OaScratchpad oaScratchpad,String pageIndex, String pageSize) {
		return dao.getOaScratchpadsPage(oaScratchpad,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    

    /**
     * @see com.vriche.adrm.service.OaScratchpadManager#getOaScratchpad(String id)
     */
    public OaScratchpad getOaScratchpad(final String id) {
        return dao.getOaScratchpad(new Long(id));
    }
    /**
     * @see com.vriche.adrm.service.OaScratchpadManager#getOaScratchpadsByIdList(final Map idList)
     */
    public List getOaScratchpadsByIdList(final Map idList) {
        return dao.getOaScratchpadsByIdList(idList);
    }    

    /**
     * @see com.vriche.adrm.service.OaScratchpadManager#saveOaScratchpad(OaScratchpad oaScratchpad)
     */
    public String saveOaScratchpad(OaScratchpad oaScratchpad) {
        return dao.saveOaScratchpad(oaScratchpad).toString();
    }

    /**
     * @see com.vriche.adrm.service.OaScratchpadManager#removeOaScratchpad(String id)
     */
    public void removeOaScratchpad(final String id) {
        dao.removeOaScratchpad(new Long(id));
    }

     /**
     * @see com.vriche.adrm.service.OaScratchpadManager#removeOaScratchpads(String Map)
     */
    public void removeOaScratchpads(final Map idList) {
        dao.removeOaScratchpads(idList);
    }    
}
