/****************************************************************************     
 * Created on 2007-10-28                                      *    
 *                                                               			*
 * @author <a href="mailto:hongxilin@yahoo.com.cn">hongxi</a>               *
 *         Updated by hongxi (hongxilin@yahoo.com.cn)                       *
 *                                                                          *
 * @version  Vision:1.0														*
 * 																			*
 ***************************************************************************/
package com.vriche.adrm.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * PublishArrange class
 * 
 * This class is used to 
 * 
 * <p><a href="PublishArrange.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_published_arrang"
 * 
 */
public class PublishArrange extends BaseObject  implements Comparable{
	
	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Comment for <code>serialVersionUID</code>
	 */

	protected Long id;
	protected Integer publishDate;

    protected Long resourceId;
    protected String carrierName;
    protected String resourceName;
    protected String resourceMeno;
    protected String postionMeno;
    protected Integer resourceTotalTimes;
    protected Integer resourceUsedTimes;
    protected String filePath;
    
    protected Boolean isEnable;             //
    protected Boolean isLocked;              //
    protected String memo;

 
    protected Long createBy;				  //default sysdate
    protected Date createDate;					  
    protected Long modifyBy;				  //default sysdate
    protected Date modifyDate;	
    protected Integer version;
    
    protected List publishArrangeDetails = new ArrayList();
    
    protected PublishArrangeDetail[] details;
    
    protected Set resourceIds = new HashSet();
    
    
    protected Long carrierId;
    protected Integer arrangeType;  
    protected Boolean isArranged;  
    
    protected Integer displayNo;
    
    protected Integer beforehand;
    
    protected Integer broadcastStartTime;
    protected Integer broadcastEndTime;
    
	private Long orgId;
    protected String loginUser;
    protected String loginUserId;
    
    
    protected String arrangeforce;  
    protected String referenceDate;  
    
    /**
     * @hibernate.id column="arrange_id" generator-class="native" unsaved-value="null"
     */
	public Long getId() {
		return id;
	}   

	/**
	 * 
	 * Returns the carrierName
	 * @return String 
	 * 
	 * @hibernate.property length="20" column="carrier_name" not-null="false"
	 */
	public String getCarrierName() {
		return carrierName;
	}
	/**
	 * 
	 * Returns the filePath
	 * @return String 
	 * 
	 * @hibernate.property length="128" column="file_path" not-null="false"
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * 
	 * Returns the isEnable
	 * @return Boolean 
	 * 
	 * @hibernate.property column="is_enable" not-null="false" type="yes_no"
	 */
	public Boolean getIsEnable() {
		return isEnable;
	}
	/**
	 * 
	 * Returns the isLocked
	 * @return Boolean 
	 * 
	 * @hibernate.property column="is_locked" not-null="false" type="yes_no"
	 */
	public Boolean getIsLocked() {
		return isLocked;
	}
	/**
	 * 
	 * Returns the publishDate
	 * @return Integer 
     * @struts.validator type="required"
	 * @hibernate.property length="8" column="publish_date" not-null="true"
	 */
	public Integer getPublishDate() {
		return publishDate;
	}
	/**
	 * 
	 * Returns the resourceId
	 * @return Long 
	 * 
	 * @hibernate.property length="128" column="resource_id" not-null="false"
	 */
	public Long getResourceId() {
		return resourceId;
	}
	/**
	 * 
	 * Returns the resourceMeno
	 * @return String 
	 * 
	 * @hibernate.property length="128" column="resource_meno" not-null="false"
	 */
	public String getResourceMeno() {
		return resourceMeno;
	}
	/**
	 * 
	 * Returns the resourceName
	 * @return String 
	 * 
	 * @hibernate.property length="20" column="resource_name" not-null="false"
	 */
	public String getResourceName() {
		return resourceName;
	}
	/**
	 * 
	 * Returns the resourceTotalTimes
	 * @return Integer 
	 * 
	 * @hibernate.property length="12" column="resource_total_times" not-null="false"
	 */
	public Integer getResourceTotalTimes() {
		return resourceTotalTimes;
	}
	
	public String getResourceTotalTimeStr() {
		String rest = null;
		Integer total = resourceTotalTimes==null?new Integer(0):resourceTotalTimes;
		int hour = total.intValue()/3600;
		int min = total.intValue()%3600/60;
		int sec = total.intValue()%3600%60%60;
		rest = ""+hour+"'"+min+"'"+sec+"\"";
		return rest;
	}
	/**
	 * 
	 * Returns the resourceUsedTimes
	 * @return Integer 
	 * 
	 * @hibernate.property length="12" column="resource_used_times" not-null="false"
	 */
	public Integer getResourceUsedTimes() {
		return resourceUsedTimes;
	}
    
	
	public String getResourceUsedTimeStr() {
		String rest = null;
		Integer total = resourceUsedTimes==null?new Integer(0):resourceUsedTimes;
		int hour = total.intValue()/3600;
		int min = total.intValue()%3600/60;
		int sec = total.intValue()%3600%60%60;
		rest = ""+hour+"'"+min+"'"+sec+"\"";
		return rest;
	}
	
	public String getTotalUsedRateStr() {
		String rest = null;
		long restLong;
		Integer used = resourceUsedTimes==null?new Integer(0):resourceUsedTimes;
		Integer total = resourceTotalTimes==null?new Integer(0):resourceTotalTimes;
		restLong = Math.round(used.doubleValue()/total.doubleValue()*100);
		rest = new Long(restLong).toString()+"%";
		return rest;
	}
	
//	
//	public String getUsedTotalTimeStr() {
//		String rest = null;
//		Integer total = resourceUsedTimes;
//		int hour = total.intValue()/3600;
//		int min = total.intValue()%3600/60;
//		int sec = total.intValue()%3600%60%60;
//		rest = ""+hour+"'"+min+"'"+sec+"\"";
//		return rest;
//	}
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
     * @hibernate.set name="publishArrangeDetails" table="tb_published_arrang_detail" inverse="false" cascade="none" lazy="false"
     * @hibernate.collection-key column="arrange_id"
     * @hibernate.collection-one-to-many class="com.vriche.adrm.model.PublishArrangeDetail" column="arrange_detail_id"
     */
	public List getPublishArrangeDetails() {
		return publishArrangeDetails;
	}  
    
    
    
    
    
    
    
    /**
	 * 
	 * Returns the carrierId
	 * @return Long 
	 * 
	 * @hibernate.property length="128" column="carrier_id" not-null="false"
	 */
	public Long getCarrierId() {
		return carrierId;
	}   
    
	
	
    /**
	 * 
	 * Returns the displayNo
	 * @return Long 
	 * 
	 * @hibernate.property_bak length="128" column="display_no" not-null="false"
	 */
	public Integer getDisplayNo() {
		return displayNo;
	}    
    
    
    
    
    
    
    

	/** 
	 * @param carrierId The carrierId to set.
	 */
	public void setCarrierId(Long carrierId) {
		this.carrierId = carrierId;
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
	 * @param filePath The filePath to set.
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	/** 
	 * @param id The id to set.
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/** 
	 * @param isEnable The isEnable to set.
	 */
	public void setIsEnable(Boolean isEnable) {
		this.isEnable = isEnable;
	}
	/** 
	 * @param isLocked The isLocked to set.
	 */
	public void setIsLocked(Boolean isLocked) {
		this.isLocked = isLocked;
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
	 * @param publishDate The publishDate to set.
	 */
	public void setPublishDate(Integer publishDate) {
		this.publishDate = publishDate;
	}
	/** 
	 * @param resourceId The resourceId to set.
	 */
	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}
	/** 
	 * @param resourceMeno The resourceMeno to set.
	 */
	public void setResourceMeno(String resourceMeno) {
		this.resourceMeno = resourceMeno;
	}
	/** 
	 * @param resourceName The resourceName to set.
	 */
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	/** 
	 * @param resourceTotalTimes The resourceTotalTimes to set.
	 */
	public void setResourceTotalTimes(Integer resourceTotalTimes) {
		this.resourceTotalTimes = resourceTotalTimes;
	}
	/** 
	 * @param resourceUsedTimes The resourceUsedTimes to set.
	 */
	public void setResourceUsedTimes(Integer resourceUsedTimes) {
		this.resourceUsedTimes = resourceUsedTimes;
	}
	/** 
	 * @param version The version to set.
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
	

	/** 
	 * @param publishArrangeDetails The publishArrangeDetails to set.
	 */
	public void setPublishArrangeDetails(List publishArrangeDetails) {
		this.publishArrangeDetails = publishArrangeDetails;
	}
	
	
	
	
	public Integer getArrangeType() {
		return arrangeType;
	}

	public void setArrangeType(Integer arrangeType) {
		this.arrangeType = arrangeType;
	}


	/**
	 * 
	 * Returns the isArranged
	 * @return Boolean 
	 * 
	 * @hibernate.property column="is_arranged" not-null="false" type="yes_no"
	 */
	public Boolean getIsArranged() {
		return isArranged;
	}

	public void setIsArranged(Boolean isArranged) {
		this.isArranged = isArranged;
	}

	public Set getResourceIds() {
		return resourceIds;
	}

	public void setResourceIds(Set resourceIds) {
		this.resourceIds = resourceIds;
	}

	public PublishArrangeDetail[] getDetails() {
		return details;
	}

	public void setDetails(PublishArrangeDetail[] details) {
		this.details = details;
	}
	


	public void setDisplayNo(Integer displayNo) {
		this.displayNo = displayNo;
	}
	

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof PublishArrange)) {
			return false;
		}
		PublishArrange rhs = (PublishArrange) object;
		return new EqualsBuilder().append(this.arrangeType, rhs.arrangeType)
				.append(this.memo, rhs.memo).append(this.resourceMeno,
						rhs.resourceMeno).append(this.resourceTotalTimes,
						rhs.resourceTotalTimes).append(this.resourceIds,
						rhs.resourceIds).append(this.publishDate,
						rhs.publishDate).append(this.publishArrangeDetails,
						rhs.publishArrangeDetails).append(this.details,
						rhs.details).append(this.modifyBy, rhs.modifyBy)
				.append(this.carrierId, rhs.carrierId).append(this.filePath,
						rhs.filePath).append(this.isEnable, rhs.isEnable)
				.append(this.isArranged, rhs.isArranged).append(
						this.carrierName, rhs.carrierName).append(
						this.createBy, rhs.createBy).append(this.id, rhs.id)
				.append(this.version, rhs.version).append(this.resourceName,
						rhs.resourceName).append(this.resourceUsedTimes,
						rhs.resourceUsedTimes).append(this.modifyDate,
						rhs.modifyDate).append(this.createDate, rhs.createDate)
				.append(this.isLocked, rhs.isLocked).append(this.resourceId,
						rhs.resourceId).isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-1522832337, -587805705).append(
				this.arrangeType).append(this.memo).append(this.resourceMeno)
				.append(this.resourceTotalTimes).append(this.resourceIds)
				.append(this.publishDate).append(this.publishArrangeDetails)
				.append(this.details).append(this.modifyBy).append(
						this.carrierId).append(this.filePath).append(
						this.isEnable).append(this.isArranged).append(
						this.carrierName).append(this.createBy).append(this.id)
				.append(this.version).append(this.resourceName).append(
						this.resourceUsedTimes).append(this.modifyDate).append(
						this.createDate).append(this.isLocked).append(
						this.resourceId).toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("modifyBy", this.modifyBy)
				.append("resourceIds", this.resourceIds).append("isArranged",
						this.isArranged).append("id", this.id).append(
						"details", this.details).append("carrierId",
						this.carrierId).append("modifyDate", this.modifyDate)
				.append("resourceMeno", this.resourceMeno).append(
						"resourceName", this.resourceName).append(
						"publishDate", this.publishDate).append("memo",
						this.memo).append("resourceUsedTimes",
						this.resourceUsedTimes).append("isLocked",
						this.isLocked).append("createBy", this.createBy)
				.append("resourceId", this.resourceId).append(
						"resourceTotalTimes", this.resourceTotalTimes).append(
						"filePath", this.filePath).append("version",
						this.version).append("isEnable", this.isEnable).append(
						"arrangeType", this.arrangeType).append(
						"publishArrangeDetails", this.publishArrangeDetails)
				.append("carrierName", this.carrierName).append("createDate",
						this.createDate).toString();
	}

	public int compareTo(Object o) {
		PublishArrange other = (PublishArrange)o;
		
		 return displayNo.intValue() - other.displayNo.intValue();

//	       return displayNo.intValue() - other.displayNo.intValue();
	}

	public Integer getBeforehand() {
		return beforehand;
	}

	public void setBeforehand(Integer beforehand) {
		this.beforehand = beforehand;
	}

	public Integer getBroadcastEndTime() {
		return broadcastEndTime;
	}

	public void setBroadcastEndTime(Integer broadcastEndTime) {
		this.broadcastEndTime = broadcastEndTime;
	}

	public Integer getBroadcastStartTime() {
		return broadcastStartTime;
	}

	public void setBroadcastStartTime(Integer broadcastStartTime) {
		this.broadcastStartTime = broadcastStartTime;
	}

	public String getPostionMeno() {
		return postionMeno;
	}

	public void setPostionMeno(String postionMeno) {
		this.postionMeno = postionMeno;
	}

	public String getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public String getArrangeforce() {
		return arrangeforce;
	}

	public void setArrangeforce(String arrangeforce) {
		this.arrangeforce = arrangeforce;
	}

	public String getReferenceDate() {
		return referenceDate;
	}

	public void setReferenceDate(String referenceDate) {
		this.referenceDate = referenceDate;
	}

	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}


	


}
