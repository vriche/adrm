/****************************************************************************     
 * Created on 2007-4-11                                      *    
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
import java.util.Set;

/**
 * OaAssets class
 * 
 * This class is used to 
 * 
 * <p><a href="OaAssets.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_oa_assets"
 * 
 */
public class OaAssets  extends BaseObject {
	
	
	private static final long serialVersionUID = -3774862020317495825L;

	protected Long id;
	
	protected String assetsCode;  // required
	protected String assetsName;
	protected Long assetsTypeId;
	protected String standard;
	protected String depreciation;
	protected String voucher;
	protected Integer useYearFixed;
	protected Double purchaseMoney;
	protected String purchaseDate;
	protected Double oldValue;
	protected Double surplusValue;
	protected String provider;
	protected String storage;
	protected Long assetsStateId;
	protected String memo;

	
	protected Long createBy; 	 // default sysdate
	protected Date createDate;
	protected Long modifyBy;	 // default sysdate
	protected Date modifyDate;
	protected Integer version;
	
	protected OaAssetsState oaAssetsState = new OaAssetsState();
	protected OaAssetsType oaAssetsType = new OaAssetsType();
	protected Set oaProductInfos = new HashSet();
	protected User signUser = new User();
	
	
	
	public OaAssets() {};

	/**
	 * @hibernate.id column="assets_id" generator-class="native"
	 *               unsaved-value="null"
	 */
	public Long getId() {
		return id;
	}



	public OaAssetsState getOaAssetsState() {
		return oaAssetsState;
	}

	public OaAssetsType getOaAssetsType() {
		return oaAssetsType;
	}



	/**
	 * 
	 * Returns the assetsCode
	 * @return String 
	 * @struts.validator type="required"
	 * @hibernate.property length="255" column="assets_code" not-null="false"
	 */
	public String getAssetsCode() {
		return assetsCode;
	}

	/**
	 * 
	 * Returns the assetsName
	 * @return String 
	 * 
	 * @hibernate.property length="32" column="assets_name" not-null="false"
	 */
	public String getAssetsName() {
		return assetsName;
	}

	/**
	 * 
	 * Returns the assetsStateId
	 * @return Long 
	 * 
	 * @hibernate.property length="20" column="assets_state_id" not-null="false"
	 */
	public Long getAssetsStateId() {
		return assetsStateId;
	}

	/**
	 * 
	 * Returns the assetsTypeId
	 * @return Long 
	 * 
	 * @hibernate.property length="20" column="assets_type_id" not-null="false"
	 */
	public Long getAssetsTypeId() {
		return assetsTypeId;
	}

	/**
	 * 
	 * Returns the depreciation
	 * @return String 
	 * 
	 * @hibernate.property length="32" column="depreciation" not-null="false"
	 */
	public String getDepreciation() {
		return depreciation;
	}

	/**
	 * 
	 * Returns the memo
	 * @return String 
	 * 
	 * @hibernate.property length="255" column="memo" not-null="false"
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * 
	 * Returns the oldValue
	 * @return Double 
	 * 
	 * @hibernate.property length="10" column="old_value" not-null="false"
	 */
	public Double getOldValue() {
		return oldValue;
	}

	/**
	 * 
	 * Returns the provider
	 * @return String 
	 * 
	 * @hibernate.property length="128" column="provider" not-null="false"
	 */
	public String getProvider() {
		return provider;
	}



	/**
	 * 
	 * Returns the purchaseMoney
	 * @return Double 
	 * 
	 * @hibernate.property length="10" column="purchase_money" not-null="false"
	 */
	public Double getPurchaseMoney() {
		return purchaseMoney;
	}
	/**
	 * 
	 * Returns the purchaseDate
	 * @return String 
	 * 
	 * @hibernate.property length="8" column="purchase_date" not-null="false"
	 */
	public String getPurchaseDate() {
		return purchaseDate;
	}
	/**
	 * 
	 * Returns the standard
	 * @return String 
	 * 
	 * @hibernate.property length="128" column="standard" not-null="false"
	 */
	public String getStandard() {
		return standard;
	}

	/**
	 * 
	 * Returns the storage
	 * @return String 
	 * 
	 * @hibernate.property length="255" column="storage" not-null="false"
	 */
	public String getStorage() {
		return storage;
	}

	/**
	 * 
	 * Returns the surplusValue
	 * @return Double 
	 * 
	 * @hibernate.property length="10" column="surplus_value" not-null="false"
	 */
	public Double getSurplusValue() {
		return surplusValue;
	}

	/**
	 * 
	 * Returns the useYearFixed
	 * @return Integer 
	 * 
	 * @hibernate.property length="5" column="use_year_fixed" not-null="false"
	 */
	public Integer getUseYearFixed() {
		return useYearFixed;
	}

	/**
	 * 
	 * Returns the voucher
	 * @return String 
	 * 
	 * @hibernate.property length="32" column="voucher" not-null="false"
	 */
	public String getVoucher() {
		return voucher;
	}

	/**
	 * 
	 * Returns the createBy
	 * 
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
	 * 
	 * @return Date
	 * 
	 * @hibernate.property column="create_date" update="false" insert="true"
	 *                     type="timestamp"
	 */

	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 
	 * Returns the modifyBy
	 * 
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
	 * 
	 * @return Date
	 * 
	 * @hibernate.property column="modify_date" update="false" insert="true"
	 *                     type="timestamp"
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
     * @hibernate.set table="tb_oa_assets_product" cascade="save-update" lazy="false"
     * @hibernate.collection-key column="assets_id"
     * @hibernate.collection-many-to-many class="com.vriche.adrm.model.OaProductInfo" column="product_id"
     */
	public Set getOaProductInfos() {
		return oaProductInfos;
	}
	
	/**
	 * 
	 * Returns the signUser
	 * @return User 
	 * 
	 */
	public User getSignUser() {
		return signUser;
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
	 * @param version The version to set.
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}


	/** 
	 * @param purchaseDate The purchaseDate to set.
	 */
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	

	
	
	/** 
	 * @param assetsCode The assetsCode to set.
	 */
	public void setAssetsCode(String assetsCode) {
		this.assetsCode = assetsCode;
	}

	/** 
	 * @param assetsName The assetsName to set.
	 */
	public void setAssetsName(String assetsName) {
		this.assetsName = assetsName;
	}

	/** 
	 * @param assetsStateId The assetsStateId to set.
	 */
	public void setAssetsStateId(Long assetsStateId) {
		this.assetsStateId = assetsStateId;
	}

	/** 
	 * @param assetsTypeId The assetsTypeId to set.
	 */
	public void setAssetsTypeId(Long assetsTypeId) {
		this.assetsTypeId = assetsTypeId;
	}

	/** 
	 * @param depreciation The depreciation to set.
	 */
	public void setDepreciation(String depreciation) {
		this.depreciation = depreciation;
	}

	/** 
	 * @param memo The memo to set.
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}

	/** 
	 * @param oldValue The oldValue to set.
	 */
	public void setOldValue(Double oldValue) {
		this.oldValue = oldValue;
	}

	/** 
	 * @param provider The provider to set.
	 */
	public void setProvider(String provider) {
		this.provider = provider;
	}

	/** 
	 * @param purchaseMoney The purchaseMoney to set.
	 */
	public void setPurchaseMoney(Double purchaseMoney) {
		this.purchaseMoney = purchaseMoney;
	}

	/** 
	 * @param standard The standard to set.
	 */
	public void setStandard(String standard) {
		this.standard = standard;
	}

	/** 
	 * @param storage The storage to set.
	 */
	public void setStorage(String storage) {
		this.storage = storage;
	}

	/** 
	 * @param surplusValue The surplusValue to set.
	 */
	public void setSurplusValue(Double surplusValue) {
		this.surplusValue = surplusValue;
	}

	/** 
	 * @param useYearFixed The useYearFixed to set.
	 */
	public void setUseYearFixed(Integer useYearFixed) {
		this.useYearFixed = useYearFixed;
	}

	/** 
	 * @param voucher The voucher to set.
	 */
	public void setVoucher(String voucher) {
		this.voucher = voucher;
	}
	/** 
	 * @param oaAssetsState The oaAssetsState to set.
	 */
	public void setOaAssetsState(OaAssetsState oaAssetsState) {
		this.oaAssetsState = oaAssetsState;
	}



	/** 
	 * @param oaAssetsType The oaAssetsType to set.
	 */
	public void setOaAssetsType(OaAssetsType oaAssetsType) {
		this.oaAssetsType = oaAssetsType;
	}
	


	/** 
	 * @param signUser The signUser to set.
	 */
	public void setSignUser(User signUser) {
		this.signUser = signUser;
	}	
	

	/** 
	 * @param oaProductInfos The oaProductInfos to set.
	 */
	public void setOaProductInfos(Set oaProductInfos) {
		this.oaProductInfos = oaProductInfos;
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.model.BaseObjectWithoutNestedFormValidation#toString()
	 */
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.model.BaseObjectWithoutNestedFormValidation#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.model.BaseObjectWithoutNestedFormValidation#hashCode()
	 */
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}






}
