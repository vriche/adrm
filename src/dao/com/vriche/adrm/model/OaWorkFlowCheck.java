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
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * OaWorkFlowCheck class
 * 
 * This class is used to 
 * 
 * <p><a href="OaWorkFlowCheck.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_oa_work_flow_check"
 * 
 */
public class OaWorkFlowCheck extends BaseObject {
	
	private static final long serialVersionUID = 1L;
	protected Long id;
	protected Long workFlowTypeId;
//	protected Long sysEventId;
	protected Long checkUserId;  // required    
	protected String checkIdea;
//	protected Long checkResultId;
	protected Long createBy; // default sysdate
	protected Date createDate;
	protected Long modifyBy; // default sysdate
	protected Date modifyDate;
	protected Integer version;
	
	protected Long checkStateId;
	
	protected Long workFlowId;
	
//	protected Boolean  checked;

	protected OaWorkFlowType workFlowType = new OaWorkFlowType();
	protected OaWorkFlow workFlow = new OaWorkFlow();
	protected OaWorkFlowCheckState checkState = new OaWorkFlowCheckState();
	
//	protected OaWorkFlowCheckResult checkResult = new OaWorkFlowCheckResult();
//	protected SysEvent sysEvent = new SysEvent();
	protected User checkUser = new User();
	
	protected Set contracts = new HashSet();
	protected Set orders = new HashSet();
	protected Set applys = new HashSet();
	
	public OaWorkFlowCheck() {};
	








	/**
	 * 
	 * Returns the id
	 * @return Long
	 * 
	 * @hibernate.id column="work_flow_check_id" generator-class="native" unsaved-value="null"
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * 
	 * Returns the checkIdea
	 * @return String
	 * 
	 * @hibernate.property length="255" column="check_idea" not-null="false"
	 */
	public String getCheckIdea() {
		return checkIdea;
	}




	/**
	 * 
	 * Returns the checkUserId
	 * @return Long
	 * @struts.validator type="required"
	 * @hibernate.property length="20" column="check_user_id" not-null="false"
	 */
	public Long getCheckUserId() {
		return checkUserId;
	}





	/**
	 * 
	 * Returns the workFlowTypeId
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
	 * 
	 * Returns the checkStateId
	 * @return Long 
	 * 
	 * @hibernate.property length="128" column="check_state_id" not-null="false"
	 */
	public Long getCheckStateId() {
		return checkStateId;
	}

	/**
	 * 
	 * Returns the workFlowId
	 * @return Long 
	 * 
	 * @hibernate.property length="128" column="work_flow_id" not-null="false"
	 */
	public Long getWorkFlowId() {
		return workFlowId;
	}

	/**
	 * 
	 * Returns the checkState
	 * @return OaWorkFlowCheckState 
	 * 
	 */
	public OaWorkFlowCheckState getCheckState() {
		return checkState;
	}
	

//	/**
//	 * 
//	 * Returns the checcked
//	 * @return Boolean 
//	 * 
//	 * @hibernate.property length="1" column="checked" not-null="false"
//	 */
//	public Boolean getChecked() {
//		return checked;
//	}




	/**
	 * 
	 * Returns the workFlow
	 * @return OaWorkFlow 
	 */
	public OaWorkFlow getWorkFlow() {
		return workFlow;
	}
	
	/**
	 * @hibernate.version
	 */
	public Integer getVersion() {
		return version;
	}
	
	/**
	* 
    * @hibernate.list  name="contracts" table="tb_oa_work_flow_result_contract" cascade="save-update" lazy="false"
    * @hibernate.collection-key column="work_flow_check_id" 
    * @hibernate.collection-index column = "contract_id" type = "long" not-null="true"
    * @hibernate.collection-element column = "checked" type = "integer"  length="1" not-null="true"
	 */

	public Set getContracts() {
		return contracts;
	}

	/**
	 * 
    * @hibernate.list  name="orders" table="tb_oa_work_flow_result_order" cascade="save-update" lazy="false"
    * @hibernate.collection-key column="work_flow_check_id"
    * @hibernate.collection-index column = "order_id" type = "long" not-null="true"
    * @hibernate.collection-element column = "checked" type = "integer"  length="1" not-null="true"
	 */
	public Set getOrders() {
		return orders;
	}
	

	/**
	 * 
    * @hibernate.list  name="applys" table="tb_oa_work_flow_result_apply" cascade="save-update" lazy="false"
    * @hibernate.collection-key column="work_flow_check_id"
    * @hibernate.collection-index column = "apply_info_id" type = "long" not-null="true"
     * @hibernate.collection-element column = "checked" type = "integer"  length="1" not-null="true"
	 */
	public Set getApplys() {
		return applys;
	}

	
	



	/**
	 * 
	 * Returns the checkUser
	 * @return User 
	 */
	public User getCheckUser() {
		return checkUser;
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
	 * @param version The version to set.
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}


	/**
	 * @param workflowtypeid The workflowtypeid to set.
	 */
	public void setWorkflowtypeid(Long workflowtypeid) {
		this.workFlowTypeId = workflowtypeid;
	}
	
	


	/** 
	 * @param checkIdea The checkIdea to set.
	 */
	public void setCheckIdea(String checkIdea) {
		this.checkIdea = checkIdea;
	}





	/** 
	 * @param checkUser The checkUser to set.
	 */
	public void setCheckUser(User checkUser) {
		this.checkUser = checkUser;
	}


	/** 
	 * @param checkUserId The checkUserId to set.
	 */
	public void setCheckUserId(Long checkUserId) {
		this.checkUserId = checkUserId;
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
	 * @param checkState The checkState to set.
	 */
	public void setCheckState(OaWorkFlowCheckState checkState) {
		this.checkState = checkState;
	}


	/** 
	 * @param checkStateId The checkStateId to set.
	 */
	public void setCheckStateId(Long checkStateId) {
		this.checkStateId = checkStateId;
	}









	/** 
	 * @param contracts The contracts to set.
	 */
	public void setContracts(Set contracts) {
		this.contracts = contracts;
	}









	/** 
	 * @param orders The orders to set.
	 */
	public void setOrders(Set orders) {
		this.orders = orders;
	}









	/** 
	 * @param workFlow The workFlow to set.
	 */
	public void setWorkFlow(OaWorkFlow workFlow) {
		this.workFlow = workFlow;
	}

	/** 
	 * @param workFlowId The workFlowId to set.
	 */
	public void setWorkFlowId(Long workFlowId) {
		this.workFlowId = workFlowId;
	}

	/** 
	 * @param enents The enents to set.
	 */
	public void setApplys(Set applys) {
		this.applys = applys;
	}


//	/** 
//	 * @param checcked The checcked to set.
//	 */
//	public void setChecked(Boolean checked) {
//		this.checked = checked;
//	}




	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof OaWorkFlowCheck)) {
			return false;
		}
		OaWorkFlowCheck rhs = (OaWorkFlowCheck) object;
		return new EqualsBuilder().append(this.checkIdea, rhs.checkIdea)
				.append(this.checkUserId, rhs.checkUserId).append(
						this.modifyBy, rhs.modifyBy).append(this.orders,
						rhs.orders).append(this.createBy, rhs.createBy).append(
						this.id, rhs.id).append(this.version, rhs.version)
				.append(this.workFlowType, rhs.workFlowType).append(
						this.checkState, rhs.checkState).append(this.workFlow,
						rhs.workFlow).append(this.checkUser, rhs.checkUser)
				.append(this.workFlowId, rhs.workFlowId).append(
						this.checkStateId, rhs.checkStateId).append(
						this.workFlowTypeId, rhs.workFlowTypeId).append(
						this.createDate, rhs.createDate).append(
						this.modifyDate, rhs.modifyDate).append(this.contracts,
						rhs.contracts).isEquals();
	}









	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-683043157, -1573125933).append(
				this.checkIdea).append(this.checkUserId).append(this.modifyBy)
				.append(this.orders).append(this.createBy).append(this.id)
				.append(this.version).append(this.workFlowType).append(
						this.checkState).append(this.workFlow).append(
						this.checkUser).append(this.workFlowId).append(
						this.checkStateId).append(this.workFlowTypeId).append(
						this.createDate).append(this.modifyDate).append(
						this.contracts).toHashCode();
	}









	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("workFlowType",
				this.workFlowType).append("workFlow", this.workFlow).append(
				"modifyBy", this.modifyBy).append("id", this.id).append(
				"checkUser", this.checkUser).append("modifyDate",
				this.modifyDate).append("workFlowId", this.workFlowId).append(
				"checkState", this.checkState)
				.append("createBy", this.createBy).append("workFlowTypeId",
						this.workFlowTypeId).append("version", this.version)
				.append("checkUserId", this.checkUserId).append("orders",
						this.orders).append("checkIdea", this.checkIdea)
				.append("checkStateId", this.checkStateId).append("createDate",
						this.createDate).append("contracts", this.contracts)
				.toString();
	}














}
