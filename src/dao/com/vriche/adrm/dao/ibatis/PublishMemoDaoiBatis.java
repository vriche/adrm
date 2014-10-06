
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.PublishMemoDao;
import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.PublishMemo;

import org.springframework.orm.ObjectRetrievalFailureException;

public class PublishMemoDaoiBatis extends BaseDaoiBATIS implements PublishMemoDao {

    /**
     * @see com.vriche.adrm.adver.dao.PublishMemoDao#getPublishMemos(com.vriche.adrm.adver.model.PublishMemo)
     */
    public List getPublishMemos(final PublishMemo publishMemo) {
          return getSqlMapClientTemplate().queryForList("getPublishMemos", publishMemo);
    }
    /**
     * @see com.vriche.adrm.adver.dao.PublishMemoDao#getPublishMemosByIdList(com.vriche.adrm.adver.model.PublishMemo)
     */
    public List getPublishMemosByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getPublishMemosByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.adver.dao.PublishMemoDao#getPublishMemo(Long id)
     */
    public PublishMemo getPublishMemo(Long id) {
        PublishMemo publishMemo = (PublishMemo) getSqlMapClientTemplate().queryForObject("getPublishMemo", id);

        if (publishMemo == null) {
            throw new ObjectRetrievalFailureException(PublishMemo.class, id);
        }

        return publishMemo;
    }

    /**
     * @see com.vriche.adrm.adver.dao.PublishMemoDao#savePublishMemo(PublishMemo publishMemo)
     */    
    public void savePublishMemo(final PublishMemo publishMemo) {
        Long id = publishMemo.getId();
        // check for new record
        if (id == null) {
            id = (Long) getSqlMapClientTemplate().insert("addPublishMemo", publishMemo);
        } else {
            getSqlMapClientTemplate().update("updatePublishMemo", publishMemo);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(PublishMemo.class, id);
        }
    }

    /**
     * @see com.vriche.adrm.adver.dao.PublishMemoDao#removePublishMemo(Long id)
     */
    public void removePublishMemo(Long id) {
        getSqlMapClientTemplate().update("deletePublishMemo", id);
    }
    /**
     * @see com.vriche.adrm.order.dao.PublishMemoDAO#removePublishMemos(String ids)
     */
    public void removePublishMemos(final Map idList) {
        getSqlMapClientTemplate().update("deletePublishMemos", idList);
    }
	public PaginatedList getPublishMemosPage(PublishMemo publishMemo, int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getPublishMemos",publishMemo,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}
	public Integer getPublishMemosCount(PublishMemo publishMemo) {
		// TODO Auto-generated method stub
		return (Integer)getSqlMapClientTemplate().queryForObject("getPublishMemosCount", publishMemo);
	}    
}
