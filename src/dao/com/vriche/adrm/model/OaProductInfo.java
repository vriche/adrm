/****************************************************************************     
 * Created on 2004-1-22                                                     *    
 *                                                               			*
 * @author <a href="mailto:hongxilin@yahoo.com.cn">hongxi</a>               *
 *         Updated by hongxi (hongxilin@yahoo.com.cn)                       *
 *                                                                          *
 * @version  Vision:1.0														*
 * 																			*
 ***************************************************************************/
package com.vriche.adrm.model;

import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * OaProductInfo class
 * 
 * This class is used to 
 * 
 * <p><a href="OaProductInfo.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_oa_product_info"
 * 
 */
public class OaProductInfo extends BaseObjectWithoutNestedFormValidation {
	
	private static final long serialVersionUID = 1L;
	protected Long id;
	protected Long productTypeId;
	protected String fittings;  // required
	protected Double price;
	protected String unit;
	protected Long quantity;
	protected String provider;
	protected Integer stockDate;
	protected Integer storageDate;
	protected Long stockUser;	
	protected String picture;	
	protected String memo;	
	protected Long createBy; // default sysdate
	protected Date createDate;
	protected Long modifyBy; // default sysdate
	protected Date modifyDate;
	protected Integer version;
	
	protected OaProductType productType = new OaProductType();
	
	public OaProductInfo() {};
	
	



	/**
	 * 
	 * Returns the id
	 * @return Long
	 * 
	 * @hibernate.id column="product_id" generator-class="native" unsaved-value="null"
	 */
	public Long getId() {
		return id;
	}
	
	
	/**
	 * 
	 * Returns the fittings
	 * @return String
	 *  @struts.validator type="required"
	 * @hibernate.property length="255" column="fittings" not-null="false"
	 */
	public String getFittings() {
		return fittings;
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
	 * Returns the picture
	 * @return String
	 * 
	 * @hibernate.property length="255" column="picture" not-null="false"
	 */
	public String getPicture() {
		return picture;
	}


	/**
	 * 
	 * Returns the price
	 * @return Double
	 * 
	 * @hibernate.property length="10" column="price" not-null="false"
	 */
	public Double getPrice() {
		return price;
	}


	/**
	 * 
	 * Returns the productTypeId
	 * @return Long
	 * 
	 * @hibernate.property length="20" column="product_type_id" not-null="false"
	 */
	public Long getProductTypeId() {
		return productTypeId;
	}


	/**
	 * 
	 * Returns the provider
	 * @return String
	 * 
	 * @hibernate.property length="255" column="provider" not-null="false"
	 */
	public String getProvider() {
		return provider;
	}


	/**
	 * 
	 * Returns the quantity
	 * @return Long
	 * 
	 * @hibernate.property length="20" column="quantity" not-null="false"
	 */
	public Long getQuantity() {
		return quantity;
	}


	/**
	 * 
	 * Returns the stockDate
	 * @return Integer
	 * 
	 * @hibernate.property length="8" column="stock_date" not-null="false"
	 */
	public Integer getStockDate() {
		return stockDate;
	}


	/**
	 * 
	 * Returns the stockUser
	 * @return Long
	 * 
	 * @hibernate.property length="20" column="stock_user" not-null="false"
	 */
	public Long getStockUser() {
		return stockUser;
	}


	/**
	 * 
	 * Returns the storageDate
	 * @return Integer
	 * 
	 * @hibernate.property length="8" column="storage_date" not-null="false"
	 */
	public Integer getStorageDate() {
		return storageDate;
	}


	/**
	 * 
	 * Returns the unit
	 * @return String
	 * 
	 * @hibernate.property length="32" column="unit" not-null="false"
	 */
	public String getUnit() {
		return unit;
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
		
	
	public OaProductType getProductType() {
		return productType;
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
	 * @param fittings The fittings to set.
	 */
	public void setFittings(String fittings) {
		this.fittings = fittings;
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
	 * @param picture The picture to set.
	 */
	public void setPicture(String picture) {
		this.picture = picture;
	}


	/**
	 * @param price The price to set.
	 */
	public void setPrice(Double price) {
		this.price = price;
	}


	/**
	 * @param producttype The producttype to set.
	 */
	public void setProductType(OaProductType productType) {
		this.productType = productType;
	}


	/**
	 * @param productTypeId The productTypeId to set.
	 */
	public void setProductTypeId(Long productTypeId) {
		this.productTypeId = productTypeId;
	}


	/**
	 * @param provider The provider to set.
	 */
	public void setProvider(String provider) {
		this.provider = provider;
	}


	/**
	 * @param quantity The quantity to set.
	 */
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}


	/**
	 * @param stockDate The stockDate to set.
	 */
	public void setStockDate(Integer stockDate) {
		this.stockDate = stockDate;
	}


	/**
	 * @param stockUser The stockUser to set.
	 */
	public void setStockUser(Long stockUser) {
		this.stockUser = stockUser;
	}


	/**
	 * @param storageDate The storageDate to set.
	 */
	public void setStorageDate(Integer storageDate) {
		this.storageDate = storageDate;
	}


	/**
	 * @param unit The unit to set.
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}


	/**
	 * @param version The version to set.
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}


	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof OaProductInfo)) {
			return false;
		}
		OaProductInfo rhs = (OaProductInfo) object;
		return new EqualsBuilder().append(
				this.memo, rhs.memo).append(this.unit, rhs.unit).append(
				this.stockUser, rhs.stockUser).append(this.modifyBy,
				rhs.modifyBy).append(this.picture, rhs.picture).append(
				this.productTypeId, rhs.productTypeId).append(this.createBy,
				rhs.createBy).append(this.id, rhs.id).append(this.version,
				rhs.version).append(this.productType, rhs.productType).append(
				this.storageDate, rhs.storageDate)
				.append(this.price, rhs.price).append(this.stockDate,
						rhs.stockDate).append(this.modifyDate, rhs.modifyDate)
				.append(this.createDate, rhs.createDate).append(this.provider,
						rhs.provider).append(this.quantity, rhs.quantity)
				.append(this.fittings, rhs.fittings).isEquals();
	}


	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-817307533, 444294905).append(this.memo).append(this.unit).append(
				this.stockUser).append(this.modifyBy).append(this.picture)
				.append(this.productTypeId).append(this.createBy).append(
						this.id).append(this.version).append(this.productType)
				.append(this.storageDate).append(this.price).append(
						this.stockDate).append(this.modifyDate).append(
						this.createDate).append(this.provider).append(
						this.quantity).append(this.fittings).toHashCode();
	}


	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("modifyBy", this.modifyBy)
				.append("productTypeId", this.productTypeId).append("id",
						this.id).append("quantity", this.quantity).append(
						"modifyDate", this.modifyDate).append("fittings",
						this.fittings).append("stockDate", this.stockDate)
				.append("unit", this.unit).append("memo", this.memo).append(
						"createBy", this.createBy).append("price", this.price)
				.append("stockUser", this.stockUser).append("version",
						this.version).append("provider", this.provider).append(
						"picture", this.picture).append("storageDate",
						this.storageDate).append("createDate", this.createDate)
				.toString();
	}

}
