package com.vriche.adrm.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;



import com.vriche.adrm.dao.PublishArrangeDao;
import com.vriche.adrm.model.Carrier;
import com.vriche.adrm.model.Industry;
import com.vriche.adrm.model.PublishArrangeDetail;
import com.vriche.adrm.model.Resource;
import com.vriche.adrm.service.AdrmWebService;
import com.vriche.adrm.util.DateUtil;
import com.vriche.adrm.util.ServiceLocator;
import com.vriche.adrm.util.StringUtil;

public class AdrmWebServiceImpl implements AdrmWebService {

	
	public String getCarrierInfo(String orgId) {
		
		Map mp = new HashMap();
		StringBuffer sb = new StringBuffer();
		
	
		
		String newline = "\r\n";

		mp.put("orgId",orgId);
		mp.put("nodeLevel","1");

		List ls = ServiceLocator.getCarrierDao().getCarrierInfo(mp);


		sb.append("<?xml version=\"1.0\" encoding=\"GB2312\"?>");
		sb.append(newline);
		sb.append("<Import>");
		sb.append(newline);
		for(Iterator it = ls.iterator();it.hasNext();){
			Carrier carr = (Carrier) it.next();
			sb.append("<Carrier id=\""+ carr.getId()+"\" name=\""+ carr.getCarrierName()+"\"  aliasName=\""+ carr.getAliasName()+"\"/>");
			sb.append(newline);
		}
		sb.append("</Import>");
		
		return sb.toString();
	}
	
	
	public String getResourceInfo(String inPublishDate) {
		
		Map mp = new HashMap();
		StringBuffer sb = new StringBuffer();
		
		String newline = "\r\n";

//		mp.put("orgId",orgId);
//		mp.put("carrierId",carrierId);
		mp.put("year",inPublishDate.substring(0,4));
		mp.put("inPublishDate",inPublishDate);
		
		
		 System.out.println("AdrmWebService getResourceInfo  year >>>>>%%%%%%%%%%%%%%%%%%%%%%%%%%%%% vvvvvv  " + inPublishDate.substring(0,4)) ;
		 System.out.println("AdrmWebService getResourceInfo  inPublishDate >>>>>%%%%%%%%%%%%%%%%%%%%%% vvvvvvv  " + inPublishDate) ;
		 
		

		List ls = ServiceLocator.getResourceDao().getResourceInfoForWebService(mp);
//		<Import>		
//		<Resource id="2407" memo="XW9"  name="新闻航班"  carrierId="48" startTime=""/>
//		<Resource id="2408" memo="XW10"  name="一路阳光一路歌"  carrierId="48" startTime=""/>
//		</Import>


		sb.append("<?xml version=\"1.0\" encoding=\"GB2312\"?>");
		sb.append(newline);
		sb.append("<Import>");
		sb.append(newline);
		for(Iterator it = ls.iterator();it.hasNext();){
			Resource resource = (Resource) it.next();
			String resourceId = StringUtil.getNullValue(resource.getId(),"");
			String resourceName = StringUtil.getNullValue(resource.getResourceName(),"");
			String resourceMemo = StringUtil.getNullValue(resource.getMemo(),"");
			String carrierId = StringUtil.getNullValue(resource.getCarrierId(),"");
			String carrierNameMain = StringUtil.getNullValue(resource.getCarrier().getCarrierName(),"");
			String carrierNameMainAliasName = StringUtil.getNullValue(resource.getCarrier().getAliasName(),"");
			String startTime = StringUtil.getNullValue(resource.getPropertiyTime(),"0");
			

//			sb.append("<Resource id=\""+ resourceId+"\" memo=\""+ resourceMemo+"\"  resourceNam=\""+ resourceName +"\"  carrierId=\""+ carrierId+"\"  carrierNameMain=\""+ carrierNameMain +"\"  carrierNameMainAliasName=\""+ carrierNameMainAliasName+"\"/>");
			sb.append("<Resource id=\""+ resourceId+"\" memo=\""+ resourceMemo+"\"  name=\""+ resourceName +"\"  carrierId=\""+ carrierId+"\"  startTime=\""+ startTime+"\"/>");
			
			sb.append(newline);
		}
		sb.append("</Import>");
		
		return sb.toString();
	}

	public String getArrangedPublish(String carrierId, String publishDate) {
		Map mp = new HashMap();
		StringBuffer sb = new StringBuffer();
		
		String newline = "\r\n";
		
//		carrierId = "12";
//		publishDate = "20111015";

		mp.put("carrierId",carrierId);
		
		mp.put("publishDate",publishDate);

		
		   System.out.println(">>>   "+mp);
		   
		List ls = ServiceLocator.getPublishArrangeDetailDao().getArrangedPublishForWebService(mp);


		sb.append("<?xml version=\"1.0\" encoding=\"GB2312\"?>");
		sb.append(newline);
		sb.append("<Import>");
		sb.append(newline);
		
//	 	<Channel chnName="频道" BroadDate="2004-07-14">	
		
//		<ADName>广告名称</ADName>	
//		<SoundName>版本</SoundName>	
//		<FileLength>长度</FileLength>	
//		<Path>磁带编号</Path>	
//		<OrderId>订单系统编号</OrderId>	
//		<OrderCode>订单号</OrderCode>	
//		<BroadTime>播出位置</BroadTime>	
//		<BroadOrder>播出顺序</BroadOrder>	
//		<Class>指定位置<Class/>	
//		<TotalTimes>标准时长</TotalTimes>	
//		<UsdedTimes>使用时长<UsdedTimes/>	
//		<ResourceId>资源编号<ResourceId/>	
//		<IndustryId>广告分类编号<IndustryId/>	
//		</Channel>	
		
		String publish_date = DateUtil.SetDateFormat(publishDate,"yyyy-MM-dd");

	    System.out.println(">>>   "+ls.size());
	    
	    
		for(Iterator it = ls.iterator();it.hasNext();){
		    sb.append("<Channel id=\""+ carrierId+"\"  BroadDate=\""+ publish_date+"\" >");
		    sb.append(newline);
		    
			PublishArrangeDetail arrangeDetail = (PublishArrangeDetail) it.next();
			String adName = arrangeDetail.getMatterName();
			String soundName = arrangeDetail.getMatterEdit();
			String fileLength = arrangeDetail.getMatterLength();
			String path = arrangeDetail.getTapeCode();
			String orderId = StringUtil.getNullValue(arrangeDetail.getOrderId(),"");
			String orderCode = StringUtil.getNullValue(arrangeDetail.getOrderCode(),"");
			String broadTime = StringUtil.getNullValue(arrangeDetail.getResourceName(),"");
			String resourceId = StringUtil.getNullValue(arrangeDetail.getResourceId(),"0");
			String broadOrder = StringUtil.getNullValue(arrangeDetail.getPublishSort(),"");
			String className = StringUtil.getNullValue(arrangeDetail.getSpecificName(),"");
			String total = StringUtil.getNullValue(arrangeDetail.getTotal(),"0");
			String usded = StringUtil.getNullValue(arrangeDetail.getUsedTime(),"0");
			String industryId = StringUtil.getNullValue(arrangeDetail.getId(),"0");

			
			
			sb.append("<ADName>" + adName + "</ADName>");
			sb.append(newline);
			sb.append("<SoundName>" + soundName + "</SoundName>");
			sb.append(newline);
			sb.append("<FileLength>" + fileLength + "</FileLength>");
			sb.append(newline);
			sb.append("<Path>" + path + "</Path>");
			sb.append(newline);
			sb.append("<OrderId>" + orderId + "</OrderId>");
			sb.append(newline);
			sb.append("<OrderCode>" + orderCode + "</OrderCode>");
			sb.append(newline);
			sb.append("<BroadTime>" + broadTime + "</BroadTime>");
			sb.append(newline);		
			sb.append("<BroadOrder>" + broadOrder + "</BroadOrder>");
			sb.append(newline);
			sb.append("<Class>" + className + "</Class>");
			sb.append(newline);
			sb.append("<ResourceId>" + resourceId + "</ResourceId>");
			sb.append(newline);	
			sb.append("<TotalTimes>" + total + "</TotalTimes>");
			sb.append(newline);		
			sb.append("<UsdedTimes>" + usded + "</UsdedTimes>");
			sb.append(newline);				
			sb.append("<IndustryId>" + industryId + "</IndustryId>");
			sb.append(newline);				
			sb.append("</Channel>");
			sb.append(newline);
		}

		sb.append("</Import>");
		
		return sb.toString();
	}


	public String getIndustrys() {
		Map mp = new HashMap();
		StringBuffer sb = new StringBuffer();
		
		String newline = "\r\n";


		mp.put("nodeLevel","1");

		List ls = ServiceLocator.getIndustrysDao().getIndustrys(null);


		sb.append("<?xml version=\"1.0\" encoding=\"GB2312\"?>");
		sb.append(newline);
		sb.append("<Import>");
		sb.append(newline);
		for(Iterator it = ls.iterator();it.hasNext();){
			Industry industry = (Industry) it.next();
			sb.append("<Industry id=\""+ industry.getId()+"\" name=\""+ industry.getName()+"\"  code=\""+ industry.getCode()+"\"/>");
			sb.append(newline);
		}
		sb.append("</Import>");
		
		return sb.toString();
	}
	
//  webService 调用地址  http://10.77.51.51:8080/adrm/services/ImportProgramListService?wsdl
//  方法名 saveProgramListLockInfo(String iteId,String lockStatus)
//  参数1 iteId = <!-- 广告播出单段ID --> <m0:ItemID>20131101s01</m0:ItemID> 如果多个段用逗号隔开 如 id="20131101s0001,20131101s0002,20131101s0003"
//  参数2 lockStatus = 0 或 1   0-解锁   1-锁定
//  返回值 0-成功  其它是错误描述
	public String saveProgramListLockInfo(String iteId,String lockStatus) {
		
		System.out.println("saveProgramListLockInfo  iteId>>>>>>>>>>>>>>>>>" + iteId);
		System.out.println("saveProgramListLockInfo  lockStatus>>>>>>>>>>>>>>>>>" + lockStatus);

		PublishArrangeDao dao = ServiceLocator.getPublishArrangeDao();
		String state  = "0";
		
		if(iteId != null && !"".equals(iteId)){
			String[] ids = iteId.split(",");
			int size = ids.length;
			Map<String,List> mp = new HashMap<String,List>();
			for(int i = 0;i<size;i++){
				String[] idmp = ids[i].split("s");
				String publishDate = idmp[0];
				String resourceId = idmp[1];
				
				if(mp.containsKey(publishDate)){
					List ls = mp.get(publishDate);
					ls.add(resourceId);
					mp.put(publishDate,ls);
				}else{
					List ls = new ArrayList<String>();
					ls.add(resourceId);
				}
			}
			
			Iterator it = mp.keySet().iterator();
			List lsAll = new ArrayList();
			while(it.hasNext()){
				Map mpp = new HashMap();
				String publishDate = (String)it.next();
				mpp.put("publishDate",publishDate);
				mpp.put("residList",mpp.get(publishDate));
				List ls = dao.getPublishArrangeIdsByDateResid(mpp);
				if(ls.size()>0) lsAll.addAll(ls);
			}
			
			System.out.println("saveProgramListLockInfo  lsAll>>>>>>>>>>>>>>>>>" + lsAll.toString());
			if(lsAll.size()>0){
				Map mp2 = new HashMap();
				mp2.put("idList",lsAll);
				mp2.put("isLocked",lockStatus);
				dao.updatePublishArrangeLock(mp2);
			}
			
			System.out.println("saveProgramListLockInfo  >>>>>>>>>>>>>>>>" + "锁定（"+ iteId +"）成功。");
			
			
//			state ="锁定（"+ id +"）成功。";
		}else{
			state ="id不能为空";
		}

		return state;
	}


	public String getVersion() {
		// TODO Auto-generated method stub
		return "adrm V-2.1.0";
	}
	
//	public void saveMattersAllInDayang2zero(){
//		String sql ="update tb_adver_matter set in_dayang_matter = 0";
//		try {
//			ServiceLocator.getIndustrysDao().getDefaultDataSource().getConnection().createStatement().execute(sql);
//			System.out.println("saveMattersAll2dayang>>>"+sql);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

//	public ImportProgramListResponseType saveProgramListLockInfo2(ImportProgramListRequestType importProgramListRequest,String lockStatus) {
//		System.out.println("saveProgramListLockInfo  lockStatus>>>>>>>>>>>>>>>>>" + lockStatus);
//		BroadcastListEntityType broadcastListEntity = importProgramListRequest.getBroadcastListEntity();
//		BroadcastListItemType[] items =broadcastListEntity.getListItem();
//		StringBuffer sb = new StringBuffer();
//		String iteIds = null;
//		int size = items.length;
//		for(int i=0;i<size;i++){
//			BroadcastListItemType broadcastListItemType = items[i];
//			String itemId = broadcastListItemType.getItemID();
//			sb.append(itemId);
//			if(i<size-1)sb.append(",");
//		}
//		iteIds = sb.toString();
//		String rs = this.saveProgramListLockInfo(iteIds,lockStatus);
//		int states = 1;
//		String islock = "锁定";
//		String description = "";
//		if("0".equals(rs)) states = 0;
//		if("0".equals(lockStatus)) islock = "解锁";
//		if(states == 0){
//			description = islock+"（"+ iteIds +"）成功";
//		}else{
//			description = islock+"（"+ iteIds +"）失败";
//		}
//		
//		ImportProgramListResponseType importProgramListResponse = new ImportProgramListResponseType();
//		CommonResponseType commonResponse =  new CommonResponseType();
//		commonResponse.setStatus(states);
//		commonResponse.setDescription(description);
//		importProgramListResponse.setCommonResponse(commonResponse);
//
//		return importProgramListResponse;
//	}

}
