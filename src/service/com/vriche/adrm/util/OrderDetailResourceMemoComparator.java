package com.vriche.adrm.util;


import java.util.Comparator;

import com.vriche.adrm.model.OrderDetail;

public class OrderDetailResourceMemoComparator implements Comparator {

	public int compare(Object a, Object b) {
		OrderDetail left = (OrderDetail) a;
		OrderDetail right = (OrderDetail) b;
		String l = left.getResource().getMemo();
		String r = right.getResource().getMemo();

		return l.compareTo(r);
	}
}
