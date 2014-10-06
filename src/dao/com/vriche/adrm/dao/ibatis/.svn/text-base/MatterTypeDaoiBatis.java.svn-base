
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.MatterType;
import com.vriche.adrm.dao.MatterTypeDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class MatterTypeDaoiBatis extends BaseDaoiBATIS implements MatterTypeDao {

    /**
     * @see com.vriche.adrm.dao.MatterTypeDao#getMatterTypes(com.vriche.adrm.model.MatterType)
     */
    public List getMatterTypes(final MatterType matterType) {
          return getSqlMapClientTemplate().queryForList("getMatterTypes", matterType);
    }
     /**
     * @see com.vriche.adrm.dao.MatterTypeDao#getMatterTypesCount(com.vriche.adrm.model.MatterType)
     */
    public Integer getMatterTypesCount(final MatterType matterType) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getMatterTypesCount", matterType);
    }
     /**
     * @see com.vriche.adrm.dao.MatterTypeDao#getMatterTypesPage(com.vriche.adrm.model.MatterType)
     */   
  	public PaginatedList getMatterTypesPage(final MatterType matterType,int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getMatterTypes",matterType,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}  
    /**
     * @see com.vriche.adrm.dao.MatterTypeDao#getMatterTypesByIdList(com.vriche.adrm.model.MatterType)
     */
    public List getMatterTypesByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getMatterTypesByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.dao.MatterTypeDao#getMatterType(Long id)
     */
    public MatterType getMatterType(Long id) {
        MatterType matterType = (MatterType) getSqlMapClientTemplate().queryForObject("getMatterType", id);

        if (matterType == null) {
            throw new ObjectRetrievalFailureException(MatterType.class, id);
        }

        return matterType;
    }

    /**
     * @see com.vriche.adrm.dao.MatterTypeDao#saveMatterType(MatterType matterType)
     */    
    public Long saveMatterType(final MatterType matterType) {
        Long id = matterType.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addMatterType", matterType);
        } else {
            getSqlMapClientTemplate().update("updateMatterType", matterType);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(MatterType.class, id);
        }
        return  id;
    }

    /**
     * @see com.vriche.adrm.dao.MatterTypeDao#removeMatterType(Long id)
     */
    public void removeMatterType(Long id) {
        getSqlMapClientTemplate().update("deleteMatterType", id);
    }
    /**
     * @see com.vriche.adrm.dao.MatterTypeDAO#removeMatterTypes(String ids)
     */
    public void removeMatterTypes(final Map idList) {
        getSqlMapClientTemplate().update("deleteMatterTypes", idList);
    }    
}
