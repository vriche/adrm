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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
/**
 * ResourceChannel class
 * 
 * This class is used to 
 * 
 * <p><a href="ResourceChannel.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_ad_resource_channel"
 * 
 */
public class ResourceChannel extends BaseObject {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Long id;
    protected String name;			         // required; unique
    protected String value;			         
    protected String memo;
    protected Integer enable;
    protected Boolean activation;
    
    
    protected Long createBy;				  //default sysdate
    protected Date createDate;					  
    protected Long modifyBy;				  //default sysdate
    protected Date modifyDate;					  
    protected Integer version;
    
    protected String broTimeFormat;
    
    protected String broTimeHour;
    protected String broTimeMin;
    protected String broTimeSec;
    
	private Long orgId;
	private Long orgAdminId;
	private Org org;
	
//	private ResourceChannelConfig channelConfig = new ResourceChannelConfig();
	
	
	protected List hourList= new ArrayList();
	protected List minList= new ArrayList();
	protected List secList= new ArrayList();
	
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
	/**
     * @hibernate.id column="resource_mediaorg_id" generator-class="native" unsaved-value="null"
     */
    public Long getId() {
        return id;
    }
    /**
     * 
     * Returns the name
     * @return String
     * @struts.validator type="required"
     * @hibernate.property length="128" column="name" not-null="false"
     */
    public String getName() {
        return name;
    }
    /**
     * 
     * Returns the value
     * @return String
     * 
     * @hibernate.property length="5" column="value" not-null="false"
     */
    public String getValue() {
        return value;
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
        if (!(object instanceof ResourceChannel)) {
            return false;
        }
        ResourceChannel rhs = (ResourceChannel) object;
        return new EqualsBuilder().append(this.memo, rhs.memo).append(
                this.value, rhs.value).append(this.modifyBy, rhs.modifyBy)
                .append(this.modifyDate, rhs.modifyDate).append(
                        this.createDate, rhs.createDate).append(this.createBy,
                        rhs.createBy).append(this.name, rhs.name).append(
                        this.id, rhs.id).append(this.version, rhs.version)
                .append(this.enable, rhs.enable).isEquals();
    }
    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder(1691351599, -1025655505).append(this.memo)
                .append(this.value).append(this.modifyBy).append(
                        this.modifyDate).append(this.createDate).append(
                        this.createBy).append(this.name).append(this.id)
                .append(this.version).append(this.enable).toHashCode();
    }
    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return new ToStringBuilder(this).append("name", this.name).append(
                "modifyBy", this.modifyBy).append("id", this.id).append(
                "version", this.version).append("modifyDate", this.modifyDate)
                .append("value", this.value).append("enable", this.enable)
                .append("memo", this.memo).append("createBy", this.createBy)
                .append("createDate", this.createDate).toString();
    }
    
    public static String converTime(Integer s,int fmt){

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
    
    public static String formatTime(long ms,String strFormat) {//将毫秒数换算成x天x时x分x秒x毫秒
		   int ss = 1000;
		   int mi = ss * 60;
		   int hh = mi * 60;
		   int dd = hh * 24;
		   
		   if(strFormat == null) strFormat ="d h:m:s S";

		   long day = ms / dd;
		   long hour = (ms - day * dd) / hh;
		   long minute = (ms - day * dd - hour * hh) / mi;
		   long second = (ms - day * dd - hour * hh - minute * mi) / ss;
		   long milliSecond = ms - day * dd - hour * hh - minute * mi - second * ss;

		   String strDay = day < 10 ? "0" + day : "" + day;
		   String strHour = hour < 10 ? "0" + hour : "" + hour;
		   String strMinute = minute < 10 ? "0" + minute : "" + minute;
		   String strSecond = second < 10 ? "0" + second : "" + second;
		   String strMilliSecond = milliSecond < 10 ? "0" + milliSecond : "" + milliSecond;
		   strMilliSecond = milliSecond < 100 ? "0" + strMilliSecond : "" + strMilliSecond;
		   
		   StringBuffer sb  = new StringBuffer();
		   
		   if(strFormat.indexOf("d")>-1) sb.append(strDay);
		   
		   if(strFormat.indexOf("h")>-1){
//			   sb.append(" ");
			   sb.append(strHour);
		   }
		   if(strFormat.indexOf("m")>-1){
			   if(strFormat.indexOf("h")>-1) sb.append(":");
			   sb.append(strMinute);
		   }
		   if(strFormat.indexOf("s")>-1){
			   if(strFormat.indexOf("m")>-1) sb.append(":");
			   sb.append(strSecond);
		   }
		   if(strFormat.indexOf("S")>-1){
			   if(strFormat.indexOf("s")>-1) sb.append(" ");
			   sb.append(strMilliSecond);
		   }
		   
		   return sb.toString();
//		   return strDay + " " + strHour + ":" + strMinute + ":" + strSecond + " " + strMilliSecond;
		}
	public String getBroTimeHour() {
		String value = this.value;
   	    value = (value ==null|| "".equals(value)) ?"0":value;
		return formatTime(Long.parseLong(value)*1000,"hh");
	}
	public void setBroTimeHour(String broTimeHour) {
		this.broTimeHour = broTimeHour;
	}
	public String getBroTimeMin() {
		String value = this.value;
   	    value = (value ==null|| "".equals(value)) ?"0":value;
		return formatTime(Long.parseLong(value)*1000,"mm");
	}
	public void setBroTimeMin(String broTimeMin) {
		this.broTimeMin = broTimeMin;
	}
	public String getBroTimeSec() {
		String value = this.value;
   	    value = (value ==null|| "".equals(value)) ?"0":value;
		return formatTime(Long.parseLong(value)*1000,"ss");
	}
	public void setBroTimeSec(String broTimeSec) {
		this.broTimeSec = broTimeSec;
	}
	public String getBroTimeFormat() {
		String value = this.value;
   	    value = (value ==null|| "".equals(value)) ?"0":value;
		return formatTime(Long.parseLong(value)*1000,"hh:mm:ss");
	}
	public void setBroTimeFormat(String broTimeFormat) {
		this.broTimeFormat = broTimeFormat;
	}
	public List getHourList() {
// 	   ArrayList list = new ArrayList();
//	   for(int i = 0;i<25;i++){
//		    String v = i<10?"0"+i:String.valueOf(i);
//		    list.add(new org.apache.struts.util.LabelValueBean(v,v));
//	   }
		return hourList;
	}
	public List getMinList() {
		
//		List list = new ArrayList();
//	   for(int i = 0;i<61;i++){
//		    String v = i<10?"0"+i:String.valueOf(i);
//		    list.add(new org.apache.struts.util.LabelValueBean(v,v));
//	   }
//	   resourceChannel.setMinList(list);   		
		
		return minList;
	}
	
	public List getSecList() {
//		List list = new ArrayList();
//		   for(int i = 0;i<61;i++){
//			    String v = i<10?"0"+i:String.valueOf(i);
//			    list.add(new org.apache.struts.util.LabelValueBean(v,v));
//		   }
//		   resourceChannel.setMinList(list);   		
			
//			return list;
		return secList;
	}
	public void setHourList(List hourList) {
		this.hourList = hourList;
	}
	public void setMinList(List minList) {
		this.minList = minList;
	}
	public void setSecList(List secList) {
		this.secList = secList;
	}
	public Boolean getActivation() {
		if(this.enable != null){
			activation = Boolean.valueOf(this.enable.intValue() == 1);
		}else{
			activation = Boolean.valueOf(true);
		}
		return activation;
	}
	public void setActivation(Boolean activation) {
		this.activation = activation;
	}
	/**
	 * @return Returns the channelConfig.
	 */
//	public ResourceChannelConfig getChannelConfig() {
//		return channelConfig;
//	}
//	/**
//	 * @param channelConfig The channelConfig to set.
//	 */
//	public void setChannelConfig(ResourceChannelConfig channelConfig) {
//		this.channelConfig = channelConfig;
//	}
//	

}
