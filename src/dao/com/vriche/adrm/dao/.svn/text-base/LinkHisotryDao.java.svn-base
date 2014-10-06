
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.LinkHisotry;
import com.vriche.adrm.model.LinkMan;

public interface LinkHisotryDao extends Dao {

    /**
     * Retrieves all of the linkHisotrys
     */
    public List getLinkHisotrys(LinkHisotry linkHisotry);

    /**
     * Retrieves all of the linkHisotrysByIdList
     */
    public List getLinkHisotrysByIdList(final Map idList);

    /**
     * Gets linkHisotry's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the linkHisotry's id
     * @return linkHisotry populated linkHisotry object
     */
    public LinkHisotry getLinkHisotry(final Long id);

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
    public void removeLinkHisotry(final Long id);
	/**
     * Removes linkHisotrys from the database by ids
     * @param ids the linkHisotry's id eg:"'1','2','3'"
     */
    public void removeLinkHisotrys(final Map idList);
    
    public PaginatedList getLinkHisotryPage(LinkHisotry linkHisotry, int pageIndex, int pageSize);
    
    public Integer getLinkHisotryCount(LinkHisotry linkHisotry);
}

