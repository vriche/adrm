
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.dao.ProCheckIdeaDao;
import com.vriche.adrm.model.ProCheckIdea;

public interface ProCheckIdeaManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setProCheckIdeaDao(ProCheckIdeaDao proCheckIdeaDao);

    /**
     * Retrieves all of the proCheckIdeas
     */
    public List getProCheckIdeas(ProCheckIdea proCheckIdea);
    
    /**
     * Retrieves all of the getProCheckIdeasId
     */
    public ProCheckIdea getProCheckIdeasId(final ProCheckIdea proCheckIdea);
     /**
     * Retrieves all of the proCheckIdeasCount
     */
    public String getProCheckIdeasCount(ProCheckIdea proCheckIdea);
     /**
     * Retrieves all of the proCheckIdeasCount
     */    
    public List getProCheckIdeasPage(ProCheckIdea proCheckIdea,String pageIndex,String pageSize);
     /**
     * Retrieves all of the proCheckIdeasPageXML
     */   
    public String getProCheckIdeasPageXML(ProCheckIdea proCheckIdea,String pageIndex,String pageSize);
    /**
     * Retrieves all of the proCheckIdeasPageXML
     */   
    public String getProCheckIdeasXML(ProCheckIdea proCheckIdea);
     /**
     * Retrieves all of the proCheckIdeasByMap
     */
    public List getProCheckIdeasByMap(final Map mp);

    /**
     * Gets proCheckIdea's information based on id.
     * @param id the proCheckIdea's id
     * @return proCheckIdea populated proCheckIdea object
     */
    public ProCheckIdea getProCheckIdea(final String id);

    /**
     * Saves a proCheckIdea's information
     * @param proCheckIdea the object to be saved
     */
    public String saveProCheckIdea(ProCheckIdea proCheckIdea);

    /**
     * Removes a proCheckIdea from the database by id
     * @param id the proCheckIdea's id
     */
    public void removeProCheckIdea(final String id);
     /**
     * Removes a proCheckIdea from the database by id
     * @param idList
     */
    public void removeProCheckIdeas(final Map mp);
}

