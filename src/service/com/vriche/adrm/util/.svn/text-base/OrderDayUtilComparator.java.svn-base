package com.vriche.adrm.util;

import java.util.Comparator;

import com.vriche.adrm.model.OrderDayInfo;

public class OrderDayUtilComparator implements Comparator {

	public int compare(Object a, Object b) {
		OrderDayInfo left = (OrderDayInfo) a;
		OrderDayInfo right = (OrderDayInfo) b;
		
		 int lt= left.getAdDayTimes().intValue();
		 int lb= left.getDayStandardPrice().intValue();
		 int l = lt*lb;
		
		 int rt= right.getAdDayTimes().intValue();
		 int rb= right.getDayStandardPrice().intValue();
		 int r = rt*rb;
		 return (r - l); 
	}

}
