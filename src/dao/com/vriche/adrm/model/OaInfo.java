/****************************************************************************     
 * Created on 2004-1-22                                                     *    
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
 * OaInfo class
 * 
 * This class is used to 
 * 
 * <p><a href="OaInfo.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_oa_info"
 * 
 */
public class OaInfo extends BaseObjectWithoutNestedFormValidation {
	


	private static final long serialVersionUID = 1L;
	protected Long id;	
	protected Long infoTypeId;	
	protected String title;  // required	
	protected String searchKey;	
	protected String content;  // required	
	protected Date displayTimes;	
	protected Long createBy; // default sysdate
	protected Date createDate;
	protected Long modifyBy; // default sysdate
	protected Date modifyDate;

	protected Integer version;
	
	protected OaInfoType infoType = new OaInfoType();
	
	
	public OaInfo(){}
	
	
	
	
	/**
	 * 
	 * Returns the id
	 * @return Long
	 * 
	 * @hibernate.id column="info_id" generator-class="native" unsaved-value="null"
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 
	 * Returns the content
	 * @return String
	 * @struts.validator type="required"
	 * @hibernate.property length="500" column="content" not-null="false"
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 
	 * Returns the displayTimes
	 * @return Date
	 * 
	 * @hibernate.property column="display_times" update="false" insert="true"
	 *                     type="timestamp"
	 */
	public Date getDisplayTimes() {
		return displayTimes;
	}
	/**
	 * 
	 * Returns the infoTypeId
	 * @return Long
	 * 
	 * @hibernate.property length="20" column="info_type_id" not-null="false"
	 */
	public Long getInfoTypeId() {
		return infoTypeId;
	}
	/**
	 * 
	 * Returns the searchKey
	 * @return String
	 * 
	 * @hibernate.property length="32" column="search_key" not-null="false"
	 */
	public String getSearchKey() {
		return searchKey;
	}
	/**
	 * 
	 * Returns the title
	 * @return String
	 * @struts.validator type="required"
	 * @hibernate.property length="32" column="title" not-null="false"
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 
	 * Returns the createBy
	 * 
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
	 * 
	 * @return Date
	 * 
	 * @hibernate.property column="create_date" update="false" insert="true"
	 *                     type="timestamp"
	 */

	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 
	 * Returns the modifyBy
	 * 
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
	 * 
	 * @return Date
	 * 
	 * @hibernate.property column="modify_date" update="false" insert="true"
	 *                     type="timestamp"
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
	 * @param content The content to set.
	 */
	public void setContent(String content) {
		this.content = content;
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
	 * @param displayTimes The displayTimes to set.
	 */
	public void setDisplayTimes(Date displayTimes) {
		this.displayTimes = displayTimes;
	}




	/**
	 * @param id The id to set.
	 */
	public void setId(Long id) {
		this.id = id;
	}




	/**
	 * @param infoType The infoType to set.
	 */
	public void setInfoType(OaInfoType infoType) {
		this.infoType = infoType;
	}




	/**
	 * @param infoTypeId The infoTypeId to set.
	 */
	public void setInfoTypeId(Long infoTypeId) {
		this.infoTypeId = infoTypeId;
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
	 * @param searchKey The searchKey to set.
	 */
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}




	/**
	 * @param title The title to set.
	 */
	public void setTitle(String title) {
		this.title = title;
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
		if (!(object instanceof OaInfo)) {
			return false;
		}
		OaInfo rhs = (OaInfo) object;
		return new EqualsBuilder().append(
				this.displayTimes, rhs.displayTimes).append(this.infoTypeId,
				rhs.infoTypeId).append(this.title, rhs.title).append(
				this.modifyBy, rhs.modifyBy).append(this.content, rhs.content)
				.append(this.modifyDate, rhs.modifyDate).append(
						this.createDate, rhs.createDate).append(this.searchKey,
						rhs.searchKey).append(this.infoType, rhs.infoType)
				.append(this.createBy, rhs.createBy).append(this.id, rhs.id)
				.append(this.version, rhs.version).isEquals();
	}




	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(505715459, -295644179).append(this.displayTimes).append(
				this.infoTypeId).append(this.title).append(this.modifyBy)
				.append(this.content).append(this.modifyDate).append(
						this.createDate).append(this.searchKey).append(
						this.infoType).append(this.createBy).append(this.id)
				.append(this.version).toHashCode();
	}




	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("modifyBy", this.modifyBy)
				.append("id", this.id).append("version", this.version).append(
						"modifyDate", this.modifyDate).append("title",
						this.title).append("infoTypeId", this.infoTypeId)
				.append("displayTimes", this.displayTimes).append("content",
						this.content).append("createBy", this.createBy).append(
						"createDate", this.createDate).append("searchKey",
						this.searchKey).toString();
	}

}
