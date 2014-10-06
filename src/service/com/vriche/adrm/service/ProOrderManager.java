
package com.vriche.adrm.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.FinanceTarget;
import com.vriche.adrm.model.FusionChartObject;
import com.vriche.adrm.model.ProCustomer;
import com.vriche.adrm.model.ProOrder;
import com.vriche.adrm.dao.ProOrderDao;

public interface ProOrderManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setProOrderDao(ProOrderDao proOrderDAO);

    /**
     * Retrieves all of the proOrders
     */
    public List getProOrders(ProOrder proOrder);
     /**
     * Retrieves all of the proOrdersCount
     */
    public String getProOrdersCount(ProOrder proOrder);
    
    /**
     * Retrieves all of the getProOrdersCountByName
     */
    public String getProOrdersCountByName(final ProOrder proOrder);
     /**
     * Retrieves all of the proOrdersCount
     */    
    public List getProOrdersPage(ProOrder proOrder,String pageIndex,String pageSize);
     /**
     * Retrieves all of the proOrdersPageXML
     */   
    public String getProOrdersPageXML(ProOrder proOrder,String pageIndex,String pageSize);
     /**
     * Retrieves all of the proOrdersByMap
     */
    public List getProOrdersByMap(final Map mp);

    /**
     * Gets proOrder's information based on id.
     * @param id the proOrder's id
     * @return proOrder populated proOrder object
     */
    public ProOrder getProOrder(final String id);
    
    /**
     * Retrieves all of the getProOrderXMLByProgramId
     */  
    public String getProOrderXMLByProgramId(ProOrder proOrder);
    
    /**
     * Saves a proOrder's information
     * @param proOrder the object to be saved
     */
    public ProOrder saveProOrder(ProOrder proOrder);
    
    /**
     * Saves a proOrder's information
     * @param proOrder the object to be saved
     */
    public ProOrder saveProOrders(ProOrder proOrder);
    
    public void saveProIncomePulls(ProOrder proOrders[]);
    /**
     * Removes a proOrder from the database by id
     * @param id the proOrder's id
     */
    public void removeProOrder(final String id);
     /**
     * Removes a proOrder from the database by id
     * @param idList
     */
    public void removeProOrders(final Map mp);
    
    public String getProOrderXML(ProOrder proOrder);
    
    public String getProOrderCodeXML(ProOrder proOrder);
    
    public String getProIncomePullCount(String customerName,String programName,String cusType,ProOrder proOrder);
    public String getProIncomePullPageXML(String customerName,String programName,String cusType,ProOrder proOrder,String pageIndex,String pageSize);
    public String getIncomePullListXML(String customerName,String programName,String cusType,ProOrder proOrder);
    public List getIncomePullList(String customerName, String programName, String cusType,ProOrder proOrder);
    
    public String getProPaymentCount(String customerName,ProOrder proOrder);
    public String getPaymentPageXML(String customerName,ProOrder proOrder,String pageIndex,String pageSize);
    public String getPaymentByCustomerXML(ProOrder proOrder);
    
    public Collection getCollections(final String queryString,String type);
    
    public FusionChartObject[] getProOrderChartObjs(String queryString);
    
    public Collection getCollectionsByPayment(final String queryString,String type);
    
    public FusionChartObject[] getProOrderChartObjsByPayment(String queryString);
    
    public Collection getCollectionsByIncomePulls(final String queryString,String type);
    
    public FusionChartObject[] getProOrderChartObjsByIncomePulls(String queryString);
}

