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
 * SysEnent class
 * 
 * This class is used to 
 * 
 * <p><a href="SysEnent.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_sys_event"
 * 
 */
public class SysEvent extends BaseObject{
	

	private static final long serialVersionUID = 1L;
	protected Long id;	
	protected Long infoId;	
	protected Long eventTypeId;	
	protected Long promptModeId;	
	protected Date promptStart;  // required	
	protected Date promptEnd;  // required	
	protected String mesgMemo;	
	protected String linkPath;	
	protected Long eventStateId;	
	protected Long createBy; // default sysdate
	protected Date createDate;
	protected Long modifyBy; // default sysdate
	protected Date modifyDate;
	protected Integer version;
	
	protected SysPromptMode promptMode = new SysPromptMode();
	protected SysEventType eventType = new SysEventType();
	protected SysEventState eventState = new SysEventState();
	protected OaInfo info = new OaInfo();
	
	public SysEvent() {};
	
	
	/**
	 * 
	 * Returns the id
	 * @return Long
	 * 
	 * @hibernate.id column="sys_enent_id" generator-class="native" unsaved-value="null"
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 
	 * Returns the infoId
	 * @return Long
	 * 
	 * @hibernate.property length="20" column="info_id" not-null="false"
	 */
	public Long getInfoId() {
		return infoId;
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
	 * 
	 * Returns the enentState
	 * @return SysEnentState 
	 */
	public SysEventState getEventState() {
		return eventState;
	}


	/**
	 * 
	 * Returns the enentStateId
	 * @return Long 
	 * 
	 * @hibernate.property length="20" column="enent_state_id" not-null="false"
	 */
	public Long getEventStateId() {
		return eventStateId;
	}



	/**
	 * 
	 * Returns the enentTypeId
	 * @return Long 
	 * 
	 * @hibernate.property length="20" column="enent_type_id" not-null="false"
	 */
	public Long getEventTypeId() {
		return eventTypeId;
	}


	/**
	 * 
	 * Returns the info
	 * @return OaInfo 
	 * 
	 */
	public OaInfo getInfo() {
		return info;
	}





	/**
	 * 
	 * Returns the eventType
	 * @return SysEventType 
	 * 
	 */
	public SysEventType getEventType() {
		return eventType;
	}


	/**
	 * 
	 * Returns the linkPath
	 * @return String 
	 * 
	 * @hibernate.property length="255" column="link_path" not-null="false"
	 */
	public String getLinkPath() {
		return linkPath;
	}


	/**
	 * 
	 * Returns the mesgMemo
	 * @return String 
	 * 
	 * @hibernate.property length="255" column="mesg_meno" not-null="false"
	 */
	public String getMesgMemo() {
		return mesgMemo;
	}


	/**
	 * 
	 * Returns the promptEnd
	 * @return Date 
	 * 
	 * @hibernate.property  column="promptEnd" not-null="false" type="timestamp"
	 */
	public Date getPromptEnd() {
		return promptEnd;
	}


	/**
	 * 
	 * Returns the promptMode
	 * @return SysPromptMode 
	 * 
	 */
	public SysPromptMode getPromptMode() {
		return promptMode;
	}


	/**
	 * 
	 * Returns the promptModeId
	 * @return Long 
	 * 
	 * @hibernate.property length="20" column="prompt_mode _id" not-null="false"
	 */
	public Long getPromptModeId() {
		return promptModeId;
	}


	/**
	 * 
	 * Returns the promptStart
	 * @return Date 
	 * 
	 * @hibernate.property  column="prompt_start" not-null="false" type="timestamp"
	 */
	public Date getPromptStart() {
		return promptStart;
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
	 * @param enentstateid The enentstateid to set.
	 */
	public void setEventstateid(Long eventStateId) {
		this.eventStateId = eventStateId;
	}


	/**
	 * @param enenttypeid The enenttypeid to set.
	 */
	public void setEventtypeid(Long eventTypeId) {
		this.eventTypeId = eventTypeId;
	}


	/**
	 * @param id The id to set.
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @param infoid The infoid to set.
	 */
	public void setInfoid(Long infoId) {
		this.infoId = infoId;
	}


	/**
	 * @param linkpath The linkpath to set.
	 */
	public void setLinkpath(String linkPath) {
		this.linkPath = linkPath;
	}


	/**
	 * @param mesgmemo The mesgmemo to set.
	 */
	public void setMesgmemo(String mesgMemo) {
		this.mesgMemo = mesgMemo;
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
	 * @param promptend The promptend to set.
	 */
	public void setPromptend(Date promptEnd) {
		this.promptEnd = promptEnd;
	}


	/**
	 * @param promptmodeid The promptmodeid to set.
	 */
	public void setPromptmodeid(Long promptModeId) {
		this.promptModeId = promptModeId;
	}


	/**
	 * @param promptstart The promptstart to set.
	 */
	public void setPromptstart(Date promptStart) {
		this.promptStart = promptStart;
	}


	/**
	 * @param version The version to set.
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}



	/** 
	 * @param eventState The eventState to set.
	 */
	public void setEventState(SysEventState eventState) {
		this.eventState = eventState;
	}


	/** 
	 * @param eventStateId The eventStateId to set.
	 */
	public void setEventStateId(Long eventStateId) {
		this.eventStateId = eventStateId;
	}


	/** 
	 * @param eventType The eventType to set.
	 */
	public void setEventType(SysEventType eventType) {
		this.eventType = eventType;
	}


	/** 
	 * @param eventTypeId The eventTypeId to set.
	 */
	public void setEventTypeId(Long eventTypeId) {
		this.eventTypeId = eventTypeId;
	}


	/** 
	 * @param info The info to set.
	 */
	public void setInfo(OaInfo info) {
		this.info = info;
	}


	/** 
	 * @param infoId The infoId to set.
	 */
	public void setInfoId(Long infoId) {
		this.infoId = infoId;
	}


	/** 
	 * @param linkPath The linkPath to set.
	 */
	public void setLinkPath(String linkPath) {
		this.linkPath = linkPath;
	}


	/** 
	 * @param mesgMemo The mesgMemo to set.
	 */
	public void setMesgMemo(String mesgMemo) {
		this.mesgMemo = mesgMemo;
	}


	/** 
	 * @param promptEnd The promptEnd to set.
	 */
	public void setPromptEnd(Date promptEnd) {
		this.promptEnd = promptEnd;
	}


	/** 
	 * @param promptMode The promptMode to set.
	 */
	public void setPromptMode(SysPromptMode promptMode) {
		this.promptMode = promptMode;
	}


	/** 
	 * @param promptModeId The promptModeId to set.
	 */
	public void setPromptModeId(Long promptModeId) {
		this.promptModeId = promptModeId;
	}


	/** 
	 * @param promptStart The promptStart to set.
	 */
	public void setPromptStart(Date promptStart) {
		this.promptStart = promptStart;
	}


	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof SysEvent)) {
			return false;
		}
		SysEvent rhs = (SysEvent) object;
		return new EqualsBuilder().append(this.promptEnd, rhs.promptEnd)
				.append(this.promptModeId, rhs.promptModeId).append(
						this.modifyBy, rhs.modifyBy).append(this.promptMode,
						rhs.promptMode).append(this.mesgMemo, rhs.mesgMemo)
				.append(this.createBy, rhs.createBy).append(this.id, rhs.id)
				.append(this.infoId, rhs.infoId).append(this.version,
						rhs.version).append(this.info, rhs.info).append(
						this.eventTypeId, rhs.eventTypeId).append(
						this.eventState, rhs.eventState).append(
						this.promptStart, rhs.promptStart).append(
						this.createDate, rhs.createDate).append(
						this.modifyDate, rhs.modifyDate).append(this.linkPath,
						rhs.linkPath).append(this.eventStateId,
						rhs.eventStateId).append(this.eventType, rhs.eventType)
				.isEquals();
	}


	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(2141230129, -812428333).append(
				this.promptEnd).append(this.promptModeId).append(this.modifyBy)
				.append(this.promptMode).append(this.mesgMemo).append(
						this.createBy).append(this.id).append(this.infoId)
				.append(this.version).append(this.info)
				.append(this.eventTypeId).append(this.eventState).append(
						this.promptStart).append(this.createDate).append(
						this.modifyDate).append(this.linkPath).append(
						this.eventStateId).append(this.eventType).toHashCode();
	}


	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("eventType", this.eventType)
				.append("modifyBy", this.modifyBy).append("mesgMemo",
						this.mesgMemo).append("id", this.id).append(
						"eventStateId", this.eventStateId).append(
						"eventTypeId", this.eventTypeId).append("modifyDate",
						this.modifyDate).append("promptMode", this.promptMode)
				.append("promptStart", this.promptStart).append("infoId",
						this.infoId).append("createBy", this.createBy).append(
						"promptEnd", this.promptEnd).append("linkPath",
						this.linkPath)
				.append("promptModeId", this.promptModeId).append("version",
						this.version).append("info", this.info).append(
						"createDate", this.createDate).append("eventState",
						this.eventState).toString();
	}
		

}
