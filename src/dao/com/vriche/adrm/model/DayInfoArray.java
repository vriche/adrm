/****************************************************************************     
 * Created on 2006-11-6                                                     *    
 *                                                               			*
 * @author <a href="mailto:hongxilin@yahoo.com.cn">hongxi</a>               *
 *         Updated by hongxi (hongxilin@yahoo.com.cn)                       *
 *                                                                          *
 * @version  Vision:1.0														*
 * 																			*
 ***************************************************************************/
package com.vriche.adrm.model;


import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
/**
 * DayInfo class
 * 
 * This class is used to 
 * 
 * <p><a href="DayInfo.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * 
 */
public class DayInfoArray extends BaseObject {

	private static final long serialVersionUID = 5803808751619834249L;
	protected Integer year;
	protected Integer month;
	protected Integer day;
	protected Integer dayDate;
	protected String  dayShort;
	protected Double adLength;    //广告规格
	protected Double adUsedTime;  //广告占用时长
	protected Integer adTimes;	   //广告日投放次数
	protected Double  adPrice;     //广告规格
	protected String  adSpecific;  //广告指定位置
	protected Long    adDayInfoId;  //订单日信息编号
	protected Long    adOrderDetailId;  //订单明细息编号
	protected Integer  version;     //
	protected Integer weak;
	protected String weakStr;
	
	
	
	protected Long    resourceId;  //资信息编号
	protected Long    resourceDayId;  //资源日信息编号
	protected Double rsTotalTime; //资源总时长
	protected Double rsUsedTime;  //资源已使用时间
	
	protected Double rsTotalTime2; //资源总时长
	protected Double rsUsedTime2;  //资源已使用时间
	
	protected String  rsSpecific;  //资源已指定信息
	protected String  rsAlert;     //资源提示信息
	protected String  rsColor;     //资源单元格背景色
	protected String  rsModifyTime;     //时间戳
	
	//protected Boolean rsIsPublish; //资源已发布
	//protected Boolean rsRight;     //资源是权限

//  已发布
	protected Boolean isPublish;   
//  超时封签 isClosed
	protected Boolean isLimit;  
//  已有指定 
	protected Boolean isResSpecificed; 
//  已有指定 (修改广告)
	protected Boolean isAdSpecificed; 
//  是套装 
	protected Boolean isCompages; 
//  当前指定 
	protected Boolean curSpecificed; 
//  资源剩余时间 
	protected Double rsReleave;  
	
	protected Double rsReleave2;  

	//  无效 
	protected Boolean disabled;    
//  超时封签 
	
//  指定加收
    protected Boolean resIsOverweight;
//  超时封签
    protected Boolean resIsValidate;
//  出串联单
    protected Boolean resIsSeralized;
//  手动价格
    protected Boolean resIsManual;
//  启用
    protected Boolean resEnable;
    
//  播出锁定
    protected Boolean isLocked;
    
    public Boolean getIsLocked() {
		return isLocked;
	}
	public void setIsLocked(Boolean isLocked) {
		this.isLocked = isLocked;
	}
	protected Double dayRelIncome;
    protected Double dayRelPuton;
	

//	public DayInfoArray() {
//	    this.adLength = new Integer("0");
//	    this.adLength = new Integer("0");
//	    this.adUsedTime = new Integer("0");
//	    this.adTimes = new Integer("0");
//	    this.adPrice = new Double("0");
//	    this.adTimes = new Integer("0");
//	    this.adSpecific = new String("");
//	    
//	    this.rsTotalTime = new Integer("0");
//	    this.rsUsedTime = new Integer("0");
//	    this.rsAlert = new String("");
//	    this.rsSpecific = new String("");
//	    
//	}

	public Double getRsTotalTime2() {
		return rsTotalTime2;
	}
	public void setRsTotalTime2(Double rsTotalTime2) {
		this.rsTotalTime2 = rsTotalTime2;
	}
	public Double getRsUsedTime2() {
		return rsUsedTime2;
	}
	public void setRsUsedTime2(Double rsUsedTime2) {
		this.rsUsedTime2 = rsUsedTime2;
	}
	public Double getRsReleave2() {
		return rsReleave2;
	}
	public void setRsReleave2(Double rsReleave2) {
		this.rsReleave2 = rsReleave2;
	}
	/**
     * 
     * Returns the adPrice
     * @return Double
     * 
     */
    public Double getAdPrice() {
        return adPrice;
    }
    /**
     * @param adPrice The adPrice to set.
     */
    public void setAdPrice(Double adPrice) {
        this.adPrice = adPrice;
    }
    /**
     * 
     * Returns the rsAlert
     * @return String
     */
    public String getRsAlert() {
        return rsAlert;
    }
    /**
     * @param rsAlert The rsAlert to set.
     */
    public void setRsAlert(String rsAlert) {
        this.rsAlert = rsAlert;
    }
    /**
     * 
     * Returns the adSpecific
     * @return String
     */
    public String getAdSpecific() {
        return adSpecific;
    }
    /**
     * @param adSpecific The adSpecific to set.
     */
    public void setAdSpecific(String adSpecific) {
        this.adSpecific = adSpecific;
    }
    /**
     * 
     * Returns the adTimes
     * @return Integer
     */
    public Integer getAdTimes() {
        return adTimes;
    }
    /**
     * @param adTimes The adTimes to set.
     */
    public void setAdTimes(Integer adTimes) {
        this.adTimes = adTimes;
    }
    /**
     * 
     * Returns the adUsedTime
     * @return Integer
     */
    public Double getAdUsedTime() {
        return adUsedTime;
    }
    /**
     * @param adUsedTime The adUsedTime to set.
     */
    public void setAdUsedTime(Double adUsedTime) {
        this.adUsedTime = adUsedTime;
    }

    /**
     * 
     * Returns the rsColor
     * @return String
     * 
     */
    public String getRsColor() {
        return rsColor;
    }
    /**
     * @param rsColor The rsColor to set.
     */
    public void setRsColor(String rsColor) {
        this.rsColor = rsColor;
    }

    /**
     * 
     * Returns the rsSpecific
     * @return String
     * 
     */
    public String getRsSpecific() {
        return rsSpecific;
    }
    /**
     * @param rsSpecific The rsSpecific to set.
     */
    public void setRsSpecific(String rsSpecific) {
        this.rsSpecific = rsSpecific;
    }
    /**
     * 
     * Returns the rsTotalTime
     * @return Integer
     * 
     */
    public Double getRsTotalTime() {
        return rsTotalTime;
    }
    /**
     * @param rsTotalTime The rsTotalTime to set.
     */
    public void setRsTotalTime(Double rsTotalTime) {
        this.rsTotalTime = rsTotalTime;
    }
    /**
     * 
     * Returns the rsUsedTime
     * @return Integer
     * 
     */
    public Double getRsUsedTime() {
        return rsUsedTime;
    }
    /**
     * @param rsUsedTime The rsUsedTime to set.
     */
    public void setRsUsedTime(Double rsUsedTime) {
        this.rsUsedTime = rsUsedTime;
    }
    /**
     * 
     * Returns the adLength
     * @return Integer
     * 
     */
    public Double getAdLength() {
        return adLength;
    }

    /**
     * 
     * Returns the day
     * @return Integer
     * 
     */
    public Integer getDay() {
        return day;
    }
    /**
     * 
     * Returns the dayDate
     * @return Integer
     * 
     */
    public Integer getDayDate() {
        return dayDate;
    }
    /**
     * 
     * Returns the dayShort
     * @return String
     * 
     */
    public String getDayShort() {
        return dayShort;
    }
    /**
     * 
     * Returns the month
     * @return Integer
     * 
     */
    public Integer getMonth() {
        return month;
    }
    /**
     * 
     * Returns the right
     * @return Boolean
     * 
     */
 
    /**
     * 
     * Returns the year
     * @return Integer
     */
    public Integer getYear() {
        return year;
    }
    
    /**
	 * 
	 * Returns the isLimit
	 * @return Boolean 
	 * 
	 */
	public Boolean getIsLimit() {
		return isLimit;
	}

	/**
	 * 
	 * Returns the isPublish
	 * @return Boolean 
	 * 
	 */
	public Boolean getIsPublish() {
		return isPublish;
	}


	

    /**
     * @param adLength The adLength to set.
     */
    public void setAdLength(Double adLength) {
        this.adLength = adLength;
    }
    /**
     * @param alert The alert to set.
     */
  
    /**
     * @param day The day to set.
     */
    public void setDay(Integer day) {
        this.day = day;
    }
    /**
     * @param dayDate The dayDate to set.
     */
    public void setDayDate(Integer dayDate) {
        this.dayDate = dayDate;
    }
    /**
     * @param dayShort The dayShort to set.
     */
    public void setDayShort(String dayShort) {
        this.dayShort = dayShort;
    }
    /**
     * @param month The month to set.
     */
    public void setMonth(Integer month) {
        this.month = month;
    }
    /**
     * @param right The right to set.
     */

    /**
     * @param year The year to set.
     */
    public void setYear(Integer year) {
        this.year = year;
    }
    
    /**
     * 
     * Returns the resourceDayId
     * @return Long
     */
    public Long getResourceDayId() {
        return resourceDayId;
    }
    /**
     * @param resourceDayId The resourceDayId to set.
     */
    public void setResourceDayId(Long resourceDayId) {
        this.resourceDayId = resourceDayId;
    }
    

    
    /**
     * 
     * Returns the adDayInfoId
     * @return Long
     * 
     */
    public Long getAdDayInfoId() {
        return adDayInfoId;
    }
    /**
     * @param adDayInfoId The adDayInfoId to set.
     */
    public void setAdDayInfoId(Long adDayInfoId) {
        this.adDayInfoId = adDayInfoId;
    }
    
    
	/** 
	 * @param isPublish The isPublish to set.
	 */
	public void setIsPublish(Boolean isPublish) {
		this.isPublish = isPublish;
	}
	
	/** 
	 * @param isLimit The isLimit to set.
	 */
	public void setIsLimit(Boolean isLimit) {
		this.isLimit = isLimit;
	}
 
    
    
    
    
    
    
    
    
    
    
    
    /**
     * @see java.lang.Object#equals(Object)
     */
    public boolean equals(Object object) {
        if (!(object instanceof DayInfoArray)) {
            return false;
        }
        DayInfoArray rhs = (DayInfoArray) object;
        return new EqualsBuilder().append(this.adTimes, rhs.adTimes).append(
                this.month, rhs.month).append(this.dayShort, rhs.dayShort)
                .append(this.day, rhs.day).append(this.dayDate, rhs.dayDate)
                .append(this.rsColor, rhs.rsColor).append(this.rsAlert,
                        rhs.rsAlert).append(this.year, rhs.year).append(
                        this.resourceDayId, rhs.resourceDayId).append(
                        this.rsUsedTime, rhs.rsUsedTime).append(
                        this.adUsedTime, rhs.adUsedTime).append(this.adLength,
                        rhs.adLength).append(this.adSpecific, rhs.adSpecific)
                .append(this.rsSpecific, rhs.rsSpecific).append(
                        this.rsTotalTime, rhs.rsTotalTime).append(this.adPrice,
                        rhs.adPrice).isEquals();
    }
    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder(-2073173905, 1306147039)
                .append(this.adTimes).append(this.month).append(this.dayShort)
                .append(this.day).append(this.dayDate).append(this.rsColor)
                .append(this.rsAlert).append(this.year).append(
                        this.resourceDayId).append(this.rsUsedTime).append(
                        this.adUsedTime).append(this.adLength).append(
                        this.adSpecific).append(this.rsSpecific).append(
                        this.rsTotalTime).append(this.adPrice).toHashCode();
    }
    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return new ToStringBuilder(this).append("adLength", this.adLength)
                .append("rsSpecific", this.rsSpecific).append("rsUsedTime",
                        this.rsUsedTime).append("month", this.month).append(
                        "adSpecific", this.adSpecific).append("adTimes",
                        this.adTimes).append("adUsedTime", this.adUsedTime)
                .append("day", this.day).append("dayDate", this.dayDate)
                .append("rsColor", this.rsColor).append("year", this.year)
                .append("rsAlert", this.rsAlert).append("rsTotalTime",
                        this.rsTotalTime).append("dayShort", this.dayShort)
                .append("adPrice", this.adPrice).append("resourceDayId",
                        this.resourceDayId).toString();
    }




	/**
	 * 
	 * Returns the disable
	 * @return Boolean 
	 * 
	 * @hibernate.property length="128" column="disable" not-null="false"
	 */
	public Boolean getDisabled() {
		return disabled;
	}
	/** 
	 * @param disable The disable to set.
	 */
	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	/**
	 * 
	 * Returns the rsReleave
	 * @return Integer 
	 * 
	 */
	public Double getRsReleave() {
		return rsReleave;
	}
	/** 
	 * @param rsReleave The rsReleave to set.
	 */
	public void setRsReleave(Double rsReleave) {
		this.rsReleave = rsReleave;
	}
	/**
	 * 
	 * Returns the curSpecificed
	 * @return Boolean 
	 * 
	 */
	public Boolean getCurSpecificed() {
		return curSpecificed;
	}
	/** 
	 * @param curSpecificed The curSpecificed to set.
	 */
	public void setCurSpecificed(Boolean curSpecificed) {
		this.curSpecificed = curSpecificed;
	}
	/**
	 * 
	 * Returns the isAdSpecificed
	 * @return Boolean 
	 * 
	 */
	public Boolean getIsAdSpecificed() {
		return isAdSpecificed;
	}
	/** 
	 * @param isAdSpecificed The isAdSpecificed to set.
	 */
	public void setIsAdSpecificed(Boolean isAdSpecificed) {
		this.isAdSpecificed = isAdSpecificed;
	}
	/**
	 * 
	 * Returns the isResSpecificed
	 * @return Boolean 
	 * 
	 */
	public Boolean getIsResSpecificed() {
		return isResSpecificed;
	}
	/** 
	 * @param isResSpecificed The isResSpecificed to set.
	 */
	public void setIsResSpecificed(Boolean isResSpecificed) {
		this.isResSpecificed = isResSpecificed;
	}
	/**
	 * 
	 * Returns the isCompages
	 * @return Boolean 
	 * 
	 */
	public Boolean getIsCompages() {
		return isCompages;
	}
	/** 
	 * @param isCompages The isCompages to set.
	 */
	public void setIsCompages(Boolean isCompages) {
		this.isCompages = isCompages;
	}
	public Boolean getResEnable() {
		return resEnable;
	}
	public void setResEnable(Boolean resEnable) {
		this.resEnable = resEnable;
	}
	public Boolean getResIsManual() {
		return resIsManual;
	}
	public void setResIsManual(Boolean resIsManual) {
		this.resIsManual = resIsManual;
	}
	public Boolean getResIsOverweight() {
		return resIsOverweight;
	}
	public void setResIsOverweight(Boolean resIsOverweight) {
		this.resIsOverweight = resIsOverweight;
	}
	public Boolean getResIsSeralized() {
		return resIsSeralized;
	}
	public void setResIsSeralized(Boolean resIsSeralized) {
		this.resIsSeralized = resIsSeralized;
	}
	public Boolean getResIsValidate() {
		return resIsValidate;
	}
	public void setResIsValidate(Boolean resIsValidate) {
		this.resIsValidate = resIsValidate;
	}
	public Long getResourceId() {
		return resourceId;
	}
	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}

	public Long getAdOrderDetailId() {
		return adOrderDetailId;
	}
	public void setAdOrderDetailId(Long adOrderDetailId) {
		this.adOrderDetailId = adOrderDetailId;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getRsModifyTime() {
		return rsModifyTime;
	}
	public void setRsModifyTime(String rsModifyTime) {
		this.rsModifyTime = rsModifyTime;
	}
	public Double getDayRelIncome() {
		return dayRelIncome;
	}
	public void setDayRelIncome(Double dayRelIncome) {
		this.dayRelIncome = dayRelIncome;
	}
	public Double getDayRelPuton() {
		return dayRelPuton;
	}
	public void setDayRelPuton(Double dayRelPuton) {
		this.dayRelPuton = dayRelPuton;
	}
	public Integer getWeak() {
		return weak;
	}
	public void setWeak(Integer weak) {
		this.weak = weak;
	}
	public String getWeakStr() {
		return weakStr;
	}
	public void setWeakStr(String weakStr) {
		this.weakStr = weakStr;
	}





}
