
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.OaDocument;
import com.vriche.adrm.model.OrderCategory;

public interface OrderCategoryDao extends Dao {

    /**
     * Retrieves all of the orderCategorys
     */
    public List getOrderCategorys(OrderCategory orderCategory);

    public List getOrderCategorysOrderList(OrderCategory orderCategory) ;
    
    public List getOrderCategorysNameList(OrderCategory orderCategory) ;
    
    public List getSameNameIdList(String name);
    
    public List getSameNameIdListByOrg(Map mp);
//    public List getCategorysIds(OrderCategory orderCategory);
    /**
     * Retrieves all of the orderCategorysByIdList
     */
    public List getOrderCategorysByIdList(final Map idList);
    
    public Integer getOrderCategorysCount(OrderCategory orderCategory);
    
    public PaginatedList getOrderCategorysPage(OrderCategory orderCategory,int pageIndex,int pageSize);
    
    public List getOrderCategorysPage2(OrderCategory orderCategory,int pageIndex,int pageSize);

    /**
     * Gets orderCategory's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the orderCategory's id
     * @return orderCategory populated orderCategory object
     */
    public OrderCategory getOrderCategory(final Long id);
    


    /**
     * Saves a orderCategory's information
     * @param orderCategory the object to be saved
     */    
    public Long saveOrderCategory(OrderCategory orderCategory);

    /**
     * Removes a orderCategory from the database by id
     * @param id the orderCategory's id
     */
    public void removeOrderCategory(final Long id);
	/**
     * Removes orderCategorys from the database by ids
     * @param ids the orderCategory's id eg:"'1','2','3'"
     */
    public void removeOrderCategorys(final Map idList);
    
    public List getOrderCategorysFromOrder(final OrderCategory orderCategory);
}

