
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.OrderDayInfo;
import com.vriche.adrm.model.Workspan;

public interface WorkspanDao extends Dao {

    /**
     * Retrieves all of the workspans
     */
    public List getWorkspans(Workspan workspan);
    
   
    public List getWorkspansByResourceId(String resourceId);
    
    
    /**
     * Retrieves all of the workspansByIdList
     */
    public List getWorkspansByIdList(final Map idList);

    /**
     * Gets workspan's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the workspan's id
     * @return workspan populated workspan object
     */
    public Workspan getWorkspan(final Long id);

    /**
     * Saves a workspan's information
     * @param workspan the object to be saved
     */    
    public Long saveWorkspan(Workspan workspan);

    /**
     * Removes a workspan from the database by id
     * @param id the workspan's id
     */
    public void removeWorkspan(final Long id);
	/**
     * Removes workspans from the database by ids
     * @param ids the workspan's id eg:"'1','2','3'"
     */
    public void removeWorkspans(final Map idList);
    
    public PaginatedList getWorkspanPageByResoruceId(Long resId, int pageIndex, int pageSize);
    
	public Integer getWorkspanCountByResoruceId(String id);
	
	public List getResourceDayInfo(Integer publishDate,Long resourceId);
	
	public List getWorkspansByResourceIdList(Map mp) ;
	
	public Map getOrderDayTimeSpec(Integer startDate,Integer endDate,Long resourceId);
	public Map getOrderDayTimeUsed(Integer startDate,Integer endDate,Long resourceId);
	
	
	public void removeResourceDayInfo(Long workspanId,Integer beginDate,Integer endDate);
	public void addResourceDayInfo(Workspan workspan);


}

