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

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * OaWorkFlowType class
 * 
 * This class is used to 
 * 
 * <p><a href="OaWorkFlowType.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_oa_work_flow_type"
 * 
 */
public class OaWorkFlowType extends BaseObjectWithoutNestedFormValidation {
	

	private static final long serialVersionUID = 1L;

	protected Long id;	
	protected String name;    	// required 	
	protected Long parentId;	
	protected Long nodeLevel;	
	protected Long displayNo;
	
	protected Long createBy; 	// default sysdate
	protected Date createDate;
	protected Long modifyBy; 	// default sysdate
	protected Date modifyDate;
	protected Integer version;
	
	
	
	public OaWorkFlowType() {};
	
	
	
	/**
	 * 
	 * Returns the id
	 * @return Long
	 * 
	 * @hibernate.id column="work_flow_type_id" generator-class="native" unsaved-value="null"
	 */
	public Long getId() {
		return id;
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
	 * @return Long
	 * 
	 * @hibernate.property length="32" column="parent_id" not-null="false"
	 */
	public Long getParentId() {
		return parentId;
	}
	/**
	 * 
	 * Returns the name
	 * @return String 
	 * @struts.validator type="required"
	 * @hibernate.property length="32" column="name" not-null="false"
	 */
	public String getName() {
		return name;
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
	 * @param displayno The displayno to set.
	 */
	public void setDisplayNo(Long displayNo) {
		this.displayNo = displayNo;
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
	 * @param nodelevel The nodelevel to set.
	 */
	public void setNodeLevel(Long nodeLevel) {
		this.nodeLevel = nodeLevel;
	}



	/**
	 * @param parentid The parentid to set.
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}



	/**
	 * @param version The version to set.
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}



	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof OaWorkFlowType)) {
			return false;
		}
		OaWorkFlowType rhs = (OaWorkFlowType) object;
		return new EqualsBuilder().append(
				this.parentId, rhs.parentId)
				.append(this.modifyBy, rhs.modifyBy).append(this.modifyDate,
						rhs.modifyDate).append(this.createDate, rhs.createDate)
				.append(this.nodeLevel, rhs.nodeLevel).append(this.createBy,
						rhs.createBy).append(this.name, rhs.name).append(
						this.id, rhs.id).append(this.version, rhs.version)
				.append(this.displayNo, rhs.displayNo).isEquals();
	}



	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("nodeLevel", this.nodeLevel)
				.append("name", this.name).append("modifyBy", this.modifyBy)
				.append("id", this.id).append("version", this.version).append(
						"modifyDate", this.modifyDate).append("parentId",
						this.parentId).append("displayNo", this.displayNo)
				.append("createBy", this.createBy).append("createDate",
						this.createDate).toString();
	}



	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(1284759049, 306899387).append(this.parentId).append(this.modifyBy)
				.append(this.modifyDate).append(this.createDate).append(
						this.nodeLevel).append(this.createBy).append(this.name)
				.append(this.id).append(this.version).append(this.displayNo)
				.toHashCode();
	}







}
