
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.ProOrderType;

public interface ProOrderTypeDao extends Dao {

    /**
     * Retrieves all of the proOrderTypes
     */
    public List getProOrderTypes(ProOrderType proOrderType);
    /**
     * Retrieves all of the getProOrderTypesCount
     */
    public Integer getProOrderTypesCount(ProOrderType proOrderType);   
    /**
     * Retrieves all of the getProOrderTypesPage
     */        
    public List getProOrderTypesPage(ProOrderType proOrderType,int pageIndex,int pageSize);
    /**
     * Retrieves all of the proOrderTypesByIdList
     */
    public List getProOrderTypesByMap(final Map mp);

    /**
     * Gets proOrderType's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the proOrderType's id
     * @return proOrderType populated proOrderType object
     */
    public ProOrderType getProOrderType(final Long id);

    /**
     * Saves a proOrderType's information
     * @param proOrderType the object to be saved
     */    
    public Long saveProOrderType(ProOrderType proOrderType);

    /**
     * Removes a proOrderType from the database by id
     * @param id the proOrderType's id
     */
    public void removeProOrderType(final Long id);
	/**
     * Removes proOrderTypes from the database by ids
     * @param ids the proOrderType's id eg:"'1','2','3'"
     */
    public void removeProOrderTypes(final Map idList);
}

