package com.vriche.adrm.util;

import java.util.Collections;
import java.util.Comparator;

import com.vriche.adrm.model.Carrier;

public class CarrierComparator implements Comparator {

	public int compare(Object a, Object b) {
		Carrier left = (Carrier) a;
		Carrier right = (Carrier) b;
		
		Long left_T = left.getChannelId();
		Long right_T = right.getChannelId();

//		return right_T.compareTo(left_T);
		return left_T.compareTo(right_T);
		
	}

}
