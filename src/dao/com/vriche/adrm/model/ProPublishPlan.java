/**
 * 
 */
package com.vriche.adrm.model;

import java.io.Serializable;
import java.util.Date;

/**
 * ProProgram class
 * 
 * This class is used to 
 * 
 * <p><a href="ProPublishPlan.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * 
 * @hibernate.class table="tb_pro_publish_plan"
 */
public class ProPublishPlan extends BaseObjectWithoutNestedFormValidation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 721639426659596678L;
	protected Long id;               //计划id  20
	protected Long programId;        //节目id 20
	protected Long carrierId;	         //频道id 20
	protected Integer startDate ;       //节目开始日期12
	protected Integer endDate ;         //节目结束日期12
	protected Integer startTime ;       //节目开始时间12
	protected Integer endTime ;         //节目结束时间12
	protected String weeksPlan;       //周排期 20
	
    protected Integer version;
    protected Long createBy;				  
    protected Date createDate;					  
    protected Long modifyBy;				  
    protected Date modifyDate;	
    
    protected Carrier carrier = new Carrier();
    protected ProProgram proProgram = new ProProgram(); 
    protected ParamClass paramClass = new ParamClass();

    
    
    
	public ParamClass getParamClass() {
		return paramClass;
	}

	public void setParamClass(ParamClass paramClass) {
		this.paramClass = paramClass;
	}

	/**
     * @hibernate.many-to-one name="programId" column="program_id" cascade="all" not-null="true"
 	 */
	public ProProgram getProProgram() {
		return proProgram;
	}
	
	/**
     * @hibernate.many-to-one name="carrierId" column="carrier_id" cascade="all" not-null="true"
 	 */
	public Carrier getCarrier() {
		return carrier;
	}
	
	/**
     * 
     * Returns the carrierId
     * @return Long
     * 
     * @hibernate.property length="20" column="carrier_id" not-null="false"
     */
	public Long getCarrierId() {
		return carrierId;
	}

	/**
     * 
     * Returns the createBy
     * @return Long
     * 
     * @hibernate.property length="20" column="create_by" not-null="false"
     */
	public Long getCreateBy() {
		return createBy;
	}

	/**
     * 
     * Returns the createDate
     * @return Date
     * 
     * @hibernate.property column="create_date" length="12" update="false" insert="true" type="timestamp"
     */
	public Date getCreateDate() {
		return createDate;
	}

	/**
     * 
     * Returns the endDate
     * @return Integer
     * 
     * @hibernate.property length="12" column="end_date" not-null="false"
     */
	public Integer getEndDate() {
		return endDate;
	}

	/**
     * 
     * Returns the endTime
     * @return Integer
     * 
     * @hibernate.property length="12" column="end_time" not-null="false"
     */
	public Integer getEndTime() {
		return endTime;
	}

	/**
     * @hibernate.id column="id" generator-class="native" unsaved-value="null"
     */
	public Long getId() {
		return id;
	}

	/**
     * 
     * Returns the modifyBy
     * @return Long
     * 
     * @hibernate.property length="20" column="modify_by" not-null="false"
     */
	public Long getModifyBy() {
		return modifyBy;
	}

	/**
     * 
     * Returns the modifyDate
     * @return Integer
     * 
    * @hibernate.property column="modify_date" update="false" insert="true" type="timestamp"
     */
	public Date getModifyDate() {
		return modifyDate;
	}

	/**
     * 
     * Returns the programId
     * @return Long
     * 
     * @hibernate.property length="20" column="program_id" not-null="false"
     */
	public Long getProgramId() {
		return programId;
	}

	/**
     * 
     * Returns the startDate
     * @return Integer
     * 
     * @hibernate.property length="12" column="start_date" not-null="false"
     */
	public Integer getStartDate() {
		return startDate;
	}

	/**
     * 
     * Returns the startTime
     * @return Integer
     * 
     * @hibernate.property length="12" column="start_time" not-null="false"
     */
	public Integer getStartTime() {
		return startTime;
	}

	/**
     * @hibernate.version column="version"
     */
	public Integer getVersion() {
		return version;
	}

	/**
     * 
     * Returns the weeksPlan
     * @return String
     * 
     * @hibernate.property length="20" column="weeks_plan" not-null="false"
     */
	public String getWeeksPlan() {
		return weeksPlan;
	}



	
	
	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}

	public void setCarrierId(Long carrierId) {
		this.carrierId = carrierId;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setEndDate(Integer endDate) {
		this.endDate = endDate;
	}

	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setModifyBy(Long modifyBy) {
		this.modifyBy = modifyBy;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public void setProgramId(Long programId) {
		this.programId = programId;
	}

	public void setProProgram(ProProgram proProgram) {
		this.proProgram = proProgram;
	}

	public void setStartDate(Integer startDate) {
		this.startDate = startDate;
	}

	public void setStartTime(Integer startTime) {
		this.startTime = startTime;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public void setWeeksPlan(String weeksPlan) {
		this.weeksPlan = weeksPlan;
	}

	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}



	
}
