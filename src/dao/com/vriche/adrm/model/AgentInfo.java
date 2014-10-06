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

import java.io.Serializable;
//import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


import com.vriche.adrm.model.Industry;


/**
 * AgentInfo class
 * 
 * This class is used to 
 * 
 * <p><a href="AgentInfo.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * 
 * @hibernate.class table="tb_customer_agent_info"
 */
public class AgentInfo extends  BaseObjectWithoutNestedFormValidation  implements Serializable {
    

	private static final long serialVersionUID = 3532626162173359411L;
	protected Long id;
    protected Long customerId;           // required; 
    protected Integer agenetType;
    protected Long resourcePriceTypeId;
    protected Long industryTypeId;
    protected Double agentRate;
    protected Integer beginDate;
    protected Integer endDate;
    protected Integer state;

    protected Long createBy;				  //default sysdate
    protected Date createDate;					  
    protected Long modifyBy;				  //default sysdate
    protected Date modifyDate;					  
    protected Integer version;
    protected Long contractId;

    protected Long carrierId;
    protected Long resourceSortId;
    protected Double lowestRate;
    protected Boolean enable;
    protected Long customerCategoryId;
    
    protected Industry industry = new Industry();
    protected Carrier carrier = new Carrier();
    protected ResourceSort resourceSort = new ResourceSort();
    protected Category category = new Category();
    
	/**
     * 
     * Returns the customerCategoryId
     * @return Long
     * 
     * @hibernate.property length="20" column="customer_category_id" not-null="true"
     */
    public Long getCustomerCategoryId() {
		return customerCategoryId;
	}

    /**
     * @param customerCategoryId The customerCategoryId to set.
     */
	public void setCustomerCategoryId(Long customerCategoryId) {
		this.customerCategoryId = customerCategoryId;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public ResourceSort getResourceSort() {
		return resourceSort;
	}


	public void setResourceSort(ResourceSort resourceSort) {
		this.resourceSort = resourceSort;
	}


	public AgentInfo(){}
    
    
    /**
     * 
     * Returns the enable
     * @return Boolean
     * 
     * @hibernate.property  column="enable" not-null="true"  type="yes_no"
     */
    public Boolean getEnable() {
		return enable;
	}
    /**
     * @param enable The enable to set.
     */
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}


    /**
     * 
     * Returns the lowestRate
     * @return Double
     * 
     * @hibernate.property length="12" column="lowest_rate" not-null="true"
     */
	public Double getLowestRate() {
		return lowestRate;
	}
    /**
     * @param lowestRate The enable to set.
     */
	public void setLowestRate(Double lowestRate) {
		this.lowestRate = lowestRate;
	}



	/**
     * 
     * Returns the resourceSortId
     * @return Long
     * 
     * @hibernate.property length="20" column="ad_resource_sort_id" not-null="true"
     */
    public Long getResourceSortId() {
		return resourceSortId;
	}

    /**
     * @param resourceSortId The resourceSortId to set.
     */
	public void setResourceSortId(Long resourceSortId) {
		this.resourceSortId = resourceSortId;
	}

    /**
	 * 
	 * Returns the carrierId
	 * @return Long 
	 * 
	 * @hibernate.property length="128" column="resource_carrier_id" not-null="true"
	 */
	public Long getCarrierId() {
		return carrierId;
	}

    /**
     * @param carrierId The carrierId to set.
     */
	public void setCarrierId(Long carrierId) {
		this.carrierId = carrierId;
	}


	/**
     * @hibernate.id column="customer_agent_info_id" generator-class="native" unsaved-value="null"
     */
    public Long getId() {
        return id;
    }
    /**
     * 
     * Returns the agenetType
     * @return Integer
     * 
     * @hibernate.property length="20" column="customer_agenet_type" not-null="false"
     */
    public Integer getAgenetType() {
        return agenetType;
    }
    

    /**
     * 
     * Returns the industryTypeId
     * @return Long
     * 
     * @hibernate.property length="20" column="ad_resource_price_type_id" not-null="false"
     */
	public Long getResourcePriceTypeId() {
		return resourcePriceTypeId;
	}
	
    /**
     * 
     * Returns the agentRate
     * @return Double
     * 
     * @hibernate.property length="12" column="agent_rate" not-null="false"
     */
    public Double getAgentRate() {
        return agentRate;
    }
    /**
     * 
     * Returns the beginDate
     * @return Integer
     * 
     * @hibernate.property length="8" column="begin_date" not-null="false"
     */
    public Integer getBeginDate() {
        return beginDate;
    }
    /**
     * 
     * Returns the customerId
     * @return Long
     * @struts.validator type="required"
     * @hibernate.property length="20" column="customer_id" not-null="false"
     */
    public Long getCustomerId() {
        return customerId;
    }
    /**
     * 
     * Returns the endDate
     * @return Integer
     * 
     * @hibernate.property length="8" column="end_date" not-null="false"
     */
    public Integer getEndDate() {
        return endDate;
    }
    /**
     * 
     * Returns the industryTypeId
     * @return Long
     * 
     * @hibernate.property length="20" column="customer_industry_type_id" not-null="false"
     */
    public Long getIndustryTypeId() {
        return industryTypeId;
    }
    /**
     * 
     * Returns the state
     * @return Integer
     * 
     * @hibernate.property length="2" column="state" not-null="false"
     */
    public Integer getState() {
        return state;
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
     * @hibernate.version column="version"
     */
    public Integer getVersion() {
        return version;
    }
    
    
	public Industry getIndustry() {
		return industry;
	}

   
    
    
  
    
    /**
     * @param id The id to set.
     */
    public void setId(Long id) {
        this.id = id;
    }  
    /**
     * @param agenetType The agenetType to set.
     */
    public void setAgenetType(Integer agenetType) {
        this.agenetType = agenetType;
    }
    /**
     * @param agentRate The agentRate to set.
     */
    public void setAgentRate(Double agentRate) {
        this.agentRate = agentRate;
    }
    /**
     * @param beginDate The beginDate to set.
     */
    public void setBeginDate(Integer beginDate) {
        this.beginDate = beginDate;
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
     * @param endDate The endDate to set.
     */
    public void setEndDate(Integer endDate) {
        this.endDate = endDate;
    }

    /**
     * @param industryTypeId The industryTypeId to set.
     */
    public void setIndustryTypeId(Long industryTypeId) {
        this.industryTypeId = industryTypeId;
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
     * @param state The state to set.
     */
    public void setState(Integer state) {
        this.state = state;
    }

	public void setResourcePriceTypeId(Long resourcePriceTypeId) {
		this.resourcePriceTypeId = resourcePriceTypeId;
	}
    /**
     * @param version The version to set.
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
    
	public void setIndustry(Industry industry) {
		this.industry = industry;
	}
//	
//	/** 
//	 * @param createDate The createDate to set.
//	 */
//	public void setCreateDate(Date createDate) {
//		this.createDate = createDate;
//	}
//
//
//	/** 
//	 * @param modifyDate The modifyDate to set.
//	 */
//	public void setModifyDate(Date modifyDate) {
//		this.modifyDate = modifyDate;
//	}

    
    /**
     * @see java.lang.Object#equals(Object)
     */
    public boolean equals(Object object) {
        if (!(object instanceof AgentInfo)) {
            return false;
        }
        AgentInfo rhs = (AgentInfo) object;
        return new EqualsBuilder().append(
                this.beginDate, rhs.beginDate).append(this.agenetType,
                rhs.agenetType).append(this.agentRate, rhs.agentRate).append(
                this.modifyBy, rhs.modifyBy).append(this.state, rhs.state)
                .append(this.modifyDate, rhs.modifyDate).append(
                        this.createDate, rhs.createDate).append(this.endDate,
                        rhs.endDate).append(this.industryTypeId,
                        rhs.industryTypeId).append(this.createBy, rhs.createBy)
                .append(this.id, rhs.id).append(this.version, rhs.version)
                .append(this.customerId, rhs.customerId).append(this.contractId, rhs.contractId).isEquals();
    }
    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder(1225948403, -49899205).append(this.beginDate)
                .append(this.agenetType).append(this.agentRate).append(
                        this.modifyBy).append(this.state).append(
                        this.modifyDate).append(this.createDate).append(
                        this.endDate).append(this.industryTypeId).append(
                        this.createBy).append(this.id).append(this.version)
                .append(this.customerId).append(this.contractId).toHashCode();
    }
    /**
	 * 
	 * Returns the contractId
	 * @return Long
	 * 
	 *@hibernate.property length="128" column="contract_id" not-null="false"
	 */
	public Long getContractId() {
		return contractId;
	}


	/**
	 * @param contractId The contractId to set.
	 */
	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}


	public Carrier getCarrier() {
		return carrier;
	}


	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("modifyBy", this.modifyBy)
				.append("id", this.id).append("carrierId", this.carrierId)
				.append("lowestRate", this.lowestRate).append("modifyDate",
						this.modifyDate).append("enable", this.enable).append(
						"createBy", this.createBy).append(
						"resourcePriceTypeId", this.resourcePriceTypeId)
				.append("resourceSortId", this.resourceSortId).append(
						"endDate", this.endDate).append("contractId",
						this.contractId).append("industryTypeId",
						this.industryTypeId).append("industry", this.industry)
				.append("customerCategoryId", this.customerCategoryId).append(
						"customerId", this.customerId).append("beginDate",
						this.beginDate).append("agentRate", this.agentRate)
				.append("state", this.state).append("agenetType",
						this.agenetType).append("version", this.version)
				.append("resourceSort", this.resourceSort).append("carrier",
						this.carrier).append("category", this.category).append(
						"createDate", this.createDate).toString();
	}




}
