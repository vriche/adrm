
package com.vriche.adrm.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.vriche.adrm.Constants;
import com.vriche.adrm.dao.CarrierDao;
import com.vriche.adrm.dao.CarrierTypeDao;
import com.vriche.adrm.dao.MediaOrgDao;
import com.vriche.adrm.model.Carrier;
import com.vriche.adrm.model.CarrierType;
import com.vriche.adrm.model.MediaOrg;
import com.vriche.adrm.model.Resource;
import com.vriche.adrm.model.SysParam;
import com.vriche.adrm.service.CarrierManager;
import com.vriche.adrm.service.ResourceManager;
import com.vriche.adrm.util.CarrierComparator;
import com.vriche.adrm.util.CarrierUtil;
import com.vriche.adrm.util.ConvertUtil;
import com.vriche.adrm.util.ServiceLocator;
import com.vriche.adrm.util.StringUtil;
import com.vriche.adrm.util.SysParamUtil;
import com.vriche.adrm.util.UserUtil;

public class CarrierManagerImpl extends BaseManager implements CarrierManager {
    private CarrierDao dao;
    private CarrierTypeDao carrierTypeDao;
    private ResourceManager resourceManager;
    private MediaOrgDao mediaOrgDao;
    
    
	/**
	 * @param mediaOrgDao The mediaOrgDao to set.
	 */
	public void setMediaOrgDao(MediaOrgDao mediaOrgDao) {
		this.mediaOrgDao = mediaOrgDao;
	}




    /**
	 * @param resourceManager The resourceManager to set.
	 */
	public void setResourceManager(ResourceManager resourceManager) {
		this.resourceManager = resourceManager;
	}

	/**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setCarrierDao(CarrierDao dao) {
        this.dao = dao;
    }

    
	public void setCarrierTypeDao(CarrierTypeDao carrierTypeDao) {
		this.carrierTypeDao = carrierTypeDao;
	}

    /**
     * @see com.vriche.adrm.adres.service.CarrierManager#getCarriersByIdList(final Map idList)
     */
    public List getCarriersByIdList(final Map idList) {
        return dao.getCarriersByIdList(idList);
    }
   /**
     * @see com.vriche.adrm.adres.service.CarrierManager#getCarriers(com.vriche.adrm.adres.model.Carrier)
     */
    public List getCarriers(final Carrier carrier) {
        return dao.getCarriers(carrier);
    }
    
    public List getCarriersForChannel(final Carrier carrier) {
    	//System.out.print(">>>   "+carrier.getNodeLevel());
        return dao.getCarrierForChannel(carrier);
    }

    /**
     * @see com.vriche.adrm.adres.service.CarrierManager#getCarrier(String id)
     */
    public Carrier getCarrier(final String id) {
        return dao.getCarrier(new Long(id));
    }

    public String getCarriersXml(String id) {
		// TODO Auto-generated method stub
		return dao.getCarriersXml(id);
	}
    
    

	public String getCarriersTypeXml(String id) {
		// TODO Auto-generated method stub
		return  dao.getCarriersTypeXml(id);
	}

	/**
     * @see com.vriche.adrm.adres.service.CarrierManager#saveCarrier(Carrier carrier)
     */
    public String saveCarrier(Carrier carrier) {
//    	System.out.println(carrier);
    	String name = carrier.getCarrierName();
    	String meno = carrier.getMemo();
    	carrier.setCarrierName(StringUtil.getFileName(name));
    	carrier.setMemo(StringUtil.getFileName(meno));
    	return dao.saveCarrier(carrier).toString();
    }

    /**
     * @see com.vriche.adrm.adres.service.CarrierManager#removeCarrier(String id)
     */
    public void removeCarrier(final String id) {
        dao.removeCarrier(new Long(id));
    }

     /**
     * @see com.vriche.adrm.adres.service.CarrierManager#removeCarriers(String Map)
     */
    public void removeCarriers(final Map idList) {
        dao.removeCarriers(idList);
    }
    
   public List getCarrierAlisnamesStore(Carrier carr){
	   Map mpAlisName = new HashMap();
	   Carrier carrierPar = new Carrier();
	   carrierPar.setParentId("0");
	   List ls = this.getCarriers(carrierPar);
	   
	   System.out.println("getCarrierAlisnames==============00000=======key==" + ls.size());
	   
//	   Iterator it = ls.iterator();
//	   while(it.hasNext()){
//	    	Carrier carr = (Carrier)it.next();
//	    	String id = carr.getId().toString();
//	    	String ids = CarrierUtil.getOtherSameAlisnameIds(id);
//	   }
	   
	   List lss = new ArrayList();
	   
		for(Iterator it = ls.iterator();it.hasNext();){
			Carrier carrier = (Carrier)it.next();
			String alisName = carrier.getAliasName();
			alisName = StringUtils.isEmpty(alisName)||alisName ==null?carrier.getCarrierName():alisName;
			if(mpAlisName.containsKey(alisName)){
				Carrier car = (Carrier)mpAlisName.get(alisName);
				String ids = car.getMemo()+","+carrier.getId().toString();
				car.setMemo(ids);
				car.setAliasName(alisName);
				mpAlisName.put(alisName,car);
			}else{
				String id = carrier.getId().toString();
				carrier.setMemo(id);
				carrier.setAliasName(alisName);
				mpAlisName.put(alisName,carrier);
			}
		}	
		
		Iterator itt = mpAlisName.keySet().iterator();
		while(itt.hasNext()){
			  String key = (String)itt.next(); 
			  Carrier carrier = (Carrier)mpAlisName.get(key);
			  lss.add(carrier);
//			  mp.put(key,carrier.getMemo());
			  System.out.println("=======id======="+ carrier.getId().toString() +"=======key==" + carrier.getAliasName()+"=======value==" + carrier.getMemo());
			
		}

	   
	   return lss;
   }
    
    
	public Map getCarrierSelect(Carrier carrier) {
				
		List ls = this.getCarriers(carrier);
		
	    Map reply = new LinkedHashMap();
	    Iterator it = ls.iterator();
    	reply.put("0",""); 
    	
    	int i=0;
	    while(it.hasNext()){
	    	StringBuffer sign=new StringBuffer("└─");
	    	Carrier carriers = new Carrier();
	    	carriers = (Carrier) it.next();
	    	reply.put(carriers.getId(),carriers.getCarrierName());
	    	getCarriersByParentId(sign,reply,carriers.getId(),i++);
	    }
		return reply;
	}

	private void getCarriersByParentId(StringBuffer space,Map mp,Long parentId,int i){
		Carrier carrier = new Carrier();
		carrier.setParentId(parentId.toString());
		List ls = this.getCarriers(carrier);
		space=new StringBuffer("┆ 　").append(space);
		for(Iterator it = ls.iterator();it.hasNext();){
			StringBuffer sp=new StringBuffer("  ");
			sp.append(space);
			Carrier carr = (Carrier)it.next();
			String ss =sp.append(carr.getCarrierName()).toString();
			mp.put(carr.getId(),ss);
			getCarriersByParentId(space,mp,carr.getId(),i++);
		}
		
	}
	public   List getCarrierType(){
		return carrierTypeDao.getCarrierTypes(new CarrierType());
	}
	
	
	public Map getCarriersAllFromMap(Carrier carrier, boolean enable,boolean needZeroId) {
		boolean isAdd = false;
		List carrs = (List)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIER_ALL);
		Integer nodeLevel = carrier.getNodeLevel();
		int level = nodeLevel == null?0:nodeLevel.intValue();
		Map reply = new LinkedHashMap();
		if(needZeroId) reply.put("0","== 频道 ==");
		for(Iterator it = carrs.iterator();it.hasNext();){
			Carrier carr = (Carrier)it.next();
			boolean isEnable = carr.getEnable().booleanValue();
			int le = Integer.parseInt(StringUtil.null2String(carr.getNodeLevel()));
			
			if(level == le){
				if(enable && isEnable){
					isAdd = true;
				}else if(!enable){
					isAdd = true;
				}
			}else{
				isAdd = false;
			}
			if(isAdd)reply.put(carr.getId(),carr.getCarrierName());
			
		}
		return reply;
	}
	
	public Map getCarrierSelectItem(Carrier carrier) {
		boolean isCATV = SysParamUtil.isCATVParam(null);
		Map resourceMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_RESOURCE_MAP);
		Map userCarrierRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_CARRIER_RELS);
		Integer nodeLevel = carrier.getNodeLevel();
		int level = nodeLevel == null?0:nodeLevel.intValue();
		List carrierTypes=this.getCarrierType();
		
		String orgId = carrier.getOrgId();
		

		boolean isDisplayCarrierType = SysParamUtil.getCarrierTypeDisplay();
		boolean channelPull = SysParamUtil.getChannelModelPara();
//		订单签订中载体是一级还是多级
		boolean orderCarrierLevelOne = SysParamUtil.getOrderCarrierLevelOne();
		
		String year = carrier.getVersion().toString();
		
		Iterator ite=carrierTypes.iterator();
		Map reply = new LinkedHashMap();
		reply.put("0","== 频道 ==");
		
		if(isCATV){
			reply.put("1","电影频道");
		}
		while(ite.hasNext()){
			CarrierType carrierType=(CarrierType)ite.next();
			if(orgId.equals(carrierType.getOrgId().toString())){
				List carriers=dao.getCarriersByCarrier_TypeId(carrierType.getId());
				List carriers2 = getCarrier(carriers,userCarrierRelsMap,channelPull);
				this.getCarriers(carriers2,reply,carrierType.getName(),level,false,isDisplayCarrierType,resourceMap,year,orderCarrierLevelOne);
			}

		}
		return reply;
	}
	
public Map getCarrierSelectItemFromMap(Carrier carrier) {
 	    boolean isXMTV = SysParamUtil.isXMTVParam(null);
 	    
		Integer nodeLevel = carrier.getNodeLevel();
		int level = nodeLevel == null?0:nodeLevel.intValue();
		String year = carrier.getVersion().toString();
		String resource_sort = StringUtil.getNullValue(carrier.getResourceSort(),"");
//		String orgId =( mediaOrgId == null)?"0":mediaOrgId.toString();
		String orgId = carrier.getOrgId();
		
//		if("3".equals(resource_sort)) resource_sort = resource_sort;
		
	
		
		
		List carrierTypes = (List)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIER_TYPES);
		Map carrierMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIERS_BY_CARRIER_TYPE);
		Map resourceMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_RESOURCE_MAP);
		Map userCarrierRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_CARRIER_RELS);

		boolean displayCarrierType = SysParamUtil.getCarrierTypeDisplay();
		boolean channelPull = SysParamUtil.getChannelModelPara();
		boolean orderCarrierLevelOne = SysParamUtil.getOrderCarrierLevelOne();
        String loginUser = carrier.getLoginUser();
		Iterator ite = carrierTypes.iterator();
		
		Map reply = new LinkedHashMap();
		reply.put("0","");
		boolean isValidate = carrier.getEnable().booleanValue();
		
//		System.out.println("carrier.getVersion()%%%%%%%%%%5555555555555555555555555555555555%%%%%%%%%%%%%%"+carrier.getVersion());
		
		while(ite.hasNext()){
			
			
			CarrierType carrierType =(CarrierType)ite.next();
			
			String org_id = carrierType.getOrgId().toString();
			
			if(org_id.equals(orgId)){
				
				List carriers = (List)carrierMap.get(carrierType.getId());
				
				carriers = carriers == null? new ArrayList():carriers;
				
				
				
				List carriers2 = getCarrier2(resource_sort,carriers,userCarrierRelsMap,channelPull,loginUser);
				
				Collections.sort(carriers2,new CarrierComparator());
				
//				System.out.println("carriers2<<<<<<<<<<<<<<<<<<<<<<<<<<<<............................<"+carriers2);
//				System.out.println("carriers2 size<<<<<<<<<<<<<<<<<<<<<<<<<<<<............................<"+carriers2.size());
				
				
				this.getCarriers3(carriers2,reply,carrierType.getName(),level,isValidate,displayCarrierType,resourceMap,year, orderCarrierLevelOne,orgId);	
			}

		


		}
		
		
		return reply;
	}

private List getCarrier2(String resource_sort, List sourList,Map userCarrierRelsMap,boolean channelPull,String loginUser){
	List newList = new ArrayList();
	if(channelPull){
    	List tagList = getOwnerUsersList2(userCarrierRelsMap,loginUser);
    	Map mp = new HashMap();
    	for(Iterator it = tagList.iterator();it.hasNext();){
    		Carrier carrier = (Carrier)it.next();
    		mp.put(carrier.getId(),carrier);
    	}
//    	System.out.println("sourList size1%%%%%%%%%%%%%%%%%%%%%%%%%"+sourList);
    	for(Iterator it = sourList.iterator();it.hasNext();){
//    		System.out.println("sourList size2%%%%%%%%%%%%%%%%%%%%%%%%%"+userCarrierRelsMap.size());
    		Carrier carrier = (Carrier)it.next();
    		
    		String res_sort =   StringUtil.getNullValue(carrier.getMediaOrgId(),"");
    		
//    		System.out.println("res_sort%%%%%%%%%%%%%%%%%%%%%%%%%"+res_sort +"resource_sort%%%%%%%%%%%%%%%%%%%%%%%%%"+resource_sort);
    		
    		if(resource_sort.equals(res_sort)){

        		if(mp.containsKey(carrier.getId())) {
        			newList.add(carrier);
        		}
    		}
    		

    	}
	}else{
		for(Iterator it = sourList.iterator();it.hasNext();){
			Carrier carrier = (Carrier)it.next();
			String res_sort =   StringUtil.getNullValue(carrier.getMediaOrgId(),"");
			if(resource_sort.equals(res_sort)) newList.add(carrier);
		}
	}

	return newList;
}
    private List getCarrier(List sourList,Map userCarrierRelsMap,boolean channelPull){
    	List newList = new ArrayList();
    	if(channelPull){
        	List tagList = getOwnerUsersList(userCarrierRelsMap);
        	Map mp = new HashMap();
        	for(Iterator it = tagList.iterator();it.hasNext();){
        		Carrier carrier = (Carrier)it.next();
        		mp.put(carrier.getId(),carrier);
        	}
//        	System.out.println("sourList size1%%%%%%%%%%%%%%%%%%%%%%%%%"+sourList);
        	for(Iterator it = sourList.iterator();it.hasNext();){
//        		System.out.println("sourList size2%%%%%%%%%%%%%%%%%%%%%%%%%"+userCarrierRelsMap.size());
        		Carrier carrier = (Carrier)it.next();
//        		System.out.println("sourList size3%%%%%%%%%%%%%%%%%%%%%%%%%"+carrier.toString());
        		if(mp.containsKey(carrier.getId())) {
        			newList.add(carrier);
        		}
        	}
    	}else{
    		newList = sourList;
    	}

    	return newList;
    }
    
	
	private void getCarriers(List ls ,Map reply,String carrierTypename,int level,boolean isValidate,boolean isDisplayCarrierType,Map resourceMap,String year,boolean orderCarrierLevelOne){
//		SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
		
//		boolean isDisplayCarrierType = Boolean.getBoolean(sysParam.getOrderCarrierTypeDisplayParam());
//		System.out.println(">>>>>>>>>>>>>>>>>>" + sysParam.getOrderCarrierTypeDisplayParam());
//		boolean isDisplayCarrierType = (sysParam.getOrderCarrierTypeDisplayParam().equals("0")|| sysParam.getOrderCarrierTypeDisplayParam() == null)?false:true;
//		System.out.println(" %%%%%%%%%%%%%%%%%%%%%%%%%"+isDisplayCarrierType);
//		String tvName = SysParamUtil.getTvNameParam();
//		boolean xmtv = SysParamUtil.isXMTVParam(tvName);

		 
    	int i=0;
    	
    	if(ls != null){
    		 for(Iterator it = ls.iterator();it.hasNext();){

    		    	String name = "";
    		    	
    		    	Carrier carrier =(Carrier) it.next(); 
//    		    	String carrYear = carrier.getVersion().toString();
    		    	
    		    	
    		    	if(isDisplayCarrierType){
    		    		name = carrierTypename+"::"+carrier.getCarrierName();
    			    }else{
    		    		name = carrier.getCarrierName();
    		    	}
    		    	
//    		    	System.out.println("getCarrierName %%%%%%%%%%%%%%%%%%%%%%%%%"+name);
//    		    	System.out.println("orderCarrierLevelOne %%%%%%%%%%%%%%%%%%%%%%%%%"+orderCarrierLevelOne);
//    		    	
    		    	int childrens = 0;
    		    	if(level == 0){
    		    		boolean isEnable = carrier.getEnable().booleanValue();
    		    		boolean isAdd = !isValidate || (isValidate && isEnable) ? true:false;
    		    		
    		    		if(orderCarrierLevelOne){
    		    			if(isAdd) reply.put(carrier.getId(),name);
    		    		}else{
            		    	if(isAdd){
        		    			childrens = getCarriersByParentIdItem(reply,carrier.getId(),name,i++,isValidate,resourceMap,year);
            		    	}
            		    	if(childrens == 0 && isAdd){ reply.put(carrier.getId(),name);}
    		    		}
    		    	}
    		    	
    		    	
    		    	
//    		    	System.out.println("childrens %%%%%%%%%%%%%%%%%%%%%%%%%"+level);
    			  
    			    //播出下载
    			    if(level == 2){
    		    		getCarriersByParentIdForDayOrNeit(reply,carrier.getId(),name,level,i++,year);
    		    	}
    			    //客户区间统计
    			    if(level == 1){
    			    	reply.put(carrier.getId(),name);
    		    	}
    		    }
    	}
	   
	}
	private void getCarriers3(List ls ,Map reply,String carrierTypename,int level,boolean isValidate,boolean isDisplayCarrierType,Map resourceMap,String year,boolean orderCarrierLevelOne,String orgId){
//		SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
		
//		boolean isDisplayCarrierType = Boolean.getBoolean(sysParam.getOrderCarrierTypeDisplayParam());
//		System.out.println(">>>>>>>>>>>>>>>>>>" + sysParam.getOrderCarrierTypeDisplayParam());
//		boolean isDisplayCarrierType = (sysParam.getOrderCarrierTypeDisplayParam().equals("0")|| sysParam.getOrderCarrierTypeDisplayParam() == null)?false:true;
//		System.out.println(" %%%%%%%%%%%%%%%%%%%%%%%%%"+isDisplayCarrierType);
		String tvName = SysParamUtil.getTvNameParam();
		boolean xmtv = tvName.equals("xmtv");
		String orgType = SysParamUtil.getOrgTypeById(orgId);
		 
    	int i=0;
    	
    	if(ls != null){
    		 for(Iterator it = ls.iterator();it.hasNext();){

    		    	String name = "";
    		    	
    		    	Carrier carrier =(Carrier) it.next(); 
//    		    	String carrYear = carrier.getVersion().toString();
    		    	String carrierSort =  StringUtil.getNullValue( carrier.getMediaOrgId(),"") ;
    		    	
    		    	
    		    	if(isDisplayCarrierType){
    		    		name = carrierTypename+"::"+carrier.getCarrierName();
    			    }else{
    		    		name = carrier.getCarrierName();
    		    	}
//    		    	System.out.println("carrierSort %%%%%%%%%%%%%%%%ttttttttttttttttttttttt%%%%%%%%%"+carrierSort);
//    		    	System.out.println("getCarrierName %%%%%%%%%%%%%%%%%%%%%%%%%"+name);
//    		    	System.out.println("getCarrierName %%%%%%%%%%%%%%%%%%%%%%%%%"+carrier.getId());
    		    	
//    		    	System.out.println("orderCarrierLevelOne %%%%%%%%%%%%%%%%%%%%%%%%%"+orderCarrierLevelOne);
//    		    	
    		    	int childrens = 0;
    		    	if(level == 0){
    		    		boolean isEnable = carrier.getEnable().booleanValue();
    		    		boolean isAdd = !isValidate || (isValidate && isEnable) ? true:false;
    		    		if(orderCarrierLevelOne||(xmtv && "2".equals(orgType) && "1".equals(carrierSort))){
//    		    		if(orderCarrierLevelOne){
    		    			if(isAdd) reply.put(carrier.getId(),name);
    		    		}else{
            		    	if(isAdd){
        		    			childrens = getCarriersByParentIdItem(reply,carrier.getId(),name,i++,isValidate,resourceMap,year);
            		    	}
            		    	if(childrens == 0 && isAdd){ reply.put(carrier.getId(),name);}
    		    		}
    		    	}
    		    	
    		    	
    		    	
//    		    	System.out.println("childrens %%%%%%%%%%%%%%%%%%%%%%%%%"+level);
    			  
    			    //播出下载
    			    if(level == 2){
    		    		getCarriersByParentIdForDayOrNeit(reply,carrier.getId(),name,level,i++,year);
    		    	}
    			    //客户区间统计
    			    if(level == 1){
    			    	reply.put(carrier.getId(),name);
    		    	}
    		    }
    	}
	   
	}
	private int getCarriersByParentIdForDayOrNeit(Map mp,Long parentId,String carrierName,int level,int i,String year){
		Carrier carrier = new Carrier();
		
		carrier.setParentId(parentId.toString());
		carrier.setNodeLevel(new Integer(level));
		List ls = this.getCarriers(carrier);

		for(Iterator it = ls.iterator();it.hasNext();){
			
		Carrier carr = (Carrier)it.next();
		String carrYear = carr.getVersion().toString();
		if(carrYear.equals(year)){
//			boolean isEnable = carr.getEnable().booleanValue();
//			if(isEnable) 
				mp.put(carr.getId(),carrierName+" || "+carr.getCarrierName());
		}

		}
	return ls.size();
		
	}
	
	private int getCarriersByParentIdItem(Map mp,Long parentId,String carrierName,int i,boolean isValidate,Map resourceMap,String year){
		
//		Map resourceMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_RESOURCE_MAP);

		Carrier carrier = new Carrier();
		
		carrier.setParentId(parentId.toString());
//		System.out.println("=========="+parentId);
		List ls = this.getCarriers(carrier);

		for(Iterator it = ls.iterator();it.hasNext();){
			Carrier carr = (Carrier)it.next();
			String carrYear = carr.getVersion().toString();
			if(carrYear.equals(year)){
				boolean isEnable = carr.getEnable().booleanValue();
				boolean isAdd = !isValidate || (isValidate && isEnable) ? true:false;
				if(isAdd) {
						int childrens = getCarriersByParentIdItem(mp,carr.getId(),carrierName+" || "+carr.getCarrierName(),i++,isValidate,resourceMap,year);
						
//						System.out.println("getCarriersByParentIdItem%%%%%%%%%%%%%"+carr.getId()+"%%%%%%%%%%%%"+childrens);
						
						if(childrens == 0){
							List resourceList = (List)resourceMap.get(carr.getId());
							if(resourceList != null){
								if(resourceList.size() >0){
										mp.put(carr.getId(),carrierName+" || "+carr.getCarrierName());
								}
							}
						}
				}	
			}

		}
		return ls.size();
	}
	
	

	

	
	
	private void getCarriersByParentId(String id, StringBuffer sb,String IdPrefix,String resourceIdPrefix){
//		System.out.println("==============1222=========");
		Carrier carrier = new Carrier();
		
		carrier.setParentId(id);
		
		Iterator it = this.getCarriers(carrier).iterator();
		
		while (it.hasNext()) {
			
						
			Carrier carr = (Carrier) it.next();

			sb.append("<item id='" +IdPrefix
							+ carr.getId().toString()
							+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
							+ carr.getCarrierName().toString() + "\">");
			sb.append("<userdata name=\"id\">" + carr.getId().toString()
					+ "</userdata>");
			sb.append("<userdata name=\"type\">2</userdata>");
			
			resourceManager.getResourceItemsByCarrierId(sb,carr.getId().toString(),resourceIdPrefix);
			getCarriersByParentId(carr.getId().toString(), sb,IdPrefix,resourceIdPrefix);
//			System.out.println("==============00000=========");
			
			sb.append("</item>");
		}
	}
	
	private void getCarriersByParentIdForArrange(String id, StringBuffer sb,String IdPrefix,String resourceIdPrefix,String publishDate){
//		System.out.println("==============1222=========");
		Carrier carrier = new Carrier();
		
		carrier.setParentId(id);
		
		Iterator it = this.getCarriers(carrier).iterator();
		
		while (it.hasNext()) {
			
						
			Carrier carr = (Carrier) it.next();

			sb.append("<item id='" +IdPrefix
							+ carr.getId().toString()
							+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
							+ carr.getCarrierName().toString() + "\">");
			sb.append("<userdata name=\"id\">" + carr.getId().toString()
					+ "</userdata>");
			sb.append("<userdata name=\"type\">2</userdata>");
			
			resourceManager.getResourceItemsByCarrierIdForArrange(sb,carr.getId().toString(),resourceIdPrefix,publishDate);
			getCarriersByParentIdForArrange(carr.getId().toString(), sb,IdPrefix,resourceIdPrefix,publishDate);
//			System.out.println("==============00000=========");
			
			sb.append("</item>");
		}
	}

	public void getCarriersItemsByCarrierTypeId(StringBuffer sb, String carrierTypeId, String carrierIdPrefix,String resourceIdPrefix) {
//		System.out.println("==============1==========");
		Carrier car = new Carrier();
		
		car.setCarrierTypeId(new Long(carrierTypeId));
		car.setParentId("0");
		
		List ls = dao.getCarriers(car);
		
		for(Iterator it = ls.iterator();it.hasNext();){
				
			Carrier carrier = (Carrier)it.next();
			sb.append("<item id='" + carrierIdPrefix
							+ carrier.getId().toString()
							+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
							+ carrier.getCarrierName().toString() + "\">");
			sb.append("<userdata name=\"type\">2</userdata>");
			resourceManager.getResourceItemsByCarrierId(sb,carrier.getId().toString(),resourceIdPrefix);
			getCarriersByParentId(carrier.getId().toString(),sb,carrierIdPrefix,resourceIdPrefix);

			sb.append("</item>");
			
		}
		
	}
	private List  getCarriersByTypeByCarrierTypeId(Long carrierTypeId) {
		Map mp = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIERS_BY_CARRIER_TYPE);
		Object obj = mp.get(carrierTypeId);
		List ls  = new ArrayList();
		if(obj != null) ls = (List)obj;
		return ls;
	}	
	public void getCarriersItemsByCarrierTypeIdFromMapByYear(StringBuffer sb, String carrierTypeId, String carrierIdPrefix,String resourceIdPrefix,String year) {
//		List ls = (List)getCarriersByTypeByCarrierTypeId(new Long(carrierTypeId));
		List ls = new ArrayList();
//		判断是否分频道
		boolean channelPull = SysParamUtil.getChannelModelPara();
		if(channelPull){
//			如果分频道取得当前用户相对应的频道 
			Map userCarrierRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_CARRIER_RELS);
			ls = getOwnerUsersList(userCarrierRelsMap);
		}else{
			ls = (List)getCarriersByTypeByCarrierTypeId(new Long(carrierTypeId));
		}		
		for(Iterator it = ls.iterator();it.hasNext();){
				
			Carrier carrier = (Carrier)it.next();
			
			String parentId = carrier.getParentId();
			
//			Integer carYear = carr.getVersion();
//			if(year.equals(carYear.toString())){}
			String caTypeId = carrier.getCarrierTypeId().toString();

			if(parentId.equals("0") && caTypeId.equals(carrierTypeId)){
//				List lss = this.getCarriersByParentIdFromMap(carrier.getId());
//				if(lss.size() > 0){
					sb.append("<item id='" + carrierIdPrefix
							+ carrier.getId().toString()
							+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
							+ carrier.getCarrierName().toString() + "\">");
					sb.append("<userdata name=\"type\">2</userdata>");
			//		oneCarrResListByCarrierId
					resourceManager.getResourceItemsByCarrierIdFromMapByYear(sb,carrier.getId().toString(),resourceIdPrefix,year);
					getCarriersByParentIdFromMapByYear(carrier.getId().toString(),sb,carrierIdPrefix,resourceIdPrefix,year);
					sb.append("</item>");
//				}
	
			}

			
		}
		
	}
	
	public void getCarriersItemsByCarrierTypeIdFromMapByYear2(StringBuffer sb, String carrierTypeId, String carrierIdPrefix,String resourceIdPrefix,String year,boolean isAccountRes) {
//		List ls = (List)getCarriersByTypeByCarrierTypeId(new Long(carrierTypeId));
		List ls = new ArrayList();
//		判断是否分频道
		boolean channelPull = SysParamUtil.getChannelModelPara();
		if(channelPull){
//			如果分频道取得当前用户相对应的频道 
			Map userCarrierRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_CARRIER_RELS);
			ls = getOwnerUsersList(userCarrierRelsMap);
		}else{
			ls = (List)getCarriersByTypeByCarrierTypeId(new Long(carrierTypeId));
		}		
		for(Iterator it = ls.iterator();it.hasNext();){
				
			Carrier carrier = (Carrier)it.next();
			
			String parentId = carrier.getParentId();
			
		
//			Integer carYear = carr.getVersion();
//			if(year.equals(carYear.toString())){}
			String caTypeId = carrier.getCarrierTypeId().toString();

			if(parentId.equals("0") && caTypeId.equals(carrierTypeId)){

//				List lss = this.getCarriersByParentIdFromMap(carrier.getId());
//				if(lss.size() > 0){
					sb.append("<item id='" + carrierIdPrefix
							+ carrier.getId().toString()
							+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
							+ carrier.getCarrierName().toString() + "\">");
					sb.append("<userdata name=\"type\">2</userdata>");
			//		oneCarrResListByCarrierId
					resourceManager.getResourceItemsByCarrierIdFromMapByYear2(sb,carrier.getId().toString(),resourceIdPrefix,year,isAccountRes);
					getCarriersByParentIdFromMapByYear2(carrier.getId().toString(),sb,carrierIdPrefix,resourceIdPrefix,year,isAccountRes);
					sb.append("</item>");
//				}
	
			}

			
		}
		
	}	

	
	

	public void getCarriersItemsByCarrierTypeIdFromMap(StringBuffer sb, String carrierTypeId, String carrierIdPrefix,String resourceIdPrefix,String publishDate,String resourceTypeId) {
		String tvName = SysParamUtil.getTvNameParam();
//		boolean fztv =SysParamUtil.isFZTVParam(tvName);
		
//		System.out.println("==============getCarriersItemsByCarrierTypeIdFromMap=========");
		
		List ls = new ArrayList();
//		判断是否分频道
		boolean channelPull = SysParamUtil.getChannelModelPara();
		if(channelPull){
//			如果分频道取得当前用户相对应的频道 
			Map userCarrierRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_CARRIER_RELS);
			ls = getOwnerUsersList(userCarrierRelsMap);
		}else{
			ls = (List)getCarriersByTypeByCarrierTypeId(new Long(carrierTypeId));
		}
		
//		if(fztv) carrierIdPrefix =resourceTypeId+"_"+carrierIdPrefix;  
//		carrierIdPrefix =resourceTypeId+"_"+carrierIdPrefix;  
		
//		System.out.println("carrierIdPrefixvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv   "+carrierIdPrefix);
		
		Collections.sort(ls,new CarrierComparator());
		
		for(Iterator it = ls.iterator();it.hasNext();){
				
			Carrier carrier = (Carrier)it.next();
			
			String parentId = carrier.getParentId();
			String caTypeId = carrier.getCarrierTypeId().toString();

			if(parentId.equals("0") && caTypeId.equals(carrierTypeId)){

				sb.append("<item id='" + carrierIdPrefix
						+ carrier.getId().toString()
						+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
						+ carrier.getCarrierName().toString() + "\">");
				sb.append("<userdata name=\"type\">2</userdata>");
				sb.append("<userdata name=\"carrierIdFist\">"+  carrier.getId().toString() +"</userdata>");
		//		oneCarrResListByCarrierId

				resourceManager.getResourceItemsByCarrierIdFromMap(sb,carrier.getId().toString(),resourceIdPrefix,publishDate,resourceTypeId);
				
//				if(!fztv||!resourceTypeId.equals("3")){
//					getCarriersByParentIdFromMap(carrier.getId().toString(),sb,carrierIdPrefix,resourceIdPrefix,publishDate,resourceTypeId);
//				}
				
				if(!resourceTypeId.equals("3")){
					getCarriersByParentIdFromMap(carrier.getId().toString(),sb,carrierIdPrefix,resourceIdPrefix,publishDate,resourceTypeId);
				}
				sb.append("</item>");
			}

			
		}
		
	}
	

	
	private List  getCarriersByParentIdFromMap(Long parentId) {
		Map mp = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIER_CHILD_NOMYSALFE);
		Object obj = mp.get(parentId);
		List ls  = new ArrayList();
		if(obj != null) ls = (List)obj;
		return ls;
	}
	
	
	

	private void getCarriersByParentIdFromMap(String id, StringBuffer sb,String IdPrefix,String resourceIdPrefix,String publishDate,String resourceTypeId){
		
		Iterator it = getCarriersByParentIdFromMap(new Long(id)).iterator();
	
		while (it.hasNext()) {
		
			Carrier carr = (Carrier) it.next();
			Integer carYear = carr.getVersion();
			String year = publishDate.substring(0,4);
			String parentId = carr.getParentId();
			
			System.out.println("==============00000========= parentId >>>>>>>>>>>>>>>>>>>"+parentId);
			
//			List resList = resourceManager.getResListByCarrierId(carr.getId(),publishDate);
//			boolean hasResChilens = resList.size() > 0? true:false;
			
			if(year.equals(carYear.toString())){
//			if(year.equals(carYear.toString()) && hasResChilens){
//				boolean isFztv = getFztvSpecialParam();
//				if(!isFztv){
					sb.append("<item id='" +IdPrefix
							+ carr.getId().toString()
							+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
							+ carr.getCarrierName().toString() + "\">");
					sb.append("<userdata name=\"id\">" + carr.getId().toString()
							+ "</userdata>");
					sb.append("<userdata name=\"type\">2</userdata>");
//				}
				resourceManager.getResourceItemsByCarrierIdFromMap(sb,carr.getId().toString(),resourceIdPrefix,publishDate,resourceTypeId);
				getCarriersByParentIdFromMap(carr.getId().toString(), sb,IdPrefix,resourceIdPrefix,publishDate,resourceTypeId);
		//		System.out.println("==============00000=========");
//				if(!isFztv){
					sb.append("</item>");
//				}
				
			}


		}
	}
	

	
	private void getCarriersByParentIdFromMapByYear(String id, StringBuffer sb,String IdPrefix,String resourceIdPrefix,String year){
		
		Iterator it = getCarriersByParentIdFromMap(new Long(id)).iterator();
	
		while (it.hasNext()) {
			
			Carrier carr = (Carrier) it.next();
//			List resList = resourceManager.getResListByCarrierId(carr.getId(),year);
//			boolean hasResChilens = resList.size() > 0? true:false;
			Integer carYear = carr.getVersion();
			
			if(year.equals(carYear.toString()) ){
				sb.append("<item id='" +IdPrefix
						+ carr.getId().toString()
						+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
						+ carr.getCarrierName().toString() + "\">");
				sb.append("<userdata name=\"id\">" + carr.getId().toString()
						+ "</userdata>");
				sb.append("<userdata name=\"type\">2</userdata>");
				
				resourceManager.getResourceItemsByCarrierIdFromMapByYear(sb,carr.getId().toString(),resourceIdPrefix,year);
				getCarriersByParentIdFromMapByYear(carr.getId().toString(), sb,IdPrefix,resourceIdPrefix,year);
		//		System.out.println("==============00000=========");
				
				sb.append("</item>");			
				
			}
			

		}
	}
	
	private void getCarriersByParentIdFromMapByYear2(String id, StringBuffer sb,String IdPrefix,String resourceIdPrefix,String year,boolean isAccountRes){
		
		Iterator it = getCarriersByParentIdFromMap(new Long(id)).iterator();
	
		while (it.hasNext()) {
			
			Carrier carr = (Carrier) it.next();
//			List resList = resourceManager.getResListByCarrierId(carr.getId(),year);
//			boolean hasResChilens = resList.size() > 0? true:false;
			Integer carYear = carr.getVersion();
			
			List resList = resourceManager.getResListByCarrierIdAndIsAccountRes(carr.getId(),isAccountRes);
			
			boolean hasResChilens = resList.size() > 0? true:false;
//			System.out.println(">>>>>>>>>>>>>>>>>>>getResListByCarrierIdAndIsAccountRes>>>>>>>>>>>" +resList.size());
			
			
			if(year.equals(carYear.toString()) && hasResChilens){
				sb.append("<item id='" +IdPrefix
						+ carr.getId().toString()
						+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
						+ carr.getCarrierName().toString() + "\">");
				sb.append("<userdata name=\"id\">" + carr.getId().toString()
						+ "</userdata>");
				sb.append("<userdata name=\"type\">2</userdata>");
				
				resourceManager.getResourceItemsByCarrierIdFromMapByYear2(sb,carr.getId().toString(),resourceIdPrefix,year,isAccountRes);
				getCarriersByParentIdFromMapByYear2(carr.getId().toString(), sb,IdPrefix,resourceIdPrefix,year,isAccountRes);
		//		System.out.println("==============00000=========");
				
				sb.append("</item>");			
				
			}
			

		}
	}
	
	
	

	public void getCarriersItemsByCarrierTypeIdForArrange(StringBuffer sb, String carrierTypeId, String carrierIdPrefix,String resourceIdPrefix,String publishDate) {
//		System.out.println("==============1==========");
		Carrier car = new Carrier();
		
		car.setCarrierTypeId(new Long(carrierTypeId));
		car.setParentId("0");
		
		List ls = dao.getCarriers(car);
		
		for(Iterator it = ls.iterator();it.hasNext();){
				
			Carrier carrier = (Carrier)it.next();
			sb.append("<item id='" + carrierIdPrefix
							+ carrier.getId().toString()
							+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
							+ carrier.getCarrierName().toString() + "\">");
			sb.append("<userdata name=\"type\">2</userdata>");
			resourceManager.getResourceItemsByCarrierIdForArrange(sb,carrier.getId().toString(),resourceIdPrefix,publishDate);
			getCarriersByParentIdForArrange(carrier.getId().toString(),sb,carrierIdPrefix,resourceIdPrefix,publishDate);

			sb.append("</item>");
			
		}
		
	}
	
	
	public String getCarriersAdvTypeXML(Carrier carrier, String IdPrefix) {
		
		StringBuffer sb = new StringBuffer("");
		sb.append("<?xml version=\"1.0\"?>");
		sb.append("<tree id=\"0\">");
		sb.append("<item text=\"广告类型\" id=\"root\" open=\"1\" im0=\"books_close.gif\" im1=\"tombs.gif\" im2=\"tombs.gif\" call=\"1\" select=\"1\">");
		sb.append("<userdata name=\"id\">0</userdata>");
		sb.append("<userdata name=\"type\">0</userdata>");
		getCarriersIdsByParent(carrier.getParentId(),sb,IdPrefix);
		sb.append("</item>");
		sb.append("</tree>");
		
		return sb.toString();
	} 
	
	
	private void getCarriersIdsByParent(String id, StringBuffer sb,String IdPrefix) {

		Carrier carriers = new Carrier();
		carriers.setParentId(id);
		Iterator it = this.getCarriers(carriers).iterator();
		
		while (it.hasNext()) {
			Carrier cus = (Carrier) it.next();

			sb.append("<item id='" +IdPrefix
							+ cus.getId().toString()
							+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
							+ cus.getCarrierName().toString() + "\">");
			sb.append("<userdata name=\"id\">" + cus.getId().toString()
					+ "</userdata>");
			sb.append("<userdata name=\"type\">1</userdata>");
			getCarriersIdsByParent(cus.getId().toString(), sb,IdPrefix);
			sb.append("</item>");

		}
	}

//	public String getCarrierNameByLevel(Resource res,int level) {
//		Map resourceMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_RESOURCE_MAP);
//		List resourceList = (List)resourceMap.get(res.getCarrierId());
//		return null; 
//	}
//	

	public String getCarrierParnet(String resourceId,int level){
		Resource resource = resourceManager.getResource(resourceId);
		String carrierId = resource.getCarrierId().toString();
		Map carrierMap = new HashMap();
		getCarrierParnet(carrierId,carrierMap);
		Carrier carrier= (Carrier)carrierMap.get(new Integer(level));
		return carrier.getCarrierName();
	}
	
	
	private void getCarrierParnet(String carrierId,Map carrierMap){
		Carrier carrierParnet= dao.getCarrier(new Long(carrierId));
		Integer level = carrierParnet.getNodeLevel();
		Long id = carrierParnet.getId();
		
		carrierMap.put(level,carrierParnet);
		if(level.intValue() >1){
			getCarrierParnet(id.toString(),carrierMap);
		}
		
	}
	
	public boolean isBuildLevel(String nodeLevel){
		boolean isbuild;
		SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
		String carrierNodeLevel = sysParam.getCarrierNodeLevelParam()==null?null:sysParam.getCarrierNodeLevelParam();
		if(carrierNodeLevel.equals(nodeLevel)){
			isbuild = true;
		}else{
			isbuild = false;
		}
		return isbuild;
	}

	public void getCarriersResourceAnalyze(StringBuffer sb, String carrierTypeId, String carrierIdPrefix, String resourceIdPrefix, String carrierId, String resourceTypeId) {
		Carrier car = new Carrier();
		
		car.setCarrierTypeId(new Long(carrierTypeId));
		car.setId(new Long(carrierId));
		
		List ls = dao.getCarriers(car);
		
		for(Iterator it = ls.iterator();it.hasNext();){
				
			Carrier carrier = (Carrier)it.next();
			sb.append("<item id='" + carrierIdPrefix
							+ carrier.getId().toString()
							+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
							+ carrier.getCarrierName().toString() + "\">");
			sb.append("<userdata name=\"type\">2</userdata>");
			resourceManager.getResourcesResourceAnalyze(sb,carrier.getId().toString(),resourceIdPrefix,resourceTypeId);
			getCarriersByParentIdResourceAnalyze(carrier.getId().toString(),sb,carrierIdPrefix,resourceIdPrefix,resourceTypeId);

			sb.append("</item>");
			
		}
		
	}
	
	private void getCarriersByParentIdResourceAnalyze(String id, StringBuffer sb,String IdPrefix,String resourceIdPrefix,String resourceTypeId){
//		System.out.println("==============1222=========");
		Carrier carrier = new Carrier();
		
		carrier.setParentId(id);
		
		Iterator it = this.getCarriers(carrier).iterator();
		
		while (it.hasNext()) {
			
						
			Carrier carr = (Carrier) it.next();

			sb.append("<item id='" +IdPrefix
							+ carr.getId().toString()
							+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
							+ carr.getCarrierName().toString() + "\">");
			sb.append("<userdata name=\"id\">" + carr.getId().toString()
					+ "</userdata>");
			sb.append("<userdata name=\"type\">2</userdata>");
			
			resourceManager.getResourcesResourceAnalyze(sb,carr.getId().toString(),resourceIdPrefix,resourceTypeId);
			getCarriersByParentIdResourceAnalyze(carr.getId().toString(), sb,IdPrefix,resourceIdPrefix,resourceTypeId);
//			System.out.println("==============00000=========");
			
			sb.append("</item>");
		}
	}

	public void getUserCarriersItemsByCarrierTypeId(StringBuffer sb, String carrierTypeId,String theUser, String carrierIdPrefix) {
		// TODO Auto-generated method stub
		boolean channelPull = SysParamUtil.getChannelModelPara();
		boolean isUseCarrierAlinsname = SysParamUtil.getUseCarrierAliname();
//		boolean isUseCarrierAlinsname = alisnameType.equals("1");
		
//		System.out.println("==============channelPull========="+channelPull);
		
		List ls=new ArrayList();
//		System.out.println("==============theUser========="+theUser);
//		System.out.println("==============1222========="+(theUser==null));
//		System.out.println("==============carrierTypeId========="+carrierTypeId);
		if(!channelPull||theUser == null){
			Carrier car = new Carrier();
			car.setCarrierTypeId(new Long(carrierTypeId));
			car.setParentId("0");
		    ls = dao.getCarriers(car);
		}else{
			Map userCarrierRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_CARRIER_RELS);
			ls = (List)userCarrierRelsMap.get(theUser);
//			System.out.println("==============ls.size========="+ls.size());
		}
//		System.out.println("==============ls.size========="+ls.size());
//		System.out.println("==============isUseCarrierAlinsname========="+isUseCarrierAlinsname);
//		System.out.println("==============channelPull========="+channelPull);
//		System.out.println("==============theUser========="+theUser);
		
		
		
		if(isUseCarrierAlinsname  && theUser != null){
			
			Map mpAlisName = new HashMap();
			for(Iterator it = ls.iterator();it.hasNext();){
				Carrier carrier = (Carrier)it.next();
				String alisName = carrier.getAliasName();
//				System.out.println("==============alisName========="+alisName);
				
				alisName = StringUtils.isEmpty(alisName)||alisName ==null?carrier.getCarrierName():alisName;
			
				if(mpAlisName.containsKey(alisName)){
					Carrier car = (Carrier)mpAlisName.get(alisName);
					String ids = car.getMemo()+","+carrier.getId().toString();
//					System.out.println("==============ids========="+ids);
					car.setMemo(ids);
					car.setAliasName(alisName);
					mpAlisName.put(alisName,car);
				}else{
					String id = carrier.getId().toString();
					carrier.setMemo(id);
					System.out.println("==============id========="+id);
					carrier.setAliasName(alisName);
					mpAlisName.put(alisName,carrier);
				}
			}	
			
			List ls2 =  new ArrayList();
			CollectionUtils.addAll(ls2,mpAlisName.values().toArray());
			Collections.sort(ls2,new CarrierComparator());
			
			
			for(Iterator it =ls2.iterator();it.hasNext();){
				Carrier carrier = (Carrier)it.next();
				String caTypeId = carrier.getCarrierTypeId().toString();
				if(caTypeId.equals(carrierTypeId)){
					sb.append("<item id='" + carrierIdPrefix + carrier.getId().toString()+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\"" + carrier.getAliasName() + "\">");
					sb.append("<userdata name=\"type\">2</userdata>");
					sb.append("<userdata name=\"alisname\">"+ carrier.getMemo() +"</userdata>");
					sb.append("</item>");
				}
			}		
			
		}else{
			
			Collections.sort(ls,new CarrierComparator());
			
			for(Iterator it = ls.iterator();it.hasNext();){
				Carrier carrier = (Carrier)it.next();
				String caTypeId = carrier.getCarrierTypeId().toString();
				if(caTypeId.equals(carrierTypeId)){
					sb.append("<item id='" + carrierIdPrefix + carrier.getId().toString()+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\"" + carrier.getCarrierName().toString() + "\">");
					sb.append("<userdata name=\"type\">2</userdata>");
					sb.append("<userdata name=\"alisname\">"+ carrier.getMemo() +"</userdata>");
					sb.append("</item>");
				}
			}			
			
			
		}
		
		
		
		
		
		
		
		

	}

	public Map getCarrierSelectItemAnalyze() {
		// TODO Auto-generated method stub
		Map userCarrierRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_CARRIER_RELS);
		
		List ls = getOwnerUsersList(userCarrierRelsMap);
		
		
	    Map reply = new LinkedHashMap();
	    Iterator it = ls.iterator();
	    reply.put("0","==频道==");
	    while(it.hasNext()){
	    	Carrier carrier = new Carrier();
	    	carrier = (Carrier) it.next();
	    	reply.put(carrier.getId(),carrier.getCarrierName());
	    }
	    
		return reply;
	}
	
	
	public Map getCarrierSelectItemAnalyze5(String loginUser,String orgId) {
		//判断是否分频道，值为1分，否则不分
//		boolean channelPull = SysParamUtil.getChannelModelPara();
//		boolean carrierAlisname = SysParamUtil.getUseCarrierAliname();
		Map mp = new HashMap();
//		List carrierIdList  = this.getOwnerCarrier(null,channelPull,theUser,true);
		List carrierIdList  = CarrierUtil.getOwnerCarrier(orgId,loginUser);
		
//		if(carrierAlisname) Collections.sort(carrierIdList,new CarrierComparator());
	    Map reply = new LinkedHashMap();
	    Iterator it = carrierIdList.iterator();
	    reply.put("0","==频道==");
	    while(it.hasNext()){
	    	Carrier carrier = new Carrier();
	    	carrier = (Carrier) it.next();
	    	reply.put(carrier.getId(),carrier.getCarrierName());
//			if(carrierAlisname){
//				String key = carrier.getAliasName();
//		    	if(!mp.containsKey(key)){
//		    		reply.put(carrier.getId(),carrier.getCarrierName());
//		    		mp.put(carrier.getAliasName(),""+carrier.getId());
//		    	}
//			}else{
//				reply.put(carrier.getId(),carrier.getCarrierName());
//			}
	    }
	    
		return reply;
	}
	
	
	
	
	
	public Map getCarrierSelectItemAnalyze6(String loginUser,String orgId) {
		//判断是否分频道，值为1分，否则不分
//		boolean channelPull = SysParamUtil.getChannelModelPara();
//		Map carrierMp = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIER);
		boolean carrierAlisname = SysParamUtil.getUseCarrierAliname();
		Map mp = new HashMap();
//		List carrierIdList  = this.getOwnerCarrier(null,channelPull,loginUser,true);
		
		orgId = StringUtil.getNullValue(orgId,"1");
		
		
		List carrierIdList  = CarrierUtil.getOwnerCarrier(orgId,loginUser);
		
		
//		List carrierIdList2 = CarrierUtil.getCarrierIds("","2",loginUser);
//		System.out.println(">>>>>>>>>>>>loginUser>>>>>>>>" + loginUser);
		System.out.println(">>>>>>aaaaaaaaaaaaaaaaaaa>>>>>>carrierIdList>>>>>>>>" + carrierIdList);
//		if(carrierAlisname) Collections.sort(carrierIdList,new CarrierComparator());
	    Map reply = new LinkedHashMap();
	    Iterator it = carrierIdList.iterator();
	    reply.put("0","==频道==");
	    while(it.hasNext()){
	    	Carrier carrier  = (Carrier)it.next();
//	    	System.out.println(">>>>>>>>>>>> carrierId >>>>>>>>" + carr.getId().toString());
//	    	Carrier carrier = (Carrier)carrierMp.get(carr.getId());
//	    	Carrier carrier = (Carrier)it.next();
	    
	    	String org_id = carrier.getOrgId();
	    	System.out.println(">>>>>>>>>>>>org_id-2>>>>>>>>" + org_id);
	    	if(orgId.equals(org_id)){
				if(carrierAlisname){
					String key = carrier.getAliasName();
			    	if(!mp.containsKey(key)){
			    		reply.put(carrier.getId(),carrier.getCarrierName());
			    		mp.put(carrier.getAliasName(),""+carrier.getId());
			    	}
				}else{
					reply.put(carrier.getId(),carrier.getCarrierName());
				}
	    	}

	    }
	    
		return reply;
	}	
	
	
	public List getOwnerUsersList(Map map) {
		//获取当前用户
	     String currentUser = UserUtil.getCurrentPrincipalUser();
//	 	System.out.println(">>>>>>>>>>>>carrierId2-2>>>>>>>>" + currentUser);
		 List ls = (List)map.get(currentUser);
		 
		 Collections.sort(ls,new CarrierComparator());
		 
		 return ls;
	}
	public List getOwnerUsersList2(Map map,String loginUser) {
		//获取当前用户
		 if(loginUser == null|| "".equals(loginUser)){
			 loginUser= UserUtil.getCurrentPrincipalUser();
		 }
	    
//	 	System.out.println(">>>>>>>>>>>>carrierId2-2>>>>>>>>" + currentUser);
		 List ls = (List)map.get(loginUser);
		 return ls;
	}
	
	public List getCarrierIdLists(String carrierName,boolean channelPull,String theUser){
		List carrierIdList = new ArrayList();
		//System.out.println(">>>>>"+carrierName.equals("0"));
		Map carrierMp = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIER_CHILD);
//		System.out.println(">>carrierName>>>>>>>>>>>>>>>>>>>"+carrierName);
		if( !"0".equals(carrierName) && carrierName !=null){
			List ls = (List)carrierMp.get(Long.valueOf(carrierName));
//			System.out.println(">>ls.size()>>>>>>>>>>>>>>>>>>>"+ls.size());
			CollectionUtils.addAll(carrierIdList,ConvertUtil.getColFromList(ls,"id"));

		}else{
		    if(channelPull){
				Map userCarrierRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_CARRIER_RELS);
				List ls = new ArrayList();
				if(theUser==null){
					ls = getOwnerUsersList(userCarrierRelsMap);
				}else{
					ls = (List)userCarrierRelsMap.get(theUser);
				}
				for(Iterator it=ls.iterator();it.hasNext();){
					Carrier carrier = (Carrier) it.next();
					Long parentId=carrier.getId();
					List list = (List)carrierMp.get(parentId);
					CollectionUtils.addAll(carrierIdList,ConvertUtil.getColFromList(list,"id"));
				}
//				System.out.println(">>carrierIdList.size()>>>>>>>>>>>>>>>>>>>"+carrierIdList.size());
				if(carrierIdList.size()==0)carrierIdList.add("0");
		    }else{
		    	for(Iterator it = carrierMp.values().iterator();it.hasNext();){
		    		List list = (List)it.next();
		    		CollectionUtils.addAll(carrierIdList,ConvertUtil.getColFromList(list,"id"));
		    	}
		    	carrierIdList.add("-1");
		    }

			
		}
		return carrierIdList;
	}
	
	public List getCarrierIdListsNotChilden(String carrierName,boolean channelPull,String theUser){
		

		
		List carrierIdList = new ArrayList();
		List ls = new ArrayList();
		if(channelPull){
			
			Map userCarrierRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_CARRIER_RELS);

			if(theUser==null){
				ls = getOwnerUsersList(userCarrierRelsMap);
			}else{
				Object obj = userCarrierRelsMap.get(theUser);
				if(obj!= null){
					ls = (List)userCarrierRelsMap.get(theUser);
				}
			}
	    }
		if(ls.size() > 0){
			CollectionUtils.addAll(carrierIdList,ConvertUtil.getColFromList(ls,"id"));
		}

		return carrierIdList;
	}	
	

	public void getCarriersResourceAnalyzeForChannel(StringBuffer sb, String carrierTypeId, String carrierIdPrefix, String resourceIdPrefix, int channelModelParam) {
		// TODO Auto-generated method stub
		Carrier car = new Carrier();
		car.setCarrierTypeId(new Long(carrierTypeId));
		car.setParentId("0");
		List ls=new ArrayList();
		//根据是否分频道,取得频道
		if(channelModelParam!=1){
			ls = dao.getCarriers(car);
		}else{
			Map userCarrierRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_CARRIER_RELS);
			ls = getOwnerUsersList(userCarrierRelsMap);
		}
		
		for(Iterator it = ls.iterator();it.hasNext();){
			Carrier carrier = (Carrier)it.next();
			
			sb.append("<item id='" + carrierIdPrefix
							+ carrier.getId().toString()
							+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
							+ carrier.getCarrierName().toString() + "\">");
			sb.append("<userdata name=\"type\">2</userdata>");
			
			sb.append("<userdata name=\"carrierName\">"+ carrier.getCarrierName().toString()+"</userdata>");
	
			  resourceManager.getResourceItemsByCarrierId(sb,carrier.getId().toString(),resourceIdPrefix);
			  getCarriersByParentId(carrier.getId().toString(),sb,carrierIdPrefix,resourceIdPrefix);


			sb.append("</item>");
			
		}
	}

	public void getCarriersItemsByCarrierTypeIdByYear(StringBuffer sb, String carrierTypeId, String carrierIdPrefix, String resourceIdPrefix,String year,Integer resourceType,Integer orderBy) {
		Carrier car = new Carrier();
		car.setCarrierTypeId(new Long(carrierTypeId));
		car.setParentId("0");
		
		boolean isWithResourceSort = SysParamUtil.getWithResourceSort();
		
		List ls = dao.getCarriers(car);
		
		Collections.sort(ls,new CarrierComparator());
		
		for(Iterator it = ls.iterator();it.hasNext();){
				
			Carrier carrier = (Carrier)it.next();
			
			String orgType = SysParamUtil.getOrgTypeById(carrier.getOrgId());

				
			sb.append("<item id='" +carrierIdPrefix
							+ carrier.getId().toString()
							+ "' im0=\"magazines_close.gif\" im1=\"magazines_open.gif\" im2=\"magazines_close.gif\" text=\""
							+ carrier.getCarrierName().toString() + "\">");
			sb.append("<userdata name=\"type\">2</userdata>");
			
			boolean orderCarrierLevelOne = false;
			
			if(isWithResourceSort && resourceType!=null && resourceType.intValue() !=999) orderCarrierLevelOne = true;
			
			if(log.isDebugEnabled()){
				System.out.println(">>>>>>>>>>>>>>>isWithResourceSort = " + isWithResourceSort);
				System.out.println(">>>>>>>>>>>>>>>resourceType = " + resourceType);
				System.out.println(">>>>>>>>>>>>>>>orderCarrierLevelOne = " + orderCarrierLevelOne);
			}
			resourceManager.getResourceItemsByCarrierIdByYear(sb,carrier.getId().toString(),resourceIdPrefix,year,orderCarrierLevelOne,resourceType,orgType); 	
			if(!orderCarrierLevelOne) getCarriersByParentIdByYear(carrier.getId().toString(),sb,carrierIdPrefix,resourceIdPrefix,year,orderCarrierLevelOne,resourceType,null);
			sb.append("</item>");  
			
		}
		
	}
	
	
	
	
	
	
	public void getCarriersItemsByCarrierTypeIdByYear2(StringBuffer sb, String carrierTypeId, String carrierIdPrefix, String resourceIdPrefix,String year,Integer resourceType,Integer orderBy,String displayCarModerier,boolean enable,boolean fitterCarrier,String loginUser,boolean isFineRes) {
		Carrier car = new Carrier();
		car.setCarrierTypeId(new Long(carrierTypeId));
		car.setParentId("0");
		
		String orgType = SysParamUtil.getOrgTypeByTypeId(carrierTypeId);
		
	
		
		boolean isWithResourceSort = SysParamUtil.getWithResourceSort();
		
		Map userCarrierRelsIdsMap = new HashMap();
		List carIds = new ArrayList();
		if(fitterCarrier){
			userCarrierRelsIdsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_CARRIER_RELS_ID);
			carIds = (List)userCarrierRelsIdsMap.get(loginUser);
		}
	
		
		List ls = dao.getCarriers(car);
		
		Collections.sort(ls,new CarrierComparator());
		
		for(Iterator it = ls.iterator();it.hasNext();){
				
			Carrier carrier = (Carrier)it.next();
			
			boolean displayMode = carrier.getEnable().booleanValue();
			displayCarModerier = StringUtil.getNullValue(displayCarModerier,"");
			
			System.out.println("displayMode>>>>>>>>%%%%%%%%%%%%%%%%%%%%%%%%%%%%% ???????????????????????>>>>>>>>>>>>>>>> " + displayMode);
			System.out.println("displayCarModerier>>>>>>>>>%%%%%%%%%%%%%%%%%%%%%%%%%%%%% ?????????????????????>>>>>>>>>>>>> " + displayCarModerier);
			System.out.println(" carrier.getCarrierName()>>>>>>>>%%%%%%%%%%%%%%%%%%%%%%%%%%%%% ???????????????????????>>>>>>>>>>>>>>>> " +  carrier.getCarrierName());
			
			//时段维护 displayCarModerier ＝ 1  displayMode ＝ true 启用
			if("1".equals(displayCarModerier) && displayMode){
				sb.append("<item id='" +carrierIdPrefix
						+ carrier.getId().toString()
						+ "' im0=\"magazines_close.gif\" im1=\"magazines_open.gif\" im2=\"magazines_close.gif\" text=\""
								+ carrier.getCarrierName().toString() + "\">");
				sb.append("<userdata name=\"type\">2</userdata>");
				
				sb.append("<userdata name=\"carrierName\">"+ carrier.getCarrierName().toString() + "</userdata>");
				
				boolean orderCarrierLevelOne = false;
				
				if(isWithResourceSort && resourceType!=null && resourceType.intValue() !=999) orderCarrierLevelOne = true;
				
				if(log.isDebugEnabled()){
					System.out.println(">>>>>>>>>>>>>>>isWithResourceSort = " + isWithResourceSort);
					System.out.println(">>>>>>>>>>>>>>>resourceType = " + resourceType);
					System.out.println(">>>>>>>>>>>>>>>orderCarrierLevelOne = " + orderCarrierLevelOne);
				}
				resourceManager.getResourceItemsByCarrierIdByYearTest(sb,carrier.getId().toString(),resourceIdPrefix,year,orderCarrierLevelOne,resourceType,orgType,true); 	
				if(!orderCarrierLevelOne) getCarriersByParentIdByYear(carrier.getId().toString(),sb,carrierIdPrefix,resourceIdPrefix,year,orderCarrierLevelOne,resourceType,displayCarModerier);
				sb.append("</item>");  
			}

			if("2".equals(displayCarModerier)||"".equals(displayCarModerier)){
				sb.append("<item id='" +carrierIdPrefix
						+ carrier.getId().toString()
						+ "' im0=\"magazines_close.gif\" im1=\"magazines_open.gif\" im2=\"magazines_close.gif\" text=\""
								+ carrier.getCarrierName().toString() + "\">");
				sb.append("<userdata name=\"type\">2</userdata>");
				
				sb.append("<userdata name=\"carrierName\">"+ carrier.getCarrierName().toString() + "</userdata>");
				
				boolean orderCarrierLevelOne = false;
				
				if(isWithResourceSort && resourceType!=null && resourceType.intValue() !=999) orderCarrierLevelOne = true;
				
				if(log.isDebugEnabled()){
					System.out.println(">>>>>>>>>>>>>>>isWithResourceSort = " + isWithResourceSort);
					System.out.println(">>>>>>>>>>>>>>>resourceType = " + resourceType);
					System.out.println(">>>>>>>>>>>>>>>orderCarrierLevelOne = " + orderCarrierLevelOne);
				}
				resourceManager.getResourceItemsByCarrierIdByYear(sb,carrier.getId().toString(),resourceIdPrefix,year,orderCarrierLevelOne,resourceType,orgType); 	
				if(!orderCarrierLevelOne) getCarriersByParentIdByYear(carrier.getId().toString(),sb,carrierIdPrefix,resourceIdPrefix,year,orderCarrierLevelOne,resourceType,displayCarModerier);
				sb.append("</item>");  
			}

			
			
//			统计分析  displayCarModerier ＝ 3  
			if("3".equals(displayCarModerier)){
				
				boolean carEnable = carrier.getEnable().booleanValue();
				String car_id = carrier.getId().toString();
				if(fitterCarrier && !carIds.contains(car_id))  carEnable = false;

				
				if(carEnable){
					sb.append("<item id='" +carrierIdPrefix
							+ carrier.getId().toString()
							+ "' im0=\"magazines_close.gif\" im1=\"magazines_open.gif\" im2=\"magazines_close.gif\" text=\""
									+ carrier.getCarrierName().toString() + "\">");
					sb.append("<userdata name=\"type\">2</userdata>");
					
					sb.append("<userdata name=\"carrierName\">"+ carrier.getCarrierName().toString() + "</userdata>");
					
					boolean orderCarrierLevelOne = false;
					
					if(isWithResourceSort && resourceType!=null && resourceType.intValue() !=999) orderCarrierLevelOne = true;
					resourceManager.getResourceItemsByChannelIdByYear2( sb, carrier.getId().toString(),  resourceIdPrefix,  year, null,null,true,isFineRes) ;
//					resourceManager.getResourceItemsByCarrierIdByYear(sb,carrier.getId().toString(),resourceIdPrefix,year,orderCarrierLevelOne,resourceType); 	
					if(!orderCarrierLevelOne) getCarriersByParentIdByYear2(carrier.getId().toString(),sb,carrierIdPrefix,resourceIdPrefix,year,orderCarrierLevelOne,resourceType,enable,isFineRes);
					sb.append("</item>");  
				}

			}				

			
		}
		
	}
	private void getCarriersByParentIdByYear(String id, StringBuffer sb,String IdPrefix,String resourceIdPrefix,String year,boolean orderCarrierLevelOne,Integer resType,String displayCarModerier){
//		System.out.println("==============1222=========");
		Carrier carrier = new Carrier();
		
		carrier.setParentId(id);
		
		Iterator it = this.getCarriers(carrier).iterator();
		
		while (it.hasNext()) {
			Carrier carr = (Carrier) it.next();
			Integer carYear = carr.getVersion();
			
			
			if(carr.getOrgId() == null){
				System.out.println("error ==============error error error error error error========="+carr.getId()+"|"+carr.getCarrierName());
			}else{
				System.out.println("error ==============good good good good good good========="+carr.getId()+"|"+carr.getCarrierName());
			}

			
			String orgType = SysParamUtil.getOrgTypeById(carr.getOrgId());
			
//			String orgType = "1";
//			System.out.println("==============good good good good good good=========");
			
			if(year.equals(carYear.toString())){
				
				sb.append("<item id='" +IdPrefix
						+ carr.getId().toString()
						+ "' im0=\"magazines_close.gif\" im1=\"magazines_open.gif\" im2=\"magazines_close.gif\" text=\""
						+ carr.getCarrierName().toString() + "\">");
				sb.append("<userdata name=\"id\">" + carr.getId().toString()
						+ "</userdata>");
				sb.append("<userdata name=\"type\">2</userdata>");
				
				if("1".equals(displayCarModerier)){
					resourceManager.getResourceItemsByCarrierIdByYearTest(sb,carr.getId().toString(),resourceIdPrefix,year,orderCarrierLevelOne,resType,orgType,true);
				}else{
					resourceManager.getResourceItemsByCarrierIdByYear(sb,carr.getId().toString(),resourceIdPrefix,year,orderCarrierLevelOne,resType,orgType);
				}
				
				getCarriersByParentId(carr.getId().toString(), sb,IdPrefix,resourceIdPrefix);
		//		System.out.println("==============00000========="); 
				sb.append("</item>");  
			}

		}
	}
	private void getCarriersByParentIdByYear2(String id, StringBuffer sb,String IdPrefix,String resourceIdPrefix,String year,boolean orderCarrierLevelOne,Integer resType,boolean enable,boolean isFineRes){
//		System.out.println("==============1222=========");
		Carrier carrier = new Carrier();
		
		carrier.setParentId(id);
		
		Iterator it = this.getCarriers(carrier).iterator();
		
		while (it.hasNext()) {
			Carrier carr = (Carrier) it.next();
			Integer carYear = carr.getVersion();
			if(year.equals(carYear.toString())){
				
				sb.append("<item id='" +IdPrefix
						+ carr.getId().toString()
						+ "' im0=\"magazines_close.gif\" im1=\"magazines_open.gif\" im2=\"magazines_close.gif\" text=\""
						+ carr.getCarrierName().toString() + "\">");
				sb.append("<userdata name=\"id\">" + carr.getId().toString()
						+ "</userdata>");
				sb.append("<userdata name=\"type\">2</userdata>");
				
//				System.out.println("==============00000========="+ carr.getCarrierName()); 
				
				resourceManager.getResourceItemsByChannelIdByYear2( sb, carr.getId().toString(),  resourceIdPrefix,  year, null,null,enable,isFineRes) ;
				
				 getCarriersByParentId2(carr.getId().toString(), sb,IdPrefix,resourceIdPrefix, year, resType,enable,isFineRes);
		//		System.out.println("==============00000========="); 
				sb.append("</item>");  
			}

		}
	}
	
	
	private void getCarriersByParentId2(String id, StringBuffer sb,String IdPrefix,String resourceIdPrefix, String year, Integer resType,boolean enable,boolean isFineRes){
//		System.out.println("==============1222=========");
		Carrier carrier = new Carrier();
		
		carrier.setParentId(id);
		
		Iterator it = this.getCarriers(carrier).iterator();
		
		while (it.hasNext()) {
			
						
			Carrier carr = (Carrier) it.next();

			sb.append("<item id='" +IdPrefix
							+ carr.getId().toString()
							+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
							+ carr.getCarrierName().toString() + "\">");
			sb.append("<userdata name=\"id\">" + carr.getId().toString()
					+ "</userdata>");
			sb.append("<userdata name=\"type\">2</userdata>");
			
			resourceManager.getResourceItemsByChannelIdByYear2( sb, carr.getId().toString(),  resourceIdPrefix,  year, null,null,enable,isFineRes) ;
			
			getCarriersByParentId2(carr.getId().toString(), sb,IdPrefix,resourceIdPrefix,year,resType,enable,isFineRes);
//			System.out.println("==============00000=========");
			
			sb.append("</item>");
		}
	}
	
	private List oneCarrResListByCarrierId(Long carrId) {
		Map mp = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_RESOURCE_MAP);
		Object obj = mp.get(carrId);
		List ls  = new ArrayList();
		if(obj != null) ls = (List)obj;
		return ls;
	}	
	
	public List getOneCarrResourceiDListByCarrierId(Long carrierId,boolean isObj,String year) {
		List newList = new ArrayList();
		List newResIdList = new ArrayList();
		boolean channelPull = SysParamUtil.getChannelModelPara();
		List carrierIdList = this.getCarrierIdListsByYear(carrierId.toString(),channelPull,null,year);
//		System.out.println("carrierIdList size>>>>>>>>>>"+carrierIdList.size());
		
		for(Iterator it = carrierIdList.iterator();it.hasNext();){
			Long carid = (Long) it.next();
			List ls = oneCarrResListByCarrierId(carid);
			if(ls.size()> 0) CollectionUtils.addAll(newList,ls.iterator());
		}
		
//		System.out.println("newList size>>>>>>>>>>"+newList.size());
		
		if(newList.size()> 0){
			if(!isObj){
				Object[] objs = ConvertUtil.getColFromList(newList,"id");
				CollectionUtils.addAll(newResIdList,objs);
			}else{
				CollectionUtils.addAll(newResIdList,newList.iterator());
			}
		}
		
		return newResIdList;
	}	
	
	public List getOwnerCarrierIds(String carrierId,boolean channelPull,String theUser){
		List carrierIdList = new ArrayList();
		Map mp  = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_CARRIER_RELS);
		if("0".equals(carrierId)|| carrierId == null||"".equals(carrierId)){
			if(channelPull){
				if(theUser == null) theUser = UserUtil.getCurrentPrincipalUser();
				List newList = (List)mp.get(theUser);
				Object[] objs = ConvertUtil.getColFromList(newList,"id");
				CollectionUtils.addAll(carrierIdList,objs);
				if(carrierIdList.size() == 0 )carrierIdList.add("-1");
			}
			
		}else{
			carrierIdList.add(carrierId);
		}
		
		
		
//		for(Iterator it=carrierIdList.iterator();it.hasNext();){
//			String id = (String) it.next();
//			System.out.println(">>>>>>>>>>>>>>>>>>>>CarrierName"+id);
//		}
		return carrierIdList;
	}
	
	
	
	private List getOwnerCarrier(String carrierId,boolean channelPull,String theUser,boolean isObj){
		List carrierIdList = new ArrayList();
		Map mp  = new HashMap();
		
		if(isObj){
			mp  = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_CARRIER_RELS);
		}else{
			mp  = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_CARRIER_RELS_ID);
		}
	
		
		if("0".equals(carrierId)|| carrierId == null|| "".equals(carrierId)){
			if(channelPull){
				if(theUser == null) theUser = UserUtil.getCurrentPrincipalUser();
				List newList = new ArrayList();
				Object obj  = mp.get(theUser);
				if(obj != null) newList = (List)obj;
				
				CollectionUtils.addAll(carrierIdList,newList.iterator());
//				if(isObj){
//					CollectionUtils.addAll(carrierIdList,newList.iterator());
//				}else{
//					Object[] objs = ConvertUtil.getColFromList(newList,"id");
//					CollectionUtils.addAll(carrierIdList,objs);
//					
//					if(carrierIdList.size() == 0)carrierIdList.add("-1");
//				}
			}else{
				
				
			}
			
		}else{
			if(isObj){
				Map carrierMp = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIER_ALL_MAP);
				Object obj  = carrierMp.get(carrierId);
				if(obj != null){
					Carrier car = (Carrier)obj;
					carrierIdList.add(car);
				}
			    	
			}else{
				carrierIdList.add(carrierId);
			}
			
		}
		
		
		
//		for(Iterator it=carrierIdList.iterator();it.hasNext();){
//			String id = (String) it.next();
//			System.out.println(">>>>>>>>>>>>>>>>>>>>CarrierName"+id);
//		}
		return carrierIdList;
	}
	
	
	public List getCarrierIdListsByYear(String carrierId,boolean channelPull,String theUser,String year){
		List carrierIdList = new ArrayList();
		List ls = new ArrayList();
//		List ls2 = new ArrayList();
		Map carrierMp = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIER_CHILD);
		
		int yearQuery = Integer.parseInt(year);
		
		if(carrierId.equals("0")){
			Map mp  = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_CARRIER_RELS);
			if(theUser == null){
				theUser = UserUtil.getCurrentPrincipalUser();
			}
			List ls2 = (List)mp.get(theUser);
			for(Iterator it = ls2.iterator();it.hasNext();){
				Carrier carr = (Carrier) it.next();
				List newList = (List)carrierMp.get(carr.getId());
				CollectionUtils.addAll(ls,newList.iterator());
			}
				
		}else{
			
			ls = (List)carrierMp.get(Long.valueOf(carrierId));
		}
		
		
		for(Iterator it = ls.iterator();it.hasNext();){
				Carrier carr = (Carrier) it.next();
				int carrYear = carr.getVersion().intValue();
//				System.out.println(">>>CarrierName"+carr.getCarrierName()+ "carrYear>>>>>>>>>>"+carrYear);
				
				if(yearQuery == carrYear){
					carrierIdList.add(carr.getId());
				}
		}		
//        if(carrierIdList.size() == 0) carrierIdList.add("-1");
		return carrierIdList;
	
	}
	
	
//    public Map getCarrierNameMap() {
//    	Map mp = new HashMap();
//    	Map carrierMp = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIER_ALL_MAP);
//    	for(Iterator it = carrierMp.values().iterator();it.hasNext();){
//    		Carrier carr = (Carrier) it.next();
//    		
//    		System.out.println("getCarrierNameMap FTarget>>>>>>6666666666 77777777 88888888>>>>>>>>>>>>>"+carr.getCarrierName()); 
//    		
//    		mp.put(carr.getId().toString(),carr.getCarrierName());
//    	}
//    	return mp;
//    }
    
    
    public Map getCarrierNameMap() {
    	Map mp = new HashMap();
    	List carrierList = (List)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIER_ALL);
    	for(Iterator it = carrierList.iterator();it.hasNext();){
    		Carrier carr = (Carrier) it.next();
    		
    		System.out.println("getCarrierNameMap FTarget>>>>>>6666666666 77777777 88888888>>>>>>>>>>>>>"+carr.getCarrierName()); 
    		
    		mp.put(carr.getId().toString(),carr.getCarrierName());
    	}
    	return mp;
    }
    
    public Map getCarrierAlisNameMap() {
    	Map mp = new HashMap();
    	Map carrierMp = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIER_ALL_MAP);
    	for(Iterator it = carrierMp.values().iterator();it.hasNext();){
    		Carrier carr = (Carrier) it.next();
    		mp.put(carr.getId().toString(),carr.getAliasName());
    	}
    	return mp;
    }   
    
//    public Map getCarrierAlisNameMap() {
//    	Map mp = new HashMap();
//    	Map carrierMp = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIER_ALL_MAP);
//    	Map alisNameMp  = new HashMap();
//    	for(Iterator it = carrierMp.values().iterator();it.hasNext();){
//    		Carrier carr = (Carrier) it.next();
//    		if(carr.getNodeLevel().intValue() ==1){
//        		String alisName = carr.getAliasName();
//        		if(alisNameMp.containsKey(alisName)){
//        			List ls = (List)alisNameMp.get(alisNameMp);
//        			ls.add(carr.getId().toString());
//        			mp.put(alisName,ls);
//        		}else{
//        			List ls = new ArrayList();
//        			ls.add(carr.getId().toString());
//        			mp.put(alisName,ls);
//        		}
//            		
//    		}
//
//    	}
//    	return mp;
//    } 
    
    public String getCarrierTree(String theUser){
    	
    	System.out.println(">>>>>>>>>>>>>>>>>>>>theUser"+theUser);

		Map mp  = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_CARRIER_RELS);
		if(theUser == null){
			theUser = UserUtil.getCurrentPrincipalUser();
		}
		
		
		List ls2 = new ArrayList();
		//判断是否分频道
		if(SysParamUtil.getChannelModelPara()){
			ls2 = (List)mp.get(theUser);
		}else{
			ls2 = (List)getCarriersByTypeByCarrierTypeId(new Long(1));
		}
		
		
		StringBuffer sb = new StringBuffer("");
		sb.append("<?xml version=\"1.0\"?>");
		sb.append("<tree id=\"0\">");
		
		if(SysParamUtil.getIsUseCarrierProty()){
	    	MediaOrg mediaOrg = new MediaOrg();
	    	List medList = mediaOrgDao.getMediaOrgs(mediaOrg);
	    	sb.append("<item text=\"载体名称\" id=\"root\" open=\"1\" im0=\"books_close.gif\" im1=\"tombs.gif\" im2=\"tombs.gif\" call=\"1\" select=\"1\">");

			Iterator it = medList.iterator();
			while (it.hasNext()) {
				MediaOrg media = (MediaOrg) it.next();
				sb.append("<item id='" +"main"
						+ media.getId().toString()
						+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
						+ media.getName().toString() + "\">");
				sb.append("<userdata name=\"id\">" + media.getId().toString()
						+ "</userdata>");
				sb.append("<userdata name=\"type\">1</userdata>");

				for(Iterator it3 = ls2.iterator();it3.hasNext();){
					Carrier carr = (Carrier) it3.next();
					if(carr.getMediaOrgId().toString().equals(media.getId().toString())){
						sb.append("<item id='" +"sub"
								+ carr.getId().toString()
								+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
								+ carr.getCarrierName().toString() + "\">");
						sb.append("<userdata name=\"id\">" + carr.getId().toString()
								+ "</userdata>");
						sb.append("<userdata name=\"type\">2</userdata>");
						
						sb.append("</item>");  
					}
				}				

				

				sb.append("</item>");  
			}	
			
			sb.append("</item>");  
		}else{

			sb.append("<item text=\"载体名称\" id=\"root\" open=\"1\" im0=\"books_close.gif\" im1=\"tombs.gif\" im2=\"tombs.gif\" call=\"1\" select=\"1\">");


			for(Iterator it = ls2.iterator();it.hasNext();){
				Carrier carr = (Carrier) it.next();
				
				sb.append("<item id='" +"sub"
						+ carr.getId().toString()
						+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
						+ carr.getCarrierName().toString() + "\">");
				sb.append("<userdata name=\"id\">" + carr.getId().toString()
						+ "</userdata>");
				sb.append("<userdata name=\"type\">2</userdata>");
				
				sb.append("</item>");  

			}
			
			sb.append("</item>");
		}
  	

		
		sb.append("</tree>");
		
		return sb.toString();
    	
    }




	public Map getStoreMap(Carrier carr) {
		Map mpAlisName = new HashMap();
		Map mp = new HashMap();
		   Carrier carrierPar = new Carrier();
		   carrierPar.setParentId("0");
		   carrierPar.setOrgId(carr.getOrgId());
		   List ls = this.getCarriers(carrierPar);
		   
		   System.out.println("getCarrierAlisnames==============00000=======key==" + ls.size());
		   
//		   Iterator it = ls.iterator();
//		   while(it.hasNext()){
//		    	Carrier carr = (Carrier)it.next();
//		    	String id = carr.getId().toString();
//		    	String ids = CarrierUtil.getOtherSameAlisnameIds(id);
//		   }
		   
		   List lss = new ArrayList();
		   
			for(Iterator it = ls.iterator();it.hasNext();){
				Carrier carrier = (Carrier)it.next();
				String alisName = carrier.getAliasName();
				alisName = StringUtils.isEmpty(alisName)||alisName ==null?carrier.getCarrierName():alisName;
				if(mpAlisName.containsKey(alisName)){
					Carrier car = (Carrier)mpAlisName.get(alisName);
					String ids = car.getMemo()+","+carrier.getId().toString();
					car.setMemo(ids);
					car.setAliasName(alisName);
					mpAlisName.put(alisName,car);
				}else{
					String id = carrier.getId().toString();
					carrier.setMemo(id);
					carrier.setAliasName(alisName);
					mpAlisName.put(alisName,carrier);
				}
			}	
			
			Iterator itt = mpAlisName.keySet().iterator();
			while(itt.hasNext()){
				  String key = (String)itt.next(); 
				  Carrier carrier = (Carrier)mpAlisName.get(key);
//				  lss.add(carrier);
				  mp.put(carrier.getMemo(),key);
				  System.out.println("=======id======="+ carrier.getId().toString() +"=======key==" + carrier.getAliasName()+"=======value==" + carrier.getMemo());
				
			}

		   
		   return mp;
	}


	public List getCarrierWithChannel(Carrier carrier){
		
		   List ls =  dao.getCarrierWithChannel(carrier);
		   
		   List ls2 = new ArrayList();
		   Map mp = new HashMap();
		   
		   for(Iterator it = ls.iterator();it.hasNext();){
			   Carrier carr = (Carrier) it.next();
//			   System.out.println("=======id======="+carr.getResourceChannel().getId());
			   Long key = carr.getResourceChannel().getId();	   
			   if(!mp.containsKey(key)){
				   mp.put(key,key);
				   ls2.add(carr);
			   }
		   }

		   return ls2;
		   
	}
	
	
	public List getCarrierWithChannel2(Carrier carrier){
		
		
//		 System.out.println("=======1111111111111111111111111111111111111111111111111111111111======="+carrier.getEnable());
		 
//		  if(!carrier.getEnable().booleanValue()) carrier.setEnable(null);
		  
		  
		  if(!Boolean.valueOf(StringUtil.getNullValue(carrier.getEnable(),"0")).booleanValue())  carrier.setEnable(null);
		
		   List ls =  dao.getCarrierWithChannel(carrier);
			Collections.sort(ls,new CarrierComparator());
		   
//		   for(Iterator it = ls.iterator();it.hasNext();){
//			   Carrier carr = (Carrier) it.next();
//			   carr.setCarrierName(carr.getCarrierName()+StringUtil.getNullValue(carr.getResourceChannel().getName(),""));
//		   }

		  return ls;
		   
	}
	
	

//	public String getCarrierInfo(String orgId) {
//		// TODO Auto-generated method stub
//		 Map mp = new HashMap();
//		 mp.put("orgId",orgId);
//		 
//		 StringBuffer sb = new StringBuffer("");
//		 sb.append("<?xml version=\"1.0\"?>");
//		 sb.append("<Import>");
//		 List ls = dao.getCarrierInfo(mp);
//		 for(Iterator it = ls.iterator();it.hasNext();){
//				Carrier carr = (Carrier) it.next();
//				String id = carr.getId().toString();
//				String name = carr.getCarrierName();
//				String aliasName = carr.getAliasName();
//				
//				sb.append("<Carrier id=/" + id  +"/" +"  name=/" + name + "/"+"  aliasName=/" + aliasName + "/" + "</Carrier>");	
//		 }
//		 sb.append("</Import>");
//		 
//		return sb.toString();
//	}



	public Map getStoreMapCtr(Carrier carr) {
			String date = carr.getMemo();
		
		System.out.println("====== date     ======="+ carr.getMemo());
		
//			String date ="20130101";
		Map mp = new HashMap();
		String sql ="select distinct carrider_name  from tb_ctr_data where bro_date="+date +" order by id asc";
		ResultSet rs;
		try {
			rs = ServiceLocator.getDao().getDefaultDataSource().getConnection().createStatement().executeQuery(sql);
			int key = 1;
			while (rs.next()){
				 mp.put(rs.getString("carrider_name"),new Integer(key++));
			}
			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		   return mp;
	}
	
	public List getStoreObjsCtr(Carrier carr) {
		String date = carr.getMemo();
	
	System.out.println("====== date     ======="+ carr.getMemo());
	
//		String date ="20130101";
	List ls = new ArrayList();
	String sql ="select distinct carrider_name  from tb_ctr_data where bro_date="+date +" order by id asc";
	ResultSet rs;
	try {
		rs = ServiceLocator.getDao().getDefaultDataSource().getConnection().createStatement().executeQuery(sql);
		int key = 1;
		while (rs.next()){
			Carrier car = new Carrier();
			car.setId(new Long(key++));
			car.setCarrierName(rs.getString("carrider_name"));
			ls.add(car);
		}
		rs.close();

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

	   return ls;
}

}
