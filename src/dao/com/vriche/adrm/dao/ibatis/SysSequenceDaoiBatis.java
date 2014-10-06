
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.SysSequence;
import com.vriche.adrm.dao.SysSequenceDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class SysSequenceDaoiBatis extends BaseDaoiBATIS implements SysSequenceDao {

    /**
     * @see com.vriche.adrm.dao.SysSequenceDao#getSysSequences(com.vriche.adrm.model.SysSequence)
     */
    public List getSysSequences(final SysSequence sysSequence) {
          return getSqlMapClientTemplate().queryForList("getSysSequences", sysSequence);
    }
     /**
     * @see com.vriche.adrm.dao.SysSequenceDao#getSysSequencesCount(com.vriche.adrm.model.SysSequence)
     */
    public Integer getSysSequencesCount(final SysSequence sysSequence) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getSysSequencesCount", sysSequence);
    }
     /**
     * @see com.vriche.adrm.dao.SysSequenceDao#getSysSequencesPage(com.vriche.adrm.model.SysSequence)
     */   
  	public PaginatedList getSysSequencesPage(final SysSequence sysSequence,int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getSysSequences",sysSequence,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}  
    /**
     * @see com.vriche.adrm.dao.SysSequenceDao#getSysSequencesByIdList(com.vriche.adrm.model.SysSequence)
     */
    public List getSysSequencesByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getSysSequencesByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.dao.SysSequenceDao#getSysSequence(String sequenceID)
     */
    public SysSequence getSysSequence(String sequenceID) {
        SysSequence sysSequence = (SysSequence) getSqlMapClientTemplate().queryForObject("getSysSequence", sequenceID);

        if (sysSequence == null) {
            throw new ObjectRetrievalFailureException(SysSequence.class, sequenceID);
        }

        return sysSequence;
    }

    /**
     * @see com.vriche.adrm.dao.SysSequenceDao#saveSysSequence(SysSequence sysSequence)
     */    
    public Long saveSysSequence(final SysSequence sysSequence) {
        Long id = sysSequence.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addSysSequence", sysSequence);
        } else {
            getSqlMapClientTemplate().update("updateSysSequence", sysSequence);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(SysSequence.class, id);
        }
        return  id;
    }

    /**
     * @see com.vriche.adrm.dao.SysSequenceDao#removeSysSequence(String sequenceID)
     */
    public void removeSysSequence(String sequenceID) {
        getSqlMapClientTemplate().update("deleteSysSequence", sequenceID);
    }
    /**
     * @see com.vriche.adrm.dao.SysSequenceDAO#removeSysSequences(String sequenceIDs)
     */
    public void removeSysSequences(final Map idList) {
        getSqlMapClientTemplate().update("deleteSysSequences", idList);
    }
	public SysSequence getSysSequenceByObject(SysSequence sysSequence) {
		// TODO Auto-generated method stub
		SysSequence sequence = (SysSequence)getSqlMapClientTemplate().queryForObject("getSysSequenceByObject", sysSequence);
		return sequence;
	}    
}
