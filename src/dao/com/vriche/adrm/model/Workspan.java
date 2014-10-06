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
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.vriche.adrm.model.BaseObject;

/**
 * Workspan class
 * 
 * This class is used to 
 * 
 * <p><a href="Workspan.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_ad_resource_workspan"
 * 
 */
public class Workspan extends BaseObject {
    private static final long serialVersionUID = 3832626162173359411L;
    
    
    protected String carrierId;
    protected Long resourceId;
    protected Integer resourceType;
    protected Integer propertiyTime;
    protected Integer beginDate;
    protected Integer endDate;
    
    protected Integer broadcastStartTime;
    protected Integer broadcastEndTime;
    
//    protected String broadcastStartTimeFormat;
//    protected String broadcastEndTimeFormat;
    
    

    
    protected String broadcastStartT;
    protected String broadcastStartTh;
    protected String broadcastStartTm;
    protected String broadcastStartTs;
    
    protected String broadcastT;
    protected String broadStartTimeS;
    protected String broadEndTimeS;
   
    protected String monLength;
    protected String tueLength;
    protected String wenLength;
    protected String thiLength;
    protected String friLength;
    protected String satLength;
    protected String sunLength;

    
    protected Long id;
    protected Long createBy;				  //default sysdate
    protected Date createDate;					  
    protected Long modifyBy;				  //default sysdate
    protected Date modifyDate;					  
    protected Integer version;
    protected String memo;
    
    protected Set dayInfos = new HashSet();
    
    public Workspan(){};
    

    /**
     * @hibernate.id column="ad_resource_workspan_id" generator-class="native" unsaved-value="null"
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
     * Returns the carrierId
     * @return String
     * 
     * @hibernate.property length="32" column="ad_resource_carrier_id" not-null="false"
     */
    public String getCarrierId() {
        return carrierId;
    }
    /**
     * 
     * Returns the resourceId
     * @return Long
     * 
     * @hibernate.property length="20" column="ad_resource_info_id" not-null="false"
     */
    public Long getResourceId() {
        return resourceId;
    }
    /**
     * 
     * Returns the resourceType
     * @return Integer
     * 
     * @hibernate.property length="2" column="ad_resource_type" not-null="false"
     */
    public Integer getResourceType() {
        return resourceType;
    }
    /**
     * 
     * Returns the propertiyTime
     * @return Integer
     * 
     * @hibernate.property length="2" column="ad_resource_propertiy_time" not-null="false"
     */
    public Integer getPropertiyTime() {
        return propertiyTime;
    }
    
    /**
     * @hibernate.collection-one-to-many class="com.vriche.adrm.model.DayInfo"
     * @hibernate.collection-key column="ad_resource_workspan_id"
     * @hibernate.set name="dayInfos" table="tb_ad_resource_day_info" inverse="false" cascade="all" lazy="false"
     */
    public Set getDayInfos() {
        return dayInfos;
    }   
    
    
    
    
    
    
    
    
    /**
     * @param dayInfos The dayInfos to set.
     */
    public void setDayInfos(Set dayInfos) {
        this.dayInfos = dayInfos;
    }
    /**
     * 
     * Returns the broadcastStartTime
     * @return Integer
     * 
     * @hibernate.property  length="11" column="broadcast_start_time" not-null="false"
     */
    public Integer getBroadcastStartTime() {
        return broadcastStartTime;
    }

    /**
     * 
     * Returns the beginDate
     * @return Integer
     * 
     * @hibernate.property length="8" column="begin_date" not-null="false"
     */
    public Integer getBeginDate() {
        return beginDate;
    }
    /**
     * 
     * Returns the endDate
     * @return Integer
     * 
     * @hibernate.property length="8" column="end_date" not-null="false"
     */
    public Integer getEndDate() {
        return endDate;
    }

    /**
     * 
     * Returns the broadcastEndTime
     * @return String
     * 
     * @hibernate.property  column="broadcast_end_time" not-null="false"
     */
    public Integer getBroadcastEndTime() {
        return broadcastEndTime;
    }
    /**
     * 
     * Returns the sunLength
     * @return String
     * 
     * @hibernate.property length="32" column="sun_length" not-null="false"
     */
    public String getSunLength() {
        return sunLength;
    }
    /**
     * 
     * Returns the monLength
     * @return String
     * 
     * @hibernate.property length="32" column="mon_length" not-null="false"
     */
    public String getMonLength() {
        return monLength;
    }
    /**
     * 
     * Returns the tueLength
     * @return String
     * 
     * @hibernate.property length="32" column="tue_length" not-null="false"
     */
    public String getTueLength() {
        return tueLength;
    }
    /**
     * 
     * Returns the thiLength
     * @return String
     * 
     * @hibernate.property length="32" column="thi_length" not-null="false"
     */
    public String getThiLength() {
        return thiLength;
    }
    /**
     * 
     * Returns the wenLength
     * @return String
     * 
     * @hibernate.property length="32" column="wen_length" not-null="false"
     */
    public String getWenLength() {
        return wenLength;
    }
    /**
     * 
     * Returns the friLength
     * @return String
     * 
     * @hibernate.property length="32" column="fri_length" not-null="false"
     */
    public String getFriLength() {
        return friLength;
    }
    /**
     * 
     * Returns the satLength
     * @return String
     * 
     * @hibernate.property length="32" column="sat_length" not-null="false"
     */
    public String getSatLength() {
        return satLength;
    }
  
    /**
     * @param propertiyTime The propertiyTime to set.
     */
    public void setPropertiyTime(Integer propertiyTime) {
        this.propertiyTime = propertiyTime;
    } 
    
    
    

    /**
     * @param beginDate The beginDate to set.
     */
    public void setBeginDate(Integer beginDate) {
        this.beginDate = beginDate;
    }
    /**
     * @param broadcastEndTime The broadcastEndTime to set.
     */
    public void setBroadcastEndTime(Integer broadcastEndTime) {
        this.broadcastEndTime = broadcastEndTime;
    }
    /**
     * @param broadcastStartTime The broadcastStartTime to set.
     */
    public void setBroadcastStartTime(Integer broadcastStartTime) {
        this.broadcastStartTime = broadcastStartTime;
    }
    /**
     * @param carrierId The carrierId to set.
     */
    public void setCarrierId(String carrierId) {
        this.carrierId = carrierId;
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
     * @param endDate The endDate to set.
     */
    public void setEndDate(Integer endDate) {
        this.endDate = endDate;
    }
    /**
     * @param friLength The friLength to set.
     */
    public void setFriLength(String friLength) {
        this.friLength = friLength;
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
     * @param monLength The monLength to set.
     */
    public void setMonLength(String monLength) {
        this.monLength = monLength;
    }
    /**
     * @param resourceId The resourceId to set.
     */
    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }
    /**
     * @param resourceType The resourceType to set.
     */
    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
    }
    /**
     * @param satLength The satLength to set.
     */
    public void setSatLength(String satLength) {
        this.satLength = satLength;
    }
    /**
     * @param sunLength The sunLength to set.
     */
    public void setSunLength(String sunLength) {
        this.sunLength = sunLength;
    }
    /**
     * @param thiLength The thiLength to set.
     */
    public void setThiLength(String thiLength) {
        this.thiLength = thiLength;
    }
    /**
     * @param tueLength The tueLength to set.
     */
    public void setTueLength(String tueLength) {
        this.tueLength = tueLength;
    }
    /**
     * @param version The version to set.
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
    /**
     * @param wenLength The wenLength to set.
     */
    public void setWenLength(String wenLength) {
        this.wenLength = wenLength;
    }
   
    
    
    /**
     * @see java.lang.Object#equals(Object)
     */
    public boolean equals(Object object) {
        if (!(object instanceof Workspan)) {
            return false;
        }
        Workspan rhs = (Workspan) object;
        return new EqualsBuilder().append(
                this.tueLength, rhs.tueLength).append(this.memo, rhs.memo)
                .append(this.beginDate, rhs.beginDate).append(
                        this.broadcastStartTime, rhs.broadcastStartTime)
                .append(this.dayInfos, rhs.dayInfos).append(this.friLength,
                        rhs.friLength).append(this.modifyBy, rhs.modifyBy)
                .append(this.carrierId, rhs.carrierId).append(
                        this.broadcastEndTime, rhs.broadcastEndTime).append(
                        this.createBy, rhs.createBy).append(this.monLength,
                        rhs.monLength).append(this.thiLength, rhs.thiLength)
                .append(this.id, rhs.id).append(this.version, rhs.version)
                .append(this.propertiyTime, rhs.propertiyTime).append(
                        this.sunLength, rhs.sunLength).append(this.satLength,
                        rhs.satLength).append(this.wenLength, rhs.wenLength)
                .append(this.resourceType, rhs.resourceType).append(
                        this.modifyDate, rhs.modifyDate).append(
                        this.createDate, rhs.createDate).append(this.endDate,
                        rhs.endDate).append(this.resourceId, rhs.resourceId)
                .isEquals();
    }
    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder(1912542021, -1117608007).append(this.tueLength).append(this.memo)
                .append(this.beginDate).append(this.broadcastStartTime).append(
                        this.dayInfos).append(this.friLength).append(
                        this.modifyBy).append(this.carrierId).append(
                        this.broadcastEndTime).append(this.createBy).append(
                        this.monLength).append(this.thiLength).append(this.id)
                .append(this.version).append(this.propertiyTime).append(
                        this.sunLength).append(this.satLength).append(
                        this.wenLength).append(this.resourceType).append(
                        this.modifyDate).append(this.createDate).append(
                        this.endDate).append(this.resourceId).toHashCode();
    }
    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return new ToStringBuilder(this).append("wenLength", this.wenLength)
                .append("modifyBy", this.modifyBy).append("id", this.id)
                .append("carrierId", this.carrierId).append("modifyDate",
                        this.modifyDate).append("propertiyTime",
                        this.propertiyTime).append("dayInfos", this.dayInfos)
                .append("satLength", this.satLength).append("tueLength",
                        this.tueLength).append("sunLength", this.sunLength)
                .append("resourceType", this.resourceType).append("memo",
                        this.memo).append("createBy", this.createBy).append(
                        "broadcastStartTime", this.broadcastStartTime).append(
                        "resourceId", this.resourceId).append("beginDate",
                        this.beginDate).append("thiLength", this.thiLength)
                .append("endDate", this.endDate)
                .append("version", this.version).append("monLength",
                        this.monLength).append("broadcastEndTime",
                        this.broadcastEndTime).append("friLength",
                        this.friLength).append("createDate", this.createDate)
                .toString();
    }


	/**
	 * @return Returns the broadcastEndT.
	 */
	public String getBroadcastStartT() {
		String h = this.broadcastStartTh;
		String m = this.broadcastStartTm;
		String s = this.broadcastStartTs;
		h = (h == null)||h.equals("")?"00":h;
		m = (m == null)||m.equals("")?"00":m;
		s = (s == null)||s.equals("")?"00":s;
		return h+":"+m+":"+s;
//		return broadcastEndT;
	}


	/**
	 * @param broadcastEndT The broadcastEndT to set.
	 */
	public void setBroadcastStartT(String broadcastStartT) {
		this.broadcastStartT = broadcastStartT;
	}


	/**
	 * @return Returns the broadcastEndTh.
	 */
	public String getBroadcastStartTh() {
		return broadcastStartTh;
	}


	/**
	 * @param broadcastEndTh The broadcastEndTh to set.
	 */
	public void setBroadcastStartTh(String broadcastStartTh) {
		this.broadcastStartTh = broadcastStartTh;
	}


	/**
	 * @return Returns the broadcastEndTm.
	 */
	public String getBroadcastStartTm() {
		return broadcastStartTm;
	}


	/**
	 * @param broadcastEndTm The broadcastEndTm to set.
	 */
	public void setBroadcastStartTm(String broadcastStartTm) {
		this.broadcastStartTm = broadcastStartTm;
	}


	/**
	 * @return Returns the broadcastEndTs.
	 */
	public String getBroadcastStartTs() {
		return broadcastStartTs;
	}


	/**
	 * @param broadcastEndTs The broadcastEndTs to set.
	 */
	public void setBroadcastStartTs(String broadcastStartTs) {
		this.broadcastStartTs = broadcastStartTs;
	}


//	public String getBroadcastTimeFormat() {
//		 String broTime = "";
//		 String broStartTime = "";
//		 String broEndTime = "";
//		 Integer startTime = this.getBroadcastStartTime();
//		 Integer endTime = this.getBroadcastEndTime();
//         String s1 = DateUtil.converTime(startTime,3);
//         
//          broStartTime = DateUtil.converTime(startTime,1) + ":"+DateUtil.converTime(startTime,2);
//         if(!"00".equals(s1)) broStartTime =  broStartTime +":"+ DateUtil.converTime(startTime,3);
//         
//         String s2 = DateUtil.converTime(endTime,3);
//         broEndTime = DateUtil.converTime(endTime,1) + ":"+DateUtil.converTime(endTime,2);
//         if(!"00".equals(s2)) broEndTime = broEndTime + ":" +DateUtil.converTime(endTime,3);
//         broTime = broStartTime +"-" +broEndTime;
//         return broTime;
//	}

	public String getBroadcastTimeFormat() {
       return this.getBroadcastTimeFormat("-");
	}
	
	public String getBroadcastTimeFormat(String split) {
		 String broTime = "";
        broTime = this.getBroadcastTimeFormatStart() +"-" +this.getBroadcastTimeFormatEnd();
        return broTime;
	}

	public String getBroadcastTimeFormatStart() {
		 String broStartTime = "";
		 Integer startTime = this.getBroadcastStartTime();
		 
		 if(startTime != null){
	         String s1 = this.converTime(startTime,3);
	         broStartTime = this.converTime(startTime,1) + ":"+this.converTime(startTime,2);
	         if(!"00".equals(s1)) broStartTime =  broStartTime +":"+ this.converTime(startTime,3); 
		 }


        return broStartTime;
	}
	public String getBroadcastTimeFormatEnd() {
		String broEndTime = "";
		Integer endTime = this.getBroadcastEndTime();
		
		 if(endTime != null){
		        String s2 = this.converTime(endTime,3);
		        broEndTime = this.converTime(endTime,1) + ":"+this.converTime(endTime,2);
		        if(!"00".equals(s2)) broEndTime = broEndTime + ":" +this.converTime(endTime,3); 
		 }

        return broEndTime;
	}
    private String converTime(Integer s,int fmt){

	    String t ="00";
		if(s != null){
			if(!"0".equals(s.toString())){
	            if(fmt == 1){
	            	 t = String.valueOf(s.intValue()/3600);
	            }
	            if(fmt ==2){
	    	        int second = s.intValue()%3600;
	    	        int minute = second / 60;
	            	t = String.valueOf(minute);
	            }
	            if(fmt ==3){
	                int second = s.intValue()%3600;
	    	        second %= 60;
	            	t = String.valueOf(second);
	            }
	            if(t.length() == 1) t = "0"+t;
			}
		}
		
	    return t;
	}




	public String getBroadcastT() {
		return broadcastT;
	}


	public void setBroadcastT(String broadcastT) {
		this.broadcastT = broadcastT;
	}


	public String getBroadEndTimeS() {
		return broadEndTimeS;
	}


	public void setBroadEndTimeS(String broadEndTimeS) {
		this.broadEndTimeS = broadEndTimeS;
	}


	public String getBroadStartTimeS() {
		return broadStartTimeS;
	}


	public void setBroadStartTimeS(String broadStartTimeS) {
		this.broadStartTimeS = broadStartTimeS;
	}

}
