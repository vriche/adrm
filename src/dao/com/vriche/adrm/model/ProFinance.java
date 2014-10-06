package com.vriche.adrm.model;

import java.io.Serializable;
import java.util.Date;


/**
 * ProFinance class
 * 
 * This class is used to 
 * 
 * <p><a href="ProFinance.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * 
 * @hibernate.class table="tb_pro_finance"
 */

public class ProFinance extends BaseObjectWithoutNestedFormValidation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -939738712855633166L;
	
	protected Long id;                    //到款id
	protected Long orderId;               //订单id
	protected Double payMoney;            //应付金额
	protected Integer payDate;            //应付日期
	protected Double paidMoney;           //到款金额
	protected Integer paidDate;           //到款日期
	protected Long incomeModeId;          //到款类型id
	protected Long incomePurposeId ;      //到款用途id
	
    protected Integer version;
    protected Long createBy;				  
    protected Date createDate;					  
    protected Long modifyBy;				  
    protected Date modifyDate;
    
    protected IncomeMode incomeMode = new IncomeMode();
    protected IncomePurpose incomePurpose = new IncomePurpose();
    
	public Long getCreateBy() {
		return createBy;
	}
	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIncomeModeId() {
		return incomeModeId;
	}
	public void setIncomeModeId(Long incomeModeId) {
		this.incomeModeId = incomeModeId;
	}
	public Long getIncomePurposeId() {
		return incomePurposeId;
	}
	public void setIncomePurposeId(Long incomePurposeId) {
		this.incomePurposeId = incomePurposeId;
	}
	public Long getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(Long modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Integer getPaidDate() {
		return paidDate;
	}
	public void setPaidDate(Integer paidDate) {
		this.paidDate = paidDate;
	}
	public Double getPaidMoney() {
		return paidMoney;
	}
	public void setPaidMoney(Double paidMoney) {
		this.paidMoney = paidMoney;
	}
	public Integer getPayDate() {
		return payDate;
	}
	public void setPayDate(Integer payDate) {
		this.payDate = payDate;
	}
	public Double getPayMoney() {
		return payMoney;
	}
	public void setPayMoney(Double payMoney) {
		this.payMoney = payMoney;
	}
	public Integer getVersion() {
		return version;
	}
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
	public IncomeMode getIncomeMode() {
		return incomeMode;
	}
	public void setIncomeMode(IncomeMode incomeMode) {
		this.incomeMode = incomeMode;
	}
	public IncomePurpose getIncomePurpose() {
		return incomePurpose;
	}
	public void setIncomePurpose(IncomePurpose incomePurpose) {
		this.incomePurpose = incomePurpose;
	}	
}