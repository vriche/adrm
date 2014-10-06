
package com.vriche.adrm.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import com.vriche.adrm.dao.OrderDayInfoDao;
import com.vriche.adrm.dao.ResourceLimitDao;
import com.vriche.adrm.model.CustomerProduct;
import com.vriche.adrm.model.OrderDetailColl;
import com.vriche.adrm.model.ResourceLimit;
import com.vriche.adrm.service.CarrierManager;
import com.vriche.adrm.service.ResourceLimitManager;
import com.vriche.adrm.util.ConvertUtil;
import com.vriche.adrm.util.DateUtil;
import com.vriche.adrm.util.StringUtil;

public class ResourceLimitManagerImpl extends BaseManager implements ResourceLimitManager {
    private ResourceLimitDao dao;
    private OrderDayInfoDao orderDayInfoDao;
    private CarrierManager carrierManager;
    
    

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setResourceLimitDao(ResourceLimitDao dao) {
        this.dao = dao;
    }
	/**
	 * @param orderDayInfoDao The orderDayInfoDao to set.
	 */
	public void setOrderDayInfoDao(OrderDayInfoDao orderDayInfoDao) {
		this.orderDayInfoDao = orderDayInfoDao;
	}
	/**
	 * @param carrierManager The carrierManager to set.
	 */
	public void setCarrierManager(CarrierManager carrierManager) {
		this.carrierManager = carrierManager;
	}

	
   /**
     * @see com.vriche.adrm.service.ResourceLimitManager#getResourceLimits(com.vriche.adrm.model.ResourceLimit)
     */
    public List getResourceLimits(final ResourceLimit resourceLimit) {
    	List ls = dao.getResourceLimits(resourceLimit);
    	convertTiomeByList(ls);
        return ls;
    }
   /**
     * @see com.vriche.adrm.service.ResourceLimitManager#getResourceLimitsCount(com.vriche.adrm.model.ResourceLimit)
     */
    public String getResourceLimitsCount(final ResourceLimit resourceLimit) {
        return dao.getResourceLimitsCount(resourceLimit).toString();
    }    

   /**
     * @see com.vriche.adrm.service.ResourceLimitManager#getResourceLimitsCount(com.vriche.adrm.model.ResourceLimit)
     */    
	public List getResourceLimitsPage(final ResourceLimit resourceLimit,String pageIndex, String pageSize) {
		
		List ls = dao.getResourceLimitsPage(resourceLimit,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
		convertTiomeByList(ls);
//		return dao.getResourceLimitsPage(resourceLimit,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));		
		return ls;
	}    
   /**
     * @see com.vriche.adrm.service.ResourceLimitManager#getResourceLimitsCount(com.vriche.adrm.model.ResourceLimit)
     */    
	public String getResourceLimitsPageXML(final ResourceLimit resourceLimit,String pageIndex, String pageSize) {
	    StringBuffer sb = new StringBuffer();
	    List ls = this.getResourceLimitsPage(resourceLimit,pageIndex,pageSize);
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");   
		for(Iterator it = ls.iterator();it.hasNext();){
			ResourceLimit obj = (ResourceLimit)it.next();
			sb.append("<row  id=\""+ obj  +"\"" +">");
			sb.append("<cell><![CDATA["+ obj  +"]]></cell>");
			sb.append("</row>");
		}
		sb.append("</rows>");	
		return sb.toString();
	}  
	  public static String getResourceRowCss(String total,String used){
//		  int t = total.equals("")?0:Integer.parseInt(total);
//		  int u = used.equals("")?0:Integer.parseInt(used);
//		  int resourceLeave = t -u;
//		  String resourceRowCss = "";
//		  if(resourceLeave == 0) resourceRowCss = "font-weight:bold;" +" background-color: #CCCCCC;";
//		  if(resourceLeave > 0) resourceRowCss = "font-weight:bold;" +" background-color: #99FF66;";
//		  if(resourceLeave < 0) resourceRowCss = "font-weight:bold;" +" background-color: #FFFF00;";
		  String resourceRowCss = "font-weight:bold;" +" background-color: #99FF66;";
		  return resourceRowCss;
		  
	  }
	public String getResourceLimitsXML(ResourceLimit resourceLimit) {
	    StringBuffer sb = new StringBuffer();
		String seachType = resourceLimit.getPreT();
	    List ls = this.getResourceLimitsByCarrier(resourceLimit);
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");   
		int k = 0;
		for(Iterator it = ls.iterator();it.hasNext();){
			 
			CustomerProduct obj = (CustomerProduct)it.next();
			sb.append("<row  id=\""+ k++  +"\"" +">");
			sb.append("<cell BgColor='red'><![CDATA["+ obj.getBroadcastStartT()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ obj.getBroadcastEndT()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ obj.getMonth()  +"]]></cell>");
			for(int i = 0;i<31;i++){
				Double used = obj.getDayTimes()[i] ;
				String total = obj.getTotal();
				if(seachType.equals("2")){
					total = total == null||total.equals("")?"0":total;
					if(used != null && !total.equals("0")){
						obj.getDayTimes()[i] =new Double(Double.valueOf(total).doubleValue()-  used.doubleValue()) ;
					}else{
						if(!total.equals("0"))
						obj.getDayTimes()[i] =new Double(total);
					}
					
				}
				
	            String u = StringUtil.doubleFormat(obj.getDayTimes()[i]);
	            String resourceRowCss = getResourceRowCss(obj.getTotal(),u);
				sb.append("<cell  style=\""+ resourceRowCss +"\"><![CDATA["+ u  +"]]></cell>");
			}
			sb.append("<cell><![CDATA["+ obj.getTotal()  +"]]></cell>");
			sb.append("</row>");
		}
		sb.append("</rows>");
		return sb.toString();
	} 
	

	public Collection getResourceLimitsColl(ResourceLimit resourceLimit){
		Collection coll = new ArrayList();
		String seachType = resourceLimit.getPreT();
		
	    List ls = this.getResourceLimitsByCarrier(resourceLimit);
	   
	    for (Iterator it = ls.iterator(); it.hasNext();) {
	    	CustomerProduct customerProduct = (CustomerProduct) it.next();
	    	OrderDetailColl cpColl = new OrderDetailColl();
	    	cpColl.setAdvName(customerProduct.getBroadcastStartT());
	    	cpColl.setAdvVer(customerProduct.getBroadcastEndT());
	    	cpColl.setMonth(customerProduct.getMonth());
	    	setOrderDetailCollDays(cpColl,customerProduct,seachType);
	    	cpColl.setCarrier(customerProduct.getTotal());
	    	coll.add(cpColl);
	    }	
		return coll;
	}
	
    private String[] setValue(Double[] dayUseds,String total,String seachType){
    	String[] ss = new String[31];
    		for(int i = 0; i< 31;i++){
    			
				if(seachType.equals("2")){
					Double used = dayUseds[i] ;
					total = total == null||total.equals("")?"0":total;
					if(used != null && !total.equals("0")){
						dayUseds[i] =new Double(Double.valueOf(total).doubleValue() - used.doubleValue()) ;
					}else{
						if(!total.equals("0"))
							dayUseds[i] =new Double(total);
					}
				}   			
    			
    			ss[i] = StringUtil.doubleFormat(dayUseds[i]);
    			if(ss[i].equals("0")) ss[i] = "";
    		}
      return ss;
    }
    
	
	private void setOrderDetailCollDays(OrderDetailColl cpColl,CustomerProduct customerProduct,String seachType){
		
		int i = 0;
		String[] days = setValue(customerProduct.getDayTimes(),customerProduct.getTotal(),seachType);
		cpColl.setDay1(days[i++]);
		cpColl.setDay2(days[i++]);
		cpColl.setDay3(days[i++]);
		cpColl.setDay4(days[i++]);
		cpColl.setDay5(days[i++]);
		cpColl.setDay6(days[i++]);
		cpColl.setDay7(days[i++]);
		cpColl.setDay8(days[i++]);
		cpColl.setDay9(days[i++]);
		cpColl.setDay10(days[i++]);
		cpColl.setDay11(days[i++]);
		cpColl.setDay12(days[i++]);
		cpColl.setDay13(days[i++]);
		cpColl.setDay14(days[i++]);		
		cpColl.setDay15(days[i++]);
		cpColl.setDay16(days[i++]);
		cpColl.setDay17(days[i++]);
		cpColl.setDay18(days[i++]);
		cpColl.setDay19(days[i++]);
		cpColl.setDay20(days[i++]);
		cpColl.setDay21(days[i++]);
		cpColl.setDay22(days[i++]);
		cpColl.setDay23(days[i++]);
		cpColl.setDay24(days[i++]);
		cpColl.setDay25(days[i++]);
		cpColl.setDay26(days[i++]);
		cpColl.setDay27(days[i++]);
		cpColl.setDay28(days[i++]);
		cpColl.setDay29(days[i++]);
		cpColl.setDay30(days[i++]);
		cpColl.setDay31(days[i++]);
	}
	
	private List getResourceListByLimit(List listRes,ResourceLimit resourceLimit){
		
		return null;
	}
	

	

	private List getResourceResultListByLimit(List adList,ResourceLimit resourceLimit){
		List productList = new ArrayList();
		
		int startTime = resourceLimit.getStartTime().intValue();
		int endTime = resourceLimit.getEndTime().intValue();
		int centerTime =3600*24;
		//跨24点需要把标准拆开，分成两个时间片
		if(endTime < startTime){
			getStartEndCustomerProduct(adList,productList,startTime,centerTime);
			getStartEndCustomerProduct(adList,productList,0,endTime);
		}else{
			getStartEndCustomerProduct(adList,productList,startTime,endTime);
		}
		
		return productList;
	}
	
	
	private void  getStartEndCustomerProduct(List adList,List productList,int startTime,int endTime){
		int centerTime =3600*24;
		List newAdList = new ArrayList();
		for(Iterator it = adList.iterator();it.hasNext();){
			 CustomerProduct customerProduct =(CustomerProduct)it.next();
			 int adStartTime = customerProduct.getBroadcastStartTime().intValue();
			 int adEndTime = customerProduct.getBroadcastEndTime().intValue();
			 
			 //跨24点需要把标准拆开，分成两个时间片
             if(adEndTime > centerTime){
            	 
            	 customerProduct.setBroadcastEndTime(new Integer(centerTime));
            	 getAdCustomerProduct(productList,customerProduct,startTime,endTime);
            	 
            	 CustomerProduct adInfo = new CustomerProduct();
            	 ConvertUtil.copyBeanProperties(adInfo,customerProduct);
            	 adInfo.setBroadcastStartTime(new Integer(0));
            	 adInfo.setBroadcastEndTime(new Integer(adEndTime -centerTime));
            	 Integer publishDate = new Integer(DateUtil.convertDateToString("yyyyMMdd",adInfo.getPublishDate().toString(),1));
//            	 System.out.println("publishDate>>>>>>>>>>"+publishDate.toString());
            	 adInfo.setPublishDate(publishDate);
            	 newAdList.add(adInfo);

  
            	 getAdCustomerProduct(productList,adInfo,startTime,endTime);
             }else{
            	 getAdCustomerProduct(productList,customerProduct,startTime,endTime);
             }
		}
		 CollectionUtils.addAll(adList,newAdList.iterator());

		
	}
	
	
	private void getAdCustomerProduct(List productList,CustomerProduct customerProduct,int startTime,int endTime){
		 int adStartTime = customerProduct.getBroadcastStartTime().intValue();
		 int adEndTime = customerProduct.getBroadcastEndTime().intValue();
		 
		 if(startTime<=adStartTime && endTime>=adEndTime){
		     customerProduct.setBroadcastStartTime(new Integer(adStartTime));
			 customerProduct.setBroadcastEndTime(new Integer(adEndTime));
			 productList.add(customerProduct);
		 }else if(startTime>adStartTime && endTime>=adEndTime && startTime<adEndTime){
			 customerProduct.setBroadcastStartTime(new Integer(startTime));
			 customerProduct.setBroadcastEndTime(new Integer(adEndTime));
			 productList.add(customerProduct);
		 }else if(startTime<=adStartTime && endTime<adEndTime && endTime>adStartTime){
		     customerProduct.setBroadcastStartTime(new Integer(adStartTime));
			 customerProduct.setBroadcastEndTime(new Integer(endTime));
			 productList.add(customerProduct);
		 }else if(startTime>adStartTime && endTime<adEndTime){
		     customerProduct.setBroadcastStartTime(new Integer(startTime));
			 customerProduct.setBroadcastEndTime(new Integer(endTime)); 
			 productList.add(customerProduct);
		 }
	}
	
	
	private List getMonthResourceResultListByLimit(List adList,ResourceLimit resourceLimit,int startMonth, int endMonth){
		Map mp = new HashMap();
		List newList = new ArrayList();
		for(Iterator it = adList.iterator();it.hasNext();){
			 CustomerProduct customerProduct =(CustomerProduct)it.next();
			 String month = customerProduct.getPublishDate().toString().substring(4,6);
			 if(mp.containsKey(month)){
				 List ls = (List)mp.get(month);
				 ls.add(customerProduct);
			 }else{
				 List ls = new ArrayList();
				 ls.add(customerProduct);
				 mp.put(month,ls);
			 }
		}
		
		for(int i = startMonth;i<endMonth+1;i++){
			 List ls = new ArrayList();
			 String key = String.valueOf(i).length()==1?"0"+i:String.valueOf(i);
			 Object obj = mp.get(key);
			 if(obj != null)ls = (List)mp.get(key);
			 CustomerProduct customerProduct = new CustomerProduct();
			 customerProduct.setBroadcastStartT(resourceLimit.getStarT());
			 customerProduct.setBroadcastEndT(resourceLimit.getEndT());
			 customerProduct.setMonth(key);
			 customerProduct.setTotal(String.valueOf(resourceLimit.getLimitTime()));
			 if(ls.size()>0) setDaysTime(customerProduct,ls);
			 newList.add(customerProduct);
		}

		
		return newList;
	}
	
	private void setDaysTime(CustomerProduct product,List ls){
		Double[] dayTimes = new Double[31];
		for(Iterator it = ls.iterator();it.hasNext();){
			CustomerProduct customerProduct =(CustomerProduct)it.next();
			int start = customerProduct.getBroadcastStartTime().intValue();
			int end = customerProduct.getBroadcastEndTime().intValue();
			int day = Integer.parseInt(customerProduct.getPublishDate().toString().substring(6,8));
			Double used = new Double(end - start);
			double uBefore =0;
			if(dayTimes[day-1] != null){
				uBefore = dayTimes[day-1].doubleValue();
			}
			double u = used.doubleValue();
			u +=uBefore;
			dayTimes[day-1] = new Double(u);
		}
		product.setDayTimes(dayTimes);
	}
	
	private List getResourceLimitsByCarrier(ResourceLimit resourceLimit){
		ResourceLimit resourceLimitPar = new ResourceLimit();
		List lsEnd = new ArrayList();
		Long carrierId = resourceLimit.getCarrierId();
		String year = resourceLimit.getVersion().toString();
	
		 Map mp = new HashMap();
		
		int startMonth = Integer.parseInt(resourceLimit.getStartTime().toString().substring(4,6));
		int endMonth = Integer.parseInt(resourceLimit.getEndTime().toString().substring(4,6));
		
//		System.out.println("carrierId>>>>>>>>>>"+carrierId);
		
		resourceLimitPar.setCarrierId(carrierId);
		List resIdList = carrierManager.getOneCarrResourceiDListByCarrierId(carrierId,false,year);
//		System.out.println("resIdList size>>>>>>>>>>"+resIdList.size());

		List ls1 = this.getResourceLimits(resourceLimitPar);

//		System.out.println("resourceLimit size>>>>>>>>>>"+ls1.size());
		
		for(Iterator it = ls1.iterator();it.hasNext();){	
			 ResourceLimit resLimit = (ResourceLimit)it.next();
//			 List newResList = getResourceListByLimit(lsRes,resLimit);
//			 resourceLimit.setResourceList(newResList);
			 
			 //根据资源编号去查找广告 并给每一天广告都带上 播出结束时间
			 mp.put("version",year);
			 mp.put("beginDate",resourceLimit.getStartTime());
			 mp.put("endDate",resourceLimit.getEndTime());
			 mp.put("resourceIdList",resIdList);
			 
			 System.out.println("year>>>>>>>>>>"+year);
			 System.out.println("beginDate>>>>>>>>>>"+resourceLimit.getStartTime());
			 System.out.println("endDate>>>>>>>>>>"+resourceLimit.getEndTime());
//			 System.out.println("resIdList>>>>>>>>>>"+resIdList.size());
			 

			 List adList = orderDayInfoDao.getResourceByresourceLimit(mp);

			 System.out.println("order day size>>>>>>>>>>"+adList.size());
			 
			 //二次处理广告 把符合条件的加到每一天的资源里边
//			 System.out.println("adList size>>>>>>>>>>"+adList.size());
			 List lls = getResourceResultListByLimit(adList,resLimit);
//			 System.out.println("adList size>>>>>>>>>>"+adList.size());

//			 System.out.println("lls  size>>>>>>>>>>"+lls.size());
			 
			 //再把结果写成月对象
			 List llsMonth = getMonthResourceResultListByLimit(lls,resLimit,startMonth,endMonth);

//			 System.out.println("llsMonth size>>>>>>>>>>"+llsMonth.size());
			 CollectionUtils.addAll(lsEnd,llsMonth.iterator());
//			 lsEnd.add(llsMonth);
//			 CustomerProduct customerProduct = new CustomerProduct();
//			 lsEnd.add(CustomerProduct)
		}
//		List ls = dao.getResourceLimitsByCarrier(resourceLimit);
		return lsEnd;
	}

    /**
     * @see com.vriche.adrm.service.ResourceLimitManager#getResourceLimit(String id)
     */
    public ResourceLimit getResourceLimit(final String id) {
    	ResourceLimit resLimit = dao.getResourceLimit(new Long(id));
    	setResourceLimitObj(resLimit);
        return resLimit;
    }
    /**
     * @see com.vriche.adrm.service.ResourceLimitManager#getResourceLimitsByIdList(final Map idList)
     */
    public List getResourceLimitsByMap(final Map mp) {
		List ls = dao.getResourceLimitsByMap(mp);
		convertTiomeByList(ls);
        return ls;
    }    

    /**
     * @see com.vriche.adrm.service.ResourceLimitManager#saveResourceLimit(ResourceLimit resourceLimit)
     */
    public String saveResourceLimit(ResourceLimit resourceLimit) {
    	String ha = resourceLimit.getStarTh();
    	String ma = resourceLimit.getStarTm();
    	String sa = resourceLimit.getStarTs();
    	ha = (ha == null)|| "".equals(ha)||"null".equals(ha)?"0":ha;
    	ma = (ma == null)|| "".equals(ma)||"null".equals(ma)?"0":ma;
    	sa = (sa == null)|| "".equals(sa)||"null".equals(sa)?"0":sa;
    	
    	
    	String hb = resourceLimit.getEndTh();
    	String mb = resourceLimit.getEndTm();
    	String sb = resourceLimit.getEndTs();
    	hb = (hb == null)|| "".equals(hb)||"null".equals(hb)?"0":hb;
    	mb = (mb == null)|| "".equals(mb)||"null".equals(mb)?"0":mb;
    	sb = (sb == null)|| "".equals(sb)||"null".equals(sb)?"0":sb; 	
    	
    	
    	String hc = resourceLimit.getLimitTh();
    	String mc = resourceLimit.getLimitTm();
    	String sc = resourceLimit.getLimitTs();
    	hc = (hc == null)|| "".equals(hc)||"null".equals(hc)?"0":hc;
    	mc = (mc == null)|| "".equals(mc)||"null".equals(mc)?"0":mc;
    	sc = (sc == null)|| "".equals(sc)||"null".equals(sc)?"0":sc;
    	

    	
    	int h = Integer.parseInt(ha);
    	int m  =Integer.parseInt(ma);	
    	int s =Integer.parseInt(sa);

    	int h2 = Integer.parseInt(hb);
    	int m2  =Integer.parseInt(mb);	
    	int s2 =Integer.parseInt(sb);

    	int h3 = Integer.parseInt(hc);
    	int m3  =Integer.parseInt(mc);	
    	int s3 =Integer.parseInt(sc);
	

    	Integer startTime = new Integer(h*3600+m*60+s);
		Integer endTime = new Integer(h2*3600+m2*60+s2);
		Integer limitTime =new Integer(h3*3600+m3*60+s3);
		
		resourceLimit.setStartTime(startTime);
		resourceLimit.setEndTime(endTime);
		resourceLimit.setLimitTime(limitTime);
		
    	
        return dao.saveResourceLimit(resourceLimit).toString();
    }

    /**
     * @see com.vriche.adrm.service.ResourceLimitManager#removeResourceLimit(String id)
     */
    public void removeResourceLimit(final String id) {
        dao.removeResourceLimit(new Long(id));
    }

     /**
     * @see com.vriche.adrm.service.ResourceLimitManager#removeResourceLimits(String Map)
     */
    public void removeResourceLimits(final Map mp) {
        dao.removeResourceLimits(mp);
    }    
    
    

	
	private void convertTiomeByList(List ls){
		for(Iterator it = ls.iterator();it.hasNext();){
			ResourceLimit resLimit = (ResourceLimit)it.next();
			setResourceLimitObj(resLimit);
		}
			
	}

	
	private void setResourceLimitObj(ResourceLimit resLimit){
		
		Integer startTime = resLimit.getStartTime(); 
		Integer endTime = resLimit.getEndTime(); 
		Integer limitTime = resLimit.getLimitTime();
		
		resLimit.setStarTh(DateUtil.converTime(startTime,1));
		resLimit.setStarTm(DateUtil.converTime(startTime,2));
		resLimit.setStarTs(DateUtil.converTime(startTime,3));
		
		resLimit.setEndTh(DateUtil.converTime(endTime,1));
		resLimit.setEndTm(DateUtil.converTime(endTime,2));
		resLimit.setEndTs(DateUtil.converTime(endTime,3));
		
		resLimit.setLimitTh(DateUtil.converTime(limitTime,1));
		resLimit.setLimitTm(DateUtil.converTime(limitTime,2));
		resLimit.setLimitTs(DateUtil.converTime(limitTime,3));
		
	}

	
}
