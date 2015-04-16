
package com.vriche.adrm.dao.ibatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ObjectRetrievalFailureException;

import com.vriche.adrm.dao.ResourceDao;
import com.vriche.adrm.model.Resource;
import com.vriche.adrm.model.Workspan;

public class ResourceDaoiBatis extends BaseDaoiBATIS implements ResourceDao {
	List idList = new ArrayList();
	List workSpanceIdList = new ArrayList();
	

    /**
     * @see com.vriche.adrm.adres.dao.ResourceDao#getResources(com.vriche.adrm.adres.model.Resource)
     */
    public List getResources(final Resource resource) {
          return getSqlMapClientTemplate().queryForList("getResources", resource);
    }
    
	public List getResourcesLevelOne(Resource resource) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getResourcesLevelOne", resource);
	}
	
    
    public List getResourcesForArrange(final Resource resource) {
        return getSqlMapClientTemplate().queryForList("getResourcesForArrange", resource);
  }
    
    public List getResourcesForArrangeOrderByBroTime(final Resource resource) {
        return getSqlMapClientTemplate().queryForList("getResourcesForArrangeOrderByBroTime", resource);
  }
    /**
     * @see com.vriche.adrm.adres.dao.ResourceDao#getResourcesByIdList(com.vriche.adrm.adres.model.Resource)
     */
    public List getResourcesByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getResourcesByIdList", idList);
    }
    
    public List getResourcesIdByIdList(final Map idList) {
        return getSqlMapClientTemplate().queryForList("getParentIdByIdList", idList);
  }
    
    public List getResourcesNameByIdList(final Resource resource) {
        return getSqlMapClientTemplate().queryForList("getResourcesNameByIdList", resource);
  }

    /**
     * @see com.vriche.adrm.adres.dao.ResourceDao#getResource(Long id)
     */
    public Resource getResource(Long id) {
        Resource resource = (Resource) getSqlMapClientTemplate().queryForObject("getResource", id);

        if (resource == null) {
            throw new ObjectRetrievalFailureException(Resource.class, id);
        }
        
        return resource;
    }

    /**
     * @see com.vriche.adrm.adres.dao.ResourceDao#saveResource(Resource resource)
     */    
    public Long saveResource(final Resource resource) {
        Long id = resource.getId();
        // check for new record
        if (id == null || id.intValue() == 0|| id.intValue() == -1) {
            id = (Long) getSqlMapClientTemplate().insert("addResource", resource);
        } else {
            getSqlMapClientTemplate().update("updateResource", resource);
        }
//        if( id == null ) {
//            throw new ObjectRetrievalFailureException(Resource.class, id);
//        }
        return id;
    }
    
    

  

    /**
     * @see com.vriche.adrm.adres.dao.ResourceDao#removeResource(Long id)
     */
    public void removeResource(Long id) {
    	Map mp = new HashMap();
    	Map mpWks = new HashMap();
    	idList.clear();
        idList.add(id);
    	getResourceIdsByParent(id);
    	
    	//先扫除有效信息
    	workSpanceIdList.clear();
    	getWorkSpanceIdByResourceIds(idList);
    	if (workSpanceIdList.size()>0){
        	mpWks.put("WorkspanIdList",workSpanceIdList);
        	getSqlMapClientTemplate().update("deleteDayInfoByworkspanIdList", mpWks);
        	getSqlMapClientTemplate().update("deleteWorkspans", mpWks);
    	}

    	mp.put("ResourceIdList",idList);
    	this.removeResources(mp);
//        getSqlMapClientTemplate().update("deleteResource", id);
    	
    }

    private void getResourceIdsByParent(Long parentId){
    	List ls = getSqlMapClientTemplate().queryForList("getResourceByParentId", parentId);
    	Iterator it  = ls.iterator();
    	while (it.hasNext()){
    		Resource resource = (Resource)it.next();
    		idList.add(resource.getId());
    		getResourceIdsByParent(resource.getId());
    	}  	

    }
    
    private void getWorkSpanceIdByResourceIds(List rsList){
    	Iterator it  = rsList.iterator();
    	while(it.hasNext()){
    		List ws =  getSqlMapClientTemplate().queryForList("getWorkspanByResourceId", (Long)it.next());
    		setWorkSpanceIdList(ws);
    	}
    	
    }
    
    private void setWorkSpanceIdList(List wsList){ 
    	Iterator it  = wsList.iterator();
    	while(it.hasNext()){
    		Workspan workspan = (Workspan)it.next();
    		workSpanceIdList.add(workspan.getId());
    	}
    	
    }
    
    
    
    
    /**
     * @see com.vriche.adrm.order.dao.ResourceDAO#removeResources(String ids)
     */
    public void removeResources(final Map idList) {
    	  
    	getSqlMapClientTemplate().update("deletePriceResourceRelByResourceIdList", idList);
   
        getSqlMapClientTemplate().update("deleteResources", idList);
    }
    
    public void removeResources2(final Map idList) {
  	  
//    	getSqlMapClientTemplate().update("deletePriceResourceRelByResourceIdList2", idList);
   
        getSqlMapClientTemplate().update("deleteResources2", idList);
    }
    
	public List getResourcesByCompagesId(Long id) {
		return getSqlMapClientTemplate().queryForList("getResourcesByCompagesId",id);
	}    
    
	public List getResourcePrint(Map carrierIds){
		return getSqlMapClientTemplate().queryForList("getResourcePrint",carrierIds);
	}
	public void updateDisplayNo(Map resourceIds){
		getSqlMapClientTemplate().update("updatedisplayNo", resourceIds);
	}
	public void updateEnable(Map resourceIdAndEnable){
		getSqlMapClientTemplate().update("updateEnable", resourceIdAndEnable);
	}
	public List getPriceLength(Map carrierIds){
		return getSqlMapClientTemplate().queryForList("getPriceLength",carrierIds);
	}

	public List getResourcesOrderbyBroStartTime(Resource resource) {
		// TODO Auto-generated method stub
		  return getSqlMapClientTemplate().queryForList("getResourcesOrderbyBroStartTime", resource);
	}
	

	public List getResourcesOrderbyBroStartTimeLevelOne(Resource resource) {
		// TODO Auto-generated method stub
		  return getSqlMapClientTemplate().queryForList("getResourcesOrderbyBroStartTimeLevelOne", resource);
	}

    public void saveResCarrTypeRel(Map mp) {
   	    getSqlMapClientTemplate().update("updateResourceByResType", mp);
   }
    
    
	public List getResourceIdsBySortId(Map mp) {
		  return getSqlMapClientTemplate().queryForList("getResourceIdsBySortId", mp);
	}

	public List getResourceInfoForWebService(Map mp) {
		 return getSqlMapClientTemplate().queryForList("getResourceInfoForWebService", mp);
	}

	public List getStoreResourceByOrderId(Map mp) {
		 return getSqlMapClientTemplate().queryForList("getStoreResourceByOrderId", mp);
	}

	public Map getResourcesForQuery1(Map mp) {
		return getSqlMapClientTemplate().queryForMap("getResourcesForQuery1",mp,"lable");
	}
	
	public Map getResourcesForQuery1_1(Map mp) {
		return getSqlMapClientTemplate().queryForMap("getResourcesForQuery1",mp,"value3");
	}

	public List getResourcesForQuery2(Map mp) {
		return getSqlMapClientTemplate().queryForList("getResourcesForQuery2", mp);
	}

	public List getResourcesByIds(Map mp) {
		return getSqlMapClientTemplate().queryForList("getResourcesByIds", mp);
	}

	
	
	
	public List getResourceIdsByYearUser(Map mp) {
		return getSqlMapClientTemplate().queryForList("getResourceIdsByYearUser", mp);
	}

	public void removeResourceUserRate(Map mp) {
		getSqlMapClientTemplate().update("deleteResourceUserRate", mp);
	}

	public Long saveResourceUserRate(Map mp) {
		return (Long) getSqlMapClientTemplate().insert("addResourceUserRate", mp);
	}
   
	
    
}
