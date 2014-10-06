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

/**
 * CarrierType class
 * 
 * This class is used to 
 * 
 * <p><a href="CarrierType.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_ad_resource_carrier_type"
 * 
 * 
 */
public class CarrierType extends BaseObjectWithoutNestedFormValidation {
    /**
	 * 
	 */
	private static final long serialVersionUID = -138333527487873917L;
	protected Long id;
    protected String name;			         // required; unique	         
    protected String memo;
    protected Integer enable;
    
    protected Long parentId;
    protected Integer nodeLevel;
    protected Integer displayNo;
    protected String nodePath;
    
    protected Long createBy;				  //default sysdate
    protected Date createDate;					  
    protected Long modifyBy;				  //default sysdate
    protected Date modifyDate;					  
    protected Integer version;
    
	private Long orgId;
	private Long orgAdminId;
	private Org org;
	
	protected String loginUser;
	
	protected Integer fitterCarrier;
	
	protected Integer isFineRes;

    
    /**
     * @hibernate.id column="ad_resource_carrier_type_id" generator-class="native" unsaved-value="null"
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
     * Returns the carrierName
     * @return String
     * @struts.validator type="required"
     * @hibernate.property length="128" column="name" not-null="true"
     */
    public String getName() {
        return name;
    }
   
    /**
     * 
     * Returns the parentId
     * @return Long
     * 
     * @hibernate.property length="128" column="parent_id" not-null="false"
     */
    public Long getParentId() {
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
     * Returns the displayNo
     * @return Integer
     * 
     * @hibernate.property length="16" column="display_no" not-null="false"
     */
    public Integer getDisplayNo() {
        return displayNo;
    }
    /**
     * 
     * Returns the nodePath
     * @return String
     * 
     * @hibernate.property length="256" column="nodePath" not-null="false"
     */
    public String getNodePath() {
        return nodePath;
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
     * @param displayNo The displayNo to set.
     */
    public void setDisplayNo(Integer displayNo) {
        this.displayNo = displayNo;
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
    public void setParentId(Long parentId) {
        this.parentId = parentId;
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
        if (!(object instanceof CarrierType)) {
            return false;
        }
        CarrierType rhs = (CarrierType) object;
        return new EqualsBuilder().append(this.memo, rhs.memo).append(
                this.parentId, rhs.parentId)
                .append(this.modifyBy, rhs.modifyBy).append(this.nodePath,
                        rhs.nodePath).append(this.modifyDate, rhs.modifyDate)
                .append(this.createDate, rhs.createDate).append(this.nodeLevel,
                        rhs.nodeLevel).append(this.createBy, rhs.createBy)
                .append(this.name, rhs.name).append(this.id, rhs.id).append(
                        this.version, rhs.version).append(this.displayNo,
                        rhs.displayNo).append(this.enable, rhs.enable)
                .isEquals();
    }
    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder(-1044011643, 401879939).append(this.memo)
                .append(this.parentId).append(this.modifyBy).append(
                        this.nodePath).append(this.modifyDate).append(
                        this.createDate).append(this.nodeLevel).append(
                        this.createBy).append(this.name).append(this.id)
                .append(this.version).append(this.displayNo)
                .append(this.enable).toHashCode();
    }
    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return new ToStringBuilder(this).append("nodeLevel", this.nodeLevel)
                .append("nodePath", this.nodePath).append("name", this.name)
                .append("modifyBy", this.modifyBy).append("id", this.id)
                .append("version", this.version).append("modifyDate",
                        this.modifyDate).append("parentId", this.parentId)
                .append("enable", this.enable).append("displayNo",
                        this.displayNo).append("memo", this.memo).append(
                        "createBy", this.createBy).append("createDate",
                        this.createDate).toString();
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
	public Org getOrg() {
		return org;
	}
	public void setOrg(Org org) {
		this.org = org;
	}
	public Integer getFitterCarrier() {
		return fitterCarrier;
	}
	public void setFitterCarrier(Integer fitterCarrier) {
		this.fitterCarrier = fitterCarrier;
	}
	public String getLoginUser() {
		return loginUser;
	}
	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}
	public Integer getIsFineRes() {
		return isFineRes;
	}
	public void setIsFineRes(Integer isFineRes) {
		this.isFineRes = isFineRes;
	}
}
