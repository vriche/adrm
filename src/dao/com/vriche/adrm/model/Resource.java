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

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * Resource class
 * 
 * This class is used to 
 * 
 * <p><a href="Resource.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_ad_resource_info"
 * 
 */
public class Resource extends BaseObject {
    private static final long serialVersionUID = 3832626162173359411L;
    
    
    protected String resourceName;					// required
    protected Long carrierId;					// required
    protected Long parentId;
    protected Integer resourceType;
    protected Long resourceSortId;
    protected Integer propertiyTime;
    protected Long    proResourceId;
    protected String  proResourceMemo;
    protected Integer displayNo;
//  超时封签
    protected Boolean isClosed; 
//  指定加收
    protected Boolean isOverweight;
//  超时封签
    protected Boolean isValidate;
//  启用
    protected Boolean isSeralized;
//  手动价格
    protected Boolean isManual;
//  启用
    protected Boolean enable;
    
    protected Workspan workspan =new Workspan();
    
    protected Double sysPrice;
    
    protected Long id;
    protected Long createBy;				  //default sysdate
    protected Date createDate;					  
    protected Long modifyBy;				  //default sysdate
    protected Date modifyDate;					  
    protected Integer version;
    protected String memo;
    
    protected Integer resourceYear;
    
    protected Integer inPublishDate;
    
    protected Set resourcePrices = new HashSet();
//    protected Set compagesPrices = new HashSet();
    
    protected Set workspans = new HashSet();
    
    protected Carrier carrier = new Carrier();
    
    protected ResourceType resType = new ResourceType();
    
    protected ResourceSort resSort = new ResourceSort();
    
    
    
    

    protected String orgId;
    protected String resourceSort;
    
    protected Integer beforehand;
    
    protected String today;
    
    protected List carrierIdList;
    protected String loginUser;
    protected Integer orderBy;
    
    
    
    
    
    
    public Resource(){};
    public Resource(String resourceName) {
        this.resourceName = resourceName;
    }

    /**
     * @hibernate.id column="ad_resource_info_id" generator-class="native" unsaved-value="null"
     */

    public Long getId() {
        return id;
    }
    /**
     * 
     * Returns the parentId
     * @return Long
     * 
     * @hibernate.property length="128" column="parent_id" not-null="false"
     */
    public Long getParentId() {
        return parentId;
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


    public Long getCarrierId() {
        return carrierId;
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
     * Returns the propertiyTime
     * @return Integer
     * 
     * @hibernate.property length="2" column="ad_resource_propertiy_time" not-null="false"
     */
    public Integer getPropertiyTime() {
        return propertiyTime;
    }

    /**
     * 
     * Returns the proResourceId
     * @return Long
     * 
     * @hibernate.property length="20" column="pro_resource_id" not-null="false"
     */
    public Long getProResourceId() {
        return proResourceId;
    }
    /**
     * 
     * Returns the proResourceMemo
     * @return String
     * 
     * @hibernate.property length="256" column="pro_resource_memo" not-null="false"
     */
    public String getProResourceMemo() {
        return proResourceMemo;
    }
    /**
     * 
     * Returns the displayNo
     * @return Integer
     * 
     * @hibernate.property length="16" column="display_no" not-null="false"
     */
    public Integer getDisplayNo() {
        return displayNo;
    }
    /**
     * 
     * Returns the isClosed
     * @return Boolean
     * 
     * @hibernate.property column="is_closed" not-null="false"  type="yes_no"
     */
    public Boolean getIsClosed() {
        return isClosed;
    }
    /**
     * 
     * Returns the isOverweight
     * @return Boolean
     * 
     * @hibernate.property column="is_overweight" not-null="false"  type="yes_no"
     */
    public Boolean getIsOverweight() {
        return isOverweight;
    }
    /**
     * 
     * Returns the isValidate
     * @return Boolean
     * 
     * @hibernate.property  column="is_validate" not-null="false"  type="yes_no"
     */
    public Boolean getIsValidate() {
        return isValidate;
    }
    /**
     * 
     * Returns the isSeralized
     * @return Boolean
     * 
     * @hibernate.property column="is_seralized" not-null="false"  type="yes_no"
     */
    public Boolean getIsSeralized() {
        return isSeralized;
    }
    /**
     * 
     * Returns the isManual
     * @return Integer
     * 
     * @hibernate.property length="128" column="is_manual" not-null="false"  type="yes_no"
     */
    public Boolean getIsManual() {
        return isManual;
    }
    /**
     * 
     * Returns the resourceName
     * @return String
     * @struts.validator type="required"
     * @hibernate.property length="128" column="resource_name" not-null="true"
     */
    public String getResourceName() {
        return resourceName;
    }
    
    /**
     * 
     * Returns the enable
     * @return Integer
     * 
     * @hibernate.property  column="enable" not-null="false"  type="yes_no"
     */
    public Boolean getEnable() {
        return enable;
    }
    
    /**
     * @hibernate.set table="tb_ad_resource_price_rel" inverse="false" cascade="all" lazy="false"
     * @hibernate.collection-key column="ad_resource_info_id"
     * @hibernate.collection-many-to-many class="com.vriche.adrm.model.Price" column="ad_resource_price_id"
     */
    public Set getResourcePrices() {
        return resourcePrices;
    }
   
    
//    /**
//     * @hibernate.set table="tb_ad_resource_compages_price_rel" inverse="false" cascade="all" lazy="false"
//     * @hibernate.collection-key column="ad_resource_compages_id"
//     * @hibernate.collection-many-to-many class="com.vriche.adrm.model.Price" column="ad_resource_price_id"
//     */
//	public Set getCompagesPrices() {
//		return compagesPrices;
//	}
    /**
     * @hibernate.set name="workspans" table="tb_ad_resource_workspan" inverse="false" cascade="all" lazy="false"
     * @hibernate.collection-key column="ad_resource_info_id"
     * @hibernate.collection-one-to-many class="com.vriche.adrm.model.Workspan"
     */
 
     public Set getWorkspans() {
         return workspans;
     }   
    
    
    
   
    
    
  
    /**
     * @param workspans The workspans to set.
     */
    public void setWorkspans(Set workspans) {
        this.workspans = workspans;
    }
    /**
     * @param carrierId The carrierId to set.
     */
    public void setCarrierId(Long carrierId) {
        this.carrierId = carrierId;
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
     * @param displayNo The displayNo to set.
     */
    public void setDisplayNo(Integer displayNo) {
        this.displayNo = displayNo;
    }
    /**
     * @param id The id to set.
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @param isClosed The isClosed to set.
     */
    public void setIsClosed(Boolean isClosed) {
        this.isClosed = isClosed;
    }
    /**
     * @param isManual The isManual to set.
     */
    public void setIsManual(Boolean isManual) {
        this.isManual = isManual;
    }
    /**
     * @param isOverweight The isOverweight to set.
     */
    public void setIsOverweight(Boolean isOverweight) {
        this.isOverweight = isOverweight;
    }
    /**
     * @param isSeralized The isSeralized to set.
     */
    public void setIsSeralized(Boolean isSeralized) {
        this.isSeralized = isSeralized;
    }
    /**
     * @param isValidate The isValidate to set.
     */
    public void setIsValidate(Boolean isValidate) {
        this.isValidate = isValidate;
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
     * @param propertiyTime The propertiyTime to set.
     */
    public void setPropertiyTime(Integer propertiyTime) {
        this.propertiyTime = propertiyTime;
    }
    /**
     * @param proResourceId The proResourceId to set.
     */
    public void setProResourceId(Long proResourceId) {
        this.proResourceId = proResourceId;
    }
    /**
     * @param proResourceMemo The proResourceMemo to set.
     */
    public void setProResourceMemo(String proResourceMemo) {
        this.proResourceMemo = proResourceMemo;
    }
    /**
     * @param resourceName The resourceName to set.
     */
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }
    /**
     * @param resourceType The resourceType to set.
     */
    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
    }
    
    
    
    /**
     * @param enable The enable to set.
     */
    public void setEnable(Boolean enable) {
        this.enable = enable;
    } 
    
    /**
     * @param version The version to set.
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    
    
    
    
    /**
     * @param prices The prices to set.
     */
    public void setResourcePrices(Set resourcePrices) {
        this.resourcePrices = resourcePrices;
    }
    public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

/**
	 * 
	 * Returns the sysPrice
	 * @return Double 
	 * 
	 */
	public Double getSysPrice() {
		return sysPrice;
	}
	/** 
	 * @param sysPrice The sysPrice to set.
	 */
	public void setSysPrice(Double sysPrice) {
		this.sysPrice = sysPrice;
	}
	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof Resource)) {
			return false;
		}
		Resource rhs = (Resource) object;
		return new EqualsBuilder().append(
				this.proResourceMemo, rhs.proResourceMemo).append(this.memo,
				rhs.memo).append(this.isSeralized, rhs.isSeralized).append(
				this.parentId, rhs.parentId)
				.append(this.sysPrice, rhs.sysPrice).append(this.workspans,
						rhs.workspans).append(this.modifyBy, rhs.modifyBy)
				.append(this.carrierId, rhs.carrierId).append(
						this.isOverweight, rhs.isOverweight).append(
						this.createBy, rhs.createBy).append(this.id, rhs.id)
				.append(this.proResourceId, rhs.proResourceId).append(
						this.isManual, rhs.isManual).append(this.version,
						rhs.version)
				.append(this.resourceName, rhs.resourceName).append(
						this.propertiyTime, rhs.propertiyTime).append(
						this.displayNo, rhs.displayNo).append(this.isValidate,
						rhs.isValidate).append(this.isClosed, rhs.isClosed)
				.append(this.resourceType, rhs.resourceType).append(
						this.resourcePrices, rhs.resourcePrices).append(
						this.modifyDate, rhs.modifyDate).append(
						this.createDate, rhs.createDate).append(this.enable,
						rhs.enable).isEquals();
	}
	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-2099330577, -186717169).append(this.proResourceMemo)
				.append(this.memo).append(this.isSeralized).append(
						this.parentId).append(this.sysPrice).append(
						this.workspans).append(this.modifyBy).append(
						this.carrierId).append(this.isOverweight).append(
						this.createBy).append(this.id).append(
						this.proResourceId).append(this.isManual).append(
						this.version).append(this.resourceName).append(
						this.propertiyTime).append(this.displayNo).append(
						this.isValidate).append(this.isClosed).append(
						this.resourceType).append(this.resourcePrices).append(
						this.modifyDate).append(this.createDate).append(
						this.enable).toHashCode();
	}
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("modifyBy", this.modifyBy)
				.append("id", this.id).append("carrierId", this.carrierId)
				.append("workspans", this.workspans).append("modifyDate",
						this.modifyDate).append("parentId", this.parentId)
				.append("enable", this.enable)
				.append("isClosed", this.isClosed).append("resourceType",
						this.resourceType).append("memo", this.memo).append(
						"isSeralized", this.isSeralized).append("createBy",
						this.createBy).append("isManual", this.isManual)
				.append("resourcePrices", this.resourcePrices).append(
						"isValidate", this.isValidate).append("isOverweight",
						this.isOverweight).append("proResourceMemo",
						this.proResourceMemo).append("propertiyTime",
						this.propertiyTime).append("proResourceId",
						this.proResourceId).append("resourceName",
						this.resourceName).append("displayNo", this.displayNo)
				.append("version", this.version).append("sysPrice",
						this.sysPrice).append("createDate", this.createDate)
				.toString();
	}
	/**
     * @hibernate.many-to-one name="carrierId" column="ad_resource_carrier_id" cascade="all" not-null="true"
 	 */
	public Carrier getCarrier() {
		return carrier;
	}
	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}
	public Workspan getWorkspan() {
		return workspan;
	}
	public void setWorkspan(Workspan workspan) {
		this.workspan = workspan;
	}
	public Integer getInPublishDate() {
		return inPublishDate;
	}
	public void setInPublishDate(Integer inPublishDate) {
		this.inPublishDate = inPublishDate;
	}
	/**
	 * @return Returns the resourceYear.
	 */
	public Integer getResourceYear() {
		return resourceYear;
	}
	/**
	 * @param resourceYear The resourceYear to set.
	 */
	public void setResourceYear(Integer resourceYear) {
		this.resourceYear = resourceYear;
	}
	public ResourceType getResType() {
		return resType;
	}
	public void setResType(ResourceType resType) {
		this.resType = resType;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getResourceSort() {
		return resourceSort;
	}
	public void setResourceSort(String resourceSort) {
		this.resourceSort = resourceSort;
	}
	public Integer getBeforehand() {
		return beforehand;
	}
	public void setBeforehand(Integer beforehand) {
		this.beforehand = beforehand;
	}
	public String getToday() {
		return today;
	}
	public void setToday(String today) {
		this.today = today;
	}
	public ResourceSort getResSort() {
		return resSort;
	}
	public void setResSort(ResourceSort resSort) {
		this.resSort = resSort;
	}
	public Long getResourceSortId() {
		return resourceSortId;
	}
	public void setResourceSortId(Long resourceSortId) {
		this.resourceSortId = resourceSortId;
	}
	public List getCarrierIdList() {
		return carrierIdList;
	}
	public void setCarrierIdList(List carrierIdList) {
		this.carrierIdList = carrierIdList;
	}
	public String getLoginUser() {
		return loginUser;
	}
	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}
	public Integer getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(Integer orderBy) {
		this.orderBy = orderBy;
	}


}
