
package com.vriche.adrm.dao;

import com.vriche.adrm.dao.Dao;

import com.vriche.adrm.model.ProProgramDetail;

public interface ProProgramDetailDao extends Dao {

    /**
     * Gets proProgram's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the proProgram's id
     * @return proProgram populated proProgram object
     */
    public ProProgramDetail getProProgramDetail(final Long id);

    /**
     * Saves a proProgram's information
     * @param proProgram the object to be saved
     */    
    public void saveProProgramDetail(ProProgramDetail proProgram);

    /**
     * Removes a proProgram from the database by id
     * @param id the proProgram's id
     */
    public void removeProProgramDetail(final Long id);

}

