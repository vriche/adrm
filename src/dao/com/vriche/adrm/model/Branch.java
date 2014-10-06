package com.vriche.adrm.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * Branch class
 * 
 * This class is used to 
 * 
 * <p><a href="Branch.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_sys_branch"
 * 
 */
public class Branch extends BaseObject {
	
	private static final long serialVersionUID = 1L;
	protected Long id;
    protected String name; 					 // required
	protected Long orgId;

    protected String parentId;
    protected Integer treeLevel;
    protected Integer displayNo;
    
    protected Long createBy;				  //default sysdate
    protected Date createDate;					  
    protected Long modifyBy;				  //default sysdate
    protected Date modifyDate;					  
    protected Integer version;	
    
	protected Org org = new Org();
	protected Set users = new HashSet();  
	
	
    public Branch() {};
	
    /**
     * @hibernate.id column="sys_branch_id" generator-class="native" unsaved-value="null"
     */
	public Long getId() {
		return id;
	}

	/**
	 * 
	 * Returns the name
	 * @return String 
     * @struts.validator type="required"
	 * @hibernate.property length="32" column="name" not-null="true"
	 */
	public String getName() {
		return name;
	}	
	/**
	 * 
	 * Returns the orgId
	 * @return Long 
	 * 
	 * @hibernate.property length="20" column="sys_org_id" not-null="false"
	 */
	public Long getOrgId() {
		return orgId;
	}

	
	/**
	 * 
	 * Returns the org
	 * @return BaseObjectWithoutNestedFormValidation 
	 */
	public Org getOrg() {
		return org;
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
    * @hibernate.version
    */
   public Integer getVersion() {
       return version;
   }	
   
   
	 /**
    * @hibernate.set table="tb_sys_user_branch" cascade="save-update" lazy="false"
    * @hibernate.collection-key column="branch_id"
    * @hibernate.collection-many-to-many class="com.vriche.adrm.model.User" column="user_id"
    */
	public Set getUsers() {
		return users;
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
	 * @param displayNo The displayNo to set.
	 */
	public void setDisplayNo(Integer displayNo) {
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
	 * @param org The org to set.
	 */
	public void setOrg(Org org) {
		this.org = org;
	}

	/** 
	 * @param orgId The orgId to set.
	 */
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
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

	/** 
	 * @param version The version to set.
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
	

	/** 
	 * @param users The users to set.
	 */
	public void setUsers(Set users) {
		this.users = users;
	}	
	
	

	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("orgId", this.orgId).append(
				"createBy", this.createBy).append("treeLevel", this.treeLevel)
				.append("createDate", this.createDate).append("modifyDate",
						this.modifyDate).append("org", this.org).append(
						"parentId", this.parentId).append("modifyBy",
						this.modifyBy).append("version", this.version).append(
						"name", this.name).append("displayNo", this.displayNo)
				.append("users", this.users).append("id", this.id).toString();
	}




}
