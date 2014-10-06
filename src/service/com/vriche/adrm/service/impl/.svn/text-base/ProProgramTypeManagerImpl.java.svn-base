
package com.vriche.adrm.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.ProExpenseProgramDao;
import com.vriche.adrm.dao.ProExpenseTypeDao;
import com.vriche.adrm.dao.ProProgramTypeDao;
import com.vriche.adrm.model.Branch;
import com.vriche.adrm.model.ProExpenseProgram;
import com.vriche.adrm.model.ProProgramType;
import com.vriche.adrm.service.ProProgramTypeManager;

public class ProProgramTypeManagerImpl extends BaseManager implements ProProgramTypeManager {
    private ProProgramTypeDao dao;
    private ProExpenseTypeDao proExpenseTypeDao;
    private ProExpenseProgramDao proExpenseProgramDao;
    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setProProgramTypeDao(ProProgramTypeDao dao) {
        this.dao = dao;
    }
    
    /**
     * Set the Dao for communication with the data layer.
     * @param proExpenseTypeDao
     */
	public void setProExpenseTypeDao(ProExpenseTypeDao proExpenseTypeDao) {
		this.proExpenseTypeDao = proExpenseTypeDao;
	}
	/**
     * Set the Dao for communication with the data layer.
     * @param proExpenseProgramDao
     */
	public void setProExpenseProgramDao(ProExpenseProgramDao proExpenseProgramDao) {
		this.proExpenseProgramDao = proExpenseProgramDao;
	}
   /**
     * @see com.vriche.adrm.service.ProProgramTypeManager#getProProgramTypes(com.vriche.adrm.model.ProProgramType)
     */
    public List getProProgramTypes(final ProProgramType proProgramType) {
        return dao.getProProgramTypes(proProgramType);
    }
    /**
     * @see com.vriche.adrm.service.ProProgramTypeManager#getProProgramStatusXML(com.vriche.adrm.model.ProProgramType)
     */
    public String getProProgramStatusXML(final ProProgramType proProgramType) {
       
			StringBuffer sb = new StringBuffer();
			List ls= dao.getProProgramStatus(proProgramType);
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<rows>");   
			for(Iterator it = ls.iterator();it.hasNext();){
				ProProgramType obj = (ProProgramType)it.next();
				sb.append("<row  id=\""+ obj.getId() +"\"" +">");
				sb.append("<cell><![CDATA["+ obj.getName()  +"]]></cell>");
				sb.append("<cell><![CDATA["+ obj.getDisplayNo()  +"]]></cell>");
				sb.append("</row>");
			}
			sb.append("</rows>");	
			return sb.toString();
    }
    /**
     * @see com.vriche.adrm.service.ProProgramTypeManager#getProProgramStatus(com.vriche.adrm.model.ProProgramType)
     */
    public ProProgramType getProProgramStatus(final ProProgramType proProgramType) {
    	
        List ls=dao.getProProgramStatus(proProgramType);
        ProProgramType pro=new ProProgramType();
        for(Iterator it=ls.iterator();it.hasNext();){
        		pro=(ProProgramType)it.next();
        }
        return pro;
    }
    
    /**
     * @see com.vriche.adrm.service.ProProgramTypeManager#getProProgramStatusList(com.vriche.adrm.model.ProProgramType)
     */
    public List getProProgramStatusList(final ProProgramType proProgramType) {
    	return dao.getProProgramStatus(proProgramType);    
    }
    /**
     * @see com.vriche.adrm.service.ProProgramTypeManager#saveProProgramStatus(ProProgramType proProgramType)
     */
    public String saveProProgramStatus(ProProgramType proProgramType) {
        return dao.saveProProgramStatus(proProgramType).toString();
    }
    
    /**
     * @see com.vriche.adrm.service.ProProgramTypeManager#removeProProgramStatus(String id)
     */
    public void removeProProgramStatus(final String id) {
        dao.removeProProgramStatus(new Long(id));
    }
   /**
     * @see com.vriche.adrm.service.ProProgramTypeManager#getProProgramTypesCount(com.vriche.adrm.model.ProProgramType)
     */
    public String getProProgramTypesCount(final ProProgramType proProgramType) {
        return dao.getProProgramTypesCount(proProgramType).toString();
    }    

   /**
     * @see com.vriche.adrm.service.ProProgramTypeManager#getProProgramTypesCount(com.vriche.adrm.model.ProProgramType)
     */    
	public List getProProgramTypesPage(final ProProgramType proProgramType,String pageIndex, String pageSize) {
		return dao.getProProgramTypesPage(proProgramType,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    
   /**
     * @see com.vriche.adrm.service.ProProgramTypeManager#getProProgramTypesCount(com.vriche.adrm.model.ProProgramType)
     */    
	public String getProProgramTypesPageXML(final ProProgramType proProgramType,String pageIndex, String pageSize) {
	    StringBuffer sb = new StringBuffer();
	    List ls = dao.getProProgramTypesPage(proProgramType,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");   
		for(Iterator it = ls.iterator();it.hasNext();){
			ProProgramType obj = (ProProgramType)it.next();
			sb.append("<row  id=\""+ obj  +"\"" +">");
			sb.append("<cell><![CDATA["+ obj  +"]]></cell>");
			sb.append("</row>");
		}
		sb.append("</rows>");	
		return sb.toString();
	}    

    /**
     * @see com.vriche.adrm.service.ProProgramTypeManager#getProProgramType(String id)
     */
    public ProProgramType getProProgramType(final String id) {
        return dao.getProProgramType(new Long(id));
    }
    /**
     * @see com.vriche.adrm.service.ProProgramTypeManager#getProProgramTypesByIdList(final Map idList)
     */
    public List getProProgramTypesByMap(final Map mp) {
        return dao.getProProgramTypesByMap(mp);
    }    

    /**
     * @see com.vriche.adrm.service.ProProgramTypeManager#saveProProgramType(ProProgramType proProgramType)
     */
    public String saveProProgramType(ProProgramType proProgramType) {
        return dao.saveProProgramType(proProgramType).toString();
    }

    /**
     * @see com.vriche.adrm.service.ProProgramTypeManager#removeProProgramType(String id)
     */
    public void removeProProgramType(final String id) {
        dao.removeProProgramType(new Long(id));
    }

     /**
     * @see com.vriche.adrm.service.ProProgramTypeManager#removeProProgramTypes(String Map)
     */
    public void removeProProgramTypes(final Map mp) {
        dao.removeProProgramTypes(mp);
    }
	public String getProgramTypesXML(ProProgramType proProgramType) {
		StringBuffer sb = new StringBuffer();
		 int i=1;
		    List ls = dao.getProProgramTypes(proProgramType);
		    
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<complete>");   
			for(Iterator it = ls.iterator();it.hasNext();){
				ProProgramType obj = (ProProgramType)it.next();
				sb.append("<option  value=\""+ i++  +"\"" +">");
				sb.append("<![CDATA["+ obj.getName() +"]]>");
				sb.append("</option>");
			}
			sb.append("</complete>");
			return sb.toString();
	}
	
	
	public String getProProgramTypesXML(ProProgramType proProgramType, String IdPrefix) {
		StringBuffer sb = new StringBuffer("");
		sb.append("<?xml version=\"1.0\"?>");
		sb.append("<tree id=\"0\">");
		sb.append("<item text=\"节目类别\" id=\"" + IdPrefix + "-1\" open=\"1\" im0=\"books_close.gif\" im1=\"tombs.gif\" im2=\"tombs.gif\"  select=\"1\">");
		sb.append("<userdata name=\"type\">2</userdata>");
		getProgarmTypesItems(proProgramType.getParentId().toString(),sb,IdPrefix);
		sb.append("</item>");
		sb.append("</tree>");
		return new String(sb.toString());
	}    
	public void getProgarmTypesItems(String parentId,StringBuffer sb, String IdPrefix) {
		ProProgramType pro = new ProProgramType();
			pro.setParentId(parentId);
			List ls = this.getProProgramTypes(pro);
			
			for (Iterator it = ls.iterator();it.hasNext();){
				ProProgramType ProPT = (ProProgramType) it.next();
				sb.append("<item id='" +IdPrefix
								+ ProPT.getId().toString()
								+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
								+ ProPT.getName().toString() + "\">");
				sb.append("<userdata name=\"id\">"+ ProPT.getId().toString() +"</userdata>");
				Long pId = ProPT.getId();
				getProgarmTypesItems(pId.toString(),sb,IdPrefix);
				sb.append("</item>");
			}
	
	}
	public String getProgarmTypeTableXML(ProProgramType proProgramType) {
		StringBuffer sb = new StringBuffer();
	    List ls = getProProgramTypes(proProgramType);
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");   
		for(Iterator it = ls.iterator();it.hasNext();){
			ProProgramType obj = (ProProgramType)it.next();
			sb.append("<row  id=\""+ obj.getId() +"\"" +">");
			sb.append("<cell><![CDATA["+ obj.getId()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ obj.getName()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ obj.getDisplayNo()  +"]]></cell>");
			sb.append("</row>");
		}
		sb.append("</rows>");	
		return sb.toString();
	}
	public ProProgramType getProProgramTypeById(String id) {
		
		ProProgramType proProgramType = (ProProgramType)dao.getProProgramType(new Long(id));
		
		return proProgramType;
	}
	
	public ProProgramType getProExpenseTypeById(String id) {
		
		return proExpenseTypeDao.getProExpenseType(new Long(id));
	}
	
	public String getProExpenseTypeXML(ProProgramType proProgramType) {		
		StringBuffer sb = new StringBuffer();
	    List ls = proExpenseTypeDao.getProExpenseTypes(proProgramType);
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");   
		for(Iterator it = ls.iterator();it.hasNext();){
			ProProgramType obj = (ProProgramType)it.next();
			sb.append("<row  id=\""+ obj.getId() +"\"" +">");
			sb.append("<cell><![CDATA["+ obj.getName()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ obj.getDisplayNo()  +"]]></cell>");
			sb.append("</row>");
		}
		sb.append("</rows>");	
		return sb.toString();
	}
    /**
     * @see com.vriche.adrm.service.ProProgramTypeManager#saveProExpenseType(ProProgramType proProgramType)
     */
    public String saveProExpenseType(ProProgramType proProgramType) {
        return proExpenseTypeDao.saveProExpenseType(proProgramType).toString();
    }
    public void removeProExpenseType(final String id){
    	proExpenseTypeDao.removeProExpenseType(new Long(id));
    }
    
    /**
     * @see com.vriche.adrm.service.ProProgramTypeManager#saveProExpensemoney(ProExpenseProgram proExpenseProgram)
     */
    public void saveProExpenseMoney(ProExpenseProgram proExpenseProgram) {
        proExpenseProgramDao.saveProExpenseMoney(proExpenseProgram);
    }
    
	public ProProgramType getExpenseId(ProProgramType proProgramType) {
		System.out.println("####"+proProgramType.getName());
		ProProgramType pro= proExpenseTypeDao.getExpenseId(proProgramType);
		System.out.println("proId&&&"+pro);
		return pro;
	}

	
}
