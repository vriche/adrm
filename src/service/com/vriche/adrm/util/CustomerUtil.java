package com.vriche.adrm.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerUtil {
	
	public static List getCustomerIdsByOrg(String loginUser,String orgId){
		Map mp = new HashMap();
    	List lsCutCates = UserUtil.getAllUserCustomerCates(loginUser, null);
    	if(lsCutCates.size()>0)mp.put("customerCates",lsCutCates);
		mp.put("orgId",orgId);
		return ServiceLocator.getCustomerDao().getCustidsByOrg(mp);
	}
}
