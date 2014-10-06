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

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
/**
 * OrderDetail class
 * 
 * This class is used to 
 * 
 * <p><a href="OrderDetail.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_order_detail"
 * 
 */
public class OrderDetail extends BaseObjectWithoutNestedFormValidation { 
	private static final long serialVersionUID = 4519897035754226790L;
	protected Long id;
	protected Long parentId;
    protected Long createBy;				 
    protected Date createDate;					//default timestamp  
    protected Long modifyBy;				  
    protected Date modifyDate;				  //default timestamp	  
    
    protected Long resourceSortId;	
    protected Long contractId;	
	protected Long paymentId;
    protected Long orderId;		
    protected String orderCategoryId;
    protected String carrierId;				
    protected Integer resourceType;
    protected Long resourceInfoId;			   // required
    protected Long  compagesId;
    protected Long  resourceSpecificId;
    protected Integer matteType;
    protected Long matterId;				   // required
    protected String matterLength;	
    protected Long industryTypeId;
    protected String publishMemo;
    protected Long resourcePriceType;
    
    protected Double sysPrice;
    protected Double execPrice;
    protected Double execPrice2;
    

    protected Double appRate;
    protected Double ageRate;
    protected Double favourRate;
    protected Double moneyBalance;
    protected Double moneyRealpay;

    protected String orderCategoryMain;
    protected Long isCkecked; 
    protected Integer sumTimes;
    protected Double moneyBase;
    protected Double moneyIn;
    protected Integer publishStartDate;
    protected Integer publishEndDate;
    protected Boolean isNotInSeries;
    protected Integer needPublish;
    
    protected Integer version;
    
    protected String memo;
    protected String carrierParentName;
    
    
    
    protected Boolean isSpaceAdver;
    
    protected Boolean isSaveOrderDayInfo;
    
    protected Boolean isLastDetail;
    protected Boolean isCompages;
    
    protected Integer isMonMoney;
     
    
    
    protected Set monthInfoMap = new HashSet();
    
    protected Resource resource = new Resource();
    protected Carrier carrier = new Carrier();
    protected Specific specific = new Specific();
    protected Matter matter = new Matter(); 
    protected Industry industry = new Industry();
    protected OrderCategory orderCategory = new OrderCategory();
    protected PriceType priceType = new PriceType();
    
    protected Set matters = new HashSet(); 
    protected OrderDayInfo[] orderDayInfos;
    protected OrderDayInfo[] orderDayInfosBak;
    protected OrderDetail[] orderDetails;
    protected Order order = new Order();

    protected OrderDetail orderDetailBak ;
    
    protected String specificValue;
    
    protected String loginUser ="";
    
    protected int orderDetailStates = 0;
    
    protected String orgId;
    protected String calculateauto;
    
    
    
    protected String tableModel; //0 ÊÇ¶©µ¥±à¼­  1¡¢»»°æ±¾
    
 
    protected OaWorkFlowCheckState orderState = new OaWorkFlowCheckState();
    
    protected String tempString; 
    
    protected String detailIds; 
    protected List detailIdsIdList; 
    
     
    
    protected String moidType; //1Í£²¥
    
    
    protected OrderPublic orderPublic = new OrderPublic();
//    protected CustomerProduct customerProduct = new CustomerProduct();
    
    protected Compages compages = new Compages();

	public OrderDetail(){};


    /**
     * @hibernate.id column="order_detail_id" generator-class="native" unsaved-value="null"
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
     * @hibernate.property column="create_date" update="true" insert="true" type="timestamp"
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
    * @hibernate.property column="modify_date" update="true" insert="true" type="timestamp"
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
     * Returns the orderId
     * @return Long
     * 
     * @BAK_hibernate.property length="20" column="order_id" not-null="true"
     */
    public Long getOrderId() {
        return orderId;
    }
    /**
     * 
     * Returns the orderCategoryId
     * @return String
     * 
     * @BAK_hibernate.property length="32" column="order_category_id" not-null="false"
     */
    public String getOrderCategoryId() {
        return orderCategoryId;
    }


    /**
     * 
     * Returns the resourceType
     * @return Integer
     * 
     * @hibernate.property length="2" column="ad_resource_type" not-null="false"
     */
    public Integer getResourceType() {
        return resourceType;
    }
    /**
     * Returns the resourceInfoId
     * @return Long
     * @struts.validator type="required"
     * @BAK_hibernate.property length="20" column="ad_resource_info_id" not-null="false"
     */
    public Long getResourceInfoId() {
        return resourceInfoId;
    }
    
  

    /**
     * 
     * Returns the resourceSpecificId
     * @return Long
     * 
     * @hibernate.property length="20" column="ad_resource_specific_id" not-null="false"
     */
    public Long getResourceSpecificId() {
        return resourceSpecificId;
    }
    /**
     * 
     * Returns the matteType
     * @return Integer
     * 
     * @hibernate.property length="2" column="adver_matter_type" not-null="false"
     */
    public Integer getMatteType() {
        return matteType;
    }
    /**
     * 
     * Returns the matterId
     * @return Long
     * @BAK_hibernate.property length="20" column="adver_matter_id" not-null="false"
     */
    public Long getMatterId() {
        return matterId;
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
     * Returns the industryTypeId
     * @return Long
     * 
     * @BAK_hibernate.property length="20" column="customer_industry_type_id" not-null="false"
     */
    public Long getIndustryTypeId() {
        return industryTypeId;
    }
    /**
     * 
     * Returns the publishMemo
     * @return String
     * 
     * @hibernate.property length="32" column="publish_memo" not-null="false"
     */
    public String getPublishMemo() {
        return publishMemo;
    }
    /**
     * 
     * Returns the resourcePriceType
     * @return Long
     * 
     * @BAK_hibernate.property length="128" column="ad_resource_price_type" not-null="true"
     */
    public Long getResourcePriceType() {
        return resourcePriceType;
    }
    /**
     * 
     * Returns the sysPrice
     * @return Double
     * 
     * @hibernate.property length="12" column="sys_price" not-null="true"
     */
    public Double getSysPrice() {
        return sysPrice;
    }
    /**
     * 
     * Returns the execPrice
     * @return Double
     * 
     * @hibernate.property length="12" column="exec_price" not-null="true"
     */
    public Double getExecPrice() {
        return execPrice;
    }
  

    /**
     * 
     * Returns the appRate
     * @return Double
     * 
     * @hibernate.property length="5" column="app_rate" not-null="true"
     */
    public Double getAppRate() {
        return appRate;
    }
    /**
     * 
     * Returns the favourRate
     * @return Double
     * 
     * @hibernate.property length="5" column="favour_rate" not-null="true"
     */
    public Double getFavourRate() {
        return favourRate;
    }
    /**
     * 
     * Returns the moneyBalance
     * @return Double
     * 
     * @hibernate.property length="12" column="money_balance" not-null="true"
     */
    public Double getMoneyBalance() {
        return moneyBalance;
    }
    /**
     * 
     * Returns the moneyRealpay
     * @return Double
     * 
     * @hibernate.property length="12" column="money_realpay" not-null="true"
     */
    public Double getMoneyRealpay() {
        return moneyRealpay;
    }

    
    /**
     * 
     * Returns the isCkecked
     * @return Integer
     * 
     * @hibernate.property length="128" column="is_ckecked" not-null="true"
     */
    public Long getIsCkecked() {
        return isCkecked;
    }
    
	/**
	 * 
	 * Returns the needPublish
	 * @return Integer 
	 * 
	 * @hibernate.property length="1" column="need_publish" not-null="true"
	 */
	public Integer getNeedPublish() {
		return needPublish;
	}   
    
	/**
	 * 
	 * Returns the parentId
	 * @return Long 
	 * 
	 * @hibernate.property length="128" column="parent_id" not-null="true"
	 */
	public Long getParentId() {
		return parentId;
	}
	/**
	 * 
	 * Returns the resourceSortId
	 * @return Long 
	 * 
	 * @hibernate.property length="128" column="resource_sort_id" not-null="false"
	 */
	public Long getResourceSortId() {
		return resourceSortId;
	}	
	
	/**
	 * 
	 * Returns the ageRate
	 * @return Double 
	 * 
	 * @hibernate.property length="5" column="age_rate" not-null="true"
	 */
	public Double getAgeRate() {
		return ageRate;
	}
	/**
	 * 
	 * Returns the compagesId
	 * @return Long 
	 * 
	 * @hibernate.property length="128" column="compages_id" not-null="false"
	 */
	public Long getCompagesId() {
		return compagesId;
	}		
	
	
	
	
	
	
    /**
     * 
     * Returns the moneyIn
     * @return Double
     * 
     */
    public Double getMoneyIn() {
        return moneyIn;
    }
    
    /**
     * 
     * Returns the sumTimes
     * @return Double
     * 
     */
    public Integer getSumTimes() {
        return sumTimes;
    }    
    /**
     * 
     * Returns the publishStartDate
     * @return Integer
     * 
     */
    public Integer getPublishStartDate() {
        return publishStartDate;
    }
    /**
     * 
     * Returns the publishEndDate
     * @return Integer
     * 

     */
    public Integer getPublishEndDate() {
        return publishEndDate;
    }
    /**
     * 
     * Returns the moneyBase
     * @return Double
     * 
     */
    public Double getMoneyBase() {
        return moneyBase;
    } 
    /**
     * 
     * Returns the carrierId
     * @return String
     * 
     */
    public String getCarrierId() {
        return carrierId;
    }
    /**
     * @hibernate.set name="orderDayInfos" table="tb_order_day_info" inverse="false" cascade="none" lazy="false"
     * @hibernate.collection-key column="order_detail_id"
     * @hibernate.collection-one-to-many class="com.vriche.adrm.model.OrderDayInfo" column="order_day_info_id"
     */
    public Set getMonthInfoMap() {
        return monthInfoMap;
    }
    
    

    /**
     * 
     * Returns the resource
     */
 
	/**
     * @hibernate.many-to-one name="resourceInfoId" column="ad_resource_info_id" cascade="all" not-null="true"
 	 */
	public Resource getResource() {
		return resource;
	}
    /**
     * 
     * Returns the resource
     */
 
	public Carrier getCarrier() {
		return carrier;
	}
	

	
	

    public Specific getSpecific() {
		return specific;
	}
 
	/**
     * @hibernate.many-to-one name="matterId" column="adver_matter_id" cascade="all" not-null="true"
 	 */
	public Matter getMatter() {
		return matter;
	}
	
	/**
     * @hibernate.many-to-one name="industryTypeId" column="customer_industry_type_id" cascade="all" not-null="true"
 	 */
	public Industry getIndustry() {
		return industry;
	}

  
	/** 
	 * 
    * @bak_hibernate.list  name="matters" table="tb_order_detail_matter" cascade="save-update" lazy="false"
    * @bak_hibernate.collection-key column="order_detail_id"
    * @bak_hibernate.collection-index column = "adver_matter_id" type="long" not-null="true"
    * @bak_hibernate.collection-element column = "startDate" type = "integer"  length="11" not-null="true"
    * @bak_hibernate.collection-element column = "endDate" type = "integer"  length="11" not-null="true"
	*/    

    public Set getMatters() {
		return matters;
	}
    
    
    
	/**
	 * 
	 * Returns the orderPublic
	 * @return OrderPublic 
	 * 
	 */
	public OrderPublic getOrderPublic() {
		return orderPublic;
	} 
    
	/**
	 * 
	 * Returns the orderCategoryMain
	 * @return String 
	 * 
	 */
	public String getOrderCategoryMain() {
		return orderCategoryMain;
	}
    
	/**
	 * 
	 * Returns the orderDayInfos
	 * @return OrderDayInfo[] 
	 * 
	 */
	public OrderDayInfo[] getOrderDayInfos() {
		return orderDayInfos;
	}  
    
	/**
	 * 
	 * Returns the memo
	 * @return String 
	 * 
	 * @hibernate.property length="128" column="memo" not-null="false"
	 */
	public String getMemo() {
		return memo;
	}

	

	/**
	 * 
	 * Returns the isSpaceAdver
	 * @return Boolean 
	 * 
	 * @hibernate.property  column="is_space_adver" not-null="false" type="yes_no"
	 */
	public Boolean getIsSpaceAdver() {
		return isSpaceAdver;
	}

	
	
	
	
	
	

	/** 
	 * @param isSpaceAdver The isSpaceAdver to set.
	 */
	public void setIsSpaceAdver(Boolean isSpaceAdver) {
		this.isSpaceAdver = isSpaceAdver;
	}
	
	
	
	


    /**
     * @param appRate The appRate to set.
     */
    public void setAppRate(Double appRate) {
        this.appRate = appRate;
    }
    /**
     * @param carrierId The carrierId to set.
     */
    public void setCarrierId(String carrierId) {
        this.carrierId = carrierId;
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
     * @param execPrice The execPrice to set.
     */
    public void setExecPrice(Double execPrice) {
        this.execPrice = execPrice;
    }
    /**
     * @param favourRate The favourRate to set.
     */
    public void setFavourRate(Double favourRate) {
        this.favourRate = favourRate;
    }
    /**
     * @param id The id to set.
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @param industryTypeId The industryTypeId to set.
     */
    public void setIndustryTypeId(Long industryTypeId) {
        this.industryTypeId = industryTypeId;
    }
    /**
     * @param isCkecked The isCkecked to set.
     */
    public void setIsCkecked(Long isCkecked) {
        this.isCkecked = isCkecked;
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
     * @param matteType The matteType to set.
     */
    public void setMatteType(Integer matteType) {
        this.matteType = matteType;
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
     * @param moneyBalance The moneyBalance to set.
     */
    public void setMoneyBalance(Double moneyBalance) {
        this.moneyBalance = moneyBalance;
    }
    /**
     * @param moneyIn The moneyIn to set.
     */
    public void setMoneyIn(Double moneyIn) {
        this.moneyIn = moneyIn;
    }
    /**
     * @param moneyRealpay The moneyRealpay to set.
     */
    public void setMoneyRealpay(Double moneyRealpay) {
        this.moneyRealpay = moneyRealpay;
    }
    /**
     * @param orderCategoryId The orderCategoryId to set.
     */
    public void setOrderCategoryId(String orderCategoryId) {
        this.orderCategoryId = orderCategoryId;
    }
    /**
     * @param orderId The orderId to set.
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    /**
     * @param publishMemo The publishMemo to set.
     */
    public void setPublishMemo(String publishMemo) {
        this.publishMemo = publishMemo;
    }
    /**
     * @param resourceInfoId The resourceInfoId to set.
     */
    public void setResourceInfoId(Long resourceInfoId) {
        this.resourceInfoId = resourceInfoId;
    }
    /**
     * @param resourcePriceType The resourcePriceType to set.
     */
    public void setResourcePriceType(Long resourcePriceType) {
        this.resourcePriceType = resourcePriceType;
    }
    /**
     * @param resourceSpecificId The resourceSpecificId to set.
     */
    public void setResourceSpecificId(Long resourceSpecificId) {
        this.resourceSpecificId = resourceSpecificId;
    }
    /**
     * @param resourceType The resourceType to set.
     */
    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
    }

    /**
     * @param moneyBase The moneyBase to set.
     */
    public void setMoneyBase(Double moneyBase) {
        this.moneyBase = moneyBase;
    }
    /**
     * @param sumTimes The sumTimes to set.
     */
    public void setSumTimes(Integer sumTimes) {
        this.sumTimes = sumTimes;
    }
    /**
     * @param sysPrice The sysPrice to set.
     */
    public void setSysPrice(Double sysPrice) {
        this.sysPrice = sysPrice;
    }

    /**
     * @param orderDayInfos The orderDayInfos to set.
     */
    public void setMonthInfoMap(Set monthInfoMap) {
        this.monthInfoMap = monthInfoMap;
    }
    
    /**
     * @param version The version to set.
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * @param publishEndDate The publishEndDate to set.
     */
    public void setPublishEndDate(Integer publishEndDate) {
        this.publishEndDate = publishEndDate;
    }
    /**
     * @param publishStartDate The publishStartDate to set.
     */
    public void setPublishStartDate(Integer publishStartDate) {
        this.publishStartDate = publishStartDate;
    }
    
    /**
     * @param isCkecked The isCkecked to set.
     */
    public void setCkecked(Long isCkecked) {
        this.isCkecked = isCkecked;
    }  
    


	/** 
	 * @param matter The matter to set.
	 */
	public void setMatter(Matter matter) {
		this.matter = matter;
	}


	public void setMatters(Set matter) {
		this.matters = matters;
	}
	
	
	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}
	public void setSpecific(Specific specific) {
		this.specific = specific;
	}


	/** 
	 * @param orderPublic The orderPublic to set.
	 */
	public void setOrderPublic(OrderPublic orderPublic) {
		this.orderPublic = orderPublic;
	}



	/** 
	 * @param orderCategoryMain The orderCategoryMain to set.
	 */
	public void setOrderCategoryMain(String orderCategoryMain) {
		this.orderCategoryMain = orderCategoryMain;
	}

	/**
	 * 
	 * Returns the contractId
	 * @return Long 
	 * 
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
	 * @param orderDayInfos The orderDayInfos to set.
	 */
	public void setOrderDayInfos(OrderDayInfo[] orderDayInfos) {
		this.orderDayInfos = orderDayInfos;
	}





	/** 
	 * @param ageRate The ageRate to set.
	 */
	public void setAgeRate(Double ageRate) {
		this.ageRate = ageRate;
	}


	/**
	 * 
	 * Returns the isNotInSeries
	 * @return Boolean 
	 * 
	 */
	public Boolean getIsNotInSeries() {
		return isNotInSeries;
	}


	/** 
	 * @param isNotInSeries The isNotInSeries to set.
	 */
	public void setIsNotInSeries(Boolean isNotInSeries) {
		this.isNotInSeries = isNotInSeries;
	}




	/** 
	 * @param compagesId The compagesId to set.
	 */
	public void setCompagesId(Long compagesId) {
		this.compagesId = compagesId;
	}


	/** 
	 * @param parentId The parentId to set.
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}




	/** 
	 * @param resourceSortId The resourceSortId to set.
	 */
	public void setResourceSortId(Long resourceSortId) {
		this.resourceSortId = resourceSortId;
	}


	/**
	 * 
	 * Returns the compages
	 * @return Compages 
	 * 
	 */
	public Compages getCompages() {
		return compages;
	}


	/** 
	 * @param compages The compages to set.
	 */
	public void setCompages(Compages compages) {
		this.compages = compages;
	}

	/** 
	 * @param needPublish The needPublish to set.
	 */
	public void setNeedPublish(Integer needPublish) {
		this.needPublish = needPublish;
	}



	/** 
	 * @param memo The memo to set.
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}

	/**
	 * @param industry The industry to set.
	 */
	public void setIndustry(Industry industry) {
		this.industry = industry;
	}





	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof OrderDetail)) {
			return false;
		}
		OrderDetail rhs = (OrderDetail) object;
		return new EqualsBuilder().append(this.ageRate, rhs.ageRate).append(this.isCkecked,
				rhs.isCkecked).append(this.isNotInSeries, rhs.isNotInSeries)
				.append(this.compagesId, rhs.compagesId).append(
						this.resourceInfoId, rhs.resourceInfoId).append(
						this.moneyBalance, rhs.moneyBalance).append(
						this.carrierId, rhs.carrierId).append(this.createBy, rhs.createBy)
				.append(this.id, rhs.id)
				.append(this.contractId, rhs.contractId).append(
						this.publishStartDate, rhs.publishStartDate).append(
						this.resourcePriceType, rhs.resourcePriceType).append(
						this.matterLength, rhs.matterLength).append(
						this.orderId, rhs.orderId).append(this.publishEndDate,
						rhs.publishEndDate).append(this.orderCategoryId,
						rhs.orderCategoryId)
				.append(this.sumTimes, rhs.sumTimes).append(this.execPrice,
						rhs.execPrice).append(this.resourceSpecificId,
						rhs.resourceSpecificId).append(this.moneyBase, rhs.moneyBase)
				.append(this.sysPrice, rhs.sysPrice).append(this.favourRate,
						rhs.favourRate).append(this.matter, rhs.matter).append(
						this.matterId, rhs.matterId).append(this.modifyBy,
						rhs.modifyBy).append(this.industryTypeId,
						rhs.industryTypeId).append(this.resource, rhs.resource)
				.append(this.moneyRealpay, rhs.moneyRealpay).append(
						this.version, rhs.version).append(this.moneyIn,
						rhs.moneyIn).append(this.publishMemo, rhs.publishMemo)
				.append(this.resourceType, rhs.resourceType).append(
						this.matters, rhs.matters).append(this.carrier,
						rhs.carrier).append(this.paymentId, rhs.paymentId)
				.append(this.modifyDate, rhs.modifyDate).append(
						this.createDate, rhs.createDate).append(this.appRate,
						rhs.appRate).append(this.matteType, rhs.matteType)
				.append(this.orderCategoryMain, rhs.orderCategoryMain)
				.isEquals();
	}


	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-2091949087, -641045543)
				.append(this.ageRate).append(this.orderPublic).append(
						this.isCkecked).append(this.isNotInSeries).append(
						this.compagesId).append(this.resourceInfoId).append(
						this.moneyBalance).append(this.carrierId).append(
						this.specific).append(this.createBy).append(this.id)
				.append(this.contractId).append(this.orderDayInfos).append(
						this.publishStartDate).append(this.resourcePriceType)
				.append(this.matterLength).append(this.orderId).append(
						this.publishEndDate).append(this.orderCategoryId)
				.append(this.sumTimes).append(this.execPrice).append(
						this.resourceSpecificId).append(this.monthInfoMap)
				.append(this.moneyBase).append(this.sysPrice).append(
						this.favourRate).append(this.matter).append(
						this.matterId).append(this.modifyBy).append(
						this.industryTypeId).append(this.resource).append(
						this.moneyRealpay).append(this.version).append(
						this.moneyIn).append(this.publishMemo).append(
						this.resourceType).append(this.matters).append(
						this.carrier).append(this.paymentId).append(
						this.modifyDate).append(this.createDate).append(
						this.appRate).append(this.matteType).append(
						this.orderCategoryMain).toHashCode();
	}


	/**
     * @hibernate.many-to-one name="orderCategoryId" column="order_category_id" cascade="all" not-null="true"
 	 */
	public OrderCategory getOrderCategory() {
		return orderCategory;
	}


	/**
	 * @param orderCategory The orderCategory to set.
	 */
	public void setOrderCategory(OrderCategory orderCategory) {
		this.orderCategory = orderCategory;
	}


	/**
     * @hibernate.many-to-one name="resourcePriceType" column="ad_resource_price_type" cascade="all" not-null="true"
 	 */
	public PriceType getPriceType() {
		return priceType;
	}


	/**
	 * @param priceType The priceType to set.
	 */
	public void setPriceType(PriceType priceType) {
		this.priceType = priceType;
	}


	/**
     * @hibernate.many-to-one name="orderId" column="order_id" cascade="all" not-null="true"
 	 */
	public Order getOrder() {
		return order;
	}


	/**
	 * @param order The order to set.
	 */
	public void setOrder(Order order) {
		this.order = order;
	}





	/**
	 * @return Returns the isSaveOrderDayInfo.
	 */
	public Boolean getIsSaveOrderDayInfo() {
		return isSaveOrderDayInfo;
	}


	/**
	 * @param isSaveOrderDayInfo The isSaveOrderDayInfo to set.
	 */
	public void setIsSaveOrderDayInfo(Boolean isSaveOrderDayInfo) {
		this.isSaveOrderDayInfo = isSaveOrderDayInfo;
	}


	/**
	 * @return Returns the orderDayInfosBak.
	 */
	public OrderDayInfo[] getOrderDayInfosBak() {
		return orderDayInfosBak;
	}


	/**
	 * @param orderDayInfosBak The orderDayInfosBak to set.
	 */
	public void setOrderDayInfosBak(OrderDayInfo[] orderDayInfosBak) {
		this.orderDayInfosBak = orderDayInfosBak;
	}


	public OrderDetail[] getOrderDetails() {
		return orderDetails;
	}


	public void setOrderDetails(OrderDetail[] orderDetails) {
		this.orderDetails = orderDetails;
	}


	public String getCarrierParentName() {
		return carrierParentName;
	}


	public void setCarrierParentName(String carrierParentName) {
		this.carrierParentName = carrierParentName;
	}


	public String getLoginUser() {
		return loginUser;
	}


	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}




	public int getOrderDetailStates() {
		return orderDetailStates;
	}


	public void setOrderDetailStates(int orderDetailStates) {
		this.orderDetailStates = orderDetailStates;
	}





	public void setOrderDetailBak(OrderDetail orderDetailBak) {
		this.orderDetailBak = orderDetailBak;
	}


	public OrderDetail getOrderDetailBak() {
		return orderDetailBak;
	}



	public Boolean getIsLastDetail() {
		return isLastDetail;
	}


	public void setIsLastDetail(Boolean isLastDetail) {
		this.isLastDetail = isLastDetail;
	}


	public Boolean getIsCompages() {
		return isCompages;
	}


	public void setIsCompages(Boolean isCompages) {
		this.isCompages = isCompages;
	}


	public String getOrgId() {
		return orgId;
	}


	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}


	public String getTableModel() {
		return tableModel;
	}


	public void setTableModel(String tableModel) {
		this.tableModel = tableModel;
	}


	public OaWorkFlowCheckState getOrderState() {
		return orderState;
	}


	public void setOrderState(OaWorkFlowCheckState orderState) {
		this.orderState = orderState;
	}


	public String getTempString() {
		return tempString;
	}


	public void setTempString(String tempString) {
		this.tempString = tempString;
	}


	public String getDetailIds() {
		return detailIds;
	}


	public void setDetailIds(String detailIds) {
		this.detailIds = detailIds;
	}


	public List getDetailIdsIdList() {
		return detailIdsIdList;
	}


	public void setDetailIdsIdList(List detailIdsIdList) {
		this.detailIdsIdList = detailIdsIdList;
	}


	public String getMoidType() {
		return moidType;
	}


	public void setMoidType(String moidType) {
		this.moidType = moidType;
	}


	public String getSpecificValue() {
		return specificValue;
	}


	public void setSpecificValue(String specificValue) {
		this.specificValue = specificValue;
	}


	public String getCalculateauto() {
		return calculateauto;
	}


	public void setCalculateauto(String calculateauto) {
		this.calculateauto = calculateauto;
	}


	public Double getExecPrice2() {
		return execPrice2;
	}


	public void setExecPrice2(Double execPrice2) {
		this.execPrice2 = execPrice2;
	}


	public Integer getIsMonMoney() {
		return isMonMoney;
	}


	public void setIsMonMoney(Integer isMonMoney) {
		this.isMonMoney = isMonMoney;
	}




	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this)
		.append("\n\r")
		.append("publishEndDate",this.publishEndDate).append("\n\r")
		.append("publishStartDate",this.publishStartDate).append("\n\r")
		.append("sumTimes",this.sumTimes).append("\n\r")
		.append("moneyRealpay", this.moneyRealpay).append("\n\r")
		.append("isSpaceAdver",this.isSpaceAdver).append("\n\r")
		.append("needPublish",this.needPublish).append("\n\r")
		.append("resourceSortId",this.resourceSortId).append("\n\r")
		.append("parentId",this.parentId).append("\n\r")		
		.append("ageRate", this.ageRate).append("\n\r")	
		.append("appRate", this.appRate).append("\n\r")
		.append("execPrice",this.execPrice).append("\n\r")
		
		.append("favourRate",this.favourRate).append("\n\r")
		.append("industryTypeId",this.industryTypeId).append("\n\r")
		.append("matterId",this.matterId).append("\n\r")
		.append("matterLength",this.matterLength).append("\n\r")
		
		.append("matteType",this.matteType).append("\n\r")
		.append("modifyBy",this.modifyBy).append("\n\r")
		.append("modifyDate",this.modifyDate).append("\n\r")
		.append("moneyBalance",this.moneyBalance).append("\n\r")
		.append("orderCategoryId",this.orderCategoryId).append("\n\r")
		
		.append("orderId",this.orderId).append("\n\r")
		.append("publishMemo",this.publishMemo).append("\n\r")
		.append("resourceInfoId",this.resourceInfoId).append("\n\r")
		.append("resourcePriceType",this.resourcePriceType).append("\n\r")
		.append("resourceSpecificId",this.resourceSpecificId).append("\n\r")
		
		.append("resourceType",this.resourceType).append("\n\r")
		.append("compagesId",this.compagesId).append("\n\r")
		.append("sysPrice",this.sysPrice).append("\n\r")
		.append("version",this.version).append("\n\r")
		.append("id",this.id).toString();
		
		
//		.append("orgId", this.orgId)
//		.append("isSaveOrderDayInfo", this.isSaveOrderDayInfo)
//		.append("moneyBase", this.moneyBase)
//		.append("carrierId", this.carrierId)
//		.append("modifyDate", this.modifyDate)
//		.append("matterLength", this.matterLength)
//		.append("resourceSpecificId", this.resourceSpecificId)
//		.append("specific", this.specific)
//		.append("createBy",this.createBy)
//						.append("orderDayInfos",
//						this.orderDayInfos)
//						.append("matter", this.matter)
//				.append("loginUser", this.loginUser)
//				
//						.append("contractId", this.contractId)
//				.append("priceType", this.priceType)
//			
//				.append("monthInfoMap", this.monthInfoMap)
//				.append("orderCategory", this.orderCategory)
//						.append("orderDayInfosBak", this.orderDayInfosBak)
//						
//						.append("isLastDetail",this.isLastDetail)
//				.append("isCompages", this.isCompages)
//				
//				.append("detailIds", this.detailIds)
//				.append("order", this.order)
//				.append("isCkecked", this.isCkecked)
//				.append("resource",this.resource)
//				.append("moneyBalance", this.moneyBalance)
//				.append("matteType",this.matteType)
//				
//				.append("tableModel", this.tableModel)
//				.append("carrier",this.carrier)
//				
//				.append("calculateauto", this.calculateauto)
//				.append("modifyBy",this.modifyBy)
//						.append("id", this.id)
//						.append("orderCategoryMain", this.orderCategoryMain)
//						.append("isNotInSeries", this.isNotInSeries)
//						.append("orderState", this.orderState)
//					
//						.append("publishMemo", this.publishMemo)
//				.append("carrierParentName", this.carrierParentName)
//				.append(
//						"orderDetails", this.orderDetails)
//						.append("resourceType", this.resourceType)
//						.append("matterId",this.matterId)
//						.append("memo", this.memo)
//						.append("isMonMoney", this.isMonMoney)
//						
//						.append("orderCategoryId",this.orderCategoryId)
//						.append("industryTypeId",this.industryTypeId)
//						
//						.append("industry", this.industry)
//				.append("paymentId", this.paymentId).append("execPrice2",
//						this.execPrice2).append("resourceInfoId",
//						this.resourceInfoId).append("detailIdsIdList",
//						this.detailIdsIdList).append("orderDetailBak",
//						this.orderDetailBak).append("resourcePriceType",
//						this.resourcePriceType).append("moneyIn", this.moneyIn)
//				.append("moidType", this.moidType).append("orderDetailStates",
//						this.orderDetailStates).append("orderId", this.orderId)
//				.append("favourRate", this.favourRate).append("compagesId",
//						this.compagesId).append("version", this.version)
//				.append("tempString", this.tempString).append("matters", this.matters)
//				.append("sysPrice", this.sysPrice).append("specificValue",
//						this.specificValue).append("compages", this.compages)
//				.append("createDate", this.createDate).toString();
	}










//	/**
//	 * 
//	 * Returns the customerProduct
//	 * @return CustomerProduct
//	 */
//	public CustomerProduct getCustomerProduct() {
//		return customerProduct;
//	}
//
//
//	/**
//	 * @param customerProduct The customerProduct to set.
//	 */
//	public void setCustomerProduct(CustomerProduct customerProduct) {
//		this.customerProduct = customerProduct;
//	}







	



}
