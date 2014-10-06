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

import com.vriche.adrm.model.CustomerProduct;

public class CustomerProductComparator implements Comparator {

	public int compare(Object a, Object b) {
 
		CustomerProduct left = (CustomerProduct) a;
		CustomerProduct right = (CustomerProduct) b;
		
		 String orderBy = left.getOrderBy();
		 
//		 System.out.println("orderBy>>>>>>xxxxxxxxxxxxxxxxxxxxxxxxxxx>>  " +orderBy);
		 
		 if("0".equals(orderBy)){
			 Integer l= left.getDisplayNo();
			 Integer r = right.getDisplayNo();
			 Integer left_T = l == null? new Integer(0):l;
			 Integer right_T = r == null? new Integer(0):r;
			 return left_T.intValue() - right_T.intValue();
			 
		 }else if("1".equals(orderBy)){
			 String l= left.getResourceMeno();
			 String r = right.getResourceMeno();
			 return l.compareTo(r);
			 
		 }else 	if("2".equals(orderBy)){
			 Integer l= left.getBroadcastStartTime();
			 Integer r = right.getBroadcastStartTime();
			 Integer left_T = l == null? new Integer(0):l;
			 Integer right_T = r == null? new Integer(0):r;
			 
			 int rs =  left_T.intValue() - right_T.intValue() ;
			 
//			 System.out.println("666666666>>>>>>xxxxxxxxxxxxxxxxxxxxxxxxxxx>>  " +rs);
				 
			 return  rs;
		 }else{
			 return 1;
		 }
		 

		 



	}

}
