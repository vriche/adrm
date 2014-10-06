
package com.vriche.adrm.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Iterator;

import org.apache.commons.collections.CollectionUtils;

import com.vriche.adrm.service.impl.BaseManager;
import com.vriche.adrm.model.FusionChartObject;
import com.vriche.adrm.model.Income;
import com.vriche.adrm.model.ProCustomer;
import com.vriche.adrm.model.ProOrder;
import com.vriche.adrm.dao.ProCustomerDao;
import com.vriche.adrm.service.ProCustomerManager;
import com.vriche.adrm.util.DateUtil;
import com.vriche.adrm.util.GetFirstLetter;
import com.vriche.adrm.util.StringUtil;

public class ProCustomerManagerImpl extends BaseManager implements ProCustomerManager {
    private ProCustomerDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setProCustomerDao(ProCustomerDao dao) {
        this.dao = dao;
    }
   /**
     * @see com.vriche.adrm.service.ProCustomerManager#getProCustomers(com.vriche.adrm.model.ProCustomer)
     */
    public List getProCustomers(final ProCustomer proCustomer) {
        return dao.getProCustomers(proCustomer);
    }
    
    /**
     * @see com.vriche.adrm.service.ProCustomerManager#getProCustomersId(com.vriche.adrm.model.ProCustomer)
     */
    public ProCustomer getProCustomersId(final ProCustomer proCustomer) {
    	ProCustomer customer=new ProCustomer();
    	List ls=getProCustomers(proCustomer);
    	for(Iterator it = ls.iterator();it.hasNext();){
    		ProCustomer obj = (ProCustomer)it.next();
    		customer.setId(obj.getId());
    	}
		return customer;
    }
   /**
     * @see com.vriche.adrm.service.ProCustomerManager#getProCustomersCount(com.vriche.adrm.model.ProCustomer)
     */
    public String getProCustomersCount(final ProCustomer proCustomer) {
        return dao.getProCustomersCount(proCustomer).toString();
    }    

   /**
     * @see com.vriche.adrm.service.ProCustomerManager#getProCustomersCount(com.vriche.adrm.model.ProCustomer)
     */    
	public List getProCustomersPage(final ProCustomer proCustomer,String pageIndex, String pageSize) {
		return dao.getProCustomersPage(proCustomer,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    
   /**
     * @see com.vriche.adrm.service.ProCustomerManager#getProCustomersCount(com.vriche.adrm.model.ProCustomer)
     */    
	public String getProCustomersPageXML(final ProCustomer proCustomer,String pageIndex, String pageSize) {
		List ls = dao.getProCustomersPage(proCustomer,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
		StringBuffer sb = new StringBuffer();
		    
		    sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<rows>");   
			for(Iterator it = ls.iterator();it.hasNext();){
				ProCustomer obj = (ProCustomer)it.next();
				String linkMName = obj.getLinkmanName()==null?"":obj.getLinkmanName();
				String tphone = obj.getTelephone()==null?"":obj.getTelephone();
				sb.append("<row  id=\""+ obj.getId()  +"\"" +">");
				sb.append("<cell><![CDATA["+ obj.getCustomerName()  +"]]></cell>");
				sb.append("<cell><![CDATA["+ linkMName  +"]]></cell>");
				sb.append("<cell><![CDATA["+ tphone  +"]]></cell>");
				sb.append("</row>");
			}
			sb.append("</rows>");	
			return sb.toString();
	}    

    /**
     * @see com.vriche.adrm.service.ProCustomerManager#getProCustomer(String id)
     */
    public ProCustomer getProCustomer(final String id) {
        return dao.getProCustomer(new Long(id));
    }
    /**
     * @see com.vriche.adrm.service.ProCustomerManager#getProCustomersByIdList(final Map idList)
     */
    public List getProCustomersByMap(final Map mp) {
        return dao.getProCustomersByMap(mp);
    }    

    /**
     * @see com.vriche.adrm.service.ProCustomerManager#saveProCustomer(ProCustomer proCustomer)
     */
    public String saveProCustomer(ProCustomer proCustomer) {
    	String helpCode = proCustomer.getHelpCode();
    	if(helpCode == null || "".endsWith(helpCode)){
    		String code = GetFirstLetter.getFirstLetter(proCustomer.getCustomerName());
    		helpCode = getCustomerHelpCode(code);
    		proCustomer.setHelpCode(helpCode);
    	}
        return dao.saveProCustomer(proCustomer).toString();
    }
    private String getCustomerHelpCode(String helpCode){
    	ProCustomer proCustomer = new ProCustomer();
    	proCustomer.setHelpCode(helpCode);
    	List ls = getProCustomers(proCustomer);
    	if(ls.size()>0){
    		helpCode +=ls.size();
    	}
    	return helpCode;
    }

    /**
     * @see com.vriche.adrm.service.ProCustomerManager#removeProCustomer(String id)
     */
    public void removeProCustomer(final String id) {
        dao.removeProCustomer(new Long(id));
    }

     /**
     * @see com.vriche.adrm.service.ProCustomerManager#removeProCustomers(String Map)
     */
    public void removeProCustomers(final Map mp) {
        dao.removeProCustomers(mp);
    }
	public String getProCustomersXML(ProCustomer proCustomer) {
		 StringBuffer sb = new StringBuffer();
		 int i=1;
		    List ls = dao.getProCustomers(proCustomer);
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<complete>");   
			for(Iterator it = ls.iterator();it.hasNext();){
				ProCustomer obj = (ProCustomer)it.next();
				sb.append("<option  value=\""+ i++  +"\"" +">");
				sb.append("<![CDATA["+ obj.getCustomerName() +"]]>");
				sb.append("</option>");
			}
			sb.append("</complete>");	
			return sb.toString();
	}
	public String getProCustomerListXML(ProCustomer proCustomer) {
		
		String customerName = proCustomer.getCustomerName();
		String helpCode = proCustomer.getHelpCode();
		Long typeId = proCustomer.getTypeId();
		String telephone = proCustomer.getTelephone();
		String linkmanName = proCustomer.getLinkmanName();
		String accountAddress = proCustomer.getAccountAddress();
		List ls = this.getProCustomerList(customerName,helpCode,typeId,telephone,linkmanName,accountAddress);
		StringBuffer sb = new StringBuffer();
		    
		    sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<rows>");   
			for(Iterator it = ls.iterator();it.hasNext();){
				ProCustomer obj = (ProCustomer)it.next();
				String linkMName = obj.getLinkmanName()==null?"":obj.getLinkmanName();
				String tphone = obj.getTelephone()==null?"":obj.getTelephone();
				sb.append("<row  id=\""+ obj.getId()  +"\"" +">");
				sb.append("<cell><![CDATA["+ obj.getCustomerName()  +"]]></cell>");
				sb.append("<cell><![CDATA["+ linkMName  +"]]></cell>");
				sb.append("<cell><![CDATA["+ tphone  +"]]></cell>");
				sb.append("</row>");
			}
			sb.append("</rows>");	
			return sb.toString();
	}
public List getProCustomerList(String customerName, String helpCode, Long typeId, String telephone, String linkmanName, String accountAddress) {
		Map mp =new HashMap();
		
		mp.put("customerName",customerName);
		mp.put("linkmanName",linkmanName);
		mp.put("helpCode",helpCode);
		mp.put("telephone",telephone);
		mp.put("accountAddress",accountAddress);
		mp.put("typeId",typeId);
		
		List ls = dao.getProCustomersByMap(mp);
		
		return ls;
	} 
	
public Map getCustomerName(Map mp) {
		Map retMp = new HashMap();
		List ls = getProCustomersByMap(mp);
		for (Iterator it = ls.iterator(); it.hasNext();) {
			ProCustomer obj = (ProCustomer) it.next();
			retMp.put(obj.getId(),obj.getCustomerName());
		}
		return retMp;
	}
	
public Collection getCollections(final String queryString,String type) {
			
		String helpCode = StringUtil.getParamFromUrl(queryString,"helpCode");
		Long typeId = Long.valueOf(StringUtil.getParamFromUrl(queryString,"typeId"));
		String telephone = StringUtil.getParamFromUrl(queryString,"telephone");
		String linkmanName = StringUtil.getParamFromUrl(queryString,"linkmanName");
		String accountAddress = StringUtil.getParamFromUrl(queryString,"accountAddress");
		String customerName = StringUtil.getParamFromUrl(queryString,"customerName");
		
		
		List ls = getProCustomerList(customerName,helpCode,typeId,telephone,linkmanName,accountAddress);
		
		Collection coll = new ArrayList();
		List valuecoll = new ArrayList();
		
		int cols = 3;
		
		
		for(Iterator it = ls.iterator();it.hasNext();){
			
			ProCustomer obj = (ProCustomer)it.next();
			String linkMName = obj.getLinkmanName()==null?"":obj.getLinkmanName();
			String tphone = obj.getTelephone()==null?"":obj.getTelephone();
			FusionChartObject fObject = new FusionChartObject();
			
			if(type.equals("report")){
				for(int i=1;i<cols+1;i++){
					switch(i){
						case 1:
							fObject.setValue1(obj.getCustomerName());break;
						case 2:
							fObject.setValue2(linkMName);break;
						case 3:
							fObject.setValue3(tphone);break;
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
