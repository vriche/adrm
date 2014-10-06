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
 * OaProductUsed class
 * 
 * This class is used to 
 * 
 * <p><a href="OaProductUsed.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_oa_product_used"
 * 
 */
public class OaProductUsed extends BaseObjectWithoutNestedFormValidation {
	

	private static final long serialVersionUID = 1L;
	protected Long id;	
	protected Long productId;	
	protected Date useDate;	
	protected Date playReturnDate;	
	protected Long useNum;	
	protected Long returnNum;	
	protected Long useMan; // required	
	protected Date relReturnDate;	
	protected Long attaint;	
	protected Double amends;	
	
	protected Long createBy; // default sysdate
	protected Date createDate;
	protected Long modifyBy; // default sysdate
	protected Date modifyDate;
	protected Integer version;
	
	protected OaProductInfo product = new OaProductInfo();
	
	protected User userUse = new User();
	
	
	public OaProductUsed(){}
	
	
	
	/**
	 * 
	 * Returns the id
	 * @return Long
	 * 
	 * @hibernate.id column="product_used_id" generator-class="native" unsaved-value="null"
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * 
	 * Returns the amends
	 * @return Double
	 * 
	 * @hibernate.property length="10" column="amends" not-null="false"
	 * 
	 */
	public Double getAmends() {
		return amends;
	}



	/**
	 * 
	 * Returns the attaint
	 * @return Long
	 * 
	 * @hibernate.property length="10" column="attaint" not-null="false"
	 */
	public Long getAttaint() {
		return attaint;
	}



	/**
	 * 
	 * Returns the playReturnDate
	 * @return Date
	 * 
	 * @hibernate.property column="play_return_date" update="false" insert="true"
	 *                     type="timestamp"
	 */
	public Date getPlayReturnDate() {
		return playReturnDate;
	}



	/**
	 * 
	 * Returns the productId
	 * @return Long
	 * 
	 * @hibernate.property length="20" column="product_id" not-null="false"
	 */
	public Long getProductId() {
		return productId;
	}



	/**
	 * 
	 * Returns the relReturnDate
	 * @return Date
	 * 
	 * @hibernate.property column="rel_return_date" update="false" insert="true"
	 *                     type="timestamp"
	 */
	public Date getRelReturnDate() {
		return relReturnDate;
	}



	/**
	 * 
	 * Returns the returnNum
	 * @return Long
	 * 
	 * @hibernate.property length="20" column="return_num" not-null="false"
	 */
	public Long getReturnNum() {
		return returnNum;
	}



	/**
	 * 
	 * Returns the useDate
	 * @return Date
	 * 
	 * @hibernate.property column="use_date" update="false" insert="true"
	 *                     type="timestamp"
	 */
	public Date getUseDate() {
		return useDate;
	}



	/**
	 * 
	 * Returns the useMan
	 * @return Long
	 * @struts.validator type="required"
	 * @hibernate.property length="20" column="use_man" not-null="false"
	 */
	public Long getUseMan() {
		return useMan;
	}



	/**
	 * 
	 * Returns the useNum
	 * @return Long
	 * 
	 * @hibernate.property length="20" column="use_num" not-null="false"
	 */
	public Long getUseNum() {
		return useNum;
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
	 * 
	 * Returns the product
	 * @return OaProductInfo 
	 * 
	 */
	public OaProductInfo getProduct() {
		return product;
	}




	/**
	 * @hibernate.version
	 */
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 
	 * Returns the userUse
	 * @return User 
	 * 
	 */
	public User getUserUse() {
		return userUse;
	}
	
	

	
	
	/**
	 * @param amends The amends to set.
	 */
	public void setAmends(Double amends) {
		this.amends = amends;
	}



	/**
	 * @param attaint The attaint to set.
	 */
	public void setAttaint(Long attaint) {
		this.attaint = attaint;
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
	 * @param playreturndate The playreturndate to set.
	 */
	public void setPlayReturnDate(Date playReturnDate) {
		this.playReturnDate = playReturnDate;
	}



	/**
	 * @param productid The productid to set.
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}



	/**
	 * @param relreturndate The relreturndate to set.
	 */
	public void setRelReturnDate(Date relReturnDate) {
		this.relReturnDate = relReturnDate;
	}



	/**
	 * @param returnnum The returnnum to set.
	 */
	public void setReturnNum(Long returnNum) {
		this.returnNum = returnNum;
	}



	/**
	 * @param usedate The usedate to set.
	 */
	public void setUseDate(Date useDate) {
		this.useDate = useDate;
	}



	/**
	 * @param useman The useman to set.
	 */
	public void setUseMan(Long useMan) {
		this.useMan = useMan;
	}



	/**
	 * @param usenum The usenum to set.
	 */
	public void setUseNum(Long useNum) {
		this.useNum = useNum;
	}



	/**
	 * @param version The version to set.
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/** 
	 * @param product The product to set.
	 */
	public void setProduct(OaProductInfo product) {
		this.product = product;
	}




	/** 
	 * @param userUse The userUse to set.
	 */
	public void setUserUse(User userUse) {
		this.userUse = userUse;
	}
	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof OaProductUsed)) {
			return false;
		}
		OaProductUsed rhs = (OaProductUsed) object;
		return new EqualsBuilder().append(
				this.product, rhs.product)
				.append(this.returnNum, rhs.returnNum).append(this.useDate,
						rhs.useDate).append(this.relReturnDate,
						rhs.relReturnDate)
				.append(this.productId, rhs.productId).append(this.modifyBy,
						rhs.modifyBy).append(this.amends, rhs.amends).append(
						this.createBy, rhs.createBy).append(this.id, rhs.id)
				.append(this.version, rhs.version).append(this.useNum,
						rhs.useNum).append(this.useMan, rhs.useMan).append(
						this.attaint, rhs.attaint).append(this.playReturnDate,
						rhs.playReturnDate).append(this.modifyDate,
						rhs.modifyDate).append(this.createDate, rhs.createDate)
				.isEquals();
	}



	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(1447463841, 474511159).append(this.product).append(this.returnNum)
				.append(this.useDate).append(this.relReturnDate).append(
						this.productId).append(this.modifyBy).append(
						this.amends).append(this.createBy).append(this.id)
				.append(this.version).append(this.useNum).append(this.useMan)
				.append(this.attaint).append(this.playReturnDate).append(
						this.modifyDate).append(this.createDate).toHashCode();
	}



	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("amends", this.amends).append(
				"useMan", this.useMan).append("modifyBy", this.modifyBy)
				.append("id", this.id).append("modifyDate", this.modifyDate)
				.append("playReturnDate", this.playReturnDate).append(
						"relReturnDate", this.relReturnDate).append("createBy",
						this.createBy).append("version", this.version).append(
						"returnNum", this.returnNum).append("useDate",
						this.useDate).append("attaint", this.attaint).append(
						"useNum", this.useNum).append("productId",
						this.productId).append("createDate", this.createDate)
				.toString();
	}









	
	

	
}
