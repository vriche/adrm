/****************************************************************************     
 * Created on 2006-10-14                                                     *    
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
 * Category class
 * 
 * This class is used to 
 * 
 * <p><a href="Category.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_customer_category"
 * 
 */
public class Category extends BaseObject{
    private static final long serialVersionUID = 3832626162173359411L;
    protected Long id;
    protected String categoryName;					  // required
    protected String parentId;
    protected Integer treeLevel;
    protected Integer displayNo;
    protected String categoryCode;
    protected Integer adResourcePriceType;			  //0 正常代理价格 1 季节性代理 2 销售价格 3 刊例价 4 最低销售价格
    protected String memo;
    
    protected Long createBy;						  //default sysdate
    protected Date createDate;					  
    protected Long modifyBy;						  //default sysdate
    protected Date modifyDate;					  
    protected Integer version;
    protected String loginUser;
    
    protected String orgId;
    
    public Category(){};
    
    public Category(String categoryName){
        this.categoryName = categoryName;
    }

    /**
     * @hibernate.id column="customer_category_id" generator-class="native" unsaved-value="null"
     */
    public Long getId() {
        return id;
    }
    /**
     * 
     * Returns the adResourcePriceType
     * @return Integer
     * 
     * @hibernate.property length="2" column="ad_resource_price_type" not-null="false"
     */
    public Integer getAdResourcePriceType() {
        return adResourcePriceType;
    }
    /**
     * 
     * Returns the categoryCode
     * @return String
     * 
     * @hibernate.property length="8" column="category_code" not-null="true"
     */
    public String getCategoryCode() {
        return categoryCode;
    }
    /**
     * 
     * Returns the categoryName
     * @return String
     * @struts.validator type="required"
     * @hibernate.property length="128" column="category_name" not-null="true"
     */
    public String getCategoryName() {
        return categoryName;
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
     * Returns the parentId
     * @return String
     * 
     * @hibernate.property length="32" column="parent_id" not-null="false"
     */
    public String getParentId() {
        return parentId;
    }
    /**
     * 
     * Returns the treeLevel
     * @return Integer
     * 
     * @hibernate.property length="5" column="tree_level" not-null="false"
     */
    public Integer getTreeLevel() {
        return treeLevel;
    }
    /**
     * 
     * Returns the displayNo
     * @return Integer
     * 
     * @hibernate.property length="16" column="display_no" not-null="true"
     */
    public Integer getDisplayNo() {
        return displayNo;
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
     * @param adResourcePriceType The adResourcePriceType to set.
     */
    public void setAdResourcePriceType(Integer adResourcePriceType) {
        this.adResourcePriceType = adResourcePriceType;
    }
    /**
     * @param categoryCode The categoryCode to set.
     */
    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }
    /**
     * @param categoryName The categoryName to set.
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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
     * @param displayNo The displayNo to set.
     */
    public void setDisplayNo(Integer displayNo) {
        this.displayNo = displayNo;
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
     * @param parentId The parentId to set.
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
    /**
     * @param treeLevel The treeLevel to set.
     */
    public void setTreeLevel(Integer treeLevel) {
        this.treeLevel = treeLevel;
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
        if (!(object instanceof Category)) {
            return false;
        }
        Category rhs = (Category) object;
        return new EqualsBuilder().append(
                this.treeLevel, rhs.treeLevel).append(this.memo, rhs.memo)
                .append(this.categoryCode, rhs.categoryCode).append(
                        this.parentId, rhs.parentId).append(this.modifyBy,
                        rhs.modifyBy).append(this.categoryName,
                        rhs.categoryName).append(this.adResourcePriceType,
                        rhs.adResourcePriceType).append(this.modifyDate,
                        rhs.modifyDate).append(this.createDate, rhs.createDate)
                .append(this.createBy, rhs.createBy).append(this.id, rhs.id)
                .append(this.version, rhs.version).append(this.displayNo,
                        rhs.displayNo).isEquals();
    }
    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder(-1004730563, 559293799).append(this.treeLevel).append(this.memo)
                .append(this.categoryCode).append(this.parentId).append(
                        this.modifyBy).append(this.categoryName).append(
                        this.adResourcePriceType).append(this.modifyDate)
                .append(this.createDate).append(this.createBy).append(this.id)
                .append(this.version).append(this.displayNo).toHashCode();
    }
    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return new ToStringBuilder(this).append("modifyBy", this.modifyBy)
                .append("categoryName", this.categoryName)
                .append("id", this.id).append("version", this.version).append(
                        "modifyDate", this.modifyDate).append("parentId",
                        this.parentId).append("adResourcePriceType",
                        this.adResourcePriceType).append("displayNo",
                        this.displayNo).append("categoryCode",
                        this.categoryCode).append("treeLevel", this.treeLevel)
                .append("memo", this.memo).append("createBy", this.createBy)
                .append("createDate", this.createDate).toString();
    }

	public String getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
}
