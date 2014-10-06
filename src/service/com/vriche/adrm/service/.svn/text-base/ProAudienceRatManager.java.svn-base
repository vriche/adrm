
package com.vriche.adrm.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.ProAudienceRatDao;
import com.vriche.adrm.model.FusionChartObject;
import com.vriche.adrm.model.ProAudienceRat;

public interface ProAudienceRatManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setProAudienceRatDao(ProAudienceRatDao proAudienceRatDAO);

    /**
     * Retrieves all of the proAudienceRats
     */
    public List getProAudienceRats(ProAudienceRat proAudienceRat);
     /**
     * Retrieves all of the proAudienceRatsCount
     */
    public String getProAudienceRatsCount(ProAudienceRat proAudienceRat);
     /**
     * Retrieves all of the proAudienceRatsCount
     */    
    public List getProAudienceRatsPage(ProAudienceRat proAudienceRat,String pageIndex,String pageSize);
     /**
     * Retrieves all of the proAudienceRatsPageXML
     */   
    public String getProAudienceRatsPageXML(ProAudienceRat proAudienceRat,String pageIndex,String pageSize);
     /**
     * Retrieves all of the proAudienceRatsByMap
     */
    public List getProAudienceRatsByMap(final Map mp);

    /**
     * Gets proAudienceRat's information based on id.
     * @param id the proAudienceRat's id
     * @return proAudienceRat populated proAudienceRat object
     */
    public ProAudienceRat getProAudienceRat(final String id);

    /**
     * Saves a proAudienceRat's information
     * @param proAudienceRat the object to be saved
     */
    public String saveProAudienceRat(ProAudienceRat proAudienceRat);
    
    
    public void saveProAudienceRats(List ls,Map parmap);

    /**
     * Removes a proAudienceRat from the database by id
     * @param id the proAudienceRat's id
     */
    public void removeProAudienceRat(final String id);
     /**
     * Removes a proAudienceRat from the database by id
     * @param idList
     */
    public void removeProAudienceRats(final Map mp);
    
    public Collection getCollections(final String queryString,String type);
    
    public FusionChartObject[] getProAudienceRatChartObjs(final String queryString);
    
}

