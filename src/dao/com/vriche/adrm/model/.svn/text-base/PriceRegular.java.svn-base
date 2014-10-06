/****************************************************************************     
 * Created on 2006-10-15                                                     *    
 *                                                               			*
 * @author <a href="mailto:hongxilin@yahoo.com.cn">hongxi</a>               *
 *         Updated by hongxi (hongxilin@yahoo.com.cn)                       *
 *                                                                          *
 * @version  Vision:1.0														*
 * 																			*
 ***************************************************************************/
package com.vriche.adrm.model;

import java.util.Date;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

import com.vriche.adrm.model.BaseObject;
/**
 * PriceRegular class
 * 
 * This class is used to 
 * 
 * <p><a href="PriceRegular.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_ad_resource_price_regular"
 * 
 */
public class PriceRegular extends BaseObject {
	private static final long serialVersionUID = -1955627947364189959L;
	protected Long id;
    protected String name;					  // required; unique
    protected Double multiBase;
    protected Double multiply;
    protected Double otherBase;
    protected String regularExpr;
    
    protected Long createBy;				  //default sysdate
    protected Date createDate;					  
    protected Long modifyBy;				  //default sysdate
    protected Date modifyDate;					  
    protected Integer version;
    protected String memo;
    
    
    public PriceRegular(){};
    public PriceRegular(String name) {
        this.name = name;
    }

    /**
     * @hibernate.id column="ad_resource_price_regular_id" generator-class="native" unsaved-value="null"
     */
    public Long getId() {
        return id;
    }
    /**
     * 
     * Returns the name
     * @return String
     * @struts.validator type="required"
     * @hibernate.property length="32" column="account_obj" not-null="true" unique="true"
     */
    public String getName() {
        return name;
    }
    /**
     * 
     * Returns the multiBase
     * @return Double
     * 
     * @hibernate.property length="32" column="multi_base" not-null="true"
     */
    public Double getMultiBase() {
        return multiBase;
    }
    /**
     * 
     * Returns the multiply
     * @return Double
     * 
     * @hibernate.property length="5" column="multiply" not-null="false"
     */
    public Double getMultiply() {
        return multiply;
    }
    /**
     * 
     * Returns the otherBase
     * @return String
     * 
     * @hibernate.property length="32" column="other_base" not-null="true"
     */
    public Double getOtherBase() {
        return otherBase;
    }
    /**
     * 
     * Returns the regularExpr
     * @return String
     * @struts.validator type="required"
     * @hibernate.property length="256" column="regular_expr" not-null="false"
     */
    public String getRegularExpr() {
        return regularExpr;
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
     * Returns the memo
     * @return String
     * 
     * @hibernate.property length="128" column="memo" not-null="false"
     */
    public String getMemo() {
        return memo;
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
     * @param multiBase The multiBase to set.
     */
    public void setMultiBase(Double multiBase) {
        this.multiBase = multiBase;
    }
    /**
     * @param multiply The multiply to set.
     */
    public void setMultiply(Double multiply) {
        this.multiply = multiply;
    }
    /**
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @param otherBase The otherBase to set.
     */
    public void setOtherBase(Double otherBase) {
        this.otherBase = otherBase;
    }
    /**
     * @param regularExpr The regularExpr to set.
     */
    public void setRegularExpr(String regularExpr) {
        this.regularExpr = regularExpr;
    }
    /**
     * @param version The version to set.
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
   
    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder(1727601807, -1343100947).append(this.memo).append(this.modifyBy)
                .append(this.otherBase).append(this.multiply).append(
                        this.modifyDate).append(this.createDate).append(
                        this.regularExpr).append(this.multiBase).append(
                        this.createBy).append(this.name).append(this.id)
                .append(this.version).toHashCode();
    }
    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return new ToStringBuilder(this).append("name", this.name).append(
                "modifyBy", this.modifyBy).append("id", this.id).append(
                "otherBase", this.otherBase).append("version", this.version)
                .append("modifyDate", this.modifyDate).append("regularExpr",
                        this.regularExpr).append("multiBase", this.multiBase)
                .append("memo", this.memo).append("multiply", this.multiply)
                .append("createBy", this.createBy).append("createDate",
                        this.createDate).toString();
    }
    /**
     * @see java.lang.Object#equals(Object)
     */
    public boolean equals(Object object) {
        if (!(object instanceof PriceRegular)) {
            return false;
        }
        PriceRegular rhs = (PriceRegular) object;
        return new EqualsBuilder().append(
                this.memo, rhs.memo).append(this.modifyBy, rhs.modifyBy)
                .append(this.otherBase, rhs.otherBase).append(this.multiply,
                        rhs.multiply).append(this.modifyDate, rhs.modifyDate)
                .append(this.createDate, rhs.createDate).append(
                        this.regularExpr, rhs.regularExpr).append(
                        this.multiBase, rhs.multiBase).append(this.createBy,
                        rhs.createBy).append(this.name, rhs.name).append(
                        this.id, rhs.id).append(this.version, rhs.version)
                .isEquals();
    }
}
