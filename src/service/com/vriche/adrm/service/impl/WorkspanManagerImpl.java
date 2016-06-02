
package com.vriche.adrm.service.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.WorkspanDao;
import com.vriche.adrm.model.Workspan;
import com.vriche.adrm.service.WorkspanManager;
import com.vriche.adrm.util.DateUtil;
import com.vriche.adrm.util.StringUtil;
import com.vriche.adrm.util.SysParamUtil;

public class WorkspanManagerImpl extends BaseManager implements WorkspanManager {
    private WorkspanDao dao;

    
    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setWorkspanDao(WorkspanDao dao) {
        this.dao = dao;
    }

    /**
     * @see com.vriche.adrm.adres.service.WorkspanManager#getWorkspansByIdList(final Map idList)
     */
    public List getWorkspansByIdList(final Map idList) {
        List ls = dao.getWorkspansByIdList(idList);
    	convertTiomeByList(ls);
        return ls;
    }
   /**
     * @see com.vriche.adrm.adres.service.WorkspanManager#getWorkspans(com.vriche.adrm.adres.model.Workspan)
     */
    public List getWorkspans(final Workspan workspan) {
        List ls = dao.getWorkspans(workspan);
    	convertTiomeByList(ls);
    	return ls;	
    }
    
    

    public List getWorkspansByResourceId(String resourceId) {
    	List ls = dao.getWorkspansByResourceId(resourceId);
    	convertTiomeByList(ls);
    	return ls;	
    }

	/**
     * @see com.vriche.adrm.adres.service.WorkspanManager#getWorkspan(String id)
     */
    public Workspan getWorkspan(final String id) {
    	Workspan workspan = dao.getWorkspan(new Long(id));
    	setResourceLimitObj(workspan);
        return workspan;
    }

    /**
     * @see com.vriche.adrm.adres.service.WorkspanManager#saveWorkspan(Workspan workspan)
     */
    public void saveWorkspan(Workspan workspan) {
       	String ha = workspan.getBroadcastStartTh();
    	String ma = workspan.getBroadcastStartTm();
    	String sa = workspan.getBroadcastStartTs();
    	ha = (ha == null)|| "".equals(ha)||"null".equals(ha)||"00".equals(ha)?"0":ha;
    	ma = (ma == null)|| "".equals(ma)||"null".equals(ma)||"00".equals(ma)?"0":ma;
    	sa = (sa == null)|| "".equals(sa)||"null".equals(sa)||"00".equals(sa)?"0":sa;
     	int h = Integer.parseInt(ha);
    	int m  =Integer.parseInt(ma);	
    	int s =Integer.parseInt(sa);
    	Integer startTime = new Integer(h*3600+m*60+s);
    	workspan.setBroadcastStartTime(startTime);
    	
    	setBroadcastEndTime(workspan);
    	
        dao.saveWorkspan(workspan);
    }
    
    
    private int getADlengthFormWeek(Workspan workspan){
    	
    	int adTotalTimes = Integer.parseInt(StringUtil.getNullValue(workspan.getMonLength(),"0"));
    	
    	if(adTotalTimes  == 0){
    		adTotalTimes = Integer.parseInt(StringUtil.getNullValue(workspan.getTueLength(),"0"));
    	}
    	if(adTotalTimes  == 0){
    		adTotalTimes = Integer.parseInt(StringUtil.getNullValue(workspan.getThiLength(),"0"));
    	}
    	if(adTotalTimes  == 0){
    		adTotalTimes = Integer.parseInt(StringUtil.getNullValue(workspan.getFriLength(),"0"));
    	}
    	if(adTotalTimes  == 0){
    		adTotalTimes = Integer.parseInt(StringUtil.getNullValue(workspan.getWenLength(),"0"));
    	}
    	if(adTotalTimes  == 0){
    		adTotalTimes = Integer.parseInt(StringUtil.getNullValue(workspan.getFriLength(),"0"));
    	}
    	if(adTotalTimes  == 0){
    		adTotalTimes = Integer.parseInt(StringUtil.getNullValue(workspan.getSatLength(),"0"));
    	}
    	if(adTotalTimes  == 0){
    		adTotalTimes = Integer.parseInt(StringUtil.getNullValue(workspan.getSunLength(),"0"));
    	}
    	
    	return adTotalTimes;
    }
    
    private void setBroadcastEndTime(Workspan workspan){
    	int adTotalTimes = getADlengthFormWeek(workspan);
    	if(SysParamUtil.getWithBroPoint()){
    		Integer startTime = workspan.getBroadcastStartTime();
    		Integer endTime = new Integer(startTime.intValue() +adTotalTimes);
    		workspan.setBroadcastEndTime(endTime);
    	}
    }

    /**
     * @see com.vriche.adrm.adres.service.WorkspanManager#removeWorkspan(String id)
     */
    public void removeWorkspan(final String id) {
        dao.removeWorkspan(new Long(id));
    }

     /**
     * @see com.vriche.adrm.adres.service.WorkspanManager#removeWorkspans(String Map)
     */
    public void removeWorkspans(final Map idList) {
        dao.removeWorkspans(idList);
    }

	public PaginatedList getWorkspanPageByResoruceId(String resId, String pageIndex, String pageSize) {
		PaginatedList ls = dao.getWorkspanPageByResoruceId(new Long(resId),Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
		convertTiomeByList(ls);
		return ls;
	}

	public String getWorkspanCountByResoruceId(String id) {
		return dao.getWorkspanCountByResoruceId(id).toString();
	}    
	
	
	private void convertTiomeByList(List ls){
		for(Iterator it = ls.iterator();it.hasNext();){
			Workspan workspan = (Workspan)it.next();
			setResourceLimitObj(workspan);
		}
			
	}
	
	private void setResourceLimitObj(Workspan workspan){
		Integer startTime = workspan.getBroadcastStartTime() ;
		workspan.setBroadcastStartTh(DateUtil.converTime(startTime,1));
		workspan.setBroadcastStartTm(DateUtil.converTime(startTime,2));
		workspan.setBroadcastStartTs(DateUtil.converTime(startTime,3));	
	}
	
	public List getResourceDayInfo(Integer publishDate,Long resourceId){
		return dao.getResourceDayInfo(publishDate,resourceId);
	}
	
	public List getWorkspansByResourceIdList(String[] resourceIds){
		List resourceIdList =new ArrayList();
		Map mp= new HashMap();
		CollectionUtils.addAll(resourceIdList,resourceIds);
		mp.put("resourceIdList",resourceIdList);
		return dao.getWorkspansByResourceIdList(mp);   
	}
	
	

	public void resetAllSpecByOrderDayInfo(String year){
		
		
		Map mp = new HashMap();

		
		
		Long resourceId = new Long(0);
			Integer startDate = new Integer(0);
				Integer endDate = new Integer(0);
				String used ="";
				String specific ="";
				String sql = "";
				String sql1 = "";
				ResultSet rs;
				int i = 0;
				String key ="";
				
;		try {
	       Connection conn= dao.getDefaultDataSource().getConnection(); 
	       
	       ResultSet rs2 = dao.getDefaultDataSource().getConnection().createStatement().executeQuery("select ad_resource_info_id,ad_resource_workspan_id,publish_date,ad_resource_day_info_id from tb_ad_resource_day_info where version ="+year);
	   	   while(rs2.next()){
//				rs2.getString("ad_resource_day_info_id");
//				resourceId = (String)rs2.getString("ad_resource_info_id");
//				startDate =rs2.getString("publish_date");
				mp.put(rs2.getString("ad_resource_info_id")+rs2.getString("publish_date"),rs2.getString("ad_resource_day_info_id"));
	      	}

	       
	       conn.setAutoCommit(false);  
//	       sql = "update tb_ad_resource_day_info set ad_resource_specific=?,used=? where ad_resource_info_id=? and  publish_date=?";
	       sql = "update tb_ad_resource_day_info set ad_resource_specific=?,used=?,is_lock=? where ad_resource_day_info_id=? ";
	       PreparedStatement pst = conn.prepareStatement(sql);
	       
	      
//	         System.out.println("resourceId startDate endDate >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ");
//	       sql1 ="select A.ad_resource_info_id,B.begin_date,B.end_date from tb_ad_resource_info A left outer join tb_ad_resource_workspan B on A.ad_resource_info_id=B.ad_resource_info_id";
	       sql1 ="select A.ad_resource_info_id,A.begin_date,A.end_date from tb_ad_resource_workspan A INNER join tb_ad_resource_info B on A.ad_resource_info_id=B.ad_resource_info_id WHERE A.version ="+year;
	       

	       //	         sql ="select A.ad_resource_info_id ad id,B.begin_date as begin,B.end_date as end from tb_ad_resource_info A,tb_ad_resource_workspan B where  A.ad_resource_info_id=B.ad_resource_info_id";
//			ResultSet rs =  dao.getDefaultDataSource().getConnection().createStatement().executeQuery(sql);
//	         sql ="select * from tb_ad_resource_info";
			rs = dao.getDefaultDataSource().getConnection().createStatement().executeQuery(sql1);
			
			

			while (rs.next()){
				resourceId = Long.valueOf(String.valueOf(rs.getLong("ad_resource_info_id")));
				startDate =Integer.valueOf(rs.getString("begin_date"));
				endDate =  Integer.valueOf(rs.getString("end_date"));
				Map orderDayTimeSpecMap = dao.getOrderDayTimeSpec(startDate,endDate,resourceId); 
				Map orderDayTimeUsedMap = dao.getOrderDayTimeUsed(startDate,endDate,resourceId);
				Map orderDayLockStateMap = dao.getPublishLockState(startDate,endDate,resourceId);
				
//				System.out.println("resourceId startDate endDate >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> "+resourceId +"||"+startDate+"||"+endDate);
				
				Iterator it  =orderDayTimeUsedMap.keySet().iterator();
				
				
				while(it.hasNext()){
					Integer date = (Integer)it.next();
					specific  = StringUtil.null2String(orderDayTimeSpecMap.get(date));
					used  =    StringUtil.getNullValue(orderDayTimeUsedMap.get(date),"0");
					used  =  "".equals(used)?"0":used;
					
					String bislock  =    StringUtil.getNullValue(orderDayLockStateMap.get(date),"0");
					bislock = "true".equals(bislock)?"1":"0";
					
					pst.setString(1, specific);  
					pst.setString(2, ""+Math.round(Double.valueOf(used).floatValue()));  
					pst.setString(3, bislock);  
					key = StringUtil.null2String(mp.get(resourceId.toString()+date.toString()));
					key = key == "" ?"0":key;
					pst.setInt(4, Integer.parseInt(key));  
//					pst.setInt(4, date.intValue());  
//					System.out.println("ad_resource_day_info_id  >>>>>>>>>>>>>>>>>> "+String.valueOf(mp.get(resourceId.toString()+date.toString())));
					pst.addBatch();
//					OrderDayInfo orderDayInfo = new OrderDayInfo();
//					orderDayInfo.setId(new Long(resourceId));
//					orderDayInfo.setAdDayTimes(new Integer(date));
//					orderDayInfo.setAdlength(used);
//					orderDayInfo.setToaccountTotal(""+ Math.round(Double.valueOf(used)));
//					ls.add(orderDayInfo);
					
					i++;
//					Math.round(Double.valueOf(used));
//					System.out.println("date used specific>>>>>>>>>>>>>>>>> "+i+"__"+resourceId +"||"+date+"||"+used +"||"+specific);
//					sql="update tb_ad_resource_day_info set ad_resource_specific='"+ specific +"',used='"+ ""+Math.round(Double.valueOf(used)) +"' where ad_resource_info_id="+ resourceId + " and  publish_date="+date.longValue();
//					dao.getDefaultDataSource().getConnection().createStatement().execute(sql);
//					pst.addBatch(sql);
//					System.out.println("sql  >>>>>>>>>>>>>>>>>> "+sql);
//					dao.getDefaultDataSource().getConnection().createStatement().addBatch(sql);
//					dao.getDefaultDataSource().getConnection().createStatement().execute(sql);
					
					 if (i % 20000 == 0) {  
						             System.out.println("executeBatch ......... ");
						             pst.executeBatch();  
//						             System.out.println("sql 2 >>>>>>>>>>>>>>>>>> ");
						             conn.commit();  
//						             System.out.println("sql 3 >>>>>>>>>>>>>>>>>> ");
						             conn.setAutoCommit(false);  
						             pst = conn.prepareStatement(sql);  
						             pst.clearBatch();
						         }  
				    }
				
			}
			 if (i % 20000 != 0) {  
					pst.executeBatch();
					conn.commit();
			 }
			pst.close();  
			conn.close(); 

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
	
	public void saveDayinfoByWorkspan(String version) {
		//先删除资源日信息
		Map mp = new HashMap();
		Workspan workspanParam = new Workspan();
		workspanParam.setVersion(Integer.valueOf(version));
        List ls = dao.getWorkspans(workspanParam);
        System.out.println("saveDayinfoByWorkspan Workspan count >>>>>>>>>>>>>>>>>> "+ ls.size());
        Iterator it = ls.iterator();
        while(it.hasNext()){
        	Workspan ws = (Workspan)it.next();
        	Long id = ws.getId();
   
        	 System.out.println("saveDayinfoByWorkspan Workspan id >>>>>>>>>>>>>>>>>> "+ id);
         	dao.removeResourceDayInfo(id,ws.getBeginDate(),ws.getEndDate());
         	dao.addResourceDayInfo(ws);	

        }

		
	}
	
}
