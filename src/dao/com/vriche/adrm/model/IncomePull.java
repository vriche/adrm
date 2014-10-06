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
 * IncomePull class
 * 
 * This class is used to
 * 
 * <p>
 * <a href="IncomePull.java.html"> <i>View Source </i> </a>
 * </p>
 * 
 * @struts.form include-all="true" extends="BaseForm"
 * @hibernate.class table="tb_income_pull"
 *  
 */
public class IncomePull extends BaseObjectWithoutNestedFormValidation {

	private static final long serialVersionUID = -2452932856270474635L;

	protected Long incomeId;

    protected Long resourceCarrierId;

   

    protected Long id;

    protected Long createBy; //default sysdate

    protected Date createDate;

    protected Long modifyBy; //default sysdate

    protected Date modifyDate;

    protected Integer version;

    protected Carrier carrier = new Carrier();
    // 
    protected Double moneyPull;
    protected Double moneyIn;
    protected String incomeDate;
	protected String incomeCode;
	protected Double incomeMoney;
    protected Double arrearMoney;
    protected String customerName;
    protected String firstName;
    protected String lastName;
    protected String memo;
    protected String modeName;
    protected String purposeName;
    protected String fullName;
    
    protected Income income = new Income();
    
    protected List customerIdList;
    protected List yearIdList;
    protected List userIdList2;
    
    
    
    protected Long resourceTypeId;
    protected Long orgId;
    protected String resourceTypeIds;
    
    protected Long resourceChannelId;
    
    protected String startDate;
    protected String endDate;
    

    protected ResourceType resourceType = new ResourceType();
    
    
    
//    ad_ad_resource_type_id
    
    
    public String getFullName() {
		return this.firstName + this.lastName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public IncomePull() {
    };

    /**
     * @hibernate.id column="income_pull_id" generator-class="native"
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
     * Returns the incomeId
     * 
     * @return Long
     * 
     * @BAK_hibernate.property length="20" column="income_id" not-null="false"
     */
    public Long getIncomeId() {
        return incomeId;
    }

    /**
     * 
     * Returns the resourceCarrierId
     * 
     * @return Long
     * 
     * @hibernate.property length="20" column="ad_resource_carrier_id"
     *                     not-null="false"
     */
    public Long getResourceCarrierId() {
        return resourceCarrierId;
    }

    /**
     * 
     * Returns the moneyPull
     * 
     * @return Double
     * 
     * @hibernate.property length="12" column="money_pull" not-null="false"
     */
    public Double getMoneyPull() {
        return moneyPull;
    }

    /**
     * 
     * Returns the moneyIn
     * 
     * @return Double
     * @struts.validator type="required"
     * @hibernate.property length="12" column="money_in" not-null="true"
     */
    public Double getMoneyIn() {
        return moneyIn;
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
     * @param id
     *            The id to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @param incomeId
     *            The incomeId to set.
     */
    public void setIncomeId(Long incomeId) {
        this.incomeId = incomeId;
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
     * @param moneyIn
     *            The moneyIn to set.
     */
    public void setMoneyIn(Double moneyIn) {
        this.moneyIn = moneyIn;
    }

    /**
     * @param moneyPull
     *            The moneyPull to set.
     */
    public void setMoneyPull(Double moneyPull) {
        this.moneyPull = moneyPull;
    }

    /**
     * @param resourceCarrierId
     *            The resourceCarrierId to set.
     */
    public void setResourceCarrierId(Long resourceCarrierId) {
        this.resourceCarrierId = resourceCarrierId;
    }

    /**
     * @param version
     *            The version to set.
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * @see java.lang.Object#equals(Object)
     */
    public boolean equals(Object object) {
        if (!(object instanceof IncomePull)) {
            return false;
        }
        IncomePull rhs = (IncomePull) object;
        return new EqualsBuilder().append(
                this.moneyIn, rhs.moneyIn)
                .append(this.moneyPull, rhs.moneyPull).append(this.modifyBy,
                        rhs.modifyBy).append(this.modifyDate, rhs.modifyDate)
                .append(this.createDate, rhs.createDate).append(this.createBy,
                        rhs.createBy).append(this.resourceCarrierId,
                        rhs.resourceCarrierId).append(this.incomeId,
                        rhs.incomeId).append(this.id, rhs.id).append(
                        this.version, rhs.version).isEquals();
    }
    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder(-585458167, 1040974193).append(this.moneyIn).append(this.moneyPull)
                .append(this.modifyBy).append(this.modifyDate).append(
                        this.createDate).append(this.createBy).append(
                        this.resourceCarrierId).append(this.incomeId).append(
                        this.id).append(this.version).toHashCode();
    }
    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return new ToStringBuilder(this).append("incomeId", this.incomeId)
                .append("modifyBy", this.modifyBy).append("id", this.id)
                .append("version", this.version).append("modifyDate",
                        this.modifyDate).append("moneyIn", this.moneyIn)
                .append("resourceCarrierId", this.resourceCarrierId).append(
                        "createBy", this.createBy).append("moneyPull",
                        this.moneyPull).append("createDate", this.createDate)
                .toString();
    }

	public Carrier getCarrier() {
		return carrier;
	}

	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}

	public Double getArrearMoney() {
		return arrearMoney;
	}

	public void setArrearMoney(Double arrearMoney) {
		this.arrearMoney = arrearMoney;
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

	public Double getIncomeMoney() {
		return incomeMoney;
	}

	public void setIncomeMoney(Double incomeMoney) {
		this.incomeMoney = incomeMoney;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getModeName() {
		return modeName;
	}

	public void setModeName(String modeName) {
		this.modeName = modeName;
	}

	public String getPurposeName() {
		return purposeName;
	}

	public void setPurposeName(String purposeName) {
		this.purposeName = purposeName;
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

	public List getCustomerIdList() {
		return customerIdList;
	}

	public void setCustomerIdList(List customerIdList) {
		this.customerIdList = customerIdList;
	}

	public List getYearIdList() {
		return yearIdList;
	}

	public void setYearIdList(List yearIdList) {
		this.yearIdList = yearIdList;
	}

	public Long getResourceTypeId() {
		return resourceTypeId;
	}

	public void setResourceTypeId(Long resourceTypeId) {
		this.resourceTypeId = resourceTypeId;
	}

	public ResourceType getResourceType() {
		return resourceType;
	}

	public void setResourceType(ResourceType resourceType) {
		this.resourceType = resourceType;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public String getResourceTypeIds() {
		return resourceTypeIds;
	}

	public void setResourceTypeIds(String resourceTypeIds) {
		this.resourceTypeIds = resourceTypeIds;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public Long getResourceChannelId() {
		return resourceChannelId;
	}

	public void setResourceChannelId(Long resourceChannelId) {
		this.resourceChannelId = resourceChannelId;
	}

	public List getUserIdList2() {
		return userIdList2;
	}

	public void setUserIdList2(List userIdList2) {
		this.userIdList2 = userIdList2;
	}
}