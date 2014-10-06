
package com.vriche.adrm.dao;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.PublishArrange;

public interface PublishArrangeDao extends Dao {
	
    /**
     * Retrieves all of the publishArranges
     */
    public List getPublishArranges(PublishArrange publishArrange);
    /**
     * Retrieves all of the getPublishArrangesCount
     */
    public Integer getPublishArrangesCount(PublishArrange publishArrange);   
    /**
     * Retrieves all of the getPublishArrangesPage
     */        
    public PaginatedList getPublishArrangesPage(PublishArrange publishArrange,int pageIndex,int pageSize);
    /**
     * Retrieves all of the publishArrangesByIdList
     */
    public List getPublishArrangesByIdList(final Map idList);
    
    public List getPublishArrangesByIdListFromHistory(final Map idList);

    /**
     * Gets publishArrange's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the publishArrange's id
     * @return publishArrange populated publishArrange object
     */
    public PublishArrange getPublishArrange(final Long id);

    /**
     * Saves a publishArrange's information
     * @param publishArrange the object to be saved
     */    
    public Long savePublishArrange(PublishArrange publishArrange);

    
    public void updatePublishArrangeLock(Map idList) ;
    /**
     * Removes a publishArrange from the database by id
     * @param id the publishArrange's id
     */
    public void removePublishArrange(final Long id);
	/**
     * Removes publishArranges from the database by ids
     * @param ids the publishArrange's id eg:"'1','2','3'"
     */
    public void removePublishArranges(final Map idList);
    
    
    public void savePublishArrangeObjArray(PublishArrange[] objs);
    
    public List getPublishArrangeIds(final Integer curDate);
    
    public void savePublishArrangeBak(final Map idList);
    
    public void savePublishArrangeDetailBak(final Map idList);
    
    public void savePublishArrangeBakFile(final Map idList);
    
    public void savePublishArrangeDetailBakFile(final Map idList);
    
    public List getPublishArrangeIdsByDateResid(final Map mp);

}

