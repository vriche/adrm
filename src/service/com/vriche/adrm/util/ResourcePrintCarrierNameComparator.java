/****************************************************************************     
 * Created on 2007-12-7                                      *    
 *                                                               			*
 * @author <a href="mailto:hongxilin@yahoo.com.cn">hongxi</a>               *
 *         Updated by hongxi (hongxilin@yahoo.com.cn)                       *
 *                                                                          *
 * @version  Vision:1.0														*
 * 																			*
 ***************************************************************************/
package com.vriche.adrm.util;

import java.util.Comparator;

import com.vriche.adrm.model.ResourcePrint;

public class ResourcePrintCarrierNameComparator implements Comparator {

	public int compare(Object a, Object b) {
		ResourcePrint left = (ResourcePrint) a;
		ResourcePrint right = (ResourcePrint) b;
		if (a == null || b == null) {
		      System.out.println("Error: left, right = " + left + "," + right);
		      return 0;
		    }
		
		if (left.getCarrierName() == null || right.getCarrierName() == null) {
	    	System.out.println("Error: left.adv, right.adv = " +
	                    left.getCarrierName() + "," +
	                    right.getCarrierName());
	      return 0;
	    }
		 String left_T = left.getCarrierName();
		 String right_T = right.getCarrierName();
//		 Integer left_T = l == null? new Integer(0):l;
//		 Integer right_T = r == null? new Integer(0):r;
//		 int res = isDesc?right_T.compareTo(left_T):left_T.compareTo(right_T);
		 
		 return right_T.compareTo(left_T);
	}


}
