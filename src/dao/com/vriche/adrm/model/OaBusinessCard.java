/****************************************************************************     
 * Created on 2007-4-11                                      *    
 *                                                               			*
 * @author <a href="mailto:hongxilin@yahoo.com.cn">hongxi</a>               *
 *         Updated by hongxi (hongxilin@yahoo.com.cn)                       *
 *                                                                          *
 * @version  Vision:1.0														*
 * 																			*
 ***************************************************************************/
package com.vriche.adrm.model;

import java.util.Date;

/**
 * OaBusinessCard class
 * 
 * This class is used to 
 * 
 * <p><a href="OaBusinessCard.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_oa_business_card"
 * 
 */
public class OaBusinessCard extends BaseObjectWithoutNestedFormValidation {

	private static final long serialVersionUID = -7871336680646908431L;

	protected Long id;
	protected Long businessCardTypId;   
	protected String firstName;       // required
	protected String lastName;  	  // required
	protected String fullName;   
	protected Integer sex;
	protected String tel1;  
	protected String tel2;  
	protected String tel3;  
	protected String mob;  
	protected String work; 	
	protected String headship; 	
	protected Integer birthdayYear; 	
	protected Integer birthdayMonth; 	
	protected Integer birthdayDate; 	
	
	protected Long createBy; 	// default sysdate
	protected Date createDate;
	protected Long modifyBy; 	// default sysdate
	protected Date modifyDate;
	protected Integer version;
	
	protected OaBusinessCardType oaBusinessCardType = new OaBusinessCardType();
	
	public OaBusinessCard() {};
	
	
	/**
     * @hibernate.id column="business_card_id" generator-class="native" unsaved-value="null"
	 */
	public Long getId() {
		return id;
	}
	

	

	/**
	 * 
	 * Returns the birthdayDate
	 * @return Integer 
	 * 
	 * @hibernate.property length="2" column="birthday_date" not-null="false"
	 */
	public Integer getBirthdayDate() {
		return birthdayDate;
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
	 * Returns the businessCardTypId
	 * @return Long 
	 * 
	 * @hibernate.property length="20" column="business_card_typ_id" not-null="false"
	 */
	public Long getBusinessCardTypId() {
		return businessCardTypId;
	}


	/**
	 * 
	 * Returns the firstName
	 * @return String 
	 * @struts.validator type="required"
	 * @hibernate.property length="32" column="first_name" not-null="false"
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * 
	 * Returns the lastName
	 * @return String 
	 * @struts.validator type="required"
	 * @hibernate.property length="32" column="last_name" not-null="false"
	 */
	public String getLastName() {
		return lastName;
	}
	

	public String getFullName() {
		return this.firstName.toString() + this.lastName.toString();
	}


	/**
	 * 
	 * Returns the headship
	 * @return String 
	 * 
	 * @hibernate.property length="32" column="headship" not-null="false"
	 */
	public String getHeadship() {
		return headship;
	}





	/**
	 * 
	 * Returns the mob
	 * @return String 
	 * 
	 * @hibernate.property length="255" column="mob" not-null="false"
	 */
	public String getMob() {
		return mob;
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
	 * Returns the tel1
	 * @return String 
	 * 
	 * @hibernate.property length="255" column="tel1" not-null="false"
	 */
	public String getTel1() {
		return tel1;
	}


	/**
	 * 
	 * Returns the tel2
	 * @return String 
	 * 
	 * @hibernate.property length="255" column="tel2" not-null="false"
	 */
	public String getTel2() {
		return tel2;
	}


	/**
	 * 
	 * Returns the tel3
	 * @return String 
	 * 
	 * @hibernate.property length="255" column="tel3" not-null="false"
	 */
	public String getTel3() {
		return tel3;
	}


	/**
	 * 
	 * Returns the work
	 * @return String 
	 * 
	 * @hibernate.property length="255" column="work" not-null="false"
	 */
	public String getWork() {
		return work;
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
	

	public OaBusinessCardType getOaBusinessCardType() {
		return oaBusinessCardType;
	}	
	
	
	
	
	
	/** 
	 * @param birthdayDate The birthdayDate to set.
	 */
	public void setBirthdayDate(Integer birthdayDate) {
		this.birthdayDate = birthdayDate;
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
	 * @param businessCardTypId The businessCardTypId to set.
	 */
	public void setBusinessCardTypId(Long businessCardTypId) {
		this.businessCardTypId = businessCardTypId;
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
	 * @param firstName The firstName to set.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	/** 
	 * @param fullName The fullName to set.
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	/** 
	 * @param headship The headship to set.
	 */
	public void setHeadship(String headship) {
		this.headship = headship;
	}


	/** 
	 * @param id The id to set.
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/** 
	 * @param lastName The lastName to set.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	/** 
	 * @param mob The mob to set.
	 */
	public void setMob(String mob) {
		this.mob = mob;
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
	 * @param oaBusinessCardType The oaBusinessCardType to set.
	 */
	public void setOaBusinessCardType(OaBusinessCardType oaBusinessCardType) {
		this.oaBusinessCardType = oaBusinessCardType;
	}


	/** 
	 * @param sex The sex to set.
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}


	/** 
	 * @param tel1 The tel1 to set.
	 */
	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}


	/** 
	 * @param tel2 The tel2 to set.
	 */
	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}


	/** 
	 * @param tel3 The tel3 to set.
	 */
	public void setTel3(String tel3) {
		this.tel3 = tel3;
	}


	/** 
	 * @param version The version to set.
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}


	/** 
	 * @param work The work to set.
	 */
	public void setWork(String work) {
		this.work = work;
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
