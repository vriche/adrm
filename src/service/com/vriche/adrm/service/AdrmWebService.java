package com.vriche.adrm.service;



public interface AdrmWebService {
	
	public String getCarrierInfo(String orgId);
	
	public String getResourceInfo(String inPublishDate);
	
	public String getIndustrys();
	 
	public String getArrangedPublish(String carrierId,String publishDate);
	
//	public String saveProgramListLockInfo(String iteId,String lockStatus);
	
//	public void saveMattersAllInDayang2zero();
	
	
	public String getVersion();
	
	
}
