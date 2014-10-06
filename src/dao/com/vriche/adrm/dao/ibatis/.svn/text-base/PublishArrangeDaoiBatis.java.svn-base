
package com.vriche.adrm.dao.ibatis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ObjectRetrievalFailureException;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.PublishArrangeDao;
import com.vriche.adrm.model.PublishArrange;
import com.vriche.adrm.model.PublishedInfo;

public class PublishArrangeDaoiBatis extends BaseDaoiBATIS implements PublishArrangeDao {

    /**
     * @see com.vriche.adrm.dao.PublishArrangeDao#getPublishArranges(com.vriche.adrm.model.PublishArrange)
     */
    public List getPublishArranges(final PublishArrange publishArrange) {
          return getSqlMapClientTemplate().queryForList("getPublishArranges", publishArrange);
    }
     /**
     * @see com.vriche.adrm.dao.PublishArrangeDao#getPublishArrangesCount(com.vriche.adrm.model.PublishArrange)
     */
    public Integer getPublishArrangesCount(final PublishArrange publishArrange) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getPublishArrangesCount", publishArrange);
    }
     /**
     * @see com.vriche.adrm.dao.PublishArrangeDao#getPublishArrangesPage(com.vriche.adrm.model.PublishArrange)
     */   
  	public PaginatedList getPublishArrangesPage(final PublishArrange publishArrange,int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getPublishArranges",publishArrange,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}  
    /**
     * @see com.vriche.adrm.dao.PublishArrangeDao#getPublishArrangesByIdList(com.vriche.adrm.model.PublishArrange)
     */
    public List getPublishArrangesByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getPublishArrangesByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.dao.PublishArrangeDao#getPublishArrange(Long id)
     */
    public PublishArrange getPublishArrange(Long id) {
        PublishArrange publishArrange = (PublishArrange) getSqlMapClientTemplate().queryForObject("getPublishArrange", id);

        if (publishArrange == null) {
            throw new ObjectRetrievalFailureException(PublishArrange.class, id);
        }

        return publishArrange;
    }

    /**
     * @see com.vriche.adrm.dao.PublishArrangeDao#savePublishArrange(PublishArrange publishArrange)
     */    
    public Long savePublishArrange(final PublishArrange publishArrange) {
        Long id = publishArrange.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addPublishArrange", publishArrange);
        } else {
            getSqlMapClientTemplate().update("updatePublishArrange", publishArrange);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(PublishArrange.class, id);
        }
        return  id;
    }

    /**
     * @see com.vriche.adrm.dao.PublishArrangeDao#removePublishArrange(Long id)
     */
    public void removePublishArrange(Long id) {
        getSqlMapClientTemplate().update("deletePublishArrange", id);
    }
    /**
     * @see com.vriche.adrm.dao.PublishArrangeDAO#removePublishArranges(String ids)
     */
    public void removePublishArranges(final Map idList) {
        getSqlMapClientTemplate().update("deletePublishArranges", idList);
    }
	public List getPublishArrangesByIdListFromHistory(Map mp) {
		
			return getSqlMapClientTemplate().queryForList("getPublishArrangesByIdListFromHistory", mp);
		
	}
	
	
	public static String getNullValue(Object obj,String def) {
		try {
			String i = String.valueOf (obj);
//			i = i.equals("null")||i.equals("undefined")||i.equals("")?def:i;
			i = "null".equals(i)||"undefined".equals(i)||"".equals(i)?def:i;
			return i;
		} catch (Exception ex) {
			String j = def;
			return j;
		}
	}
	public void savePublishArrangeObjArray(PublishArrange[] objs) {
		
//		try {
//			getSqlMapClientTemplate().getSqlMapClient().startBatch();
			
			for(int i = 0 ;i<objs.length;i++){
				PublishArrange publishArrange = objs[i];
//				publishArrange.setResourceName(getNullValue(publishArrange.getResourceName(),""));
//				publishArrange.setResourceMeno(getNullValue(publishArrange.getResourceMeno(),""));
//				System.out.println(">>>>>>> savePublishArrangeObjArray 11111111111111 getResourceName>>>>>>>" + publishArrange.getResourceName()); 
				String resName = publishArrange.getResourceName();
				if("".equals(resName)) {
					publishArrange.setResourceName(" ");
				}
				
				 
				Long id = publishArrange.getId();
		        if (id == null || id.toString().equals("0")) {
		        	
		        	publishArrange.setCreateDate(new Date());
		        	publishArrange.setModifyDate(new Date());
		            id = (Long) getSqlMapClientTemplate().insert("addPublishArrange", publishArrange);

		        } else {

		            getSqlMapClientTemplate().update("updatePublishArrange", publishArrange);
		        }	

			}			
			
	}
   
	public void updatePublishArrangeLock(Map idList) {
		getSqlMapClientTemplate().update("updatePublishArrangeLock", idList);
	}
	
    /**
     * @see com.vriche.adrm.dao.PublishArrangeDao#getPublishArranges(com.vriche.adrm.model.PublishArrange)
     */
    public List getPublishArrangeIds(final Integer curDate) {
          return getSqlMapClientTemplate().queryForList("getPublishArrangeIds", curDate);
    }
    /**
     * @see com.vriche.adrm.dao.PublishArrangeDao#savePublishArrangeBak(PublishArrange publishArrange)
     */    
    public void savePublishArrangeBak(final Map idList) {
            getSqlMapClientTemplate().insert("addPublishArrangeBak", idList);
    }
    /**
     * @see com.vriche.adrm.dao.PublishArrangeDao#savePublishArrangeDetailBak(PublishArrange publishArrange)
     */    
    public void savePublishArrangeDetailBak(final Map idList) {
            getSqlMapClientTemplate().insert("addPublishArrangeDetailBak", idList);
    }
    /**
     * @see com.vriche.adrm.dao.PublishArrangeDao#savePublishArrangeBakFile(PublishArrange publishArrange)
     */    
    public void savePublishArrangeBakFile(final Map idList) {
            getSqlMapClientTemplate().insert("producePublishArrangeBak", idList);
    }
    /**
     * @see com.vriche.adrm.dao.PublishArrangeDao#savePublishArrangeDetailBakFile(PublishArrange publishArrange)
     */    
    public void savePublishArrangeDetailBakFile(final Map idList) {
            getSqlMapClientTemplate().insert("producePublishArrangeDetailBak", idList);
    }
    
    public List getPublishArrangeIdsByDateResid(final Map mp) {
        return getSqlMapClientTemplate().queryForList("getPublishArrangeIdsByDateResid", mp);
}
    
	
}
