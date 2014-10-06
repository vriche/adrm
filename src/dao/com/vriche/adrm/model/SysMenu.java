/****************************************************************************     
 * Created on 2007-10-12                                      *    
 *                                                               			*
 * @author <a href="mailto:hongxilin@yahoo.com.cn">hongxi</a>               *
 *         Updated by hongxi (hongxilin@yahoo.com.cn)                       *
 *                                                                          *
 * @version  Vision:1.0														*
 * 																			*
 ***************************************************************************/
package com.vriche.adrm.model;

import java.util.Date;

/**
 * SysMenu class
 * 
 * This class is used to 
 * 
 * <p><a href="SysMenu.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="tb_sys_menu"
 * 
 */
public class SysMenu extends BaseObjectWithoutNestedFormValidation {
//	 primary key
	protected Long id;
	
    protected Long parentId;
    protected Integer treeLevel;
    protected Integer displayNo;
	// fields
	protected String name;				     // required
	protected String title;
	protected String description;
	protected String location;	
	protected String target;
	protected String onclick;	
	protected String onmouseover;
	protected String onmouseout;	
	protected String image;	
	protected String altImage;
	protected String tooltip;	
	protected String roles;	
	protected String pageNum;
	protected String width;	
	protected String height;	
	protected String forward;	
	protected String action;	
	protected Boolean isDisplay;
	

	
    protected Long createBy;				  //default sysdate
    protected Date createDate;					  
    protected Long modifyBy;				  //default sysdate
    protected Date modifyDate;					  
    protected Integer version;	
    
    
	public SysMenu() {}   
    
	  /**
     * @hibernate.id column="sys_menu_id" generator-class="native" unsaved-value="null"
     */
	public Long getId() {
		return id;
	}
	/**
	 * 
	 * Returns the name
	 * @return String 
     * @struts.validator type="required"
	 * @hibernate.property length="32" column="name" not-null="true"
	 */
	public String getName() {
		return name;
	}	
    
    
	/**
     * 
     * Returns the parentId
     * @return Long
     * 
     * @hibernate.property length="32" column="parent_id" not-null="false"
     */
    public Long getParentId() {
        return parentId;
    }
    /**
     * 
     * Returns the treeLevel
     * @return Integer
     * 
     * @hibernate.property length="5" column="tree_level" not-null="false"
     */
    public Integer getTreeLevel() {
        return treeLevel;
    }
    /**
     * 
     * Returns the displayNo
     * @return Integer
     * 
     * @hibernate.property length="16" column="display_no" not-null="true"
     */
    public Integer getDisplayNo() {
        return displayNo;
    }   
    
    /**
     * 
     * Returns the action
     * @return String
     * 
     * @hibernate.property column="action" not-null="false" update="true" 
     * length="50"
     */
    public String getAction() {
        return action;
    }
    /**
     * 
     * Returns the altImage
     * @return String
     * 
     * @hibernate.property column="alt_image" not-null="false" update="true"
     */
    public String getAltImage() {
        return altImage;
    }
    /**
     * 
     * Returns the description
     * @return String
     * 
     * @hibernate.property column="description" not-null="false" update="true"
     */
    public String getDescription() {
        return description;
    }
    /**
     * 
     * Returns the forward
     * @return String
     * 
     * @hibernate.property column="forward" not-null="false" update="true"
     */
    public String getForward() {
        return forward;
    }
    /**
     * 
     * Returns the height
     * @return String
     * 
     * @hibernate.property column="height" not-null="false" update="true"
     */
    public String getHeight() {
        return height;
    }
    /**
     * 
     * Returns the image
     * @return String
     * 
     * @hibernate.property column="image" not-null="false" update="true"
     */
    public String getImage() {
        return image;
    }
    /**
     * 
     * Returns the location
     * @return String
     * 
     * @hibernate.property column="location" not-null="false" update="true"
     */
    public String getLocation() {
        return location;
    }
    /**
     * 
     * Returns the onclick
     * @return String
     * 
     * @hibernate.property column="onclick" not-null="false" update="true"
     */
    public String getOnclick() {
        return onclick;
    }
    /**
     * 
     * Returns the onmouseout
     * @return String
     * 
     * @hibernate.property column="onmouseout" not-null="false" update="true"
     */
    public String getOnmouseout() {
        return onmouseout;
    }
    /**
     * 
     * Returns the onmouseover
     * @return String
     * 
     * @hibernate.property column="onmouseover" not-null="false" update="true"
     */
    public String getOnmouseover() {
        return onmouseover;
    }
    /**
     * 
     * Returns the pageNum
     * @return String
     * 
     * @hibernate.property column="page_num" not-null="false" update="true"
     */
    public String getPageNum() {
        return pageNum;
    }

    /**
     * 
     * Returns the roles
     * @return String
     * 
     * @hibernate.property column="roles" not-null="false" update="true"
     */
    public String getRoles() {
        return roles;
    }
    /**
     * 
     * Returns the target
     * @return String
     * 
     * @hibernate.property column="target" not-null="false" update="true"
     */
    public String getTarget() {
        return target;
    }
    /**
     * 
     * Returns the title
     * @return String
     * 
     * @hibernate.property column="title" not-null="false" update="true"
     */
    public String getTitle() {
        return title;
    }
    /**
     * 
     * Returns the tooltip
     * @return String
     * 
     * @hibernate.property column="tooltip" not-null="false" update="true"
     */
    public String getTooltip() {
        return tooltip;
    }
    /**
     * 
     * Returns the width
     * @return String
     * 
     * @hibernate.property column="width" not-null="false" update="true"
     */
    public String getWidth() {
        return width;
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
	 * Returns the isDisplay
	 * @return Boolean 
	 * 
	 * @hibernate.property column="is_display" not-null="false"   type="yes_no" 
	 */
	public Boolean getIsDisplay() {
		return isDisplay;
	}
  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

	/** 
	 * @param action The action to set.
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/** 
	 * @param altImage The altImage to set.
	 */
	public void setAltImage(String altImage) {
		this.altImage = altImage;
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
	 * @param description The description to set.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/** 
	 * @param displayNo The displayNo to set.
	 */
	public void setDisplayNo(Integer displayNo) {
		this.displayNo = displayNo;
	}

	/** 
	 * @param forward The forward to set.
	 */
	public void setForward(String forward) {
		this.forward = forward;
	}

	/** 
	 * @param height The height to set.
	 */
	public void setHeight(String height) {
		this.height = height;
	}

	/** 
	 * @param id The id to set.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/** 
	 * @param image The image to set.
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/** 
	 * @param location The location to set.
	 */
	public void setLocation(String location) {
		this.location = location;
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
	 * @param onclick The onclick to set.
	 */
	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}

	/** 
	 * @param onmouseout The onmouseout to set.
	 */
	public void setOnmouseout(String onmouseout) {
		this.onmouseout = onmouseout;
	}

	/** 
	 * @param onmouseover The onmouseover to set.
	 */
	public void setOnmouseover(String onmouseover) {
		this.onmouseover = onmouseover;
	}

	/** 
	 * @param pageNum The pageNum to set.
	 */
	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}

	/** 
	 * @param parentId The parentId to set.
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/** 
	 * @param roles The roles to set.
	 */
	public void setRoles(String roles) {
		this.roles = roles;
	}

	/** 
	 * @param target The target to set.
	 */
	public void setTarget(String target) {
		this.target = target;
	}

	/** 
	 * @param title The title to set.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/** 
	 * @param tooltip The tooltip to set.
	 */
	public void setTooltip(String tooltip) {
		this.tooltip = tooltip;
	}

	/** 
	 * @param treeLevel The treeLevel to set.
	 */
	public void setTreeLevel(Integer treeLevel) {
		this.treeLevel = treeLevel;
	}


	/** 
	 * @param width The width to set.
	 */
	public void setWidth(String width) {
		this.width = width;
	}
	
	/** 
	 * @param isDisplay The isDisplay to set.
	 */
	public void setIsDisplay(Boolean isDisplay) {
		this.isDisplay = isDisplay;
	}
	/** 
	 * @param version The version to set.
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/* (non-Javadoc)
	 * @see com.vriche.adrm.model.BaseObject#toString()
	 */
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.model.BaseObject#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.model.BaseObject#hashCode()
	 */
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}


}
