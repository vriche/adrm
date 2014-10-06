
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.IncomeModeDao;
import com.vriche.adrm.model.IncomeMode;
import com.vriche.adrm.service.Manager;

public interface IncomeModeManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setIncomeModeDao(IncomeModeDao incomeModeDAO);

    /**
     * Retrieves all of the incomeModes
     */
    public List getIncomeModes(IncomeMode incomeMode);
        /**
     * Retrieves all of the incomeModesByIdList
     */
    public List getIncomeModesByIdList(final Map idList);

    /**
     * Gets incomeMode's information based on id.
     * @param id the incomeMode's id
     * @return incomeMode populated incomeMode object
     */
    public IncomeMode getIncomeMode(final String id);

    /**
     * Saves a incomeMode's information
     * @param incomeMode the object to be saved
     */
    public void saveIncomeMode(IncomeMode incomeMode);

    /**
     * Removes a incomeMode from the database by id
     * @param id the incomeMode's id
     */
    public void removeIncomeMode(final String id);
     /**
     * Removes a incomeMode from the database by id
     * @param idList
     */
    public void removeIncomeModes(final Map idList);
    
    public Map getIncomeModeSelect(IncomeMode incomeMode);
    
    public Map getIncomeModeFromMap(IncomeMode incomeMode);
}

