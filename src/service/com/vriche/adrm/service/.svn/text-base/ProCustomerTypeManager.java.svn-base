
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.ProCustomerType;
import com.vriche.adrm.dao.ProCustomerTypeDao;

public interface ProCustomerTypeManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setProCustomerTypeDao(ProCustomerTypeDao proCustomerTypeDAO);

    /**
     * Retrieves all of the proCustomerTypes
     */
    public List getProCustomerTypes(ProCustomerType proCustomerType);
     /**
     * Retrieves all of the proCustomerTypesCount
     */
    public String getProCustomerTypesCount(ProCustomerType proCustomerType);
     /**
     * Retrieves all of the proCustomerTypesCount
     */    
    public List getProCustomerTypesPage(ProCustomerType proCustomerType,String pageIndex,String pageSize);
     /**
     * Retrieves all of the proCustomerTypesPageXML
     */   
    public String getProCustomerTypesPageXML(ProCustomerType proCustomerType,String pageIndex,String pageSize);
    
    /**
     * Retrieves all of the proCustomerTypesPageXML
     */   
    public String getProCustomerTypeXML(ProCustomerType proCustomerType);
     /**
     * Retrieves all of the proCustomerTypesByMap
     */
    public List getProCustomerTypesByMap(final Map mp);

    /**
     * Gets proCustomerType's information based on id.
     * @param id the proCustomerType's id
     * @return proCustomerType populated proCustomerType object
     */
    public ProCustomerType getProCustomerType(final String id);

    /**
     * Saves a proCustomerType's information
     * @param proCustomerType the object to be saved
     */
    public String saveProCustomerType(ProCustomerType proCustomerType);

    /**
     * Removes a proCustomerType from the database by id
     * @param id the proCustomerType's id
     */
    public void removeProCustomerType(final String id);
     /**
     * Removes a proCustomerType from the database by id
     * @param idList
     */
    public void removeProCustomerTypes(final Map mp);
}

