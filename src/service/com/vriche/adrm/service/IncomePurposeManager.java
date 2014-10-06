
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.IncomePurposeDao;
import com.vriche.adrm.model.IncomePurpose;
import com.vriche.adrm.model.TreeNode;
import com.vriche.adrm.service.Manager;

public interface IncomePurposeManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setIncomePurposeDao(IncomePurposeDao incomePurposeDAO);

    /**
     * Retrieves all of the incomePurposes
     */
    public List getIncomePurposes(IncomePurpose incomePurpose);
        /**
     * Retrieves all of the incomePurposesByIdList
     */
    public List getIncomePurposesByIdList(final Map idList);

    /**
     * Gets incomePurpose's information based on id.
     * @param id the incomePurpose's id
     * @return incomePurpose populated incomePurpose object
     */
    public IncomePurpose getIncomePurpose(final String id);

    /**
     * Saves a incomePurpose's information
     * @param incomePurpose the object to be saved
     */
    public void saveIncomePurpose(IncomePurpose incomePurpose);

    /**
     * Removes a incomePurpose from the database by id
     * @param id the incomePurpose's id
     */
    public void removeIncomePurpose(final String id);
     /**
     * Removes a incomePurpose from the database by id
     * @param idList
     */
    public void removeIncomePurposes(final Map idList);
    
    public Map getIncomePurposesSelect(IncomePurpose incomePurpose);
    
    public Map getIncomePurposesFromMap(IncomePurpose incomePurpose);
    
    public Map getIncomePurposesFromMap2(IncomePurpose incomePurpose);
    
    public List getTreeForJosin(TreeNode node,IncomePurpose incomePurpose);
}

