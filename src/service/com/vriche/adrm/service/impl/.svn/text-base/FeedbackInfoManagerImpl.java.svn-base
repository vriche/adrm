
package com.vriche.adrm.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.FeedbackInfoDao;
import com.vriche.adrm.model.ContractPayment;
import com.vriche.adrm.model.FeedbackInfo;
import com.vriche.adrm.model.LinkMan;
import com.vriche.adrm.service.FeedbackInfoManager;
import com.vriche.adrm.service.impl.BaseManager;
import com.vriche.adrm.util.DateUtil;
import com.vriche.adrm.util.StringUtil;
import com.vriche.adrm.util.SysParamUtil;
import com.vriche.adrm.util.UserUtil;

public class FeedbackInfoManagerImpl extends BaseManager implements FeedbackInfoManager {
    private FeedbackInfoDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setFeedbackInfoDao(FeedbackInfoDao dao) {
        this.dao = dao;
    }
    
    
    private void getCustomerCateFiter(FeedbackInfo feedbackInfo) {
    	
    	boolean 	catFiter = SysParamUtil.getCustomerCateFiter();

    	if(catFiter){
        	List ls = UserUtil.getCustomerCateByUser(feedbackInfo.getLoginUser(),"");
        	
        	if(log.isDebugEnabled()){
        		log.info("getCustomerCateFiter>>>>>>>>>getCustomerCateByUser>>>>>>>>>>>>>>>>"+ls.toArray());
        	}
        	feedbackInfo.setCustomerCateList(ls);

    	}
    } 
    

    /**
     * @see com.vriche.adrm.crm.service.FeedbackInfoManager#getFeedbackInfosByIdList(final Map idList)
     */
    public List getFeedbackInfosByIdList(final Map idList) {
        return dao.getFeedbackInfosByIdList(idList);
    }
   /**
     * @see com.vriche.adrm.crm.service.FeedbackInfoManager#getFeedbackInfos(com.vriche.adrm.crm.model.FeedbackInfo)
     */
    public List getFeedbackInfos(final FeedbackInfo feedbackInfo) {
    	
    	getCustomerCateFiter(feedbackInfo);
    	
        return dao.getFeedbackInfos(feedbackInfo);
    }
    
    

    public String getFeedbackInfosCount(FeedbackInfo feedbackInfo) {
    	getCustomerCateFiter(feedbackInfo);
    	
    	return dao.getFeedbackInfosCount(feedbackInfo).toString();
    }

	public PaginatedList getFeedbackInfosPage(FeedbackInfo feedbackInfo, String pageIndex, String pageSize) {
		
		getCustomerCateFiter(feedbackInfo);
		
		return dao.getFeedbackInfosPage(feedbackInfo,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}

	/**
     * @see com.vriche.adrm.crm.service.FeedbackInfoManager#getFeedbackInfo(String id)
     */
    public FeedbackInfo getFeedbackInfo(final String id) {
        return dao.getFeedbackInfo(new Long(id));
    }

    /**
     * @see com.vriche.adrm.crm.service.FeedbackInfoManager#saveFeedbackInfo(FeedbackInfo feedbackInfo)
     */
    public void saveFeedbackInfo(FeedbackInfo feedbackInfo) {
        dao.saveFeedbackInfo(feedbackInfo);
    }

    /**
     * @see com.vriche.adrm.crm.service.FeedbackInfoManager#removeFeedbackInfo(String id)
     */
    public void removeFeedbackInfo(final String id) {
        dao.removeFeedbackInfo(new Long(id));
    }

     /**
     * @see com.vriche.adrm.crm.service.FeedbackInfoManager#removeFeedbackInfos(String Map)
     */
    public void removeFeedbackInfos(final Map idList) {
        dao.removeFeedbackInfos(idList);
    }    
    
    public String getFeedbackInfosListXML(FeedbackInfo feedbackInfo) {

		List all = dao.getFeedbackInfosListPage(feedbackInfo);
//		System.out.println("all<<<<<<<1111111111111<<<<<<<<<<"+all.size());
		StringBuffer sb  = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");  
		
		for(Iterator it = all.iterator();it.hasNext();){
			FeedbackInfo LMan = (FeedbackInfo) it.next();
			String feedContent = LMan.getFeedContent()==null?"":LMan.getFeedContent();
			sb.append("<row  id=\""+ LMan.getId()  +"\">");
//			sb.append("<cell><![CDATA["+ DateUtil.SetDateFormat(LMan.getSubmitDate().toString(),"yyyy/MM/dd") +"]]></cell>");
			sb.append("<cell><![CDATA["+ "" +"]]></cell>");
			sb.append("<cell><![CDATA["+ LMan.getFeeder() +"]]></cell>");
			sb.append("<cell><![CDATA["+ feedContent  +"]]></cell>");
			sb.append("<cell><![CDATA["+ "" +"]]></cell>");
//			sb.append("<cell><![CDATA["+ DateUtil.SetDateFormat(LMan.getDealDate().toString(),"yyyy/MM/dd")  +"]]></cell>");
//			sb.append("<cell><![CDATA["+ LMan.getSatisfactoryDegree()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
			
			sb.append("</row>");
		 }
		
		sb.append("</rows>");
		
		return sb.toString();
	}
}
