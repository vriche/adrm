
package com.vriche.adrm.service.impl;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.Constants;
import com.vriche.adrm.service.impl.BaseManager;
import com.vriche.adrm.model.Industry;
import com.vriche.adrm.model.OaAreaCity;
import com.vriche.adrm.dao.OaAreaCityDao;
import com.vriche.adrm.service.OaAreaCityManager;

public class OaAreaCityManagerImpl extends BaseManager implements OaAreaCityManager {
    private OaAreaCityDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setOaAreaCityDao(OaAreaCityDao dao) {
        this.dao = dao;
    }
   /**
     * @see com.vriche.adrm.service.OaAreaCityManager#getOaAreaCitys(com.vriche.adrm.model.OaAreaCity)
     */
    public List getOaAreaCitys(final OaAreaCity oaAreaCity) {
        return dao.getOaAreaCitys(oaAreaCity);
    }
   /**
     * @see com.vriche.adrm.service.OaAreaCityManager#getOaAreaCitysCount(com.vriche.adrm.model.OaAreaCity)
     */
    public String getOaAreaCitysCount(final OaAreaCity oaAreaCity) {
        return dao.getOaAreaCitysCount(oaAreaCity).toString();
    }    

   /**
     * @see com.vriche.adrm.service.OaAreaCityManager#getOaAreaCitysCount(com.vriche.adrm.model.OaAreaCity)
     */    
	public PaginatedList getOaAreaCitysPage(final OaAreaCity oaAreaCity,String pageIndex, String pageSize) {
		return dao.getOaAreaCitysPage(oaAreaCity,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    

    /**
     * @see com.vriche.adrm.service.OaAreaCityManager#getOaAreaCity(String id)
     */
    public OaAreaCity getOaAreaCity(final String id) {
        return dao.getOaAreaCity(new Long(id));
    }
    /**
     * @see com.vriche.adrm.service.OaAreaCityManager#getOaAreaCitysByIdList(final Map idList)
     */
    public List getOaAreaCitysByIdList(final Map idList) {
        return dao.getOaAreaCitysByIdList(idList);
    }    

    /**
     * @see com.vriche.adrm.service.OaAreaCityManager#saveOaAreaCity(OaAreaCity oaAreaCity)
     */
    public String saveOaAreaCity(OaAreaCity oaAreaCity) {
        return dao.saveOaAreaCity(oaAreaCity).toString();
    }

    /**
     * @see com.vriche.adrm.service.OaAreaCityManager#removeOaAreaCity(String id)
     */
    public void removeOaAreaCity(final String id) {
        dao.removeOaAreaCity(new Long(id));
    }

     /**
     * @see com.vriche.adrm.service.OaAreaCityManager#removeOaAreaCitys(String Map)
     */
    public void removeOaAreaCitys(final Map idList) {
        dao.removeOaAreaCitys(idList);
    }    
    
    public Map getOaAreaCitySelectFromMap(OaAreaCity oaAreaCity) {
		// TODO Auto-generated method stub
		List oaAreaCityList = getOaAreaCitys(oaAreaCity);
	    Map reply = new LinkedHashMap();
	    Iterator it = oaAreaCityList.iterator();
    	
	    while(it.hasNext()){
	    	OaAreaCity ind =(OaAreaCity)it.next();
	    	
	    	reply.put(ind.getId(),ind.getName());
	    }
		return reply;
	}
}
