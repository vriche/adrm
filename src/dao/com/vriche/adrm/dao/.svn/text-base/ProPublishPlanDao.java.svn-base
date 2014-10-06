
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.ProPublishPlan;
import com.vriche.adrm.model.ProPublishPlanDetail;

public interface ProPublishPlanDao extends Dao {

    /**
     * Retrieves all of the proPublishPlans
     */
    public List getProPublishPlans(ProPublishPlan proPublishPlan);
    /**
     * Retrieves all of the proPublishPlan
     */
    public List getProPublishPlan(ProPublishPlan proPublishPlan);
    /**
     * Retrieves all of the proPublishPlanResultCollection
     */
    public List getProPublishPlanCollection(final ProPublishPlan proPublishPlan);
    /**
     * Retrieves all of the getProPublishPlansCount
     */
    public Integer getProPublishPlansCount(ProPublishPlan proPublishPlan);   
    /**
     * Retrieves all of the getProPublishPlansPage
     */        
    public List getProPublishPlansPage(ProPublishPlan proPublishPlan,int pageIndex,int pageSize);
    /**
     * Retrieves all of the proPublishPlansByIdList
     */
    public List getProPublishPlansByMap(final Map mp);

    /**
     * Gets proPublishPlan's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the proPublishPlan's id
     * @return proPublishPlan populated proPublishPlan object
     */
    public ProPublishPlan getProPublishPlan(final Long id);

    /**
     * Saves a proPublishPlan's information
     * @param proPublishPlan the object to be saved
     */    
    public Long saveProPublishPlan(ProPublishPlan proPublishPlan);
    
    public void saveProPublishPlanDetail(ProPublishPlan proPlanDetail,List weeksPlanList);
    
    public void saveProPublishPlanDetail(ProPublishPlanDetail proPlanDetail);
    /**
     * Removes a proPublishPlan from the database by id
     * @param id the proPublishPlan's id
     */
    public void removeProPublishPlan(final Long id);
    
    public void removeProPublishPlanDetail(final Long id);
	/**
     * Removes proPublishPlans from the database by ids
     * @param ids the proPublishPlan's id eg:"'1','2','3'"
     */
    public void removeProPublishPlans(final Map idList);
	public List getProPublishPlanDetail(String id);
	public List getProPublishPlanDetails(String id);
}

