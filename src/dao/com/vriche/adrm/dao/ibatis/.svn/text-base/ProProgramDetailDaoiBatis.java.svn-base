
package com.vriche.adrm.dao.ibatis;

import com.vriche.adrm.dao.ProProgramDetailDao;
import com.vriche.adrm.model.ProProgramDetail;

public class ProProgramDetailDaoiBatis extends BaseDaoiBATIS implements ProProgramDetailDao {

	 /**
     * @see com.vriche.adrm.dao.ProProgramDetailDao#getProProgramDetail(com.vriche.adrm.model.ProProgramDetail)
     */
    public ProProgramDetail getProProgramDetail(final Long id) {
    		return (ProProgramDetail) getSqlMapClientTemplate().queryForObject("getProProgramDetail", id);
         
    }
    
    /**
     * @see com.vriche.adrm.dao.ProProgramDetailDao#saveProProgramDetail(ProProgramDetail ProProgramDetail)
     */    
    public void saveProProgramDetail(final ProProgramDetail proProgramDetail) {
        ProProgramDetail proDetail = getProProgramDetail(proProgramDetail.getProgramId());
        if(proDetail==null){	
            getSqlMapClientTemplate().insert("addProProgramDetail", proProgramDetail);
        } else {
            getSqlMapClientTemplate().update("updateProProgramDetail", proProgramDetail);
        }
    }

    /**
     * @see com.vriche.adrm.dao.ProProgramDetailDao#removeProProgramDetail(Long id)
     */
    public void removeProProgramDetail(Long id) {
        getSqlMapClientTemplate().update("deleteProProgramDetail", id);
    }
  

}
