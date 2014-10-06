
package com.vriche.adrm.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Iterator;

import org.apache.commons.collections.CollectionUtils;

import com.vriche.adrm.Constants;
import com.vriche.adrm.service.impl.BaseManager;
import com.vriche.adrm.model.Carrier;
import com.vriche.adrm.model.FusionChartObject;
import com.vriche.adrm.model.ProOrder;
import com.vriche.adrm.model.ProPublishPlan;
import com.vriche.adrm.model.ProPublishPlanDetail;
import com.vriche.adrm.dao.ProPublishPlanDao;
import com.vriche.adrm.service.ProPublishPlanManager;
import com.vriche.adrm.util.DateUtil;
import com.vriche.adrm.util.StringUtil;

public class ProPublishPlanManagerImpl extends BaseManager implements ProPublishPlanManager {
    private ProPublishPlanDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setProPublishPlanDao(ProPublishPlanDao dao) {
        this.dao = dao;
    }
    /**
     * @see com.vriche.adrm.service.ProPublishPlanManager#getProPublishPlans(com.vriche.adrm.model.ProPublishPlan)
     */
    public List getProPublishPlan(final ProPublishPlan proPublishPlan) {
        return dao.getProPublishPlans(proPublishPlan);    
    }
   /**
     * @see com.vriche.adrm.service.ProPublishPlanManager#getProPublishPlans(com.vriche.adrm.model.ProPublishPlan)
     */
    public ProPublishPlan getProPublishPlans(final ProPublishPlan proPublishPlan) {
        List ls = dao.getProPublishPlans(proPublishPlan);
        ProPublishPlan pro=new ProPublishPlan();
        for(Iterator it=ls.iterator();it.hasNext();){
        	ProPublishPlan obj=(ProPublishPlan)it.next();
        	pro.setCarrierId(obj.getCarrierId());
        	pro.setWeeksPlan(obj.getWeeksPlan());
			String startTime = DateUtil.formatTime(obj.getStartTime().longValue(),"h:m");
			String endTime = DateUtil.formatTime(obj.getEndTime().longValue(),"h:m");
			pro.setStartDate(Integer.valueOf(startTime.substring(1,3)));
			pro.setStartTime(Integer.valueOf(startTime.substring(4,6)));
			pro.setEndDate(Integer.valueOf(endTime.substring(1,3)));
			pro.setEndTime(Integer.valueOf(endTime.substring(4,6)));
        }
        return pro;
    }
   /**
     * @see com.vriche.adrm.service.ProPublishPlanManager#getProPublishPlansCount(com.vriche.adrm.model.ProPublishPlan)
     */
    public String getProPublishPlansCount(final ProPublishPlan proPublishPlan) {
        return dao.getProPublishPlansCount(proPublishPlan).toString();
    }    

   /**
     * @see com.vriche.adrm.service.ProPublishPlanManager#getProPublishPlansCount(com.vriche.adrm.model.ProPublishPlan)
     */    
	public List getProPublishPlansPage(final ProPublishPlan proPublishPlan,String pageIndex, String pageSize) {
		return dao.getProPublishPlansPage(proPublishPlan,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    
   /**
     * @see com.vriche.adrm.service.ProPublishPlanManager#getProPublishPlansCount(com.vriche.adrm.model.ProPublishPlan)
     */    
	public String getProPublishPlansPageXML(final ProPublishPlan proPublishPlan,String pageIndex, String pageSize) {
	    StringBuffer sb = new StringBuffer();
	    List ls = dao.getProPublishPlansPage(proPublishPlan,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");   
		for(Iterator it = ls.iterator();it.hasNext();){
			ProPublishPlan obj = (ProPublishPlan)it.next();
			sb.append("<row  id=\""+ obj  +"\"" +">");
			sb.append("<cell><![CDATA["+ obj  +"]]></cell>");
			sb.append("</row>");
		}
		sb.append("</rows>");	
		return sb.toString();
	}    

    /**
     * @see com.vriche.adrm.service.ProPublishPlanManager#getProPublishPlan(String id)
     */
    public ProPublishPlan getProPublishPlan(final String id) {
        return dao.getProPublishPlan(new Long(id));
    }
    /**
     * @see com.vriche.adrm.service.ProPublishPlanManager#getProPublishPlansByIdList(final Map idList)
     */
    public List getProPublishPlansByMap(final Map mp) {
        return dao.getProPublishPlansByMap(mp);
    }    

    /**
     * @see com.vriche.adrm.service.ProPublishPlanManager#saveProPublishPlan(ProPublishPlan proPublishPlan)
     */
    public String saveProPublishPlan(ProPublishPlan proPublishPlan) {
        return dao.saveProPublishPlan(proPublishPlan).toString();
    }
    
    public String saveProPublishPlanById(ProPublishPlan proPublishPlan) {
    	ProPublishPlan proPPlan = new ProPublishPlan();
    	proPPlan.setId(proPublishPlan.getId());

    	int size = dao.getProPublishPlansCount(proPPlan).intValue();

    	if(size==0)proPublishPlan.setId(new Long(0));
    	Long planId = dao.saveProPublishPlan(proPublishPlan);

//    	proPPlan.setId(planId);
//    	proPPlan.setStartDate(proPublishPlan.getStartDate());
//    	proPPlan.setEndDate(proPublishPlan.getEndDate());
//    	proPPlan.setWeeksPlan(proPublishPlan.getWeeksPlan());
//    	saveProPublishPlanDetail(proPPlan);
    	return planId.toString();
	}    
    public void saveProPublishPlanDetail(ProPublishPlan proPlanDetail) {
    	List weeksPlanList = new ArrayList();
    	String weeksPlan = proPlanDetail.getWeeksPlan();
		CollectionUtils.addAll(weeksPlanList,weeksPlan.split(","));
    	dao.saveProPublishPlanDetail(proPlanDetail,weeksPlanList);
    }

    public void saveProPublishPlanDetails(ProPublishPlanDetail proPlanDetail) {
    	dao.saveProPublishPlanDetail(proPlanDetail);	
    }

    /**
     * @see com.vriche.adrm.service.ProPublishPlanManager#removeProPublishPlan(String id)
     */
    public void removeProPublishPlan(final String id) {
        dao.removeProPublishPlan(new Long(id));
    }

     /**
     * @see com.vriche.adrm.service.ProPublishPlanManager#removeProPublishPlans(String Map)
     */
    public void removeProPublishPlans(final Map mp) {
        dao.removeProPublishPlans(mp);
    }
    //有条件的计算订单数
	public String getProPublishPlanCount(String proName, ProPublishPlan proPublishPlan) {
		proPublishPlan.getProProgram().setProName(proName);
		return dao.getProPublishPlansCount(proPublishPlan).toString();
	}
	public String getProPublishPlanPageXML(String proName, ProPublishPlan proPublishPlan, String pageIndex, String pageSize) {
		int i=1;
		proPublishPlan.getProProgram().setProName(proName);
		StringBuffer sb = new StringBuffer();
		    List ls = dao.getProPublishPlansPage(proPublishPlan,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<rows>");   
			for(Iterator it = ls.iterator();it.hasNext();){
				//序号,节目名称,频道,开始日期,结束日期,开始时间,结束时间,播出排期"
				ProPublishPlan obj = (ProPublishPlan)it.next();
				
				String startDate = DateUtil.SetDateFormat(obj.getStartDate().toString(),"yyyy/MM/dd");
				String endDate = DateUtil.SetDateFormat(obj.getEndDate().toString(),"yyyy/MM/dd");
				String startTime = DateUtil.formatTime(obj.getStartTime().longValue(),"h:m");
				String endTime = DateUtil.formatTime(obj.getEndTime().longValue(),"h:m");
				sb.append("<row  id=\""+ obj.getId()  +"\"" +">");
				sb.append("<cell><![CDATA["+ i++  +"]]></cell>");
				sb.append("<cell><![CDATA["+ obj.getVersion()  +"]]></cell>");
				sb.append("<cell><![CDATA["+ obj.getCarrierId()  +"]]></cell>");
				sb.append("<cell><![CDATA["+ startDate  +"]]></cell>");
				sb.append("<cell><![CDATA["+ endDate  +"]]></cell>");
				sb.append("<cell><![CDATA["+ startTime  +"]]></cell>");
				sb.append("<cell><![CDATA["+ endTime  +"]]></cell>");
				sb.append("<cell><![CDATA["+ obj.getWeeksPlan()  +"]]></cell>");
				sb.append("<cell><![CDATA["+ obj.getProgramId()  +"]]></cell>");
				sb.append("</row>");
			}
			sb.append("</rows>");	
			return sb.toString();
	}
	public String getProPublishPlanXML(ProPublishPlan proPublishPlan) {
			int i=1;
			StringBuffer sb = new StringBuffer();
		    List ls = dao.getProPublishPlan(proPublishPlan);
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<rows>");   
			for(Iterator it = ls.iterator();it.hasNext();){
				ProPublishPlan obj = (ProPublishPlan)it.next();
				//System.out.println(obj.getStartDate()==null);
				String startDate = obj.getStartDate()==null?"":DateUtil.SetDateFormat(obj.getStartDate().toString(),"yyyy/MM/dd");
				String endDate = obj.getEndDate()==null?"":DateUtil.SetDateFormat(obj.getEndDate().toString(),"yyyy/MM/dd");
				String startTime = DateUtil.formatTime(obj.getStartTime().longValue(),"h:m");
				String endTime = DateUtil.formatTime(obj.getEndTime().longValue(),"h:m");
				String sumTimes=obj.getProgramId()==null?"":obj.getProgramId().toString();
				sb.append("<row  id=\""+ obj.getId()  +"\"" +">");
				sb.append("<cell><![CDATA["+ i++  +"]]></cell>");
				sb.append("<cell><![CDATA["+ obj.getCarrierId()  +"]]></cell>");
				sb.append("<cell><![CDATA["+ obj.getWeeksPlan()  +"]]></cell>");
				sb.append("<cell><![CDATA["+ startDate  +"]]></cell>");
				sb.append("<cell><![CDATA["+ endDate  +"]]></cell>");
				sb.append("<cell><![CDATA["+ startTime  +"]]></cell>");
				sb.append("<cell><![CDATA["+ endTime  +"]]></cell>");
				sb.append("<cell><![CDATA["+ sumTimes  +"]]></cell>");
				sb.append("</row>");
			}
			sb.append("</rows>");	
			return sb.toString();
	}
	public String getProPublishPlanDetailXML(String id) {
		StringBuffer sb = new StringBuffer();
		int j=0;
		int k=0;
		int m=0;
		int year=0;
		boolean isExist=false;
		List ls = dao.getProPublishPlanDetail(id);
		List lst = dao.getProPublishPlanDetails(id);
		String[] times=new String[ls.size()];
		String[] dayNum=new String[ls.size()];
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");   

		for(Iterator it = ls.iterator();it.hasNext();){
			ProPublishPlanDetail obj = (ProPublishPlanDetail)it.next();			    
				times[j++]=obj.getDayTimes().toString();
				dayNum[k++]=obj.getPlanDate().toString();
		}
		
			for(Iterator it = lst.iterator();it.hasNext();){
				ProPublishPlanDetail obj = (ProPublishPlanDetail)it.next();
				String yearMonth=obj.getPlanDate().toString().substring(0,6);
				sb.append("<row  id=\""+ obj.getPublishPlanId()+obj.getPlanDate().toString().substring(0,6) +"\"" +">");
				if(year!=Integer.parseInt(obj.getPlanDate().toString().substring(0,4))){
					year=Integer.parseInt(obj.getPlanDate().toString().substring(0,4));
					sb.append("<cell><![CDATA["+ obj.getPlanDate().toString().substring(0,4)  +"]]></cell>");
				}else{
					sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
				}
				sb.append("<cell><![CDATA["+ obj.getPlanDate().toString().substring(4,6)  +"]]></cell>");
				for(int i=1;i<=31;i++){
					for(int n=0;n<ls.size();n++){
						if(i<10){
							isExist=dayNum[n].equals(yearMonth+"0"+i);
						}else{
							isExist=dayNum[n].equals(yearMonth+i);
						}
						if(!isExist){
						    continue;
						}else{
							sb.append("<cell><![CDATA["+  times[m++] +"]]></cell>");
							break;					
						}
					}
					if(isExist) continue;
						
					sb.append("<cell><![CDATA["+  "" +"]]></cell>");
				}
			sb.append("</row>");
			}
			sb.append("</rows>");
			return sb.toString();
	}
	public void removeProPublishPlanDetail(Long id) {
		 dao.removeProPublishPlanDetail(id);
	}
	
	public Collection getCollections(final String queryString,String type) {
		int j=1;
		String programName = StringUtil.getParamFromUrl(queryString,"programName");
		String startDates = StringUtil.getParamFromUrl(queryString,"startDate");
		Integer start=startDates.equals("")?null:new Integer(startDates);
		String endDates = StringUtil.getParamFromUrl(queryString,"endDate");
		Integer end=startDates.equals("")?null:new Integer(endDates);
		
		ProPublishPlan proPublishPlan=new ProPublishPlan();
		proPublishPlan.getProProgram().setProName(programName);
		proPublishPlan.setStartDate(start);
		proPublishPlan.setEndDate(end);
		
		List ls = dao.getProPublishPlanCollection(proPublishPlan);
		
		Collection coll = new ArrayList();
		List valuecoll = new ArrayList();
		
		int cols = 9;

		for(Iterator it = ls.iterator();it.hasNext();){
			
			ProPublishPlan obj = (ProPublishPlan)it.next();
			
			String startDate = obj.getStartDate().toString().equals("0")?"":obj.getStartDate().toString();
			String endDate = obj.getEndDate().toString().equals("0")?"":obj.getEndDate().toString();
			String startTime = DateUtil.formatTime(obj.getStartTime().longValue(),"h:m");
			String endTime = DateUtil.formatTime(obj.getEndTime().longValue(),"h:m");

			FusionChartObject fObject = new FusionChartObject();
			
			if(type.equals("report")){
				for(int i=1;i<cols+1;i++){
					switch(i){
						case 1:
							fObject.setValue1(String.valueOf(j++));break;
						case 2:
							fObject.setValue2(obj.getProProgram().getProName());break;
						case 3:
							fObject.setValue3(obj.getCarrier().getCarrierName());break;
						case 4:
							fObject.setValue4(DateUtil.SetDateFormat(startDate,"yyyy/MM/dd"));break;
						case 5:
							fObject.setValue5(DateUtil.SetDateFormat(endDate,"yyyy/MM/dd"));break;
						case 6:
							fObject.setValue6(startTime);break;
						case 7:						
							fObject.setValue7(endTime);break;
						case 8:						
							fObject.setValue8(obj.getWeeksPlan());break;
						case 9:						
							fObject.setValue9(obj.getProgramId().toString());break;
						default :
					}
				}
			}

			valuecoll.add(fObject);
		}
		
		
		
		CollectionUtils.addAll(coll,valuecoll.iterator());
		
		return coll;	
		
	}


	
}
