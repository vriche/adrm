
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.SysSequence;

public interface SysSequenceDao extends Dao {

    /**
     * Retrieves all of the sysSequences
     */
    public List getSysSequences(SysSequence sysSequence);
    /**
     * Retrieves all of the getSysSequencesCount
     */
    public Integer getSysSequencesCount(SysSequence sysSequence);   
    /**
     * Retrieves all of the getSysSequencesPage
     */        
    public PaginatedList getSysSequencesPage(SysSequence sysSequence,int pageIndex,int pageSize);
    /**
     * Retrieves all of the sysSequencesByIdList
     */
    public List getSysSequencesByIdList(final Map idList);

    /**
     * Gets sysSequence's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param sequenceID the sysSequence's sequenceID
     * @return sysSequence populated sysSequence object
     */
    public SysSequence getSysSequence(final String sequenceID);

    /**
     * Saves a sysSequence's information
     * @param sysSequence the object to be saved
     */    
    public Long saveSysSequence(SysSequence sysSequence);

    /**
     * Removes a sysSequence from the database by sequenceID
     * @param sequenceID the sysSequence's sequenceID
     */
    public void removeSysSequence(final String sequenceID);
	/**
     * Removes sysSequences from the database by sequenceIDs
     * @param sequenceIDs the sysSequence's sequenceID eg:"'1','2','3'"
     */
    public void removeSysSequences(final Map idList);
    public SysSequence getSysSequenceByObject(SysSequence sysSequence);
}

