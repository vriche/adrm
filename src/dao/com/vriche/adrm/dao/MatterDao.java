
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.Matter;


public interface MatterDao extends Dao {

    /**
     * Retrieves all of the matters
     */
    public List getMatters(Matter matter);
    
    
    public List getStoreMatterLengthByName(Matter matter);
    
    public List getStoreMatterEditByName(Matter matter);
    
    
    
    public List getMattersByOrderId(Matter matter);
    
    
    public List getMattersByCustomerIdAndLength(final Matter matter);
    
    public List getMattersReport(Matter matter);
    
    public Integer getMattersCountByDate(Map mp);
    
    public PaginatedList getMattersByDate(Map mp, int pageIndex, int pageSize) ;
    
    public PaginatedList getMattersPage(Matter matter,int pageIndex,int pageSize);
    
    public Integer getMattersCount(Matter matter);
    
    public Integer getMattersSerachCount(Map mp);
    
    public List getMattersSearchPage(Map mp, int pageIndex, int pageSize);
    
    
    public List getMattersByCustomer(Matter matter);
    /**
     * Retrieves all of the mattersByIdList
     */
    public List getMattersByIdList(final Map idList);

    /**
     * Gets matter's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the matter's id
     * @return matter populated matter object
     */
    public Matter getMatter(final Long id);
    
    public Matter getMatter(Matter matter);
    
    public Matter getMatterByTapCode(Matter matter);
    
    

    /**
     * Saves a matter's information
     * @param matter the object to be saved
     */    
    public Long saveMatter(Matter matter);

    /**
     * Removes a matter from the database by id
     * @param id the matter's id
     */
    public void removeMatter(final Long id);
	/**
     * Removes matters from the database by ids
     * @param ids the matter's id eg:"'1','2','3'"
     */
    public void removeMatters(final Map idList);
    
    public List getAllMatters(String name);
    
    public List getMattersDIV(Matter matter);
    
    public List getMattersByResCut(Map mp);
    
    public List getMattersListPage(Matter matter);
    
    public List getMattersNames(final Matter matter);
    public List getMattersEditsByHelpCode(final Matter matter);
    public List getMattersNews(final Map mp,int pageIndex,int pageSize);
    public Integer getMattersNewsCount(final Map mp);
    
    public void saveMatterInDayang(Matter matter);
    
}

