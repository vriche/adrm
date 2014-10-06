
package com.vriche.adrm.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.LinkHisotryDao;
import com.vriche.adrm.model.LinkHisotry;
import com.vriche.adrm.model.LinkMan;
import com.vriche.adrm.service.LinkHisotryManager;
import com.vriche.adrm.service.impl.BaseManager;
import com.vriche.adrm.util.DateUtil;

public class LinkHisotryManagerImpl extends BaseManager implements LinkHisotryManager {
    private LinkHisotryDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setLinkHisotryDao(LinkHisotryDao dao) {
        this.dao = dao;
    }

    /**
     * @see com.vriche.adrm.crm.service.LinkHisotryManager#getLinkHisotrysByIdList(final Map idList)
     */
    public List getLinkHisotrysByIdList(final Map idList) {
        return dao.getLinkHisotrysByIdList(idList);
    }
   /**
     * @see com.vriche.adrm.crm.service.LinkHisotryManager#getLinkHisotrys(com.vriche.adrm.crm.model.LinkHisotry)
     */
    public List getLinkHisotrys(final LinkHisotry linkHisotry) {
        return dao.getLinkHisotrys(linkHisotry);
    }

    /**
     * @see com.vriche.adrm.crm.service.LinkHisotryManager#getLinkHisotry(String id)
     */
    public LinkHisotry getLinkHisotry(final String id) {
        return dao.getLinkHisotry(new Long(id));
    }

    /**
     * @see com.vriche.adrm.crm.service.LinkHisotryManager#saveLinkHisotry(LinkHisotry linkHisotry)
     */
    public void saveLinkHisotry(LinkHisotry linkHisotry) {
        dao.saveLinkHisotry(linkHisotry);
    }
    
    public Long saveCustomerLinkHisotryList(LinkHisotry linkHisotry) {
        return dao.saveCustomerLinkHisotryList(linkHisotry);
    }

    /**
     * @see com.vriche.adrm.crm.service.LinkHisotryManager#removeLinkHisotry(String id)
     */
    public void removeLinkHisotry(final String id) {
        dao.removeLinkHisotry(new Long(id));
    }

     /**
     * @see com.vriche.adrm.crm.service.LinkHisotryManager#removeLinkHisotrys(String Map)
     */
    public void removeLinkHisotrys(final Map idList) {
        dao.removeLinkHisotrys(idList);
    }

	public PaginatedList getLinkHisotryPage(LinkHisotry linkHisotry, String pageIndex, String pageSize) {
		// TODO Auto-generated method stub
		return dao.getLinkHisotryPage(linkHisotry,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}

	public String getLinkHisotryCount(LinkHisotry linkHisotry) {
		// TODO Auto-generated method stub
		return dao.getLinkHisotryCount(linkHisotry).toString();
	}   
	
	public String getlinkHistoryXML(LinkHisotry linkHisotry) {
//		LinkMan linkMan = new LinkMan();
//		customerAddress.setCustomerId(new Long(customerId));
		List all = getLinkHisotrys(linkHisotry);
		
		StringBuffer sb  = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");  
		
		for(Iterator it = all.iterator();it.hasNext();){
			LinkHisotry LMan = (LinkHisotry) it.next();
			//主题subject   	联系时间linkDate   	接洽人linkManId   	联系人编号counterpartMan
			sb.append("<row  id=\""+ LMan.getId()  +"\">");
//			sb.append("<cell><![CDATA["+ orderDayInfo.getCarrier().getCarrierName()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ LMan.getSubject()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ DateUtil.SetDateFormat(LMan.getLinkDate().toString(),"yyyy/MM/dd") +"]]></cell>");
			sb.append("<cell><![CDATA["+ LMan.getLinkManId()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ LMan.getCounterpartMan()  +"]]></cell>");
			
			sb.append("</row>");
		 }
		
		sb.append("</rows>");
		
		return sb.toString();
	}   
}
