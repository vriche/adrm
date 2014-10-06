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
 * PublishMemo class
 * 
 * This class is used to 
 * 
 * <p><a href="PublishMemo.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_adver_publish_memo"
 * 
 */
public class PublishMemo extends BaseObject {
	private static final long serialVersionUID = 3298403962294485693L;
	protected Long id;
    protected String name;
    protected Integer value;
    protected Long createBy;				  //default sysdate
    protected Date createDate;					  
    protected Long modifyBy;				  //default sysdate
    protected Date modifyDate;					  
    protected Integer version;
    
    public PublishMemo(){};
    public PublishMemo(String name) {
        this.name = name;
    }

    /**
     * @hibernate.id column="adver_publish_memo_id" generator-class="native" unsaved-value="null"
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
     * Returns the value
     * @return Integer
     * 
     * @hibernate.property length="3" column="value" not-null="false"
     */
	public Integer getValue() {
		return value;
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

	public void setValue(Integer value) {
		this.value = value;
	}
    /**
     * @see java.lang.Object#equals(Object)
     */
    public boolean equals(Object object) {
        if (!(object instanceof PublishMemo)) {
            return false;
        }
        PublishMemo rhs = (PublishMemo) object;
        return new EqualsBuilder().append(
                this.modifyBy, rhs.modifyBy).append(this.modifyDate,
                rhs.modifyDate).append(this.createDate, rhs.createDate).append(
                this.createBy, rhs.createBy).append(this.name, rhs.name)
                .append(this.id, rhs.id).append(this.version, rhs.version)
                .isEquals();
    }
    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder(1283921037, 119566977).append(this.modifyBy).append(this.modifyDate)
                .append(this.createDate).append(this.createBy)
                .append(this.name).append(this.id).append(this.version)
                .toHashCode();
    }
    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return new ToStringBuilder(this).append("name", this.name).append(
                "modifyBy", this.modifyBy).append("id", this.id).append(
                "version", this.version).append("modifyDate", this.modifyDate)
                .append("createBy", this.createBy).append("createDate",
                        this.createDate).toString();
    }

}
