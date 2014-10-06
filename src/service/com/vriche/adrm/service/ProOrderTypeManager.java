
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.ProOrderType;
import com.vriche.adrm.dao.ProOrderTypeDao;

public interface ProOrderTypeManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setProOrderTypeDao(ProOrderTypeDao proOrderTypeDAO);

    /**
     * Retrieves all of the proOrderTypes
     */
    public List getProOrderTypes(ProOrderType proOrderType);
     /**
     * Retrieves all of the proOrderTypesCount
     */
    public String getProOrderTypesCount(ProOrderType proOrderType);
     /**
     * Retrieves all of the proOrderTypesCount
     */    
    public List getProOrderTypesPage(ProOrderType proOrderType,String pageIndex,String pageSize);
     /**
     * Retrieves all of the proOrderTypesPageXML
     */   
    public String getProOrderTypesPageXML(ProOrderType proOrderType,String pageIndex,String pageSize);
     /**
     * Retrieves all of the proOrderTypesByMap
     */
    public List getProOrderTypesByMap(final Map mp);

    /**
     * Gets proOrderType's information based on id.
     * @param id the proOrderType's id
     * @return proOrderType populated proOrderType object
     */
    public ProOrderType getProOrderType(final String id);

    /**
     * Saves a proOrderType's information
     * @param proOrderType the object to be saved
     */
    public String saveProOrderType(ProOrderType proOrderType);

    /**
     * Removes a proOrderType from the database by id
     * @param id the proOrderType's id
     */
    public void removeProOrderType(final String id);
     /**
     * Removes a proOrderType from the database by id
     * @param idList
     */
    public void removeProOrderTypes(final Map mp);
    
    public String getProOrderTypeXML(ProOrderType proOrderType);
    
}

