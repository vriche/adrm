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

import com.vriche.adrm.model.PublishArrange;

public class PublishArrangeEntryComparator implements Comparator {

	public int compare(Object a, Object b) {
		PublishArrange left = (PublishArrange) a;
		PublishArrange right = (PublishArrange) b;

//		 Integer l= left.getArrangeType();
//		 Integer r = right.getArrangeType();
		 Integer l= left.getBroadcastStartTime();
		 Integer r = right.getBroadcastStartTime();
		 
//		  System.out.println("broPoint left>>>>>>>>>>>>>"+ left.getResourceMeno()+">>>>>>>>>>>>>>>>>>>>>"+ left.getBroadcastStartTime());
//		  System.out.println("broPoint right>>>>>>>>>>>>>"+ right.getResourceMeno()+">>>>>>>>>>>>>>>>>>>>>"+ r);
		 
		 Integer left_T = l == null? new Integer(0):l;
		 Integer right_T = r == null? new Integer(0):r;

		 return left_T.intValue() - right_T.intValue();
	}


}
