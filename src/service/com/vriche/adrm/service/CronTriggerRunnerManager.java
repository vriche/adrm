package com.vriche.adrm.service;

	/**
	 */
	public interface CronTriggerRunnerManager {
		public void setParameter(String startup,String ldap,String casLogoutUrl,String casLoginUrl,String casServiceUrl,String casServerName,String casValidateUrl);
		
		public String[] getParameter();
}
