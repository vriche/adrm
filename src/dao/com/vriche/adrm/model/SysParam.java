package com.vriche.adrm.model;

import java.util.Date;

import com.vriche.adrm.Constants;

/**
 * SysParam class
 * 
 * This class is used to 
 * 
 * <p><a href="SysParam.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_sys_param"
 * 
 */
public class SysParam extends BaseObjectWithoutNestedFormValidation {
	
	private static final long serialVersionUID = 1L;
	protected Long id;
    protected String name;
    protected String value;
    protected String memo;   
    
    protected Long createBy;				  //default sysdate
    protected Date createDate;					  
    protected Long modifyBy;				  //default sysdate
    protected Date modifyDate;					  
    protected Integer version;
    
    
//  合同参数   
    protected String contractSortParam;
//订单浏览方式
    protected String orderViewModelParam;
	//分频道管理
    protected String channelModelParam;
    //广告编排方式
    protected String piblishModelParam;
    //串编接口类型
    protected String piblishExportModelParam;
    //串编号生成方式
    protected String adverCodeModelParam;
    //订单号生成方式  
    protected String orderCodeModelParam;
    //表单样式 
    protected String theme;  
    //广告载体类别的显示控制
    protected String orderCarrierTypeDisplayParam;
    
    //广告载体类别的显示控制
    protected String resourceDisplayParam;   
    //客户归属方式
    protected String customerOwnerParam;
    //  客户载体归属方式
    //protected String customerCarrierParam;
    //订单协约
    protected String orderContractParam;
    //载体级别
    protected String carrierNodeLevelParam;
    //垫片类型
    protected String dianpianParam;
    //跨段位调整
    protected String stridePositionParam;
//  在订单中添加客户
    protected String addCustomerInOrderParam;
//  有制定也允许调整
    protected String specArowMoveParam;
    //  频道划账
    protected String  channelPullParam; 
    
    //串编时是否显示没有广告的段位
    protected String  isDisplayNoadResParam;     
    
    //是否多频道
    protected String  moreChannelParam; 
    
    //多频道不划帐
    protected String  moreChannelNoPullParam; 
    
    
    //13令的时间限定
    protected String  resourceReLimitParam;    
    
    
    //审后订单，允许修改广告素材，但不能修改长度
    protected String  permitModAdverParam;    
    
    //  新添订单时，订单类别的默认值
    protected String  orderModCategoryParam; 
    
    //  是否开启订单日志
    protected String  isOpenOrderOrgParam; 
    
    //  是否显示图表按钮
    protected String  isDisplayChartParam;
    
    //	是否显示用户客户隶属
    protected String  isUserCustomerRelParam;
    
    //	如何显示欠款统计方式
    protected String  arrearageMode;
    
    //	如何编排串联单(按显示顺序(0),还是播出入点(1)排序)
    protected String  isArrangeOrderOrEntry;
    
    //福州电视台特殊功能参数(若是福州台则设置为1,其他设置为0);系统参数默认是0;
    protected String  fztvSpecialParam;
    
    //泉州电视台特殊功能参数(若是泉州台则设置为1,其他设置为0);系统参数默认是0;
    protected String  qztvSpecialParam;
    
    
    //是否启用套装参数(启用1,不启用0)系统参数默认是0;
    protected String  signCompages;
    
    //是否启用播出入点(启用1,不启用0)系统参数默认是0;
    protected String  withBroPoint;
    
    //是否启用广告资源分类(启用1,不启用0)系统参数默认是0
    protected  String withResourceSort;
    
    
    //电视台特殊功能参数(若有指定特定电视台则设置为catv,sjztv,hntv,fztv,qztv,xmtv,其他设置为0);系统参数默认是0;
    protected String  tvNameParam;    
    
    
    //订单不予提交，就能审核(需要提交(0),不提交(1))
    protected String  withoutSubmit;
    
    // 到款提示，相关的业务员(如果财务录入一笔到款或修改一别到款，则提示相关的业务员) 0为默认不提示，1表示需要提示
    protected String  incomeMessageAlertParam;
    
    protected String  sequenceIncomeAutoParam;
    //是否由业务员平帐(0-否 1-是)  
    protected String  isSignUserBalance;
    
    //订单是否启用年份归属(0-否 1-是)   
    protected String  isUserOrderYearRel;
    
   //建立串联单前，需要提示的订单状态、默认1(1未审批、2审核中、3通过、4被退回、5未通过)
    protected String  publishOrderAlertStates;
    
//  是否试用频道属性(0-否 1-是) 如 地面频道、卫星频道的分类方法  
    protected String  isUseCarrierProty;
//  统计中是否显示刊例金额列
    protected String  isDisplayStandPrice;
    
    //订单中载体级别(默认0是维护时默认的级别数；1为表示只取一级)
    protected String  orderCarrierLevelParam;
    
    //订单中订单明细显示分页或不分页(默认0默认分页；1为表示不分)
    protected String  orderDetailDisplayParam;
    
    //统计分析中是否启用频道别名(默认0,1启用)
    protected String  useCarrierAliname;

    //统计分析中是否启用频道别名(默认0,1启用)
    protected String  useMoreCarrierSortParam;

//  是否启用客户类别过滤
    protected String  customerCateFiter;
    
//  行业级别 
    protected String  industryLevelParam;  
    
//  是否启用自动联系号
    protected String  autoRelationCodeParam;     
    
//  默认价格类别
    protected String  autoPriceTypeParam;     
    
    
	 
	 //是否独立使用栏目
    protected String  useLanmuSingleParam;     

	 //是否独立使用栏目
    protected String  allowModiyPassedOrderParam;     
    
//    广告发布合同模板类型 默认 0 最后每页有落款，1 只有最后一页有落款
    protected String  orderPublishTempleParam;    
    
//  是否显示关联编号，0不显示，1显示，默认0
    protected String  orderDisplayRelcodeParam;  
    
    //是否开启订单类别过滤，true|56,22|88
    protected String  financialAuditParam;  
    
//  是否显示关联编号，0不显示，1显示，默认0
    protected String  orderDisplayIncomeParam;     
    
    
	 //一个集团下多个分支机构，但广告资源共享，0不显示，1显示，默认0
    protected String  oneOrgMoreSuborgsParam;     
    
    
	 //财务平帐方式，0不显示，1显示，默认0
   protected String  financeBalanceModelParam;     
   
	 //快速下单，0否，1是
   protected String  fastSignOrderParam; 
   
   //订单应收计算模式，0 应收=折后价格*次数*折扣*（1+加收率）+补差, 1 应收=销售价格*次数*折扣*（1+加收率）+补差
   protected String  orderCalculateModel; 
   
	 //是否启用大洋的备播系统对接 0 否  1 是
   protected String  dayangBeiboEnableParam; 
   
   
   //大洋的备播系统  webservice ImportMaterialService url  "http://10.77.82.91:8892/ADPINF/services/ImportMaterialService";
   protected String  dayangWebServiceUrlMatterParam; 
   
   //	大洋的备播系统  webservice ImportProgramListService url  "http://10.77.82.91:8892/ADPINF/services/ImportProgramListService";
   protected String  dayangWebServiceUrlProLitstParam; 
   
   
// 系统启用的年份
   protected String  adrmSysYearProgramList; 
   
// 订单刊例价格是否可以修改
   protected String  orderBasePriceEnableModyParam; 
   
// 广告编排是否显示品牌
   protected String  arrangeWithBrandParam;    
   
   
// 新签订单广告排期默认月份,默认当前月份+2
   protected String  orderArrangDefaultMonths;    
   
   // 出串联单限制排期的修改
   protected String  outLimitBroarrang;
   // 使用客户广告投放的时间比率
   protected String resourceUseCustomerCatelog;
   
   
	//公益广告自动添加
   protected String publicAdAutoFill;

//ftp服务器
   protected String ftpConfig;
   
   
 //时段维护根据时间排序
   protected String resconfigOrderbyTime;

   

public String getResconfigOrderbyTime() {
	return resconfigOrderbyTime;
}
public void setResconfigOrderbyTime(String resconfigOrderbyTime) {
	this.resconfigOrderbyTime = resconfigOrderbyTime;
}
/**
 * @param resourceUseCustomerCatelog the resourceUseCustomerCatelog to set
 */
public void setResourceUseCustomerCatelog(String resourceUseCustomerCatelog) {
	this.resourceUseCustomerCatelog = resourceUseCustomerCatelog;
}
	public String getChannelPullParam() {
		return channelPullParam;
	}
	public void setChannelPullParam(String channelPullParam) {
		this.channelPullParam = channelPullParam;
	}
	public String getCarrierNodeLevelParam() {
		return carrierNodeLevelParam;
	}
	public void setCarrierNodeLevelParam(String carrierNodeLevelParam) {
		this.carrierNodeLevelParam = carrierNodeLevelParam;
	}
	/**
     * @hibernate.id column="id" generator-class="native" unsaved-value="null"
     */
    public Long getId() {
        return id;
    }
    /**
     * 
     * Returns the name
     * @return String
     * @struts.validator type="required"
     * @hibernate.property column="name" length="128" not-null="true"
     */
    public String getName() {
        return name;
    }
    
    /**
     * 
     * Returns the memo
     * @return String
     * 
     * @hibernate.property length="256" column="memo" not-null="false"
     */
    public String getMemo() {
        return memo;
    }
    
    /**
     * 
     * Returns the value
     * @return String
     * @struts.validator type="required"
     * @hibernate.property length="128" column="value" not-null="true"
     */
    public String getValue() {
        return value;
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
	 * @param id The id to set.
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/** 
	 * @param memo The memo to set.
	 */
	public void setMemo(String memo) {
		this.memo = memo;
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
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/** 
	 * @param value The value to set.
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/** 
	 * @param version The version to set.
	 */
	public void setVersion(Integer version) {
		this.version = version;
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
	
	
	
	
	
	public String getAdverCodeModelParam() {
		return adverCodeModelParam;
	}
	public void setAdverCodeModelParam(String adverCodeModelParam) {
		this.adverCodeModelParam = adverCodeModelParam;
	}
	public String getChannelModelParam() {
		return channelModelParam;
	}
	public void setChannelModelParam(String channelModelParam) {
		this.channelModelParam = channelModelParam;
	}
	public String getContractSortParam() {
		return contractSortParam;
	}
	public void setContractSortParam(String contractSortParam) {
		this.contractSortParam = contractSortParam;
	}
	public String getOrderCodeModelParam() {
		return orderCodeModelParam;
	}
	public void setOrderCodeModelParam(String orderCodeModelParam) {
		this.orderCodeModelParam = orderCodeModelParam;
	}
	public String getOrderViewModelParam() {
		return orderViewModelParam;
	}
	public void setOrderViewModelParam(String orderViewModelParam) {
		this.orderViewModelParam = orderViewModelParam;
	}
	public String getPiblishExportModelParam() {
		return piblishExportModelParam;
	}
	public void setPiblishExportModelParam(String piblishExportModelParam) {
		this.piblishExportModelParam = piblishExportModelParam;
	}
	public String getPiblishModelParam() {
		return piblishModelParam;
	}
	public void setPiblishModelParam(String piblishModelParam) {
		this.piblishModelParam = piblishModelParam;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getOrderCarrierTypeDisplayParam() {
		return orderCarrierTypeDisplayParam;
	}
	public void setOrderCarrierTypeDisplayParam(String orderCarrierTypeDisplayParam) {
		this.orderCarrierTypeDisplayParam = orderCarrierTypeDisplayParam;
	}
	public String getCustomerOwnerParam() {
		return customerOwnerParam;
	}
	public void setCustomerOwnerParam(String customerOwner) {
		this.customerOwnerParam = customerOwner;
	}
//	public String getCustomerCarrierParam() {
//		return customerCarrierParam;
//	}
//	public void setCustomerCarrierParam(String customerCarrier) {
//		this.customerCarrierParam = customerCarrier;
//	}
	public String getOrderContractParam() {
		return orderContractParam;
	}
	public void setOrderContractParam(String orderContractParam) {
		this.orderContractParam = orderContractParam;
	}
	public String getDianpianParam() {
		return dianpianParam;
	}
	public void setDianpianParam(String dianpianParam) {
		this.dianpianParam = dianpianParam;
	}
	public String getStridePositionParam() {
		return stridePositionParam;
	}
	public void setStridePositionParam(String stridePositionParam) {
		this.stridePositionParam = stridePositionParam;
	}
	/**
	 * @return Returns the addCustomerInOrderParam.
	 */
	public String getAddCustomerInOrderParam() {
		return addCustomerInOrderParam;
	}
	/**
	 * @param addCustomerInOrderParam The addCustomerInOrderParam to set.
	 */
	public void setAddCustomerInOrderParam(String addCustomerInOrderParam) {
		this.addCustomerInOrderParam = addCustomerInOrderParam;
	}
	public String getResourceDisplayParam() {
		return resourceDisplayParam;
	}
	public void setResourceDisplayParam(String resourceDisplayParam) {
		this.resourceDisplayParam = resourceDisplayParam;
	}
	public String getSpecArowMoveParam() {
		return specArowMoveParam;
	}
	public void setSpecArowMoveParam(String specArowMoveParam) {
		this.specArowMoveParam = specArowMoveParam;
	}
	/**
	 * @return Returns the isDisplayNoadResParam.
	 */
	public String getIsDisplayNoadResParam() {
		return isDisplayNoadResParam;
	}
	/**
	 * @param isDisplayNoadResParam The isDisplayNoadResParam to set.
	 */
	public void setIsDisplayNoadResParam(String isDisplayNoadResParam) {
		this.isDisplayNoadResParam = isDisplayNoadResParam;
	}
	public String getMoreChannelParam() {
		return moreChannelParam;
	}
	public void setMoreChannelParam(String moreChannelParam) {
		this.moreChannelParam = moreChannelParam;
	}
	/**
	 * @return Returns the moreChannelNoPullParam.
	 */
	public String getMoreChannelNoPullParam() {
		return moreChannelNoPullParam;
	}
	/**
	 * @param moreChannelNoPullParam The moreChannelNoPullParam to set.
	 */
	public void setMoreChannelNoPullParam(String moreChannelNoPullParam) {
		this.moreChannelNoPullParam = moreChannelNoPullParam;
	}
	/**
	 * @return Returns the resourceReLimitParam.
	 */
	public String getResourceReLimitParam() {
		return resourceReLimitParam;
	}
	/**
	 * @param resourceReLimitParam The resourceReLimitParam to set.
	 */
	public void setResourceReLimitParam(String resourceReLimitParam) {
		this.resourceReLimitParam = resourceReLimitParam;
	}
	/**
	 * @return Returns the permitModAdverParam.
	 */
	public String getPermitModAdverParam() {
		return permitModAdverParam;
	}
	/**
	 * @param permitModAdverParam The permitModAdverParam to set.
	 */
	public void setPermitModAdverParam(String permitModAdverParam) {
		this.permitModAdverParam = permitModAdverParam;
	}
	
	public String getOrderModCategoryParam() {
		return orderModCategoryParam;
	}
	public void setOrderModCategoryParam(String orderModCategoryParam) {
		this.orderModCategoryParam = orderModCategoryParam;
	}
	public String getIsOpenOrderOrgParam() {
		return isOpenOrderOrgParam;
	}
	public void setIsOpenOrderOrgParam(String isOpenOrderOrgParam) {
		this.isOpenOrderOrgParam = isOpenOrderOrgParam;
	}
	public String getIsDisplayChartParam() {
		return isDisplayChartParam;
	}
	public void setIsDisplayChartParam(String isDisplayChartParam) {
		this.isDisplayChartParam = isDisplayChartParam;
	}
	public String getIsUserCustomerRelParam() {
		return isUserCustomerRelParam;
	}
	public void setIsUserCustomerRelParam(String isUserCustomerRelParam) {
		this.isUserCustomerRelParam = isUserCustomerRelParam;
	}
	public String getArrearageMode() {
		return arrearageMode;
	}
	public void setArrearageMode(String arrearageMode) {
		this.arrearageMode = arrearageMode;
	}
	public String getIsArrangeOrderOrEntry() {
		return isArrangeOrderOrEntry;
	}
	public void setIsArrangeOrderOrEntry(String isArrangeOrderOrEntry) {
		this.isArrangeOrderOrEntry = isArrangeOrderOrEntry;
	}
	/**
	 * @return Returns the fztvSpecialParam.
	 */
	public String getFztvSpecialParam() {
		return fztvSpecialParam;
	}
	/**
	 * @param fztvSpecialParam The fztvSpecialParam to set.
	 */
	public void setFztvSpecialParam(String fztvSpecialParam) {
		this.fztvSpecialParam = fztvSpecialParam;
	}
	
	public String getQztvSpecialParam() {
		return qztvSpecialParam;
	}
	public void setQztvSpecialParam(String qztvSpecialParam) {
		this.qztvSpecialParam = qztvSpecialParam;
	}
	
	
	public String getIncomeMessageAlertParam() {
		return incomeMessageAlertParam;
	}
	public void setIncomeMessageAlertParam(String incomeMessageAlertParam) {
		this.incomeMessageAlertParam = incomeMessageAlertParam;
	}
	
	public String getSequenceIncomeAutoParam() {
		return sequenceIncomeAutoParam;
	}
	public void setSequenceIncomeAutoParam(String sequenceIncomeAutoParam) {
		this.sequenceIncomeAutoParam = sequenceIncomeAutoParam;
	}
	public String getIsSignUserBalance() {
		return isSignUserBalance;
	}
	public void setIsSignUserBalance(String isSignUserBalance) {
		this.isSignUserBalance = isSignUserBalance;
	}

	public String getIsUserOrderYearRel() {
		return isUserOrderYearRel;
	}
	public void setIsUserOrderYearRel(String isUserOrderYearRel) {
		this.isUserOrderYearRel = isUserOrderYearRel;
	}

	/**
	 * @return Returns the isUseCarrierProty.
	 */
	public String getIsUseCarrierProty() {
		return isUseCarrierProty;
	}
	/**
	 * @param isUseCarrierProty The isUseCarrierProty to set.
	 */
	public void setIsUseCarrierProty(String isUseCarrierProty) {
		this.isUseCarrierProty = isUseCarrierProty;
	}

	/**
	 * @return Returns the publishOrderAlertStates.
	 */
	public String getPublishOrderAlertStates() {
		return publishOrderAlertStates;
	}
	/**
	 * @param publishOrderAlertStates The publishOrderAlertStates to set.
	 */
	public void setPublishOrderAlertStates(String publishOrderAlertStates) {
		this.publishOrderAlertStates = publishOrderAlertStates;
	}
	
	
	/**
	 * @return Returns the isDisplayStandPrice.
	 */
	public String getIsDisplayStandPrice() {
		return isDisplayStandPrice;
	}
	/**
	 * @param isDisplayStandPrice The isDisplayStandPrice to set.
	 */
	public void setIsDisplayStandPrice(String isDisplayStandPrice) {
		this.isDisplayStandPrice = isDisplayStandPrice;
	}

	
	public String getWithoutSubmit() {
		return withoutSubmit;
	}
	public void setWithoutSubmit(String withoutSubmit) {
		this.withoutSubmit = withoutSubmit;
	}
	public String getSignCompages() {
		return signCompages;
	}
	public void setSignCompages(String signCompages) {
		this.signCompages = signCompages;
	}

	public String getTvNameParam() {
		return tvNameParam;
	}
	public void setTvNameParam(String tvNameParam) {
		this.tvNameParam = tvNameParam;
	}
	
	public String getWithBroPoint() {
		return withBroPoint;
	}
	public void setWithBroPoint(String withBroPoint) {
		this.withBroPoint = withBroPoint;
	}
	public String getWithResourceSort() {
		return withResourceSort;
	}
	public void setWithResourceSort(String withResourceSort) {
		this.withResourceSort = withResourceSort;
	}

	public String getOrderCarrierLevelParam() {
		return orderCarrierLevelParam;
	}
	public void setOrderCarrierLevelParam(String orderCarrierLevelParam) {
		this.orderCarrierLevelParam = orderCarrierLevelParam;
	}
	public String getOrderDetailDisplayParam() {
		return orderDetailDisplayParam;
	}
	public void setOrderDetailDisplayParam(String orderDetailDisplayParam) {
		this.orderDetailDisplayParam = orderDetailDisplayParam;
	}
	public String getUseCarrierAliname() {
		return useCarrierAliname;
	}
	public void setUseCarrierAliname(String useCarrierAliname) {
		this.useCarrierAliname = useCarrierAliname;
	}

	public String getUseMoreCarrierSortParam() {
		return useMoreCarrierSortParam;
	}
	public void setUseMoreCarrierSortParam(String useMoreCarrierSortParam) {
		this.useMoreCarrierSortParam = useMoreCarrierSortParam;
	}
	public String getCustomerCateFiter() {
		return customerCateFiter;
	}
	public void setCustomerCateFiter(String customerCateFiter) {
		this.customerCateFiter = customerCateFiter;
	}
	public String getIndustryLevelParam() {
		return industryLevelParam;
	}
	public void setIndustryLevelParam(String industryLevelParam) {
		this.industryLevelParam = industryLevelParam;
	}
	public String getAutoRelationCodeParam() {
		return autoRelationCodeParam;
	}
	public void setAutoRelationCodeParam(String autoRelationCodeParam) {
		this.autoRelationCodeParam = autoRelationCodeParam;
	}
	public String getAutoPriceTypeParam() {
		return autoPriceTypeParam;
	}
	public void setAutoPriceTypeParam(String autoPriceTypeParam) {
		this.autoPriceTypeParam = autoPriceTypeParam;
	}

	public String getUseLanmuSingleParam() {
		return useLanmuSingleParam;
	}
	public void setUseLanmuSingleParam(String useLanmuSingleParam) {
		this.useLanmuSingleParam = useLanmuSingleParam;
	}
	public String getAllowModiyPassedOrderParam() {
		return allowModiyPassedOrderParam;
	}
	public void setAllowModiyPassedOrderParam(String allowModiyPassedOrderParam) {
		this.allowModiyPassedOrderParam = allowModiyPassedOrderParam;
	}
	public String getOrderPublishTempleParam() {
		return orderPublishTempleParam;
	}
	public void setOrderPublishTempleParam(String orderPublishTempleParam) {
		this.orderPublishTempleParam = orderPublishTempleParam;
	}
	public String getOrderDisplayRelcodeParam() {
		return orderDisplayRelcodeParam;
	}
	public void setOrderDisplayRelcodeParam(String orderDisplayRelcodeParam) {
		this.orderDisplayRelcodeParam = orderDisplayRelcodeParam;
	}
	public String getFinancialAuditParam() {
		return financialAuditParam;
	}
	public void setFinancialAuditParam(String financialAuditParam) {
		this.financialAuditParam = financialAuditParam;
	}
	public String getOrderDisplayIncomeParam() {
		return orderDisplayIncomeParam;
	}
	public void setOrderDisplayIncomeParam(String orderDisplayIncomeParam) {
		this.orderDisplayIncomeParam = orderDisplayIncomeParam;
	}
	public String getOneOrgMoreSuborgsParam() {
		return oneOrgMoreSuborgsParam;
	}
	public void setOneOrgMoreSuborgsParam(String oneOrgMoreSuborgsParam) {
		this.oneOrgMoreSuborgsParam = oneOrgMoreSuborgsParam;
	}
	public String getFinanceBalanceModelParam() {
		return financeBalanceModelParam;
	}
	public void setFinanceBalanceModelParam(String financeBalanceModelParam) {
		this.financeBalanceModelParam = financeBalanceModelParam;
	}
	public String getFastSignOrderParam() {
		return fastSignOrderParam;
	}
	public void setFastSignOrderParam(String fastSignOrderParam) {
		this.fastSignOrderParam = fastSignOrderParam;
	}
	public String getOrderCalculateModel() {
		return orderCalculateModel;
	}
	public void setOrderCalculateModel(String orderCalculateModel) {
		this.orderCalculateModel = orderCalculateModel;
	}
	public String getDayangBeiboEnableParam() {
		return dayangBeiboEnableParam;
	}
	public void setDayangBeiboEnableParam(String dayangBeiboEnableParam) {
		this.dayangBeiboEnableParam = dayangBeiboEnableParam;
	}
	
	public String getArrangeWithBrandParam() {
		return arrangeWithBrandParam;
	}

	public void setArrangeWithBrandParam(String arrangeWithBrandParam) {
		this.arrangeWithBrandParam = arrangeWithBrandParam;
	}

	public String getMenoByName(String name){
		
		String meno = name;
		
		if(name.equals(Constants.CSS_THEME)){
			meno = "表单样式";
		}else if(name.equals(Constants.CONTRACT_SORT_PARAM)){
			meno = "合同参数（0根据付款分配应收 1正常）";
		}else if(name.equals(Constants.ORDER_VIEW_MODEL_PARAM)){
			meno = "订单浏览方式（0不限制1根据用户归属）";
		}else if(name.equals(Constants.CHANNEL_MODEL_PARAM)){
			meno = "分频道管理（0不分1分）(应用广泛,0能看到所有频道,1可以设定权限看到指定频道)";
		}else if(name.equals(Constants.PUBLISH_MODEL_PARAM)){
			meno = "广告编排方式（1串编1 2串编2）";
		}else if(name.equals(Constants.PUBLISH_EXPORT_MODEL_PARAM)){
			meno = "串编文件接口类型 （1按载体第二级保存成文件、2按时段保存成文件）";
		}else if(name.equals(Constants.ADVER_CODE_MODEL_PARAM)){
			meno = "串编号生成方式（0手动1自动）";
		}else if(name.equals(Constants.ORDER_CODE_MODEL_PARAM)){
			meno = "合同号生成方式";
		}else if(name.equals(Constants.ORDER_CARRIER_TYPE_DISPLAY_PARAM)){
			meno = "广告载体类别的显示控制(0不显示1显示默认1显示)";
		}else if(name.equals(Constants.RESOURCE_DISPLAY_PARAM)){
			meno = "广告段位显示名称或备注";
		}else if(name.equals(Constants.CHANNEL_PULL_PARAM)){
			meno = "频道划账(与moreChannelNoPullParam在到款入录页面配合使用,配合方式为(1,0),(1,1),(0,0))";
		}else if(name.equals(Constants.CUSTOMER_OWNER_PARAM)){
			meno = "客户归属方式";
		}else if(name.equals(Constants.ORDER_CONTRACT_PARAM)){
			meno = "订单协约";
		}else if(name.equals(Constants.CARRIER_NODELEVEL_PARAM)){
			meno = "载体级别";
		}else if(name.equals(Constants.DIAN_PIAN_PARAM)){
			meno = "垫片类型";
		}else if(name.equals(Constants.STRIDE_POSITION_PARAM)){
			meno = "广告编排时是否允许跨段位调整";
		}else if(name.equals(Constants.ADD_CUSTOMER_IN_ORDER_PARAM)){
			meno = "在订单中添加客户";
		}else if(name.equals(Constants.SPEC_AROWMOVE_PARAM)){
			meno = "有指定也允许调整";
		}else if(name.equals(Constants.IS_DISPLAYNOADRES_PARAM)){
			meno = "串编时是否显示没有广告的段位";
		}else if(name.equals(Constants.MORE_CHANNEL_NOPULL_PARAM)){
			meno = "多频道不划帐(与channelPullParam在到款入录页面配合使用,上面分别是：手动划账到各个频道(多频道统一)、自动划账到各个频道(多频道独立)、不分频道划账(单频道))";
		}else if(name.equals(Constants.MORE_CHANNEL_PARAM)){
			meno = "是否多频道(主要用于在单据中是否显示频道名称,1显示,0不显示,暂时只用于后台(2010/05/21))";
		}else if(name.equals(Constants.RESOURCE_RELIMIT_PARAM)){
			meno = "13令的时间限定";
		}else if(name.equals(Constants.PERMIT_MOD_ADVER_PARAM)){
			meno = "审后订单允许修改广告素材长度除外";	
		}else if(name.equals(Constants.ORDER_MOD_CATEGORY_PARAM)){
			meno = "新签订单默认的订单类别的设定";
		}else if(name.equals(Constants.IS_OPEN_ORDER_ORG_PARAM)){
			meno = "是否开启订单日志";
		}else if(name.equals(Constants.IS_DISPLAY_CHART_PARAM)){
			meno = "是否显示图表按钮（1显示）";
		}else if(name.equals(Constants.IS_USER_CUSTOMER_REL_PARAM)){
			meno = "是否显示用户客户隶属关系及客户载体隶属关系按钮（0可能不显示1显示）";
		}else if(name.equals(Constants.ARREARAGE_MODE)){
			meno = "欠款统计方式(0{投放-分配},1{投放-到帐})";	
		}else if(name.equals(Constants.IS_ARRANGE_ORDER_OR_ENTRY)){
			meno = "如何编排串联单(按显示顺序(0),还是播出入点(1)排序)";	
		}else if(name.equals(Constants.FZTV_SPECIAL_PARAM)){
			meno = "福州电视台特殊功能参数(若是福州台则设置为1,其他设置为0);因为系统参数默认是0";	
		}else if(name.equals(Constants.QZTV_SPECIAL_PARAM)){
			meno = "泉州电视台特殊功能参数(若是泉州台则设置为1,其他设置为0);因为系统参数默认是0";	
		}else if(name.equals(Constants.TV_NAME_PARAM)){
			meno = "电视台特殊功能参数(若有指定特定电视台则设置为catv其他设置为0);系统参数默认是0;";	
		}else if(name.equals(Constants.WITHOUT_SUBMIT)){
			meno = "订单不予提交，就能审核(需要提交(0),不提交(1))";	
		}else if(name.equals(Constants.INCOME_MESSAGE_ALERT_PARAM)){
			meno = "到款提示，相关的业务员(如果财务录入一笔到款或修改一别到款，则提示相关的业务员) 格式（1,192.168.1.100,5222,domain.com,longin,PWD）";	
		}else if(name.equals(Constants.INCOME_CODE_MODEL_PARAM)){
			meno = "到款编号自动产生(0-手动，1-自动)";	
		}else if(name.equals(Constants.IS_SIGN_USER_BALANCE)){
			meno = "是否由业务员平帐(0-否 1-是)";	
		}else if(name.equals(Constants.IS_USER_ORDER_YEAR_REL)){
			meno = "订单是否启用年份归属(0-否 1-是)";	
		}else if(name.equals(Constants.IS_USE_CARRIER_PROTY)){
			meno = "是否试用频道属性(0-否 1-是) 如 地面频道、卫星频道的分类方法";	
		}else if(name.equals(Constants.PUBLISH_ORDER_ALERT_STATES)){
			meno = "建立串联单前，需要提示的订单状态、默认1(1未审批、2审核中、3通过、4被退回、5未通过)";	
		}else if(name.equals(Constants.IS_DISPLAY_STANDPRICE)){
			meno = "统计中是否显示刊例金额列(0-否 1-是))";	
		}else if(name.equals(Constants.SIGN_COMPAGES_PARAM)){
			meno = "是否启用套装参数(启用1,不启用0)系统参数默认是0";	
		}else if(name.equals(Constants.WITH_BROPROINT_PARAM)){
			meno = "是否启用播出入点(启用1,不启用0)系统参数默认是0";	
		}else if(name.equals(Constants.WITH_RESOURCE_SORT_PARAM)){
			meno = "是否启用广告资源分类(启用1,不启用0)系统参数默认是0";	
		}else if(name.equals(Constants.ORDER_CARRIER_LEVEL_PARAM)){
			meno = "订单中载体级别(默认0是维护时默认的级别数；1为表示只取一级)";	
		}else if(name.equals(Constants.ORDER_DETAIL_DISPLAY_PARAM)){
			meno = "订单中订单明细显示分页或不分页(默认0默认分页；1为表示不分)";	
		}else if(name.equals(Constants.USE_CARRIER_ALINAME_PARAM)){
			meno = "统计分析中是否启用频道别名(默认0,1启用)";	
		}else if(name.equals(Constants.USE_MORE_CARRIER_SORT_PARAM)){
			meno = "判断是否启用多种类型的载体，如电视、广播等等，默认0";	
		}else if(name.equals(Constants.CUSTOMER_CATE_FITER_PARAM)){
			meno = "是否启用客户类别过滤，默认0";	
		}else if(name.equals(Constants.INDUSTRY_LEVEL_PARAM)){
			meno = "行业级别，默认0为一级";	
		}else if(name.equals(Constants.AUTO_RELATION_CODE_PARAM)){
			meno = "是否启用自动联系号默认0,不启用1启用";	
		}else if(name.equals(Constants.AUTO_PRICE_TYPE_PARAM)){
			meno = "默认价格类别";	
		}else if(name.equals(Constants.USE_LANMU_SINGLE)){
			meno = "是否独立使用栏目";	
		}else if(name.equals(Constants.ALLOW_MODIY_PASSED_ORDER)){
			meno = "审核后的订单是否允许编辑";	
		}else if(name.equals(Constants.ORDER_PUBLISH_TEMPLE_PARAM)){
			meno = "广告发布合同模板类型 默认 0 最后每页有落款，1 只有最后一页有落款";	
		}else if(name.equals(Constants.ORDER_DISPLAY_RELATIONCEODE_PARAM)){
			meno = "是否显示关联编号，0不显示，1显示，默认0款";	
		}else if(name.equals(Constants.FINANCIA_AUDIT_PARAM)){
			meno = "是否显示编号，0不显示，1显示，";	
		}else if(name.equals(Constants.ORDER_DISPLAY_INCOME_PARAM)){
			meno = "是否显示平帐信息，0不显示，1显示，默认0";	
		}else if(name.equals(Constants.ONE_ORG_MORE_SUBORGS_PARAM)){
			meno = "一个集团下多个分支机构，但广告资源共享，0不显示，1显示，默认0";	
		}else if(name.equals(Constants.FINANCE_BALANCE_MODEL_PARAM)){
			meno = "财务平帐方式，0不显示，1显示，默认0";	
		}else if(name.equals(Constants.FAST_SIGN_ORDER_PARAM)){
			meno = "是否启用快速下订单，0否，1是";	
		}else if(name.equals(Constants.ORDER_CALCULATE_MODEL_PARAM)){
			meno = "订单应收计算模式，0 应收=折后价格*次数*折扣*（1+加收率）+补差, 1 应收=销售价格*次数*折扣*（1+加收率）+补差";	
		}else if(name.equals(Constants.DAYANG_BEIBO_ENADBLE_PARAM)){
			meno = "是否启用大洋的备播系统对接 0 否  1 是";	
		}else if(name.equals(Constants.DAYANG_WEBSERVER_URL_MATTER)){
			meno = "大洋的备播系统  webservice ImportMaterialService url http://10.77.82.91:8892/ADPINF/services/ImportMaterialService";	
		}else if(name.equals(Constants.DAYANG_WEBSERVER_URL_PROGRAM_LIST)){
			meno = "大洋的备播系统  webservice ImportProgramListService url http://10.77.82.91:8892/ADPINF/services/ImportProgramListService";	
		}else if(name.equals(Constants.ADRM_SYS_YEAR_PROGRAM_LIST)){
			meno = "系统启用的年份";	
		}else if(name.equals(Constants.ORDER_BASE_PRICE_ENABLE_MODY_PARAM)){
			meno = "订单刊例价格是否可以修改";	
		}else if(name.equals(Constants.ARRANGE_WITH_BRAND_PARAM)){
			meno = "广告编排是否显示品牌";	
		}else if(name.equals(Constants.ORDER_ARRANG_DEFAULT_MONTHS)){
			meno = "新签订单广告排期默认月份,默认当前月份+2";	
		}else if(name.equals(Constants.OUT_LIMIT_BROARRANG)){
			meno = "出串联单限制排期的修改";	
		}else if(name.equals(Constants.PUBLIC_AD_AUTO_FILL)){
			meno = "公益广告自动添加";	
		}else if(name.equals(Constants.RESOURCE_USE_CUSTOMER_CATELOG)){
			meno = "使用客户广告投放的时间比率";	
		}else if(name.equals(Constants.FTP_SERVVICE_CONFIG)){
			meno = "ftp服务器";	
		}else if(name.equals(Constants.RESCONFIG_ORDER_BY_TIME)){
			meno = "时段维护根据时间排序";	
		}
		
		

		return meno;
	}
	public String getDayangWebServiceUrlMatterParam() {
		return dayangWebServiceUrlMatterParam;
	}
	public void setDayangWebServiceUrlMatterParam(
			String dayangWebServiceUrlMatterParam) {
		this.dayangWebServiceUrlMatterParam = dayangWebServiceUrlMatterParam;
	}
	public String getDayangWebServiceUrlProLitstParam() {
		return dayangWebServiceUrlProLitstParam;
	}
	public void setDayangWebServiceUrlProLitstParam(
			String dayangWebServiceUrlProLitstParam) {
		this.dayangWebServiceUrlProLitstParam = dayangWebServiceUrlProLitstParam;
	}
	public String getAdrmSysYearProgramList() {
		return adrmSysYearProgramList;
	}
	public void setAdrmSysYearProgramList(String adrmSysYearProgramList) {
		this.adrmSysYearProgramList = adrmSysYearProgramList;
	}
	public String getOrderBasePriceEnableModyParam() {
		return orderBasePriceEnableModyParam;
	}
	public void setOrderBasePriceEnableModyParam(
			String orderBasePriceEnableModyParam) {
		this.orderBasePriceEnableModyParam = orderBasePriceEnableModyParam;
	}
	

	public String getOrderArrangDefaultMonths() {
		return orderArrangDefaultMonths;
	}

	public void setOrderArrangDefaultMonths(String orderArrangDefaultMonths) {
		this.orderArrangDefaultMonths = orderArrangDefaultMonths;
	}
	
	/**
 * @return the outLimitBroarrang
 */
public String getOutLimitBroarrang() {
	return outLimitBroarrang;
}
/**
 * @param outLimitBroarrang the outLimitBroarrang to set
 */
public void setOutLimitBroarrang(String outLimitBroarrang) {
	this.outLimitBroarrang = outLimitBroarrang;
}
/**
 * @return the resourceUseCustomerCatelog
 */
public String getResourceUseCustomerCatelog() {
	return resourceUseCustomerCatelog;
}
public String getPublicAdAutoFill() {
	return publicAdAutoFill;
}
public void setPublicAdAutoFill(String publicAdAutoFill) {
	this.publicAdAutoFill = publicAdAutoFill;
}

public String getFtpConfig() {
	return ftpConfig;
}
public void setFtpConfig(String ftpConfig) {
	this.ftpConfig = ftpConfig;
}
}
