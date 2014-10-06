/****************************************************************************     
 * Created on 2006-11-24                                                     *    
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
 * MediaOrg class
 * 
 * This class is used to 
 * 
 * <p><a href="MediaOrg.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_ad_resource_mediaorg"
 * 
 */
public class MediaOrg extends BaseObjectWithoutNestedFormValidation {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Long id;
    protected String name;			         // required; unique
    protected String value;			         
    protected String memo;
    protected Integer enable;
    
    protected Long createBy;				  //default sysdate
    protected Date createDate;					  
    protected Long modifyBy;				  //default sysdate
    protected Date modifyDate;					  
    protected Integer version;
    
    
	private Long orgId;
	private Long orgAdminId;
	private Org org;
    
    public Org getOrg() {
		return org;
	}
	public void setOrg(Org org) {
		this.org = org;
	}
	public Long getOrgAdminId() {
		return orgAdminId;
	}
	public void setOrgAdminId(Long orgAdminId) {
		this.orgAdminId = orgAdminId;
	}
	public Long getOrgId() {
		return orgId;
	}
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
	/**
     * @hibernate.id column="ad_resource_mediaorg_id" generator-class="native" unsaved-value="null"
     */
    public Long getId() {
        return id;
    }
    /**
     * 
     * Returns the name
     * @return String
     * @struts.validator type="required"
     * @hibernate.property length="128" column="name" not-null="false"
     */
    public String getName() {
        return name;
    }
    /**
     * 
     * Returns the value
     * @return String
     * 
     * @hibernate.property length="5" column="value" not-null="false"
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
     * @return Integer
     * 
     * @hibernate.property length="1" column="enable" not-null="false"
     */
    public Integer getEnable() {
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
    public void setEnable(Integer enable) {
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
    /**
     * @see java.lang.Object#equals(Object)
     */
    public boolean equals(Object object) {
        if (!(object instanceof MediaOrg)) {
            return false;
        }
        MediaOrg rhs = (MediaOrg) object;
        return new EqualsBuilder().append(this.memo, rhs.memo).append(
                this.value, rhs.value).append(this.modifyBy, rhs.modifyBy)
                .append(this.modifyDate, rhs.modifyDate).append(
                        this.createDate, rhs.createDate).append(this.createBy,
                        rhs.createBy).append(this.name, rhs.name).append(
                        this.id, rhs.id).append(this.version, rhs.version)
                .append(this.enable, rhs.enable).isEquals();
    }
    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder(-403496431, -1989530243).append(this.memo)
                .append(this.value).append(this.modifyBy).append(
                        this.modifyDate).append(this.createDate).append(
                        this.createBy).append(this.name).append(this.id)
                .append(this.version).append(this.enable).toHashCode();
    }
    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return new ToStringBuilder(this).append("name", this.name).append(
                "modifyBy", this.modifyBy).append("id", this.id).append(
                "version", this.version).append("modifyDate", this.modifyDate)
                .append("value", this.value).append("enable", this.enable)
                .append("memo", this.memo).append("createBy", this.createBy)
                .append("createDate", this.createDate).toString();
    }
}
