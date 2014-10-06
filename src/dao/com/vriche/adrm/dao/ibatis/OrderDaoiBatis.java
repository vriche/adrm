
package com.vriche.adrm.dao.ibatis;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ObjectRetrievalFailureException;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.OrderDao;
import com.vriche.adrm.model.Order;
import com.vriche.adrm.model.OrderPublic;

public class OrderDaoiBatis extends BaseDaoiBATIS implements OrderDao {

	
    /**
     * @see com.vriche.adrm.order.dao.OrderDao#getOrders(com.vriche.adrm.order.model.Order)
     */
    public List getOrders(final Order order) {
          return getSqlMapClientTemplate().queryForList("getOrders", order);
    }
    
    public List getOrderForReport(final Order order) {
        return getSqlMapClientTemplate().queryForList("getOrderForReport", order);
  }
    
    public PaginatedList getOrdersPage(final Order order,int pageIndex,int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getOrders",order,pageSize);
	     pageList.gotoPage(pageIndex-1);
	    
		 return pageList;
	}

	public Integer getOrdersCount(Order order) {
		 return (Integer)getSqlMapClientTemplate().queryForObject("getOrdersCount", order);
	}   
    
//	public PaginatedList getOrdersPageByUsers(Map mp, int pageIndex, int pageSize) {
//	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getOrdersPageByUsers",mp,pageSize);
//	   	 pageList.gotoPage(pageIndex-1);
//		 return pageList;   
//	}
	

	public List getOrdersPageByUsers(Map mp, int skip, int pageSize) {
//		 int skip = pageIndex * pageSize;
		 if(pageSize == -1){
			 return getSqlMapClientTemplate().queryForList("getOrdersPageByUsers",mp);
		 }else{
			 return getSqlMapClientTemplate().queryForList("getOrdersPageByUsers",mp,skip,pageSize);
		 }
	}	
	
	public Map getOrdersPageByUsersForRelPayInDate(Map mp) {
		 return getSqlMapClientTemplate().queryForMap("getOrdersPageByUsersForRelPayIndate",mp,"id");
	}	
	
	
	
	public List getOrderListPage(Map mp) {
		 return getSqlMapClientTemplate().queryForList("getOrdersPageByUsers",mp);
	}	
	
	public List getOrdersForReport(Map mp) {
	   	 List pageList = getSqlMapClientTemplate().queryForList("getOrdersForReport",mp);
		 return pageList;   
	}
	
	public Integer getOrdersPageByUsersCount(Map mp) {
//		List ls = getSqlMapClientTemplate().queryForList("getOrdersPageByUsersCount", mp);
//		return new Integer(ls.size());
		return (Integer)getSqlMapClientTemplate().queryForObject("getOrdersPageByUsersCount", mp);
//		return new Integer(String.valueOf(getSqlMapClientTemplate().queryForList("getOrdersPageByUsersCount", mp).size()));
		
	}	
	
	public List getOrdersPageByUsersCount2(Map mp) {
//		List ls = getSqlMapClientTemplate().queryForList("getOrdersPageByUsersCount", mp);
//		return new Integer(ls.size());
//		return (Integer)getSqlMapClientTemplate().queryForObject("getOrdersPageByUsersCount", mp);
//		PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getOrdersPageByUsersCount",mp,18);
		
//		System.out.println("pageList>>>>>>>>   "+ pageList.size() +" ");
		
		return getSqlMapClientTemplate().queryForList("getOrdersPageByUsersCount2", mp);
	}
	
    
    /* (non-Javadoc)
	 * @see com.vriche.adrm.dao.OrderDao#getOrderIdsByWorkFlowId(java.util.Map)
	 */
	public List getOrderIdsByWorkFlowId(Map mp) {
		return getSqlMapClientTemplate().queryForList("getOrderIdsByWorkFlowId", mp);
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.dao.OrderDao#getOrdersByUsers(java.util.Map)
	 */
	public List getOrdersByUsers(Map mp) {
		return getSqlMapClientTemplate().queryForList("getOrdersByUsers", mp);
	}
	


	/* (non-Javadoc)
	 * @see com.vriche.adrm.dao.OrderDao#getOrdersByWorkFlowId(java.util.Map)
	 */
	public List getOrdersByWorkFlowId(Map mp) {
		return getSqlMapClientTemplate().queryForList("getOrdersByWorkFlowId", mp);
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.dao.OrderDao#getOrdersByIdListCount(java.util.Map)
	 */
	public Integer getOrdersByIdListCount(Map idList) {
		return (Integer)getSqlMapClientTemplate().queryForObject("getOrdersByIdListCount", idList);
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.dao.OrderDao#getOrdersByIdList(java.util.Map, int, int)
	 */
	public List getOrdersByIdList(Map idList, int pageIndex, int pageSize) {
//		 int skip = (pageIndex-1) * pageSize;
		 int skip = (pageIndex) * pageSize;
		 int max =  pageSize;
		 return getSqlMapClientTemplate().queryForList("getOrdersByIdList",idList,skip,max);  
	}


	/**
     * @see com.vriche.adrm.order.dao.OrderDao#getOrdersByIdList(com.vriche.adrm.order.model.Order)
     */
    public List getOrdersByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getOrdersByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.order.dao.OrderDao#getOrder(Long id)
     */
    public Order getOrder(Long id) {
    	
//    	 long start1 = System.currentTimeMillis();
        Order order = (Order) getSqlMapClientTemplate().queryForObject("getOrder", id);
//        long end1 = System.currentTimeMillis();
//        System.out.println("1111111111>>>>>>>>   "+ (end1 -start1) +"√Î");
        

        if (order == null) {
            logger.warn("uh oh, order not found...");
            throw new ObjectRetrievalFailureException(Order.class, id);
        }else{
//            List orderDetails = getSqlMapClientTemplate().queryForList("getOrderDetailByOrderId",id);
//            order.setOrderDetails(new HashSet(orderDetails));
//            
//            List payments = getSqlMapClientTemplate().queryForList("getPaymentsByOrderId",id);
//            order.setContractPayments(new HashSet(payments));
//            
//            List orderLogs = getSqlMapClientTemplate().queryForList("getOrderLogsByOrderId",id);
//            order.setOrderLogs(new HashSet(orderLogs));
            
        }

        return order;
    }
    
    public Order getOrderForEdit(Long id) {
    	 return (Order) getSqlMapClientTemplate().queryForObject("getOrderForEdit", id);
    }
    
    
    
    public OrderPublic getOrderPublic(Long orderId) {
    	return  (OrderPublic) getSqlMapClientTemplate().queryForObject("getOrderPublic-from-orderDayInfo", orderId);
    }
      
    

    /**
     * @see com.vriche.adrm.order.dao.OrderDao#saveOrder(Order order)
     */    
    public Long saveOrder(final Order order) {
        Long id = order.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addOrder", order);
        } else {
            getSqlMapClientTemplate().update("updateOrder", order);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(Order.class, id);
        }

        return id;
    }

    /**
     * @see com.vriche.adrm.order.dao.OrderDao#removeOrder(Long id)
     */
    public void removeOrder(Long id) {
        getSqlMapClientTemplate().update("deleteOrder", id);
    }
    /**
     * @see com.vriche.adrm.order.dao.OrderDAO#removeOrders(String ids)
     */
    public void removeOrders(final Map idList) {
        getSqlMapClientTemplate().update("deleteOrders", idList);
    }

	/* (non-Javadoc)
	 * @see com.vriche.adrm.dao.OrderDao#updateOrderStates(java.util.Map)
	 */
	public void updateOrderStates(Map idList) {
		getSqlMapClientTemplate().update("updateOrderStates", idList);
	}

	public Integer getOrdersByCheckState(String checkState){
		return (Integer)getSqlMapClientTemplate().queryForObject("getOrdersByCheckState",checkState);
	}

	public List getOrderIdsByState4(Map mp) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getOrderIdsByState4", mp);
    }

	public List getSpecificInfo(Map mp) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getResourceSpecificInfo", mp);
	}

	public List getOrdersPageByUserSum(Map mp) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getOrdersPageByUserSum",mp);
	}

	public Integer getOrdersByCheckState2(Map mp) {
		
		return (Integer)getSqlMapClientTemplate().queryForObject("getOrdersByCheckState2",mp);
	}

	public List getOrderCodeByCheckState1(Map mp) {
		
		return getSqlMapClientTemplate().queryForList("getOrderCodeByCheckState1",mp);
	}

	public List getOrderSignUsersForOpenFire(Map mp) {
		return getSqlMapClientTemplate().queryForList("getOrderSignUsersForOpenFire",mp);
	}

	public List getCustomersByLoginUser(Map mp) {
		
		return getSqlMapClientTemplate().queryForList("getCustomersByLoginUser",mp);
	}

	public List getCustomerFromIncomeNoInORrder(){
		return getSqlMapClientTemplate().queryForList("getCustomerFromIncomeNoInORrder", null);
	}

	public Order getOrderCopy(Long id) {
		return (Order)getSqlMapClientTemplate().queryForObject("getOrdersCopy",id);
	}


	
	
    public Long saveOrderCopy(final Order order) {
        Long id = order.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addOrderCopy", order);
        } 
        if( id == null ) {
            throw new ObjectRetrievalFailureException(Order.class, id);
        }

        return id;
    }

	public void saveOrderMemo(Map mp) {
		 getSqlMapClientTemplate().update("updateOrderMemo", mp);
	}
}
