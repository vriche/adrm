/****************************************************************************     
 * Created on 2006-10-15                                                     *    
 *                                                               			*
 * @author <a href="mailto:hongxilin@yahoo.com.cn">hongxi</a>               *
 *         Updated by hongxi (hongxilin@yahoo.com.cn)                       *
 *                                                                          *
 * @version  Vision:1.0														*
 * 																			*
 ***************************************************************************/
package com.vriche.adrm.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.vriche.adrm.model.BaseObject;
/**
 * Price class
 * 
 * This class is used to 
 * 
 * <p><a href="Price.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_ad_resource_price"
 * 
 */
public class Price extends BaseObject {
    private static final long serialVersionUID = 3832626162173359411L;
    
    protected Long id;
    protected String name;
    protected String memo;
    protected Long createBy;				  //default sysdate
    protected Date createDate;					  
    protected Long modifyBy;				  //default sysdate
    protected Date modifyDate;					  
    protected Integer version;
    
    protected Integer resourceType;
    protected Long resourcePriceType;
    protected String moneyType;
    protected Boolean isDefault;
    protected Boolean isUseRegular;

    protected Resource resource;
    
    protected Compages compages;
    
    protected Set priceDetails = new HashSet();
    
    protected PriceDetail priceDetail = new PriceDetail();
    
    protected PriceType priceType = new PriceType();
    
    protected Long orgId;
    
    public Price(){};
    public Price(String name) {
        this.name = name;
    }

    /**
     * @hibernate.id column="ad_resource_price_id" generator-class="native" unsaved-value="null"
     */
    public Long getId() {
        return id;
    }
    /**
     * 
     * Returns the name
     * @return String
     * @struts.validator type="required"
     * @hibernate.property column="name" length="128" not-null="true"
     */
    public String getName() {
        return name;
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
     * Returns the resourceType
     * @return Integer
     * 
     * @hibernate.property length="2" column="ad_resource_type" not-null="false"
     */
    public Integer getResourceType() {
        return resourceType;
    }
    /**
     * 
     * Returns the resourcePriceType
     * @return Long
     * 
     * @hibernate.property length="20" column="ad_resource_price_type" not-null="false"
     */
    public Long getResourcePriceType() {
        return resourcePriceType;
    }
    /**
     * 
     * Returns the moneyType
     * @return String
     * 
     * @hibernate.property length="16" column="money_type" not-null="false"
     */
    public String getMoneyType() {
        return moneyType;
    }
    /**
     * 
     * Returns the isDefault
     * @return Boolean
     * 
     * @hibernate.property length="1" column="is_default" not-null="false"  type="yes_no"
     */
    public Boolean getIsDefault() {
        return isDefault;
    }
    /**
     * 
     * Returns the isUseRegular
     * @return Boolean
     * 
     * @hibernate.property length="1" column="is_use_regular" not-null="false"  type="yes_no"
     */
    public Boolean getIsUseRegular() {
        return isUseRegular;
    }
    

    /**
     * @hibernate.set table="tb_ad_resource_price_detail_rel" cascade="save-update" lazy="false"
     * @hibernate.collection-key column="ad_resource_price_id"
     * @hibernate.collection-many-to-many class="com.vriche.adrm.model.PriceDetail" column="ad_resource_price_detail_id"
     */
    public Set getPriceDetails() {
        return priceDetails;
    }
    

	public PriceDetail getPriceDetail() {
		return priceDetail;
	}    
    
    /**
     * 
     * Returns the moneyType
     * @return String
     * 
     * @hibernate.property length="256" column="memo" not-null="false"
     */
    public String getMemo() {
		return memo;
	}
    
	public Resource getResource() {
		return resource;
	}  
	public PriceType getPriceType() {
		return priceType;
	}   
    

	public Compages getCompages() {
		return compages;
	}

	
	
	
	
	
	
	
	
	
	public void setCompages(Compages compages) {
		this.compages = compages;
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
     * @param isDefault The isDefault to set.
     */
    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }
    /**
     * @param isUseRegular The isUseRegular to set.
     */
    public void setIsUseRegular(Boolean isUseRegular) {
        this.isUseRegular = isUseRegular;
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
     * @param moneyType The moneyType to set.
     */
    public void setMoneyType(String moneyType) {
        this.moneyType = moneyType;
    }
    /**
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @param priceDetails The priceDetails to set.
     */
    public void setPriceDetails(Set priceDetails) {
        this.priceDetails = priceDetails;
    }
    /**
     * @param resourcePriceType The resourcePriceType to set.
     */
    public void setResourcePriceType(Long resourcePriceType) {
        this.resourcePriceType = resourcePriceType;
    }
    /**
     * @param resourceType The resourceType to set.
     */
    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
    }
    /**
     * @param version The version to set.
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
    

	public void setPriceDetail(PriceDetail priceDetail) {
		this.priceDetail = priceDetail;
	} 
    
	public void setResource(Resource resource) {
		this.resource = resource;
	}
	public void setPriceType(PriceType priceType) {
		this.priceType = priceType;
	}
   
    
    
    
    

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof Price)) {
			return false;
		}
		Price rhs = (Price) object;
		return new EqualsBuilder().append(this.isDefault, rhs.isDefault)
				.append(this.priceDetails, rhs.priceDetails).append(this.memo,
						rhs.memo).append(this.modifyBy, rhs.modifyBy).append(
						this.resource, rhs.resource).append(this.createBy,
						rhs.createBy).append(this.id, rhs.id).append(
						this.version, rhs.version).append(this.priceType,
						rhs.priceType).append(this.resourcePriceType,
						rhs.resourcePriceType).append(this.resourceType,
						rhs.resourceType).append(this.priceDetail,
						rhs.priceDetail)
				.append(this.createDate, rhs.createDate).append(
						this.modifyDate, rhs.modifyDate).append(this.name,
						rhs.name).append(this.isUseRegular, rhs.isUseRegular)
				.append(this.moneyType, rhs.moneyType).isEquals();
	}
	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(838554029, -1128305875).append(
				this.isDefault).append(this.priceDetails).append(this.memo)
				.append(this.modifyBy).append(this.resource).append(
						this.createBy).append(this.id).append(this.version)
				.append(this.priceType).append(this.resourcePriceType).append(
						this.resourceType).append(this.priceDetail).append(
						this.createDate).append(this.modifyDate).append(
						this.name).append(this.isUseRegular).append(
						this.moneyType).toHashCode();
	}
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("modifyBy", this.modifyBy)
				.append("id", this.id).append("modifyDate", this.modifyDate)
				.append("moneyType", this.moneyType).append(
						"resourcePriceType", this.resourcePriceType).append(
						"resourceType", this.resourceType).append("memo",
						this.memo).append("createBy", this.createBy).append(
						"name", this.name).append("priceDetails",
						this.priceDetails).append("isUseRegular",
						this.isUseRegular).append("resource", this.resource)
				.append("version", this.version).append("isDefault",
						this.isDefault).append("priceType", this.priceType)
				.append("priceDetail", this.priceDetail).append("createDate",
						this.createDate).toString();
	}
	public Long getOrgId() {
		return orgId;
	}
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}



}
