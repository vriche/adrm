
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.Price;

public interface PriceDao extends Dao {

    /**
     * Retrieves all of the prices
     */
    public List getPrices(Price price);
    
    public List getPricesByResourceId(final Long id);
    
//    public Double getSysPriceByResId(Map mp);
    
    public List getPriceDetailByPriceId(final Long id);
        

    /**
     * Retrieves all of the pricesByIdList
     */
    public List getPricesByIdList(final Map idList);

    /**
     * Gets price's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the price's id
     * @return price populated price object
     */
    public Price getPrice(final Long id);
    


    /**
     * Saves a price's information
     * @param price the object to be saved
     */    
    public Long savePrice(Price price);
    
    public Long savePriceByCompage(Price price);

    /**
     * Removes a price from the database by id
     * @param id the price's id
     */
    public void removePrice(final Long id);
	/**
     * Removes prices from the database by ids
     * @param ids the price's id eg:"'1','2','3'"
     */
    public void removePrices(final Map idList);
    
    public void removePricesResRel(final Map idList);
    
    
    
    public List getPricesByResourceInfoAndLength(final Long id,String adLength);
    
    public List getPricesCompagesByResSysPrice(final Map map);
    
    public List getPriceByCompages(final Long id,String adLength,Long priceTypeId);
    
    public Double getPriceByCompages2(final Long id,String adLength,String priceTypeId);
    
    
    public List getPricesByCompagesId(final Long compagesId);
    
    public Double getPriceByResourceIdAndLength(final Long id,String adLength,Long resourcePriceId);
    
    public Long getPriceDetailIdByCompagesIdAndLength(final Long compagesId,String adLength);
    
    public void removeCompagesPrice(Long id);
    public void removePriceAndPriceDetailRel(Long id);
    public void removePriceByPriceId(final Long id);
    
    
    public PaginatedList getPricePageByResoruceId(final Long resId, int pageIndex, int pageSize);
    
	public Integer getPriceCountByResoruceId(String id);
	
	public void saveResourcePriceRel(String resourceId,String priceId);
	
	public void removeResourcePriceRel(Long priceId,Long resourceId);
	
	public List getPricesForImport(Price price);
	
	public Map getPriceResRelMap(String sourYear);
	
	public Map getPriceResRelMapForCopyRes(String sourYear);
	
	public void savePriceDeatilRel(String priceId,String priceDetailId);
	
}

