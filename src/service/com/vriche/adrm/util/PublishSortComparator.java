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

import com.vriche.adrm.model.PublishArrangeDetail;
import com.vriche.adrm.model.Resource;

public class PublishSortComparator implements Comparator {

	public int compare(Object a, Object b) {

		PublishArrangeDetail left = (PublishArrangeDetail) a;
		PublishArrangeDetail right = (PublishArrangeDetail) b;

		 String l= ""+left.getPublishSort();
		 String r = ""+right.getPublishSort();
		   
		 return l.compareTo(r);
	}
}
