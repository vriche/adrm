
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.OaAreaCity;

public interface OaAreaCityDao extends Dao {

    /**
     * Retrieves all of the oaAreaCitys
     */
    public List getOaAreaCitys(OaAreaCity oaAreaCity);
    /**
     * Retrieves all of the getOaAreaCitysCount
     */
    public Integer getOaAreaCitysCount(OaAreaCity oaAreaCity);   
    /**
     * Retrieves all of the getOaAreaCitysPage
     */        
    public PaginatedList getOaAreaCitysPage(OaAreaCity oaAreaCity,int pageIndex,int pageSize);
    /**
     * Retrieves all of the oaAreaCitysByIdList
     */
    public List getOaAreaCitysByIdList(final Map idList);

    /**
     * Gets oaAreaCity's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the oaAreaCity's id
     * @return oaAreaCity populated oaAreaCity object
     */
    public OaAreaCity getOaAreaCity(final Long id);

    /**
     * Saves a oaAreaCity's information
     * @param oaAreaCity the object to be saved
     */    
    public Long saveOaAreaCity(OaAreaCity oaAreaCity);

    /**
     * Removes a oaAreaCity from the database by id
     * @param id the oaAreaCity's id
     */
    public void removeOaAreaCity(final Long id);
	/**
     * Removes oaAreaCitys from the database by ids
     * @param ids the oaAreaCity's id eg:"'1','2','3'"
     */
    public void removeOaAreaCitys(final Map idList);
}

