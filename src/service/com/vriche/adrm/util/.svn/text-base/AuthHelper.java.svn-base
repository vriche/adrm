/****************************************************************************     
 * Created on 2007-5-13                                      *    
 *                                                               			*
 * @author <a href="mailto:hongxilin@yahoo.com.cn">hongxi</a>               *
 *         Updated by hongxi (hongxilin@yahoo.com.cn)                       *
 *                                                                          *
 * @version  Vision:1.0														*
 * 																			*
 ***************************************************************************/
package com.vriche.adrm.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class AuthHelper {
	  
	public final static String AUTHORIZED = "authorized";
	
	public final static Map  authMap = new HashMap();
	
	static{
		authMap.put("true", "Authorized");
		authMap.put("false", "Unauthorized");
	}

	/**
	 * 新增或删除多对多关系
	 */
	public static void saveAuth(Collection authSet, Object authObj,boolean isAuthorized) {
		if (isAuthorized) {
			if (authSet.contains(authObj)) {
				authSet.remove(authObj);
			}
		} else {
			if (!authSet.contains(authObj)) {
				authSet.add(authObj);
			}
		}
	}
	
	public static void judgeAuthorized(Collection auths, Collection autheds)  {
		Iterator iter = auths.iterator();
		try {
			while (iter.hasNext()) {
				Object resource = iter.next();

				if (autheds.contains(resource)) {
					BeanUtils.setProperty(resource, "authorized", Boolean.TRUE);
				} else {
					BeanUtils.setProperty(resource, "authorized", Boolean.FALSE);
				}
			}
		} catch (Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}
}
