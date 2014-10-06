
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.ProOrder;

public interface ProOrderDao extends Dao {

    /**
     * Retrieves all of the proOrders
     */
    public List getProOrders(ProOrder proOrder);
    /**
     * Retrieves all of the getProOrdersCount
     */
    
    public Integer getProOrdersCount(ProOrder proOrder); 
    
    public Integer getProOrdersCountByName(final ProOrder proOrder);
    
    public Integer getProOrdersCountBySellName(final ProOrder proOrder);
    
    public Integer getProCountByObject(ProOrder proOrder); 
    
    public Integer getProPayCountByObject(ProOrder proOrder); 
    /**
     * Retrieves all of the getProOrdersPage
     */        
    public List getProOrdersPage(ProOrder proOrder,int pageIndex,int pageSize);
    /**
     * Retrieves all of the getProOrdersSellPage
     */        
    public List getProOrdersSellPage(ProOrder proOrder,int pageIndex,int pageSize);
    /**
     * Retrieves all of the getProOrdersC
     */ 
    public List getProOrdersC(final ProOrder proOrder);
    /**
     * Retrieves all of the getProOrdersX
     */ 
    public List getProOrdersX(final ProOrder proOrder);
    /**
     * Retrieves all of the proOrdersByIdList
     */
    public List getProOrdersByMap(final Map mp);

    /**
     * Gets proOrder's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the proOrder's id
     * @return proOrder populated proOrder object
     */
    public ProOrder getProOrder(final Long id);

    /**
     * Saves a proOrder's information
     * @param proOrder the object to be saved
     */    
    public Long saveProOrder(ProOrder proOrder);
    
    public void saveProIncomePulls(ProOrder[] proOrders);

    /**
     * Removes a proOrder from the database by id
     * @param id the proOrder's id
     */
    public void removeProOrder(final Long id);
	/**
     * Removes proOrders from the database by ids
     * @param ids the proOrder's id eg:"'1','2','3'"
     */
    public void removeProOrders(final Map idList);
    
    public List getProOrderByObject(ProOrder proOrder);
    
    
}

