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
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Carrier class
 * 
 * This class is used to 
 * 
 * <p><a href="Carrier.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_ad_resource_carrier"
 * 
 */
public class Carrier extends BaseObjectWithoutNestedFormValidation implements Serializable, Comparable{
    
    private static final long serialVersionUID = 3832626162173359411L;

   
    protected Long id;
    protected String carrierName;			 // required
    protected String aliasName;
    protected String parentId;
    protected Integer nodeLevel;
    protected Integer displayNo;
    protected String nodePath;
    protected String memo;
    protected Boolean enable;
    protected Long carrierTypeId;
    protected Long channelId;
    protected Long mediaOrgId;
    protected Boolean isBuildLevel;           //建立串联单
    
    protected Long createBy;				  //default sysdate
    protected Date createDate;					  
    protected Long modifyBy;				  //default sysdate
    protected Date modifyDate;					  
    protected Integer version;
    protected CarrierType carrierType = new CarrierType();
    protected ResourceChannel resourceChannel = new ResourceChannel();
    
    protected String resourceSort;
    protected String orgId;
    
    protected String loginUser ="";
    
    
	public Carrier(){};
    public Carrier(String carrierName) {
        this.carrierName = carrierName;
    }

    /**
     * @hibernate.id column="ad_resource_carrier_id" generator-class="native" unsaved-value="null"
     */
    public Long getId() {
        return id;
    }
    /**
     * 
     * Returns the channelId
     * @return Long
     * 
     * @hibernate.property length="20" column="ad_resource_channel_id" not-null="false"
     */
	public Long getChannelId() {
		return channelId;
	}
    /**
     * 
     * Returns the createBy
     * @return Long
     * 
     * @hibernate.property length="20" column="ad_resource_mediaorg_Id" not-null="false"
     */
	public Long getMediaOrgId() {
		return mediaOrgId;
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
     * 
     * Returns the enable
     * @return Boolean
     * 
     * @hibernate.property  column="enable" not-null="false"  type="yes_no"
     */
    public Boolean getEnable() {
        return enable;
    }  

	/**
	 * 
	 * Returns the isBuildLevel
	 * @return Boolean 
	 * 
	 * @hibernate.property  column="is_build_level" not-null="false"  type="yes_no"
	 */
	public Boolean getIsBuildLevel() {
		return isBuildLevel;
	}
	
    /**
     * 
     * Returns the carrierName
     * @return String
     * @struts.validator type="required"
     * @hibernate.property length="128" column="carrier_name" not-null="true"
     */
    public String getCarrierName() {
        return carrierName;
    }
    
    /**
     * 
     * Returns the carrierTypeId
     * @return Long
     * @hibernate.property length="128" column="ad_resource_carrier_type_id" not-null="false"
     */
	public Long getCarrierTypeId() {
		return carrierTypeId;
	}
    /**
     * 
     * Returns the aliasName
     * @return String
     * 
     * @hibernate.property length="128" column="alias_name" not-null="false"
     */
    public String getAliasName() {
        return aliasName;
    }
    /**
     * 
     * Returns the parentId
     * @return String
     * 
     * @hibernate.property length="32" column="parent_id" not-null="false"
     */
    public String getParentId() {
        return parentId;
    }
    /**
     * 
     * Returns the nodeLevel
     * @return Integer
     * 
     * @hibernate.property length="5" column="node_level" not-null="false"
     */
    public Integer getNodeLevel() {
        return nodeLevel;
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
     * Returns the nodePath
     * @return String
     * 
     * @hibernate.property length="256" column="nodePath" not-null="false"
     */
    public String getNodePath() {
        return nodePath;
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
     * @hibernate.version
     */
    public Integer getVersion() {
        return version;
    }  
    
    

    


    /**
     * @param enable The enable to set.
     */
    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
    /**
     * @param aliasName The aliasName to set.
     */
    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }
    /**
     * @param carrierName The carrierName to set.
     */
    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
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
     * @param nodeLevel The nodeLevel to set.
     */
    public void setNodeLevel(Integer nodeLevel) {
        this.nodeLevel = nodeLevel;
    }
    /**
     * @param nodePath The nodePath to set.
     */
    public void setNodePath(String nodePath) {
        this.nodePath = nodePath;
    }
    /**
     * @param parentId The parentId to set.
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
    /**
     * @param version The version to set.
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
   

	public void setCarrierTypeId(Long carrierTypeId) {
		this.carrierTypeId = carrierTypeId;
	}

    
    
    public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}
	public void setMediaOrgId(Long mediaOrgId) {
		this.mediaOrgId = mediaOrgId;
	}
	
	

	/** 
	 * @param isBuildLevel The isBuildLevel to set.
	 */
	public void setIsBuildLevel(Boolean isBuildLevel) {
		this.isBuildLevel = isBuildLevel;
	}

	
	/**
     * @see java.lang.Object#equals(Object)
     */
    public boolean equals(Object object) {
        if (!(object instanceof Carrier)) {
            return false;
        }
        Carrier rhs = (Carrier) object;
        return new EqualsBuilder().append(
                this.memo, rhs.memo).append(this.parentId, rhs.parentId)
                .append(this.aliasName, rhs.aliasName).append(this.modifyBy,
                        rhs.modifyBy).append(this.nodePath, rhs.nodePath)
                .append(this.modifyDate, rhs.modifyDate).append(
                        this.createDate, rhs.createDate).append(this.nodeLevel,
                        rhs.nodeLevel).append(this.createBy, rhs.createBy)
                .append(this.carrierName, rhs.carrierName).append(this.id,
                        rhs.id).append(this.version, rhs.version).append(
                        this.enable, rhs.enable).append(this.displayNo,
                        rhs.displayNo).isEquals();
    }
    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder(-1240469957, -1094985097).append(this.memo).append(this.parentId)
                .append(this.aliasName).append(this.modifyBy).append(
                        this.nodePath).append(this.modifyDate).append(
                        this.createDate).append(this.nodeLevel).append(
                        this.createBy).append(this.carrierName).append(this.id)
                .append(this.version).append(this.enable)
                .append(this.displayNo).toHashCode();
    }
    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return new ToStringBuilder(this).append("nodeLevel", this.nodeLevel)
                .append("nodePath", this.nodePath).append("modifyBy",
                        this.modifyBy).append("id", this.id).append("version",
                        this.version).append("modifyDate", this.modifyDate)
                .append("parentId", this.parentId).append("aliasName",
                        this.aliasName).append("enable", this.enable).append(
                        "displayNo", this.displayNo).append("memo", this.memo)
                .append("carrierName", this.carrierName).append("createBy",
                        this.createBy).append("createDate", this.createDate)
                .toString();
    }
    
	public int compareTo(Object o) {
		Carrier other = (Carrier)o;
		
		 return nodeLevel.intValue() - other.nodeLevel.intValue();

//	       return displayNo.intValue() - other.displayNo.intValue();
	}
	/**
	 * @return Returns the carrierType.
	 */
	public CarrierType getCarrierType() {
		return carrierType;
	}
	/**
	 * @param carrierType The carrierType to set.
	 */
	public void setCarrierType(CarrierType carrierType) {
		this.carrierType = carrierType;
	}
	public String getResourceSort() {
		return resourceSort;
	}
	public void setResourceSort(String resourceSort) {
		this.resourceSort = resourceSort;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getLoginUser() {
		return loginUser;
	}
	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}

	public ResourceChannel getResourceChannel() {
		return resourceChannel;
	}
	public void setResourceChannel(ResourceChannel resourceChannel) {
		this.resourceChannel = resourceChannel;
	}

}
