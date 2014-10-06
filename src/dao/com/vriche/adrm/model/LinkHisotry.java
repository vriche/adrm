/****************************************************************************     
 * Created on 2006-10-13                                                     *    
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
import com.vriche.adrm.model.User;
/**
 * LinkHisotry class
 * 
 * This class is used to 
 * 
 * <p><a href="LinkHisotry.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form  include-all="true"  extends="BaseForm"  import="com.vriche.adrm.order.webapp.form.UserForm"
 * @hibernate.class table="tb_customer_link_hisotry"
 * 
 */
public class LinkHisotry extends BaseObjectWithoutNestedFormValidation {
    
    private static final long serialVersionUID = 3832626162173359411L;
    
    protected Integer linkDate;
    protected String subject; 				  // required
    protected Long linkManId;
    protected String counterpartMan;
    protected String memo;

    
    protected Long id;
    protected Long createBy;				  //default sysdate
    protected Date createDate;					  
    protected Long modifyBy;				  //default sysdate
    protected Date modifyDate;					  
    protected Integer version;
    protected Long customerId;
    
    protected User linkUser = new User();

    
    public LinkHisotry(){};


    /**
     * @hibernate.id column="customer_link_hisotry_id" generator-class="native" unsaved-value="null"
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
     * Returns the linkDate
     * @return Integer
     * 
     * @hibernate.property length="8" column="link_date" not-null="false"
     */
    public Integer getLinkDate() {
        return linkDate;
    }
    /**
     * 
     * Returns the subject
     * @return String
     * @struts.validator type="required"
     * @hibernate.property length="128" column="subject" not-null="true"
     */
    public String getSubject() {
        return subject;
    }
    /**
     * 
     * Returns the linkManId
     * @return Long
     * 
     * @hibernate.property length="20" column="customer_link_man_id" not-null="false"
     */
    public Long getLinkManId() {
        return linkManId;
    }
    /**
     * 
     * Returns the counterpartMan
     * @return String
     * 
     * @hibernate.property length="128" column="counterpart_man" not-null="false"
     */
    public String getCounterpartMan() {
        return counterpartMan;
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
     * Returns the customerId
     * @return Long
     * 
     * @hibernate.property length="20" column="customer_id" not-null="false"
     */
	public Long getCustomerId() {
		return customerId;
	}   
    
    
    
    
    
    /**
     * @param counterpartMan The counterpartMan to set.
     */
    public void setCounterpartMan(String counterpartMan) {
        this.counterpartMan = counterpartMan;
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
     * @param linkDate The linkDate to set.
     */
    public void setLinkDate(Integer linkDate) {
        this.linkDate = linkDate;
    }
    /**
     * @param linkManId The linkManId to set.
     */
    public void setLinkManId(Long linkManId) {
        this.linkManId = linkManId;
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
     * @param subject The subject to set.
     */
    public void setSubject(String subject) {
        this.subject = subject;
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
        if (!(object instanceof LinkHisotry)) {
            return false;
        }
        LinkHisotry rhs = (LinkHisotry) object;
        return new EqualsBuilder().append(
                this.memo, rhs.memo).append(this.counterpartMan,
                rhs.counterpartMan).append(this.linkManId, rhs.linkManId)
                .append(this.modifyBy, rhs.modifyBy).append(this.linkDate,
                        rhs.linkDate).append(this.modifyDate, rhs.modifyDate)
                .append(this.createDate, rhs.createDate).append(this.subject,
                        rhs.subject).append(this.createBy, rhs.createBy)
                .append(this.id, rhs.id).append(this.version, rhs.version)
                .isEquals();
    }
    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder(-1134252161, -1892771229).append(this.memo).append(this.counterpartMan)
                .append(this.linkManId).append(this.modifyBy).append(
                        this.linkDate).append(this.modifyDate).append(
                        this.createDate).append(this.subject).append(
                        this.createBy).append(this.id).append(this.version)
                .toHashCode();
    }
    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return new ToStringBuilder(this).append("subject", this.subject)
                .append("linkManId", this.linkManId).append("modifyBy",
                        this.modifyBy).append("id", this.id).append("version",
                        this.version).append("modifyDate", this.modifyDate)
                .append("linkDate", this.linkDate).append("counterpartMan",
                        this.counterpartMan).append("memo", this.memo).append(
                        "createBy", this.createBy).append("createDate",
                        this.createDate).toString();
    }


	public User getLinkUser() {
		return linkUser;
	}


	public void setLinkUser(User linkUser) {
		this.linkUser = linkUser;
	}



	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
}
