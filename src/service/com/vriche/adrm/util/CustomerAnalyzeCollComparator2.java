package com.vriche.adrm.util;

import java.util.Comparator;

import com.vriche.adrm.model.CustomerAnalyzeColl;

public class CustomerAnalyzeCollComparator2 implements Comparator {

	public int compare(Object a, Object b) {
		CustomerAnalyzeColl left = (CustomerAnalyzeColl) a;
		CustomerAnalyzeColl right = (CustomerAnalyzeColl) b;
		String sor = left.getSortStr();
		sor = sor == null ? "0,ASC" : sor;
		String[] sorStr = left.getSortStr().split(",");

		int colIndex = Integer.parseInt(sorStr[0].toString());
		int sortType = sorStr[1].toString().equals("ASC") ? 0 : 1; //ASC DESC

		if (colIndex == 1 || colIndex == 2 || colIndex == 3 || colIndex == 4
				|| colIndex == 5 || colIndex == 6 || colIndex == 7
				|| colIndex == 8 || colIndex == 9 || colIndex == 10
				|| colIndex == 11 || colIndex == 12 || colIndex == 13) {
			double left_1 = Double.parseDouble((String)left.getMonth().get(colIndex));
			double right_1 = Double.parseDouble((String)right.getMonth().get(colIndex));
			int res1 = 0;

			if (sortType == 1) {
				res1 = left_1 < right_1 ? 1 : 0;
			} else {
				res1 = left_1 > right_1 ? 1 : 0;
			}
			return res1;
		} else {

			String left_0 = left.getCustomerName();
			String right_0 = right.getCustomerName();

			if (sortType == 1) {
				return right_0.compareTo(left_0);
			} else {
				return left_0.compareTo(right_0);
			}

		}

	}

}
