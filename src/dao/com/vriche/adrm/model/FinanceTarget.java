package com.vriche.adrm.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;




/**
 * FinanceTarget class
 * 
 * This class is used to 
 * 
 * <p><a href="FinanceTarget.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_finance_target"
 * 
 */
public class FinanceTarget extends BaseObjectWithoutNestedFormValidation {

	private static final long serialVersionUID = 1L;
	protected Long id;
    protected Long carrierId;	//required
    protected String carrierName;
    protected Integer targetDateYear;             //日期
    protected Integer targetDateMonth;             //日期
    protected Double targetMoney;
    protected Long createBy;				  //default sysdate
    protected Date createDate;					  
    protected Long modifyBy;				  //default sysdate
    protected Date modifyDate;					  
    protected Integer version;
    
    protected Double relIncome;
    protected Double relPut;
    protected String used;
    protected String sumUsed;
    protected String targetMonth;
    
    protected Carrier carrier = new Carrier();
    protected String[] tarMonths = new String[13]; 
    
    protected List carrierIdList = new ArrayList();
    
    protected List yearIdList = new ArrayList();
    
    
    
    /**
     * @hibernate.id column="finance_target_id" generator-class="native" unsaved-value="null"
     */
	public Long getId() {
		return id;
	}
	/**
	 * @return Returns the carrierId.
	 * @struts.validator type="required"
	 */
	public Long getCarrierId() {
		return carrierId;
	}

    /**
     * 
     * Returns the targetDateYear
     * @return Integer
     * 
     * @hibernate.property length="4" column="year" not-null="true"
     */
	public Integer getTargetDateYear() {
		return targetDateYear;
	}
	
    /**
     * 
     * Returns the targetDateMonth
     * @return Integer
     * 
     * @hibernate.property length="2" column="month" not-null="true"
     */
	public Integer getTargetDateMonth() {
		return targetDateMonth;
	}



    /**
     * 
     * Returns the targetMoney
     * @return Double
     * 
     * @hibernate.property length="12" column="money" not-null="true"
     */
	public Double getTargetMoney() {
		return targetMoney;
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
		 * @return Returns the tarMonths.
		 */
		public String[] getTarMonths() {
			return tarMonths;
		}
		
	   
		/**
	     * @hibernate.many-to-one name="carrierId" column="ad_resource_carrier_id" cascade="all" not-null="true"
	 	 */
		public Carrier getCarrier() {
			return carrier;
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
		 * @param targetDateMonth The targetDateMonth to set.
		 */
		public void setTargetDateMonth(Integer targetDateMonth) {
			this.targetDateMonth = targetDateMonth;
		}
		/**
		 * @param targetDateYear The targetDateYear to set.
		 */
		public void setTargetDateYear(Integer targetDateYear) {
			this.targetDateYear = targetDateYear;
		}
		/**
		 * @param targetMoney The targetMoney to set.
		 */
		public void setTargetMoney(Double targetMoney) {
			this.targetMoney = targetMoney;
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
		 * @param tarMonths The tarMonths to set.
		 */
		public void setTarMonths(String[] tarMonths) {
			this.tarMonths = tarMonths;
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
	public List getCarrierIdList() {
		return carrierIdList;
	}
	public void setCarrierIdList(List carrierIdList) {
		this.carrierIdList = carrierIdList;
	}
	public String getCarrierName() {
		return carrierName;
	}
	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}
	public Double getRelIncome() {
		return relIncome;
	}
	public void setRelIncome(Double relIncome) {
		this.relIncome = relIncome;
	}
	public Double getRelPut() {
		return relPut;
	}
	public void setRelPut(Double relPut) {
		this.relPut = relPut;
	}
	public String getTargetMonth() {
		return targetMonth;
	}
	public void setTargetMonth(String targetMonth) {
		this.targetMonth = targetMonth;
	}
	public String getUsed() {
		return used;
	}
	public void setUsed(String used) {
		this.used = used;
	}
	/**
	 * @return Returns the sumUsed.
	 */
	public String getSumUsed() {
		return sumUsed;
	}
	/**
	 * @param sumUsed The sumUsed to set.
	 */
	public void setSumUsed(String sumUsed) {
		this.sumUsed = sumUsed;
	}
	public List getYearIdList() {
		return yearIdList;
	}
	public void setYearIdList(List yearIdList) {
		this.yearIdList = yearIdList;
	}





}
