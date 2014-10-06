
package com.vriche.adrm.dao.ibatis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ObjectRetrievalFailureException;

import com.vriche.adrm.dao.PublishedInfoDao;
import com.vriche.adrm.model.PublishedInfo;

public class PublishedInfoDaoiBatis extends BaseDaoiBATIS implements PublishedInfoDao {
	
	StringBuffer sb = new StringBuffer("");
	List adverList = new ArrayList();
	

    /**
     * @see com.vriche.adrm.adver.dao.PublishedInfoDao#getPublishedInfos(com.vriche.adrm.adver.model.PublishedInfo)
     */
    public List getPublishedInfos(final PublishedInfo publishedInfo) {
          return getSqlMapClientTemplate().queryForList("getPublishedInfos", publishedInfo);
    }
    
    public List getPublishedInfosByHistory(String resourceIds,String publishDate) {
    	adverList.clear();
    	
    	String ids[] = resourceIds.split(",");
		Map mp = new HashMap();
		List rsIdList = new ArrayList();
		for (int i = 0 ;i<ids.length;i++) rsIdList.add(ids[i]);
		
		mp.put("ResourceIdList",rsIdList);
		mp.put("publishDate",publishDate);

		adverList =  getSqlMapClientTemplate().queryForList("getPublishedInfosByHistory",mp);	
	
		makeDhtmlGridXMLByHistory(adverList);
        return adverList;
  }   
    
    
    public Collection getPublishedInfosByHistoryColl(String resourceIds,String publishDate) {
    	Collection adverColl = new ArrayList();
    	String ids[] = resourceIds.split(",");
		Map mp = new HashMap();
		List rsIdList = new ArrayList();
		for (int i = 0 ;i<ids.length;i++) rsIdList.add(ids[i]);
		
		mp.put("ResourceIdList",rsIdList);
		mp.put("publishDate",publishDate);

		Iterator it =  getSqlMapClientTemplate().queryForList("getPublishedInfosByHistoryColl",mp).iterator();	
		
		while (it.hasNext()){
			PublishedInfo publishedInfo = (PublishedInfo)it.next();	
			adverColl.add(publishedInfo);
		}

        return adverColl;
  }      
    
    
    
   private void makeDhtmlGridXMLByHistory(List ls){
   	sb.delete(0,sb.length());
	sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
	sb.append("<rows>");    
	int rowNum = 0;
	
	Iterator it = ls.iterator();
	while(it.hasNext()){
		sb.append("<row id=\""+ rowNum++ +"\">");
		PublishedInfo publishedInfo = (PublishedInfo)it.next();	
		String type = publishedInfo.getOrderDayInfoId().toString();
		sb.append("<cell>" + publishedInfo.getPublishOrder() +"</cell>");
		sb.append("<cell><![CDATA[" + publishedInfo.getTapeCode()     +"]]></cell>");
		sb.append("<cell><![CDATA[" + publishedInfo.getMatterName()   +"]]></cell>");
		sb.append("<cell><![CDATA[" + publishedInfo.getMatterEdit()   +"]]></cell>");
		sb.append("<cell>" + publishedInfo.getMatterLength() +"</cell>");
		sb.append("<cell>" + publishedInfo.getAppPosition()  +"</cell>");
		if (type =="0" || type =="-1"){
			sb.append("<cell>"+""+"</cell>");
		}else{
			sb.append("<cell><![CDATA[ <a target=_blank href=editOrder.html?id="+ publishedInfo.getOrderId()+">" + publishedInfo.getOrderCode() +"</a>]]></cell>");	
		}
		sb.append("<cell>" + publishedInfo.getLinkUser() +"</cell>");
	
		sb.append("</row>");	
	}
		
	sb.append("</rows>");
   }
    

    
    
    public List getPublishedInfosByResourceIds(String resourceIds,String publishDate) {
    	
    	String ids[] = resourceIds.split(",");
    	
    	adverList.clear();
    	sb.delete(0,sb.length());
    	
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");   	
    	
		int kk = 0;
    	for(int i = 0 ;i < ids.length; i++){
    		//order by 指定参数
    		Map mp = new HashMap();
    		mp.put("resourceId",ids[i]);
    		mp.put("publishDate",publishDate);
    		//广告
    		List adList =  getSqlMapClientTemplate().queryForList("getPublishedInfosByResourceId",mp);	
    		if(adList.size() > 0) kk++;
    		setadverList(adList);
    		makeDhtmlGridXML(adList,ids[i], "adRow","1");
    		//总结行
    		if(adList.size()>0){
        		List sumRowList =  getSqlMapClientTemplate().queryForList("getOneDayResourceInfo",mp);	
        		setadverList(sumRowList);
        		makeDhtmlGridXML(sumRowList,ids[i],"sumRow","0");   			
    		}

    	}
    	
    	//所有广告资源的总结行
    	if(ids.length > 1 && kk >1){
    		Map mp = new HashMap();
    		List rsIdList = new ArrayList();
    		for (int i = 0 ;i<ids.length;i++) rsIdList.add(ids[i]);
    		
    		mp.put("ResourceIdList",rsIdList);
    		mp.put("publishDate",publishDate);
    		List LastSumRowList =  getSqlMapClientTemplate().queryForList("getOneDayResourceInfos",mp);	
    		setadverList(LastSumRowList);
    		makeDhtmlGridXML(LastSumRowList,"0","sumRow","-1");
    	}
    	
		sb.append("</rows>");
//		System.out.println("adverList0="+adverList);
        return adverList;
	}
    
   public List getInfosByResourceIds(String resourceIds,String publishDate) {
	   
//	   System.out.println("ids=="+resourceIds);
	   
	   
	   
		int rowNum = 0;
		
	   	String ids[] = resourceIds.split(",");
	   	
	   	adverList.clear();
	   	sb.delete(0,sb.length());
	   	
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");
				
		
	   	for(int i = 0 ;i < ids.length; i++){
	   			   		
	   		
	   		//order by 指定参数
	   		Map mp = new HashMap();
	   		mp.put("resourceId",ids[i]);
	   		mp.put("publishDate",publishDate);
	   		mp.put("date",publishDate);
	   		    		
	   		//广告
	   		List adList =  getSqlMapClientTemplate().queryForList("getInfosByResourceId",mp);
	   			   		
	   		setadverList(adList);
	   		
	   		if(adList.size() > 0) {
	   			rowNum = rowNum+1; 
	   			makeDhtml_GridXML(adList,ids[i], "adRow","1",rowNum);
	   		}
	
	   	}

	   	
		sb.append("</rows>");
	    return adverList;
	}
   
	public String getPublishedInfosByResourceIdsXML(String resourceIds,String publishDate,int model) {
		
		
		List ls = new ArrayList();
		//如果
		if(model == 0){
			ls = this.getPublishedInfosByResourceIds(resourceIds,publishDate);
		}else{
			ls = this.getPublishedInfosByHistory(resourceIds,publishDate);
		}
		
		if (ls.size() >0 ) {
			return sb.toString();
		}else{
			return "";
		}
	}

	public String getInfosByResourceIdsXML(String resourceIds, String publishDate, int model) {
		List ls = new ArrayList();
		//如果
		if(model == 0){
			ls = this.getInfosByResourceIds(resourceIds,publishDate);
		}else{
			ls = this.getPublishedInfosByHistory(resourceIds,publishDate);
		}
		
		if (ls.size() >0 ) {
			return sb.toString();
		}else{
			return "";
		}
	} 	
	
	public Integer getPublishedCount(String resourceIds,String publishDate){
				
		Map mp = new HashMap();
		List rsIdList = new ArrayList();
		String ids[] = resourceIds.split(",");
		for (int i = 0 ;i<ids.length;i++) rsIdList.add(ids[i]);
		mp.put("ResourceIdList",rsIdList);
		mp.put("publishDate",publishDate);
		Integer count =  (Integer)getSqlMapClientTemplate().queryForObject("getPublishedCount",mp);
				
        return count;
	}
	
	
	
	
	
	private void makeDhtmlGridXML(List ls,String resourceId,String idFag,String type){
		
		String rowNumStr="";
		int rowNum = 0;
		
		Iterator it = ls.iterator();
		while(it.hasNext()){
			PublishedInfo publishedInfo = (PublishedInfo)it.next();
			int dayTimes = publishedInfo.getDayTimes().intValue();
			
		    for (int i = 0;i < dayTimes;i++){
			    rowNum = rowNum+1;
			    if (type =="1") rowNumStr = String.valueOf(rowNum);
//			    if (type =="1" && publishedInfo.getAppPosition() !="") appPosition = publishedInfo.getAppPosition();
			    String rowId = resourceId +"_"+ idFag +"_"+ publishedInfo.getOrderDayInfoId()+"_"+ rowNum;
			    
			    
				sb.append("<row id=\""+ rowId +"\">");
				//用户数据
				sb.append("<userdata name=\"resourceId\">" + resourceId +  "</userdata>");
				sb.append("<userdata name=\"idFag\">" + idFag +  "</userdata>");
				sb.append("<userdata name=\"rowNum\">" + rowNum +  "</userdata>");
				//type:1是广告 2是总结行
				sb.append("<userdata name=\"type\">" + type +  "</userdata>");
				
				sb.append("<userdata name=\"orderId\">" + publishedInfo.getOrderId() +  "</userdata>");	
				sb.append("<userdata name=\"carrierId\">" + publishedInfo.getCarrierId() +  "</userdata>");
				sb.append("<userdata name=\"resourceType\">" + publishedInfo.getResourceType() +  "</userdata>");
				sb.append("<userdata name=\"orderDayInfoId\">" + publishedInfo.getOrderDayInfoId() +  "</userdata>");
				sb.append("<userdata name=\"linkUserId\">" + publishedInfo.getLinkUserId() +  "</userdata>");	
				sb.append("<userdata name=\"customerId\">" + publishedInfo.getCustomerId() +  "</userdata>");
				sb.append("<userdata name=\"adContent\">" + publishedInfo.getAdContent() +  "</userdata>");
				
				sb.append("<userdata name=\"resourceCarrier\">" + publishedInfo.getResourceCarrier() +  "</userdata>");	
				sb.append("<userdata name=\"linkUser\">" + publishedInfo.getLinkUser() +  "</userdata>");	
				sb.append("<userdata name=\"adverMatterId\">" + publishedInfo.getAdverMatterId() +  "</userdata>");	
				sb.append("<userdata name=\"publishDate\">" + publishedInfo.getPublishDate() +  "</userdata>");	
				sb.append("<userdata name=\"orderCode\">" + publishedInfo.getOrderCode() +  "</userdata>");	
				sb.append("<userdata name=\"tapeCode\"><![CDATA[" + publishedInfo.getTapeCode() +  "]]></userdata>");
				sb.append("<userdata name=\"matterName\"><![CDATA[" + publishedInfo.getMatterName() +  "]]></userdata>");
				sb.append("<userdata name=\"matterEdit\"><![CDATA[" + publishedInfo.getMatterEdit() +  "]]></userdata>");
				sb.append("<userdata name=\"matterLength\">" + publishedInfo.getMatterLength() +  "</userdata>");
				sb.append("<userdata name=\"appPosition\">" + publishedInfo.getAppPosition() +  "</userdata>");	
				sb.append("<userdata name=\"customerName\"><![CDATA[" + publishedInfo.getCustomerName() +  "]]></userdata>");	
				
				//总结行
				if (type =="0" || type =="-1"){
					//总结行的剩余时间  
//					System.out.println("总结行的剩余时间" + (new Double(publishedInfo.getAppPosition())).intValue());
					sb.append("<userdata name=\"totalTimes\">" + (new Double(publishedInfo.getMatterEdit())).intValue() +  "</userdata>");
					sb.append("<userdata name=\"usedTimes\">" + (new Double(publishedInfo.getMatterLength())).intValue() +  "</userdata>");
					sb.append("<userdata name=\"leaveTimes\">" + (new Double(publishedInfo.getAppPosition())).intValue() +  "</userdata>");	
					sb.append("<userdata name=\"appPosition\">" + (new Double(publishedInfo.getAppPosition())).intValue() +  "</userdata>");	
				}
				
				sb.append("<cell>" + rowNumStr                 	     +"</cell>");
				sb.append("<cell><![CDATA[" + publishedInfo.getTapeCode()     +"]]></cell>");
				sb.append("<cell><![CDATA[" + publishedInfo.getMatterName()   +"]]></cell>");
				
				if (type =="0" || type =="-1"){
					sb.append("<cell>" + (new Double(publishedInfo.getMatterEdit())).intValue()   +"</cell>");
					sb.append("<cell>" + (new Double(publishedInfo.getMatterLength())).intValue() +"</cell>");
					sb.append("<cell>" + (new Double(publishedInfo.getAppPosition())).intValue()  +"</cell>");					
				}else{
					sb.append("<cell><![CDATA[" + publishedInfo.getMatterEdit()   +"]]></cell>");
					sb.append("<cell>" + publishedInfo.getMatterLength() +"</cell>");
					sb.append("<cell>" + publishedInfo.getAppPosition()  +"</cell>");					
				}

				if (type =="0" || type =="-1"){
					sb.append("<cell>"+""+"</cell>");
				}else{
					sb.append("<cell><![CDATA[ <a target=_blank href=editOrder.html?id="+ publishedInfo.getOrderId()+">" + publishedInfo.getOrderCode() +"</a>]]></cell>");	
				}
				sb.append("<cell>" + publishedInfo.getLinkUser() +"</cell>");
				
				sb.append("</row>");
				
//				System.out.println("sb="+sb.toString());
		   }
		}		
	}
	
	private void makeDhtml_GridXML(List ls,String resourceId,String idFag,String type,int rowNum){

//    	System.out.println("ls==="+ls.size());
    	
		String rowNumStr="";
		Iterator it = ls.iterator();
		String content = "";
		String memo = "";
		String total = "";
		String pos = "";
		
		sb.append("<row id=\""+ resourceId +"_"+ "adRow" +"_"+ rowNum +"\">");
			
		while(it.hasNext()){
			PublishedInfo publishedInfo = (PublishedInfo)it.next();
    		
    		if (type =="1") rowNumStr = String.valueOf(rowNum);
    		
			int dayTimes = publishedInfo.getDayTimes().intValue();
			
			

//		    for (int i = 0;i < dayTimes;i++){
			    
				//用户数据
				sb.append("<userdata name=\"resourceId\">" + resourceId +  "</userdata>");
				sb.append("<userdata name=\"idFag\">" + idFag +  "</userdata>");
				sb.append("<userdata name=\"rowNum\">" + rowNum +  "</userdata>");
				//type:1是广告 2是总结行
				sb.append("<userdata name=\"type\">" + type +  "</userdata>");
				
				
				sb.append("<userdata name=\"orderId\">" + publishedInfo.getOrderId() +  "</userdata>");	
				sb.append("<userdata name=\"carrierId\">" + publishedInfo.getCarrierId() +  "</userdata>");
				sb.append("<userdata name=\"resourceType\">" + publishedInfo.getResourceType() +  "</userdata>");
				sb.append("<userdata name=\"orderDayInfoId\">" + publishedInfo.getOrderDayInfoId() +  "</userdata>");
				sb.append("<userdata name=\"linkUserId\">" + publishedInfo.getLinkUserId() +  "</userdata>");	
				sb.append("<userdata name=\"customerId\">" + publishedInfo.getCustomerId() +  "</userdata>");
				
				sb.append("<userdata name=\"resourceCarrier\">" + publishedInfo.getResourceCarrier() +  "</userdata>");	
				sb.append("<userdata name=\"linkUser\">" + publishedInfo.getLinkUser() +  "</userdata>");	
				sb.append("<userdata name=\"adverMatterId\">" + publishedInfo.getAdverMatterId() +  "</userdata>");	
				sb.append("<userdata name=\"publishDate\">" + publishedInfo.getPublishDate() +  "</userdata>");	
				sb.append("<userdata name=\"orderCode\">" + publishedInfo.getOrderCode() +  "</userdata>");	
				sb.append("<userdata name=\"tapeCode\"><![CDATA[" + publishedInfo.getTapeCode() +  "]]></userdata>");
				sb.append("<userdata name=\"matterName\"><![CDATA[" + publishedInfo.getMatterName() +  "]]></userdata>");
				sb.append("<userdata name=\"matterEdit\"><![CDATA[" + publishedInfo.getMatterEdit() +  "]]></userdata>");
				sb.append("<userdata name=\"matterLength\">" + publishedInfo.getMatterLength() +  "</userdata>");
				sb.append("<userdata name=\"appPosition\">" + publishedInfo.getAppPosition() +  "</userdata>");	
				sb.append("<userdata name=\"publishMemo\">" + publishedInfo.getPublishMemo() +  "</userdata>");	
				sb.append("<userdata name=\"customerName\"><![CDATA[" + publishedInfo.getCustomerName() +  "]]></userdata>");
				
//				String con =  publishedInfo.getMatterName() + "("+publishedInfo.getMatterEdit()+")"+
//				publishedInfo.getMatterLength()+"”"+" || ";
//				
//				content += con;
				
//		    }
			String con =  publishedInfo.getMatterName() + "("+publishedInfo.getMatterEdit()+")"+
			publishedInfo.getMatterLength()+"”("+dayTimes+"次)"+" || ";
			
			content += con;
			
		    int count = new Double(publishedInfo.getAppPosition()).intValue();
		    count = count/60;
		    pos = publishedInfo.getPosition();
		    memo = publishedInfo.getPublishMemo();
		    total = count+"'";
		}

	    sb.append("<cell>" + rowNumStr +"</cell>");
	    sb.append("<cell>" + pos +"</cell>");
	    sb.append("<cell>" + memo +"</cell>");
	    sb.append("<cell>" + total +"</cell>");
		sb.append("<cell>" + content +"</cell>");				
		sb.append("</row>");	
	}	
	
	private void setadverList(List ls){
		Iterator it =  ls.iterator();
		while(it.hasNext()){
			PublishedInfo publishedInfo = (PublishedInfo)it.next();
			adverList.add(publishedInfo);
		}
	}
	


	/**
     * @see com.vriche.adrm.adver.dao.PublishedInfoDao#getPublishedInfosByIdList(com.vriche.adrm.adver.model.PublishedInfo)
     */
    public List getPublishedInfosByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getPublishedInfosByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.adver.dao.PublishedInfoDao#getPublishedInfo(Long id)
     */
    public PublishedInfo getPublishedInfo(Long id) {
        PublishedInfo publishedInfo = (PublishedInfo) getSqlMapClientTemplate().queryForObject("getPublishedInfo", id);

        if (publishedInfo == null) {
            throw new ObjectRetrievalFailureException(PublishedInfo.class, id);
        }

        return publishedInfo;
    }

    /**
     * @see com.vriche.adrm.adver.dao.PublishedInfoDao#savePublishedInfo(PublishedInfo publishedInfo)
     */    
    public void savePublishedInfo(final PublishedInfo publishedInfo) {
    	    	
        Long id = publishedInfo.getId();
        // check for new record
        if (id == null || id.intValue() == -1) {
            id = (Long) getSqlMapClientTemplate().insert("addPublishedInfo", publishedInfo);
        } else {
            getSqlMapClientTemplate().update("updatePublishedInfo", publishedInfo);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(PublishedInfo.class, id);
        }
    }

    /**
     * @see com.vriche.adrm.adver.dao.PublishedInfoDao#removePublishedInfo(Long id)
     */
    public void removePublishedInfo(Long id) {
        getSqlMapClientTemplate().update("deletePublishedInfo", id);
    }
    
    public void removePublishedInfosByResDate(String resourceIds,String publishDate) {
    	String ids[] = resourceIds.split(",");
		Map mp = new HashMap();
		List rsIdList = new ArrayList();
		
		for(int i=0;i<ids.length;i++) rsIdList.add(ids[i]);
		mp.put("ResourceIdList",rsIdList);
		mp.put("publishDate",publishDate);
        getSqlMapClientTemplate().update("deletePublishedInfosByResDate", mp);
    } 
    
    
    /**
     * @see com.vriche.adrm.order.dao.PublishedInfoDAO#removePublishedInfos(String ids)
     */
    public void removePublishedInfos(final Map idList) {
        getSqlMapClientTemplate().update("deletePublishedInfos", idList);
    }

	public Collection getInfosByHistoryColl(String resourceIds, String publishDate) {
    	Collection adverColl = new ArrayList();
    	String ids[] = resourceIds.split(",");
		Map mp = new HashMap();
		List rsIdList = new ArrayList();
		for (int i = 0 ;i<ids.length;i++) rsIdList.add(ids[i]);
		
		mp.put("ResourceIdList",rsIdList);
		mp.put("publishDate",publishDate);

		Iterator it =  getSqlMapClientTemplate().queryForList("getInfosByHistoryColl",mp).iterator();	
		
		while (it.hasNext()){
			PublishedInfo publishedInfo = (PublishedInfo)it.next();	
			adverColl.add(publishedInfo);
		}

//			System.out.println("adverColl===>.>>"+adverColl);
        return adverColl;
	}

    
    
//    private List sortAdver(List ls){
//
//		List specAdverTop = new ArrayList();
//		List specAdverButtom = new ArrayList();
//		List normalAdver = new ArrayList();
////		List normalAdverRoll = new ArrayList();
//		int index = 0;
//		
//		Iterator it = ls.iterator();
//		while(it.hasNext()){
//			PublishedInfo publishedInfo = (PublishedInfo)it.next();
//			String spec = publishedInfo.getAppPosition();
////			Integer publishDate = publishedInfo.getPublishDate();
//			if (StringUtils.isNotEmpty(spec) && spec != null && spec !=""){
//				if(NumberUtils.isNumber(spec)){
//					specAdverTop.add(publishedInfo); 		    
//					System.out.println(publishedInfo.toString());
//				}else{
//					specAdverButtom.add(publishedInfo);
//				}
//			}else{
//					normalAdver.add(publishedInfo);
//			}
//		}
//		int size = specAdverTop.size() +specAdverButtom.size() +normalAdver.size();
//			
//		List rsList = new ArrayList(size);
//		
//		//正指定
//		if(specAdverTop.size()>0){
//			Iterator itTop = specAdverTop.iterator();
//			while(itTop.hasNext()){
//				PublishedInfo adTop = (PublishedInfo)itTop.next();
//				rsList.add(index++,adTop);
//			}
//		}
//		//无指定
//		if(normalAdver.size()>0){
//			Iterator itNormal = normalAdver.iterator();
//			while(itNormal.hasNext()){
//				PublishedInfo adNormal = (PublishedInfo)itNormal.next();
//				rsList.add(index++,adNormal);
//			}
//		}		
//       //倒指定
//		if(specAdverButtom.size()>0){
//			Iterator itButtom = specAdverButtom.iterator();
//			while(itButtom.hasNext()){
//				PublishedInfo aditButtom = (PublishedInfo)itButtom.next();
//				rsList.add(index++,aditButtom);
//			}
//		}	
//		
//		//每个时段的总结行
//		
//		return rsList;
//	}
    
    
    
}
