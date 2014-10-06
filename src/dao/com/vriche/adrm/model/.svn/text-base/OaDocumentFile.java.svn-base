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
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * OaDocumentFile class
 * 
 * This class is used to 
 * 
 * <p><a href="OaDocumentFile.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_oa_document_file"
 * 
 */
public class OaDocumentFile extends BaseObjectWithoutNestedFormValidation {
	
	private static final long serialVersionUID = 8058922724580543461L;
	protected Long id;

//	protected Long documentCatalogId;    
	protected Long documentId;   
	protected String filePath;    		
	protected String fileName;    		 // required 
	protected String picName;    		 

	protected Long createBy; // default sysdate
	protected Date createDate;
	protected Long modifyBy; // default sysdate
	protected Date modifyDate;
	protected Integer version;

//	protected OaDocumentCatalog oaDocumentCatalog = new OaDocumentCatalog(); 
	
	




	public OaDocumentFile() {};

	/**
	 * @hibernate.id column="document_file_id" generator-class="native"
	 *               unsaved-value="null"
	 */
	public Long getId() {
		return id;
	}


	/**
	 * 
	 * Returns the filePath
	 * @return String 
	 * @hibernate.property length="255" column="file_path" not-null="true"
	 */
	public String getFilePath() {
		return filePath;
	}
//	/**
//	 * 
//	 * Returns the documentCatalogId
//	 * @return Long 
//	 * 
//	 * @hibernate.property length="255" column="document_catalog_id" not-null="false"
//	 */
//	public Long getDocumentCatalogId() {
//		return documentCatalogId;
//	}

	/**
	 * 
	 * Returns the fileName
	 * @return String 
	 * @struts.validator type="required"
	 * @hibernate.property length="255" column="file_name" not-null="false"
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * 
	 * Returns the picName
	 * @return String 
	 * 
	 * @hibernate.property length="255" column="pic_name" not-null="false"
	 */
	public String getPicName() {
		return picName;
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
	
//	public OaDocumentCatalog getOaDocumentCatalog() {
//		return oaDocumentCatalog;
//	}
//	
	
	/**
	 * 
	 * Returns the documentId
	 * @return Long 
	 * 
	 * @hibernate.property length="20" column="document_id" not-null="false"
	 */
	public Long getDocumentId() {
		return documentId;
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
	 * @param documentId The documentId to set.
	 */
	public void setDocumentId(Long documentId) {
		this.documentId = documentId;
	}

	/** 
	 * @param filePath The filePath to set.
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}


	/** 
	 * @param version The version to set.
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
	

//	/** 
//	 * @param documentCatalogId The documentCatalogId to set.
//	 */
//	public void setDocumentCatalogId(Long documentCatalogId) {
//		this.documentCatalogId = documentCatalogId;
//	}

	/** 
	 * @param fileName The fileName to set.
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/** 
	 * @param picName The picName to set.
	 */
	public void setPicName(String picName) {
		this.picName = picName;
	}

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof OaDocumentFile)) {
			return false;
		}
		OaDocumentFile rhs = (OaDocumentFile) object;
		return new EqualsBuilder().append(
				this.fileName, rhs.fileName).append(this.documentId,
				rhs.documentId).append(this.modifyBy, rhs.modifyBy).append(
				this.filePath, rhs.filePath).append(this.modifyDate,
				rhs.modifyDate).append(this.createDate, rhs.createDate).append(
				this.picName, rhs.picName).append(this.createBy, rhs.createBy)
				.append(this.id, rhs.id).append(this.version, rhs.version)
				.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(767429089, 1258162917).append(this.fileName)
				.append(this.documentId)
				.append(this.modifyBy).append(this.filePath).append(
						this.modifyDate).append(this.createDate).append(
						this.picName).append(this.createBy).append(this.id)
				.append(this.version).toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("filePath", this.filePath)
				.append("modifyBy", this.modifyBy).append("id", this.id)
				.append("version", this.version).append("modifyDate",
						this.modifyDate).append("fileName", this.fileName)
				.append("picName", this.picName).append("documentId",
						this.documentId).append("createBy", this.createBy)
				.append("createDate", this.createDate).toString();
	}
	

//	/** 
//	 * @param oaDocumentCatalog The oaDocumentCatalog to set.
//	 */
//	public void setOaDocumentCatalog(OaDocumentCatalog oaDocumentCatalog) {
//		this.oaDocumentCatalog = oaDocumentCatalog;
//	}







}
