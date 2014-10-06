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

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.vriche.adrm.model.BaseObject;
/**
 * IncomeUsed class
 * 
 * This class is used to 
 * 
 * <p><a href="IncomeUsed.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_income_used"
 * 
 */
public class IncomeUsed extends BaseObjectWithoutNestedFormValidation {

	private static final long serialVersionUID = -4599610710719746802L;
	protected Long incomeId;
    protected Long incomePullId;
    protected Long contractId;
    protected Long orderId;
    protected Long orderDetailId;
    protected Long orderDayInfoId;
    protected Integer publishDate;
    protected Double moneyIn;
    protected Double moneyPull;

    protected Long id;	  
    protected Integer version;
    
    protected Long paymentId;
    
    protected ContractPayment payment = new ContractPayment();
    protected Income income= new Income();
    protected OrderDayInfo orderDayInfo= new OrderDayInfo();
    
    
    
    protected String incomeMoney;
    protected String carrierName;
    protected String orderCode;
    protected String contractCode; 
    protected String incomeDate;
    protected String incomeCode;
    protected String firstName;
    protected String lastName;
    protected String customerName;
    protected String fullName;
    protected IncomePublic incomePublic= new IncomePublic();
    
    
    
    public IncomePublic getIncomePublic() {
		return incomePublic;
	}


	public void setIncomePublic(IncomePublic incomePublic) {
		this.incomePublic = incomePublic;
	}


	public String getFullName() {
    	return this.firstName +  this.lastName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public IncomeUsed(){};


    /**
     * @hibernate.id column="income_used_id" generator-class="native" unsaved-value="null"
     */
    public Long getId() {
        return id;
    }
    


    /**
     * 
     * Returns the incomeId
     * @return Long
     * 
     * @BAK_hibernate.property length="20" column="income_id" not-null="false"
     */
    public Long getIncomeId() {
        return incomeId;
    }
    /**
     * 
     * Returns the incomePullId
     * @return String
     * 
     * @hibernate.property length="20" column="income_pull_id" not-null="false"
     */
    public Long getIncomePullId() {
        return incomePullId;
    }
    /**
     * 
     * Returns the contractId
     * @return String
     * 
     * @BAK_hibernate.property length="20" column="contract_id" not-null="false"
     */
    public Long getContractId() {
        return contractId;
    }
    /**
     * 
     * Returns the orderId
     * @return String
     * 
     * @BAK_hibernate.property length="20" column="order_id" not-null="false"
     */
    public Long getOrderId() {
        return orderId;
    }
    /**
     * 
     * Returns the orderDetailId
     * @return String
     * 
     * @BAK_hibernate.property length="20" column="order_detail_id" not-null="false"
     */
    public Long getOrderDetailId() {
        return orderDetailId;
    }
    /**
     * 
     * Returns the orderDayInfoId
     * @return String
     * 
     * @BAK_hibernate.property length="20" column="order_day_info_id" not-null="false"
     */
    public Long getOrderDayInfoId() {
        return orderDayInfoId;
    }
    /**
     * 
     * Returns the publishDate
     * @return String
     * 
     * @hibernate.property length="8" column="publish_date" not-null="false"
     */
    public Integer getPublishDate() {
        return publishDate;
    }
    /**
     * 
     * Returns the moneyIn
     * @return Double
     * @struts.validator type="required"
     * @hibernate.property length="12" column="money_in" not-null="true"
     */
    public Double getMoneyIn() {
        return moneyIn;
    }
    
    /**
     * @hibernate.version
     */
    public Integer getVersion() {
        return version;
    }
    

    
    
    
    /**
     * @param contractId The contractId to set.
     */
    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }
    /**
     * @param id The id to set.
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @param incomeId The incomeId to set.
     */
    public void setIncomeId(Long incomeId) {
        this.incomeId = incomeId;
    }
    /**
     * @param incomePullId The incomePullId to set.
     */
    public void setIncomePullId(Long incomePullId) {
        this.incomePullId = incomePullId;
    }
    /**
     * @param moneyIn The moneyIn to set.
     */
    public void setMoneyIn(Double moneyIn) {
        this.moneyIn = moneyIn;
    }
    /**
     * @param orderDayInfoId The orderDayInfoId to set.
     */
    public void setOrderDayInfoId(Long orderDayInfoId) {
        this.orderDayInfoId = orderDayInfoId;
    }
    /**
     * @param orderDetailId The orderDetailId to set.
     */
    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }
    /**
     * @param orderId The orderId to set.
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    /**
     * @param publishDate The publishDate to set.
     */
    public void setPublishDate(Integer publishDate) {
        this.publishDate = publishDate;
    }
    /**
     * @param version The version to set.
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
    
    
    
    
    

    
    /**
     * @see java.lang.Object#equals(Object)
     */
    public boolean equals(Object object) {
        if (!(object instanceof IncomeUsed)) {
            return false;
        }
        IncomeUsed rhs = (IncomeUsed) object;
        return new EqualsBuilder().append(
                this.incomePullId, rhs.incomePullId).append(this.moneyIn,
                rhs.moneyIn).append(this.publishDate, rhs.publishDate).append(
                this.orderId, rhs.orderId).append(this.orderDetailId,
                rhs.orderDetailId).append(this.incomeId, rhs.incomeId).append(
                this.id, rhs.id).append(this.version, rhs.version).append(
                this.orderDayInfoId, rhs.orderDayInfoId).append(
                this.contractId, rhs.contractId).append(
                        this.paymentId, rhs.paymentId).isEquals();
    }
    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder(101307027, 1824590479).append(this.incomePullId)
                .append(this.moneyIn).append(this.publishDate).append(
                        this.orderId).append(this.orderDetailId).append(
                        this.incomeId).append(this.id).append(this.version)
                .append(this.orderDayInfoId).append(this.paymentId)
                .toHashCode();
    }
    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return new ToStringBuilder(this).append("incomeId", this.incomeId)
                .append("orderDayInfoId", this.orderDayInfoId).append(
                        "contractId", this.contractId).append("id", this.id)
                .append("version", this.version).append("publishDate",
                        this.publishDate).append("incomePullId",
                        this.incomePullId).append("moneyIn", this.moneyIn)
                .append("orderDetailId", this.orderDetailId).append("orderId",
                        this.orderId)
                        .append("paymentId", this.paymentId).toString();
    }


	/**
	 * 
	 * Returns the paymentId
	 * @return Long
	 * 
	 * @BAK_hibernate.property length="128" column="payment_id" not-null="true"
	 */
	public Long getPaymentId() {
		return paymentId;
	}


	/**
	 * @param paymentId The paymentId to set.
	 */
	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	/**
	    * @hibernate.many-to-one name="paymentId" column="payment_id" cascade="all" not-null="true"
	*/
	public ContractPayment getPayment() {
		return payment;
	}


	public void setPayment(ContractPayment payment) {
		this.payment = payment;
	}


	public String getCarrierName() {
		return carrierName;
	}


	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getIncomeCode() {
		return incomeCode;
	}


	public void setIncomeCode(String incomeCode) {
		this.incomeCode = incomeCode;
	}


	public String getIncomeDate() {
		return incomeDate;
	}


	public void setIncomeDate(String incomeDate) {
		this.incomeDate = incomeDate;
	}


	public String getIncomeMoney() {
		return incomeMoney;
	}


	public void setIncomeMoney(String incomeMoney) {
		this.incomeMoney = incomeMoney;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getOrderCode() {
		return orderCode;
	}


	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}


	public Double getMoneyPull() {
		return moneyPull;
	}


	public void setMoneyPull(Double moneyPull) {
		this.moneyPull = moneyPull;
	}


	/**
     * @hibernate.many-to-one name="incomeId" column="income_id" cascade="all" not-null="true"
 	 */
	public Income getIncome() {
		return income;
	}


	/**
	 * @param income The income to set.
	 */
	public void setIncome(Income income) {
		this.income = income;
	}

	
	/**
     * @hibernate.many-to-one name="orderDayInfoId" column="order_day_info_id" cascade="all" not-null="true"
 	 */
	public OrderDayInfo getOrderDayInfo() {
		return orderDayInfo;
	}


	/**
	 * @param orderDayInfo The orderDayInfo to set.
	 */
	public void setOrderDayInfo(OrderDayInfo orderDayInfo) {
		this.orderDayInfo = orderDayInfo;
	}


	public String getContractCode() {
		return contractCode;
	}


	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}
}
