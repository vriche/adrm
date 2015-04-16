
package com.vriche.adrm.service.impl;


//import java.net.MalformedURLException;
//import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;

import com.dayang.adp.schema.admaterialentity._1_0.ADMaterialEntityType;
import com.dayang.adp.schema.adpserviceparametertype._0_1.CommonRequestType;
import com.dayang.adp.schema.adpserviceparametertype._0_1.CommonResponseType;
import com.dayang.adp.schema.adpserviceparametertype._0_1.ImportMaterialRequest;
import com.dayang.adp.schema.adpserviceparametertype._0_1.ImportMaterialRequestType;
import com.dayang.adp.schema.adpserviceparametertype._0_1.ImportMaterialResponse;
import com.dayang.adp.schema.adpserviceparametertype._0_1.MaterialServiceParameterResponseType;
import com.dayang.adp.service.importmaterialservice._0_1.ImportMaterialServiceCallbackHandler;
import com.dayang.adp.service.importmaterialservice._0_1.ImportMaterialServiceStub;
import com.dayang.adp.service.importmaterialservice._0_1.MyImportMaterialServiceCallbackHandler;
import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.Constants;
import com.vriche.adrm.dao.MatterDao;
import com.vriche.adrm.model.CMatter;
import com.vriche.adrm.model.Carrier;
import com.vriche.adrm.model.Customer;
import com.vriche.adrm.model.Industry;
import com.vriche.adrm.model.Matter;
import com.vriche.adrm.model.OrderDetail;
import com.vriche.adrm.model.ResourceChannel;
import com.vriche.adrm.service.MatterManager;
import com.vriche.adrm.service.SysSequenceManager;
import com.vriche.adrm.util.CarrierUtil;
import com.vriche.adrm.util.ConvertUtil;
import com.vriche.adrm.util.DateUtil;
import com.vriche.adrm.util.GetFirstLetter;
import com.vriche.adrm.util.StringUtil;
import com.vriche.adrm.util.SysParamUtil;

public class MatterManagerImpl extends BaseManager implements MatterManager {
    private MatterDao dao;
    private SysSequenceManager sysSequenceManager;
  
    
    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setMatterDao(MatterDao dao) {
        this.dao = dao;
    }

    /**
     * @see com.vriche.adrm.adver.service.MatterManager#getMattersByIdList(final Map idList)
     */
    public List getMattersByIdList(final Map idList) {
        return dao.getMattersByIdList(idList);
    }
    
 
   /**
     * @see com.vriche.adrm.adver.service.MatterManager#getMatters(com.vriche.adrm.adver.model.Matter)
     */
    public List getMatters(final Matter matter) {
    	List ls = dao.getMatters(matter);
    	if(log.isDebugEnabled()){
    		System.out.println("getMattersByCustomerIdAndLength getOrgId  "+matter.getOrgId());
    		System.out.println("getMattersByCustomerIdAndLength CustomerId  "+matter.getCustomerId());
    		System.out.println("getMattersByCustomerIdAndLength matterName   "+matter.getName());
    		System.out.println("getMattersByCustomerIdAndLength edit         "+matter.getEdit());
    		System.out.println("getMattersByCustomerIdAndLength length         "+matter.getLength());
    		System.out.println("getMattersByCustomerIdAndLength ls.size         "+ls.size());
    	}
    	
           return ls;
    }
    
    public List getMattersByOrderId(final Matter matter) {
    	List ls = dao.getMattersByOrderId(matter);
        return ls;
    }
       
    public List getStoreMatterEditByName(final Matter matter) {
    	List ls = dao.getStoreMatterEditByName(matter);
        return ls;
    }
    
    
    
    
    /**
     * @see com.vriche.adrm.adver.service.MatterManager#getMattersByCustomerIdAndLength(com.vriche.adrm.adver.model.Matter)
     */
    public List getMattersByCustomerIdAndLength(final Matter matter) {
//		System.out.println("getMattersByCustomerIdAndLength CustomerId  "+matter.getCustomerId());
//		System.out.println("getMattersByCustomerIdAndLength matterName   "+matter.getName());
//		System.out.println("getMattersByCustomerIdAndLength edit         "+matter.getEdit());
//		System.out.println("getMattersByCustomerIdAndLength length         "+matter.getLength());
    	boolean industryLevel2Param = SysParamUtil.getIndustryLevel2Param();
		List ls  = dao.getMattersByCustomerIdAndLength(matter);
		
		
//		System.out.println("getMattersByCustomerIdAndLength getOrgId  "+matter.getOrgId());
//		System.out.println("getMattersByCustomerIdAndLength CustomerId  "+matter.getCustomerId());
//		System.out.println("getMattersByCustomerIdAndLength matterName   "+matter.getName());
//		System.out.println("getMattersByCustomerIdAndLength edit         "+matter.getEdit());
//		System.out.println("getMattersByCustomerIdAndLength length         "+matter.getLength());
//		System.out.println("getMattersByCustomerIdAndLength ls.size         "+ls.size());
		
//		System.out.println("getMattersByCustomerIdAndLength size   "+ls.size());
		
			Iterator it = ls.iterator();
			 while(it.hasNext()){
				   CMatter mat = (CMatter) it.next();
				   mat.setName(StringUtil.encodeStringXML(mat.getName()));
				   mat.setEdit(StringUtil.encodeStringXML(mat.getEdit())); 
//				   System.out.println("getMattersByCustomerIdAndLength edit         "+mat.getEdit());
				   if(industryLevel2Param){
					    Industry industry = mat.getIndustry();
					    String name = industry.getName();
						String parentName = StringUtil.getNullValue(industry.getParentName(),"");
						if(!"".equals(parentName)) name = parentName +"/"+name;
						industry.setName(StringUtil.encodeStringXML(name));
				   }
				   
				   
					
					
			 }	
		

    	return ls;
    }
    
    public PaginatedList getMattersByDate(String beginDate,String startOrend, String pageIndex, String pageSize) {
    	Map mp = new HashMap();	
    	if(startOrend.equals("startDate")){
    		mp.put("startDate",beginDate);
    	}else{
    		mp.put("endDate",beginDate);
    	}
        return dao.getMattersByDate(mp,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
    }

    public String getMattersCountByDate(String beginDate,String startOrend) {
    	Map mp = new HashMap();
    	if(startOrend.equals("startDate")){
    		mp.put("startDate",beginDate);
    	}else{
    		mp.put("endDate",beginDate);
    	}
    	return dao.getMattersCountByDate(mp).toString();
    }
    
    public String getMattersCount(Matter matter) {
    	return dao.getMattersCount(matter).toString();
    }

	public PaginatedList getMattersPage(Matter matter, String pageIndex, String pageSize) {
		return dao.getMattersPage(matter,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}

	public Collection getMatterReport(Matter matter) {
		 return dao.getMatters(matter);
	}
	

    public String getMattersSerachCount(String orgId,String matterName,String customerName,String edit,Integer matterType) {
    	Map mp = new HashMap();
    	if(orgId!=null){
			mp.put("orgId",orgId);
		}   	
    	
    	if(matterType!=null){
			mp.put("matterType",matterType);
		}
		if(customerName!=null){
			mp.put("customerName",customerName);
		}
		if(matterName!=null){
			mp.put("name",matterName);
		}
		if(edit!=null){
			mp.put("edit",edit);
		}
		
    	return dao.getMattersNewsCount(mp).toString();
    }
	
	public List getMattersSerachPage(String orgId,String matterName,String customerName,String edit,Integer matterType, String pageIndex, String pageSize) {
//		System.out.println(matterType==null);
//		System.out.println("customerName  "+customerName);
//		System.out.println("matterName   "+matterName);
//		System.out.println("edit         "+edit);
//		System.out.println("pageIndex         "+pageIndex);
//		System.out.println("pageSize         "+pageSize);

		Map mp = new HashMap();
    	if(orgId!=null){
			mp.put("orgId",orgId);
		}   		
		
		if(matterType!=null){
			mp.put("matterType",matterType);
		}
		if(customerName!=null){
			mp.put("customerName",customerName);
		}
		if(matterName!=null){
			mp.put("name",matterName);
		}
		if(edit!=null){
			mp.put("edit",edit);
		}
		int skip = (Integer.parseInt(pageIndex)-1) * Integer.parseInt(pageSize);
		
		
//		List ls = dao.getMattersSearchPage(mp,skip,Integer.parseInt(pageSize));
		List ls = dao.getMattersNews(mp,skip,Integer.parseInt(pageSize));;
		
//		System.out.println("ls.size()         "+ls.size());
		
		return  ls;
	}
	
	/**
     * @see com.vriche.adrm.adver.service.MatterManager#getMatter(String id)
     */
    public Matter getMatter(final String id) {
        return dao.getMatter(new Long(id));
    }
    
    public Matter getMatterByTapCode(Matter matter) {
		boolean industryLevel2Param = SysParamUtil.getIndustryLevel2Param();
		if(industryLevel2Param){
			Matter mat =  dao.getMatterByTapCode(matter);
			Industry industry = mat.getIndustry();
			String name = industry.getName();
			String parentName = StringUtil.getNullValue(industry.getParentName(),"");
			if(!"".equals(parentName)) name = parentName +"/"+name;
			industry.setName(name);
			return mat;
		}else{
			return dao.getMatter(matter);
		}
		
	}
    
    public Matter getCheckMatter(Matter matter) {
		return dao.getMatter(matter);
	}
    
	public Matter getMatter(Matter matter) {
		return dao.getMatter(matter);
	} 
	
	public Matter getMatterByObj(Matter matter) {
		 getHelpCodeEdit(matter);
		return dao.getMatter(matter);
	} 
	
    /**
     * @see com.vriche.adrm.adver.service.MatterManager#saveMatter(Matter matter)
     */
    public String saveMatter(Matter matter) {
//        return dao.saveMatter(matter).toString();
    	
    	System.out.println("saveMatter matter:>>>>>>>>11111111111 333333333    55555555555 dfsdf>>" + matter.getBrandId2());
    	
    	return saveMatter(matter.getOrgId(),matter.getCustomerId(), matter.getTapeCode(), matter.getName(), matter.getEdit(), matter.getLength(),matter.getCreateBy(),matter.getMatterType(),matter.getMemo(),matter.getEnable().booleanValue(),matter.getBrandId(),matter.getSave2dayang(),matter.getBrandId2()).getId().toString();
    }
    
    
    public Matter saveMatter3(Matter matter) {
    	return saveMatter(matter.getOrgId(),matter.getCustomerId(), matter.getTapeCode(), matter.getName(), matter.getEdit(), matter.getLength(),matter.getCreateBy(),matter.getMatterType(),matter.getMemo(),matter.getEnable().booleanValue(),matter.getBrandId(),matter.getSave2dayang(),matter.getBrandId2());
  }
    
    public String saveMatter2(Matter matter) {
    	
    	return saveMatter(matter);
    }
    
    public String saveMatterForm(Matter matter) {
//      return dao.saveMatter(matter).toString();
  	return saveFiter(matter).toString();
  }
    
  private Long saveFiter(Matter matter){
	  String rep ="\n\r\t";
	  String name = matter.getName();
	  String edit = matter.getEdit();
	  String length = matter.getLength();
	  String tapeCode = matter.getTapeCode().toUpperCase();
//	  StringUtil.getResourceName(name); StringUtil.getResourceName(name)
//	  matter.setName(StringUtil.getResourceName(name));
//	  matter.setEdit(StringUtil.String2kenizer(edit,rep));
	  
//	  name = StringUtil.getResourceName(name);
//	  edit = StringUtil.getResourceName(edit);
	  
	  System.out.println("fiter 7777777777777777777777777777777777:>>>>>>>>>>" +StringUtil.getResourceName(edit));
	  
	  matter.setName(StringUtil.String2kenizer(name,rep));
	  matter.setEdit(StringUtil.String2kenizer(edit,rep));
	  matter.setLength(StringUtil.String2kenizer(length,rep));
	  matter.setTapeCode(StringUtil.String2kenizer(tapeCode,rep));
	  getHelpCodeEdit(matter);
	  
	  if(matter.getBrandId2() == null) matter.setBrandId2(new Long(0));
	  
		Matter obj = new Matter();
		ConvertUtil.copyBeanProperties2(obj,matter);
   
		
	  boolean isNew =  matter.getId() == null;   
	  
	  Long id = dao.saveMatter(matter);
	  
	  
	  int importOption = isNew?1:2;
	  matter.setId(id);
	  
	  obj.setId(id);
	  saveDayangMatter(obj,importOption);
	  
	 return id;
} 
  
  private Matter fiter(Matter matter){
	  String rep ="\n\r\t";
	  String name = matter.getName();
	  String version = matter.getEdit();
	  String length = matter.getLength();
//	  System.out.println("fiter 7777777777777777777777777777777777:>>>>>>>>>>" + matter.getTapeCode());
	  String tapeCode = matter.getTapeCode().toUpperCase();

	  matter.setName(StringUtil.String2kenizer(name,rep));
	  matter.setEdit(StringUtil.String2kenizer(version,rep));
	  matter.setLength(StringUtil.String2kenizer(length,rep));
	  matter.setTapeCode(StringUtil.String2kenizer(tapeCode,rep));
	  
	 return matter;
} 

//    private Long save(Matter matter){
//    	 return dao.saveMatter(matter);
//    	 return saveMatter(matter.getCustomerId(), matter.getTapeCode(), matter.getName(), matter.getEdit(), matter.getLength(),matter.getCreateBy());
//    }

    /**
     * @see com.vriche.adrm.adver.service.MatterManager#removeMatter(String id)
     */
    public void removeMatter(final String id) {
        dao.removeMatter(new Long(id));
        
        Matter matter = new Matter();
        matter.setId(new Long(id));
        saveDayangMatter(matter,3);
        
    }

     /**
     * @see com.vriche.adrm.adver.service.MatterManager#removeMatters(String Map)
     */
    public void removeMatters(final Map idList) {
        dao.removeMatters(idList);
    }

	public String getMatterXML(Matter matter, String IdPrefix) {
		StringBuffer sb = new StringBuffer("");
		sb.append("<?xml version=\"1.0\"?>");
		sb.append("<tree id=\"0\">");
		sb.append("<item text=\"素材信息\" id=\"root\" open=\"1\" im0=\"books_close.gif\" im1=\"tombs.gif\" im2=\"tombs.gif\" call=\"1\" select=\"1\">");
		sb.append("<userdata name=\"id\">0</userdata>");
		sb.append("<userdata name=\"type\">0</userdata>");
//		   System.out.println("matter.getMatterType()<<<<>>>>>>>>>>" + this.getMatters(matter).size());
		getMattersByAdvMatterType(matter.getMatterType(),sb,IdPrefix);
		sb.append("</item>");
		sb.append("</tree>");
//		System.out.println("getMatterXML:>>>>>>>>>>" + sb.toString());
		return sb.toString();
	}
	
	
	
	public String getMatterNameXML(Matter matter) {
		StringBuffer sb = new StringBuffer("");
		sb.append("<?xml version=\"1.0\"?>");
		sb.append("<tree id=\"0\">");
		sb.append("<item text=\"品牌信息\" id=\"root\" open=\"1\" im0=\"books_close.gif\" im1=\"tombs.gif\" im2=\"tombs.gif\" call=\"1\" select=\"1\">");
		sb.append("<userdata name=\"id\">0</userdata>");
		sb.append("<userdata name=\"type\">0</userdata>");
		Iterator it = this.getMattersByResCut(matter).iterator();
		int i = 1;
		 while(it.hasNext()){
			 Matter mat = (Matter) it.next();
			  sb.append("<item id='" + i + "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
						+ mat.getName().toString()+ "\">");
			  sb.append("</item>");		
		 }
		  
		sb.append("</item>");
		sb.append("</tree>");

		return sb.toString();
	}
	
	
	public List getMatterNamesStore(Matter matter) {
		return this.getMattersByResCut(matter);
	}
	
	
	
	
	
	

	public void getMattersByAdvMatterType(Integer advType,StringBuffer sb,String IdPrefix){
	   Matter matter = new Matter();
	   matter.setMatterType(advType);
	   Iterator it = this.getMatters(matter).iterator();
//	   System.out.println("this.getMatters(matter):>>>>>>>>>>" + this.getMatters(matter).size());
	   while(it.hasNext()){
		   Matter mat = (Matter) it.next();
		   Object obj = mat.getEnable();
		   boolean isEnable = obj==null?false:mat.getEnable().booleanValue();
		   
//		   System.out.println("this.getMatters(matter):>>>>>>>>>>" + mat.getEdit());
		   if(isEnable){
			 String adName =  StringUtil.encodeStringXML(StringUtil.getResourceName(mat.getName()));
			 String edit =  StringUtil.encodeStringXML( StringUtil.getResourceName(mat.getEdit()));
		     String name =  "["+ adName +"] "+ edit;
		 
		     
//		      name =  "&lt;/wrer/&gt;";
//		     name =  StringUtil.getResourceName(name);
	
//		     name = "\\〈"+  " wrer&quot;";
//		     name = "wrer";
//		     name = "/*"+ name +"*/";
//		     System.out.println("this.getMatters(matter):>>>>>>>>>>" + name);
			   sb.append("<item id='" +IdPrefix
						+ mat.getId().toString()
//						+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\"/*"
//						+ "["+ mat.getName().toString() +"] "+ mat.getEdit()+ "*/\">"); tooltip
			   
				+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" tooltip=\"\"  text=\""+ name + "\">");
//			   + "["+ mat.getEdit().toString() +"]\">"); 
			   
			    sb.append("<userdata name=\"type\">2</userdata>");
				sb.append("<userdata name=\"id\">" + mat.getId().toString()+ "</userdata>");
				sb.append("<userdata name=\"publishSort\">0</userdata>");
				sb.append("<userdata name=\"tapeCode\">" + mat.getTapeCode()+ "</userdata>");
				sb.append("<userdata name=\"matterName\">" + adName+ "</userdata>");
				sb.append("<userdata name=\"matterEdit\">" + edit + "</userdata>");	
				sb.append("<userdata name=\"matterLength\">" + mat.getLength()+ "</userdata>");	
//				sb.append("<userdata name=\"matterType\">" + mat.getMatterType()+ "</userdata>");	
				
				sb.append("<userdata name=\"specificName\"></userdata>");	
				sb.append("<userdata name=\"publishMemo\"></userdata>");	
				sb.append("<userdata name=\"specificValue\"></userdata>");	
				sb.append("<userdata name=\"orderDayId\">0</userdata>");	
				sb.append("<userdata name=\"resourceId\"></userdata>");	

				sb.append("<userdata name=\"customerName\">" + mat.getCustomer().getCustomerName()+ "</userdata>");
				sb.append("<userdata name=\"ownerUserName\"></userdata>");
				sb.append("<userdata name=\"id\">0</userdata>");	
				sb.append("<userdata name=\"isArranged\">0</userdata>");	
				sb.append("<userdata name=\"isLocked\">false</userdata>");	
				
				
//				getMattersByAdvMatterType(mat.getMatterType(), sb,IdPrefix);
				sb.append("</item>");	   
			   
		   }
		 
	   }
   }

public List getAllMatters(Matter matter) {
	String name = matter.getName();	
	return dao.getAllMatters(name);
}

public void setSysSequenceManager(SysSequenceManager sysSequenceManager) {
	this.sysSequenceManager = sysSequenceManager;
}





public Matter saveMatterTest(OrderDetail orderDetail) {
	Matter matterTest = orderDetail.getMatter();
	Long matterId = new Long(0);  
	Long customerId = matterTest.getCustomerId();
	String tapeCode = matterTest.getTapeCode();
	String name =matterTest.getName();
	String edit =matterTest.getEdit();
	String length = matterTest.getLength();
	Long createBy = matterTest.getCreateBy();
	Integer type =matterTest.getMatterType();
	String meno =matterTest.getMemo();
	Long industryType = matterTest.getBrandId();
	Long orgId = matterTest.getOrgId();
	Long brandId = matterTest.getBrandId2();
	
	if(orgId == null ) orgId = new Long(1);
	
	
	System.out.println(" eee tt >>>>>>>>>>>tttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt>>>brandId>>>>>>"+brandId);
	
	
	
//	System.out.println(">>>>>>>>>>>orderDetail.getIsNotInSeries().booleanValue()>>>>>>>>>"+orderDetail.getIsNotInSeries());
	
	boolean isNew =false;
	if(orderDetail.getIsNotInSeries()==null||orderDetail.getIsNotInSeries().booleanValue()){
//		System.out.println(">>>>>>>>>>>tttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt>>>111111111111111>>>>>>"+industryType);
		matterTest = this.getMatterOrg(orgId,name,edit,length,industryType,brandId);  
//		System.out.println(">>>>>>>>>>>tttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt>>>2222222222>>>>>>"+matterTest.getBrandId());
		isNew =  matterTest.getId() == null;   
	}
	
//	Matter matter = this.getMatter(name,edit,length);    

	                   
	int importOption = (isNew)?1:2;
	if(isNew){
		Matter newMatter = getNewMatterOrg(orgId, customerId, tapeCode,name,edit,length,createBy,type,meno,industryType,brandId);
		getHelpCodeEdit(newMatter);
		newMatter = fiter(newMatter);
		
		
		if(newMatter.getBrandId2() == null) newMatter.setBrandId2(new Long(0));
		
		Matter obj = new Matter();
		ConvertUtil.copyBeanProperties2(obj,newMatter);
		
		
		System.out.println(" eee tt getBrandId2 >>>>>>>>>>>tttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt>>>brandId>>>>>>"+newMatter.getBrandId2());

		matterId = dao.saveMatter(newMatter); 

		obj.setId(matterId);
		saveDayangMatter(obj,importOption);
		
	}else{
		matterTest.setOrgId(orgId);
		matterTest.setModifyBy(createBy);
		matterTest.setModifyDate(new Date());
		matterTest = fiter(matterTest);
		tapeCode = matterTest.getTapeCode().toUpperCase();         
		String rep ="\n\r\t";
		tapeCode = StringUtil.String2kenizer(tapeCode,rep);
		if("".endsWith(matterTest.getTapeCode()) || matterTest.getTapeCode().equals(null)){
			if(tapeCode !="") matterTest.setTapeCode(tapeCode);
		}
//		System.out.println(">>>>>>>>>>>tttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt>>>33333>>>>>>"+matterTest.getBrandId());
		
		getHelpCodeEdit(matterTest);
		
		if(matterTest.getBrandId2() == null) matterTest.setBrandId2(new Long(0));
		
		Matter obj = new Matter();
		ConvertUtil.copyBeanProperties2(obj,matterTest);
//		obj.setId(matterId);
//		saveDayangMatter(obj,importOption);	
		
		
//		System.out.println("1111 >>>>>>>>>>>tttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt>>>getBrandId2>>>>>>"+matterTest.getBrandId2());
		
		matterId = dao.saveMatter(matterTest);
//		System.out.println("2222  >>>>>>>>>>>tttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt>>>getBrandId2>>>>>>"+matterTest.getBrandId2());
		
		
		obj.setId(matterId);
		saveDayangMatter(obj,importOption);	
		
//		System.out.println(">>>>>>>>>>>matterId>>>>>>>>>"+matterId);
	
	}
	
	
	


	
	orderDetail.setMatterId(matterId);
//	matterTest.setId(matterId);
//	matterTest.setTapeCode(matterTest.getTapeCode());
	return matterTest;
}



//没有传递组织编号
public Matter saveMatter(Long customerId, String tapeCode, String name, String edit, String length,Long createBy,Integer type,String meno,boolean enable,Long industryType,Long brandId) {
	Long matterId = new Long(0);
	Long orgId = new Long(1);
	 
//	System.out.println(">>>>>>>>>>>name>>>>>>>>>"+name);
//	System.out.println(">>>>>>>>>>>version>>>>>>>>>"+edit);
//	System.out.println(">>>>>>>>>>>length>>>>>>>>>"+length);
	
	Matter matter = this.getMatterOrg(orgId,name,edit,length,industryType,brandId);
	
//	System.out.println(">>>>>>>>>>>getMatter >>>>>>>>>"+matter);
	
	boolean isNew =  matter.getId() == null ?true:false;
	
//	System.out.println(">>>>>>>>>>>isNew >>>>>>>>>"+isNew);
	int importOption = (isNew)?1:2;
	
	if(isNew){
		matter = getNewMatterOrg(orgId, customerId, tapeCode,name,edit,length,createBy,type,meno,industryType,brandId);
		
//		System.out.println(">>>>>>>>>>>isNew 2>>>>>>>>>"+matter.getTapeCode());
		
		matter.setEnable(new Boolean(true));       
//		matterId = dao.saveMatter(newMatter);
		
//		matterId = dao.saveMatter(fiter(matter));
		matter.setCreateDate(new Date());
		matter.setModifyDate(new Date());
		
		getHelpCodeEdit(matter);
		
		if(matter.getBrandId2() == null) matter.setBrandId2(new Long(0));
		
		Matter obj = new Matter();
		ConvertUtil.copyBeanProperties2(obj,matter);
		
		matterId = dao.saveMatter(fiter(matter));
		matter.setId(matterId);
		
		obj.setId(matterId);
		saveDayangMatter(obj,importOption);	
		
//		matterId = this.saveFiter(newMatter);
	}else{
		matter.setOrgId(orgId);
		matter.setModifyBy(createBy);
		matter.setModifyDate(new Date());
//		matterId = dao.saveMatter(matter);
		matter = fiter(matter);
		matter.setEnable(new Boolean(enable));
		matter.setMatterType(type);     
		
		String rep ="\n\r\t";
		tapeCode = StringUtil.String2kenizer(matter.getTapeCode(),rep);
		if("".endsWith(matter.getTapeCode()) || matter.getTapeCode().equals(null)){
			if(tapeCode !="") matter.setTapeCode(tapeCode);
		}
		
		getHelpCodeEdit(matter);
		
		if(matter.getBrandId2() == null) matter.setBrandId2(new Long(0));
		
		Matter obj = new Matter();
		ConvertUtil.copyBeanProperties2(obj,matter);
//		obj.setId(matterId);
//		saveDayangMatter(obj,importOption);	
		
		matterId = dao.saveMatter(matter);
		matter.setId(matterId);
		
		obj.setId(matterId);
		saveDayangMatter(obj,importOption);	
	}
	

	
	
	return matter;
}

public Matter saveMatter(Long orgId,Long customerId, String tapeCode, String name, String edit, String length,Long createBy,Integer type,String meno,boolean enable,Long industryType,String save2dayang,Long brandId) {
	Long matterId = new Long(0);
//	Long orgId = new Long(1);
	 
//	System.out.println(">>>>>>>>>>>name>>>>>>>>>"+name);
//	System.out.println(">>>>>>>>>>>version>>>>>>>>>"+edit);
//	System.out.println(">>>>>>>>>>>length>>>>>>>>>"+length);
	
	Matter matter = this.getMatterOrg(orgId,name,edit,length, industryType,brandId);
	
//	System.out.println(">>>>>>>>>>>getMatter >>>>>>>>>"+matter);
	

	
	boolean isNew =  matter.getId() == null ?true:false;
	
	int importOption = (isNew)?1:2;
	

	
//	System.out.println(">>>>>>>>>>>isNew >>>>>>>>>"+isNew);
	
	if(isNew){
//		System.out.println(">>>>>>>>>>>isNew 1>>>>>>>>>"+isNew);
		
		
//		System.out.println(">>>>>>>>>>>orgId>>>>>>>>>"+orgId);
//		System.out.println(">>>>>>>>>>>customerId>>>>>>>>>"+customerId);
//		System.out.println(">>>>>>>>>>>tapeCode>>>>>>>>>"+tapeCode);	
//		System.out.println(">>>>>>>>>>>name>>>>>>>>>"+name);
//		System.out.println(">>>>>>>>>>>length>>>>>>>>>"+length);
//		System.out.println(">>>>>>>>>>>createBy>>>>>>>>>"+createBy);
//		System.out.println(">>>>>>>>>>>type>>>>>>>>>"+type);
//		System.out.println(">>>>>>>>>>>meno>>>>>>>>>"+meno);
//		System.out.println(">>>>>>>>>>>industryType>>>>>>>>>"+industryType);
		
		
		
		matter = getNewMatterOrg(orgId, customerId, tapeCode,name,edit,length,createBy,type,meno,industryType,brandId);
		
//		System.out.println(">>>>>>>>>>>isNew 2>>>>>>>>>"+matter.getTapeCode());
		
		matter.setEnable(new Boolean(true));       
//		matterId = dao.saveMatter(newMatter);
		
//		matterId = dao.saveMatter(fiter(matter));
		matter.setCreateDate(new Date());
		matter.setModifyDate(new Date());
		
		getHelpCodeEdit(matter);
		 matter = fiter(matter);
		 
		 
			Matter obj = new Matter();
			ConvertUtil.copyBeanProperties2(obj,matter);
			
		if(matter.getBrandId2() == null) matter.setBrandId2(new Long(0));
		
//		System.out.println(">>>>>>>>>+matter.getBrandId2 1111111111 333333333    55555555555 >>>>>>>"+matter.getBrandId2());
		
		matterId = dao.saveMatter(matter);
		matter.setId(matterId);
		
		obj.setId(matterId);
		obj.setSave2dayang(save2dayang);
		saveDayangMatter(obj,importOption);	
		
//		matterId = this.saveFiter(newMatter);
	}else{
		matter.setOrgId(orgId);
		matter.setModifyBy(createBy);
		matter.setModifyDate(new Date());
//		matterId = dao.saveMatter(matter);
		matter = fiter(matter);
		matter.setEnable(new Boolean(enable));
		matter.setMatterType(type); 
		matter.setCustomerId(customerId);
		
		String rep ="\n\r\t";
		tapeCode = StringUtil.String2kenizer(matter.getTapeCode(),rep);
		if("".endsWith(matter.getTapeCode()) || matter.getTapeCode().equals(null)){
			if(tapeCode !="") matter.setTapeCode(tapeCode);
		}
		
		getHelpCodeEdit(matter);
		
		if(matter.getBrandId2() == null) matter.setBrandId2(new Long(0));
		
//		System.out.println(">>>>>>>>>>>orgId>>>>>>>>>"+orgId);
//		System.out.println(">>>>>>>>>>>customerId>>>>>>>>>"+customerId);
//		System.out.println(">>>>>>>>>>>tapeCode>>>>>>>>>"+tapeCode);	
//		System.out.println(">>>>>>>>>>>name>>>>>>>>>"+name);
//		System.out.println(">>>>>>>>>>>length>>>>>>>>>"+length);
//		System.out.println(">>>>>>>>>>>createBy>>>>>>>>>"+createBy);
//		System.out.println(">>>>>>>>>>>type>>>>>>>>>"+type);
//		System.out.println(">>>>>>>>>>>meno>>>>>>>>>"+meno);
		
		
		
		
		
		Matter obj = new Matter();
		ConvertUtil.copyBeanProperties2(obj,matter);
		
		System.out.println(">>>>>>>>11111111111 666          7777 >>>(matter.getBrandId2()>>>>>>>>>"+matter.getBrandId2());		

		matterId = dao.saveMatter(matter);
		matter.setId(matterId);
		
		obj.setId(matterId);
		obj.setSave2dayang(save2dayang);
		saveDayangMatter(obj,importOption);
	}
	
	
	 
 
	

	return matter;
}


private String getHelpCodeEdit(Matter matter){
	String rep ="\n\r\t";
	
	String edit =  matter.getEdit();
	edit = StringUtil.String2kenizer(edit,rep);
	String helpCodeEdit = GetFirstLetter.getFirstLetter(edit);
	
	String name =  matter.getName();
	edit = StringUtil.String2kenizer(name,rep);
	String helpCodeName = GetFirstLetter.getFirstLetter(name);
	
	matter.setHelpCodeName(helpCodeName);	
	matter.setHelpCodeEdit(helpCodeEdit);
	return "";
}



//private Matter getMatter(String name, String eidt, String length){
//	Matter matterPar = new Matter();
//	matterPar.setName(name);
//	matterPar.setEdit(eidt);
//	matterPar.setLength(length);
//	Matter matter =  dao.getMatter(matterPar);
////	System.out.println(">>>>>>>>>>>length2>>>>>>>>>"+length);
//	return matter;
//}

private Matter getMatterOrg(Long orgId,String name, String eidt, String length,Long industryType,Long brandId){
	Matter matterPar = new Matter();
	matterPar.setOrgId(orgId);
	matterPar.setName(name);
	matterPar.setEdit(eidt);
	matterPar.setLength(length);
	Matter matter =  dao.getMatter(matterPar);
	matter.setBrandId(industryType);
	matter.setBrandId2(brandId);
	if( matter == null) matter = new Matter();
//	System.out.println(">>>>>>>>>>>length2>>>>>>>>>"+length);
	return matter;
}

//private Matter getNewMatter(Long customerId,String tapeCode, String name, String version, String length,Long createBy,Integer type,String meno,Long industryType){
//	Matter matter = new Matter();
//	
//	matter.setId(null);
//	matter.setName(name);
//	matter.setEdit(version);
//	matter.setLength(length);
//	matter.setCustomerId(customerId);
//	matter.setCreateDate(new Date());
//	matter.setCreateBy(createBy);
//	matter.setMatterType(type);
//	matter.setMemo(meno);
//	matter.setEnable(new Boolean(true));
//	matter.setBrandId(industryType);
//	
//	
//	//设置磁带编号 0 表示手动 1自动
//
//	boolean isAuto = SysParamUtil.isAutoTapeCode();
//	if(isAuto){
//		String newCode = sysSequenceManager.getSysSequenceByObject(Constants.SEQUENCE_TB_ADVER_MATTER);
//    	matter.setTapeCode(newCode);
//	}else{
//		matter.setTapeCode(tapeCode);
//	}
//	
//	
//	return matter;
//}

private Matter getNewMatterOrg(Long orgId,Long customerId,String tapeCode, String name, String version, String length,Long createBy,Integer type,String meno,Long industryType,Long brandId){
	Matter matter = new Matter();
	
	matter.setId(null);
	matter.setName(name);
	matter.setEdit(version);
	matter.setLength(length);
	matter.setCustomerId(customerId);
	matter.setCreateDate(new Date());
	matter.setCreateBy(createBy);
	matter.setMatterType(type);
	matter.setMemo(meno);
	matter.setEnable(new Boolean(true));
	matter.setBrandId(industryType);
	matter.setBrandId2(brandId);
	matter.setOrgId(orgId);
	

	
	//设置磁带编号 0 表示手动 1自动

	boolean isAuto = SysParamUtil.isAutoTapeCode();
	if(isAuto){
		log.info("getNewMatterOrg isAuto>>>>>>>>>>>>"+ isAuto);
	
		String newCode = sysSequenceManager.getSysSequenceByObject(orgId.toString(),Constants.SEQUENCE_TB_ADVER_MATTER);
    	matter.setTapeCode(newCode);
    	log.info("getNewMatterOrg newCode>>>>>>>>>>>>"+ newCode);
//    	if(log.isDebugEnabled()){
//    		log.info("getNewMatterOrg isAuto>>>>>>>>>>>>"+ isAuto);
//    		log.info("getNewMatterOrg newCode>>>>>>>>>>>>"+ newCode);
//    	}
	}else{
		matter.setTapeCode(tapeCode);
	}
	
	
	return matter;	
}

public List getMattersDIV(Matter matter) {
	System.out.println("CustomerId  "+matter.getCustomerId());
	System.out.println("matterName   "+matter.getName());
	System.out.println("edit         "+matter.getEdit());
	System.out.println("length         "+matter.getLength());
//	System.out.println(">>>>>>>>>>>matter>>>>>>>>>"+matter);
	List ls = dao.getMattersDIV(matter);

	Iterator it = ls.iterator();
	 while(it.hasNext()){
		   Matter mat = (Matter) it.next();
		   mat.setName(StringUtil.encodeStringXML(mat.getName()));
		   mat.setEdit(StringUtil.encodeStringXML(mat.getEdit())); 	
	 }	

	return ls;
}

public List getMattersByResCut(Matter matter) {
	Map mp = new HashMap();
	List carrierIdList = new ArrayList();
	List resourceIdList = new ArrayList();
	List customerIdList = new ArrayList();
	List userIdList = new ArrayList();
	String matterName = matter.getName();
	Integer version = matter.getVersion();
	String loginUser = matter.getLoginUser();
	
	String rstring = org.apache.commons.lang.StringUtils.join(matter.getCarrierIds(),",");
	
	
	
	carrierIdList = CarrierUtil.getCarrierIds(rstring,"2",loginUser);	
	
	
	CollectionUtils.addAll(resourceIdList,matter.getResourceIds());
	CollectionUtils.addAll(customerIdList,matter.getCustomerIds());
	CollectionUtils.addAll(userIdList,matter.getUserIds());
	
//	org.apache.commons.lang.StringUtils.join(ls.toArray(),",");
	
	mp.put("carrierIdList",carrierIdList);
	mp.put("resourceIdList",resourceIdList);
	mp.put("customerIdList",customerIdList);
	mp.put("userIdList",userIdList);
	mp.put("matterName",matterName);
	mp.put("version",version);
	mp.put("orgId",matter.getOrgId());
	
	List ls = dao.getMattersByResCut(mp);


	System.out.println("getMattersByResCut<<<<<<<11111111111vvvvvvv carrierIdList vvvvvvvv11<<<<<<<<<<"+carrierIdList.size());
	System.out.println("getMattersByResCut<<<<<<<11111111111vvvvvvvvv  resourceIdList tvvvvvvvvv11<<<<<<<<<<"+resourceIdList.size());
	System.out.println("getMattersByResCut<<<<<<<11111111111vvvvvvvvc customerIdList vvvvvvv11<<<<<<<<<<"+customerIdList.size());
	System.out.println("getMattersByResCut<<<<<<<11111111111vvvvuserIdListvvvvvvvvvvv11<<<<<<<<<<"+userIdList);
	System.out.println("getMattersByResCut<<<<<<<11111111111vmatterName vvvvvvvvvvvv11<<<<<<<<<<"+matterName);
	System.out.println("getMattersByResCut<<<<<<<11111111111vvvvvversion vvvvvvvvvvvvv11<<<<<<<<<<"+version);
	System.out.println("getMattersByResCut<<<<<<<1111111111vvvvv getOrgId vvvvvvvvvvvvvvv11<<<<<<<<<<"+matter.getOrgId());
	System.out.println("getMattersByResCut<<<<<<<11111111111vvvvvvvvvvvvvv11<<<<<<<<<<"+ls.size());
	return ls;
}


public String getMattersListXML(Matter matter) {

//	List all = dao.getMattersListPage(matter);
	List all = dao.getMattersByCustomer(matter);
	
//	System.out.println("all<<<<<<<1111111111111<<<<<<<<<<"+all.size());
	StringBuffer sb  = new StringBuffer();
	sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
	sb.append("<rows>");  

	for(Iterator it = all.iterator();it.hasNext();){
		CMatter LMan = (CMatter) it.next();
		String edits = LMan.getEdit()==null?"":LMan.getEdit();
		sb.append("<row  id=\""+ LMan.getId()  +"\">");
		
		sb.append("<cell><![CDATA["+ LMan.getName() +"]]></cell>");
		sb.append("<cell><![CDATA["+ StringUtil.encodeStringXML(edits) +"]]></cell>");
		sb.append("<cell><![CDATA["+ LMan.getLength() +"]]></cell>");
		sb.append("<cell><![CDATA["+ LMan.getTapeCode()  +"]]></cell>");
		
		sb.append("</row>");
	 }
	
	sb.append("</rows>");
	
	return sb.toString();
}
public Map getMatterName(Matter matter){
	Map mp=new HashMap();
	List ls=getMattersDIV(matter);
	for(Iterator it=ls.iterator();it.hasNext();){
		Matter matters=(Matter)it.next();
		mp.put(matters.getName(),matters.getName());
	}
	return mp;
}
public Map getMatterEditOrLength(Matter matter){
	Map mp=new HashMap();
	List ls=getMatters(matter);
	if(matter.getEdit()==null){
		for(Iterator it=ls.iterator();it.hasNext();){
			Matter matters=(Matter)it.next();
			mp.put(matters.getEdit(),matters.getEdit());
		}
	}else{
		for(Iterator it=ls.iterator();it.hasNext();){
			Matter matters=(Matter)it.next();
			mp.put(matters.getLength(),matters.getLength());
		}
	}
	return mp;
}

public Map getStoreMatterLengthByName(Matter matter){
	Map mp=new HashMap();
	List ls= dao.getStoreMatterLengthByName(matter);
		for(Iterator it=ls.iterator();it.hasNext();){
			String length=(String)it.next();
//			log.info("getMatters>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>end"+matters.getLength());
			mp.put(length,length);
		}
	return mp;
}

public List getMattersNamesStore(final Matter matter) {
    return dao.getMattersNames(matter);
}
public List getMattersEditsByHelpCodeStore(final Matter matter) {
	 return dao.getMattersEditsByHelpCode(matter);
}
public List getMattersNews(String strQueryString) {
	 Map mp =  this.buildParamBy(strQueryString);
	 int pageIndex =  Integer.parseInt(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"posStart"),"0"));
	 int pageSize =  Integer.parseInt(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"count"),"30"));	
	 return dao.getMattersNews(mp,pageIndex,pageSize);
}

public String getMattersNewsPageXML(String strQueryString) {	

	
	boolean industryLevel2Param = SysParamUtil.getIndustryLevel2Param();
	
    Map mp =  this.buildParamBy(strQueryString);
	int posStart =  Integer.parseInt(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"posStart"),"0"));
    int count =  Integer.parseInt(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"count"),"30"));	
//    int total_count = Integer.parseInt(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"total_count"),"0")) ;
    int total_count = dao.getMattersNewsCount(mp).intValue();
    int i = 1;

//	System.out.println("getContractPaymentsPageXML>>>>>>>>>>>>>>>>>>>>>>>>>>>>> pageIndex:"+posStart);
//	System.out.println("getContractPaymentsPageXML>>>>>>>>>>>>>>>>>>>>>>>>>>>>> size:"+count);
//	System.out.println("getContractPaymentsPageXML>>>>>>>>>>>>>>>>>>>>>>>>>>>>> total_count:"+total_count);
//	
//	 RequestObject requestObject = RequestUtil.getReqInfo();
//	 
//	 System.out.println(">>>>>>>> requestObject:"+requestObject);
	 
	 String  ctxPath =(String) Constants.APPLACTION_MAP.get(Constants.SELET_CONPTCH);
	 
//	 System.out.println(">>111111111>>>SELET_CONPTCH>>> ctxPath:"+ctxPath);

    List pageList = dao.getMattersNews(mp,posStart,count);


	StringBuffer sb  = new StringBuffer();
	sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
	sb.append("<rows" +" total_count=\""+ total_count +"\"  pos=\""+ posStart +"\""+ " scrollTop=\"0\"" +">");  
	
	

	
	
	for(Iterator it = pageList.iterator();it.hasNext();){
		Matter LMan = (Matter) it.next();
		Industry Industry = LMan.getIndustry();
		Customer customer = LMan.getCustomer();
		
		
		String id = LMan.getId().toString();
//		System.out.println(">>>>>>>>  LMan.getBrandId():"+ LMan.getBrandId());
		
		String brandId = String.valueOf(LMan.getBrandId());
		String brandId2 = String.valueOf(LMan.getBrandId2());
		String brandName = String.valueOf(LMan.getBrand().getName());
		String name = StringUtil.getNullValue(LMan.getName(),"");
		String edit = StringUtil.getNullValue(LMan.getEdit(),"");

		String indstName = StringUtil.getNullValue(Industry.getName(),"");
		String indstNameParent = StringUtil.getNullValue(Industry.getParentName(),"");
		
//		System.out.println(">>>>>>>> id:"+id);
		
		Date createDate =  LMan.getCreateDate();
//		System.out.println(">>>>>>>> createDate:"+createDate);
		String createDateStr = "";
		if(createDate != null) createDateStr = DateUtil.getDate(createDate);
		
		String endDateStr =  StringUtil.getNullValue(LMan.getEndDate(),"19991231");
		String endDateStr2 = DateUtil.SetDateFormat(endDateStr,DateUtil.getDatePattern());
		int endDate =  Integer.valueOf(endDateStr).intValue();
		
		int nowDate =  Integer.valueOf(DateUtil.getDate()).intValue();
		boolean isNowUsing = endDate >= nowDate;
        String statesImg = "";
		if(isNowUsing) {
			statesImg = ""+ctxPath+"image/grid/item_chk1.gif^使用中（结束时间:" +endDateStr2 +")";
		}else{
			statesImg = ""+ctxPath+"image/grid/dyn_.gif^停用（结束时间:"+endDateStr2 +")";
		}
//		if(isNowUsing) statesImg = "/../../../item_chk1.gif^使用期限";
//		if(isNowUsing) statesImg = "image/button_delete.gif^删除";
		
//		 statesImg = "/adrm/image/grid/item_chk1.gif^删除";

//		System.out.println(">>>>"+ endDate +">>>> statesImg:"+statesImg);

//		System.out.println(">>>>>>>> createDateStr:"+createDateStr);
		
		if(industryLevel2Param){
			indstName = indstNameParent + " / "+ indstName;
		}

		sb.append("<row  id=\""+ id  +"\">");
//		sb.append("<cell><![CDATA["+ i++ +"]]></cell>");
//		sb.append("<cell><![CDATA["+ StringUtil.encodeStringXML(customer.getCustomerName()) +"]]></cell>");
		sb.append("<cell><![CDATA["+ StringUtil.encodeStringXML(brandName) +"]]></cell>");
//		sb.append("<cell><![CDATA["+ "11111111" +"]]></cell>");
		sb.append("<cell><![CDATA["+ StringUtil.encodeStringXML(name) +"]]></cell>");
		sb.append("<cell><![CDATA["+ StringUtil.encodeStringXML(edit) +"]]></cell>");
		sb.append("<cell><![CDATA["+ LMan.getLength() +"]]></cell>");
		sb.append("<cell><![CDATA["+ StringUtil.encodeStringXML(LMan.getTapeCode())  +"]]></cell>");
		sb.append("<cell><![CDATA["+ StringUtil.encodeStringXML(indstName)  +"]]></cell>");
		sb.append("<cell><![CDATA["+ StringUtil.encodeStringXML(LMan.getMatType().getName())  +"]]></cell>");
		sb.append("<cell><![CDATA["+ createDateStr  +"]]></cell>");
//		是否现用
		sb.append("<cell><![CDATA["+ statesImg  +"]]></cell>");
		
		
		
//		
		
		sb.append("<userdata name=\"id\"><![CDATA["+ id +"]]></userdata>");
		sb.append("<userdata name=\"brandId\"><![CDATA["+ brandId +"]]></userdata>");
		sb.append("<userdata name=\"brandId2\"><![CDATA["+ brandId2 +"]]></userdata>");
		sb.append("<userdata name=\"matterType\"><![CDATA["+ LMan.getMatterType().toString() +"]]></userdata>");
		sb.append("<userdata name=\"customerCategoryId\"><![CDATA["+ customer.getCustomerCategoryId().toString() +"]]></userdata>");
		sb.append("<userdata name=\"customerId\"><![CDATA["+ LMan.getCustomerId() +"]]></userdata>");
		
//		System.out.println("getContractPaymentsPageXML>>>>>>>>>>>>>>>>>>>>>>>>>>>>> pageIndex:"+posStart);

		sb.append("</row>");
	 }
	sb.append("</rows>");

	

	return sb.toString();

}
public Map buildParamBy(String strQueryString){
	Map mp = new HashMap();	
	
	String year =  StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"year"),"");
	String loginUser =  StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"loginUser"),"");
	String signUserId =  StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"signUserId"),"");
	
	String orgId =  StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"orgId"),"1");
	String name =  StringUtil.getURLDecoderStr(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"name"),""));
	String edit =  StringUtil.getURLDecoderStr(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"edit"),""));
	String length =  StringUtil.getURLDecoderStr(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"length"),""));
	String tapeCode =  StringUtil.getURLDecoderStr(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"tapeCode"),""));
	String brandId =  StringUtil.getURLDecoderStr(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"brandId"),""));
	String brandId2 =  StringUtil.getURLDecoderStr(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"brandId2"),""));
	String matterType =  StringUtil.getURLDecoderStr(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"matterType"),""));
	String sortStr =  StringUtil.getURLDecoderStr(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"sortStr"),""));
	String customerName =  StringUtil.getURLDecoderStr(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"customerName"),""));
	
//	if("".equals(matterType)) matterType = null;

//	System.out.println(">>>>>>>> year:"+year);
//	System.out.println(">>>>>>>> loginUser:"+loginUser);
//	System.out.println(">>>>>>>> signUserId:"+signUserId);
//	System.out.println(">>>>>>>> orgId:"+orgId);
//	System.out.println(">>>>>>>> name:"+name);
//	System.out.println(">>>>>>>> edit:"+edit);
//	System.out.println(">>>>>>>> length:"+length);
//	System.out.println(">>>>>>>> tapeCode:"+tapeCode);
//	System.out.println(">>>>>>>> brandId:"+brandId);
//	System.out.println(">>>>>>>> customerName:"+customerName);
	System.out.println("buildParamBy 666666  555  >>>>>>>> matterType:"+matterType);

	mp.put("year",year);
	mp.put("orgId",orgId);
	mp.put("tapeCode",tapeCode);
	mp.put("name",name);
	mp.put("edit",edit);
	mp.put("length",length);	
	mp.put("brandId",brandId);
	mp.put("brandId2",brandId2);
	mp.put("matterType",matterType);
	mp.put("sortStr",sortStr);
	mp.put("customerName",customerName);
 	
 	return mp;
}



////大洋素材交互
//public String saveMatter2Dayang(Matter matter,int importOption){
//	
//	
//	System.out.println(">>>>>>>> saveMatter2Dayang START:");
//	
//
////	String IURL ="http://Server:8080/ADP/services/ImportMaterialServiceService?wsdl";
////	String IURL ="http://Server:8080/ADP/services/ImportMaterialServiceService";
//	String IURL = Constants.DAYANG_WEBSERVER_IMPORT_MATTER_URL;
//	ImportMaterialServiceClient client = new ImportMaterialServiceClient();
////	System.out.println(">>>>>>>> saveMatter2Dayang ImportMaterialServiceClient:" + client);
//	ImportMaterial service = client.getImportMaterialLocalEndpoint();
////	System.out.println(">>>>>>>> saveMatter2Dayang ImportMaterial:" + service);
//
//	
////	Service serviceModel = new ObjectServiceFactory().create(ImportMaterialService.class);
////	XFireProxyFactory factory = new XFireProxyFactory(XFireFactory.newInstance().getXFire());
////	ImportMaterial service = new ImportMaterialServiceImpl();
//
//	System.out.println(">>>>>>>> saveMatter2Dayang ImportMaterial:" + service);
//	
//	
////	<!-- 导入选项。1-新增素材信息，2-只更新素材元数据信息-->
////	<m:ImportOption>1</m:ImportOption>
//	
//	 com.dayang.adp.schema.adpserviceparametertype._0.ObjectFactory  factoryParam = new  com.dayang.adp.schema.adpserviceparametertype._0.ObjectFactory();
//	 
//	 
//	 System.out.println(">>>>>>>> saveMatter2Dayang factoryParam:" + factoryParam);
//	 
////	 ObjectFactory  factoryEntity = new ObjectFactory();
//	 
//	 ImportMaterialRequestType importMaterialRequestType = factoryParam.createImportMaterialRequestType();
//	 
//	 System.out.println(">>>>>>>> saveMatter2Dayang importMaterialRequestType:" + importMaterialRequestType);
//	 
////	ImportMaterialRequestType importMaterialRequestType = new ImportMaterialRequestType();
//	 importMaterialRequestType.setImportOption(importOption);
//
////	 CommonRequestType commonRequest = importMaterialRequestType.getCommonRequest();
//	 CommonRequestType commonRequest = new CommonRequestType();
//	 
//	 
//	 System.out.println(">>>>>>>> saveMatter2Dayang commonRequest:" + commonRequest);
//	 
////	CommonRequestType commonRequest = factoryParam.createCommonRequestType();
////	CommonRequestType commonRequest = new CommonRequestType();
//
////	<!-- 发起调用请求的系统ID -->
////	<m:RequestSystemID>BoRuiADM</m:RequestSystemID>
//	commonRequest.setRequestSystemID("BoRuiADM");
////	<!-- 发起请求系统的当前用户ID -->
////	<m:UserID>007</m:UserID>
//	commonRequest.setUserID("007");
////	<!-- 发起请求系统的当前用户名称 -->
////	<m:UserName>admin</m:UserName>
//	commonRequest.setUserName("admin");	
//
//
//	ADMaterialEntityType adMaterialEntity = new ADMaterialEntityType(); 
////	ADMaterialEntityType adMaterialEntity =  factoryEntity.createADMaterialEntityType();
////	ADMaterialEntityType adMaterialEntity =  importMaterialRequestType.getADMaterialEntity();
//	
//	 System.out.println(">>>>>>>> saveMatter2Dayang adMaterialEntity:" + adMaterialEntity);
//	 
//	 System.out.println(">>>>>>>> saveMatter2Dayang matter>>>:" + matter.toString());
//	
//	
////	<!-- 素材ID（主键）；可使用ADM界面中的磁带编码 -->  //广告系统磁带系统编码
////	<m0:MaterialID>44668221</m0:MaterialID>
//	adMaterialEntity.setMaterialID(matter.getTapeCode());
////	adMaterialEntity.setMaterialID(matter.getId().toString());
//	
////	<!-- 素材名称-->
////	<m0:MaterialName>西峡风光新配音版15秒</m0:MaterialName>
//	adMaterialEntity.setMaterialName(matter.getName()+' '+matter.getEdit());
////	<!-- 素材类型（使用0即可） -->
////	<m0:MaterialType>0</m0:MaterialType>
//	adMaterialEntity.setMaterialType(0);
////	<!-- 源介质类型（1-蓝光，2-磁带，3-P2，4-目录文件）-->
////	<m0:MediumType>2</m0:MediumType>
//	adMaterialEntity.setMaterialID("2");
////	<!-- 素材制式（填0即可）-->
////	<m0:Standard>0</m0:Standard>
//	adMaterialEntity.setStandard(0);
////	<!-- 总时长，单位：帧-->
////	<m0:TotalLength>125</m0:TotalLength>
//	adMaterialEntity.setTotalLength(Integer.parseInt(matter.getLength())*25);
////	<!-- 入点。对于含有视频的单位是帧，纯音频单位是采样点-->
////	<m0:MarkIn>0</m0:MarkIn>
//	adMaterialEntity.setMarkIn(0);
////	<!-- 出点。对于含有视频的单位是帧，纯音频单位是采样点 -->
////	<m0:MarkOut>230</m0:MarkOut>
//	adMaterialEntity.setMarkOut(Integer.parseInt(matter.getLength())*25);
////	<!-- 源高标清类型（0-未知，1-标清，2-高清）-->
////	<m0:HDFlag>1</m0:HDFlag>
//	adMaterialEntity.setHDFlag(1);
////	<!-- 源AFD信息，使用0即可 -->
////	<m0:AFD>0</m0:AFD>
//	adMaterialEntity.setAFD("0");
////	<!-- 素材业务类型（填0即可）-->
////	<m0:BusinessType>0</m0:BusinessType>
//	adMaterialEntity.setBusinessType(0);
////	<!-- 素材业务子类型（填0即可）-->
////	<m0:SubBusinessType>0</m0:SubBusinessType>
//	adMaterialEntity.setSubBusinessType(0);
////	<!-- 预播栏目 ，此处填栏目名称 -->
////	<m0:PrePlayColumn>走进科学</m0:PrePlayColumn>
//	adMaterialEntity.setPrePlayColumn("");
////	<!-- 预播频道 此处填频道名称 -->
////	<m0:PrePlayChannel>东方卫视</m0:PrePlayChannel>
//	adMaterialEntity.setPrePlayChannel("");
////	<!-- 描述-->
////	<m0:Description>西峡风光新配音版15秒素材信息</m0:Description>
//	adMaterialEntity.setDescription("");
//
//	
//	System.out.println(">>>>>>>> saveMatter2Dayang adMaterialEntity: end" );
//
////	com.dayang.adp.schema.adpserviceparametertype._0.ExtendAttributesType extendAttributesType = new com.dayang.adp.schema.adpserviceparametertype._0.ExtendAttributesType(); 
//
//	importMaterialRequestType.setCommonRequest(commonRequest);
////	importMaterialRequestType.setImportOption(importOption);
//	importMaterialRequestType.setADMaterialEntity(adMaterialEntity);
////	importMaterialRequestType.setExtendAttributes(extendAttributesType);
//	
////	ImportMaterial importMaterial  =  ServiceLocator.getImportMaterialManager();
//	
//	String staus = "";
//	String newId = "";
//	
//	
//	try {  
//		 MaterialServiceParameterResponseType materialServiceParameterResponseType = service.importMaterial(importMaterialRequestType);
//		 
//		 System.out.println(">>>>>>>> saveMatter2Dayang materialServiceParameterResponseType:" + materialServiceParameterResponseType);
//	//		<!-- 响应 -->
//			CommonResponseType commonResponse = materialServiceParameterResponseType.getCommonResponse();
//			
//			System.out.println(">>>>>>>> saveMatter2Dayang commonResponse:" + commonResponse);
//			
//	//		<!-- 返回状态，0-成功，1-失败 -->
//	//		<ns4:Status>0</ns4:Status>
//			 staus = String.valueOf(commonResponse.getStatus());
//	//		<!-- 状态文字描述 -->
//	//		<ns4:Description>新增ID为44668221的素材信息成功。</ns4:Description>
//			 newId = commonResponse.getDescription();
//			 
//			 
//			 System.out.println(">>>>>>>> saveMatter2Dayang commonResponse.getDescription()>>>> newId:" + newId);
//			 
//	    } catch (Exception e) {  
//	       e.printStackTrace();  
//	    } 
//	    
//	System.out.println(">>>>>>>> saveMatter2Dayang END:");
//
//	return staus;
//}


//public String saveMatter2Dayang(Matter matter,int importOption){
//	String IURL = "http://127.0.0.1:8080/adrm/services/ImportProgramListService?wsdl";
//	java.net.URL portAddress = null;
//	ImportMaterial service = null;
//	
//	try {
//		portAddress = new java.net.URL(IURL);
//	} catch (MalformedURLException e2) {
//		// TODO Auto-generated catch block
//		e2.printStackTrace();
//	}  
//	
//	ImportMaterialService mgr = new ImportMaterialServiceLocator();
//	try {
//		service = mgr.getImportMaterialServiceHttpPort(portAddress);
//		
//		System.out.println(">>>>>>>> saveMatter2Dayang service test  test test test test test :" + service);
//		 
//	} catch (ServiceException e1) {
//		// TODO Auto-generated catch block
//		e1.printStackTrace();
//	}
//	
//	return null;
//}
////大洋素材交互
private String saveMatter2Dayang(Matter matter,int importOption,ImportMaterialServiceStub  service1){
	


//	java.net.URL portAddress = null;
	ImportMaterialServiceStub  service = null;
	
//	try {
//		portAddress = new java.net.URL(IURL);
//	} catch (MalformedURLException e2) {
//		// TODO Auto-generated catch block
//		e2.printStackTrace();
//	}  
	
	
	try {
		
		if(service1 != null) {
			  service = service1;
		}else{
			 service = new ImportMaterialServiceStub(getDaYangURL());
		}

		
//		 System.out.println(">>>>>>>> saveMatter2Dayang service:" + service);
		ImportMaterialRequest importMaterialRequest = new ImportMaterialRequest();
		ImportMaterialRequestType importMaterialRequestType = new ImportMaterialRequestType();
		importMaterialRequestType.setImportOption(importOption);
		CommonRequestType commonRequest = new CommonRequestType();


//		<!-- 发起调用请求的系统ID -->
//		<m:RequestSystemID>BoRuiADM</m:RequestSystemID>
		commonRequest.setRequestSystemID("BoRuiADM");
//		<!-- 发起请求系统的当前用户ID -->
//		<m:UserID>007</m:UserID>
		commonRequest.setUserID("007");
//		<!-- 发起请求系统的当前用户名称 -->
//		<m:UserName>admin</m:UserName>
		commonRequest.setUserName("admin");	


		ADMaterialEntityType adMaterialEntity = new ADMaterialEntityType(); 
//		ADMaterialEntityType adMaterialEntity =  factoryEntity.createADMaterialEntityType();
//		ADMaterialEntityType adMaterialEntity =  importMaterialRequestType.getADMaterialEntity();
		
//		<!-- 素材ID（主键）；可使用ADM界面中的磁带编码 -->  //广告系统磁带系统编码
//		<m0:MaterialID>44668221</m0:MaterialID>
		adMaterialEntity.setMaterialID(matter.getTapeCode());
//		adMaterialEntity.setMaterialID(matter.getId().toString());	
//		adMaterialEntity.setMaterialID(matter.getId().toString());
		
//		<!-- 素材名称-->
//		<m0:MaterialName>西峡风光新配音版15秒</m0:MaterialName>
		adMaterialEntity.setMaterialName(matter.getName()+' '+matter.getEdit());
//		<!-- 素材类型（使用0-1即可） -->
//		<m0:MaterialType>0</m0:MaterialType>
		adMaterialEntity.setMaterialType(0);
		
		adMaterialEntity.setMediumType(2);
//		<!-- 源介质类型（1-蓝光，2-磁带，3-P2，4-目录文件）-->
//		<m0:MediumType>2</m0:MediumType>

//		<!-- 素材制式（填0即可）-->
//		<m0:Standard>0</m0:Standard>
		adMaterialEntity.setStandard(0);
		
//		<!-- 总时长，单位：帧-->
//		<m0:TotalLength>125</m0:TotalLength>
		adMaterialEntity.setTotalLength(Integer.parseInt(matter.getLength())*25);
//		<!-- 入点。对于含有视频的单位是帧，纯音频单位是采样点-->
//		<m0:MarkIn>0</m0:MarkIn>
		adMaterialEntity.setMarkIn(0);
//		<!-- 出点。对于含有视频的单位是帧，纯音频单位是采样点 -->
//		<m0:MarkOut>230</m0:MarkOut>
		adMaterialEntity.setMarkOut(Integer.parseInt(matter.getLength())*25);
//		<!-- 源高标清类型（0-未知，1-高清）-- 2-标清，>
//		<m0:HDFlag>1</m0:HDFlag>
		adMaterialEntity.setHDFlag(2);
//		<!-- 源AFD信息，使用0即可 -->
//		<m0:AFD>0</m0:AFD>
		adMaterialEntity.setAFD("0");
//		<!-- 素材业务类型（填0即可）-->
//		<m0:BusinessType>0</m0:BusinessType>
		adMaterialEntity.setBusinessType(0);
//		<!-- 素材业务子类型（填0即可）-->
//		<m0:SubBusinessType>0</m0:SubBusinessType>
		adMaterialEntity.setSubBusinessType(0);
//		<!-- 预播栏目 ，此处填栏目名称 -->
//		<m0:PrePlayColumn>走进科学</m0:PrePlayColumn>
		adMaterialEntity.setPrePlayColumn("");

//		<!-- 描述-->
//		<m0:Description>西峡风光新配音版15秒素材信息</m0:Description>
		adMaterialEntity.setDescription("");
		
		
		if(importOption == 1){
			 Carrier car =  matter.getCarrier();
			 ResourceChannel channel = car.getResourceChannel();
			 String carrierAliasName = car.getAliasName();
			 String channelCode = channel.getMemo();
//				<!-- 预播频道 此处填频道名称 -->
//				<m0:PrePlayChannel>东方卫视</m0:PrePlayChannel>
				adMaterialEntity.setPrePlayChannel(channelCode);
		}

		
		importMaterialRequestType.setCommonRequest(commonRequest);
//		importMaterialRequestType.setImportOption(importOption);
		importMaterialRequestType.setADMaterialEntity(adMaterialEntity);
//		importMaterialRequestType.setExtendAttributes(extendAttributesType);
		importMaterialRequest.setImportMaterialRequest(importMaterialRequestType);
		

	
		ServiceClient _serviceClient =  service._getServiceClient();
		Options options =  _serviceClient.getOptions(); 
		options.setProperty(HTTPConstants.CHUNKED,false); 

//		try {  
			if(service.async){
				ConfigurationContext context = _serviceClient.getServiceContext().getConfigurationContext();
				
				HttpClient httpClient = new HttpClient(new MultiThreadedHttpConnectionManager());
				options.setTimeOutInMilliSeconds(1000*60*60);
				options.setManageSession(true);   
			    options.setProperty(HTTPConstants.REUSE_HTTP_CLIENT,true);  
//			    options.setUseSeparateListener(true);

				context.setProperty(HTTPConstants.REUSE_HTTP_CLIENT,true);
				context.setProperty(HTTPConstants.CACHED_HTTP_CLIENT,httpClient);
				context.setProperty(HTTPConstants.AUTO_RELEASE_CONNECTION,true);
				
			     
				ImportMaterialServiceCallbackHandler myCallback  = new MyImportMaterialServiceCallbackHandler(service,adMaterialEntity);
//				options.setProperty(org.apache.axis2.transport.http.HTTPConstants.HTTP_PROTOCOL_VERSION, org.apache.axis2.transport.http.HTTPConstants.HEADER_PROTOCOL_10);
//				service._getServiceClient().cleanupTransport();//增加此行，测试160条
				service.startimportMaterial(importMaterialRequest,myCallback);
//				_serviceClient.cleanupTransport(); 

			}else{
				
				System.out.println("/****************************************************************/");
		        long end1 = System.currentTimeMillis();
		        options.setTimeOutInMilliSeconds(1000*60*5);  //600*1000毫秒（10分钟   不起任何作用
				ImportMaterialResponse importMaterialResponse = service.importMaterial(importMaterialRequest);
//				options.setManageSession(true);   
//				_serviceClient.cleanupTransport(); 
				
				MaterialServiceParameterResponseType materialServiceParameterResponseType = importMaterialResponse.getImportMaterialResponse();
				CommonResponseType commonResponse = materialServiceParameterResponseType.getCommonResponse();
				String  staus = String.valueOf(commonResponse.getStatus());
				String  description = commonResponse.getDescription();
				long end2 = System.currentTimeMillis();
			
				System.out.println("Send Id>>"+ adMaterialEntity.getMaterialID()+"  Number> " + service.seq+" / "+service.sumCount);
				System.out.println("Status> " + staus);
//				System.out.println("Return id>" + description);  
//				System.out.println("Return Description>" + description);  
			    System.out.println("use time>>   "+ (end2 - end1) +"");
			    
			    System.out.println("/****************************************************************/");
//				System.out.println(">>>>>>>> saveMatter2Dayang commonResponse staus newId:" + staus +"__"+newId);
			}


			
			
//			//		<!-- 响应 -->
//			CommonResponseType commonResponse = materialServiceParameterResponseType.getCommonResponse();
//			
//			System.out.println(">>>>>>>> saveMatter2Dayang commonResponse:" + commonResponse);
//			
//	//		<!-- 返回状态，0-成功，1-失败 -->
//	//		<ns4:Status>0</ns4:Status>
//			 staus = String.valueOf(commonResponse.getStatus());
//	//		<!-- 状态文字描述 -->
//	//		<ns4:Description>新增ID为44668221的素材信息成功。</ns4:Description>
//			 newId = commonResponse.getDescription();
			
				 
//		 } catch (RemoteException e) {  
//		       e.printStackTrace();  
//		       System.out.println("/****************************************************************/");
//		 } 
		    
	

		
	} catch (Exception  e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

	return "";
}




private void saveDayangMatter(Matter matter,int importOption){
	 boolean dayangImport = SysParamUtil.getDayangBeiboEnableParam() == 1;
	 String save2DY = matter.getSave2dayang();
	 
	 System.out.println("saveDayangMatter (Matter matter,int importOption) rrrrrrrrrrrrrrrrrrrrr  >>>>>>>>save2DY:" + save2DY);
	 
	 boolean save2dayang = "1".equals(save2DY);

//	 System.out.println("rrrrrrrrrrrrrrrrrrrrr  >>>>>>>> saveMatter2Dayang dayangImport:" + dayangImport);
	 System.out.println("saveDayangMatter (Matter matter,int importOption) rrrrrrrrrrrrrrrrrrrrr  >>>>>>>>save2dayang:" + save2dayang);
	 
	 
	 if(dayangImport &&  save2dayang && importOption !=1){
		 this.saveMatter2Dayang(matter, importOption,null);
	 }
}



private String getDaYangURL(){
	 
//	 System.out.println("rrrrrrrrrrrrrrrrrrrrr  >>>>>>>> saveMatter2Dayang dayangImport:" + dayangImport);
		
//		String IURL = Constants.DAYANG_WEBSERVER_IMPORT_MATTER_URL;
//		String IURL = Constants.DAYANG_WEBSERVER_IMPORT_MATTER_URL_TEST;

		String IURL = SysParamUtil.getDayangWebServiceUrlMatterParam();
//		 System.out.println(">>>>>>>> saveMatter2Dayang importOption:" + importOption);
//		 System.out.println(">>>>>>>> saveMatter2Dayang IURL:" + IURL);
	return IURL;
}


public void saveMattersAll2dayang2(Matter mtParam,String url_address){
//	saveMattersAll2dayang2_test(mtParam);
	saveMattersAll2dayang2_1( mtParam, url_address);
}
public void saveMattersAll2dayang2_1(Matter mtParam,String url_address){
	
	 boolean dayangImport = SysParamUtil.getDayangBeiboEnableParam() == 1;
	 
	 List tapeCodeList = mtParam.getTapeCodeList();
	 Carrier car = mtParam.getCarrier();


//	 ImportMaterialServiceStub service = null;
//	try {
//		service = new ImportMaterialServiceStub(getDaYangURL());
//	} catch (AxisFault e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	 
	 
	if(tapeCodeList.size() > 0) {
		Matter matter = new Matter();
		matter.setTapeCodeList(tapeCodeList);
		matter.setInDayangMatter("0");
		
		List ls = dao.getMatters(matter);
		
//		System.out.println("saveMattersAll2dayang start..............................."+ls.size());
//		System.out.println("saveMattersAll2dayang start..............................."+ls.toString());
		
		Iterator it = ls.iterator();
//		System.out.println("saveMattersAll2dayang start...............................");
		int count1 = 0;
		int total = ls.size();

		List mtIdList = new ArrayList();
		while(it.hasNext()){
			Matter mat = (Matter)it.next();
			String len = mat.getLength();
			mat.setCarrier(car);
			mtIdList.add(mat.getId());
			if(len == null || "".equals(len)) len ="0";
			len = StringUtil.doubleFormat4(Double.parseDouble(len));
			int l = Integer.parseInt(len);
//			System.out.println("saveMattersAll2dayang TapeCode>>>>" +mat.getTapeCode());
//			if(l > 0){
				 try{
					 if(dayangImport){ 
						 System.out.println("saveMattersAll2dayang url_address..............................."+url_address);
						 ImportMaterialServiceStub service = new ImportMaterialServiceStub(url_address);
						 service.async = true;
						 service.sumCount = total;
						 service.setSeq(count1);
						 this.saveMatter2Dayang(mat, 1,service);
					 }
					 count1++;
				 } catch (Exception e2) {
//					 System.out.println("error  mat TapeCode" + mat.getTapeCode() +"...............................");
				}  
				 
//			}
		}
		if(mtIdList.size() > 0){
			Matter matter2 = new Matter();
			matter2.setTapeCodeList(mtIdList);
			dao.saveMatterInDayang(matter2);
		}
		
		System.out.println("saveMattersAll2dayang end...............................");
	}else{
		System.out.println("saveMattersAll2dayang no data to save.........");
	}
	
	

}

public void saveMattersAllindayang2zero(){
	String sql ="update tb_adver_matter set in_dayang_matter = 0";
	try {
		dao.getDefaultDataSource().getConnection().createStatement().execute(sql);
		System.out.println("saveMattersAll2dayang>>>"+sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


public void saveMattersAll2dayang2_test(String total2,String ansy){
//	List tapeCodeList = ma.getTapeCodeList();
	
	 boolean dayangImport = SysParamUtil.getDayangBeiboEnableParam() == 1;

	 ImportMaterialServiceStub service = null;
	
//	try {
//		service = new ImportMaterialServiceStub(getDaYangURL());
		
//		service._getServiceClient().getOptions().setTimeOutInMilliSeconds(600000);  //600*1000毫秒（10分钟 
//		Options options = service._getServiceClient().getOptions(); 
//		options.setTimeOutInMilliSeconds(10000);
//		options.setTimeOutInMilliSeconds(10000);
//		options.setProperty(org.apache.axis2.transport.http.HTTPConstants.HTTP_PROTOCOL_VERSION, org.apache.axis2.transport.http.HTTPConstants.HEADER_PROTOCOL_10);
	
		
//	} catch (AxisFault e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	 
	 

	 
	
	Matter matter = new Matter();
	List ls = dao.getMatters(matter);

	Iterator it = ls.iterator();
	System.out.println("saveMattersAll2dayang start...............................");
	int count1 = 1;
	int total = Integer.valueOf(total2);
	 long start1 = System.currentTimeMillis();
	 
	while(it.hasNext()){
		Matter mat = (Matter)it.next();
		String len = mat.getLength();
		if(len == null || "".equals(len)) len ="0";
		len = StringUtil.doubleFormat4(Double.parseDouble(len));
		int l = Integer.parseInt(len);
		
//		int code = Integer.valueOf(mat.getTapeCode());
		if(l > 0 && count1<=total){
			
//			System.out.println("saveMattersAll2dayang TapeCode>>>>" +mat.getTapeCode());
//			http://10.77.50.242/msbus-webapp/esb/event/ImportMaterialService
//			http://10.77.82.121:88/ADPINF/services/ImportMaterialService
			 try{
				 if(dayangImport){
//					 try {
//						    if(count1%100 == 0){
						    	service = new ImportMaterialServiceStub(getDaYangURL());
//						    	service._getServiceClient().getOptions().setTimeOutInMilliSeconds(600000);  //600*1000毫秒（10分钟 
//						    	System.out.println("saveMattersAll2dayang count1>>>>" + count1);
//						    }
//							service._getServiceClient().getOptions().setTimeOutInMilliSeconds(600000);  //600*1000毫秒（10分钟 
//					 	  try {
//					 		 if(count1%100 == 0){
//					 			 Thread.sleep(1000*60);
//					 		 }
//						   } catch (InterruptedException e) {
//						    e.printStackTrace();
//						   }
						    boolean async = "1".equals(ansy)?true:false;
						    service.async = async;
						    service.sumCount = total;
						    service.setSeq(count1);
						   
							this.saveMatter2Dayang(mat, 1,service);
//						} catch (AxisFault e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
					 
				 }
				 count1++;
//				 System.out.println("saveMattersAll2dayang end add    count1 ..............................." + count1);
			 } catch (AxisFault e) {
				 System.out.println("error  mat TapeCode" + mat.getTapeCode() +"...............................");
				 System.out.println("error info "+e.getMessage());
				
			}  
			 

			 
		}
		

	}
	
	 long end1 = System.currentTimeMillis();
	 
	 System.out.println("use total time>>   "+ (end1 - start1)/1000 +"s");
	
}
//public class WsClient {  
//	  
//	  private RPCServiceClient serviceClient;  
//	  private Options options;  
//	  private EndpointReference targetEPR;  
//	    
//	  public WsClient(String endpoint) throws AxisFault {  
//	    serviceClient = new RPCServiceClient();  
//	    options = serviceClient.getOptions();  
//	    targetEPR = new EndpointReference(endpoint);  
//	    options.setTo(targetEPR);  
//	  }  
//	  public Object[] invokeOp(String targetNamespace, String opName,  
//	      Object[] opArgs, Class<?>[] opReturnType) throws AxisFault,  
//	      ClassNotFoundException {  
//	    // 设定操作的名称  
//	    QName opQName = new QName(targetNamespace, opName);  
//	    // 设定返回值  
//	      
//	    //Class<?>[] opReturn = new Class[] { opReturnType };  
//	  
//	    // 操作需要传入的参数已经在参数中给定，这里直接传入方法中调用  
//	    return serviceClient.invokeBlocking(opQName, opArgs, opReturnType);  
//	  }  
//}

////大洋素材交互
//public String saveMatter2Dayang(Matter matter,int importOption){
//	
////	String IURL = Constants.DAYANG_WEBSERVER_IMPORT_MATTER_URL;
//	String IURL = Constants.DAYANG_WEBSERVER_IMPORT_MATTER_URL_TEST;
////	java.net.URL portAddress = null;
////	ImportMaterialService service = null;
////	ImportMaterialServiceStub  service = null;
//
//	
////	try {
////		portAddress = new java.net.URL(IURL);
////	} catch (MalformedURLException e2) {
////		// TODO Auto-generated catch block
////		e2.printStackTrace();
////	}  
//
//
////		创建客户端对象  
//		try {
//			
//			System.out.println("rrrrrrrrrrrrrrrrrrrrr  >>>>>>>> saveMatter2Dayang  IURL:" +  IURL);
//			
//			ImportMaterialServiceStub  service = new ImportMaterialServiceStub(IURL);
//			
//			 System.out.println("rrrrrrrrrrrrrrrrrrrrr  >>>>>>>> saveMatter2Dayang  service:" +  service);
//			 
//			ImportMaterialRequest importMaterialRequest = new ImportMaterialRequest();
//			ImportMaterialRequestType importMaterialRequestType = new ImportMaterialRequestType();
//			
//			importMaterialRequestType.setImportOption(importOption);
//
//			CommonRequestType commonRequest = new CommonRequestType();
//	//		<!-- 发起调用请求的系统ID -->
//	//		<m:RequestSystemID>BoRuiADM</m:RequestSystemID>
//			commonRequest.setRequestSystemID("BoRuiADM");
//	//		<!-- 发起请求系统的当前用户ID -->
//	//		<m:UserID>007</m:UserID>
//			commonRequest.setUserID("007");
//	//		<!-- 发起请求系统的当前用户名称 -->
//	//		<m:UserName>admin</m:UserName>
//			commonRequest.setUserName("admin");	
//	
//	
//			ADMaterialEntityType adMaterialEntity = new ADMaterialEntityType(); 
//	//		ADMaterialEntityType adMaterialEntity =  factoryEntity.createADMaterialEntityType();
//	//		ADMaterialEntityType adMaterialEntity =  importMaterialRequestType.getADMaterialEntity();
//			
//			 System.out.println(">>>>>>>> saveMatter2Dayang adMaterialEntity:" + adMaterialEntity);
//			 
//			 System.out.println(">>>>>>>> saveMatter2Dayang matter>>>:" + matter.toString());
//			
//	
//	//		<!-- 素材ID（主键）；可使用ADM界面中的磁带编码 -->  //广告系统磁带系统编码
//	//		<m0:MaterialID>44668221</m0:MaterialID>
//	//		adMaterialEntity.setMaterialID(matter.getTapeCode());
//			adMaterialEntity.setMaterialID(matter.getId().toString());	//10358
//	//		adMaterialEntity.setMaterialID(matter.getId().toString());
//			
//	//		<!-- 素材名称-->
//	//		<m0:MaterialName>西峡风光新配音版15秒</m0:MaterialName>
//			adMaterialEntity.setMaterialName(matter.getName()+' '+matter.getEdit());
//	//		<!-- 素材类型（使用0-1即可） -->
//	//		<m0:MaterialType>0</m0:MaterialType>
//			adMaterialEntity.setMaterialType(0);
//			
//			adMaterialEntity.setMediumType(2);
//	//		<!-- 源介质类型（1-蓝光，2-磁带，3-P2，4-目录文件）-->
//	//		<m0:MediumType>2</m0:MediumType>
//	
//	//		<!-- 素材制式（填0即可）-->
//	//		<m0:Standard>0</m0:Standard>
//			adMaterialEntity.setStandard(0);
//			
//	//		<!-- 总时长，单位：帧-->
//	//		<m0:TotalLength>125</m0:TotalLength>
//			adMaterialEntity.setTotalLength(Integer.parseInt(matter.getLength())*25);
//	//		<!-- 入点。对于含有视频的单位是帧，纯音频单位是采样点-->
//	//		<m0:MarkIn>0</m0:MarkIn>
//			adMaterialEntity.setMarkIn(0);
//	//		<!-- 出点。对于含有视频的单位是帧，纯音频单位是采样点 -->
//	//		<m0:MarkOut>230</m0:MarkOut>
//			adMaterialEntity.setMarkOut(Integer.parseInt(matter.getLength())*25);
//	//		<!-- 源高标清类型（0-未知，1-标清，2-高清）-->
//	//		<m0:HDFlag>1</m0:HDFlag>
//			adMaterialEntity.setHDFlag(1);
//	//		<!-- 源AFD信息，使用0即可 -->
//	//		<m0:AFD>0</m0:AFD>
//			adMaterialEntity.setAFD("0");
//	//		<!-- 素材业务类型（填0即可）-->
//	//		<m0:BusinessType>0</m0:BusinessType>
//			adMaterialEntity.setBusinessType(0);
//	//		<!-- 素材业务子类型（填0即可）-->
//	//		<m0:SubBusinessType>0</m0:SubBusinessType>
//			adMaterialEntity.setSubBusinessType(0);
//	//		<!-- 预播栏目 ，此处填栏目名称 -->
//	//		<m0:PrePlayColumn>走进科学</m0:PrePlayColumn>
//			adMaterialEntity.setPrePlayColumn("");
//	//		<!-- 预播频道 此处填频道名称 -->
//	//		<m0:PrePlayChannel>东方卫视</m0:PrePlayChannel>
//			adMaterialEntity.setPrePlayChannel("");
//	//		<!-- 描述-->
//	//		<m0:Description>西峡风光新配音版15秒素材信息</m0:Description>
//			adMaterialEntity.setDescription("");
//	
//			
//			System.out.println(">>>>>>>> saveMatter2Dayang adMaterialEntity: end" );
//	
//	//		com.dayang.adp.schema.adpserviceparametertype._0.ExtendAttributesType extendAttributesType = new com.dayang.adp.schema.adpserviceparametertype._0.ExtendAttributesType(); 
//	
//			importMaterialRequestType.setCommonRequest(commonRequest);
//	//		importMaterialRequestType.setImportOption(importOption);
//			importMaterialRequestType.setADMaterialEntity(adMaterialEntity);
//	//		importMaterialRequestType.setExtendAttributes(extendAttributesType);
//			importMaterialRequest.setImportMaterialRequest(importMaterialRequestType);
//	//		ImportMaterial importMaterial  =  ServiceLocator.getImportMaterialManager();
//			
//			String staus = "";
//			String newId = "";		
//			
//			
//			 System.out.println(">>>>>>>> saveMatter2Dayang importMaterialResponse: start>>>>>>>>>>>>>>>" );
//			
//			ImportMaterialResponse importMaterialResponse = service.importMaterial(importMaterialRequest);
//			
//			 System.out.println(">>>>>>>> saveMatter2Dayang importMaterialResponse: importMaterialResponse>>>>>>>>>>>>>>>" + importMaterialResponse);
//			
//			
//			MaterialServiceParameterResponseType materialServiceParameterResponseType = importMaterialResponse.getImportMaterialResponse();
//			 
//			 System.out.println(">>>>>>>> saveMatter2Dayang materialServiceParameterResponseType:" + materialServiceParameterResponseType);
//		//		<!-- 响应 -->
//				CommonResponseType commonResponse = materialServiceParameterResponseType.getCommonResponse();
//				
//				System.out.println(">>>>>>>> saveMatter2Dayang commonResponse:" + commonResponse);
//				
//		//		<!-- 返回状态，0-成功，1-失败 -->
//		//		<ns4:Status>0</ns4:Status>
//				 staus = String.valueOf(commonResponse.getStatus());
//		//		<!-- 状态文字描述 -->
//		//		<ns4:Description>新增ID为44668221的素材信息成功。</ns4:Description>
//				 newId = commonResponse.getDescription();
//				 
//				 
//				 System.out.println(">>>>>>>> saveMatter2Dayang commonResponse.getDescription()>>>> newId:" + newId);
//				 
//		    } catch (RemoteException e) {  
//		       e.printStackTrace();  
//		    } 
//		    
//		System.out.println(">>>>>>>> saveMatter2Dayang END:");			
//			
//			
//
//	return "";
//}



//public String saveMatter2Dayang(Matter matter,int importOption){
//	
//	
//	 System.out.println(">>>>>>>> saveMatter2Dayang importOption:" + importOption);
//	 
//	
////	String IURL = Constants.DAYANG_WEBSERVER_IMPORT_MATTER_URL;
//	String IURL = Constants.DAYANG_WEBSERVER_IMPORT_MATTER_URL_TEST;
//	
//	
//
//		
//	java.net.URL portAddress = null;
//	ImportMaterial service = null;
//	
//	try {
//		portAddress = new java.net.URL(IURL);
//	} catch (MalformedURLException e2) {
//		// TODO Auto-generated catch block
//		e2.printStackTrace();
//	}  
//	
//	
//	try {
//		
////		ImportMaterial service = new ImportMaterialHttpBindingStub();
//		ImportMaterialService mgr = new ImportMaterialServiceLocator();
//
//		try {
//			service = mgr.getImportMaterialServiceHttpPort(portAddress);
//		} catch (ServiceException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
////		 System.out.println(">>>>>>>> saveMatter2Dayang service:" + service);
//		 
//		ImportMaterialRequestType importMaterialRequestType = new ImportMaterialRequestType();
//		 importMaterialRequestType.setImportOption(importOption);
//		 CommonRequestType commonRequest = new CommonRequestType();
//
//		 System.out.println(">>>>>>>> saveMatter2Dayang commonRequest:" + commonRequest);
//
//
////		<!-- 发起调用请求的系统ID -->
////		<m:RequestSystemID>BoRuiADM</m:RequestSystemID>
//		commonRequest.setRequestSystemID("BoRuiADM");
////		<!-- 发起请求系统的当前用户ID -->
////		<m:UserID>007</m:UserID>
//		commonRequest.setUserID("007");
////		<!-- 发起请求系统的当前用户名称 -->
////		<m:UserName>admin</m:UserName>
//		commonRequest.setUserName("admin");	
//
//
//		ADMaterialEntityType adMaterialEntity = new ADMaterialEntityType(); 
////		ADMaterialEntityType adMaterialEntity =  factoryEntity.createADMaterialEntityType();
////		ADMaterialEntityType adMaterialEntity =  importMaterialRequestType.getADMaterialEntity();
//		
//		 System.out.println(">>>>>>>> saveMatter2Dayang adMaterialEntity:" + adMaterialEntity);
//		 
//		 System.out.println(">>>>>>>> saveMatter2Dayang matter>>>:" + matter.toString());
//		
//
////		<!-- 素材ID（主键）；可使用ADM界面中的磁带编码 -->  //广告系统磁带系统编码
////		<m0:MaterialID>44668221</m0:MaterialID>
//		adMaterialEntity.setMaterialID(matter.getTapeCode());
////		adMaterialEntity.setMaterialID(matter.getId().toString());	
////		adMaterialEntity.setMaterialID(matter.getId().toString());
//		
////		<!-- 素材名称-->
////		<m0:MaterialName>西峡风光新配音版15秒</m0:MaterialName>
//		adMaterialEntity.setMaterialName(matter.getName()+' '+matter.getEdit());
////		<!-- 素材类型（使用0-1即可） -->
////		<m0:MaterialType>0</m0:MaterialType>
//		adMaterialEntity.setMaterialType(0);
//		
//		adMaterialEntity.setMediumType(2);
////		<!-- 源介质类型（1-蓝光，2-磁带，3-P2，4-目录文件）-->
////		<m0:MediumType>2</m0:MediumType>
//
////		<!-- 素材制式（填0即可）-->
////		<m0:Standard>0</m0:Standard>
//		adMaterialEntity.setStandard(0);
//		
////		<!-- 总时长，单位：帧-->
////		<m0:TotalLength>125</m0:TotalLength>
//		adMaterialEntity.setTotalLength(Integer.parseInt(matter.getLength())*25);
////		<!-- 入点。对于含有视频的单位是帧，纯音频单位是采样点-->
////		<m0:MarkIn>0</m0:MarkIn>
//		adMaterialEntity.setMarkIn(0);
////		<!-- 出点。对于含有视频的单位是帧，纯音频单位是采样点 -->
////		<m0:MarkOut>230</m0:MarkOut>
//		adMaterialEntity.setMarkOut(Integer.parseInt(matter.getLength())*25);
////		<!-- 源高标清类型（0-未知，1-标清，2-高清）-->
////		<m0:HDFlag>1</m0:HDFlag>
//		adMaterialEntity.setHDFlag(1);
////		<!-- 源AFD信息，使用0即可 -->
////		<m0:AFD>0</m0:AFD>
//		adMaterialEntity.setAFD("0");
////		<!-- 素材业务类型（填0即可）-->
////		<m0:BusinessType>0</m0:BusinessType>
//		adMaterialEntity.setBusinessType(0);
////		<!-- 素材业务子类型（填0即可）-->
////		<m0:SubBusinessType>0</m0:SubBusinessType>
//		adMaterialEntity.setSubBusinessType(0);
////		<!-- 预播栏目 ，此处填栏目名称 -->
////		<m0:PrePlayColumn>走进科学</m0:PrePlayColumn>
//		adMaterialEntity.setPrePlayColumn("");
////		<!-- 预播频道 此处填频道名称 -->
////		<m0:PrePlayChannel>东方卫视</m0:PrePlayChannel>
//		adMaterialEntity.setPrePlayChannel("");
////		<!-- 描述-->
////		<m0:Description>西峡风光新配音版15秒素材信息</m0:Description>
//		adMaterialEntity.setDescription("");
//
//		
//		System.out.println(">>>>>>>> saveMatter2Dayang adMaterialEntity: end" );
//
////		com.dayang.adp.schema.adpserviceparametertype._0.ExtendAttributesType extendAttributesType = new com.dayang.adp.schema.adpserviceparametertype._0.ExtendAttributesType(); 
//
//		importMaterialRequestType.setCommonRequest(commonRequest);
////		importMaterialRequestType.setImportOption(importOption);
//		importMaterialRequestType.setADMaterialEntity(adMaterialEntity);
////		importMaterialRequestType.setExtendAttributes(extendAttributesType);
//		
////		ImportMaterial importMaterial  =  ServiceLocator.getImportMaterialManager();
//		
//		String staus = "";
//		String newId = "";
//		
//		
//		try {  
//			
//			
//			 MaterialServiceParameterResponseType materialServiceParameterResponseType = service.importMaterial(importMaterialRequestType);
//			 
//			 System.out.println(">>>>>>>> saveMatter2Dayang materialServiceParameterResponseType:" + materialServiceParameterResponseType);
//		//		<!-- 响应 -->
//				CommonResponseType commonResponse = materialServiceParameterResponseType.getCommonResponse();
//				
//				System.out.println(">>>>>>>> saveMatter2Dayang commonResponse:" + commonResponse);
//				
//		//		<!-- 返回状态，0-成功，1-失败 -->
//		//		<ns4:Status>0</ns4:Status>
//				 staus = String.valueOf(commonResponse.getStatus());
//		//		<!-- 状态文字描述 -->
//		//		<ns4:Description>新增ID为44668221的素材信息成功。</ns4:Description>
//				 newId = commonResponse.getDescription();
//				 
//				 
//				 System.out.println(">>>>>>>> saveMatter2Dayang commonResponse.getDescription()>>>> newId:" + newId);
//				 
//		    } catch (RemoteException e) {  
//		       e.printStackTrace();  
//		    } 
//		    
//		System.out.println(">>>>>>>> saveMatter2Dayang END:");
//
//		
//	} catch (Exception  e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	
//
//	return "";
//}





}
