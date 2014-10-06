/****************************************************************************     
 * Created on 2006-10-15                                                     *    
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

import com.vriche.adrm.model.BaseObject;
/**
 * PriceDetail class
 * 
 * This class is used to 
 * 
 * <p><a href="PriceDetail.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_ad_resource_price_detail"
 * 
 */
public class PriceDetail extends BaseObject {
	private static final long serialVersionUID = -4025216768069333798L;
	protected Long id;
    protected String length;
    protected Double price;				  
    protected Integer version;
    protected Long priceId;

    public PriceDetail(){
    	this.length = "0";
    	this.price = new Double("0");
    };


    /**
     * @hibernate.id column="ad_resource_price_detail_id" generator-class="native" unsaved-value="null"
     */
    public Long getId() {
        return id;
    }
    /**
     * 
     * Returns the length
     * @return String
     * 
     * @hibernate.property length="32" column="length" not-null="false"
     */
    public String getLength() {
        return length;
    }
    /**
     * 
     * Returns the price
     * @return Double
     * @struts.validator type="required"
     * @hibernate.property length="12" column="price" not-null="true"
     */
    public Double getPrice() {
        return price;
    }
    /**
     * @hibernate.version
     */
    public Integer getVersion() {
        return version;
    }

    
	public Long getPriceId() {
		return priceId;
	}


	public void setPriceId(Long priceId) {
		this.priceId = priceId;
	}  
    

    /**
     * @param id The id to set.
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @param length The length to set.
     */
    public void setLength(String length) {
        this.length = length;
    }
    /**
     * @param price The price to set.
     */
    public void setPrice(Double price) {
        this.price = price;
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
		if (!(object instanceof PriceDetail)) {
			return false;
		}
		PriceDetail rhs = (PriceDetail) object;
		return new EqualsBuilder().append(this.priceId, rhs.priceId).append(
				this.price, rhs.price).append(this.length, rhs.length).append(
				this.id, rhs.id).append(this.version, rhs.version).isEquals();
	}


	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(155048817, 614665855).append(this.priceId)
				.append(this.price).append(this.length).append(this.id).append(
						this.version).toHashCode();
	}


	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("length", this.length).append(
				"id", this.id).append("version", this.version).append("price",
				this.price).append("priceId", this.getPriceId()).toString();
	}



}
