package com.vriche.adrm.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.quartz.*;

import com.vriche.adrm.model.ListRange;

import java.text.ParseException;

//second minute hours dayOfMonth month dayOfWeek year 

public interface SchedulerManager {
	 /**
     * ���� Quartz Cron Expression ��������
     *
     * @param cronExpression Quartz Cron ���ʽ���� "0/10 * * ? * * *"��
     */
    void schedule(String cronExpression, JobDetail jobDetail);

    /**
     * ���� Quartz Cron Expression ��������
     *
     * @param name           Quartz CronTrigger����
     * @param cronExpression Quartz Cron ���ʽ���� "0/10 * * ? * * *"��
     */
    void schedule(String name, String cronExpression, JobDetail jobDetail);

    /**
     * ���� Quartz Cron Expression ��������
     *
     * @param name           Quartz CronTrigger����
     * @param cronExpression Quartz Cron ���ʽ���� "0/10 * * ? * * *"��
     * @param group          Quartz CronExpression Group
     */
    void schedule(String name, String cronExpression, String group, JobDetail jobDetail);

    /**
     * ���� Quartz Cron Expression ��������
     *
     * @param cronExpression Quartz CronExpression
     */
    void schedule(CronExpression cronExpression, JobDetail jobDetail);

    /**
     * ���� Quartz Cron Expression ��������
     *
     * @param name           Quartz CronTrigger����
     * @param cronExpression Quartz CronExpression
     */
    void schedule(String name, CronExpression cronExpression, JobDetail jobDetail);

    /**
     * ���� Quartz Cron Expression ��������
     *
     * @param name           Quartz CronTrigger����
     * @param cronExpression Quartz CronExpression
     * @param group          Quartz CronExpression Group
     */
    void schedule(String name, CronExpression cronExpression, String group, JobDetail jobDetail);

    /**
     * ��startTimeʱִ�е���һ��
     *
     * @param startTime ���ȿ�ʼʱ��
     */
    void schedule(Date startTime, JobDetail jobDetail);

    /**
     * ��startTimeʱִ�е���һ��
     *
     * @param startTime ���ȿ�ʼʱ��
     * @param group     Quartz SimpleTrigger Group
     */
    void schedule(Date startTime, String group, JobDetail jobDetail);

    /**
     * ��startTimeʱִ�е���һ��
     *
     * @param name      Quartz SimpleTrigger ����
     * @param startTime ���ȿ�ʼʱ��
     */
    void schedule(String name, Date startTime, JobDetail jobDetail);

    /**
     * ��startTimeʱִ�е���һ��
     *
     * @param name      Quartz SimpleTrigger ����
     * @param startTime ���ȿ�ʼʱ��
     * @param group     Quartz SimpleTrigger Group
     */
    void schedule(String name, Date startTime, String group, JobDetail jobDetail);

    /**
     * ��startTimeʱִ�е��ԣ�endTime����ִ�е���
     *
     * @param startTime ���ȿ�ʼʱ��
     * @param endTime   ���Ƚ���ʱ��
     */
    void schedule(Date startTime, Date endTime, JobDetail jobDetail);

    /**
     * ��startTimeʱִ�е��ԣ�endTime����ִ�е���
     *
     * @param startTime ���ȿ�ʼʱ��
     * @param endTime   ���Ƚ���ʱ��
     * @param group     Quartz SimpleTrigger Group
     */
    void schedule(Date startTime, Date endTime, String group, JobDetail jobDetail);

    /**
     * ��startTimeʱִ�е��ԣ�endTime����ִ�е���
     *
     * @param name      Quartz SimpleTrigger ����
     * @param startTime ���ȿ�ʼʱ��
     * @param endTime   ���Ƚ���ʱ��
     */
    void schedule(String name, Date startTime, Date endTime, JobDetail jobDetail);

    /**
     * ��startTimeʱִ�е��ԣ�endTime����ִ�е���
     *
     * @param name      Quartz SimpleTrigger ����
     * @param startTime ���ȿ�ʼʱ��
     * @param endTime   ���Ƚ���ʱ��
     * @param group     Quartz SimpleTrigger Group
     */
    void schedule(String name, Date startTime, Date endTime, String group, JobDetail jobDetail);

    /**
     * ��startTimeʱִ�е��ԣ�endTime����ִ�е��ȣ��ظ�ִ��repeatCount��
     *
     * @param startTime   ���ȿ�ʼʱ��
     * @param endTime     ���Ƚ���ʱ��
     * @param repeatCount �ظ�ִ�д���
     */
    void schedule(Date startTime, Date endTime, int repeatCount, JobDetail jobDetail);

    /**
     * ��startTimeʱִ�е��ԣ�endTime����ִ�е��ȣ��ظ�ִ��repeatCount��
     *
     * @param startTime   ���ȿ�ʼʱ��
     * @param endTime     ���Ƚ���ʱ��
     * @param repeatCount �ظ�ִ�д���
     * @param group       Quartz SimpleTrigger Group
     */
    void schedule(Date startTime, Date endTime, int repeatCount, String group, JobDetail jobDetail);

    /**
     * ��startTimeʱִ�е��ԣ�endTime����ִ�е��ȣ��ظ�ִ��repeatCount��
     *
     * @param name        Quartz SimpleTrigger ����
     * @param startTime   ���ȿ�ʼʱ��
     * @param endTime     ���Ƚ���ʱ��
     * @param repeatCount �ظ�ִ�д���
     */
    void schedule(String name, Date startTime, Date endTime, int repeatCount, JobDetail jobDetail);

    /**
     * ��startTimeʱִ�е��ԣ�endTime����ִ�е��ȣ��ظ�ִ��repeatCount��
     *
     * @param name        Quartz SimpleTrigger ����
     * @param startTime   ���ȿ�ʼʱ��
     * @param endTime     ���Ƚ���ʱ��
     * @param repeatCount �ظ�ִ�д���
     * @param group       Quartz SimpleTrigger Group
     */
    void schedule(String name, Date startTime, Date endTime, int repeatCount, String group, JobDetail jobDetail);

    /**
     * ��startTimeʱִ�е��ԣ�endTime����ִ�е��ȣ��ظ�ִ��repeatCount�Σ�ÿ��repeatInterval��ִ��һ��
     *
     * @param startTime      ���ȿ�ʼʱ��
     * @param endTime        ���Ƚ���ʱ��
     * @param repeatCount    �ظ�ִ�д���
     * @param repeatInterval ִ��ʱ�����
     */
    void schedule(Date startTime, Date endTime, int repeatCount, long repeatInterval, JobDetail jobDetail);

    /**
     * ��startTimeʱִ�е��ԣ�endTime����ִ�е��ȣ��ظ�ִ��repeatCount�Σ�ÿ��repeatInterval��ִ��һ��
     *
     * @param startTime      ���ȿ�ʼʱ��
     * @param endTime        ���Ƚ���ʱ��
     * @param repeatCount    �ظ�ִ�д���
     * @param repeatInterval ִ��ʱ�����
     * @param group          Quartz SimpleTrigger Group
     */
    void schedule(Date startTime, Date endTime, int repeatCount, long repeatInterval, String group, JobDetail jobDetail);

    /**
     * ��startTimeʱִ�е��ԣ�endTime����ִ�е��ȣ��ظ�ִ��repeatCount�Σ�ÿ��repeatInterval��ִ��һ��
     *
     * @param name           Quartz SimpleTrigger ����
     * @param startTime      ���ȿ�ʼʱ��
     * @param endTime        ���Ƚ���ʱ��
     * @param repeatCount    �ظ�ִ�д���
     * @param repeatInterval ִ��ʱ�����
     */
    void schedule(String name, Date startTime, Date endTime, int repeatCount, long repeatInterval, JobDetail jobDetail);

    /**
     * ��startTimeʱִ�е��ԣ�endTime����ִ�е��ȣ��ظ�ִ��repeatCount�Σ�ÿ��repeatInterval��ִ��һ��
     *
     * @param name           Quartz SimpleTrigger ����
     * @param startTime      ���ȿ�ʼʱ��
     * @param endTime        ���Ƚ���ʱ��
     * @param repeatCount    �ظ�ִ�д���
     * @param repeatInterval ִ��ʱ�����
     * @param group          Quartz SimpleTrigger Group
     */
    void schedule(String name, Date startTime, Date endTime, int repeatCount, long repeatInterval, String group, JobDetail jobDetail);

    /**
     * Trigger ����,��com.sundoctor.example.Constant����Ϊ����װ��Map
     *
     * @param map<String, String>
     */
    void schedule(Map map, JobDetail jobDetail);


    /**
     * ����SimpleJob
     */
    void scheduleSimpleJob(String triggerName, String appPath, String mainClass, String args, String cronExpression, String group) throws ParseException;

    /**
     * ��װһ��JobDetail
     *
     * @param appPath
     * @param mainClass
     * @param main_args
     * @param jvm_args
     * @param group
     */
    void addJobDetail(String appPath, String mainClass, String main_args, String jvm_args, String group, String name, String desc);

    /**
     * ȡ�����е���Triggers
     *
     * @return List<Trigger>
     */
    List getQrtzTriggers();

    /**
     * �������ƺ������ͣTigger
     *
     * @param triggerName
     * @param group
     */
    boolean pauseTrigger(String triggerName, String group);

    /**
     * �ָ�Trigger
     *
     * @param triggerName
     * @param group
     */
    boolean resumeTrigger(String triggerName, String group);

    /**
     * ɾ��Trigger
     *
     * @param triggerName
     * @param group
     */
    boolean removeTrigger(String triggerName, String group);


    public void schedule(JobDetail jobDetail, CronTrigger cronTrigger);

    
    public void  schedule(String triggerName, String cronExpression, String jobDetailName);

    /**
     * @return ȡ�����е�JobDetail List<JobDetail>
     */
    public List getAllJobDetails();

    /**
     * ����jobDetail�����ֺ���Ų��Ҹ�jobDetail����ЩTrigger�ڵ���
     *
     * @param jobName   job��
     * @param groupName ����
     * @return List<TriggerVO>
     */
    public List getTriggersByJobName(String jobName, String groupName);

    /**
     * ����jobName��groupName����JobDetail
     *
     * @param jobName
     * @param groupName
     * @return
     */
    public JobDetail getJobDetailByNameAndGroup(String jobName, String groupName);


    /**
     * ��Job���CronTrigger
     *
     * @param cronTrigger
     */
    public void schedule(CronTrigger cronTrigger);

    /**
     * ����triggerName ��groupName �ж�Trigger��״̬
     *
     * @param triggerName
     * @param groupName
     * @return
     */
    public String getTriggerState(String triggerName, String groupName);

    /**
     * ���ݰ�װĿ¼����jobDetail
     *
     * @param app_path
     * @return List<JobDetail>
     */
    public List getInstalledJobDetails(String app_path);

    public Trigger[] getTrigersOfJob(String jobName, String groupName) throws SchedulerException;

    /**
     * ɾ��Job
     *
     * @param jobName
     * @param jobGroup
     */
    public void deleteJobDetail(String jobName, String jobGroup);
    
    
    public ListRange getQrtzTriggersJosn();
    
	public void shutdownScheduler();
	  
	public void startScheduler();
	
	
	public void getSchedulerStates();
	
	
	public void saveJobConfigs(String tigerName,String params);
	
	public String getJobConfigs(String tigerName);
	
	 public void startTriggerNow(String jobName,String groupName);
	 
	 public void updateCronExpression(String triggerName, String cronExpression) throws ParseException;
	
	
}
