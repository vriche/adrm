
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.CompagesDao;
import com.vriche.adrm.model.Compages;
import com.vriche.adrm.service.Manager;

public interface CompagesManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setCompagesDao(CompagesDao compagesDAO);

    /**
     * Retrieves all of the compagess
     */
    public List getCompagess(Compages compages);
        /**
     * Retrieves all of the compagessByIdList
     */
    public List getCompagessByIdList(final Map idList);

    
    public String getPriceByLegth(String compagesId, String length,String priceTypeId);
    /**
     * Gets compages's information based on id.
     * @param id the compages's id
     * @return compages populated compages object
     */
    public Compages getCompages(final String id);

    /**
     * Saves a compages's information
     * @param compages the object to be saved
     */
    public void saveCompages(Compages compages);

    /**
     * Removes a compages from the database by id
     * @param id the compages's id
     */
    public void removeCompages(final String id,final String priceId);
     /**
     * Removes a compages from the database by id
     * @param idList
     */
    public void removeCompagess(final Map idList);
    
    public String getCompagessXML(Compages compages, String IdPrefix,String resourceIdPrefix);
    
    public List getPrice(Compages compages,String length,Long priceTypeId,int model);
    
    public List getPriceByResIdListAndLength(List idList,String length,Long priceTypeId);
    
    public void saveCompagesAndResource(Compages compages, String id);
    
    public String saveCompagesAndResourceRel(Compages compages);
    
    public String getPriceDetailIdByCompagesIdAndLength(Long compagesId,String length);
    
    public Compages getCompage(final String id);
}

