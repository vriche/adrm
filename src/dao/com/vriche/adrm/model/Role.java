package com.vriche.adrm.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.acegisecurity.GrantedAuthority;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * This class is used to represent available roles in the database.</p>
 *
 * <p><a href="Role.java.html"><i>View Source</i></a></p>
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 *  Version by Dan Kibler dan@getrolling.com
 *  Extended to implement Acegi GrantedAuthority interface 
 *  	by David Carter david@carter.net
 *
 * @struts.form extends="BaseForm"
 * @hibernate.class table="tb_sys_role"
 */
public class Role extends BaseObject implements Serializable, GrantedAuthority {
    private static final long serialVersionUID = 3690197650654049848L;
    private Long id;
    private String name;
    private String lable;
    private String description;
	private Boolean authorized;
	private Long orgId;
	private Long orgAdminId;
	
	
    
	private Set users = new HashSet();

	private Set rescs = new HashSet();
	
	
	private Set usersNo = new HashSet();

	private Set rescsNo = new HashSet();
	
	

	public Role() {}
    
    public Role(String name) {
        this.name = name;
    }
    
    /**
     * @hibernate.id column="id" generator-class="native" unsaved-value="null"
     */
    public Long getId() {
        return id;
    }

    /**
     * @see org.acegisecurity.GrantedAuthority#getAuthority()
     */
    public String getAuthority() {
        return getName();
    }
    
    /**
     * @hibernate.property column="name" length="20"
     */
    public String getName() {
        return this.name;
    }
    
	/**
	 * 
	 * Returns the lable
	 * @return String 
	 * 
	 * @hibernate.property length="32" column="lable" not-null="false"
	 */
	public String getLable() {
		return lable;
	}

    /**
     * @hibernate.property column="description" length="64"
     */
    public String getDescription() {
        return this.description;
    }
    
	/**
	 * 
	 * Returns the authorized
	 * @return Boolean 
	 */
	public Boolean getAuthorized() {
		return authorized;
	}

    
    
	public Set getRescs() {
		return rescs;
	}

	public Set getUsers() {
		return users;
	}  
    
	public Set getRescsNo() {
		return rescsNo;
	}


	public Set getUsersNo() {
		return usersNo;
	}


    
    
    



	public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    

	public void setLable(String lable) {
		this.lable = lable;
	}

	public void setAuthorized(Boolean authorized) {
		this.authorized = authorized;
	}
    
	public void setRescs(Set rescs) {
		this.rescs = rescs;
	}

	public void setUsers(Set users) {
		this.users = users;
	}
	public void setUsersNo(Set usersNo) {
		this.usersNo = usersNo;
	}   

	public void setRescsNo(Set rescsNo) {
		this.rescsNo = rescsNo;
	} 
	
	
	

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;

        final Role role = (Role) o;

        return !(name != null ? !name.equals(role.name) : role.name != null);

    }

    public int hashCode() {
        return (name != null ? name.hashCode() : 0);
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE)
                .append(this.name)
                .toString();
    }

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public Long getOrgAdminId() {
		return orgAdminId;
	}

	public void setOrgAdminId(Long orgAdminId) {
		this.orgAdminId = orgAdminId;
	}




}
