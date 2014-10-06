
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.SpecificDao;
import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.Specific;

import org.springframework.orm.ObjectRetrievalFailureException;

public class SpecificDaoiBatis extends BaseDaoiBATIS implements SpecificDao {

    /**
     * @see com.vriche.adrm.adres.dao.SpecificDao#getSpecifics(com.vriche.adrm.adres.model.Specific)
     */
    public List getSpecifics(final Specific specific) {
    	List ls = getSqlMapClientTemplate().queryForList("getSpecifics", specific);
    	System.out.println("sameNameIds  1111111111111111111111111111111111111111111111111 "+ls.size());
    	
          return ls;
    }
    /**
     * @see com.vriche.adrm.adres.dao.SpecificDao#getSpecificsByIdList(com.vriche.adrm.adres.model.Specific)
     */
    public List getSpecificsByIdList(final Map idList) {
    	List ls = getSqlMapClientTemplate().queryForList("getSpecificsByIdList", idList);

          return ls;
    }

    /**
     * @see com.vriche.adrm.adres.dao.SpecificDao#getSpecific(Long id)
     */
    public Specific getSpecific(Long id) {
        Specific specific = (Specific) getSqlMapClientTemplate().queryForObject("getSpecific", id);

        if (specific == null) {
            throw new ObjectRetrievalFailureException(Specific.class, id);
        }

        return specific;
    }

    /**
     * @see com.vriche.adrm.adres.dao.SpecificDao#saveSpecific(Specific specific)
     */    
    public void saveSpecific(final Specific specific) {
        Long id = specific.getId();
        // check for new record
        if (id == null) {
            id = (Long) getSqlMapClientTemplate().insert("addSpecific", specific);
        } else {
            getSqlMapClientTemplate().update("updateSpecific", specific);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(Specific.class, id);
        }
    }

    /**
     * @see com.vriche.adrm.adres.dao.SpecificDao#removeSpecific(Long id)
     */
    public void removeSpecific(Long id) {
        getSqlMapClientTemplate().update("deleteSpecific", id);
    }
    /**
     * @see com.vriche.adrm.order.dao.SpecificDAO#removeSpecifics(String ids)
     */
    public void removeSpecifics(final Map idList) {
        getSqlMapClientTemplate().update("deleteSpecifics", idList);
    }    
}
