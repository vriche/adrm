
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.IndustryDao;
import com.vriche.adrm.model.Industry;
import com.vriche.adrm.model.OrderCategory;
import com.vriche.adrm.service.Manager;

public interface IndustryManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setIndustryDao(IndustryDao industryDAO);

    /**
     * Retrieves all of the industrys
     */
    public List getIndustrys(Industry industry);
    
    public PaginatedList getIndustrysPage(Industry industry,String pageSize);
    
    public String getIndustrysCount(Industry industry);
        /**
     * Retrieves all of the industrysByIdList
     */
    public List getIndustrysByIdList(final Map idList);

    /**
     * Gets industry's information based on id.
     * @param id the industry's id
     * @return industry populated industry object
     */
    public Industry getIndustry(final String id);

    /**
     * Saves a industry's information
     * @param industry the object to be saved
     */
    public void saveIndustry(Industry industry);

    /**
     * Removes a industry from the database by id
     * @param id the industry's id
     */
    public void removeIndustry(final String id);
     /**
     * Removes a industry from the database by id
     * @param idList
     */
    public void removeIndustrys(final Map idList);
    
    public Map getIndustrySelect(Industry industry);
    
    public Map getIndustrySelectFromMap(Industry industry);
    
    public List getTree(Map searchMap);
}

