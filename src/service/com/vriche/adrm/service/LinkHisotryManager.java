
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.LinkHisotryDao;
import com.vriche.adrm.model.LinkHisotry;
import com.vriche.adrm.service.Manager;

public interface LinkHisotryManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setLinkHisotryDao(LinkHisotryDao linkHisotryDAO);

    /**
     * Retrieves all of the linkHisotrys
     */
    public List getLinkHisotrys(LinkHisotry linkHisotry);
        /**
     * Retrieves all of the linkHisotrysByIdList
     */
    public List getLinkHisotrysByIdList(final Map idList);

    /**
     * Gets linkHisotry's information based on id.
     * @param id the linkHisotry's id
     * @return linkHisotry populated linkHisotry object
     */
    public LinkHisotry getLinkHisotry(final String id);

    /**
     * Saves a linkHisotry's information
     * @param linkHisotry the object to be saved
     */
    public void saveLinkHisotry(LinkHisotry linkHisotry);
    
    public Long saveCustomerLinkHisotryList(LinkHisotry linkHisotry);

    /**
     * Removes a linkHisotry from the database by id
     * @param id the linkHisotry's id
     */
    public void removeLinkHisotry(final String id);
     /**
     * Removes a linkHisotry from the database by id
     * @param idList
     */
    public void removeLinkHisotrys(final Map idList);
    
    public PaginatedList getLinkHisotryPage(LinkHisotry linkHisotry, String pageIndex, String pageSize);
    
    public String getLinkHisotryCount(LinkHisotry linkHisotry);
    
    public String getlinkHistoryXML(LinkHisotry linkHisotry);
}

