package com.vriche.adrm.dao.ibatis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.orm.ObjectRetrievalFailureException;

import com.ibatis.common.util.PaginatedList;
import com.opensymphony.oscache.util.StringUtil;
import com.vriche.adrm.Constants;
import com.vriche.adrm.dao.WorkspanDao;
import com.vriche.adrm.model.DayInfo;
import com.vriche.adrm.model.SysParam;
import com.vriche.adrm.model.Workspan;


public class WorkspanDaoiBatis extends BaseDaoiBATIS implements WorkspanDao {

	/**
	 * @see com.vriche.adrm.adres.dao.WorkspanDao#getWorkspans(com.vriche.adrm.adres.model.Workspan)
	 */
	public List getWorkspans(final Workspan workspan) {
		return getSqlMapClientTemplate().queryForList("getWorkspans", workspan);
	}

	public List getWorkspansByResourceId(String resourceId) {
		return getSqlMapClientTemplate().queryForList(
				"getWorkspanByResourceId", resourceId);
	}

	/**
	 * @see com.vriche.adrm.adres.dao.WorkspanDao#getWorkspansByIdList(com.vriche.adrm.adres.model.Workspan)
	 */
	public List getWorkspansByIdList(final Map idList) {
		return getSqlMapClientTemplate().queryForList("getWorkspansByIdList",
				idList);
	}

	/**
	 * @see com.vriche.adrm.adres.dao.WorkspanDao#getWorkspan(Long id)
	 */
	public Workspan getWorkspan(Long id) {
		Workspan workspan = (Workspan) getSqlMapClientTemplate()
				.queryForObject("getWorkspan", id);

		if (workspan == null) {
			throw new ObjectRetrievalFailureException(Workspan.class, id);
		}

		return workspan;
	}

	/**
	 * @see com.vriche.adrm.adres.dao.WorkspanDao#saveWorkspan(Workspan workspan)
	 */
	public Long saveWorkspan(final Workspan workspan) {
		Long id = workspan.getId();
		// check for new record

		if (id == null || id.intValue() == -1 || id.intValue() == 0) {
			id = (Long) getSqlMapClientTemplate().insert("addWorkspan",workspan);
		} else {
	    	//先删除资源日信息
	       	Workspan ws= this.getWorkspan(id);

	    	removeResourceDayInfo(id,ws.getBeginDate(),ws.getEndDate());
	    	
			getSqlMapClientTemplate().update("updateWorkspan", workspan);
			
		}
		
		addResourceDayInfo(workspan);	
		
		
		if (id == null) {
			throw new ObjectRetrievalFailureException(Workspan.class, id);
		}
		
		return id;
	}

	/**
	 * @see com.vriche.adrm.adres.dao.WorkspanDao#removeWorkspan(Long id)
	 */
	public void removeWorkspan(Long id) {
		getSqlMapClientTemplate().update("deleteDayInfoByworkspanId", id);
		getSqlMapClientTemplate().update("deleteWorkspan", id);
	}

	/**
	 * @see com.vriche.adrm.order.dao.WorkspanDAO#removeWorkspans(String ids)
	 */
	public void removeWorkspans(final Map idList) {
		getSqlMapClientTemplate().update("deleteDayInfoByworkspanIdList", idList);
		getSqlMapClientTemplate().update("deleteWorkspans", idList);
	}

	/* *****************************************************
	 * 
	 *                       以下处理日信息
	 *
	 * *****************************************************/

	/*根据资源信息修改日信息，同时根据订单修改使用，和指定信息*/

	public void addResourceDayInfo(Workspan workspan){
    	
    	Long workspanId = workspan.getId();
    	Long resourceId = workspan.getResourceId();
    	Integer beginDate = workspan.getBeginDate();
    	Integer endDate = workspan.getEndDate();
    	String totals[] = setTotalArray(workspan);
    	Integer version = workspan.getVersion();
    	
//    	Integer broadcastEndTime = workspan.getBroadcastEndTime();
    	
    	if (beginDate == null || endDate == null) return ;
    	Map orderDayTimeUsedMap = getOrderDayTimeUsed(beginDate,endDate,resourceId);
    	Map orderDayTimeSpecMap = getOrderDayTimeSpec(beginDate,endDate,resourceId);
    	Map orderDayLockStateMap = getPublishLockState(beginDate,endDate,resourceId);
    	
//    	System.out.println("StringUtilsv.printMap beginDate>>>>>>>>>>>> " +beginDate);
//    	System.out.println("StringUtilsv.printMap endDate>>>>>>>>>>>> "+endDate);
//    	System.out.println("StringUtilsv.printMap resourceId>>>>>>>>>>>> "+resourceId);
//    	System.out.println("StringUtilsv.printMap>>>>>>>>>>>> start");
//		Iterator   it   =   orderDayTimeUsedMap.keySet().iterator();
//
//		while   (it.hasNext()){
//			Object   key   =   it.next()   ;
//			Object   value   =  orderDayTimeUsedMap.get(key);
//			System.out.println("key="+ key+"  value="+value);
//		} 
    	
    	//日期处理
    	long u = 3600*24*1000;
    	Date trialTime1 = new Date();
    	Date trialTime2 = new Date();
		try {
			trialTime1 = convertStringToDate("yyyyMMdd",beginDate.toString());
	    	trialTime2 = convertStringToDate("yyyyMMdd",endDate.toString());
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(trialTime1);
       	long a = calendar.getTimeInMillis();
       	calendar.setTime(trialTime2);
       	long b = calendar.getTimeInMillis();  
       	int days = new Integer(String.valueOf((b-a)/u)).intValue();
       	



    	//插入日信息
    	for (int i = 0;i <= days;i++){
    		DayInfo dayInfo = new DayInfo();
    		dayInfo.setWorkspanId(workspanId);
    		dayInfo.setResourceId(resourceId);
    		try {
    			long s = a + u*i;
           		calendar.setTimeInMillis(s);
           		Date date = calendar.getTime();
//    			calendar.add(Calendar.DATE,i);
//    			Date date =  calendar.getTime();
 
           		Integer publishDate = new Integer(getDateTime("yyyyMMdd",date)); 
           		
//           		System.out.println("publishDate>>>>>>>>>>>>"+ publishDate.intValue());

           		double o_used = 0;
           		String o_spec ="";
           		Boolean is_lock = false;
           		
           		if (!orderDayTimeUsedMap.isEmpty()){
           			if (orderDayTimeUsedMap.containsKey(publishDate)){
           				o_used = (new Double(getNullValue(orderDayTimeUsedMap.get(publishDate),"0"))).doubleValue();
           		
           			}
           		}
           		if (!orderDayTimeSpecMap.isEmpty()){
           			if (orderDayTimeSpecMap.containsKey(publishDate)){
           				o_spec= orderDayTimeSpecMap.get(publishDate).toString();
           			}
           		}
           		
           		if (!orderDayLockStateMap.isEmpty()){
           			if (orderDayLockStateMap.containsKey(publishDate)){
           				is_lock= Boolean.valueOf(getNullValue(orderDayLockStateMap.get(publishDate),"0"));
           			}
           		}
           		
           		
           		double total = getDayTotalTimes(date,totals);
    			dayInfo.setPublishDate(publishDate);
				dayInfo.setTotal(String.valueOf(total));
				dayInfo.setUsed(getResUsed(total,o_used));
				dayInfo.setSpecific(o_spec);
				dayInfo.setIsLocked(is_lock);
				dayInfo.setVersion(version);
//				dayInfo.setBroadcastStartTime(new Integer(broadcastEndTime.intValue()+total));
//				if(total > 0){
//					dayInfo.setBroadcastStartTime(new Integer(broadcastEndTime.intValue()+total));
//				}
//				else{
//					dayInfo.setBroadcastStartTime(new Integer(0));
//				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
    		getSqlMapClientTemplate().insert("addDayInfo", dayInfo);
    	}

    }	

   private  String getNullValue(Object obj,String def) {
		try {
			String i = String.valueOf (obj);
//			i = i.equals("null")||i.equals("undefined")||i.equals("")?def:i;
			i = "null".equals(i)||"undefined".equals(i)||"".equals(i)?def:i;
			return i;
		} catch (Exception ex) {
			String j = def;
			return j;
		}
   }

   //根据日期，判断星期，再根据星期判断标准时间
   private double getDayTotalTimes(Date day,String totals[]) throws Exception{
	   Calendar calendar = new GregorianCalendar();
	   calendar.setTime(day);
	   int week = calendar.get(Calendar.DAY_OF_WEEK);
	   String t = totals[week-1];
	   
//	   System.out.println("week>>>>>>>>>>>>"+ week);
	   double total = StringUtils.isNotEmpty(t) && t != null  && t != "" ? Double.parseDouble(t):0;
	   return total;
   }
   
   private String getResUsed(double total,double used){
	   String u = "0";
	   if(total == 0 && used > 0){
		   u = String.valueOf(-used);
	   }else{
		   u = String.valueOf(used);
	   }
	   return u;
   }
   
	private static  boolean getFztvSpecialParam(){
	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
	    if(StringUtils.isEmpty(sysParam.getFztvSpecialParam())) sysParam.setFztvSpecialParam("0");
	    return (sysParam.getFztvSpecialParam().equals("0"))?false:true;
	}
	

   //根据资源有效时间范围，删除资源信息
	public void removeResourceDayInfo(Long workspanId,Integer beginDate,Integer endDate) {
		Map mp = new HashMap();
		mp.put("workspanId",workspanId);
		mp.put("beginDate",beginDate.toString());
		mp.put("endDate",endDate.toString());
		getSqlMapClientTemplate().update("deleteDayInfoByworkspanIdAndDate", mp);
	}

	//查找订单资源使用  
	public Map getOrderDayTimeUsed(Integer startDate,Integer endDate,Long resourceId) {
		Map orderDay = new HashMap();
        Map mp = new HashMap();
        List ls = new ArrayList();
        mp.put("startDate",startDate);
        mp.put("endDate",endDate);
        mp.put("resourceId",resourceId);
        if(!getFztvSpecialParam()){ 
        	ls = getSqlMapClientTemplate().queryForList("getOrderDayTimeUsed",mp);
//        	orderDay = getSqlMapClientTemplate().queryForMap("getOrderDayTimeUsed",mp,"publishDate");
        }else{
        	ls = getSqlMapClientTemplate().queryForList("getOrderDayTimeUsedForFztv",mp);  
        }
        
        Iterator it =ls.iterator();

        while(it.hasNext()){
        	DayInfo dayInfo = (DayInfo) it.next();
        	orderDay.put(dayInfo.getPublishDate(),dayInfo.getUsed());       
        }

		return orderDay;
	}
	
	
	

	//查找订单指定信息
	public Map getOrderDayTimeSpec(Integer startDate,Integer endDate,Long resourceId) {
		Map orderDay = new HashMap();
        Map resourceParameter = new HashMap();
        resourceParameter.put("startDate",startDate);
        resourceParameter.put("endDate",endDate);
        resourceParameter.put("resourceId",resourceId);
        List ls = getSqlMapClientTemplate().queryForList("getOrderDayTimeSpec",resourceParameter);
        Iterator it =ls.iterator();
        
        while(it.hasNext()){
        	DayInfo dayInfo = (DayInfo) it.next();
        	Integer date = dayInfo.getPublishDate();
        	String newSpc =  dayInfo.getSpecific();
        	if(orderDay.containsKey(date)){
        		String oldSpc = orderDay.get(date).toString();
        		if(!"".equals(oldSpc) && !"null".equals(oldSpc)){
        			  newSpc = oldSpc +","+ newSpc;
        		}
        		
        		
        		
        		orderDay.remove(date);
        		orderDay.put(date,newSpc);
        	}else{
        		orderDay.put(date,dayInfo.getSpecific());
        	}
        	
        }
        
		return orderDay;
	}
	
	//查找订单指定信息
		public Map getPublishLockState(Integer startDate,Integer endDate,Long resourceId) {
			Map orderDay = new HashMap();
	        Map resourceParameter = new HashMap();
	        resourceParameter.put("startDate",startDate);
	        resourceParameter.put("endDate",endDate);
	        resourceParameter.put("resourceId",resourceId);
	        List ls = getSqlMapClientTemplate().queryForList("getPublishLockState",resourceParameter);
	        Iterator it =ls.iterator();
	        
	        while(it.hasNext()){
	        	DayInfo dayInfo = (DayInfo) it.next(); 
	        	Integer date = dayInfo.getPublishDate();
//	        	Object obj = dayInfo.getIsLocked();
//	        	String lock = (obj == null ||"".equals(obj))?"0":"1";
	        	Boolean isLock =  Boolean.valueOf( dayInfo.getIsLocked());
	        	orderDay.put(date,isLock);
	        }
	        
			return orderDay;
		}
	
	
	private String[] setTotalArray(Workspan workspan){
		 String totals[] = new  String[7];
		 totals[0] = workspan.getSunLength();//if(totals[1] == null || totals[1] == "") totals[1]= "0";
		 totals[1] = workspan.getMonLength();//if(totals[2] == null || totals[2] == "") totals[2]= "0";
		 totals[2] = workspan.getTueLength();//if(totals[3] == null || totals[3] == "") totals[3]= "0";
		 totals[3] = workspan.getWenLength();//if(totals[5] == null || totals[5] == "") totals[5]= "0";
		 totals[4] = workspan.getThiLength();//if(totals[4] == null || totals[4] == "") totals[4]= "0";
		 totals[5] = workspan.getFriLength();//if(totals[6] == null || totals[6] == "") totals[6]= "0";
		 totals[6] = workspan.getSatLength();//if(totals[7] == null || totals[7] == "") totals[7]= "0";
		 return totals;
	}
	
    public static final Date convertStringToDate(String aMask, String strDate)
    throws ParseException {
      SimpleDateFormat df = null;
      Date date = null;
      df = new SimpleDateFormat(aMask);

      try {
          date = df.parse(strDate);
      } catch (ParseException pe) {
          //log.error("ParseException: " + pe);
          throw new ParseException(pe.getMessage(), pe.getErrorOffset());
      }

      return (date);
  }	
	
    public static final String getDateTime(String aMask, Date aDate) {
        SimpleDateFormat df = null;
        String returnValue = "";

        if (aDate == null) {
//            log.error("aDate is null!");
        } else {
            df = new SimpleDateFormat(aMask);
            returnValue = df.format(aDate);
        }

        return (returnValue);
    }

	public PaginatedList getWorkspanPageByResoruceId(Long resId, int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getWorkspanByResourceId",resId,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}

	public Integer getWorkspanCountByResoruceId(String id) {
		return (Integer)getSqlMapClientTemplate().queryForObject("getWorkspanCountByResourceId", id);
	}	
	
	public List getResourceDayInfo(Integer publishDate,Long resourceId) {
		
		Map resourceParameter = new HashMap();
		
        resourceParameter.put("startDate",publishDate);
        resourceParameter.put("endDate",publishDate);
        resourceParameter.put("resourceId",resourceId);
        
		return getSqlMapClientTemplate().queryForList("getResDayInfosByOrderDetail",resourceParameter);		
	}
	public List getWorkspansByResourceIdList(Map mp) {
		
		return getSqlMapClientTemplate().queryForList("getWorkspansByResourceIdList",mp);		
	}
	


	
}
