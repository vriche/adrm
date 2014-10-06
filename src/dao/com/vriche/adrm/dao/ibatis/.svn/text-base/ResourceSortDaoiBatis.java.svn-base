
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.ResourceSort;
import com.vriche.adrm.dao.ResourceSortDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class ResourceSortDaoiBatis extends BaseDaoiBATIS implements ResourceSortDao {

    /**
     * @see com.vriche.adrm.dao.ResourceSortDao#getResourceSorts(com.vriche.adrm.model.ResourceSort)
     */
    public List getResourceSorts(final ResourceSort resourceSort) {
          return getSqlMapClientTemplate().queryForList("getResourceSorts", resourceSort);
    }
     /**
     * @see com.vriche.adrm.dao.ResourceSortDao#getResourceSortsCount(com.vriche.adrm.model.ResourceSort)
     */
    public Integer getResourceSortsCount(final ResourceSort resourceSort) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getResourceSortsCount", resourceSort);
    }
     /**
     * @see com.vriche.adrm.dao.ResourceSortDao#getResourceSortsPage(com.vriche.adrm.model.ResourceSort)
     */   
  	public PaginatedList getResourceSortsPage(final ResourceSort resourceSort,int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getResourceSorts",resourceSort,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}  
    /**
     * @see com.vriche.adrm.dao.ResourceSortDao#getResourceSortsByIdList(com.vriche.adrm.model.ResourceSort)
     */
    public List getResourceSortsByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getResourceSortsByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.dao.ResourceSortDao#getResourceSort(Long id)
     */
    public ResourceSort getResourceSort(Long id) {
        ResourceSort resourceSort = (ResourceSort) getSqlMapClientTemplate().queryForObject("getResourceSort", id);

        if (resourceSort == null) {
            throw new ObjectRetrievalFailureException(ResourceSort.class, id);
        }

        return resourceSort;
    }

    /**
     * @see com.vriche.adrm.dao.ResourceSortDao#saveResourceSort(ResourceSort resourceSort)
     */    
    public Long saveResourceSort(final ResourceSort resourceSort) {
        Long id = resourceSort.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addResourceSort", resourceSort);
        } else {
            getSqlMapClientTemplate().update("updateResourceSort", resourceSort);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(ResourceSort.class, id);
        }
        return  id;
    }

    /**
     * @see com.vriche.adrm.dao.ResourceSortDao#removeResourceSort(Long id)
     */
    public void removeResourceSort(Long id) {
        getSqlMapClientTemplate().update("deleteResourceSort", id);
    }
    /**
     * @see com.vriche.adrm.dao.ResourceSortDAO#removeResourceSorts(String ids)
     */
    public void removeResourceSorts(final Map idList) {
        getSqlMapClientTemplate().update("deleteResourceSorts", idList);
    }    
}
