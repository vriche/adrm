/****************************************************************************     
 * Created on 2007-4-9                                      *    
 *                                                               			*
 * @author <a href="mailto:hongxilin@yahoo.com.cn">hongxi</a>               *
 *         Updated by hongxi (hongxilin@yahoo.com.cn)                       *
 *                                                                          *
 * @version  Vision:1.0														*
 * 																			*
 ***************************************************************************/
package com.vriche.adrm.model;

import java.io.Serializable;
import java.util.Date;
import com.vriche.adrm.model.BaseObject;

/**
 * contractTarget class
 * 
 * This class is used to 
 * 
 * <p><a href="contractTarget.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_contract_target"
 * 
 */
public class ContractTarget extends BaseObjectWithoutNestedFormValidation   implements Serializable{
	

	private static final long serialVersionUID = 1L;
	protected Long id;
    protected Long contractId;
    protected Long carrierId;
    protected Long industryTypeId;
    protected Double target;
    
    protected Long createBy;				  //default sysdate
    protected Date createDate;					  
    protected Long modifyBy;				  //default sysdate
    protected Date modifyDate;					  
    protected Integer version;
    protected String memo;
    
    protected Contract contract = new Contract();
    protected Carrier carrier = new Carrier();
    protected Industry industry = new Industry();
    
    public ContractTarget(){};
    
    
    
    /**
     * @hibernate.id column="contract_target_id" generator-class="native" unsaved-value="null"
     */
    public Long getId() {
        return id;
    }
    
    /**
	 * 
	 * Returns the carrierId
	 * @return Long 
	 * 
	 * @hibernate.property length="128" column="resource_carrier_id" not-null="false"
	 */
	public Long getCarrierId() {
		return carrierId;
	}


	/**
	 * 
	 * Returns the contractId
	 * @return Long 
     * @struts.validator type="required"
	 * @hibernate.property length="128" column="contract_id" not-null="false"
	 */
	public Long getContractId() {
		return contractId;
	}


	/**
	 * 
	 * Returns the industryTypeId
	 * @return Long 
	 * 
	 * @hibernate.property length="128" column="industry_type_id" not-null="false"
	 */
	public Long getIndustryTypeId() {
		return industryTypeId;
	}


	/**
	 * 
	 * Returns the target
	 * @return Double 
	 * 
	 * @hibernate.property length="128" column="target" not-null="false"
	 */
	public Double getTarget() {
		return target;
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
	 * Returns the carrier
	 * @return Carrier 
	 */
	public Carrier getCarrier() {
		return carrier;
	}



	/**
	 * 
	 * Returns the contract
	 * @return Contract 
	 */
	public Contract getContract() {
		return contract;
	}



	/**
	 * 
	 * Returns the industry
	 * @return Industry 
	 */
	public Industry getIndustry() {
		return industry;
	}



	/** 
	 * @param carrierId The carrierId to set.
	 */
	public void setCarrierId(Long carrierId) {
		this.carrierId = carrierId;
	}

	/** 
	 * @param contractId The contractId to set.
	 */
	public void setContractId(Long contractId) {
		this.contractId = contractId;
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
	 * @param modifyDate The modifyDate to set.
	 */
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	/** 
	 * @param target The target to set.
	 */
	public void setTarget(Double target) {
		this.target = target;
	}

	/** 
	 * @param version The version to set.
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
	/** 
	 * @param carrier The carrier to set.
	 */
	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}
	/** 
	 * @param contract The contract to set.
	 */
	public void setContract(Contract contract) {
		this.contract = contract;
	}
	/** 
	 * @param industry The industry to set.
	 */
	public void setIndustry(Industry industry) {
		this.industry = industry;
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
