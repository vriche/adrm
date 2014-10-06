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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;



/**
 * Contract class
 * 
 * This class is used to 
 * 
 * <p><a href="Contract.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_contract"
 * 
 */
public class Contract extends BaseObjectWithoutNestedFormValidation {  
	private static final long serialVersionUID = -647204361317790918L;
	
	protected Long carrierId; 
	protected Long owner;
    protected String code;					 // required
    protected Long customerId; 				 // required
    protected String signUser;
    protected String signHeadship;
    protected Double moneySum;
    protected Double moneyExec;
    protected Double moneyIn;
    protected Integer csignDate;
    protected Long state;
    protected Integer startDate;			 // required
    protected Integer endDate;				 // required
    protected Integer contractType;
    protected Integer notifyDays;
    protected Boolean isLimitOrder;
    protected Integer contractSort;
    protected String contractSortName;
    protected Long userId;
    protected Integer osignDate;
    protected String memo;
    protected String memoRenew;

    protected Long id;
    protected Long createBy;				  
    protected Date createDate;				   //default timestamp	  
    protected Long modifyBy;				  //default Date
    protected Date modifyDate;					  
    protected Integer version;
    
    protected String customerCategoryId; 
    
    protected String customerName;
    
    protected Set orders = new HashSet(); 
    protected Set contractPayments = new HashSet();
    protected Set contractTargets = new HashSet();
//    protected Set orderDays = new HashSet(); 
    

    
    protected Customer customer = new Customer();
    protected User ownerUser = new User();
    protected OaWorkFlowCheckState checkState = new OaWorkFlowCheckState();
    
    protected Carrier carrier = new Carrier();
    protected List carrierIdList = new ArrayList();
     
    private Long orgId;

	public Contract(){};

    
    public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	/**
     * @hibernate.id column="contract_id" generator-class="native" unsaved-value="null"
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
     * @hibernate.property column="create_date" update="true" insert="true" type="timestamp"
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
    * @hibernate.property column="modify_date" update="true" insert="true" type="timestamp"
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
     * Returns the owner
     * @return Long
     * 
     * @hibernate.property length="128" column="owner" not-null="false"
     */
    public Long getOwner() {
        return owner;
    }
    /**
     * 
     * Returns the code
     * @return String
     * @struts.validator type="required"
     * @hibernate.property length="32" column="code" not-null="false"
     */
    public String getCode() {
        return code;
    }
    /**
     * 
     * Returns the customerId
     * @return Long
     * @struts.validator type="required"
     * @Bak_hibernate.property length="20" column="customer_id" not-null="false"
     */
    public Long getCustomerId() {
        return customerId;
    }
    /**
     * 
     * Returns the signUser
     * @return String
     * 
     * @hibernate.property length="32" column="sign_user" not-null="false"
     */
    public String getSignUser() {
        return signUser;
    }
    /**
     * 
     * Returns the signHeadship
     * @return String
     * 
     * @hibernate.property length="32" column="sign_headship" not-null="false"
     */
    public String getSignHeadship() {
        return signHeadship;
    }
    /**
     * 
     * Returns the moneySum
     * @return Double
     * 
     * @hibernate.property length="12" column="contract_money_sum" not-null="false" 
     */
    public Double getMoneySum() {
        return moneySum;
    }
    /**
     * 
     * Returns the moneyExec
     * @return Double
     * 
     * @hibernate.property length="12" column="contract_money_exec" not-null="false"
     */
    public Double getMoneyExec() {
        return moneyExec;
    }
    /**
     * 
     * Returns the moneyIn
     * @return Double
     * 
     * @hibernate.property length="12" column="money_in_sum" not-null="false"
     */
    public Double getMoneyIn() {
        return moneyIn;
    }
    /**
     * 
     * Returns the csignDate
     * @return Integer
     * 
     * @hibernate.property length="8" column="csign_date" not-null="false"
     */
    public Integer getCsignDate() {
        return csignDate;
    }
    /**
     * 
     * Returns the state
     * @return Long
     * 
     * @hibernate.property length="128" column="contract_state" not-null="true"
     */
    public Long getState() {
        return state;
    }
    /**
     * 
     * Returns the startDate
     * @return Integer
     * @hibernate.property length="8" column="start_date" not-null="false"
     */
    public Integer getStartDate() {
        return startDate;
    }
    /**
     * 
     * Returns the endDate
     * @return Integer
     * @hibernate.property length="8" column="end_date" not-null="false"
     */
    public Integer getEndDate() {
        return endDate;
    }
    /**
     * 
     * Returns the contractType
     * @return Integer
     * 
     * @hibernate.property length="2" column="contract_type" not-null="false"
     */
    public Integer getContractType() {
        return contractType;
    }
    /**
     * 
     * Returns the notifyDays
     * @return Integer
     * 
     * @hibernate.property length="3" column="notify_days" not-null="false"
     */
    public Integer getNotifyDays() {
        return notifyDays;
    }
    /**
     * 
     * Returns the isLimitOrder
     * @return Boolean
     * 
     * @hibernate.property  column="is_limit_order" not-null="false"   type="yes_no"
     */
    public Boolean getIsLimitOrder() {
        return isLimitOrder;
    }
    /**
     * 
     * Returns the contractSort
     * @return Integer
     * 
     * @hibernate.property length="2" column="contract_sort" not-null="false"
     */
    public Integer getContractSort() {
        return contractSort;
    }
    /**
     * 
     * Returns the userId
     * @return Long
     * 
     * @hibernate.property length="20" column="user_id" not-null="false"
     */
    public Long getUserId() {
        return userId;
    }
    /**
     * 
     * Returns the osignDate
     * @return Integer
     * 
     * @hibernate.property length="8" column="osign_date" not-null="false"
     */
    public Integer getOsignDate() {
        return osignDate;
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
     * Returns the memoRenew
     * @return String
     * 
     * @hibernate.property length="512" column="memo_renew" not-null="false"
     */
    public String getMemoRenew() {
        return memoRenew;
    }
 
    public Set getOrders() {
        return orders;
    }
    /**
     * @bak_hibernate.set name="contractPayments" table="tb_contract_payment" inverse="false" cascade="none" lazy="false"
     * @bak_hibernate.collection-key column="contract_id"
     * @bak_hibernate.collection-one-to-many class="com.vriche.adrm.model.ContractPayment" column="contract_payment_id"
     */
    public Set getContractPayments() {
        return contractPayments;
    }

    /**
     * @hibernate.many-to-one name="customerId" column="customer_id" cascade="all" not-null="true"
     */
    public Customer getCustomer() {
        return customer;
    }
    
    
	 /**
     * @hibernate.set table="tb_contract_target" cascade="save-update" lazy="false"
     * @hibernate.collection-key column="contract_id"
     * @hibernate.collection-one-to-many class="com.vriche.adrm.model.ContractTarget" column="contract_target_id"
     */
	public Set getContractTargets() {
		return contractTargets;
	}
   
    
    
    
    
    /**
     * @param code The code to set.
     */
    public void setCode(String code) {
        this.code = code;
    }
    /**
     * @param contractSort The contractSort to set.
     */
    public void setContractSort(Integer contractSort) {
        this.contractSort = contractSort;
    }
    /**
     * @param contractType The contractType to set.
     */
    public void setContractType(Integer contractType) {
        this.contractType = contractType;
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
     * @param csignDate The csignDate to set.
     */
    public void setCsignDate(Integer csignDate) {
        this.csignDate = csignDate;
    }
    /**
     * @param customerId The customerId to set.
     */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    /**
     * @param endDate The endDate to set.
     */
    public void setEndDate(Integer endDate) {
        this.endDate = endDate;
    }
    /**
     * @param id The id to set.
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @param isLimitOrder The isLimitOrder to set.
     */
    public void setIsLimitOrder(Boolean isLimitOrder) {
        this.isLimitOrder = isLimitOrder;
    }
    /**
     * @param memo The memo to set.
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }
    /**
     * @param memoRenew The memoRenew to set.
     */
    public void setMemoRenew(String memoRenew) {
        this.memoRenew = memoRenew;
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
     * @param moneyExec The moneyExec to set.
     */
    public void setMoneyExec(Double moneyExec) {
        this.moneyExec = moneyExec;
    }
    /**
     * @param moneyIn The moneyIn to set.
     */
    public void setMoneyIn(Double moneyIn) {
        this.moneyIn = moneyIn;
    }
    /**
     * @param moneySum The moneySum to set.
     */
    public void setMoneySum(Double moneySum) {
        this.moneySum = moneySum;
    }
    /**
     * @param notifyDays The notifyDays to set.
     */
    public void setNotifyDays(Integer notifyDays) {
        this.notifyDays = notifyDays;
    }
    /**
     * @param osignDate The osignDate to set.
     */
    public void setOsignDate(Integer osignDate) {
        this.osignDate = osignDate;
    }
    /**
     * @param owner The owner to set.
     */
    public void setOwner(Long owner) {
        this.owner = owner;
    }
    /**
     * @param signHeadship The signHeadship to set.
     */
    public void setSignHeadship(String signHeadship) {
        this.signHeadship = signHeadship;
    }
    /**
     * @param signUser The signUser to set.
     */
    public void setSignUser(String signUser) {
        this.signUser = signUser;
    }
    /**
     * @param startDate The startDate to set.
     */
    public void setStartDate(Integer startDate) {
        this.startDate = startDate;
    }
    /**
     * @param state The state to set.
     */
    public void setState(Long state) {
        this.state = state;
    }
    /**
     * @param userId The userId to set.
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    /**
     * @param version The version to set.
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
    
    /**
     * @param contractPayments The contractPayments to set.
     */
    public void setContractPayments(Set contractPayments) {
        this.contractPayments = contractPayments;
    }
    /**
     * @param orders The orders to set.
     */
    public void setOrders(Set orders) {
        this.orders = orders;
    }
    /**
     * @param customer The customer to set.
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    /**
     * @param isLimitOrder The isLimitOrder to set.
     */
    public void setLimitOrder(Boolean isLimitOrder) {
        this.isLimitOrder = isLimitOrder;
    }
    
	/** 
	 * @param contractTargets The contractTargets to set.
	 */
	public void setContractTargets(Set contractTargets) {
		this.contractTargets = contractTargets;
	}


	
    
    /**
     * @see java.lang.Object#equals(Object)
     */
    public boolean equals(Object object) {
        if (!(object instanceof Contract)) {
            return false;
        }
        Contract rhs = (Contract) object;
        return new EqualsBuilder().append(
                this.startDate, rhs.startDate).append(this.moneyExec,
                rhs.moneyExec).append(this.userId, rhs.userId).append(
                this.orders, rhs.orders).append(this.createBy, rhs.createBy)
                .append(this.osignDate, rhs.osignDate).append(this.id, rhs.id)
                .append(this.code, rhs.code)
                .append(this.moneySum, rhs.moneySum).append(this.contractSort,
                        rhs.contractSort).append(this.notifyDays,
                        rhs.notifyDays).append(this.memo, rhs.memo).append(
                        this.owner, rhs.owner).append(this.isLimitOrder,
                        rhs.isLimitOrder).append(this.modifyBy, rhs.modifyBy)
                .append(this.customer, rhs.customer).append(this.version,
                        rhs.version).append(this.customerId, rhs.customerId)
                .append(this.csignDate, rhs.csignDate).append(this.moneyIn,
                        rhs.moneyIn).append(this.memoRenew, rhs.memoRenew)
                .append(this.contractType, rhs.contractType).append(
                        this.signHeadship, rhs.signHeadship).append(this.state,
                        rhs.state).append(this.endDate, rhs.endDate).append(
                        this.signUser, rhs.signUser).append(this.createDate,
                        rhs.createDate).append(this.modifyDate, rhs.modifyDate)
                .append(this.contractPayments, rhs.contractPayments)
                .append(this.customerCategoryId, rhs.customerCategoryId).isEquals();
    }
    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder(-1037799355, 2018547413).append(this.startDate).append(this.moneyExec)
                .append(this.userId).append(this.orders).append(this.createBy)
                .append(this.osignDate).append(this.id).append(this.code)
                .append(this.moneySum).append(this.contractSort).append(
                        this.notifyDays).append(this.memo).append(this.owner)
                .append(this.isLimitOrder).append(this.modifyBy).append(
                        this.customer).append(this.version).append(
                        this.customerId).append(this.csignDate).append(
                        this.moneyIn).append(this.memoRenew).append(
                        this.contractType).append(this.signHeadship).append(
                        this.state).append(this.endDate).append(this.signUser)
                .append(this.createDate).append(this.modifyDate)
                .append(this.contractPayments)
                .append(this.customerCategoryId).toHashCode();
    }
    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return new ToStringBuilder(this).append("modifyBy", this.modifyBy)
                .append("id", this.id).append("modifyDate", this.modifyDate)
                .append("memoRenew", this.memoRenew).append("notifyDays",
                        this.notifyDays).append("owner", this.owner).append(
                        "memo", this.memo).append("createBy", this.createBy)
                .append("signUser", this.signUser).append("endDate",
                        this.endDate).append("startDate", this.startDate)
                .append("moneyExec", this.moneyExec).append("signHeadship",
                        this.signHeadship).append("userId", this.userId)
                .append("customerId", this.customerId).append("contractType",
                        this.contractType).append("contractSort",
                        this.contractSort).append("moneyIn", this.moneyIn)
                .append("moneySum", this.moneySum).append("state", this.state)
                .append("contractPayments", this.contractPayments).append(
                        "isLimitOrder", this.isLimitOrder).append("customer",
                        this.customer).append("version", this.version).append(
                        "orders", this.orders).append("code", this.code)
                .append("csignDate", this.csignDate).append("createDate",
                        this.createDate).append("osignDate", this.osignDate)
                .append("customerCategoryId", this.customerCategoryId).toString();
    }


	/**
	 * 
	 * Returns the checkState
	 * @return OaWorkFlowCheckState 
	 * 
	 */
	public OaWorkFlowCheckState getCheckState() {
		return checkState;
	}


	/** 
	 * @param checkState The checkState to set.
	 */
	public void setCheckState(OaWorkFlowCheckState checkState) {
		this.checkState = checkState;
	}


	/**
	 * 
	 * Returns the ownerUser
	 * @return User
	 * 
	 * @hibernate.property length="128" column="ownerUser" not-null="false"
	 */
	public User getOwnerUser() {
		return ownerUser;
	}


	/**
	 * @param ownerUser The ownerUser to set.
	 */
	public void setOwnerUser(User ownerUser) {
		this.ownerUser = ownerUser;
	}


	/**
	 * 
	 * Returns the customerCategoryId
	 * @return String
	 * 
	 */
	public String getCustomerCategoryId() {
		return customerCategoryId;
	}


	/**
	 * @param customerCategoryId The customerCategoryId to set.
	 */
	public void setCustomerCategoryId(String customerCategoryId) {
		this.customerCategoryId = customerCategoryId;
	}
	
	/**
     * @hibernate.many-to-one name="carrierId" column="ad_resource_carrier_id" cascade="all" not-null="true"
 	 */
	public Carrier getCarrier() {
		return carrier;
	}




	/**
	 * @param carrier The carrier to set.
	 */
	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
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


	public Long getOrgId() {
		return orgId;
	}


	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}


	public String getContractSortName() {
		
		if(this.contractSort != null){
			int contractSort = this.contractSort.intValue();
			
			if(contractSort == 0){
				contractSortName = "协约合同";
			}else if (contractSort == 1){
				contractSortName = "协议";
			}else if (contractSort == 2){
				contractSortName = "部门订单";
			}else{
				contractSortName = "";
			}	
		}

		return contractSortName;
	}


	public void setContractSortName(String contractSortName) {
		this.contractSortName = contractSortName;
	}


//	/**
//     * @hibernate.set name="getOrderDays" table="tb_order_day_info" inverse="false" cascade="none" lazy="false"
//     * @hibernate.collection-key column="contract_id"
//     * @hibernate.collection-one-to-many class="com.vriche.adrm.model.OrderDayInfo" column="contract_id"
//     */
//	public Set getOrderDays() {
//		return orderDays;
//	}
//
//
//	/** 
//	 * @param orderDays The orderDays to set.
//	 */
//	public void setOrderDays(Set orderDays) {
//		this.orderDays = orderDays;
//	}











}
