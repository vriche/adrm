
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.ForetArrearage;
import com.vriche.adrm.dao.ForetArrearageDao;

public interface ForetArrearageManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setForetArrearageDao(ForetArrearageDao foretArrearageDAO);

    /**
     * Retrieves all of the foretArrearages
     */
    public List getForetArrearages(ForetArrearage foretArrearage);
     /**
     * Retrieves all of the foretArrearagesCount
     */
    public String getForetArrearagesCount(ForetArrearage foretArrearage);
     /**
     * Retrieves all of the foretArrearagesCount
     */    
    public List getForetArrearagesPage(ForetArrearage foretArrearage,String pageIndex,String pageSize);
   
    public String getForetArrearagesPageXML(ForetArrearage foretArrearage,String pageIndex,String pageSize);
     /**
     * Retrieves all of the foretArrearagesByMap
     */
    public List getForetArrearagesByMap(final Map mp);

    /**
     * Gets foretArrearage's information based on id.
     * @param id the foretArrearage's id
     * @return foretArrearage populated foretArrearage object
     */
    public ForetArrearage getForetArrearage(final String id);

    /**
     * Saves a foretArrearage's information
     * @param foretArrearage the object to be saved
     */
    public String saveForetArrearage(ForetArrearage foretArrearage);

    /**
     * Removes a foretArrearage from the database by id
     * @param id the foretArrearage's id
     */
    public void removeForetArrearage(final String id);
     /**
     * Removes a foretArrearage from the database by id
     * @param idList
     */
    public void removeForetArrearages(final Map mp);
    
    public String getForetArrearagesForXML(ForetArrearage foretArrearage,int type);
}

