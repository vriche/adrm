
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.PriceTypeDao;
import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.PriceType;

import org.springframework.orm.ObjectRetrievalFailureException;

public class PriceTypeDaoiBatis extends BaseDaoiBATIS implements PriceTypeDao {

    /**
     * @see com.vriche.adrm.adres.dao.PriceTypeDao#getPriceTypes(com.vriche.adrm.adres.model.PriceType)
     */
    public List getPriceTypes(final PriceType priceType) {
          return getSqlMapClientTemplate().queryForList("getPriceTypes", priceType);
    }
    /**
     * @see com.vriche.adrm.adres.dao.PriceTypeDao#getPriceTypesByIdList(com.vriche.adrm.adres.model.PriceType)
     */
    public List getPriceTypesByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getPriceTypesByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.adres.dao.PriceTypeDao#getPriceType(Long id)
     */
    public PriceType getPriceType(Long id) {
        PriceType priceType = (PriceType) getSqlMapClientTemplate().queryForObject("getPriceType", id);

        if (priceType == null) {
            throw new ObjectRetrievalFailureException(PriceType.class, id);
        }

        return priceType;
    }

    /**
     * @see com.vriche.adrm.adres.dao.PriceTypeDao#savePriceType(PriceType priceType)
     */    
    public void savePriceType(final PriceType priceType) {
        Long id = priceType.getId();
        // check for new record
        if (id == null) {
            id = (Long) getSqlMapClientTemplate().insert("addPriceType", priceType);
        } else {
            getSqlMapClientTemplate().update("updatePriceType", priceType);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(PriceType.class, id);
        }
    }

    /**
     * @see com.vriche.adrm.adres.dao.PriceTypeDao#removePriceType(Long id)
     */
    public void removePriceType(Long id) {
        getSqlMapClientTemplate().update("deletePriceType", id);
    }
    /**
     * @see com.vriche.adrm.adres.dao.PriceTypeDAO#removePriceTypes(String ids)
     */
    public void removePriceTypes(final Map idList) {
        getSqlMapClientTemplate().update("deletePriceTypes", idList);
    }    
}
