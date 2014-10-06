public String[] getUserRoles() {
        com.vriche.adrm.model.Role role;
        String[] userRoles = new String[roles.size()];
        int i = 0;
        for (java.util.Iterator iter = roles.iterator(); iter.hasNext();) {
            role = (com.vriche.adrm.model.Role) iter.next();
            userRoles[i] = role.getName();
            i++;
        }
        return userRoles;
    }

    /**
     * Note that this is not used - it's just needed by Struts.  If you look
     * in UserAction - you'll see that request.getParameterValues("userRoles")
     * is used instead.
     * 
     * @param roles
     */
    public void setUserRoles(String[] roles) {}
    
    
    
    
    public String[] getUserBranchs(){
    	com.vriche.adrm.model.Branch branch;
    	String[] userBranchs = new String[branchs.size()];
    	 int i = 0;
         for (java.util.Iterator iter = branchs.iterator(); iter.hasNext();) {
        	 branch = (com.vriche.adrm.model.Branch) iter.next();
        	 userBranchs[i] = branch.getName();
             i++;
         }
         return userBranchs;   	
    }
    
    public void setUserBranchs(String[] branchs) {}
    
