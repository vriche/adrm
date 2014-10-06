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


import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.vriche.adrm.model.BaseObject;
/**
 * DayInfo class
 * 
 * This class is used to 
 * 
 * <p><a href="DayInfo.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_ad_resource_day_info"
 * 
 */
public class DayInfo extends BaseObject {
    private static final long serialVersionUID = 3832626162173359411L;
   

    protected String carrierId;
    protected Long resourceId;
    protected Integer resourceType;
    protected Integer propertiyTime;
    protected Long workspanId;
    
    protected Integer broadcastStartTime;
    
    protected Integer publishDate;
    protected String  specific;
    protected String total;
    protected String used;
    
    protected Double changedValue;   
    
    protected Integer startDate;
    protected Integer endDate;   

    
    protected Long id;		  
    protected Integer version;
    
    
    protected String  modifyTime;     //Ê±¼ä´Á
    
    protected Resource resource = new Resource();

    
    public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}
	
	
	
//	public DayInfo(){
//		changedValue = new Double(0);
//	}

	public void reset(Integer publishDate){
    	this.carrierId ="0";
    	this.resourceId = new Long("0");
    	this.resourceType= new Integer("0");
    	this.workspanId= new Long("0");  	
    	this.publishDate = publishDate;
    	this.specific ="";
    	this.total = "0";
    	this.used = "0";
    	
    	this.resource.setIsClosed(new Boolean(false));
    	this.resource.setIsManual(new Boolean(false));
    	this.resource.setIsOverweight(new Boolean(false));
    	this.resource.setIsSeralized(new Boolean(false));
    	this.resource.setIsValidate(new Boolean(false));
    	this.resource.setEnable(new Boolean(false));
    };
    
    /**
     * @hibernate.id column="ad_resource_day_info_id" generator-class="native" unsaved-value="null"
     */
    public Long getId() {
        return id;
    }

    
    /**
     * 
     * Returns the carrierId
     * @return String
     * 
     * @hibernate.property length="32" column="ad_resource_carrier_id" not-null="false"
     */
    public String getCarrierId() {
        return carrierId;
    }
    /**
     * 
     * Returns the resourceId
     * @return Long
     * 
     * @hibernate.property length="20" column="ad_resource_info_id" not-null="false"
     */
    public Long getResourceId() {
        return resourceId;
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
     * Returns the workspanId
     * @return Long
     * 
     * @hibernate.property length="128" column="ad_resource_workspan_id" not-null="false"
     */
    public Long getWorkspanId() {
        return workspanId;
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
     * Returns the specific
     * @return String
     * 
     * @hibernate.property length="32" column="ad_resource_specific" not-null="false"
     */
    public String getSpecific() {
        return specific;
    }
    /**
     * 
     * Returns the total
     * @return String
     * 
     * @hibernate.property length="32" column="total" not-null="false"
     */
    public String getTotal() {
        return total;
    }
    /**
     * 
     * Returns the used
     * @return String
     * 
     * @hibernate.property length="32" column="used" not-null="false"
     */
    public String getUsed() {
        return used;
    }
    
    /**
     * @hibernate.version
     */
    public Integer getVersion() {
        return version;
    }   
    
    

    /**
     * @param carrierId The carrierId to set.
     */
    public void setCarrierId(String carrierId) {
        this.carrierId = carrierId;
    }
    /**
     * @param id The id to set.
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @param propertiyTime The propertiyTime to set.
     */
    public void setPropertiyTime(Integer propertiyTime) {
        this.propertiyTime = propertiyTime;
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
     * @param resourceType The resourceType to set.
     */
    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
    }
    /**
     * @param specific The specific to set.
     */
    public void setSpecific(String specific) {
        this.specific = specific;
    }
    /**
     * @param total The total to set.
     */
    public void setTotal(String total) {
        this.total = total;
    }
    /**
     * @param used The used to set.
     */
    public void setUsed(String used) {
        this.used = used;
    }
    /**
     * @param version The version to set.
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
    /**
     * @param workspanId The workspanId to set.
     */
    public void setWorkspanId(Long workspanId) {
        this.workspanId = workspanId;
    }
    /**
     * @see java.lang.Object#equals(Object)
     */
    public boolean equals(Object object) {
        if (!(object instanceof DayInfo)) {
            return false;
        }
        DayInfo rhs = (DayInfo) object;
        return new EqualsBuilder().append(
                this.total, rhs.total)
                .append(this.publishDate, rhs.publishDate).append(
                        this.resourceType, rhs.resourceType).append(
                        this.carrierId, rhs.carrierId).append(this.specific,
                        rhs.specific).append(this.workspanId, rhs.workspanId)
                .append(this.id, rhs.id).append(this.version, rhs.version)
                .append(this.used, rhs.used).append(this.propertiyTime,
                        rhs.propertiyTime).append(this.resourceId,
                        rhs.resourceId).isEquals();
    }
    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder(1323035177, 816643695).append(this.total).append(this.publishDate)
                .append(this.resourceType).append(this.carrierId).append(
                        this.specific).append(this.workspanId).append(this.id)
                .append(this.version).append(this.used).append(
                        this.propertiyTime).append(this.resourceId)
                .toHashCode();
    }
    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return new ToStringBuilder(this).append("used", this.used).append("id",
                this.id).append("carrierId", this.carrierId).append(
                "propertiyTime", this.propertiyTime).append("publishDate",
                this.publishDate).append("workspanId", this.workspanId).append(
                "resourceType", this.resourceType).append("specific",
                this.specific).append("total", this.total).append("resourceId",
                this.resourceId).toString();
    }


	/**
	 * 
	 * Returns the startDate
	 * @return Integer 
	 * 
	 */
	public Integer getStartDate() {
		return startDate;
	}


	/** 
	 * @param startDate The startDate to set.
	 */
	public void setStartDate(Integer startDate) {
		this.startDate = startDate;
	}


	/**
	 * 
	 * Returns the endDate
	 * @return Integer 
	 * 
	 */
	public Integer getEndDate() {
		return endDate;
	}


	/** 
	 * @param endDate The endDate to set.
	 */
	public void setEndDate(Integer endDate) {
		this.endDate = endDate;
	}

	  /**
     * 
     * Returns the broadcastStartTime
     * @return Integer
     * 
     * @hibernate.property length="11" column="broadcast_start_time" not-null="true"
     */
	public Integer getBroadcastStartTime() {
		return broadcastStartTime;
	}

	/**
	 * @param broadcastStartTime The broadcastStartTime to set.
	 */
	public void setBroadcastStartTime(Integer broadcastStartTime) {
		this.broadcastStartTime = broadcastStartTime;
	}

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Double getChangedValue() {
		return changedValue;
	}

	public void setChangedValue(Double changedValue) {
		this.changedValue = changedValue;
	}


}
