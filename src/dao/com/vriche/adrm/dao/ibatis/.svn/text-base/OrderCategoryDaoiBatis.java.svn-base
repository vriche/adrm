
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.OrderCategoryDao;
import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.OrderCategory;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OrderCategoryDaoiBatis extends BaseDaoiBATIS implements OrderCategoryDao {

    /* (non-Javadoc)
     * @see com.vriche.adrm.order.dao.OrderCategoryDao#getOrderCategoryLevelSecondMap(java.lang.String)
     */

    /**
     * @see com.vriche.adrm.order.dao.OrderCategoryDao#getOrderCategorys(com.vriche.adrm.order.model.OrderCategory)
     */
    public List getOrderCategorys(final OrderCategory orderCategory) {
          return getSqlMapClientTemplate().queryForList("getOrderCategorys", orderCategory);
    }
    public List getOrderCategorysFromOrder(final OrderCategory orderCategory) {
        return getSqlMapClientTemplate().queryForList("getOrderCategorysFromOrder", orderCategory);
  }  
    
    
    
    public List getOrderCategorysNameList(OrderCategory orderCategory) {
        return getSqlMapClientTemplate().queryForList("getOrderCategorysNameList", orderCategory);
  }
    
    public List getOrderCategorysOrderList(OrderCategory orderCategory) {
        return getSqlMapClientTemplate().queryForList("getOrderCategorysOrderList",orderCategory);
  }
//    public List getSameNameIdList() {
//        return getSqlMapClientTemplate().queryForList("getSameNameIdList",null);
//  }
//    public List getCategorysIds(OrderCategory orderCategory) {
//        return getSqlMapClientTemplate().queryForList("getCategorysIds",orderCategory);
//  }
    
    public List getSameNameIdList(String name) {
      return getSqlMapClientTemplate().queryForList("getSameNameIdList",name);
}
    /**
     * @see com.vriche.adrm.order.dao.OrderCategoryDao#getOrderCategorysByIdList(com.vriche.adrm.order.model.OrderCategory)
     */
    public List getOrderCategorysByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getOrderCategorysByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.order.dao.OrderCategoryDao#getOrderCategory(Long id)
     */
    public OrderCategory getOrderCategory(Long id) {
        OrderCategory orderCategory = (OrderCategory) getSqlMapClientTemplate().queryForObject("getOrderCategory", id);

        if (orderCategory == null) {
            throw new ObjectRetrievalFailureException(OrderCategory.class, id);
        }

        return orderCategory;
    }

    /**
     * @see com.vriche.adrm.order.dao.OrderCategoryDao#saveOrderCategory(OrderCategory orderCategory)
     */    
    public Long saveOrderCategory(final OrderCategory orderCategory) {
//    	System.out.println("orderCategory===ttttttttt=="+orderCategory);
        Long id = orderCategory.getId();
        
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addOrderCategory", orderCategory);
//            System.out.println("id====="+id);
        } else {
            getSqlMapClientTemplate().update("updateOrderCategory", orderCategory);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(OrderCategory.class, id);
        }
        return id;
    }

    /**
     * @see com.vriche.adrm.order.dao.OrderCategoryDao#removeOrderCategory(Long id)
     */
    public void removeOrderCategory(Long id) {
        getSqlMapClientTemplate().update("deleteOrderCategory", id);
    }
    /**
     * @see com.vriche.adrm.order.dao.OrderCategoryDAO#removeOrderCategorys(String ids)
     */
    public void removeOrderCategorys(final Map idList) {
        getSqlMapClientTemplate().update("deleteOrderCategorys", idList);
    }
	public Integer getOrderCategorysCount(OrderCategory orderCategory) {
		return (Integer)getSqlMapClientTemplate().queryForObject("getOrderCategorysCount", orderCategory);
	}
	public PaginatedList getOrderCategorysPage(OrderCategory orderCategory, int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getOrderCategorys",orderCategory,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}
	public List getOrderCategorysPage2(OrderCategory orderCategory, int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getOrderCategorys",orderCategory,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}
	public List getSameNameIdListByOrg(Map mp) {
		 return getSqlMapClientTemplate().queryForList("getSameNameIdListByOrg",mp);
		
	}    
}
