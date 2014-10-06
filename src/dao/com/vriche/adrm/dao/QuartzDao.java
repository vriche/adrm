package com.vriche.adrm.dao;

import java.util.List;

public interface QuartzDao  {

	public List getQrtzTriggers();
    public List  getInstalledJobs(String app_path);
    public void installJob(String jobName, String groupName, String app_path);
    public void unInstallJob(String jobName, String groupName);
    public void updateConExpress(String name,String conExPress);
    
	
}
