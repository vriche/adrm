package com.vriche.adrm.util;
import java.util.Comparator;

import com.vriche.adrm.model.PublishArrangeDetail;


public class PublishDateComparator implements Comparator {

	public int compare(Object a, Object b) {
		PublishArrangeDetail left = (PublishArrangeDetail) a;
		PublishArrangeDetail right = (PublishArrangeDetail) b;
		
		Integer left_T = left.getPublishDate();
		Integer right_T = right.getPublishDate();

		return left_T.compareTo(right_T);
		
	}                 

}