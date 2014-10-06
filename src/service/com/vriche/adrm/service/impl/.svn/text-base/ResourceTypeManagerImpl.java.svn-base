
package com.vriche.adrm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.ResourceTypeDao;
import com.vriche.adrm.model.Carrier;
import com.vriche.adrm.model.CarrierType;
import com.vriche.adrm.model.Industry;
import com.vriche.adrm.model.ResourceType;
import com.vriche.adrm.service.ResourceTypeManager;
import com.vriche.adrm.service.impl.BaseManager;
import com.vriche.adrm.util.StringUtilsv;

public class ResourceTypeManagerImpl extends BaseManager implements ResourceTypeManager {
    private ResourceTypeDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setResourceTypeDao(ResourceTypeDao dao) {
        this.dao = dao;
    }

    /**
     * @see com.vriche.adrm.adres.service.ResourceTypeManager#getResourceTypesByIdList(final Map idList)
     */
    public List getResourceTypesByIdList(final Map idList) {
        return dao.getResourceTypesByIdList(idList);
    }
   /**
     * @see com.vriche.adrm.adres.service.ResourceTypeManager#getResourceTypes(com.vriche.adrm.adres.model.ResourceType)
     */
    public List getResourceTypes(final ResourceType resourceType) {
        return dao.getResourceTypes(resourceType);
    }

    /**
     * @see com.vriche.adrm.adres.service.ResourceTypeManager#getResourceType(String id)
     */
    public ResourceType getResourceType(final String id) {
        return dao.getResourceType(new Long(id));
    }

    /**
     * @see com.vriche.adrm.adres.service.ResourceTypeManager#saveResourceType(ResourceType resourceType)
     */
    public void saveResourceType(ResourceType resourceType) {
        dao.saveResourceType(resourceType);
    }

    /**
     * @see com.vriche.adrm.adres.service.ResourceTypeManager#removeResourceType(String id)
     */
    public void removeResourceType(final String id) {
        dao.removeResourceType(new Long(id));
    }

     /**
     * @see com.vriche.adrm.adres.service.ResourceTypeManager#removeResourceTypes(String Map)
     */
    public void removeResourceTypes(final Map idList) {
        dao.removeResourceTypes(idList);
    }    
    
    public Map getResourceTypeSelectItem(ResourceType resourceType){
    	List resourceTypes = this.getResourceTypes(resourceType);
    	
    	if(log.isDebugEnabled()){
    		log.info("resourceTypes.getOrgId()>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +resourceType.getOrgId());
    		log.info("resourceTypes.size()>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +resourceTypes.size());
    	}
    	
    	Iterator ite=resourceTypes.iterator();
		Map reply = new LinkedHashMap();
//		reply.put("0","==所有分类==");
		while(ite.hasNext()){
			
			ResourceType rType=(ResourceType)ite.next();

//			List carriers=dao.getCarriersByCarrier_TypeId(carrierType.getId());
//			Carrier carr =new Carrier();
//			carr.setCarrierTypeId(carrierType.getId());
//			carr.setNodeLevel(nodeLevel);
//			List carriers= dao.getCarriers(carr);
			reply.put(rType.getId(),rType.getName());
         
//			this.getCarriers(carriers,reply,carrierType.getName(),level);
		}
		return reply;
    }
    
    
    
    
    
    public List getTree(Map searchMap){
		List trees = new ArrayList();
		
		System.out.println("searchMap>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+searchMap);
	
		String nodeId = StringUtilsv.getNullValue(searchMap.get("nodeId"),"0");
		String orgId = StringUtilsv.getNullValue(searchMap.get("orgId"),"0");
		
		System.out.println("orgId>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+orgId);
		System.out.println("nodeId>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+nodeId);
		
		ResourceType resourceType = new ResourceType();
		resourceType.setOrgId(new Long(orgId));
		
		List lsIndustry = dao.getResourceTypes(resourceType);
		Iterator it = lsIndustry.iterator();
		while (it.hasNext()) {
			Map map = new HashMap();
			ResourceType ind =(ResourceType)it.next();
			
//			ResourceType resourceType2 = new ResourceType();
//			resourceType2.setOrgId(new Long(orgId));
//			List ls2 = dao.getResourceTypes(resourceType2);
//
//	
//			boolean isLeaf = (ls2.size() == 0);
	
//			System.out.println("isLeaf>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+isLeaf);

			map.put("id", ind.getId());
			map.put("text", ind.getName());
			map.put("leaf", new Boolean(true));
			map.put("type", "1");
			map.put("level", "1");
			map.put("realId", ind.getId());


//			if (!isLeaf){
//				Map searchMap2 = new HashMap();
//				searchMap2.put("nodeId",ind.getId().toString());
//				map.put("children", getTree(searchMap2));
//			}
			 
//			if (!isLeaf) map.put("expanded",  new Boolean(true));
			
//			map.put("childNodesSum", new Integer(ls2.size()));
			
			trees.add(map);
		}
		return trees;
	}
}



