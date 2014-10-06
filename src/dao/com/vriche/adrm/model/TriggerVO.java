package com.vriche.adrm.model;

//import org.quartz.JobDataMap;

import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Created by IntelliJ IDEA.
 * User: SongJiao
 * Date: 2010-1-16
 * Time: 13:09:56
 * To change this template use File | Settings | File Templates.
 */
public class TriggerVO {
	
    private String name;
    private String triggerGroup;
    private String triggerType;
    private String jobName;
    private String jobGroup;
    private String description;
    private String volatility;
    private Date startTime;
    private Date endTime;
    private Date nextFireTime;
    private Date prevFireTime;
    private int misfireInstruction;
    private String[] linkedTriggerListeners;
    private int priority;
    private String opts;
    private String cronExpression;
    
    
//    private JobDataMap jobData;
    
    
    
    
    
    public String getName() {
        return name;
    } 

    public void setName(String name) {
        this.name = name;
    }

    public String getTriggerGroup() {
        return triggerGroup;
    }

    public void setTriggerGroup(String triggerGroup) {
        this.triggerGroup = triggerGroup;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVolatility() {
        return volatility;
    }

    public void setVolatility(String volatility) {
        this.volatility = volatility;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getNextFireTime() {
        return nextFireTime;
    }

    public void setNextFireTime(Date nextFireTime) {
        this.nextFireTime = nextFireTime;
    }

    public Date getPrevFireTime() {
        return prevFireTime;
    }

    public void setPrevFireTime(Date prevFireTime) {
        this.prevFireTime = prevFireTime;
    }

    public int getMisfireInstruction() {
        return misfireInstruction;
    }

    public void setMisfireInstruction(int misfireInstruction) {
        this.misfireInstruction = misfireInstruction;
    }

    public String[] getLinkedTriggerListeners() {
        return linkedTriggerListeners;
    }

    public void setLinkedTriggerListeners(String[] linkedTriggerListeners) {
        this.linkedTriggerListeners = linkedTriggerListeners;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }



//    public JobDataMap getJobData() {
//        return jobData;
//    }
//
//    public void setJobData(JobDataMap jobData) {
//        this.jobData = jobData;
//    }

    private String state;

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("jobGroup", this.jobGroup).append("volatility",
						this.volatility).append("misfireInstruction",
						this.misfireInstruction).append("prevFireTime",
						this.prevFireTime).append("startTime", this.startTime)
				.append("state", this.state).append("name", this.name).append(
						"jobName", this.jobName).append("description",
						this.description).append("endTime", this.endTime)
				.append("priority", this.priority).append("nextFireTime",
						this.nextFireTime).append("triggerGroup",
						this.triggerGroup).append("linkedTriggerListeners",
						this.linkedTriggerListeners).toString();
	}

	public String getTriggerType() {
		return triggerType;
	}

	public void setTriggerType(String triggerType) {
		this.triggerType = triggerType;
	}

	public String getOpts() {
		return opts;
	}

	public void setOpts(String opts) {
		this.opts = opts;
	}

	public String getCronExpression() {
		return cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

}
