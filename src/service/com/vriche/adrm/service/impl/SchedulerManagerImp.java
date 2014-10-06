package com.vriche.adrm.service.impl;



import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.quartz.CronExpression;
import org.quartz.CronTrigger;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerUtils;
import org.quartz.impl.StdSchedulerFactory;

import com.vriche.adrm.Constants;
import com.vriche.adrm.dao.QuartzDao;
import com.vriche.adrm.model.ListRange;
import com.vriche.adrm.model.TriggerVO;
import com.vriche.adrm.service.SchedulerManager;
import com.vriche.adrm.util.HandlePropertiesUtil;
import com.vriche.adrm.util.StringUtil;

/**
 * Created by IntelliJ IDEA.
 * User: SongJiao
 * Date: 2009-12-23
 * Time: 22:18:35
 * To change this template use File | Settings | File Templates.
 */
public class SchedulerManagerImp implements SchedulerManager {
	
    private static final Logger logger = Logger.getLogger(SchedulerManagerImp.class);
    
    
    private Scheduler scheduler;
    
    private JobDetail jobDetail;

    private QuartzDao quartzDao;
    
    

    public QuartzDao getQuartzDao() {
        return quartzDao;
    }

    public void setQuartzDao(QuartzDao quartzDao) {
        this.quartzDao = quartzDao;
    }




    public Scheduler getScheduler() {
        return scheduler;
    }

    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

	public void setJobDetail(JobDetail jobDetail) {
		this.jobDetail = jobDetail;
	}



    
    public void schedule(String cronExpression, JobDetail jobDetail) {
        schedule("", cronExpression, jobDetail);
    }

    
    public void schedule(String name, String cronExpression, JobDetail jobDetail) {
        schedule(name, cronExpression, Scheduler.DEFAULT_GROUP, jobDetail);
    }

    
    public void schedule(String name, String cronExpression, String group, JobDetail jobDetail) {
        try {
            schedule(name, new CronExpression(cronExpression), group, jobDetail);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    
    public void schedule(CronExpression cronExpression, JobDetail jobDetail) {
        schedule(null, cronExpression, jobDetail);
    }

    
    public void schedule(String name, CronExpression cronExpression, JobDetail jobDetail) {
        schedule(name, cronExpression, Scheduler.DEFAULT_GROUP, jobDetail);
    }

    
    public void schedule(String name, CronExpression cronExpression, String group, JobDetail jobDetail) {
    	
        try {
            scheduler.addJob(jobDetail, true);
            CronTrigger cronTrigger = new CronTrigger(name, group, jobDetail.getName(),Scheduler.DEFAULT_GROUP);
            cronTrigger.setCronExpression(cronExpression);
            scheduler.scheduleJob(cronTrigger);
            scheduler.rescheduleJob(cronTrigger.getName(), cronTrigger.getGroup(), cronTrigger);

        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }

    public void schedule(JobDetail jobDetail, CronTrigger cronTrigger) {
        try {
            scheduler.addJob(jobDetail, true);
            scheduler.scheduleJob(cronTrigger);
            scheduler.rescheduleJob(cronTrigger.getName(), cronTrigger.getGroup(), cronTrigger);
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }

//    return  List<JobDetail>
    public List getAllJobDetails() {
        List jobDetails = new ArrayList();
        try {


            String[] groupNames = scheduler.getJobGroupNames();

            for (int i = 0 ; i<groupNames.length;i++) {
           	 String[] jobNames = scheduler.getJobNames(groupNames[i]);
           	 for (int j = 0;j<jobNames.length;j++) {
           		jobDetails.add(scheduler.getJobDetail(jobNames[j], groupNames[i]));
           	 }
           }         
            

        } catch (SchedulerException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return jobDetails;
    }


    /**
     * @param jobName
     * @param groupName
     * @return
     * @throws SchedulerException
     */
    
    public Trigger[] getTrigersOfJob(String jobName, String groupName) throws SchedulerException {
        return scheduler.getTriggersOfJob(jobName, groupName);
    }

    /**
     * 删除Job
     *
     * @param jobName
     * @param jobGroup
     */
    
    public void deleteJobDetail(String jobName, String jobGroup) {
        try {
            scheduler.deleteJob(jobName, jobGroup);
            quartzDao.unInstallJob(jobName, jobGroup);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据jobDetail的名字查找该jobDetail有哪些Trigger在调用
     *
     * @param jobName
     * @param groupName
     * @return List<TriggerVO>
     */
    
    public List getTriggersByJobName(String jobName, String groupName) {

        List triggers = new ArrayList();
        try {
            Trigger[] trgs = scheduler.getTriggersOfJob(jobName, groupName);
            for (int i = 0;i< trgs.length;i++) {
                TriggerVO vo = new TriggerVO();
                vo.setTriggerGroup(trgs[i].getGroup());
                vo.setDescription(trgs[i].getDescription());
               
                vo.setJobGroup(trgs[i].getJobGroup());
//                vo.setJobData(trgs[i].getJobDataMap());
                vo.setJobName(trgs[i].getJobName());
                vo.setName(trgs[i].getName());
                vo.setNextFireTime(trgs[i].getNextFireTime());
                vo.setPrevFireTime(trgs[i].getPreviousFireTime());
                vo.setStartTime(trgs[i].getStartTime());
                vo.setEndTime(trgs[i].getEndTime());
                vo.setPriority(trgs[i].getPriority());
                vo.setMisfireInstruction(trgs[i].getMisfireInstruction());
                vo.setState(this.getTriggerState(trgs[i].getName(), trgs[i].getGroup()));
                vo.setLinkedTriggerListeners(trgs[i].getTriggerListenerNames());
                
//                trgs[i].get
    
                
                
                triggers.add(vo);
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return triggers;
    }
    
	private Properties   getDBBackupProperties(){
    	return HandlePropertiesUtil.loadFromClass("databaseBackup.properties");
    	
    
	}   
	
    private String getJobPror(String triggerName){
    	Properties ps = getDBBackupProperties();
    	
    	String v ="";
    	
    
    	  

// 	 	params.serviceType= v[0],
// 	 	params.db_database=v[0];
// 	 	params.db_path = v[0];
// 	 	params.targ_path=v[0];
// 	 	
// 	 	params.db_host=v[0];
// 	 	params.db_user=v[0];
// 	 	params.db_pass=v[0];
//
// 	 	params.targ_hostname=v[0];
// 	 	params.targ_username=v[0];
// 	 	params.targ_password=v[0];
//
// 	 	params.existDate=v[0];
 	 	
    	String split = "|";
    	
    	if("triggerSQLDump".equals(triggerName)){
	        String hostname=ps.getProperty("db_host");
	        String database=ps.getProperty("db_database");
//	        String dbpath=ps.getProperty("db_path");
	        String username=ps.getProperty("db_user");
	        String password=ps.getProperty("db_pass");
	        v = hostname +split+database+split+username+split+password;

    	}
    	if("triggerTransfersdb".equals(triggerName)){
    		String serviceType=ps.getProperty("serviceType");   
    	    String hostname=ps.getProperty("targ_hostname");
            String targpath=ps.getProperty("targ_path");  
    	    String username=ps.getProperty("targ_username");
    	    String password=ps.getProperty("targ_password");
            String existDate=ps.getProperty("existDate");  
            v = serviceType +split+ hostname +split+targpath+split+username+split+password+split+existDate;
    	}
    	
    	
//    	  System.out.println("getJobPror>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+triggerName+">>>>>>>>>>>>>" +v);
    	  return v;  

    }

    /**
     * 根据jobName和groupName查找JobDetail
     *
     * @param jobName
     * @param groupName
     * @return
     */
    
    public JobDetail getJobDetailByNameAndGroup(String jobName, String groupName) {
        JobDetail jobDetail = null;
        try {
            jobDetail = scheduler.getJobDetail(jobName, groupName);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return jobDetail;
    }

    /**
     * 给Job添加CronTrigger
     *
     * @param cronTrigger
     */
    
    public void schedule(CronTrigger cronTrigger) {
        try {
            scheduler.scheduleJob(cronTrigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据triggerName 和groupName 判断Trigger的状态
     *
     * @param triggerName
     * @param groupName
     * @return
     */
    
    

    public String getTriggerState(String triggerName, String groupName) {
        String rs = "UNKNOWN";
        try {
            int state = scheduler.getTriggerState(triggerName, groupName);
            

            switch (state) {
                case Trigger.STATE_BLOCKED:
                    rs = "运行中";
                    break;
                case Trigger.STATE_COMPLETE:
                    rs = "完成";
                    break;
                case Trigger.STATE_ERROR:
                    rs = "出错";
                    break;
                case Trigger.STATE_NONE:
                    rs = "未知";
                    break;
                case Trigger.STATE_NORMAL:
                    rs = "正常";
                    break;
                case Trigger.STATE_PAUSED:
                    rs = "暂停";
                    break;
                default:
                    break;

            }

        } catch (SchedulerException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


        return rs;
    }
    
    


    

    /**
     * 根据安装目录查找jobDetail
     *
     * @param app_path
     * @return List<JobDetail>
     */
    
    public List getInstalledJobDetails(String app_path) {
        List jobDetails = new ArrayList();
//        List<Map<String, String>>
        List installedJobs = quartzDao.getInstalledJobs(app_path);
        Iterator it = installedJobs.iterator();
      
        while(it.hasNext()){
           Map row = (Map)it.next();
	       String job_name = (String)row.get("JOB_NAME");
	       String job_group = (String)row.get("JOB_GROUP");
	       JobDetail jdetail = this.getJobDetailByNameAndGroup(job_name, job_group);
           if (jdetail != null) {
               jobDetails.add(jdetail);
           }
        }


        return jobDetails;
    }

    
    public void schedule(Date startTime, JobDetail jobDetail) {
        schedule(startTime, Scheduler.DEFAULT_GROUP, jobDetail);
    }

    
    public void schedule(Date startTime, String group, JobDetail jobDetail) {
        schedule(startTime, null, group, jobDetail);
    }

    
    public void schedule(String name, Date startTime, JobDetail jobDetail) {
        schedule(name, startTime, Scheduler.DEFAULT_GROUP, jobDetail);
    }

    
    public void schedule(String name, Date startTime, String group, JobDetail jobDetail) {
        schedule(name, startTime, null, group, jobDetail);
    }

    
    public void schedule(Date startTime, Date endTime, JobDetail jobDetail) {
        schedule(startTime, endTime, Scheduler.DEFAULT_GROUP, jobDetail);
    }

    
    public void schedule(Date startTime, Date endTime, String group, JobDetail jobDetail) {
        schedule(startTime, endTime, 0, group, jobDetail);
    }

    
    public void schedule(String name, Date startTime, Date endTime, JobDetail jobDetail) {
        schedule(name, startTime, endTime, Scheduler.DEFAULT_GROUP, jobDetail);
    }

    
    public void schedule(String name, Date startTime, Date endTime, String group, JobDetail jobDetail) {
        schedule(name, startTime, endTime, 0, group, jobDetail);
    }

    
    public void schedule(Date startTime, Date endTime, int repeatCount, JobDetail jobDetail) {
        schedule(startTime, endTime, 0, Scheduler.DEFAULT_GROUP, jobDetail);
    }

    
    public void schedule(Date startTime, Date endTime, int repeatCount, String group, JobDetail jobDetail) {
        schedule(null, startTime, endTime, 0, group, jobDetail);
    }

    
    public void schedule(String name, Date startTime, Date endTime, int repeatCount, JobDetail jobDetail) {
        schedule(name, startTime, endTime, 0, Scheduler.DEFAULT_GROUP, jobDetail);
    }

    
    public void schedule(String name, Date startTime, Date endTime, int repeatCount, String group, JobDetail jobDetail) {
        schedule(name, startTime, endTime, 0, 1L, group, jobDetail);
    }

    
    public void schedule(Date startTime, Date endTime, int repeatCount, long repeatInterval, JobDetail jobDetail) {
        schedule(startTime, endTime, repeatCount, repeatInterval, Scheduler.DEFAULT_GROUP, jobDetail);
    }

    
    public void schedule(Date startTime, Date endTime, int repeatCount, long repeatInterval, String group, JobDetail jobDetail) {
        schedule(null, startTime, endTime, repeatCount, repeatInterval, group, jobDetail);
    }

    
    public void schedule(String name, Date startTime, Date endTime, int repeatCount, long repeatInterval, JobDetail jobDetail) {
        this.schedule(name, startTime, endTime, repeatCount, repeatInterval, Scheduler.DEFAULT_GROUP, jobDetail);
    }

    
    public void schedule(String name, Date startTime, Date endTime, int repeatCount, long repeatInterval, String group, JobDetail jobDetail) {
        if (name == null || name.trim().equals("")) {
            name = String.valueOf(StringUtil.randoms());
        } else {
            //在名称后添加UUID，保证名称的唯一性
            name += "&" + String.valueOf(StringUtil.randoms());
        }

        try {
            scheduler.addJob(jobDetail, true);

            SimpleTrigger SimpleTrigger = new SimpleTrigger(name, group, jobDetail.getName(),
                    Scheduler.DEFAULT_GROUP, startTime, endTime, repeatCount, repeatInterval);
            scheduler.scheduleJob(SimpleTrigger);
            scheduler.rescheduleJob(SimpleTrigger.getName(), SimpleTrigger.getGroup(), SimpleTrigger);
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }

//    Map<String, String>
    public void schedule(Map map, JobDetail jobDetail) {

        String temp = null;
        //实例化SimpleTrigger
        SimpleTrigger SimpleTrigger = new SimpleTrigger();

        //这些值的设置也可以从外面传入，这里采用默放值
        SimpleTrigger.setJobName(jobDetail.getName());
        SimpleTrigger.setJobGroup(Scheduler.DEFAULT_GROUP);
        SimpleTrigger.setRepeatInterval(1000L);

        //设置名称
        temp = (String)map.get(Constants.TRIGGERNAME);
        if (StringUtils.isEmpty(StringUtils.trim(temp))) {
            temp = String.valueOf(StringUtil.randoms());
        } else {
            //在名称后添加UUID，保证名称的唯一性
            temp += "&" + String.valueOf(StringUtil.randoms());
        }
        SimpleTrigger.setName(temp);

        //设置Trigger分组
        temp = (String)map.get(Constants.TRIGGERGROUP);
        if (StringUtils.isEmpty(temp)) {
            temp = Scheduler.DEFAULT_GROUP;
        }
        SimpleTrigger.setGroup(temp);

        //设置开始时间
        temp = (String)map.get(Constants.STARTTIME);
        if (StringUtils.isNotEmpty(temp)) {
            SimpleTrigger.setStartTime(this.parseDate(temp));
        }

        //设置结束时间
        temp = (String)map.get(Constants.ENDTIME);
        if (StringUtils.isNotEmpty(temp)) {
            SimpleTrigger.setEndTime(this.parseDate(temp));
        }

        //设置执行次数
        temp = (String)map.get(Constants.REPEATCOUNT);
        if (StringUtils.isNotEmpty(temp) && NumberUtils.toInt(temp) > 0) {
            SimpleTrigger.setRepeatCount(NumberUtils.toInt(temp));
        }

        //设置执行时间间隔
        temp = (String)map.get(Constants.REPEATINTERVEL);
        if (StringUtils.isNotEmpty(temp) && NumberUtils.toLong(temp) > 0) {
            SimpleTrigger.setRepeatInterval(NumberUtils.toLong(temp) * 1000);
        }

        try {
            scheduler.addJob(jobDetail, true);

            scheduler.scheduleJob(SimpleTrigger);
            scheduler.rescheduleJob(SimpleTrigger.getName(), SimpleTrigger.getGroup(), SimpleTrigger);
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }

    
    public void scheduleSimpleJob(String triggerName, String appPath, String mainClass, String args, String cronExpression, String group) throws ParseException {
        String uuname = triggerName + "_" + String.valueOf(StringUtil.randoms());

        JobDetail jobDetail = new JobDetail(uuname, group, SimpleJobBean.class);
        JobDataMap datamap = new JobDataMap();
        datamap.put("appPath", appPath);
        datamap.put("mainClass", mainClass);
        datamap.put("args", args);
        jobDetail.setJobDataMap(datamap);


        CronTrigger cronTrigger = new CronTrigger(uuname, group, jobDetail.getName(),
                group);
        cronTrigger.setCronExpression(cronExpression);
        this.schedule(jobDetail, cronTrigger);
    }

    /**
     * 安装一个JobDetail
     *
     * @param appPath
     * @param mainClass
     * @param main_args
     * @param jvm_args
     * @param group
     */
    
    public void addJobDetail(String appPath, String mainClass, String main_args, String jvm_args, String group, String name, String desc) {
        JobDetail jobDetail = new JobDetail(name, group, SimpleJobBean.class);
        jobDetail.setDescription(desc);
        JobDataMap datamap = new JobDataMap();
        datamap.put("appPath", appPath);
        datamap.put("mainClass", mainClass);
        datamap.put("main_args", main_args);
        datamap.put("jvm_args", jvm_args);
        jobDetail.setJobDataMap(datamap);
        try {
            scheduler.addJob(jobDetail, true);
            quartzDao.installJob(name, group, appPath);
        } catch (SchedulerException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

//    return  List<Trigger>
    public List getQrtzTriggers() {
    	
    	int k = 0;
    	
 
    	
        List triggers = new ArrayList();
        try {
            String[] triggerGroupNames = scheduler.getTriggerGroupNames();
            

            
            for (int i = 0 ; i<triggerGroupNames.length;i++) {
            	 String[] triggerNames = scheduler.getTriggerNames(triggerGroupNames[i]);
            	 
        
            	  
            	 for (int j = 0;j<triggerNames.length;j++) {
            		 
            		   TriggerVO vo = new TriggerVO();
            		   
            		   Trigger trigger = scheduler.getTrigger(triggerNames[j], triggerGroupNames[i]);
            		
//            		   System.out.println("getQrtzTriggers>>>>>>>>>>>>>>>>>>>>>>triggerNames[j]>>>"+ triggerNames[j]+">>>>>>>>>>>>triggerGroupNames[i]>>"+ triggerGroupNames[i] +">>>>>>>>>>>>>>>>>>>>> start>>>"+triggerNames.length);

            		try {
						org.apache.commons.beanutils.BeanUtils.copyProperties(vo,trigger);
						
						k++;
//						 System.out.println("getQrtzTriggers>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>trigger>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> start>>>"+trigger);
						
						 
						 
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
//					
				      String state = this.getTriggerState(trigger.getName(), trigger.getGroup());
            		  vo.setState(state);
            		  vo.setTriggerType(getTriggerType(trigger));
                   
            		  
//            		  System.out.println("getQrtzTriggers>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>vo>>>>>>>>>>>>>>>>>>>>>>>>>>> start>>>"+vo);

            		  triggers.add(vo);
            	 }
            	
            }
            
            


        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        
        
//        System.out.println("getQrtzTriggers>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>triggers size>>>>>>>>>>>>>>>>>>>>>>>>>>> >>>"+triggers.size());
        return triggers;
    }
    
    
    
    public ListRange getQrtzTriggersJosn() {
		ListRange listRange = new ListRange();
		List ls = quartzDao.getQrtzTriggers();
		Iterator it = ls.iterator();
//		
//		 SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//		
//		System.out.println("getQrtzTriggers>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>yyyyMMdd>>>>>>>>>>>>>>>>>>>>>>>>>> >>>" +sdf.format( new Date(1323965082*1000)));
//		Date d=new Date();   
//		System.out.println("getQrtzTriggers>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>yyyyMMdd>>>>>>>1323965082>>>>>>>>>>>>>>>>>>> >>>" +d.getTime());
//		long aa =  Long.parseLong("1323965082000");
//		System.out.println("getQrtzTriggers>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>yyyyMMdd>>>>>>>1323965082>>>>>>>>>>>>>>>>>>> >>>" +sdf.format( new Date(aa)));
//		System.out.println("getQrtzTriggers>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>yyyyMMdd>>>>>>>1323965082>>>>>>>>>>>>>>>>>>> >>>" +sdf.format( new Date()));
//		
		
		 while(it.hasNext()){
			 TriggerVO vo =(TriggerVO) it.next();
//			 System.out.println("getQrtzTriggers>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>triggers size>>>>>>>>>>>>>>>>>>>>>>>>>>> >>>"+vo.toString());
			 vo.setOpts(getJobPror(vo.getName()));
		  }
		
		listRange.setData(ls);
		listRange.setTotalSize(ls.size());
		return listRange;
	}   

    
//    public ListRange getQrtzTriggersJosn() {
//		ListRange listRange = new ListRange();
//		List ls = this.getQrtzTriggers();
//		listRange.setData(ls);
//		listRange.setTotalSize(ls.size());
//		return listRange;
//	}
    
	
	
    
    public boolean pauseTrigger(String triggerName, String group) {
        boolean flag = false;
        try {
            scheduler.pauseTrigger(triggerName, group);//停止触发器
            flag = true;
        } catch (SchedulerException e) {
            flag = false;
            throw new RuntimeException(e);
        }
        return flag;
    }

    
    public boolean resumeTrigger(String triggerName, String group) {
        boolean flag = false;
        try {
            scheduler.resumeTrigger(triggerName, group);//重启触发器
            flag = true;
        } catch (SchedulerException e) {
            flag = false;
            throw new RuntimeException(e);
        }
        return flag;
    }

    
    public boolean removeTrigger(String triggerName, String group) {
        try {
            scheduler.pauseTrigger(triggerName, group);//停止触发器
            return scheduler.unscheduleJob(triggerName, group);//移除触发器
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }


    private Date parseDate(String time) {
        try {
            return DateUtils.parseDate(time, new String[]{"yyyy-MM-dd HH:mm"});
        } catch (ParseException e) {
            logger.error("日期格式错误{}，正确格式为：yyyy-MM-dd HH:mm" + time);
            throw new RuntimeException(e);
        }
    }

    public static String getTriggerType(Trigger trigger) {
    	String type = null;
    	if (trigger == null) {
    	    return null;
    	}

    	if (trigger.getClass() == SimpleTrigger.class) {
    	    type = "simple";
    	} else if (trigger.getClass() == CronTrigger.class) {
    	    type = "cron";
    	} else {
    	    type = trigger.getClass().getName();
    	}
    	return type;
        }
    
	  public void shutdownScheduler(){
		
		 try {
			 Scheduler scduler = getScheduler(); 
			 scduler.standby();
			 System.out.println("shutdownScheduler>>>>>>>"+ scduler.getSchedulerName());
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			logger.info("Cannot shutdown scheduler."+e.getMessage());
		}
	  } 
	    
	  public void startScheduler(){

			 try {
				 Scheduler scduler = getScheduler(); 
				 scduler.start();
				 System.out.println("startScheduler>>>>>>>"+ scduler.getSchedulerName());
			} catch (SchedulerException e) {
				// TODO Auto-generated catch block
				logger.info("Cannot start scheduler."+e.getMessage());
			}
		 } 
  
	  public void getSchedulerStates(){
			
			 try {
				 SchedulerFactory sf = new StdSchedulerFactory();
				 Scheduler scheduler = sf.getScheduler();
				 scheduler.start();
			} catch (SchedulerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 } 
	 
	  public void saveJobConfigs(String tigerName,String params){
		  Map mp = StringUtil.convertQueryStringtoMap(params);
		  
		  Properties ps= getDBBackupProperties();
		  
		  if("triggerSQLDump".equals(tigerName)){
			  String db_host = StringUtil.getNullValue(mp.get("db_host"),"127.0.0.1");
			  String db_database = StringUtil.getNullValue(mp.get("db_database"),"test");
//			  String db_path = StringUtil.getNullValue(mp.get("db_path"),"");
			  String db_user = StringUtil.getNullValue(mp.get("db_user"),"root");
			  String db_pass = StringUtil.getNullValue(mp.get("db_pass"),"root");
			  ps.setProperty("db_host",db_host);
			  ps.setProperty("db_database",db_database);
//			  ps.setProperty("db_path",db_path);
			  ps.setProperty("db_user",db_user);
			  ps.setProperty("db_pass",db_pass);
		  }
		  
		  if("triggerTransfersdb".equals(tigerName)){
			  String serviceType = StringUtil.getNullValue(mp.get("serviceType"),"ftp");
			  String targ_hostname = StringUtil.getNullValue(mp.get("targ_hostname"),"127.0.0.1");
			  String targ_path = StringUtil.getNullValue(mp.get("targ_path"),"");
			  String targ_username = StringUtil.getNullValue(mp.get("targ_username"),"test");
			  String targ_password = StringUtil.getNullValue(mp.get("targ_password"),"test");
			  String existDate = StringUtil.getNullValue(mp.get("existDate"),"5");
			  ps.setProperty("serviceType",serviceType);
			  ps.setProperty("targ_hostname",targ_hostname);
			  ps.setProperty("targ_path",targ_path);
			  ps.setProperty("targ_username",targ_username);
			  ps.setProperty("targ_password",targ_password);
			  ps.setProperty("existDate",existDate);
		  }
		  
		   HandlePropertiesUtil.saveProperty("databaseBackup.properties",ps,"");

		  logger.info("tigerName>>>>>>>"+ tigerName);
		  logger.info("params>>>>>>>"+ mp);
	  }
	  
	  
	  public String getJobConfigs(String tigerName){
	     
		  StringBuffer sb = new StringBuffer();
		  String split = "|";
		  Properties ps= getDBBackupProperties();
		  
		  if("triggerSQLDump".equals(tigerName)){
			  String db_host = StringUtil.getNullValue(ps.getProperty("db_host"),"127.0.0.1");
			  String db_database = StringUtil.getNullValue(ps.getProperty("db_database"),"test");
			  String db_user = StringUtil.getNullValue(ps.getProperty("db_user"),"root");
			  String db_pass = StringUtil.getNullValue(ps.getProperty("db_pass"),"root");
			  sb.append(db_host);
			  sb.append(split);
			  sb.append(db_database);
			  sb.append(split);
			  sb.append(db_user);
			  sb.append(split);
			  sb.append(db_pass);
               
		  }
		  
		  if("triggerTransfersdb".equals(tigerName)){

			  String serviceType = StringUtil.getNullValue(ps.getProperty("serviceType"),"ftp");
			  String targ_hostname = StringUtil.getNullValue(ps.getProperty("targ_hostname"),"127.0.0.1");
			  String targ_path = StringUtil.getNullValue(ps.getProperty("targ_path"),"/");
			  String targ_username = StringUtil.getNullValue(ps.getProperty("targ_username"),"test");
			  String targ_password = StringUtil.getNullValue(ps.getProperty("targ_password"),"test");
			  String existDate = StringUtil.getNullValue(ps.getProperty("existDate"),"5");

			  sb.append(serviceType);	
			  sb.append(split);
			  sb.append(targ_hostname);
			  sb.append(split);
			  sb.append(targ_path);
			  sb.append(split);
			  sb.append(targ_username);
			  sb.append(split);
			  sb.append(targ_password);			  
			  sb.append(split);
			  sb.append(existDate);		
		  }
		  
		  
		  logger.info("tigerName>>>>>>>"+ tigerName);
		  logger.info("params>>>>>>>"+  sb.toString());
		  
         return sb.toString();

		
	  }
  
	  public void startTriggerNow(String jobName,String groupName){
//		  StdScheduler scheduler = (StdScheduler)context.getScheduler();
		  try {
			  logger.info("jobName>>>>>>>"+ jobName);
			  logger.info("groupName>>>>>>>"+ groupName);
			   JobDetail jobDetail = this.getJobDetailByNameAndGroup(jobName,groupName);
			  scheduler.triggerJob(jobName,groupName,jobDetail.getJobDataMap());
			 
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	    public static Trigger getTrigger(Scheduler scheduler, String triggerName,  
	            String triggerGroup) {  
	        try {  
	            return scheduler.getTrigger(triggerName, triggerGroup);  
	        } catch (SchedulerException e) {  
	            throw new RuntimeException(e);  
	        }  
	    }  
	public void schedule(String triggerName, String triggerGroupName,String cronExpression, String jobDetailName, String jobGroupName) {
		
		JobDetail jobDetail = getJobDetailByNameAndGroup(jobDetailName,jobGroupName);
//		jobDetail.getJobDataMap().
		
        try {
			CronTrigger cronTrigger = new CronTrigger(triggerName, triggerGroupName, cronExpression);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	

//        try {
//			cronTrigger.setCronExpression(cronExpression);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	
//			Trigger trigger =getTrigger(scheduler,triggerName,triggerGroupName);
//			schedulerManager.schedule(triggerName, cronExpression, jobDetail);
			
		
			if (cronExpression.length() > 2) {
//				trigger.setCronExpression()
			}

		
	}
	
	public void updateCronExpression(String triggerName, String cronExpression) throws ParseException{
		try {
			CronTrigger cronTrigger = (CronTrigger) getScheduler().getTrigger(triggerName, Scheduler.DEFAULT_GROUP);
			String originConExpression = cronTrigger.getCronExpression();  
			
			   System.out.println("tigerName>>>>>>>"+ triggerName);
	           System.out.println("cronExpression>>>>>>>"+ cronExpression);
	            System.out.println("originConExpression>>>>>>>"+ originConExpression);
	           
            //判断任务时间是否更新过  
            if (!originConExpression.equalsIgnoreCase(cronExpression)) {  
//            	scheduler.addJob(this.jobDetail, true);  
            	cronTrigger.setCronExpression(cronExpression);
//                scheduler.scheduleJob(cronTrigger);  
                scheduler.rescheduleJob(triggerName, Scheduler.DEFAULT_GROUP, cronTrigger);  
//                quartzDao.updateConExpress(triggerName,cronExpression);
            }  
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}

	public void schedule(String triggerName, String cronExpression, String jobDetailName) {
		// TODO Auto-generated method stub
		
	}


	
//    public static void execNow(Scheduler scheduler, String jobName,  
//            String jobGroup, String triggerName, String triggerGroup) {  
//        try {  
//            Class _class = null;  
//            if (JobExecuUtil.getTaskType(jobName) == 2) {  
//                _class = TaskJob_FTP.class;  
//            } else {  
//                _class = TaskJob.class;  
//            }  
//            JobDetail jobDetail = new JobDetail(jobName, jobGroup, _class);  
//            Trigger trigger = TriggerUtils.makeImmediateTrigger(0, 0); // 第一个参数是将要触发的次数。第二个参数是执行的间隔时间。  
//            trigger.setName(triggerName);  
//            trigger.setGroup(triggerGroup);  
//            scheduler.scheduleJob(jobDetail, trigger);// 调度起来  
//        } catch (SchedulerException e) {  
//            throw new RuntimeException(e);  
//        }  
//    }  
  
}



