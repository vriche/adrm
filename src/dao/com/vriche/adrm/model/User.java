package com.vriche.adrm.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.acegisecurity.GrantedAuthority;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;



/**
 * This class is used to generate the Struts Validator Form as well as the
 * This class is used to generate Spring Validation rules
 * as well as the Hibernate mapping file.
 *
 * <p><a href="User.java.html"><i>View Source</i></a>
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 *         Updated by Dan Kibler (dan@getrolling.com)
 *  Extended to implement Acegi UserDetails interface
 *      by David Carter david@carter.net
 *
 * @struts.form include-all="true" extends="BaseForm"
 * @hibernate.class table="tb_sys_user"
 */
public class User extends BaseObjectWithoutNestedFormValidation implements Serializable {
    private static final long serialVersionUID = 3832626162173359411L;

    protected Long id;
    protected String username;                    // required
    protected String password;                    // required
    protected String confirmPassword;
    protected String passwordHint;
    protected String firstName;                   // required
    protected String lastName;                    // required
    protected String fullName;                    
    protected String email;                       // required; unique
    protected String phoneNumber;
    protected String website;
    protected Address address = new Address();
    protected Integer version;

    protected Boolean enabled;
    protected Boolean accountExpired;
    protected Boolean accountLocked;
    protected Boolean credentialsExpired;
    protected Long branchId;
    protected String branchName;
    
    protected String loginUser;

    
    protected boolean encryptPass;
    
    protected Integer branchsCount;

    
    
    protected Set roles = new HashSet();
    protected Set branchs = new HashSet();
    protected Set users = new HashSet();
    protected Set usersCarrier = new HashSet();
    
    private Long orgId;
    
    protected String customerIds;
    
//    private Org org  = new Org();
//    private Branch branch = new Branch();
    

    
	public static final Integer STATUS_ENABLED = new Integer(1);
	public static final Integer STATUS_DISABLED = new Integer(0);
	public static Map statusEnum = new HashMap();
	
	static {
		statusEnum.put(STATUS_ENABLED, "Enabled");
		statusEnum.put(STATUS_DISABLED, "Disabled");
	}

    public User() {}

    public User(String username) {
        this.username = username;
    }


	/**
     * @hibernate.id column="id" generator-class="native" unsaved-value="null"
     */
    public Long getId() {
        return id;
    }

    /**
     * @struts.validator type="required"
     * @hibernate.property length="50" not-null="true" unique="true"
     */
    public String getUsername() {
        return username;
    }

    /**
     * @struts.validator type="required"
     * @struts.validator type="twofields" msgkey="errors.twofields"
     * @struts.validator-args arg1resource="userForm.password"
     * @struts.validator-args arg1resource="userForm.confirmPassword"
     * @struts.validator-var name="secondProperty" value="confirmPassword"
     * @hibernate.property column="password" not-null="true"
     */
    public String getPassword() {
        return password;
    }

    /**
     * @struts.validator type="required"
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * @struts.validator type="required"
     * @hibernate.property column="password_hint" not-null="false"
     */
    public String getPasswordHint() {
        return passwordHint;
    }

    /**
     * @struts.validator type="required"
     * @hibernate.property column="first_name" not-null="true" length="50"
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @struts.validator type="required"
     * @hibernate.property column="last_name" not-null="true" length="50"
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @struts.validator type="required"
     * @struts.validator type="email"
     * @hibernate.property name="email" not-null="true" unique="true"
     */
    public String getEmail() {
        return email;
    }

    /**
     * @struts.validator type="mask" msgkey="errors.phone"
     * @struts.validator-var name="mask" value="${phone}"
     * @hibernate.property column="phone_number" not-null="false"
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @struts.validator type="required"
     * @hibernate.property column="website" not-null="false"
     */
    public String getWebsite() {
        return website;
    }

    /**
     * Returns the full name.
     */
    public String getFullName() {
    	if(this.firstName == null) this.firstName ="";
    	if(this.lastName == null) this.lastName ="";
        return this.firstName + this.lastName;
    }

    /**
     * @hibernate.component
     */
    public Address getAddress() {
        return address;
    }

    /**
     * @hibernate.set table="tb_sys_user_role" cascade="save-update" lazy="false"
     * @hibernate.collection-key column="user_id"
     * @hibernate.collection-many-to-many class="com.vriche.adrm.model.Role" column="role_id"
     */
    public Set getRoles() {
        return roles;
    }
    
	/**
	 * @bak_hibernate.set name="branchs" table="tb_sys_branch" inverse="false" cascade="none" lazy="false"          
	 * @bak_hibernate.collection-key column="user_id"
	 * @bak_hibernate.collection-one-to-many class="com.vriche.adrm.model.Branch"  column="sys_branch_id"                               
	 */
	public Set getBranchs() {
		return branchs;
	}
	
    /**
     * Adds a role for the user
     * @param role
     */
    public void addBranch(Branch branch) {
    	getBranchs().add(branch);
    }

    /**
     * Adds a role for the user
     * @param role
     */
    public void addRole(Role role) {
        getRoles().add(role);
    }
    
    /**
     * @see org.acegisecurity.userdetails.UserDetails#getAuthorities()
     */
    public GrantedAuthority[] getAuthorities() {
        return (GrantedAuthority[]) roles.toArray(new GrantedAuthority[0]);
    }

    /**
     * @hibernate.version
     */
    public Integer getVersion() {
        return version;
    }
    

    
    /**
	 * 
	 * Returns the accountExpired
	 * @return Boolean  
	 * 
	 * @hibernate.property   column="account_expired" not-null="false"   type="yes_no"
	 */
	public Boolean getAccountExpired() {
		return accountExpired;
	}

	/**
	 * 
	 * Returns the accountLocked
	 * @return Boolean 
	 * 
	 * @hibernate.property  column="account_locked" not-null="false" type="yes_no"
	 */
	public Boolean getAccountLocked() {
		return accountLocked;
	}

	/**
	 * 
	 * Returns the credentialsExpired
	 * @return Boolean 
	 * 
	 * @hibernate.property  column="credentials_expired" not-null="false" type="yes_no"
	 */
	public Boolean getCredentialsExpired() {
		return credentialsExpired;
	}

	/**
	 * 
	 * Returns the enabled
	 * @return Boolean 
	 * 
	 * @hibernate.property  column="account_enabled" not-null="false"   type="yes_no" 
	 */
	public Boolean getEnabled() {
		return enabled;
	}
  
	/**
	 * 
	 * Returns the branchId
	 * @return Long 
	 * 
	 */
	public Long getBranchId() {
		return branchId;
	}

	 /**
     * @hibernate.set table="tb_sys_user_rel" cascade="save-update" lazy="false"
     * @hibernate.collection-key column="parent_user_id"
     * @hibernate.collection-many-to-many class="com.vriche.adrm.model.User" column="user_id"
     */
    
	public Set getUsers() {
		return users;
	}	
	
	

    
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setPasswordHint(String passwordHint) {
        this.passwordHint = passwordHint;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

	public void setBranchs(Set branchs) {
		this.branchs = branchs;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setRoles(Set roles) {
        this.roles = roles;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
    
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public void setAccountExpired(Boolean accountExpired) {
        this.accountExpired = accountExpired;
    }
    
    public void setAccountLocked(Boolean accountLocked) {
        this.accountLocked = accountLocked;
    }

    public void setCredentialsExpired(Boolean credentialsExpired) {
        this.credentialsExpired = credentialsExpired;
    }
    
    
    
	/** 
	 * @param branchId The branchId to set.
	 */
	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}
  
    
    
    
    
    
    
    
    
    
    
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        final User user = (User) o;

        if (username != null ? !username.equals(user.getUsername()) : user.getUsername() != null) return false;

        return true;
    }

    public int hashCode() {
        return (username != null ? username.hashCode() : 0);
    }

    /**
	 * 
	 * Returns the encryptPass
	 * @return boolean 
	 */
	public boolean isEncryptPass() {
		return encryptPass;
	}

	/** 
	 * @param encryptPass The encryptPass to set.
	 */
	public void setEncryptPass(boolean encryptPass) {
		this.encryptPass = encryptPass;
	}



	/** 
	 * @param users The users to set.
	 */
	public void setUsers(Set users) {
		this.users = users;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("id", this.id).append("users",
				this.users).append("roles", this.roles).append("enabled",
				this.enabled).append("credentialsExpired",
				this.credentialsExpired).append("branchs", this.branchs)
				.append("accountLocked", this.accountLocked).append(
						"firstName", this.firstName).append("encryptPass",
						this.encryptPass).append("passwordHint",
						this.passwordHint).append("lastName", this.lastName)
				.append("version", this.version).append("authorities",
						this.getAuthorities()).append("accountExpired",
						this.accountExpired).append("username", this.username)
				.append("email", this.email).append("phoneNumber",
						this.phoneNumber).append("fullName", this.fullName)
				.append("password", this.password).append("address",
						this.address).append("branchId", this.branchId).append(
						"confirmPassword", this.confirmPassword).append(
						"website", this.website).toString();
	}
	 /**
     * @hibernate.set table="tb_sys_user_carrier_rel" cascade="save-update" lazy="false"
     * @hibernate.collection-key column="user_id"
     * @hibernate.collection-many-to-many class="com.vriche.adrm.model.Carrier" column="carrier_id"
     */

	public Set getUsersCarrier() {
		return usersCarrier;
	}

	public void setUsersCarrier(Set usersCarrier) {
		this.usersCarrier = usersCarrier;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}

	public Integer getBranchsCount() {
		return branchsCount;
	}

	public void setBranchsCount(Integer branchsCount) {
		this.branchsCount = branchsCount;
	}



	public String getCustomerIds() {
		return customerIds;
	}

	public void setCustomerIds(String customerIds) {
		this.customerIds = customerIds;
	}



}
