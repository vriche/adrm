
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.BrandDao;
import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.Brand;

import org.springframework.orm.ObjectRetrievalFailureException;

public class BrandDaoiBatis extends BaseDaoiBATIS implements BrandDao {

    /**
     * @see com.vriche.adrm.adver.dao.BrandDao#getBrands(com.vriche.adrm.adver.model.Brand)
     */
    public List getBrands(final Brand brand) {
          return getSqlMapClientTemplate().queryForList("getBrands", brand);
    }
    /**
     * @see com.vriche.adrm.adver.dao.BrandDao#getBrandsByIdList(com.vriche.adrm.adver.model.Brand)
     */
    public List getBrandsByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getBrandsByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.adver.dao.BrandDao#getBrand(Long id)
     */
    public Brand getBrand(Long id) {
        Brand brand = (Brand) getSqlMapClientTemplate().queryForObject("getBrand", id);

        if (brand == null) {
            throw new ObjectRetrievalFailureException(Brand.class, id);
        }

        return brand;
    }

    /**
     * @see com.vriche.adrm.adver.dao.BrandDao#saveBrand(Brand brand)
     */    
    public void saveBrand(final Brand brand) {
        Long id = brand.getId();
        // check for new record
        if (id == null) {
            id = (Long) getSqlMapClientTemplate().insert("addBrand", brand);
        } else {
            getSqlMapClientTemplate().update("updateBrand", brand);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(Brand.class, id);
        }
    }

    /**
     * @see com.vriche.adrm.adver.dao.BrandDao#removeBrand(Long id)
     */
    public void removeBrand(Long id) {
        getSqlMapClientTemplate().update("deleteBrand", id);
    }
    /**
     * @see com.vriche.adrm.order.dao.BrandDAO#removeBrands(String ids)
     */
    public void removeBrands(final Map idList) {
        getSqlMapClientTemplate().update("deleteBrands", idList);
    }
	public PaginatedList getBrandsPage(Brand brand, int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getBrands",brand,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}
	public Integer getBrandsCount(Brand brand) {
		return (Integer)getSqlMapClientTemplate().queryForObject("getBrandsCount", brand);
	}    
}
