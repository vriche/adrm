
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.ProFinance;

public interface ProFinanceDao extends Dao {

    /**
     * Retrieves all of the getProFinance
     */
    public List getProFinance(final ProFinance proFinance);
    
    /**
     * Retrieves all of the getProFinancesByMap
     */
    public List getProFinancesByMap(final Map mp);

    /**
     * Retrieves all of the getProFinanceCount
     */
    public Integer getProFinanceCount(final Long id);
    /**
     * Saves a proFinance's information
     * @param proFinance the object to be saved
     */    
    public Long saveProFinance(final ProFinance proFinance);
    

    /**
     * Removes a proFinance from the database by id
     * @param id the proFinance's id
     */
    public void removeProFinance(final Long id);
    
    /**
     * Removes a proFinance or more from the database by id
     * @param id the proOrder's id
     */
    public void removeProFinanceByOrderId(final Long id);
    
	/**
     * Removes proFinances from the database by ids
     * @param ids the proFinance's id eg:"'1','2','3'"
     */
    public void removeProFinances(final Map idList);

}

