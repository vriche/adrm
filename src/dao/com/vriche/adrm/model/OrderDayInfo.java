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


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
//import com.vriche.adrm.order.model.DayInfo;
/**
 * OrderDayInfo class
 * 
 * This class is used to 
 * 
 * <p><a href="OrderDayInfo.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_order_day_info"
 * 
 */
public class OrderDayInfo extends BaseObject {

	
	 
	protected Long contractId;
	protected Long paymentId;
	protected Long orderId;
    protected Long orderDetailId;
    protected Integer publishDate;
    protected String adlength;
    protected Double dayStandardPrice;
    protected Double dayExecPrice;
    protected Double dayRelIncome;
    protected Double dayRelPuton;
    protected Integer adDayTimes;
    protected String resourceSpecific;
    protected Integer isPublished;
    protected Long customerId;	
    protected Long linkUserId;
    protected Integer needCal;
    protected Integer needPublish;
    protected Long parentId;
    protected Long compagesId;
    
    
    protected String startDate;
    protected String endDate;
    protected Double adSumTimes;
    protected Customer customer =new Customer(); 
    protected Carrier carrier = new Carrier();
    protected String businessFirstName;//业务员名称
    protected String businessLastName;//业务员名称
    protected String businessFullName;//业务员名称
    protected String toaccountTotal;//业务员名称
    protected Integer incomeDate;//到帐日期
    protected Integer resourceType;//到帐日期
    
    private Long orgId;
    protected String weekStr;
    
    
    
    protected String  rsModifyTime;     //时间戳
    protected String  rsSpecific;  //资源已指定信息
//    protected String  rsUsed;     //时间戳
        
    
    protected Long id;			  
    protected Integer version;
    protected String month[];
    protected String tatol[];
    protected DayInfo dayInfo = new DayInfo();
    
    List orderDayInfoIdList = new ArrayList();
    
//    public OrderDayInfo(){};
    
    public void reset(Integer publishDate){
      this.orderId = new Long("0");
      this.orderDetailId = new Long("0");
      this.publishDate = publishDate;
      this.adlength = "0";
      this.dayStandardPrice = new Double("0");
      this.dayRelIncome = new Double("0");
      this.dayRelPuton = new Double("0");
      this.adDayTimes = new Integer("0");
      this.resourceSpecific ="";
      this.isPublished = new Integer("0");
      this.linkUserId = new Long("0");
      this.needPublish = new Integer("0");
      this.version = new Integer("0");
//      this.dayInfo =  new DayInfo();
  };  


    /**
     * @hibernate.id column="order_day_info_id" generator-class="native" unsaved-value="null"
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     * Returns the orderDetailId
     * @return Long
     * 
     * @bak_hibernate.property length="20" column="order_detail_id" not-null="true"
     */
    public Long getOrderDetailId() {
        return orderDetailId;
    }
    /**
     * 
     * Returns the publishDate
     * @return Integer
     * 
     * @hibernate.property length="8" column="publish_date" not-null="true"
     */
    public Integer getPublishDate() {
        return publishDate;
    }

    /**
     * 
     * Returns the dayRelIncome
     * @return Double
     * 
     * @hibernate.property length="12" column="day_rel_income" not-null="true"
     */
    public Double getDayRelIncome() {
        return dayRelIncome;
    }
    
	/**
	 * 
	 * Returns the dayRelPuton
	 * @return Double 
	 * 
	 * @hibernate.property length="12" column="day_rel_puton" not-null="true"
	 */
	public Double getDayRelPuton() {
		return dayRelPuton;
	}




	
    /**
     * 
     * Returns the adDayTimes
     * @return Integer
     * 
     * @hibernate.property length="5" column="ad_day_times" not-null="true"
     */
    public Integer getAdDayTimes() {
        return adDayTimes;
    }

    
	/**
	 * 
	 * Returns the needPublish
	 * @return Integer 
	 * 
	 */
	public Integer getNeedPublish() {
		return needPublish;
	}

    /**
     * 
     * Returns the isPublished
     * @return Integer
     * 
     * @hibernate.property length="1" column="is_published" not-null="true"
     */
    public Integer getIsPublished() {
        return isPublished;
    }
    
    
    /**
     * @hibernate.version
     */
    public Integer getVersion() {
        return version;
    }
    
    /**
     * 
     * Returns the dayInfo
     * @return DayInfo
     * 
     */
    public DayInfo getDayInfo() {
        return dayInfo;
    } 
    
    /**
     * 
     * Returns the customerId
     * @return Long
     */
    public Long getCustomerId() {
        return customerId;
    }  
    
    /**
     * 
     * Returns the adlength
     * @return String
     */
    public String getAdlength() {
        return adlength;
    } 
    
    /**
     * 
     * Returns the resourceSpecific
     * @return String
     * 
     */
    public String getResourceSpecific() {
        return resourceSpecific;
    }
    /**
     * 
     * Returns the linkUserId 
     * @return Long
     * 
     */
	public Long getLinkUserId() {
		return linkUserId;
	}
	
    /**
     * 
     * Returns the dayStandardPrice
     * @return Double
     * 
     */
    public Double getDayStandardPrice() {
        return dayStandardPrice;
    }	
	
	
	
    
    
    /**
     * @param adDayTimes The adDayTimes to set.
     */
    public void setAdDayTimes(Integer adDayTimes) {
        this.adDayTimes = adDayTimes;
    }
    /**
     * @param adlength The adlength to set.
     */
    public void setAdlength(String adlength) {
        this.adlength = adlength;
    }
    
    /**
     * @param dayRelIncome The dayRelIncome to set.
     */
    public void setDayRelIncome(Double dayRelIncome) {
        this.dayRelIncome = dayRelIncome;
    }
    /**
     * @param dayStandardPrice The dayStandardPrice to set.
     */
    public void setDayStandardPrice(Double dayStandardPrice) {
        this.dayStandardPrice = dayStandardPrice;
    }
    /**
     * @param id The id to set.
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @param isPublished The isPublished to set.
     */
    public void setIsPublished(Integer isPublished) {
        this.isPublished = isPublished;
    }
    
    /**
     * @param orderDetailId The orderDetailId to set.
     */
    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    /**
     * @param publishDate The publishDate to set.
     */
    public void setPublishDate(Integer publishDate) {
        this.publishDate = publishDate;
    }
    /**
     * @param resourceSpecific The resourceSpecific to set.
     */
    public void setResourceSpecific(String resourceSpecific) {
        this.resourceSpecific = resourceSpecific;
    }

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}   
	
    /**
     * @param version The version to set.
     */
    public void setVersion(Integer version) {
        this.version = version;
    }	
    

    /**
     * @param dayInfo The dayInfo to set.
     */
    public void setDayInfo(DayInfo dayInfo) {
        this.dayInfo = dayInfo;
    }
    
	public void setLinkUserId(Long linkUserId) {
		this.linkUserId = linkUserId;
	}


    /**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof OrderDayInfo)) {
			return false;
		}
		OrderDayInfo rhs = (OrderDayInfo) object;
		return new EqualsBuilder().append(this.resourceSpecific,
				rhs.resourceSpecific).append(this.adDayTimes, rhs.adDayTimes)
				.append(this.publishDate, rhs.publishDate).append(
						this.orderDetailId, rhs.orderDetailId).append(
						this.adlength, rhs.adlength).append(
						this.dayStandardPrice, rhs.dayStandardPrice).append(
						this.dayRelIncome, rhs.dayRelIncome).append(this.id,
						rhs.id).append(this.customerId, rhs.customerId).append(
						this.version, rhs.version).append(this.isPublished,
						rhs.isPublished).append(this.dayInfo, rhs.dayInfo)
				.append(this.linkUserId, rhs.linkUserId).isEquals();
	}


	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-1790006219, 132054201).append(
				this.resourceSpecific).append(this.adDayTimes).append(
				this.publishDate).append(this.orderDetailId).append(
				this.adlength).append(this.dayStandardPrice).append(
				this.dayRelIncome).append(this.id).append(this.customerId)
				.append(this.version).append(this.isPublished).append(
						this.dayInfo).append(this.linkUserId).toHashCode();
	}


	/**
	 * 
	 * Returns the contractId
	 * @return Long 
	 * @hibernate.property length="20" column="contract_id" not-null="false"
	 */
	public Long getContractId() {
		return contractId;
	}


	/** 
	 * @param contractId The contractId to set.
	 */
	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}


	/**
	 * 
	 * Returns the orderId
	 * @return Long 
	 * 
	 */
	public Long getOrderId() {
		return orderId;
	}


	/** 
	 * @param orderId The orderId to set.
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}


	/**
	 * 
	 * Returns the paymentId
	 * @return Long 
	 * 
	 */
	public Long getPaymentId() {
		return paymentId;
	}


	/** 
	 * @param paymentId The paymentId to set.
	 */
	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}


	/** 
	 * @param dayRelPuton The dayRelPuton to set.
	 */
	public void setDayRelPuton(Double dayRelPuton) {
		this.dayRelPuton = dayRelPuton;
	}
	/**
	 * 
	 * Returns the needCal
	 * @return Integer 
	 */
	public Integer getNeedCal() {
		return needCal;
	}
	

	/** 
	 * @param orderCategorySub The orderCategorySub to set.
	 */
	public void setNeedCal(Integer needCal) {
		this.needCal = needCal;
	}


	/**
	 * 
	 * Returns the orderDayInfoIdList
	 * @return List 
	 * 
	 */
	public List getOrderDayInfoIdList() {
		return orderDayInfoIdList;
	}


	/** 
	 * @param orderDayInfoIdList The orderDayInfoIdList to set.
	 */
	public void setOrderDayInfoIdList(List orderDayInfoIdList) {
		this.orderDayInfoIdList = orderDayInfoIdList;
	}


	/**
	 * 
	 * Returns the parentId
	 * @return Long 
	 * 
	 */
	public Long getParentId() {
		return parentId;
	}


	/** 
	 * @param parentId The parentId to set.
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}




	/** 
	 * @param needPublish The needPublish to set.
	 */
	public void setNeedPublish(Integer needPublish) {
		this.needPublish = needPublish;
	}


	/**
	 * 
	 * Returns the compagesId
	 * @return Long 
	 * 
	 */
	public Long getCompagesId() {
		return compagesId;
	}


	/** 
	 * @param compagesId The compagesId to set.
	 */
	public void setCompagesId(Long compagesId) {
		this.compagesId = compagesId;
	}


	public Double getAdSumTimes() {
		return adSumTimes;
	}


	public void setAdSumTimes(Double adSumTimes) {
		this.adSumTimes = adSumTimes;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public String getBusinessFirstName() {
		return businessFirstName;
	}


	public void setBusinessFirstName(String businessFirstName) {
		this.businessFirstName = businessFirstName;
	}


	public String getBusinessFullName() {
		return businessFullName;
	}


	public void setBusinessFullName(String businessFullName) {
		this.businessFullName = businessFullName;
	}


	public String getBusinessLastName() {
		return businessLastName;
	}


	public void setBusinessLastName(String businessLastName) {
		this.businessLastName = businessLastName;
	}


	public String[] getMonth() {
		return month;
	}


	public void setMonth(String[] month) {
		this.month = month;
	}


	public Integer getIncomeDate() {
		return incomeDate;
	}


	public void setIncomeDate(Integer incomeDate) {
		this.incomeDate = incomeDate;
	}


	public String[] getTatol() {
		return tatol;
	}


	public void setTatol(String[] tatol) {
		this.tatol = tatol;
	}


	public String getToaccountTotal() {
		return toaccountTotal;
	}


	public void setToaccountTotal(String toaccountTotal) {
		this.toaccountTotal = toaccountTotal;
	}


	public Carrier getCarrier() {
		return carrier;
	}


	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}


	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("businessLastName",
				this.businessLastName).append("id", this.id).append(
				"resourceSpecific", this.resourceSpecific).append("month",
				this.month).append("adDayTimes", this.adDayTimes).append(
				"parentId", this.parentId).append("dayInfo", this.dayInfo)
				.append("toaccountTotal", this.toaccountTotal).append(
						"isPublished", this.isPublished).append("endDate",
						this.endDate).append("contractId", this.contractId)
				.append("dayRelPuton", this.dayRelPuton).append(
						"dayStandardPrice", this.dayStandardPrice).append(
						"startDate", this.startDate).append("paymentId",
						this.paymentId).append("needCal", this.needCal).append(
						"businessFirstName", this.businessFirstName).append(
						"customerId", this.customerId).append("adlength",
						this.adlength).append("publishDate", this.publishDate)
				.append("tatol", this.tatol).append("orderDayInfoIdList",
						this.orderDayInfoIdList).append("dayRelIncome",
						this.dayRelIncome).append("orderId", this.orderId)
				.append("compagesId", this.compagesId).append("customer",
						this.customer).append("version", this.version).append(
						"needPublish", this.needPublish).append("carrier",
						this.carrier).append("businessFullName",
						this.businessFullName).append("incomeDate",
						this.incomeDate).append("orderDetailId",
						this.orderDetailId).append("adSumTimes",
						this.adSumTimes).append("linkUserId", this.linkUserId)
				.toString();
	}


	public Integer getResourceType() {
		return resourceType;
	}


	public void setResourceType(Integer resourceType) {
		this.resourceType = resourceType;
	}


	public Long getOrgId() {
		return orgId;
	}


	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}


	public Double getDayExecPrice() {
		return dayExecPrice;
	}


	public void setDayExecPrice(Double dayExecPrice) {
		this.dayExecPrice = dayExecPrice;
	}


	public String getRsModifyTime() {
		return rsModifyTime;
	}


	public void setRsModifyTime(String rsModifyTime) {
		this.rsModifyTime = rsModifyTime;
	}


	public String getRsSpecific() {
		return rsSpecific;
	}


	public void setRsSpecific(String rsSpecific) {
		this.rsSpecific = rsSpecific;
	}


	public String getWeekStr() {
		return weekStr;
	}


	public void setWeekStr(String weekStr) {
		this.weekStr = weekStr;
	}
















}
