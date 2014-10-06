package com.vriche.adrm.model;

import java.util.Date;

public class OrderColl {
	    protected String  orderCode;
	    protected String  contractId;
	    protected String    customerName;		 // required
	    protected String  matterName;		 // required
	    protected String  startDate;

	    protected String isCkecked;
	    protected String  endDate;

	    protected String    moneyRealpay;				 
	    protected String    moneyIn;		 //default timestamp	  
	    protected String    user;		 //
	    protected String    firstName;		 //
	    protected String    lastName;		 //
		/**
		 * @return Returns the contractId.
		 */
		public String getContractId() {
			return contractId;
		}
		/**
		 * @param contractId The contractId to set.
		 */
		public void setContractId(String contractId) {
			this.contractId = contractId;
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
		 * @return Returns the endDate.
		 */
		public String getEndDate() {
			return endDate;
		}
		/**
		 * @param endDate The endDate to set.
		 */
		public void setEndDate(String endDate) {
			this.endDate = endDate;
		}
		/**
		 * @return Returns the isCkecked.
		 */
		public String getIsCkecked() {
			return isCkecked;
		}
		/**
		 * @param isCkecked The isCkecked to set.
		 */
		public void setIsCkecked(String isCkecked) {
			this.isCkecked = isCkecked;
		}
		/**
		 * @return Returns the matterName.
		 */
		public String getMatterName() {
			return matterName;
		}
		/**
		 * @param matterName The matterName to set.
		 */
		public void setMatterName(String matterName) {
			this.matterName = matterName;
		}
		/**
		 * @return Returns the moneyIn.
		 */
		public String getMoneyIn() {
			return moneyIn;
		}
		/**
		 * @param moneyIn The moneyIn to set.
		 */
		public void setMoneyIn(String moneyIn) {
			this.moneyIn = moneyIn;
		}
		/**
		 * @return Returns the moneyRealpay.
		 */
		public String getMoneyRealpay() {
			return moneyRealpay;
		}
		/**
		 * @param moneyRealpay The moneyRealpay to set.
		 */
		public void setMoneyRealpay(String moneyRealpay) {
			this.moneyRealpay = moneyRealpay;
		}
		/**
		 * @return Returns the orderCode.
		 */
		public String getOrderCode() {
			return orderCode;
		}
		/**
		 * @param orderCode The orderCode to set.
		 */
		public void setOrderCode(String orderCode) {
			this.orderCode = orderCode;
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
			this.startDate = startDate;
		}
		/**
		 * @return Returns the user.
		 */
		public String getUser() {
			return this.firstName+this.lastName;
		}
		/**
		 * @param user The user to set.
		 */
		public void setUser(String user) {
			this.user = user;
		}
		/**
		 * @return Returns the firstName.
		 */
		public String getFirstName() {
			return firstName;
		}
		/**
		 * @param firstName The firstName to set.
		 */
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		/**
		 * @return Returns the lastName.
		 */
		public String getLastName() {
			return lastName;
		}
		/**
		 * @param lastName The lastName to set.
		 */
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
	    
}
