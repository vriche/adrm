package com.vriche.adrm.model;

import java.io.Serializable;
import java.util.Date;

/**
 * ForetArrearage class
 * 
 * This class is used to
 * 
 * <p>
 * <a href="ForetArrearage.java.html"> <i>View Source </i> </a>
 * </p>
 * 
 * @struts.form include-all="true" extends="BaseForm"
 * @hibernate.class table="tb_foret_arrearage"
 *  
 */
public class ForetArrearage extends BaseObject  implements Serializable{
  
	protected Long id;
    protected String customerName; //客户名称 required;
    protected Integer payDate;     //应付日期 required; 
    protected Integer incomeDate;  //到款日期 required; 
    protected Double payMoney;     //应付金额
    protected String incomeCode;   //进款编号 
    protected Double incomeMoney;  //已付金额
    protected String incomeMode;   //到款方式
    protected String incomePurpose;//到款用途
    protected String userName;     //催款人
    protected String memo;         //备注
    
 
    protected Long createBy; //default sysdate
    protected Date createDate;
    protected Long modifyBy; //default sysdate
    protected Date modifyDate;
    protected Integer version;


    protected String startDate; //开始日期
    protected String endDate;	//结束日期
    
    protected String month[];
    protected Integer year;
    
    public ForetArrearage() {};
    /**
     * @hibernate.id column="fa_id" generator-class="native"
     *               unsaved-value="null"
     */
    public Long getId() {
        return id;
    }
    
    
    
    

    /**
     * 
     * Returns the customerName
     * 
     * @return String
     * @struts.validator type="required"
     * @hibernate.property length="128" column="customer_name" not-null="true" 
     */
	public String getCustomerName() {
		return customerName;
	}





    /**
     * 
     * Returns the incomeCode
     * 
     * @return String
     * @hibernate.property length="32" column="income_code" not-null="true" unique="true"
     */
	public String getIncomeCode() {
		return incomeCode;
	}





    /**
     * 
     * Returns the incomeDate
     * 
     * @return Integer
     * @struts.validator type="required"
     * @hibernate.property length="8" column="income_date" not-null="true"
     */
	public Integer getIncomeDate() {
		return incomeDate;
	}





    /**
     * 
     * Returns the incomeMode
     * 
     * @return String
     * @hibernate.property length="32" column="income_mode" not-null="true"
     */
	public String getIncomeMode() {
		return incomeMode;
	}





    /**
     * 
     * Returns the incomeMoney
     * 
     * @return java.lang.Double
     * 
     * @hibernate.property length="12" column="income_money" not-null="true"
     */
	public Double getIncomeMoney() {
		return incomeMoney;
	}





    /**
     * 
     * Returns the incomePurpose
     * 
     * @return String
     * @hibernate.property length="32" column="income_purpose" not-null="true"
     */
	public String getIncomePurpose() {
		return incomePurpose;
	}





    /**
     * 
     * Returns the incomePurpose
     * 
     * @return String
     * @hibernate.property length="255" column="memo" not-null="false"
     */
	public String getMemo() {
		return memo;
	}





    /**
     * 
     * Returns the payDate
     * 
     * @return Integer
     * @struts.validator type="required"
     * @hibernate.property length="8" column="pay_date" not-null="true"
     */
	public Integer getPayDate() {
		return payDate;
	}





    /**
     * 
     * Returns the payMoney
     * 
     * @return java.lang.Double
     * 
     * @hibernate.property length="12" column="pay_money" not-null="true"
     */
	public Double getPayMoney() {
		return payMoney;
	}





    /**
     * 
     * Returns the userName
     * 
     * @return String
     * @hibernate.property length="32" column="user_name" not-null="true"
     */
	public String getUserName() {
		return userName;
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
	 * @return Returns the endDate.
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * @return Returns the startDate.
	 */
	public String getStartDate() {
		return startDate;
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
	 * @param customerName The customerName to set.
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}





	/**
	 * @param endDate The endDate to set.
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}





	/**
	 * @param id The id to set.
	 */
	public void setId(Long id) {
		this.id = id;
	}





	/**
	 * @param incomeCode The incomeCode to set.
	 */
	public void setIncomeCode(String incomeCode) {
		this.incomeCode = incomeCode;
	}





	/**
	 * @param incomeDate The incomeDate to set.
	 */
	public void setIncomeDate(Integer incomeDate) {
		this.incomeDate = incomeDate;
	}





	/**
	 * @param incomeMode The incomeMode to set.
	 */
	public void setIncomeMode(String incomeMode) {
		this.incomeMode = incomeMode;
	}





	/**
	 * @param incomeMoney The incomeMoney to set.
	 */
	public void setIncomeMoney(Double incomeMoney) {
		this.incomeMoney = incomeMoney;
	}





	/**
	 * @param incomePurpose The incomePurpose to set.
	 */
	public void setIncomePurpose(String incomePurpose) {
		this.incomePurpose = incomePurpose;
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
	 * @param payDate The payDate to set.
	 */
	public void setPayDate(Integer payDate) {
		this.payDate = payDate;
	}





	/**
	 * @param payMoney The payMoney to set.
	 */
	public void setPayMoney(Double payMoney) {
		this.payMoney = payMoney;
	}





	/**
	 * @param startDate The startDate to set.
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}





	/**
	 * @param userName The userName to set.
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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
	public String[] getMonth() {
		return month;
	}
	public void setMonth(String[] month) {
		this.month = month;
	}
	/**
	 * @return Returns the year.
	 */
	public Integer getYear() {
		return year;
	}
	/**
	 * @param year The year to set.
	 */
	public void setYear(Integer year) {
		this.year = year;
	}

}
