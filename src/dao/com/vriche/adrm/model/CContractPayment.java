/****************************************************************************     
 * Created on 2006-10-16                                                     *    
 *                                                               			*
 * @author <a href="mailto:hongxilin@yahoo.com.cn">hongxi</a>               *
 *         Updated by hongxi (hongxilin@yahoo.com.cn)                       *
 *                                                                          *
 * @version  Vision:1.0														*
 * 																			*
 ***************************************************************************/
package com.vriche.adrm.model;

/**
 * ContractPayment class
 * 
 * This class is used to 
 * 
 * <p><a href="ContractPayment.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_contract_payment"
 * 
 */
public class CContractPayment extends BaseObjectWithoutNestedFormValidation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected Long id;
    protected Long contractId;
    protected Long orderId;
    protected Double moneyPay;
    protected Double moneyIn;
    protected Integer payNumber;
    protected Integer payDate;   
    protected String contractCode;
    protected String orderCode;  
    protected String incomePurposeName;
    protected String matterName;
    protected String customerId;
    protected String memo;
    
    protected Long resourceTypeId;
    
    protected ResourceType resourceType = new ResourceType();

	public ResourceType getResourceType() {
		return resourceType;
	}

	public void setResourceType(ResourceType resourceType) {
		this.resourceType = resourceType;
	}

	public Long getResourceTypeId() {
		return resourceTypeId;
	}

	public void setResourceTypeId(Long resourceTypeId) {
		this.resourceTypeId = resourceTypeId;
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
	public String getContractCode() {
		return contractCode;
	}
	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}
	public Long getContractId() {
		return contractId;
	}
	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIncomePurposeName() {
		return incomePurposeName;
	}
	public void setIncomePurposeName(String incomePurposeName) {
		this.incomePurposeName = incomePurposeName;
	}
	public String getMatterName() {
		return matterName;
	}
	public void setMatterName(String matterName) {
		this.matterName = matterName;
	}
	public Double getMoneyIn() {
		return moneyIn;
	}
	public void setMoneyIn(Double moneyIn) {
		this.moneyIn = moneyIn;
	}
	public Double getMoneyPay() {
		return moneyPay;
	}
	public void setMoneyPay(Double moneyPay) {
		this.moneyPay = moneyPay;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Integer getPayDate() {
		return payDate;
	}
	public void setPayDate(Integer payDate) {
		this.payDate = payDate;
	}
	public Integer getPayNumber() {
		return payNumber;
	}
	public void setPayNumber(Integer payNumber) {
		this.payNumber = payNumber;
	}

	/**
	 * @return Returns the customerId.
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId The customerId to set.
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}



}