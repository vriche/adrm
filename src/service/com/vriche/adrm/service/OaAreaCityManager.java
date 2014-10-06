
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.OaAreaCity;
import com.vriche.adrm.dao.OaAreaCityDao;

public interface OaAreaCityManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setOaAreaCityDao(OaAreaCityDao oaAreaCityDAO);

    /**
     * Retrieves all of the oaAreaCitys
     */
    public List getOaAreaCitys(OaAreaCity oaAreaCity);
     /**
     * Retrieves all of the oaAreaCitysCount
     */
    public String getOaAreaCitysCount(OaAreaCity oaAreaCity);
     /**
     * Retrieves all of the oaAreaCitysCount
     */    
    public PaginatedList getOaAreaCitysPage(OaAreaCity oaAreaCity,String pageIndex,String pageSize);
     /**
     * Retrieves all of the oaAreaCitysByIdList
     */
    public List getOaAreaCitysByIdList(final Map idList);

    /**
     * Gets oaAreaCity's information based on id.
     * @param id the oaAreaCity's id
     * @return oaAreaCity populated oaAreaCity object
     */
    public OaAreaCity getOaAreaCity(final String id);

    /**
     * Saves a oaAreaCity's information
     * @param oaAreaCity the object to be saved
     */
    public String saveOaAreaCity(OaAreaCity oaAreaCity);

    /**
     * Removes a oaAreaCity from the database by id
     * @param id the oaAreaCity's id
     */
    public void removeOaAreaCity(final String id);
     /**
     * Removes a oaAreaCity from the database by id
     * @param idList
     */
    public void removeOaAreaCitys(final Map idList);
}

