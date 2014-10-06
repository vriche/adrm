
/****************************************************************************     
 * Created on 2006-6-27                                                     *    
 *                                                               			*
 * @author <a href="mailto:hongxilin@yahoo.com.cn">hongxi</a>               *
 *         Updated by hongxi (hongxilin@yahoo.com.cn)                       *
 *                                                                          *
 * @version  Vision:1.0														*
 * 																			*
 ***************************************************************************/

package com.vriche.adrm.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
/**
 * SysSequence class
 * 
 * <p><a href="SysSequence.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_sys_sequence"
 */
public class SysSequence  extends BaseObjectWithoutNestedFormValidation implements Serializable{
	
    private static final long serialVersionUID = 3832626162173359411L;
	
	// primary key
	protected java.lang.Long id;
	// fields
	protected java.lang.String suffix;
	protected java.lang.Long currentNext;
	protected java.lang.String prefix;
	protected java.lang.Long incrementNo;
	protected java.lang.Long startNo;
	protected java.lang.Long currentNextSys;
	protected java.lang.String name;  // required
	protected java.lang.String format;
	
	
	protected java.lang.Integer version;
	
	public SysSequence() {
	}
	
	

	/**
	 * @hibernate.id column="sequence_id" generator-class="native"
	 *               unsaved-value="version"
	 */
	public java.lang.Long getId() {
		return id;
	}
    /**
     * 
     * Returns the name
     * @return java.lang.String
     * 
     *  @struts.validator type="required"
     * @hibernate.property column="name" not-null="false" update="true" length="50" 
     */
	
	
    public java.lang.String getName() {
        return name;
    }
    /**
     * 
     * Returns the prefix
     * @return java.lang.String
     * 
     * @hibernate.property column="prefix" not-null="false" update="true" length="50" 
     */
    public java.lang.String getPrefix() {
        return prefix;
    }
    
    /**
     * 
     * Returns the startNo
     * @return java.lang.Long
     * 
     * @struts.validator type="required"
     * @hibernate.property column="start_no" not-null="false" update="true" length="50" 
     */
    public java.lang.Long getStartNo() {
        return startNo;
    }
    /**
     * 
     * Returns the incrementNo
     * @return java.lang.Long
     * 
     * @struts.validator type="required"
     * @hibernate.property column="increment_no" not-null="false" update="true"
     */
    public java.lang.Long getIncrementNo() {
        return incrementNo;
    }
    
    /**
     * 
     * Returns the format
     * @return java.lang.String
     * 
     * @hibernate.property column="format" not-null="false" update="true"
     */
    public java.lang.String getFormat() {
        return format;
    }
    
    /**
     * 
     * Returns the currentNext
     * @return java.lang.Long
     * 
     * @struts.validator type="required"
     * @hibernate.property column="current_next" not-null="false" update="true"
     */
    public java.lang.Long getCurrentNext() {
        return currentNext;
    }
    /**
     * 
     * Returns the currentNextSys
     * @return java.lang.Long
     * 
     * @struts.validator type="required"
     * @hibernate.property column="current_next_sys" not-null="false" update="true"
     */
    public java.lang.Long getCurrentNextSys() {
        return currentNextSys;
    }


    /**
     * 
     * Returns the suffix
     * @return java.lang.String
     * 
     * @hibernate.property column="suffix" not-null="false" update="true"
     */
    public java.lang.String getSuffix() {
        return suffix;
    }
     
    
	/**
     * @return Returns the updated version.
     * @hibernate.version column="version"
	 */
	public java.lang.Integer getVersion() {
		return version;
	}
		
	

    
    
    /**
     * @param currentNext The currentNext to set.
     */
    public void setCurrentNext(java.lang.Long currentNext) {
        this.currentNext = currentNext;
    }
    /**
     * @param currentNextSys The currentNextSys to set.
     */
    public void setCurrentNextSys(java.lang.Long currentNextSys) {
        this.currentNextSys = currentNextSys;
    }
    /**
     * @param format The format to set.
     */
    public void setFormat(java.lang.String format) {
        this.format = format;
    }
    /**
     * @param incrementNo The incrementNo to set.
     */
    public void setIncrementNo(java.lang.Long incrementNo) {
        this.incrementNo = incrementNo;
    }
    /**
     * @param name The name to set.
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }
    /**
     * @param prefix The prefix to set.
     */
    public void setPrefix(java.lang.String prefix) {
        this.prefix = prefix;
    }
    /**
     * @param sequenceID The sequenceID to set.
     */
    public void setId(java.lang.Long id) {
        this.id = id;
    }
    /**
     * @param startNo The startNo to set.
     */
    public void setStartNo(java.lang.Long startNo) {
        this.startNo = startNo;
    }
    /**
     * @param suffix The suffix to set.
     */
    public void setSuffix(java.lang.String suffix) {
        this.suffix = suffix;
    }
    /**
     * @param version The version to set.
     */
    public void setVersion(java.lang.Integer version) {
        this.version = version;
    }
	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof SysSequence)) {
			return false;
		}
		SysSequence rhs = (SysSequence) object;
		return new EqualsBuilder().append(this.suffix, rhs.suffix).append(
				this.currentNext, rhs.currentNext).append(this.prefix,
				rhs.prefix).append(this.incrementNo, rhs.incrementNo).append(
				this.currentNextSys, rhs.currentNextSys).append(this.startNo,
				rhs.startNo).append(this.name, rhs.name)
				.append(this.id, rhs.id).append(this.version, rhs.version)
				.append(this.format, rhs.format).isEquals();
	}


	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-480444741, -1457962447).append(this.suffix)
				.append(this.currentNext).append(this.prefix).append(
						this.incrementNo).append(this.currentNextSys).append(
						this.startNo).append(this.name).append(this.id).append(
						this.version).append(this.format).toHashCode();
	}


	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this)
				.append("incrementNo", this.incrementNo).append("currentNext",
						this.currentNext).append("name", this.name).append(
						"prefix", this.prefix).append("id", this.id).append(
						"version", this.version).append("format", this.format)
				.append("suffix", this.suffix).append("startNo", this.startNo)
				.append("currentNextSys", this.currentNextSys).toString();
	}
}
