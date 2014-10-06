/**
 * 
 */
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.model.ParamClass;

public interface ProAnalyzeDao extends Dao{
	 /**
     * Retrieves all of the proOrders
     */
    public List getProOrders(ParamClass paramClass);
    /**
     * Retrieves all of the getProOrdersCount
     */
    public Integer getProOrdersCount(ParamClass paramClass);   
    /**
     * Retrieves all of the getProOrdersPage
     */        
    public List getProOrdersPage(ParamClass paramClass,int pageIndex,int pageSize);

    /**
     * Gets paramClass's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the paramClass id
     * @return paramClass populated paramClass object
     */
    public ParamClass getProOrder(final Long id);
    public double getCarrierMoneyByProgramId(ParamClass  paramClass);
    public List getProOrderByObject(ParamClass paramClass);
    
    public List getProCostAnalyzeList(ParamClass paramClass,int pageIndex, int pageSize);
    public Integer getProCostAnalyzeCount(ParamClass paramClass);
    public List getProCostAnalyzes(ParamClass paramClass);
    
    public List getProAudienceAnalyzeList(ParamClass paramClass,int pageIndex, int pageSize);
    public List getProAudienceAnalyzes(ParamClass paramClass);

    /**
     * Gets Carrier  Resources's information based 
     * 
     * @return resources id List
     */
    public List getResourcesIdByIdList(Map map);
    /**
     * Gets CarrierResources's information based  by paramClass object
     * 
     * @return ParentId id List
     */
    public List getCarrierParentIdList(ParamClass paramClass);
    public List getProProgramNameList(ParamClass paramClass,int pageIndex, int pageSize);
    public List getProProgramNameList(ParamClass paramClass);
    public Integer getProProgramNameCount(ParamClass paramClass);
    public List getCarrierMemo(Map map);
    public List getCarrierMoney(Map map);
    public List getProPlanDateList(ParamClass paramClass);
    
}
