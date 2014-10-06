package com.vriche.adrm.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.quartz.Trigger;

import com.vriche.adrm.service.JobManager;
import com.vriche.adrm.service.SchedulerManager;
import com.vriche.adrm.util.JsonUtil;

public class JobManagerImpl implements JobManager {
	
    private SchedulerManager schedulerManager;
    
    public SchedulerManager getSchedulerManager() {
        return schedulerManager;
    }

	public String getQrtzTriggers(Map paraMap) {
//		 List<Trigger>
	      List results = this.schedulerManager.getQrtzTriggers();
	      Iterator it = results.iterator();
	      
	      
	      String josn = JsonUtil.encodeBasic(results);
	      
	      while(it.hasNext()){
	    	  Trigger trigger = (Trigger)it.next();
	      }
	      
	      
	      
	      return josn;

	}

}
