
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.Brand;
  
public interface BrandDao extends Dao {

    /**
     * Retrieves all of the brands
     */
    public List getBrands(Brand brand);

    /**
     * Retrieves all of the brandsByIdList
     */
    public List getBrandsByIdList(final Map idList);

    /**
     * Gets brand's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the brand's id
     * @return brand populated brand object
     */
    public Brand getBrand(final Long id);

    /**
     * Saves a brand's information
     * @param brand the object to be saved
     */    
    public void saveBrand(Brand brand);

    /**
     * Removes a brand from the database by id
     * @param id the brand's id
     */
    public void removeBrand(final Long id);
	/**
     * Removes brands from the database by ids
     * @param ids the brand's id eg:"'1','2','3'"
     */
    public void removeBrands(final Map idList);
    
    public PaginatedList getBrandsPage(Brand brand,int pageIndex,int pageSize);
    
    public Integer getBrandsCount(Brand brand);
}

