
package com.vriche.adrm.service.impl;

import java.util.Map;
import java.util.List;
import java.util.Iterator;

import com.vriche.adrm.service.impl.BaseManager;
import com.vriche.adrm.model.ProOrderType;
import com.vriche.adrm.model.ProProgram;
import com.vriche.adrm.dao.ProOrderTypeDao;
import com.vriche.adrm.service.ProOrderTypeManager;

public class ProOrderTypeManagerImpl extends BaseManager implements ProOrderTypeManager {
    private ProOrderTypeDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setProOrderTypeDao(ProOrderTypeDao dao) {
        this.dao = dao;
    }
   /**
     * @see com.vriche.adrm.service.ProOrderTypeManager#getProOrderTypes(com.vriche.adrm.model.ProOrderType)
     */
    public List getProOrderTypes(final ProOrderType proOrderType) {
        return dao.getProOrderTypes(proOrderType);
    }
   /**
     * @see com.vriche.adrm.service.ProOrderTypeManager#getProOrderTypesCount(com.vriche.adrm.model.ProOrderType)
     */
    public String getProOrderTypesCount(final ProOrderType proOrderType) {
        return dao.getProOrderTypesCount(proOrderType).toString();
    }    

   /**
     * @see com.vriche.adrm.service.ProOrderTypeManager#getProOrderTypesCount(com.vriche.adrm.model.ProOrderType)
     */    
	public List getProOrderTypesPage(final ProOrderType proOrderType,String pageIndex, String pageSize) {
		return dao.getProOrderTypesPage(proOrderType,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    
   /**
     * @see com.vriche.adrm.service.ProOrderTypeManager#getProOrderTypesCount(com.vriche.adrm.model.ProOrderType)
     */    
	public String getProOrderTypesPageXML(final ProOrderType proOrderType,String pageIndex, String pageSize) {
	    StringBuffer sb = new StringBuffer();
	    List ls = dao.getProOrderTypesPage(proOrderType,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");   
		for(Iterator it = ls.iterator();it.hasNext();){
			ProOrderType obj = (ProOrderType)it.next();
			sb.append("<row  id=\""+ obj  +"\"" +">");
			sb.append("<cell><![CDATA["+ obj  +"]]></cell>");
			sb.append("</row>");
		}
		sb.append("</rows>");	
		return sb.toString();
	}    

    /**
     * @see com.vriche.adrm.service.ProOrderTypeManager#getProOrderType(String id)
     */
    public ProOrderType getProOrderType(final String id) {
        return dao.getProOrderType(new Long(id));
    }
    /**
     * @see com.vriche.adrm.service.ProOrderTypeManager#getProOrderTypesByIdList(final Map idList)
     */
    public List getProOrderTypesByMap(final Map mp) {
        return dao.getProOrderTypesByMap(mp);
    }    

    /**
     * @see com.vriche.adrm.service.ProOrderTypeManager#saveProOrderType(ProOrderType proOrderType)
     */
    public String saveProOrderType(ProOrderType proOrderType) {
        return dao.saveProOrderType(proOrderType).toString();
    }

    /**
     * @see com.vriche.adrm.service.ProOrderTypeManager#removeProOrderType(String id)
     */
    public void removeProOrderType(final String id) {
        dao.removeProOrderType(new Long(id));
    }

     /**
     * @see com.vriche.adrm.service.ProOrderTypeManager#removeProOrderTypes(String Map)
     */
    public void removeProOrderTypes(final Map mp) {
        dao.removeProOrderTypes(mp);
    }    
    public String getProOrderTypeXML(ProOrderType proOrderType) {
		 StringBuffer sb = new StringBuffer();
		    List ls = dao.getProOrderTypes(proOrderType);
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<complete>");   
			for(Iterator it = ls.iterator();it.hasNext();){
				ProOrderType obj = (ProOrderType)it.next();
				sb.append("<option  value=\""+ obj.getId()  +"\"" +">");
				sb.append("<![CDATA["+ obj.getName() +"]]>");
				sb.append("</option>");
			}
			sb.append("</complete>");	
			return sb.toString();
	}
}
