package com.vriche.adrm.model;

import java.io.Serializable;
import java.util.Date;


/**
 * ProCustomer class
 * 
 * This class is used to 
 * 
 * <p><a href="ProCustomer.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * 
 * @hibernate.class table="tb_pro_customer"
 */

public class ProCustomer extends BaseObjectWithoutNestedFormValidation implements Serializable {
	

	private static final long serialVersionUID = 5333527663844428353L;
	protected Long id; 
    protected String customerName; 		//客户名称
    protected String helpCode;     		//助记码
	protected Long typeId;			//客户类型
    protected String telephone;     	//联系电话  
    protected String fax;				//传真
    protected String linkmanName;    	//联系人
    protected String accountAddress;    //公司地址
	
    protected Integer version;
    protected Long createBy;				  
    protected Date createDate;					  
    protected Long modifyBy;				  
    protected Date modifyDate;	
    
    protected ProCustomerType proCustomerType = new ProCustomerType();
    
    /**
     * @hibernate.id column="id" generator-class="native" unsaved-value="null"
     */
    public Long getId() {
        return id;
    }
    
    /**
     * 
     * Returns the customerName
     * @return String
     * 
     * @hibernate.property length="30" column="customer_name" not-null="false"
     */
	public String getCustomerName() {
		return customerName;
	}
	
	 /**
     * @hibernate.version length="10"  column="version"
     */
    public Integer getVersion() {
        return version;
    }
    
    
    
	/**
     * @hibernate.many-to-one name="typeId"  column="customer_type_id" cascade="all" not-null="true"
 	 */
	public ProCustomerType getProCustomerType() {
		return proCustomerType;
	}

    
    
    /**
     * 
     * Returns the createBy
     * @return Long
     * 
     * @hibernate.property length="10" column="create_by" not-null="false"
     */
    public Long getCreateBy() {
        return createBy;
    }
    /**
     * 
     * Returns the createDate
     * @return Date
     * 
     * @hibernate.property length="12"  column="create_date" update="false" insert="true" type="timestamp"
     */
    
    public Date getCreateDate() {
        return createDate;
    }
    /**
     * 
     * Returns the modifyBy
     * @return Long
     * 
     * @hibernate.property length="10" column="modify_by" not-null="false"
     */
    public Long getModifyBy() {
        return modifyBy;
    }
    /**
     * 
     * Returns the modifyDate
     * @return Date
     * 
    * @hibernate.property  length="12"  column="modify_date" update="false" insert="true" type="timestamp"
     */
    public Date getModifyDate() {
        return modifyDate;
    } 

    /**
     * 
     * Returns the accountAddress
     * @return String
     * 
    * @hibernate.property  length="50" column="account_address" 
     */
	public String getAccountAddress() {
		return accountAddress;
	}
	 /**
     * 
     * Returns the fax
     * @return String
     * 
    * @hibernate.property length="15" column="fax" 
     */
	public String getFax() {
		return fax;
	}
	 /**
     * 
     * Returns the helpCode
     * @return String
     * 
    * @hibernate.property length="30"  column="help_code" 
     */
	public String getHelpCode() {
		return helpCode;
	}
	 /**
     * 
     * Returns the linkmanName
     * @return String
     * 
    * @hibernate.property length="10" column="linkman_name" 
     */
	public String getLinkmanName() {
		return linkmanName;
	}
	/**
     * 
     * Returns the telephone
     * @return String
     * 
    * @hibernate.property length="15"  column="telephone" 
     */
	public String getTelephone() {
		return telephone;
	}
	
	/**
     * 
     * Returns the telephone
     * @return String
     * 
    * @hibernate.property length="15"  column="tb_customer_id" 
     */
	public Long getTypeId() {
		return typeId;
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
	 * @param customerName The customerName to set.
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @param proCustomerType The proCustomerType to set.
	 */
	public void setProCustomerType(ProCustomerType proCustomerType) {
		this.proCustomerType = proCustomerType;
	}

	/**
	 * @param typeId The typeId to set.
	 */
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	/**
	 * @param accountAddress The accountAddress to set.
	 */
	public void setAccountAddress(String accountAddress) {
		this.accountAddress = accountAddress;
	}

	/**
	 * @param fax The fax to set.
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}

	/**
	 * @param helpCode The helpCode to set.
	 */
	public void setHelpCode(String helpCode) {
		this.helpCode = helpCode;
	}

	/**
	 * @param linkmanName The linkmanName to set.
	 */
	public void setLinkmanName(String linkmanName) {
		this.linkmanName = linkmanName;
	}

	/**
	 * @param telephone The telephone to set.
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
