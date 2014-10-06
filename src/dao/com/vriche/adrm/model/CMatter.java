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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.vriche.adrm.model.BaseObject;
/**
 * Matter class
 * 
 * This class is used to 
 * 
 * <p><a href="Matter.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_adver_matter"
 * 
 */
public class CMatter extends BaseObjectWithoutNestedFormValidation {

	private static final long serialVersionUID = 8893210427912412016L;
	protected Long id;
    protected String name;  // required
    protected String edit;
    protected String length;
    protected Long customerId;
    protected Integer matterType;
    protected String tapeCode;
    protected Integer industryType;
    
    
    protected Industry industry = new Industry();

//    protected Long createBy;				  //default sysdate
//    protected Date createDate;					  
//    protected Long modifyBy;				  //default sysdate
//    protected Date modifyDate;					  
//    protected Integer version;
//    protected String memo;
//    protected Boolean enable;
//    
//    protected Customer customer = new Customer();
//    protected MatterType matType = new MatterType();
//    protected String startDate;
//    protected String endDate;
//    
//    protected String[] resourceIds;
//    protected String[] customerIds;
//    protected String[] userIds;
//    protected String[] matterNames;
    
    protected Long orgId;
 
    
    public CMatter(){};
    public CMatter(String name) {
        this.name = name;
    }

    /**
     * @hibernate.id column="adver_matter_id" generator-class="native" unsaved-value="null"
     */
    public Long getId() {
        return id;
    }
    /**
     * 
     * Returns the name
     * @return String
     * @struts.validator type="required"
     * @hibernate.property column="name" length="128" not-null="true"
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * Returns the edit
     * @return String
     * 
     * @hibernate.property length="128" column="edit" not-null="true"
     */
    public String getEdit() {
        return edit;
    }
    /**
     * 
     * Returns the length
     * @return String
     * @struts.validator type="required"
     * @hibernate.property length="32" column="length" not-null="true"
     */
    public String getLength() {
        return length;
    }
    /**
     * 
     * Returns the customerId
     * @return Long
     * @struts.validator type="required"
     * 
     * @hibernate.property length="20" column="customer_id" not-null="true"
     */
    public Long getCustomerId() {
        return customerId;
    }
    /**
     * 
     * Returns the matterType
     * @return Integer
     * 
     * @hibernate.property length="2" column="adver_matter_type" not-null="false"
     */
    public Integer getMatterType() {
        return matterType;
    }
    /**
     * 
     * Returns the tapeCode
     * @return String
     * 
     * @hibernate.property length="32" column="tape_code" not-null="false"
     */
    public String getTapeCode() {
        return tapeCode;
    }
    /**
     * @param customerId The customerId to set.
     */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    /**
     * @param edit The edit to set.
     */
    public void setEdit(String edit) {
        this.edit = edit;
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
     * @param matterType The matterType to set.
     */
    public void setMatterType(Integer matterType) {
        this.matterType = matterType;
    }
    /**
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @param tapeCode The tapeCode to set.
     */
    public void setTapeCode(String tapeCode) {
        this.tapeCode = tapeCode;
    }
    
    
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}
	public Integer getIndustryType() {
		return industryType;
	}
	public void setIndustryType(Integer industryType) {
		this.industryType = industryType;
	}
	public Long getOrgId() {
		return orgId;
	}
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
	public Industry getIndustry() {
		return industry;
	}
	public void setIndustry(Industry industry) {
		this.industry = industry;
	}
    
	public static String encodeStringXML(String strData){
        if (strData == null){return ""; }
        strData = strData.replace("&", "&amp;");
        strData = strData.replace("<", "&lt;");
        strData = strData.replace(">", "&gt;");
        strData = strData.replace("'", "&apos;");
        strData = strData.replace("\"", "&quot;");
        return strData;
	}

}
