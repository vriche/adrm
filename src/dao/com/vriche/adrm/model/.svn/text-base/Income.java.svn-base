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
import org.apache.commons.lang.builder.CompareToBuilder;

/**
 * Income class
 * 
 * This class is used to
 * 
 * <p>
 * <a href="Income.java.html"> <i>View Source </i> </a>
 * </p>
 * 
 * @struts.form include-all="true" extends="BaseForm"
 * @hibernate.class table="tb_income"
 *  
 */
public class Income extends BaseObject {

	private static final long serialVersionUID = 3252630111679051531L;
	protected String incomeCode;  // required; unique
    protected Integer incomeDate;
    protected Long customerId;
    protected Double incomeMoney;
    protected Double incomeUsed;   //已分配金额
    protected Double balanceMoney; //分配余额
    protected Long incomeModeId;
    protected Long incomePurposeId;
    protected Long id;
    protected Long createBy; //default sysdate
    protected Date createDate;
    protected Long modifyBy; //default sysdate
    protected Date modifyDate;
    protected Integer version;
    protected String memo;
    
    protected String startDate;
    protected String endDate;
    protected Integer incomePullDate;
    protected Long userId;
    
    protected Integer state;
    
    protected IncomeMode incomeMode = new IncomeMode();
    protected IncomePurpose incomePurpose = new IncomePurpose();
    protected Customer customer = new Customer();
    protected User user = new User();
//    protected Carrier carrier = new Carrier();
//    protected IncomePull incomePull = new IncomePull();
    protected String month[];
    
    protected String customerName;
    protected String incomePurposeName;
    protected String incomeModeName;
    protected String userName;
    
    protected Long resourceCarrierId;
    protected String resourceChannelId;
    
    protected List carrierIdList = new ArrayList();
    
    protected List userIdList2 = new ArrayList();
    
    protected List orgIdList = new ArrayList();
    
    
//    protected Set incomePulls = new HashSet();
    
    protected IncomePublic incomePublic= new IncomePublic();
    
    protected String pullByCarrier;
    
    
    
    protected List yearIdList = new ArrayList();
    
    private List fitterOrderSubCatesList= new ArrayList();
    
    
    
	private Long orgId;
	private Long orgAdminId;
	private Org org;
    
    public Org getOrg() {
		return org;
	}

	public void setOrg(Org org) {
		this.org = org;
	}

	public Long getOrgAdminId() {
		return orgAdminId;
	}

	public void setOrgAdminId(Long orgAdminId) {
		this.orgAdminId = orgAdminId;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public IncomePublic getIncomePublic() {
		return incomePublic;
	}

	public void setIncomePublic(IncomePublic incomePublic) {
		this.incomePublic = incomePublic;
	}

	public Income() {
    };

    /**
     * @hibernate.id column="income_id" generator-class="native"
     *               unsaved-value="null"
     */
    public Long getId() {
        return id;
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
     * 
     * Returns the incomeCode
     * 
     * @return String
     * @struts.validator type="required"
     * @hibernate.property length="32" column="income_code" not-null="false"
     */
    public String getIncomeCode() {
        return incomeCode;
    }

    /**
     * 
     * Returns the incomeDate
     * 
     * @return Integer
     * @hibernate.property length="8" column="income_date" not-null="false"
     */
    public Integer getIncomeDate() {
        return incomeDate;
    }

    /**
     * 
     * Returns the customerId
     * 
     * @return Long
     * @struts.validator type="required"
     * @BAK_hibernate.property length="8" column="customer_id" not-null="false"
     */
    public Long getCustomerId() {
        return customerId;
    }

    /**
     * 
     * Returns the incomeMoney
     * 
     * @return java.lang.Double
     * 
     * @hibernate.property length="12" column="income_money" not-null="false"
     */
    public java.lang.Double getIncomeMoney() {
        return incomeMoney;
    }
    
    /**
	 * 
	 * Returns the incomeUsed
	 * @return Double 
	 * 
	 */
	public Double getIncomeUsed() {
		return incomeUsed;
	}
	
	/**
	 * 
	 * Returns the balanceMoney
	 * @return Double 
	 * 
	 */
	public Double getBalanceMoney() {
		double income = 0;
		double used = 0;
		if(incomeMoney != null) income = incomeMoney.doubleValue();
		if(incomeMoney != null) used = incomeMoney.doubleValue();
		
		return new Double(income - used);
	}

    /**
     * 
     * Returns the incomeModeId
     * 
     * @return Long
     * 
     * @BAK_hibernate.property length="20" column="income_mode_id" not-null="false"
     */
    public Long getIncomeModeId() {
        return incomeModeId;
    }

    /**
     * 
     * Returns the incomePurposeId
     * 
     * @return Long
     * 
     * @BAK_hibernate.property length="20" column="income_purpose_id"
     *                     not-null="false"
     */
    public Long getIncomePurposeId() {
        return incomePurposeId;
    }

//    /**
//     * @hibernate.set name="incomePulls" table="tb_income_pull" inverse="false"
//     *                cascade="all" lazy="false"
//     * @hibernate.collection-key column="income_id"
//     * @hibernate.collection-one-to-many class="com.vriche.adrm.model.IncomePull"
//     *                                   column="income_pull_id"
//     */
//    public Set getIncomePulls() {
//        return incomePulls;
//    }

    
	/**
     * @hibernate.many-to-one name="customerId" column="customer_id" cascade="all" not-null="true"
 	 */
	public Customer getCustomer() {
		return customer;
	}
	
	/**
     * @hibernate.many-to-one name="incomePurposeId" column="income_purpose_id" cascade="all" not-null="true"
 	 */
	public IncomePurpose getIncomePurpose() {
		return incomePurpose;
	}
    /**
     * @param createBy
     *            The createBy to set.
     */
    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    /**
     * @param createDate
     *            The createDate to set.
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @param customerId
     *            The customerId to set.
     */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    /**
     * @param id
     *            The id to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @param incomeCode
     *            The incomeCode to set.
     */
    public void setIncomeCode(String incomeCode) {
        this.incomeCode = incomeCode;
    }

    /**
     * @param incomeDate
     *            The incomeDate to set.
     */
    public void setIncomeDate(Integer incomeDate) {
        this.incomeDate = incomeDate;
    }

    /**
     * @param incomeModeId
     *            The incomeModeId to set.
     */
    public void setIncomeModeId(Long incomeModeId) {
        this.incomeModeId = incomeModeId;
    }

    /**
     * @param incomeMoney
     *            The incomeMoney to set.
     */
    public void setIncomeMoney(java.lang.Double incomeMoney) {
        this.incomeMoney = incomeMoney;
    }

    /**
     * @param incomePurposeId
     *            The incomePurposeId to set.
     */
    public void setIncomePurposeId(Long incomePurposeId) {
        this.incomePurposeId = incomePurposeId;
    }

    /**
     * @param modifyBy
     *            The modifyBy to set.
     */
    public void setModifyBy(Long modifyBy) {
        this.modifyBy = modifyBy;
    }

    /**
     * @param modifyDate
     *            The modifyDate to set.
     */
    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
    


	/** 
	 * @param incomeUsed The incomeUsed to set.
	 */
	public void setIncomeUsed(Double incomeUsed) {
		this.incomeUsed = incomeUsed;
	}

    /**
     * @param version
     *            The version to set.
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

//    /**
//     * @param incomePulls
//     *            The incomePulls to set.
//     */
//    public void setIncomePulls(Set incomePulls) {
//        this.incomePulls = incomePulls;
//    }


	/**
     * @hibernate.many-to-one name="incomeModeId" column="income_mode_id" cascade="all" not-null="true"
 	 */
	public IncomeMode getIncomeMode() {
		return incomeMode;
	}

	public void setIncomeMode(IncomeMode incomeMode) {
		this.incomeMode = incomeMode;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public void setIncomePurpose(IncomePurpose incomePurpose) {
		this.incomePurpose = incomePurpose;
	}
	

	/** 
	 * @param balanceMoney The balanceMoney to set.
	 */
	public void setBalanceMoney(Double balanceMoney) {
		this.balanceMoney = balanceMoney;
	}

	/**
	 * 
	 * Returns the state
	 * @return Integer
	 * 
	 */
	public Integer getState() {
		return state;
	}

	/**
	 * @param state The state to set.
	 */
	public void setState(Integer state) {
		this.state = state;
	}
    /**
     * 
     * Returns the memo
     * 
     * @return String
     * 
     * @hibernate.property length="255" column="memo" not-null="false"
     */
	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	 /**
     * 
     * Returns the userId
     * 
     * @return Long
     * 
     * @BAK_hibernate.property length="128" column="user_id" not-null="true"
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
     * @hibernate.many-to-one name="id" column="user_id" cascade="all" not-null="true"
 	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user The user to set.
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return Returns the month.
	 */
	public String[] getMonth() {
		return month;
	}

	/**
	 * @param month The month to set.
	 */
	public void setMonth(String[] month) {
		this.month = month;
	}

	/**
	 * @return Returns the endDate.
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate The endDate to set.
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return Returns the startDate.
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate The startDate to set.
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

//	/**
//	 * @return Returns the customerName.
//	 */
//	public String getCustomerName() {
//		return customerName;
//	}
//
//	/**
//	 * @param customerName The customerName to set.
//	 */
//	public void setCustomerName(String customerName) {
//		this.customerName = customerName;
//	}

//	/**
//	 * @return Returns the incomeModeName.
//	 */
//	public String getIncomeModeName() {
//		return incomeModeName;
//	}
//
//	/**
//	 * @param incomeModeName The incomeModeName to set.
//	 */
//	public void setIncomeModeName(String incomeModeName) {
//		this.incomeModeName = incomeModeName;
//	}
//
//	/**
//	 * @return Returns the incomePurposeName.
//	 */
//	public String getIncomePurposeName() {
//		return incomePurposeName;
//	}
//
//	/**
//	 * @param incomePurposeName The incomePurposeName to set.
//	 */
//	public void setIncomePurposeName(String incomePurposeName) {
//		this.incomePurposeName = incomePurposeName;
//	}
//
//	/**
//	 * @return Returns the userName.
//	 */
//	public String getUserName() {
//		return userName;
//	}
//
//	/**
//	 * @param userName The userName to set.
//	 */
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}

//	public Carrier getCarrier() {
//		return carrier;
//	}
//
//	public void setCarrier(Carrier carrier) {
//		this.carrier = carrier;
//	}

//	public IncomePull getIncomePull() {
//		return incomePull;
//	}
//
//	public void setIncomePull(IncomePull incomePull) {
//		this.incomePull = incomePull;
//	}
    /**
     * 
     * Returns the incomeDate
     * 
     * @return Integer
     * @hibernate.property length="8" column="income_pull_date" not-null="true"
     */
	public Integer getIncomePullDate() {
		return incomePullDate;
	}

	public void setIncomePullDate(Integer incomePullDate) {
		this.incomePullDate = incomePullDate;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-149770853, 1131551695).append(this.incomeCode)
				.append(this.startDate).append(this.userId).append(
						this.createBy).append(this.incomePurposeId).append(
						this.id).append(
						this.incomePullDate).append(this.month).append(
						this.memo).append(this.incomeDate)
				.append(this.incomeMoney).append(this.modifyBy).append(
						this.incomeUsed).append(
						this.incomeModeId).append(
						this.customerId).append(this.version).append(
						this.balanceMoney).append(
						this.state).append(this.modifyDate).append(
						this.createDate).append(this.endDate).toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("incomePurposeId",
				this.incomePurposeId).append("incomeMoney", this.incomeMoney)
				.append("modifyBy", this.modifyBy).append("id", this.id)
				.append("modifyDate", this.modifyDate).append("month",
						this.month).append("incomePullDate",
						this.incomePullDate).append("memo", this.memo).append(
						"createBy", this.createBy).append("endDate",
						this.endDate).append("incomeCode", this.incomeCode)
				.append("balanceMoney", this.balanceMoney).append(
						"startDate", this.startDate).append("userId",
						this.userId).append("customerId", this.customerId)
				
				.append("incomeUsed", this.incomeUsed).append("state", this.state).append("version",
						this.version).append("incomeDate", this.incomeDate)
				.append(
						"incomeModeId", this.incomeModeId).append("createDate",
						this.createDate).toString();
	}

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof Income)) {
			return false;
		}
		Income rhs = (Income) object;
		return new EqualsBuilder().append(
				this.incomeCode, rhs.incomeCode).append(this.startDate,
				rhs.startDate).append(this.userId, rhs.userId).append(
				this.createBy, rhs.createBy).append(this.incomePurposeId,
				rhs.incomePurposeId).append(this.id, rhs.id).append(this.incomePullDate,
				rhs.incomePullDate).append(this.month, rhs.month).append(
				this.memo, rhs.memo).append(
				this.incomeDate, rhs.incomeDate).append(this.incomeMoney,
				rhs.incomeMoney).append(this.modifyBy, rhs.modifyBy).append(
				this.incomeUsed, rhs.incomeUsed).append(this.incomeModeId, rhs.incomeModeId)
				.append(
						this.customerId, rhs.customerId).append(this.version,
						rhs.version)
				.append(this.balanceMoney, rhs.balanceMoney).append(
						this.state, rhs.state).append(this.modifyDate,
						rhs.modifyDate).append(this.createDate, rhs.createDate)
				.append(this.endDate, rhs.endDate).isEquals();
	}

	/**
	 * @return Returns the customerName.
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName The customerName to set.
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return Returns the incomeModeName.
	 */
	public String getIncomeModeName() {
		return incomeModeName;
	}

	/**
	 * @param incomeModeName The incomeModeName to set.
	 */
	public void setIncomeModeName(String incomeModeName) {
		this.incomeModeName = incomeModeName;
	}

	/**
	 * @return Returns the incomePurposeName.
	 */
	public String getIncomePurposeName() {
		return incomePurposeName;
	}

	/**
	 * @param incomePurposeName The incomePurposeName to set.
	 */
	public void setIncomePurposeName(String incomePurposeName) {
		this.incomePurposeName = incomePurposeName;
	}

	/**
	 * @return Returns the userName.
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName The userName to set.
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return Returns the resourceCarrierId.
	 */
	public Long getResourceCarrierId() {
		return resourceCarrierId;
	}

	/**
	 * @param resourceCarrierId The resourceCarrierId to set.
	 */
	public void setResourceCarrierId(Long resourceCarrierId) {
		this.resourceCarrierId = resourceCarrierId;
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

	public List getYearIdList() {
		return yearIdList;
	}

	public void setYearIdList(List yearIdList) {
		this.yearIdList = yearIdList;
	}

	/**
	 * @see java.lang.Comparable#compareTo(Object)
	 */
	public int compareTo(Object object) {
		Income myClass = (Income) object;
		return new CompareToBuilder().append(this.incomeCode,
				myClass.incomeCode).append(this.startDate, myClass.startDate)
				.append(this.org, myClass.org).append(this.userId,
						myClass.userId).append(this.resourceCarrierId,
						myClass.resourceCarrierId).append(this.createBy,
						myClass.createBy).append(this.incomePurposeId,
						myClass.incomePurposeId).append(this.id, myClass.id)
				.append(this.incomeMode, myClass.incomeMode).append(this.orgId,
						myClass.orgId).append(this.incomePullDate,
						myClass.incomePullDate).append(this.yearIdList,
						myClass.yearIdList).append(this.month, myClass.month)
				.append(this.userName, myClass.userName).append(this.memo,
						myClass.memo).append(this.user, myClass.user).append(
						this.incomeDate, myClass.incomeDate).append(
						this.incomeMoney, myClass.incomeMoney).append(
						this.modifyBy, myClass.modifyBy).append(
						this.incomeUsed, myClass.incomeUsed).append(
						this.customer, myClass.customer).append(
						this.incomeModeId, myClass.incomeModeId).append(
						this.incomePublic, myClass.incomePublic).append(
						this.incomeModeName, myClass.incomeModeName).append(
						this.customerId, myClass.customerId).append(
						this.version, myClass.version).append(
						this.carrierIdList, myClass.carrierIdList).append(
						this.balanceMoney, myClass.balanceMoney).append(
						this.orgAdminId, myClass.orgAdminId).append(
						this.incomePurpose, myClass.incomePurpose).append(
						this.incomePurposeName, myClass.incomePurposeName)
				.append(this.customerName, myClass.customerName).append(
						this.state, myClass.state).append(this.modifyDate,
						myClass.modifyDate).append(this.createDate,
						myClass.createDate).append(this.endDate,
						myClass.endDate).toComparison();
	}

	public String getPullByCarrier() {
		return pullByCarrier;
	}

	public void setPullByCarrier(String pullByCarrier) {
		this.pullByCarrier = pullByCarrier;
	}

	public List getFitterOrderSubCatesList() {
		return fitterOrderSubCatesList;
	}

	public void setFitterOrderSubCatesList(List fitterOrderSubCatesList) {
		this.fitterOrderSubCatesList = fitterOrderSubCatesList;
	}

	public String getResourceChannelId() {
		return resourceChannelId;
	}

	public void setResourceChannelId(String resourceChannelId) {
		this.resourceChannelId = resourceChannelId;
	}

	public List getUserIdList2() {
		return userIdList2;
	}

	public void setUserIdList2(List userIdList2) {
		this.userIdList2 = userIdList2;
	}

	public List getOrgIdList() {
		return orgIdList;
	}

	public void setOrgIdList(List orgIdList) {
		this.orgIdList = orgIdList;
	}

	
}