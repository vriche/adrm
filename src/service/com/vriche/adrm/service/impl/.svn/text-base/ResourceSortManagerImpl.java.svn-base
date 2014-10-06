
package com.vriche.adrm.service.impl;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.Constants;
import com.vriche.adrm.dao.ResourceSortDao;
import com.vriche.adrm.model.ResourceSort;
import com.vriche.adrm.service.ResourceSortManager;

public class ResourceSortManagerImpl extends BaseManager implements ResourceSortManager {
    private ResourceSortDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setResourceSortDao(ResourceSortDao dao) {
        this.dao = dao;
    }
   /**
     * @see com.vriche.adrm.service.ResourceSortManager#getResourceSorts(com.vriche.adrm.model.ResourceSort)
     */
    public List getResourceSorts(final ResourceSort resourceSort) {
        return dao.getResourceSorts(resourceSort);
    }
   /**
     * @see com.vriche.adrm.service.ResourceSortManager#getResourceSortsCount(com.vriche.adrm.model.ResourceSort)
     */
    public String getResourceSortsCount(final ResourceSort resourceSort) {
        return dao.getResourceSortsCount(resourceSort).toString();
    }    

   /**
     * @see com.vriche.adrm.service.ResourceSortManager#getResourceSortsCount(com.vriche.adrm.model.ResourceSort)
     */    
	public PaginatedList getResourceSortsPage(final ResourceSort resourceSort,String pageIndex, String pageSize) {
		return dao.getResourceSortsPage(resourceSort,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    

    /**
     * @see com.vriche.adrm.service.ResourceSortManager#getResourceSort(String id)
     */
    public ResourceSort getResourceSort(final String id) {
        return dao.getResourceSort(new Long(id));
    }
    /**
     * @see com.vriche.adrm.service.ResourceSortManager#getResourceSortsByIdList(final Map idList)
     */
    public List getResourceSortsByIdList(final Map idList) {
        return dao.getResourceSortsByIdList(idList);
    }    

    /**
     * @see com.vriche.adrm.service.ResourceSortManager#saveResourceSort(ResourceSort resourceSort)
     */
    public String saveResourceSort(ResourceSort resourceSort) {
        return dao.saveResourceSort(resourceSort).toString();
    }

    /**
     * @see com.vriche.adrm.service.ResourceSortManager#removeResourceSort(String id)
     */
    public void removeResourceSort(final String id) {
        dao.removeResourceSort(new Long(id));
    }

     /**
     * @see com.vriche.adrm.service.ResourceSortManager#removeResourceSorts(String Map)
     */
    public void removeResourceSorts(final Map idList) {
        dao.removeResourceSorts(idList);
    }
	public Map getResourceSortSelect() {
		   List ls = dao.getResourceSorts(null);
	       Map reply = new LinkedHashMap();
	       Iterator it = ls.iterator();
//	       reply.put( "0","");
	       while (it.hasNext()){
	    	   ResourceSort resourceSort = new ResourceSort();
	    	   resourceSort = (ResourceSort)it.next();
	           reply.put(resourceSort.getId(),resourceSort.getName() + "||" +resourceSort.getValue());
	       }
	       return reply;
	}
	public Map getResourceSortSelectFromMap() {
		// TODO Auto-generated method stub
		List resourceSortList = (List)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_RESOURCESORT);
		Map reply = new LinkedHashMap();
		Iterator it = resourceSortList.iterator();
//		reply.put("0","");
		while(it.hasNext()){
			ResourceSort resSort = (ResourceSort)it.next();
			reply.put(resSort.getId(),resSort.getName() + "||" +resSort.getValue());
		}
		return reply;
	}   
	
	public List getResourceSortSelect2() {
		// TODO Auto-generated method stub
		List resourceSortList = (List)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_RESOURCESORT);
		return resourceSortList;
	}  	
	
	
	
	public Map getResourceSortSelectFromMap2() {
		// TODO Auto-generated method stub
		List resourceSortList = (List)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_RESOURCESORT);
		Map reply = new LinkedHashMap();
		Iterator it = resourceSortList.iterator();
		reply.put("0","==所有分类==");
		while(it.hasNext()){
			ResourceSort resSort = (ResourceSort)it.next();
			reply.put(resSort.getId(),resSort.getName() + "||" +resSort.getValue());
		}
		return reply;
	}   
	
}
