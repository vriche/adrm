
package com.vriche.adrm.dao;

import java.util.List;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.ProExpenseProgram;
import com.vriche.adrm.model.ProProgramType;

public interface ProExpenseTypeDao extends Dao {

    /**
     * Retrieves all of the proProgramTypes
     */
    public List getProExpenseTypes(ProProgramType proProgramType);
    
    /**
     * Gets proProgramType's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the proProgramType's id
     * @return proProgramType populated proProgramType object
     */
    public ProProgramType getProExpenseType(final Long id);

    /**
     * Saves a proProgramType's information
     * @param proProgramType the object to be saved
     */    
    public Long saveProExpenseType(ProProgramType proProgramType);

    /**
     * Removes a proProgramType from the database by id
     * @param id the proProgramType's id
     */
    public void removeProExpenseType(final Long id);
    
    public ProProgramType getExpenseId(final ProProgramType proProgramType);


}

