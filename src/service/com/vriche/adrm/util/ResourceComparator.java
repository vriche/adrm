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

import com.vriche.adrm.model.Resource;

public class ResourceComparator implements Comparator {

	public int compare(Object a, Object b) {

		Resource left = (Resource) a;
		Resource right = (Resource) b;

		 Integer l= left.getDisplayNo();
		 Integer r = right.getDisplayNo();
		 Integer left_T = l == null? new Integer(0):l;
		 Integer right_T = r == null? new Integer(0):r;

		 return left_T.intValue() - right_T.intValue();
	}

}
