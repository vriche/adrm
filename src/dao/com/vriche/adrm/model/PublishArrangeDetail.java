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

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
/**
 * PublishArrangeDetail class
 * 
 * This class is used to 
 * 
 * <p><a href="PublishArrangeDetail.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_published_arrang_detail"
 * 
 */

public class PublishArrangeDetail extends BaseObject implements Comparable{
	

	private static final long serialVersionUID = 1L;

	protected Long id;
	protected Long publishArrangeId;  
    protected Integer publishSort;

    
    
   
    protected Long orderDayId;
    protected String specificValue;  //指定参数
    protected String ownerUserName;
    protected String customerName;	
    protected String tapeCode;
    protected String matterName;
    protected String matterEdit;
    protected String matterLength;
    protected Integer adverTimes;	
    protected String publishMemo;
    protected String specificName;	
//    protected Long carrierId;
    protected Long resourceId;
    protected Integer publishDate;    
    protected Long customerId;	
    protected Long contractId;
    protected Long orderId;
    protected Long orderDetailId;
    protected Long matterId;      
    protected Long ownerUserId;   //归属业务员
    
    protected String firstName;	
    protected String lastName;	
    
    protected String orderCode;
    
    protected Boolean spaceAdver;
    protected String resourceName;
    
    protected String total;
    protected String usedTime;
    protected String orgId;
    
    protected Long tempId; 
    protected Integer ctrBroTime;
    protected Integer ctrBroSort;

    
  
    protected PublishArrange publishArrange = new PublishArrange();
  


    
    /**
     * @hibernate.id column="arrange_detail_id" generator-class="native" unsaved-value="null"
     */
	public Long getId() {
		return id;
	}  
	/**
	 * 
	 * Returns the publishArrangeId
	 * @return Long 
	 * 
	 * @hibernate.property_bak length="128" column="arrange_id" not-null="true"
	 */
	public Long getPublishArrangeId() {
		return publishArrangeId;
	}
	

	/**
	 * 
	 * Returns the publishSort
	 * @return Integer 
	 * 
	 * @hibernate.property length="5" column="publish_sort" not-null="false"
	 */
	public Integer getPublishSort() {
		return publishSort;
	}
	/**
	 * 
	 * Returns the specificValue
	 * @return String 
	 * 
	 * @hibernate.property length="2" column="specific_value" not-null="false"
	 */
	public String getSpecificValue() {
		return specificValue;
	}

	/**
	 * 
	 * Returns the orderDayId
	 * @return Long 
	 * 
	 * @hibernate.property length="128" column="order_day_info_id" not-null="false"
	 */
	public Long getOrderDayId() {
		return orderDayId;
	}
	
	/**
	 * 
	 * Returns the customerName
	 * @return String 
	 * 
	 * @hibernate.property length="50" column="customer_name" not-null="false"
	 */
	public String getCustomerName() {
		return customerName;
	}
	
	/**
	 * 
	 * Returns the tapeCode
	 * @return String 
	 * 
	 * @hibernate.property length="20" column="tape_code" not-null="false"
	 */
	public String getTapeCode() {
		return tapeCode;
	}
	
	/**
	 * 
	 * Returns the matterEdit
	 * @return String 
	 * 
	 * @hibernate.property length="50" column="matter_edit" not-null="false"
	 */
	public String getMatterEdit() {
		return matterEdit;
	}

	/**
	 * 
	 * Returns the matterLength
	 * @return String 
	 * 
	 * @hibernate.property length="10" column="matter_length" not-null="false"
	 */
	public String getMatterLength() {
		return matterLength;
	}

	/**
	 * 
	 * Returns the matterName
	 * @return String 
     * @struts.validator type="required"
	 * @hibernate.property length="50" column="matter_name" not-null="false"
	 */
	public String getMatterName() {
		return matterName;
	}
	

	/**
	 * 
	 * Returns the specificName
	 * @return String 
	 * 
	 * @hibernate.property length="10" column="specific_name" not-null="false"
	 */
	public String getSpecificName() {
		return specificName;
	}

	/**
	 * 
	 * Returns the adverTimes
	 * @return Integer 
	 * 
	 * @hibernate.property length="8" column="adver_times" not-null="false"
	 */
	public Integer getAdverTimes() {
		return adverTimes;
	}
	/**
	 * 
	 * Returns the ownerUserName
	 * @return String 
	 * 
	 * @hibernate.property length="20" column="owner_user_name" not-null="false"
	 */
	public String getOwnerUserName() {
//		return ownerUserName;
		return  this.firstName + this.lastName;
	}

	/**
	 * 
	 * Returns the publishMemo
	 * @return String 
	 * 
	 * @hibernate.property length="20" column="publish_memo" not-null="false"
	 */
	public String getPublishMemo() {
		return publishMemo;
	}






   
	
	
	
//	public Long getCarrierId() {
//		return carrierId;
//	}
	public Long getResourceId() {
		return resourceId;
	}	
	public Integer getPublishDate() {
		return publishDate;
	}	
	
	/**
	 * 
	 * Returns the contractId
	 * @return Long 
	 * 
	 * @hibernate.property_BAK length="128" column="contract_id" not-null="false"
	 */
	public Long getContractId() {
		return contractId;
	}

	/**
	 * 
	 * Returns the customerId
	 * @return Long 
	 * 
	 * @hibernate.property_BAK length="128" column="customer_id" not-null="false"
	 */
	public Long getCustomerId() {
		return customerId;
	}
	/**
	 * 
	 * Returns the matterId
	 * @return Long 
	 * 
	 * @hibernate.property_BAK length="128" column="matter_id" not-null="false"
	 */
	public Long getMatterId() {
		return matterId;
	}	
	/**
	 * 
	 * Returns the orderDetailId
	 * @return Long 
	 * 
	 * @hibernate.property_BAK length="128" column="order_detail_id" not-null="false"
	 */
	public Long getOrderDetailId() {
		return orderDetailId;
	}

	/**
	 * 
	 * Returns the orderId
	 * @return Long 
	 * 
	 * @hibernate.property_BAK length="128" column="order_id" not-null="false"
	 */
	public Long getOrderId() {
		return orderId;
	}

	/**
	 * 
	 * Returns the ownerUserId
	 * @return Long 
	 * 
	 * @hibernate.property_bak length="128" column="owner_user_id" not-null="false"
	 */
	public Long getOwnerUserId() {
		return ownerUserId;
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//	public void setCarrierId(Long carrierId) {
//		this.carrierId = carrierId;
//	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}

	public void setPublishDate(Integer publishDate) {
		this.publishDate = publishDate;
	}

	/** 
	 * @param adverTimes The adverTimes to set.
	 */
	public void setAdverTimes(Integer adverTimes) {
		this.adverTimes = adverTimes;
	}
	/** 
	 * @param contractId The contractId to set.
	 */
	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}
	/** 
	 * @param customerId The customerId to set.
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	/** 
	 * @param customerName The customerName to set.
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/** 
	 * @param id The id to set.
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/** 
	 * @param matterEdit The matterEdit to set.
	 */
	public void setMatterEdit(String matterEdit) {
		this.matterEdit = matterEdit;
	}
	/** 
	 * @param matterId The matterId to set.
	 */
	public void setMatterId(Long matterId) {
		this.matterId = matterId;
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
	 * @param orderDayId The orderDayId to set.
	 */
	public void setOrderDayId(Long orderDayId) {
		this.orderDayId = orderDayId;
	}
	/** 
	 * @param orderDetailId The orderDetailId to set.
	 */
	public void setOrderDetailId(Long orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	/** 
	 * @param orderId The orderId to set.
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	/** 
	 * @param ownerUserId The ownerUserId to set.
	 */
	public void setOwnerUserId(Long ownerUserId) {
		this.ownerUserId = ownerUserId;
	}
//	/** 
//	 * @param ownerUserName The ownerUserName to set.
//	 */
//	public void setOwnerUserName(String ownerUserName) {
//		this.ownerUserName = ownerUserName;
//	}
	/** 
	 * @param publishArrangeId The publishArrangeId to set.
	 */
	public void setPublishArrangeId(Long publishArrangeId) {
		this.publishArrangeId = publishArrangeId;
	}
	/** 
	 * @param publishMemo The publishMemo to set.
	 */
	public void setPublishMemo(String publishMemo) {
		this.publishMemo = publishMemo;
	}
	/** 
	 * @param publishSort The publishSort to set.
	 */
	public void setPublishSort(Integer publishSort) {
		this.publishSort = publishSort;
	}
	/** 
	 * @param specificName The specificName to set.
	 */
	public void setSpecificName(String specificName) {
		this.specificName = specificName;
	}
	/** 
	 * @param specificValue The specificValue to set.
	 */
	public void setSpecificValue(String specificValue) {
		this.specificValue = specificValue;
	}
	/** 
	 * @param tapeCode The tapeCode to set.
	 */
	public void setTapeCode(String tapeCode) {
		this.tapeCode = tapeCode;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof PublishArrangeDetail)) {
			return false;
		}
		PublishArrangeDetail rhs = (PublishArrangeDetail) object;
		return new EqualsBuilder().append(this.publishDate, rhs.publishDate)
				.append(this.ownerUserName, rhs.ownerUserName).append(
						this.matterId, rhs.matterId).append(this.orderDetailId,
						rhs.orderDetailId).append(this.ownerUserId,
						rhs.ownerUserId)
				.append(this.orderDayId, rhs.orderDayId).append(this.firstName,
						rhs.firstName).append(this.id, rhs.id).append(
						this.lastName, rhs.lastName).append(this.contractId,
						rhs.contractId).append(this.customerId, rhs.customerId)
				.append(this.specificValue, rhs.specificValue).append(
						this.specificName, rhs.specificName).append(
						this.publishMemo, rhs.publishMemo).append(
						this.tapeCode, rhs.tapeCode).append(this.matterEdit,
						rhs.matterEdit).append(this.matterLength,
						rhs.matterLength).append(this.orderId, rhs.orderId)
				.append(this.customerName, rhs.customerName).append(
						this.publishSort, rhs.publishSort).append(
						this.publishArrangeId, rhs.publishArrangeId).append(
						this.matterName, rhs.matterName).append(
						this.resourceId, rhs.resourceId).append(
						this.adverTimes, rhs.adverTimes).isEquals();
	}
	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(1339184561, 1580632919).append(
				this.publishDate).append(this.ownerUserName).append(
				this.matterId).append(this.orderDetailId).append(
				this.ownerUserId).append(this.orderDayId)
				.append(this.firstName).append(this.id).append(this.lastName)
				.append(this.contractId).append(this.customerId).append(
						this.specificValue).append(this.specificName).append(
						this.publishMemo).append(this.tapeCode).append(
						this.matterEdit).append(this.matterLength).append(
						this.orderId).append(this.customerName).append(
						this.publishSort).append(this.publishArrangeId).append(
						this.matterName).append(this.resourceId).append(
						this.adverTimes).toHashCode();
	}
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("matterName", this.matterName)
				.append("id", this.id).append("tapeCode", this.tapeCode)
				.append("matterLength", this.matterLength).append("matterEdit",
						this.matterEdit)
				.append("publishMemo", this.publishMemo).append("matterId",
						this.matterId).append("publishArrangeId",
						this.publishArrangeId).append("resourceId",
						this.resourceId).append("contractId", this.contractId)
				.append("orderDayId", this.orderDayId).append("ownerUserName",
						this.ownerUserName).append("specificName",
						this.specificName)
				.append("adverTimes", this.adverTimes).append("customerId",
						this.customerId)
				.append("publishDate", this.publishDate).append("ownerUserId",
						this.ownerUserId).append("firstName", this.firstName)
				.append("publishSort", this.publishSort).append("orderId",
						this.orderId).append("lastName", this.lastName).append(
						"customerName", this.customerName).append(
						"orderDetailId", this.orderDetailId).append(
						"specificValue", this.specificValue).toString();
	}
	public int compareTo(Object o) {
		
		PublishArrangeDetail other = (PublishArrangeDetail)o;

	       return publishSort.intValue() - other.publishSort.intValue();
	
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public Boolean getSpaceAdver() {
		return spaceAdver;
	}
	public void setSpaceAdver(Boolean spaceAdver) {
		this.spaceAdver = spaceAdver;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getUsedTime() {
		return usedTime;
	}
	public void setUsedTime(String usedTime) {
		this.usedTime = usedTime;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public Long getTempId() {
		return tempId;
	}
	public void setTempId(Long tempId) {
		this.tempId = tempId;
	}
	public Integer getCtrBroTime() {
		return ctrBroTime;
	}
	public void setCtrBroTime(Integer ctrBroTime) {
		this.ctrBroTime = ctrBroTime;
	}

	public PublishArrange getPublishArrange() {
		return publishArrange;
	}
	public void setPublishArrange(PublishArrange publishArrange) {
		this.publishArrange = publishArrange;
	}
	public Integer getCtrBroSort() {
		return ctrBroSort;
	}
	public void setCtrBroSort(Integer ctrBroSort) {
		this.ctrBroSort = ctrBroSort;
	}



}
