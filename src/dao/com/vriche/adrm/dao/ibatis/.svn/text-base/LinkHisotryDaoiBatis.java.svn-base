
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.LinkHisotryDao;
import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.LinkHisotry;

import org.springframework.orm.ObjectRetrievalFailureException;

public class LinkHisotryDaoiBatis extends BaseDaoiBATIS implements LinkHisotryDao {

    /**
     * @see com.vriche.adrm.crm.dao.LinkHisotryDao#getLinkHisotrys(com.vriche.adrm.crm.model.LinkHisotry)
     */
    public List getLinkHisotrys(final LinkHisotry linkHisotry) {
          return getSqlMapClientTemplate().queryForList("getLinkHisotrys", linkHisotry);
    }
    /**
     * @see com.vriche.adrm.crm.dao.LinkHisotryDao#getLinkHisotrysByIdList(com.vriche.adrm.crm.model.LinkHisotry)
     */
    public List getLinkHisotrysByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getLinkHisotrysByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.crm.dao.LinkHisotryDao#getLinkHisotry(Long id)
     */
    public LinkHisotry getLinkHisotry(Long id) {
        LinkHisotry linkHisotry = (LinkHisotry) getSqlMapClientTemplate().queryForObject("getLinkHisotry", id);

        if (linkHisotry == null) {
            throw new ObjectRetrievalFailureException(LinkHisotry.class, id);
        }

        return linkHisotry;
    }

    /**
     * @see com.vriche.adrm.crm.dao.LinkHisotryDao#saveLinkHisotry(LinkHisotry linkHisotry)
     */    
    public void saveLinkHisotry(final LinkHisotry linkHisotry) {
        Long id = linkHisotry.getId();
//        
//        System.out.println("====linkHisotry====" + linkHisotry);
//        System.out.println("====linkHisotry.LinkUser====" + linkHisotry.getLinkUser());
//        System.out.println("====linkHisotry.Usernam====" + linkHisotry.getLinkUser().getUsername());
//        
        // check for new record
        if (id == null || id.intValue() == -1 || id.intValue() == 0) {
            id = (Long) getSqlMapClientTemplate().insert("addLinkHisotry", linkHisotry);
        } else {
        	
//        	System.out.println("====0====");
        	
            getSqlMapClientTemplate().update("updateLinkHisotry", linkHisotry);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(LinkHisotry.class, id);
        }
    }
    
    public Long saveCustomerLinkHisotryList(final LinkHisotry linkHisotry) {
        Long id = linkHisotry.getId();

        // check for new record
        if (id == null || id.intValue() == -1 || id.intValue() == 0) {
            id = (Long) getSqlMapClientTemplate().insert("addLinkHisotry", linkHisotry);
        } else {
        	
//        	System.out.println("====0====");
        	
            getSqlMapClientTemplate().update("updateLinkHisotry", linkHisotry);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(LinkHisotry.class, id);
        }
        return id;
    }

    /**
     * @see com.vriche.adrm.crm.dao.LinkHisotryDao#removeLinkHisotry(Long id)
     */
    public void removeLinkHisotry(Long id) {
        getSqlMapClientTemplate().update("deleteLinkHisotry", id);
    }
    /**
     * @see com.vriche.adrm.order.dao.LinkHisotryDAO#removeLinkHisotrys(String ids)
     */
    public void removeLinkHisotrys(final Map idList) {
        getSqlMapClientTemplate().update("deleteLinkHisotrys", idList);
    }
	public PaginatedList getLinkHisotryPage(LinkHisotry linkHisotry, int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getLinkHisotrys",linkHisotry,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}
	public Integer getLinkHisotryCount(LinkHisotry linkHisotry) {
		return (Integer) getSqlMapClientTemplate().queryForObject("getLinkHisotryCount", linkHisotry);
	}    
}
