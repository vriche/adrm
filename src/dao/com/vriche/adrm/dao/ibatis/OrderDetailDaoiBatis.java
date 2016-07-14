
package com.vriche.adrm.dao.ibatis;


import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ObjectRetrievalFailureException;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.OrderDetailDao;
import com.vriche.adrm.model.OrderDetail;
//import com.vriche.adrm.util.OrderLogUtil;

 
public class OrderDetailDaoiBatis extends BaseDaoiBATIS implements OrderDetailDao {
	
    public void saveOrderDetailPublicInfo(Map mp) {
    	getSqlMapClientTemplate().update("updateOrderDetail_public_info", mp); 
    }   
	public void saveOrderDetailPublicInfoMoneyIn(Map mp) {
		try {
			getSqlMapClientTemplate().getSqlMapClient().startBatch();
			
			for(Iterator it = mp.keySet().iterator();it.hasNext();){
				OrderDetail orderDetail = new OrderDetail();
				Long  id = (Long)it.next();
				Double moneyIn = (Double)mp.get(id);
				moneyIn = moneyIn == null?new Double(0):moneyIn;
				orderDetail.setId(id);
				orderDetail.setMoneyIn(moneyIn);
//				System.out.println("orderDetail——id>>>>>>>>>>>>"+ id.toString());
//				System.out.println("orderDetail——moneyIn>>>>>>>>>>>>"+ moneyBalance.toString());
				getSqlMapClientTemplate().getSqlMapClient().update("updateOrderDetail_public_moneyin", orderDetail);
			}
			
			getSqlMapClientTemplate().getSqlMapClient().executeBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}   
	
	
	public void saveOrderDetailRate(List ls) {
		try {
			getSqlMapClientTemplate().getSqlMapClient().startBatch();
			
			for(Iterator it = ls.iterator();it.hasNext();){
				OrderDetail orderDetail = (OrderDetail)it.next();
				getSqlMapClientTemplate().getSqlMapClient().update("updateOrderDetail_rate", orderDetail);
			}
			
			getSqlMapClientTemplate().getSqlMapClient().executeBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}  	
	
	
	
	
	public void saveOrderDetailCheckState(Map mp) {

				getSqlMapClientTemplate().update("updateOrderDetailCheckState", mp); 

		
	}  
	
	
    /*
     * (non-Javadoc)
     * 
     * @see com.vriche.adrm.order.dao.OrderDetailDao#getOrderDetailByOrderId(java.lang.Long)
     */
    public List getOrderDetailByOrderId(Long id) {
        return getSqlMapClientTemplate().queryForList("getOrderDetailByOrderId", id);
    }
    
    public List getOrderDetailByMap(Map mp) {
        return getSqlMapClientTemplate().queryForList("getOrderDetailByOrderId", mp);
    }
    
    public Integer getOrderDetailByResourceType(Map mp) {
        return (Integer)getSqlMapClientTemplate().queryForObject("getOrderDetailByResourceType", mp);
    }
    
    public PaginatedList getOrderDetailByOrderIdPage(Long id,int pageIndex, int pageSize) {
    	 
    	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getOrderDetailByOrderId",id,pageSize);
         pageList.gotoPage(pageIndex-1);
    	 return pageList;
	}

	public List getOrderDetailsPage(OrderDetail orderDetail, int pageIndex, int pageSize) {
		 int skip = pageIndex * pageSize;
		 int max =  pageSize;
//		 System.out.println("skip>>>>>>>>>>>>"+ skip);
//		 System.out.println("max>>>>>>>>>>>>"+ max);
	     List pageList = getSqlMapClientTemplate().queryForList("getOrderDetails",orderDetail,skip,max);  
	   	 
//	   	 System.out.println("getOrderDetailsPage pageList.size()>>>>>>>>>>>>"+ pageList.size());
//	   	 System.out.println("orderDetail paramObj >>>>>>>>>>>>"+ orderDetail.toString());
	   	 
//	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}
	

	public List getOrderDetailsPage2(OrderDetail orderDetail) {
		 return getSqlMapClientTemplate().queryForList("getOrderDetails_by_month",orderDetail);  
	}
	
	


	public Integer getOrderDetailByOrderIdCount(String id) {
		return (Integer)getSqlMapClientTemplate().queryForObject("getOrderDetailByOrderIdCount", id);
	}

	public Integer getOrderDetailsCount(OrderDetail orderDetail) {
		return  (Integer)getSqlMapClientTemplate().queryForObject("getOrderDetailsCount", orderDetail);  
	} 


	/**
     * @see com.vriche.adrm.order.dao.OrderDetailDao#getOrderDetails(com.vriche.adrm.order.model.OrderDetail)
     */
    public List getOrderDetails(final OrderDetail orderDetail) {

    		return getSqlMapClientTemplate().queryForList("getOrderDetails", orderDetail); 

    }
    /**
     * @see com.vriche.adrm.order.dao.OrderDetailDao#getOrderDetailsByIdList(com.vriche.adrm.order.model.OrderDetail)
     */
    public List getOrderDetailsByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getOrderDetailsByIdList", idList);
    }
    
    public OrderDetail getOrderDetail(Long id) {

        OrderDetail orderDetail = (OrderDetail) getSqlMapClientTemplate().queryForObject("getOrderDetail", id);
//        System.out.println("getOrderDetail id 3 8888888888888888888888888888>>>>>>>>>>>>>>>" + orderDetail);	
        if (orderDetail == null) {
            throw new ObjectRetrievalFailureException(OrderDetail.class, id);
        }
        return orderDetail;  
    }
    

    /**
     * @see com.vriche.adrm.order.dao.OrderDetailDao#getOrderDetail(Long id)
     */
    public String getOrderDetailForXML(Long id) {

        String orderDetailXML =(String)getSqlMapClientTemplate().queryForObject("getOrderDetailXMLByOrderId", id);

         return orderDetailXML;
        
    }

    /**
     * @see com.vriche.adrm.order.dao.OrderDetailDao#saveOrderDetail(OrderDetail
     *      orderDetail)
     */    
    public Long saveOrderDetail(final OrderDetail orderDetail) {
        Long id = orderDetail.getId();
//        Long matterId = new Long("0");
//        
//        Matter matter = orderDetail.getMatter();
//        matterId = matter.getId();
//
//        if(matterId.intValue() != 0 && matterId.intValue() != -1 && matterId.toString() != ""){
//        	 getSqlMapClientTemplate().update("updateMatter", matter);
//        }else{
//        	matterId = (Long) getSqlMapClientTemplate().insert("addMatter", matter);
//        }
//        
//        orderDetail.setMatterId(matterId);
        // check for new record'

        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addOrderDetail", orderDetail);
          
        } else {
            getSqlMapClientTemplate().update("updateOrderDetail", orderDetail);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(OrderDetail.class, id);
        }
       
//        OrderDayInfo[] orderDayInfos = orderDetail.getOrderDayInfos();
//        for(int i =0;i<orderDayInfos.length;i++){
//        	orderDayInfos[i].setOrderDetailId(id);
//        }
//        saveOrderDayInfos(orderDayInfos);

        
        return id;
    }

    /**
     * @see com.vriche.adrm.order.dao.OrderDetailDao#removeOrderDetail(Long id)
     */
    public void removeOrderDetail(Long id) {
        getSqlMapClientTemplate().update("deleteOrderDetail", id);
    }
    /**
     * @see com.vriche.adrm.order.dao.OrderDetailDAO#removeOrderDetails(String
     *      ids)
     */
    public void removeOrderDetails(final Map idList) {
        getSqlMapClientTemplate().update("deleteOrderDetails", idList);

    }


	public Integer getSumTimes(Long orderId) {
		return (Integer)getSqlMapClientTemplate().queryForObject("getSumTimes", orderId);
	}


	public List getOrderDetailIdsByParentId(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getOrderDetails",orderDetail);
	}
	


	public List getCustomerProductByBeginAndEndDate(Map idList) {
        return getSqlMapClientTemplate().queryForList("getCustomerProductByBeginAndEndDate", idList);
	}

	public List getIndustryTypeProductByBeginAndEndDate(Map idList) {		
		return getSqlMapClientTemplate().queryForList("getIndustryTypeProductByBeginAndEndDate", idList);
	}
	
	public List getIndustryTypeProductChannelByBeginAndEndDate(Map idList) {		
		return getSqlMapClientTemplate().queryForList("getIndustryTypeProductChannelByBeginAndEndDate", idList);
	}
	 
	public List getAdvTypeProductByBeginAndEndDate(Map idList) {
		return getSqlMapClientTemplate().queryForList("getAdvTypeProductByBeginAndEndDate", idList);
	}


	public Integer getCustomerProductCount(Map map) {
		return  (Integer)getSqlMapClientTemplate().queryForObject("getCustomerProductCount", map);
	}


	public Integer getIndustryTypeProductCount(Map map) {
		// TODO Auto-generated method stub
		return  (Integer)getSqlMapClientTemplate().queryForObject("getIndustryTypeProductCount", map);
	}


	public Integer getAdvTypeProductCount(Map map) {
		// TODO Auto-generated method stub
		return  (Integer)getSqlMapClientTemplate().queryForObject("getAdvTypeProductCount", map);
	}
	
	public List getOrderDetailIdByPublishMemo(Map map) {
		// TODO Auto-generated method stub
		return  getSqlMapClientTemplate().queryForList("getOrderDetailIdByPublishMemo", map);
	}

    /**
     * @see com.vriche.adrm.order.dao.OrderDetailDao#removeOrderByImport(Long publishMemo)
     */
    public void removeOrderByImport(String  publishMemo) {  
        getSqlMapClientTemplate().update("deleteOrderByImport", publishMemo);
    }

    
	public List getOrderDetailsAnalyze(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		return  getSqlMapClientTemplate().queryForList("getOrderDetailsAnalyze", orderDetail);
	}
	
	
	 public Long saveOrderDetail2(final OrderDetail orderDetail) {
//			System.out.println("order 6 saveOrderDetail2>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  " +orderDetail); 
	        Long id = orderDetail.getId();
//	        System.out.println("order 7 saveOrderDetail2>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  " +orderDetail.toString()); 

	        if (id == null || id.toString().equals("0")) {
	            id = (Long) getSqlMapClientTemplate().insert("addOrderDetail", orderDetail);
//	            String changeContent ="新添这条记录" +" , , "+ "\n\r";
//	            OrderLogUtil.saveLog(orderDetail, changeContent); 
	        } else {
	            getSqlMapClientTemplate().update("updateOrderDetail2", orderDetail);
	        }
	        if( id == null ) {
	            throw new ObjectRetrievalFailureException(OrderDetail.class, id);
	        }
	               
	        return id;
	    }
	public List getOrderDetailsForChangeRate(OrderDetail orderDetail) {
		return getSqlMapClientTemplate().queryForList("getOrderDetailsForChangeRate", orderDetail); 
	}
	public List getResTypeByOrderDetail(Map map) {
		return getSqlMapClientTemplate().queryForList("getResTypeByOrderDetail", map); 
	}
	public List getOrderDetailByOrderIdCopy(Map map) {
		return getSqlMapClientTemplate().queryForList("getOrderDetailsCopy",map);
	}
//	public List getOrderDetailByOrderIdCopy2(Map map) {
//		return getSqlMapClientTemplate().queryForList("getOrderDetailsCopy",map);
//	}
	
	 public Long saveOrderDetailCopy(final OrderDetail orderDetail) {
	        Long id = orderDetail.getId();

	        if (id == null || id.toString().equals("0")) {
	            id = (Long) getSqlMapClientTemplate().insert("addOrderDetailCopy", orderDetail);
//	            String changeContent ="新添这条记录" +" , , "+ "\n\r";
//	            OrderLogUtil.saveLog(orderDetail, changeContent);
	        }
	        if( id == null ) {
	            throw new ObjectRetrievalFailureException(OrderDetail.class, id);
	        }
	               
	        return id;
	    }
	public List getMonthDetailByIncomeId(Map mp,int skip, int pageSize) {
		
//	   	log.info("startDay>>>>>>vvvvvvvvvvvvvvvvvvv>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + (String)mp.get("startDay"));
//    	log.info("endDay>>>>>>>>>>vvvvvvvvvvvvvvvvvv>>>>>>>>>>>>>>>>>>>>>>>>" + (String)mp.get("endDay"));
		
		return getSqlMapClientTemplate().queryForList("getMonthDetailByIncomeId",mp);
	}	
	
	public OrderDetail getMonthDetailByIncomeIdSumNew(Map mp) {
		return (OrderDetail)getSqlMapClientTemplate().queryForObject("getMonthDetailByIncomeIdSumNew",mp);
	}
	public List getMonthDetailByIncomeInfo(Map mp) {
		return getSqlMapClientTemplate().queryForList("getMonthDetailByIncomeInfo",mp);
	}	
	
	public List getCollectionsBroReport(Map mp) {
		return getSqlMapClientTemplate().queryForList("getCollectionsBroReport",mp);
	}
	public List getCollectionsBroReport2(Map mp) {
		return getSqlMapClientTemplate().queryForList("getCollectionsBroReport2",mp);
	}	
	
		public List getOrderDetailsForBroProve(Map mp) {
			return getSqlMapClientTemplate().queryForList("getOrderDetails_for_bro_prove", mp); 
	}
	
	
}
