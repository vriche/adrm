
package com.vriche.adrm.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.LinkManDao;
import com.vriche.adrm.model.Customer;
import com.vriche.adrm.model.CustomerAddress;
import com.vriche.adrm.model.LinkMan;
import com.vriche.adrm.service.LinkManManager;
import com.vriche.adrm.service.impl.BaseManager;
import com.vriche.adrm.util.SysParamUtil;
import com.vriche.adrm.util.UserUtil;

public class LinkManManagerImpl extends BaseManager implements LinkManManager {
    private LinkManDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setLinkManDao(LinkManDao dao) {
        this.dao = dao;
    }

    /**
     * @see com.vriche.adrm.crm.service.LinkManManager#getLinkMansByIdList(final Map idList)
     */
    public List getLinkMansByIdList(final Map idList) {
        return dao.getLinkMansByIdList(idList);
    }
   /**
     * @see com.vriche.adrm.crm.service.LinkManManager#getLinkMans(com.vriche.adrm.crm.model.LinkMan)
     */
    public List getLinkMans(final LinkMan linkMan) {
        return dao.getLinkMans(linkMan);
    }

    /**
     * @see com.vriche.adrm.crm.service.LinkManManager#getLinkMan(String id)
     */
    public LinkMan getLinkMan(final String id) {
        return dao.getLinkMan(new Long(id));
    }

    /**
     * @see com.vriche.adrm.crm.service.LinkManManager#saveLinkMan(LinkMan linkMan)
     */
    public void saveLinkMan(LinkMan linkMan) {
        dao.saveLinkMan(linkMan);
    }
    
    public Long saveCustomerLinkMan(LinkMan linkMan) {
       return dao.saveCustomerLinkMan(linkMan);
    }

    /**
     * @see com.vriche.adrm.crm.service.LinkManManager#removeLinkMan(String id)
     */
    public void removeLinkMan(final String id) {
        dao.removeLinkMan(new Long(id));
    }

     /**
     * @see com.vriche.adrm.crm.service.LinkManManager#removeLinkMans(String Map)
     */
    public void removeLinkMans(final Map idList) {
        dao.removeLinkMans(idList);
    }
    
    
    
    private void getCustomerCateFiter(LinkMan linkMan) {
    	
    	boolean 	catFiter = SysParamUtil.getCustomerCateFiter();

    	if(catFiter){
        	List ls = UserUtil.getCustomerCateByUser(linkMan.getLoginUser(),"");
        	
        	if(log.isDebugEnabled()){
        		log.info("getCustomerCateFiter>>>>>>>>>getCustomerCateByUser>>>>>>>>>>>>>>>>"+ls.toArray());
        	}
        	linkMan.setCustomerCateList(ls);

    	}
    }
    
    

	public PaginatedList getLinkManPage(LinkMan linkMan, String pageIndex, String pageSize) {
		getCustomerCateFiter( linkMan);
		return dao.getLinkManPage(linkMan,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}

	public String getLinkManCount(LinkMan linkMan) {
		getCustomerCateFiter( linkMan);
		return dao.getLinkManCount(linkMan).toString();
	}

	public void resetMainLinkMan(String cusId) {
		dao.resetMainLinkMan(new Long(cusId));		
	} 
	
	public String getLinkManXML(LinkMan linkMan) {
//		LinkMan linkMan = new LinkMan();
//		customerAddress.setCustomerId(new Long(customerId));
		List all = getLinkMans(linkMan);
		
		StringBuffer sb  = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");  
		int i=1;
		for(Iterator it = all.iterator();it.hasNext();){
			LinkMan LMan = (LinkMan) it.next();
			//联系人姓名linkmanName      住宅电话homeTel	工作电话officeTel 	移动电话mobile	首选电子信箱favorEmail  	主要联系人isCustomerMain
			sb.append("<row  id=\""+ LMan.getId()  +"\">");
//			sb.append("<cell><![CDATA["+ orderDayInfo.getCarrier().getCarrierName()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ i++ +"^/adrm/editLinkMan.html?id="+LMan.getId() +"]]></cell>");
			sb.append("<cell><![CDATA["+ LMan.getLinkmanName()+ "]]></cell>");
			sb.append("<cell><![CDATA["+ LMan.getHomeTel()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ LMan.getOfficeTel()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ LMan.getMobile()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ LMan.getFavorEmail()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ LMan.getIsCustomerMain()+"]]></cell>");
			
			sb.append("</row>");
		 }
		
		sb.append("</rows>");
		
		return sb.toString();
	}   
}
