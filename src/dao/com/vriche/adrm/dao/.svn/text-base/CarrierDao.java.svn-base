
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

//import com.vriche.adrm.adres.dao.Dao;

import com.vriche.adrm.model.Carrier;
import com.vriche.adrm.dao.Dao;

public interface CarrierDao extends Dao {

	
    /**
     * Retrieves all of the carriers
     */
    public List getCarriers(Carrier carrier);

    /**
     * Retrieves all of the carriersByIdList
     */
    public List getCarriersByIdList(final Map idList);

    /**
     * Gets carrier's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the carrier's id
     * @return carrier populated carrier object
     */
    public Carrier getCarrier(final Long id);
    
    public List getCarrierForChannel(Carrier carrier);
    
    public String getCarriersTypeXml(final String id);  
    
    
    public String getCarriersXml(final String id);  

    /**
     * Saves a carrier's information
     * @param carrier the object to be saved
     */    
    public Long saveCarrier(Carrier carrier);

    /**
     * Removes a carrier from the database by id
     * @param id the carrier's id
     */
    public void removeCarrier(final Long id);
    
 
	/**
     * Removes carriers from the database by ids
     * @param ids the carrier's id eg:"'1','2','3'"
     */
    public void removeCarriers(final Map idList);
    
    public void removeCarriers2(final Map idList);
    
    
	public List getCarriersByCarrier_TypeId(Long CarrierTypeId);
	
	public List getCarrierInfo(Map mp);
	
	public List getCarrierWithChannel(Carrier carrier);
	
	public Map getCarrierWithChannelMap(Carrier carrier);
		
}

