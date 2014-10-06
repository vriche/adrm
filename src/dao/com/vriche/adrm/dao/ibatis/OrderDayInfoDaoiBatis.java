
package com.vriche.adrm.dao.ibatis;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList; 
import java.util.Map;

import org.springframework.orm.ObjectRetrievalFailureException;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.OrderDayInfoDao;
import com.vriche.adrm.model.OrderDayInfo;



//import com.vriche.adrm.util.DateUtil;
//import com.vriche.adrm.util.StringUtilsv;


public class OrderDayInfoDaoiBatis extends BaseDaoiBATIS implements OrderDayInfoDao {
    

    /**
     * @see com.vriche.adrm.order.dao.OrderDayInfoDao#getOrderDayInfos(com.vriche.adrm.order.model.OrderDayInfo)
     */
    public List getOrderDayInfos(final OrderDayInfo orderDayInfo) {
    	
//    	 System.out.println("model yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy           yyyyyyyy           KKKKKKKKKKKKKKKKKK>>" +orderDayInfo.toString());
    	 
    	return getSqlMapClientTemplate().queryForList("getOrderDayInfos", orderDayInfo); 
    }
    
    /**
     * @see com.vriche.adrm.order.dao.OrderDayInfoDao#getOrderDayInfoId(com.vriche.adrm.order.model.OrderDayInfo)
     */
    public List getOrderDayInfoId(final Long id) {
          return getSqlMapClientTemplate().queryForList("getOrderDayInfoId", id);    
    }
    
    public List getOrderDayInfosForPutOn(Map mp) {
        return getSqlMapClientTemplate().queryForList("getOrderDayInfosForPutOn", mp);
       

  }
    /**
     * @see com.vriche.adrm.order.dao.OrderDayInfoDao#getOrderDayInfosByIdList(com.vriche.adrm.order.model.OrderDayInfo)
     */
    public List getOrderDayInfosByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getOrderDayInfosByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.order.dao.OrderDayInfoDao#getOrderDayInfo(Long id)
     */
    public OrderDayInfo getOrderDayInfo(Long id) {
        OrderDayInfo orderDayInfo = (OrderDayInfo) getSqlMapClientTemplate().queryForObject("getOrderDayInfo", id);

        if (orderDayInfo == null) {
            throw new ObjectRetrievalFailureException(OrderDayInfo.class, id);
        }

        return orderDayInfo;
    }
    


    /**
     * @see com.vriche.adrm.order.dao.OrderDayInfoDao#saveOrderDayInfo(OrderDayInfo orderDayInfo)
     */    
    public void saveOrderDayInfo(final OrderDayInfo orderDayInfo) {
        Long id = orderDayInfo.getId();
        Integer dayTimes = new Integer("0");
        dayTimes = orderDayInfo.getAdDayTimes();
        
        // check for new record
        if ((id == null ||id.longValue() == 0) && dayTimes.intValue()>0) {
             id = (Long) getSqlMapClientTemplate().insert("addOrderDayInfo", orderDayInfo);

        } else {
            //如果次数为0，则删除广告日信息
            if( dayTimes.intValue()== 0){
                removeOrderDayInfo(id);
            }else{
                getSqlMapClientTemplate().update("updateOrderDayInfo", orderDayInfo);
            }
        }
        
        //对资源日信息进行修改
        getSqlMapClientTemplate().update("updateDayInfo-saveOrderDetail", orderDayInfo.getDayInfo());

    }
    
public void saveOrderDayInfos(OrderDayInfo[] orderDayInfos) {
		
//		log.info(">>>>>>>>>>>>"+orderDayInfos.length);
//		System.out.println(">>>>>>>>>>>>>>>>>>>%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%>>>>>>>>>>>>>>>>>>>>>>needCal>>>>>>" + orderDayInfos.length);
		try {
			getSqlMapClientTemplate().getSqlMapClient().startBatch();

			for(int i = 0;i < orderDayInfos.length;i++){
				 OrderDayInfo  orderDayInfo = orderDayInfos[i];
				
					Long id = orderDayInfo.getId();  
					int dayTimes = orderDayInfo.getAdDayTimes().intValue();
					boolean isNew = (id == null || id.longValue() == 0) ? true : false;
					int need=orderDayInfo.getNeedPublish().intValue();
					
//					System.out.println("saveOrderDayInfos isNew >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>needCal>>>>>>" + isNew);
//					System.out.println("saveOrderDayInfos dayTimes >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>needCal>>>>>>" + dayTimes);
//					System.out.println("saveOrderDayInfos need >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>needCal>>>>>>" + need);
					if (isNew && dayTimes > 0&& need!=1) {
						 getSqlMapClientTemplate().getSqlMapClient().insert("addOrderDayInfo", orderDayInfo);						
					}
			}	
			
		  for(int i = 0;i < orderDayInfos.length;i++){
				OrderDayInfo  orderDayInfo = orderDayInfos[i];
				 
				Long id = orderDayInfo.getId();
				int dayTimes = orderDayInfo.getAdDayTimes().intValue();
				boolean isNew = (id == null || id.longValue() == 0) ? true
						: false;

				if (!isNew && dayTimes == 0) {
					getSqlMapClientTemplate().getSqlMapClient().update(
							"deleteOrderDayInfo", id);
				}
				
			}			
			
			for(int i = 0;i < orderDayInfos.length;i++){
				 	OrderDayInfo  orderDayInfo = orderDayInfos[i];
					Long id = orderDayInfo.getId();
					int dayTimes = orderDayInfo.getAdDayTimes().intValue();
					boolean isNew = (id == null || id.longValue() == 0) ? true : false;				 
				 
					if (!isNew && dayTimes > 0) {
						getSqlMapClientTemplate().getSqlMapClient().update("updateOrderDayInfo", orderDayInfo);				
					}
			}	
			//updateDayInfo
			for(int i = 0;i < orderDayInfos.length;i++){
				 OrderDayInfo  orderDayInfo = orderDayInfos[i];
//				 System.out.println(orderDayInfo.getDayInfo().getId()+"???"+orderDayInfo.getDayInfo().getUsed());
				 if(orderDayInfo.getNeedPublish().intValue()!=1)
					 	getSqlMapClientTemplate().getSqlMapClient().update("updateDayInfo-saveOrderDetail", orderDayInfo.getDayInfo());
			}
			getSqlMapClientTemplate().getSqlMapClient().executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	  



public void saveResourceDayInfo(OrderDayInfo[] orderDayInfos){
	try {
		getSqlMapClientTemplate().getSqlMapClient().startBatch();

		for(int i = 0;i < orderDayInfos.length;i++){
			 OrderDayInfo  orderDayInfo = orderDayInfos[i];
			 getSqlMapClientTemplate().getSqlMapClient().update("updateDayInfo-saveOrderDetail-new", orderDayInfo.getDayInfo());
		}	
		
		getSqlMapClientTemplate().getSqlMapClient().executeBatch();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
}

public void saveOrderDayInfosNew(OrderDayInfo[] orderDayInfos){
	try {
		getSqlMapClientTemplate().getSqlMapClient().startBatch();

		for(int i = 0;i < orderDayInfos.length;i++){
			 OrderDayInfo  orderDayInfo = orderDayInfos[i];
			 int adDayTimes = orderDayInfo.getAdDayTimes().intValue();
			 Long id = orderDayInfo.getId();  
			 boolean isNew = (id == null || id.longValue() == 0) ? true : false;				 
			 if(adDayTimes > 0 && isNew){
				 getSqlMapClientTemplate().getSqlMapClient().insert("addOrderDayInfo", orderDayInfo);	 
			 }else{
				 getSqlMapClientTemplate().getSqlMapClient().insert("updateOrderDayInfo", orderDayInfo);	 
			 }
		}	
		
		getSqlMapClientTemplate().getSqlMapClient().executeBatch();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
}


    /**
     * @see com.vriche.adrm.order.dao.OrderDayInfoDao#removeOrderDayInfo(Long id)
     */
    public void removeOrderDayInfo(Long id) {
        getSqlMapClientTemplate().update("deleteOrderDayInfo", id);
    }
    /**
     * @see com.vriche.adrm.order.dao.OrderDayInfoDAO#removeOrderDayInfos(String ids)
     */
    public void removeOrderDayInfos(final Map idList) {
        getSqlMapClientTemplate().update("deleteOrderDayInfos", idList);
    }
 
	public List getOrderDayInfos(Map mp) {
		
		Long paymentId = Long.valueOf(getNullValue(mp.get("paymentId"),"0"));   
		Long orderId =  Long.valueOf(getNullValue(mp.get("orderId"),"0"));   
		Long contractId =  Long.valueOf(getNullValue(mp.get("contractId"),"0"));   
		Long detailId =  Long.valueOf(getNullValue(mp.get("detailId"),"0"));   
		Integer needCal =  Integer.valueOf(getNullValue(mp.get("needCal"),"0"));   
		Integer resourceType = Integer.valueOf(getNullValue(mp.get("resourceType"),"0"));   
		
//		Long parentId = (Long)mp.get("parentId");
		

		OrderDayInfo orderDayInfo = new OrderDayInfo();

		if(paymentId.longValue() >0){
			orderDayInfo.setPaymentId(paymentId);			
		}
		if(orderId.longValue() >0){
			orderDayInfo.setOrderId(orderId);			
		}
		if(detailId.longValue() >0){
			orderDayInfo.setOrderDetailId(detailId);		
		}
		
		if(resourceType.longValue() >0){
			orderDayInfo.setResourceType(resourceType);
		}
		
		if(contractId == null) contractId = new Long(0);
		if(contractId.longValue() >0){
			orderDayInfo.setContractId(contractId);
		}
		
//		if(log.isDebugEnabled()){
			System.out.println(">>>>>>>>>>paymentId>>>>>>" + paymentId);
			System.out.println(">>>>>>>>>>orderId>>>>>>" + orderId);
			System.out.println(">>>>>>>>>>detailId>>>>>>" + detailId);
			System.out.println(">>>>>>>>>>contractId>>>>>>" + contractId); 
			System.out.println(">>>>>>>>>>needCal>>>>>>" + needCal); 
			System.out.println(">>>>>>>>>>resourceType>>>>>>" + resourceType);   
//		}
     
		
//		orderDayInfo.setParentId(parentId);
		
		orderDayInfo.setNeedCal(needCal);
		
		
		return this.getOrderDayInfos(orderDayInfo);
	}
	
	
	
	public List getOrderDayInfosByStartEndDay(Integer startDate,Integer endDate) {
		Map mp = new HashMap();
		mp.put("startDate",startDate);
		mp.put("endDate",endDate);
		return getSqlMapClientTemplate().queryForList("getOrderDayInfosByDetailIdList", mp);
	}
	
	public List getOrderDayInfosByDetailIdList(Map mp) {
		 return getSqlMapClientTemplate().queryForList("getOrderDayInfosByDetailIdList", mp);
	}
	
	
	
	public void saveOrderDayInfosRealPlay(Map mp) {
		
		try {
			getSqlMapClientTemplate().getSqlMapClient().startBatch();
			
			for (Iterator it = mp.keySet().iterator(); it.hasNext();) {
				Long key = (Long)it.next();
				String value = (String)mp.get(key);
				Map m = new HashMap();
				m.put("value",value);
				m.put("id",key);	
				getSqlMapClientTemplate().getSqlMapClient().update("updateOrderDayRealPlay", m);
//				getSqlMapClientTemplate().update("updateOrderDayRealPlay", mp);
			}
            
			getSqlMapClientTemplate().getSqlMapClient().executeBatch();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void saveOrderDayInfosRealPlay2(Map mp) {
		
		try {
			getSqlMapClientTemplate().getSqlMapClient().startBatch();
			
			for (Iterator it = mp.keySet().iterator(); it.hasNext();) {
				Long key = (Long)it.next();
				Double value = (Double)mp.get(key);
				Map m = new HashMap();
				m.put("value",value);
				m.put("id",key);	
				getSqlMapClientTemplate().getSqlMapClient().update("updateOrderDayRealPlay", m);
//				getSqlMapClientTemplate().update("updateOrderDayRealPlay", mp);
			}
            
			getSqlMapClientTemplate().getSqlMapClient().executeBatch();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void saveOrderDayInfosRealPlay3(Map mp1,Map mp2) {
		
		try {
			getSqlMapClientTemplate().getSqlMapClient().startBatch();
			
			for (Iterator it = mp1.keySet().iterator(); it.hasNext();) {
				Long key = (Long)it.next();
				Double value = (Double)mp1.get(key);
				Double balance = new Double(0);
				Object obj = mp2.get(key);
				if(obj != null) balance = (Double)obj;
				
				Map m = new HashMap();
				m.put("value",value);
				m.put("balance",balance);
				m.put("id",key);	
				getSqlMapClientTemplate().getSqlMapClient().update("updateOrderDayRealPlay3", m);
//				getSqlMapClientTemplate().update("updateOrderDayRealPlay", mp);
			}
            
			getSqlMapClientTemplate().getSqlMapClient().executeBatch();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
public void saveOrderDayInfosRelPutOn(Map mp) {
		
		try {
			getSqlMapClientTemplate().getSqlMapClient().startBatch();
			
			for (Iterator it = mp.keySet().iterator(); it.hasNext();) {
				Long key = (Long)it.next();
				Double value = (Double)mp.get(key);
				Map m = new HashMap();
				m.put("value",value);
				m.put("id",key);
				getSqlMapClientTemplate().getSqlMapClient().update("updateOrderDayRealPutOn", m);		
//				getSqlMapClientTemplate().update("updateOrderDayRealPlay", m);
			}
//			System.out.println(">>>>>>><<<<<<<<<<<<<");
			getSqlMapClientTemplate().getSqlMapClient().executeBatch();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public List getCustomerRelIncome(Map mp) {
		return getSqlMapClientTemplate().queryForList("getCustomerRelIncome", mp);
	}
	
	public Integer getOrderDayInfoCount(Map mp) {
		return (Integer)getSqlMapClientTemplate().queryForObject("getOrderDayInfoCount", mp);
	}

	public List getCustomerByYearPage(Map mp) {
		return getSqlMapClientTemplate().queryForList("getCustomerByYear", mp);
	}
	public List getBusinessPage(Map mp) {
		return getSqlMapClientTemplate().queryForList("getBusinessCount", mp);
	}
	public List getCarrierByDate(Map mp) {
		return getSqlMapClientTemplate().queryForList("getScopeCarriers", mp);
	}
	public List getCarrierAllYear(Map mp) {
		return getSqlMapClientTemplate().queryForList("getAllYearCarriers", mp);
	}
	public List getAllYearCarrierRelPuton(Map mp) {
		return getSqlMapClientTemplate().queryForList("getAllYearCarrierRelPuton", mp);
	}
	public PaginatedList getOrderDayInfosAllPage(OrderDayInfo orderDayInfo, int pageIndex, int pageSize) {
		PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getOrderDayInfos",orderDayInfo,pageSize);
	    pageList.gotoPage(pageIndex-1);
	    	    
		return pageList;
	}
	public List getResourceByDate(Map map) {
		return getSqlMapClientTemplate().queryForList("getAdvResource", map);
	}
	public List getUsedTimeByCustomer(Map map) {
		return getSqlMapClientTemplate().queryForList("getAdvResource2", map);
	}
	public List getUsedTimeByCustomerAndTime(Map map) {
		return getSqlMapClientTemplate().queryForList("getAdvResource3", map);
	}
	public List getIdsByPayMentAndIncome(Map mp) {
		return getSqlMapClientTemplate().queryForList("getIdsByPayMentAndIncome", mp);
	}
	public void saveDayPutOnById(Map mp) {
		try {
			getSqlMapClientTemplate().getSqlMapClient().startBatch();
			
			for (Iterator it = mp.keySet().iterator(); it.hasNext();) {
				Long key = (Long)it.next();
				Double value = (Double)mp.get(key);
				Map m = new HashMap();
				m.put("value",value);
				m.put("id",key);
				getSqlMapClientTemplate().getSqlMapClient().update("updateOrderDayPutOnByUsedMap", m);		
//				getSqlMapClientTemplate().update("updateOrderDayRealPlay", m);
			}
//			System.out.println(">>>>>>><<<<<<<<<<<<<");
			getSqlMapClientTemplate().getSqlMapClient().executeBatch();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List getResourceListByDate(Map mp) {
		return getSqlMapClientTemplate().queryForList("getScopeResources", mp);
	}
	public List getAudienceListByDate(Map mp) {
		return getSqlMapClientTemplate().queryForList("getAudienceResources", mp);
	}
	
	
	public List getScopeResourcesCustomer(Map mp) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getScopeResourcesCustomer", mp);
	}

	public List getResourceByresourceLimit(Map mp) {
		return getSqlMapClientTemplate().queryForList("getResourceByresourceLimit", mp);
	}

	public List getCarrierIncome(Map mp) {
		return getSqlMapClientTemplate().queryForList("getCarrierIncome", mp);
	}
	public List getIncomeMoneyAllCarrier(Map mp){
		
		return getSqlMapClientTemplate().queryForList("getCarrierIncomeByYear", mp);
	}
    public List getRelIncomeByStartEndDate(Map mp) {
        return getSqlMapClientTemplate().queryForList("getRelIncomeByStartEndDate", mp);
    } 
    
    public void saveDetailIdWithMaterChange(Map mp) {

        getSqlMapClientTemplate().update("updateOrderDetailIdWithMaterChange",mp);
    } 
    
	private static String getNullValue(Object obj,String def) {
		try {
			String i = String.valueOf (obj);
			i = i.equals("null")||i.equals("undefined")||i.equals("")?def:i;
			return i;
		} catch (Exception ex) {
			String j = def;
			return j;
		}
	}

	public void removeOrderDayInfoByOrderDetailId(Long orderDetailId) {
		   getSqlMapClientTemplate().update("removeOrderDayInfoByOrderDetailId", orderDetailId);
		
	}

	public void saveOrderDayInfosCal(Map mp) {
		getSqlMapClientTemplate().update("updateOOrderDayInfosCal",mp);
	}

	public List getOrderDayInfosCopy(Long orderDetailId) {
		return getSqlMapClientTemplate().queryForList("getOrderDayInfosCopy",orderDetailId);
	}

	public List getOrderDayInfosForPutOn2(Map mp) {
		 return getSqlMapClientTemplate().queryForList("getOrderDayInfosForPutOn_2", mp);
	}

	public List getResourceSumByOrgDate(Map map) {
		 return getSqlMapClientTemplate().queryForList("getResourceSumByOrgDate", map);
	}

	public List getOrderDayInfosCopy2(Map mp) {
		return getSqlMapClientTemplate().queryForList("getOrderDayInfosCopy2",mp);
	}
	

	
	public List getOrderDayInfosAdversByWorkSpanId(Map mp) {
		return getSqlMapClientTemplate().queryForList("getAdversByWorkSpanId",mp);
	}
}
