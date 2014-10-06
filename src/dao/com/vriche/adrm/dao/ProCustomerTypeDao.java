
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.ProCustomerType;

public interface ProCustomerTypeDao extends Dao {

    /**
     * Retrieves all of the proCustomerTypes
     */
    public List getProCustomerTypes(ProCustomerType proCustomerType);
    /**
     * Retrieves all of the getProCustomerTypesCount
     */
    public Integer getProCustomerTypesCount(ProCustomerType proCustomerType);   
    /**
     * Retrieves all of the getProCustomerTypesPage
     */        
    public List getProCustomerTypesPage(ProCustomerType proCustomerType,int pageIndex,int pageSize);
    /**
     * Retrieves all of the proCustomerTypesByIdList
     */
    public List getProCustomerTypesByMap(final Map mp);

    /**
     * Gets proCustomerType's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the proCustomerType's id
     * @return proCustomerType populated proCustomerType object
     */
    public ProCustomerType getProCustomerType(final Long id);

    /**
     * Saves a proCustomerType's information
     * @param proCustomerType the object to be saved
     */    
    public Long saveProCustomerType(ProCustomerType proCustomerType);

    /**
     * Removes a proCustomerType from the database by id
     * @param id the proCustomerType's id
     */
    public void removeProCustomerType(final Long id);
	/**
     * Removes proCustomerTypes from the database by ids
     * @param ids the proCustomerType's id eg:"'1','2','3'"
     */
    public void removeProCustomerTypes(final Map idList);
}

