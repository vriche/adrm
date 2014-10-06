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


import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.vriche.adrm.model.BaseObject;
/**
 * Specific class
 * 
 * This class is used to 
 * 
 * <p><a href="Specific.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_ad_resource_specific"
 * 
 */
public class Specific extends BaseObject {
    private static final long serialVersionUID = 3832626162173359411L;
    
    protected Long id;
    protected String name;					  // required; unique
    protected String position;				  // required; unique
    protected Double overRate;
    protected Long createBy;				  //default sysdate
    protected Date createDate;					  
    protected Long modifyBy;				  //default sysdate
    protected Date modifyDate;					  
    protected Integer version;
    protected String memo;
    
    
    public Specific(){};
    public Specific(String name) {
        this.name = name;
    }

    /**
     * @hibernate.id column="ad_resource_specific_id" generator-class="native" unsaved-value="null"
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
     * @hibernate.property length="256" column="memo" not-null="false"
     */
    public String getMemo() {
        return memo;
    }
    /**
     * 
     * Returns the position
     * @return String
     * 
     * @hibernate.property length="3" column="position" not-null="true" unique="true"
     */
    public String getPosition() {
        return position;
    }
    /**
     * 
     * Returns the name
     * @return String
      * @struts.validator type="required"
     * @hibernate.property length="128" column="name" not-null="true" unique="true"
     */
    public String getName() {
        return name;
    }
    /**
     * 
     * Returns the overRate
     * @return Double
     * 
     * @hibernate.property length="12" column="over_rate" not-null="false"
     */
    public Double getOverRate() {
        return overRate;
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
     * @param overRate The overRate to set.
     */
    public void setOverRate(Double overRate) {
        this.overRate = overRate;
    }
    /**
     * @param position The position to set.
     */
    public void setPosition(String position) {
        this.position = position;
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
        if (!(object instanceof Specific)) {
            return false;
        }
        Specific rhs = (Specific) object;
        return new EqualsBuilder().append(this.memo, rhs.memo).append(
                this.position, rhs.position)
                .append(this.modifyBy, rhs.modifyBy).append(this.modifyDate,
                        rhs.modifyDate).append(this.createDate, rhs.createDate)
                .append(this.createBy, rhs.createBy)
                .append(this.name, rhs.name)
                .append(this.overRate, rhs.overRate).append(this.id, rhs.id)
                .append(this.version, rhs.version).isEquals();
    }
    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder(243429761, -70449317).append(this.memo)
                .append(this.position).append(this.modifyBy).append(
                        this.modifyDate).append(this.createDate).append(
                        this.createBy).append(this.name).append(this.overRate)
                .append(this.id).append(this.version).toHashCode();
    }
    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return new ToStringBuilder(this).append("overRate", this.overRate)
                .append("name", this.name).append("modifyBy", this.modifyBy)
                .append("id", this.id).append("version", this.version).append(
                        "modifyDate", this.modifyDate)
                .append("memo", this.memo).append("position", this.position)
                .append("createBy", this.createBy).append("createDate",
                        this.createDate).toString();
    }
}
