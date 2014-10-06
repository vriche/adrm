
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.PriceRegularDao;
import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.PriceRegular;

import org.springframework.orm.ObjectRetrievalFailureException;

public class PriceRegularDaoiBatis extends BaseDaoiBATIS implements PriceRegularDao {

    /**
     * @see com.vriche.adrm.adres.dao.PriceRegularDao#getPriceRegulars(com.vriche.adrm.adres.model.PriceRegular)
     */
    public List getPriceRegulars(final PriceRegular priceRegular) {
          return getSqlMapClientTemplate().queryForList("getPriceRegulars", priceRegular);
    }
    /**
     * @see com.vriche.adrm.adres.dao.PriceRegularDao#getPriceRegularsByIdList(com.vriche.adrm.adres.model.PriceRegular)
     */
    public List getPriceRegularsByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getPriceRegularsByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.adres.dao.PriceRegularDao#getPriceRegular(Long id)
     */
    public PriceRegular getPriceRegular(Long id) {
        PriceRegular priceRegular = (PriceRegular) getSqlMapClientTemplate().queryForObject("getPriceRegular", id);

        if (priceRegular == null) {
            throw new ObjectRetrievalFailureException(PriceRegular.class, id);
        }

        return priceRegular;
    }

    /**
     * @see com.vriche.adrm.adres.dao.PriceRegularDao#savePriceRegular(PriceRegular priceRegular)
     */    
    public void savePriceRegular(final PriceRegular priceRegular) {
        Long id = priceRegular.getId();
        // check for new record
        if (id == null) {
            id = (Long) getSqlMapClientTemplate().insert("addPriceRegular", priceRegular);
        } else {
            getSqlMapClientTemplate().update("updatePriceRegular", priceRegular);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(PriceRegular.class, id);
        }
    }

    /**
     * @see com.vriche.adrm.adres.dao.PriceRegularDao#removePriceRegular(Long id)
     */
    public void removePriceRegular(Long id) {
        getSqlMapClientTemplate().update("deletePriceRegular", id);
    }
    /**
     * @see com.vriche.adrm.order.dao.PriceRegularDAO#removePriceRegulars(String ids)
     */
    public void removePriceRegulars(final Map idList) {
        getSqlMapClientTemplate().update("deletePriceRegulars", idList);
    }
	public PriceRegular getPriceRegular(final PriceRegular priceRegular) {
		return  (PriceRegular) getSqlMapClientTemplate().queryForObject("getPriceRegular", priceRegular);
	}    
}
