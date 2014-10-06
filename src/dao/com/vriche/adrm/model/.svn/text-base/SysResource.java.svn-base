/****************************************************************************     
 * Created on 2007-5-3                                      *    
 *                                                               			*
 * @author <a href="mailto:hongxilin@yahoo.com.cn">hongxi</a>               *
 *         Updated by hongxi (hongxilin@yahoo.com.cn)                       *
 *                                                                          *
 * @version  Vision:1.0														*
 * 																			*
 ***************************************************************************/
package com.vriche.adrm.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SysResource class
 * 
 * This class is used to 
 * 
 * <p><a href="SysResource.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_sys_resource"
 * 
 */
public class SysResource extends BaseObject implements Serializable{

	private static final long serialVersionUID = 5695094109257273613L;

	private Long id;
	private String name;
	private String resType;
	private String resString;
	private String memo;
	private Boolean authorized;
	
	protected Long createBy; // default sysdate
	protected Date createDate;
	protected Long modifyBy; // default sysdate
	protected Date modifyDate;
	protected Integer version;
	
	
	
	private Set roles = new HashSet();
	
	
	public SysResource() {};

	/**
	 * @hibernate.id column="id" generator-class="native"
	 *               unsaved-value="null"
	 */
	public Long getId() {
		return id;
	}
	

	/**
	 * 
	 * Returns the name
	 * @return String 
	 * @struts.validator type="required"
	 * @hibernate.property length="128" column="name" not-null="false"
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * Returns the resType
	 * @return String 
	 * 
	 * @hibernate.property length="128" column="res_type" not-null="false"
	 */
	public String getResType() {
		return resType;
	}


	/**
	 * 
	 * Returns the resString
	 * @return String 
	 * 
	 * @hibernate.property length="256" column="res_string" not-null="false"
	 */
	public String getResString() {
		return resString;
	}



	/**
	 * 
	 * Returns the descn
	 * @return String 
	 * 
	 * @hibernate.property length="256" column="memo" not-null="false"
	 */
	public String getMemo() {
		return memo;
	}



    /**
     * @hibernate.set table="tb_sys_resource_role" cascade="save-update" lazy="false"
     * @hibernate.collection-key column="resource_id"
     * @hibernate.collection-many-to-many class="com.vriche.adrm.model.Role" column="role_id"
     */
	public Set getRoles() {
		return roles;
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
	

	public Boolean getAuthorized() {
		return authorized;
	}
	

	/**
	 * @hibernate.version
	 */
	public Integer getVersion() {
		return version;
	}	
	
	
	
	

	
		

	/** 
	 * @param authorized The authorized to set.
	 */
	public void setAuthorized(Boolean authorized) {
		this.authorized = authorized;
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
	 * @param memo The memo to set.
	 */
	public void setMemo(String memo) {
		this.memo = memo;
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
	 * @param resString The resString to set.
	 */
	public void setResString(String resString) {
		this.resString = resString;
	}

	/** 
	 * @param resType The resType to set.
	 */
	public void setResType(String resType) {
		this.resType = resType;
	}

	/** 
	 * @param roles The roles to set.
	 */
	public void setRoles(Set roles) {
		this.roles = roles;
	}

	/** 
	 * @param version The version to set.
	 */
	public void setVersion(Integer version) {
		this.version = version;
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
