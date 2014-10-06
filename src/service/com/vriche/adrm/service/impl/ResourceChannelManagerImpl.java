
package com.vriche.adrm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.ResourceChannelDao;
import com.vriche.adrm.model.ResourceChannel;
import com.vriche.adrm.model.ResourceChannelConfig;
import com.vriche.adrm.service.ResourceChannelManager;
import com.vriche.adrm.util.RequestUtil;
import com.vriche.adrm.util.StringUtil;

public class ResourceChannelManagerImpl extends BaseManager implements ResourceChannelManager {
    private ResourceChannelDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setResourceChannelDao(ResourceChannelDao dao) {
        this.dao = dao;
    }

    /**
     * @see com.vriche.adrm.adres.service.ResourceChannelManager#getResourceChannelsByIdList(final Map idList)
     */
    public List getResourceChannelsByIdList(final Map idList) {
        return dao.getResourceChannelsByIdList(idList);
    }
    

    
   /**
     * @see com.vriche.adrm.adres.service.ResourceChannelManager#getResourceChannels(com.vriche.adrm.adres.model.ResourceChannel)
     */
    public List getResourceChannels(final ResourceChannel resourceChannel) {
    	
    	if("1".equals(StringUtil.getNullValue(resourceChannel.getEnable(),"0"))){
    		resourceChannel.setEnable(new Integer(1));
    	}else{
    	    	resourceChannel.setEnable(null);
    	    }
    
    	List ls = dao.getResourceChannels(resourceChannel);
//    	for(Iterator it = ls.iterator();it.hasNext();){
//    		 ResourceChannel channel =(ResourceChannel)it.next();
//    		 String value= channel.getValue();
//    		 value = (value ==null || "".equals(value)) ?"0":value;
//    		 System.out.println("value1>>>>>>>>>>>>>>>>>>>>>>"+value);
//    		 value =DateUtil.formatTime(Long.parseLong(value)*1000,"hh:mm:ss");
//    		 System.out.println("value2>>>>>>>>>>>>>>>>>>>>>>"+value);
//    		 channel.setValue(value);
//    	}
    	
        return ls;
    }

    /**
     * @see com.vriche.adrm.adres.service.ResourceChannelManager#getResourceChannel(String id)
     */
    public ResourceChannel getResourceChannel(final String id) {
    	ResourceChannel resourceChannel = dao.getResourceChannel(new Long(id));
//    	String value = resourceChannel.getValue();
//    	 value = (value ==null|| "".equals(value)) ?"0":value;
//   	    value = DateUtil.formatTime(Long.parseLong(value)*1000,"hh:mm:ss");
//   	    resourceChannel.setValue(value);
    	
    	
    	   ArrayList list = new ArrayList();
    	   for(int i = 0;i<25;i++){
    		    String v = i<10?"0"+i:String.valueOf(i);
    		    list.add(new org.apache.struts.util.LabelValueBean(v,v));
    	   }
    	   resourceChannel.setHourList(list);   
    	   
    	   list = new ArrayList();
    	   for(int i = 0;i<61;i++){
   		    String v = i<10?"0"+i:String.valueOf(i);
   		    list.add(new org.apache.struts.util.LabelValueBean(v,v));
    	   }
    	   resourceChannel.setMinList(list);   

        return resourceChannel;
    }

    /**
     * @see com.vriche.adrm.adres.service.ResourceChannelManager#saveResourceChannel(ResourceChannel resourceChannel)
     */
    public void saveResourceChannel(ResourceChannel resourceChannel) {
    	String value = resourceChannel.getValue();
//    	System.out.println("value1>>>>>>>>>>>>>>>>>>>>>>"+value);
//    	System.out.println("value1>>>>>>>>>>>>>>>>>>>>>>"+resourceChannel.getBroTimeHour());

//    	 value = (value ==null|| "".equals(value)) ?"0":value;
//    	Date date = new Date("1999-01-01 " +value);
//    	
//        SimpleDateFormat sdf2  = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        System.out.println(sdf2.format(date));
//        
//        Calendar calendar = new GregorianCalendar();
////        calendar.setTime(trialTime1);
//        calendar.set(Calendar.HOUR_OF_DAY,)
        
//    	formatter = new SimpleDateFormat("HH.mm.ss");
//    	s = formatter.format(date);
//    	Locale locale = Locale.ITALIAN;
//    	Date date = new Date();
////    	 Parse
//    	try {
//    	    date = DateFormat.getTimeInstance(DateFormat.DEFAULT, locale).parse("00.00.01");
//    	    System.out.println("date>>>>>>>>>>>>>>>>>>>>>>"+(date.getTime()+28800000));
//    	} catch (ParseException e) {
//    	}

    	
//    	 SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
//    	 try {
//    		value = resourceChannel.getBroTimeHour()+":"+resourceChannel.getBroTimeMin()+":"+resourceChannel.getBroTimeSec();
//    		System.out.println("value2>>>>>>>>>>>>>>>>>>>>>>"+value);
//    		
//			long millionSeconds = sdf.parse(value).getTime()+28800000;
//		    String sec = String.valueOf(millionSeconds/1000);
////		    System.out.println("value2>>>>>>>>>>>>>>>>>>>>>>"+sec);
//		    resourceChannel.setValue(sec);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}//ºÁÃë

//        System.out.println("value2>>>>>>>>>>>>>>>>>>>>>>"+ca.getTimeInMillis()/1000);
//    	07:01:00
    	
    	
        dao.saveResourceChannel(resourceChannel);
    }

    /**
     * @see com.vriche.adrm.adres.service.ResourceChannelManager#removeResourceChannel(String id)
     */
    public void removeResourceChannel(final String id) {
        dao.removeResourceChannel(new Long(id));
    }

     /**
     * @see com.vriche.adrm.adres.service.ResourceChannelManager#removeResourceChannels(String Map)
     */
    public void removeResourceChannels(final Map idList) {
        dao.removeResourceChannels(idList);
    }    
    
    public Map getResourceChannelsSelectItem(ResourceChannel resourceChannel){
		Map reply = new LinkedHashMap();
    	List channels = this.getResourceChannels(resourceChannel);
    	Iterator ite= channels.iterator();
		while(ite.hasNext()){
			
			ResourceChannel channel =(ResourceChannel)ite.next();

			reply.put(channel.getId(),channel.getName());

		}
		return reply;
    }

    public List getResourceChannelConfigs(String channelId) {
	   	 Map mp = new HashMap();
		 mp.put("channelId",channelId);
//		 mp.put("sendType",sendType);
	     return dao.getResourceChannelConfigs(mp);
    }
    
    public String getResourceChannelConfigsGridXML(String channelId){
    	List ls = this.getResourceChannelConfigs(channelId);
    	StringBuffer sb = new StringBuffer("");
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");   
		for (Iterator it = ls.iterator();it.hasNext();){
			ResourceChannelConfig config  = (ResourceChannelConfig) it.next();
			String key = config.getId().toString();
			String delImg = RequestUtil.getReqInfo().getCtxPath()+"/image/button_delete.gif^É¾³ý^javascript:_remove_work_span();^_self";
			sb.append("<row  id=\""+ key +"\">");  
			sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
			sb.append("<cell><![CDATA["+ config.getEnable()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ config.getPreOne()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ config.getSendType()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ config.getSendAddress()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ config.getResourceSort()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ config.getSendZeo()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ delImg  +"]]></cell>");
			sb.append("</row>");
		}
		sb.append("</rows>");
		
		return sb.toString();
    	
    }
    
    
    public void removeResourceChannelConf(String id) {
	   	 Map mp = new HashMap();
		 mp.put("id",id);
		 dao.removeResourceChannelConfig(mp);
    }
    
	public void saveChannelConfig(String channelId,ResourceChannelConfig[] channelConfigs) {
		
		 Map mp = new HashMap();
		 mp.put("channelId",channelId);
		 dao.removeResourceChannelConfig(mp);
		 
		for(int i = 0;i<channelConfigs.length;i++)
			 dao.saveChannelConfig(channelConfigs[i]);
		}
 
}
