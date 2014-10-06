
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.SysSequence;
import com.vriche.adrm.dao.SysSequenceDao;

public interface SysSequenceManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setSysSequenceDao(SysSequenceDao sysSequenceDAO);

    /**
     * Retrieves all of the sysSequences
     */
    public List getSysSequences(SysSequence sysSequence);
     /**
     * Retrieves all of the sysSequencesCount
     */
    public String getSysSequencesCount(SysSequence sysSequence);
     /**
     * Retrieves all of the sysSequencesCount
     */    
    public PaginatedList getSysSequencesPage(SysSequence sysSequence,String pageIndex,String pageSize);
     /**
     * Retrieves all of the sysSequencesByIdList
     */
    public List getSysSequencesByIdList(final Map idList);

    /**
     * Gets sysSequence's information based on sequenceID.
     * @param sequenceID the sysSequence's sequenceID
     * @return sysSequence populated sysSequence object
     */
    public SysSequence getSysSequence(final String sequenceID);

    /**
     * Saves a sysSequence's information
     * @param sysSequence the object to be saved
     */
    public String saveSysSequence(SysSequence sysSequence);

    /**
     * Removes a sysSequence from the database by sequenceID
     * @param sequenceID the sysSequence's sequenceID
     */
    public void removeSysSequence(final String sequenceID);
     /**
     * Removes a sysSequence from the database by sequenceID
     * @param idList
     */
    public void removeSysSequences(final Map idList);
    
    public String getSysSequenceByObject(String orgId,String name);
    
    public  String getSysSequenceByObject(String orgId,String name,String year);
    
    public  String getSysSequenceByObjectNew(String orgId,String name,String year);
    
    public  String getSysSequenceByObject2(String name);
    
    public SysSequence getSysSequenceByObject(SysSequence sysSequence);
    
    public  String getSysSequenceRelationCode(String temStr,String name,String year);
}

