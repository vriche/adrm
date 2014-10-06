package com.vriche.adrm.util;

import java.util.Comparator;

import com.vriche.adrm.model.FusionChartObject;



public class FusionChartObjectComparator implements Comparator {
	public int compare(Object a, Object b) {

		FusionChartObject left_T =(FusionChartObject) a;
		FusionChartObject right_T = (FusionChartObject) b;
		
		Long left = (new Long(left_T.getSequence()));
		Long right =  (new Long(right_T.getSequence()));
		
//		System.out.println("left_T<<<<<<<1111111111111<<<<<<<<<<"+ left.compareTo(right));
//		System.out.println("right_T<<<<<<<1111111111111<<<<<<<<<<"+ right_T);
		
		 return  left.compareTo(right);
	}
}
