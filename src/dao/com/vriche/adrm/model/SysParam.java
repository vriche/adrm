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
    
    
//  ��ͬ����   
    protected String contractSortParam;
//���������ʽ
    protected String orderViewModelParam;
	//��Ƶ������
    protected String channelModelParam;
    //�����ŷ�ʽ
    protected String piblishModelParam;
    //����ӿ�����
    protected String piblishExportModelParam;
    //��������ɷ�ʽ
    protected String adverCodeModelParam;
    //���������ɷ�ʽ  
    protected String orderCodeModelParam;
    //����ʽ 
    protected String theme;  
    //�������������ʾ����
    protected String orderCarrierTypeDisplayParam;
    
    //�������������ʾ����
    protected String resourceDisplayParam;   
    //�ͻ�������ʽ
    protected String customerOwnerParam;
    //  �ͻ����������ʽ
    //protected String customerCarrierParam;
    //����ЭԼ
    protected String orderContractParam;
    //���弶��
    protected String carrierNodeLevelParam;
    //��Ƭ����
    protected String dianpianParam;
    //���λ����
    protected String stridePositionParam;
//  �ڶ�������ӿͻ�
    protected String addCustomerInOrderParam;
//  ���ƶ�Ҳ�������
    protected String specArowMoveParam;
    //  Ƶ������
    protected String  channelPullParam; 
    
    //����ʱ�Ƿ���ʾû�й��Ķ�λ
    protected String  isDisplayNoadResParam;     
    
    //�Ƿ��Ƶ��
    protected String  moreChannelParam; 
    
    //��Ƶ��������
    protected String  moreChannelNoPullParam; 
    
    
    //13���ʱ���޶�
    protected String  resourceReLimitParam;    
    
    
    //��󶩵��������޸Ĺ���زģ��������޸ĳ���
    protected String  permitModAdverParam;    
    
    //  ������ʱ����������Ĭ��ֵ
    protected String  orderModCategoryParam; 
    
    //  �Ƿ���������־
    protected String  isOpenOrderOrgParam; 
    
    //  �Ƿ���ʾͼ��ť
    protected String  isDisplayChartParam;
    
    //	�Ƿ���ʾ�û��ͻ�����
    protected String  isUserCustomerRelParam;
    
    //	�����ʾǷ��ͳ�Ʒ�ʽ
    protected String  arrearageMode;
    
    //	��α��Ŵ�����(����ʾ˳��(0),���ǲ������(1)����)
    protected String  isArrangeOrderOrEntry;
    
    //���ݵ���̨���⹦�ܲ���(���Ǹ���̨������Ϊ1,��������Ϊ0);ϵͳ����Ĭ����0;
    protected String  fztvSpecialParam;
    
    //Ȫ�ݵ���̨���⹦�ܲ���(����Ȫ��̨������Ϊ1,��������Ϊ0);ϵͳ����Ĭ����0;
    protected String  qztvSpecialParam;
    
    
    //�Ƿ�������װ����(����1,������0)ϵͳ����Ĭ����0;
    protected String  signCompages;
    
    //�Ƿ����ò������(����1,������0)ϵͳ����Ĭ����0;
    protected String  withBroPoint;
    
    //�Ƿ����ù����Դ����(����1,������0)ϵͳ����Ĭ����0
    protected  String withResourceSort;
    
    
    //����̨���⹦�ܲ���(����ָ���ض�����̨������Ϊcatv,sjztv,hntv,fztv,qztv,xmtv,��������Ϊ0);ϵͳ����Ĭ����0;
    protected String  tvNameParam;    
    
    
    //���������ύ���������(��Ҫ�ύ(0),���ύ(1))
    protected String  withoutSubmit;
    
    // ������ʾ����ص�ҵ��Ա(�������¼��һ�ʵ�����޸�һ�𵽿����ʾ��ص�ҵ��Ա) 0ΪĬ�ϲ���ʾ��1��ʾ��Ҫ��ʾ
    protected String  incomeMessageAlertParam;
    
    protected String  sequenceIncomeAutoParam;
    //�Ƿ���ҵ��Աƽ��(0-�� 1-��)  
    protected String  isSignUserBalance;
    
    //�����Ƿ�������ݹ���(0-�� 1-��)   
    protected String  isUserOrderYearRel;
    
   //����������ǰ����Ҫ��ʾ�Ķ���״̬��Ĭ��1(1δ������2����С�3ͨ����4���˻ء�5δͨ��)
    protected String  publishOrderAlertStates;
    
//  �Ƿ�����Ƶ������(0-�� 1-��) �� ����Ƶ��������Ƶ���ķ��෽��  
    protected String  isUseCarrierProty;
//  ͳ�����Ƿ���ʾ���������
    protected String  isDisplayStandPrice;
    
    //���������弶��(Ĭ��0��ά��ʱĬ�ϵļ�������1Ϊ��ʾֻȡһ��)
    protected String  orderCarrierLevelParam;
    
    //�����ж�����ϸ��ʾ��ҳ�򲻷�ҳ(Ĭ��0Ĭ�Ϸ�ҳ��1Ϊ��ʾ����)
    protected String  orderDetailDisplayParam;
    
    //ͳ�Ʒ������Ƿ�����Ƶ������(Ĭ��0,1����)
    protected String  useCarrierAliname;

    //ͳ�Ʒ������Ƿ�����Ƶ������(Ĭ��0,1����)
    protected String  useMoreCarrierSortParam;

//  �Ƿ����ÿͻ�������
    protected String  customerCateFiter;
    
//  ��ҵ���� 
    protected String  industryLevelParam;  
    
//  �Ƿ������Զ���ϵ��
    protected String  autoRelationCodeParam;     
    
//  Ĭ�ϼ۸����
    protected String  autoPriceTypeParam;     
    
    
	 
	 //�Ƿ����ʹ����Ŀ
    protected String  useLanmuSingleParam;     

	 //�Ƿ����ʹ����Ŀ
    protected String  allowModiyPassedOrderParam;     
    
//    ��淢����ͬģ������ Ĭ�� 0 ���ÿҳ����1 ֻ�����һҳ�����
    protected String  orderPublishTempleParam;    
    
//  �Ƿ���ʾ������ţ�0����ʾ��1��ʾ��Ĭ��0
    protected String  orderDisplayRelcodeParam;  
    
    //�Ƿ������������ˣ�true|56,22|88
    protected String  financialAuditParam;  
    
//  �Ƿ���ʾ������ţ�0����ʾ��1��ʾ��Ĭ��0
    protected String  orderDisplayIncomeParam;     
    
    
	 //һ�������¶����֧�������������Դ����0����ʾ��1��ʾ��Ĭ��0
    protected String  oneOrgMoreSuborgsParam;     
    
    
	 //����ƽ�ʷ�ʽ��0����ʾ��1��ʾ��Ĭ��0
   protected String  financeBalanceModelParam;     
   
	 //�����µ���0��1��
   protected String  fastSignOrderParam; 
   
   //����Ӧ�ռ���ģʽ��0 Ӧ��=�ۺ�۸�*����*�ۿ�*��1+�����ʣ�+����, 1 Ӧ��=���ۼ۸�*����*�ۿ�*��1+�����ʣ�+����
   protected String  orderCalculateModel; 
   
	 //�Ƿ����ô���ı���ϵͳ�Խ� 0 ��  1 ��
   protected String  dayangBeiboEnableParam; 
   
   
   //����ı���ϵͳ  webservice ImportMaterialService url  "http://10.77.82.91:8892/ADPINF/services/ImportMaterialService";
   protected String  dayangWebServiceUrlMatterParam; 
   
   //	����ı���ϵͳ  webservice ImportProgramListService url  "http://10.77.82.91:8892/ADPINF/services/ImportProgramListService";
   protected String  dayangWebServiceUrlProLitstParam; 
   
   
// ϵͳ���õ����
   protected String  adrmSysYearProgramList; 
   
// ���������۸��Ƿ�����޸�
   protected String  orderBasePriceEnableModyParam; 
   
// �������Ƿ���ʾƷ��
   protected String  arrangeWithBrandParam;    
   
   
// ��ǩ�����������Ĭ���·�,Ĭ�ϵ�ǰ�·�+2
   protected String  orderArrangDefaultMonths;    
   
   // ���������������ڵ��޸�
   protected String  outLimitBroarrang;
   // ʹ�ÿͻ����Ͷ�ŵ�ʱ�����
   protected String resourceUseCustomerCatelog;
   
   
	//�������Զ����
   protected String publicAdAutoFill;

//ftp������
   protected String ftpConfig;
   
   
 //ʱ��ά������ʱ������
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
			meno = "����ʽ";
		}else if(name.equals(Constants.CONTRACT_SORT_PARAM)){
			meno = "��ͬ������0���ݸ������Ӧ�� 1������";
		}else if(name.equals(Constants.ORDER_VIEW_MODEL_PARAM)){
			meno = "���������ʽ��0������1�����û�������";
		}else if(name.equals(Constants.CHANNEL_MODEL_PARAM)){
			meno = "��Ƶ������0����1�֣�(Ӧ�ù㷺,0�ܿ�������Ƶ��,1�����趨Ȩ�޿���ָ��Ƶ��)";
		}else if(name.equals(Constants.PUBLISH_MODEL_PARAM)){
			meno = "�����ŷ�ʽ��1����1 2����2��";
		}else if(name.equals(Constants.PUBLISH_EXPORT_MODEL_PARAM)){
			meno = "�����ļ��ӿ����� ��1������ڶ���������ļ���2��ʱ�α�����ļ���";
		}else if(name.equals(Constants.ADVER_CODE_MODEL_PARAM)){
			meno = "��������ɷ�ʽ��0�ֶ�1�Զ���";
		}else if(name.equals(Constants.ORDER_CODE_MODEL_PARAM)){
			meno = "��ͬ�����ɷ�ʽ";
		}else if(name.equals(Constants.ORDER_CARRIER_TYPE_DISPLAY_PARAM)){
			meno = "�������������ʾ����(0����ʾ1��ʾĬ��1��ʾ)";
		}else if(name.equals(Constants.RESOURCE_DISPLAY_PARAM)){
			meno = "����λ��ʾ���ƻ�ע";
		}else if(name.equals(Constants.CHANNEL_PULL_PARAM)){
			meno = "Ƶ������(��moreChannelNoPullParam�ڵ�����¼ҳ�����ʹ��,��Ϸ�ʽΪ(1,0),(1,1),(0,0))";
		}else if(name.equals(Constants.CUSTOMER_OWNER_PARAM)){
			meno = "�ͻ�������ʽ";
		}else if(name.equals(Constants.ORDER_CONTRACT_PARAM)){
			meno = "����ЭԼ";
		}else if(name.equals(Constants.CARRIER_NODELEVEL_PARAM)){
			meno = "���弶��";
		}else if(name.equals(Constants.DIAN_PIAN_PARAM)){
			meno = "��Ƭ����";
		}else if(name.equals(Constants.STRIDE_POSITION_PARAM)){
			meno = "������ʱ�Ƿ�������λ����";
		}else if(name.equals(Constants.ADD_CUSTOMER_IN_ORDER_PARAM)){
			meno = "�ڶ�������ӿͻ�";
		}else if(name.equals(Constants.SPEC_AROWMOVE_PARAM)){
			meno = "��ָ��Ҳ�������";
		}else if(name.equals(Constants.IS_DISPLAYNOADRES_PARAM)){
			meno = "����ʱ�Ƿ���ʾû�й��Ķ�λ";
		}else if(name.equals(Constants.MORE_CHANNEL_NOPULL_PARAM)){
			meno = "��Ƶ��������(��channelPullParam�ڵ�����¼ҳ�����ʹ��,����ֱ��ǣ��ֶ����˵�����Ƶ��(��Ƶ��ͳһ)���Զ����˵�����Ƶ��(��Ƶ������)������Ƶ������(��Ƶ��))";
		}else if(name.equals(Constants.MORE_CHANNEL_PARAM)){
			meno = "�Ƿ��Ƶ��(��Ҫ�����ڵ������Ƿ���ʾƵ������,1��ʾ,0����ʾ,��ʱֻ���ں�̨(2010/05/21))";
		}else if(name.equals(Constants.RESOURCE_RELIMIT_PARAM)){
			meno = "13���ʱ���޶�";
		}else if(name.equals(Constants.PERMIT_MOD_ADVER_PARAM)){
			meno = "��󶩵������޸Ĺ���زĳ��ȳ���";	
		}else if(name.equals(Constants.ORDER_MOD_CATEGORY_PARAM)){
			meno = "��ǩ����Ĭ�ϵĶ��������趨";
		}else if(name.equals(Constants.IS_OPEN_ORDER_ORG_PARAM)){
			meno = "�Ƿ���������־";
		}else if(name.equals(Constants.IS_DISPLAY_CHART_PARAM)){
			meno = "�Ƿ���ʾͼ��ť��1��ʾ��";
		}else if(name.equals(Constants.IS_USER_CUSTOMER_REL_PARAM)){
			meno = "�Ƿ���ʾ�û��ͻ�������ϵ���ͻ�����������ϵ��ť��0���ܲ���ʾ1��ʾ��";
		}else if(name.equals(Constants.ARREARAGE_MODE)){
			meno = "Ƿ��ͳ�Ʒ�ʽ(0{Ͷ��-����},1{Ͷ��-����})";	
		}else if(name.equals(Constants.IS_ARRANGE_ORDER_OR_ENTRY)){
			meno = "��α��Ŵ�����(����ʾ˳��(0),���ǲ������(1)����)";	
		}else if(name.equals(Constants.FZTV_SPECIAL_PARAM)){
			meno = "���ݵ���̨���⹦�ܲ���(���Ǹ���̨������Ϊ1,��������Ϊ0);��Ϊϵͳ����Ĭ����0";	
		}else if(name.equals(Constants.QZTV_SPECIAL_PARAM)){
			meno = "Ȫ�ݵ���̨���⹦�ܲ���(����Ȫ��̨������Ϊ1,��������Ϊ0);��Ϊϵͳ����Ĭ����0";	
		}else if(name.equals(Constants.TV_NAME_PARAM)){
			meno = "����̨���⹦�ܲ���(����ָ���ض�����̨������Ϊcatv��������Ϊ0);ϵͳ����Ĭ����0;";	
		}else if(name.equals(Constants.WITHOUT_SUBMIT)){
			meno = "���������ύ���������(��Ҫ�ύ(0),���ύ(1))";	
		}else if(name.equals(Constants.INCOME_MESSAGE_ALERT_PARAM)){
			meno = "������ʾ����ص�ҵ��Ա(�������¼��һ�ʵ�����޸�һ�𵽿����ʾ��ص�ҵ��Ա) ��ʽ��1,192.168.1.100,5222,domain.com,longin,PWD��";	
		}else if(name.equals(Constants.INCOME_CODE_MODEL_PARAM)){
			meno = "�������Զ�����(0-�ֶ���1-�Զ�)";	
		}else if(name.equals(Constants.IS_SIGN_USER_BALANCE)){
			meno = "�Ƿ���ҵ��Աƽ��(0-�� 1-��)";	
		}else if(name.equals(Constants.IS_USER_ORDER_YEAR_REL)){
			meno = "�����Ƿ�������ݹ���(0-�� 1-��)";	
		}else if(name.equals(Constants.IS_USE_CARRIER_PROTY)){
			meno = "�Ƿ�����Ƶ������(0-�� 1-��) �� ����Ƶ��������Ƶ���ķ��෽��";	
		}else if(name.equals(Constants.PUBLISH_ORDER_ALERT_STATES)){
			meno = "����������ǰ����Ҫ��ʾ�Ķ���״̬��Ĭ��1(1δ������2����С�3ͨ����4���˻ء�5δͨ��)";	
		}else if(name.equals(Constants.IS_DISPLAY_STANDPRICE)){
			meno = "ͳ�����Ƿ���ʾ���������(0-�� 1-��))";	
		}else if(name.equals(Constants.SIGN_COMPAGES_PARAM)){
			meno = "�Ƿ�������װ����(����1,������0)ϵͳ����Ĭ����0";	
		}else if(name.equals(Constants.WITH_BROPROINT_PARAM)){
			meno = "�Ƿ����ò������(����1,������0)ϵͳ����Ĭ����0";	
		}else if(name.equals(Constants.WITH_RESOURCE_SORT_PARAM)){
			meno = "�Ƿ����ù����Դ����(����1,������0)ϵͳ����Ĭ����0";	
		}else if(name.equals(Constants.ORDER_CARRIER_LEVEL_PARAM)){
			meno = "���������弶��(Ĭ��0��ά��ʱĬ�ϵļ�������1Ϊ��ʾֻȡһ��)";	
		}else if(name.equals(Constants.ORDER_DETAIL_DISPLAY_PARAM)){
			meno = "�����ж�����ϸ��ʾ��ҳ�򲻷�ҳ(Ĭ��0Ĭ�Ϸ�ҳ��1Ϊ��ʾ����)";	
		}else if(name.equals(Constants.USE_CARRIER_ALINAME_PARAM)){
			meno = "ͳ�Ʒ������Ƿ�����Ƶ������(Ĭ��0,1����)";	
		}else if(name.equals(Constants.USE_MORE_CARRIER_SORT_PARAM)){
			meno = "�ж��Ƿ����ö������͵����壬����ӡ��㲥�ȵȣ�Ĭ��0";	
		}else if(name.equals(Constants.CUSTOMER_CATE_FITER_PARAM)){
			meno = "�Ƿ����ÿͻ������ˣ�Ĭ��0";	
		}else if(name.equals(Constants.INDUSTRY_LEVEL_PARAM)){
			meno = "��ҵ����Ĭ��0Ϊһ��";	
		}else if(name.equals(Constants.AUTO_RELATION_CODE_PARAM)){
			meno = "�Ƿ������Զ���ϵ��Ĭ��0,������1����";	
		}else if(name.equals(Constants.AUTO_PRICE_TYPE_PARAM)){
			meno = "Ĭ�ϼ۸����";	
		}else if(name.equals(Constants.USE_LANMU_SINGLE)){
			meno = "�Ƿ����ʹ����Ŀ";	
		}else if(name.equals(Constants.ALLOW_MODIY_PASSED_ORDER)){
			meno = "��˺�Ķ����Ƿ�����༭";	
		}else if(name.equals(Constants.ORDER_PUBLISH_TEMPLE_PARAM)){
			meno = "��淢����ͬģ������ Ĭ�� 0 ���ÿҳ����1 ֻ�����һҳ�����";	
		}else if(name.equals(Constants.ORDER_DISPLAY_RELATIONCEODE_PARAM)){
			meno = "�Ƿ���ʾ������ţ�0����ʾ��1��ʾ��Ĭ��0��";	
		}else if(name.equals(Constants.FINANCIA_AUDIT_PARAM)){
			meno = "�Ƿ���ʾ��ţ�0����ʾ��1��ʾ��";	
		}else if(name.equals(Constants.ORDER_DISPLAY_INCOME_PARAM)){
			meno = "�Ƿ���ʾƽ����Ϣ��0����ʾ��1��ʾ��Ĭ��0";	
		}else if(name.equals(Constants.ONE_ORG_MORE_SUBORGS_PARAM)){
			meno = "һ�������¶����֧�������������Դ����0����ʾ��1��ʾ��Ĭ��0";	
		}else if(name.equals(Constants.FINANCE_BALANCE_MODEL_PARAM)){
			meno = "����ƽ�ʷ�ʽ��0����ʾ��1��ʾ��Ĭ��0";	
		}else if(name.equals(Constants.FAST_SIGN_ORDER_PARAM)){
			meno = "�Ƿ����ÿ����¶�����0��1��";	
		}else if(name.equals(Constants.ORDER_CALCULATE_MODEL_PARAM)){
			meno = "����Ӧ�ռ���ģʽ��0 Ӧ��=�ۺ�۸�*����*�ۿ�*��1+�����ʣ�+����, 1 Ӧ��=���ۼ۸�*����*�ۿ�*��1+�����ʣ�+����";	
		}else if(name.equals(Constants.DAYANG_BEIBO_ENADBLE_PARAM)){
			meno = "�Ƿ����ô���ı���ϵͳ�Խ� 0 ��  1 ��";	
		}else if(name.equals(Constants.DAYANG_WEBSERVER_URL_MATTER)){
			meno = "����ı���ϵͳ  webservice ImportMaterialService url http://10.77.82.91:8892/ADPINF/services/ImportMaterialService";	
		}else if(name.equals(Constants.DAYANG_WEBSERVER_URL_PROGRAM_LIST)){
			meno = "����ı���ϵͳ  webservice ImportProgramListService url http://10.77.82.91:8892/ADPINF/services/ImportProgramListService";	
		}else if(name.equals(Constants.ADRM_SYS_YEAR_PROGRAM_LIST)){
			meno = "ϵͳ���õ����";	
		}else if(name.equals(Constants.ORDER_BASE_PRICE_ENABLE_MODY_PARAM)){
			meno = "���������۸��Ƿ�����޸�";	
		}else if(name.equals(Constants.ARRANGE_WITH_BRAND_PARAM)){
			meno = "�������Ƿ���ʾƷ��";	
		}else if(name.equals(Constants.ORDER_ARRANG_DEFAULT_MONTHS)){
			meno = "��ǩ�����������Ĭ���·�,Ĭ�ϵ�ǰ�·�+2";	
		}else if(name.equals(Constants.OUT_LIMIT_BROARRANG)){
			meno = "���������������ڵ��޸�";	
		}else if(name.equals(Constants.PUBLIC_AD_AUTO_FILL)){
			meno = "�������Զ����";	
		}else if(name.equals(Constants.RESOURCE_USE_CUSTOMER_CATELOG)){
			meno = "ʹ�ÿͻ����Ͷ�ŵ�ʱ�����";	
		}else if(name.equals(Constants.FTP_SERVVICE_CONFIG)){
			meno = "ftp������";	
		}else if(name.equals(Constants.RESCONFIG_ORDER_BY_TIME)){
			meno = "ʱ��ά������ʱ������";	
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
