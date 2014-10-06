/**
 * 
 */
package com.vriche.adrm.model;

import java.io.Serializable;
import java.util.Date;

/**
 * ProCheckIdea class
 * 
 * This class is used to 
 * 
 * <p><a href="ProCheckIdea.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * 
 * @hibernate.class table="tb_pro_check_idea"
 */
public class ProCheckIdea extends BaseObjectWithoutNestedFormValidation
		implements Serializable {
	
	private static final long serialVersionUID = 1L;
	protected Long id ;               //审核id 
	protected Long programId ;        //节目id 
	protected Long carrierId ;        //频道id 
	protected Long checkResult ;      //审核结果 
	protected String checkIdea ;      //审核意见
    
	protected Integer version;
    protected Long createBy;				  
    protected Date createDate;					  
    protected Long modifyBy;				  
    protected Date modifyDate;
    
    

	/**
     * @hibernate.id column="id" generator-class="native" unsaved-value="null"
     */
	public Long getId() {
		return id;
	}  
    /**
     * 
     * Returns the checkResult
     * @return Long
     * 
     * @hibernate.property length="20" column="check_result" not-null="false"
     */
    public Long getCheckResult() {
		return checkResult;
	}
    /**
     * 
     * Returns the checkIdea
     * @return String
     * 
     * @hibernate.property length="20" column="check_idea" not-null="false"
     */
	public String getCheckIdea() {
		return checkIdea;
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
     * @hibernate.property column="create_date" update="false" insert="true" type="timestamp"
     */
	public Date getCreateDate() {
		return createDate;
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
     * @return Date
     * 
    * @hibernate.property column="modify_date" update="false" insert="true" type="timestamp"
     */
	public Date getModifyDate() {
		return modifyDate;
	}


	 /**
     * @hibernate.version column="version"
     */
	public Integer getVersion() {
		return version;
	}



	/**
	 * @param id The id to set.
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @param checkIdea The checkIdea to set.
	 */
	public void setCheckIdea(String checkIdea) {
		this.checkIdea = checkIdea;
	}
	/**
	 * @param checkResult The checkResult to set.
	 */
	public void setCheckResult(Long checkResult) {
		this.checkResult = checkResult;
	}
	/**
	 * @param programId The programId to set.
	 */
	public void setProgramId(Long programId) {
		this.programId = programId;
	}
	/**
	 * @param createBy The createBy to set.
	 */
	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	/**
	 * @param createDate The createDate to set.
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @param modifyBy The modifyBy to set.
	 */
	public void setModifyBy(Long modifyBy) {
		this.modifyBy = modifyBy;
	}

	/**
	 * @param modifyDate The modifyDate to set.
	 */
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	/**
	 * @param version The version to set.
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	
	public String toString() {
		return null;
	}

	public boolean equals(Object o) {
		return false;
	}

	public int hashCode() {
		return 0;
	}
	public Long getCarrierId() {
		return carrierId;
	}
	public void setCarrierId(Long carrierId) {
		this.carrierId = carrierId;
	}

}
