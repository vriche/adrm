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

//import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
//import java.util.List;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
/**
 * Compages class
 * 
 * This class is used to 
 * 
 * <p><a href="Compages.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_ad_resource_compages"
 * 
 */
public class Compages extends BaseObject {
 
	private static final long serialVersionUID = 8370092790822135861L;
	protected Long id;
    protected String name;
    protected Long createBy;				  //default sysdate
    protected Date createDate;					  
    protected Long modifyBy;				  //default sysdate
    protected Date modifyDate;					  
    protected Integer version;
    protected String memo;
    protected Set resources = new HashSet();
    protected Boolean enable;
    protected Boolean isAutoPrice;
    protected String[]  resourceIds;
    
    protected Long mediaorgId;	
    
    private Long orgId;
    
    protected Long priceId;
    protected Long priceTypeId;
//    protected Long priceDetailId;
    protected Set compagesPrices = new HashSet();
    
    public Compages(){};
    public Compages(String name) {
        this.name = name;
    }

//    /**
//	 * 
//	 * Returns the priceDetailId
//	 * @return Long
//	 * 
//	 * @hibernate.property length="128" column="priceDetailId" not-null="false"
//	 */
//	public Long getPriceDetailId() {
//		return priceDetailId;
//	}
//	/**
//	 * @param priceDetailId The priceDetailId to set.
//	 */
//	public void setPriceDetailId(Long priceDetailId) {
//		this.priceDetailId = priceDetailId;
//	}
	/**
     * @hibernate.id column="ad_resource_compages_id" generator-class="native" unsaved-value="null"
     */
    public Long getId() {
        return id;
    }
    /**
     * 
     * Returns the name
     * @return String
     * @struts.validator type="required"
     * @hibernate.property column="name" length="128" not-null="true" unique="true"
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
     * Returns the memo
     * @return String
     * 
     * @hibernate.property length="256" column="memo" not-null="false"
     */
    public String getMemo() {
        return memo;
    }   
    
    
    /**
     * @hibernate.set table="tb_ad_resource_package_pos_rel" inverse="false" cascade="all" lazy="false"
     * @hibernate.collection-key column="ad_resource_compages_id"
     * @hibernate.collection-many-to-many class="com.vriche.adrm.model.Resource" column="ad_resource_info_id"
     */
    public Set getResources() {
        return resources;
    }
    

    /**
     * 
     * Returns the enable
     * @return Boolean
     * 
     * @hibernate.property column="enable" not-null="true"   type="yes_no"
     */
    public Boolean getEnable() {
        return enable;
    }

	public Long getPriceId() {
		return priceId;
	}
	
	
	
	
	
	public void setPriceId(Long priceId) {
		this.priceId = priceId;
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
     * @param enable The enable to set.
     */
    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
    /**
     * @param id The id to set.
     */
    public void setId(Long id) {
        this.id = id;
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
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @param version The version to set.
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
    /**
     * @param resources The resources to set.
     */
    public void setResources(Set resources) {
        this.resources = resources;
    }

    
    /**
     * @see java.lang.Object#equals(Object)
     */
    public boolean equals(Object object) {
        if (!(object instanceof Compages)) {
            return false;
        }
        Compages rhs = (Compages) object;
        return new EqualsBuilder().append(
                this.memo, rhs.memo).append(this.resources, rhs.resources)
                .append(this.modifyBy, rhs.modifyBy).append(this.modifyDate,
                        rhs.modifyDate).append(this.createDate, rhs.createDate)
                .append(this.createBy, rhs.createBy)
                .append(this.name, rhs.name).append(this.id, rhs.id).append(
                        this.enable, rhs.enable).append(this.version,
                        rhs.version).isEquals();
    }
    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder(-1546313235, -1219207411).append(this.memo).append(this.resources)
                .append(this.modifyBy).append(this.modifyDate).append(
                        this.createDate).append(this.createBy)
                .append(this.name).append(this.id).append(this.enable).append(
                        this.version).toHashCode();
    }
    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return new ToStringBuilder(this).append("name", this.name).append(
                "modifyBy", this.modifyBy).append("id", this.id).append(
                "resources", this.resources).append("version", this.version)
                .append("modifyDate", this.modifyDate).append("enable",
                        this.enable).append("memo", this.memo).append(
                        "createBy", this.createBy).append("createDate",
                        this.createDate).toString();
    }
	/**
	 * 
	 * Returns the isAutoPrice
	 * @return Boolean 
	 * 
	 * @hibernate.property length="1" column="is_auto_price" not-null="true"
	 */
	public Boolean getIsAutoPrice() {
		return isAutoPrice;
	}
	/** 
	 * @param isAutoPrice The isAutoPrice to set.
	 */
	public void setIsAutoPrice(Boolean isAutoPrice) {
		this.isAutoPrice = isAutoPrice;
	}
	/**
	 * 
	 * Returns the resourceIds
	 * @return String[] 
	 * 
	 */
	public String[] getResourceIds() {
		return resourceIds;
	}
	/** 
	 * @param resourceIds The resourceIds to set.
	 */
	public void setResourceIds(String[] resourceIds) {
		this.resourceIds = resourceIds;
	}
	
	/**
     * @hibernate.set table="tb_ad_resource_compages_price_rel" inverse="false" cascade="all" lazy="false"
     * @hibernate.collection-key column="ad_resource_compages_id"
     * @hibernate.collection-many-to-many class="com.vriche.adrm.model.Price" column="ad_resource_price_id"
     */
	public Set getCompagesPrices() {
		return compagesPrices;
	}
	public void setCompagesPrices(Set compagesPrices) {
		this.compagesPrices = compagesPrices;
	}
	public Long getOrgId() {
		return orgId;
	}
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public Long getMediaorgId() {
		return mediaorgId;
	}
	public void setMediaorgId(Long mediaorgId) {
		this.mediaorgId = mediaorgId;
	}
	public Long getPriceTypeId() {
		return priceTypeId;
	}
	public void setPriceTypeId(Long priceTypeId) {
		this.priceTypeId = priceTypeId;
	}

}
