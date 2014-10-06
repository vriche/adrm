/****************************************************************************     
 * Created on 2006-11-22                                                     *    
 *                                                               			*
 * @author <a href="mailto:hongxilin@yahoo.com.cn">hongxi</a>               *
 *         Updated by hongxi (hongxilin@yahoo.com.cn)                       *
 *                                                                          *
 * @version  Vision:1.0														*
 * 																			*
 ***************************************************************************/
package com.vriche.adrm.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.vriche.adrm.model.BaseObject;

/**
 * CustomerAddress class
 * 
 * This class is used to 
 * 
 * <p><a href="CustomerAddress.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_customer_address"
 * 
 */
public class CustomerAddress extends BaseObjectWithoutNestedFormValidation implements Serializable{
   
	private static final long serialVersionUID = 8959890759241663750L;
	protected Long id;
    protected String addressType;               
    protected Long customerId;                 // required
    protected String address;
    protected String city;
    protected Long province;
    protected String country;
    protected String postalCode;
    
    protected Long createBy;				  //default sysdate
    protected Date createDate;					  
    protected Long modifyBy;				  //default sysdate
    protected Date modifyDate;					  
    protected Integer version;
    
    protected OaAreaCity oaAreaCity;
    
    
    /**
     * @hibernate.id column="customer_address_id" generator-class="native" unsaved-value="null"
     */
    public Long getId() {
        return id;
    }
    /**
     * 
     * Returns the customerId
     * @return Long
     * @struts.validator type="required"
     * @hibernate.property length="20" column="customer_id" not-null="false"
     */
    public Long getCustomerId() {
        return customerId;
    }
    /**
     * 
     * Returns the addressType
     * @return String
     * 
     * @hibernate.property length="128" column="addressType" not-null="false"
     */
    public String getAddressType() {
        return addressType;
    }
    /**
     * @hibernate.property column="address" not-null="false" length="150"
     */
    public String getAddress() {
        return address;
    }

    /**
     * @struts.validator type="required"
     * @hibernate.property column="city" not-null="true" length="50"
     */
    public String getCity() {
        return city;
    }

    /**
     * @struts.validator type="required"
     * @hibernate.property column="province" length="20"
     */
    public Long getProvince() {
        return province;
    }

    /**
     * @struts.validator type="required"
     * @hibernate.property column="country" length="100"
     */
    public String getCountry() {
        return country;
    }

    /**
     * @struts.validator type="required"
     * @struts.validator type="mask" msgkey="errors.zip"
     * @struts.validator-var name="mask" value="${zip}"
     * @hibernate.property column="postal_code" not-null="true" length="15"
     */
    public String getPostalCode() {
        return postalCode;
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
     * @param id The id to set.
     */
    public void setId(Long id) {
        this.id = id;
    }  
    /**
     * @param customerId The customerId to set.
     */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    /**
     * @param addressType The addressType to set.
     */
    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setProvince(Long province) {
        this.province = province;
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
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof CustomerAddress)) {
			return false;
		}
		CustomerAddress rhs = (CustomerAddress) object;
		return new EqualsBuilder().append(this.postalCode, rhs.postalCode)
				.append(this.country, rhs.country).append(this.modifyBy,
						rhs.modifyBy).append(this.address, rhs.address).append(
						this.province, rhs.province).append(this.addressType,
						rhs.addressType)
				.append(this.modifyDate, rhs.modifyDate).append(
						this.createDate, rhs.createDate).append(this.createBy,
						rhs.createBy).append(this.city, rhs.city).append(
						this.id, rhs.id).append(this.version, rhs.version)
				.append(this.customerId, rhs.customerId).isEquals();
	}
	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-1979577307, 387092961).append(
				this.postalCode).append(this.country).append(this.modifyBy)
				.append(this.address).append(this.province).append(
						this.addressType).append(this.modifyDate).append(
						this.createDate).append(this.createBy)
				.append(this.city).append(this.id).append(this.version).append(
						this.customerId).toHashCode();
	}
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("modifyBy", this.modifyBy)
				.append("id", this.id).append("version", this.version).append(
						"modifyDate", this.modifyDate).append("customerId",
						this.customerId).append("country", this.country)
				.append("address", this.address).append("createBy",
						this.createBy).append("province", this.province)
				.append("addressType", this.addressType).append("createDate",
						this.createDate).append("postalCode", this.postalCode)
				.append("city", this.city).toString();
	}
	public OaAreaCity getOaAreaCity() {
		return oaAreaCity;
	}
	public void setOaAreaCity(OaAreaCity oaAreaCity) {
		this.oaAreaCity = oaAreaCity;
	}
}
