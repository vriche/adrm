package com.vriche.adrm.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Org class
 * 
 * This class is used to
 * 
 * <p>
 * <a href="Org.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @struts.form include-all="true" extends="BaseForm"
 * @hibernate.class table="tb_sys_org"
 * 
 */
public class Org extends BaseObjectWithoutNestedFormValidation {

	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 1L;

	protected Long id;
	protected String name; // required
	protected String tel;
	protected String fax;
	protected String linkMan;
	protected String bankName;
	protected String bankCode;
	protected String reportTitle;
	protected String reportSignature; //report_signature
	
	
	protected byte[] logo; 
	protected String logoType;
	
	protected Long createBy; // default sysdate
	protected Date createDate;
	protected Long modifyBy; // default sysdate
	protected Date modifyDate;
	protected Integer version;

	protected Address address = new Address();
	protected Set branchs = new HashSet();
	
	protected User sysAdmin = new User();
	
	protected String logFileRel;
	
	protected String logFile;
	
	protected String orgType;
	

    protected String parentId;
    protected Integer displayNo;	
	

	public Org() {};

	/**
	 * @hibernate.id column="sys_org_id" generator-class="native"
	 *               unsaved-value="null"
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 
	 * Returns the name
	 * 
	 * @return String
	 * @struts.validator type="required"
	 * @hibernate.property length="255" column="name" not-null="false"
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * Returns the bankCode
	 * 
	 * @return String
	 * 
	 * @hibernate.property length="32" column="bank_code" not-null="false"
	 */
	public String getBankCode() {
		return bankCode;
	}

	/**
	 * 
	 * Returns the bankName
	 * 
	 * @return String
	 * 
	 * @hibernate.property length="128" column="bank_name" not-null="false"
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * 
	 * Returns the fax
	 * 
	 * @return String
	 * 
	 * @hibernate.property length="128" column="fax" not-null="false"
	 */
	public String getFax() {
		return fax;
	}

	/**
	 * 
	 * Returns the linkMan
	 * 
	 * @return String
	 * 
	 * @hibernate.property length="32" column="link_man" not-null="false"
	 */
	public String getLinkMan() {
		return linkMan;
	}

	/**
	 * 
	 * Returns the tel
	 * 
	 * @return String
	 * 
	 * @hibernate.property length="255" column="tel" not-null="false"
	 */
	public String getTel() {
		return tel;
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
	 * Returns the address
	 * 
	 * @return Address
	 * 
	 * @hibernate.component
	 */
	public Address getAddress() {
		return address;
	}
	
	/**
	 * 
	 * Returns the reportTitle
	 * @return String 
	 * 
	 * @hibernate.property length="128" column="report_title" not-null="false"
	 */
	public String getReportTitle() {
		return reportTitle;
	}
	
	
	/**
	 * 
	 * Returns the logo
	 * @return blob 
	 * 
	 * @hibernate.property column="logo" type="blob" not-null="false"
	 */
	public byte[] getLogo() {
		return logo;
	}
	/**
	 * 
	 * Returns the logoType
	 * @return String 
	 * 
	 * @hibernate.property length="32" column="logo_type" not-null="false"
	 */
	public String getLogoType() {
		return logoType;
	}

	/**
	 * @hibernate.set name="branchs" table="tb_sys_branch" inverse="false" cascade="none" lazy="false"          
	 * @hibernate.collection-key column="sys_org_id"
	 * @hibernate.collection-one-to-many class="com.vriche.adrm.model.Branch"  column="sys_branch_id"
	 *                                  
	 */
	public Set getBranchs() {
		return branchs;
	}

	/**
	 * @param bankCode
	 *            The bankCode to set.
	 */
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	/**
	 * @param bankName
	 *            The bankName to set.
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
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
	 * @param fax
	 *            The fax to set.
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}

	/**
	 * @param id
	 *            The id to set.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param linkMan
	 *            The linkMan to set.
	 */
	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
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
	 * @param name
	 *            The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param tel
	 *            The tel to set.
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @param version
	 *            The version to set.
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * @param address
	 *            The address to set.
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @param branch
	 *            The branch to set.
	 */
	public void setBranchs(Set branchs) {
		this.branchs = branchs;
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



	/** 
	 * @param reportTitle The reportTitle to set.
	 */
	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}



	public void setLogo(byte[] logo) {
		this.logo = logo;
	}



	public void setLogoType(String logoType) {
		this.logoType = logoType;
	}

	public User getSysAdmin() {
//		String fullName1 = sysAdmin.getFirstName() == null?"":sysAdmin.getFirstName();
//		String fullName2 = sysAdmin.getLastName() == null?"":sysAdmin.getLastName();
//		sysAdmin.setFullName(fullName1+fullName2);
		return sysAdmin;
	}

	public void setSysAdmin(User sysAdmin) {
		this.sysAdmin = sysAdmin;
	}

	public String getLogFile() {
		return logFile;
	}

	public void setLogFile(String logFile) {
		this.logFile = logFile;
	}

	public String getLogFileRel() {
		return logFileRel;
	}

	public void setLogFileRel(String logFileRel) {
		this.logFileRel = logFileRel;
	}

	public String getReportSignature() {
		return reportSignature;
	}

	public void setReportSignature(String reportSignature) {
		this.reportSignature = reportSignature;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	public Integer getDisplayNo() {
		return displayNo;
	}

	public void setDisplayNo(Integer displayNo) {
		this.displayNo = displayNo;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

}
