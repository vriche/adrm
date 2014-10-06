package com.vriche.adrm.util;

import java.util.Collections;
import java.util.Comparator;

import com.vriche.adrm.model.Carrier;

public class CarrierParentIdComparator implements Comparator {

	public int compare(Object a, Object b) {
		Carrier left = (Carrier) a;
		Carrier right = (Carrier) b;
		
		Long left_T = new Long(left.getParentId());
		Long right_T = new Long(right.getParentId());
        
		
//		return right_T.compareTo(left_T);
		return left_T.compareTo(right_T);
		
	}

}
