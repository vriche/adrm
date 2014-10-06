
package com.vriche.adrm.service.impl;

import java.util.Map;
import java.util.List;
import java.util.Iterator;

import com.vriche.adrm.service.impl.BaseManager;
import com.vriche.adrm.model.ProCustomerType;
import com.vriche.adrm.dao.ProCustomerTypeDao;
import com.vriche.adrm.service.ProCustomerTypeManager;

public class ProCustomerTypeManagerImpl extends BaseManager implements ProCustomerTypeManager {
    private ProCustomerTypeDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setProCustomerTypeDao(ProCustomerTypeDao dao) {
        this.dao = dao;
    }
   /**
     * @see com.vriche.adrm.service.ProCustomerTypeManager#getProCustomerTypes(com.vriche.adrm.model.ProCustomerType)
     */
    public List getProCustomerTypes(final ProCustomerType proCustomerType) {
        return dao.getProCustomerTypes(proCustomerType);
    }
   /**
     * @see com.vriche.adrm.service.ProCustomerTypeManager#getProCustomerTypesCount(com.vriche.adrm.model.ProCustomerType)
     */
    public String getProCustomerTypesCount(final ProCustomerType proCustomerType) {
        return dao.getProCustomerTypesCount(proCustomerType).toString();
    }    

   /**
     * @see com.vriche.adrm.service.ProCustomerTypeManager#getProCustomerTypesCount(com.vriche.adrm.model.ProCustomerType)
     */    
	public List getProCustomerTypesPage(final ProCustomerType proCustomerType,String pageIndex, String pageSize) {
		return dao.getProCustomerTypesPage(proCustomerType,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    
   /**
     * @see com.vriche.adrm.service.ProCustomerTypeManager#getProCustomerTypesCount(com.vriche.adrm.model.ProCustomerType)
     */    
	public String getProCustomerTypesPageXML(final ProCustomerType proCustomerType,String pageIndex, String pageSize) {
	    StringBuffer sb = new StringBuffer();
	    List ls = dao.getProCustomerTypesPage(proCustomerType,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");   
		for(Iterator it = ls.iterator();it.hasNext();){
			ProCustomerType obj = (ProCustomerType)it.next();
			sb.append("<row  id=\""+ obj  +"\"" +">");
			sb.append("<cell><![CDATA["+ obj  +"]]></cell>");
			sb.append("</row>");
		}
		sb.append("</rows>");	
		return sb.toString();
	}    

    /**
     * @see com.vriche.adrm.service.ProCustomerTypeManager#getProCustomerType(String id)
     */
    public ProCustomerType getProCustomerType(final String id) {
        return dao.getProCustomerType(new Long(id));
    }
    /**
     * @see com.vriche.adrm.service.ProCustomerTypeManager#getProCustomerTypesByIdList(final Map idList)
     */
    public List getProCustomerTypesByMap(final Map mp) {
        return dao.getProCustomerTypesByMap(mp);
    }    

    /**
     * @see com.vriche.adrm.service.ProCustomerTypeManager#saveProCustomerType(ProCustomerType proCustomerType)
     */
    public String saveProCustomerType(ProCustomerType proCustomerType) {
        return dao.saveProCustomerType(proCustomerType).toString();
    }

    /**
     * @see com.vriche.adrm.service.ProCustomerTypeManager#removeProCustomerType(String id)
     */
    public void removeProCustomerType(final String id) {
        dao.removeProCustomerType(new Long(id));
    }

     /**
     * @see com.vriche.adrm.service.ProCustomerTypeManager#removeProCustomerTypes(String Map)
     */
    public void removeProCustomerTypes(final Map mp) {
        dao.removeProCustomerTypes(mp);
    }
	public String getProCustomerTypeXML(ProCustomerType proCustomerType) {
		 StringBuffer sb = new StringBuffer();
		 int i=1;
		    List ls = dao.getProCustomerTypes(proCustomerType);
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<rows>");   
			for(Iterator it = ls.iterator();it.hasNext();){
				ProCustomerType obj = (ProCustomerType)it.next();
				sb.append("<row  id=\""+ obj.getId() +"\"" +">");
				sb.append("<cell><![CDATA["+ i++  +"]]></cell>");
				sb.append("<cell><![CDATA["+ obj.getId()  +"]]></cell>");
				sb.append("<cell><![CDATA["+ obj.getName()  +"]]></cell>");
				sb.append("</row>");
			}
			sb.append("</rows>");	
			return sb.toString();
	}    
}
