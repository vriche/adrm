
package com.vriche.adrm.dao.ibatis;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.orm.ObjectRetrievalFailureException;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.PublishArrangeDetailDao;
import com.vriche.adrm.model.PublishArrangeDetail;
import com.vriche.adrm.util.StringUtil;

public class PublishArrangeDetailDaoiBatis extends BaseDaoiBATIS implements PublishArrangeDetailDao {

    /**
     * @see com.vriche.adrm.dao.PublishArrangeDetailDao#getPublishArrangeDetails(com.vriche.adrm.model.PublishArrangeDetail)
     */
    public List getPublishArrangeDetails(final PublishArrangeDetail publishArrangeDetail) {
          return getSqlMapClientTemplate().queryForList("getPublishArrangeDetails", publishArrangeDetail);
    }
     /**
     * @see com.vriche.adrm.dao.PublishArrangeDetailDao#getPublishArrangeDetailsCount(com.vriche.adrm.model.PublishArrangeDetail)
     */
    public Integer getPublishArrangeDetailsCount(final PublishArrangeDetail publishArrangeDetail) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getPublishArrangeDetailsCount", publishArrangeDetail);
    }
     /**
     * @see com.vriche.adrm.dao.PublishArrangeDetailDao#getPublishArrangeDetailsPage(com.vriche.adrm.model.PublishArrangeDetail)
     */   
  	public PaginatedList getPublishArrangeDetailsPage(final PublishArrangeDetail publishArrangeDetail,int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getPublishArrangeDetails",publishArrangeDetail,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}  
    /**
     * @see com.vriche.adrm.dao.PublishArrangeDetailDao#getPublishArrangeDetailsByIdList(com.vriche.adrm.model.PublishArrangeDetail)
     */
    public List getPublishArrangeDetailsByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getPublishArrangeDetailsByIdList", idList);
    }
    
    /**
     * @see com.vriche.adrm.dao.PublishArrangeDetailDao#getPublishArrangeDetailsByIdLists(com.vriche.adrm.model.PublishArrangeDetail)
     */
    public List getPublishArrangeDetailsByIdLists(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getPublishArrangeDetailsByIdLists", idList);
    }
    
    /**
     * @see com.vriche.adrm.dao.PublishArrangeDetailDao#getPublishArrangeDetailsByIdLists4(com.vriche.adrm.model.PublishArrangeDetail)
     */
    public List getPublishArrangeDetailsByIdLists3(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getPublishArrangeDetailsByIdLists3", idList);
    }
    
    /**
     * @see com.vriche.adrm.dao.PublishArrangeDetailDao#getPublishArrangeDetailsByIdLists4(com.vriche.adrm.model.PublishArrangeDetail)
     */
    public List getPublishArrangeDetailsByIdLists4(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getPublishArrangeDetailsByIdLists4", idList);
    }
    
    /**
     * @see com.vriche.adrm.dao.PublishArrangeDetailDao#getPublishArrangeDetail(Long id)
     */
    public PublishArrangeDetail getPublishArrangeDetail(Long id) {
        PublishArrangeDetail publishArrangeDetail = (PublishArrangeDetail) getSqlMapClientTemplate().queryForObject("getPublishArrangeDetail", id);

        if (publishArrangeDetail == null) {
            throw new ObjectRetrievalFailureException(PublishArrangeDetail.class, id);
        }

        return publishArrangeDetail;
    }

    /**
     * @see com.vriche.adrm.dao.PublishArrangeDetailDao#savePublishArrangeDetail(PublishArrangeDetail publishArrangeDetail)
     */    
    public Long savePublishArrangeDetail(final PublishArrangeDetail publishArrangeDetail) {
        Long id = publishArrangeDetail.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addPublishArrangeDetail", publishArrangeDetail);
        } else {
            getSqlMapClientTemplate().update("updatePublishArrangeDetail", publishArrangeDetail);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(PublishArrangeDetail.class, id);
        }
        return  id;
    }

    /**
     * @see com.vriche.adrm.dao.PublishArrangeDetailDao#removePublishArrangeDetail(Long id)
     */
    public void removePublishArrangeDetail(Long id) {
        getSqlMapClientTemplate().update("deletePublishArrangeDetail", id);
    }
    /**
     * @see com.vriche.adrm.dao.PublishArrangeDetailDAO#removePublishArrangeDetails(String ids)
     */
    public void removePublishArrangeDetails(final Map idList) {
        getSqlMapClientTemplate().update("deletePublishArrangeDetails", idList);
    }
    
	public List getPublishArrangeDetailsByIdListFromHistory(Map mp) {
		 return getSqlMapClientTemplate().queryForList("getPublishArrangeDetailsByIdListFromHistory", mp);
	}
	
	public List getPublishArrangeDetailsByIdListForPublishSort(Map mp) {
		 return getSqlMapClientTemplate().queryForList("getPublishArrangeDetailsByIdListForPublishSort", mp);
	}
	
	
	public void savePublishArrangeDetails(PublishArrangeDetail publishArrangeDetails[]) {
		// TODO Auto-generated method stub
	
	}
	public void savePublishArrangeDetails(Map mp,List ids) {
		
		try {
			
			getSqlMapClientTemplate().getSqlMapClient().startBatch();
			for(Iterator it = ids.iterator();it.hasNext();){
				Long publishArrangeId = (Long)it.next();
				PublishArrangeDetail publishArrangeDetails[] = (PublishArrangeDetail[])mp.get(publishArrangeId);
				for(int i = 0 ;i<publishArrangeDetails.length;i++){
					PublishArrangeDetail publishArrangeDetail = publishArrangeDetails[i];
					publishArrangeDetail.setPublishArrangeId(publishArrangeId);
					publishArrangeDetail.setCtrBroSort(Integer.valueOf(StringUtil.null2String(publishArrangeDetail.getCtrBroSort())));
					
//					 System.out.println("savePublishArrangeDetails getMatterEdit >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+ publishArrangeDetail.getMatterEdit());
					 
					getSqlMapClientTemplate().getSqlMapClient().insert("addPublishArrangeDetail", publishArrangeDetail);
				}
			}   
//			for(Iterator it = mp.keySet().iterator();it.hasNext();){
//				Long publishArrangeId = (Long)it.next();
//				PublishArrangeDetail publishArrangeDetails[] = (PublishArrangeDetail[])mp.get(publishArrangeId);
//				for(int i = 0 ;i<publishArrangeDetails.length;i++){
//					PublishArrangeDetail publishArrangeDetail = publishArrangeDetails[i];
//					publishArrangeDetail.setPublishArrangeId(publishArrangeId);
//					getSqlMapClientTemplate().getSqlMapClient().insert("addPublishArrangeDetail", publishArrangeDetail);
//				}
//				
//			}
			
			getSqlMapClientTemplate().getSqlMapClient().executeBatch();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}
	public List getDetailidByResourceIdDate(Map idList) {
		return getSqlMapClientTemplate().queryForList("getDetailidByResourceIdDate", idList);
	}
	
	public List getArrangeIdByResourceIdDate(Map idList) {
		return getSqlMapClientTemplate().queryForList("getArrangeIdByResourceIdDate", idList);
	}
	public List getArrangedPublishForWebService(Map mp) {

		return getSqlMapClientTemplate().queryForList("getArrangedPublishForWebService", mp);
	}
	public List getArrangedPublishForBroZM(Map mp) {
		return getSqlMapClientTemplate().queryForList("getArrangedPublishForBroZM", mp);
	}
	
	
 
}
