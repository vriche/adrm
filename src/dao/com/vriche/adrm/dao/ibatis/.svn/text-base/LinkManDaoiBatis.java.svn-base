
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.LinkManDao;
import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.LinkMan;

import org.springframework.orm.ObjectRetrievalFailureException;

public class LinkManDaoiBatis extends BaseDaoiBATIS implements LinkManDao {

    /**
     * @see com.vriche.adrm.crm.dao.LinkManDao#getLinkMans(com.vriche.adrm.crm.model.LinkMan)
     */
    public List getLinkMans(final LinkMan linkMan) {
          return getSqlMapClientTemplate().queryForList("getLinkMans", linkMan);
    }
    /**
     * @see com.vriche.adrm.crm.dao.LinkManDao#getLinkMansByIdList(com.vriche.adrm.crm.model.LinkMan)
     */
    public List getLinkMansByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getLinkMansByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.crm.dao.LinkManDao#getLinkMan(Long id)
     */
    public LinkMan getLinkMan(Long id) {
        LinkMan linkMan = (LinkMan) getSqlMapClientTemplate().queryForObject("getLinkMan", id);

        if (linkMan == null) {
            throw new ObjectRetrievalFailureException(LinkMan.class, id);
        }

        return linkMan;
    }

    /**
     * @see com.vriche.adrm.crm.dao.LinkManDao#saveLinkMan(LinkMan linkMan)
     */    
    public void saveLinkMan(final LinkMan linkMan) {
        Long id = linkMan.getId();
        // check for new record
                
        if (id == null|| id.intValue() == -1 || id.intValue() == 0) {
            id = (Long) getSqlMapClientTemplate().insert("addLinkMan", linkMan);
        } else {
            getSqlMapClientTemplate().update("updateLinkMan", linkMan);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(LinkMan.class, id);
        }
    }
    
    public Long saveCustomerLinkMan(LinkMan linkMan){
        Long id = linkMan.getId();
        // check for new record
                
        if (id == null|| id.intValue() == -1 || id.intValue() == 0) {
            id = (Long) getSqlMapClientTemplate().insert("addLinkMan", linkMan);
        } else {
            getSqlMapClientTemplate().update("updateLinkMan", linkMan);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(LinkMan.class, id);
        }
        return id;
    }

    /**
     * @see com.vriche.adrm.crm.dao.LinkManDao#removeLinkMan(Long id)
     */
    public void removeLinkMan(Long id) {
        getSqlMapClientTemplate().update("deleteLinkMan", id);
    }
    /**
     * @see com.vriche.adrm.order.dao.LinkManDAO#removeLinkMans(String ids)
     */
    public void removeLinkMans(final Map idList) {
        getSqlMapClientTemplate().update("deleteLinkMans", idList);
    }
	public PaginatedList getLinkManPage(LinkMan linkMan, int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getLinkMans",linkMan,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}
	public Integer getLinkManCount(LinkMan linkMan) {
		return (Integer) getSqlMapClientTemplate().queryForObject("getLinkManCount", linkMan);
	}
	public void resetMainLinkMan(Long cusId) {
		getSqlMapClientTemplate().update("updateMainLinkMan", cusId);
	}    
}
