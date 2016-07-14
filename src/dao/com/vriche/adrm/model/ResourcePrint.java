package com.vriche.adrm.model;

public class ResourcePrint extends BaseObject {

	protected String resourceId;
    protected String resourceName;
    protected String carrierId;
    protected String parentId;
    protected String carrierName;
    protected String memo;
    protected String length;
    protected String price;
    protected String sunLength;
    protected String monLength;
    protected String tueLength;
    protected String thiLength;
    protected String wenLength;
    protected String friLength;
    protected String satLength;
    protected String fivePrice;
    protected String tenPrice;
    protected String fifteenPrice;
    protected String thirtyPrice;
    protected String sixtyPrice;
    protected String weekDay;
    protected Integer displayNo;
    
    protected Integer beforehand;
    
    protected Workspan workspan =new Workspan();
	
	public Workspan getWorkspan() {
		return workspan;
	}

	public void setWorkspan(Workspan workspan) {
		this.workspan = workspan;
	}

	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
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
	 * @return Returns the fifteenPrice.
	 */
	public String getFifteenPrice() {
		return fifteenPrice;
	}

	/**
	 * @param fifteenPrice The fifteenPrice to set.
	 */
	public void setFifteenPrice(String fifteenPrice) {
		this.fifteenPrice = fifteenPrice;
	}

	/**
	 * @return Returns the fivePrice.
	 */
	public String getFivePrice() {
		return fivePrice;
	}

	/**
	 * @param fivePrice The fivePrice to set.
	 */
	public void setFivePrice(String fivePrice) {
		this.fivePrice = fivePrice;
	}

	/**
	 * @return Returns the friLength.
	 */
	public String getFriLength() {
		return friLength;
	}

	/**
	 * @param friLength The friLength to set.
	 */
	public void setFriLength(String friLength) {
		this.friLength = friLength;
	}

	/**
	 * @return Returns the length.
	 */
	public String getLength() {
		return length;
	}

	/**
	 * @param length The length to set.
	 */
	public void setLength(String length) {
		this.length = length;
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
	 * @return Returns the monLength.
	 */
	public String getMonLength() {
		return monLength;
	}

	/**
	 * @param monLength The monLength to set.
	 */
	public void setMonLength(String monLength) {
		this.monLength = monLength;
	}

	/**
	 * @return Returns the price.
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * @param price The price to set.
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * @return Returns the resourceId.
	 */
	public String getResourceId() {
		return resourceId;
	}

	/**
	 * @param resourceId The resourceId to set.
	 */
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	/**
	 * @return Returns the resourceName.
	 */
	public String getResourceName() {
		return resourceName;
	}

	/**
	 * @param resourceName The resourceName to set.
	 */
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	/**
	 * @return Returns the satLength.
	 */
	public String getSatLength() {
		return satLength;
	}

	/**
	 * @param satLength The satLength to set.
	 */
	public void setSatLength(String satLength) {
		this.satLength = satLength;
	}

	/**
	 * @return Returns the sixtyPrice.
	 */
	public String getSixtyPrice() {
		return sixtyPrice;
	}

	/**
	 * @param sixtyPrice The sixtyPrice to set.
	 */
	public void setSixtyPrice(String sixtyPrice) {
		this.sixtyPrice = sixtyPrice;
	}

	/**
	 * @return Returns the sunLength.
	 */
	public String getSunLength() {
		return sunLength;
	}

	/**
	 * @param sunLength The sunLength to set.
	 */
	public void setSunLength(String sunLength) {
		this.sunLength = sunLength;
	}

	/**
	 * @return Returns the tenPrice.
	 */
	public String getTenPrice() {
		return tenPrice;
	}

	/**
	 * @param tenPrice The tenPrice to set.
	 */
	public void setTenPrice(String tenPrice) {
		this.tenPrice = tenPrice;
	}

	/**
	 * @return Returns the thiLength.
	 */
	public String getThiLength() {
		return thiLength;
	}

	/**
	 * @param thiLength The thiLength to set.
	 */
	public void setThiLength(String thiLength) {
		this.thiLength = thiLength;
	}

	/**
	 * @return Returns the thirtyPrice.
	 */
	public String getThirtyPrice() {
		return thirtyPrice;
	}

	/**
	 * @param thirtyPrice The thirtyPrice to set.
	 */
	public void setThirtyPrice(String thirtyPrice) {
		this.thirtyPrice = thirtyPrice;
	}

	/**
	 * @return Returns the tueLength.
	 */
	public String getTueLength() {
		return tueLength;
	}

	/**
	 * @param tueLength The tueLength to set.
	 */
	public void setTueLength(String tueLength) {
		this.tueLength = tueLength;
	}

	/**
	 * @return Returns the weekDay.
	 */
	public String getWeekDay() {
		return weekDay;
	}

	/**
	 * @param weekDay The weekDay to set.
	 */
	public void setWeekDay(String weekDay) {
		this.weekDay = weekDay;
	}

	/**
	 * @return Returns the wenLength.
	 */
	public String getWenLength() {
		return wenLength;
	}

	/**
	 * @param wenLength The wenLength to set.
	 */
	public void setWenLength(String wenLength) {
		this.wenLength = wenLength;
	}

	/**
	 * @return Returns the parentId.
	 */
	public String getParentId() {
		return parentId;
	}

	/**
	 * @param parentId The parentId to set.
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	/**
	 * @return Returns the displayNo.
	 */
	public Integer getDisplayNo() {
		return displayNo;
	}

	/**
	 * @param displayNo The displayNo to set.
	 */
	public void setDisplayNo(Integer displayNo) {
		this.displayNo = displayNo;
	}

	public Integer getBeforehand() {
		return beforehand;
	}

	public void setBeforehand(Integer beforehand) {
		this.beforehand = beforehand;
	}

}
