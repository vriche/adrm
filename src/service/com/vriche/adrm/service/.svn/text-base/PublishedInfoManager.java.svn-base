
package com.vriche.adrm.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.PublishedInfoDao;
import com.vriche.adrm.model.PublishedInfo;

public interface PublishedInfoManager extends Manager {
    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setPublishedInfoDao(PublishedInfoDao publishedInfoDAO);

    /**
     * Retrieves all of the publishedInfos
     */
    public List getPublishedInfos(PublishedInfo publishedInfo);
    
    public List getPublishedInfosByHistory(String resourceIds,String publishDate);
    
    public Collection getPublishedInfosByHistoryColl(String resourceIds,String publishDate);
    public Collection getInfosByHistoryColl(String resourceIds,String publishDate);
    public String getInfosByResourceIdsXML(String ResourceIds,String publishDate,int model);
    
    public String getPublishedInfosByResourceIdsXML(String ResourceIds,String publishDate,int model);
        /**
     * Retrieves all of the publishedInfosByIdList
     */
    public List getPublishedInfosByIdList(final Map idList);

    /**
     * Gets publishedInfo's information based on id.
     * @param id the publishedInfo's id
     * @return publishedInfo populated publishedInfo object
     */
    public PublishedInfo getPublishedInfo(final String id);

    /**
     * Saves a publishedInfo's information
     * @param publishedInfo the object to be saved
     */
    public void savePublishedInfo(PublishedInfo publishedInfo);

    /**
     * Removes a publishedInfo from the database by id
     * @param id the publishedInfo's id
     */
    public void removePublishedInfo(final String id);
     /**
     * Removes a publishedInfo from the database by id
     * @param idList
     */
    public void removePublishedInfos(final Map idList);
    
    public void removePublishedInfosByResDate(String ResourceIds,String publishDate);
    
    public Integer getPublishedCount(String resourceIds,String publishDate);
}

