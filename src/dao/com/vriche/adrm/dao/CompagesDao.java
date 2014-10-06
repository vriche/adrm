
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.Compages;

public interface CompagesDao extends Dao {

    /**
     * Retrieves all of the compagess
     */
    public List getCompagess(Compages compages);

    /**
     * Retrieves all of the compagessByIdList
     */
    public List getCompagessByIdList(final Map idList);

    /**
     * Gets compages's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the compages's id
     * @return compages populated compages object
     */
    public Compages getCompages(final Long id);

    /**
     * Saves a compages's information
     * @param compages the object to be saved
     */    
    public Long saveCompages(Compages compages);

    /**
     * Removes a compages from the database by id
     * @param id the compages's id
     */
    public void removeCompages(final Long id);
	/**
     * Removes compagess from the database by ids
     * @param ids the compages's id eg:"'1','2','3'"
     */
    public void removeCompagess(final Map idList);
    
    public void saveCompagesAndResource(Compages compages,final Long id);
        
    public void removeCompagesAndResources(final Long id);
    
    public void removeCompagesAndPrices(final Long id);
}

