
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.BrandDao;
import com.vriche.adrm.model.Brand;
import com.vriche.adrm.service.Manager;

public interface BrandManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setBrandDao(BrandDao brandDAO);

    /**
     * Retrieves all of the brands
     */
    public List getBrands(Brand brand);
    
    public PaginatedList getBrandsPage(Brand brand,String pageIndex,String pageSize);
    
    public String getBrandsCount(Brand brand);
        /**
     * Retrieves all of the brandsByIdList
     */
    public List getBrandsByIdList(final Map idList);

    /**
     * Gets brand's information based on id.
     * @param id the brand's id
     * @return brand populated brand object
     */
    public Brand getBrand(final String id);
    
  
    /**
     * Saves a brand's information
     * @param brand the object to be saved
     */
    public void saveBrand(Brand brand);

    /**
     * Removes a brand from the database by id
     * @param id the brand's id
     */
    public void removeBrand(final String id);
     /**
     * Removes a brand from the database by id
     * @param idList
     */
    public void removeBrands(final Map idList);
    
    public void saveBrandHelpCode();
}

