
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.model.Industry;

public interface IndustryDao extends Dao {

    /**
     * Retrieves all of the industrys
     */
    public List getIndustrys(Industry industry);
    
    public PaginatedList getIndustrysPage(Industry industry,int pageSize);
    
    public Integer getIndustrysCount(Industry industry);

    /**
     * Retrieves all of the industrysByIdList
     */
    public List getIndustrysByIdList(final Map idList);

    /**
     * Gets industry's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the industry's id
     * @return industry populated industry object
     */
    public Industry getIndustry(final Long id);
    

    /**
     * Saves a industry's information
     * @param industry the object to be saved
     */    
    public void saveIndustry(Industry industry);

    /**
     * Removes a industry from the database by id
     * @param id the industry's id
     */
    public void removeIndustry(final Long id);
	/**
     * Removes industrys from the database by ids
     * @param ids the industry's id eg:"'1','2','3'"
     */
    public void removeIndustrys(final Map idList);
}

