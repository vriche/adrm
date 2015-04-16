
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.Resource;


public interface ResourceDao extends Dao {

    /**
     * Retrieves all of the resources
     */
    public List getResources(Resource resource);
    public List getResourcesLevelOne(Resource resource);
    public List getResourcesOrderbyBroStartTime(Resource resource);
    public List getResourcesOrderbyBroStartTimeLevelOne(Resource resource);
    
    
    

    
    public List getResourcesForArrange(final Resource resource) ;
    
    public List getResourcesForArrangeOrderByBroTime(final Resource resource);
    /**
     * Retrieves all of the resourcesByIdList
     */
    public List getResourcesByIdList(final Map idList);
    
    public List getResourcesIdByIdList(final Map idList);
    
    public List getResourcesNameByIdList(Resource resource);

    /**
     * Gets resource's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the resource's id
     * @return resource populated resource object
     */
    public Resource getResource(final Long id);

    /**
     * Saves a resource's information
     * @param resource the object to be saved
     */    
    public Long saveResource(Resource resource);

    /**
     * Removes a resource from the database by id
     * @param id the resource's id
     */
    public void removeResource(final Long id);
    
//    public void removeResource(final Map mp);
	/**
     * Removes resources from the database by ids
     * @param ids the resource's id eg:"'1','2','3'"
     */
    public void removeResources(final Map idList);
    
    public void removeResources2(final Map idList);
    
    public List getResourcesByCompagesId(final Long id);
    
    public List getResourcePrint(Map carrierIds);
    
    public void updateDisplayNo(Map carrierIds);
    
    public void updateEnable(Map resourceIdAndEnable);
    
    public List getPriceLength(Map carrierIds);
    
    public void saveResCarrTypeRel(Map mp);
    
    public List getResourceIdsBySortId(Map mp);
    
    public List getResourceInfoForWebService(Map mp);
    
    public List getStoreResourceByOrderId(Map mp);
    
    public Map getResourcesForQuery1(Map mp);
    public Map getResourcesForQuery1_1(Map mp);
    
    public List getResourcesForQuery2(Map mp);
    public List getResourcesByIds(Map mp);
    
    public List getResourceIdsByYearUser(Map mp);
    public void removeResourceUserRate(final Map mp);
    public Long saveResourceUserRate(final Map mp);
    
    
    
}

