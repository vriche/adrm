
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.ProOrder;
import com.vriche.adrm.model.ProProgram;
import com.vriche.adrm.model.ProProgramType;

public interface ProProgramDao extends Dao {

    /**
     * Retrieves all of the proPrograms
     */
    public List getProPrograms(ProProgram proProgram);
    /**
     * Retrieves all of the getProProgramsByOrder
     */
    public List getProProgramsByOrder(final ProProgram proProgram);
    
    /**
     * Retrieves all of the getProProgramsAll
     */
    public List getProProgramsAll(final ProProgram proProgram);
    
    /**
     * Retrieves all of the getProProgramsByName
     */
    public List getProProgramsByName(ProProgram proProgram);
    /**
     * Retrieves all of the getProProgramsCount
     */
    public Integer getProProgramsCount(ProProgram proProgram);   
    public Integer getProProgramsCountByName(ProProgram proProgram);   
    /**
     * Retrieves all of the getProProgramsPage
     */        
    public List getProProgramsPage(ProProgram proProgram,int pageIndex,int pageSize);
    
    /**
     * Retrieves all of the proProgramsByIdList
     */
    public List getProProgramsByMap(final Map mp);

    /**
     * Gets proProgram's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the proProgram's id
     * @return proProgram populated proProgram object
     */
    public ProProgram getProProgram(final Long id);

    /**
     * Saves a proProgram's information
     * @param proProgram the object to be saved
     */    
    public Long saveProProgram(ProProgram proProgram);

    public void saveProProgramStatus(final ProProgram proProgram);
    /**
     * Removes a proProgram from the database by id
     * @param id the proProgram's id
     */
    public void removeProProgram(final Long id);
    public List getProTypeChild(Long id);
    public List getProNameByOrders(ProOrder proOrder);
    public List getPayMoneyList(ProOrder proOrder);
	/**
     * Removes proPrograms from the database by ids
     * @param ids the proProgram's id eg:"'1','2','3'"
     */
    public void removeProPrograms(final Map idList);
    
    public List getProProgramsByPage(final ProProgram proProgram,int pageIndex, int pageSize);
    public List getProProgramsByPage1(final ProProgram proProgram);
    
}

