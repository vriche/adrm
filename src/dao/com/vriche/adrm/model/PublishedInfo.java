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


import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.vriche.adrm.model.BaseObject;
/**
 * PublishedInfo class
 * 
 * This class is used to 
 * 
 * <p><a href="PublishedInfo.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_adver_published_info"
 * 
 */
public class PublishedInfo extends BaseObject {
	private static final long serialVersionUID = -4609837344903972785L;
	protected Long id;
    protected Integer publishDate;
    protected Long contractId;
    protected Long orderId;
    protected String publishOrder;
    protected Long adResourceId;
    protected Long adResourceWorkspanId;
    protected String resourceCarrier;
    protected Long carrierId;
    protected Long resourceType;
    protected String position;
    protected String publishMemo;
    protected String linkUser;
    protected Long linkUserId;
    protected String positionDes;
    protected String proResourceMemo;
    protected Long adverMatterId;
    protected String tapeCode;
    protected String matterName;
    protected String matterEdit;
    protected String matterLength;
    protected String appPosition;		  
    protected Integer version;
    protected Long customerId;	
    protected String customerName;
    
    protected Integer publishMemoValue;
    protected String specificValue;
    protected Integer dayTimes;
//    protected String resourceMemo;
    
    protected Long orderDayInfoId;
    protected String orderCode;
    
    protected String adContent;
    
 
    
//    protected String carrierName ;
    
    
    public PublishedInfo(){};

    /**
     * @hibernate.id column="adver_published_info_id" generator-class="native" unsaved-value="null"
     */
    public Long getId() {
        return id;
    }
    
    /**
     * 
     * Returns the orderDayInfoId
     * @return Long
     * 
     * @hibernate.property length="128" column="order_day_info_id" not-null="false"
     */
	public Long getOrderDayInfoId() {
		return orderDayInfoId;
	}
	
    /**
     * 
     * Returns the linkUserId 
     * @return Long
     * 
     * @hibernate.property length="128" column="link_user_id" not-null="false"
     */
	public Long getLinkUserId() {
		return linkUserId;
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
     * Returns the customerName
     * @return String
     * 
     * @hibernate.property length="128" column="customer_name" not-null="false"
     */
	public String getCustomerName() {
		return customerName;
	}   

    /**
     * 
     * Returns the publishDate
     * @return Integer
     * @struts.validator type="required"
     * @hibernate.property length="8" column="publish_date" not-null="false"
     */
    public Integer getPublishDate() {
        return publishDate;
    }
    /**
     * 
     * Returns the contractId
     * @return Long
     * 
     * @hibernate.property length="20" column="contract_id" not-null="false"
     */
    public Long getContractId() {
        return contractId;
    }
    /**
     * 
     * Returns the orderId
     * @return Long
     * 
     * @hibernate.property length="20" column="order_id" not-null="false"
     */
    public Long getOrderId() {
        return orderId;
    }
    /**
     * 
     * Returns the publishOrder
     * @return String
     * 
     * @hibernate.property length="32" column="publish_order" not-null="false"
     */
    public String getPublishOrder() {
        return publishOrder;
    }
    /**
     * 
     * Returns the adResourceId
     * @return Long
     * 
     * @hibernate.property length="20" column="ad_resource_info_id" not-null="false"
     */
    public Long getAdResourceId() {
        return adResourceId;
    }
    /**
     * 
     * Returns the adResourceWorkspanId
     * @return Long
     * 
     * @hibernate.property length="20" column="ad_resource_workspan_id" not-null="false"
     */
    public Long getAdResourceWorkspanId() {
        return adResourceWorkspanId;
    }
    /**
     * 
     * Returns the resourceCarrier
     * @return String
     * 
     * @hibernate.property length="32" column="resource_carrier" not-null="false"
     */
    public String getResourceCarrier() {
        return resourceCarrier;
    }
    /**
     * 
     * Returns the position
     * @return String
     * 
     * @hibernate.property length="32" column="position" not-null="false"
     */
    public String getPosition() {
        return position;
    }
    /**
     * 
     * Returns the publishMemo
     * @return String
     * 
     * @hibernate.property length="32" column="publish_memo_name" not-null="false"
     */
    public String getPublishMemo() {
        return publishMemo;
    }
    /**
     * 
     * Returns the linkUser
     * @return String
     * 
     * @hibernate.property length="32" column="link_user" not-null="false"
     */
    public String getLinkUser() {
        return linkUser;
    }
    /**
     * 
     * Returns the positionDes
     * @return String
     * 
     * @hibernate.property length="128" column="position_des" not-null="false"
     */
    public String getPositionDes() {
        return positionDes;
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
     * Returns the adverMatterId
     * @return Integer
     * 
     * @hibernate.property length="20" column="adver_matter_id" not-null="false"
     */
    public Long getAdverMatterId() {
        return adverMatterId;
    }
    /**
     * 
     * Returns the tapeCode
     * @return String
     * 
     * @hibernate.property length="32" column="tape_code" not-null="false"
     */
    public String getTapeCode() {
        return tapeCode;
    }
    /**
     * 
     * Returns the matterName
     * @return String
     * 
     * @hibernate.property length="128" column="matter_name" not-null="false"
     */
    public String getMatterName() {
        return matterName;
    }
    /**
     * 
     * Returns the matterEdit
     * @return String
     * 
     * @hibernate.property length="128" column="matter_edit" not-null="false"
     */
    public String getMatterEdit() {
        return matterEdit;
    }
    /**
     * 
     * Returns the matterLength
     * @return String
     * 
     * @hibernate.property length="32" column="matter_length" not-null="false"
     */
    public String getMatterLength() {
        return matterLength;
    }
    /**
     * 
     * Returns the appPosition
     * @return String
     * 
     * @hibernate.property length="32" column="app_position" not-null="false"
     */
    public String getAppPosition() {
        return appPosition;
    }
    /**
     * @hibernate.version
     */
    public Integer getVersion() {
        return version;
    }

   
	 /**
     * 
     * Returns the publishMemoValue
     * @return Integer
     * 
     * @hibernate.property length="5" column="publish_memo_value" not-null="false"
     */
	public Integer getPublishMemoValue() {
		return publishMemoValue;
	}   
	
    /**
     * 
     * Returns the carrierId
     * @return Long
     * 
     * @hibernate.property length="20" column="ad_resource_carrier_id" not-null="false"
     */	
	public Long getCarrierId() {
		return carrierId;
	}
    /**
     * 
     * Returns the resourceType
     * @return Long
     * 
     * @hibernate.property length="20" column="ad_resource_type" not-null="false"
     */
	public Long getResourceType() {
		return resourceType;
	}	
	
	 /**
     * 
     * Returns the orderCode
     * @return String
     * 
     * @hibernate.property length="128" column="order_code" not-null="false"
     */
	public String getOrderCode() {
		return orderCode;
	}	
	
	 /**
     * 
     * Returns the specificValue
     * @return String
     * 
     * @hibernate.property length="5" column="specific_value" not-null="false"
     */
	public String getSpecificValue() {
		return specificValue;
	}
	 /**
     * 
     * Returns the dayTimes
     * @return Integer
     * 
     * @hibernate.property length="5" column="ad_day_times" not-null="false"
     */
	public Integer getDayTimes() {
		return dayTimes;
	}	
	
    /**
     * 
     * Returns the adContent
     * @return String
     * 
     * @hibernate.property length="512" column="ad_content" not-null="false"
     */
	public String getAdContent() {
		return adContent;
	}

	
	
	
	
	
	
	/**
	 * @param adContent The adContent to set.
	 */
	public void setAdContent(String adContent) {
		this.adContent = adContent;
	}	

    /**
     * @param adResourceId The adResourceId to set.
     */
    public void setAdResourceId(Long adResourceId) {
        this.adResourceId = adResourceId;
    }
    /**
     * @param adResourceWorkspanId The adResourceWorkspanId to set.
     */
    public void setAdResourceWorkspanId(Long adResourceWorkspanId) {
        this.adResourceWorkspanId = adResourceWorkspanId;
    }
    /**
     * @param adverMatterId The adverMatterId to set.
     */
    public void setAdverMatterId(Long adverMatterId) {
        this.adverMatterId = adverMatterId;
    }
    /**
     * @param appPosition The appPosition to set.
     */
    public void setAppPosition(String appPosition) {
        this.appPosition = appPosition;
    }
    /**
     * @param contractId The contractId to set.
     */
    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }
    /**
     * @param id The id to set.
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @param linkUser The linkUser to set.
     */
    public void setLinkUser(String linkUser) {
        this.linkUser = linkUser;
    }
    /**
     * @param matterEdit The matterEdit to set.
     */
    public void setMatterEdit(String matterEdit) {
        this.matterEdit = matterEdit;
    }
    /**
     * @param matterLength The matterLength to set.
     */
    public void setMatterLength(String matterLength) {
        this.matterLength = matterLength;
    }
    /**
     * @param matterName The matterName to set.
     */
    public void setMatterName(String matterName) {
        this.matterName = matterName;
    }
    /**
     * @param orderId The orderId to set.
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    /**
     * @param position The position to set.
     */
    public void setPosition(String position) {
        this.position = position;
    }
    /**
     * @param positionDes The positionDes to set.
     */
    public void setPositionDes(String positionDes) {
        this.positionDes = positionDes;
    }
    /**
     * @param proResourceMemo The proResourceMemo to set.
     */
    public void setProResourceMemo(String proResourceMemo) {
        this.proResourceMemo = proResourceMemo;
    }
    /**
     * @param publishDate The publishDate to set.
     */
    public void setPublishDate(Integer publishDate) {
        this.publishDate = publishDate;
    }
    /**
     * @param publishMemo The publishMemo to set.
     */
    public void setPublishMemo(String publishMemo) {
        this.publishMemo = publishMemo;
    }
    /**
     * @param publishOrder The publishOrder to set.
     */
    public void setPublishOrder(String publishOrder) {
        this.publishOrder = publishOrder;
    }
    /**
     * @param resourceCarrier The resourceCarrier to set.
     */
    public void setResourceCarrier(String resourceCarrier) {
        this.resourceCarrier = resourceCarrier;
    }
    /**
     * @param tapeCode The tapeCode to set.
     */
    public void setTapeCode(String tapeCode) {
        this.tapeCode = tapeCode;
    }
    /**
     * @param version The version to set.
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public void setPublishMemoValue(Integer publishMemoValue) {
		this.publishMemoValue = publishMemoValue;
	}
	
	public void setOrderDayInfoId(Long orderDayInfoId) {
		this.orderDayInfoId = orderDayInfoId;
	}



	public void setLinkUserId(Long linkUserId) {
		this.linkUserId = linkUserId;
	}




	public void setSpecificValue(String specificValue) {
		this.specificValue = specificValue;
	}


	public void setDayTimes(Integer dayTimes) {
		this.dayTimes = dayTimes;
	}



	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}



	public void setCarrierId(Long carrierId) {
		this.carrierId = carrierId;
	}



	public void setResourceType(Long resourceType) {
		this.resourceType = resourceType;
	}
	
    /**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof PublishedInfo)) {
			return false;
		}
		PublishedInfo rhs = (PublishedInfo) object;
		return new EqualsBuilder().append(this.resourceCarrier,
				rhs.resourceCarrier).append(this.proResourceMemo,
				rhs.proResourceMemo).append(this.publishDate, rhs.publishDate)
				.append(this.position, rhs.position).append(this.positionDes,
						rhs.positionDes).append(this.id, rhs.id).append(
						this.customerId, rhs.customerId).append(this.version,
						rhs.version).append(this.contractId, rhs.contractId)
				.append(this.adResourceId, rhs.adResourceId).append(
						this.appPosition, rhs.appPosition).append(
						this.publishOrder, rhs.publishOrder).append(
						this.publishMemo, rhs.publishMemo).append(
						this.matterLength, rhs.matterLength).append(
						this.tapeCode, rhs.tapeCode).append(this.matterEdit,
						rhs.matterEdit).append(this.customerName,
						rhs.customerName).append(this.orderId, rhs.orderId)
				.append(this.adverMatterId, rhs.adverMatterId).append(
						this.linkUser, rhs.linkUser).append(
						this.adResourceWorkspanId, rhs.adResourceWorkspanId)
				.append(this.matterName, rhs.matterName).isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-415975285, -385863849).append(
				this.resourceCarrier).append(this.proResourceMemo).append(
				this.publishDate).append(this.position)
				.append(this.positionDes).append(this.id).append(
						this.customerId).append(this.version).append(
						this.contractId).append(this.adResourceId).append(
						this.appPosition).append(this.publishOrder).append(
						this.publishMemo).append(this.matterLength).append(
						this.tapeCode).append(this.matterEdit).append(
						this.customerName).append(this.orderId).append(
						this.adverMatterId).append(this.linkUser).append(
						this.adResourceWorkspanId).append(this.matterName)
				.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("adResourceWorkspanId",
				this.adResourceWorkspanId).append("linkUser", this.linkUser)
				.append("positionDes", this.positionDes).append("matterName",
						this.matterName).append("id", this.id).append(
						"tapeCode", this.tapeCode).append("customerId",
						this.customerId).append("proResourceMemo",
						this.proResourceMemo).append("matterLength",
						this.matterLength)
				.append("matterEdit", this.matterEdit).append("publishDate",
						this.publishDate).append("publishMemo",
						this.publishMemo).append("position", this.position)
				.append("orderId", this.orderId).append("adResourceId",
						this.adResourceId)
				.append("contractId", this.contractId).append("version",
						this.version).append("publishOrder", this.publishOrder)
				.append("adverMatterId", this.adverMatterId).append(
						"resourceCarrier", this.resourceCarrier).append(
						"appPosition", this.appPosition).append("customerName",
						this.customerName).toString();
	}





	

//	public String getCarrierName() {
//		return carrierName;
//	}
//
//	public void setCarrierName(String carrierName) {
//		this.carrierName = carrierName;
//	}






}
