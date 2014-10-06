
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.IncomePurpose;

public interface IncomePurposeDao extends Dao {

    /**
     * Retrieves all of the incomePurposes
     */
    public List getIncomePurposes(IncomePurpose incomePurpose);

    /**
     * Retrieves all of the incomePurposesByIdList
     */
    public List getIncomePurposesByIdList(final Map idList);

    /**
     * Gets incomePurpose's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the incomePurpose's id
     * @return incomePurpose populated incomePurpose object
     */
    public IncomePurpose getIncomePurpose(final Long id);

    /**
     * Saves a incomePurpose's information
     * @param incomePurpose the object to be saved
     */    
    public void saveIncomePurpose(IncomePurpose incomePurpose);

    /**
     * Removes a incomePurpose from the database by id
     * @param id the incomePurpose's id
     */
    public void removeIncomePurpose(final Long id);
	/**
     * Removes incomePurposes from the database by ids
     * @param ids the incomePurpose's id eg:"'1','2','3'"
     */
    public void removeIncomePurposes(final Map idList);
}

