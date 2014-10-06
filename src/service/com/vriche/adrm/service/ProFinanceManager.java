
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.ProFinance;

public interface ProFinanceManager extends Manager {


     /**
     * Retrieves all of the proFinancesPageXML
     */   
    public String getProFinancesPageXML(ProFinance proFinance,String pageIndex,String pageSize);
     /**
     * Retrieves all of the proFinancesByMap
     */
    public List getProFinancesByMap(final Map mp);

    /**
     * Gets proFinance's information based on id.
     * @param id the proFinance's id
     * @return proFinance populated proFinance object
     */
    public String getProFinanceXML(String id);
    
    public List getProFinanceXML(Long id);

    /**
     * Saves a proFinance's information
     * @param proFinance the object to be saved
     */
    public Long saveProFinance(ProFinance proFinance);
    
    /**
     * Saves a proFinance's information
     * @param proFinance the object to be saved
     */
    public ProFinance saveProFinances(ProFinance proFinance);
    
    public void saveProIncomePulls(ProFinance proFinances[]);
    /**
     * Removes a proFinance from the database by id
     * @param id the proFinance's id
     */
    public void removeProFinance(final String id);
    
    /**
     * Removes a proFinance or more from the database by id
     * @param id the proOrder's id
     */
    public void removeProFinanceByOrderId(final String id);
     /**
     * Removes a proFinance from the database by id
     * @param idList
     */
    public void removeProFinances(final Map mp);
    
    
}

