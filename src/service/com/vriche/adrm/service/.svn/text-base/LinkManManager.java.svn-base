
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.LinkManDao;
import com.vriche.adrm.model.CustomerAddress;
import com.vriche.adrm.model.LinkMan;
import com.vriche.adrm.service.Manager;

public interface LinkManManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setLinkManDao(LinkManDao linkManDAO);

    /**
     * Retrieves all of the linkMans
     */
    public List getLinkMans(LinkMan linkMan);
        /**
     * Retrieves all of the linkMansByIdList
     */
    public List getLinkMansByIdList(final Map idList);

    /**
     * Gets linkMan's information based on id.
     * @param id the linkMan's id
     * @return linkMan populated linkMan object
     */
    public LinkMan getLinkMan(final String id);

    /**
     * Saves a linkMan's information
     * @param linkMan the object to be saved
     */
    public void saveLinkMan(LinkMan linkMan);
    
    public Long saveCustomerLinkMan(LinkMan linkMan);

    /**
     * Removes a linkMan from the database by id
     * @param id the linkMan's id
     */
    public void removeLinkMan(final String id);
     /**
     * Removes a linkMan from the database by id
     * @param idList
     */
    public void removeLinkMans(final Map idList);
    
    public PaginatedList getLinkManPage(LinkMan linkMan, String pageIndex, String pageSize);
    
    public String getLinkManCount(LinkMan linkMan);
    
    public void resetMainLinkMan(String cusId);
    
    public String getLinkManXML(LinkMan linkMan);
}

