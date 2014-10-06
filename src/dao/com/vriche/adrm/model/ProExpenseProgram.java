/**
 * 
 */
package com.vriche.adrm.model;

import java.io.Serializable;
import java.util.Date;

/**
 * ProProgramType class
 * 
 * This class is used to 
 * 
 * <p><a href="ProProgramType.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * 
 * @hibernate.class table="tb_pro_program_type"
 */
public class ProExpenseProgram extends BaseObjectWithoutNestedFormValidation
		implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5990847682211383749L;
	protected Long programId ;                //节目id 
	protected Long expenseId ;                //费用类别id
	protected Double expenseMoney;           //费用
	
	protected Integer version;
    protected Long createBy;				  
    protected Date createDate;					  
    protected Long modifyBy;				  
    protected Date modifyDate;
    
	public Long getCreateBy() {
		return createBy;
	}
	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Double getExpenseMoney() {
		return expenseMoney;
	}
	public void setExpenseMoney(Double expenseMoney) {
		this.expenseMoney = expenseMoney;
	}
	public Long getExpenseId() {
		return expenseId;
	}
	public void setExpenseId(Long expenseId) {
		this.expenseId = expenseId;
	}
	public Long getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(Long modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public Long getProgramId() {
		return programId;
	}
	public void setProgramId(Long programId) {
		this.programId = programId;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
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
