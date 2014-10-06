package com.vriche.adrm.util;

import java.util.List;

import com.vriche.adrm.model.DayInfo;

public class DayInfoUtil {

	public static void getDayInfosFree(DayInfo dayInfo,List ls){
		String beginDate = dayInfo.getStartDate().toString();
		String endDate= dayInfo.getEndDate().toString();
//		List lsDates = DateUtil.getDatesByStartEndDate(beginDate, endDate);
		
		int start = dayInfo.getStartDate().intValue();
		int end = dayInfo.getEndDate().intValue();

    
		for(int i = start;i<end+1;i++){
			DayInfo dayInfo2 = new DayInfo();
			dayInfo2.setModifyTime("0");
			dayInfo2.setCarrierId("0");
			dayInfo2.setId(new Long(0));
			dayInfo2.setPropertiyTime(new Integer(0));
			dayInfo2.setPublishDate(new Integer(i));
			dayInfo2.setResourceId(new Long(0));
			dayInfo2.setResourceType(new Integer(0));
			dayInfo2.setSpecific("");
			dayInfo2.setTotal("100000");
			dayInfo2.setUsed("0");
			dayInfo2.setWorkspanId(new Long(0));
			dayInfo2.setVersion(new Integer(0));
			ls.add(dayInfo2);
		}
	}
	
	
}
