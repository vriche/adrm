
package com.vriche.adrm.service.impl;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import com.ibatis.common.jdbc.ScriptRunner;
import com.ibatis.common.resources.Resources;
import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.Constants;
import com.vriche.adrm.dao.SysMenuDao;
import com.vriche.adrm.model.SysMenu;
import com.vriche.adrm.service.SysMenuManager;

public class SysMenuManagerImpl extends BaseManager implements SysMenuManager {
	
    private SysMenuDao dao;
    

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setSysMenuDao(SysMenuDao dao) {
        this.dao = dao;
    }
   /**
     * @see com.vriche.adrm.service.SysMenuManager#getSysMenus(com.vriche.adrm.model.SysMenu)
     */
    public List getSysMenus(final SysMenu sysMenu) {
        return dao.getSysMenus(sysMenu);
    }
   /**
     * @see com.vriche.adrm.service.SysMenuManager#getSysMenusCount(com.vriche.adrm.model.SysMenu)
     */
    public String getSysMenusCount(final SysMenu sysMenu) {
        return dao.getSysMenusCount(sysMenu).toString();
    }    

   /**
     * @see com.vriche.adrm.service.SysMenuManager#getSysMenusCount(com.vriche.adrm.model.SysMenu)
     */    
	public PaginatedList getSysMenusPage(final SysMenu sysMenu,String pageIndex, String pageSize) {
		return dao.getSysMenusPage(sysMenu,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    

    /**
     * @see com.vriche.adrm.service.SysMenuManager#getSysMenu(String id)
     */
    public SysMenu getSysMenu(final String id) {
        return dao.getSysMenu(new Long(id));
    }
    /**
     * @see com.vriche.adrm.service.SysMenuManager#getSysMenusByIdList(final Map idList)
     */
    public List getSysMenusByIdList(final Map idList) {
        return dao.getSysMenusByIdList(idList);
    }    

    /**
     * @see com.vriche.adrm.service.SysMenuManager#saveSysMenu(SysMenu sysMenu)
     */
    public String saveSysMenu(SysMenu sysMenu) {
        return dao.saveSysMenu(sysMenu).toString();
    }

    /**
     * @see com.vriche.adrm.service.SysMenuManager#removeSysMenu(String id)
     */
    public void removeSysMenu(final String id) {
        dao.removeSysMenu(new Long(id));
    }

     /**
     * @see com.vriche.adrm.service.SysMenuManager#removeSysMenus(String Map)
     */
    public void removeSysMenus(final Map idList) {
        dao.removeSysMenus(idList);
    }
	public String getSysMenuXML(SysMenu sysMenu, String IdPrefix) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer("");
		sb.append("<?xml version=\"1.0\"?>");
		sb.append("<tree id=\"0\">");
		sb.append("<item text=\"²¥³öÐÅÏ¢\" id=\"root\" open=\"1\" im0=\"books_close.gif\" im1=\"tombs.gif\" im2=\"tombs.gif\" call=\"1\" select=\"1\">");
		sb.append("<userdata name=\"id\">0</userdata>");
		sb.append("<userdata name=\"type\">0</userdata>");
		getSysMenuIdsByParent(sysMenu.getParentId(),sb,IdPrefix);
		sb.append("</item>");
		sb.append("</tree>");
		return sb.toString();
	} 
	
	private void getSysMenuIdsByParent(Long id, StringBuffer sb,String IdPrefix) {
		SysMenu sysMenu = new SysMenu();
		int type=0;
		sysMenu.setParentId(id);
		Iterator it = this.getSysMenus(sysMenu).iterator();
		while (it.hasNext()) {
			SysMenu sm = (SysMenu) it.next();
			int pId = sm.getParentId().intValue();
			sb.append("<item id='" +IdPrefix
							+ sm.getId().toString()
							+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
							+ sm.getName().toString() + "\">");
			sb.append("<userdata name=\"id\">" + sm.getId().toString()
					+ "</userdata>");
			if(pId == 0){
				type = 1;
			}
			if(pId >= 1){
				type = 2;
			}
			sb.append("<userdata name=\"type\">" + type + "</userdata>");
			getSysMenuIdsByParent(sm.getId(), sb,IdPrefix);
			sb.append("</item>");

		}
	}
	public String getSysMenuArray() {
		
		SysMenu sysMenu = new SysMenu();
		StringBuffer sb = new StringBuffer("");
				
        sb.append("var myMenu =");     
        sb.append("["); 
        sb.append("_cmSplit,"); 
        
		sysMenu.setParentId(new Long(0));
		
		List ls = dao.getSysMenus(sysMenu);
		
		for(Iterator it = ls.iterator();it.hasNext();){
			SysMenu menu = (SysMenu) it.next();
			fillNode(menu,sb);
//			getSysMenuByParentId(menu.getId(),sb);
		}
		sb.append(",_cmSplit,");
		sb.append("];");
		
		sb.append("cmDraw ('myMenuID', myMenu, 'hbr', cmThemeOffice, 'ThemeOffice');"); 
		
		return sb.toString();
	}
	

	
	private void fillNode(SysMenu menu,StringBuffer sb){
		
		String name =menu.getName();
//		try
//		{
//	        byte target_byte[] = name.getBytes("ISO8859_1");
//	        name = new String(target_byte, "GBK");
//		}catch (JRException e)
//		
//		{

		
		
        sb.append("[");
        sb.append("\'<img src=\"" + "<c:url value=");
        sb.append("'" + menu.getImage() + "'");
        sb.append("/>\"");
        sb.append(" />',");
        sb.append("'" + name  + "',");
        sb.append("'" + menu.getAction() + "',");
        sb.append("'" + menu.getTarget() + "',");
        sb.append("'" + menu.getTitle() );
        
        int i = getSysMenuByParentId(menu.getId());
        
        if(i > 0){
        	sb.append("',");
        	getSysMenuByParentId(menu.getId(),sb);
        }else{
        	sb.append("'");
        }
       
        sb.append("]");
	}
	
	
	private void getSysMenuByParentId(Long parentId,StringBuffer sb){
		SysMenu sysMenu = new SysMenu();
		sysMenu.setParentId(parentId);

		
		List ls = dao.getSysMenus(sysMenu);
		
		for(Iterator it = ls.iterator();it.hasNext();){
			SysMenu menu = (SysMenu) it.next();
			fillNode(menu,sb);
		}

	}
	
	
	private int getSysMenuByParentId(Long parentId){
		SysMenu sysMenu = new SysMenu();
		sysMenu.setParentId(parentId);
		List ls = dao.getSysMenus(sysMenu);
		return  ls.size();
	}
	
	
	
	
	public int saveSysMenuDefault(SysMenu sysMenu) {
		
		DataSource dataSource= dao.getDefaultDataSource();
		
		String filePath = Constants.FILE_PATH_SQL_SCRIPT_MENUS;
		
		try {
			Connection conn = dataSource.getConnection();
	
			try {
//				ScriptRunner runner = new ScriptRunner(conn, false, false);
//				runner.setErrorLogWriter(null);
//				runner.setLogWriter(null);
//				runner.runScript(Resources.getResourceAsReader(filePath));

				File file =   Resources.getResourceAsFile(filePath);
//				System.out.println(">>>>>>>>>>>>>>>"+file.getAbsolutePath());
				InputStream sqlFileIn = new FileInputStream(file);
				InputStreamReader reader= new InputStreamReader(sqlFileIn, "UTF-8");  
				ScriptRunner runner = new ScriptRunner(conn, false, false);
				runner.setLogWriter(null);
				runner.setErrorLogWriter(null);
				runner.runScript(reader);
				conn.commit();
				reader.close();  
//				System.out.println(">>>>>>>>>>>>>>> ok");
			} finally {
				conn.close();
			}  
		}catch (Exception e) {  
			       throw new RuntimeException("Description.  Cause: " + e, e);  

		}  
		return 1;
	}


}
