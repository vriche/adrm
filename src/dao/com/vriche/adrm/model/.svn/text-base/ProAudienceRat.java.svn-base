package com.vriche.adrm.model;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * ProAudienceRat class
 * 
 * This class is used to 
 * 
 * <p><a href="ProCustomer.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * 
 * @hibernate.class table="tb_pro_audience_rat"
 */

public class ProAudienceRat extends BaseObjectWithoutNestedFormValidation implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Long id;               //计划id  20
	protected Long carrierId;	         //频道id 20
	protected Integer audienceDate ;       //收视日期12
	protected Integer audienceTime ;       //时间段12
	protected Double audienceRat;       //收视率 20
	
    protected Integer version;
    
    protected Carrier carrier = new Carrier();
    
    protected ParamClass paramClass = new ParamClass();
    

    
    
    
    
    /**
     * @hibernate.many-to-one name="programId" column="carrier_id" cascade="all" not-null="true"
 	 */
	public Carrier getCarrier() {
		return carrier;
	}

	/**
     * 
     * Returns the AudienceDate
     * @return Integer
     * 
     * @hibernate.property column="audience_date" length="12" update="false" insert="true" type="timestamp"
     */
	public Integer getAudienceDate() {
		return audienceDate;
	}

	/**
     * 
     * Returns the AudienceRat
     * @return Double
     * 
     * @hibernate.property column="audience_rat" length="20" update="false" insert="true" 
     */
	public Double getAudienceRat() {
		return audienceRat;
	}

	/**
     * 
     * Returns the AudienceTime
     * @return Integer
     * 
     * @hibernate.property column="audience_time" length="12" update="false" insert="true" type="timestamp"
     */
	public Integer getAudienceTime() {
		return audienceTime;
	}

	/**
     * 
     * Returns the carrierId
     * @return Long
     * 
     * @hibernate.property length="20" column="carrier_id" not-null="false"
     */
	public Long getCarrierId() {
		return carrierId;
	}

	/**
     * @hibernate.id column="id" generator-class="native" unsaved-value="null"
     */
	public Long getId() {
		return id;
	}

	 /**
     * @hibernate.version length="10"  column="version"
     */
	public Integer getVersion() {
		return version;
	}
	
	
	
	
	



	/**
	 * @param audienceDate The audienceDate to set.
	 */
	public void setAudienceDate(Integer audienceDate) {
		this.audienceDate = audienceDate;
	}

	/**
	 * @param audienceRat The audienceRat to set.
	 */
	public void setAudienceRat(Double audienceRat) {
		this.audienceRat = audienceRat;
	}

	/**
	 * @param audienceTime The audienceTime to set.
	 */
	public void setAudienceTime(Integer audienceTime) {
		this.audienceTime = audienceTime;
	}

	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}

	public void setCarrierId(Long carrierId) {
		this.carrierId = carrierId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setVersion(Integer version) {
		this.version = version;
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
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("id", this.id).append(
				"version", this.version).append("carrierId", this.carrierId)
				.append("audienceTime", this.audienceTime).append(
						"audienceDate", this.audienceDate).append("carrier",
						this.carrier).append("audienceRat", this.audienceRat)
				.toString();
	}

	/**
	 * @return Returns the paramClass.
	 */
	public ParamClass getParamClass() {
		return paramClass;
	}

	/**
	 * @param paramClass The paramClass to set.
	 */
	public void setParamClass(ParamClass paramClass) {
		this.paramClass = paramClass;
	}

	
}