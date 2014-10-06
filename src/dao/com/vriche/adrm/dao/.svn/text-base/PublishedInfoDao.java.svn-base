
package com.vriche.adrm.dao;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.vriche.adrm.model.PublishedInfo;

public interface PublishedInfoDao extends Dao {

    /**
     * Retrieves all of the publishedInfos
     */
    public List getPublishedInfos(PublishedInfo publishedInfo);
    
    public List getPublishedInfosByHistory(String resourceIds,String publishDate);
    
    public Collection getPublishedInfosByHistoryColl(String resourceIds,String publishDate);
    public Collection getInfosByHistoryColl(String resourceIds,String publishDate);
    public List getPublishedInfosByResourceIds(String resourceIds,String publishDate);
    
    public String getPublishedInfosByResourceIdsXML(String resourceIds,String publishDate,int model);

    public String getInfosByResourceIdsXML(String resourceIds,String publishDate,int model);
    
    /**
     * Retrieves all of the publishedInfosByIdList
     */
    public List getPublishedInfosByIdList(final Map idList);
    
    

    /**
     * Gets publishedInfo's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the publishedInfo's id
     * @return publishedInfo populated publishedInfo object
     */
    public PublishedInfo getPublishedInfo(final Long id);

    /**
     * Saves a publishedInfo's information
     * @param publishedInfo the object to be saved
     */    
    public void savePublishedInfo(PublishedInfo publishedInfo);

    /**
     * Removes a publishedInfo from the database by id
     * @param id the publishedInfo's id
     */
    public void removePublishedInfo(final Long id);
	/**
     * Removes publishedInfos from the database by ids
     * @param ids the publishedInfo's id eg:"'1','2','3'"
     */
    public void removePublishedInfos(final Map idList);
    
    public void removePublishedInfosByResDate(String resourceIds,String publishDate);
    
    public Integer getPublishedCount(String resourceIds,String publishDate);
}

