/****************************************************************************     
 * Created on 2007-4-11                                      *    
 *                                                               			*
 * @author <a href="mailto:hongxilin@yahoo.com.cn">hongxi</a>               *
 *         Updated by hongxi (hongxilin@yahoo.com.cn)                       *
 *                                                                          *
 * @version  Vision:1.0														*
 * 																			*
 ***************************************************************************/
package com.vriche.adrm.model;

import java.util.Date;

/**
 * OaAssetsType class
 * 
 * This class is used to 
 * 
 * <p><a href="OaAssetsType.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_oa_assets_type"
 * 
 */
public class OaAssetsType extends BaseObjectWithoutNestedFormValidation {
	

	private static final long serialVersionUID = 7864444142688624238L;

	protected Long id;
	protected String name;   	 // required
	protected Long value;    
	protected Long createBy; 	// default sysdate
	protected Date createDate;
	protected Long modifyBy; 	// default sysdate
	protected Date modifyDate;
	protected Integer version;
	
	public OaAssetsType() {};

	/**
	 * @hibernate.id column="assets_type_id" generator-class="native"
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
	 * @hibernate.property length="32" column="name" not-null="false"
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * Returns the value
	 * @return Long 
	 * 
	 * @hibernate.property length="3" column="value" not-null="false"
	 */
	public Long getValue() {
		return value;
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
	 * @param value The value to set.
	 */
	public void setValue(Long value) {
		this.value = value;
	}

	/** 
	 * @param version The version to set.
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
	/* (non-Javadoc)
	 * @see com.vriche.adrm.model.BaseObjectWithoutNestedFormValidation#toString()
	 */
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.model.BaseObjectWithoutNestedFormValidation#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.model.BaseObjectWithoutNestedFormValidation#hashCode()
	 */
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

}
