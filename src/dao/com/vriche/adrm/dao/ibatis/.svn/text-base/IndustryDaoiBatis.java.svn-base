
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.IndustryDao;
import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.Industry;

import org.springframework.orm.ObjectRetrievalFailureException;

public class IndustryDaoiBatis extends BaseDaoiBATIS implements IndustryDao {

    /**
     * @see com.vriche.adrm.crm.dao.IndustryDao#getIndustrys(com.vriche.adrm.crm.model.Industry)
     */
    public List getIndustrys(final Industry industry) {
          return getSqlMapClientTemplate().queryForList("getIndustrys", industry);
    }
    
    
    public Integer getIndustrysCount(Industry industry) {
    	 return (Integer)getSqlMapClientTemplate().queryForObject("getIndustrysCount", industry);
	}

    

	public PaginatedList getIndustrysPage(Industry industry,int pageSize) {
		return getSqlMapClientTemplate().queryForPaginatedList("getIndustrys",industry,pageSize);
	}


	/**
     * @see com.vriche.adrm.crm.dao.IndustryDao#getIndustrysByIdList(com.vriche.adrm.crm.model.Industry)
     */
    public List getIndustrysByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getIndustrysByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.crm.dao.IndustryDao#getIndustry(Long id)
     */
    public Industry getIndustry(Long id) {
        Industry industry = (Industry) getSqlMapClientTemplate().queryForObject("getIndustry", id);

        if (industry == null) {
            throw new ObjectRetrievalFailureException(Industry.class, id);
        }

        return industry;
    }

    /**
     * @see com.vriche.adrm.crm.dao.IndustryDao#saveIndustry(Industry industry)
     */    
    public void saveIndustry(final Industry industry) {
//    	System.out.println("industry==="+industry);
        Long id = industry.getId();
        // check for new record
        if (id == null) {
//        	System.out.println("id==="+id);
            id = (Long) getSqlMapClientTemplate().insert("addIndustry", industry);
        } else {
            getSqlMapClientTemplate().update("updateIndustry", industry);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(Industry.class, id);
        }
    }

    /**
     * @see com.vriche.adrm.crm.dao.IndustryDao#removeIndustry(Long id)
     */
    public void removeIndustry(Long id) {
        getSqlMapClientTemplate().update("deleteIndustry", id);
    }
    /**
     * @see com.vriche.adrm.order.dao.IndustryDAO#removeIndustrys(String ids)
     */
    public void removeIndustrys(final Map idList) {
        getSqlMapClientTemplate().update("deleteIndustrys", idList);
    }    
}
