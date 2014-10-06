package com.vriche.adrm.util;


import java.util.Comparator;

import com.vriche.adrm.model.OrderDetail;

public class OrderDetailAdNameComparator implements Comparator {

	public int compare(Object a, Object b) {
		OrderDetail left = (OrderDetail) a;
		OrderDetail right = (OrderDetail) b;
		String l = left.getMatter().getName();
		String r = right.getMatter().getName();

		return l.compareTo(r);
	}
}
