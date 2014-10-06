/**
 * 
 */
package com.vriche.adrm.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * ProProgram class
 * 
 * This class is used to 
 * 
 * <p><a href="ProProgram.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * 
 * @hibernate.class table="tb_pro_program"
 */
public class ProProgram extends BaseObjectWithoutNestedFormValidation implements Serializable {

	private static final long serialVersionUID = 1L;
	protected Long id;               //节目id 
	protected String proName;        //节目名称
	protected Long typeId;           //节目类型id
	protected String copyrightNum ;  //版权号
	protected Integer startDate ;    //版权开始时间
	protected Integer endDate ;      //版权结束时间
	protected Long customerId ;      //客户id
	protected String businessName ;  //制作单位
	
	protected Long isChecked;       //审核状态
	protected Double  sowCount;     //播出集数
	protected Integer arriveDate;   //到带日期
	protected Integer checkedDate;  //审核日期
	protected Double  price;         //单价
	protected Double  audienceRat;  //收视率
	protected Long isSell;          //是否二次发行
	protected String copyrightArea; //版权区域
	protected Long programStatusId; //节目状态id
	
    protected Integer version;
    protected Long createBy;				  
    protected Date createDate;					  
    protected Long modifyBy;				  
    protected Date modifyDate;	
    
    protected ProProgramType proProgramType = new ProProgramType(); 
    protected ProCustomer proCustomer = new ProCustomer();
    protected List proTypeIdList;

	/**
     * 
     * Returns the copyrightNum
     * @return String
     * 
     * @hibernate.property length="20" column="copyright_num" not-null="false"
     */
	public String getCopyrightNum() {
		return copyrightNum;
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
     * @hibernate.property column="create_date" length="12" update="false" insert="true" type="timestamp"
     */
	public Date getCreateDate() {
		return createDate;
	}

	/**
     * 
     * Returns the endDate
     * @return Date
     * 
     * @hibernate.property length="12" column="end_date" not-null="false"
     */
	public Integer getEndDate() {
		return endDate;
	}

	/**
     * @hibernate.id column="id" generator-class="native" unsaved-value="null"
     */
	public Long getId() {
		return id;
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
     * @return Integer
     * 
    * @hibernate.property column="modify_date" update="false" insert="true" type="timestamp"
     */
	public Date getModifyDate() {
		return modifyDate;
	}

	/**
     * 
     * Returns the proName
     * @return String
     * 
     * @hibernate.property length="20" column="program_name" not-null="true"
     */
	public String getProName() {
		return proName;
	}
	
	/**
     * 
     * Returns the businessName
     * @return String
     * 
     * @hibernate.property length="20" column="business_name" not-null="true"
     */
	public String getBusinessName() {
		return businessName;
	}

	/**
     * @hibernate.many-to-one name="typeId" column="program_type_id" cascade="all" not-null="true"
 	 */
	public ProProgramType getProProgramType() {
		return proProgramType;
	}

	/**
     * 
     * Returns the startDate
     * @return Integer
     * 
     * @hibernate.property length="12" column="start_date" not-null="false"
     */
	public Integer getStartDate() {
		return startDate;
	}


	public Long getTypeId() {
		return typeId;
	}

	/**
     * 
     * Returns the arriveDate
     * @return Integer
     * 
     * @hibernate.property length="12" column="arrive_date" not-null="false"
     */
	public Integer getArriveDate() {
		return arriveDate;
	}
	/**
     * 
     * Returns the audienceRat
     * @return Double
     * 
     * @hibernate.property column="audience_rat" not-null="true"
     */
	public Double getAudienceRat() {
		return audienceRat;
	}
	/**
     * 
     * Returns the checkedDate
     * @return Integer
     * 
     * @hibernate.property length="12" column="checked_date" not-null="true"
     */
	public Integer getCheckedDate() {
		return checkedDate;
	}
	/**
     * 
     * Returns the copyrightArea
     * @return String
     * 
     * @hibernate.property length="100" column="copyright_area" not-null="true"
     */
	public String getCopyrightArea() {
		return copyrightArea;
	}
	/**
     * 
     * Returns the isChecked
     * @return Long
     * 
     * @hibernate.property length="20" column="is_checked" not-null="false"
     */
	public Long getIsChecked() {
		return isChecked;
	}
	/**
     * 
     * Returns the isSell
     * @return Long
     * 
     * @hibernate.property length="20" column="is_sell" not-null="false"
     */
	public Long getIsSell() {
		return isSell;
	}
	/**
     * 
     * Returns the price
     * @return Double
     * 
     * @hibernate.property column="price" not-null="true"
     */
	public Double getPrice() {
		return price;
	}
	/**
     * 
     * Returns the sowCount
     * @return Double
     * 
     * @hibernate.property column="sow_count" not-null="true"
     */
	public Double getSowCount() {
		return sowCount;
	}

	/**
     * @hibernate.version length="10" column="version"
     */
	public Integer getVersion() {
		return version;
	}

	
	public Long getCustomerId() {
		return customerId;
	}

	/**
     * @hibernate.many-to-one name="customerId" column="customer_id" cascade="all" not-null="true"
 	 */
	public ProCustomer getProCustomer() {
		return proCustomer;
	}

	/**
	 * @param proCustomer The proCustomer to set.
	 */
	public void setProCustomer(ProCustomer proCustomer) {
		this.proCustomer = proCustomer;
	}

	/**
	 * @param customerId The customerId to set.
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	/**
	 * @param copyrightNum The copyrightNum to set.
	 */
	public void setCopyrightNum(String copyrightNum) {
		this.copyrightNum = copyrightNum;
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
	 * @param proName The proName to set.
	 */
	public void setProName(String proName) {
		this.proName = proName;
	}

	/**
	 * @param proProgramType The proProgramType to set.
	 */
	public void setProProgramType(ProProgramType proProgramType) {
		this.proProgramType = proProgramType;
	}

	/**
	 * @param startDate The startDate to set.
	 */
	public void setStartDate(Integer startDate) {
		this.startDate = startDate;
	}

	/**
	 * @param typeId The typeId to set.
	 */
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	
	/**
	 * @param arriveDate The arriveDate to set.
	 */
	public void setArriveDate(Integer arriveDate) {
		this.arriveDate = arriveDate;
	}
	/**
	 * @param audienceRat The audienceRat to set.
	 */
	public void setAudienceRat(Double audienceRat) {
		this.audienceRat = audienceRat;
	}
	/**
	 * @param checkedDate The checkedDate to set.
	 */
	public void setCheckedDate(Integer checkedDate) {
		this.checkedDate = checkedDate;
	}
	/**
	 * @param copyrightArea The copyrightArea to set.
	 */
	public void setCopyrightArea(String copyrightArea) {
		this.copyrightArea = copyrightArea;
	}
	/**
	 * @param isChecked The isChecked to set.
	 */
	public void setIsChecked(Long isChecked) {
		this.isChecked = isChecked;
	}
	/**
	 * @param isSell The isSell to set.
	 */
	public void setIsSell(Long isSell) {
		this.isSell = isSell;
	}
	/**
	 * @param price The price to set.
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	/**
	 * @param sowCount The sowCount to set.
	 */
	public void setSowCount(Double sowCount) {
		this.sowCount = sowCount;
	}

	/**
	 * @param version The version to set.
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	public String toString() {
		return null;
	}

	public boolean equals(Object o) {
		return false;
	}

	public int hashCode() {
		return 0;
	}

	/**
	 * @return Returns the proTypeIdList.
	 */
	public List getProTypeIdList() {
		return proTypeIdList;
	}

	/**
	 * @param proTypeIdList The proTypeIdList to set.
	 */
	public void setProTypeIdList(List proTypeIdList) {
		this.proTypeIdList = proTypeIdList;
	}

	public Long getProgramStatusId() {
		return programStatusId;
	}

	public void setProgramStatusId(Long programStatusId) {
		this.programStatusId = programStatusId;
	}



}
