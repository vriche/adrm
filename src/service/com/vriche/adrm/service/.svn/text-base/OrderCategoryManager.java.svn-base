
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.OrderCategoryDao;
import com.vriche.adrm.model.OaDocument;
import com.vriche.adrm.model.OaDocumentCatalog;
import com.vriche.adrm.model.OrderCategory;
import com.vriche.adrm.model.TreeNode;
import com.vriche.adrm.service.Manager;

public interface OrderCategoryManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setOrderCategoryDao(OrderCategoryDao orderCategoryDAO);

    /**
     * Retrieves all of the orderCategorys
     */
    public List getOrderCategorys(OrderCategory orderCategory);
    
    public String getOrderCategorysCount(OrderCategory orderCategory);
    
    public PaginatedList getOrderCategorysPage(OrderCategory orderCategory,String pageIndex,String pageSize);
        /**
     * Retrieves all of the orderCategorysByIdList
     */
    public List getOrderCategorysByIdList(final Map idList);

    /**
     * Gets orderCategory's information based on id.
     * @param id the orderCategory's id
     * @return orderCategory populated orderCategory object
     */
    public OrderCategory getOrderCategory(final String id);

    /**
     * Saves a orderCategory's information
     * @param orderCategory the object to be saved
     */
    public String saveOrderCategory(OrderCategory orderCategory);

    /**
     * Removes a orderCategory from the database by id
     * @param id the orderCategory's id
     */
    public void removeOrderCategory(final String id);
     /**
     * Removes a orderCategory from the database by id
     * @param idList
     */
    public void removeOrderCategorys(final Map idList);
    
    public Map getOrderCategorySelect(OrderCategory orderCategory);
    
    public String getOrderCategoryXML(OrderCategory orderCategory, String IdPrefix);
    
    public Map getOrderCategorySelectFromMap(OrderCategory orderCategory);
    
    public Map getOrderCategorySelectOrderList(String orgId,String version);
    
    public Map getOrderCategorySelectParentFromMap(OrderCategory orderCategory);
    
    public List getStore(OrderCategory orderCategory);
    
    public Map getOrderCategoryFromOrder(OrderCategory category);
    
    public List getOrderCategorySelectFromMap5(OrderCategory orderCategory);
    
    public List getTreeForJosin(TreeNode node,OrderCategory orderCategory);
    
    
    public List getOrderCategorysPage2(OrderCategory orderCategory, String pageIndex, String pageSize);
    
}

