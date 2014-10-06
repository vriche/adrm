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
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.vriche.adrm.model.BaseObject;
/**
 * FeedbackInfo class
 * 
 * This class is used to 
 * 
 * <p><a href="FeedbackInfo.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_customer_feedback"
 * 
 */
public class FeedbackInfo extends BaseObject {
	
    private static final long serialVersionUID = 3832626162173359411L;
    
    protected Long customerId;
    protected String feeder;
    protected Long departmentId;
    protected Integer feedType;
    protected Integer submitDate;
    protected String feedContent;			  // required
    protected Integer dealDate;
    protected Integer satisfactoryDegree;
    protected String memo;

    protected Long id;
    protected Long createBy;				  //default sysdate
    protected Date createDate;					  
    protected Long modifyBy;				  //default sysdate
    protected Date modifyDate;					  
    protected Integer version;
    
    protected Long orgId;
    protected List customerCateList;
    protected String loginUser; 
    
    
    public List getCustomerCateList() {
		return customerCateList;
	}


	public void setCustomerCateList(List customerCateList) {
		this.customerCateList = customerCateList;
	}


	public String getLoginUser() {
		return loginUser;
	}


	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}


	public Long getOrgId() {
		return orgId;
	}


	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}


	public FeedbackInfo(){};


    /**
     * @hibernate.id column="customer_feedback_id" generator-class="native" unsaved-value="null"
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
     * @param customerId The customerId to set.
     */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    /**
     * @param dealDate The dealDate to set.
     */
    public void setDealDate(Integer dealDate) {
        this.dealDate = dealDate;
    }
    /**
     * @param departmentId The departmentId to set.
     */
    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
    /**
     * @param feedContent The feedContent to set.
     */
    public void setFeedContent(String feedContent) {
        this.feedContent = feedContent;
    }
    /**
     * @param feeder The feeder to set.
     */
    public void setFeeder(String feeder) {
        this.feeder = feeder;
    }
    /**
     * @param feedType The feedType to set.
     */
    public void setFeedType(Integer feedType) {
        this.feedType = feedType;
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
     * @param satisfactoryDegree The satisfactoryDegree to set.
     */
    public void setSatisfactoryDegree(Integer satisfactoryDegree) {
        this.satisfactoryDegree = satisfactoryDegree;
    }
    /**
     * @param submitDate The submitDate to set.
     */
    public void setSubmitDate(Integer submitDate) {
        this.submitDate = submitDate;
    }
    /**
     * @param version The version to set.
     */
    public void setVersion(Integer version) {
        this.version = version;
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
     * 
     * Returns the feeder
     * @return String
     * 
     * @hibernate.property length="128" column="feeder" not-null="false"
     */
    public String getFeeder() {
        return feeder;
    }
    /**
     * 
     * Returns the departmentId
     * @return Long
     * 
     * @hibernate.property length="20" column="department_id" not-null="false"
     */
    public Long getDepartmentId() {
        return departmentId;
    }
    /**
     * 
     * Returns the feedType
     * @return Integer
     * 
     * @hibernate.property length="2" column="feed_type" not-null="false"
     */
    public Integer getFeedType() {
        return feedType;
    }
    /**
     * 
     * Returns the submitDate
     * @return Integer
     * 
     * @hibernate.property length="8" column="submit_date" not-null="false"
     */
    public Integer getSubmitDate() {
        return submitDate;
    }
    /**
     * 
     * Returns the feedContent
     * @return String
     * @struts.validator type="required"
     * @hibernate.property length="255" column="feed_content" not-null="true"
     */
    public String getFeedContent() {
        return feedContent;
    }
    /**
     * 
     * Returns the dealDate
     * @return Integer
     * 
     * @hibernate.property length="8" column="deal_date" not-null="false"
     */
    public Integer getDealDate() {
        return dealDate;
    }
    /**
     * 
     * Returns the satisfactoryDegree
     * @return Integer
     * 
     * @hibernate.property length="2" column="satisfactory_degree" not-null="false"
     */
    public Integer getSatisfactoryDegree() {
        return satisfactoryDegree;
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
     * @see java.lang.Object#equals(Object)
     */
    public boolean equals(Object object) {
        if (!(object instanceof FeedbackInfo)) {
            return false;
        }
        FeedbackInfo rhs = (FeedbackInfo) object;
        return new EqualsBuilder().append(
                this.feedType, rhs.feedType).append(this.memo, rhs.memo)
                .append(this.departmentId, rhs.departmentId).append(
                        this.feedContent, rhs.feedContent).append(
                        this.modifyBy, rhs.modifyBy).append(this.submitDate,
                        rhs.submitDate).append(this.feeder, rhs.feeder).append(
                        this.modifyDate, rhs.modifyDate).append(
                        this.createDate, rhs.createDate).append(this.dealDate,
                        rhs.dealDate).append(this.createBy, rhs.createBy)
                .append(this.satisfactoryDegree, rhs.satisfactoryDegree)
                .append(this.id, rhs.id).append(this.version, rhs.version)
                .append(this.customerId, rhs.customerId).isEquals();
    }
    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder(-2048203953, -161439473).append(this.feedType).append(this.memo)
                .append(this.departmentId).append(this.feedContent).append(
                        this.modifyBy).append(this.submitDate).append(
                        this.feeder).append(this.modifyDate).append(
                        this.createDate).append(this.dealDate).append(
                        this.createBy).append(this.satisfactoryDegree).append(
                        this.id).append(this.version).append(this.customerId)
                .toHashCode();
    }
    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return new ToStringBuilder(this)
                .append("feedContent", this.feedContent).append("modifyBy",
                        this.modifyBy).append("feeder", this.feeder).append(
                        "id", this.id).append("version", this.version).append(
                        "feedType", this.feedType).append("customerId",
                        this.customerId).append("modifyDate", this.modifyDate)
                .append("submitDate", this.submitDate).append("departmentId",
                        this.departmentId).append("dealDate", this.dealDate)
                .append("memo", this.memo).append("createBy", this.createBy)
                .append("createDate", this.createDate).append(
                        "satisfactoryDegree", this.satisfactoryDegree)
                .toString();
    }
}
