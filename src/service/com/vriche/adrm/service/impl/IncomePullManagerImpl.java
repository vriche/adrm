
package com.vriche.adrm.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.vriche.adrm.Constants;
import com.vriche.adrm.dao.CarrierDao;
import com.vriche.adrm.dao.IncomePullDao;
import com.vriche.adrm.dao.OrderDao;
import com.vriche.adrm.model.FusionChartObject;
import com.vriche.adrm.model.IncomePull;
import com.vriche.adrm.model.SysParam;
import com.vriche.adrm.service.CarrierManager;
import com.vriche.adrm.service.IncomePullManager;
import com.vriche.adrm.service.ResourceManager;
import com.vriche.adrm.service.UserManager;
import com.vriche.adrm.util.AnalyCustomerIncomeMoneyUtil;
import com.vriche.adrm.util.CarrierUtil;
import com.vriche.adrm.util.CustomerUtil;
import com.vriche.adrm.util.DateUtil;
import com.vriche.adrm.util.RequestUtil;
import com.vriche.adrm.util.StringUtil;
import com.vriche.adrm.util.StringUtilsv;
import com.vriche.adrm.util.SysParamUtil;
import com.vriche.adrm.util.UserUtil;

public class IncomePullManagerImpl extends BaseManager implements IncomePullManager {
    private IncomePullDao dao;
    private CarrierManager carrierManager;
    private UserManager userManager;
    private ResourceManager resourceManager;
    private CarrierDao carrierDao;
    private OrderDao orderDao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setIncomePullDao(IncomePullDao dao) {
        this.dao = dao;
    }

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	
	public void setResourceManager(ResourceManager resourceManager) {
		this.resourceManager = resourceManager;
	}
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
    /**
     * @see com.vriche.adrm.service.IncomePullManager#getIncomePullsByIdList(final Map idList)
     */
    public List getIncomePullsByIdList(final Map idList) {
        return dao.getIncomePullsByIdList(idList);
    }
   /**
     * @see com.vriche.adrm.finance.service.IncomePullManager#getIncomePulls(com.vriche.adrm.model.IncomePull)
     */
    public List getIncomePulls(final IncomePull incomePull) {
        return dao.getIncomePulls(incomePull);
    }

    /**
     * @see com.vriche.adrm.service.IncomePullManager#getIncomePull(String id)
     */
    public IncomePull getIncomePull(final String id) {
        return dao.getIncomePull(new Long(id));
    }

    /**
     * @see com.vriche.adrm.service.IncomePullManager#saveIncomePull(IncomePull incomePull)
     */
    public void saveIncomePull(IncomePull incomePull) {
        dao.saveIncomePull(incomePull);
    }

    /**
     * @see com.vriche.adrm.service.IncomePullManager#removeIncomePull(String id)
     */
    public void removeIncomePull(final String id) {
        dao.removeIncomePull(new Long(id));
    }
    
    public List checkRemoveIncomePullByIncomeUsed(final String incomeUsedId) {
        return dao.checkRemoveIncomePullByIncomeUsed(new Long(incomeUsedId));
    }
     /**
     * @see com.vriche.adrm.service.IncomePullManager#removeIncomePulls(String Map)
     */
    public void removeIncomePulls(final Map idList) {
        dao.removeIncomePulls(idList);
    }

	public void removeIncomePullByIncomeId(Long incomeId) {
		// TODO Auto-generated method stub
		dao.removeIncomePullByIncomeId(incomeId);
	}  
    public String getCustomerIncomeMoneyListGrid(String orgId,String putYear,String userName,int channelModelParam,String customerId,String carrierName,String userId,String start,String end,String[] purpose,String arrears){
    	
    	List lastList = getCustomerIncomeMoneyList(orgId,putYear,userName,channelModelParam,customerId,carrierName,userId,start,end,purpose,arrears);
        	
        StringBuffer sb = new StringBuffer();
 		AnalyCustomerIncomeMoneyUtil.makeTreeGridXML(sb,lastList,arrears);
 		 return sb.toString();
    }
public List getCustomerIncomeMoneyList(String orgId,String putYear,String theUser,int channelModelParam,String customerId,String carrierName,String userId,String start,String end,String[] purpose,String arrears){
    	
//    	List carrierIdList = new ArrayList();
    	List purls = new ArrayList();
    	CollectionUtils.addAll(purls,purpose);
    	
    	
//    	System.out.println("customerId"+customerId) ;
//
//    	System.out.println("carrierName"+carrierName) ;
//
//    	System.out.println("userId"+userId) ;
//
//    	System.out.println("arrears"+arrears) ;

    	Map mp = new HashMap();
		List userIdList = new ArrayList();
//    	Map carrierMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIER);
		
		boolean carrierAlisname = SysParamUtil.getUseCarrierAliname();
		boolean isResourceSort = SysParamUtil.getWithResourceSort();
		boolean moreChannelNoPullParam = SysParamUtil.getMoreChannelNoPullParam();
		
		if(carrierAlisname){
			mp.put("carrierAlisname","1");
		}else{
			mp.put("carrierAlisname","0");
		}
		
		if(isResourceSort){
			mp.put("isResourceSort","1");
		}else{
			mp.put("isResourceSort","0");
		}
		
		mp.put("putYear",putYear);
		
		if(!start.equals("")&&start!=null)
			mp.put("startDate",start);
		
		if(!end.equals("")&&end!=null)
			mp.put("endDate",end);		

		if(purls.size()>0)
			mp.put("IncomePurposeIdList",purls);
		
		if(!customerId.equals("")&&customerId!=null&&!customerId.equals("0")&&!customerId.equals("null")){
			 List  customerls = new ArrayList();
			 CollectionUtils.addAll(customerls, customerId.split(","));
			 mp.put("customerIdList",customerls);
		}else{
			List  customerls =   CustomerUtil.getCustomerIdsByOrg(theUser,orgId);
			if(customerls.size() == 0)customerls.add("-1");
			mp.put("customerIdList",customerls);
		}
    	
//   if(UserUtil.isUserOrderYearRel()) {
//     		mp.put("yearIdList",UserUtil.getUserYearRelByLoginUser(theUser));
//     	}
     	
     	
		if((!"".equals(userId) &&  userId!=null)){
    		List userls = new ArrayList();
    		CollectionUtils.addAll(userls, userId.split(","));
    		mp.put("UserIdList",userls);
    	}else{
    		userIdList = UserUtil.getCurUserRels(theUser,orgId);
    		if(userIdList.size() == 0)userIdList.add("-1");
    		mp.put("UserIdList",userIdList);
    	}   	
     	
		
		 System.out.println("getCustomerIncomeMoneyList<<<<<***************** <<<<moreChannelNoPullParam<<<<<<<<<<"+moreChannelNoPullParam);
		 System.out.println("getCustomerIncomeMoneyList<<<<<<<*****************<<carrierName<<<<<<<<<<"+carrierName);
		 if(!"0".equals(carrierName) ||!moreChannelNoPullParam){
				List carrierIdList = CarrierUtil.getCarrierIds(carrierName,"1",theUser);
				mp.put("carrierIdList",carrierIdList);
		 }


		if(!arrears.equals("2")&&arrears!=null) mp.put("arrears",arrears);
		

		//判断是否业务员平帐
        if(UserUtil.isSignUserBalance()){
        	mp.put("version",new Integer(1));
        }else{
        	mp.put("version",new Integer(0));
        }
		
		
		
//		System.out.println(mp.size()); 
    	List ls = dao.getCustomerIncomeMoneyPull(mp);
    	
//    	 List customerid = new ArrayList();
    	
    	 List dateList = new ArrayList();
    	 List lastList = new ArrayList();
    	 

    	 
    	if(!"0".equals(carrierName) ||!moreChannelNoPullParam){
    		 		List carrierIdList = CarrierUtil.getCarrierIds(carrierName,"2",theUser);
        	 mp.put("carrierIdList",carrierIdList);	
    	 }
    
    	 
//    	 StringUtilsv.printMap(mp);
    	 
    	 String sumIncomePullMoney = getCustomerIncomePullMoney(mp);
    	 
 	     double sumIncomeMoney = 0;
	     double sumMoneyPull = 0;
	     double sumMoneyIn = 0;
	     double sumArrearMoney = 0;
    	 
    	 for(Iterator it = ls.iterator();it.hasNext();){
    		 IncomePull incomePull = (IncomePull)it.next();

    		incomePull.setArrearMoney(new Double(incomePull.getMoneyPull().doubleValue() - incomePull.getMoneyIn().doubleValue()));
    		
 			if(dateList.contains(incomePull.getIncomeCode())){
 				incomePull.setIncomeDate("");
 				incomePull.setIncomeCode("");
 				incomePull.setIncomeMoney(new Double(0));
 				incomePull.setCustomerName("");
 				incomePull.setLastName("");
 				incomePull.setFirstName("");
 				incomePull.setFullName("");
 				incomePull.setModeName("");
 				incomePull.setPurposeName("");
 				incomePull.setMemo("");
 				
 			}else{
 				dateList.add(incomePull.getIncomeCode());
 			}
 							
 			
 			if(incomePull.getLastName()==null){
 				incomePull.setLastName("");
 			}
 			if(incomePull.getFirstName()==null){
 				incomePull.setFirstName("");
 			}
 			
// 			 incomePull.setIncomeMoney(StringUtil.doubleFormat3(incomePull.getIncomeMoney()));
			 
			 sumIncomeMoney += incomePull.getIncomeMoney().doubleValue();
			 sumMoneyPull += incomePull.getMoneyPull().doubleValue();
			 sumMoneyIn += incomePull.getMoneyIn().doubleValue();
			 sumArrearMoney += incomePull.getArrearMoney().doubleValue();
			 
			
			 
 		}
    	 if(ls.size()>1){
    		 
//    		 sumIncomeMoney = StringUtil.round1(new Double(sumIncomeMoney).doubleValue(),0);
//    		 sumMoneyPull = StringUtil.round1(new Double(sumMoneyPull).doubleValue(),0);
//    		 sumMoneyIn = StringUtil.round1(new Double(sumMoneyIn).doubleValue(),0);
//    		 sumArrearMoney = StringUtil.round1(new Double(sumArrearMoney).doubleValue(),0);
//    		 sumIncomePullMoney = String.valueOf(StringUtil.round1(new Double(sumIncomePullMoney).doubleValue(),0));
    		 
        	 IncomePull incomePull = new IncomePull();
        	 incomePull.setIncomeCode("合计：");
        	 incomePull.setIncomeMoney(new Double(sumIncomeMoney));
        	 
        	 
        	 incomePull.getCarrier().setCarrierName("");
        	 incomePull.setMoneyPull(new Double(sumMoneyPull));
        	 incomePull.setMoneyIn(new Double(sumMoneyIn));
        	 incomePull.setArrearMoney(new Double(sumArrearMoney));
        	 incomePull.setCustomerName("");
        	 incomePull.setLastName("");
        	 incomePull.setFirstName("");
        	 incomePull.setModeName("总投放：");
        	 incomePull.setPurposeName(StringUtil.doubleFormat3(new Double(sumIncomePullMoney)));
        	 incomePull.setMemo("");
        	 
        	 ls.add(incomePull);
    	 }

    	 

    	
    	 return ls;

    }
    
    


	private String getCustomerIncomePullMoney(Map mp){
		String pullMoney;
	

		List ls = dao.getCustomerIncomePullResult(mp);
//		System.out.println("ls.size<<<<<<<@111111111111<<<<<<<<<<<"+ls.size());
		double sumMoneyPull = 0;
		for(Iterator it = ls.iterator();it.hasNext();){
			IncomePull incomePull = (IncomePull)it.next();
			sumMoneyPull += incomePull.getMoneyPull().doubleValue();
//			System.out.println("sumMoneyPull<<<<<<<@222222222222<<<<<<<<<<<"+sumMoneyPull);
		}
		pullMoney = StringUtil.doubleFormat2(new Double(sumMoneyPull));
		System.out.println("pullMoney<<<<<<<@@@@@@@@@@@@@<<<<<<<<<<<"+pullMoney);
		return pullMoney;
	}

 	private List getIncomeMoneyDate(String incomeDate,List ls,List newList){
				int i=0;
				for(Iterator it = ls.iterator();it.hasNext();){
					IncomePull incomePull = (IncomePull)it.next();
					if(incomePull.getIncomeDate().equals(incomeDate)){
					if(i>0){
							incomePull.setIncomeDate("");
						}
						i++;
						newList.add(incomePull);
					}
			}
				
				return newList;
			}

		/**
		 * @param carrierManager The carrierManager to set.
		 */
		public void setCarrierManager(CarrierManager carrierManager) {
			this.carrierManager = carrierManager;
		}

		/**
		 * @param carrierDao The carrierDao to set.
		 */
		public void setCarrierDao(CarrierDao carrierDao) {
			this.carrierDao = carrierDao;
		}

		public List getIncomesPulls(IncomePull incomePull) {
			
			// TODO Auto-generated method stub
			return dao.getIncomesPulls(incomePull);
		}
		
		public List getIncomePullsByCustomerId2(IncomePull incomePull) {
			
			// TODO Auto-generated method stub
			return dao.getIncomePullsByCustomerId2(incomePull);
		}
		
		

		public String getIncomesPullsXML(IncomePull incomePull) {
//			System.out.println("getCustomerId>>>>>>>>>>>>>>>"+incomePull.getIncome().getCustomerId()) ;
//			System.out.println("getVersion>>>>>>>>>>>>>>>"+incomePull.getVersion()) ;
//			System.out.println("getState>>>>>>>>>>>>>>>"+incomePull.getIncome().getState()) ;
			
			System.out.println("getCustomerId>>>>>>>>>>>>>>>"+incomePull.getIncome().getCustomerId()) ;
			System.out.println("getState>>>>>>>>>>>>>>>"+incomePull.getIncome().getState()) ;
			System.out.println("getIncomeCode>>>>>>>>>>>>>>>"+incomePull.getIncome().getIncomeCode()) ;
			System.out.println("getVersion>>>>>>>>>>>>>>>"+incomePull.getVersion()) ;
			System.out.println("getId>>>>>>>>>>>>>>>"+incomePull.getId()) ;
			
			String orgId = incomePull.getOrgId().toString();
		  List userls2 = UserUtil.getUserIdList(orgId);
		  if(userls2.size()>0) incomePull.setUserIdList2(userls2);
			
			List ls = this.getIncomesPulls(incomePull); 
			return makeGridXML(ls,1);
		}
		
		
		
		public String getIncomesPullsXML2(IncomePull incomePull) {
//			System.out.println("getCustomerId>>>>>>>>>>>>>>>"+incomePull.getIncome().getCustomerId()) ;
//			System.out.println("getVersion>>>>>>>>>>>>>>>"+incomePull.getVersion()) ;
//			System.out.println("getState>>>>>>>>>>>>>>>"+incomePull.getIncome().getState()) ;
//			List customerIds = new ArrayList();
			Map cutRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CUSTOMER_WITH_CUT_REL);  
			
	
			
			List customerIds = incomePull.getCustomerIdList();
//			CollectionUtils.addAll(customerIds,incomePull.getCustomerIdList());
//			if(memo.indexOf(",")>1){
//				CollectionUtils.addAll(customerIds,incomePull.getMemo().split(","));
//			}else{
//				if(!memo.equals(""))customerIds.add(memo);
//			}
			
			String year =  StringUtil.null2String(incomePull.getVersion());
			String loginUser = incomePull.getLastName();
			String userName = incomePull.getFirstName();
			String customerName = incomePull.getCustomerName();
			String orgId = incomePull.getOrgId().toString();
			
			
			
			
			 

			
			
			
//			if(year == null) year ="";
			if(year.equals("")||year.equals("0")) year = null;
				

			userName = userName.equals("0")?null:userName;
			if(customerName == null) customerName="";
			customerName = customerName.equals("")?null:customerName;
			

			
			
//			System.out.println(">>>>>>>> year:"+year);
//			System.out.println(">>>>>>>> loginUser:"+loginUser);
//			System.out.println(">>>>>>>> userName:"+userName);
//			System.out.println(">>>>>>>> customerName:"+customerName);
//			System.out.println(">>>>>>>> customerIds:"+customerIds.size());
			
			

			
			if(customerIds.size() == 0){
				
				Map mp = new HashMap();	
				mp.put(year,year);
				if(customerName != null) mp.put("customerName",customerName);
				if(userName != null) mp.put("userName",userName);
				
				List userIdList = new ArrayList();
//				if(userName == null ||customerName != null){
					userIdList = UserUtil.getCurUserRels(loginUser);
//					System.out.println(">>>>>>>> userIdList size:"+userIdList.size());
//					if(userIdList.size() == 0){
//						userIdList.add("-1");
//					}
					mp.put("userIdList",userIdList);
					mp.put("customerName",customerName);
					
//					if(userName == null) {
						incomePull.getIncome().setCarrierIdList(userIdList);
//						incomePull.setUserIdList(userIdList);
//					}else{
//						incomePull.getIncome().setCarrierIdList(null);
//					}
//				}
				
				//从订单中查找归属自己的客户
				customerIds = orderDao.getCustomersByLoginUser(mp);
				
				//从到款查找划归自己的客户
//				mp.put("customerIdList",customerIds);
//				if(userName != null) mp.put("userIdList",null);
				List customerIdsIncome = dao.getCustomerFromIncomeNoInORrder();
//				System.out.println("customerIdsIncome.size()111>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+customerIdsIncome.size()) ;
//				System.out.println("customerIdsIncome.size()111>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+customerIds.size()) ;
				if(customerIdsIncome.size()>0) customerIds.addAll(customerIdsIncome);
//				System.out.println("customerIdsIncome.size()111>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+customerIds.size()) ;
				
			}
			
			
            
			
			List cusIdList = new ArrayList();
			for(Iterator it = customerIds.iterator();it.hasNext();){
				String id =(String)it.next();
//				System.out.println("id key>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+id) ;
//				System.out.println("id 111>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+cutRelsMap.get(id)) ;
				String  parentId = StringUtil.null2String(cutRelsMap.get(id));
				if(!parentId.equals("0")&& !parentId.equals("")) cusIdList.add(parentId);
			}
			
			
			
//			System.out.println("customerIds.size()111>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+customerIds.size()) ;
			if(cusIdList.size()>0)customerIds.addAll(cusIdList);
//			System.out.println("customerIds.size()111>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+customerIds.size()) ;
			
//			if(customerIds.size() == 0) {
//				if(customerName == null && userName == null) customerIds.add("-1");
//			}
			
//			incomePull.setCustomerIdList(ConvertUtil.convertFromListToArray2(customerIds));
//			incomePull.setVersion(new Integer(year));
			incomePull.setFirstName(userName);
			incomePull.setCustomerName(customerName);
			incomePull.setCustomerIdList(customerIds);
			
			
			
			//判断是否业务员平帐
            if(getIsSignUserBalance()){
            	incomePull.setVersion(new Integer(1));
            }else{
            	incomePull.setVersion(new Integer(0));
            }
			//年份归属
         	if(UserUtil.isUserOrderYearRel()) {
         		incomePull.setYearIdList(UserUtil.getUserYearRelByLoginUser(loginUser));
         	}
            
			
			List ls = this.getIncomePullsByCustomerId2(incomePull);
			return makeGridXML(ls,2);
		}
		
		
		
		
		
	
		
		
		
		private String getStyleCSS(int i){
			String[] colors = new String[2];
			colors[0] = "BACKGROUND-COLOR: #ECEFF4;";
			colors[1] = "BACKGROUND-COLOR: #f5f5f5;";
			return  colors[i % 2];
		}

		public  String makeGridXML(List all,int type){
			
			 boolean carrierAlisname = SysParamUtil.getUseCarrierAliname();
			 boolean isWithResourceSort = SysParamUtil.getWithResourceSort();
		        
			 String ctxpath =RequestUtil.getReqInfo().getCtxPath();
		        
			int i = 0;
			StringBuffer sb = new StringBuffer();
			
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<rows>");    
		   
			for(Iterator it = all.iterator();it.hasNext();){
				
				IncomePull incomePull = (IncomePull)it.next();
				
				String incomeId = incomePull.getIncomeId().toString();
				String incomeCode =  StringUtil.null2String(incomePull.getIncome().getIncomeCode());
				String incomeCodeLink =incomeCode +  "^editIncome.html?id=" + incomeId;
				
					
				
//				String incomeCodeLink = "<a href=\"javascript:void 0\" onClick= getIncomeById("+ incomeId +")>" +incomeCode+ "</a>";	
				String carrierName =  StringUtil.null2String(incomePull.getCarrier().getCarrierName());
				String resourceTypeName =  StringUtil.null2String(incomePull.getResourceType().getName());
				String orgId =  StringUtil.null2String(incomePull.getResourceType().getOrgId());
				
//				System.out.println(">>>>>>>> >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>orgId:"+orgId);
				
				double pullMoney = incomePull.getMoneyPull().doubleValue();
				double incUsed = incomePull.getIncome().getIncomeUsed().doubleValue();
				double relMoney = pullMoney - incUsed;
				String incomeMeno  = StringUtil.String2kenizer(StringUtil.null2String(incomePull.getIncome().getMemo()),"\n\r\t").replaceAll(" ","_");
				String incomeDate = DateUtil.SetDateFormat(incomePull.getIncome().getIncomeDate().toString(),"yyyy/MM/dd");
				String incomePullDate = DateUtil.SetDateFormat(incomePull.getIncome().getIncomePullDate().toString(),"yyyy");
				
				//				sb.append("<row  id=\""+ incomePull.getId()  +"\"" +"  style=\""+ getStyleCSS(i++) +"\">");
				sb.append("<row  id=\""+ incomePull.getId()  +"\"" +">");
				if(type == 1) sb.append("<cell><![CDATA["+ " "  +"]]></cell>");
				sb.append("<cell><![CDATA["+ incomeDate   +"]]></cell>");
				if(isWithResourceSort){
					sb.append("<cell><![CDATA["+ resourceTypeName  +"]]></cell>");
				}else{
					sb.append("<cell><![CDATA["+ carrierName  +"]]></cell>");
				}

				
//				sb.append("<cell><![CDATA["+ incomeCodeLink + "]]></cell>");
				sb.append("<cell><![CDATA[ <a target=_blank href="+ ctxpath +"/editIncome.html?id="+ incomeId+"&orgId="+ orgId+">" +incomeCode +"</a>]]></cell>");
				if(type == 2) sb.append("<cell><![CDATA["+ incomePull.getIncome().getCustomer().getCustomerName() + "]]></cell>");
				sb.append("<cell><![CDATA["+ incomePull.getIncome().getUser().getFullName() +"]]></cell>");
//				System.out.println(">>>>>>>> getMoneyPull:"+incomePull.getMoneyPull().longValue());
//				DecimalFormat df = new DecimalFormat(".0");
//				System.out.println(">>>>>>>> getMoneyPull:"+df.format(relMoney));
				if(type == 2) sb.append("<cell><![CDATA["+ incomePullDate +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(incomePull.getMoneyPull())  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(new Double(relMoney))  +"]]></cell>");
				if(type == 1) sb.append("<cell><![CDATA["+ incomePullDate +"]]></cell>");
				
				sb.append("<cell><![CDATA["+ incomeMeno +"]]></cell>");
//				sb.append("<cell><![CDATA["+ incomePull.getResourceCarrierId()  +"]]></cell>");
//				sb.append("<cell><![CDATA["+ incomePull.getIncome().getUserId()  +"]]></cell>");
//				sb.append("<cell><![CDATA["+ incomeCode  +"]]></cell>");
				sb.append("<userdata name=\"type\">1</userdata>");
				
		        if(carrierAlisname){
		        	sb.append("<userdata name=\"resourceCarrierId\">"+CarrierUtil.getOtherSameAlisnameIds(incomePull.getResourceCarrierId().toString())+"</userdata>");
		        }else{
		        	sb.append("<userdata name=\"resourceCarrierId\">"+incomePull.getResourceCarrierId()+"</userdata>");
		        }
			     
		        sb.append("<userdata name=\"resourceTypeId\">"+incomePull.getResourceTypeId()+"</userdata>");
		        
				sb.append("<userdata name=\"userId\">"+incomePull.getIncome().getUserId()+"</userdata>");
				sb.append("<userdata name=\"incomeId\">"+incomeId+"</userdata>");  
				sb.append("<userdata name=\"incomeCode\">"+incomeCode+"</userdata>");  
				sb.append("</row>");
			 }
			
			sb.append("</rows>");
			return sb.toString();
	  }

		public void saveIncomePullVersion(IncomePull incomePull) {
			
//			System.out.println(">>>>>>>>  incomePull.toString():"+ incomePull.toString());
			// TODO Auto-generated method stub
			dao.saveIncomePullVersion(incomePull);
		}
		

		/**
		 * @see com.vriche.adrm.finance.service.IncomePullManager#getOrdersByIncomeId(String id)
		 */
//		public String getOrdersByIncomeId(final String id) {
//			Map mp = new HashMap();
//			Map mp2 = new HashMap();
//			List ls = dao.getOrdersByIncomeId(new Long(id));
//			Iterator it = ls.iterator();
//			StringBuffer sb=new StringBuffer();
//			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
//			sb.append("<rows>");    
//		    while(it.hasNext()){
//		    	IncomePull incomePull= (IncomePull) it.next();
//		    	
//		    	String orderCode = incomePull.getIncomeCode(); 
//		    	String userName = incomePull.getFullName();
//		    	Long carrierId = incomePull.getResourceCarrierId();
//		    	Double moneyIn = incomePull.getMoneyIn();
//		    	mp2.put(orderCode+userName,incomePull);
//		    	mp.put(orderCode+userName+carrierId,moneyIn);
//		    }
//		    int i=1;
//	    	for(Iterator its=mp2.keySet().iterator();its.hasNext();){                                    
//	    		String key = (String)its.next();
//	    		IncomePull incomePull= (IncomePull)mp2.get(key);
//	    		String m1= mp.get(key+1)==null?"":""+(Double)mp.get(key+1);
//	    		String m2= mp.get(key+2)==null?"":""+(Double)mp.get(key+2);
//	    		String m3= mp.get(key+3)==null?"":""+(Double)mp.get(key+3);
//	    		String m4= mp.get(key+4)==null?"":""+(Double)mp.get(key+4);
//		    	sb.append("<row  id=\""+ key +"\">");
//		    	sb.append("<cell>"+ i++  +"</cell>");
//			    sb.append("<cell>"+ incomePull.getIncomeCode()  +"</cell>");
//			    sb.append("<cell>"+ incomePull.getFullName()  +"</cell>");
//			    sb.append("<cell>"+ m1 +"</cell>");
//			    sb.append("<cell>"+ m2  +"</cell>");	
//			    sb.append("<cell>"+ m3  +"</cell>");
//			    sb.append("<cell>"+ m4  +"</cell>");
//			    sb.append("</row>");
//	    	}
//
//		    sb.append("</rows>");
//		    return sb.toString();
//		}
		
		public List getOrdersByIncomeId(final String id) {
			return dao.getOrdersByIncomeId(new Long(id));
		}


		private static  boolean getIsSignUserBalance(){
		    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
		    if(StringUtils.isEmpty(sysParam.getIsSignUserBalance())) sysParam.setIsSignUserBalance("0");
		    return (sysParam.getIsSignUserBalance().equals("0"))?false:true;
		}
		
		
		
		private List getgetIncomesPulls3(IncomePull incomePull){
			Map cutRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CUSTOMER_WITH_CUT_REL);  

			List customerIds = incomePull.getCustomerIdList();
			String year =  StringUtil.null2String(incomePull.getVersion());
			String signUserId = incomePull.getFirstName();
			String loginUser = incomePull.getLastName();
			String customerName = incomePull.getCustomerName();
			String orgId = incomePull.getOrgId().toString();
//			String resourceTypeId = incomePull.getResourceTypeId().toString();
			String resourceTypeIds = incomePull.getResourceTypeIds();
			String startDate = incomePull.getStartDate();
			String endDate = incomePull.getEndDate();
			
			if(customerIds == null) customerIds = new ArrayList();
			
			

			if(year.equals("")||year.equals("0")) year = null;
				

		
			
			

			
			List userIdList = new ArrayList();
			userIdList = UserUtil.getCurUserRels(loginUser,orgId);
			if(userIdList.size() == 0) userIdList.add("-1");
			
//			List yearIdList = new ArrayList();
			//年份归属
//         	if(UserUtil.isUserOrderYearRel()) {
			List	yearIdList = UserUtil.getUserYearRelByLoginUser(loginUser);
//         		if(yearIdList.size() == 0) yearIdList.add("-1");
//         	}

			
         	
         	
         	
			if(customerIds.size() == 0){
				
				Map mp = new HashMap();	
				
				mp.put(year,year);
				if(customerName != null && !"".equals(customerName) && !"null".equals(customerName))  mp.put("customerName",customerName);
				if(signUserId != null && !"".equals(signUserId) && !"null".equals(signUserId)) mp.put("userName",signUserId);
				mp.put("userIdList",userIdList);
//				mp.put("customerName",customerName);
				mp.put("yearIdList",yearIdList);
				//从订单中查找归属自己的客户
				customerIds = orderDao.getCustomersByLoginUser(mp);
				//从到款查找划归自己的客户
				List customerIdsIncome = dao.getCustomerFromIncomeNoInORrder();
				if(customerIdsIncome.size()>0) customerIds.addAll(customerIdsIncome);
				
			}
			

			List cusIdList = new ArrayList();
			for(Iterator it = customerIds.iterator();it.hasNext();){
				String id =(String)it.next();
				String  parentId = StringUtil.null2String(cutRelsMap.get(id));
				if(!parentId.equals("0")&& !parentId.equals("")) cusIdList.add(parentId);
			}
			if(cusIdList.size()>0)customerIds.addAll(cusIdList);
			


			Map mpp = new HashMap();
			
         	if(customerName != null && !"".equals(customerName) && !"null".equals(customerName)) {
         		mpp.put("customerName",customerName);
         	}else{
         		
         	}
         	
         	if(signUserId != null && !"".equals(signUserId) && !"null".equals(signUserId)&& !"0".equals(signUserId)) mpp.put("signUserId",signUserId);		
//         	if(resourceTypeId != null && !"".equals(resourceTypeId)&& !"null".equals(resourceTypeId)) mpp.put("resourceTypeId",resourceTypeId);		
         	
         	
         	if(resourceTypeIds != null && !"".equals(resourceTypeIds)&& !"null".equals(resourceTypeIds)) {
         		List resourceTypeIdList = new ArrayList();
    			CollectionUtils.addAll(resourceTypeIdList,resourceTypeIds.split("_"));
//    			mp.put("resourceTypeId",resourceTypeId);
    			mpp.put("resourceTypeIdList",resourceTypeIdList);	
         	}
         	
        	List lsCutCates = UserUtil.getCustomerCateByUser(loginUser, null);
        	if(lsCutCates.size()>0)mpp.put("customerCates",lsCutCates);        	
         	
        	mpp.put("startDate",startDate);
        	mpp.put("endDate",endDate);
			mpp.put("version",year);
			mpp.put("orgId",orgId);
			if(cusIdList.size()>0) mpp.put("customerIdList",customerIds);
			if(userIdList.size()>0) mpp.put("userIdList",userIdList);
			if(yearIdList.size()>0) mpp.put("yearIdList",yearIdList);
			
//           if(log.isDebugEnabled()){
            	System.out.println("getIncomesPullsXM3>>>>>>>> orgId:"+orgId);			
    			System.out.println("getIncomesPullsXM3>>>>>>>> year:"+year);
    			System.out.println("getIncomesPullsXM3>>>>>>>> loginUser:"+loginUser);
    			System.out.println("getIncomesPullsXM3>>>>>>>> signUserId:"+signUserId);
    			System.out.println("getIncomesPullsXM3>>>>>>>> customerName:"+customerName);
    			System.out.println("getIncomesPullsXM3>>>>>>>> resourceTypeId:"+resourceTypeIds);
    			System.out.println("getIncomesPullsXM3>>>>>>>> customerIds:"+customerIds);
    			System.out.println("getIncomesPullsXM3>>>>>>>> userIdList:"+userIdList);
    			System.out.println("getIncomesPullsXM3>>>>>>>> yearIdList:"+yearIdList);
//           }
           
         	List ls =  dao.getIncomePullsByCustomerId3(mpp);
         	
         	return ls;
           
		}
		
		
		
		
		
		public String getIncomesPullsXM3(IncomePull incomePull) {
			List ls = getgetIncomesPulls3(incomePull);
			return makeGridXML(ls,2);
		}	
		
		public Collection getIncomesPullsCollections(Map mp) {
			
			 boolean carrierAlisname = SysParamUtil.getUseCarrierAliname();
			 boolean isWithResourceSort = SysParamUtil.getWithResourceSort();
			 
			 IncomePull incPull = new IncomePull();
//			 incPull.setCustomerIdList()
			 incPull.setVersion(Integer.valueOf(StringUtil.null2String(mp.get("year"))));
			 incPull.setFirstName(StringUtil.null2String(mp.get("signUserId")));
			 incPull.setLastName(StringUtil.null2String(mp.get("loginUser")));
			 incPull.setCustomerName(StringUtil.getURLDecoderStr(StringUtil.null2String(mp.get("customerName"))));
			 incPull.setOrgId(Long.valueOf(StringUtil.null2String(mp.get("orgId"))));
//			 incPull.setResourceTypeId(Long.valueOf(StringUtil.null2String(mp.get("resourceTypeId"))));
			 incPull.setResourceTypeIds(StringUtil.null2String(mp.get("resourceTypeIds")));
			 
			 incPull.setStartDate(StringUtil.null2String(mp.get("startDate")));
			 incPull.setEndDate(StringUtil.null2String(mp.get("endDate")));

			 

			 
			 
			 
			List ls = getgetIncomesPulls3(incPull);
			
			FusionChartObject fObject=null;
			List valuecoll = new ArrayList();
			
			for(Iterator it = ls.iterator();it.hasNext();){
				
				IncomePull incomePull = (IncomePull)it.next();
				
				String incomeId = incomePull.getIncomeId().toString();
				String incomeCode =  StringUtil.null2String(incomePull.getIncome().getIncomeCode());

//				String incomeCodeLink = "<a href=\"javascript:void 0\" onClick= getIncomeById("+ incomeId +")>" +incomeCode+ "</a>";	
				String carrierName =  StringUtil.null2String(incomePull.getCarrier().getCarrierName());
				String resourceTypeName =  StringUtil.null2String(incomePull.getResourceType().getName());
				String orgId =  StringUtil.null2String(incomePull.getResourceType().getOrgId());
				
//				System.out.println(">>>>>>>> >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>orgId:"+orgId);
				
				double pullMoney = incomePull.getMoneyPull().doubleValue();
				double incUsed = incomePull.getIncome().getIncomeUsed().doubleValue();
				double relMoney = pullMoney - incUsed;
				String incomeMeno  = StringUtil.String2kenizer(StringUtil.null2String(incomePull.getIncome().getMemo()),"\n\r\t").replaceAll(" ","_");
				String incomeDate = DateUtil.SetDateFormat(incomePull.getIncome().getIncomeDate().toString(),"yyyy/MM/dd");
				String incomePullDate = DateUtil.SetDateFormat(incomePull.getIncome().getIncomePullDate().toString(),"yyyy");
				
				fObject = new FusionChartObject();
				
				fObject.setId(incomePull.getId().toString());
				fObject.setLable(incomeDate);
				if(isWithResourceSort){
					fObject.setValue1(resourceTypeName);
				}else{
					fObject.setValue1(carrierName);
				}
				
				fObject.setValue2(incomeCode);
				fObject.setValue3(incomePull.getIncome().getCustomer().getCustomerName());
				fObject.setValue4(StringUtil.null2String(incomePull.getIncome().getUser().getFullName()));
				fObject.setValue5(incomePullDate);
				fObject.setValue6(StringUtil.doubleFormat2(incomePull.getMoneyPull()));
				fObject.setValue7(StringUtil.doubleFormat2(new Double(relMoney)));
//				fObject.setValue8(incomeMeno);

				valuecoll.add(fObject);
				
			}
			Collection coll = new ArrayList();
			CollectionUtils.addAll(coll,valuecoll.iterator());
			return coll;				
	
		}	
}