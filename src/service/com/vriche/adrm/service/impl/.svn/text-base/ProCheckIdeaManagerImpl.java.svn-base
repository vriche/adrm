
package com.vriche.adrm.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Iterator;


import com.vriche.adrm.Constants;
import com.vriche.adrm.service.impl.BaseManager;
import com.vriche.adrm.model.ProCheckIdea;
import com.vriche.adrm.model.ProPublishPlan;
import com.vriche.adrm.model.User;
import com.vriche.adrm.dao.ProCheckIdeaDao;
import com.vriche.adrm.service.ProCheckIdeaManager;
import com.vriche.adrm.util.DateUtil;

public class ProCheckIdeaManagerImpl extends BaseManager implements ProCheckIdeaManager {
    private ProCheckIdeaDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setProCheckIdeaDao(ProCheckIdeaDao dao) {
        this.dao = dao;
    }
   /**
     * @see com.vriche.adrm.service.ProCheckIdeaManager#getProCheckIdeas(com.vriche.adrm.model.ProCheckIdea)
     */
    public List getProCheckIdeas(final ProCheckIdea proCheckIdea) {
        return dao.getProCheckIdeas(proCheckIdea);
    }
    
    /**
     * @see com.vriche.adrm.service.ProCheckIdeaManager#getProCheckIdeasId(com.vriche.adrm.model.ProCheckIdea)
     */
    public ProCheckIdea getProCheckIdeasId(final ProCheckIdea proCheckIdea) {
    	ProCheckIdea customer=new ProCheckIdea();
    	List ls=getProCheckIdeas(proCheckIdea);
    	for(Iterator it = ls.iterator();it.hasNext();){
    		ProCheckIdea obj = (ProCheckIdea)it.next();
    		customer.setId(obj.getId());
    	}
		return customer;
    }
   /**
     * @see com.vriche.adrm.service.ProCheckIdeaManager#getProCheckIdeasCount(com.vriche.adrm.model.ProCheckIdea)
     */
    public String getProCheckIdeasCount(final ProCheckIdea proCheckIdea) {
        return dao.getProCheckIdeasCount(proCheckIdea).toString();
    }    

   /**
     * @see com.vriche.adrm.service.ProCheckIdeaManager#getProCheckIdeasCount(com.vriche.adrm.model.ProCheckIdea)
     */    
	public List getProCheckIdeasPage(final ProCheckIdea proCheckIdea,String pageIndex, String pageSize) {
		return dao.getProCheckIdeasPage(proCheckIdea,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    
   /**
     * @see com.vriche.adrm.service.ProCheckIdeaManager#getProCheckIdeasCount(com.vriche.adrm.model.ProCheckIdea)
     */    
	public String getProCheckIdeasPageXML(final ProCheckIdea proCheckIdea,String pageIndex, String pageSize) {
		List ls = dao.getProCheckIdeasPage(proCheckIdea,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
		StringBuffer sb = new StringBuffer();
		    
		    sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<rows>");   
			for(Iterator it = ls.iterator();it.hasNext();){
				ProCheckIdea obj = (ProCheckIdea)it.next();
				
				sb.append("<row  id=\""+ obj.getId()  +"\"" +">");
				sb.append("<cell><![CDATA["+  "]]></cell>");
				sb.append("<cell><![CDATA["+  "]]></cell>");
				sb.append("<cell><![CDATA["+  "]]></cell>");
				sb.append("</row>");
			}
			sb.append("</rows>");	
			return sb.toString();
	}    

    /**
     * @see com.vriche.adrm.service.ProCheckIdeaManager#getProCheckIdea(String id)
     */
    public ProCheckIdea getProCheckIdea(final String id) {
        return dao.getProCheckIdea(new Long(id));
    }
    /**
     * @see com.vriche.adrm.service.ProCheckIdeaManager#getProCheckIdeasByIdList(final Map idList)
     */
    public List getProCheckIdeasByMap(final Map mp) {
        return dao.getProCheckIdeasByMap(mp);
    }    

    /**
     * @see com.vriche.adrm.service.ProCheckIdeaManager#saveProCheckIdea(ProCheckIdea proCheckIdea)
     */
    public String saveProCheckIdea(ProCheckIdea proCheckIdea) {
    	
    	ProCheckIdea proPPlan = new ProCheckIdea();
    	proPPlan.setId(proCheckIdea.getId());
    	int size = dao.getProCheckIdeasCount(proPPlan).intValue();
    	if(size==0){proCheckIdea.setId(new Long(0));}
    	proCheckIdea.setCreateDate(new Date());
        return dao.saveProCheckIdea(proCheckIdea).toString();
    }

    /**
     * @see com.vriche.adrm.service.ProCheckIdeaManager#removeProCheckIdea(String id)
     */
    public void removeProCheckIdea(final String id) {
        dao.removeProCheckIdea(new Long(id));
    }

     /**
     * @see com.vriche.adrm.service.ProCheckIdeaManager#removeProCheckIdeas(String Map)
     */
    public void removeProCheckIdeas(final Map mp) {
        dao.removeProCheckIdeas(mp);
    }
	public String getProCheckIdeasXML(ProCheckIdea proCheckIdea) {
		List ls = dao.getProCheckIdeas(proCheckIdea);
		StringBuffer sb = new StringBuffer();
		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USERS_MAP);
		
		    sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<rows>");   
			for(Iterator it = ls.iterator();it.hasNext();){
				ProCheckIdea obj = (ProCheckIdea)it.next();

				User userObj = (User)userRelsMap.get(obj.getCreateBy().toString());
				String userName = userObj.getFirstName()+userObj.getLastName();
				sb.append("<row  id=\""+ obj.getId()  +"\"" +">");
				sb.append("<cell><![CDATA["+ obj.getCarrierId()  +"]]></cell>");
				sb.append("<cell><![CDATA["+ userName  +"]]></cell>");
				sb.append("<cell><![CDATA["+ DateUtil.convertDateToString(obj.getCreateDate())  +"]]></cell>");
				sb.append("<cell><![CDATA["+ obj.getCheckIdea()  +"]]></cell>");
				sb.append("<cell><![CDATA["+ obj.getCheckResult()  +"]]></cell>");
				sb.append("</row>");
				
			}
			sb.append("</rows>");	
			return sb.toString();
	}

}
