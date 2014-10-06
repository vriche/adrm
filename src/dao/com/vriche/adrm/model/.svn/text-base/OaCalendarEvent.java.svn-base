/****************************************************************************     
 * Created on 2007-4-11                                      *    
 *                                                               			*
 * @author <a href="mailto:hongxilin@yahoo.com.cn">hongxi</a>               *
 *         Updated by hongxi (hongxilin@yahoo.com.cn)                       *
 *                                                                          *
 * @version  Vision:1.0														*
 * 																			*
 ***************************************************************************/
package com.vriche.adrm.model;

import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * OaCalendarEvent class
 * 
 * This class is used to 
 * 
 * <p><a href="OaCalendarEvent.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_oa_calendar_event"
 * 
 */
public class OaCalendarEvent extends BaseObject {

	private static final long serialVersionUID = -4860220773359211232L;
	protected Long id;
	protected String title;    // required
	protected Long eventStateId;    
	protected String content;    // required	
	

	protected Long createBy; // default sysdate
	protected String createDate;
	protected Long modifyBy; // default sysdate
	protected Date modifyDate;
	protected Integer version;
	protected Integer type;
	protected Integer indexDate;
	protected Long indexTime;
	
	protected SysEventState  sysEventState = new SysEventState();
	
	public OaCalendarEvent() {};

	/**
	 * @hibernate.id column="calendar_event_id" generator-class="native"
	 *               unsaved-value="null"
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 
	 * Returns the content
	 * @return String 
	 * @struts.validator type="required"
	 * @hibernate.property length="255" column="content" not-null="false"
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 
	 * Returns the eventStateId
	 * @return Long 
	 * 
	 * @hibernate.property length="20" column="event_state_id" not-null="false"
	 */
	public Long getEventStateId() {
		return eventStateId;
	}

	/**
	 * 
	 * Returns the title
	 * @return String 
	 * @struts.validator type="required"
	 * @hibernate.property length="255" column="title" not-null="false"
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
	 * @return String
	 * 
	 * @hibernate.property column="create_date" update="false" insert="true"
	 *                     type="timestamp"
	 */

	public String getCreateDate() {
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
	 * 
	 * Returns the sysEventState
	 * @return SysEventState 
	 */
	public SysEventState getSysEventState() {
		return sysEventState;
	}

	/**
	 * 
	 * Returns the type
	 * @return Integer 
	 * 
	 * @hibernate.property length="128" column="type" not-null="false"
	 */
	public Integer getType() {
		return type;
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
	public void setCreateDate(String createDate) {
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
	 * @param version The version to set.
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
	
	/** 
	 * @param sysEventState The sysEventState to set.
	 */
	public void setSysEventState(SysEventState sysEventState) {
		this.sysEventState = sysEventState;
	}
	
	

	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

	/** 
	 * @param content The content to set.
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/** 
	 * @param eventStateId The eventStateId to set.
	 */
	public void setEventStateId(Long eventStateId) {
		this.eventStateId = eventStateId;
	}

	/** 
	 * @param title The title to set.
	 */
	public void setTitle(String title) {
		this.title = title;
	}



	/** 
	 * @param type The type to set.
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("modifyBy", this.modifyBy)
				.append("id", this.id).append("version", this.version).append(
						"eventStateId", this.eventStateId).append("modifyDate",
						this.modifyDate).append("title", this.title).append(
						"type", this.type).append("content", this.content)
				.append("sysEventState", this.sysEventState).append("createBy",
						this.createBy).append("createDate", this.createDate)
				.toString();
	}

	/**
	 * 
	 * Returns the indexDate
	 * @return Integer
	 * 
	 * @hibernate.property length="11" column="index_date" not-null="false"
	 */
	public Integer getIndexDate() {
		return indexDate;
	}

	/**
	 * @param indexDate The indexDate to set.
	 */
	public void setIndexDate(Integer indexDate) {
		this.indexDate = indexDate;
	}

	/**
	 * 
	 * Returns the indexTime
	 * @return Long
	 * 
	 * @hibernate.property length="128" column="index_time" not-null="false"
	 */
	public Long getIndexTime() {
		return indexTime;
	}

	/**
	 * @param indexTime The indexTime to set.
	 */
	public void setIndexTime(Long indexTime) {
		this.indexTime = indexTime;
	}



}
