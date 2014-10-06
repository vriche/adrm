package com.vriche.adrm.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.vriche.adrm.model.PublishArrangeDetail;
import com.vriche.adrm.service.ArrangedPublishInfoService;
import com.vriche.adrm.util.DateUtil;
import com.vriche.adrm.util.ServiceLocator;
import com.vriche.adrm.util.StringUtil;

public class ArrangedPublishInfoServiceImpl implements
		ArrangedPublishInfoService {
	
	

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


		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append(newline);
		sb.append("<Import>");
		sb.append(newline);
		
//	 	<Channel chnName="频道" BroadDate="2004-07-14">	
		
//		<ADName>广告名称</ADName>	
//		<SoundName>版本</SoundName>	
//		<FileLength>长度</FileLength>	
//		<Path>磁带编号</Path>	
//		<OrderId>订单系统编号</OrderId>	
//		<OrderCode>订单号</OrderId>	
//		<BroadTime>播出位置</BroadTime>	
//		<BroadOrder>播出顺序</BroadOrder>	
//		<Class>指定位置<Class/>	
//		<TotalTimes>标准时长</TotalTimes>	
//		<UsdedTimes>使用时长<UsdedTimes/>	
//		<ResourceId>资源编号<ResourceId/>			
//		</Channel>	
		
		String publish_date = DateUtil.SetDateFormat(publishDate,"yyyy-MM-dd");

	    System.out.println(">>>   "+ls.size());
	    
	    
		for(Iterator it = ls.iterator();it.hasNext();){
		    sb.append("<Channel id=\""+ carrierId+"\"  BroadDate=\""+ publish_date+"\" >");
		    sb.append(newline);
		    
			PublishArrangeDetail arrangeDetail = (PublishArrangeDetail) it.next();
			String adName = arrangeDetail.getMatterName();
			String soundName = arrangeDetail.getMatterEdit();
			String fileLength = arrangeDetail.getMatterName();
			String path = arrangeDetail.getTapeCode();
			String orderId = StringUtil.getNullValue(arrangeDetail.getOrderId(),"");
			String broadTime = StringUtil.getNullValue(arrangeDetail.getResourceName(),"");
			String resourceId = StringUtil.getNullValue(arrangeDetail.getResourceId(),"0");
			String broadOrder = StringUtil.getNullValue(arrangeDetail.getPublishSort(),"");
			String className = StringUtil.getNullValue(arrangeDetail.getSpecificName(),"");
			String total = StringUtil.getNullValue(arrangeDetail.getTotal(),"0");
			String usded = StringUtil.getNullValue(arrangeDetail.getUsedTime(),"0");

			
			
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
			
			sb.append("</Channel>");
			sb.append(newline);
		}

		sb.append("</Import>");
		
		return sb.toString();
	}
	
	

}
