
package com.vriche.adrm.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.CustomerAddressDao;
import com.vriche.adrm.model.CustomerAddress;
import com.vriche.adrm.model.OrderDayInfo;
import com.vriche.adrm.service.CustomerAddressManager;
import com.vriche.adrm.service.impl.BaseManager;
import com.vriche.adrm.util.StringUtil;

public class CustomerAddressManagerImpl extends BaseManager implements CustomerAddressManager {
    private CustomerAddressDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setCustomerAddressDao(CustomerAddressDao dao) {
        this.dao = dao;
    }

    /**
     * @see com.vriche.adrm.crm.service.CustomerAddressManager#getCustomerAddresssByIdList(final Map idList)
     */
    public List getCustomerAddresssByIdList(final Map idList) {
        return dao.getCustomerAddresssByIdList(idList);
    }
   /**
     * @see com.vriche.adrm.crm.service.CustomerAddressManager#getCustomerAddresss(com.vriche.adrm.crm.model.CustomerAddress)
     */
    public List getCustomerAddresss(final CustomerAddress customerAddress) {
        return dao.getCustomerAddresss(customerAddress);
    }

    /**
     * @see com.vriche.adrm.crm.service.CustomerAddressManager#getCustomerAddress(String id)
     */
    public CustomerAddress getCustomerAddress(final String id) {
        return dao.getCustomerAddress(new Long(id));
    }

    /**
     * @see com.vriche.adrm.crm.service.CustomerAddressManager#saveCustomerAddress(CustomerAddress customerAddress)
     */
    public void saveCustomerAddress(CustomerAddress customerAddress) {
        dao.saveCustomerAddress(customerAddress);
    }
    
    public Long saveCustomerAddressList(CustomerAddress customerAddress){
		return dao.saveCustomerAddressList(customerAddress);
    }

    /**
     * @see com.vriche.adrm.crm.service.CustomerAddressManager#removeCustomerAddress(String id)
     */
    public void removeCustomerAddress(final String id) {
        dao.removeCustomerAddress(new Long(id));
    }

     /**
     * @see com.vriche.adrm.crm.service.CustomerAddressManager#removeCustomerAddresss(String Map)
     */
    public void removeCustomerAddresss(final Map idList) {
        dao.removeCustomerAddresss(idList);
    }

	public PaginatedList getCustomerAddressPage(CustomerAddress customerAddress, String pageIndex, String pageSize) {
		return dao.getCustomerAddressPage(customerAddress,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}

	public String getCustomerAddressCount(CustomerAddress customerAddress) {
		return dao.getCustomerAddressCount(customerAddress).toString();
	}

	public String getCustomerAddresssXML(String customerId) {
		CustomerAddress customerAddress = new CustomerAddress();
		customerAddress.setCustomerId(new Long(customerId));
		List all = getCustomerAddresss(customerAddress);
		
		StringBuffer sb  = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");  
		
		for(Iterator it = all.iterator();it.hasNext();){
			CustomerAddress cusAddress = (CustomerAddress) it.next();
			//地址类别addressType   街道addres 城市city 国家country  邮编postalCode   直辖市/省oaAreaCity.name
			sb.append("<row  id=\""+ cusAddress.getId()  +"\">");
//			sb.append("<cell><![CDATA["+ orderDayInfo.getCarrier().getCarrierName()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ cusAddress.getAddressType()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ cusAddress.getAddress()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ cusAddress.getCity()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ cusAddress.getCountry()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ cusAddress.getPostalCode()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ cusAddress.getProvince()  +"]]></cell>");
			
			sb.append("</row>");
		 }
		
		sb.append("</rows>");
		
		return sb.toString();
	}    
}
