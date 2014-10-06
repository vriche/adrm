
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.ProAudienceRat;

public interface ProAudienceRatDao extends Dao {

    /**
     * Retrieves all of the proAudienceRats
     */
    public List getProAudienceRats(ProAudienceRat proAudienceRat);
    /**
     * Retrieves all of the getProAudienceRatsCount
     */
    public Integer getProAudienceRatsCount(ProAudienceRat proAudienceRat);   
    /**
     * Retrieves all of the getProAudienceRatsPage
     */        
    public List getProAudienceRatsPage(ProAudienceRat proAudienceRat,int pageIndex,int pageSize);
    /**
     * Retrieves all of the proAudienceRatsByIdList
     */
    public List getProAudienceRatsByMap(final Map mp);

    /**
     * Gets proAudienceRat's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the proAudienceRat's id
     * @return proAudienceRat populated proAudienceRat object
     */
    public ProAudienceRat getProAudienceRat(final Long id);

    /**
     * Saves a proAudienceRat's information
     * @param proAudienceRat the object to be saved
     */    
    public Long saveProAudienceRat(ProAudienceRat proAudienceRat);

    /**
     * Removes a proAudienceRat from the database by id
     * @param id the proAudienceRat's id
     */
    public void removeProAudienceRat(final Long id);
	/**
     * Removes proAudienceRats from the database by ids
     * @param ids the proAudienceRat's id eg:"'1','2','3'"
     */
    public void removeProAudienceRats(final Map idList);
    
    public void saveProAudienceRats(final List ls);
}

