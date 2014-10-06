package com.vriche.adrm.model;

import java.util.List;

public class CustomerAnalyzeColl {
	protected  String id;
	 protected String customerName;
	 protected String customerIncome;
	 protected String dayStandardPrice;
	 protected String dayRelIncome;
	 protected String dayRelPuton;
	 protected String dayPayMoney;
	 protected String adSumTimes;
	 protected String sortStr;
	 protected List month;
	 
	 
//	 protected int sorCol;
//	 protected int sorType;
//	 protected Integer tt;
	 
	 
	/**
	 * @return Returns the adSumTimes.
	 */
	public String getAdSumTimes() {
		return adSumTimes;
	}
	/**
	 * @param adSumTimes The adSumTimes to set.
	 */
	public void setAdSumTimes(String adSumTimes) {
		this.adSumTimes = adSumTimes;
	}
	/**
	 * @return Returns the customerName.
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param customerName The customerName to set.
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * @return Returns the dayRelIncome.
	 */
	public String getDayRelIncome() {
		return dayRelIncome;
	}
	/**
	 * @param dayRelIncome The dayRelIncome to set.
	 */
	public void setDayRelIncome(String dayRelIncome) {
		this.dayRelIncome = dayRelIncome;
	}
	/**
	 * @return Returns the dayRelPuton.
	 */
	public String getDayRelPuton() {
		return dayRelPuton;
	}
	/**
	 * @param dayRelPuton The dayRelPuton to set.
	 */
	public void setDayRelPuton(String dayRelPuton) {
		this.dayRelPuton = dayRelPuton;
	}
	/**
	 * @return Returns the customerIncome.
	 */
	public String getCustomerIncome() {
		return customerIncome;
	}
	/**
	 * @param customerIncome The customerIncome to set.
	 */
	public void setCustomerIncome(String customerIncome) {
		this.customerIncome = customerIncome;
	}
	/**
	 * @return Returns the sortStr.
	 */
	public String getSortStr() {
		return sortStr;
	}
	/**
	 * @param sortStr The sortStr to set.
	 */
	public void setSortStr(String sortStr) {
		this.sortStr = sortStr;
	}
	/**
	 * @return Returns the dayPayMoney.
	 */
	public String getDayPayMoney() {
		return dayPayMoney;
	}
	/**
	 * @param dayPayMoney The dayPayMoney to set.
	 */
	public void setDayPayMoney(String dayPayMoney) {
		this.dayPayMoney = dayPayMoney;
	}
	/**
	 * @param sorCol The sorCol to set.
	 */
//	public void setSorCol(int sorCol) {
//		this.sorCol = sorCol;
//	}
//	/**
//	 * @param sorType The sorType to set.
//	 */
//	public void setSorType(int sorType) {
//		this.sorType = sorType;
//	}
//	/**
//	 * @return Returns the tt.
//	 */
//	public Integer getTt() {
//		return tt;
//	}
//	/**
//	 * @param tt The tt to set.
//	 */
//	public void setTt(Integer tt) {
//		this.tt = tt;
//	}
	/**
	 * @return Returns the id.
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id The id to set.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param month The month to set.
	 */
	public void setMonth(List month) {
		this.month = month;
	}
	/**
	 * @return Returns the month.
	 */
	public List getMonth() {
		return month;
	}
	/**
	 * @return Returns the dayStandardPrice.
	 */
	public String getDayStandardPrice() {
		return dayStandardPrice;
	}
	/**
	 * @param dayStandardPrice The dayStandardPrice to set.
	 */
	public void setDayStandardPrice(String dayStandardPrice) {
		this.dayStandardPrice = dayStandardPrice;
	}
}
