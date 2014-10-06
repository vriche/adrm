/****************************************************************************     
 * Created on 2007-4-11                                      *    
 *                                                               			*
 * @author <a href="mailto:hongxilin@yahoo.com.cn">hongxi</a>               *
 *         Updated by hongxi (hongxilin@yahoo.com.cn)                       *
 *                                                                          *
 * @version  Vision:1.0														*
 * 																			*
 ***************************************************************************/
package com.vriche.adrm.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * OaDocumentCatalog class
 * 
 * This class is used to 
 * 
 * <p><a href="OaDocumentCatalog.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_oa_document_catalog"
 * 
 */
public class OaDocumentCatalog extends BaseObjectWithoutNestedFormValidation {
	 
	private static final long serialVersionUID = -3808113461386533102L;
	protected Long 	 id;
	protected String name;    // required 
//	protected Long 	 permitTypeId;
	protected String parentId;    
	protected Long	 nodeLevel;    
	protected Long 	 displayNo;   
	protected Long   createBy; // default sysdate
	protected Date   createDate;
	protected Long   modifyBy; // default sysdate
	protected Date   modifyDate;
	protected Integer version;
	
	protected Set documents = new HashSet();
	
	protected Set permitUsers = new HashSet();
	protected Set permitBranchs = new HashSet();
	protected Set permitRoles = new HashSet();
	
	
	protected Set  permitTypes = new HashSet();

	
//	protected OaDocumentCatalogPermitType oaDocumentCatalogPermitType = new OaDocumentCatalogPermitType();


	public OaDocumentCatalog() {};
	

	

	/**
	 * @hibernate.id column="document_catalog_id" generator-class="native"
	 *               unsaved-value="null"
	 */
	public Long getId() {
		return id;
	}
	

	/**
	 * 
	 * Returns the name
	 * @return String 
	 * @struts.validator type="required"
	 * @hibernate.property length="32" column="name" not-null="false"
	 */
	public String getName() {
		return name;
	}
//	/**
//	 * 
//	 * Returns the permitTypeId
//	 * @return Long 
//	 * 
//	 * @hibernate.property length="20" column="permit_type_id" not-null="false"
//	 */
//	public Long getPermitTypeId() {
//		return permitTypeId;
//	}	
	

	/**
	 * 
	 * Returns the displayNo
	 * @return Long 
	 * 
	 * @hibernate.property length="16" column="display_no" not-null="false"
	 */
	public Long getDisplayNo() {
		return displayNo;
	}

	/**
	 * 
	 * Returns the nodeLevel
	 * @return Long 
	 * 
	 * @hibernate.property length="5" column="node_level" not-null="false"
	 */
	public Long getNodeLevel() {
		return nodeLevel;
	}

	/**
	 * 
	 * Returns the parentId
	 * @return String 
	 * 
	 * @hibernate.property length="32" column="parent_id" not-null="false"
	 */
	public String getParentId() {
		return parentId;
	}

	/**
	 * 
	 * Returns the createBy
	 * 
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
	 * 
	 * @return Date
	 * 
	 * @hibernate.property column="create_date" update="false" insert="true"
	 *                     type="timestamp"
	 */

	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 
	 * Returns the modifyBy
	 * 
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
	 * 
	 * @return Date
	 * 
	 * @hibernate.property column="modify_date" update="false" insert="true"
	 *                     type="timestamp"
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
	 * @hibernate.set name="documents" table="tb_oa_document" inverse="false" cascade="none" lazy="false"          
	 * @hibernate.collection-key column="document_catalog_id"
	 * @hibernate.collection-one-to-many class="com.vriche.adrm.model.OaDocument"  column="document_id"
	 *                                  
	 */
	public Set getDocuments() {
		return documents;
	}	

    /**
     * @hibernate.set table="tb_oa_document_catalog_user" cascade="save-update" lazy="false"
     * @hibernate.collection-key column="catalog_id"
     * @hibernate.collection-many-to-many class="com.vriche.adrm.model.User" column="user_id"
     */
	public Set getPermitUsers() {
		return permitUsers;
	}

    /**
     * @hibernate.set table="tb_oa_document_catalog_branch" cascade="save-update" lazy="false"
     * @hibernate.collection-key column="catalog_id"
     * @hibernate.collection-many-to-many class="com.vriche.adrm.model.Branch" column="branch_id"
     */
	public Set getPermitBranchs() {
		return permitBranchs;
	}
    /**
     * @hibernate.set table="tb_oa_document_catalog_role" cascade="save-update" lazy="false"
     * @hibernate.collection-key column="catalog_id"
     * @hibernate.collection-many-to-many class="com.vriche.adrm.model.Role" column="role_id"
     */
	public Set getPermitRoles() {
		return permitRoles;
	}	
	
	
	  /**
   * @hibernate.set table="tb_oa_document_catalog_permit" cascade="save-update" lazy="false"
   * @hibernate.collection-key column="catalog_id"
   * @hibernate.collection-many-to-many class="com.vriche.adrm.model.OaDocumentCatalogPermitType" column="permit_type_id"
   */
	public Set getPermitTypes() {
		return permitTypes;
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
	 * @param id The id to set.
	 */
	public void setId(Long id) {
		this.id = id;
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
	
//	/**
//	 * 
//	 * Returns the oaDocumentCatalogPermitType
//	 * @return OaDocumentCatalogPermitType 
//	 * 
//	 */
//	public OaDocumentCatalogPermitType getOaDocumentCatalogPermitType() {
//		return oaDocumentCatalogPermitType;
//	}	
//	
	

	/** 
	 * @param displayNo The displayNo to set.
	 */
	public void setDisplayNo(Long displayNo) {
		this.displayNo = displayNo;
	}

	/** 
	 * @param nodeLevel The nodeLevel to set.
	 */
	public void setNodeLevel(Long nodeLevel) {
		this.nodeLevel = nodeLevel;
	}

	/** 
	 * @param parentId The parentId to set.
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}


//	/** 
//	 * @param permitTypeId The permitTypeId to set.
//	 */
//	public void setPermitTypeId(Long permitTypeId) {
//		this.permitTypeId = permitTypeId;
//	}
	/** 
	 * @param permitUsers The permitUsers to set.
	 */
	public void setPermitUsers(Set permitUsers) {
		this.permitUsers = permitUsers;
	}



	/** 
	 * @param permitBranchs The permitBranchs to set.
	 */
	public void setPermitBranchs(Set permitBranchs) {
		this.permitBranchs = permitBranchs;
	}

	/** 
	 * @param permitRoles The permitRoles to set.
	 */
	public void setPermitRoles(Set permitRoles) {
		this.permitRoles = permitRoles;
	}

	/** 
	 * @param documents The documents to set.
	 */
	public void setDocuments(Set documents) {
		this.documents = documents;
	}

//	/** 
//	 * @param oaDocumentCatalogPermitType The oaDocumentCatalogPermitType to set.
//	 */
//	public void setOaDocumentCatalogPermitType(
//			OaDocumentCatalogPermitType oaDocumentCatalogPermitType) {
//		this.oaDocumentCatalogPermitType = oaDocumentCatalogPermitType;
//	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.model.BaseObjectWithoutNestedFormValidation#toString()
	 */
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.model.BaseObjectWithoutNestedFormValidation#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.model.BaseObjectWithoutNestedFormValidation#hashCode()
	 */
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

  

	/** 
	 * @param permitTypes The permitTypes to set.
	 */
	public void setPermitTypes(Set permitTypes) {
		this.permitTypes = permitTypes;
	}




}
