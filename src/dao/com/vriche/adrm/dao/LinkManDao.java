
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.LinkMan;

public interface LinkManDao extends Dao {

    /**
     * Retrieves all of the linkMans
     */
    public List getLinkMans(LinkMan linkMan);

    /**
     * Retrieves all of the linkMansByIdList
     */
    public List getLinkMansByIdList(final Map idList);

    /**
     * Gets linkMan's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the linkMan's id
     * @return linkMan populated linkMan object
     */
    public LinkMan getLinkMan(final Long id);

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
    public void removeLinkMan(final Long id);
	/**
     * Removes linkMans from the database by ids
     * @param ids the linkMan's id eg:"'1','2','3'"
     */
    public void removeLinkMans(final Map idList);
    
    public PaginatedList getLinkManPage(LinkMan linkMan, int pageIndex, int pageSize);
    
    public Integer getLinkManCount(LinkMan linkMan);
    
    public void resetMainLinkMan(Long cusId);
}

