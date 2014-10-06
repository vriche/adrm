package com.vriche.adrm.model;

import java.io.Serializable;
import java.util.Date;


/**
 * ProOrder class
 * 
 * This class is used to 
 * 
 * <p><a href="ProOrder.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * 
 * @hibernate.class table="tb_pro_order"
 */

public class ProOrder extends BaseObjectWithoutNestedFormValidation implements Serializable {

	private static final long serialVersionUID = -3549740254857694L;
	protected Long id;                    //订单id
	protected String orderCode;           //订单编号
	protected String relationCode;        //关联编号
	protected String orderMeno;           //订单备注
	protected Double payMoney;            //应付款金额
	protected Integer payDate;            //应付款日期
	protected Double paidMoney;           //已付款金额
	protected Integer paidDate;           //已付款日期
	protected Double moreMoney;           //加收金额
	protected Double lessMoney;           //优惠金额
	
	protected Long programId;             //节目id
	protected Long orderTypeId;           //订单类别id
	protected Long userId;                //用户id
	protected Long customerId ;      //客户id
	
    protected Integer version;
    protected Long createBy;				  
    protected Date createDate;					  
    protected Long modifyBy;				  
    protected Date modifyDate;	
    
    protected ProOrderType proOrderType = new ProOrderType();   
    protected User user = new User(); 
    protected ProProgram program = new ProProgram();
    protected ProCustomer proCustomer = new ProCustomer();
    
    
	 /**
     * @hibernate.id column="id" generator-class="native" unsaved-value="null"
     */
	public Long getId() {
		return id;
	}
	
	
	public Long getProgramId() {
		return programId;
	}
	
	/**
     * @hibernate.many-to-one name="programId" column="program_id" cascade="all" not-null="true"
 	 */
	public ProProgram getProgram() {
		return program;
	}
	
	/**
     * @hibernate.many-to-one name="customerId" column="customer_id" cascade="all" not-null="true"
 	 */
	public ProCustomer getProCustomer() {
		return proCustomer;
	}
	
	/**
     * 
     * Returns the orderCode
     * @return String
     * 
     * @hibernate.property length="32" column="order_code" not-null="true"
     */
	public String getOrderCode() {
		return orderCode;
	}
	
	/**
     * 
     * Returns the orderMeno
     * @return String
     * 
     * @hibernate.property length="256" column="order_meno" not-null="false"
     */
	public String getOrderMeno() {
		return orderMeno;
	}
	
	/**
     * 
     * Returns the payMoney
     * @return Double
     * 
     * @hibernate.property length="20" column="pay_money" not-null="false"
     */
	public Double getPayMoney() {
		return payMoney;
	}
	
	/**
     * 
     * Returns the payDate
     * @return Integer
     * 
     * @hibernate.property length="12" column="pay_date" not-null="false"
     */
	public Integer getPayDate() {
		return payDate;
	}
	
	/**
     * 
     * Returns the paidMoney
     * @return Double
     * 
     * @hibernate.property length="20" column="paid_money" not-null="false"
     */
	public Double getPaidMoney() {
		return paidMoney;
	}
	
	/**
     * 
     * Returns the paidDate
     * @return Integer
     * 
     * @hibernate.property length="12" column="paid_date" not-null="false"
     */
	public Integer getPaidDate() {
		return paidDate;
	}

	/**
     * 
     * Returns the lessMoney
     * @return Double
     * 
     * @hibernate.property length="20" column="less_money" not-null="false"
     */
	public Double getLessMoney() {
		return lessMoney;
	}
	
	/**
     * 
     * Returns the moreMoney
     * @return Double
     * 
     * @hibernate.property length="20" column="more_money" not-null="false"
     */
	public Double getMoreMoney() {
		return moreMoney;
	}

	public Long getOrderTypeId() {
		return orderTypeId;
	}
	
	/**
     * @hibernate.many-to-one name="orderTypeId" column="order_type_id" cascade="all" not-null="true"
 	 */
	public ProOrderType getProOrderType() {
		return proOrderType;
	}
	
	/**
     * 
     * Returns the relationCode
     * @return String
     * 
     * @hibernate.property length="32" column="relation_code" not-null="false"
     */
	public String getRelationCode() {
		return relationCode;
	}
	
	/**
     * @hibernate.many-to-one name="userId" column="user_id" cascade="all" not-null="true"
 	 */
	public User getUser() {
		return user;
	}
	
	public Long getCustomerId() {
		return customerId;
	}
	
	public Long getUserId() {
		return userId;
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
	 * @param id The id to set.
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @param programId The programId to set.
	 */
	public void setProgramId(Long programId) {
		this.programId = programId;
	}
	
	/**
	 * @param program The program to set.
	 */
	public void setProgram(ProProgram program) {
		this.program = program;
	}
	
	/**
	 * @param proCustomer The proCustomer to set.
	 */
	public void setProCustomer(ProCustomer proCustomer) {
		this.proCustomer = proCustomer;
	}
    
	
	/**
	 * @param orderCode The orderCode to set.
	 */
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	
	/**
	 * @param orderMeno The orderMeno to set.
	 */
	public void setOrderMeno(String orderMeno) {
		this.orderMeno = orderMeno;
	}
	
	/**
	 * @param payMoney The payMoney to set.
	 */
	public void setPayMoney(Double payMoney) {
		this.payMoney = payMoney;
	}

	/**
	 * @param payDate The payDate to set.
	 */
	public void setPayDate(Integer payDate) {
		this.payDate = payDate;
	}
	
	/**
	 * @param paidMoney The paidMoney to set.
	 */
	public void setPaidMoney(Double paidMoney) {
		this.paidMoney = paidMoney;
	}

	/**
	 * @param paidDate The paidDate to set.
	 */
	public void setPaidDate(Integer paidDate) {
		this.paidDate = paidDate;
	}

	/**
	 * @param lessMoney The lessMoney to set.
	 */
	public void setLessMoney(Double lessMoney) {
		this.lessMoney = lessMoney;
	}

	/**
	 * @param moreMoney The moreMoney to set.
	 */
	public void setMoreMoney(Double moreMoney) {
		this.moreMoney = moreMoney;
	}
	
	/**
	 * @param orderTypeId The orderTypeId to set.
	 */
	public void setOrderTypeId(Long orderTypeId) {
		this.orderTypeId = orderTypeId;
	}
	
	/**
	 * @param proOrderType The proOrderType to set.
	 */
	public void setProOrderType(ProOrderType proOrderType) {
		this.proOrderType = proOrderType;
	}
	
	/**
	 * @param relationCode The relationCode to set.
	 */
	public void setRelationCode(String relationCode) {
		this.relationCode = relationCode;
	}
	
	/**
	 * @param user The user to set.
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	/**
	 * @param userId The userId to set.
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	/**
	 * @param customerId The customerId to set.
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
	/**
	 * @param version The version to set.
	 */
	public void setVersion(Integer version) {
		this.version = version;
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