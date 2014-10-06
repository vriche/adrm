package com.vriche.adrm.model;

import org.apache.commons.lang.builder.ToStringBuilder;

public class ParamClass {
	
	protected String  carrierId;   //频道
    protected String  startDate;   //开始日期
    protected String  endDate;     //结束日期
    protected String  startTime;   //开始时间
    protected String  endTime;     //结束时间
    
    protected String  id;     //ID
    protected String  typeId;     //客户ID
    
    protected String  customerName;     //客户名
    protected String  customerTypeName;     //客户类型名
    protected String  programName;     //节目名
    protected String  programTypeName;     //节目类型名
    protected String  orderCode;     //订单编号
    protected String  copyRightCode;     //版权编号
    protected Long  orderTypeId;     //订单类型
    protected Double  payMoney;     //订单类型
    protected String  sumTime;     //次数
    
    //节目收视分析
    protected Integer audienceDate ;       //收视日期12
	protected Integer audienceTime ;       //时间段12
	protected String audienceRat;       //收视率 20
	protected String  carrierName;     //频道名
	
	//节目收入分析
	
	protected Integer publishDate;
	protected String total;
	protected Double dayRelIncome;
	protected String  memo;
	protected Double relIncome ;
	protected Double totalIncome ;
	
	protected String planDate ;
	protected String second ;
	
   
	/**
	 * @return Returns the copyRightCode.
	 */
	public String getCopyRightCode() {
		return copyRightCode;
	}

	/**
	 * @param copyRightCode The copyRightCode to set.
	 */
	public void setCopyRightCode(String copyRightCode) {
		this.copyRightCode = copyRightCode;
	}

	/**
	 * @return Returns the orderTypeId.
	 */
	public Long getOrderTypeId() {
		return orderTypeId;
	}

	/**
	 * @param orderTypeId The orderTypeId to set.
	 */
	public void setOrderTypeId(Long orderTypeId) {
		this.orderTypeId = orderTypeId;
	}

	/**
	 * @return Returns the startDate.
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate The startDate to set.
	 */
	public void setStartDate(String startDate) {
		this.startDate =startDate;
	}

	

	
    /**
	 * @return Returns the endDate.
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate The endDate to set.
	 */
	public void setEndDate(String endDate) {
		this.endDate =  endDate;
	}

	/**
	 * @return Returns the startTime.
	 */
	public String getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime The startTime to set.
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	/**
	 * @return Returns the endTime.
	 */
	public String getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime The endTime to set.
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}


	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("endDate", this.endDate)
				.append("endTime", this.endTime).append("startDate",
						this.startDate).append("startTime", this.startTime)
				.toString();
	}

	/**
	 * @return Returns the carrierId.
	 */
	public String getCarrierId() {
		return carrierId;
	}

	/**
	 * @param carrierId The carrierId to set.
	 */
	public void setCarrierId(String carrierId) {
		this.carrierId = carrierId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerTypeName() {
		return customerTypeName;
	}

	public void setCustomerTypeName(String customerTypeName) {
		this.customerTypeName = customerTypeName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getProgramTypeName() {
		return programTypeName;
	}

	public void setProgramTypeName(String programTypeName) {
		this.programTypeName = programTypeName;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	/**
	 * @return Returns the payMoney.
	 */
	public Double getPayMoney() {
		return payMoney;
	}

	/**
	 * @param payMoney The payMoney to set.
	 */
	public void setPayMoney(Double payMoney) {
		this.payMoney = payMoney;
	}

	/**
	 * @return Returns the audienceDate.
	 */
	public Integer getAudienceDate() {
		return audienceDate;
	}

	/**
	 * @param audienceDate The audienceDate to set.
	 */
	public void setAudienceDate(Integer audienceDate) {
		this.audienceDate = audienceDate;
	}

	/**
	 * @return Returns the audienceRat.
	 */
	public String getAudienceRat() {
		return audienceRat;
	}

	/**
	 * @param audienceRat The audienceRat to set.
	 */
	public void setAudienceRat(String audienceRat) {
		this.audienceRat = audienceRat;
	}

	/**
	 * @return Returns the audienceTime.
	 */
	public Integer getAudienceTime() {
		return audienceTime;
	}

	/**
	 * @param audienceTime The audienceTime to set.
	 */
	public void setAudienceTime(Integer audienceTime) {
		this.audienceTime = audienceTime;
	}

	/**
	 * @return Returns the dayRelIncome.
	 */
	public Double getDayRelIncome() {
		return dayRelIncome;
	}

	/**
	 * @param dayRelIncome The dayRelIncome to set.
	 */
	public void setDayRelIncome(Double dayRelIncome) {
		this.dayRelIncome = dayRelIncome;
	}

	/**
	 * @return Returns the memo.
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * @param memo The memo to set.
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}

	/**
	 * @return Returns the publishDate.
	 */
	public Integer getPublishDate() {
		return publishDate;
	}

	/**
	 * @param publishDate The publishDate to set.
	 */
	public void setPublishDate(Integer publishDate) {
		this.publishDate = publishDate;
	}

	/**
	 * @return Returns the total.
	 */
	public String getTotal() {
		return total;
	}

	/**
	 * @param total The total to set.
	 */
	public void setTotal(String total) {
		this.total = total;
	}

	/**
	 * @return Returns the relIncome.
	 */
	public Double getRelIncome() {
		return relIncome;
	}

	/**
	 * @param relIncome The relIncome to set.
	 */
	public void setRelIncome(Double relIncome) {
		this.relIncome = relIncome;
	}

	/**
	 * @return Returns the totalIncome.
	 */
	public Double getTotalIncome() {
		return totalIncome;
	}

	/**
	 * @param totalIncome The totalIncome to set.
	 */
	public void setTotalIncome(Double totalIncome) {
		this.totalIncome = totalIncome;
	}

	/**
	 * @return Returns the carrierName.
	 */
	public String getCarrierName() {
		return carrierName;
	}

	/**
	 * @param carrierName The carrierName to set.
	 */
	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	/**
	 * @return Returns the planDate.
	 */
	public String getPlanDate() {
		return planDate;
	}

	/**
	 * @param planDate The planDate to set.
	 */
	public void setPlanDate(String planDate) {
		this.planDate = planDate;
	}

	/**
	 * @return Returns the second.
	 */
	public String getSecond() {
		return second;
	}

	/**
	 * @param second The second to set.
	 */
	public void setSecond(String second) {
		this.second = second;
	}

	public String getSumTime() {
		return sumTime;
	}

	public void setSumTime(String sumTime) {
		this.sumTime = sumTime;
	}
}
