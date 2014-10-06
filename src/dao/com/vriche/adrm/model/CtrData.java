package com.vriche.adrm.model;

public class CtrData extends BaseObjectWithoutNestedFormValidation {
	
	protected Long id;
	
	protected String carrierName;
	protected Integer broDate;
	protected Integer broTime;
	protected Integer broSort;
	protected String advContents;
	protected Integer broLength;
	protected Integer orgId;
	
	protected String broDateStr;
	protected String broTimeStr;
	

	

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

	public String getAdvContents() {
		return advContents;
	}

	public void setAdvContents(String advContents) {
		this.advContents = advContents;
	}



	public Integer getBroLength() {
		return broLength;
	}

	public void setBroLength(Integer broLength) {
		this.broLength = broLength;
	}



	public Integer getBroDate() {
		return broDate;
	}

	public Integer getBroTime() {
		return broTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public String getBroDateStr() {
		return broDateStr;
	}

	public void setBroDateStr(String broDateStr) {
		this.broDateStr = broDateStr;
	}

	public String getBroTimeStr() {
		return broTimeStr;
	}

	public void setBroTimeStr(String broTimeStr) {
		this.broTimeStr = broTimeStr;
	}

	public void setBroDate(Integer broDate) {
		this.broDate = broDate;
	}

	public void setBroTime(Integer broTime) {
		this.broTime = broTime;
	}

	public Integer getBroSort() {
		return broSort;
	}

	public void setBroSort(Integer broSort) {
		this.broSort = broSort;
	}

}
