
package com.vriche.adrm.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.ProPublishPlan;
import com.vriche.adrm.model.ProPublishPlanDetail;
import com.vriche.adrm.dao.ProPublishPlanDao;

public interface ProPublishPlanManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setProPublishPlanDao(ProPublishPlanDao proPublishPlanDAO);
    /**
     * Retrieves all of the getProPublishPlan
     */
    public List getProPublishPlan(final ProPublishPlan proPublishPlan);
    /**
     * Retrieves all of the proPublishPlans
     */
    public ProPublishPlan getProPublishPlans(ProPublishPlan proPublishPlan);
     /**
     * Retrieves all of the proPublishPlansCount
     */
    public String getProPublishPlansCount(ProPublishPlan proPublishPlan);
    
    public String getProPublishPlanCount(String proName,ProPublishPlan proPublishPlan);
     /**
     * Retrieves all of the proPublishPlansCount
     */    
    public List getProPublishPlansPage(ProPublishPlan proPublishPlan,String pageIndex,String pageSize);
     /**
     * Retrieves all of the proPublishPlansPageXML
     */   
    public String getProPublishPlansPageXML(ProPublishPlan proPublishPlan,String pageIndex,String pageSize);
    
    public String getProPublishPlanPageXML(String proName,ProPublishPlan proPublishPlan,String pageIndex,String pageSize);
    public String getProPublishPlanXML(ProPublishPlan proPublishPlan);
     /**
     * Retrieves all of the proPublishPlansByMap
     */
    public List getProPublishPlansByMap(final Map mp);

    /**
     * Gets proPublishPlan's information based on id.
     * @param id the proPublishPlan's id
     * @return proPublishPlan populated proPublishPlan object
     */
    public ProPublishPlan getProPublishPlan(final String id);

    /**
     * Saves a proPublishPlan's information
     * @param proPublishPlan the object to be saved
     */
    public String saveProPublishPlan(ProPublishPlan proPublishPlan);
    
    public void saveProPublishPlanDetails(ProPublishPlanDetail proPublishPlan);
    
    public String saveProPublishPlanById(ProPublishPlan proPublishPlan);

    /**
     * Removes a proPublishPlan from the database by id
     * @param id the proPublishPlan's id
     */
    public void removeProPublishPlan(final String id);
     /**
     * Removes a proPublishPlan from the database by id
     * @param idList
     */
    public void removeProPublishPlans(final Map mp);
    
    
    public String getProPublishPlanDetailXML(String id);
    
    public void removeProPublishPlanDetail(Long id);
    
    public Collection getCollections(final String queryString,String type);
}

