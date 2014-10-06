
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ObjectRetrievalFailureException;

import com.vriche.adrm.dao.ProProgramDao;
import com.vriche.adrm.model.ProOrder;
import com.vriche.adrm.model.ProProgram;

public class ProProgramDaoiBatis extends BaseDaoiBATIS implements ProProgramDao {

	 /**
     * @see com.vriche.adrm.dao.ProProgramDao#getProPrograms(com.vriche.adrm.model.ProProgram)
     */
    public List getProPrograms(final ProProgram proProgram) {
    		return getSqlMapClientTemplate().queryForList("getProPrograms", proProgram);
         
    }
    
	 /**
     * @see com.vriche.adrm.dao.ProProgramDao#getProPrograms(com.vriche.adrm.model.ProProgram)
     */
    public List getProProgramsByOrder(final ProProgram proProgram) {
    	if(proProgram.getTypeId().intValue()==1){
    		return getSqlMapClientTemplate().queryForList("getProProgramsByOrder", proProgram);
    	}else{
    		return getSqlMapClientTemplate().queryForList("getProProgramsBySell", proProgram);
    	}         
    }
    
    /**
     * @see com.vriche.adrm.dao.ProProgramDao#getProProgramsAll(com.vriche.adrm.model.ProProgram)
     */
    public List getProProgramsAll(final ProProgram proProgram) {
    	if(proProgram.getTypeId().intValue()==1){
    		return getSqlMapClientTemplate().queryForList("getProProgramsAll", proProgram);
    	}else{
    		return getSqlMapClientTemplate().queryForList("getProProgramsBySellAll", proProgram);
    	}         
    }
     /**
     * @see com.vriche.adrm.dao.ProProgramDao#getProProgramsCount(com.vriche.adrm.model.ProProgram)
     */
    public Integer getProProgramsCount(final ProProgram proProgram) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getProProgramsCount", proProgram);
    }
	public Integer getProProgramsCountByName(ProProgram proProgram) {
		  return (Integer)getSqlMapClientTemplate().queryForObject("getProProgramsCountByName", proProgram);
	}  
     /**
     * @see com.vriche.adrm.dao.ProProgramDao#getProProgramsPage(com.vriche.adrm.model.ProProgram)
     */   
  	public List getProProgramsPage(final ProProgram proProgram,int pageIndex, int pageSize) {
		 int skip = pageIndex * pageSize;
		 return getSqlMapClientTemplate().queryForList("getProPrograms",proProgram,skip,pageSize);
	}  
    /**
     * @see com.vriche.adrm.dao.ProProgramDao#getProProgramsByIdList(com.vriche.adrm.model.ProProgram)
     */
    public List getProProgramsByMap(final Map mp) {
          return getSqlMapClientTemplate().queryForList("getProProgramsByIdList", mp);
    }

    /**
     * @see com.vriche.adrm.dao.ProProgramDao#getProProgram(Long id)
     */
    public ProProgram getProProgram(Long id) {
        ProProgram proProgram = (ProProgram) getSqlMapClientTemplate().queryForObject("getProProgram", id);

        if (proProgram == null) {
            throw new ObjectRetrievalFailureException(ProProgram.class, id);
        }

        return proProgram;
    }

    /**
     * @see com.vriche.adrm.dao.ProProgramDao#saveProProgram(ProProgram proProgram)
     */    
    public Long saveProProgram(final ProProgram proProgram) {
        Long id = proProgram.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addProProgram", proProgram);
        } else {
            getSqlMapClientTemplate().update("updateProProgram", proProgram);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(ProProgram.class, id);
        }
        return  id;
    }
    
    /**
     * @see com.vriche.adrm.dao.ProProgramDao#saveProProgramStatus(ProProgram proProgram)
     */    
    public void saveProProgramStatus(final ProProgram proProgram) {
            getSqlMapClientTemplate().update("updateProProgramStatusId", proProgram);

    }

    /**
     * @see com.vriche.adrm.dao.ProProgramDao#removeProProgram(Long id)
     */
    public void removeProProgram(Long id) {
        getSqlMapClientTemplate().update("deleteProProgram", id);
    }
    /**
     * @see com.vriche.adrm.dao.ProProgramDAO#removeProPrograms(String ids)
     */
    public void removeProPrograms(final Map idList) {
        getSqlMapClientTemplate().update("deleteProPrograms", idList);
    }
	public List getProProgramsByName(ProProgram proProgram) {
		return getSqlMapClientTemplate().queryForList("getProProgramsOfName", proProgram);
	}
	
	public List getProProgramsByPage(final ProProgram proProgram,int pageIndex, int pageSize) {
		 int skip = pageIndex * pageSize;
		 return getSqlMapClientTemplate().queryForList("getProProgramsOfName",proProgram,skip,pageSize);
	}
	public List getProProgramsByPage1(final ProProgram proProgram) {
		 return getSqlMapClientTemplate().queryForList("getProProgramsOfName",proProgram);
	}
	public List getProTypeChild(Long id) {
		return getSqlMapClientTemplate().queryForList("getProTypeChild", id);
	}
	public List getProNameByOrders(ProOrder proOrder) {
		return getSqlMapClientTemplate().queryForList("getProNameByOrders", proOrder);
	}
	public List getPayMoneyList(ProOrder proOrder) {
		return getSqlMapClientTemplate().queryForList("getPayMoneyList", proOrder);
	}

}
