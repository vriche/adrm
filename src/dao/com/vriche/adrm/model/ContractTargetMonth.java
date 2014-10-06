package com.vriche.adrm.model;
/**
 * contractTargetMonth class
 * 
 * This class is used to 
 * 
 * <p><a href="contractTargetMonth.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_contract_target_month"
 * 
 */
public class ContractTargetMonth extends BaseObjectWithoutNestedFormValidation {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Long id;
	protected Long contractTargetId;
	protected Integer monthDate;
	protected Integer yearDate;
	protected Double monthTarg;
	protected Double monthReal;
    protected Integer version;
	protected ContractTarget contractTarget;
	
    
    /**
     * @hibernate.id column="contract_target_month_id" generator-class="native" unsaved-value="null"
     */
    public Long getId() {
        return id;
    }
    /**
	 * 
	 * Returns the contractTargetId
	 * @return Long 
	 * 
	 * @bak_hibernate.property length="128" column="contract_target_id" not-null="true"
	 */
	public Long getContractTargetId() {
		return contractTargetId;
	}
    /**
	 * 
	 * Returns the monthDate
	 * @return Integer 
     * @struts.validator type="required"* 
	 * @hibernate.property length="8" column="month_date" not-null="true"
	 */
	public Integer getMonthDate() {
		return monthDate;
	}
    /**
	 * 
	 * Returns the yearDate
	 * @return Integer 
     * @struts.validator type="required"* 
	 * @hibernate.property length="8" column="year_date" not-null="true"
	 */
    public Integer getYearDate() {
		return yearDate;
	}
	/**
	 * 
	 * Returns the monthTarg
	 * @return Double 
	 * 
	 * @hibernate.property length="128" column="month_targ" not-null="true"
	 */
	public Double getMonthTarg() {
		return monthTarg;
	}
    /**
	 * 
	 * Returns the monthReal
	 * @return Double 
	 * 
	 * @hibernate.property length="128" column="month_real" not-null="true"
	 */
	public Double getMonthReal() {
		return monthReal;
	}

    /**
     * @hibernate.version
     */
    public Integer getVersion() {
        return version;
    }
    
	/**
     * @hibernate.many-to-one name="contractTargetId" column="contract_target_id" cascade="all" not-null="true"
	 */
	public ContractTarget getContractTarget() {
		return contractTarget;
	}


	public void setId(Long id) {
		this.id = id;
	}
	public void setContractTargetId(Long contractTargetId) {
		this.contractTargetId = contractTargetId;
	}

	public void setMonthDate(Integer monthDate) {
		this.monthDate = monthDate;
	}

	public void setYearDate(Integer yearDate) {
		this.yearDate = yearDate;
	}
	public void setMonthReal(Double monthReal) {
		this.monthReal = monthReal;
	}	
	
	public void setMonthTarg(Double monthTarg) {
		this.monthTarg = monthTarg;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	
	
	public void setContractTarget(ContractTarget contractTarget) {
		this.contractTarget = contractTarget;
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
