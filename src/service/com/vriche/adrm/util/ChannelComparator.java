package com.vriche.adrm.util;

import java.util.Comparator;

import com.vriche.adrm.model.FinanceTarget;

public class ChannelComparator implements Comparator {
	public int compare(Object a, Object b) {

		String left_T =(String) a;
		String right_T = (String) b;
		
//		System.out.println("left_T<<<<<<<1111111111111<<<<<<<<<<"+ left_T);
//		System.out.println("right_T<<<<<<<1111111111111<<<<<<<<<<"+ right_T);
		 return  left_T.compareTo(right_T);
	}
}
