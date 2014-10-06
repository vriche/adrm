
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.PublishArrangeDetail;
import com.vriche.adrm.dao.PublishArrangeDetailDao;

public interface PublishArrangeDetailManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setPublishArrangeDetailDao(PublishArrangeDetailDao publishArrangeDetailDAO);

    /**
     * Retrieves all of the publishArrangeDetails
     */
    public List getPublishArrangeDetails(PublishArrangeDetail publishArrangeDetail);
     /**
     * Retrieves all of the publishArrangeDetailsCount
     */
    public String getPublishArrangeDetailsCount(PublishArrangeDetail publishArrangeDetail);
     /**
     * Retrieves all of the publishArrangeDetailsCount
     */    
    public PaginatedList getPublishArrangeDetailsPage(PublishArrangeDetail publishArrangeDetail,String pageIndex,String pageSize);
     /**
     * Retrieves all of the publishArrangeDetailsByIdList
     */
    public List getPublishArrangeDetailsByIdList(final Map idList);

    /**
     * Gets publishArrangeDetail's information based on id.
     * @param id the publishArrangeDetail's id
     * @return publishArrangeDetail populated publishArrangeDetail object
     */
    public PublishArrangeDetail getPublishArrangeDetail(final String id);

    /**
     * Saves a publishArrangeDetail's information
     * @param publishArrangeDetail the object to be saved
     */
    public String savePublishArrangeDetail(PublishArrangeDetail publishArrangeDetail);

    /**
     * Removes a publishArrangeDetail from the database by id
     * @param id the publishArrangeDetail's id
     */
    public void removePublishArrangeDetail(final String id);
     /**
     * Removes a publishArrangeDetail from the database by id
     * @param idList
     */
    public void removePublishArrangeDetails(final Map idList);
}

