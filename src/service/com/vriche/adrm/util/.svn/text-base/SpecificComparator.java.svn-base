/****************************************************************************     
 * Created on 2007-11-9                                      *    
 *                                                               			*
 * @author <a href="mailto:hongxilin@yahoo.com.cn">hongxi</a>               *
 *         Updated by hongxi (hongxilin@yahoo.com.cn)                       *
 *                                                                          *
 * @version  Vision:1.0														*
 * 																			*
 ***************************************************************************/
package com.vriche.adrm.util;

import java.util.Comparator;

import com.vriche.adrm.model.PublishArrangeDetail;

public class SpecificComparator implements Comparator {

	public int compare(Object a, Object b) {
		boolean isDesc = false;
		
		PublishArrangeDetail left = (PublishArrangeDetail) a;
		PublishArrangeDetail right = (PublishArrangeDetail) b;
	    //数值为null,提示错误的信息
	    if (a == null || b == null) {
//	      System.out.println("Error: left, right = " + left + "," + right);
	      return 0;
	    }
	    
	    //
	    if (left.getSpecificValue() == null || right.getSpecificValue() == null) {
//	    	System.out.println("Error: left.adv, right.adv = " +
//	                    left.getSpecificValue() + "," +
//	                    right.getSpecificValue());
	      return 0;
	    }
	    
//	    System.out.println("info: left.adv, right.adv = " +
//                left.getSpecificValue() + "," +
//                right.getSpecificValue());
	    
		 String left_T = left.getSpecificValue();
		 String right_T = right.getSpecificValue();


		 if("ABCDEFGHI".indexOf(left_T) > -1 && "ABCDEFGHI".indexOf(right_T)>-1) isDesc = true;

		 int res = isDesc?right_T.compareTo(left_T):left_T.compareTo(right_T);
		 
		 return res;
		
	}

}
