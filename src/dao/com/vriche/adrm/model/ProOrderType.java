package com.vriche.adrm.model;

import java.io.Serializable;
import java.util.Date;

/**
 * ProOrderType class
 * 
 * This class is used to 
 * 
 * <p><a href="ProOrderType.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * 
 * @hibernate.class table="tb_pro_order_type"
 */

public class ProOrderType extends BaseObjectWithoutNestedFormValidation implements Serializable {

	private static final long serialVersionUID = -6106601998667465426L;
	protected Long id;
	protected String name;
	protected String value;
	
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
     * Returns the name
     * @return String
     * 
     * @hibernate.property length="20" column="name" not-null="false"
     */
	public String getName() {
		return name;
	}
	
    /**
     * 
     * Returns the value
     * @return String
     * 
     * @hibernate.property length="20" column="value" not-null="false"
     */
	public String getValue() {
		return value;
	}
	
	
	
	
    
    /**
     * @hibernate.version column="version"
     */
    public Integer getVersion() {
        return version;
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
	public void setValue(String value) {
		this.value = value;
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
