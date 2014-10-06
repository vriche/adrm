/****************************************************************************     
 * Created on 2004-1-22                                                     *    
 *                                                               			*
 * @author <a href="mailto:hongxilin@yahoo.com.cn">hongxi</a>               *
 *         Updated by hongxi (hongxilin@yahoo.com.cn)                       *
 *                                                                          *
 * @version  Vision:1.0														*
 * 																			*
 ***************************************************************************/
package com.vriche.adrm.model;

import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * OaApplyInfo class
 * 
 * This class is used to 
 * 
 * <p><a href="OaApplyInfo.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_oa_apply_info"
 * 
 */
public class OaApplyInfo extends BaseObjectWithoutNestedFormValidation {
	

	private static final long serialVersionUID = 1L;
	protected Long id;
	protected Long workFlowTypeId;
	protected Integer applyStart;  	 // required
	protected Integer applyEnd;  		 // required
	protected String reason;
	protected Long checkResultId;
	protected Long createBy; 		 // default sysdate
	protected Date createDate;
	protected Long modifyBy;		 // default sysdate
	protected Date modifyDate;
	protected Integer version;
	
	protected OaWorkFlowType workFlowType = new OaWorkFlowType();
	protected OaWorkFlowCheckResult checkResult = new OaWorkFlowCheckResult();
	
	public OaApplyInfo() {};
	
	
	/**
	 * 
	 * Returns the id
	 * @return Long
	 * 
     * @hibernate.id column="apply_info_id" generator-class="native" unsaved-value="null"
	 */
	public Long getId() {
		return id;
	}


	/**
	 * 
	 * Returns the checkResult
	 * @return OaWorkFlowCheckResult
	 * 
	 */
	public OaWorkFlowCheckResult getCheckResult() {
		return checkResult;
	}


	/**
	 * 
	 * Returns the workFlowType
	 * @return OaWorkFlowType
	 * 
	 */
	public OaWorkFlowType getWorkFlowType() {
		return workFlowType;
	}


	/**
	 * 
	 * Returns the applystart
	 * @return Integer
	 * @struts.validator type="required"
	 * @hibernate.property length="8" column="apply_start" update="false" insert="true"
	 */
	public Integer getApplyStart() {
		return applyStart;
	}
	/**
	 * 
	 * Returns the applyEnd
	 * @return Integer
	 * @struts.validator type="required"
	 * @hibernate.property length="8" column="apply_end" not-null="false"
	 */
	public Integer getApplyEnd() {
		return applyEnd;
	}



	/**
	 * 
	 * Returns the checkresultid
	 * @return Long
	 * 
	 * @hibernate.property length="20" column="check_result_id" not-null="false"
	 */
	public Long getCheckResultId() {
		return checkResultId;
	}


	/**
	 * 
	 * Returns the reason
	 * @return String
	 * 
	 * @hibernate.property length="255" column="reason" not-null="false"
	 */
	public String getReason() {
		return reason;
	}


	/**
	 * 
	 * Returns the workflowtypeid
	 * @return Long
	 * 
	 * @hibernate.property length="20" column="work_flow_type_id" not-null="false"
	 */
	public Long getWorkFlowTypeId() {
		return workFlowTypeId;
	}


	/**
	 * 
	 * Returns the createBy
	 * 
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
	 * 
	 * @return Date
	 * 
	 * @hibernate.property column="create_date" update="false" insert="true"
	 *                     type="timestamp"
	 */

	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 
	 * Returns the modifyBy
	 * 
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
	 * 
	 * @return Date
	 * 
	 * @hibernate.property column="modify_date" update="false" insert="true"
	 *                     type="timestamp"
	 */
	public Date getModifyDate() {
		return modifyDate;
	}

	/**
	 * @hibernate.version
	 */
	public Integer getVersion() {
		return version;
	}
	
	
	


	/**
	 * @param applyEnd The applyEnd to set.
	 */
	public void setApplyEnd(Integer applyEnd) {
		this.applyEnd = applyEnd;
	}


	/**
	 * @param applyStart The applyStart to set.
	 */
	public void setApplyStart(Integer applyStart) {
		this.applyStart = applyStart;
	}


	/**
	 * @param checkResult The checkResult to set.
	 */
	public void setCheckResult(OaWorkFlowCheckResult checkResult) {
		this.checkResult = checkResult;
	}


	/**
	 * @param checkResultId The checkResultId to set.
	 */
	public void setCheckResultId(Long checkResultId) {
		this.checkResultId = checkResultId;
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
	 * @param id The id to set.
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * @param reason The reason to set.
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}


	/**
	 * @param version The version to set.
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}


	/**
	 * @param workFlowType The workFlowType to set.
	 */
	public void setWorkFlowType(OaWorkFlowType workFlowType) {
		this.workFlowType = workFlowType;
	}


	/**
	 * @param workFlowTypeId The workFlowTypeId to set.
	 */
	public void setWorkFlowTypeId(Long workFlowTypeId) {
		this.workFlowTypeId = workFlowTypeId;
	}


	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof OaApplyInfo)) {
			return false;
		}
		OaApplyInfo rhs = (OaApplyInfo) object;
		return new EqualsBuilder().append(
				this.applyStart, rhs.applyStart).append(this.modifyBy,
				rhs.modifyBy).append(this.createBy, rhs.createBy).append(
				this.id, rhs.id).append(this.version, rhs.version).append(
				this.workFlowType, rhs.workFlowType).append(this.checkResultId,
				rhs.checkResultId).append(this.reason, rhs.reason).append(
				this.workFlowTypeId, rhs.workFlowTypeId).append(this.applyEnd,
				rhs.applyEnd).append(this.createDate, rhs.createDate).append(
				this.modifyDate, rhs.modifyDate).append(this.checkResult,
				rhs.checkResult).isEquals();
	}


	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-1743602559, 21236743).append(this.applyStart).append(this.modifyBy)
				.append(this.createBy).append(this.id).append(this.version)
				.append(this.workFlowType).append(this.checkResultId).append(
						this.reason).append(this.workFlowTypeId).append(
						this.applyEnd).append(this.createDate).append(
						this.modifyDate).append(this.checkResult).toHashCode();
	}


	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("workFlowTypeId",
				this.workFlowTypeId).append("reason", this.reason).append(
				"checkResultId", this.checkResultId).append("modifyBy",
				this.modifyBy).append("id", this.id).append("version",
				this.version).append("modifyDate", this.modifyDate).append(
				"applyStart", this.applyStart)
				.append("createBy", this.createBy).append("applyEnd",
						this.applyEnd).append("createDate", this.createDate)
				.toString();
	}

}
