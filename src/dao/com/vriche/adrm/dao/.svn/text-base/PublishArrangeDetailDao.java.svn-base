
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.PublishArrangeDetail;

public interface PublishArrangeDetailDao extends Dao {

    /**
     * Retrieves all of the publishArrangeDetails
     */
    public List getPublishArrangeDetails(PublishArrangeDetail publishArrangeDetail);
    /**
     * Retrieves all of the getPublishArrangeDetailsCount
     */
    public Integer getPublishArrangeDetailsCount(PublishArrangeDetail publishArrangeDetail);   
    /**
     * Retrieves all of the getPublishArrangeDetailsPage
     */        
    public PaginatedList getPublishArrangeDetailsPage(PublishArrangeDetail publishArrangeDetail,int pageIndex,int pageSize);
    /**
     * Retrieves all of the publishArrangeDetailsByIdList
     */
    public List getPublishArrangeDetailsByIdList(final Map idList);
    
    public List getPublishArrangeDetailsByIdLists(final Map idList);
    
    public List getPublishArrangeDetailsByIdLists3(final Map idList);
    
    public List getPublishArrangeDetailsByIdLists4(final Map idList);
    
    public List getPublishArrangeDetailsByIdListFromHistory(final Map idList);
    
    public List getPublishArrangeDetailsByIdListForPublishSort(Map mp);
    
    public List getDetailidByResourceIdDate(final Map idList);
    

    /**
     * Gets publishArrangeDetail's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the publishArrangeDetail's id
     * @return publishArrangeDetail populated publishArrangeDetail object
     */
    public PublishArrangeDetail getPublishArrangeDetail(final Long id);

    /**
     * Saves a publishArrangeDetail's information
     * @param publishArrangeDetail the object to be saved
     */    
    public Long savePublishArrangeDetail(PublishArrangeDetail publishArrangeDetail);
    
    
    public void savePublishArrangeDetails(PublishArrangeDetail publishArrangeDetail[]);
    
    public void savePublishArrangeDetails(Map mp,List ids);

    /**
     * Removes a publishArrangeDetail from the database by id
     * @param id the publishArrangeDetail's id
     */
    public void removePublishArrangeDetail(final Long id);
	/**
     * Removes publishArrangeDetails from the database by ids
     * @param ids the publishArrangeDetail's id eg:"'1','2','3'"
     */
    public void removePublishArrangeDetails(final Map idList);
    
    public List getArrangeIdByResourceIdDate(Map idList);
    
    public List getArrangedPublishForWebService(Map mp);
    
    public List getArrangedPublishForBroZM(Map mp);
    
  
}

