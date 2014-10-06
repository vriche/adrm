/****************************************************************************     
 * Created on 2006-10-16                                                     *    
 *                                                               			*
 * @author <a href="mailto:hongxilin@yahoo.com.cn">hongxi</a>               *
 *         Updated by hongxi (hongxilin@yahoo.com.cn)                       *
 *                                                                          *
 * @version  Vision:1.0														*
 * 																			*
 ***************************************************************************/
package com.vriche.adrm.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;





//import com.vriche.adrm.crm.model.Customer;
//import com.vriche.adrm.order.model.User;
/**
 * Order class
 * 
 * This class is used to 
 * 
 * <p><a href="Order.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_order"
 * 
 */
public class Order extends BaseObject  implements Serializable {
   
    private static final long serialVersionUID = 3832626162173359411L;
    
    protected Long    id;
    protected String  orderCode;
    protected String  relationCode;
    protected Long    contractId;
    protected Long    customerId;		 // required
    protected Long  categoryId;	     // required
    protected Long    userId;		
    protected String  matterId;
    // required
    protected String  orderMeno;

    protected Long isCkecked;
    protected String  publishMemo;

    protected Long    createBy;				 
    protected Date    createDate;		 //default timestamp	  
    protected Long    modifyBy;			 //default timestamp
    protected Date    modifyDate;					  
    protected Integer version;
    protected Long    paymentId;
    //
    protected Long    carrierId;
    
    protected String    carrIds;
    
    protected String orderStates;   
    protected String orderCategorys;
    
    
    protected String customerCategoryCode; 
    protected String orderCategoryMain; 
    
    
    
    protected OrderPublic orderPublic = new OrderPublic();

    protected User user = new User();  
  
    protected User modUser = new User();  
    
    protected Customer customer = new Customer();
    protected Contract contract = new Contract(); 
    protected OaWorkFlowCheckState orderState = new OaWorkFlowCheckState();
  
    
    
    
    protected Set orderDays = new HashSet(); 
    protected Set orderDetails = new HashSet();  
    protected OrderDetail[] orderDetailsObj;
    
    protected Set contractPayments = new HashSet();
    protected Set orderLogs =  new HashSet();
    protected List users =  new ArrayList(); 
  
    protected List carrierIds =  new ArrayList(); 

//    protected OrderDetail orderDetailBak = new OrderDetail();
    
    protected OrderCategory orderCategory = new OrderCategory();
//    protected OrderCategory orderCategoryMan = new OrderCategory();
    protected ContractPayment contractPayment = new ContractPayment();
    protected ContractPayment orderPayment = new ContractPayment();
    
    protected String cutCates = "1"; 
    protected String carrierType;
    protected String carrSort = "1";
    
    protected Long orgId;
    protected String tempStr = "";
    
    protected String loginUser ="";
    
    
    protected String customerIds ="";
    
    protected String isDayRealPlay =null;
    
    protected String orderRelPay =null;
    
    
    protected String orderRate1 =null;
    
    protected String orderRate2 =null;    
    
    
    protected Integer isDisplayMonDetail;
    
    protected String tempString; 
    
    
    
//    DateUtil2 dateUtil2 = new DateUtil2();
    
//    protected Page page = new Page();
    
    public Order(){
    	
//    	String curDate = dateUtil2.GetDate();
//    	int y = dateUtil2.getYear(curDate) ;
//    	int m =  dateUtil2.getMonth(curDate) ;
//    	String d ="01";
//		try {
//			d = dateUtil2.getYearMonthEndDay(y,m);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	
//    	orderPublic.setPublishStartDate(new Integer(String.valueOf(y)+String.valueOf(m)+d));
//    	orderPublic.setPublishEndDate(new Integer(String.valueOf(y)+String.valueOf(m)+d));
    };


    /**
     * @hibernate.id column="order_id" generator-class="native" unsaved-value="null"
     */
    public Long getId() {
        return id;
    }
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
     * @hibernate.version
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 
     * Returns the orderCode
     * @return String
     * 
     * @hibernate.property length="32" column="order_code" not-null="false"
     */
    public String getOrderCode() {
        return orderCode;
    }
    /**
     * 
     * Returns the relationCode
     * @return String
     * 
     * @hibernate.property length="32" column="relation_code" not-null="false"
     */
    public String getRelationCode() {
        return relationCode;
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
     * Returns the customerId
     * @return Long
     * @struts.validator type="required"
     * @BAK_hibernate.property length="20" column="customer_id" not-null="false"
     */
    public Long getCustomerId() {
        return customerId;
    }
    /**
     * 
     * Returns the categoryId
     * @return String
     * @struts.validator type="required"
     * @BAK_hibernate.property length="32" column="order_category_id" not-null="false"
     */
    public Long getCategoryId() {
        return categoryId;
    }
    /**
     * 
     * Returns the userId
     * @return Long
     * @struts.validator type="required"
     * @BAK_hibernate.property length="20" column="user_id" not-null="false"
     */
    public Long getUserId() {
        return userId;
    }
    /**
     * 
     * Returns the orderMeno
     * @return String
     * 
     * @hibernate.property length="256" column="order_meno" not-null="false"
     */
    public String getOrderMeno() {
        return orderMeno;
    }

    /**
     * 
     * Returns the isCkecked
     * @return Long
     * 
     * @hibernate.property length="128" column="is_ckecked" not-null="true" 
     */
    public Long getIsCkecked() {
        return isCkecked;
    }
    /**
     * 
     * Returns the publishMemo
     * @return String
     * 
     * @hibernate.property length="256" column="publish_memo" not-null="false"
     */
    public String getPublishMemo() {
        return publishMemo;
    }
    
	/**
	 * 
	 * Returns the paymentId
	 * @return Long 
	 * 
	 * @hibernate.property length="128" column="contract_payment_id" not-null="true"
	 */
	public Long getPaymentId() {
		return paymentId;
	}
	
	
	

    
    public Contract getContract() {
		return contract;
	}


	/**
    * @hibernate.many-to-one name="customerId" column="customer_id" cascade="all" not-null="true"
	 */
	public Customer getCustomer() {
		return customer;
	}
	
	


	public OrderPublic getOrderPublic() {
		return orderPublic;
	}


	/**
     * @hibernate.many-to-one name="id" column="user_id" cascade="all" not-null="true"
 	 */
	public User getUser() {
		return user;
	}


	/**
     * @BAK_hibernate.set name="orderDetails" table="tb_order_detail" inverse="false" cascade="none" lazy="false"
     * @BAK_hibernate.collection-key column="order_id"
     * @BAK_hibernate.collection-one-to-many class="com.vriche.adrm.model.OrderDetail" column="order_detail_id"
     */
    public Set getOrderDetails() {
        return orderDetails;
    }
    
    /**
     * @bak_hibernate.set name="contractPayments" table="tb_contract_payment" inverse="false" cascade="none" lazy="false"
     * @bak_hibernate.collection-key column="order_id"
     * @bak_hibernate.collection-one-to-many class="com.vriche.adrm.model.ContractPayment" column="contract_payment_id"
     */
    public Set getContractPayments() {
        return contractPayments;
    }
    /**
     * 
     * Returns the orderLogs
     * @return OrderLog
     */
    public Set getOrderLogs() {
        return orderLogs;
    }   
    


	public OaWorkFlowCheckState getOrderState() {
		return orderState;
	}

  

	/**
	 * 
	 * Returns the contractPayment
	 * @return ContractPayment 
	 * 
	 */
	public ContractPayment getContractPayment() {
		return contractPayment;
	}  
    
    
    
    
    
    
    
    

  

    /**
     * @param categoryId The categoryId to set.
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
    /**
     * @param contractId The contractId to set.
     */
    public void setContractId(Long contractId) {
        this.contractId = contractId;
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
     * @param customerId The customerId to set.
     */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    /**
     * @param id The id to set.
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @param isCkecked The isCkecked to set.
     */
    public void setIsCkecked(Long isCkecked) {
        this.isCkecked = isCkecked;
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
     * @param moneyIn The moneyIn to set.
     */
   
    /**
     * @param orderCode The orderCode to set.
     */
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }
    /**
     * @param orderMeno The orderMeno to set.
     */
    public void setOrderMeno(String orderMeno) {
        this.orderMeno = orderMeno;
    }
    /**
     * @param publishMemo The publishMemo to set.
     */
    public void setPublishMemo(String publishMemo) {
        this.publishMemo = publishMemo;
    }
    /**
     * @param relationCode The relationCode to set.
     */
    public void setRelationCode(String relationCode) {
        this.relationCode = relationCode;
    }
    /**
     * @param userId The userId to set.
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    /**
     * @param version The version to set.
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
    /**
     * @param contractPayments The contractPayments to set.
     */
    public void setContractPayments(Set contractPayments) {
        this.contractPayments = contractPayments;
    }
    /**
     * @param orderDetails The orderDetails to set.
     */
    public void setOrderDetails(Set orderDetails) {
        this.orderDetails = orderDetails;
    }

    /**
     * @param isCkecked The isCkecked to set.
     */
    public void setCkecked(Long isCkecked) {
        this.isCkecked = isCkecked;
    }
    /**
     * @param orderLogs The orderLogs to set.
     */
    public void setOrderLogs(Set orderLogs) {
        this.orderLogs = orderLogs;
    }
  

 
    public void setContract(Contract contract) {
		this.contract = contract;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	


	public void setUser(User user) {
		this.user = user;
	}
	


	public void setOrderPublic(OrderPublic orderPublic) {
		this.orderPublic = orderPublic;
	}

	/**
     * @hibernate.many-to-one name="orderCategoryId" column="order_category_id" cascade="all" not-null="true"
 	 */
//	public OrderCategory getOrderCategory() {
//		return orderCategory;
//	}
//
//
//	/** 
//	 * @param orderCategory The orderCategory to set.
//	 */
//	public void setOrderCategory(OrderCategory orderCategory) {
//		this.orderCategory = orderCategory;
//	}


	/** 
	 * @param orderState The orderState to set.
	 */
	public void setOrderState(OaWorkFlowCheckState orderState) {
		this.orderState = orderState;
	}


	/** 
	 * @param paymentId The paymentId to set.
	 */
	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}




	/** 
	 * @param contractPayment The contractPayment to set.
	 */
	public void setContractPayment(ContractPayment contractPayment) {
		this.contractPayment = contractPayment;
	}

	
	
	
	
	

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof Order)) {
			return false;
		}
		Order rhs = (Order) object;
		return new EqualsBuilder().append(this.contract, rhs.contract).append(
				this.isCkecked, rhs.isCkecked).append(this.orderPublic,
				rhs.orderPublic).append(this.orderMeno, rhs.orderMeno).append(
				this.user, rhs.user)
				.append(this.orderDetails, rhs.orderDetails).append(
						this.userId, rhs.userId).append(this.orderCode,
						rhs.orderCode).append(this.orderLogs, rhs.orderLogs)
				.append(this.modifyBy, rhs.modifyBy).append(this.customer,
						rhs.customer).append(this.relationCode,
						rhs.relationCode).append(this.createBy, rhs.createBy)
				.append(this.id, rhs.id)
				.append(this.contractId, rhs.contractId).append(
						this.customerId, rhs.customerId).append(this.version,
						rhs.version).append(this.publishMemo, rhs.publishMemo)
				.append(this.createDate, rhs.createDate).append(
						this.modifyDate, rhs.modifyDate).append(
						this.contractPayments, rhs.contractPayments).append(
						this.categoryId, rhs.categoryId).isEquals();
	}


	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(721563365, -957434623).append(this.contract)
				.append(this.isCkecked).append(this.orderPublic).append(
						this.orderMeno).append(this.user).append(
						this.orderDetails).append(this.userId).append(
						this.orderCode).append(this.orderLogs).append(
						this.modifyBy).append(this.customer).append(
						this.relationCode).append(this.createBy)
				.append(this.id).append(this.contractId)
				.append(this.customerId).append(this.version).append(
						this.publishMemo).append(this.createDate).append(
						this.modifyDate).append(this.contractPayments).append(
						this.categoryId).toHashCode();
	}


	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("modifyBy", this.modifyBy)
				.append("contract", this.contract).append("id", this.id)
				.append("orderPublic", this.orderPublic).append("modifyDate",
						this.modifyDate).append("customerId", this.customerId)
				.append("user", this.user).append("publishMemo",
						this.publishMemo).append("orderDetails",
						this.orderDetails).append("createBy", this.createBy)
				.append("relationCode", this.relationCode).append("isCkecked",
						this.isCkecked).append("contractPayments",
						this.contractPayments)
				.append("customer", this.customer).append("contractId",
						this.contractId).append("version", this.version)
				.append("orderCode", this.orderCode).append("orderLogs",
						this.orderLogs).append("orderMeno", this.orderMeno)
				.append("categoryId", this.categoryId).append("createDate",
						this.createDate).append("userId", this.userId)
				.toString();
	}


    /**
     * @hibernate.set name="orders" table="tb_order" inverse="false" cascade="none" lazy="false"
     * @hibernate.collection-key column="order_id"
     * @hibernate.collection-one-to-many class="com.vriche.adrm.model.OrderDayInfo" column="order_id"
     */
	public Set getOrderDays() {
		return orderDays;
	}


	/** 
	 * @param orderDays The orderDays to set.
	 */
	public void setOrderDays(Set orderDays) {
		this.orderDays = orderDays;
	}


	public ContractPayment getOrderPayment() {
		return orderPayment;
	}


	public void setOrderPayment(ContractPayment orderPayment) {
		this.orderPayment = orderPayment;
	}




	public List getUsers() {
		return users;
	}


	public void setUsers(List users) {
		this.users = users;
	}


	public String getOrderStates() {
		return orderStates;
	}


	public void setOrderStates(String orderStates) {
		this.orderStates = orderStates;
	}


	public List getCarrierIds() {
		return carrierIds;
	}


	public void setCarrierIds(List carrierIds) {
		this.carrierIds = carrierIds;
	}


	public String getMatterId() {
		return matterId;
	}


	public void setMatterId(String matterId) {
		this.matterId = matterId;
	}


	/**
	 * @return Returns the carrierId.
	 */
	public Long getCarrierId() {
		return carrierId;
	}


	/**
	 * @param carrierId The carrierId to set.
	 */
	public void setCarrierId(Long carrierId) {
		this.carrierId = carrierId;
	}


	/**
     * @hibernate.many-to-one name="orderCategoryId" column="order_category_id" cascade="all" not-null="true"
 	 */
	public OrderCategory getOrderCategory() {
		return orderCategory;
	}


	/**
	 * @param orderCategoryMan The orderCategoryMan to set.
	 */
	public void setOrderCategory(OrderCategory orderCategory) {
		this.orderCategory = orderCategory;
	}


	/**
	 * @return Returns the orderCategorys.
	 */
	public String getOrderCategorys() {
		return orderCategorys;
	}


	/**
	 * @param orderCategorys The orderCategorys to set.
	 */
	public void setOrderCategorys(String orderCategorys) {
		this.orderCategorys = orderCategorys;
	}


	public String getCarrIds() {
		return carrIds;
	}


	public void setCarrIds(String carrIds) {
		this.carrIds = carrIds;
	}


	public String getCutCates() {
		return cutCates;
	}

	public void setCutCates(String cutCates) {
		this.cutCates = cutCates;
	}


	public String getCarrierType() {
		return carrierType;
	}


	public void setCarrierType(String carrierType) {
		this.carrierType = carrierType;
	}


	public String getCarrSort() {
		return carrSort;
	}


	public void setCarrSort(String carrSort) {
		this.carrSort = carrSort;
	}


	public Long getOrgId() {
		return orgId;
	}


	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}


	public String getTempStr() {
		return tempStr;
	}


	public void setTempStr(String tempStr) {
		this.tempStr = tempStr;
	}


	public String getCustomerCategoryCode() {
		return customerCategoryCode;
	}


	public void setCustomerCategoryCode(String customerCategoryCode) {
		this.customerCategoryCode = customerCategoryCode;
	}


	public String getLoginUser() {
		return loginUser;
	}


	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}


	public String getCustomerIds() {
		return customerIds;
	}


	public void setCustomerIds(String customerIds) {
		this.customerIds = customerIds;
	}


	public User getModUser() {
		return modUser;
	}


	public void setModUser(User modUser) {
		this.modUser = modUser;
	}


	public String getIsDayRealPlay() {
		return isDayRealPlay;
	}


	public void setIsDayRealPlay(String isDayRealPlay) {
		this.isDayRealPlay = isDayRealPlay;
	}


	public String getOrderRelPay() {
		return orderRelPay;
	}


	public void setOrderRelPay(String orderRelPay) {
		this.orderRelPay = orderRelPay;
	}





	public String getOrderRate1() {
		return orderRate1;
	}


	public void setOrderRate1(String orderRate1) {
		this.orderRate1 = orderRate1;
	}


	public String getOrderRate2() {
		return orderRate2;
	}


	public void setOrderRate2(String orderRate2) {
		this.orderRate2 = orderRate2;
	}


	public OrderDetail[] getOrderDetailsObj() {
		return orderDetailsObj;
	}


	public void setOrderDetailsObj(OrderDetail[] orderDetailsObj) {
		this.orderDetailsObj = orderDetailsObj;
	}


	public String getOrderCategoryMain() {
		return orderCategoryMain;
	}


	public void setOrderCategoryMain(String orderCategoryMain) {
		this.orderCategoryMain = orderCategoryMain;
	}


	public Integer getIsDisplayMonDetail() {
		return isDisplayMonDetail;
	}


	public void setIsDisplayMonDetail(Integer isDisplayMonDetail) {
		this.isDisplayMonDetail = isDisplayMonDetail;
	}


	public String getTempString() {
		return tempString;
	}


	public void setTempString(String tempString) {
		this.tempString = tempString;
	}




}
