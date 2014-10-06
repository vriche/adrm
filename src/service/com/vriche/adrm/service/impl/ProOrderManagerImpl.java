
package com.vriche.adrm.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Iterator;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.vriche.adrm.Constants;
import com.vriche.adrm.service.impl.BaseManager;
import com.vriche.adrm.model.FusionChartObject;
import com.vriche.adrm.model.ProCustomer;
import com.vriche.adrm.model.ProFinance;
import com.vriche.adrm.model.ProOrder;
import com.vriche.adrm.model.ProProgram;
import com.vriche.adrm.dao.ProOrderDao;
import com.vriche.adrm.service.ProCustomerManager;
import com.vriche.adrm.service.ProFinanceManager;
import com.vriche.adrm.service.ProOrderManager;
import com.vriche.adrm.service.ProProgramManager;
import com.vriche.adrm.service.SysSequenceManager;

import com.vriche.adrm.util.DateUtil;
import com.vriche.adrm.util.StringUtil;

public class ProOrderManagerImpl extends BaseManager implements ProOrderManager {
    private ProOrderDao dao;
    private ProFinanceManager proFinanceManager;
    private SysSequenceManager sysSequenceManager;
	private ProCustomerManager proCustomerManager;
	private ProProgramManager proProgramManager;

	/**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setProOrderDao(ProOrderDao dao) {
        this.dao = dao;
    }
	/**
     * Set the Dao for communication with the data layer.
     * @param proFinancedao
     */
    public void setProFinanceManager(ProFinanceManager proFinanceManager) {
    	this.proFinanceManager = proFinanceManager;
    }
    /**
     * Set the ProCustomerManager for communication with the data layer.
     * @param proCustomerManager
     */
	public void setProCustomerManager(ProCustomerManager proCustomerManager) {
		this.proCustomerManager = proCustomerManager;
	}
	/**
     * Set the ProProgramManager for communication with the data layer.
     * @param proProgramManager
     */
	public void setProProgramManager(ProProgramManager proProgramManager) {
		this.proProgramManager = proProgramManager;
	}
	  /**
     * Set the SysSequenceManager for communication with the data layer.
     * @param sysSequenceManager
     */
	public void setSysSequenceManager(SysSequenceManager sysSequenceManager) {
		this.sysSequenceManager = sysSequenceManager;
	}
   /**
     * @see com.vriche.adrm.service.ProOrderManager#getProOrders(com.vriche.adrm.model.ProOrder)
     */
    public List getProOrders(final ProOrder proOrder) {
        return dao.getProOrders(proOrder);
    }
    
    
   /**
     * @see com.vriche.adrm.service.ProOrderManager#getProOrdersCount(com.vriche.adrm.model.ProOrder)
     */
    public String getProOrdersCount(final ProOrder proOrder) {
        return dao.getProOrdersCount(proOrder).toString();
    }
    
    public String getProOrdersCountByName(final ProOrder proOrder) {
    	if(proOrder.getVersion().intValue()==0) proOrder.setVersion(null);
    	if(proOrder.getOrderTypeId().toString().equals(new Long(2).toString())){
    		return dao.getProOrdersCountBySellName(proOrder).toString();
    	}else{
    		return dao.getProOrdersCountByName(proOrder).toString();
    	} 
    }    
   /**
     * @see com.vriche.adrm.service.ProOrderManager#getProOrdersCount(com.vriche.adrm.model.ProOrder)
     */    
	public List getProOrdersPage(final ProOrder proOrder,String pageIndex, String pageSize) {
		return dao.getProOrdersPage(proOrder,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    
   /**
     * @see com.vriche.adrm.service.ProOrderManager#getProOrdersCount(com.vriche.adrm.model.ProOrder)
     */    
	public String getProOrdersPageXML(final ProOrder proOrder,String pageIndex, String pageSize) {
		if(proOrder.getVersion().intValue()==0) proOrder.setVersion(null);
	    StringBuffer sb = new StringBuffer();
	    List ls=new ArrayList();
    	if(proOrder.getOrderTypeId().toString().equals(new Long(2).toString())){
    		ls = dao.getProOrdersSellPage(proOrder,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
    	}else{
    		ls = dao.getProOrdersPage(proOrder,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
    	}
	    //System.out.println("ls<<<<<<<<<<<"+ls.size());

		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");   
		for(Iterator it = ls.iterator();it.hasNext();){
			ProOrder obj = (ProOrder)it.next();
			String orderDate= DateUtil.SetDateFormat(obj.getPayDate().toString(),"yyyy/MM/dd");
			double payMoney = 0;
			double paidMoney = 0;
			String payDate = null;
			String paidDate = null;
			List lst = proFinanceManager.getProFinanceXML(obj.getId());
			for(Iterator its = lst.iterator();its.hasNext();){
				ProFinance objs=(ProFinance)its.next();
			    payMoney+=objs.getPayMoney().doubleValue();
			    paidMoney+=objs.getPaidMoney().doubleValue();
				payDate = DateUtil.SetDateFormat(objs.getPayDate().toString(),"yyyy/MM/dd");
				paidDate=objs.getPaidDate().equals(new Integer(0))?"":DateUtil.SetDateFormat(objs.getPaidDate().toString(),"yyyy/MM/dd");
			}			
			sb.append("<row  id=\""+ obj.getId()  +"\"" +">");
			sb.append("<cell></cell>");
			sb.append("<cell><![CDATA["+ obj.getProgram().getProName()+"^/adrm/merm/proProgramEdit.jsp?id="+obj.getProgramId()+"&orderId="+obj.getId() +"^_self]]></cell>");
			sb.append("<cell></cell>");
			if(obj.getOrderTypeId().equals(new Long(1))){
				sb.append("<cell><![CDATA["+ obj.getProgram().getProCustomer().getCustomerName()+"^/adrm/merm/editCustomer.jsp?id="+obj.getProgram().getCustomerId()+"&&orderTypeId="+obj.getOrderTypeId() +"^_self]]></cell>");
			}else{
				sb.append("<cell><![CDATA["+ obj.getProgram().getProCustomer().getCustomerName()+"^/adrm/merm/editCustomer.jsp?id="+obj.getCustomerId()+"&&orderTypeId="+obj.getOrderTypeId() +"^_self]]></cell>");
			}
			sb.append("<cell><![CDATA["+ payMoney  +"]]></cell>");
			sb.append("<cell><![CDATA["+ paidMoney +"]]></cell>");
			sb.append("<cell><![CDATA["+ obj.getUser().getFullName() +"]]></cell>");
			sb.append("<cell><![CDATA["+ orderDate  +"]]></cell>");
			sb.append("<cell><![CDATA["+ payDate  +"]]></cell>");
			sb.append("<cell><![CDATA["+ paidDate  +"]]></cell>");
			sb.append("</row>");
		}
		sb.append("</rows>");	
		return sb.toString();
	}

    /**
     * @see com.vriche.adrm.service.ProOrderManager#getProOrder(String id)
     */
    public ProOrder getProOrder(final String id) {
        ProOrder proOrder= dao.getProOrder(new Long(id));
        String ordertypeId=proOrder.getOrderTypeId().toString();
        
        if(ordertypeId.equals(new Long(2).toString())){
        	String cid=proOrder.getCustomerId().toString();
        	ProCustomer proCustomer=proCustomerManager.getProCustomer(cid);
            proOrder.getProgram().setProCustomer(proCustomer);
        }else{
        	String pid=proOrder.getProgramId().toString();
        	ProProgram proProgram=proProgramManager.getProProgram(pid);
            proOrder.setProgram(proProgram);
        }
        return proOrder;
    }

    /**
     * @see com.vriche.adrm.service.ProOrderManager#getProOrdersByIdList(final Map idList)
     */
    public List getProOrdersByMap(final Map mp) {
        return dao.getProOrdersByMap(mp);
    }    

    /**
     * @see com.vriche.adrm.service.ProOrderManager#saveProOrders(ProOrder proOrder)
     */
    public ProOrder saveProOrders(ProOrder proOrder) {

    	String customerName=proOrder.getProgram().getProCustomer().getCustomerName();
		String customerTypeId=proOrder.getProgram().getProCustomer().getTypeId().toString();
		String programId=proOrder.getProgramId().toString();
		
		ProCustomer proCustomer=new ProCustomer();
		proCustomer.setCustomerName(customerName);
		proCustomer.setTypeId(new Long(customerTypeId));
		
		List idList = proCustomerManager.getProCustomers(proCustomer) ;
		for(Iterator it = idList.iterator();it.hasNext();){
			ProCustomer proCust = (ProCustomer) it.next() ;
			Long customerId =proCust.getId() ;
			proOrder.setCustomerId(customerId) ;
		}
		if(proOrder.getCustomerId()==null){
//			保存客户信息
			String id=proCustomerManager.saveProCustomer(proCustomer);
			proOrder.setCustomerId(new Long(id));
		}

		proOrder.setProgramId(new Long(programId));

       	boolean isNew = (proOrder.getId() == null) || StringUtils.isEmpty(proOrder.getId().toString());
       	String year=null;
       	if(proOrder.getId()==null){
	   	    year = proOrder.getVersion().toString();
       	}else{
       		ProOrder proOrders= dao.getProOrder(proOrder.getId());
       		proOrder.setVersion(proOrders.getVersion());
       	}
		if(isNew){
			String orderCode  = sysSequenceManager.getSysSequenceByObject(Constants.SEQUENCE_TB_PRO_ORDER_X,year);
			proOrder.setOrderCode(orderCode);
			proOrder.setCreateDate(new Date());
			proOrder.setModifyDate(new Date());
			
	   	}else{
	   		proOrder.setModifyDate(new Date());
	   	}
		
		dao.saveProOrder(proOrder);
        
		return proOrder;
    }
    
    /**
     * @see com.vriche.adrm.service.ProOrderManager#saveProOrder(ProOrder proOrder)
     */
    public ProOrder saveProOrder(ProOrder proOrder) {
    	String programId=proOrder.getProgramId().toString();
    	
    	proOrder.setProgramId(new Long(programId));

       	boolean isNew = (proOrder.getId() == null) || StringUtils.isEmpty(proOrder.getId().toString());
       	
       	String year=null;
       	if(proOrder.getId()==null){
	   	year = proOrder.getVersion().toString();
       	}else{
       		ProOrder proOrders= dao.getProOrder(proOrder.getId());
       		proOrder.setVersion(proOrders.getVersion());
       	}
		if(isNew){
			String orderCode  = sysSequenceManager.getSysSequenceByObject(Constants.SEQUENCE_TB_PRO_ORDER_C,year);
			proOrder.setOrderCode(orderCode);
			proOrder.setCreateDate(new Date());
			proOrder.setModifyDate(new Date());
	   	}else{
	   		proOrder.setModifyDate(new Date());
	   	}
		Long id=dao.saveProOrder(proOrder);
		if(id!=null){
			ProProgram program=new ProProgram();
			program.setId(proOrder.getProgramId());
			program.setProgramStatusId(new Long(3));
			proProgramManager.saveProProgramStatus(program);
		}
		return proOrder;	
    }

    /**
     * @see com.vriche.adrm.service.ProOrderManager#removeProOrder(String id)
     */
    public void removeProOrder(final String id) {
    	proFinanceManager.removeProFinanceByOrderId(id);
        dao.removeProOrder(new Long(id));
    }

     /**
     * @see com.vriche.adrm.service.ProOrderManager#removeProOrders(String Map)
     */
    public void removeProOrders(final Map mp) {
        dao.removeProOrders(mp);
    }
	public String getProOrderXML(ProOrder proOrder) {
		
		    StringBuffer sb = new StringBuffer();
		    List ls=new ArrayList();
	    	if(proOrder.getOrderTypeId().toString().equals(new Long(2).toString())){
	    		ls = dao.getProOrdersX(proOrder);
	    	}else{
	    		ls = dao.getProOrdersC(proOrder);
	    	} 
		    //System.out.println("ls<<<<<<<<<<<"+ls.size());

	    	sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<rows>");   
			for(Iterator it = ls.iterator();it.hasNext();){
				ProOrder obj = (ProOrder)it.next();
				double payMoney = 0;
				double paidMoney = 0;
				String payDate = null;
				String paidDate = null;
				List lst = proFinanceManager.getProFinanceXML(obj.getId());
				for(Iterator its = lst.iterator();its.hasNext();){
					ProFinance objs=(ProFinance)its.next();
				    payMoney+=objs.getPayMoney().doubleValue();
				    paidMoney+=objs.getPaidMoney().doubleValue();
					payDate = DateUtil.SetDateFormat(objs.getPayDate().toString(),"yyyy/MM/dd");
					paidDate=objs.getPaidDate().equals(new Integer(0))?"":DateUtil.SetDateFormat(objs.getPaidDate().toString(),"yyyy/MM/dd");
				}			
				sb.append("<row  id=\""+ obj.getId()  +"\"" +">");
				sb.append("<cell><![CDATA["+ obj.getProgram().getProName()+"]]></cell>");
				sb.append("<cell><![CDATA["+ obj.getProgram().getProCustomer().getCustomerName()+"]]></cell>");
				sb.append("<cell><![CDATA["+ payMoney  +"]]></cell>");
				sb.append("<cell><![CDATA["+ paidMoney +"]]></cell>");
				sb.append("<cell><![CDATA["+ obj.getUser().getFullName() +"]]></cell>");
				sb.append("<cell><![CDATA["+ payDate  +"]]></cell>");
				sb.append("<cell><![CDATA["+ paidDate  +"]]></cell>");
				sb.append("</row>");
			}
			sb.append("</rows>");	
			return sb.toString();
	}
	public String getProOrderXMLByProgramId(ProOrder proOrder) {
		
	    StringBuffer sb = new StringBuffer();
    	List ls = dao.getProOrdersX(proOrder);

    	sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");   
		for(Iterator it = ls.iterator();it.hasNext();){
			ProOrder obj = (ProOrder)it.next();
			double payMoney = 0;
			double paidMoney = 0;
			String payDate = null;
			String paidDate = null;
			List lst = proFinanceManager.getProFinanceXML(obj.getId());
			for(Iterator its = lst.iterator();its.hasNext();){
				ProFinance objs=(ProFinance)its.next();
			    payMoney+=objs.getPayMoney().doubleValue();
			    paidMoney+=objs.getPaidMoney().doubleValue();
				payDate = DateUtil.SetDateFormat(objs.getPayDate().toString(),"yyyy/MM/dd");
				paidDate=objs.getPaidDate().equals(new Integer(0))?"":DateUtil.SetDateFormat(objs.getPaidDate().toString(),"yyyy/MM/dd");
			}			
			sb.append("<row  id=\""+ obj.getId()  +"\"" +">");
			sb.append("<cell><![CDATA["+ obj.getOrderCode()+"]]></cell>");
			sb.append("<cell><![CDATA["+ obj.getProOrderType().getName()+"]]></cell>");
			sb.append("<cell><![CDATA["+ obj.getProgram().getProCustomer().getCustomerName()+"]]></cell>");
			sb.append("<cell><![CDATA["+ payMoney  +"]]></cell>");
			sb.append("<cell><![CDATA["+ paidMoney +"]]></cell>");
			sb.append("<cell><![CDATA["+ obj.getUser().getFullName() +"]]></cell>");
			sb.append("<cell><![CDATA["+ DateUtil.SetDateFormat(obj.getPayDate().toString(),"yyyy/MM/dd") +"]]></cell>");
			sb.append("<cell><![CDATA["+ payDate  +"]]></cell>");
			sb.append("<cell><![CDATA["+ paidDate  +"]]></cell>");
			sb.append("</row>");
		}
		sb.append("</rows>");	
		return sb.toString();
}

	public String getProOrderCodeXML(ProOrder proOrder) {
		
		StringBuffer sb = new StringBuffer();
	    List ls = dao.getProOrders(proOrder);
	    //System.out.println("ls.size"+ls.size());
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<complete>");   
		for(Iterator it = ls.iterator();it.hasNext();){
			ProOrder obj = (ProOrder)it.next();
			sb.append("<option  value=\""+ obj.getId()  +"\"" +">");
			sb.append("<![CDATA["+ obj.getOrderCode()+"]]>");
			sb.append("</option>");
		}
		sb.append("</complete>");	
		return sb.toString();

	}
	
	public String getProIncomePullPageXML(String customerName, String programName, String cusType, ProOrder proOrder, String pageIndex, String pageSize) {
		proOrder.getProgram().getProCustomer().setCustomerName(customerName);
		proOrder.setOrderCode(proOrder.getOrderCode());
		proOrder.getProgram().setProName(programName);
		if(cusType!=null){
			proOrder.getProgram().getProCustomer().setTypeId(new Long(cusType));
		}
			
		StringBuffer sb = new StringBuffer();
	    List ls = dao.getProOrdersPage(proOrder,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	    
	    Map map = new HashMap();
	    Map cusName = proCustomerManager.getCustomerName(map);
	    
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");   
		
		for(Iterator it = ls.iterator();it.hasNext();){
			ProOrder obj = (ProOrder)it.next();
			String paidDates=obj.getPaidDate().equals(new Integer(0))?"":obj.getPaidDate().toString();
			String payDate = DateUtil.SetDateFormat(obj.getPayDate().toString(),"yyyy/MM/dd");
			String paidDate = DateUtil.SetDateFormat(paidDates,"yyyy/MM/dd");
			sb.append("<row  id=\""+ obj.getId()  +"\"" +">");
			sb.append("<cell><![CDATA["+ obj.getOrderCode()  +"]]></cell>");
			
			 if(obj.getOrderTypeId().toString().equals(new Long(2).toString())){
				 	
				 	sb.append("<cell><![CDATA["+ cusName.get(obj.getCustomerId())  +"]]></cell>");
		    	}else{
		    		sb.append("<cell><![CDATA["+ obj.getProgram().getProCustomer().getCustomerName()  +"]]></cell>");
		    	} 
			
			sb.append("<cell><![CDATA["+ obj.getUser().getFirstName()+ obj.getUser().getLastName() +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(obj.getPayMoney())  +"]]></cell>");
			sb.append("<cell><![CDATA["+ payDate  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(obj.getPaidMoney()) +"]]></cell>");
			sb.append("<cell><![CDATA["+ paidDate  +"]]></cell>");
			sb.append("</row>");
		}
		sb.append("</rows>");	
		return sb.toString();
	}

	public String getIncomePullListXML(String customerName, String programName, String cusType,ProOrder proOrder) {
		StringBuffer sb = new StringBuffer();
		
	    List ls = getIncomePullList(customerName,programName,cusType,proOrder);
	    
	    Map map = new HashMap();
	    Map cusName = proCustomerManager.getCustomerName(map);
	    
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");   
		
		for(Iterator it = ls.iterator();it.hasNext();){
			ProOrder obj = (ProOrder)it.next();
			String paidDates=obj.getPaidDate().equals(new Integer(0))?"":obj.getPaidDate().toString();
			String payDate = DateUtil.SetDateFormat(obj.getPayDate().toString(),"yyyy/MM/dd");
			String paidDate = DateUtil.SetDateFormat(paidDates,"yyyy/MM/dd");
			sb.append("<row  id=\""+ obj.getId()  +"\"" +">");
			sb.append("<cell><![CDATA["+ obj.getOrderCode()  +"]]></cell>");
			
			if(obj.getOrderTypeId().toString().equals(new Long(2).toString())){
			 	
			 	sb.append("<cell><![CDATA["+ cusName.get(obj.getCustomerId())  +"]]></cell>");
	    	}else{
	    		sb.append("<cell><![CDATA["+ obj.getProgram().getProCustomer().getCustomerName()  +"]]></cell>");
	    	} 
		
			sb.append("<cell><![CDATA["+ obj.getUser().getFirstName()+ obj.getUser().getLastName() +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(obj.getPayMoney())  +"]]></cell>");
			sb.append("<cell><![CDATA["+ payDate  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(obj.getPaidMoney()) +"]]></cell>");
			sb.append("<cell><![CDATA["+ paidDate  +"]]></cell>");
			sb.append("</row>");
		}
		sb.append("</rows>");	
		return sb.toString();
	}
	
	public String getPaymentPageXML(String customerName, ProOrder proOrder, String pageIndex, String pageSize) {
		proOrder.getProgram().getProCustomer().setCustomerName(customerName);
		proOrder.setOrderCode(proOrder.getOrderCode());
			
		StringBuffer sb = new StringBuffer();
	    List ls = dao.getProOrdersPage(proOrder,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));

	    Map map = new HashMap();
	    Map cusName = proCustomerManager.getCustomerName(map);
	    
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");   
		
		for(Iterator it = ls.iterator();it.hasNext();){
			ProOrder obj = (ProOrder)it.next();
			double payMoney = obj.getPayMoney().doubleValue();
			double paidMoney = obj.getPaidMoney().doubleValue();
			double contractPay = payMoney-paidMoney;
			if(contractPay!=0){
				String paidDates=obj.getPaidDate().equals(new Integer(0))?"":obj.getPaidDate().toString();
				String payDate = DateUtil.SetDateFormat(obj.getPayDate().toString(),"yyyy/MM/dd");
				String paidDate = DateUtil.SetDateFormat(paidDates,"yyyy/MM/dd");
				sb.append("<row  id=\""+ obj.getId()  +"\"" +">");
				sb.append("<cell><![CDATA["+ obj.getOrderCode()  +"]]></cell>");

				if(obj.getOrderTypeId().toString().equals(new Long(2).toString())){
				 	
				 	sb.append("<cell><![CDATA["+ cusName.get(obj.getCustomerId())  +"]]></cell>");
		    	}else{
		    		sb.append("<cell><![CDATA["+ obj.getProgram().getProCustomer().getCustomerName()  +"]]></cell>");
		    	} 
			
				sb.append("<cell><![CDATA["+ obj.getUser().getFullName()  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(new Double(payMoney))  +"]]></cell>");
				sb.append("<cell><![CDATA["+ payDate  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(new Double(paidMoney)) +"]]></cell>");
				sb.append("<cell><![CDATA["+ paidDate  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(new Double(contractPay)) +"]]></cell>");
				sb.append("</row>");
			}
			
		}
		sb.append("</rows>");	
		return sb.toString();
	}
	
	public String getPaymentByCustomerXML(ProOrder proOrder) {
		 StringBuffer sb = new StringBuffer();
		    List ls=new ArrayList();
	    	if(proOrder.getOrderTypeId().toString().equals(new Long(2).toString())){
	    		ls = dao.getProOrdersX(proOrder);
	    	}else{
	    		ls = dao.getProOrdersC(proOrder);
	    	} 
	    Map map = new HashMap();
	    Map cusName = proCustomerManager.getCustomerName(map);
	    
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");   
		for(Iterator it = ls.iterator();it.hasNext();){
			ProOrder obj = (ProOrder)it.next();
			double payMoney = obj.getPayMoney().doubleValue();
			double paidMoney = obj.getPaidMoney().doubleValue();
			double contractPay = payMoney-paidMoney;
			sb.append("<row  id=\""+ obj.getId()  +"\"" +">");
			sb.append("<cell><![CDATA["+ obj.getOrderCode()  +"]]></cell>");

			if(obj.getOrderTypeId().toString().equals(new Long(2).toString())){
			 	
			 	sb.append("<cell><![CDATA["+ cusName.get(obj.getCustomerId())  +"]]></cell>");
	    	}else{
	    		sb.append("<cell><![CDATA["+ obj.getProgram().getProCustomer().getCustomerName()  +"]]></cell>");
	    	} 
			sb.append("<cell><![CDATA["+ obj.getUser().getFullName()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(new Double(payMoney))  +"]]></cell>");
			sb.append("<cell><![CDATA["+ obj.getPayDate()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(new Double(paidMoney)) +"]]></cell>");
			sb.append("<cell><![CDATA["+ obj.getPaidDate()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(new Double(contractPay)) +"]]></cell>");
			sb.append("</row>");
		}
		sb.append("</rows>");	
		return sb.toString();
	}
	
	public List getIncomePullList(String customerName, String programName, String cusType,ProOrder proOrders) {
		ProOrder proOrder = new ProOrder();
		proOrder.getProgram().getProCustomer().setCustomerName(customerName);
		proOrder.setOrderCode(proOrders.getOrderCode());
		proOrder.setOrderTypeId(proOrders.getOrderTypeId());
		proOrder.getProgram().setProName(programName);

		if(cusType!=null){
			proOrder.getProgram().getProCustomer().setTypeId(new Long(cusType));
		}
		
		List ls = dao.getProOrderByObject(proOrder);
		return ls;
	}
	public void saveProIncomePulls(ProOrder[] proOrders) {
		dao.saveProIncomePulls(proOrders);
		
	}

	public String getProIncomePullCount(String customerName, String programName, String cusType, ProOrder proOrder) {
		proOrder.getProgram().getProCustomer().setCustomerName(customerName);
		proOrder.getProgram().setProName(programName);

		if(cusType!=null){
			proOrder.getProgram().getProCustomer().setTypeId(new Long(cusType));
		}
		
		String size = dao.getProCountByObject(proOrder).toString();
		return size;
	}

	public String getProPaymentCount(String customerName, ProOrder proOrder) {
		proOrder.getProgram().getProCustomer().setCustomerName(customerName);

		String size = dao.getProPayCountByObject(proOrder).toString();
		return size;
	}

public Collection getCollections(final String queryString,String type) {
		
		ProOrder proOrder = new ProOrder();
		
		String startDate = StringUtil.getParamFromUrl(queryString,"startDate");
		String endDate = StringUtil.getParamFromUrl(queryString,"endDate");
		String customerName = StringUtil.getParamFromUrl(queryString,"customerName");
		String programName =  StringUtil.getParamFromUrl(queryString,"programName");
		String proOrderType = StringUtil.getParamFromUrl(queryString,"proOrderTypeId");
		String userId = StringUtil.getParamFromUrl(queryString,"userId");
		String version=StringUtil.getParamFromUrl(queryString,"version");

		
		proOrder.setPayDate(Integer.valueOf(startDate));
		proOrder.setPaidDate(Integer.valueOf(endDate));
		proOrder.getProgram().getProCustomer().setCustomerName(customerName);
		proOrder.getProgram().setProName(programName);
		proOrder.setOrderTypeId(new Long(proOrderType));
		if(Integer.parseInt(userId)==0){
			proOrder.setUserId(null);
		}else{
			proOrder.setUserId(new Long(userId));
		}
		if(!version.equals("")){
			proOrder.setVersion(new Integer(version));
		}
		List ls=new ArrayList();
		if(Integer.parseInt(proOrderType)==1){
			ls = dao.getProOrdersC(proOrder);
		}else{
			ls = dao.getProOrdersX(proOrder);
		}
		Map map = new HashMap();
	    Map cusName = proCustomerManager.getCustomerName(map);
	    
		Collection coll = new ArrayList();
		List valuecoll = new ArrayList();
		
		int cols = 8;
		
		for(Iterator it = ls.iterator();it.hasNext();){
			
			ProOrder obj = (ProOrder)it.next();
			String ProOrderDate= DateUtil.SetDateFormat(obj.getPayDate().toString(),"yyyy/MM/dd");
			double payMoney = 0;
			double paidMoney = 0;
			String payDate = null;
			String paidDate = null;
			List lst = proFinanceManager.getProFinanceXML(obj.getId());
			for(Iterator its = lst.iterator();its.hasNext();){
				ProFinance objs=(ProFinance)its.next();
			    payMoney+=objs.getPayMoney().doubleValue();
			    paidMoney+=objs.getPaidMoney().doubleValue();
				payDate = DateUtil.SetDateFormat(objs.getPayDate().toString(),"yyyy/MM/dd");
				paidDate = DateUtil.SetDateFormat(objs.getPaidDate().toString(),"yyyy/MM/dd");
			}	
			FusionChartObject fObject = new FusionChartObject();
			
			if(type.equals("report")){
				for(int i=1;i<cols+1;i++){
					switch(i){
						case 1:
							fObject.setValue1(obj.getProgram().getProName());break;
						case 2:
							 if(obj.getOrderTypeId().toString().equals(new Long(2).toString())){
								 	fObject.setValue2(cusName.get(obj.getCustomerId()).toString());break;
						    	}else{
						    		fObject.setValue2(obj.getProgram().getProCustomer().getCustomerName());break;
						    	} 
						case 3:
							fObject.setValue3(StringUtil.doubleFormat2(new Double(payMoney)));break;
						case 4:
							fObject.setValue4(StringUtil.doubleFormat2(new Double(paidMoney)));break;
						case 5:
							fObject.setValue5(obj.getUser().getFullName());break;
						case 6:
							fObject.setValue6(ProOrderDate);break;
						case 7:
							fObject.setValue7(payDate);break;
						case 8:	
							fObject.setValue8(paidDate);break;
						default :
					}
				}
			}else{
				if(Integer.parseInt(proOrderType)==2){
					fObject.setLable(obj.getProgram().getProName()+"-"+cusName.get(obj.getCustomerId()).toString());
				}else{
					fObject.setLable(obj.getProgram().getProName()+"-"+obj.getProgram().getProCustomer().getCustomerName());
				}	
				fObject.setValue1(StringUtil.doubleFormat2(new Double(payMoney)));
				fObject.setValue2(StringUtil.doubleFormat2(new Double(paidMoney)));
			}

			valuecoll.add(fObject);
		}
		
		
		
		CollectionUtils.addAll(coll,valuecoll.iterator());
		
		return coll;	
		
	}    

public FusionChartObject[] getProOrderChartObjs(String queryString) {
	String query=StringUtil.getURLDecoderStr(queryString);
	String queryStrings=StringUtil.getURLDecoderStr(query);
	List ls = (List)this.getCollections(queryStrings,"chart");
	int size = ls.size();
	FusionChartObject fusionChartObjects[] =  new FusionChartObject[size];
	for(int i = 0 ; i<size;i++ ){
		fusionChartObjects[i] =(FusionChartObject)ls.get(i);
	}
	return fusionChartObjects;
}

public Collection getCollectionsByPayment(final String queryString,String type) {
	
	ProOrder proOrder = new ProOrder();
	
	String customerName = StringUtil.getParamFromUrl(queryString,"customerName");
	String orderTypeId=StringUtil.getParamFromUrl(queryString,"orderTypeId");
	if(!orderTypeId.equals("")&&orderTypeId!=null&&Integer.parseInt(orderTypeId)!=0){
		proOrder.setOrderTypeId(new Long(orderTypeId));
	}
	proOrder.getProgram().getProCustomer().setCustomerName(customerName);
	
	List ls = dao.getProOrderByObject(proOrder);
	
	Map map = new HashMap();
    Map cusName = proCustomerManager.getCustomerName(map);
	
	Collection coll = new ArrayList();
	List valuecoll = new ArrayList();
	
	int cols = 8;
	
	
	for(Iterator it = ls.iterator();it.hasNext();){
		
		ProOrder obj = (ProOrder)it.next();
		String paidDate=obj.getPaidDate().equals(new Integer(0))?"":obj.getPaidDate().toString();
		double payMoney = obj.getPayMoney().doubleValue();
		double paidMoney = obj.getPaidMoney().doubleValue();
		double contractPay = payMoney-paidMoney;
		FusionChartObject fObject = new FusionChartObject();
		if(contractPay!=0){
		if(type.equals("report")){
			for(int i=1;i<cols+1;i++){
				switch(i){
					case 1:
						fObject.setValue1(obj.getOrderCode());break;
					case 2:
						 if(obj.getOrderTypeId().toString().equals(new Long(2).toString())){
							 	fObject.setValue2(cusName.get(obj.getCustomerId()).toString());break;
					    	}else{
					    		fObject.setValue2(obj.getProgram().getProCustomer().getCustomerName());break;
					    	} 
					case 3:
						fObject.setValue3(obj.getUser().getFullName());break;
					case 4:
						fObject.setValue4(StringUtil.doubleFormat2(new Double(payMoney)));break;
					case 5:
						fObject.setValue5(DateUtil.SetDateFormat(obj.getPayDate().toString(),"yyyy/MM/dd"));break;
					case 6:
						fObject.setValue6(StringUtil.doubleFormat2(new Double(paidMoney)));break;
					case 7:						
						fObject.setValue7(DateUtil.SetDateFormat(paidDate,"yyyy/MM/dd"));break;
					case 8:
						fObject.setValue8(StringUtil.doubleFormat2(new Double(contractPay)));break;
					default :
				}
			}
		}else{
			fObject.setLable(obj.getOrderCode()+"-"+obj.getProgram().getProCustomer().getCustomerName());
			fObject.setValue1(StringUtil.doubleFormat2(new Double(payMoney)));
			fObject.setValue2(StringUtil.doubleFormat2(new Double(paidMoney)));
			fObject.setValue3(StringUtil.doubleFormat2(new Double(contractPay)));
		}

		valuecoll.add(fObject);
		}
	}
	
	
	
	CollectionUtils.addAll(coll,valuecoll.iterator());
	
	return coll;	
	
} 

public FusionChartObject[] getProOrderChartObjsByPayment(String queryString) {
	String query=StringUtil.getURLDecoderStr(queryString);
	String queryStrings=StringUtil.getURLDecoderStr(query);
	List ls = (List)this.getCollectionsByPayment(queryStrings,"chart");
	int size = ls.size();
	FusionChartObject fusionChartObjects[] =  new FusionChartObject[size];
	for(int i = 0 ; i<size;i++ ){
		fusionChartObjects[i] =(FusionChartObject)ls.get(i);
	}
	return fusionChartObjects;
}

public Collection getCollectionsByIncomePulls(final String queryString,String type) {
	
	ProOrder proOrder = new ProOrder();
	
	String orderCode = StringUtil.getParamFromUrl(queryString,"orderCode");
	String customerName = StringUtil.getParamFromUrl(queryString,"customerName");
	String programName = StringUtil.getParamFromUrl(queryString,"programName");
	String cusType = StringUtil.getParamFromUrl(queryString,"typeId");
	String orderTypeId = StringUtil.getParamFromUrl(queryString,"orderTypeId");
	
	if(cusType.equals(""))cusType=null;
	
	if(!orderTypeId.equals("")&&orderTypeId!=null&&Integer.parseInt(orderTypeId)!=0){
		proOrder.setOrderTypeId(new Long(orderTypeId));
	}
	proOrder.setOrderCode(orderCode);
	
	List ls = getIncomePullList(customerName,programName,cusType,proOrder);
	
	Map map = new HashMap();
    Map cusName = proCustomerManager.getCustomerName(map);
	
	Collection coll = new ArrayList();
	List valuecoll = new ArrayList();
	
	int cols = 7;
	
	
	for(Iterator it = ls.iterator();it.hasNext();){
		
		ProOrder obj = (ProOrder)it.next();
		String paidDate=obj.getPaidDate().equals(new Integer(0))?"":obj.getPaidDate().toString();
		FusionChartObject fObject = new FusionChartObject();
		
		if(type.equals("report")){
			for(int i=1;i<cols+1;i++){
				switch(i){
					case 1:
						fObject.setValue1(obj.getOrderCode());break;
					case 2:
						 if(obj.getOrderTypeId().toString().equals(new Long(2).toString())){
							 	fObject.setValue2(cusName.get(obj.getCustomerId()).toString());break;
					    	}else{
					    		fObject.setValue2(obj.getProgram().getProCustomer().getCustomerName());break;
					    	} 
						
					case 3:
						fObject.setValue3(obj.getUser().getFullName());break;
					case 4:
						fObject.setValue4(StringUtil.doubleFormat2(obj.getPayMoney()));break;
					case 5:
						fObject.setValue5(DateUtil.SetDateFormat(obj.getPayDate().toString(),"yyyy/MM/dd"));break;
					case 6:
						fObject.setValue6(StringUtil.doubleFormat2(obj.getPaidMoney()));break;
					case 7:						
						fObject.setValue7(DateUtil.SetDateFormat(paidDate,"yyyy/MM/dd"));break;
					default :
				}
			}
		}else{
			fObject.setLable(obj.getOrderCode()+"-"+obj.getProgram().getProCustomer().getCustomerName());
			fObject.setValue1(StringUtil.doubleFormat2(obj.getPayMoney()));
			fObject.setValue2(StringUtil.doubleFormat2(obj.getPaidMoney()));
		}

		valuecoll.add(fObject);
	}
	
	
	
	CollectionUtils.addAll(coll,valuecoll.iterator());
	
	return coll;	
	
} 

public FusionChartObject[] getProOrderChartObjsByIncomePulls(String queryString) {
	String query=StringUtil.getURLDecoderStr(queryString);
	String queryStrings=StringUtil.getURLDecoderStr(query);
	List ls = (List)this.getCollectionsByIncomePulls(queryStrings,"chart");
	int size = ls.size();
	FusionChartObject fusionChartObjects[] =  new FusionChartObject[size];
	for(int i = 0 ; i<size;i++ ){
		fusionChartObjects[i] =(FusionChartObject)ls.get(i);
	}
	return fusionChartObjects;
}




}
