/****************************************************************************     
 * Created on 2006-10-16                                                     *    
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
 * OrderLog class
 * 
 * This class is used to 
 * 
 * <p><a href="OrderLog.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_order_log"
 * 
 */
public class OrderLog extends BaseObject {
	private static final long serialVersionUID = -4346968425068428146L;
	protected Long id;
    protected Log log = new Log();
    protected Long orderId;			// required
    protected Long orderDetailId;			// required
    protected String changeContent;			
    protected Integer version;
    
    protected Order order = new Order();

    /**
     * @hibernate.id length="20"  column="order_log_id" generator-class="native" unsaved-value="null"
     */
    public Long getId() {
        return id;
    }
    /**
     * 
     * Returns the orderId
     * @return Long
     * @struts.validator type="required"
     * @hibernate.property length="20" column="order_id" not-null="false"
     */
    public Long getOrderId() {
        return orderId;
    }
    
	  /**
     * 
     * Returns the order_detail_id
     * @return Long
     * @struts.validator type="required"
     * @hibernate.property length="20" column="order_detail_id" not-null="false"
     */
	public Long getOrderDetailId() {
		return orderDetailId;
	}
    /**
     * 
     * Returns the changeContent
     * @return String
     * @struts.validator 
     * @hibernate.property length="512" column="change_content" not-null="true"
     */
	public String getChangeContent() {
		return changeContent;
	} 
    
    
    /**
     * @hibernate.component
     */
    public Log getLog() {
        return log;
    }
    
    /**
     * @hibernate.version
     */
    public Integer getVersion() {
        return version;
    }
    
    
    /**
     * @param id The id to set.
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @param log The log to set.
     */
    public void setLog(Log log) {
        this.log = log;
    }
    /**
     * @param version The version to set.
     */
    public void setVersion(Integer version) {
        this.version = version;
    }


    /**
     * @param orderId The orderId to set.
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    
    

    /**
     * @see java.lang.Object#equals(Object)
     */
    public boolean equals(Object object) {
        if (!(object instanceof OrderLog)) {
            return false;
        }
        OrderLog rhs = (OrderLog) object;
        return new EqualsBuilder().append(
                this.orderId, rhs.orderId).append(this.id, rhs.id).append(
                this.version, rhs.version).isEquals();
    }
    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder(2010826489, 1624230799).append(this.orderId).append(this.id).append(
                this.version).toHashCode();
    }
    /**
	 * @param changeContent The changeContent to set.
	 */
	public void setChangeContent(String changeContent) {
		this.changeContent = changeContent;
	}
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("id", this.id).append(
				"version", this.version).append("changeContent",
				this.changeContent).append("getLog", this.getLog().toString()).append("orderId", this.orderId).toString();
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * @param orderDetailId The orderDetailId to set.
	 */
	public void setOrderDetailId(Long orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
}
