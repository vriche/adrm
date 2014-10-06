/****************************************************************************     
 * Created on 2007-8-24                                      *    
 *                                                               			*
 * @author <a href="mailto:hongxilin@yahoo.com.cn">hongxi</a>               *
 *         Updated by hongxi (hongxilin@yahoo.com.cn)                       *
 *                                                                          *
 * @version  Vision:1.0														*
 * 																			*
 ***************************************************************************/
package com.vriche.adrm.model;

import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * OaTelephone class
 * 
 * This class is used to 
 * 
 * <p><a href="OaTeleExpenses.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_oa_tel_expenses" 
 * OaTeleExpenses
 */
public class OaTeleExpenses extends BaseObjectWithoutNestedFormValidation {

	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 4953684820627499354L;
	protected Long id;
	protected Long branchId;     // required 
	protected Double expenses;    
	protected Integer registerDate;     // required 
	
	protected Long createBy; 	 // default sysdate
	protected Date createDate;
	protected Long modifyBy; 	 // default sysdate
	protected Date modifyDate;
	protected Integer version;
	
	protected Branch branch = new Branch();
	/**
	 * @hibernate.id column="id" generator-class="native"
	 *               unsaved-value="null"
	 */
	public Long getId() {
		return id;
	}
	

	/**
	 * 
	 * Returns the expenses
	 * @return Double 
	 * @struts.validator type="required"
	 * @hibernate.property length="128" column="tele_expenses" not-null="true"
	 */
	public Double getExpenses() {
		return expenses;
	}	
	/**
	 * 
	 * Returns the registerDate
	 * @return Integer 
	 * @struts.validator type="required"
	 * @hibernate.property length="8" column="register_date" not-null="true"
	 */
	public Integer getRegisterDate() {
		return registerDate;
	}
	
	
	
	
	/**
	 * 
	 * Returns the branchId
	 * @return Long 
	 * @struts.validator type="required"
	 * @hibernate.property length="128" column="branch_id" not-null="true"
	 */
	public Long getBranchId() {
		return branchId;
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
	 * @hibernate.property column="create_date" update="false" insert="true" not-null="false"
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
	 * @hibernate.property column="modify_date" update="false" insert="true" not-null="false"
	 *                     type="timestamp"
	 */
	public Date getModifyDate() {
		return modifyDate;
	}
	
    /**
     * @hibernate.many-to-one name="branchId" column="branch_id" cascade="all" not-null="true"
     */
	public Branch getBranch() {
		return branch;
	}

	
	
	
	

	/**
	 * @param branch The branch to set.
	 */
	public void setBranch(Branch branch) {
		this.branch = branch;
	}	

	/** 
	 * @param branchId The branchId to set.
	 */
	public void setBranchId(Long branchId) {
		this.branchId = branchId;
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
	 * @param expenses The expenses to set.
	 */
	public void setExpenses(Double expenses) {
		this.expenses = expenses;
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
	 * @param regDate The registerDate to set.
	 */
	public void setRegisterDate(Integer registerDate) {
		this.registerDate = registerDate;
	}
	

	/** 
	 * @param version The version to set.
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}


	/**
	 * @hibernate.version
	 */
	public Integer getVersion() {
		return version;
	}		
	
	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof OaTeleExpenses)) {
			return false;
		}
		OaTeleExpenses rhs = (OaTeleExpenses) object;
		return new EqualsBuilder().append(
				this.branchId, rhs.branchId)
				.append(this.expenses, rhs.expenses).append(this.registerDate,
						rhs.registerDate).append(this.branch, rhs.branch)
				.append(this.modifyBy, rhs.modifyBy).append(this.modifyDate,
						rhs.modifyDate).append(this.createDate, rhs.createDate)
				.append(this.createBy, rhs.createBy).append(this.id, rhs.id)
				.append(this.version, rhs.version).isEquals();
	}


	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(545249035, 977339887).append(this.branchId).append(this.expenses)
				.append(this.registerDate).append(this.branch).append(
						this.modifyBy).append(this.modifyDate).append(
						this.createDate).append(this.createBy).append(this.id)
				.append(this.version).toHashCode();
	}


	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("expenses", this.expenses)
				.append("modifyBy", this.modifyBy).append("id", this.id)
				.append("version", this.version).append("modifyDate",
						this.modifyDate).append("registerDate",
						this.registerDate).append("branch", this.branch)
				.append("createBy", this.createBy).append("createDate",
						this.createDate).append("branchId", this.branchId)
				.toString();
	}











}
