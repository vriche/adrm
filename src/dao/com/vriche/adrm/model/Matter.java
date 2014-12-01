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
public class Matter extends BaseObjectWithoutNestedFormValidation {


	private static final long serialVersionUID = -8934210964391333994L;
	protected Long id;
    protected String name;  // required
    protected String edit;
    protected String length;
    protected Long brandId;     //ÐÐÒµ
    protected Long brandId2;    //Æ·ÅÆ

	protected Long customerId;
    protected Integer matterType;
    protected String tapeCode;

    protected Long createBy;				  //default sysdate
    protected Date createDate;					  
    protected Long modifyBy;				  //default sysdate
    protected Long orderId;				 
    
    protected Date modifyDate;					  
    protected Integer version;
    protected String memo;
    protected Boolean enable;
    
    protected Customer customer = new Customer();
    protected MatterType matType = new MatterType();
    protected Carrier carrier = new Carrier();
    
    protected String startDate;
    protected String endDate;
    protected String[] carrierIds;
    protected String[] resourceIds;
    protected String[] customerIds;
    protected String[] userIds;
    protected String[] matterNames;
    
    protected Long industryType;
    
    protected Industry industry = new Industry();
    protected Brand brand = new Brand();
    
    
    
 
	private Long orgId;
    protected String loginUser ="";
    protected String helpCodeName;
    protected String helpCodeEdit;
    protected List tapeCodeList = new ArrayList();
    protected String inDayangMatter;
    
    protected String save2dayang = "";
    
      
 
    public Matter(){};
    public Matter(String name) {
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
     * Returns the enable
     * @return Boolean
     * 
     * @hibernate.property  column="enable" not-null="true"  type="yes_no"
     */
    public Boolean getEnable() {
        return enable;
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
    public Long getBrandId2() {
		return brandId2;
	}
	public void setBrandId2(Long brandId2) {
		this.brandId2 = brandId2;
	}
    /**
     * 
     * Returns the brandId
     * @return Long
     * 
     * @hibernate.property length="20" column="adver_product_brand_id" not-null="false"
     */
    public Long getBrandId() {
        return brandId;
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
     * @param brandId The brandId to set.
     */
    public void setBrandId(Long brandId) {
        this.brandId = brandId;
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
     * @param enable The enable to set.
     */
    public void setEnable(Boolean enable) {
        this.enable = enable;
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
     * @param version The version to set.
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
    /**
     * @param tapeCode The tapeCode to set.
     */
    public void setTapeCode(String tapeCode) {
        this.tapeCode = tapeCode;
    }
    
    
    /**
     * @see java.lang.Object#equals(Object)
     */
    public boolean equals(Object object) {
        if (!(object instanceof Matter)) {
            return false;
        }
        Matter rhs = (Matter) object;
        return new EqualsBuilder().append(
                this.memo, rhs.memo).append(this.matterType, rhs.matterType)
                .append(this.length, rhs.length).append(this.modifyBy,
                        rhs.modifyBy).append(this.modifyDate, rhs.modifyDate)
                .append(this.createDate, rhs.createDate).append(this.createBy,
                        rhs.createBy).append(this.brandId, rhs.brandId).append(
                        this.name, rhs.name).append(this.id, rhs.id).append(
                        this.enable, rhs.enable).append(this.version,
                        rhs.version).append(this.customerId, rhs.customerId)
                .append(this.edit, rhs.edit).isEquals();
    }
    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder(683754049, -242003591).append(this.memo).append(this.matterType)
                .append(this.length).append(this.modifyBy).append(
                        this.modifyDate).append(this.createDate).append(
                        this.createBy).append(this.brandId).append(this.name)
                .append(this.id).append(this.enable).append(this.version)
                .append(this.customerId).append(this.edit).toHashCode();
    }
    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return new ToStringBuilder(this).append("length", this.length).append(
                "name", this.name).append("modifyBy", this.modifyBy).append("tapeCode", this.tapeCode).append(
                "id", this.id).append("version", this.version).append(
                "customerId", this.customerId).append("modifyDate",
                this.modifyDate).append("enable", this.enable).append(
                "brandId", this.brandId).append("edit", this.edit).append(
                "memo", this.memo).append("createBy", this.createBy).append(
                "createDate", this.createDate).append("matterType",
                this.matterType).toString();
    }
    

	public Customer getCustomer() {
		return customer;
	}
	/**
	 * @param customer The customer to set.
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return Returns the matType.
	 */
	public MatterType getMatType() {
		return matType;
	}
	/**
	 * @param matType The matType to set.
	 */
	public void setMatType(MatterType matType) {
		this.matType = matType;
	}
	/**
	 * @return Returns the customerIds.
	 */
	public String[] getCustomerIds() {
		return customerIds;
	}
	/**
	 * @param customerIds The customerIds to set.
	 */
	public void setCustomerIds(String[] customerIds) {
		this.customerIds = customerIds;
	}
	/**
	 * @return Returns the resourceIds.
	 */
	public String[] getResourceIds() {
		return resourceIds;
	}
	/**
	 * @param resourceIds The resourceIds to set.
	 */
	public void setResourceIds(String[] resourceIds) {
		this.resourceIds = resourceIds;
	}
	/**
	 * @return Returns the userIds.
	 */
	public String[] getUserIds() {
		return userIds;
	}
	/**
	 * @param userIds The userIds to set.
	 */
	public void setUserIds(String[] userIds) {
		this.userIds = userIds;
	}
	/**
	 * @return Returns the matterNames.
	 */
	public String[] getMatterNames() {
		return matterNames;
	}
	/**
	 * @param matterNames The matterNames to set.
	 */
	public void setMatterNames(String[] matterNames) {
		this.matterNames = matterNames;
	}

	public Industry getIndustry() {
		return industry;
	}
	public void setIndustry(Industry industry) {
		this.industry = industry;
	}
	public Long getIndustryType() {
		return industryType;
	}
	public void setIndustryType(Long industryType) {
		this.industryType = industryType;
	}
	public Long getOrgId() {
		return orgId;
	}
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
	public String getLoginUser() {
		return loginUser;
	}
	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}
	public String[] getCarrierIds() {
		return carrierIds;
	}
	public void setCarrierIds(String[] carrierIds) {
		this.carrierIds = carrierIds;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getHelpCodeEdit() {
		return helpCodeEdit;
	}
	public void setHelpCodeEdit(String helpCodeEdit) {
		this.helpCodeEdit = helpCodeEdit;
	}
	public String getHelpCodeName() {
		return helpCodeName;
	}
	public void setHelpCodeName(String helpCodeName) {
		this.helpCodeName = helpCodeName;
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
	
    public static String decodeStringXML(String strData){
    	
        if (strData == null){return ""; }
        
        strData = strData.replace("&lt;", "<");
        strData = strData.replace("&gt;", ">");
        strData = strData.replace("&apos;", "'");
        strData = strData.replace("&quot;", "\"");
        strData = strData.replace("&amp;", "&");  	

        return strData;
    }
	public List getTapeCodeList() {
		return tapeCodeList;
	}
	public void setTapeCodeList(List tapeCodeList) {
		this.tapeCodeList = tapeCodeList;
	}
	public Carrier getCarrier() {
		return carrier;
	}
	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}
	public String getInDayangMatter() {
		return inDayangMatter;
	}
	public void setInDayangMatter(String inDayangMatter) {
		this.inDayangMatter = inDayangMatter;
	}
	public String getSave2dayang() {
		return save2dayang;
	}
	public void setSave2dayang(String save2dayang) {
		this.save2dayang = save2dayang;
	}	
	   public Brand getBrand() {
			return brand;
		}
		public void setBrand(Brand brand) {
			this.brand = brand;
		}
	
}
