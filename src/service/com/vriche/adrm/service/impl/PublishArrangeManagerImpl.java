
package com.vriche.adrm.service.impl;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import mreml2.schema.commondatatype.CommonRequestType;
import mreml2.schema.importprogramlistservice.ImportProgramListServiceCallbackHandler;
import mreml2.schema.importprogramlistservice.ImportProgramListServiceStub;
import mreml2.schema.importprogramlistservice.MyImportProgramListServiceCallbackHandler;
import mreml2.schema.programlist.BroadcastListEntityType;
import mreml2.schema.programlist.BroadcastListItemType;
import mreml2.schema.programlist.ChannelInfoType;
import mreml2.schema.programlist.ColumnInfoType;
import mreml2.schema.programlist.ExecuteActionType;
import mreml2.schema.programlist.ProgramInfoType;

import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import com.ibatis.common.resources.Resources;
import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.Constants;
import com.vriche.adrm.dao.DayInfoDao;
import com.vriche.adrm.dao.IndustryDao;
import com.vriche.adrm.dao.MatterDao;
import com.vriche.adrm.dao.PublishArrangeDao;
import com.vriche.adrm.dao.PublishArrangeDetailDao;
import com.vriche.adrm.dao.WorkspanDao;
import com.vriche.adrm.model.Carrier;
import com.vriche.adrm.model.CtrData;
import com.vriche.adrm.model.Industry;
import com.vriche.adrm.model.Matter;
import com.vriche.adrm.model.Org;
import com.vriche.adrm.model.PublishArrange;
import com.vriche.adrm.model.PublishArrangeDetail;
import com.vriche.adrm.model.Resource;
import com.vriche.adrm.model.ResourceChannel;
import com.vriche.adrm.model.ResourceSort;
import com.vriche.adrm.model.SysParam;
import com.vriche.adrm.model.User;
import com.vriche.adrm.model.Workspan;
import com.vriche.adrm.service.PublishArrangeManager;
import com.vriche.adrm.util.ArrangeUtil;
import com.vriche.adrm.util.ArrangeUtil3;
import com.vriche.adrm.util.CarrierUtil;
import com.vriche.adrm.util.ConvertUtil;
import com.vriche.adrm.util.DateUtil;
import com.vriche.adrm.util.FTP;
import com.vriche.adrm.util.FileUtil;
import com.vriche.adrm.util.RequestUtil;
import com.vriche.adrm.util.ResourceUtil;
import com.vriche.adrm.util.ServiceLocator;
import com.vriche.adrm.util.StringUtil;
import com.vriche.adrm.util.StringUtilsv;
import com.vriche.adrm.util.SysParamUtil;
import com.vriche.adrm.util.UserUtil;

public class PublishArrangeManagerImpl extends BaseManager implements PublishArrangeManager {
  
	private PublishArrangeDao dao;
    private PublishArrangeDetailDao publishArrangeDetailDao;
    private MatterDao matterDao;
    private IndustryDao industryDao;
    private WorkspanDao workspanDao;
    private DayInfoDao dayInfoDao;
    

  
	/**
	 * Set the Dao for communication with the data layer.
	 * 
	 * @param dao
	 */
    public void setPublishArrangeDao(PublishArrangeDao dao) {
        this.dao = dao;
    }
	/**
	 * @param publishArrangeDetailDao
	 *            The publishArrangeDetailDao to set.
	 */
	public void setPublishArrangeDetailDao(
			PublishArrangeDetailDao publishArrangeDetailDao) {
		this.publishArrangeDetailDao = publishArrangeDetailDao;
	}
	/**
	 * @param matterDao
	 *            The matterDao to set.
	 */
	public void setMatterDao(MatterDao matterDao) {
		this.matterDao = matterDao;
	}
	/**
	 * @param industryDao
	 *            The industryDao to set.
	 */
	public void setIndustryDao(IndustryDao industryDao) {
		this.industryDao = industryDao;
	}
	/**
	 * @param workspanDao
	 *            The workspanDao to set.
	 */
	public void setWorkspanDao(WorkspanDao workspanDao) {
		this.workspanDao = workspanDao;
	}
	
	  public void setDayInfoDao(DayInfoDao dayInfoDao) {
			this.dayInfoDao = dayInfoDao;
		}
	  
	  
	  
   /**
	 * @see com.vriche.adrm.service.PublishArrangeManager#getPublishArranges(com.vriche.adrm.model.PublishArrange)
	 */
    public List getPublishArranges(final PublishArrange publishArrange) {
        return dao.getPublishArranges(publishArrange);
    }
   /**
	 * @see com.vriche.adrm.service.PublishArrangeManager#getPublishArrangesCount(com.vriche.adrm.model.PublishArrange)
	 */
    public String getPublishArrangesCount(final PublishArrange publishArrange) {
        return dao.getPublishArrangesCount(publishArrange).toString();
    }    

   /**
	 * @see com.vriche.adrm.service.PublishArrangeManager#getPublishArrangesCount(com.vriche.adrm.model.PublishArrange)
	 */    
	public PaginatedList getPublishArrangesPage(final PublishArrange publishArrange,String pageIndex, String pageSize) {
		return dao.getPublishArrangesPage(publishArrange,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    

    /**
	 * @see com.vriche.adrm.service.PublishArrangeManager#getPublishArrange(String
	 *      id)
	 */
    public PublishArrange getPublishArrange(final String id) {
        return dao.getPublishArrange(new Long(id));
    }
    /**
	 * @see com.vriche.adrm.service.PublishArrangeManager#getPublishArrangesByIdList(final
	 *      Map idList)
	 */
    public List getPublishArrangesByIdList(final Map idList) {
        return dao.getPublishArrangesByIdList(idList);
    }    

    /**
	 * @see com.vriche.adrm.service.PublishArrangeManager#savePublishArrange(PublishArrange
	 *      publishArrange)
	 */
    public String savePublishArrange(PublishArrange publishArrange) {
    	//�ı���Դ����Ϣ������״̬
    	Long resId = publishArrange.getResourceId();
    	List idListRes = new ArrayList();
    	idListRes.add(resId);
    	
    	Map mp = new HashMap();
       	mp.put("isLocked",publishArrange.getIsLocked());
        mp.put("publishDate",publishArrange.getPublishDate());
        mp.put("idList",idListRes);
        dayInfoDao.updateDayInfoLock(mp); 

        return dao.savePublishArrange(publishArrange).toString();
    }

    /**
	 * @see com.vriche.adrm.service.PublishArrangeManager#removePublishArrange(String
	 *      id)
	 */
    public void removePublishArrange(final String id) {
        dao.removePublishArrange(new Long(id));
    }

     /**
		 * @see com.vriche.adrm.service.PublishArrangeManager#removePublishArranges(String
		 *      Map)
		 */
    public void removePublishArranges(final Map idList) {
        dao.removePublishArranges(idList);
    }
    
    public void saveAllLock(Long carrierId,Integer publishDate,boolean isLockb) {
//    	boolean isLockb=true;
    	Map mp = new HashMap();
    	List idList = new ArrayList();
    	List idListRes = new ArrayList();
    	PublishArrange publish =new PublishArrange();
    	publish.setCarrierId(carrierId);
    	publish.setPublishDate(publishDate);
    	List ls = getPublishArranges(publish);
//    	if(isLock==1){
//    		isLockb=true;
//    	}
    	for(Iterator it = ls.iterator();it.hasNext();){	  
    		PublishArrange publishArr = (PublishArrange)it.next();
//    		publish.setIsLocked(new Boolean(isLockb));
    		idList.add(publishArr.getId());
    		idListRes.add(publishArr.getResourceId());
    	}
    	if(ls.size()==0) {
    		idList.add(new Integer(-1));
    		idListRes.add(new Integer(-1));
    	}
    	mp.put("isLocked",new Boolean(isLockb));
    	mp.put("idList",idList);
        dao.updatePublishArrangeLock(mp);
        //�޸���Դ����Ϣ������״̬
        mp.put("idList",idListRes);
        mp.put("publishDate",publishDate);
        dayInfoDao.updateDayInfoLock(mp); 
        
       
    }
    
    
    
	public void removePublishArranges(PublishArrange publishArrange) {
		Map mp = new HashMap();
		
		Set resourceIds = publishArrange.getResourceIds();
		Integer publishDate = publishArrange.getPublishDate();
		
		Object[] objs = resourceIds.toArray();
		
	
		
		
		List resList = new ArrayList();
		CollectionUtils.addAll(resList,objs);
		mp.put("ResourceIdList",resList);
		mp.put("PublishDate",publishDate);
		List ls = dao.getPublishArrangesByIdList(mp);
		Object[] ids = ConvertUtil.getColFromList(ls,"id");
		List arrangeIdList = new ArrayList();
		CollectionUtils.addAll(arrangeIdList,ids);
		
		mp.clear();
		mp.put("PublishArrangeIdList",arrangeIdList);
		publishArrangeDetailDao.removePublishArrangeDetails(mp);
		
		mp.clear();
		mp.put("PublishArrangeIdList",arrangeIdList);
		this.removePublishArranges(mp);
	}
	
 	private static  boolean getFztvSpecialParam(){
	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
	    if(StringUtils.isEmpty(sysParam.getFztvSpecialParam())) sysParam.setFztvSpecialParam("0");
	    return (sysParam.getFztvSpecialParam().equals("0"))?false:true;
	}
 	
 	private static  boolean getQztvSpecialParam(){
	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
	    if(StringUtils.isEmpty(sysParam.getQztvSpecialParam())) sysParam.setQztvSpecialParam("0");
	    return (sysParam.getQztvSpecialParam().equals("0"))?false:true;
	}
	
	public List getArrangedPublish(PublishArrange publishArrange,boolean rebuild,boolean isRoll,boolean onlyHistory){
		Map mp = new HashMap();

		List all= new ArrayList();
		// ��������±��� isArranged = false;
		boolean isArranged =  publishArrange.getIsArranged().booleanValue();
		boolean arrangeforce = "1".equals(publishArrange.getArrangeforce());
		String referenceDate = StringUtil.getNullValue(publishArrange.getReferenceDate(),"0");
		String orgId = StringUtil.getNullValue(publishArrange.getOrgId(),"1");
		String tvname = SysParamUtil.getTvNameParam();
		
		
		// ����ѡ�еĶ�λ
		Set resourceIds = publishArrange.getResourceIds();
		Object[] objs = resourceIds.toArray();
		
		
//		System.out.println(">>>>>>referenceDate>>����������������������������������������������������>>>>>>>"+ referenceDate);
		System.out.println(">>>>>>getArrangedPublish getVersion>> TDK ����������������������������������������������������>>>>>>>"+ publishArrange.getVersion());
		
//		System.out.println(">>>>>>objs.size>>����������������������������������������������������>>>>>>>"+objs.length);
		
		
		List checkedList = new ArrayList();
		CollectionUtils.addAll(checkedList,objs);
		Integer publishDate = publishArrange.getPublishDate();
		Long carrierId = publishArrange.getCarrierId();
		
		//�������Ķ�λ
		List resLocked = new ArrayList();
		//�Ѿ����Ź��Ķ�λ
		List resArranged = new ArrayList();
		//��û���Ź��Ķ�λ
		List restNoArranged = new ArrayList();

		// �����һ����������Դ���
		getArrangMap(true,mp,checkedList,publishDate);
		
		List resourceHistory = dao.getPublishArrangesByIdListFromHistory(mp);
		
//		System.out.println(">>>>>>resourceHistory.size>>>>>>>>>"+resourceHistory.size());
		
		
		ArrangeUtil.getResourceIdsByState(resLocked,resArranged,restNoArranged,resourceHistory,objs);
		
		
//		System.out.println(">>>>>>objs2222222.size>>>>>>>>>"+objs.length);
		
		//������ؽ������Ѿ����Ź�����û����������Դ�ŵ���Ҫ���±��ŵ���Դ��
		//if(rebuild) CollectionUtils.addAll(restNoArranged,resArranged.iterator());
		


        // �����Ѿ����Ź���
		if(isArranged){
			// ����ʷ�����в��ҵ�ǰѡ��Ķ�λ
			getArrangMap(true,mp,checkedList,publishDate);
			List listResource = dao.getPublishArrangesByIdListFromHistory(mp);
			List listAdver =new ArrayList();
//			List listAdver = publishArrangeDetailDao.getPublishArrangeDetailsByIdListFromHistory(mp);	
//			if(SysParamUtil.isFZTVParam(null)  && publishArrange.getIsEnable().booleanValue()&& resLocked.size()==0){   
//				listAdver = publishArrangeDetailDao.getPublishArrangeDetailsByIdListForPublishSort(mp);
//			}else{
//				listAdver = publishArrangeDetailDao.getPublishArrangeDetailsByIdListFromHistory(mp);  
//			}
			
			System.out.println(">>>>>publishArrange.getIsEnable().booleanValue()>>>>>>>>"+ publishArrange.getIsEnable().booleanValue());
			
			if(publishArrange.getIsEnable().booleanValue()&& resLocked.size()==0){   
				listAdver = publishArrangeDetailDao.getPublishArrangeDetailsByIdListForPublishSort(mp);
			}else{
				listAdver = publishArrangeDetailDao.getPublishArrangeDetailsByIdListFromHistory(mp);  
			}
			
			
			// �ж��Ƿ�ѡ��Ķ�λ������ʷ���ݣ��������Ķ�λ�͵�����ȥ����Դ
			if(restNoArranged.size()>0 && !onlyHistory){
				getArrangMap(false,mp,restNoArranged,publishDate);
				List newResource = dao.getPublishArrangesByIdList(mp);
				if(!arrangeforce) mp.put("CheckFlag","3");
				if(getQztvSpecialParam()){
					mp.remove("PublishDate");
					mp.put("PublishStartDate",publishDate);
					mp.put("PublishEndDate",DateUtil.convertDateToString("yyyyMMdd",""+publishDate,6));
				}
				List newAdver = publishArrangeDetailDao.getPublishArrangeDetailsByIdList(mp);
				
				CollectionUtils.addAll(listResource,newResource.iterator());
				CollectionUtils.addAll(listAdver,newAdver.iterator());
				
// System.out.println(">>>>>>listResource.size>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+listResource.size());
// System.out.println(">>>>>>listAdver.size>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+listAdver.size());
			}
			
// System.out.println(">>>>>>listResource.size>>>>>>>>>"+listResource.size());
// System.out.println(">>>>>>listAdver.size>>>>>>>>>"+listAdver.size());
			if("catv".equals(tvname) || "fztv".equals(tvname)){
				ArrangeUtil.resetList(all,listResource,listAdver,rebuild,isRoll,publishArrange,orgId);
			}else{
				ArrangeUtil3.resetList(all,listResource,listAdver,rebuild,isRoll,publishArrange,orgId);
			}

//			 System.out.println(">>>>>>all.size>>>>>>>>>"+all.size());
		// �������룬������������ģ���Ҫ���±���
		}else{
			
			List resource = new ArrayList();
			List adver = new ArrayList();

			//��������Դ
			if(resLocked.size()>0){
				getArrangMap(true,mp,resLocked,publishDate);
				resource = dao.getPublishArrangesByIdListFromHistory(mp);
				adver = publishArrangeDetailDao.getPublishArrangeDetailsByIdListFromHistory(mp);	
//				 System.out.println(">>>>>>> adver 0000 size>>>>>>>" +adver.size());
				
			}

			//û������Դ
			if(resArranged.size()>0){
					getArrangMap(false,mp,resArranged,publishDate);
					List resourceNoLock = dao.getPublishArrangesByIdList(mp);
					getArrangMap(true,mp,resArranged,publishDate);
					List listResourceHistory = dao.getPublishArrangesByIdListFromHistory(mp);
					
					ArrangeUtil.changeArrangeId(resourceNoLock,listResourceHistory);// �ı�ArrangeId
					resource.addAll(resourceNoLock);
			}	
				
			//û�б��Ź�����Դ
			if(restNoArranged.size()>0){
					getArrangMap(false,mp,restNoArranged,publishDate);
					resource.addAll(dao.getPublishArrangesByIdList(mp));
			}			
			
			
			List noLocked = new ArrayList();
			if(restNoArranged.size() > 0) resArranged.addAll(restNoArranged);
			if(resArranged.size() > 0) noLocked.addAll(resArranged);
			
			//��������û�����Ĺ��
			if(noLocked.size()>0){
				getArrangMap(false,mp,noLocked,publishDate);
				if(!arrangeforce) mp.put("CheckFlag","3");
				if(getQztvSpecialParam()){
					mp.remove("PublishDate");
					mp.put("PublishStartDate",publishDate);
					mp.put("PublishEndDate",DateUtil.convertDateToString("yyyyMMdd",""+publishDate,6));
				}
				adver.addAll(publishArrangeDetailDao.getPublishArrangeDetailsByIdList(mp));
			}

//			System.out.println(">>>>>>> adver 11111111111111111111111111111111111111111 mp>>>>>>>" +mp); 
//			System.out.println(">>>>>>> adver 11111111111111111111111111111111111111111 size>>>>>>>" +adver.size()); 
//			System.out.println(">>>>>>> resArranged.size()>>>>>>>" + resArranged.size());
//			System.out.println(">>>>>>> noLocked.size()>>>>>>>" + noLocked.size());
			
			if("catv".equals(tvname)|| "fztv".equals(tvname)){
				ArrangeUtil.resetList(all,resource,adver,rebuild,isRoll,publishArrange,orgId);	
			}else{
				ArrangeUtil3.resetList(all,resource,adver,rebuild,isRoll,publishArrange,orgId);	
			}
			
		}	
		
		
		return all;
	}
	
	
	
	public String getTreeGrid(PublishArrange publishArrange,String resIdPrefix,String adverIdPrefix,boolean rebuild,boolean isRoll,boolean onlyHistory) {
		StringBuffer sb = new StringBuffer();
        String orgId = StringUtil.getNullValue(publishArrange.getOrgId(),"1");
		List all = getArrangedPublish(publishArrange,rebuild,isRoll,onlyHistory);
		ArrangeUtil.makeTreeGridXML(sb,all,resIdPrefix,adverIdPrefix,rebuild,orgId);
// System.out.println(">>>>>>> sb.toString()>>>>>>>" + sb.toString());
		return sb.toString();
	}
	

	public Collection getReportColl(PublishArrange publishArrange, boolean rebuild,boolean isRoll,boolean onlyHistory) {
		    Collection adverColl = new ArrayList();
		    List all = getArrangedPublish(publishArrange,rebuild,isRoll,onlyHistory);
		    ArrangeUtil.getReportColl(adverColl,all,publishArrange);
		    return adverColl;
 
	  }   

	public Collection getCollections(final String queryString){
		String carrierName = StringUtil.getParamFromUrl(queryString,"carrierName");
		String resourceIds = StringUtil.getParamFromUrl(queryString,"resourceIds");
		String publishDate = StringUtil.getParamFromUrl(queryString,"publishDate");
		
		Set set =new HashSet();
		Collection coll = new ArrayList();
		
		PublishArrange publishArrange = new PublishArrange();
		publishArrange.setIsArranged(new Boolean(true));
		publishArrange.setIsEnable(new Boolean(false));
		publishArrange.setCarrierName(carrierName);
		publishArrange.setPublishDate(new Integer(publishDate));
		for (int i = 0; i< resourceIds.split(",").length; i++){
			  CollectionUtils.addAll(set,resourceIds.split(","));      
		}
		publishArrange.setResourceIds(set);
		
		List all = getArrangedPublish(publishArrange,false,false,false);  
	    ArrangeUtil.getReportCollForFztv(coll,all);  
      
		return coll;
	}
	
	public Collection getPulishArrangeFormColl(PublishArrange publishArrange) {
	    Collection adverColl = new ArrayList();
	    List all = this.getPublishArranges(publishArrange);
	    ArrangeUtil.getPulishArrangeFormColl(adverColl,all);
	    return adverColl;
	}
	
	public void getArrangMap(boolean isOld,Map mp,List idList,Integer publishDate){
		mp.clear();
		String withResourceSort = SysParamUtil.getWithResourceSort()?"1":"0";
		mp.put("withResourceSort",withResourceSort);
		if(isOld){
			mp.put("ResourceIdList",idList);
		}else{
			mp.put("ResourceIdList",idList);
			mp.put("isArranged",new Integer("0"));
			mp.put("createBy",UserUtil.getCurrentPrincipalUserId());
			mp.put("createDate",DateUtil.getDate());
			mp.put("filePath","");
			mp.put("id",new Long(0));
			mp.put("isEnable",new Boolean(true));
			mp.put("isLocked",new Boolean(false));
			mp.put("memo","");
			mp.put("modifyBy",UserUtil.getCurrentPrincipalUserId());
			mp.put("modifyDate",new Date());
			mp.put("version","0");
		}
		mp.put("PublishDate",publishDate);
	
	}
	
	
	public void savePublishArrangeObjArray(PublishArrange arrange,PublishArrange[] objs) {
		Integer publishDate = new Integer("0");
		List lockedIdList = new ArrayList();
		List unArrangeIdList = new ArrayList();
		List arrangeedIdList = new ArrayList();

		if (objs.length >0)  publishDate = objs[0].getPublishDate();
		// �ų������Ķ�λ
		removeLockedObjs(objs,lockedIdList,unArrangeIdList,arrangeedIdList);
		// ɾ�����±��ŵĹ��
		removeOldObjs(objs,publishDate,arrangeedIdList);
		
		dao.savePublishArrangeObjArray(objs);
		
		Map mp = new HashMap();
		List ids = new ArrayList();
		for(int i = 0 ;i<objs.length;i++){                     
			PublishArrange publishArrange = objs[i];
			Long id = publishArrange.getId();
			ids.add(id);
			mp.put(id,publishArrange.getDetails());
		}  
		publishArrangeDetailDao.savePublishArrangeDetails(mp,ids); 
		
		saveDayangPublishArrange(arrange,objs);
		
	}
	
	// ��Ҫ���´����ݿ���ж�
	public void removeLockedObjs(PublishArrange[] objs,List lockedIdList,List unArrangeIdList,List arrangeedIdList){
		for(int i = 0 ;i<objs.length;i++){
			PublishArrange publishArrange = objs[i];
			boolean isLocked = publishArrange.getIsLocked().booleanValue();
			if(isLocked){
				ArrayUtils.removeElement(objs,publishArrange);
				lockedIdList.add(publishArrange.getResourceId());
			}else{
				boolean isArranged = publishArrange.getIsArranged().booleanValue();
				if(isArranged){
					arrangeedIdList.add(publishArrange.getResourceId());
				}else{
					unArrangeIdList.add(publishArrange.getResourceId());
				}
			}

		}
	}
	
	// �޳����Ź���λ�Ĺ�棬���ڸĳ����±���
	public void removeOldObjs(PublishArrange[] objs,Integer publishDate,List arrangeedIdList){
		Map mp = new HashMap();
		mp.put("PublishDate",publishDate);
		mp.put("ResourceIdList",arrangeedIdList);
		List publishArrangeIds = publishArrangeDetailDao.getArrangeIdByResourceIdDate(mp);

		mp.clear();

		if(publishArrangeIds.size() >0){
			mp.put("PublishArrangeIdList",publishArrangeIds);
			publishArrangeDetailDao.removePublishArrangeDetails(mp);			
		}

	}
    
// �޳�ԭ�����ڵĶ�λ�����ڸĳ����±���
	public Map getPublishArrangeSelect(PublishArrange publishArrange) {
		// TODO Auto-generated method stub
		List ls = this.getPublishArranges(publishArrange);
	    Map reply = new LinkedHashMap();
	    Iterator it = ls.iterator();
	    while(it.hasNext()){
	    	PublishArrange arrange =(PublishArrange)it.next();
	    	String name = arrange.getCarrierName();
	    	if(!reply.containsKey(name)){
		    	reply.put(name,name);   		
	    	}
	    	
	    }
		return reply;
  
	}

	public List getPublishArrangesByIdListFromHistory(PublishArrange publishArrange) {
		Map mp = new HashMap();
		List resList = new ArrayList();
		Set resourceIds = publishArrange.getResourceIds();
		Object[] objs = resourceIds.toArray();
		Integer publishDate = publishArrange.getPublishDate();
		CollectionUtils.addAll(resList,objs);
		mp.put("ResourceIdList",resList);
		mp.put("PublishDate",publishDate);
		return  dao.getPublishArrangesByIdListFromHistory(mp);
	}

	public void uploadFiles(String server,String prot,String user,String pass,String publishDate) {
		
		System.out.println("ftp start.................");  
		
		System.out.println(server+">>"+prot+">>"+user+">>"+pass+"*****"+publishDate);  
		
//		UploadUtil.putFtpFile(server,prot,user,pass,publishDate);  
		
		
		  FTP ftp = new FTP(user,pass,server,Integer.valueOf(prot));
		  ftp.connectServer();
//		  ftp.listRemoteAllFiles("/");
		  System.out.println(server+">>3>>"+user+">>"+pass+"*****"+publishDate);  
		
		  String path = "";     
		  String fileName = FileUtil.getDateDir(new Integer(publishDate));
//		  System.out.println(fileName+">>>4>>");  
		  
		   File file_in = new File(fileName);  
		   File[] file = file_in.listFiles();

		   for(int i=0;i<file.length;i++){
			   String f = fileName+Constants.FILE_SEP+ file[i].getName();
//			   System.out.println(f+">>>>>"+i);Constants.FILE_SEP+
			   ftp.upFile(Constants.FILE_SEP, file[i].getName(), file[i].getAbsolutePath());
			
		   }
		
		//  ftp.downFile("/���Ա���", "���Ա���.mmap", "D:\development\workspace\swing");
		  
		  ftp.closeConnect();
	}  	
	
public int downloadAdvers(PublishArrange publishArrange,int type) {
	
//		SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
//	//	��Ƶ����Ƶ��
//		int mode = (sysParam.getPiblishModelParam().equals("0")|| sysParam.getChannelModelParam() == null)?1:Integer.parseInt(sysParam.getChannelModelParam());
	
		return saveFileBroFile(publishArrange,type);
	
	}  

	
	public int saveFileBroFile(PublishArrange publishArrange,int type) {  
		    int state = 0;
			List advers = new ArrayList();
			Integer publishDate = publishArrange.getPublishDate();
			String carrierName = publishArrange.getCarrierName();
			Object[] resourceIds =publishArrange.getResourceIds().toArray();
			// ����Ŀ¼
			String myDir = FileUtil.getDirTxt(carrierName,resourceIds,publishDate,type);
			String myDateDir= FileUtil.getDateDir(publishDate);
			String myFile = "";
			if(type == 1) myFile =FileUtil.getFileName(carrierName,resourceIds,publishDate);
			List resourceList =new ArrayList();
			// ���챣������
			if(type!=3&&type!=4){
				resourceList = this.getPublishArrangesByIdListFromHistory(publishArrange);
			}
			
//			Collections.sort(resourceList,new PublishArrangeComparator());
			
			
			
//			for(Iterator it = resourceList.iterator();it.hasNext();){
//				PublishArrange publish = (PublishArrange)it.next();
//				
//				System.out.println("first sort ttttttttttt>>>myFile>>>>>>"+ DateUtil.getBroadcastTimeFormatStart(publish.getBroadcastStartTime()) +"__"+ publish.getResourceMeno());
//				
//			}
			
			
			
//			if(type == 2){
//				Collections.sort(resourceList,new PublishArrangeEntryComparator());
//			}
			
			int seq = 1;
			for(Iterator it = resourceList.iterator();it.hasNext();){
				PublishArrange publish = (PublishArrange)it.next();
				Long resourceId = publish.getResourceId();
				Map mp = new HashMap();
				List resList = new ArrayList();
				resList.add(resourceId);
				mp.put("PublishDate",publishDate);
				mp.put("ResourceIdList",resList);  
				List oneResourceAdvers = new ArrayList();

				oneResourceAdvers = publishArrangeDetailDao.getPublishArrangeDetailsByIdListFromHistory(mp);
								
//				String fileString[]  = this.fileContent(publish,oneResourceAdvers,type);
				String fileString  = this.fileContent(publish,oneResourceAdvers,type);
				// �ļ��е�����
				
				
				if(type == 2){
					advers.clear();
					advers.add(fileString);
					String se = ""+seq++;
					if(seq<11) se ="0"+se;
					myFile = se +" "+ publish.getResourceName();

//					String broTime = DateUtil.getBroadcastTimeFormatStart2(publish.getBroadcastStartTime());
//					myFile = broTime +" "+ myFile;
//					myFile = myFile +" "+ broTime;
					
//					myFile =  myFile.matches("[^\\s\\\\/:\\*\\?\\\"<>\\|](\\x20|[^\\s\\\\/:\\*\\?\\\"<>\\|])*[^\\s\\\\/:\\*\\?\\\"<>\\|\\.]$");
//					System.out.println("ttttttttttttttttttttttttttttttttttttttttttttttttttt>>>myFile>>>>>>"+ publish.getBroadcastStartTime());
//					System.out.println("after sort ttttttttttttttttttttt>>>myFile>>>>>>"+publish.getBroadcastStartTime()+"__"+ publish.getResourceMeno());
					
					
					// �����ļ�
					FileUtil.saveFile(myDir,myFile,advers);
					// ѹ���ļ�
//					FileUtil.zipFile(myDateDir,publishDate.toString());
					// �г� "/download/adver/" �µ�����zip�ļ�
//					FileUtil.listFile(FileUtil.getUploadDir());		
				}else{
					advers.add(fileString);
				}
				}
			
			if(type == 3){
				// �����ļ�
				Map mps = new HashMap();
				
				List matter = new ArrayList();
				List advType = new ArrayList();
				List advseg = new ArrayList();
				List advcfg = new ArrayList();
				
				List matterls = matterDao.getMattersByIdList(mps);
				List advTypels = industryDao.getIndustrys(new Industry());
				//����Ӵ˲������Է��޷����գ��ᵼ����Ч��Է���Ȼ����
//				mps.put("enable","1"); 
				List advsegls = workspanDao.getWorkspansByIdList(mps);  
				         
//				mps.put("resourceType","3");
				mps.put("version",publishDate.toString().substring(0,4));
				mps.put("PublishDate",publishDate);
				List advsfgls = workspanDao.getWorkspansByIdList(mps);
				
//				System.out.println("advsfgls  ttttttttttttttttttttt>>>advsfgls.size()>>>>>>"+advsfgls.size());
				
				
				String fileString1  = this.fileContent1(matterls);  //  ����Ŀ�� ��� 50 �ֽ�
				String fileString2  = this.fileContent2(advTypels); // ������Ϳ� 18�ֽ�
				String fileString3  = this.fileContent3(advsegls); //���ʱ�ο�
				String fileString4  = this.fileContent4(advsfgls); //ʱ�����ñ�
				
				matter.add(fileString1);
				advType.add(fileString2);
				advseg.add(fileString3);
				advcfg.add(fileString4);
				
				boolean success = FileUtil.saveFile3(myDir,"����Ŀ��",matter);
				
				System.out.println("saveFileBroFile success  ttttttttttttttttttttt>>>>>>"+ success);
				
				if(!success) state = 1; //ftp ���ӳ���
				FileUtil.saveFile3(myDir,"������Ϳ�",advType);
				FileUtil.saveFile3(myDir,"���ʱ�ο�",advseg);
				FileUtil.saveFile3(myDir,"ʱ�����ñ�",advcfg);
				
				advers.clear();
				
				mps.put("carrierId",publishArrange.getCarrierId());  
				
				List oneResourceAdvers = publishArrangeDetailDao.getPublishArrangeDetailsByIdLists3(mps);
				
				String fileString  = this.fileContent(null,oneResourceAdvers,type);
				advers.add(fileString);
				
				myFile  = FileUtil.getFileName3(carrierName,resourceIds,publishDate);
				
				
//				System.out.println("saveFileBroFile myFile  ttttttttttttttttttttt>>>>>>>"+ myFile);
				
				FileUtil.saveFile3(myDir,myFile,advers);
			}
			
//			xmtv  �������һ������ΪXML
			if(type == 4){
				// �����ļ�
				Map mps = new HashMap();
				
				advers.clear();
				mps.put("PublishDate",publishDate);
				mps.put("carrierId",publishArrange.getCarrierId());
				
				List oneResourceAdvers = publishArrangeDetailDao.getPublishArrangeDetailsByIdLists4(mps);
				String fileString  = this.fileContent(null,oneResourceAdvers,type);
				advers.add(fileString);

				PublishArrangeDetail publishArrangeDetail=(PublishArrangeDetail) oneResourceAdvers.get(0);
				myFile = publishArrangeDetail.getCustomerName();
//                �����xml�ļ�
				FileUtil.saveFile4(myDir,myFile,advers);
//				������ı��ļ�
				PublishArrange publish =  new PublishArrange();
				String fileStringTxt  = this.fileContent(publish,oneResourceAdvers,type);
				advers.clear();
				advers.add(fileStringTxt);
				FileUtil.saveFile(myDir,myFile,advers);
				
				
				
				
				
			}
//			sjz 
			if(type == 1){
				// �����ļ�
				FileUtil.saveFile(myDir,myFile,advers);
				// ѹ���ļ�
//				FileUtil.zipFile(myDateDir,publishDate.toString());
				// �г� "/download/adver/" �µ�����zip�ļ�
//				FileUtil.listFile(FileUtil.getUploadDir());		
			}
			
			// ѹ���ļ�
			FileUtil.zipFile(myDateDir,publishDate.toString());
			
			return state;

	}

	/*���ݵ���̨�ų�����Ƶ�� 
	B3 1637
	B4 1638
	��A1 1653
	��A2 1654
	��A3 1768
	TA7 1662
	TA8 1663
	1637,1638,1653,1654,1768,1662,1663*/
	private boolean checkIsWithOutRes(String res_id){

		String[] withoutIds = new String[]{"1637","1638","1653","1654","1768","1662","1663"};
		Collection coll = new ArrayList<String>();  
		CollectionUtils.addAll(coll, withoutIds);
		
		return  coll.contains(String.valueOf(res_id));
	}
	private boolean checkIsWithOutRes2(String res_id){

		String[] withoutIds = new String[]{"1637","1638","1653","1654","1768","1662","1663"};
		Collection coll = new ArrayList<String>();  
		CollectionUtils.addAll(coll, withoutIds);
		
		return  coll.contains(String.valueOf(res_id));
	}
	


	private String fileContent(PublishArrange publish,List oneResourceAdvers,int type){
		 boolean resourceDisplayParam = SysParamUtil.getResourceDisplay();
		Iterator it = oneResourceAdvers.iterator();
		int size = oneResourceAdvers.size();
		String newline = "\r\n";
	
		if(type == 1) size = size +1;
		String[] arr = new String[size];
		int i = 0;
		StringBuffer str= new StringBuffer();
		
		if(type == 1){
//			arr[i++] = publish.getResourceName() + publish.getResourceMeno()+"," +"00001" +","+publish.getResourceTotalTimes()+",\n";
			Integer usedTimes = publish.getResourceUsedTimes();
			usedTimes = usedTimes == null ? new Integer(0):usedTimes;
			
			str.append(publish.getResourceName() +"," +"00001" +","+ usedTimes +",");
			str.append(newline);
			
			
			while(it.hasNext()){
//				StringBuffer str= new StringBuffer();
				
				PublishArrangeDetail publishArrangeDetail = (PublishArrangeDetail)it.next();
//				PublishArrange publishArrange = this.getPublishArrange(publishArrangeDetail.getPublishArrangeId().toString());
				
	
				str.append(StringUtil.null2String(publishArrangeDetail.getMatterName()));
				str.append(publishArrangeDetail.getMatterEdit());
				str.append(",");
				str.append(StringUtil.null2String(publishArrangeDetail.getTapeCode()));
				str.append(",");
				str.append(StringUtil.null2String(publishArrangeDetail.getMatterLength())+",");
//				arr[i++] =  str.toString();
				str.append(newline);
			}
			
		}

		if(type == 2){
				while(it.hasNext()){
//					StringBuffer str= new StringBuffer();
					
					PublishArrangeDetail publishArrangeDetail = (PublishArrangeDetail)it.next();
//					PublishArrange publishArrange = this.getPublishArrange(publishArrangeDetail.getPublishArrangeId().toString());
					
					str.append(" "+StringUtil.null2String(publishArrangeDetail.getMatterName()));
					str.append("("+publishArrangeDetail.getMatterEdit()+")  ");
					str.append(", ");
					str.append(StringUtil.null2String(publishArrangeDetail.getTapeCode()));
					str.append(" , ");
					str.append(StringUtil.null2String(publishArrangeDetail.getMatterLength())+" ;");
//					arr[i++] =  str.toString();
					str.append(newline);
				}
		}
		/*���ݵ���̨�ų�����Ƶ�� 
		B3 1637
		B4 1638
		��A1 1653
		��A2 1654
		��A3 1768
		TA7 1662
		TA8 1663
		1637,1638,1653,1654,1768,1662,1663*/
		
		if(type == 3){
	
//			String[] withoutIds = new String[]{"1637","1638","1653","1654","1768","1662","1663"};
//			Collection coll = new ArrayList<String>();  
//			CollectionUtils.addAll(coll, withoutIds);

			String spanId="";
			long matterLength=0;
			str.append("<playlist>"); 
			while(it.hasNext()){
//				StringBuffer str= new StringBuffer();

				PublishArrangeDetail publishArrangeDetail = (PublishArrangeDetail)it.next();
				
				int res_id =  publishArrangeDetail.getResourceId().intValue(); 
				int span_id =  publishArrangeDetail.getContractId().intValue(); //ʵ������ wokspan_id
				int span_sort_id =  Integer.valueOf(StringUtil.getNullValue(publishArrangeDetail.getWorkSpanSort(),"0")); //ʵ������ wokspan_id
//				if(checkIsWithOutRes(String.valueOf(res_id))) continue;
//				System.out.println("fileContent>>>>>>> 89898989   span_sort_id rrrrrrrrrr >>>>>>>"+res_id+"  <>   "+ span_sort_id);
				System.out.println("fileContent>>>>>>> 89898989   span_sort_id rrrrrrrrrr >>>>>>>"+res_id+"  <>   "+ publishArrangeDetail.getWorkSpanSort());
				if(span_sort_id == 2) continue;
				
				
//				PublishArrange publishArrange = this.getPublishArrange(publishArrangeDetail.getPublishArrangeId().toString());
//				System.out.println("publishArrangeDetail.getPublishDate().longValue() rrrrrrrrrr >>>>>>>"+ publishArrangeDetail.getPublishDate());
				
				String playTime = "";
				long startTime = Long.valueOf(StringUtil.getNullValue(publishArrangeDetail.getPublishDate(), "0")).longValue();
				
//				System.out.println("startTime rrrrrrrrrr >>>>>>>"+ startTime);
				
				if(startTime>86400){
					String playTime1 = DateUtil.formatLongToTimeStr3(startTime*1000);
					String playTime2 = DateUtil.formatTime(startTime*1000,"m:s");
					playTime = StringUtils.trim(playTime1+":"+playTime2);
				}else{
					 playTime = DateUtil.formatTime(startTime*1000,"h:m:s");
					 playTime = StringUtils.trim(playTime);
				}
				
				
				
//				String playTime = DateUtil.formatTime(Long.valueOf(StringUtilsv.getNullValue(publishArrangeDetail.getPublishDate(), "0")).longValue()*1000,"h:m:s");
//				playTime = StringUtils.trim(playTime);
//				String  matterId=publishArrangeDetail.getMatterId().toString();
//				String  matterId=publishArrangeDetail.getTapeCode();
				long id1 = Long.valueOf(publishArrangeDetail.getTapeCode())+50000;
				String matterId = String.format("%08d", id1);   
				
				
//				String  resourceId=publishArrangeDetail.getResourceId().toString();
			
				
				long id2 = span_id + 7000;
				String work_span_id = String.format("%08d", id2);   
				
				
//				long playId = publishArrangeDetail.getId()+5000000; //4013931
				long playId = publishArrangeDetail.getId()+6000000; //4013931
				
//				for(int j=8-matterId.length();j>0;j--){
//					matterId="0"+matterId;
//				}
//				for(int j=8-resourceId.length();j>0;j--){
//					resourceId="0"+resourceId;       
//				}
				if(spanId.equals(work_span_id)) {
					long startTime2 = Long.valueOf(StringUtil.getNullValue(publishArrangeDetail.getPublishDate(), "0")).longValue();
					
					if(startTime2>86400){
						String playTime1 = DateUtil.formatLongToTimeStr3(startTime2*1000);
						String playTime2 = DateUtil.formatTime(startTime2*1000,"m:s");
						playTime = StringUtils.trim(playTime1+":"+playTime2);
					}else{
						 playTime = DateUtil.formatTime(startTime2*1000,"h:m:s");
						 playTime = StringUtils.trim(playTime);
					}
					
					
					
//				    playTime = DateUtil.formatTime((Long.valueOf(StringUtilsv.getNullValue(publishArrangeDetail.getPublishDate(), "0")).longValue()+matterLength)*1000,"h:m:s");
//					playTime=DateUtil.formatTime((publishArrangeDetail.getPublishDate().longValue()+matterLength)*1000,"h:m:s");
					matterLength+=Long.parseLong(publishArrangeDetail.getMatterLength());
				}
				if(!spanId.equals(work_span_id)) {spanId=work_span_id;matterLength=Long.parseLong(publishArrangeDetail.getMatterLength());}
				str.append("<detail advseg_name=\""+ StringUtil.null2String(publishArrangeDetail.getSpecificValue())  +"\"");   
				
//				System.out.println("publishArrangeDetail.getSpecificValue() rrrrrrrrrr >>>>>>>"+playTime+"_"+ publishArrangeDetail.getSpecificValue());
				
				str.append(" startplaytime=\""+StringUtil.null2String(StringUtils.trim(playTime)) +"\"");  
				str.append(" play_index=\""+StringUtil.null2String(publishArrangeDetail.getPublishSort()) +"\"");
				str.append(" mat_id=\""+StringUtil.null2String(matterId) +"\"");
				str.append(" adv_edition=\""+StringUtil.null2String(publishArrangeDetail.getMatterName()+"("+publishArrangeDetail.getMatterEdit()+")") +"\"");
				str.append(" adv_len=\""+Integer.parseInt(StringUtil.null2String(publishArrangeDetail.getMatterLength()))*25 +"\"");
//				str.append(" play_id=\""+StringUtil.null2String(publishArrangeDetail.getId()) +"\"");
				str.append(" play_id=\""+ playId +"\"");
				str.append(" adv_segid=\""+StringUtil.null2String(work_span_id) +"\"/>");
			}
			str.append("</playlist>"); 
	}
		if(type == 4){
			
			if(publish == null){
				int index=1;
				str.append("<?xml version=\"1.0\" encoding=\"GB2312\"?>");
				str.append(newline);
				str.append("<Import>");
				str.append(newline);
				while(it.hasNext()){
//					StringBuffer str= new StringBuffer();

					PublishArrangeDetail publishArrangeDetail = (PublishArrangeDetail)it.next();
					String publishDate=publishArrangeDetail.getPublishDate().toString();
					
					String  tapeCode=publishArrangeDetail.getTapeCode();
					for(int j=8-tapeCode.length();j>0;j--){
						tapeCode="0"+tapeCode;
					}
					
					
					String broadTime = publishArrangeDetail.getPublishMemo();
					broadTime = broadTime==null?"0":broadTime;
					broadTime = StringUtil.second2HMS3(Long.parseLong(broadTime)*1000,true);
					String resourceName = publishArrangeDetail.getResourceName();
					
					str.append("	<Channel chnName=\""+ StringUtil.null2String(publishArrangeDetail.getCustomerName())  +"\"");
					str.append(" BroadDate=\""+DateUtil.SetDateFormat(publishDate,"yyyy-MM-dd") +"\">");
					str.append(newline);
					str.append("		<ADName>"+StringUtil.null2String(publishArrangeDetail.getMatterName()) +"</ADName>");
					str.append(newline);
					str.append("		<SoundName>"+StringUtil.null2String(publishArrangeDetail.getMatterEdit()) +"</SoundName>");
					str.append(newline);
					str.append("		<FileLength>"+Long.parseLong(publishArrangeDetail.getMatterLength())*1000 +"</FileLength>");
					str.append(newline);
					str.append("		<Path>"+StringUtil.null2String(tapeCode) +"</Path>");
					str.append(newline);
//					str.append("		<BroadTime>"+ broadTime +"</BroadTime>");
					str.append("		<BroadTime>"+ resourceName +"</BroadTime>");
					str.append(newline);
					str.append("		<BroadOrder>"+index++ +"</BroadOrder>");
					str.append(newline);
					str.append("		<Class>"+StringUtil.null2String(publishArrangeDetail.getSpecificName()) +"</Class>");
					str.append(newline);
					str.append("	</Channel>");
					str.append(newline);
				}
				str.append("</Import>"); 
			}else{
				
				int strLength = 20;
				str.append(" "+ StringUtil.omitString("�������",strLength," "));
				str.append(" "+ StringUtil.omitString("���汾",strLength," "));
				str.append(" "+ StringUtil.omitString("����",strLength," "));
				str.append(" "+ StringUtil.omitString("�Ŵ���",strLength," "));
				str.append(" "+ StringUtil.omitString("��λ��",strLength," "));
				str.append(newline);
				str.append("-----------------------------------------------------------------------------------------------------------");
				str.append(newline);
				
				while(it.hasNext()){
					PublishArrangeDetail publishArrangeDetail = (PublishArrangeDetail)it.next();
					str.append(" "+ StringUtil.omitString(publishArrangeDetail.getMatterName(),strLength," "));
					str.append(" "+ StringUtil.omitString("("+ publishArrangeDetail.getMatterEdit()+")",strLength," "));
					str.append(" "+ StringUtil.omitString(publishArrangeDetail.getMatterLength(),strLength," "));
					str.append(" "+ StringUtil.omitString(publishArrangeDetail.getTapeCode(),strLength," "));
					String resourceName = publishArrangeDetail.getResourceName();
					str.append(" "+ resourceName );
					str.append(newline);
				}
			}
			
			
	}

		return str.toString();
	}
	
	
	
	private String fileContent1(List oneResourceAdvers){ 
		Iterator it = oneResourceAdvers.iterator();
		
		StringBuffer str= new StringBuffer();
			str.append("<mat_info>"); 
			while(it.hasNext()){

				Matter matter = (Matter)it.next();
//				String  matterId=matter.getId().toString();
//				String  matterId=matter.getTapeCode();
//				long id = matter.getId().longValue()+50000;
				long id = Long.valueOf(matter.getTapeCode())+50000; 
				String matterId = String.format("%08d", id);    
//				String matterId = String.format("%08d", matter.getTapeCode());    
				
//				for(int j=8-matterId.length();j>0;j--){
//					matterId="0"+matterId;
//				}     
				
				
				String edit  = matter.getEdit();
				String name = matter.getName();

				edit = edit.replaceAll("&","&amp;");
				edit = edit.replaceAll("<","&lt;");
				edit = edit.replaceAll("\"","&#34;");  
				name = name.replaceAll("&","&amp;");
				name = name.replaceAll("<","&lt;");
				name = name.replaceAll("\"","&#34;");    
				
				String typeId = "";  
				if(matter.getBrandId()!=null&&!matter.getBrandId().toString().equals("0")){
					typeId = matter.getBrandId().toString().length()==1?"0"+matter.getBrandId():matter.getBrandId().toString();
				}
				str.append("<mat mat_id=\""+ StringUtil.null2String(matterId)  +"\"");
				
				if(name.equals(edit)) name = "";
				
				name = StringUtil.null2String(name+"("+edit+")");
				
				int byteSize = StringUtil.byteLength(name);
				int maxLen = 50 ;
				if(byteSize > maxLen){
					name = StringUtil.substring(name, maxLen);
				}
				
				str.append(" adv_edition=\""+ name +"\"");  
				String len = StringUtil.getNullValue(matter.getLength(),"0");
//				if("0".equals(len)){
//					System.out.println("matterId  ttttttttttttttttttttt>>6666666 >>>>>>"+ matterId);
//				}
//				str.append(" adv_len=\""+StringUtil.null2String(new Integer((int)Double.parseDouble(matter.getLength())*25)) +"\"");
				str.append(" adv_len=\""+StringUtil.null2String(new Integer((int)Double.parseDouble(len)*25)) +"\"");
				str.append(" type_id=\""+StringUtil.null2String(typeId) +"\"/>");  
			}
			str.append("</mat_info>");
	

		return str.toString();
	}
	private String fileContent2(List oneResourceAdvers){
		Iterator it = oneResourceAdvers.iterator();
		
		StringBuffer str= new StringBuffer();
			str.append("<advtypelist>"); 
			while(it.hasNext()){

				Industry matterType = (Industry)it.next();
				String typeId=matterType.getId().toString().length()==1?"0"+matterType.getId():matterType.getId().toString();
				if(!typeId.equals("00")){ 
					str.append("<detail type_id=\""+ StringUtil.null2String(typeId)  +"\"");
					int byteSize = StringUtil.byteLength(StringUtil.null2String(matterType.getName()));
					if(byteSize >18){
						str.append(" type_name=\""+ StringUtil.substring(StringUtil.null2String(matterType.getName()), 18)  +"\"/>");
					}else{
						str.append(" type_name=\""+ StringUtil.null2String(matterType.getName()) +"\"/>");
					}
					
				}

			}
			str.append("</advtypelist>"); 
	

		return str.toString();
	}
	private String fileContent3(List oneResourceAdvers){  
		Iterator it = oneResourceAdvers.iterator();

		StringBuffer str= new StringBuffer();
			str.append("<advseglist>"); 
			while(it.hasNext()){
				Workspan workspan = (Workspan)it.next();
				String weekdayLength="";
				String length = "";         
				if(workspan.getMonLength()!=null && ! "".equals(workspan.getMonLength())){
					weekdayLength="1";  
					length = ""+(Integer.parseInt(workspan.getMonLength())); 
				}else{
					weekdayLength="0";
				}
				if(workspan.getTueLength()!=null && !"".equals(workspan.getTueLength())){
					weekdayLength+="1";
					length = ""+(Integer.parseInt(workspan.getTueLength()));
				}else{
					weekdayLength+="0";
				}
				if(workspan.getWenLength()!=null && !"".equals(workspan.getWenLength())){
					weekdayLength+="1";
					length = ""+(Integer.parseInt(workspan.getWenLength()));
				}else{
					weekdayLength+="0";
				}
				if(workspan.getThiLength()!=null && !"".equals(workspan.getThiLength())){
					weekdayLength+="1";
					length = ""+(Integer.parseInt(workspan.getThiLength()));
				}else{
					weekdayLength+="0";
				}
				if(workspan.getFriLength()!=null && !"".equals(workspan.getFriLength())){
					weekdayLength+="1";
					length = ""+(Integer.parseInt(workspan.getFriLength()));
				}else{
					weekdayLength+="0";
				}
				if(workspan.getSatLength()!=null && !"".equals(workspan.getSatLength())){
					weekdayLength+="1";
					length = ""+(Integer.parseInt(workspan.getSatLength()));
				}else{
					weekdayLength+="0";
				}
				if(workspan.getSunLength()!=null && ! "".equals(workspan.getSunLength())){
					weekdayLength+="1";   
					length = ""+(Integer.parseInt(workspan.getSunLength()));
				}else{
					weekdayLength+="0";
				}    

				Long startTime = workspan.getBroadcastStartTime().longValue();
				String playTime ="";
				if(startTime>86400){
					String playTime1 = DateUtil.formatLongToTimeStr3(workspan.getBroadcastStartTime().longValue()*1000);
					String playTime2 = DateUtil.formatTime(workspan.getBroadcastStartTime().longValue()*1000,"m:s");
					playTime = StringUtils.trim(playTime1+":"+playTime2);
				}else{
					 playTime = DateUtil.formatTime(workspan.getBroadcastStartTime().longValue()*1000,"h:m:s");
					 playTime = StringUtils.trim(playTime);
				}
				
			
				
//				String  spanId =workspan.getResourceId().toString();
//				long id = workspan.getResourceId().longValue()+5000;
				long id = workspan.getId().longValue()+7000;
				String spanId = String.format("%08d", id);    
//				String spanId = String.format("%08d", workspan.getResourceId());    
				
//				System.out.println("spanId2  ttttttttttttttttttttt>>6666666 >>>>>>"+ spanId2);
				
				 
//				for(int j=8-spanId.length();j>0;j--){
//					spanId="0"+spanId;
//				}
//				
//				System.out.println("spanId1  ttttttttttttttttttttt>>6666666 >>>>>>"+ spanId);
				
				String channelId = workspan.getCarrierId().toString();    
//				System.out.println("workspan.getCarrierId()  ttttttttttttttttttttt>>6666666 >>>>>>"+ channelId);
				
				String channelCode= FileUtil.getChannelCodeByName(channelId,2);
				
				

//				List carriers = (List)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIER_ALL);
//				for(Iterator its=carriers.iterator();its.hasNext();){
//					Carrier channel=(Carrier)its.next();
//					if(workspan.getResourceId().intValue()==1424) 
//					if(channel.getId().intValue()==workspan.getId().intValue()){
//						channelId=channel.getChannelId().toString();
//					} 
//							
//				}              
				
				if(!"".equals(channelCode)){
					String  cancelFlag = workspan.getResourceType().intValue()==1?"0":"1";
					
					System.out.println("FileUtil.getChannelCodeByName  ttttttttttttttttttttt>>6666666 >>>>>>"+ channelId+" "+channelCode);
					
					str.append("<detail advseg_name=\""+ StringUtil.null2String(workspan.getMemo())  +"\"");
					str.append(" chan_id=\""+StringUtil.null2String(channelCode) +"\"");
					str.append(" startplaytime=\""+StringUtil.null2String(playTime.trim()) +"\"");
					str.append(" seg_len=\""+StringUtil.null2String(length) +"\""); 
					str.append(" date_limit=\""+StringUtil.null2String("1") +"\"");
					str.append(" startdate=\""+StringUtil.null2String(workspan.getBeginDate()) +"\"");
					str.append(" enddate=\""+StringUtil.null2String(workspan.getEndDate()) +"\"");
					str.append(" weekday=\""+StringUtil.null2String(weekdayLength) +"\"");
					str.append(" cancel_flag=\""+StringUtil.null2String(cancelFlag) +"\""); 
					str.append(" adv_segid=\""+StringUtil.null2String(spanId) +"\"/>");
				}
				
//				if(channelId.length()<10) channelId="0"+channelId;
//				String  cancelFlag = workspan.getResourceType().intValue()==1?"0":"1";

				}
			str.append("</advseglist>");  
	
		return str.toString();
	}
	
	
//	private String fileContent3(List oneResourceAdvers){  
//		Iterator it = oneResourceAdvers.iterator();
//
//		StringBuffer str= new StringBuffer();
//			str.append("<advseglist>"); 
//			while(it.hasNext()){
//				Workspan workspan = (Workspan)it.next();
//				String weekdayLength="";
//				String length = "";         
//				if(workspan.getMonLength()!=null&&!workspan.getMonLength().equals("")){
//					weekdayLength="1";  
//					length = ""+(Integer.parseInt(workspan.getMonLength())+workspan.getPropertiyTime().intValue()); 
//				}else{
//					weekdayLength="0";
//				}
//				if(workspan.getTueLength()!=null&&!workspan.getTueLength().equals("")){
//					weekdayLength+="1";
//					length = ""+(Integer.parseInt(workspan.getTueLength())+workspan.getPropertiyTime().intValue());
//				}else{
//					weekdayLength+="0";
//				}
//				if(workspan.getWenLength()!=null&&!workspan.getWenLength().equals("")){
//					weekdayLength+="1";
//					length = ""+(Integer.parseInt(workspan.getWenLength())+workspan.getPropertiyTime().intValue());
//				}else{
//					weekdayLength+="0";
//				}
//				if(workspan.getThiLength()!=null&&!workspan.getThiLength().equals("")){
//					weekdayLength+="1";
//					length = ""+(Integer.parseInt(workspan.getThiLength())+workspan.getPropertiyTime().intValue());
//				}else{
//					weekdayLength+="0";
//				}
//				if(workspan.getFriLength()!=null&&!workspan.getFriLength().equals("")){
//					weekdayLength+="1";
//					length = ""+(Integer.parseInt(workspan.getFriLength())+workspan.getPropertiyTime().intValue());
//				}else{
//					weekdayLength+="0";
//				}
//				if(workspan.getSatLength()!=null&&!workspan.getSatLength().equals("")){
//					weekdayLength+="1";
//					length = ""+(Integer.parseInt(workspan.getSatLength())+workspan.getPropertiyTime().intValue());
//				}else{
//					weekdayLength+="0";
//				}
//				if(workspan.getSunLength()!=null&&!workspan.getSunLength().equals("")){
//					weekdayLength+="1";   
//					length = ""+(Integer.parseInt(workspan.getSunLength())+workspan.getPropertiyTime().intValue());
//				}else{
//					weekdayLength+="0";
//				}    
//
//				String playTime = DateUtil.formatTime(workspan.getBroadcastStartTime().longValue()*1000,"h:m:s");
//				String  spanId=workspan.getResourceId().toString();
//				for(int j=8-spanId.length();j>0;j--){
//					spanId="0"+spanId;
//				}
//				String channelId=workspan.getCarrierId();      
//
//                   
//				if(channelId.length()<10) channelId="0"+channelId;
//				String  cancelFlag = workspan.getResourceType().intValue()==1?"0":"1";
//				str.append("<detail advseg_name=\""+ StringUtil.null2String(workspan.getMemo())  +"\"");
//				str.append(" chan_id=\""+StringUtil.null2String(channelId) +"\"");
//				str.append(" startplaytime=\""+StringUtil.null2String(playTime.trim()) +"\"");
//				str.append(" seg_len=\""+StringUtil.null2String(length) +"\""); 
//				str.append(" date_limit=\""+StringUtil.null2String("1") +"\"");
//				str.append(" startdate=\""+StringUtil.null2String(workspan.getBeginDate()) +"\"");
//				str.append(" enddate=\""+StringUtil.null2String(workspan.getEndDate()) +"\"");
//				str.append(" weekday=\""+StringUtil.null2String(weekdayLength) +"\"");
//				str.append(" cancel_flag=\""+StringUtil.null2String(cancelFlag) +"\""); 
//				str.append(" adv_segid=\""+StringUtil.null2String(spanId) +"\"/>");
//				}
//			str.append("</advseglist>");  
//	
//		return str.toString();
//	}
	private String fileContent4(List oneResourceAdvers){
		Iterator it = oneResourceAdvers.iterator();
		StringBuffer str= new StringBuffer();
			str.append("<advseg_cfglist>"); 
			while(it.hasNext()){

				Workspan workspan = (Workspan)it.next();

				String length="";
				if(workspan.getSunLength()!=null&&!workspan.getSunLength().equals("")) {length=workspan.getSunLength();}
				if(workspan.getMonLength()!=null&&!workspan.getMonLength().equals("")) {length=workspan.getMonLength();}
				if(workspan.getTueLength()!=null&&!workspan.getTueLength().equals("")) {length=workspan.getTueLength();}
				if(workspan.getWenLength()!=null&&!workspan.getWenLength().equals("")) {length=workspan.getWenLength();}
				if(workspan.getThiLength()!=null&&!workspan.getThiLength().equals("")) {length=workspan.getThiLength();}
				if(workspan.getFriLength()!=null&&!workspan.getFriLength().equals("")) {length=workspan.getFriLength();}
				if(workspan.getSatLength()!=null&&!workspan.getSatLength().equals("")) {length=workspan.getSatLength();}   
//				String playTime = DateUtil.formatTime(workspan.getBroadcastStartTime().longValue()*1000,"h:m:s");
				
//				playTime = StringUtils.trim(playTime);
				
				
				
				Long startTime = workspan.getBroadcastStartTime().longValue();
				String playTime ="";
				if(startTime>86400){
					String playTime1 = DateUtil.formatLongToTimeStr3(workspan.getBroadcastStartTime().longValue()*1000);
					String playTime2 = DateUtil.formatTime(workspan.getBroadcastStartTime().longValue()*1000,"m:s");
					playTime = StringUtils.trim(playTime1+":"+playTime2);
				}else{
					 playTime = DateUtil.formatTime(workspan.getBroadcastStartTime().longValue()*1000,"h:m:s");
					 playTime = StringUtils.trim(playTime);
				}
				
				
				
//				String  spanId=workspan.getResourceId().toString();
				long id = workspan.getId().longValue()+7000;
				String spanId = String.format("%08d", id);    
//				String spanId = String.format("%08d", workspan.getResourceId());    
				
//				for(int j=8-spanId.length();j>0;j--){
//					spanId="0"+spanId;
//				}  
				
//				String channelId=workspan.getCarrierId();  
//				channelId= FileUtil.getChannelCodeByName(channelId,2);
				
				
				String channelId = workspan.getCarrierId().toString();    
				String channelCode= FileUtil.getChannelCodeByName(channelId,2);
				
//				List carriers = (List)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIER_ALL);
//				
//				for(Iterator its=carriers.iterator();its.hasNext();){
//					Carrier channel=(Carrier)its.next();  
//					if(channel.getId().intValue()==workspan.getId().intValue())        
//							channelId=channel.getChannelId().toString();
//				}
//				if(channelId.length()<10) channelId="0"+channelId;
				
				if(!"".equals(channelCode)){
					for(int i =1;i<=7;i++){
						str.append("<detail adv_segid=\""+ StringUtil.null2String(spanId)  +"\"");
						str.append(" chan_id=\""+StringUtil.null2String(channelCode) +"\"");
						str.append(" startplaytime=\""+StringUtil.null2String(playTime) +"\"");
						str.append(" seg_len=\""+StringUtil.null2String(length) +"\"");
						str.append(" playday=\""+StringUtil.null2String(new Integer(i)) +"\"/>");
					}
				}


			}
			str.append("</advseg_cfglist>"); 
	

		return str.toString();
	}



	public void deleteArrangeAndDetail(Long id) {
		Map mp = new HashMap();
		List ls = new ArrayList();
		ls.add(id);
		mp.put("PublishArrangeIdList",ls);
		publishArrangeDetailDao.removePublishArrangeDetails(mp);
		this.removePublishArrange(id.toString());
	}

    private List getPublishArrangeIds(final Integer curDate) {
        return dao.getPublishArrangeIds(curDate);
    }
	   /**
	 * @throws IOException 
	 * @see com.vriche.adrm.service.PublishArrangeManager#moveArrangeAndDetailsToBak(final Integer curDate)
	 */
    public void moveArrangeAndDetailsToBak(final Integer curDate) throws IOException {
    	Map mp = new HashMap();

    	List ls=getPublishArrangeIds(curDate);
    	if(ls.size()!=0){
    		String publishArrange = Constants.FILE_PATH_SQL_SCRIPT + "publishArrange.xml";
    		String publishArrangeDetail = Constants.FILE_PATH_SQL_SCRIPT + "publishArrangeDetail.xml";
    		File publishArrangeFile =   Resources.getResourceAsFile(publishArrange);
    		File publishArrangeDetailFile =   Resources.getResourceAsFile(publishArrangeDetail);
    		
    		if(publishArrangeFile.exists()) publishArrangeFile.delete();
    		if(publishArrangeDetailFile.exists()) publishArrangeDetailFile.delete();
    		
    		String publishArrangePath=publishArrangeFile.getAbsolutePath();
    		String publishArrangeDetailPath=publishArrangeDetailFile.getAbsolutePath();
    		
    		mp.put("publishArrangePath",publishArrangePath);  		
    		mp.put("curDate",curDate);
    		dao.savePublishArrangeBakFile(mp);
    		
    		mp.put("publishArrangeDetailPath",publishArrangeDetailPath);
    		mp.put("PublishArrangeIdList",ls);
    		
    		dao.savePublishArrangeDetailBakFile(mp);

    		dao.savePublishArrangeBak(mp);
    		
    		dao.savePublishArrangeDetailBak(mp);

    		for(Iterator it=ls.iterator();it.hasNext();){
    			Long arrangeId=(Long)it.next();
    			deleteArrangeAndDetail(arrangeId);
        }   		
    	}
    }
    public String getAdversByResourceId(String resourceId,String  publishDate,String  orgId,String loginUser) {
    	System.out.println(">>>>>>> getAdversByResourceId 8888888888888888888888888 resourceId>>>>>>>" +resourceId ); 
    	
    	//Ϊ���ж��Ƿ�����Լ�����
    	List userList =  UserUtil.getOwnerUsersList(loginUser,1);
    	List userNames = new ArrayList();
    	for(Iterator it=userList.iterator();it.hasNext();){
			User user = (User)it.next();
			userNames.add(user.getFullName());
		}
    	
    	List checkedList =new ArrayList();
    	Map mp = new HashMap();
		 String ctxpath =RequestUtil.getReqInfo().getCtxPath();
		 
    	checkedList.add(resourceId);
    	getArrangMap(true,mp,checkedList,new Integer(publishDate));  
    	List ls = publishArrangeDetailDao.getPublishArrangeDetailsByIdList(mp);
    	StringBuffer sb=new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");
		int i=1; 
		int sum=0;
		String checkStr="";
    	for(Iterator it=ls.iterator();it.hasNext();){
    		PublishArrangeDetail publishArrangeDetail = (PublishArrangeDetail)it.next();
    		  sum+=Integer.parseInt(publishArrangeDetail.getMatterLength())*publishArrangeDetail.getAdverTimes().intValue();
    		  if(publishArrangeDetail.getPublishSort()!=null){
        		  int checkState = publishArrangeDetail.getPublishSort().intValue();
        		  if(checkState==3){
        			  checkStr="ͨ��";
        		  }else if(checkState==0){
        			  checkStr="δ���";
        		  }else{
        			  checkStr="���˻�";
        		  }
    		  }
    		  
    		  String userFullName = StringUtil.null2String(publishArrangeDetail.getOwnerUserName());
    		  sb.append("<row id=\""+i+"\">");   
	          sb.append("<cell image='leaf.gif'>"+ (i++) +"</cell>");
	  		  sb.append("<cell><![CDATA["+ StringUtil.null2String(publishArrangeDetail.getMatterName())+"]]></cell>");
	  		  sb.append("<cell><![CDATA["+ StringUtil.null2String(publishArrangeDetail.getMatterEdit())+"]]></cell>");
	  		  sb.append("<cell><![CDATA["+ StringUtil.null2String(publishArrangeDetail.getMatterLength()+"*"+publishArrangeDetail.getAdverTimes())+"]]></cell>");
	  		  sb.append("<cell><![CDATA["+ StringUtil.null2String(publishArrangeDetail.getSpecificName())+"]]></cell>");
	  		  sb.append("<cell><![CDATA["+ userFullName+"]]></cell>");
	  		  sb.append("<cell><![CDATA["+ StringUtil.null2String(publishArrangeDetail.getCustomerName())+"]]></cell>");
//	  		  sb.append("<cell><![CDATA[" +  StringUtil.null2String(publishArrangeDetail.getOrderCode()) + "]]></cell>");
	  		  
	  		  if(userNames.contains(userFullName)){
	  			 sb.append("<cell><![CDATA[ <a target=_blank href="+ ctxpath +"/editOrder.html?id="+ publishArrangeDetail.getOrderId().toString()+"&orgId="+ orgId+">" +publishArrangeDetail.getOrderCode() +"</a>]]></cell>");
	  		  }else{
	  			 sb.append("<cell><![CDATA[ " +publishArrangeDetail.getOrderCode() +"]]></cell>");
	  		  }
	  		 
	  		  sb.append("<cell><![CDATA["+ StringUtil.null2String(checkStr)+"]]></cell>");
	  		  sb.append("</row>");
    	}					
		  sb.append("<row id=\""+i+"\">");   
	      sb.append("<cell image='leaf.gif'>"+ "�ϼƣ�" +"</cell>");
		  sb.append("<cell><![CDATA["+ "" +"]]></cell>");
		  sb.append("<cell><![CDATA["+ ""+"]]></cell>");
		  sb.append("<cell><![CDATA["+ sum +"]]></cell>");
		  sb.append("<cell>"+ ""+"</cell>");
		  sb.append("<cell>"+ ""+"</cell>");
  		  sb.append("</row>"); 
  		  sb.append("</rows>");
    	              
    	return sb.toString();
    }
    
    
   


 public String getArrangedAdversByResourceId(String queryString) {
		 List resourceIdList = new ArrayList();
		 Map mp = new HashMap();
		 StringBuffer sb=new StringBuffer();
			
	   String ctxpath =RequestUtil.getReqInfo().getCtxPath();	  
	   String opt = StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(queryString,"opt"));
    	String orgId = StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(queryString,"orgId"));
    	String carrierId = StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(queryString,"carrierId"));

    	String publishDate = StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(queryString,"publishDate"));
    	String publishDateStart = StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(queryString,"publishDateStart"));
    	String publishDateEnd = StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(queryString,"publishDateEnd"));
    	
    	String resourceIds = StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(queryString,"resourceIds"));
    	
    	if(!"".equals(resourceIds)) {
    		 CollectionUtils.addAll(resourceIdList,resourceIds.split(","));    
    		 if("1".equals(opt)){mp.put("ResourceIdList",resourceIdList); }
    	  }
		  

		 mp.put("orgId",orgId);
		 
		 if(!"".equals(publishDate)) mp.put("publishDate",publishDate);
		 if(!"".equals(publishDateStart)) mp.put("publishDateStart",publishDateStart);
		 if(!"".equals(publishDateEnd)) mp.put("publishDateEnd",publishDateEnd);
		 
		 
		 
		 
		 
		 if(!"".equals(opt)) mp.put("opt",opt);
		 
		 if("2".equals(opt) && !"".equals(carrierId)){
			 mp.put("carrierId",carrierId);
//			 System.out.println("yyyyyyyyyyyyyyyyyyyyyyyy getArrangedAdversByResourceId  carrierId>>>>>>>>>>"+carrierId) ;
		 }

		

		 
    	List ls = publishArrangeDetailDao.getArrangedPublishForWebService(mp);
    	
    	StringUtilsv.printMap(mp);
    	
    	
    	System.out.println("yyyyyyyyyyyyyyyyyyyyyyyy getArrangedAdversByResourceId  opt>>>>>>>>>>"+opt) ;
    	System.out.println("yyyyyyyyyyyyyyyyyyyyyyyy getArrangedAdversByResourceId  publishDate>>>>>>>>>>"+publishDate) ;
    	System.out.println("yyyyyyyyyyyyyyyyyyyyyyyy getArrangedAdversByResourceId  carrierId>>>>>>>>>>"+carrierId) ;
    	System.out.println("yyyyyyyyyyyyyyyyyyyyyyyy getArrangedAdversByResourceId  resourceIdList>>>>>>>>>>"+resourceIdList) ;
    	System.out.println("yyyyyyyyyyyyyyyyyyyyyyyy getArrangedAdversByResourceId  ls size>>>>>>>>>>"+ls.size()) ;
    
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");
		int i=1; 
//		int sum=0;
		
		
		 if("1".equals(opt)){
		    	for(Iterator it=ls.iterator();it.hasNext();){
		    		
		    		PublishArrangeDetail publishArrangeDetail=(PublishArrangeDetail)it.next();

		    		  sb.append("<row id=\""+ publishArrangeDetail.getTempId() +"\">");   
		    		  sb.append("<cell>"+ publishArrangeDetail.getCtrBroSort()+"</cell>");
//		    		  sb.append("<cell><![CDATA["+ StringUtil.null2String(publishArrangeDetail.getTapeCode())+"]]></cell>");
			  		  sb.append("<cell><![CDATA["+ StringUtil.null2String(publishArrangeDetail.getMatterName())+"]]></cell>");
			  		  sb.append("<cell><![CDATA["+ StringUtil.null2String(publishArrangeDetail.getMatterEdit())+"]]></cell>");
//			  		  sb.append("<cell><![CDATA["+ StringUtil.null2String(publishArrangeDetail.getSpecificName())+"]]></cell>");
//			  		  sb.append("<cell><![CDATA["+ StringUtil.null2String(publishArrangeDetail.getPublishMemo())+"]]></cell>");
			  		  
			  		  String orderCode = StringUtil.getNullValue(publishArrangeDetail.getOrderCode(),"");
			  		  if(!"".equals(orderCode)) orderCode = orderCode.substring(4);
			  		  sb.append("<cell><![CDATA[ <a target=_blank href="+ ctxpath +"/editOrder.html?id="+ publishArrangeDetail.getOrderId()+"&orgId="+ orgId+">" +orderCode +"</a>]]></cell>");
			  		  sb.append("<cell><![CDATA["+ StringUtil.null2String(publishArrangeDetail.getMatterLength())+"]]></cell>");
			  		 
			  		  
			  		System.out.println("yyyyyyyyyyyyyyyyyyyyyyyy getArrangedAdversByResourceId  ctrBroTimeStr 0>>>>>>>>>>"+publishArrangeDetail.getCtrBroTime()) ;
			  		  String ctrBroTimeStr = StringUtil.getNullValue(publishArrangeDetail.getCtrBroTime(),"");
			  		System.out.println("yyyyyyyyyyyyyyyyyyyyyyyy getArrangedAdversByResourceId  ctrBroTimeStr 1>>>>>>>>>>"+ctrBroTimeStr) ;
			  		
			  		  ctrBroTimeStr = "0".equals(ctrBroTimeStr) ?"00:00:00":ctrBroTimeStr;
			  		System.out.println("yyyyyyyyyyyyyyyyyyyyyyyy getArrangedAdversByResourceId  ctrBroTimeStr 2>>>>>>>>>>"+ctrBroTimeStr) ;
			  	  	if(!"".equals(ctrBroTimeStr) && !"00:00:00".equals(ctrBroTimeStr)){
			  	  	System.out.println("yyyyyyyyyyyyyyyyyyyyyyyy getArrangedAdversByResourceId  ctrBroTimeStr 3>>>>>>>>>>"+ctrBroTimeStr) ;
			  	  		int ctrBroTime = (new Integer(ctrBroTimeStr)).intValue();
			  	  		ctrBroTimeStr = DateUtil.formatTime(Math.round(Double.parseDouble(ctrBroTime+"")*1000),"h:m:s");
			  	  			}
			  		 
			  		System.out.println("yyyyyyyyyyyyyyyyyyyyyyyy getArrangedAdversByResourceId  ctrBroTimeStr 4>>>>>>>>>>"+ctrBroTimeStr) ;
//			  		  String ctrBroTimeStr = ctrBroTime == 0?"00:00:00":DateUtil.formatTime(Math.round(Double.parseDouble(ctrBroTime+"")*1000),"h:m:s");
			  		  
//			  		  String ctrBroTimeStr = ctrBroTime == 0?"":DateUtil.formatTime(Math.round(Double.parseDouble(ctrBroTime+"")*1000),"h:m:s");

			  		  sb.append("<cell>"+ ctrBroTimeStr +"</cell>");
			  		  sb.append("</row>");
		    	}				
		 }else{
		    	for(Iterator it=ls.iterator();it.hasNext();){
		    		
		    		PublishArrangeDetail publishArrangeDetail= (PublishArrangeDetail)it.next();
		    		
		    		PublishArrange publishArrange = publishArrangeDetail.getPublishArrange();
		    		
		    		  sb.append("<row id=\""+ publishArrangeDetail.getTempId() +"\">");   
			  		  sb.append("<cell><![CDATA["+ StringUtil.null2String(publishArrange.getCarrierName())+"]]></cell>");
			  		  sb.append("<cell><![CDATA["+ StringUtil.null2String(publishArrangeDetail.getResourceName())+" "+ StringUtil.null2String(publishArrange.getResourceMeno())+"]]></cell>");
			  		  sb.append("<cell>"+ publishArrangeDetail.getCtrBroSort() +"</cell>");
			  		  sb.append("<cell><![CDATA["+ StringUtil.null2String(publishArrangeDetail.getMatterName())+"("+ StringUtil.null2String(publishArrangeDetail.getMatterEdit()) +")]]></cell>");
//			  		  sb.append("<cell><![CDATA["+ StringUtil.null2String(publishArrangeDetail.getMatterEdit())+"]]></cell>");
			  		  sb.append("<cell><![CDATA["+ StringUtil.null2String(publishArrangeDetail.getMatterLength())+"]]></cell>");
			  		  
			  		  
//			  		  int ctrBroTime = (new Integer(StringUtil.getNullValue(publishArrangeDetail.getCtrBroTime(),"0"))).intValue();
//			  		  String ctrBroTimeStr = ctrBroTime == 0?"":DateUtil.formatTime(Math.round(Double.parseDouble(ctrBroTime+"")*1000),"h:m:s");
			  		  String ctrBroTimeStr = StringUtil.getNullValue(publishArrangeDetail.getCtrBroTime(),"");
			  		  ctrBroTimeStr = "0".equals(ctrBroTimeStr) ?"00:00:00":ctrBroTimeStr;
			  	  	if(!"".equals(ctrBroTimeStr) && !"00:00:00".equals(ctrBroTimeStr)){
			  	  		int ctrBroTime = (new Integer(ctrBroTimeStr)).intValue();
			  	  		ctrBroTimeStr = DateUtil.formatTime(Math.round(Double.parseDouble(ctrBroTime+"")*1000),"h:m:s");
			  	  			}
			  		  
			  		  
			  		  sb.append("<cell>"+ ctrBroTimeStr +"</cell>");
			  		  
			  		  sb.append("</row>");
		    	}				
		 }


  		  sb.append("</rows>");
    	              
    	return sb.toString();
    }
 
 
 public void saveArrangedAdversCtrTime(CtrData[] ctrDatas,String model) {
	 try {
		Connection conn = ServiceLocator.getDao().getDefaultDataSource().getConnection();
//		java.sql.Statement sm = conn.createStatement();
		conn.setAutoCommit(false);
		
		
		String sql = "";
		if("1".equals(model)){
			sql = "update tb_published_arrang_detail set ctr_bro_time = ? where arrange_detail_id= ?";
		}
		if("2".equals(model)){
			sql = "update tb_published_arrang_detail set ctr_bro_sort = ? where arrange_detail_id= ?";
		}

		
	 
	 	
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		for(int i = 0;i<ctrDatas.length;i++){
			if("1".equals(model)){
				
					if(ctrDatas[i].getBroTime() != null){
						pstmt.setInt(1,ctrDatas[i].getBroTime().intValue());
					}else{
						pstmt.setObject(1,null);
					}
//					System.out.println("saveArrangedAdversCtrTime sql>>>>>>>>>>"+sql + ctrDatas[i].getId().longValue() +"=="+ ctrDatas[i].getBroTime().intValue()) ;
				
			}else{
					pstmt.setInt(1,ctrDatas[i].getBroSort().intValue());
//					System.out.println("saveArrangedAdversCtrTime sql>>>>>>>>>>"+sql + ctrDatas[i].getId().longValue() +"=="+ ctrDatas[i].getBroSort().intValue()) ;
				
			}

			pstmt.setLong(2,ctrDatas[i].getId().longValue());
			
			pstmt.addBatch();
		}
	
		
		pstmt.executeBatch(); 
		conn.commit();
//		conn.setAutoCommit(true); 
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	 
 }
 
 
 private String saveDayangPublishArrange(PublishArrange arrange,PublishArrange[] objs){
	 boolean dayangImport = SysParamUtil.getDayangBeiboEnableParam() == 1;
	 
//	 System.out.println(">>>>>>>> dayangImport >>>>>>>>>>>>>>>>>>>>>>>>>>>>>. 999999999999999999999999999       IURL:" + dayangImport);
	 
	 String ret ="";
	 if(dayangImport){
		 ret = savePublishArrange2Dayang(arrange, objs);
	 }
	 return ret;
}

 private  String  savePublishArrange2Dayang(PublishArrange arrange,PublishArrange[] objs){
////	String IURL = Constants.DAYANG_WEBSERVER_IMPORT_PROLIST_URL;
//		String IURL = Constants.DAYANG_WEBSERVER_IMPORT_PROLIST_URL_TEST;	 
//		String IURL = "http://168.168.168.3:8080/adrm/services/ImportProgramListService?wsdl";
//		String IURL = "http://127.0.0.1:8080/adrm/services/ImportProgramListService?wsdl";
//	 	String IURL = "http://127.0.0.1:8080/adrm/services/ImportProgramListServiceStub?wsdl";
//	 	String IURL = "http://192.168.1.199:8081/myWebService2/services/ImportProgramListService?wsdl";
		
//		String IURL = SysParamUtil.getDayangWebServiceUrlProLitstParam();
//	 	
//		 System.out.println(">>>>>>>> saveMatter2Dayang IURL:" + IURL);

        List tapeCodeList = new ArrayList();
		Map  tapeCodeMap = new HashMap();
		
		List lsBeiboEnableParamResSorts = new ArrayList();
		

		
//		ImportProgramListServiceStub service = null;

			
			
			mreml2.schema.programlistparameter.ImportProgramListRequest ImportProgramListRequest1 = new mreml2.schema.programlistparameter.ImportProgramListRequest();	
			
			mreml2.schema.programlistparameter.ImportProgramListRequestType ImportProgramListRequest = new mreml2.schema.programlistparameter.ImportProgramListRequestType();	
			
		
			
//		ExtendAttributeType[] extendAttributes1 = new ExtendAttributeType[0];
//		ImportProgramListRequest.setExtendAttributes(extendAttributes1);
		
		
		
		String orgId = arrange.getOrgId().toString();
		Org org = SysParamUtil.getOrgFromMap(orgId);
		String loginUserId = arrange.getLoginUserId();
		String loginUser = arrange.getLoginUser();
		String creator = UserUtil.getUserFullNameById(loginUserId);
	
		String orgName =org.getName();
		Integer publish_date = arrange.getPublishDate();
		String  publishDate = DateUtil.SetDateFormat(publish_date.toString(),"yyyy-MM-dd");
		String auditTime =  DateUtil.getStringDate(null);//�����ַ�����ʽ yyyy-MM-dd HH:mm:ss
		Long carrierId = arrange.getCarrierId();
//		String carrierName = arrange.getCarrierName();
		
		Map carrierMap = CarrierUtil.getAllCarriersLevelOne(new Carrier());
		Carrier car = (Carrier)carrierMap.get(new Long(carrierId));
		ResourceChannel channel = car.getResourceChannel();
		String carrierAliasName = car.getAliasName();
		String channelCode = channel.getMemo();
		String channelId = channel.getId().toString();
		
		Resource res = new Resource();
		res.setCarrierId(new Long(carrierId));
		res.setInPublishDate(publish_date);
		 Map resMap = ResourceUtil.getResourceWithWorkspan(res);
		 
		
		
		Map channelConfigMap = SysParamUtil.getWebServiceUrlChannelConfig(channelId);
	
		Iterator itConfig_2 = channelConfigMap.values().iterator();
		while (itConfig_2.hasNext()){
			Map configMap  =   (Map) itConfig_2.next();
			String url_address_importMater = (String)configMap.get("1");
//			System.out.println(">>>>>>>>  url_address_importMater:" + url_address_importMater);
			
			String url_address_importProLists1 = (String)configMap.get("2");
		
//			System.out.println(">>>>>>>>  url_address_importProLists1:" + url_address_importProLists1);
			
			String[] url_address = StringUtilsv.split(url_address_importProLists1,"|");
//			System.out.println(">>>>>>>>  url_address_importProLists.length:" + url_address.length);
			
			String url_address_importProList = url_address[0];
//			System.out.println(">>>>>>>>  url_address_importProList:" + url_address_importProList);
			
			String url_address_importProList_sen_res_sorts = url_address[1];
//			System.out.println(">>>>>>>>  url_address_importProList_sen_res_sorts:" + url_address_importProList_sen_res_sorts);
			
			boolean send_zeo = "1".equals(url_address[2]);
//			System.out.println(">>>>>>>>  send_zeo:" + send_zeo);
//			String IURL = url_address_importMater;
		 	
			 
			
//			String[]  beiboEnableParamResSorts = SysParamUtil.getDayangBeiboEnableParamResSort();
			String[]  beiboEnableParamResSorts = url_address_importProList_sen_res_sorts.split(",");
			CollectionUtils.addAll(lsBeiboEnableParamResSorts,beiboEnableParamResSorts);
//			System.out.println(">>>>>>>> saveMatter2Dayang lsBeiboEnableParamResSorts:" + lsBeiboEnableParamResSorts.toString());
			
//			System.out.println(">>>>>>>>  IURL:" + IURL);
//			System.out.println("lsBeiboEnableParamResSorts >>>" +(String)configMap.get("2"));
//			System.out.println("lsBeiboEnableParamResSorts >>>" +url_address_importProList_sen_res_sorts);
//			System.out.println(">>>>>>>> saveMatter2Dayang beiboEnableParamResSorts:" + beiboEnableParamResSorts);
//			System.out.println("lsBeiboEnableParamResSorts >>>" + lsBeiboEnableParamResSorts.toString());
//			System.out.println(">>>>>>>> saveMatter2Dayang send_zeo:" + send_zeo);
	
		
		
			int resourceCount = objs.length;
			
		
			int exchangeType = 1;
	//		Ů�Ѽ�ʱ�У��Ѿ���Q�ѣ���֪������û�ѣ��ܷ�����Ů���ѣ�
			CommonRequestType commonRequest = new CommonRequestType();
	//		List<BroadcastListEntityType> adBroadcastList  = new ArrayList<BroadcastListEntityType>();
			BroadcastListEntityType broadcastListEntity  = new BroadcastListEntityType();
	//		ExtendAttributeType[] extendAttributes2 = new ExtendAttributeType[0];
	//		broadcastListEntity.setExtendAttributes(extendAttributes2);
	//			<!-- ������������ϵͳID -->
	//			<m:RequestSystemID>BoRuiADM</m:RequestSystemID>
	//			commonRequest.setRequestSystemID("BoRuiADM");
				commonRequest.setSourceID("ADM");
	//			<!-- ��������ϵͳ�ĵ�ǰ�û�ID -->
	//			<m:UserID>11203</m:UserID>
				commonRequest.setUserID("admin");
	//			<!-- ��������ϵͳ�ĵ�ǰ�û����� -->
	//			<m:UserID>Admin</m:UserID>
				commonRequest.setUserName("����Ա");		 
				
	//			<!-- ��沥����ID	-->
	//			<m0:ListID>a45a46d9-0859-412d-88a2-5f6beafaaa06</m0:ListID>
				 UUID uuid = UUID.randomUUID();
				String listID = channelCode+ "_"+publish_date;
				broadcastListEntity.setListID(listID);
				System.out.println("ListID >>>" + listID);
	//			<!-- �������ڡ���ʽ��yyyy-MM-dd�� -->
	//			<m0:PlayDate>2013-03-10</m0:PlayDate>
				broadcastListEntity.setPlayDate(publishDate);
	//			<!-- 2����沥���� -->
	//			<m0:ListType>2</m0:ListType>
				broadcastListEntity.setListType(2);
				
	//			broadcastListEntity.setListType(5);
				
				
				
	//			<!-- Ƶ����Ϣ -->
				ChannelInfoType channelInfo = new ChannelInfoType();
	//			<m0:ChannelInfo>
	//				<m0:ChannelCode>HNTV1</m0:ChannelCode>
					channelInfo.setChannelCode(channelCode); //һ�� 
	//				channelInfo.setChannelCode("HNTV");
	//				<m0:ChannelName>����Ƶ��</m0:ChannelName>
					channelInfo.setChannelName(carrierAliasName); //����Ƶ��
	//				channelInfo.setChannelName("��������");
					
	//				System.out.println("channelCode      >>>" + channelCode);
	//				System.out.println("channelName      >>>" + channel.getName());
	//				System.out.println("channelAliasName >>>" + carrierAliasName);
					
					
	//			</m0:ChannelInfo>
				broadcastListEntity.setChannelInfo(channelInfo);
					
	//			<!-- ��沥�������� -->
	//			<m0:ListName>����Ƶ��2013-03-10��浥</m0:ListName>
				broadcastListEntity.setListName(carrierAliasName+publishDate+"��浥");
	//			<!-- �����Ϣ -->
				ExecuteActionType auditInfo = new ExecuteActionType();
	//			<m0:AuditInfo>
	//				<m0:UserID>36a50115-3c50-42d7-9245-847028dfbbeb</m0:UserID>
					auditInfo.setUserID(loginUserId);
	//				<m0:UserName>admin</m0:UserName>
					auditInfo.setUserName(creator);
	//				<m0:ActionTime>2013-03-10 08:00:00</m0:ActionTime>
					auditInfo.setActionTime(auditTime);
	//			</m0:AuditInfo>
				broadcastListEntity.setAuditInfo(auditInfo);
				
	//			<!-- ĩ���޸���Ϣ -->
				ExecuteActionType lastEditInfo = new ExecuteActionType();
	//			<m0:LastEditInfo>
	//				<m0:UserID>36a50115-3c50-42d7-9245-847028dfbbeb</m0:UserID>
					lastEditInfo.setUserID(loginUserId);
	//				<m0:UserName>admin</m0:UserName>
					lastEditInfo.setUserName(creator);
	//				<m0:ActionTime>2013-02-28 08:00:00</m0:ActionTime>
					lastEditInfo.setActionTime(auditTime);
	//			</m0:LastEditInfo>
				broadcastListEntity.setLastEditInfo(lastEditInfo);
				
	//			<!-- �������汾�ţ��ο�����1,2,3������ -->
	//			<m0:Version>1</m0:Version>
				broadcastListEntity.setVersion("1");
	//			<!-- ����������ʵ������һ�� -->
	//			<m0:ListItemCount>2</m0:ListItemCount>	
	//			broadcastListEntity.setListItemCount(resourceCount);
	
	//			System.out.println("resourceCount >>>" + resourceCount);
				
				
				
				//ÿ����λ�µĹ����Ŀ
	//			BroadcastListItemType[] listItem = new BroadcastListItemType[resourceCount];
				
				List<BroadcastListItemType> listItems = new ArrayList<BroadcastListItemType>();
				
	
				for(int i = 0 ; i< resourceCount;i++){                     
					PublishArrange publishArrange = objs[i];
						
					Long resId = publishArrange.getResourceId();
					String resourceName = publishArrange.getResourceName() ;
					String resourceMemo = publishArrange.getMemo();
					Resource resource = (Resource)resMap.get(resId.toString());
					Workspan workspan = resource.getWorkspan();
					String standTime = ResourceUtil.getStandTimeByWeek(workspan,publish_date.toString());
					ResourceSort resSort = resource.getResSort();
					String res_sort_value = resSort.getValue();
	//				System.out.println("standTime>>>>>>>>>>>>>>>>>" + standTime);
	//				System.out.println("res_sort_value>>>>>>>>>>>>>>>>>" + res_sort_value);
					
					if(!lsBeiboEnableParamResSorts.contains(res_sort_value)){
	//					System.out.println("res_sort_value>>>>>>>>>>>>>>>>>" + res_sort_value);
						continue; 
					}
					
	//				System.out.println("res_sort_value i>>>>>>>>>>>>>>>>>" + i);
					
	//				if (!"1".equals(res_sort_value) && !"3".equals(res_sort_value)) { 
	//	                continue; 
	//	            } 
					
					
					Integer broadcastStartTime = workspan.getBroadcastStartTime();
	//	       		String broTime = workspan.getBroadcastTimeFormat();
	//	       		String broTimeStar = workspan.getBroadcastTimeFormatStart();
		       		String broTimeStar = DateUtil.formatLongToTimeStr(Long.valueOf(broadcastStartTime*1000));
	//	       		String broTimeEnd = workspan.getBroadcastTimeFormatEnd();
		       		
		       		String itemId = publish_date + "s"+resId.toString();
		       		
	//	       		System.out.println("itemId "+ i +">>>" +itemId);
		       		
		       		BroadcastListItemType listItem = new BroadcastListItemType();
		       		
	//	       		ExtendAttributeType[] extendAttributes3 = new ExtendAttributeType[0];
	//	       		listItem.setExtendAttributes(extendAttributes3);
		       		
		       		//2015��1��6�� ����Ҫ�� ��λ����ǰ ��������
		       		resourceName = publish_date + " "+resourceName;
	
		       		
	//				<!-- ��沥��������Ϣ -->
	//				<m0:ListItem>
	//					<!-- ��沥������ID -->
	//					<m0:ItemID>20131101s01</m0:ItemID>
	//	       		    System.out.println("listItem[0] >>>" + listItem[i]);
		
						listItem.setItemID(itemId);  // ����ʱ�� +"s"+��λID��
	//					<!-- ��沥���������� -->
	//					<m0:ItemName>��������Ϸ����1</m0:ItemName>
						listItem.setItemName(resourceName);
	//					<!-- ����� -->
	//					<m0:ItemIndex>1</m0:ItemIndex>
						listItem.setItemIndex(i+1);
	//					<!-- �����ͣ�Ĭ��2������Ŀ������Ŀ��-->
	//					<m0:ItemType>2</m0:ItemType>
						listItem.setItemType(2);
	//					<!-- ������ʽ��1-������2-˳����3-�ֶ������� 4-���岥����ʽ��5-��Բ壬6-���壬7-�ֹ��岥-->
	//					<m0:PlayMode>5</m0:PlayMode>
						listItem.setPlayMode(5);
	//					<!-- �������� -->
	//					<m0:PlayDate>2013-03-10</m0:PlayDate>
						listItem.setPlayDate(publishDate);
	//					<!-- ����ʱ�� -->
	//					<m0:PlayTime>07:30:00</m0:PlayTime>
						listItem.setPlayTime(broTimeStar);
						
	//					System.out.println("broTimeStar>>>>>>>>>>>>>>>>>" + broTimeStar);
						
	//					<!-- ��Բ岥ʱ�����ʱ�䣬��ʽHH:MM:SS:FF����ֱ����д00:00:00:00 -->
	//					<m0:InsertTime>00:00:00:00</m0:InsertTime>
						listItem.setInsertTime("00:00:00:00");
	//					<!-- ��ʱ������λ֡ -->
						Long duration = Long.valueOf(standTime).longValue() *25;
						
	//					System.out.println("duration>>>>>>>>>>>>>>>>>" + duration);
						
	//					<m0:Duration>750</m0:Duration>
						listItem.setDuration(duration);
						
						
						
	//					<!-- ���ز���Ϣ -->
						ProgramInfoType programInfo = new ProgramInfoType();
	//					ExtendAttributeType[] extendAttributes4 =new ExtendAttributeType[0];
	//					programInfo.setExtendAttributes(extendAttributes4);
						
	//					String programCode = resId.toString();
	//					 �������е�<ProgramCode>�ֶΣ�����ֶ������ǵ����ݿ��д����ظ������������ֶ����������������ϳɺ���ļ����Ƶģ�����ظ�����ܻᵼ���ļ������ǵ�������ڽӿ��У����Ƕ�<ItemID>���������أ���˿��԰�<ProgramCode>��<ItemID>д��һ����ֵ��
	//					<m0:ProgramInfo>
	//						<!-- �κϲ����ID��ҵ��ID�� -->
	//						<m0:ProgramCode>29063</m0:ProgramCode>
						
							programInfo.setProgramCode(itemId);
	//						<!-- ��� -->
	//						<m0:InPoint>0</m0:InPoint>
							programInfo.setInPoint(0);
	//						<!-- ��ʱ������λ֡ -->
	//						<m0:Duration>750</m0:Duration>
							programInfo.setDuration(duration);
	//						<m0:ExtendAttributes>
	//						</m0:ExtendAttributes>
	//					</m0:ProgramInfo>
						listItem.setProgramInfo(programInfo);
						
	//					<!-- �Ͳ����ͣ�1-�ļ���2-�Ŵ���3-���ʣ�4-�źţ�5-������� -->
	//					<m0:SendPlayType>1</m0:SendPlayType>
						listItem.setSendPlayType(1);
						
						
	//					<!-- ��Ŀ��Ϣ -->
						ColumnInfoType columnInfo = new ColumnInfoType();
	//					<m0:ColumnInfo>
						
	//						<!-- ��Ŀ���� -->
	//						<m0:ColumnCode>SHGC</m0:ColumnCode>
	//						columnInfo.setColumnCode(resourceName);
							columnInfo.setColumnCode(UUID.randomUUID().toString());
	//						<!-- ��Ŀ���� -->
	//						<m0:ColumnName>����۲�</m0:ColumnName>
							columnInfo.setColumnName(resourceName);
	//						<!-- ��Ŀ���ͣ�0-������Ŀ,1-��Ŀ����Σ�2-��Ŀ�ڹ���,3-��ɱ� -->
	//						<m0:ColumnType>1</m0:ColumnType>
							columnInfo.setColumnType(1);
	//						<!-- ��Ŀʱ��,��λ֡ -->
	//						<m0:ColumnDuration>45000</m0:ColumnDuration>
						
							columnInfo.setColumnDuration(duration);
	//					</m0:ColumnInfo>
						listItem.setColumnInfo(columnInfo);
						
	//					<!-- ������Ŀ���� -->
	//					<m0:SubItemCount>2</m0:SubItemCount>
						PublishArrangeDetail[]  publishArrangeDetails = publishArrange.getDetails();
						int subItemCount = publishArrangeDetails.length;
						int subItemCountReal = 0;
						long adStartTime = broadcastStartTime.intValue();
						
						String adPlayTime11 = DateUtil.formatLongToTimeStr(Long.valueOf(adStartTime*1000));
	//					System.out.println("adPlayTime11>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +adPlayTime11);
						
						
						
						
	//					BroadcastListItemType[] subItem = new BroadcastListItemType[subItemCount];
						List<BroadcastListItemType> subItemList = new ArrayList<BroadcastListItemType>();
						
						long sumAdDuration = 0;
						
						int pp = 1; 
						for(int j = 0 ;j < subItemCount;j++){
							
							PublishArrangeDetail publishArrangeDetail = publishArrangeDetails[j];
							
	//						System.out.println("publishArrangeDetail>>>>>>>>>>>>>>>>>" + publishArrangeDetail.toString());
							long matterLength = Long.parseLong(publishArrangeDetail.getMatterLength());
							long adDuration = Long.valueOf(matterLength)*25;
							
							if(adDuration > 0|| send_zeo){
								
								sumAdDuration += adDuration;
								String matterName = publishArrangeDetail.getMatterName();
		//						String matterId = publishArrangeDetail.getMatterId().toString();
								String tapeCode = publishArrangeDetail.getTapeCode();
								tapeCodeMap.put(tapeCode,tapeCode);
		//						String matterId = publishArrangeDetail.getMatterId().toString();
								String matterEdit = publishArrangeDetail.getMatterEdit();
								int adSequence = publishArrangeDetail.getPublishSort().intValue();
								String matterInfo = matterName +" "+ matterEdit;
		
								long ad_PlayTime = (j ==0)?adStartTime: adStartTime + matterLength;
								adStartTime = ad_PlayTime;
								
		//						System.out.println("ad_PlayTime>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +ad_PlayTime);
								
								String adPlayTime = DateUtil.formatLongToTimeStr(Long.valueOf(ad_PlayTime*1000));
								
		//						System.out.println("adPlayTime>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +adPlayTime);
							
				
								BroadcastListItemType subItem = new BroadcastListItemType();
	//							ExtendAttributeType[] extendAttributes5 = new ExtendAttributeType[0];
	//							subItem[j].setExtendAttributes(extendAttributes5);
		                    
	//						<!-- ������Ŀ��Ϣ -->
	//						<m0:SubItem>
	//							<!-- ��ĿID -->
	//							<m0:ItemID>20131101T01</m0:ItemID>
								String subItemId  =  publish_date +"S"+resId.toString()+ "T" + adSequence;
								
	//							System.out.println("subItemId>>>>>>>>>>>>>>>>>" + subItemId);
	//							System.out.println("adPlayTime>>>>>>>>>>>>>>>>>" + adPlayTime);
	//							 UUID uu_id = UUID.randomUUID();
								subItem.setItemID(subItemId);
	//							<!-- ��Ŀ���� -->
	//							<m0:ItemName>����ҩҵС������С����ƪ5+����ƪ--θ��������ƪ�ط���10</m0:ItemName>
								subItem.setItemName(matterInfo);
	//							<!-- ������Ŀ��� -->
	//							<m0:ItemIndex>1</m0:ItemIndex>
								subItem.setItemIndex(pp++);
	//							<!-- ��Ŀ���� 1-����Ŀ-->
	//							<m0:ItemType>1</m0:ItemType>
								subItem.setItemType(1);
	//							<m0:PlayTime>07:30:00</m0:PlayTime>
								subItem.setPlayTime(adPlayTime);
								
	//							System.out.println("adPlayTime>>>>>>>>>>>>>>>>>" + adPlayTime);
	//							<m0:InsertTime>00:00:00:00</m0:InsertTime>
								subItem.setInsertTime("00:00:00:00");
	//							<m0:Duration>375</m0:Duration>
								subItem.setDuration(adDuration);
								
								ProgramInfoType subProgramInfo = new ProgramInfoType();
	//							<m0:ProgramInfo>
	//								<!-- ����д�ɶ�����Ŀ�ز�ID -->
	//								<m0:ProgramCode>290674</m0:ProgramCode>
									subProgramInfo.setProgramCode(tapeCode);
	//								<!-- ������Ŀ�ز�ID -->
	//								<m0:ClipID>290674</m0:ClipID>
									subProgramInfo.setClipID(tapeCode);
	//								<!-- �ز����� -->
	//								<m0:ClipName>����ҩҵС������С����ƪ5+����ƪ--θ��������ƪ�ط���10</m0:ClipName>
									subProgramInfo.setClipName(matterInfo);
	//								<!-- �ز���� -->
	//								<m0:InPoint>0</m0:InPoint>
									subProgramInfo.setInPoint(0);
	//								<!-- �ز�ʱ�� --> 
	//								<m0:Duration>375</m0:Duration>
									subProgramInfo.setDuration(adDuration);
	//								<m0:ExtendAttributes>
	//								</m0:ExtendAttributes>
	//							</m0:ProgramInfo>
								subItem.setProgramInfo(subProgramInfo);	
	//							<!-- ����Ŀ������Ϊ0 -->
	//							<m0:SubItemCount>0</m0:SubItemCount>
								subItem.setSubItemCount(0);
	//							<m0:ExtendAttributes>
	//							</m0:ExtendAttributes>	
	//						</m0:SubItem>						
							
								subItemList.add(subItem);
								
								subItemCountReal++;
							}
							listItem.setSubItemCount(subItemCountReal);
	
						}	
						
						if(subItemList.size() >0){
							
							BroadcastListItemType[] subItem = new BroadcastListItemType[subItemList.size()];
							
							listItem.setSubItem(subItemList.toArray(subItem));
							
							listItem.setDuration(sumAdDuration);
							
							listItems.add(listItem);
						}
	
						
	//					System.out.println("listItem["+i+"]>>>>>>>>>>>>>>>>>" +listItem.toString());
						
	//					<m0:ExtendAttributes>
	//					</m0:ExtendAttributes>					
	//				</m0:ListItem>				
				}
				
				
				int listItemCount = listItems.size();
				BroadcastListItemType[] items = new BroadcastListItemType[listItemCount];
				broadcastListEntity.setListItem(listItems.toArray(items));
				broadcastListEntity.setListItemCount(listItemCount);
				
				ImportProgramListRequest.setBroadcastListEntity(broadcastListEntity);
				ImportProgramListRequest.setCommonRequest(commonRequest);
				
				
				
				ImportProgramListRequest1.setImportProgramListRequest(ImportProgramListRequest);
				
				 
				//�����ز���Ϣ
				tapeCodeList.addAll(tapeCodeMap.keySet());
				System.out.println("saveMattersAll2dayang start.......1111........................"+tapeCodeList.toString());
				Matter mtParam = new Matter();
				mtParam.setTapeCodeList(tapeCodeList);
				mtParam.setCarrier(car);
				
		
				ServiceLocator.getMatterManager().saveMattersAll2dayang2(mtParam,url_address_importMater);
			
				System.out.println("saveMattersAll2dayang end.......2222......................."+tapeCodeList.toString());
				
//				System.out.println("listItems.size().......2222......................."+ listItems.size());
		
				String staus ="";
				String newId ="";
				try {
					if(listItems.size()>0){
						
						ImportProgramListServiceCallbackHandler myCallBack = new MyImportProgramListServiceCallbackHandler();
						 
						try {
							ImportProgramListServiceStub service = new ImportProgramListServiceStub(url_address_importProList); 
							HttpClient httpClient = new HttpClient(new MultiThreadedHttpConnectionManager());
							ServiceClient _serviceClient =  service._getServiceClient();
							ConfigurationContext context = _serviceClient.getServiceContext().getConfigurationContext();
							
							Options options =  _serviceClient.getOptions(); 
							options.setProperty(HTTPConstants.CHUNKED,false); 
							options.setTimeOutInMilliSeconds(1000*60*60);
							options.setManageSession(true);   
						    options.setProperty(HTTPConstants.REUSE_HTTP_CLIENT,true);  
						    
							context.setProperty(HTTPConstants.REUSE_HTTP_CLIENT,true);
							context.setProperty(HTTPConstants.CACHED_HTTP_CLIENT,httpClient);
							context.setProperty(HTTPConstants.AUTO_RELEASE_CONNECTION,true);
							
	//						System.out.println("importProgramList service>>>>>>>>>>>>>>>>>>>>>>>>>>>" + service);
							service.startimportProgramList(ImportProgramListRequest1,myCallBack);
	//						_serviceClient.cleanupTransport();//���Ӵ��У�����160��
							
						} catch (AxisFault e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
	//					ImportProgramListResponse importProgramListResponse1 = service.importProgramList(ImportProgramListRequest1);
						
	//					ImportProgramListResponseType importProgramListResponse = importProgramListResponse1.getImportProgramListResponse();
	//
	//					CommonResponseType commonResponse = importProgramListResponse.getCommonResponse();
	//		//			<!-- ����״̬��0-�ɹ���1-ʧ�� -->
	//		//			<ns4:Status>0</ns4:Status>
	//					 staus = String.valueOf(commonResponse.getStatus());
	//		//			<!-- ״̬�������� -->
	//		//			<Description>�����沥������ID=a45a46d9-0859-412d-88a2-5f6beafaaa06���ɹ���</Description>
	////					 <Description>���ݿ��Ѿ�����ID=2906300112�ĶΣ����ö��Ѿ�����ID=a45a46d9-0859-412d-88a2-5f6beafb6906�Ĳ���������Ҫ����Ĳ�������ID=a45a46d9-0859-412d-88a2-5f6beafaaa06����ͻ�����ݴ����벥����ʧ�ܡ�</Description>
	//					 newId = commonResponse.getDescription();	
	//					 System.out.println("importProgramList staus >>>>>>>>>>" + staus +" description" +newId);
					}else{
						System.out.println("importProgramList no advs for import to dayang!");
					}
	
					
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return staus;	
		}
		return "";			
			

 }
 
//���浽��������
// private  String  savePublishArrange2Dayang(PublishArrange arrange,PublishArrange[] objs){
//
////		String IURL = Constants.DAYANG_WEBSERVER_IMPORT_PROLIST_URL;
//		String IURL = Constants.DAYANG_WEBSERVER_IMPORT_PROLIST_URL_TEST;
//		
////		String IURL = "http://127.0.0.1:8080/adrm/services/ImportProgramListService?wsdl";
//		
//		String[]  beiboEnableParamResSorts = SysParamUtil.getDayangBeiboEnableParamResSort();
//		List lsBeiboEnableParamResSorts = new ArrayList();
////		List<String> lsBeiboEnableParamResSorts = new ArrayList<String>();
////		lsBeiboEnableParamResSorts.addAll(beiboEnableParamResSorts);
//		CollectionUtils.addAll(lsBeiboEnableParamResSorts,beiboEnableParamResSorts);
//		System.out.println("lsBeiboEnableParamResSorts >>>" + lsBeiboEnableParamResSorts.toString());
//	
//		
//		
//		java.net.URL portAddress = null;
//		ImportProgramList service = null;
//		
//		try {
//			portAddress = new java.net.URL(IURL);
//		} catch (MalformedURLException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}  
//		
//		ImportProgramListService mgr = new ImportProgramListServiceLocator();
//		
//		try {
//			service = mgr.getImportProgramListServiceHttpPort(portAddress);
//		} catch (ServiceException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		ImportProgramListRequestType ImportProgramListRequest = new ImportProgramListRequestType();
//		
////		ExtendAttributeType[] extendAttributes1 = new ExtendAttributeType[0];
////		ImportProgramListRequest.setExtendAttributes(extendAttributes1);
//		
//		
//		
//		String orgId = arrange.getOrgId().toString();
//		Org org = SysParamUtil.getOrgFromMap(orgId);
//		String loginUserId = arrange.getLoginUserId();
//		String loginUser = arrange.getLoginUser();
//		String creator = UserUtil.getUserFullNameById(loginUserId);
//	
//		String orgName =org.getName();
//		Integer publish_date = arrange.getPublishDate();
//		String  publishDate = DateUtil.SetDateFormat(publish_date.toString(),"yyyy-MM-dd");
//		String auditTime =  DateUtil.getStringDate(null);//�����ַ�����ʽ yyyy-MM-dd HH:mm:ss
//		Long carrierId = arrange.getCarrierId();
////		String carrierName = arrange.getCarrierName();
//		
//		Map carrierMap = CarrierUtil.getAllCarriersLevelOne(new Carrier());
//		Carrier car = (Carrier)carrierMap.get(new Long(carrierId));
//		ResourceChannel channel = car.getResourceChannel();
//		String carrierAliasName = car.getAliasName();
//		String channelCode = channel.getMemo();
//		
//		Resource res = new Resource();
//		res.setCarrierId(new Long(carrierId));
//		res.setInPublishDate(publish_date);
//		 Map resMap = ResourceUtil.getResourceWithWorkspan(res);
//		 
//		
//		int resourceCount = objs.length;
//		
//	
//		int exchangeType = 1;
////		Ů�Ѽ�ʱ�У��Ѿ���Q�ѣ���֪������û�ѣ��ܷ�����Ů���ѣ�
//		CommonRequestType commonRequest = new CommonRequestType();
////		List<BroadcastListEntityType> adBroadcastList  = new ArrayList<BroadcastListEntityType>();
//		BroadcastListEntityType broadcastListEntity  = new BroadcastListEntityType();
////		ExtendAttributeType[] extendAttributes2 = new ExtendAttributeType[0];
////		broadcastListEntity.setExtendAttributes(extendAttributes2);
////			<!-- ������������ϵͳID -->
////			<m:RequestSystemID>BoRuiADM</m:RequestSystemID>
////			commonRequest.setRequestSystemID("BoRuiADM");
//			commonRequest.setSourceID("ADM");
////			<!-- ��������ϵͳ�ĵ�ǰ�û�ID -->
////			<m:UserID>11203</m:UserID>
//			commonRequest.setUserID("admin");
////			<!-- ��������ϵͳ�ĵ�ǰ�û����� -->
////			<m:UserID>Admin</m:UserID>
//			commonRequest.setUserName("����Ա");		 
//			
////			<!-- ��沥����ID	-->
////			<m0:ListID>a45a46d9-0859-412d-88a2-5f6beafaaa06</m0:ListID>
//			 UUID uuid = UUID.randomUUID();
//			String listID = channelCode+ "_"+publish_date;
//			broadcastListEntity.setListID(listID);
//			System.out.println("ListID >>>" + listID);
////			<!-- �������ڡ���ʽ��yyyy-MM-dd�� -->
////			<m0:PlayDate>2013-03-10</m0:PlayDate>
//			broadcastListEntity.setPlayDate(publishDate);
////			<!-- 2����沥���� -->
////			<m0:ListType>2</m0:ListType>
//			broadcastListEntity.setListType(2);
//			
////			broadcastListEntity.setListType(5);
//			
//			
//			
////			<!-- Ƶ����Ϣ -->
//			ChannelInfoType channelInfo = new ChannelInfoType();
////			<m0:ChannelInfo>
////				<m0:ChannelCode>HNTV1</m0:ChannelCode>
//				channelInfo.setChannelCode(channelCode); //һ�� 
////				channelInfo.setChannelCode("HNTV");
////				<m0:ChannelName>����Ƶ��</m0:ChannelName>
//				channelInfo.setChannelName(carrierAliasName); //����Ƶ��
////				channelInfo.setChannelName("��������");
//				
//				System.out.println("channelCode >>>" + channelCode);
//				System.out.println("channelCode >>>" + channel.getName());
//				
//				
////			</m0:ChannelInfo>
//			broadcastListEntity.setChannelInfo(channelInfo);
//				
////			<!-- ��沥�������� -->
////			<m0:ListName>����Ƶ��2013-03-10��浥</m0:ListName>
//			broadcastListEntity.setListName(carrierAliasName+publishDate+"��浥");
////			<!-- �����Ϣ -->
//			ExecuteActionType auditInfo = new ExecuteActionType();
////			<m0:AuditInfo>
////				<m0:UserID>36a50115-3c50-42d7-9245-847028dfbbeb</m0:UserID>
//				auditInfo.setUserID(loginUserId);
////				<m0:UserName>admin</m0:UserName>
//				auditInfo.setUserName(creator);
////				<m0:ActionTime>2013-03-10 08:00:00</m0:ActionTime>
//				auditInfo.setActionTime(auditTime);
////			</m0:AuditInfo>
//			broadcastListEntity.setAuditInfo(auditInfo);
//			
////			<!-- ĩ���޸���Ϣ -->
//			ExecuteActionType lastEditInfo = new ExecuteActionType();
////			<m0:LastEditInfo>
////				<m0:UserID>36a50115-3c50-42d7-9245-847028dfbbeb</m0:UserID>
//				lastEditInfo.setUserID(loginUserId);
////				<m0:UserName>admin</m0:UserName>
//				lastEditInfo.setUserName(creator);
////				<m0:ActionTime>2013-02-28 08:00:00</m0:ActionTime>
//				lastEditInfo.setActionTime(auditTime);
////			</m0:LastEditInfo>
//			broadcastListEntity.setLastEditInfo(lastEditInfo);
//			
////			<!-- �������汾�ţ��ο�����1,2,3������ -->
////			<m0:Version>1</m0:Version>
//			broadcastListEntity.setVersion("1");
////			<!-- ����������ʵ������һ�� -->
////			<m0:ListItemCount>2</m0:ListItemCount>	
////			broadcastListEntity.setListItemCount(resourceCount);
//
////			System.out.println("resourceCount >>>" + resourceCount);
//			
//			
//			
//			//ÿ����λ�µĹ����Ŀ
////			BroadcastListItemType[] listItem = new BroadcastListItemType[resourceCount];
//			
//			List<BroadcastListItemType> listItems = new ArrayList<BroadcastListItemType>();
//			
//
//			for(int i = 0 ; i< resourceCount;i++){                     
//				PublishArrange publishArrange = objs[i];
//					
//				Long resId = publishArrange.getResourceId();
//				String resourceName = publishArrange.getResourceName() ;
//				String resourceMemo = publishArrange.getMemo();
//				Resource resource = (Resource)resMap.get(resId.toString());
//				Workspan workspan = resource.getWorkspan();
//				String standTime = ResourceUtil.getStandTimeByWeek(workspan,publish_date.toString());
//				ResourceSort resSort = resource.getResSort();
//				String res_sort_value = resSort.getValue();
////				System.out.println("standTime>>>>>>>>>>>>>>>>>" + standTime);
//				System.out.println("res_sort_value>>>>>>>>>>>>>>>>>" + res_sort_value);
//				
//				if(!lsBeiboEnableParamResSorts.contains(res_sort_value)){
////					System.out.println("res_sort_value>>>>>>>>>>>>>>>>>" + res_sort_value);
//					continue; 
//				}
//				
////				System.out.println("res_sort_value i>>>>>>>>>>>>>>>>>" + i);
//				
////				if (!"1".equals(res_sort_value) && !"3".equals(res_sort_value)) { 
////	                continue; 
////	            } 
//				
//				
//				Integer broadcastStartTime = workspan.getBroadcastStartTime();
////	       		String broTime = workspan.getBroadcastTimeFormat();
////	       		String broTimeStar = workspan.getBroadcastTimeFormatStart();
//	       		String broTimeStar = DateUtil.formatLongToTimeStr(Long.valueOf(broadcastStartTime*1000));
////	       		String broTimeEnd = workspan.getBroadcastTimeFormatEnd();
//	       		
//	       		String itemId = publish_date + "s"+resId.toString();
//	       		
//	       		System.out.println("itemId "+ i +">>>" +itemId);
//	       		
//	       		BroadcastListItemType listItem = new BroadcastListItemType();
//	       		
////	       		ExtendAttributeType[] extendAttributes3 = new ExtendAttributeType[0];
////	       		listItem.setExtendAttributes(extendAttributes3);
//
//	       		
////				<!-- ��沥��������Ϣ -->
////				<m0:ListItem>
////					<!-- ��沥������ID -->
////					<m0:ItemID>20131101s01</m0:ItemID>
////	       		    System.out.println("listItem[0] >>>" + listItem[i]);
//	
//					listItem.setItemID(itemId);  // ����ʱ�� +"s"+��λID��
////					<!-- ��沥���������� -->
////					<m0:ItemName>��������Ϸ����1</m0:ItemName>
//					listItem.setItemName(resourceName);
////					<!-- ����� -->
////					<m0:ItemIndex>1</m0:ItemIndex>
//					listItem.setItemIndex(i+1);
////					<!-- �����ͣ�Ĭ��2������Ŀ������Ŀ��-->
////					<m0:ItemType>2</m0:ItemType>
//					listItem.setItemType(2);
////					<!-- ������ʽ��1-������2-˳����3-�ֶ������� 4-���岥����ʽ��5-��Բ壬6-���壬7-�ֹ��岥-->
////					<m0:PlayMode>5</m0:PlayMode>
//					listItem.setPlayMode(5);
////					<!-- �������� -->
////					<m0:PlayDate>2013-03-10</m0:PlayDate>
//					listItem.setPlayDate(publishDate);
////					<!-- ����ʱ�� -->
////					<m0:PlayTime>07:30:00</m0:PlayTime>
//					listItem.setPlayTime(broTimeStar);
//					
//					System.out.println("broTimeStar>>>>>>>>>>>>>>>>>" + broTimeStar);
//					
////					<!-- ��Բ岥ʱ�����ʱ�䣬��ʽHH:MM:SS:FF����ֱ����д00:00:00:00 -->
////					<m0:InsertTime>00:00:00:00</m0:InsertTime>
//					listItem.setInsertTime("00:00:00:00");
////					<!-- ��ʱ������λ֡ -->
//					Long duration = Long.valueOf(standTime).longValue() *25;
//					
////					System.out.println("duration>>>>>>>>>>>>>>>>>" + duration);
//					
////					<m0:Duration>750</m0:Duration>
//					listItem.setDuration(duration);
//					
//					
//					
////					<!-- ���ز���Ϣ -->
//					ProgramInfoType programInfo = new ProgramInfoType();
////					ExtendAttributeType[] extendAttributes4 =new ExtendAttributeType[0];
////					programInfo.setExtendAttributes(extendAttributes4);
//					
//					String programCode = resId.toString();
////					<m0:ProgramInfo>
////						<!-- �κϲ����ID��ҵ��ID�� -->
////						<m0:ProgramCode>29063</m0:ProgramCode>
//						programInfo.setProgramCode(programCode);
////						<!-- ��� -->
////						<m0:InPoint>0</m0:InPoint>
//						programInfo.setInPoint(0);
////						<!-- ��ʱ������λ֡ -->
////						<m0:Duration>750</m0:Duration>
//						programInfo.setDuration(duration);
////						<m0:ExtendAttributes>
////						</m0:ExtendAttributes>
////					</m0:ProgramInfo>
//					listItem.setProgramInfo(programInfo);
//					
////					<!-- �Ͳ����ͣ�1-�ļ���2-�Ŵ���3-���ʣ�4-�źţ�5-������� -->
////					<m0:SendPlayType>1</m0:SendPlayType>
//					listItem.setSendPlayType(1);
//					
//					
////					<!-- ��Ŀ��Ϣ -->
//					ColumnInfoType columnInfo = new ColumnInfoType();
////					<m0:ColumnInfo>
//					
////						<!-- ��Ŀ���� -->
////						<m0:ColumnCode>SHGC</m0:ColumnCode>
//						columnInfo.setColumnCode(resourceName);
////						<!-- ��Ŀ���� -->
////						<m0:ColumnName>����۲�</m0:ColumnName>
//						columnInfo.setColumnName(resourceName);
////						<!-- ��Ŀ���ͣ�0-������Ŀ,1-��Ŀ����Σ�2-��Ŀ�ڹ���,3-��ɱ� -->
////						<m0:ColumnType>1</m0:ColumnType>
//						columnInfo.setColumnType(1);
////						<!-- ��Ŀʱ��,��λ֡ -->
////						<m0:ColumnDuration>45000</m0:ColumnDuration>
//					
//						columnInfo.setColumnDuration(duration);
////					</m0:ColumnInfo>
//					listItem.setColumnInfo(columnInfo);
//					
////					<!-- ������Ŀ���� -->
////					<m0:SubItemCount>2</m0:SubItemCount>
//					PublishArrangeDetail[]  publishArrangeDetails = publishArrange.getDetails();
//					int subItemCount = publishArrangeDetails.length;
//					long adStartTime = broadcastStartTime.intValue();
//					
//					String adPlayTime11 = DateUtil.formatLongToTimeStr(Long.valueOf(adStartTime*1000));
//					System.out.println("adPlayTime11>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +adPlayTime11);
//					
//					
//					listItem.setSubItemCount(subItemCount);
//					
//					BroadcastListItemType[] subItem = new BroadcastListItemType[subItemCount];
//					
//					
//					long sumAdDuration = 0;
//					for(int j = 0 ;j < subItemCount;j++){
//						PublishArrangeDetail publishArrangeDetail = publishArrangeDetails[j];
//						
////						System.out.println("publishArrangeDetail>>>>>>>>>>>>>>>>>" + publishArrangeDetail.toString());
//						
//						String matterName = publishArrangeDetail.getMatterName();
////						String matterId = publishArrangeDetail.getMatterId().toString();
//						String tapeCode = publishArrangeDetail.getTapeCode();
////						String matterId = publishArrangeDetail.getMatterId().toString();
//						String matterEdit = publishArrangeDetail.getMatterEdit();
//						int adSequence = publishArrangeDetail.getPublishSort().intValue();
//						String matterInfo = matterName +" "+ matterEdit;
//						long matterLength = Long.parseLong(publishArrangeDetail.getMatterLength());
//						long ad_PlayTime = (j ==0)?adStartTime: adStartTime + matterLength;
//						adStartTime = ad_PlayTime;
//						
////						System.out.println("ad_PlayTime>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +ad_PlayTime);
//						
//						String adPlayTime = DateUtil.formatLongToTimeStr(Long.valueOf(ad_PlayTime*1000));
//						
////						System.out.println("adPlayTime>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +adPlayTime);
//						
//						long adDuration = Long.valueOf(matterLength)*25;
//						sumAdDuration += adDuration;
//						
//						subItem[j] = new BroadcastListItemType();
////						ExtendAttributeType[] extendAttributes5 = new ExtendAttributeType[0];
////						subItem[j].setExtendAttributes(extendAttributes5);
//                    
////					<!-- ������Ŀ��Ϣ -->
////					<m0:SubItem>
////						<!-- ��ĿID -->
////						<m0:ItemID>20131101T01</m0:ItemID>
//						String subItemId  =  publish_date +"S"+resId.toString()+ "T" + adSequence;
//						
////						System.out.println("subItemId>>>>>>>>>>>>>>>>>" + subItemId);
////						System.out.println("adPlayTime>>>>>>>>>>>>>>>>>" + adPlayTime);
////						 UUID uu_id = UUID.randomUUID();
//						subItem[j].setItemID(subItemId);
////						<!-- ��Ŀ���� -->
////						<m0:ItemName>����ҩҵС������С����ƪ5+����ƪ--θ��������ƪ�ط���10</m0:ItemName>
//						subItem[j].setItemName(matterInfo);
////						<!-- ������Ŀ��� -->
////						<m0:ItemIndex>1</m0:ItemIndex>
//						subItem[j].setItemIndex(adSequence);
////						<!-- ��Ŀ���� 1-����Ŀ-->
////						<m0:ItemType>1</m0:ItemType>
//						subItem[j].setItemType(1);
////						<m0:PlayTime>07:30:00</m0:PlayTime>
//						subItem[j].setPlayTime(adPlayTime);
//						
//						System.out.println("adPlayTime>>>>>>>>>>>>>>>>>" + adPlayTime);
////						<m0:InsertTime>00:00:00:00</m0:InsertTime>
//						subItem[j].setInsertTime("00:00:00:00");
////						<m0:Duration>375</m0:Duration>
//						subItem[j].setDuration(adDuration);
//						
//						ProgramInfoType subProgramInfo = new ProgramInfoType();
////						<m0:ProgramInfo>
////							<!-- ����д�ɶ�����Ŀ�ز�ID -->
////							<m0:ProgramCode>290674</m0:ProgramCode>
//							subProgramInfo.setProgramCode(tapeCode);
////							<!-- ������Ŀ�ز�ID -->
////							<m0:ClipID>290674</m0:ClipID>
//							subProgramInfo.setClipID(tapeCode);
////							<!-- �ز����� -->
////							<m0:ClipName>����ҩҵС������С����ƪ5+����ƪ--θ��������ƪ�ط���10</m0:ClipName>
//							subProgramInfo.setClipName(matterInfo);
////							<!-- �ز���� -->
////							<m0:InPoint>0</m0:InPoint>
//							subProgramInfo.setInPoint(0);
////							<!-- �ز�ʱ�� --> 
////							<m0:Duration>375</m0:Duration>
//							subProgramInfo.setDuration(adDuration);
////							<m0:ExtendAttributes>
////							</m0:ExtendAttributes>
////						</m0:ProgramInfo>
//						subItem[j].setProgramInfo(subProgramInfo);	
////						<!-- ����Ŀ������Ϊ0 -->
////						<m0:SubItemCount>0</m0:SubItemCount>
//						subItem[j].setSubItemCount(0);
////						<m0:ExtendAttributes>
////						</m0:ExtendAttributes>	
////					</m0:SubItem>
//					}	
//					listItem.setSubItem(subItem);
//					
//					listItem.setDuration(sumAdDuration);
//					
//					if(subItemCount >0) listItems.add(listItem);
//					
////					System.out.println("listItem["+i+"]>>>>>>>>>>>>>>>>>" +listItem.toString());
//					
////					<m0:ExtendAttributes>
////					</m0:ExtendAttributes>					
////				</m0:ListItem>				
//			}
//			
//			
//			int listItemCount = listItems.size();
//			BroadcastListItemType[] items = new BroadcastListItemType[listItemCount];
//			broadcastListEntity.setListItem(listItems.toArray(items));
//			broadcastListEntity.setListItemCount(listItemCount);
//			
//			ImportProgramListRequest.setBroadcastListEntity(broadcastListEntity);
//			ImportProgramListRequest.setCommonRequest(commonRequest);
//	
//			String staus ="";
//			String newId ="";
//			try {
//				if(listItems.size()>0){
//					ImportProgramListResponseType importProgramListResponse = service.importProgramList(ImportProgramListRequest);
//					CommonResponseType commonResponse = importProgramListResponse.getCommonResponse();
//		//			<!-- ����״̬��0-�ɹ���1-ʧ�� -->
//		//			<ns4:Status>0</ns4:Status>
//					 staus = String.valueOf(commonResponse.getStatus());
//		//			<!-- ״̬�������� -->
//		//			<Description>�����沥������ID=a45a46d9-0859-412d-88a2-5f6beafaaa06���ɹ���</Description>
////					 <Description>���ݿ��Ѿ�����ID=2906300112�ĶΣ����ö��Ѿ�����ID=a45a46d9-0859-412d-88a2-5f6beafb6906�Ĳ���������Ҫ����Ĳ�������ID=a45a46d9-0859-412d-88a2-5f6beafaaa06����ͻ�����ݴ����벥����ʧ�ܡ�</Description>
//					 newId = commonResponse.getDescription();	
//					 System.out.println("importProgramList staus >>>>>>>>>>" + staus +" description" +newId);
//				}else{
//					System.out.println("importProgramList no advs for import to dayang!");
//				}
//
//				
//			} catch (RemoteException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//
//		
//		return staus;
//		
// }
 
 
 
 
// //���浽��������
// private  String  savePublishArrange2Dayang(PublishArrange arrange,PublishArrange[] objs){
//	 
////		String IURL = Constants.DAYANG_WEBSERVER_IMPORT_PROLIST_URL;
//		String IURL = Constants.DAYANG_WEBSERVER_IMPORT_PROLIST_URL_TEST;
//		
//		java.net.URL portAddress = null;
//		ImportProgramList service = null;
//		
//		try {
//			portAddress = new java.net.URL(IURL);
//		} catch (MalformedURLException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}  
//		
//		ImportProgramListService mgr = new ImportProgramListServiceLocator();
//		
//		try {
//			service = mgr.getImportProgramListServiceHttpPort(portAddress);
//		} catch (ServiceException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		ImportProgramListRequestType ImportProgramListRequest = new ImportProgramListRequestType();
//		
//		
//		
//		
//		String orgId = arrange.getOrgId().toString();
//		Org org = SysParamUtil.getOrgFromMap(orgId);
//		String loginUserId = arrange.getLoginUserId();
//		String loginUser = arrange.getLoginUser();
//		String creator = UserUtil.getUserFullNameById(loginUserId);
//	
//		String orgName =org.getName();
//		Integer publish_date = arrange.getPublishDate();
//		String  publishDate = DateUtil.SetDateFormat(publish_date.toString(),"yyyy-MM-dd");
//		String auditTime =  DateUtil.getStringDate(null);//�����ַ�����ʽ yyyy-MM-dd HH:mm:ss
//		Long carrierId = arrange.getCarrierId();
//		String carrierName = arrange.getCarrierName();
//		
//		Map carrierMap = CarrierUtil.getAllCarriersLevelOne(new Carrier());
//		Carrier car = (Carrier)carrierMap.get(new Long(carrierId));
//		ResourceChannel channel = car.getResourceChannel();
//		String carrierAliasName = car.getAliasName();
//		
//		Resource res = new Resource();
//		res.setCarrierId(new Long(carrierId));
//		res.setInPublishDate(publish_date);
//		 Map resMap = ResourceUtil.getResourceWithWorkspan(res);
//		 
//		
//		int resourceCount = objs.length;
//		
//	
//		int exchangeType = 1;
////		Ů�Ѽ�ʱ�У��Ѿ���Q�ѣ���֪������û�ѣ��ܷ�����Ů���ѣ�
//		CommonRequestType commonRequest = new CommonRequestType();
////		List<BroadcastListEntityType> adBroadcastList  = new ArrayList<BroadcastListEntityType>();
//		BroadcastListEntityType adBroadcastList  = new BroadcastListEntityType();
////			<!-- ������������ϵͳID -->
////			<m:RequestSystemID>BoRuiADM</m:RequestSystemID>
////			commonRequest.setRequestSystemID("BoRuiADM");
//			commonRequest.setSourceID("ADM");
////			<!-- ��������ϵͳ�ĵ�ǰ�û�ID -->
////			<m:UserID>11203</m:UserID>
//			commonRequest.setUserID("admin");
////			<!-- ��������ϵͳ�ĵ�ǰ�û����� -->
////			<m:UserID>Admin</m:UserID>
//			commonRequest.setUserName(creator);		 
//			
//			
//			
////			<!-- ��沥����ID	-->
////			<m0:ListID>a45a46d9-0859-412d-88a2-5f6beafaaa06</m0:ListID>
//			 UUID uuid = UUID.randomUUID();
//			adBroadcastList.setListID(uuid.toString());
////			<!-- �������ڡ���ʽ��yyyy-MM-dd�� -->
////			<m0:PlayDate>2013-03-10</m0:PlayDate>
//			adBroadcastList.setPlayDate(publishDate);
////			<!-- 2����沥���� -->
////			<m0:ListType>2</m0:ListType>
//			adBroadcastList.setListType(2);
//			
//			
//			
////			<!-- Ƶ����Ϣ -->
//			ChannelInfoType channelInfo = new ChannelInfoType();
////			<m0:ChannelInfo>
////				<m0:ChannelCode>HNTV1</m0:ChannelCode>
////				channelInfo.setChannelCode(channel.getName());
//				channelInfo.setChannelCode("HNTV");
////				<m0:ChannelName>����Ƶ��</m0:ChannelName>
////				channelInfo.setChannelName(carrierAliasName);
//				channelInfo.setChannelName("��������");
////			</m0:ChannelInfo>
//			adBroadcastList.setChannelInfo(channelInfo);
//				
////			<!-- ��沥�������� -->
////			<m0:ListName>����Ƶ��2013-03-10��浥</m0:ListName>
//			adBroadcastList.setListName(carrierAliasName+publishDate+"��浥");
////			<!-- �����Ϣ -->
//			ExecuteActionType auditInfo = new ExecuteActionType();
////			<m0:AuditInfo>
////				<m0:UserID>36a50115-3c50-42d7-9245-847028dfbbeb</m0:UserID>
//				auditInfo.setUserID(loginUserId);
////				<m0:UserName>admin</m0:UserName>
//				auditInfo.setUserName(creator);
////				<m0:ActionTime>2013-03-10 08:00:00</m0:ActionTime>
//				auditInfo.setActionTime(auditTime);
////			</m0:AuditInfo>
//			adBroadcastList.setAuditInfo(auditInfo);
//			
////			<!-- ĩ���޸���Ϣ -->
//			ExecuteActionType lastEditInfo = new ExecuteActionType();
////			<m0:LastEditInfo>
////				<m0:UserID>36a50115-3c50-42d7-9245-847028dfbbeb</m0:UserID>
//				lastEditInfo.setUserID(loginUserId);
////				<m0:UserName>admin</m0:UserName>
//				lastEditInfo.setUserName(creator);
////				<m0:ActionTime>2013-02-28 08:00:00</m0:ActionTime>
//				lastEditInfo.setActionTime(auditTime);
////			</m0:LastEditInfo>
//			adBroadcastList.setLastEditInfo(lastEditInfo);
//			
////			<!-- �������汾�ţ��ο�����1,2,3������ -->
////			<m0:Version>1</m0:Version>
//			adBroadcastList.setVersion("0");
////			<!-- ����������ʵ������һ�� -->
////			<m0:ListItemCount>2</m0:ListItemCount>	
//			adBroadcastList.setListItemCount(resourceCount);
//
//		
//			System.out.println("resourceCount >>>" + resourceCount);
//			
//			BroadcastListItemType[] listItem = new BroadcastListItemType[resourceCount];
//
//			
//			
//			for(int i = 0 ; i< resourceCount;i++){                     
//				PublishArrange publishArrange = objs[i];
//					
//				Long resId = publishArrange.getResourceId();
//				String resourceName = publishArrange.getResourceName() ;
//				String resourceMemo = publishArrange.getMemo();
//				Resource resource = (Resource)resMap.get(resId.toString());
//				Workspan workspan = resource.getWorkspan();
//				Integer broadcastStartTime = workspan.getBroadcastEndTime();
//	       		String broTime = workspan.getBroadcastTimeFormat();
//	       		String broTimeStar = workspan.getBroadcastTimeFormatStart();
//	       		String broTimeEnd = workspan.getBroadcastTimeFormatEnd();
//	       		
//	       		String itemId = publish_date + "s"+resId.toString();
//	       		
//	       		System.out.println("itemId "+ i +">>>" +itemId);
//	       		
//	       		listItem[i] = new BroadcastListItemType();
//
//	       		
////				<!-- ��沥��������Ϣ -->
////				<m0:ListItem>
////					<!-- ��沥������ID -->
////					<m0:ItemID>20131101s01</m0:ItemID>
//	       		    System.out.println("listItem[0] >>>" + listItem[i]);
//	
//					listItem[i].setItemID(itemId);
////					<!-- ��沥���������� -->
////					<m0:ItemName>��������Ϸ����1</m0:ItemName>
//					listItem[i].setItemName(resourceName);
////					<!-- ����� -->
////					<m0:ItemIndex>1</m0:ItemIndex>
//					listItem[i].setItemIndex(i);
////					<!-- �����ͣ�Ĭ��2������Ŀ������Ŀ��-->
////					<m0:ItemType>2</m0:ItemType>
//					listItem[i].setItemType(2);
////					<!-- ������ʽ��1-������2-˳����3-�ֶ������� 4-���岥����ʽ��5-��Բ壬6-���壬7-�ֹ��岥-->
////					<m0:PlayMode>5</m0:PlayMode>
//					listItem[i].setPlayMode(2);
////					<!-- �������� -->
////					<m0:PlayDate>2013-03-10</m0:PlayDate>
//					listItem[i].setPlayDate(publishDate);
////					<!-- ����ʱ�� -->
////					<m0:PlayTime>07:30:00</m0:PlayTime>
//					listItem[i].setPlayTime(broTimeStar);
////					<!-- ��Բ岥ʱ�����ʱ�䣬��ʽHH:MM:SS:FF����ֱ����д00:00:00:00 -->
////					<m0:InsertTime>00:00:00:00</m0:InsertTime>
//					listItem[i].setInsertTime("00:00:00:00");
////					<!-- ��ʱ������λ֡ -->
////					<m0:Duration>750</m0:Duration>
//					listItem[i].setDuration(750);
////					<!-- ���ز���Ϣ -->
//					ProgramInfoType programInfo = new ProgramInfoType();
////					<m0:ProgramInfo>
////						<!-- �κϲ����ID��ҵ��ID�� -->
////						<m0:ProgramCode>29063</m0:ProgramCode>
//						programInfo.setProgramCode("29063");
////						<!-- ��� -->
////						<m0:InPoint>0</m0:InPoint>
//						programInfo.setInPoint(0);
////						<!-- ��ʱ������λ֡ -->
////						<m0:Duration>750</m0:Duration>
//						programInfo.setDuration(750);
////						<m0:ExtendAttributes>
////						</m0:ExtendAttributes>
////					</m0:ProgramInfo>
//					listItem[i].setProgramInfo(programInfo);
//					
////					<!-- �Ͳ����ͣ�1-�ļ���2-�Ŵ���3-���ʣ�4-�źţ�5-������� -->
////					<m0:SendPlayType>1</m0:SendPlayType>
//					listItem[i].setSendPlayType(1);
////					<!-- ��Ŀ��Ϣ -->
//					ColumnInfoType columnInfo = new ColumnInfoType();
////					<m0:ColumnInfo>
//					
////						<!-- ��Ŀ���� -->
////						<m0:ColumnCode>SHGC</m0:ColumnCode>
//						columnInfo.setColumnCode(resourceMemo);
////						<!-- ��Ŀ���� -->
////						<m0:ColumnName>����۲�</m0:ColumnName>
//						columnInfo.setColumnName(resourceName);
////						<!-- ��Ŀ���ͣ�0-������Ŀ,1-��Ŀ����Σ�2-��Ŀ�ڹ���,3-��ɱ� -->
////						<m0:ColumnType>1</m0:ColumnType>
//						columnInfo.setColumnType(1);
////						<!-- ��Ŀʱ��,��λ֡ -->
////						<m0:ColumnDuration>45000</m0:ColumnDuration>
//						columnInfo.setColumnDuration(new Long(45000));
////					</m0:ColumnInfo>
//					listItem[i].setColumnInfo(columnInfo);
//					
////					<!-- ������Ŀ���� -->
////					<m0:SubItemCount>2</m0:SubItemCount>
//					PublishArrangeDetail[]  publishArrangeDetails = publishArrange.getDetails();
//					int subItemCount = publishArrangeDetails.length;
//					int adStartTime = broadcastStartTime.intValue();
//					listItem[i].setSubItemCount(subItemCount);
//					
//					BroadcastListItemType[] subItem = new BroadcastListItemType[subItemCount];
//					
//					for(int j = 0 ;j < subItemCount;j++){
//						PublishArrangeDetail publishArrangeDetail = publishArrangeDetails[j];
//						String matterName = publishArrangeDetail.getMatterName();
////						String matterId = publishArrangeDetail.getMatterId().toString();
//						String tapeCode = publishArrangeDetail.getTapeCode();
//						String matterEdit = publishArrangeDetail.getMatterEdit();
//						int adSequence = publishArrangeDetail.getPublishSort().intValue();
//						String matterInfo = matterName +" "+ matterEdit;
//						int matterLength = Integer.parseInt(publishArrangeDetail.getMatterLength());
//						int setPlayTime = (j ==0)?adStartTime: adStartTime + matterLength;
//						
//						
//						subItem[j] = new BroadcastListItemType();
//                    
////					<!-- ������Ŀ��Ϣ -->
////					<m0:SubItem>
////						<!-- ��ĿID -->
////						<m0:ItemID>20131101T01</m0:ItemID>
//						 UUID uu_id = UUID.randomUUID();
//						subItem[j].setItemID(uu_id.toString());
////						<!-- ��Ŀ���� -->
////						<m0:ItemName>����ҩҵС������С����ƪ5+����ƪ--θ��������ƪ�ط���10</m0:ItemName>
//						subItem[j].setItemName(matterInfo);
////						<!-- ������Ŀ��� -->
////						<m0:ItemIndex>1</m0:ItemIndex>
//						subItem[j].setItemIndex(adSequence);
////						<!-- ��Ŀ���� 1-����Ŀ-->
////						<m0:ItemType>1</m0:ItemType>
//						subItem[j].setItemType(1);
////						<m0:PlayTime>07:30:00</m0:PlayTime>
//						subItem[j].setPlayTime(setPlayTime+"");
////						<m0:InsertTime>00:00:00:00</m0:InsertTime>
//						subItem[j].setInsertTime("00:00:00:00");
////						<m0:Duration>375</m0:Duration>
//						subItem[j].setDuration(375);
//						
//						ProgramInfoType subProgramInfo = new ProgramInfoType();
////						<m0:ProgramInfo>
////							<!-- ����д�ɶ�����Ŀ�ز�ID -->
////							<m0:ProgramCode>290674</m0:ProgramCode>
//							subProgramInfo.setProgramCode(tapeCode);
////							<!-- ������Ŀ�ز�ID -->
////							<m0:ClipID>290674</m0:ClipID>
//							subProgramInfo.setClipID(tapeCode);
////							<!-- �ز����� -->
////							<m0:ClipName>����ҩҵС������С����ƪ5+����ƪ--θ��������ƪ�ط���10</m0:ClipName>
//							subProgramInfo.setClipName(matterInfo);
////							<!-- �ز���� -->
////							<m0:InPoint>0</m0:InPoint>
//							subProgramInfo.setInPoint(0);
////							<!-- �ز�ʱ�� --> 
////							<m0:Duration>375</m0:Duration>
//							subProgramInfo.setDuration(matterLength);
////							<m0:ExtendAttributes>
////							</m0:ExtendAttributes>
////						</m0:ProgramInfo>
//						subItem[j].setProgramInfo(subProgramInfo);	
////						<!-- ����Ŀ������Ϊ0 -->
////						<m0:SubItemCount>0</m0:SubItemCount>
//						subItem[j].setSubItemCount(0);
////						<m0:ExtendAttributes>
////						</m0:ExtendAttributes>	
////					</m0:SubItem>
//					}	
//					listItem[i].setSubItem(subItem);
//					
////					System.out.println("listItem["+i+"]>>>>>>>>>>>>>>>>>" +listItem[i].toString());
//					
////					<m0:ExtendAttributes>
////					</m0:ExtendAttributes>					
////				</m0:ListItem>				
//			}
//			
//			
//			
//			adBroadcastList.setListItem(listItem);
//			ImportProgramListRequest.setBroadcastListEntity(adBroadcastList);
//			ImportProgramListRequest.setCommonRequest(commonRequest);
//	
//			String staus ="";
//			String newId ="";
//			try {
//				ImportProgramListResponseType importProgramListResponse = service.importProgramList(ImportProgramListRequest);
//				CommonResponseType commonResponse = importProgramListResponse.getCommonResponse();
//	//			<!-- ����״̬��0-�ɹ���1-ʧ�� -->
//	//			<ns4:Status>0</ns4:Status>
//				 staus = String.valueOf(commonResponse.getStatus());
//	//			<!-- ״̬�������� -->
//	//			<Description>�����沥������ID=a45a46d9-0859-412d-88a2-5f6beafaaa06���ɹ���</Description>
//				 newId = commonResponse.getDescription();	
//				
//			} catch (RemoteException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println("importProgramList staus   >>>>>>>>>>>>>.    >>>>        >>>>>>>>>>>>>>>>>" + staus);
//			
//			System.out.println("importProgramList getDescription   >>>>>>>>>>>>>.    >>>>        >>>>>>>>>>>>>>>>>" +newId);
//		
//		return staus;
//		
// }
 
// //���浽��������
// private  String  savePublishArrange2Dayang(PublishArrange arrange,PublishArrange[] objs){
//	 
//	 
//		String IURL = Constants.DAYANG_WEBSERVER_IMPORT_PROLIST_URL;
//		java.net.URL portAddress = null;
//		ImportMaterial service = null;
//		
//		try {
//			portAddress = new java.net.URL(IURL);
//		} catch (MalformedURLException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}  
//		
//		
//		
//		ImportProgramListService mgr = new ImportProgramListServiceLocator();
//		
//		
//	 
//		String IURL ="http://Server:8080/ADP/services/ImportBroadcastListService";
//	 	String IURL = Constants.DAYANG_WEBSERVER_IMPORT_BROLIST_URL;		
//		ImportBroadcastListServiceClient client = new ImportBroadcastListServiceClient();
//		ImportBroadcastList service = client.getImportBroadcastListServiceHttpPort(IURL);
//		 com.dayang.adp.schema.adpserviceparametertype._0.ObjectFactory  factoryParam = new  com.dayang.adp.schema.adpserviceparametertype._0.ObjectFactory();
//		 ImportBroadcastListRequestType importBroadcastListRequest = factoryParam.createImportBroadcastListRequestType();
//		 
//		String orgId = arrange.getOrgId().toString();
//		Org org = SysParamUtil.getOrgFromMap(orgId);
//		String loginUserId = arrange.getLoginUserId();
//		String creator = UserUtil.getUserFullNameById(loginUserId);
//		
//		
//		
//		
//		String orgName =org.getName();
//		Integer publish_date = arrange.getPublishDate();
//		String  publishDate = DateUtil.SetDateFormat(publish_date.toString(),"yyyy-MM-dd");
//		String auditTime =  DateUtil.getStringDate();//�����ַ�����ʽ yyyy-MM-dd HH:mm:ss
//		String carrierName = arrange.getCarrierName();
//		
//		int exchangeType = 1;
//		importBroadcastListRequest.setExchangeType(exchangeType);
//		 CommonRequestType commonRequest = importBroadcastListRequest.getCommonRequest();
//		 ADBroadcastListType adBroadcastList = importBroadcastListRequest.getADBroadcastList();
//		 
////			<!-- ������������ϵͳID -->
////			<m:RequestSystemID>BoRuiADM</m:RequestSystemID>
//			commonRequest.setRequestSystemID("BoRuiADM");
////			<!-- ��������ϵͳ�ĵ�ǰ�û�ID -->
////			<m:UserID>11203</m:UserID>
//			commonRequest.setUserID("11203");
////			<!-- ��������ϵͳ�ĵ�ǰ�û����� -->
////			<m:UserID>Admin</m:UserID>
//			commonRequest.setUserName("Admin");		 
//			
//
//			com.dayang.adp.schema.adbroadcastlistentity._1.ObjectFactory  factoryADSegmentTypeEntity =
//				new com.dayang.adp.schema.adbroadcastlistentity._1.ObjectFactory();
//
////			<!-- ��沥����ID��������������ʹ��GUID	-->
////			<m0:ListID>20090719</m0:ListID>
//			 UUID uuid = UUID.randomUUID();
//			adBroadcastList.setListID(uuid.toString());
////			<!-- ��沥��������	-->
////			<m0:ListName>���ϵ���̨����Ƶ�����ಥ��</m0:ListName>
////			adBroadcastList.setListName("���ϵ���̨����Ƶ�����ಥ��");
//			adBroadcastList.setListName(orgName);
////			<!-- ��沥�����汾	���Ǳ�����ɲ��� -->
////			<m0:ListVersion>1</m0:ListVersion>
//			adBroadcastList.setListVersion(0);
////			<!-- Ƶ��ID -->
////			<m0:ChannelID>1</m0:ChannelID>
//			adBroadcastList.setChannelID("1");
////			<!-- Ƶ������ -->
////			<m0:ChannelCode>WXPD</m0:ChannelCode>
//			adBroadcastList.setChannelCode("WXPD");
////			<!-- Ƶ������ -->
////			<m0:ChannelName>����Ƶ��</m0:ChannelName>
//			adBroadcastList.setChannelName(carrierName);
////			<!-- �������� ��ʽ��yyyy-MM-dd�� -->
////			<m0:PlayDate>2012-07-19</m0:PlayDate>
//			adBroadcastList.setPlayDate(publishDate);
////			<!-- ���ʱ�䣨��ʽyyyy-MM-dd hh:mm:ss�� -->
////			<m0:AuditTime>2012-07-22 12:03:09</m0:AuditTime>
//			adBroadcastList.setAuditTime(auditTime);
////			<!-- ����������ˣ��Ǳ�����	-->
////			<m0:Auditor>����</m0:Auditor>
//			adBroadcastList.setAuditor("");
////			<!-- ������������ -->
////			<m0:Creator>����</m0:Creator>
//			adBroadcastList.setCreator(creator);
////			<!-- �������޸���-->
////			<m0:Editor>����</m0:Editor>
//			adBroadcastList.setEditor(creator);
////			<!-- ����޸�ʱ�䣨��ʽyyyy-MM-dd hh:mm:ss��-->
////			<m0:LastModificationTime>2012-07-24 15:54:04</m0:LastModificationTime>
//			adBroadcastList.setLastModificationTime(auditTime);
//		
//			List adSegmentEntitys = adBroadcastList.getADSegments();
////			List<ADSegmentType> adSegments = new ArrayList<ADSegmentType>();
//			
//			
//			int segmentIndex = 1;
//			for(int i = 0 ;i<objs.length;i++){                     
//				PublishArrange publishArrange = objs[i];
//				Long id = publishArrange.getId();
//				
//				String resourceName = publishArrange.getResourceName() ;
//			 
//				
////				ADSegmentType aDSegmentType = new ADSegmentType();
//				
//				ADSegmentType adSegmentEntity = factoryADSegmentTypeEntity.createADSegmentType();
//				
////				com.dayang.adp.schema.adbroadcastlistentity._1.ObjectFactory  factoryADSegmentTypeEntity = new com.dayang.adp.schema.adbroadcastlistentity._1.ObjectFactory();
//				 
//				
////				<!-- ������Ϣ ��һ�� -->
//
////				<m0:ADSegments>
////					<!-- ����ID��������������ʹ��GUID-->
////					<m0:SegmentID>2906300112</m0:SegmentID>
//					adSegmentEntity.setSegmentID(String.valueOf(id));
////					<!-- ����ҵ��ID��������ʾ��ͬ���͵ĶΣ�����ͬһ������һ���ڻ��ظ����Σ������趨��ͬ�Ķ�ҵ��ID -->
////					<m0:SegmentBusinessID>29063</m0:SegmentBusinessID>
//					adSegmentEntity.setSegmentBusinessID("29063");
////					<!-- �������� -->
////					<m0:SegmentName>G��������Ϸ����1</m0:SegmentName>
//					adSegmentEntity.setSegmentName(resourceName);
////					<!-- �������� 0-ƽ��ʱ�Σ�1-Ӱ�Ӿ��в����-->
////					<m0:SegmentType>1</m0:SegmentType>
//					adSegmentEntity.setSegmentType(0);
//					
////					<!-- ���β�����ţ���ʼֵΪ1 -->
////					<m0:SegmentIndex>1</m0:SegmentIndex>
//					adSegmentEntity.setSegmentIndex(segmentIndex++);
//					
////					<!-- ��Ŀ����ʱ�䣬��ʽyyyy-MM-dd HH:MM:SS-->
////					<m0:PlayTime>2009-07-31 00:01:00</m0:PlayTime>
//					adSegmentEntity.setPlayTime("2009-07-31 00:01:00");
//					
////					<!-- ��Ŀ���룬������ǰ��������������Ŀ����Ŀ����ʱ�θ��ֶ�Ϊ��-->
////					<m0:ColumnCode>32</m0:ColumnCode>
//					adSegmentEntity.setColumnCode("");
////					<!-- ��Ŀ���� -->
////					<m0:ColumnName>����۲�</m0:ColumnName>
//					adSegmentEntity.setColumnName("����۲�");
////					<!-- ��λ��ʱ������λ���� -->
////					<m0:Duration>30</m0:Duration>
//					adSegmentEntity.setDuration(30);
////					<!-- ������ʽ��0-δ֪��1-¼����2-�ⳡֱ����3-�ݲ���ֱ����4-�ȳ���-->
////					<m0:PlayPattern>1</m0:PlayPattern>
//					adSegmentEntity.setPlayPattern(1);
////					<!-- �ݲ������� -->
////					<m0:StudioName>��һ�ݲ���</m0:StudioName>
////					<!-- �����Ŀ ��һ�ε�һ�� �����Դ�����-->
//					adSegmentEntity.setStudioName("��һ�ݲ���");
//				
//				
//					PublishArrangeDetail[]  publishArrangeDetails = publishArrange.getDetails();
////					 List adEntitys = new ArrayList<ADEntityType>();
//					 List adEntitys =  adSegmentEntity.getADEntity();
//	
//					for(int k = 0;k<publishArrangeDetails.length;k++){
//						PublishArrangeDetail publishArrangeDetail = publishArrangeDetails[k];
//						ADEntityType adEntity = factoryADSegmentTypeEntity.createADEntityType();
//						
////						<!-- �����Ŀ ��һ�ε�һ��-->
////						<m0:ADEntity>
////							<m0:AdID>290584</m0:AdID>
//							adEntity.setAdID(publishArrangeDetail.getId().toString());
////							<m0:MaterialID>290584</m0:MaterialID>
//							adEntity.setMaterialID(publishArrangeDetail.getMatterId().toString());
////							<m0:MaterialName>�Ͻִ�ơ��</m0:MaterialName>
//							adEntity.setMaterialName(publishArrangeDetail.getMatterName());
////							<m0:IndexID>2</m0:IndexID>
//							adEntity.setIndexID(publishArrangeDetail.getPublishSort());
////							<m0:Duration>15</m0:Duration>
//							adEntity.setDuration(Integer.parseInt(publishArrangeDetail.getMatterLength()));
////						</m0:ADEntity>
//							
//							adEntitys.add(adEntity);
//					}
//					
//					adSegmentEntitys.add(adSegmentEntity);
//
//		
//			}  		
//
//			ImportBroadcastListResponseType importBroadcastListResponse = service.importBroadcastList(importBroadcastListRequest);
//			CommonResponseType commonResponse = importBroadcastListResponse.getCommonResponse();
//			
////			<!-- ����״̬��0-�ɹ���1-ʧ�� -->
////			<ns4:Status>0</ns4:Status>
//			String staus = String.valueOf(commonResponse.getStatus());
////			<!-- ״̬�������� -->
////			<ns4:Description>����IDΪ44668221���ز���Ϣ�ɹ���</ns4:Description>
//			String newId = commonResponse.getDescription();
//		 
//			return null;		
//
//	} 
 


 
    
   
}
