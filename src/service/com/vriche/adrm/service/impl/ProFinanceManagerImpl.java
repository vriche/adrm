
package com.vriche.adrm.service.impl;

import java.util.Iterator;
import java.util.Map;
import java.util.List;

import com.vriche.adrm.dao.ProFinanceDao;
import com.vriche.adrm.model.ProFinance;
import com.vriche.adrm.model.ProOrder;
import com.vriche.adrm.service.ProFinanceManager;
import com.vriche.adrm.service.impl.BaseManager;
import com.vriche.adrm.util.DateUtil;
import com.vriche.adrm.util.StringUtil;


public class ProFinanceManagerImpl extends BaseManager implements ProFinanceManager {
    private ProFinanceDao dao;

	/**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setProFinanceDao(ProFinanceDao dao) {
        this.dao = dao;
    }  

    /**
     * @see com.vriche.adrm.service.ProFinanceManager#getProFinanceXML(com.vriche.adrm.model.ProFinance)
     */  
	public List getProFinanceXML(Long id) {
		ProFinance proFinance=new ProFinance();
		proFinance.setOrderId(id);
		return dao.getProFinance(proFinance);
	}
	
    /**
     * @see com.vriche.adrm.service.ProFinanceManager#getProFinanceXML(com.vriche.adrm.model.ProFinance)
     */    
	public String getProFinanceXML(String id) {
		StringBuffer sb = new StringBuffer();
		ProFinance proFinance=new ProFinance();
		proFinance.setOrderId(new Long(id));
		List ls=dao.getProFinance(proFinance);
		
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");
		int i=1;
		for(Iterator it = ls.iterator();it.hasNext();){
			ProFinance obj = (ProFinance)it.next();
			String paidDates=obj.getPaidDate().equals(new Integer(0))?"":obj.getPaidDate().toString();
			String payDate = DateUtil.SetDateFormat(obj.getPayDate().toString(),"yyyy/MM/dd");
			String paidDate = DateUtil.SetDateFormat(paidDates,"yyyy/MM/dd");
			sb.append("<row  id=\""+ obj.getId()  +"\"" +">");
			sb.append("<cell><![CDATA["+ i++  +"]]></cell>");
//			sb.append("<cell><![CDATA["+ obj.getOrderId()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ obj.getIncomeModeId()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ obj.getIncomePurposeId()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(obj.getPayMoney())  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(obj.getPaidMoney()) +"]]></cell>");
			sb.append("<cell><![CDATA["+ payDate  +"]]></cell>");
			sb.append("<cell><![CDATA["+ paidDate  +"]]></cell>");
			sb.append("</row>");
		}
		sb.append("</rows>");	
		return sb.toString();
	}
   /**
     * @see com.vriche.adrm.service.ProFinanceManager#getProFinancesCount(com.vriche.adrm.model.ProFinance)
     */    
	public String getProFinancesPageXML(final ProFinance proFinance,String pageIndex, String pageSize) {
	    StringBuffer sb = new StringBuffer();
		return sb.toString();
	}

    /**
     * @see com.vriche.adrm.service.ProFinanceManager#getProFinancesByIdList(final Map idList)
     */
    public List getProFinancesByMap(final Map mp) {
        return dao.getProFinancesByMap(mp);
    }    

    /**
     * @see com.vriche.adrm.service.ProFinanceManager#saveProFinances(ProFinance proFinance)
     */
    public ProFinance saveProFinances(ProFinance proFinance) {
        
		return proFinance;
    }
    
    /**
     * @see com.vriche.adrm.service.ProFinanceManager#saveProFinance(ProFinance proFinance)
     */
    public Long saveProFinance(ProFinance proFinance) {
    	Long id=proFinance.getId();
    	int size = dao.getProFinanceCount(id).intValue();
    	if(size==0) proFinance.setId(new Long(0));
		return dao.saveProFinance(proFinance);	
    }

    /**
     * @see com.vriche.adrm.service.ProFinanceManager#removeProFinance(String id)
     */
    public void removeProFinance(final String id) {
        dao.removeProFinance(new Long(id));
    }

    /**
     * @see com.vriche.adrm.service.ProFinanceManager#removeProFinance(String id)
     */
    public void removeProFinanceByOrderId(final String id) {
        dao.removeProFinanceByOrderId(new Long(id));
    }
    
     /**
     * @see com.vriche.adrm.service.ProFinanceManager#removeProFinances(String Map)
     */
    public void removeProFinances(final Map mp) {
        dao.removeProFinances(mp);
    }

	public String getProFinancesCount(ProFinance proFinance) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getProFinancesCountByName(ProFinance proFinance) {
		// TODO Auto-generated method stub
		return null;
	}

	public List getProFinancesPage(ProFinance proFinance, String pageIndex, String pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveProIncomePulls(ProFinance[] proFinances) {
		// TODO Auto-generated method stub
		
	}

}
