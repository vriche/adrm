/**
 * 
 */
package com.vriche.adrm.model;

import java.io.Serializable;
import java.util.Date;

/**
 * ProProgramType class
 * 
 * This class is used to 
 * 
 * <p><a href="ProProgramType.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * 
 * @hibernate.class table="tb_pro_program_type"
 */
public class ProProgramType extends BaseObjectWithoutNestedFormValidation
		implements Serializable {
	
	private static final long serialVersionUID = 1L;
	protected Long id ;                //节目类别id 
	protected String name ;            //节目类别名称
	
    protected String parentId;
    protected Integer treeLevel;
    protected Integer displayNo;
    
	protected Integer version;
    protected Long createBy;				  
    protected Date createDate;					  
    protected Long modifyBy;				  
    protected Date modifyDate;
    
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
     * @return Date
     * 
    * @hibernate.property column="modify_date" update="false" insert="true" type="timestamp"
     */
	public Date getModifyDate() {
		return modifyDate;
	}

	/**
     * 
     * Returns the name
     * @return String
     * 
     * @hibernate.property length="10" column="name" not-null="false"
     */
	public String getName() {
		return name;
	}

	 /**
     * @hibernate.version column="version"
     */
	public Integer getVersion() {
		return version;
	}

	/**
     * 
     * Returns the displayNo
     * @return Integer
     * 
     * @hibernate.property length="16" column="display_no" not-null="true"
     */
	public Integer getDisplayNo() {
		return displayNo;
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
     * Returns the treeLevel
     * @return Integer
     * 
     * @hibernate.property length="5" column="tree_level" not-null="false"
     */
	public Integer getTreeLevel() {
		return treeLevel;
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
	 * @param displayNo The displayNo to set.
	 */
	public void setDisplayNo(Integer displayNo) {
		this.displayNo = displayNo;
	}

	/**
	 * @param parentId The parentId to set.
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
	/**
	 * @param treeLevel The treeLevel to set.
	 */
	public void setTreeLevel(Integer treeLevel) {
		this.treeLevel = treeLevel;
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

}
