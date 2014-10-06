/****************************************************************************     
 * Created on 2006-10-12                                                     *    
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
 * Customer class
 * 
 * This class is used to 
 * 
 * <p><a href="Customer.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * 
 * @hibernate.class table="tb_customer_info"
 * 
 */
public class Customer extends BaseObjectWithoutNestedFormValidation{
    
    private static final long serialVersionUID = 3832626162173359411L;
   
    
    protected Long id;
    protected String customerName;                    // required; unique
    protected String helpCode;                   	  // required; unique
    protected String customerCategoryId;              //
    protected Long customerTypeId;                    //
    protected String parentId;                   	  
    protected Long  industryTypeId;                 
    protected Integer customerLevel;                   
    protected String telephone;                   	  // required
    protected String fax;                   	 
    protected String webSite;                                     	  
    protected Integer creditAccount;                   	 
    protected Integer creditSpan;                   	 
    protected Double  discountRate;                   	  
    protected Integer delayDays;
    protected Integer delayDateUnit;  
    protected Integer paymentExpireDays;
    protected String accountName;
    protected String accountBank;
    protected String accountNumber;
    protected String ownerAgent;
    protected String accountAddress;
    protected String memo;
    protected Integer customerState;				  //default 0
    protected String postCode;
    protected Long createBy;						  //default sysdate
    protected Date createDate;					  
    protected Long modifyBy;						  //default sysdate
    protected Date modifyDate;					  
    protected Integer version;
    
    protected Category category = new Category();
    protected CustomerType customerType = new CustomerType();  
    protected Industry industry = new Industry();  
    protected LinkMan linkMan = new LinkMan(); 
    protected Set users = new HashSet();

    protected String[] resourceIds;
    protected List resourceIdList;
    protected String[] userIds;
    
    
    protected List customerCateList;
    protected String loginUser;
    protected String model;
    
    
    
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

	public Customer() {}

    public Customer(String customerName) {
        this.customerName = customerName;
    }
    
    /**
     * @hibernate.id column="customer_id" generator-class="native" unsaved-value="null"
     */
    public Long getId() {
        return id;
    }
    /**
     * 
     * Returns the accountAddress
     * @return String
     * 
     * @hibernate.property length="128" column="account_address" not-null="false"
     */
    public String getAccountAddress() {
        return accountAddress;
    }
    /**
     * 
     * Returns the accountBank
     * @return String
     * 
     * @hibernate.property length="128" column="account_bank" not-null="false"
     */
    public String getAccountBank() {
        return accountBank;
    }
    /**
     * 
     * Returns the accountName
     * @return String
     * 
     * @hibernate.property length="128" column="account_name" not-null="false"
     */
    public String getAccountName() {
        return accountName;
    }
    /**
     * 
     * Returns the accountNumber
     * @return String
     * 
     * @hibernate.property length="128" column="account_number" not-null="false"
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * 
     * Returns the creditAccount
     * @return Integer
     * 
     * @hibernate.property length="12" column="credit_account" not-null="false"
     */
    public Integer getCreditAccount() {
        return creditAccount;
    }
    /**
     * 
     * Returns the creditSpan
     * @return Integer
     * 
     * @hibernate.property length="3" column="credit_span" not-null="false"
     */
    public Integer getCreditSpan() {
        return creditSpan;
    }
    /**
     * 
     * Returns the customerCategoryId
     * @return String
     * 
     * @hibernate.property length="32" column="customer_category_id" not-null="false"
     */
    public String getCustomerCategoryId() {
        return customerCategoryId;
    }
    
    
    
    /**
     * 
     * Returns the CustomerTypeId
     * @return Long
     * 
     * @hibernate.property length="128" column="customer_type_id" not-null="false"
     */  
	public Long getCustomerTypeId() {
		return customerTypeId;
	}
    /**
     * 
     * Returns the customerLevel
     * @return Integer
     * 
     * @hibernate.property length="3" column="customer_level" not-null="false"
     */
    public Integer getCustomerLevel() {
        return customerLevel;
    }
    /**
     * 
     * Returns the customerName
     * @return String
     * @struts.validator type="required"
     * @hibernate.property length="128" column="customer_name" not-null="true" unique="true"
     */
    public String getCustomerName() {
        return customerName;
    }
    /**
     * 
     * Returns the customerState
     * @return Integer
     * 
     * @hibernate.property length="1" column="state" not-null="false"
     */
    public Integer getCustomerState() {
        return customerState;
    }
    /**
     * 
     * Returns the delayDays
     * @return Integer
     * 
     * @hibernate.property length="3" column="delay_days" not-null="false"
     */
    public Integer getDelayDays() {
        return delayDays;
    }
    
	
    /**
     * 
     * Returns the delayDays
     * @return Integer
     * 
     * @hibernate.property length="1" column="delay_date_unit" not-null="false"
     */
	public Integer getDelayDateUnit() {
		return delayDateUnit;
	}
    /**
     * 
     * Returns the discountRate
     * @return float
     * 
     * @hibernate.property length="5" column="discount_rate" not-null="false"
     */
    public Double getDiscountRate() {
        return discountRate;
    }
    /**
     * 
     * Returns the fax
     * @return String
     * 
     * @hibernate.property length="128" column="fax" not-null="false"
     */
    public String getFax() {
        return fax;
    }
    /**
     * 
     * Returns the helpCode
     * @return String
     * @struts.validator type="required"
     * @hibernate.property length="16" column="help_code" not-null="true" unique="true"
     */
    public String getHelpCode() {
        return helpCode;
    }
    /**
     * 
     * Returns the industryTypeId
     * @return Long
     * 
     * @hibernate.property length="20" column="industry_type_id" not-null="false"
     */
    public Long getIndustryTypeId() {
        return industryTypeId;
    }
    /**
     * 
     * Returns the memo
     * @return String
     * 
     * @hibernate.property length="256" column="memo" not-null="false"
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 
     * Returns the ownerAgent
     * @return String
     * 
     * @hibernate.property length="128" column="owner_agent" not-null="false"
     */
    public String getOwnerAgent() {
        return ownerAgent;
    }
    /**
     * 
     * Returns the parentId
     * @return String
     * 
     * @hibernate.property length="128" column="parent_id" not-null="true"
     */
    public String getParentId() {
        return parentId;
    }
    /**
     * 
     * Returns the paymentExpireDays
     * @return Integer
     * 
     * @hibernate.property length="3" column="payment_expire_days" not-null="false"
     */
    public Integer getPaymentExpireDays() {
        return paymentExpireDays;
    }
    /**
     * 
     * Returns the telephone
     * @return String
     * 
     * @hibernate.property length="128" column="telephone" not-null="false"
     */
    public String getTelephone() {
        return telephone;
    }
    /**
     * 
     * Returns the webSite
     * @return String
     * 
     * @hibernate.property length="256" column="web_site" not-null="false"
     */
    public String getWebSite() {
        return webSite;
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
	public Category getCategory() {
		return category;
	}
	public CustomerType getCustomerType() {
		return customerType;
	}
	public Industry getIndustry() {
		return industry;
	}
	public LinkMan getLinkMan() {
		return linkMan;
	}
    
    /**
     * @hibernate.version
     */
    public Integer getVersion() {
        return version;
    }

	 /**
     * @hibernate.set table="tb_customer_user_rel" cascade="save-update" lazy="false"
     * @hibernate.collection-key column="customer_id"
     * @hibernate.collection-many-to-many class="com.vriche.adrm.model.User" column="user_id"
     */
	public Set getUsers() {
		return users;
	}
	
	
    
   
    /**
     * @param accountAddress The accountAddress to set.
     */
    public void setAccountAddress(String accountAddress) {
        this.accountAddress = accountAddress;
    }
    /**
     * @param accountBank The accountBank to set.
     */
    public void setAccountBank(String accountBank) {
        this.accountBank = accountBank;
    }
    /**
     * @param accountName The accountName to set.
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    /**
     * @param accountNumber The accountNumber to set.
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    /**
     * @param createBy The createBy to set.
     */
    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }
    /**
     * @param creditAccount The creditAccount to set.
     */
    public void setCreditAccount(Integer creditAccount) {
        this.creditAccount = creditAccount;
    }
    /**
     * @param creditSpan The creditSpan to set.
     */
    public void setCreditSpan(Integer creditSpan) {
        this.creditSpan = creditSpan;
    }
    /**
     * @param customercategoryId The customercategoryId to set.
     */
    public void setCustomerCategoryId(String customerCategoryId) {
        this.customerCategoryId = customerCategoryId;
    }
    /**
     * @param customerLevel The customerLevel to set.
     */
    public void setCustomerLevel(Integer customerLevel) {
        this.customerLevel = customerLevel;
    }
    /**
     * @param customerName The customerName to set.
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    /**
     * @param customerState The customerState to set.
     */
    public void setCustomerState(Integer customerState) {
        this.customerState = customerState;
    }
    /**
     * @param delayDays The delayDays to set.
     */
    public void setDelayDays(Integer delayDays) {
        this.delayDays = delayDays;
    }
    /**
     * @param discountRate The discountRate to set.
     */
    public void setDiscountRate(Double discountRate) {
        this.discountRate = discountRate;
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
     * @param id The id to set.
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @param industryTypeId The industryTypeId to set.
     */
    public void setIndustryTypeId(Long industryTypeId) {
        this.industryTypeId = industryTypeId;
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
     * @param ownerAgent The ownerAgent to set.
     */
    public void setOwnerAgent(String ownerAgent) {
        this.ownerAgent = ownerAgent;
    }
    /**
     * @param parentId The parentId to set.
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
    /**
     * @param paymentExpireDays The paymentExpireDays to set.
     */
    public void setPaymentExpireDays(Integer paymentExpireDays) {
        this.paymentExpireDays = paymentExpireDays;
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
    /**
     * @param webSite The webSite to set.
     */
    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }    
    /**
     * @param createDate The createDate to set.
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    /**
     * @param modifyDate The modifyDate to set.
     */
    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
	public void setDelayDateUnit(Integer delayDateUnit) {
		this.delayDateUnit = delayDateUnit;
	}
	public void setCustomerTypeId(Long customerTypeId) {
		this.customerTypeId = customerTypeId;
	}   
	public void setCategory(Category category) {
		this.category = category;
	}


	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}



	public void setIndustry(Industry industry) {
		this.industry = industry;
	}
	public void setLinkMan(LinkMan linkMan) {
		this.linkMan = linkMan;
	}


	public void setUsers(Set users) {
		this.users = users;
	}
   
    
    /**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof Customer)) {
			return false;
		}
		Customer rhs = (Customer) object;
		return new EqualsBuilder().append(this.paymentExpireDays,
				rhs.paymentExpireDays).append(this.discountRate,
				rhs.discountRate).append(this.telephone, rhs.telephone).append(
				this.accountNumber, rhs.accountNumber)
				.append(this.fax, rhs.fax).append(this.createBy, rhs.createBy)
				.append(this.id, rhs.id)
				.append(this.creditSpan, rhs.creditSpan).append(
						this.creditAccount, rhs.creditAccount).append(
						this.customerLevel, rhs.customerLevel).append(
						this.industry, rhs.industry).append(this.delayDateUnit,
						rhs.delayDateUnit).append(this.webSite, rhs.webSite)
				.append(this.helpCode, rhs.helpCode).append(
						this.customerTypeId, rhs.customerTypeId).append(
						this.customerState, rhs.customerState).append(
						this.ownerAgent, rhs.ownerAgent).append(this.memo,
						rhs.memo).append(this.parentId, rhs.parentId).append(
						this.category, rhs.category).append(this.modifyBy,
						rhs.modifyBy).append(this.industryTypeId,
						rhs.industryTypeId).append(this.accountBank,
						rhs.accountBank).append(this.delayDays, rhs.delayDays)
				.append(this.version, rhs.version).append(
						this.customerCategoryId, rhs.customerCategoryId)
				.append(this.customerType, rhs.customerType).append(
						this.accountAddress, rhs.accountAddress).append(
						this.customerName, rhs.customerName).append(
						this.accountName, rhs.accountName).append(
						this.modifyDate, rhs.modifyDate).append(
						this.createDate, rhs.createDate).isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-1280355801, 1843253289).append(
				this.paymentExpireDays).append(this.discountRate).append(
				this.telephone).append(this.accountNumber).append(this.fax)
				.append(this.createBy).append(this.id).append(this.creditSpan)
				.append(this.creditAccount).append(this.customerLevel).append(
						this.industry).append(this.delayDateUnit).append(
						this.webSite).append(this.helpCode).append(
						this.customerTypeId).append(this.customerState).append(
						this.ownerAgent).append(this.memo)
				.append(this.parentId).append(this.category).append(
						this.modifyBy).append(this.industryTypeId).append(
						this.accountBank).append(this.delayDays).append(
						this.version).append(this.customerCategoryId).append(
						this.customerType).append(this.accountAddress).append(
						this.customerName).append(this.accountName).append(
						this.modifyDate).append(this.createDate).toHashCode();
	}

	/**
	 * @return Returns the postCode.
	 */
	public String getPostCode() {
		return postCode;
	}

	/**
	 * @param postCode The postCode to set.
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
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
	 * @return Returns the resourceIds.
	 */
	public String[] getResourceIds() {
		return resourceIds;
	}

	/**
	 * @param resourceIds The resourceIds to set.
	 */
	public void setResourceIds(String[] resourceIds) {
		this.resourceIds = resourceIds;
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
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("org", this.org).append(
				"accountAddress", this.accountAddress).append("modifyBy",
				this.modifyBy).append("orgId", this.orgId).append(
				"resourceIds", this.resourceIds).append("id", this.id).append(
				"users", this.users).append("modifyDate", this.modifyDate)
				.append("userIds", this.userIds).append("parentId",
						this.parentId).append("postCode", this.postCode)
				.append("customerState", this.customerState).append(
						"telephone", this.telephone).append("memo", this.memo)
				.append("createBy", this.createBy).append("fax", this.fax)
				.append("orgAdminId", this.orgAdminId).append("linkMan",
						this.linkMan).append("industryTypeId",
						this.industryTypeId).append("discountRate",
						this.discountRate).append("accountName",
						this.accountName).append("industry", this.industry)
				.append("accountNumber", this.accountNumber).append(
						"customerCategoryId", this.customerCategoryId).append(
						"customerType", this.customerType).append("creditSpan",
						this.creditSpan).append("resourceIdList",
						this.resourceIdList).append("customerTypeId",
						this.customerTypeId).append("delayDateUnit",
						this.delayDateUnit).append("webSite", this.webSite)
				.append("version", this.version).append("customerLevel",
						this.customerLevel).append("paymentExpireDays",
						this.paymentExpireDays).append("helpCode",
						this.helpCode)
				.append("customerName", this.customerName).append("category",
						this.category).append("accountBank", this.accountBank)
				.append("delayDays", this.delayDays).append("createDate",
						this.createDate).append("creditAccount",
						this.creditAccount).append("ownerAgent",
						this.ownerAgent).toString();
	}

	public List getCustomerCateList() {
		return customerCateList;
	}

	public void setCustomerCateList(List customerCateList) {
		this.customerCateList = customerCateList;
	}

	public String getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}





}
