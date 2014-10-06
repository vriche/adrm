package com.vriche.adrm.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;



public class CustomerProduct extends BaseObject implements Comparable{
	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 1L;
	
	protected Integer broadcastStartTime;
	protected Integer broadcastEndTime;
	protected String broadcastStartT;
	protected String broadcastEndT;
	
	protected String customerName;
	protected Double relIncome;
	protected Double putOn;
	protected String matterName;
	protected String orderCode;
	protected String industryType;
	protected Double timeUsed;
	protected String carrierName;
	protected Integer publishDate;
	protected String resourceName;
	protected String resourceMeno;
	protected String total;
	protected String used;
	protected String sumUsed;
	protected Long resourceId;
	protected Integer displayNo;
	
	protected Double standardTime;
	
	protected String month;
	protected Double[] dayTimes = new Double[31];
	protected Double[] dayStandards = new Double[31];
	
	protected String orderBy; 
	

	public Integer getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Integer publishDate) {
		this.publishDate = publishDate;
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

	public String getUsed() {
		return used;
	}

	public void setUsed(String used) {
		this.used = used;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}


	public Double getTimeUsed() {
		return timeUsed;
	}

	public void setTimeUsed(Double timeUsed) {
		this.timeUsed = timeUsed;
	}

	public String getMatterName() {
		return matterName;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public Double getRelIncome() {
		return relIncome;
	}

	public void setMatterName(String matterName) {
		this.matterName = matterName;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public void setRelIncome(Double relIncome) {
		this.relIncome = relIncome;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getIndustryType() {
		return industryType;
	}

	public void setIndustryType(String industryType) {
		this.industryType = industryType;
	}

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof CustomerProduct)) {
			return false;
		}
		CustomerProduct rhs = (CustomerProduct) object;
		return new EqualsBuilder().append(
				this.relIncome, rhs.relIncome).append(this.orderCode,
				rhs.orderCode).append(this.customerName, rhs.customerName)
				.append(this.matterName, rhs.matterName).isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-328254601, -933393077).append(this.relIncome).append(this.orderCode)
				.append(this.customerName).append(this.matterName).toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("matterName", this.matterName)
				.append("orderCode", this.orderCode).append("relIncome",
						this.relIncome).append("customerName",
						this.customerName).toString();
	}
	

	
	public String getSumUsed() {
		return sumUsed;
	}

	public void setSumUsed(String sumUsed) {
		this.sumUsed = sumUsed;
	}

	public Double[] getDayTimes() {
		return dayTimes;
	}

	public void setDayTimes(Double[] dayTimes) {
		this.dayTimes = dayTimes;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Long getResourceId() {
		return resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}

	public Double getPutOn() {
		return putOn;
	}

	public void setPutOn(Double putOn) {
		this.putOn = putOn;
	}

	public String getResourceMeno() {
		return resourceMeno;
	}

	public void setResourceMeno(String resourceMeno) {
		this.resourceMeno = resourceMeno;
	}


	public int compareTo(Object o) {
		
		CustomerProduct other = (CustomerProduct)o;

	       return displayNo.intValue() - other.displayNo.intValue();
	
	}

	public Integer getDisplayNo() {
		return displayNo;
	}

	public void setDisplayNo(Integer displayNo) {
		this.displayNo = displayNo;
	}

	/**
	 * @return Returns the broadcastEndT.
	 */
	public String getBroadcastEndT() {
		return broadcastEndT;
	}

	/**
	 * @param broadcastEndT The broadcastEndT to set.
	 */
	public void setBroadcastEndT(String broadcastEndT) {
		this.broadcastEndT = broadcastEndT;
	}

	/**
	 * @return Returns the broadcastEndTime.
	 */
	public Integer getBroadcastEndTime() {
		return broadcastEndTime;
	}

	/**
	 * @param broadcastEndTime The broadcastEndTime to set.
	 */
	public void setBroadcastEndTime(Integer broadcastEndTime) {
		this.broadcastEndTime = broadcastEndTime;
	}

	/**
	 * @return Returns the broadcastStartT.
	 */
	public String getBroadcastStartT() {
		return broadcastStartT;
	}

	/**
	 * @param broadcastStartT The broadcastStartT to set.
	 */
	public void setBroadcastStartT(String broadcastStartT) {
		this.broadcastStartT = broadcastStartT;
	}

	/**
	 * @return Returns the broadcastStartTime.
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

	/**
	 * @return Returns the standardTime.
	 */
	public Double getStandardTime() {
		return standardTime;
	}

	/**
	 * @param standardTime The standardTime to set.
	 */
	public void setStandardTime(Double standardTime) {
		this.standardTime = standardTime;
	}



	/**
	 * @return Returns the dayStandards.
	 */
	public Double[] getDayStandards() {
		return dayStandards;
	}

	/**
	 * @param dayStandards The dayStandards to set.
	 */
	public void setDayStandards(Double[] dayStandards) {
		this.dayStandards = dayStandards;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
}




