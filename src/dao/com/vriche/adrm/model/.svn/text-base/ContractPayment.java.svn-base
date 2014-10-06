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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
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
public class ContractPayment extends BaseObjectWithoutNestedFormValidation {

	private static final long serialVersionUID = 8043534932085143791L;
	protected Long id;
    protected Long createBy;				  //default timestamp
    protected Date createDate;					  
    protected Long modifyBy;				  //default timestamp
    protected Date modifyDate;					  
    protected Integer version;
    
    protected Long incomePurposeId;
    protected Integer payNumber;
    protected Integer payDate;                 // required
    protected Long contractId;
    protected Long orderId;
    protected Double moneyPay;
    protected Double moneyIn;
    protected Boolean urgencyAlert;
    protected String memo;
    protected Long customerId;                 // required
    protected Long carrierId;    
    protected String carrIds;    
    protected Long incomePullId;  
    protected String[] carrierIds;
    protected String[] incPullIds;
    protected String[] paymentIds;
    protected String[] userIds;
    
    protected List resourceIdList = new ArrayList();
    protected List incPullIdList = new ArrayList();
    protected List paymentIdList = new ArrayList();
    protected List userIdList = new ArrayList();
    protected List carrierIdList = new ArrayList();
    protected List resourceTypeIdList = new ArrayList();
    
    protected List customerIdList = new ArrayList();
    
    protected List userIdList2;
    
    protected Long userId;
    
    protected Long state;
    
    protected String contractCode;
    protected String orderCode;
    
    protected Integer isWhere;
    
    protected Long incomeId;
    
    protected String incomeCode;
    
    protected Long customerCategoryId;
    
    protected String customerName;
    
    protected Double contractMoneySum;
    
    protected Integer contractSort;
    
    protected Matter matter = new Matter();
//    protected Contract contract = new Contract();
//    protected Order order = new Order();
    
    protected IncomePurpose incomePurpose = new IncomePurpose();
    
    protected Customer customer = new Customer();
    
    protected User orderUser = new User();
    
    
    protected List yearIdList = new ArrayList();
    
    protected List contractSortIdList = new ArrayList();
    
    protected String contractSorts;
    
    protected Long resourceTypeId;
    
    protected ResourceType resourceType = new ResourceType();
    
    
    protected IncomePull[] incomePulls;
    
    
    protected Long orgId;
    
    
    protected Integer haveContract = new Integer(0);

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




	public ContractPayment(){};




	public Double getContractMoneySum() {
		return contractMoneySum;
	}




	public void setContractMoneySum(Double contractMoneySum) {
		this.contractMoneySum = contractMoneySum;
	}




	public Long getCustomerCategoryId() {
		return customerCategoryId;
	}




	public void setCustomerCategoryId(Long customerCategoryId) {
		this.customerCategoryId = customerCategoryId;
	}




	public String getCustomerName() {
		return customerName;
	}




	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}




	public Customer getCustomer() {
		return customer;
	}




	public void setCustomer(Customer customer) {
		this.customer = customer;
	}




	/**
	 * 
	 * Returns the incomePurpose
	 * @return IncomePurpose 
	 * 
	 */
	public IncomePurpose getIncomePurpose() {
		return incomePurpose;
	}




	/**
     * @hibernate.id column="contract_payment_id" generator-class="native" unsaved-value="null"
     */
    public Long getId() {
        return id;
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
     * 
     * Returns the incomeUseId
     * @return Long
     * 
     * @hibernate.property length="20" column="income_purpose_id" not-null="false"
     */
    public Long getIncomePurposeId() {
        return incomePurposeId;
    }
    /**
     * 
     * Returns the payNumber
     * @return Integer
     * 
     * @hibernate.property length="2" column="pay_number" not-null="false"
     */
    public Integer getPayNumber() {
        return payNumber;
    }
    /**
     * 
     * Returns the payDate
     * @return Integer
     * @struts.validator type="required"
     * @hibernate.property length="8" column="pay_date" not-null="false"
     */
    public Integer getPayDate() {
        return payDate;
    }
    /**
     * 
     * Returns the contractId
     * @return Long
     * 
     * @hibernate.property length="20" column="contract_id" not-null="false"
     */
    public Long getContractId() {
        return contractId;
    }
    /**
     * 
     * Returns the orderId
     * @return Long
     * 
     * @hibernate.property length="20" column="order_id" not-null="false"
     */
    public Long getOrderId() {
        return orderId;
    }
    /**
     * 
     * Returns the moneyPay
     * @return Double
     * 
     * @hibernate.property length="12" column="money_pay" not-null="false"
     */
    public Double getMoneyPay() {
        return moneyPay;
    }
    /**
     * 
     * Returns the moneyIn
     * @return Double
     * 
     * @hibernate.property length="12" column="money_in" not-null="true"
     */
    public Double getMoneyIn() {
        return moneyIn;
    }
    /**
     * 
     * Returns the urgencyAlert
     * @return Boolean
     * 
     * @hibernate.property column="urgency_alert" not-null="false"   type="yes_no"
     */
    public Boolean getUrgencyAlert() {
        return urgencyAlert;
    }
    /**
     * 
     * Returns the memo
     * @return String
     * 
     * @hibernate.property length="512" column="memo" not-null="false"
     */
    public String getMemo() {
        return memo;
    }
    
    /**
     * 
     * Returns the customerId
     * @return Long
     * 
     * @hibernate.property length="20" column="customer_id" not-null="false"
     */
	public Long getCustomerId() {
		return customerId;
	}    
    
    

	/** 
	 * @param incomePurposeId The incomePurposeId to set.
	 */
	public void setIncomePurposeId(Long incomePurposeId) {
		this.incomePurposeId = incomePurposeId;
	}
   
    
    /**
     * @param contractId The contractId to set.
     */
    public void setContractId(Long contractId) {
        this.contractId = contractId;
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
     * @param moneyIn The moneyIn to set.
     */
    public void setMoneyIn(Double moneyIn) {
        this.moneyIn = moneyIn;
    }
    /**
     * @param moneyPay The moneyPay to set.
     */
    public void setMoneyPay(Double moneyPay) {
        this.moneyPay = moneyPay;
    }
    /**
     * @param orderId The orderId to set.
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    /**
     * @param payDate The payDate to set.
     */
    public void setPayDate(Integer payDate) {
        this.payDate = payDate;
    }
    /**
     * @param payNumber The payNumber to set.
     */
    public void setPayNumber(Integer payNumber) {
        this.payNumber = payNumber;
    }
    /**
     * @param urgencyAlert The urgencyAlert to set.
     */
    public void setUrgencyAlert(Boolean urgencyAlert) {
        this.urgencyAlert = urgencyAlert;
    }
    /**
     * @param version The version to set.
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    
//    public Contract getContract() {
//		return contract;
//	}
//
//
//	public void setContract(Contract contract) {
//		this.contract = contract;
//	}
//
//
//
//
//
//	public Order getOrder() {
//		return order;
//	}
//
//
//	public void setOrder(Order order) {
//		this.order = order;
//	}


	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}



	public void setIncomePurpose(IncomePurpose incomePurpose) {
		this.incomePurpose = incomePurpose;
	}


	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof ContractPayment)) {
			return false;
		}
		ContractPayment rhs = (ContractPayment) object;
		return new EqualsBuilder().append(this.memo, rhs.memo).append(
				this.modifyBy, rhs.modifyBy).append(this.urgencyAlert,
				rhs.urgencyAlert).append(this.createBy, rhs.createBy).append(
				this.incomePurposeId, rhs.incomePurposeId).append(this.id,
				rhs.id).append(this.customerId, rhs.customerId).append(
				this.version, rhs.version).append(this.contractId,
				rhs.contractId).append(this.moneyIn, rhs.moneyIn).append(
				this.incomePurpose, rhs.incomePurpose).append(this.payDate,
				rhs.payDate).append(this.orderId, rhs.orderId).append(
				this.payNumber, rhs.payNumber).append(this.createDate,
				rhs.createDate).append(this.modifyDate, rhs.modifyDate).append(
				this.moneyPay, rhs.moneyPay).isEquals();
	}




	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-562958613, -698939039).append(this.memo)
				.append(this.modifyBy).append(this.urgencyAlert).append(
						this.createBy).append(this.incomePurposeId).append(
						this.id).append(this.customerId).append(this.version)
				.append(this.contractId).append(this.moneyIn).append(
						this.incomePurpose).append(this.payDate).append(
						this.orderId).append(this.payNumber).append(
						this.createDate).append(this.modifyDate).append(
						this.moneyPay).toHashCode();
	}




	/**
	 * 
	 * Returns the contractCode
	 * @return String 
	 * 
	 */
	public String getContractCode() {
		return contractCode;
	}




	/** 
	 * @param contractCode The contractCode to set.
	 */
	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}




	/**
	 * 
	 * Returns the orderCode
	 * @return String 
	 * 
	 */
	public String getOrderCode() {
		return orderCode;
	}




	/** 
	 * @param orderCode The orderCode to set.
	 */
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}




	/**
	 * 
	 * Returns the isWhere
	 * @return Integer
	 * 
	 */
	public Integer getIsWhere() {
		return isWhere;
	}




	/**
	 * @param isWhere The isWhere to set.
	 */
	public void setIsWhere(Integer isWhere) {
		this.isWhere = isWhere;
	}




	/**
	 * 
	 * Returns the incomeId
	 * @return Long
	 *
	 */
	public Long getIncomeId() {
		return incomeId;
	}




	/**
	 * @param incomeId The incomeId to set.
	 */
	public void setIncomeId(Long incomeId) {
		this.incomeId = incomeId;
	}




	public Integer getContractSort() {
		return contractSort;
	}




	public void setContractSort(Integer contractSort) {
		this.contractSort = contractSort;
	}




	public Long getState() {
		return state;
	}




	public void setState(Long state) {
		this.state = state;
	}








	/**
	 * @return Returns the userId.
	 */
	public Long getUserId() {
		return userId;
	}




	/**
	 * @param userId The userId to set.
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}




	/**
	 * @return Returns the resourceIdList.
	 */
	public List getResourceIdList() {
		return resourceIdList;
	}




	/**
	 * @param resourceIdList The resourceIdList to set.
	 */
	public void setResourceIdList(List resourceIdList) {
		this.resourceIdList = resourceIdList;
	}




	/**
	 * @return Returns the incPullIdList.
	 */
	public List getIncPullIdList() {
		return incPullIdList;
	}




	/**
	 * @param incPullIdList The incPullIdList to set.
	 */
	public void setIncPullIdList(List incPullIdList) {
		this.incPullIdList = incPullIdList;
	}




	/**
	 * @return Returns the carrierIds.
	 */
	public String[] getCarrierIds() {
		return carrierIds;
	}




	/**
	 * @param carrierIds The carrierIds to set.
	 */
	public void setCarrierIds(String[] carrierIds) {
		this.carrierIds = carrierIds;
	}




	/**
	 * @return Returns the incPullIds.
	 */
	public String[] getIncPullIds() {
		return incPullIds;
	}




	/**
	 * @param incPullIds The incPullIds to set.
	 */
	public void setIncPullIds(String[] incPullIds) {
		this.incPullIds = incPullIds;
	}




	/**
	 * @return Returns the paymentIdList.
	 */
	public List getPaymentIdList() {
		return paymentIdList;
	}




	/**
	 * @param paymentIdList The paymentIdList to set.
	 */
	public void setPaymentIdList(List paymentIdList) {
		this.paymentIdList = paymentIdList;
	}




	/**
	 * @return Returns the paymentIds.
	 */
	public String[] getPaymentIds() {
		return paymentIds;
	}




	/**
	 * @param paymentIds The paymentIds to set.
	 */
	public void setPaymentIds(String[] paymentIds) {
		this.paymentIds = paymentIds;
	}




	/**
	 * @return Returns the carrierId.
	 */
	public Long getCarrierId() {
		return carrierId;
	}




	/**
	 * @param carrierId The carrierId to set.
	 */
	public void setCarrierId(Long carrierId) {
		this.carrierId = carrierId;
	}




	/**
	 * @return Returns the incomePullId.
	 */
	public Long getIncomePullId() {
		return incomePullId;
	}




	/**
	 * @param incomePullId The incomePullId to set.
	 */
	public void setIncomePullId(Long incomePullId) {
		this.incomePullId = incomePullId;
	}




	/**
	 * @return Returns the matter.
	 */
	public Matter getMatter() {
		return matter;
	}




	/**
	 * @param matter The matter to set.
	 */
	public void setMatter(Matter matter) {
		this.matter = matter;
	}




	/**
	 * @return Returns the userIdList.
	 */
	public List getUserIdList() {
		return userIdList;
	}




	/**
	 * @param userIdList The userIdList to set.
	 */
	public void setUserIdList(List userIdList) {
		this.userIdList = userIdList;
	}




	/**
	 * @return Returns the userIds.
	 */
	public String[] getUserIds() {
		return userIds;
	}




	/**
	 * @param userIds The userIds to set.
	 */
	public void setUserIds(String[] userIds) {
		this.userIds = userIds;
	}




	/**
	 * @return Returns the carrierIdList.
	 */
	public List getCarrierIdList() {
		return carrierIdList;
	}




	/**
	 * @param carrierIdList The carrierIdList to set.
	 */
	public void setCarrierIdList(List carrierIdList) {
		this.carrierIdList = carrierIdList;
	}




	public User getOrderUser() {
		return orderUser;
	}




	public void setOrderUser(User orderUser) {
		this.orderUser = orderUser;
	}




	public List getYearIdList() {
		return yearIdList;
	}




	public void setYearIdList(List yearIdList) {
		this.yearIdList = yearIdList;
	}




	public String getCarrIds() {
		return carrIds;
	}




	public void setCarrIds(String carrIds) {
		this.carrIds = carrIds;
	}




	public List getResourceTypeIdList() {
		return resourceTypeIdList;
	}




	public void setResourceTypeIdList(List resourceTypeIdList) {
		this.resourceTypeIdList = resourceTypeIdList;
	}



	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("incomePurposeId",
				this.incomePurposeId).append("incomeId", this.incomeId).append(
				"carrierIds", this.carrierIds)
				.append("modifyBy", this.modifyBy).append("id", this.id)
				.append("carrierId", this.carrierId).append("urgencyAlert",
						this.urgencyAlert)
				.append("modifyDate", this.modifyDate).append("contractCode",
						this.contractCode).append("resourceTypeIdList",
						this.resourceTypeIdList)
				.append("userIds", this.userIds).append("incPullIdList",
						this.incPullIdList).append("contractMoneySum",
						this.contractMoneySum).append("incomePullId",
						this.incomePullId).append("isWhere", this.isWhere)
				.append("memo",
						this.memo).append("createBy", this.createBy).append(
						"matter", this.matter).append("contractId",
						this.contractId).append("incPullIds", this.incPullIds)
				.append("orderCode", this.orderCode).append("paymentIdList",
						this.paymentIdList).append("incomePurpose",
						this.incomePurpose).append("payDate", this.payDate)
				.append("userId", this.userId).append("payNumber",
						this.payNumber).append("carrierIdList",
						this.carrierIdList).append("customerCategoryId",
						this.customerCategoryId).append("customerId",
						this.customerId).append("contractSort",
						this.contractSort).append("moneyIn", this.moneyIn)
				.append("resourceIdList", this.resourceIdList).append(
						"orderId", this.orderId).append("state", this.state)
				.append("resourceTypeId", this.resourceTypeId).append("version",
						this.version).append("orderUser", this.orderUser)
				.append("moneyPay", this.moneyPay).append("userIdList",
						this.userIdList).append("carrIds", this.carrIds)
				.append("paymentIds", this.paymentIds).append("customerName",
						this.customerName)
				.append("yearIdList", this.yearIdList).append("createDate",
						this.createDate).toString();
	}



	public IncomePull[] getIncomePulls() {
		return incomePulls;
	}



	public void setIncomePulls(IncomePull[] incomePulls) {
		this.incomePulls = incomePulls;
	}



	public List getCustomerIdList() {
		return customerIdList;
	}



	public void setCustomerIdList(List customerIdList) {
		this.customerIdList = customerIdList;
	}



	public Long getOrgId() {
		return orgId;
	}



	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}





	public List getContractSortIdList() {
		return contractSortIdList;
	}



	public void setContractSortIdList(List contractSortIdList) {
		this.contractSortIdList = contractSortIdList;
	}



	public String getContractSorts() {
		return contractSorts;
	}



	public void setContractSorts(String contractSorts) {
		this.contractSorts = contractSorts;
	}



	public String getIncomeCode() {
		return incomeCode;
	}



	public void setIncomeCode(String incomeCode) {
		this.incomeCode = incomeCode;
	}



	public List getUserIdList2() {
		return userIdList2;
	}



	public void setUserIdList2(List userIdList2) {
		this.userIdList2 = userIdList2;
	}



	public Integer getHaveContract() {
		return haveContract;
	}



	public void setHaveContract(Integer haveContract) {
		this.haveContract = haveContract;
	}

}
