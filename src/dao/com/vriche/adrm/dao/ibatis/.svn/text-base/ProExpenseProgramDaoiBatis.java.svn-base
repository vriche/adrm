
package com.vriche.adrm.dao.ibatis;

import java.util.List;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.ProExpenseProgram;

import com.vriche.adrm.dao.ProExpenseProgramDao;



public class ProExpenseProgramDaoiBatis extends BaseDaoiBATIS implements ProExpenseProgramDao {

    /**
     * @see com.vriche.adrm.dao.ProExpenseProgramDao#saveProExpensemoney(ProExpenseProgram proExpenseProgram)
     */    
    public void saveProExpenseMoney(final ProExpenseProgram proExpenseProgram) {

        List ls=getProExpenseMoney(proExpenseProgram);
        
        // check for new record
        if (ls.size()==0) {
            getSqlMapClientTemplate().insert("addProExpenseProgram", proExpenseProgram);
        } else {
            getSqlMapClientTemplate().update("updateProExpenseProgram", proExpenseProgram);
        }
    }
    /**
     * @see com.vriche.adrm.dao.ProExpenseProgramDao#getProExpenseMoney(ProExpenseProgram proExpenseProgram)
     */    
    public List getProExpenseMoney(final ProExpenseProgram proExpenseProgram) {
    	return getSqlMapClientTemplate().queryForList("getProExpenseProgram", proExpenseProgram);
    }
 
}
