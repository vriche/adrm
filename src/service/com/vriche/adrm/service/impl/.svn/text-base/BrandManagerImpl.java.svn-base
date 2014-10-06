
package com.vriche.adrm.service.impl;

import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.BrandDao;
import com.vriche.adrm.model.Brand;
import com.vriche.adrm.service.BrandManager;
import com.vriche.adrm.service.impl.BaseManager;

public class BrandManagerImpl extends BaseManager implements BrandManager {
    private BrandDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setBrandDao(BrandDao dao) {
        this.dao = dao;
    }

    /**
     * @see com.vriche.adrm.adver.service.BrandManager#getBrandsByIdList(final Map idList)
     */
    public List getBrandsByIdList(final Map idList) {
        return dao.getBrandsByIdList(idList);
    }
   /**
     * @see com.vriche.adrm.adver.service.BrandManager#getBrands(com.vriche.adrm.adver.model.Brand)
     */
    public List getBrands(final Brand brand) {
        return dao.getBrands(brand);
    }

    /**
     * @see com.vriche.adrm.adver.service.BrandManager#getBrand(String id)
     */
    public Brand getBrand(final String id) {
        return dao.getBrand(new Long(id));
    }

    /**
     * @see com.vriche.adrm.adver.service.BrandManager#saveBrand(Brand brand)
     */
    public void saveBrand(Brand brand) {
        dao.saveBrand(brand);
    }

    /**
     * @see com.vriche.adrm.adver.service.BrandManager#removeBrand(String id)
     */
    public void removeBrand(final String id) {
        dao.removeBrand(new Long(id));
    }

     /**
     * @see com.vriche.adrm.adver.service.BrandManager#removeBrands(String Map)
     */
    public void removeBrands(final Map idList) {
        dao.removeBrands(idList);
    }

	public PaginatedList getBrandsPage(Brand brand, String pageIndex, String pageSize) {
		// TODO Auto-generated method stub
		return dao.getBrandsPage(brand,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}

	public String getBrandsCount(Brand brand) {
		// TODO Auto-generated method stub
		return dao.getBrandsCount(brand).toString();
	}    
}
