package com.vriche.adrm.dao.ibatis;

import java.util.List;

import com.vriche.adrm.dao.LookupDao;
import com.vriche.adrm.model.Branch;

/**
 * iBatis implementation of LookupDao.
 *
 * <p><a href="LookupDaoiBatis.java.html"><i>View Source</i></a></p>
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public class LookupDaoiBatis extends BaseDaoiBATIS implements LookupDao {

    /**
     * @see com.vriche.adrm.order.dao.LookupDao#getRoles()
     */
    public List getRoles() {
        logger.debug("retrieving all role names...");

        return getSqlMapClientTemplate().queryForList("getRoles", null);
    }
    
	/* (non-Javadoc)
	 * @see com.vriche.adrm.order.dao.LookupDao#getBranchs()
	 */
	public List getBranchs() {
        logger.debug("retrieving all branch names...");
        return getSqlMapClientTemplate().queryForList("getAllBranchs", null);

	}
}
