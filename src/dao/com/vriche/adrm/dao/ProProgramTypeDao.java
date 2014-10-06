
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.ProProgram;
import com.vriche.adrm.model.ProProgramType;

public interface ProProgramTypeDao extends Dao {

    /**
     * Retrieves all of the proProgramTypes
     */
    public List getProProgramTypes(ProProgramType proProgramType);
    
    /**
     * Retrieves all of the getProProgramTypesCount
     */
    public Integer getProProgramTypesCount(ProProgramType proProgramType);   
    /**
     * Retrieves all of the getProProgramTypesPage
     */        
    public List getProProgramTypesPage(ProProgramType proProgramType,int pageIndex,int pageSize);
    /**
     * Retrieves all of the proProgramTypesByIdList
     */
    public List getProProgramTypesByMap(final Map mp);

    /**
     * Gets proProgramType's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the proProgramType's id
     * @return proProgramType populated proProgramType object
     */
    public ProProgramType getProProgramType(final Long id);

    /**
     * Saves a proProgramType's information
     * @param proProgramType the object to be saved
     */    
    public Long saveProProgramType(ProProgramType proProgramType);

    /**
     * Removes a proProgramType from the database by id
     * @param id the proProgramType's id
     */
    public void removeProProgramType(final Long id);
	/**
     * Removes proProgramTypes from the database by ids
     * @param ids the proProgramType's id eg:"'1','2','3'"
     */
    public void removeProProgramTypes(final Map idList);
    
    
    public List getProProgramStatus(final ProProgramType proProgramType);
    /**
     * Saves a proProgram's information
     * @param proProgram the object to be saved
     */    
    public Long saveProProgramStatus(ProProgramType proProgramType);
    
    /**
     * Removes a proProgram from the database by id
     * @param id the proProgram's id
     */
    public void removeProProgramStatus(final Long id);
}

