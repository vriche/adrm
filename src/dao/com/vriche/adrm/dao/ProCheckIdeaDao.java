
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.ProCheckIdea;

public interface ProCheckIdeaDao extends Dao {

    /**
     * Retrieves all of the proCheckIdeas
     */
    public List getProCheckIdeas(ProCheckIdea proCheckIdea);
    /**
     * Retrieves all of the getProCheckIdeasCount
     */
    public Integer getProCheckIdeasCount(ProCheckIdea proCheckIdea);      
    /**
     * Retrieves all of the getProCheckIdeasPage
     */        
    public List getProCheckIdeasPage(ProCheckIdea proCheckIdea,int pageIndex,int pageSize);
    
    /**
     * Retrieves all of the proCheckIdeasByIdList
     */
    public List getProCheckIdeasByMap(final Map mp);

    /**
     * Gets proCheckIdea's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the proCheckIdea's id
     * @return proCheckIdea populated proCheckIdea object
     */
    public ProCheckIdea getProCheckIdea(final Long id);

    /**
     * Saves a proCheckIdea's information
     * @param proCheckIdea the object to be saved
     */    
    public Long saveProCheckIdea(ProCheckIdea proCheckIdea);
    /**
     * Removes a proCheckIdea from the database by id
     * @param id the proCheckIdea's id
     */
    public void removeProCheckIdea(final Long id);
	/**
     * Removes proCheckIdeas from the database by ids
     * @param ids the proCheckIdea's id eg:"'1','2','3'"
     */
    public void removeProCheckIdeas(final Map idList);

}

