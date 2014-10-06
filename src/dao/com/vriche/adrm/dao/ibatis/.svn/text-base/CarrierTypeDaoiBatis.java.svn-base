
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.CarrierTypeDao;
import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.CarrierType;

import org.springframework.orm.ObjectRetrievalFailureException;

public class CarrierTypeDaoiBatis extends BaseDaoiBATIS implements CarrierTypeDao {

    /**
     * @see com.vriche.adrm.adres.dao.CarrierTypeDao#getCarrierTypes(com.vriche.adrm.adres.model.CarrierType)
     */
    public List getCarrierTypes(final CarrierType carrierType) {
          return getSqlMapClientTemplate().queryForList("getCarrierTypes", carrierType);
    }
    /**
     * @see com.vriche.adrm.adres.dao.CarrierTypeDao#getCarrierTypesByIdList(com.vriche.adrm.adres.model.CarrierType)
     */
    public List getCarrierTypesByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getCarrierTypesByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.adres.dao.CarrierTypeDao#getCarrierType(String id)
     */
    public CarrierType getCarrierType(String id) {
        CarrierType carrierType = (CarrierType) getSqlMapClientTemplate().queryForObject("getCarrierType", id);

        if (carrierType == null) {
            throw new ObjectRetrievalFailureException(CarrierType.class, id);
        }

        return carrierType;
    }

    /**
     * @see com.vriche.adrm.adres.dao.CarrierTypeDao#saveCarrierType(CarrierType carrierType)
     */    
    public Long saveCarrierType(final CarrierType carrierType) {
        Long id = carrierType.getId();
       
        // check for new record
        if (id == null || id.toString().equals("") || id.toString().equals("0") || id.toString().equals("-1")) {
            id = (Long) getSqlMapClientTemplate().insert("addCarrierType", carrierType);
        } else {
            getSqlMapClientTemplate().update("updateCarrierType", carrierType);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(CarrierType.class, id);
        }
        return id;
    }

    /**
     * @see com.vriche.adrm.adres.dao.CarrierTypeDao#removeCarrierType(String id)
     */
    public void removeCarrierType(String id) {
        getSqlMapClientTemplate().update("deleteCarrierType", id);
    }
    /**
     * @see com.vriche.adrm.adres.dao.CarrierTypeDAO#removeCarrierTypes(String ids)
     */
    public void removeCarrierTypes(final Map idList) {
        getSqlMapClientTemplate().update("deleteCarrierTypes", idList);
    }    
}
