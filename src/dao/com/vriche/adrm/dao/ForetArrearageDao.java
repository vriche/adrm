
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.ForetArrearage;

public interface ForetArrearageDao extends Dao {

    /**
     * Retrieves all of the foretArrearages
     */
    public List getForetArrearages(ForetArrearage foretArrearage);
    /**
     * Retrieves all of the getForetArrearagesCount
     */
    public Integer getForetArrearagesCount(ForetArrearage foretArrearage);   
    /**
     * Retrieves all of the getForetArrearagesPage
     */        
    public List getForetArrearagesPage(ForetArrearage foretArrearage,int pageIndex,int pageSize);
    /**
     * Retrieves all of the foretArrearagesByIdList
     */
    public List getForetArrearagesByMap(final Map mp);

    /**
     * Gets foretArrearage's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the foretArrearage's id
     * @return foretArrearage populated foretArrearage object
     */
    public ForetArrearage getForetArrearage(final Long id);

    /**
     * Saves a foretArrearage's information
     * @param foretArrearage the object to be saved
     */    
    public Long saveForetArrearage(ForetArrearage foretArrearage);

    /**
     * Removes a foretArrearage from the database by id
     * @param id the foretArrearage's id
     */
    public void removeForetArrearage(final Long id);
	/**
     * Removes foretArrearages from the database by ids
     * @param ids the foretArrearage's id eg:"'1','2','3'"
     */
    public void removeForetArrearages(final Map idList);
    
    public List getForetArrearagesList(ForetArrearage foretArrearage);
}

