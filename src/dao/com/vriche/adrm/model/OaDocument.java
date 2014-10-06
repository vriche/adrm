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
 * OaDocument class
 * 
 * This class is used to 
 * 
 * <p><a href="OaDocument.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_oa_document"
 * 
 */
public class OaDocument extends BaseObject{

	private static final long serialVersionUID = -4346526264020768654L;
	protected Long id;

	protected Long documentFileId;    
	protected Long documentCatalogId;   
	protected String documentCode;    
	protected String title;   		 // required 
	protected String memo;    

	protected Long createBy; // default sysdate
	protected Date createDate;
	protected Long modifyBy; // default sysdate
	protected Date modifyDate;
	protected Integer version;
	
//	protected OaDocumentFile oaDocumentFile = new OaDocumentFile(); 
	
	protected Set documentFiles = new HashSet();
	




	public OaDocument() {};

	/**
	 * @hibernate.id column="document_id" generator-class="native"
	 *               unsaved-value="null"
	 */
	public Long getId() {
		return id;
	}
	

	/**
	 * 
	 * Returns the documentCode
	 * @return String 
	 * 
	 * @hibernate.property length="32" column="document_code" not-null="false"
	 */
	public String getDocumentCode() {
		return documentCode;
	}
	
	/**
	 * 
	 * Returns the documentCatalogId
	 * @return Long 
	 * 
	 * @hibernate.property length="20" column="document_catalog_id" not-null="false"
	 */
	public Long getDocumentCatalogId() {
		return documentCatalogId;
	}

	/**
	 * 
	 * Returns the documentFileId
	 * @return Long 
	 * 
	 * @hibernate.property length="20" column="document_file_id" not-null="false"
	 */
	public Long getDocumentFileId() {
		return documentFileId;
	}

	/**
	 * 
	 * Returns the memo
	 * @return String 
	 * 
	 * @hibernate.property length="255" column="memo" not-null="false"
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * 
	 * Returns the title
	 * @return String 
	 * @struts.validator type="required"
	 * @hibernate.property length="32" column="title" not-null="false"
	 */
	public String getTitle() {
		return title;
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
	
//	public OaDocumentFile getOaDocumentFile() {
//		return oaDocumentFile;
//	}

	/**
	 * @hibernate.set name="documentFiles" table="tb_oa_document_file" inverse="false" cascade="none" lazy="false"          
	 * @hibernate.collection-key column="document_id"
	 * @hibernate.collection-one-to-many class="com.vriche.adrm.model.OaDocumentFile"  column="document_file_id"
	 *                                  
	 */
	public Set getDocumentFiles() {
		return documentFiles;
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
	 * @param documentCode The documentCode to set.
	 */
	public void setDocumentCode(String documentCode) {
		this.documentCode = documentCode;
	}

	/** 
	 * @param documentFileId The documentFileId to set.
	 */
	public void setDocumentFileId(Long documentFileId) {
		this.documentFileId = documentFileId;
	}

	/** 
	 * @param memo The memo to set.
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}

	/** 
	 * @param title The title to set.
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/** 
	 * @param documentCatalogId The documentCatalogId to set.
	 */
	public void setDocumentCatalogId(Long documentCatalogId) {
		this.documentCatalogId = documentCatalogId;
	}

	/** 
	 * @param version The version to set.
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
	
	/** 
	 * @param documentFiles The documentFiles to set.
	 */
	public void setDocumentFiles(Set documentFiles) {
		this.documentFiles = documentFiles;
	}
	


//	/** 
//	 * @param oaDocumentFile The oaDocumentFile to set.
//	 */
//	public void setOaDocumentFile(OaDocumentFile oaDocumentFile) {
//		this.oaDocumentFile = oaDocumentFile;
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


}
