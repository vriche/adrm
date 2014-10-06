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
import java.util.HashMap;
//import java.util.LinkedHashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * OaWorkFlow class
 * 
 * This class is used to 
 * 
 * <p><a href="OaWorkFlow.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_oa_work_flow"
 * 
 */
public class OaWorkFlow extends BaseObject {

	private static final long serialVersionUID = 1L;
	protected Long id;	
	protected String name;     		// required 
	protected Long workFlowTypeId;  // required 
//	protected Long checkResultId;
//	protected Long isFlowLeve;
	protected Long createBy; 	// default sysdate
	protected Date createDate;
	protected Long modifyBy; 	// default sysdate
	protected Date modifyDate;
	
	protected Long 	 workFlowMoveTypeId; 
	protected String parentId;    
	protected Long	 nodeLevel;    
	protected Long 	 displayNo;   
	protected Long 	 agreeFlowId;   
	protected Long 	 dissentFlowId;   
	protected Boolean isFirstPoint;  
	protected Boolean isEndPoint;  
	
	
	protected OaWorkFlowType workFlowType = new OaWorkFlowType();
	protected OaWorkFlowMoveType workFlowMoveType = new OaWorkFlowMoveType();
//	protected OaWorkFlowCheckResult checkResult = new OaWorkFlowCheckResult();
//	protected OaWorkFlowCheckState checkState = new OaWorkFlowCheckState();
	

	protected Set cominUsers = new HashSet();
	protected Set checkUsers = new HashSet();
	protected Set checkRoles = new HashSet();
	protected Map workFlowsMap = new HashMap();
	
	
	protected Integer version;




	
	/**
	 * 
	 * Returns the id
	 * @return Long
	 * 
	 * @hibernate.id column="work_flow_id" generator-class="native" unsaved-value="null"
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 
	 * Returns the name
	 * @return String 
	 * @struts.validator type="required"
	 * @hibernate.property length="20" column="name" not-null="false"
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * Returns the displayNo
	 * @return Long 
	 * 
	 * @hibernate.property length="16" column="display_no" not-null="false"
	 */
	public Long getDisplayNo() {
		return displayNo;
	}

	/**
	 * 
	 * Returns the nodeLevel
	 * @return Long 
	 * 
	 * @hibernate.property length="5" column="node_level" not-null="false"
	 */
	public Long getNodeLevel() {
		return nodeLevel;
	}

	/**
	 * 
	 * Returns the parentId
	 * @return String 
	 * 
	 * @hibernate.property length="32" column="parent_id" not-null="false"
	 */
	public String getParentId() {
		return parentId;
	}
	


	/**
	 * 
	 * Returns the agreeFlowId
	 * @return Long 
	 * 
	 * @hibernate.property length="20" column="agree_flow_id" not-null="false"
	 */
	public Long getAgreeFlowId() {
		return agreeFlowId;
	}
	/**
	 * 
	 * Returns the dissentFlowId
	 * @return Long 
	 * 
	 * @hibernate.property length="20" column="dissent_flow_id" not-null="false"
	 */
	public Long getDissentFlowId() {
		return dissentFlowId;
	}
	/**
	 * 
	 * Returns the isEndPoint
	 * @return Boolean 
	 * 
	 * @hibernate.property column="is_first_point" not-null="false"  type="yes_no"
	 */
	public Boolean getIsEndPoint() {
		return isEndPoint;
	}
	/**
	 * 
	 * Returns the isFirstPoint
	 * @return Boolean 
	 * 
	 * @hibernate.property column="is_end_point" not-null="false"  type="yes_no" 
	 */
	public Boolean getIsFirstPoint() {
		return isFirstPoint;
	}
	

	/**
	 * 
	 * Returns the workFlowMoveType
	 * @return OaWorkFlowMoveType 
	 */
	public OaWorkFlowMoveType getWorkFlowMoveType() {
		return workFlowMoveType;
	}
	/**
	 * 
	 * Returns the workFlowMoveTypeId
	 * @return Long 
	 * 
	 * @hibernate.property length="20" column="move_type_id" not-null="false"
	 */
	public Long getWorkFlowMoveTypeId() {
		return workFlowMoveTypeId; 
	}
	/**
	 * 
	 * Returns the workFlowTypeId
	 * @return Long
	 * @struts.validator type="required"
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
	 * 
	 * Returns the workFlowType
	 * @return OaWorkFlowType 
	 */
	public OaWorkFlowType getWorkFlowType() {
		return workFlowType;
	}
	
	 /**
    * @hibernate.set  name="cominUsers" table="tb_oa_work_flow_comin_user" cascade="save-update" lazy="false"
    * @hibernate.collection-key column="work_flow_id"
    * @hibernate.collection-many-to-many class="com.vriche.adrm.model.User" column="user_id"
    */
	public Set getCominUsers() {
		return cominUsers;
	}
	
	
	 /**
	    * @hibernate.set  name="checkUsers" table="tb_oa_work_flow_check_user" cascade="save-update" lazy="false"
	    * @hibernate.collection-key column="work_flow_id"
	    * @hibernate.collection-many-to-many class="com.vriche.adrm.model.User" column="user_id"
	    */
		public Set getCheckUsers() {
			return checkUsers;
		}
	
	/**
	 * 
    * @hibernate.set  name="roles" table="tb_oa_work_flow_check_role" cascade="save-update" lazy="false"
    * @hibernate.collection-key column="work_flow_id"
    * @hibernate.collection-many-to-many class="com.vriche.adrm.model.Role" column="role_id"
	 */
	public Set getCheckRoles() {
		return checkRoles;
	}	
	/**
	 * 
	 * Returns the workFlowsMap
	 * @return Map 
	 * 
	 */
	public Map getWorkFlowsMap() {
//		workFlowsMap.put(this.getId(),this.getName());
		return workFlowsMap;
	}
	
	

	/** 
	 * @param workFlowMoveType The workFlowMoveType to set.
	 */
	public void setWorkFlowMoveType(OaWorkFlowMoveType workFlowMoveType) {
		this.workFlowMoveType = workFlowMoveType;
	}
	/** 
	 * @param workFlowMoveTypeId The workFlowMoveTypeId to set.
	 */
	public void setWorkFlowMoveTypeId(Long workFlowMoveTypeId) {
		this.workFlowMoveTypeId = workFlowMoveTypeId;
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
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @param agreeFlowId The agreeFlowId to set.
	 */
	public void setAgreeFlowId(Long agreeFlowId) {
		this.agreeFlowId = agreeFlowId;
	}
	/** 
	 * @param displayNo The displayNo to set.
	 */
	public void setDisplayNo(Long displayNo) {
		this.displayNo = displayNo;
	}
	/** 
	 * @param dissentFlowId The dissentFlowId to set.
	 */
	public void setDissentFlowId(Long dissentFlowId) {
		this.dissentFlowId = dissentFlowId;
	}
	/** 
	 * @param isEndPoint The isEndPoint to set.
	 */
	public void setIsEndPoint(Boolean isEndPoint) {
		this.isEndPoint = isEndPoint;
	}
	/** 
	 * @param isFirstPoint The isFirstPoint to set.
	 */
	public void setIsFirstPoint(Boolean isFirstPoint) {
		this.isFirstPoint = isFirstPoint;
	}
	/** 
	 * @param nodeLevel The nodeLevel to set.
	 */
	public void setNodeLevel(Long nodeLevel) {
		this.nodeLevel = nodeLevel;
	}
	/** 
	 * @param parentId The parentId to set.
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
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
	 * @param checkUsers The checkUsers to set.
	 */
	public void setCheckUsers(Set checkUsers) {
		this.checkUsers = checkUsers;
	}
	/** 
	 * @param cominUsers The cominUsers to set.
	 */
	public void setCominUsers(Set cominUsers) {
		this.cominUsers = cominUsers;
	}

	/** 
	 * @param checkRoles The checkRoles to set.
	 */
	public void setCheckRoles(Set checkRoles) {
		this.checkRoles = checkRoles;
	}

	/** 
	 * @param workFlowsMap The workFlowsMap to set.
	 */
	public void setWorkFlowsMap(Map workFlowsMap) {
		this.workFlowsMap = workFlowsMap;
	}
	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof OaWorkFlow)) {
			return false;
		}
		OaWorkFlow rhs = (OaWorkFlow) object;
		return new EqualsBuilder().append(this.parentId, rhs.parentId).append(
				this.workFlowMoveType, rhs.workFlowMoveType).append(
				this.modifyBy, rhs.modifyBy).append(this.isFirstPoint,
				rhs.isFirstPoint).append(this.checkRoles, rhs.checkRoles)
				.append(this.nodeLevel, rhs.nodeLevel).append(this.cominUsers,
						rhs.cominUsers).append(this.createBy, rhs.createBy)
				.append(this.id, rhs.id)
				.append(this.isEndPoint, rhs.isEndPoint).append(this.version,
						rhs.version).append(this.displayNo, rhs.displayNo)
				.append(this.agreeFlowId, rhs.agreeFlowId).append(
						this.workFlowType, rhs.workFlowType).append(
						this.checkUsers, rhs.checkUsers).append(
						this.dissentFlowId, rhs.dissentFlowId).append(
						this.workFlowTypeId, rhs.workFlowTypeId).append(
						this.createDate, rhs.createDate).append(
						this.modifyDate, rhs.modifyDate).append(this.name,
						rhs.name).append(this.workFlowMoveTypeId,
						rhs.workFlowMoveTypeId).isEquals();
	}
	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(271330315, -199462661).append(this.parentId)
				.append(this.workFlowMoveType).append(this.modifyBy).append(
						this.isFirstPoint).append(this.checkRoles).append(
						this.nodeLevel).append(this.cominUsers).append(
						this.createBy).append(this.id).append(this.isEndPoint)
				.append(this.version).append(this.displayNo).append(
						this.agreeFlowId).append(this.workFlowType).append(
						this.checkUsers).append(this.dissentFlowId).append(
						this.workFlowTypeId).append(this.createDate).append(
						this.modifyDate).append(this.name).append(
						this.workFlowMoveTypeId).toHashCode();
	}
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("cominUsers", this.cominUsers)
				.append("workFlowType", this.workFlowType).append("nodeLevel",
						this.nodeLevel).append("isFirstPoint",
						this.isFirstPoint).append("modifyBy", this.modifyBy)
				.append("id", this.id).append("modifyDate", this.modifyDate)
				.append("parentId", this.parentId).append("checkRoles",
						this.checkRoles).append("workFlowMoveType",
						this.workFlowMoveType).append("workFlowMoveTypeId",
						this.workFlowMoveTypeId).append("displayNo",
						this.displayNo).append("checkUsers", this.checkUsers)
				.append("createBy", this.createBy).append("dissentFlowId",
						this.dissentFlowId).append("workFlowTypeId",
						this.workFlowTypeId).append("name", this.name).append(
						"version", this.version).append("agreeFlowId",
						this.agreeFlowId).append("createDate", this.createDate)
				.append("isEndPoint", this.isEndPoint).toString();
	}



}
