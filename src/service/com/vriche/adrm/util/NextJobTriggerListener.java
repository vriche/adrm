package com.vriche.adrm.util;

import org.apache.log4j.Logger;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.listeners.TriggerListenerSupport;
//import org.springframework.scheduling.quartz.SimpleTriggerBean;
import org.springframework.scheduling.quartz.CronTriggerBean;

public class NextJobTriggerListener extends TriggerListenerSupport {

	 	private  Logger logger = Logger.getLogger(getClass());
	    private CronTriggerBean nextTrigger;	 
	    private String name;
	    
	    public String getName() {
	        return this.name;
	    }
	    public void setName(String name)
	    {
	        this.name=name;
	    }

	    public void setNextTrigger(CronTriggerBean nextTrigger) {
	    	
	    	
	    	 logger.info("isDurable>>>>>>>>>>>>>>>>>>>>>>>>>>"+ nextTrigger.getJobDetail().isDurable());
	    	 logger.info("isStateful>>>>>>>>>>>>>>>>>>>>>>>>>>"+ nextTrigger.getJobDetail().isStateful());
	    	 logger.info("isVolatile>>>>>>>>>>>>>>>>>>>>>>>>>>"+ nextTrigger.getJobDetail().isVolatile());
	    	
	        this.nextTrigger = nextTrigger;
	    }
	 
	    public void triggerComplete(Trigger trigger, JobExecutionContext context, int code) {
	        try{
	        Scheduler schduler=context.getScheduler();
	        JobDetail nextJob=nextTrigger.getJobDetail();
	        //�������ƺͼ������������һ��������
	        JobDetail oldJob=schduler.getJobDetail(nextJob.getName(),nextJob.getGroup());
	        //�������ƺͼ�������Ĵ�����һ���Ĵ�����
	        Trigger oldTrigger=schduler.getTrigger( nextTrigger.getName(),nextTrigger.getGroup());
	        
	        if(oldJob==null&&oldTrigger==null)//ͬ��������ʹ�������������
	        {
	            logger.debug("inside scheduleJob."+code);
	            schduler.scheduleJob(nextJob,nextTrigger);
	        }else//ͬ��������򴥷���
	        {
	            
	            logger.debug("oldJob==null:"+(oldJob==null));
	            logger.debug("oldTrigger==null:"+(oldTrigger==null));    
	        }
	        super.triggerComplete(trigger, context, code);
	        }catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	    }
}
