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
 * Brand class
 * 
 * This class is used to 
 * 
 * <p><a href="Brand.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_adver_product_brand"
 * 
 */
public class Brand extends BaseObject {

	private static final long serialVersionUID = 5882994985532469241L;
	protected Long id;
    protected String name;
    protected Long createBy;				  //default sysdate
    protected Date createDate;					  
    protected Long modifyBy;				  //default sysdate
    protected Date modifyDate;					  
    protected Integer version;
    protected String memo;
    protected Boolean enable;
    protected String helpCode;
    protected Long parentId;
    
    
	public Brand(){};
    public Brand(String name) {
        this.name = name;
    }

    /**
     * @hibernate.id column="adver_product_brand_id" generator-class="native" unsaved-value="null"
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
     * Returns the enable
     * @return Integer
     * 
     * @hibernate.property  column="enable" not-null="false"   type="yes_no"
     */
    public Boolean getEnable() {
        return enable;
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
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
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
        if (!(object instanceof Brand)) {
            return false;
        }
        Brand rhs = (Brand) object;
        return new EqualsBuilder().append(
                this.memo, rhs.memo).append(this.modifyBy, rhs.modifyBy)
                .append(this.modifyDate, rhs.modifyDate).append(
                        this.createDate, rhs.createDate).append(this.createBy,
                        rhs.createBy).append(this.name, rhs.name).append(
                        this.id, rhs.id).append(this.enable, rhs.enable)
                .append(this.version, rhs.version).isEquals();
    }
    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder(1612887645, -2099495211).append(this.memo).append(this.modifyBy)
                .append(this.modifyDate).append(this.createDate).append(
                        this.createBy).append(this.name).append(this.id)
                .append(this.enable).append(this.version).toHashCode();
    }
    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return new ToStringBuilder(this).append("name", this.name).append(
                "modifyBy", this.modifyBy).append("id", this.id).append(
                "version", this.version).append("modifyDate", this.modifyDate)
                .append("enable", this.enable).append("memo", this.memo)
                .append("createBy", this.createBy).append("createDate",
                        this.createDate).toString();
    }
    
    public String getHelpCode() {
		return helpCode;
	}
	public void setHelpCode(String helpCode) {
		this.helpCode = helpCode;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
}
