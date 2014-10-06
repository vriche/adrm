
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.WorkspanDao;
import com.vriche.adrm.model.Workspan;
import com.vriche.adrm.service.Manager;

public interface WorkspanManager extends Manager {

	
    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setWorkspanDao(WorkspanDao workspanDAO);

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
     * Gets workspan's information based on id.
     * @param id the workspan's id
     * @return workspan populated workspan object
     */
    public Workspan getWorkspan(final String id);

    /**
     * Saves a workspan's information
     * @param workspan the object to be saved
     */
    public void saveWorkspan(Workspan workspan);

    /**
     * Removes a workspan from the database by id
     * @param id the workspan's id
     */
    public void removeWorkspan(final String id);
     /**
     * Removes a workspan from the database by id
     * @param idList
     */
    public void removeWorkspans(final Map idList);
    
    public PaginatedList getWorkspanPageByResoruceId(String resId, String pageIndex, String pageSize);
    
	public String getWorkspanCountByResoruceId(String id);
	
	public List getResourceDayInfo(Integer publishDate,Long resourceId);
	
	public List getWorkspansByResourceIdList(String[] resourceIds); 
	
	public void resetAllSpecByOrderDayInfo(String year);
}

