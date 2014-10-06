
package com.vriche.adrm.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.ResourceDao;
import com.vriche.adrm.model.CtrData;
import com.vriche.adrm.model.ListRange;
import com.vriche.adrm.model.Resource;

public interface ResourceManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setResourceDao(ResourceDao resourceDAO);

    /**
     * Retrieves all of the resources
     */
    public List getResources(Resource resource);
        /**
     * Retrieves all of the resourcesByIdList
     */
    public List getResourcesByIdList(final Map idList);
    
    public List getResourcesIdByIdList(final Map idList);
    /**
     * Gets resource's information based on id.
     * @param id the resource's id
     * @return resource populated resource object
     */
    public Resource getResource(final String id);

    /**
     * Saves a resource's information
     * @param resource the object to be saved
     */
    public String saveResource(Resource resource);

    /**
     * Removes a resource from the database by id
     * @param id the resource's id
     */
    public void removeResource(final String id);
     /**
     * Removes a resource from the database by id
     * @param idList
     */
    public void removeResources(final Map idList);
    
    public Map getResourceSelect(Resource resource);
    
    public Map getResourceSelectFromMap(Resource res);
    
    public Resource getResourceByIdFromMap(Resource res);
    
    public void getResourceItemsByCarrierId(StringBuffer sb,String carrierId, String resourceIdPrefix);
    
    public void getResourceItemsByCarrierIdByYear(StringBuffer sb,String carrierId, String resourceIdPrefix,String year,boolean orderCarrierLevelOne,Integer resType,String orgType);
    
    public void getResourceItemsByCarrierIdFromMapByYear(StringBuffer sb, String carrierId, String resourceIdPrefix,String year);
    
    public void getResourceItemsByCarrierIdFromMap(StringBuffer sb, String carrierId, String resourceIdPrefix,String publishDate,String resourceTypeId);
    
    public String[] getResourcesByCompagesId(final String compagesId,String propertyName);
    
    public void getResourceItemsByCarrierIdForArrange(StringBuffer sb, String carrierId, String resourceIdPrefix,String publishDate);
    
    public List getResourceIdsForPutOn(String carrierId);
    
    public void getResourcesResourceAnalyze(StringBuffer sb,String carrierId, String resourceIdPrefix,String resourceTypeId);
    
    public Collection getResourcesPrint(String carrierId,Map carrierMap );
    
    public Collection getCollections(final String queryString,String type);
    
    public List getResListByCarrierId(Long carrId,String publishDate);
    
    public List getResListByCarrierIdAndIsAccountRes(Long carrierId,boolean isAccountRes);
    
    public void getResourceItemsByCarrierIdFromMapByYear2(StringBuffer sb, String carrierId, String resourceIdPrefix,String paramYear,boolean isAccountRes);
    
    public void updateDisplayNo(String[] resourceIds);
    
    public void updateEnable(String resourceId,boolean enable);
    
    public List getPriceLength(String[] carrierIds);
    
    public void getResourceItemsByChannelIdByYear(StringBuffer sb, String carrierId, String resourceIdPrefix, String year,Integer resourceType,Integer orderBy);
    
    public Map getResourcesAllFromChannelId(Resource res); 
    
    public Map getResourceYearTypeMap(String year,String resourceType);
    
    public String[] getResourceIds(Resource res);
    
	public  List getResourceIdsBySortId(List carrier2IdList,String startDate, String endDate,String resType);
	public  List getResourceIdsBySortId(List carrier2IdList,int sYear,int eYear,String resType) ;
	
	public void getResourceItemsByChannelIdByYear2(StringBuffer sb, String carrierId, String resourceIdPrefix, String year,Integer resourceType,Integer orderBy,boolean enable,boolean isFineRes);
    
	public List getTree(Map searchMap);
	
	public void saveResourceFromOtherYear(String sourceYear,String tagYear);
	
	public List getResourcesBySort(Resource res);
	
	public List getResourceSelectFromMap3(Resource res);
	
	public String getResourcesForQueryXml(String queryString, String type) throws Exception;
	public Collection getCollectionsForQuery(String queryString, String type,Map printParamMap) throws  Exception;
	
	public List getResourceCtrData(Resource res) throws Exception;
	
	public List getResourcesBySort2(Resource res);
	
	public List getResourcesByIds(String strQueryString);
	
	public String getResourceXMLforDhtmlTree(String strQueryString);
	
	
}

