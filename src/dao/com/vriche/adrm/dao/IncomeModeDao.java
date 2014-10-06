
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.IncomeMode;

public interface IncomeModeDao extends Dao {

    /**
     * Retrieves all of the incomeModes
     */
    public List getIncomeModes(IncomeMode incomeMode);

    /**
     * Retrieves all of the incomeModesByIdList
     */
    public List getIncomeModesByIdList(final Map idList);

    /**
     * Gets incomeMode's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the incomeMode's id
     * @return incomeMode populated incomeMode object
     */
    public IncomeMode getIncomeMode(final Long id);

    /**
     * Saves a incomeMode's information
     * @param incomeMode the object to be saved
     */    
    public void saveIncomeMode(IncomeMode incomeMode);

    /**
     * Removes a incomeMode from the database by id
     * @param id the incomeMode's id
     */
    public void removeIncomeMode(final Long id);
	/**
     * Removes incomeModes from the database by ids
     * @param ids the incomeMode's id eg:"'1','2','3'"
     */
    public void removeIncomeModes(final Map idList);
}

