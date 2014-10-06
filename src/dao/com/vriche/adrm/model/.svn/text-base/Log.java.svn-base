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

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
/**
 * Log class
 * 
 * This class is used to
 * 
 * <p>
 * <a href="Log.java.html"> <i>View Source </i> </a>
 * </p>
 * 
 * @struts.form include-all="true" extends="BaseForm"
 *  
 */
public class Log extends BaseObject implements Serializable{
    

	private static final long serialVersionUID = 4916460750766500012L;
	protected Integer operateModel;
    protected Integer operateModelFunction;
    protected Integer operateType;
    protected String linkPath;
    protected String clientIp;
    protected Long modifyBy;
    protected Date modifyDate;
    
    protected User user = new User();
    public Log() {};

    /**
     * 
     * Returns the operateModel
     * @return Integer
     * 
     * @hibernate.property length="5" column="operate_model" not-null="false"
     */
    public Integer getOperateModel() {
        return operateModel;
    }
    /**
     * 
     * Returns the operateModelFunction
     * @return Integer
     * 
     * @hibernate.property length="5" column="operate_model_function" not-null="false"
     */
    public Integer getOperateModelFunction() {
        return operateModelFunction;
    }
    /**
     * 
     * Returns the operateType
     * @return Integer
     * 
     * @hibernate.property length="2" column="operate_type" not-null="false"
     */
    public Integer getOperateType() {
        return operateType;
    }
    /**
     * 
     * Returns the linkPath
     * @return String
     * 
     * @hibernate.property length="256" column="link_path" not-null="false"
     */
    public String getLinkPath() {
        return linkPath;
    }
    /**
     * 
     * Returns the clientIp
     * @return String
     * 
     * @hibernate.property length="512" column="client_ip" not-null="false"
     */
    public String getClientIp() {
        return clientIp;
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
     * @hibernate.property column="modify_date" update="false" insert="true" type="timestamp"
     */
    public Date getModifyDate() {
        return modifyDate;
    }
    


    
    /**
     * @param clientIp The clientIp to set.
     */
    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }
    /**
     * @param linkPath The linkPath to set.
     */
    public void setLinkPath(String linkPath) {
        this.linkPath = linkPath;
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
     * @param operateModel The operateModel to set.
     */
    public void setOperateModel(Integer operateModel) {
        this.operateModel = operateModel;
    }
    /**
     * @param operateModelFunction The operateModelFunction to set.
     */
    public void setOperateModelFunction(Integer operateModelFunction) {
        this.operateModelFunction = operateModelFunction;
    }
    /**
     * @param operateType The operateType to set.
     */
    public void setOperateType(Integer operateType) {
        this.operateType = operateType;
    }
    
    
    /**
     * @see java.lang.Object#equals(Object)
     */
    public boolean equals(Object object) {
        if (!(object instanceof Log)) {
            return false;
        }
        Log rhs = (Log) object;
        return new EqualsBuilder().append(
                this.operateModel, rhs.operateModel).append(this.modifyBy,
                rhs.modifyBy).append(this.operateModelFunction,
                rhs.operateModelFunction).append(this.operateType,
                rhs.operateType).append(this.modifyDate, rhs.modifyDate)
                .append(this.linkPath, rhs.linkPath).append(this.clientIp,
                        rhs.clientIp).isEquals();
    }
    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder(-454903329, -306152763).append(this.operateModel).append(
                this.modifyBy).append(this.operateModelFunction).append(
                this.operateType).append(this.modifyDate).append(this.linkPath)
                .append(this.clientIp).toHashCode();
    }
    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return new ToStringBuilder(this).append("linkPath", this.linkPath)
                .append("operateType", this.operateType).append("modifyBy",
                        this.modifyBy).append("modifyDate", this.modifyDate)
                .append("clientIp", this.clientIp).append("operateModel",
                        this.operateModel).append("operateModelFunction",
                        this.operateModelFunction).toString();
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}