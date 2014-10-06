package com.vriche.adrm.util;

import java.util.Comparator;

import com.vriche.adrm.model.ContractPayment;

public class ContractPayMentComparator implements Comparator {
	public int compare(Object a, Object b) {
		ContractPayment left = (ContractPayment) a;
		ContractPayment right = (ContractPayment) b;
		
		String left_T = left.getPayNumber().toString();
		String right_T = right.getPayNumber().toString();
		
		int res = left_T.compareTo(right_T);
		 
		 return res;
		
	}

}
