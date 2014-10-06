
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.PriceDao;
import com.vriche.adrm.model.Price;

public interface PriceManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setPriceDao(PriceDao priceDAO);

    /**
     * Retrieves all of the prices
     */
    public List getPrices(Price price);
    
    
    
    public List getPricesByResourceId(final String id);
    
    
    public List getPriceDetailByPriceId(final String id);
        /**
     * Retrieves all of the pricesByIdList
     */
    public List getPricesByIdList(final Map idList);

    /**
     * Gets price's information based on id.
     * @param id the price's id
     * @return price populated price object
     */
    public Price getPrice(final String id);
    
    /**
     * Gets price's information based on id.
     * @param id the price's id
     * @return price populated price object
     */
//    public Price getPrice(final String id);

    /**
     * Saves a price's information
     * @param price the object to be saved
     */
    public String savePrice(Price price);

    public void removeResourcePriceRel(final String id,final String resourceId);
    
    public void saveResourcePriceRel(String resourceId,String priceId);
    
    /**
     * Removes a price from the database by id
     * @param id the price's id
     */
    public void removePrice(final String id);
     /**
     * Removes a price from the database by id
     * @param idList
     */
    public void removePrices(final Map idList);
    
    public Map getPricesByResourceInfoAndLength(Long id, String adLength);
    
    public Map makeSelectItemAnalyze(Price price);
    
    public String savePriceByCompage(Price price);
    
    public Double getSysPriceByResId(Long id, String adLength,Long resourcePriceId) throws PriceExistsException,DataAccessException;
    
    public void removeCompagesPrice(final String id);
    
    public PaginatedList getPricePageByResoruceId(String resId, String pageIndex, String pageSize);
    
	public String getPriceCountByResoruceId(String id);
    
	
	public Map getPricesForImport(Price pric);
}

