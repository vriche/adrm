/****************************************************************************     
 * Created on 2006-11-17                                                     *    
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

import com.vriche.adrm.model.BaseObject;

/**
 * PriceType class
 * 
 * This class is used to 
 * 
 * <p><a href="PriceType.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_ad_resource_price_type"
 * 
 */

public class PriceType extends BaseObject {
    
	
	private static final long serialVersionUID = 1255968575059804082L;
	
	protected Long id;
    protected String priceTypeName;			 // required; unique
    protected String value;			         // required; unique
    protected String memo;
    protected Boolean enable;
    
    protected Long createBy;				  //default sysdate
    protected Date createDate;					  
    protected Long modifyBy;				  //default sysdate
    protected Date modifyDate;					  
    protected Integer version;
    
    
  
    /**
     * @hibernate.id column="ad_resource_price_type_id" generator-class="native" unsaved-value="null"
     */
    public Long getId() {
        return id;
    }
    /**
     * 
     * Returns the priceTypeName
     * @return String
     * @struts.validator type="required"
     * @hibernate.property length="128" column="price_type_name" not-null="true" unique="true"
     */
    public String getPriceTypeName() {
        return priceTypeName;
    }
    /**
     * 
     * Returns the value
     * @return String
     * 
     * @hibernate.property length="5" column="value" not-null="true" unique="true"
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
     * 
     * Returns the enable
     * @return Boolean
     * 
     * @hibernate.property   column="enable" not-null="true" type="yes_no"
     */
    public Boolean getEnable() {
        return enable;
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
     * @param enable The enable to set.
     */
    public void setEnable(Boolean enable) {
        this.enable = enable;
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
     * @param priceTypeName The priceTypeName to set.
     */
    public void setPriceTypeName(String priceTypeName) {
        this.priceTypeName = priceTypeName;
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
    /**
     * @see java.lang.Object#equals(Object)
     */
    public boolean equals(Object object) {
        if (!(object instanceof PriceType)) {
            return false;
        }
        PriceType rhs = (PriceType) object;
        return new EqualsBuilder().append(this.memo, rhs.memo).append(
                this.value, rhs.value).append(this.modifyBy, rhs.modifyBy)
                .append(this.modifyDate, rhs.modifyDate).append(
                        this.createDate, rhs.createDate).append(this.createBy,
                        rhs.createBy).append(this.priceTypeName,
                        rhs.priceTypeName).append(this.id, rhs.id).append(
                        this.version, rhs.version).append(this.enable,
                        rhs.enable).isEquals();
    }
    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder(1924828363, -1654069207).append(this.memo)
                .append(this.value).append(this.modifyBy).append(
                        this.modifyDate).append(this.createDate).append(
                        this.createBy).append(this.priceTypeName).append(
                        this.id).append(this.version).append(this.enable)
                .toHashCode();
    }
    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return new ToStringBuilder(this).append("modifyBy", this.modifyBy)
                .append("id", this.id).append("version", this.version).append(
                        "modifyDate", this.modifyDate).append("value",
                        this.value).append("enable", this.enable).append(
                        "priceTypeName", this.priceTypeName).append("memo",
                        this.memo).append("createBy", this.createBy).append(
                        "createDate", this.createDate).toString();
    }
}
