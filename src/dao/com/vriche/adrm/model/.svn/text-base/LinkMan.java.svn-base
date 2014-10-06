/****************************************************************************     
 * Created on 2006-10-13                                                     *    
 *                                                               			*
 * @author <a href="mailto:hongxilin@yahoo.com.cn">hongxi</a>               *
 *         Updated by hongxi (hongxilin@yahoo.com.cn)                       *
 *                                                                          *
 * @version  Vision:1.0														*
 * 																			*
 ***************************************************************************/
package com.vriche.adrm.model;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.vriche.adrm.model.Customer;
import com.vriche.adrm.model.BaseObject;
/**
 * LinkMan class
 * 
 * This class is used to 
 * 
 * <p><a href="LinkMan.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_customer_link_man"
 * 
 */
public class LinkMan extends BaseObject {
    
    private static final long serialVersionUID = 3832626162173359411L;
    
    protected Long id;
    protected String linkmanName;					// required
    protected Long customerId;
    protected Integer isCustomerMain;    
    protected String nickleName;
    protected Integer sex;
    protected Integer birthdayYear;
    protected Integer birthdayMonth;
    protected Integer birthdayDay;
    protected Integer anniYear;
    protected Integer anniMonth;
    protected Integer anniDay;
    protected String jobTitle;
    protected String companyWebsite;
    protected String homeCountry;
    protected String homeProvince;
    protected String homeCity;
    protected String homeScarriert;
    protected String homeZip;
    protected String companyCountry;
    protected String companyProvince;
    protected String companyCity;
    protected String companyScarriert;
    protected String companyZip;
    protected String homeTel;
    protected String officeTel;
    protected String mobile;
    protected String favorEmail;
    protected String bakEmail;
    protected String msn;
    protected String oicq;
    protected String memo;
    protected Integer enable;
    protected String mainTel;
    protected String homePage;
    protected Long createBy;				  //default sysdate
    protected Date createDate;					  
    protected Long modifyBy;				  //default sysdate
    protected Date modifyDate;					  
    protected Integer version;
    
    protected String customerName;
    
    protected List customerCateList;
    protected String loginUser;
    
    private Long orgId;
    
//    protected Customer customer = new Customer();

	public LinkMan(){};
	
	
    public LinkMan(String linkmanName){
        this.linkmanName = linkmanName;
    } 

    /**
     * @hibernate.id column="customer_link_man_id" generator-class="native" unsaved-value="null"
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
     * Returns the name
     * @return String
     * @struts.validator type="required"
     * @hibernate.property length="128" column="link_man_name" not-null="true"
     */
    public String getLinkmanName() {
        return linkmanName;
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
     * 
     * Returns the nickleName
     * @return String
     * 
     * @hibernate.property length="32" column="nickle_name" not-null="false"
     */
    public String getNickleName() {
        return nickleName;
    }
    /**
     * 
     * Returns the sex
     * @return Integer
     * 
     * @hibernate.property length="1" column="sex" not-null="false"
     */
    public Integer getSex() {
        return sex;
    }
    /**
     * 
     * Returns the birthdayYear
     * @return Integer
     * 
     * @hibernate.property length="4" column="birthday_year" not-null="false"
     */
    public Integer getBirthdayYear() {
        return birthdayYear;
    }
    /**
     * 
     * Returns the birthdayMonth
     * @return Integer
     * 
     * @hibernate.property length="2" column="birthday_month" not-null="false"
     */
    public Integer getBirthdayMonth() {
        return birthdayMonth;
    }
    /**
     * 
     * Returns the birthdayDay
     * @return Integer
     * 
     * @hibernate.property length="2" column="birthday_day" not-null="false"
     */
    public Integer getBirthdayDay() {
        return birthdayDay;
    }
    /**
     * 
     * Returns the anniYear
     * @return Integer
     * 
     * @hibernate.property length="4" column="anni_year" not-null="false"
     */
    public Integer getAnniYear() {
        return anniYear;
    }
    /**
     * 
     * Returns the anniMonth
     * @return Integer
     * 
     * @hibernate.property length="2" column="anni_month" not-null="false"
     */
    public Integer getAnniMonth() {
        return anniMonth;
    }
    /**
     * 
     * Returns the anniDay
     * @return Integer
     * 
     * @hibernate.property length="2" column="anni_day" not-null="false"
     */
    public Integer getAnniDay() {
        return anniDay;
    }
    /**
     * 
     * Returns the jobTitle
     * @return String
     * 
     * @hibernate.property length="32" column="job_title" not-null="false"
     */
    public String getJobTitle() {
        return jobTitle;
    }
    /**
     * 
     * Returns the companyWebsite
     * @return String
     * 
     * @hibernate.property length="128" column="company_website" not-null="false"
     */
    public String getCompanyWebsite() {
        return companyWebsite;
    }
    /**
     * 
     * Returns the homeCountry
     * @return String
     * 
     * @hibernate.property length="128" column="home_country" not-null="false"
     */
    public String getHomeCountry() {
        return homeCountry;
    }
    /**
     * 
     * Returns the homeProvince
     * @return String
     * 
     * @hibernate.property length="32" column="home_province" not-null="false"
     */
    public String getHomeProvince() {
        return homeProvince;
    }
    /**
     * 
     * Returns the homeCity
     * @return String
     * 
     * @hibernate.property length="32" column="home_city" not-null="false"
     */
    public String getHomeCity() {
        return homeCity;
    }
    /**
     * 
     * Returns the homeScarriert
     * @return String
     * 
     * @hibernate.property length="32" column="home_scarriert" not-null="false"
     */
    public String getHomeScarriert() {
        return homeScarriert;
    }
    /**
     * 
     * Returns the homeZip
     * @return String
     * 
     * @hibernate.property length="32" column="home_zip" not-null="false"
     */
    public String getHomeZip() {
        return homeZip;
    }
    /**
     * 
     * Returns the companyCountry
     * @return String
     * 
     * @hibernate.property length="128" column="company_country" not-null="false"
     */
    public String getCompanyCountry() {
        return companyCountry;
    }
    /**
     * 
     * Returns the companyProvince
     * @return String
     * 
     * @hibernate.property length="32" column="company_province" not-null="false"
     */
    public String getCompanyProvince() {
        return companyProvince;
    }
    /**
     * 
     * Returns the companyCity
     * @return String
     * 
     * @hibernate.property length="32" column="company_city" not-null="false"
     */
    public String getCompanyCity() {
        return companyCity;
    }
    /**
     * 
     * Returns the companyScarriert
     * @return String
     * 
     * @hibernate.property length="32" column="company_scarriert" not-null="false"
     */
    public String getCompanyScarriert() {
        return companyScarriert;
    }
    /**
     * 
     * Returns the companyZip
     * @return String
     * 
     * @hibernate.property length="32" column="company_zip" not-null="false"
     */
    public String getCompanyZip() {
        return companyZip;
    }
    /**
     * 
     * Returns the homeTel
     * @return String
     * 
     * @hibernate.property length="128" column="home_tel" not-null="false"
     */
    public String getHomeTel() {
        return homeTel;
    }
    /**
     * 
     * Returns the officeTel
     * @return String
     * 
     * @hibernate.property length="128" column="office_tel" not-null="false"
     */
    public String getOfficeTel() {
        return officeTel;
    }
    /**
     * 
     * Returns the mobile
     * @return String
     * 
     * @hibernate.property length="128" column="mobile" not-null="false"
     */
    public String getMobile() {
        return mobile;
    }
    /**
     * 
     * Returns the favorEmail
     * @return String
     * 
     * @hibernate.property length="256" column="favor_email" not-null="false"
     */
    public String getFavorEmail() {
        return favorEmail;
    }
    /**
     * 
     * Returns the bakEmail
     * @return String
     * 
     * @hibernate.property length="256" column="bak_email" not-null="false"
     */
    public String getBakEmail() {
        return bakEmail;
    }
    /**
     * 
     * Returns the msn
     * @return String
     * 
     * @hibernate.property length="256" column="msn" not-null="false"
     */
    public String getMsn() {
        return msn;
    }
    /**
     * 
     * Returns the oicq
     * @return String
     * 
     * @hibernate.property length="256" column="oicq" not-null="false"
     */
    public String getOicq() {
        return oicq;
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
     * Returns the enable
     * @return Integer
     * 
     * @hibernate.property length="1" column="enable" not-null="false"
     */
    public Integer getEnable() {
        return enable;
    }
    /**
     * 
     * Returns the enable
     * @return Integer
     * 
     * @hibernate.property length="1" column="is_customer_main" not-null="false"
     */
	public Integer getIsCustomerMain() {
		return isCustomerMain;
	}

    /**
     * 
     * Returns the mainTel
     * @return String
     * 
     * @hibernate.property length="32" column="main_tel" not-null="false"
     */
	public String getMainTel() {
		return mainTel;
	}
    /**
     * 
     * Returns the homePage
     * @return String
     * 
     * @hibernate.property length="255" column="home_page" not-null="false"
     */   
	public String getHomePage() {
		return homePage;
	}    
    
//    public Customer getCustomer() {
//		return customer;
//	}
    
    
    
    
    
    
    
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}  
    
	public void setIsCustomerMain(Integer isCustomerMain) {
		this.isCustomerMain = isCustomerMain;
	}
      
    /**
     * @param anniDay The anniDay to set.
     */
    public void setAnniDay(Integer anniDay) {
        this.anniDay = anniDay;
    }
    /**
     * @param anniMonth The anniMonth to set.
     */
    public void setAnniMonth(Integer anniMonth) {
        this.anniMonth = anniMonth;
    }
    /**
     * @param anniYear The anniYear to set.
     */
    public void setAnniYear(Integer anniYear) {
        this.anniYear = anniYear;
    }
    /**
     * @param bakEmail The bakEmail to set.
     */
    public void setBakEmail(String bakEmail) {
        this.bakEmail = bakEmail;
    }
    /**
     * @param birthdayDay The birthdayDay to set.
     */
    public void setBirthdayDay(Integer birthdayDay) {
        this.birthdayDay = birthdayDay;
    }
    /**
     * @param birthdayMonth The birthdayMonth to set.
     */
    public void setBirthdayMonth(Integer birthdayMonth) {
        this.birthdayMonth = birthdayMonth;
    }
    /**
     * @param birthdayYear The birthdayYear to set.
     */
    public void setBirthdayYear(Integer birthdayYear) {
        this.birthdayYear = birthdayYear;
    }
    /**
     * @param companyCity The companyCity to set.
     */
    public void setCompanyCity(String companyCity) {
        this.companyCity = companyCity;
    }
    /**
     * @param companyCountry The companyCountry to set.
     */
    public void setCompanyCountry(String companyCountry) {
        this.companyCountry = companyCountry;
    }
    /**
     * @param companyProvince The companyProvince to set.
     */
    public void setCompanyProvince(String companyProvince) {
        this.companyProvince = companyProvince;
    }
    /**
     * @param companyScarriert The companyScarriert to set.
     */
    public void setCompanyScarriert(String companyScarriert) {
        this.companyScarriert = companyScarriert;
    }
    /**
     * @param companyWebsite The companyWebsite to set.
     */
    public void setCompanyWebsite(String companyWebsite) {
        this.companyWebsite = companyWebsite;
    }
    /**
     * @param companyZip The companyZip to set.
     */
    public void setCompanyZip(String companyZip) {
        this.companyZip = companyZip;
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
     * @param customerId The customerId to set.
     */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    /**
     * @param favorEmail The favorEmail to set.
     */
    public void setFavorEmail(String favorEmail) {
        this.favorEmail = favorEmail;
    }
    /**
     * @param homeCity The homeCity to set.
     */
    public void setHomeCity(String homeCity) {
        this.homeCity = homeCity;
    }
    /**
     * @param homeCountry The homeCountry to set.
     */
    public void setHomeCountry(String homeCountry) {
        this.homeCountry = homeCountry;
    }
    /**
     * @param homeProvince The homeProvince to set.
     */
    public void setHomeProvince(String homeProvince) {
        this.homeProvince = homeProvince;
    }
    /**
     * @param homeScarriert The homeScarriert to set.
     */
    public void setHomeScarriert(String homeScarriert) {
        this.homeScarriert = homeScarriert;
    }
    /**
     * @param homeTel The homeTel to set.
     */
    public void setHomeTel(String homeTel) {
        this.homeTel = homeTel;
    }
    /**
     * @param homeZip The homeZip to set.
     */
    public void setHomeZip(String homeZip) {
        this.homeZip = homeZip;
    }
    /**
     * @param id The id to set.
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @param jobTitle The jobTitle to set.
     */
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    /**
     * @param linkmanName The linkmanName to set.
     */
    public void setLinkmanName(String linkmanName) {
        this.linkmanName = linkmanName;
    }
    /**
     * @param memo The memo to set.
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }
    /**
     * @param mobile The mobile to set.
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
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
     * @param msn The msn to set.
     */
    public void setMsn(String msn) {
        this.msn = msn;
    }
    /**
     * @param nickleName The nickleName to set.
     */
    public void setNickleName(String nickleName) {
        this.nickleName = nickleName;
    }
    /**
     * @param officeTel The officeTel to set.
     */
    public void setOfficeTel(String officeTel) {
        this.officeTel = officeTel;
    }
    /**
     * @param oicq The oicq to set.
     */
    public void setOicq(String oicq) {
        this.oicq = oicq;
    }
    /**
     * @param sex The sex to set.
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }
    /**
     * @param version The version to set.
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
    

    
    
    
	public void setMainTel(String mainTel) {
		this.mainTel = mainTel;
	}   

	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}
  
    
    /**
     * @param enable The enable to set.
     */
    public void setEnable(Integer enable) {
        this.enable = enable;
    }
    /**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof LinkMan)) {
			return false;
		}
		LinkMan rhs = (LinkMan) object;
		return new EqualsBuilder().append(
				this.officeTel, rhs.officeTel).append(this.mobile, rhs.mobile)
				.append(this.jobTitle, rhs.jobTitle).append(this.homeCity,
						rhs.homeCity).append(this.companyScarriert,
						rhs.companyScarriert).append(this.companyCountry,
						rhs.companyCountry).append(this.companyProvince,
						rhs.companyProvince).append(this.companyCity,
						rhs.companyCity).append(this.homeTel, rhs.homeTel)
				.append(this.msn, rhs.msn).append(this.createBy, rhs.createBy)
				.append(this.id, rhs.id).append(this.sex, rhs.sex).append(
						this.mainTel, rhs.mainTel).append(this.isCustomerMain,
						rhs.isCustomerMain).append(this.nickleName,
						rhs.nickleName).append(this.companyZip, rhs.companyZip)
				.append(this.oicq, rhs.oicq).append(this.anniMonth,
						rhs.anniMonth).append(this.birthdayMonth,
						rhs.birthdayMonth).append(this.memo, rhs.memo).append(
						this.anniDay, rhs.anniDay).append(this.homeZip,
						rhs.homeZip).append(this.modifyBy, rhs.modifyBy)
				.append(this.linkmanName, rhs.linkmanName).append(
						this.homeProvince, rhs.homeProvince).append(this.anniYear,
						rhs.anniYear).append(this.birthdayDay, rhs.birthdayDay)
				.append(this.birthdayYear, rhs.birthdayYear).append(
						this.version, rhs.version).append(this.customerId,
						rhs.customerId).append(this.favorEmail, rhs.favorEmail)
				.append(this.homeCountry, rhs.homeCountry).append(
						this.bakEmail, rhs.bakEmail).append(this.homePage,
						rhs.homePage).append(this.homeScarriert,
						rhs.homeScarriert).append(this.modifyDate,
						rhs.modifyDate).append(this.createDate, rhs.createDate)
				.append(this.companyWebsite, rhs.companyWebsite).append(
						this.enable, rhs.enable).isEquals();
	}
	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-245258357, 1492815595).append(this.officeTel).append(this.mobile)
				.append(this.jobTitle).append(this.homeCity).append(
						this.companyScarriert).append(this.companyCountry)
				.append(this.companyProvince).append(this.companyCity).append(
						this.homeTel).append(this.msn).append(this.createBy)
				.append(this.id).append(this.sex).append(this.mainTel).append(
						this.isCustomerMain).append(this.nickleName).append(
						this.companyZip).append(this.oicq).append(
						this.anniMonth).append(this.birthdayMonth).append(
						this.memo).append(this.anniDay).append(this.homeZip)
				.append(this.modifyBy).append(this.linkmanName).append(
						this.homeProvince).append(
						this.anniYear).append(this.birthdayDay).append(
						this.birthdayYear).append(this.version).append(
						this.customerId).append(this.favorEmail).append(
						this.homeCountry).append(this.bakEmail).append(
						this.homePage).append(this.homeScarriert).append(
						this.modifyDate).append(this.createDate).append(
						this.companyWebsite).append(this.enable).toHashCode();
	}
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("anniDay", this.anniDay)
				.append("modifyBy", this.modifyBy).append("id", this.id)
				.append("modifyDate", this.modifyDate).append("enable",
						this.enable).append("isCustomerMain",
						this.isCustomerMain).append("memo", this.memo).append(
						"createBy", this.createBy).append("anniYear",
						this.anniYear).append("companyScarriert",
						this.companyScarriert)
				.append("homeCity", this.homeCity).append("homeCountry",
						this.homeCountry).append("nickleName", this.nickleName)
				.append("homeTel", this.homeTel).append("companyProvince",
						this.companyProvince).append("bakEmail", this.bakEmail)
				.append("companyCountry", this.companyCountry).append("sex",
						this.sex).append("linkmanName", this.linkmanName)
				.append("mainTel", this.mainTel).append("mobile", this.mobile)
				.append("birthdayYear", this.birthdayYear).append("msn",
						this.msn).append("officeTel", this.officeTel).append(
						"customerId", this.customerId).append("homeProvince",
						this.homeProvince).append("homePage", this.homePage)
				.append("jobTitle", this.jobTitle).append("companyCity",
						this.companyCity).append("companyZip", this.companyZip)
				.append("anniMonth",
						this.anniMonth).append("version", this.version).append(
						"homeScarriert", this.homeScarriert).append(
						"favorEmail", this.favorEmail).append("birthdayMonth",
						this.birthdayMonth).append("birthdayDay",
						this.birthdayDay).append("oicq", this.oicq).append(
						"homeZip", this.homeZip).append("createDate",
						this.createDate).append("companyWebsite",
						this.companyWebsite).toString();
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public Long getOrgId() {
		return orgId;
	}


	public void setOrgId(Long orgId) {
		this.orgId = orgId;
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





}
