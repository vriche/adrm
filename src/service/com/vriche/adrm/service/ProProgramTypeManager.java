
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.ProCustomer;
import com.vriche.adrm.model.ProExpenseProgram;
import com.vriche.adrm.model.ProProgramType;
import com.vriche.adrm.dao.ProProgramTypeDao;

public interface ProProgramTypeManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setProProgramTypeDao(ProProgramTypeDao proProgramTypeDAO);

    /**
     * Retrieves all of the proProgramTypes
     */
    public List getProProgramTypes(ProProgramType proProgramType);
    
    public ProProgramType getProProgramStatus(final ProProgramType proProgramType);
    
    public List getProProgramStatusList(final ProProgramType proProgramType);
    
    public String saveProProgramStatus(ProProgramType proProgramType);
    
    public void removeProProgramStatus(final String id);
    
    public ProProgramType getProProgramTypeById(String id);
     /**
     * Retrieves all of the proProgramTypesCount
     */
    public String getProProgramTypesCount(ProProgramType proProgramType);
     /**
     * Retrieves all of the proProgramTypesCount
     */    
    public List getProProgramTypesPage(ProProgramType proProgramType,String pageIndex,String pageSize);
     /**
     * Retrieves all of the proProgramTypesPageXML
     */   
    public String getProProgramTypesPageXML(ProProgramType proProgramType,String pageIndex,String pageSize);
  
     /**
     * Retrieves all of the proProgramTypesByMap
     */
    public List getProProgramTypesByMap(final Map mp);

    /**
     * Gets proProgramType's information based on id.
     * @param id the proProgramType's id
     * @return proProgramType populated proProgramType object
     */
    public ProProgramType getProProgramType(final String id);

    /**
     * Saves a proProgramType's information
     * @param proProgramType the object to be saved
     */
    public String saveProProgramType(ProProgramType proProgramType);

    /**
     * Removes a proProgramType from the database by id
     * @param id the proProgramType's id
     */
    public void removeProProgramType(final String id);
     /**
     * Removes a proProgramType from the database by id
     * @param idList
     */
    public void removeProProgramTypes(final Map mp);
    
    public String getProProgramTypesXML(ProProgramType proProgramType, String IdPrefix);
    
    public String getProgarmTypeTableXML(ProProgramType proProgramType);
    
    public ProProgramType getProExpenseTypeById(String id);
    
    public String getProExpenseTypeXML(ProProgramType proProgramType);
    
    public String saveProExpenseType(ProProgramType proProgramType);
    
    public void removeProExpenseType(final String id);
    
    public ProProgramType getExpenseId(ProProgramType proProgramType);
    
    public void saveProExpenseMoney(ProExpenseProgram proExpenseProgram);
}

