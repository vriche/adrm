package com.vriche.adrm.util;

import java.util.Iterator;
import java.util.Map;

import org.jivesoftware.smack.AccountManager;
import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.RosterEntry;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;

import com.vriche.adrm.Constants;
import com.vriche.adrm.model.SysParam;

public class SmackUtil {
	

	public  static ConnectionConfiguration config = null;
	public  static XMPPConnection connHelperInc = null;
	public  static XMPPConnection connHelperCuik = null;
//	public static String  isUseOpenfire ="0";
	public static String  serviceName ="";
	public static String hostPort = "";
	public static String hostName = "";

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public static ConnectionConfiguration  getConConfig() {
		if(config == null){
			String[] p = getIncomAlserParam();
			hostName = p[1];
			hostPort = p[2];
			serviceName = p[3];
			
			 System.out.println("hostName>>>>"+hostName);
			 System.out.println("hostPort>>>>"+hostPort);
			 System.out.println("serviceName>>>>"+serviceName);
			 
			config = new ConnectionConfiguration(hostName, Integer.valueOf(hostPort).intValue(),serviceName);
//			ConnectionConfiguration config = new ConnectionConfiguration("192.168.168.52", 5222);
			config.setCompressionEnabled(true);
			config.setSASLAuthenticationEnabled(true);
		}
		
		return config;
	}
	
	public static XMPPConnection getXMPPConnection(String loginUser,
			String password, String resourceName) {
		
		XMPPConnection con = null;
		getConConfig();

		try {
			con = new XMPPConnection(config);
		} catch (XMPPException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// Log into the server
		AccountManager accountManager = con.getAccountManager();
		String username = accountManager.getAccountAttribute("username").toLowerCase();
		if(username.equals(loginUser.toLowerCase())){
			
			loginAccount(con, loginUser, password, resourceName);
		}else{
			loginAccount(con, "", password, resourceName);
		}
			
		return con;
	}	
	
	
	
	public static XMPPConnection getXMPPConnection() {
		
		XMPPConnection con = null;
		getConConfig();

		try {
			con = new XMPPConnection(config);
		} catch (XMPPException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return con;
	}	
	
	// 到款提示助手
	// uid:helperInc
	// pwd:helperInc123
	// resourceName:Spark
	public static XMPPConnection getHelperIncConnection() {

		if (connHelperInc == null || !connHelperInc.isConnected()) {

			getConConfig();

			try {
				connHelperInc = new XMPPConnection(config);
			} catch (XMPPException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			// Log into the server
			loginAccount(connHelperInc, "helperInc", "helperInc123", "Spark");

		}
		return connHelperInc;

	}
		
	// 催款提示助手
	// uid:helperCuik
	// pwd:helperCuik123
	// resourceName:Spark	
	public static XMPPConnection getHelperCuikConnection() {

		if (connHelperCuik == null || !connHelperCuik.isConnected()) {
			getConConfig();
			try {
				connHelperCuik = new XMPPConnection(config);
			} catch (XMPPException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			// Log into the server
			loginAccount(connHelperCuik, "helperCuik", "helperCuik123", "Spark");

		}
		return connHelperCuik;
	}


	
	
	
	public static void loginAccount(XMPPConnection con,String loginUser,String password,String resourceName) {
//		getAccountAttribute = password,username,email,registered,name
//		AccountManager accountManager = con.getAccountManager();
//		String username = accountManager.getAccountAttribute("username").toLowerCase();
		
//		if(!username.equals(loginUser.toLowerCase())){
//			try {
//				accountManager.createAccount(loginUser,password);
//				
//			} catch (XMPPException e) {
//				// TODO Auto-generated catch block
//				System.out.println("用户已存在>>>>>>>"+loginUser);
////				e.printStackTrace();
//			}
//		}
		


	
			try {
//				accountManager.changePassword(password);
				if(!loginUser.equals("")){
					if(!con.isAuthenticated() && con.isConnected()) {
					
						if(resourceName.equals("")){
							con.login(loginUser, password);
						}else{
							con.login(loginUser, password,resourceName);
						}
						
						try {
							Thread.sleep(2000); //this is so that we dont act too fast
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
						
					}
				}else{
					if(!con.isAnonymous()&& con.isConnected()) con.loginAnonymously();
				}
				
			} catch (XMPPException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}	
	
	public static void logout(XMPPConnection con) {
		con.close();
		con = null;
	}	
	
	public static boolean sendMessage(XMPPConnection con,String user,Message msg) {
        boolean b = true;
		Chat chat = con.createChat(user);
		try {
			chat.sendMessage(msg);
//			System.out.println(user+" " +msg.getThread());
		} catch (XMPPException e) {
			b = false;
			System.out.println("failed to send msg!"+e.getMessage());
			
			// TODO Auto-generated catch block
//			e.printStackTrace();
		} 
		
		return b;

	}
	
	public static boolean isUseOpenFire(){
		String[] p = getIncomAlserParam();
		return p[0].equals("1") && !p[1].equals("");
		
	}

	
	public static String[] getIncomAlserParam(){
		String[] p = new String[6];
		SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
		String openfireParam = sysParam.getIncomeMessageAlertParam().toString();
		if(openfireParam.length()>1) {
		   p= openfireParam.split(",");
		}else{
		   p[0] = openfireParam;
		   p[1] ="";
		}
		return p;
	}
	

      
    public static boolean createUser(XMPPConnection con,String username,String password,Map m) {//创建用户  
        boolean b=true;  
    
        try {  
        	if(m != null){
        		con.getAccountManager().createAccount(username,password,m);  
        	}else{
        		con.getAccountManager().createAccount(username,password);   
        	}
        	
        } catch (XMPPException e) {  
        	con.close();
            b=false;  
        }  
        return b;  
    }  
    
	public  static boolean createUser(XMPPConnection con,String username,String password) {//创建用户  
		return createUser(con,username,password,null);
    }  
	
    public static boolean deleteUser(XMPPConnection con) {//删除用户  
        boolean b=true;  
        try {  
        	con.getAccountManager().deleteAccount();
        } catch (XMPPException e) {  
            b=false;  
        }  
        return b;  
    } 
    public void testPresences(String name){//看JID为name好友在不在线  
    	Roster roster = getHelperCuikConnection().getRoster();
        System.out.println(roster.getPresence(name));  
    }   
    
    

    
    public static boolean addUserToRoster(Roster roster,String user,String nickname,String[] s) {
    	boolean b=true;  
    	if (!isUserOnRoster(roster,user)){
    		if (roster != null) {
    			roster.setSubscriptionMode(Roster.SUBSCRIPTION_ACCEPT_ALL);
    			  try {  
    				  roster.createEntry(user,nickname, s);
    			  } catch (XMPPException e) {  
    				  b=false;  
    				  System.out.println(" error roster.createEntry userName>>"+user); 
    				  System.out.println(" error infos>>"+e.getMessage()); 
    			  }
    		}else{
    			 b=false;  
    			System.out.println(" roster is null");  
    		}
    			
    	}else{
    		 
    		 try {
				roster.removeEntry(roster.getEntry(user));	
				roster.reload();
//				addUserToRoster(roster,user,nickname,s);
				roster.createEntry(user,nickname, s);
			} catch (XMPPException e) {
				b=false;  
				 System.out.println(" error roster.createEntry userName>>"+user); 
				 System.out.println(" error infos>>"+e.getMessage()); 
			}
    		 
    		System.out.println(user + " is in our roster.");  
    	}
    	return b;  
    }
    
    public static void addUserToRoster(Roster roster,String user,String nickname){
    	addUserToRoster(roster,user,nickname,null) ;
    }
    public static boolean isUserOnRoster(Roster roster,String user){
    	if (roster != null)  {
    		return roster.contains(user);
    	}
    	return false;
    }
    public static boolean isUserOnline(Roster roster,String user) {
    	if (roster != null){
    		if(roster.getPresence(user) != null) return true;
    	}
    	return false;
    }
 
    
    public static void creatGroup(XMPPConnection con,Map branchsMap){
		
		Roster roster  = con.getRoster();
//		roster.getGroups().remove();
		for(Iterator it1 = branchsMap.keySet().iterator();it1.hasNext();){
			String key =  (String)it1.next();
			String value = (String)branchsMap.get(key);
			roster.createGroup(value);	
		}
    }
    
    

}

