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

import com.vriche.adrm.model.FinanceTarget;
import com.vriche.adrm.model.Resource;

public class FinanceTargetComparator implements Comparator {

	public int compare(Object a, Object b) {

		FinanceTarget left = (FinanceTarget) a;
		FinanceTarget right = (FinanceTarget) b;

		 Long l = left.getCarrier().getChannelId();
		 Long r = right.getCarrier().getChannelId();
		 
		 Long left_T = l == null? new Long(0):l;
		 Long right_T = r == null? new Long(0):r;

		 return left_T.intValue()-right_T.intValue();
	}

}
