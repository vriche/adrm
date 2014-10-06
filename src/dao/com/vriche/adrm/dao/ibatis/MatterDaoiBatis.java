
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ObjectRetrievalFailureException;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.MatterDao;
import com.vriche.adrm.model.Matter;

//import com.vriche.adrm.util.ServiceLocator;
//import com.vriche.adrm.util.SysParamUtil;

public class MatterDaoiBatis extends BaseDaoiBATIS implements MatterDao {

    /**
     * @see com.vriche.adrm.adver.dao.MatterDao#getMatters(com.vriche.adrm.adver.model.Matter)
     */
    public List getMatters(final Matter matter) {
          return getSqlMapClientTemplate().queryForList("getMatters", matter);
    }
    
    /**
     * @see com.vriche.adrm.adver.dao.MatterDao#getMatters(com.vriche.adrm.adver.model.Matter)
     */
    public List getMattersByCustomerIdAndLength(final Matter matter) {
          return getSqlMapClientTemplate().queryForList("getMattersByCustomerIdAndLength", matter);
    }   
    
    public Integer getMattersCountByDate(Map mp) {
   	 	return new Integer(getSqlMapClientTemplate().queryForList("getMattersCountByDate", mp).size());
	}
    
    public PaginatedList getMattersByDate(Map mp, int pageIndex, int pageSize) {
       PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getMattersByDate", mp,pageSize);
       pageList.gotoPage(pageIndex-1);
       return  pageList;
  }
    
    public Integer getMattersCount(Matter matter) {
   	 	return (Integer)getSqlMapClientTemplate().queryForObject("getMattersCount", matter);
	}

    public Integer getMattersSerachCount(Map mp) {
   	 	return (Integer)getSqlMapClientTemplate().queryForObject("getMattersSerachCount", mp);
	}

	public PaginatedList getMattersPage(Matter matter, int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getMatters",matter,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}
	
	public List getMattersListPage(Matter matter) {
		 return getSqlMapClientTemplate().queryForList("getMatters",matter);
	}

	
	
	public List getMattersByCustomer(Matter matter) {
		 return getSqlMapClientTemplate().queryForList("getMattersByCustomerIdAndLength",matter);
	}
	
	public List getMattersSearchPage(Map mp, int skip, int pageSize) {
		 return getSqlMapClientTemplate().queryForList("getMattersSearch",mp,skip,pageSize);
//	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getMattersSearch",mp,pageSize);
//	     pageList.gotoPage(pageIndex-1);
//		 return pageList;
	}

	/**
     * @see com.vriche.adrm.adver.dao.MatterDao#getMattersByIdList(com.vriche.adrm.adver.model.Matter)
     */
    public List getMattersByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getMattersByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.adver.dao.MatterDao#getMatter(Long id)
     */
    public Matter getMatter(Long id) {
    	Matter mat = new Matter();
    	mat.setId(id);
    	 
        Matter matter = this.getMatter(mat);

//        if (matter == null) {
//            throw new ObjectRetrievalFailureException(Matter.class, id);
//        }

        return matter;
    }
    
	public Matter getMatter(Matter matter) {  
		 List ls = getSqlMapClientTemplate().queryForList("getMatter", matter);
		 if(ls.size()>=1){
			 matter = (Matter)ls.get(0);
		 }else{
			 matter =new Matter();
		 }
		 return matter;
	}    

	
	

    /**
     * @see com.vriche.adrm.adver.dao.MatterDao#saveMatter(Matter matter)
     */    
    public Long saveMatter(final Matter matter) {
        Long id = matter.getId();
        // check for new record
        if (id == null) {
            id = (Long) getSqlMapClientTemplate().insert("addMatter", matter);
        } else {
            getSqlMapClientTemplate().update("updateMatter", matter);
        }
        
        
//         int importOption = (id == null)?1:2;
//         saveDayangMatter(matter,importOption);

        
        if( id == null ) {
            throw new ObjectRetrievalFailureException(Matter.class, id);
        }
        
        return id;
    }

    /**
     * @see com.vriche.adrm.adver.dao.MatterDao#removeMatter(Long id)
     */
    public void removeMatter(Long id) {
        getSqlMapClientTemplate().update("deleteMatter", id);
        
        Matter matter = new Matter();
        matter.setId(id);
//        saveDayangMatter(matter,3);
    }
    /**
     * @see com.vriche.adrm.order.dao.MatterDAO#removeMatters(String ids)
     */
    public void removeMatters(final Map idList) {
        getSqlMapClientTemplate().update("deleteMatters", idList);
    }


	public List getAllMatters(String name) {
		return getSqlMapClientTemplate().queryForList("getAllMatters", name);
	}

	public List getMattersDIV(Matter matter) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getMattersDIV", matter);
	}

	public List getMattersByResCut(Map mp) {
		return getSqlMapClientTemplate().queryForList("getMattersByResCut", mp);
	}

	public List getMattersReport(Matter matter) {
		return getSqlMapClientTemplate().queryForList("getMatters", matter);
	}

	public Matter getMatterByTapCode(Matter matter) {
		 List ls = getSqlMapClientTemplate().queryForList("getMatterByTapCode", matter);
		 if(ls.size()>=1){
			 matter = (Matter)ls.get(0);
		 }else{
			 matter =new Matter();
		 }
		 return matter;
	}

	public List getMattersByOrderId(Matter matter) {
	          return getSqlMapClientTemplate().queryForList("getMattersByOrderId", matter);
	}

	public List getStoreMatterLengthByName(Matter matter) {
		  return getSqlMapClientTemplate().queryForList("getStoreMatterLengthByName", matter);
	}

	public List getStoreMatterEditByName(Matter matter) {
		// TODO Auto-generated method stub
		 return getSqlMapClientTemplate().queryForList("getStoreMatterEditByName", matter);
	}

    public List getMattersNames(final Matter matter) {
        return getSqlMapClientTemplate().queryForList("getMattersNames", matter);
    }
    public List getMattersEditsByHelpCode(final Matter matter) {
        return getSqlMapClientTemplate().queryForList("getMattersEditsByHelpCode", matter);
    }
    public List getMattersNews(final Map mp,int pageIndex,int pageSize) {
        return getSqlMapClientTemplate().queryForList("getMattersNew", mp,pageIndex,pageSize);
    }

	public Integer getMattersNewsCount(Map mp) {
		 return (Integer)getSqlMapClientTemplate().queryForObject("getMattersNewsCount", mp);
	}

	public void saveMatterInDayang(Matter matter) {
		 getSqlMapClientTemplate().update("updateMatterInDayang", matter);
	}
    
    
    
}
