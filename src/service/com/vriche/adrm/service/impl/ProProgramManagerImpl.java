
package com.vriche.adrm.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import com.vriche.adrm.dao.ProCustomerDao;
import com.vriche.adrm.dao.ProProgramDao;
import com.vriche.adrm.dao.ProProgramDetailDao;
import com.vriche.adrm.model.FusionChartObject;
import com.vriche.adrm.model.ProCustomer;
import com.vriche.adrm.model.ProOrder;
import com.vriche.adrm.model.ProProgram;
import com.vriche.adrm.model.ProProgramDetail;
import com.vriche.adrm.service.ProCustomerManager;
import com.vriche.adrm.service.ProProgramManager;
import com.vriche.adrm.util.StringUtil;
import com.vriche.adrm.util.DateUtil;


public class ProProgramManagerImpl extends BaseManager implements ProProgramManager {
    private ProProgramDao dao;
    private ProCustomerDao proCustomerDao;
    private ProCustomerManager proCustomerManager;
    private ProProgramDetailDao proProgramDetailDao;

	public void setProCustomerManager(ProCustomerManager proCustomerManager) {
		this.proCustomerManager = proCustomerManager;
	} 
    /**
	 * @param proCustomerDao The proCustomerDao to set.
	 */
	public void setProCustomerDao(ProCustomerDao proCustomerDao) {
		this.proCustomerDao = proCustomerDao;
	}
	/**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setProProgramDao(ProProgramDao dao) {
        this.dao = dao;
    }
	/**
     * Set the ProProgramDetailDao for communication with the data layer.
     * @param proProgramDetailDao
     */
    public void setProProgramDetailDao(ProProgramDetailDao proProgramDetailDao) {
    	this.proProgramDetailDao = proProgramDetailDao;
    }
   /**
     * @see com.vriche.adrm.service.ProProgramManager#getProPrograms(com.vriche.adrm.model.ProProgram)
     */
    public List getProPrograms(final ProProgram proProgram) {
        return dao.getProPrograms(proProgram);
    }
    
    /**
     * @see com.vriche.adrm.service.ProProgramManager#getProPrograms(com.vriche.adrm.model.ProProgram)
     */
    public List getProProgramsByOrder(final ProProgram proProgram) {
        return dao.getProProgramsByOrder(proProgram);
    }
    
    /**
     * @see com.vriche.adrm.service.ProProgramManager#getProPrograms(com.vriche.adrm.model.ProProgram)
     */
    public List getProProgramsAll(final ProProgram proProgram) {
        return dao.getProProgramsAll(proProgram);
    }
    
    public ProCustomer getProCustomerXML(final String id) {
    	
    	ProProgram proProgram= dao.getProProgram(new Long(id));
    	String customerId=proProgram.getCustomerId().toString();
    	return proCustomerManager.getProCustomer(customerId);
    }
    
    /**
     * @see com.vriche.adrm.service.ProProgramManager#getProProgramId(com.vriche.adrm.model.ProProgram)
     */
    public ProProgram getProProgramId(final ProProgram proProgram) {
    	ProProgram program=new ProProgram();
    	List ls=getProPrograms(proProgram);
    	for(Iterator it = ls.iterator();it.hasNext();){
    		ProProgram obj = (ProProgram)it.next();
    		program.setId(obj.getId());
    	}
		return program;
    }

   /**
     * @see com.vriche.adrm.service.ProProgramManager#getProProgramsCount(com.vriche.adrm.model.ProProgram)
     */
    public String getProProgramsCount(final ProProgram proProgram) {
        return dao.getProProgramsCount(proProgram).toString();
    } 
    /**
     * @see com.vriche.adrm.service.ProProgramManager#getProProgramsCountByName(com.vriche.adrm.model.ProProgram)
     */
    public String getProProgramsCountByName(ProProgram proProgram,String dateType){
//    	getProTypeChild(proProgram);
    	List ls = getProgramsPageList1(proProgram,dateType);
    	return new Integer(ls.size()).toString();
    }

   /**
     * @see com.vriche.adrm.service.ProProgramManager#getProProgramsCount(com.vriche.adrm.model.ProProgram)
     */    
	public List getProProgramsPage(final ProProgram proProgram,String pageIndex, String pageSize) {
		return dao.getProProgramsPage(proProgram,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    
   /**
     * @see com.vriche.adrm.service.ProProgramManager#getProProgramsCount(com.vriche.adrm.model.ProProgram)
     */    
	public String getProProgramsPageXML(final ProProgram proProgram,String pageIndex, String pageSize) {
	    StringBuffer sb = new StringBuffer();
	    List ls = dao.getProProgramsPage(proProgram,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	    sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
	    sb.append("<rows>");  
		for(Iterator it = ls.iterator();it.hasNext();){
			ProProgram obj = (ProProgram)it.next();
			sb.append("<row  id=\""+ obj  +"\"" +">");
			sb.append("<cell><![CDATA["+ obj  +"]]></cell>");
			sb.append("</row>");
		}
		sb.append("</rows>");
		return sb.toString();
	}    

    /**
     * @see com.vriche.adrm.service.ProProgramManager#getProProgram(String id)
     */
    public ProProgram getProProgram(final String id) {
        return dao.getProProgram(new Long(id));
    }
    /**
     * @see com.vriche.adrm.service.ProProgramManager#getProProgramsByIdList(final Map idList)
     */
    public List getProProgramsByMap(final Map mp) {
        return dao.getProProgramsByMap(mp);
    }    

    /**
     * @see com.vriche.adrm.service.ProProgramManager#saveProProgram(ProProgram proProgram)
     */
    public String saveProProgram(ProProgram proProgram) {
        return dao.saveProProgram(proProgram).toString();
    }
    
    /**
     * @see com.vriche.adrm.service.ProProgramManager#saveProProgramStatus(ProProgram proProgram)
     */
    public void saveProProgramStatus(ProProgram proProgram) {
        dao.saveProProgramStatus(proProgram);
    }

    /**
     * @see com.vriche.adrm.service.ProProgramManager#removeProProgram(String id)
     */
    public void removeProProgram(final String id) {
        dao.removeProProgram(new Long(id));
    }

     /**
     * @see com.vriche.adrm.service.ProProgramManager#removeProPrograms(String Map)
     */
    public void removeProPrograms(final Map mp) {
        dao.removeProPrograms(mp);
    }
	public String getProgramNameXML(ProProgram proProgram) {
		 StringBuffer sb = new StringBuffer();
		 int i=1;
		    List ls = dao.getProPrograms(proProgram);
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<complete>");   
			for(Iterator it = ls.iterator();it.hasNext();){
				ProProgram obj = (ProProgram)it.next();
				sb.append("<option  value=\""+ i++  +"\"" +">");
				sb.append("<![CDATA["+ obj.getProName() +"]]>");
				sb.append("</option>");
			}
			sb.append("</complete>");	
			return sb.toString();
	}
	
	public String getProgramNameByOrderXML(ProProgram proProgram) {
		 StringBuffer sb = new StringBuffer();
		 int i=1;
		    List ls = dao.getProProgramsAll(proProgram);
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<complete>");   
			for(Iterator it = ls.iterator();it.hasNext();){
				ProProgram obj = (ProProgram)it.next();
				sb.append("<option  value=\""+ i++  +"\"" +">");
				sb.append("<![CDATA["+ obj.getProName() +"]]>");
				sb.append("</option>");
			}
			sb.append("</complete>");	
			return sb.toString();
	}
	public String getCopyrightNumXML(ProProgram proProgram) {
		StringBuffer sb = new StringBuffer();
		int i=1;
	    List ls = dao.getProPrograms(proProgram);
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<complete>");   
		for(Iterator it = ls.iterator();it.hasNext();){
			ProProgram obj = (ProProgram)it.next();
			sb.append("<option  value=\""+ i++  +"\"" +">");
			sb.append("<![CDATA["+ obj.getCopyrightNum() +"]]>");
			sb.append("</option>");
		}
		sb.append("</complete>");	
		return sb.toString();
	}
	
	public List getProTypeChild(Long proTypeId){
		List proTypeIdList = new ArrayList();
//		Long proTypeId = proProgram.getProProgramType().getId();
		List typeIdList = dao.getProTypeChild(proTypeId) ;
		for(Iterator it = typeIdList.iterator();it.hasNext();){
			ProProgram obj = (ProProgram)it.next();
			Long typeId = obj.getProProgramType().getId();
//			proTypeIdList.add(typeId) ;
//			System.out.println("typeId<<<<<<<<<***********<<<<<<<<<<"+typeId);
			getProTypeChild(typeId);
		}
		if(proTypeId.intValue()!= 0){
			proTypeIdList.add(proTypeId);
		}
		return proTypeIdList;
	}
	//搜索节目信息
	public String getProgramsPageXML(final ProProgram proProgram,String dateType,String pageIndex, String pageSize) {

		List ls = getProgramsPageList(proProgram,dateType,pageIndex,pageSize);
		return makeProgramsPageXML(ls);
	}
	
	public List getProgramsPageList(ProProgram proProgram,String dateType,String pageIndex, String pageSize){
		List lsType = new ArrayList();
		
		Long proTypeId = proProgram.getProProgramType().getId();

		if(proTypeId!=null){
		lsType = getProTypeChild(proTypeId);
		}
		proProgram.setBusinessName("3");
		proProgram.setProTypeIdList(lsType);
		
		List proIdList = new ArrayList();
		ProOrder proOrder = new ProOrder();
		proOrder.setOrderTypeId(new Long(1));
		List orderList = dao.getProNameByOrders(proOrder);
		for(Iterator it = orderList.iterator();it.hasNext();){
			ProOrder obj = (ProOrder)it.next();
			Long proId = obj.getProgramId();
			proIdList.add(proId);
		}
		
		Map soldMoneyMap = new HashMap();
		ProOrder pOrder = new ProOrder();
		pOrder.setOrderTypeId(new Long(2));
		List soldMoneyList = dao.getPayMoneyList(pOrder);
		for(Iterator it = soldMoneyList.iterator();it.hasNext();){
			ProOrder obj = (ProOrder)it.next();
			String proId = obj.getProgramId().toString();
			Double payMoney = obj.getPaidMoney();
			soldMoneyMap.put(proId,payMoney);
		}
		
	    List ls = dao.getProProgramsByPage(proProgram,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	    return getProgramsList(ls,proIdList,soldMoneyMap,dateType,proProgram);
	}

	public List getProgramsList(List ls,List proIdList,Map soldMoneyMap,String dateType,ProProgram proProgram){
		List list = new ArrayList();
		
		Long isBuy = proProgram.getCreateBy();
		Long isPay = proProgram.getModifyBy();
		
		Integer sDate = proProgram.getStartDate();
		Integer eDate = proProgram.getEndDate();
	    String buyState = null;
		for(Iterator it = ls.iterator();it.hasNext();){
			ProProgram obj = (ProProgram)it.next();
			Long proNameId = obj.getId();
			Integer startDateNum = obj.getStartDate()==null?new Integer(0):obj.getStartDate() ;
			Integer endDateNum = obj.getEndDate()==null?new Integer(0):obj.getEndDate() ;
			Double  sowCount = obj.getSowCount();
			Double  price = obj.getPrice();
			double sum = sowCount.doubleValue() * price.doubleValue();
			obj.getProCustomer().setLinkmanName(new Double(sum).toString());
			int startDate = startDateNum.intValue();
			int endDate =  endDateNum.intValue() ;
			int limitTime = 0;
			if(startDate!=0&&endDate!=0 ){
				startDate = new Integer(startDateNum.toString().substring(0,4)).intValue();
				endDate =  new Integer(endDateNum.toString().substring(0,4)).intValue() ;
				limitTime = endDate - startDate + 1;
				
			}else{
				limitTime = 0;
			}
			obj.getProCustomer().setTelephone(new Integer(limitTime).toString());
			if(isBuy!=null){
				if(isBuy.equals(new Long(1))){
					
					if(proIdList.contains(proNameId)){
						buyState = "已购买";
					}else{
						continue;
					}
				}else{
					if(proIdList.contains(proNameId)){
						continue;
					}else if(obj.getProgramStatusId().intValue()==1){
						buyState = "制作中";
					}else{
						buyState = "热映中";
					}
				}
			}else{
				if(proIdList.contains(proNameId)){
					buyState = "已购买";
				}else if(obj.getProgramStatusId().intValue()==1){
					buyState = "制作中";
				}else{
					buyState = "热映中";
				}
			}
			Double pMoney = (Double)soldMoneyMap.get(proNameId.toString());
			pMoney = pMoney==null?new Double(0):pMoney ;
			if(isPay!=null){
				if(isPay.equals(new Long(1))){
					if(pMoney.equals(new Double(0))){
						continue;
					}
				}else{
					if(!pMoney.equals(new Double(0))){
						continue;
					}
				}
			}
			Date createDate  = obj.getCreateDate();
			Integer date = new Integer(DateUtil.convertDateToString("yyyyMMdd",createDate));
			Integer arriveDate = obj.getArriveDate();
			if(dateType.equals("1")){
				if(date.intValue()<sDate.intValue() || date.intValue()>eDate.intValue()){
					continue; 
				}
			}
			if(dateType.equals("2")){
				if(arriveDate.intValue()<sDate.intValue() || arriveDate.intValue()>eDate.intValue()){
					continue; 
				}
			}
			obj.getProCustomer().setHelpCode(pMoney.toString());
			obj.getProCustomer().setFax(buyState);
			list.add(obj);
		}
		return list;
	} 
	public List getProgramsPageList1(ProProgram proProgram,String dateType){
		List list = new ArrayList();
		List lsType = new ArrayList();
		
		Long proTypeId = proProgram.getProProgramType().getId();

		if(proTypeId!=null){
		lsType = getProTypeChild(proTypeId);
		}
		
		proProgram.setProTypeIdList(lsType);
		
		Long isBuy = proProgram.getCreateBy();
		Long isPay = proProgram.getModifyBy();
		proProgram.setBusinessName("3");
		Integer sDate = proProgram.getStartDate();
		Integer eDate = proProgram.getEndDate();
		
		List proIdList = new ArrayList();
		ProOrder proOrder = new ProOrder();
		proOrder.setOrderTypeId(new Long(1));
		List orderList = dao.getProNameByOrders(proOrder);
		for(Iterator it = orderList.iterator();it.hasNext();){
			ProOrder obj = (ProOrder)it.next();
			Long proId = obj.getProgramId();
			proIdList.add(proId);
		}
		
		Map soldMoneyMap = new HashMap();
		ProOrder pOrder = new ProOrder();
		pOrder.setOrderTypeId(new Long(2));
		List soldMoneyList = dao.getPayMoneyList(pOrder);
		for(Iterator it = soldMoneyList.iterator();it.hasNext();){
			ProOrder obj = (ProOrder)it.next();
			String proId = obj.getProgramId().toString();
			Double payMoney = obj.getPaidMoney();
			soldMoneyMap.put(proId,payMoney);
		}
		
		List ls = dao.getProProgramsByPage1(proProgram);
		 String buyState = null;
			for(Iterator it = ls.iterator();it.hasNext();){
				ProProgram obj = (ProProgram)it.next();
				Long proNameId = obj.getId();
				Integer startDateNum = obj.getStartDate()==null?new Integer(0):obj.getStartDate() ;
				Integer endDateNum = obj.getEndDate()==null?new Integer(0):obj.getEndDate() ;
				Double  sowCount = obj.getSowCount();
				Double  price = obj.getPrice();
				double sum = sowCount.doubleValue() * price.doubleValue();
				obj.getProCustomer().setLinkmanName(new Double(sum).toString());
				int startDate = startDateNum.intValue();
				int endDate =  endDateNum.intValue() ;
				int limitTime = 0;
				if(startDate!=0&&endDate!=0 ){
					startDate = new Integer(startDateNum.toString().substring(0,4)).intValue();
					endDate =  new Integer(endDateNum.toString().substring(0,4)).intValue() ;
					limitTime = endDate - startDate + 1;
					
				}else{
					limitTime = 0;
				}
				obj.getProCustomer().setTelephone(new Integer(limitTime).toString());
				if(isBuy!=null){
					if(isBuy.equals(new Long(1))){
						
						if(proIdList.contains(proNameId)){
							buyState = "已购买";
						}else{
							continue;
						}
					}else{
						if(proIdList.contains(proNameId)){
							continue;
						}else{
							buyState = "未购买";
						}
					}
				}else{
					if(proIdList.contains(proNameId)){
						buyState = "已购买";
					}else{
						buyState = "未购买";
					}
				}
				Double pMoney = (Double)soldMoneyMap.get(proNameId.toString());
				pMoney = pMoney==null?new Double(0):pMoney ;
				if(isPay!=null){
					if(isPay.equals(new Long(1))){
						if(pMoney.equals(new Double(0))){
							continue;
						}
					}else{
						if(!pMoney.equals(new Double(0))){
							continue;
						}
					}
				}
				Date createDate  = obj.getCreateDate();
				Integer date = new Integer(DateUtil.convertDateToString("yyyyMMdd",createDate));
				Integer arriveDate = obj.getArriveDate();
				if(dateType.equals("1")){
					if(date.intValue()<=sDate.intValue() || date.intValue()>=eDate.intValue()){
						continue; 
					}
				}
				if(dateType.equals("2")){
					if(arriveDate.intValue()<=sDate.intValue() || arriveDate.intValue()>=eDate.intValue()){
						continue; 
					}
				}
				obj.getProCustomer().setHelpCode(pMoney.toString());
				obj.getProCustomer().setFax(buyState);
				list.add(obj);
			}
			return list;
	}
	public static  String makeProgramsPageXML(List all){
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");   
		for(Iterator it = all.iterator();it.hasNext();){
			ProProgram obj = (ProProgram)it.next();
			String copyrightNum = obj.getCopyrightNum()==null?"":obj.getCopyrightNum() ;
			Double sum = new Double(obj.getProCustomer().getLinkmanName());
			String aaaa = obj.getProCustomer().getHelpCode();
			Double pMoney = aaaa==null?new Double(0):new Double(aaaa) ;
			
			sb.append("<row  id=\""+ obj.getId()  +"\">");
			sb.append("<cell><![CDATA["+ obj.getProName()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ obj.getProCustomer().getCustomerName()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ copyrightNum  +"]]></cell>");
			sb.append("<cell><![CDATA["+ obj.getBusinessName()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ obj.getProProgramType().getName() +"]]></cell>");
			sb.append("<cell><![CDATA["+ obj.getProCustomer().getTelephone() +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(sum) +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(pMoney) +"]]></cell>");
			sb.append("<cell><![CDATA["+ obj.getProCustomer().getFax() +"]]></cell>");
			sb.append("<cell><![CDATA["+ obj.getProCustomer().getAccountAddress() +"]]></cell>");
			sb.append("</row>");
		}
		sb.append("</rows>");	
		return sb.toString();
	}
	public String getProgramByCustomerXML(String customerName) {
		ProProgram pProgram = new ProProgram();
		pProgram.getProCustomer().setCustomerName(customerName);
		
		StringBuffer sb = new StringBuffer();
	    List ls = dao.getProProgramsByName(pProgram);
	    sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
	    sb.append("<rows>");  
		for(Iterator it = ls.iterator();it.hasNext();){
			ProProgram obj = (ProProgram)it.next();
			String copyrightNum = obj.getCopyrightNum()==null?"":obj.getCopyrightNum() ;

			Integer startDateNum = obj.getStartDate()==null?new Integer(0):obj.getStartDate() ;
			Integer endDateNum = obj.getEndDate()==null?new Integer(0):obj.getEndDate() ;
			int startDate = startDateNum.intValue();
			int endDate =  endDateNum.intValue() ;
			int limitTime = 0;
			if(startDate!=0&&endDate!=0 ){
				startDate = new Integer(startDateNum.toString().substring(0,4)).intValue();
				endDate =  new Integer(endDateNum.toString().substring(0,4)).intValue() ;
				limitTime = endDate - startDate + 1;
				
			}else{
				limitTime = 0;
			}
			
			sb.append("<row  id=\""+ obj.getId()  +"\">");
			sb.append("<cell><![CDATA["+ obj.getProName()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ obj.getProCustomer().getCustomerName()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ copyrightNum  +"]]></cell>");
			sb.append("<cell><![CDATA["+ obj.getBusinessName()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ obj.getProProgramType().getName() +"]]></cell>");
			sb.append("<cell><![CDATA["+ limitTime +"]]></cell>");
			sb.append("</row>");
		}
		sb.append("</rows>");
		return sb.toString();
	}
	
	public String saveProProgramByName(ProProgram proProgram, String customername,String customerTypeId) {
		ProCustomer proCustomer = new ProCustomer() ;
		proCustomer.setCustomerName(customername) ;
		List idList = proCustomerDao.getProCustomers(proCustomer) ;
		for(Iterator it = idList.iterator();it.hasNext();){
			ProCustomer proCust = (ProCustomer) it.next() ;
			Long customerId =proCust.getId() ;
			proProgram.setCustomerId(customerId) ;
		}
		if(proProgram.getCustomerId()==null){
//			保存客户信息
		    checkIsNewCustomer(proProgram,customername,customerTypeId);
		}

		return dao.saveProProgram(proProgram).toString();
	}    
	private void checkIsNewCustomer(ProProgram proProgram, String customername,String customerTypeId){
		Long customerId = proProgram.getCustomerId();
		
		ProCustomer proCustomer = new ProCustomer();
		proCustomer.setId(customerId);
		proCustomer.setCustomerName(customername);
		proCustomer.setTypeId(new Long(customerTypeId));
		
		String id = proCustomerManager.saveProCustomer(proCustomer);
		proProgram.setCustomerId(new Long(id));
	}
	
public Map getProProgramAllFromMap(ProProgram proProgram, boolean enable, boolean needZeroId) {
		List carrs = dao.getProPrograms(proProgram);
		
		Map reply = new LinkedHashMap();
		if(needZeroId) reply.put("0","== 频道 ==");
		for(Iterator it = carrs.iterator();it.hasNext();){
			ProProgram carr = (ProProgram)it.next();
			reply.put(carr.getId(),carr.getProName());
			
		}
		return reply;
	}
public static String getStarConvert(int starNum){
	String starStr = null;
	   switch(starNum){
			    case 1:
			    	starStr = "一星级";
	 				break;
	   			case 2:
	   				starStr = "二星级";
	   				break;
	   			case 3:
	   				starStr = "三星级";
	   				break;
	   			case 4:
	   				starStr = "四星级";
	   				break;
	   			case 5:
	   				starStr = "五星级";
	   				break;
	   			}
	   return starStr;
}
public String getProgramDetailXML(ProProgramDetail proProgramDetail){
	
	StringBuffer sb = new StringBuffer();
	ProProgramDetail obj=proProgramDetailDao.getProProgramDetail(proProgramDetail.getProgramId());

    sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    sb.append("<rows>");  
	if(obj!=null){
		String inputDate = obj.getInputDate()==null?"":DateUtil.SetDateFormat(obj.getInputDate().toString(),"yyyy/MM/dd") ;
		String firstDate = obj.getFirstDate()==null?"":DateUtil.SetDateFormat(obj.getFirstDate().toString(),"yyyy/MM/dd") ;
		String incomeMoney = obj.getIncomeMoney()==null?"":obj.getIncomeMoney().toString();
		String rate = obj.getRate()==null?"":obj.getRate().toString();
		System.out.println("obj.getRate()="+obj.getRate());
		sb.append("<row  id=\""+ obj.getId()  +"\">");
		sb.append("<cell><![CDATA["+ inputDate  +"]]></cell>");
		sb.append("<cell><![CDATA["+ firstDate +"]]></cell>");
		sb.append("<cell><![CDATA["+ obj.getDirector() +"]]></cell>");
		sb.append("<cell><![CDATA["+ obj.getActor() +"]]></cell>");
		sb.append("<cell><![CDATA["+ obj.getContent()  +"]]></cell>");
		sb.append("<cell><![CDATA["+ obj.getOpinion()  +"]]></cell>");
		sb.append("<cell><![CDATA["+ incomeMoney +"]]></cell>");
		sb.append("<cell><![CDATA["+ rate +"]]></cell>");
		sb.append("<cell><![CDATA["+ getStarConvert(Integer.parseInt(obj.getCommendLevel())) +"]]></cell>");
		sb.append("</row>");
	}
	sb.append("</rows>");
	
	return sb.toString();
}
public ProProgramDetail getProgramDetail(ProProgramDetail proProgramDetail){
	return proProgramDetailDao.getProProgramDetail(proProgramDetail.getProgramId());
}

public void removeProgramDetail(final Long id){
	proProgramDetailDao.removeProProgramDetail(id);           
}

public void saveProProgramDetail(ProProgramDetail proProgramDetail){
	proProgramDetailDao.saveProProgramDetail(proProgramDetail);           
}

public List getProgramsCollectionList(ProProgram proProgram,String dateType){

	Long proTypeId = proProgram.getProProgramType().getId();
	List lsType = getProTypeChild(proTypeId);
	proProgram.setProTypeIdList(lsType);
	proProgram.setBusinessName("3");

	List proIdList = new ArrayList();
	ProOrder proOrder = new ProOrder();
	proOrder.setOrderTypeId(new Long(1));
	List orderList = dao.getProNameByOrders(proOrder);
	for(Iterator it = orderList.iterator();it.hasNext();){
		ProOrder obj = (ProOrder)it.next();
		Long proId = obj.getProgramId();
		proIdList.add(proId);
	}
	
	Map soldMoneyMap = new HashMap();
	ProOrder pOrder = new ProOrder();
	pOrder.setOrderTypeId(new Long(2));
	List soldMoneyList = dao.getPayMoneyList(pOrder);
	for(Iterator it = soldMoneyList.iterator();it.hasNext();){
		ProOrder obj = (ProOrder)it.next();
		String proId = obj.getProgramId().toString();
		Double payMoney = obj.getPaidMoney();
		soldMoneyMap.put(proId,payMoney);
	}
	
    List ls = dao.getProProgramsByName(proProgram);
    
    return getProgramsList(ls,proIdList,soldMoneyMap,dateType,proProgram);
}
public Collection getCollections(final String queryString,String type) {
		
		ProProgram proProgram = new ProProgram();
		
//		  dateType:dateType,
//        String  proProgramType = StringUtil.getParamFromUrl(queryString,"proProgramType");
//        programStatusId:programStatusId,
//        copyrightArea:copyrightArea,
//        isSell:isSell,
//        createBy:createBy,
//        isChecked:isChecked,
//        modifyBy:modifyBy,
//        startDate:startDate,
//        endDate:endDate,
		
		String  dateType = StringUtil.getParamFromUrl(queryString,"dateType");
		String  proProgramType = StringUtil.getParamFromUrl(queryString,"proProgramType");
		String  programStatusId = StringUtil.getParamFromUrl(queryString,"programStatusId");
		String  commendLevel = StringUtil.getParamFromUrl(queryString,"copyrightArea");
		String  isSell = StringUtil.getParamFromUrl(queryString,"isSell");
		String  createBy = StringUtil.getParamFromUrl(queryString,"createBy");
		String  modifyBy = StringUtil.getParamFromUrl(queryString,"modifyBy");
		String  isChecked = StringUtil.getParamFromUrl(queryString,"isChecked");
		String  startDateRe = StringUtil.getParamFromUrl(queryString,"startDate");
		String  endDateRe = StringUtil.getParamFromUrl(queryString,"endDate");

		String copyrightNum = StringUtil.getParamFromUrl(queryString,"copyrightNum");
		String customerName = StringUtil.getParamFromUrl(queryString,"customerName");
		String programName = StringUtil.getParamFromUrl(queryString,"programName");
		proProgramType = proProgramType==null||proProgramType==""?"0":proProgramType;
		
		
		proProgram.setBusinessName("3");
		proProgram.getProProgramType().setId(new Long(proProgramType));
//		System.out.println("programStatusId<<<<<<<<<<<@@@@@@@@@@@@@<<<<<<<<<<"+ programStatusId );
		if(!programStatusId.equals("")){
//			System.out.println("programStatusId<<<<<<<<<<<@@@@@@@@@@@@@<<<<<<<<<<"+ programStatusId.length() );
			proProgram.setProgramStatusId(new Long(programStatusId));
			}
		if(commendLevel!=""){
			proProgram.setCopyrightArea(commendLevel);
			}
		if(!isSell.equals("")){
			proProgram.setIsSell(new Long(isSell));
			}
		if(!isChecked.equals("")){
			proProgram.setIsChecked(new Long(isChecked));
			}
		if(!createBy.equals("")){
			proProgram.setCreateBy(new Long(createBy));
			}
		if(!modifyBy.equals("")){
			proProgram.setModifyBy(new Long(modifyBy));
			}
		
		proProgram.setStartDate(new Integer(startDateRe));
		proProgram.setEndDate(new Integer(endDateRe));
		
		proProgram.setCopyrightNum(copyrightNum);
		proProgram.getProCustomer().setCustomerName(customerName);
		proProgram.setProName(programName);
		
		List ls = getProgramsCollectionList(proProgram,dateType);
		
		Collection coll = new ArrayList();
		List valuecoll = new ArrayList();
		
		int cols = 10;
		
		for(Iterator it = ls.iterator();it.hasNext();){
			
			ProProgram obj = (ProProgram)it.next();
			String copyrightN = obj.getCopyrightNum()==null?"":obj.getCopyrightNum() ;
			Double sum = new Double(obj.getProCustomer().getLinkmanName());
			String aaaa = obj.getProCustomer().getHelpCode();
			Double pMoney = aaaa==null?new Double(0):new Double(aaaa) ;
			FusionChartObject fObject = new FusionChartObject();
			
			if(type.equals("report")){
				for(int i=1;i<cols+1;i++){
					switch(i){
						case 1:
							
							fObject.setValue1(obj.getProName());break;
						case 2:
							fObject.setValue2(obj.getProCustomer().getCustomerName());break;
						case 3:
							fObject.setValue3(copyrightN);break;
						case 4:
							fObject.setValue4(obj.getBusinessName());break;
						case 5:
							fObject.setValue5(obj.getProProgramType().getName());break;
						case 6:
							fObject.setValue6(obj.getProCustomer().getTelephone());break;
						case 7:
							fObject.setValue7(StringUtil.doubleFormat2(sum));break;
						case 8:
							fObject.setValue8(StringUtil.doubleFormat2(pMoney));break;
						case 9:
							fObject.setValue9(obj.getProCustomer().getFax());break;
						case 10:
							fObject.setValue10(obj.getProCustomer().getAccountAddress());break;
						default :
					}
				}
			}else{
				fObject.setLable(obj.getProName());
				fObject.setValue1(String.valueOf(obj.getProCustomer().getTelephone()));
			}
			
			valuecoll.add(fObject);
		}
		
		
		
		CollectionUtils.addAll(coll,valuecoll.iterator());
		
		return coll;	
		
	}    

public FusionChartObject[] getProProgramChartObjs(String queryString) {
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


}
