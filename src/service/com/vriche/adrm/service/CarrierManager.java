
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.CarrierDao;
import com.vriche.adrm.model.Carrier;
import com.vriche.adrm.model.Customer;
import com.vriche.adrm.model.OrderCategory;
import com.vriche.adrm.service.Manager;

public interface CarrierManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setCarrierDao(CarrierDao carrierDAO);

    /**
     * Retrieves all of the carriers
     */
    public List getCarriers(Carrier carrier);
    
    public List getCarriersForChannel(final Carrier carrier) ;
        /**
     * Retrieves all of the carriersByIdList
     */
    public List getCarriersByIdList(final Map idList);

    /**
     * Gets carrier's information based on id.
     * @param id the carrier's id
     * @return carrier populated carrier object
     */
    public Carrier getCarrier(final String id);
    
    public String getCarriersTypeXml(final String id); 
    
    public String getCarriersXml(final String id);  

    /**
     * Saves a carrier's information
     * @param carrier the object to be saved
     */
    public String saveCarrier(Carrier carrier);

    /**
     * Removes a carrier from the database by id
     * @param id the carrier's id
     */
    public void removeCarrier(final String id);
     /**
     * Removes a carrier from the database by id
     * @param idList
     */
    public void removeCarriers(final Map idList);
    
    
    public Map getCarriersAllFromMap(Carrier carrier, boolean enable,boolean needZeroId);
    
    public Map getCarrierSelect(Carrier carrier);
    public Map getCarrierSelectItemFromMap(Carrier carrier);
    public void getCarriersItemsByCarrierTypeId(StringBuffer sb,String carrierTypeId, String carrierIdPrefix,String resourceIdPrefix);
    public void getCarriersItemsByCarrierTypeIdByYear(StringBuffer sb,String carrierTypeId, String carrierIdPrefix,String resourceIdPrefix,String year,Integer resouceType,Integer orderBy);
    
    public void getCarriersItemsByCarrierTypeIdFromMapByYear(StringBuffer sb, String carrierTypeId, String carrierIdPrefix,String resourceIdPrefix,String year);
    public void getCarriersItemsByCarrierTypeIdFromMap(StringBuffer sb, String carrierTypeId, String carrierIdPrefix,String resourceIdPrefix,String publishDate,String resourceTypeId);
    public String getCarriersAdvTypeXML(Carrier carrier, String IdPrefix);
    
    public void getCarriersResourceAnalyze(StringBuffer sb,String carrierTypeId, String carrierIdPrefix,String resourceIdPrefix, String carrierId, String resourceTypeId);
    
    public String getCarrierParnet(String resourceId,int level);
    
    public void getCarriersItemsByCarrierTypeIdForArrange(StringBuffer sb, String carrierTypeId, String carrierIdPrefix,String resourceIdPrefix,String publishDate);
    
    public boolean isBuildLevel(String nodeLevel);
    
    public void getUserCarriersItemsByCarrierTypeId(StringBuffer sb,String carrierTypeId,String theUser, String carrierIdPrefix);

    public Map getCarrierSelectItemAnalyze();
    
    public List getCarrierIdLists(String carrierName,boolean channelPull,String theUser);
    
    public List getCarrierIdListsNotChilden(String carrierName,boolean channelPull,String theUser);
    
    public void getCarriersResourceAnalyzeForChannel(StringBuffer sb,String carrierTypeId,String carrierIdPrefix,String resourceIdPrefix,int channelModelParam);

    public List getOneCarrResourceiDListByCarrierId(Long carrierId,boolean isObj,String year);
    
    public void getCarriersItemsByCarrierTypeIdFromMapByYear2(StringBuffer sb, String carrierTypeId, String carrierIdPrefix,String resourceIdPrefix,String year,boolean isAccountRes);
    
    public List getOwnerCarrierIds(String carrierId,boolean channelPull,String theUser);
    
    public Map getCarrierNameMap();
    
    
    public String getCarrierTree(String theUser);
    
    public Map getCarrierSelectItemAnalyze5(String loginUser,String orgId);
    
    public Map getCarrierSelectItemAnalyze6(String theUser,String orgId);
    
    
    public void getCarriersItemsByCarrierTypeIdByYear2(StringBuffer sb, String carrierTypeId, String carrierIdPrefix, String resourceIdPrefix,String year,Integer resourceType,Integer orderBy,String displayCarModerier,boolean enable,boolean fitterCarrier,String loginUser,boolean isFineRes );

    public Map getCarrierAlisNameMap();
    
    public Map getStoreMap(Carrier carrier);
    
    public List getCarrierAlisnamesStore(Carrier carrier);
    
    public List getCarrierWithChannel(Carrier carrier);
    
			public List getCarrierWithChannel2(Carrier carrier);
			
			public Map getStoreMapCtr(Carrier carr);
			
			public List getStoreObjsCtr(Carrier carr) ;
}

