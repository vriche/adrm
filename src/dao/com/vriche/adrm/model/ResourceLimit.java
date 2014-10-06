package com.vriche.adrm.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;



/**
 * ResourceLimit class
 * 
 * This class is used to 
 * 
 * <p><a href="ResourceLimit.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_ad_resource_time_limit"
 * 
 */
public class ResourceLimit extends BaseObjectWithoutNestedFormValidation {
	protected Long id;
	protected Integer version;  //年份
	protected Integer startTime;//开始时间	
	protected Integer endTime;//结束时间
	protected Integer limitTime; //13号令规定时间
	protected Long carrierId;	//频道名称
	
	protected String starT;	//开始时间	
	protected String starTh;	//开始时间	
	protected String starTm;	//开始时间	
	protected String starTs;	//开始时间	
	
	protected String endT;	//结束时间
	protected String endTh;	//结束时间
	protected String endTm;	//结束时间
	protected String endTs;	//结束时间
	
	protected String limitT;//13号令规定时间
	protected String limitTh;//13号令规定时间
	protected String limitTm;//13号令规定时间
	protected String limitTs;//13号令规定时间
	
	protected String usedT;	//已占用时间
	protected String preT;	//饱和度
	
	protected List resourceLimitIdList = new ArrayList();	//饱和度
	protected List resourceList = new ArrayList();
	
	
	
	protected Carrier carrier = new Carrier();
	
	protected Resource resource = new Resource();
	
	
	
	public ResourceLimit() {};
	 /**
     * @hibernate.id column="id" generator-class="native" unsaved-value="null"
     */
    public Long getId() {
        return id;
    }
    /**
     * @hibernate.version
     */
    public Integer getVersion() {
        return version;
    }
    /**
     * @hibernate.many-to-one name="carrierId" column="ad_resource_carrier_id" cascade="all" not-null="true"
 	 */
	public Carrier getCarrier() {
		return carrier;
	}


	

	
	 /**
     * Returns the startTime
     * @return Long
     * @hibernate.property length="20" column="start_time" not-null="true"
     */
	public Integer getStartTime() {
		return startTime;
	}
	 /**
     * Returns the endTime
     * @return Long
     * @hibernate.property length="20" column="end_time" not-null="true"
     */
	public Integer getEndTime() {
		return endTime;
	}

	
	
	 /**
     * Returns the limitTime
     * @return Integer
     * @struts.validator type="required"
     * @hibernate.property length="20" column="limit_time" not-null="true"
     */
	public Integer getLimitTime() {
		return limitTime;
	}
	


	/**
	 * @return Returns the carrierId.
	 */
	public Long getCarrierId() {
		return carrierId;
	}


	
	
	
	
	
	/**
	 * @return Returns the starT.
	 */
	public String getStarT() {
		String h = this.starTh;
		String m = this.starTm;
		String s = this.starTs;
		h = (h == null)||h.equals("")?"00":h;
		m = (m == null)||m.equals("")?"00":m;
		s = (s == null)||s.equals("")?"00":s;
		return h+":"+m+":"+s;
	}
	
	/**
	 * @return Returns the endT.
	 */
	public String getEndT() {
		String h = this.endTh;
		String m = this.endTm;
		String s = this.endTs;
		h = (h == null)||h.equals("")?"00":h;
		m = (m == null)||m.equals("")?"00":m;
		s = (s == null)||s.equals("")?"00":s;
		return h+":"+m+":"+s;
	}



	/**
	 * @return Returns the limitT.
	 */
	public String getLimitT() {
		String h = this.limitTh;
		String m = this.limitTm;
		String s = this.limitTs;
		h = (h == null)||h.equals("")?"00":h;
		m = (m == null)||m.equals("")?"00":m;
		s = (s == null)||s.equals("")?"00":s;
		return h+":"+m+":"+s;
	}
	
	
	
	
	
	/**
	 * @param id The id to set.
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @param carrierId The carrierId to set.
	 */
	public void setCarrierId(Long carrierId) {
		this.carrierId = carrierId;
	}

	/**
	 * @param startTime The startTime to set.
	 */
	public void setStartTime(Integer startTime) {
		this.startTime = startTime;
	}
	/**
	 * @param endTime The endTime to set.
	 */
	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}
	
	/**
	 * @param version The version to set.
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
	/**
	 * @param carrier The carrier to set.
	 */
	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}
	
	
	

	
	/**
	 * @param starT The starT to set.
	 */
	public void setStarT(String starT) {
		this.starT = this.starTh+":"+this.starTm+":"+this.starTs;
	}	
	/**
	 * @param endT The endT to set.
	 */
	public void setEndT(String endT) {
		this.endT = this.endTh +":"+this.endTm+":"+this.endTs;
	}
	/**
	 * @param limitT The limitT to set.
	 */
	public void setLimitT(String limitT) {
		this.limitT = this.limitTh+":"+this.limitTm+":"+this.limitTs;
	}

	/**
	 * @param limitTime The limitTime to set.
	 */
	public void setLimitTime(Integer limitTime) {
		this.limitTime = limitTime;
	}




	
    
    
    
	/**
	 * @return Returns the usedT.
	 */
	public String getUsedT() {
		return usedT;
	}
	/**
	 * @param usedT The usedT to set.
	 */
	public void setUsedT(String usedT) {
		this.usedT = usedT;
	}
	/**
	 * @return Returns the preT.
	 */
	public String getPreT() {
		return preT;
	}
	/**
	 * @param preT The preT to set.
	 */
	public void setPreT(String preT) {
		this.preT = preT;
	}
	/**
	 * @return Returns the resourceLimitIdList.
	 */
	public List getResourceLimitIdList() {
		return resourceLimitIdList;
	}
	/**
	 * @param resourceLimitIdList The resourceLimitIdList to set.
	 */
	public void setResourceLimitIdList(List resourceLimitIdList) {
		this.resourceLimitIdList = resourceLimitIdList;
	}
	
	
	
	
	/**
	 * @param starTh The starTh to set.
	 */
	public void setStarTh(String starTh) {
		
		this.starTh = starTh;
	}

	/**
	 * @param starTm The starTm to set.
	 */
	public void setStarTm(String starTm) {
		this.starTm =  starTm;
	}

	/**
	 * @param starTs The starTs to set.
	 */
	public void setStarTs(String starTs) {
		this.starTs = starTs;
	}

	/**
	 * @param endTh The endTh to set.
	 */
	public void setEndTh(String endTh) {
		this.endTh = endTh;
	}

	/**
	 * @param endTm The endTm to set.
	 */
	public void setEndTm(String endTm) {
		this.endTm = endTm;
	}

	/**
	 * @param endTs The endTs to set.
	 */
	public void setEndTs(String endTs) {
		this.endTs = endTs;
	}



	
	
	
	
	/**
	 * @return Returns the starTh.
     * @struts.validator type="required"
	 */
	public String getStarTh() {
		return  starTh;
	}
	/**
	 * @return Returns the starTm.
     * @struts.validator type="required"
	 */
	public String getStarTm() {
		return  starTm;
	}
	/**
	 * @return Returns the starTs.
	 */
	public String getStarTs() {
		return starTs;
	}
	

	
	
	/**
	 * @return Returns the endTh.
   * @struts.validator type="required"
	 */
	public String getEndTh() {
		return endTh;
	}
	/**
	 * @return Returns the endTm.
     * @struts.validator type="required"
	 */
	public String getEndTm() {
		return endTm;
	}
	/**
	 * @return Returns the endTs.
	 */
	public String getEndTs() {
		return endTs;
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
	 * @return Returns the limitTh.
	 */
	public String getLimitTh() {
		return limitTh;
	}
	/**
	 * @param limitTh The limitTh to set.
	 */
	public void setLimitTh(String limitTh) {
		this.limitTh = limitTh;
	}
	/**
	 * @return Returns the limitTm.
	 */
	public String getLimitTm() {
		return limitTm;
	}
	/**
	 * @param limitTm The limitTm to set.
	 */
	public void setLimitTm(String limitTm) {
		this.limitTm = limitTm;
	}
	/**
	 * @return Returns the limitTs.
	 */
	public String getLimitTs() {
		return limitTs;
	}
	/**
	 * @param limitTs The limitTs to set.
	 */
	public void setLimitTs(String limitTs) {
		this.limitTs = limitTs;
	}
	/**
	 * @return Returns the resource.
	 */
	public Resource getResource() {
		return resource;
	}
	/**
	 * @param resource The resource to set.
	 */
	public void setResource(Resource resource) {
		this.resource = resource;
	}
	/**
	 * @return Returns the resourceList.
	 */
	public List getResourceList() {
		return resourceList;
	}
	/**
	 * @param resourceList The resourceList to set.
	 */
	public void setResourceList(List resourceList) {
		this.resourceList = resourceList;
	}
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("limitT", this.limitT).append(
				"limitTh", this.limitTh).append("id", this.id).append(
				"carrierId", this.carrierId).append("starTs", this.starTs)
				.append("starTh", this.starTh).append("endTh", this.endTh)
				.append("limitTime", this.limitTime).append("startTime",
						this.startTime).append("resourceLimitIdList",
						this.resourceLimitIdList).append("starT", this.starT)
				.append("endTs", this.endTs).append("resourceList",
						this.resourceList).append("preT", this.preT).append(
						"starTm", this.starTm).append("limitTs", this.limitTs)
				.append("endTm", this.endTm).append("limitTm", this.limitTm)
				.append("usedT", this.usedT).append("endTime", this.endTime)
				.append("version", this.version).append("endT", this.endT).toString();
	}
	
	


}
