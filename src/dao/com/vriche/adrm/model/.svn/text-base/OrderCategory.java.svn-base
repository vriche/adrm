/****************************************************************************     
 * Created on 2006-10-16                                                     *    
 *                                                               			*
 * @author <a href="mailto:hongxilin@yahoo.com.cn">hongxi</a>               *
 *         Updated by hongxi (hongxilin@yahoo.com.cn)                       *
 *                                                                          *
 * @version  Vision:1.0														*
 * 																			*
 ***************************************************************************/
package com.vriche.adrm.model;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
/**
 * OrderCategory class
 * 
 * This class is used to 
 * 
 * <p><a href="OrderCategory.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_order_category"
 * 
 */
public class OrderCategory extends BaseObject {

	private static final long serialVersionUID = -3008509796678899180L;
	protected String name;			 // required
    protected String parentId;
    protected Integer nodeLevel;
    protected Integer displayNo;
    protected String nodePath;
    
    protected String value;			
    protected Integer calculateAuto;

    protected Long id;
    protected Long createBy;				  //default sysdate
    protected Date createDate;					  
    protected Long modifyBy;				  //default sysdate
    protected Date modifyDate;					  
    protected Integer version;
    
	private Long orgId;
	private Long orgAdminId;
	private Org org;
	
	
	private List fitterOrderSubCatesList;
    
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
	public OrderCategory(){};
    public OrderCategory(String name) {
        this.name = name;
    }


    /**
     * @hibernate.id column="order_category_id" generator-class="native" unsaved-value="null"
     */
    public Long getId() {
        return id;
    }
    /**
     * 
     * Returns the name
     * @return String
     * @struts.validator type="required"
     * @hibernate.property column="name" length="128" not-null="false"
     */
    public String getName() {
        return name;
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
     * Returns the nodeLevel
     * @return Integer
     * 
     * @hibernate.property length="5" column="node_level" not-null="false"
     */
    public Integer getNodeLevel() {
        return nodeLevel;
    }
    
    /**
     * 
     * Returns the nodePath
     * @return String
     * 
     * @hibernate.property length="128" column="node_path" not-null="false"
     */
    public String getNodePath() {
        return nodePath;
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
     * Returns the value
     * @return String
     * 
     * @hibernate.property length="2" column="value" not-null="true"
     */
    public String getValue() {
        return value;
    }
    /**
     * 
     * Returns the calculateAuto
     * @return Integer
     * 
     * @hibernate.property length="2" column="calculate_auto" not-null="false"
     */
    public Integer getCalculateAuto() {
        return calculateAuto;
    }
    

    /**
     * 
     * Returns the displayNo
     * @return Integer
     * 
     * @hibernate.property length="128" column="displayNo" not-null="false"
     */
    public Integer getDisplayNo() {
        return displayNo;
    }
    
    
    /**
     * @hibernate.version
     */
    public Integer getVersion() {
        return version;
    }

    

    
    
    /**
     * @param calculateAuto The calculateAuto to set.
     */
    public void setCalculateAuto(Integer calculateAuto) {
        this.calculateAuto = calculateAuto;
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
     * @param nodeLevel The nodeLevel to set.
     */
    public void setNodeLevel(Integer nodeLevel) {
        this.nodeLevel = nodeLevel;
    }
    /**
     * @param nodePath The nodePath to set.
     */
    public void setNodePath(String nodePath) {
        this.nodePath = nodePath;
    }
    /**
     * @param parentId The parentId to set.
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
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
        if (!(object instanceof OrderCategory)) {
            return false;
        }
        OrderCategory rhs = (OrderCategory) object;
        return new EqualsBuilder().append(
                this.value, rhs.value).append(this.parentId, rhs.parentId)
                .append(this.modifyBy, rhs.modifyBy).append(this.nodePath,
                        rhs.nodePath).append(this.modifyDate, rhs.modifyDate)
                .append(this.createDate, rhs.createDate).append(this.nodeLevel,
                        rhs.nodeLevel).append(this.calculateAuto,
                        rhs.calculateAuto).append(this.createBy, rhs.createBy)
                .append(this.name, rhs.name).append(this.id, rhs.id).append(
                        this.version, rhs.version).append(this.displayNo,
                        rhs.displayNo).isEquals();
    }
    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder(1779222483, 1718634759).append(this.value).append(this.parentId)
                .append(this.modifyBy).append(this.nodePath).append(
                        this.modifyDate).append(this.createDate).append(
                        this.nodeLevel).append(this.calculateAuto).append(
                        this.createBy).append(this.name).append(this.id)
                .append(this.version).append(this.displayNo).toHashCode();
    }
    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return new ToStringBuilder(this).append("nodeLevel", this.nodeLevel)
                .append("nodePath", this.nodePath).append("name", this.name)
                .append("modifyBy", this.modifyBy).append("id", this.id)
                .append("version", this.version).append("value", this.value)
                .append("modifyDate", this.modifyDate).append("parentId",
                        this.parentId).append("displayNo", this.displayNo)
                .append("calculateAuto", this.calculateAuto).append("createBy",
                        this.createBy).append("createDate", this.createDate)
                .toString();
    }
	public List getFitterOrderSubCatesList() {
		return fitterOrderSubCatesList;
	}
	public void setFitterOrderSubCatesList(List fitterOrderSubCatesList) {
		this.fitterOrderSubCatesList = fitterOrderSubCatesList;
	}
}
