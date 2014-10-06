
package com.vriche.adrm.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.vriche.adrm.Constants;
import com.vriche.adrm.dao.SpecificDao;
import com.vriche.adrm.model.Branch;
import com.vriche.adrm.model.Org;
import com.vriche.adrm.model.Specific;
import com.vriche.adrm.service.SpecificManager;
import com.vriche.adrm.util.StringUtil;

public class SpecificManagerImpl extends BaseManager implements SpecificManager {
    private SpecificDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setSpecificDao(SpecificDao dao) {
        this.dao = dao;
    }

    /**
     * @see com.vriche.adrm.adres.service.SpecificManager#getSpecificsByIdList(final Map idList)
     */
    public List getSpecificsByIdList(final Map idList) {
        return dao.getSpecificsByIdList(idList);
    }
   /**
     * @see com.vriche.adrm.adres.service.SpecificManager#getSpecifics(com.vriche.adrm.adres.model.Specific)
     */
    public List getSpecifics(final Specific specific) {
        return dao.getSpecifics(specific);
    }

    /**
     * @see com.vriche.adrm.adres.service.SpecificManager#getSpecific(String id)
     */
    public Specific getSpecific(final String id) {
        return dao.getSpecific(new Long(id));
    }

    /**
     * @see com.vriche.adrm.adres.service.SpecificManager#saveSpecific(Specific specific)
     */
    public void saveSpecific(Specific specific) {
        dao.saveSpecific(specific);
    }

    /**
     * @see com.vriche.adrm.adres.service.SpecificManager#removeSpecific(String id)
     */
    public void removeSpecific(final String id) {
        dao.removeSpecific(new Long(id));
    }

     /**
     * @see com.vriche.adrm.adres.service.SpecificManager#removeSpecifics(String Map)
     */
    public void removeSpecifics(final Map idList) {
        dao.removeSpecifics(idList);
    }

	public Map getSpecificSelect(Specific specific) {
		List ls = this.getSpecifics(specific);
		
	    Map reply = new LinkedHashMap();
	    Iterator it = ls.iterator();
	    
	    while(it.hasNext()){
	    	Specific specifics = new Specific();
	    	specifics = (Specific) it.next();
	    	
	    	reply.put("0","");
	    	reply.put(specifics.getId(),specifics.getName()+ " || " + specifics.getPosition());
	    }
		return reply;
	}

	public Map getSpecificSelectFromMap(Specific specific) {
		// TODO Auto-generated method stub
		
		List sf = (List)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_SOECUFUC);
		
		Map reply = new LinkedHashMap();
		
	    Iterator it = sf.iterator();
	    
	    while(it.hasNext()){
	    	Specific specifics = new Specific();
	    	specifics = (Specific) it.next();
	    	
	    	reply.put("0","");
	    	reply.put(specifics.getId(),specifics.getName()+ " || " + specifics.getPosition());
	    }
		return reply;
	}    
	
	
	
	public Map getSpecificSelectFromMap2(Specific specific) {
		// TODO Auto-generated method stub
		
		List sf = (List)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_SOECUFUC);
		
		Map reply = new LinkedHashMap();
		
	    Iterator it = sf.iterator();
	    
	    while(it.hasNext()){
	    	Specific specifics = new Specific();
	    	specifics = (Specific) it.next();
	    	
	    	reply.put("0","");
	    	reply.put(specifics.getPosition(),specifics.getName());
	    }
		return reply;
	}    
	
	public List getSpecificSelectFromMap3(Specific specific) {
		// TODO Auto-generated method stub
		List ls = new ArrayList();
		Specific sp = new Specific();
		sp.setId(new Long(0));
		sp.setName("");
		sp.setPosition("");
		ls.add(sp);
		
		List ls2 = (List)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_SOECUFUC);
		 Iterator it = ls2.iterator();
	    while(it.hasNext()){

	    	Specific specifics = (Specific) it.next();
	    	if(specifics.getId().intValue() > 0) ls.add(specifics);
	    	System.out.println("sameNameIds   "+specifics.getId()+ " || " + specifics.getPosition());
            
	    }

		
		return ls;
	}  
	
	
	
	
	
	
	
	public String getSpecificsXML(Specific specific) {
		StringBuffer sb = new StringBuffer("");
		sb.append("<?xml version=\"1.0\"?>");
		sb.append("<tree id=\"0\">");

		 List ls =  dao.getSpecifics(specific);
		 
		 sb.append("<item text=\""+ "指定信息" + "\" id=\"root"  + "\" open=\"1\" im0=\"books_close.gif\" im1=\"tombs.gif\" im2=\"tombs.gif\" call=\"1\" select=\"1\">");
		 sb.append("<userdata name=\"type\">0</userdata>");	
		for (Iterator it = ls.iterator();it.hasNext();){
			Specific spec = (Specific)it.next();
				sb.append("<item text=\""+ spec.getName() + "\" id=\"" + spec.getId().toString() + "\" open=\"1\" im0=\"magazines_close.gif\" im1=\"magazines_open.gif\" im2=\"magazines_close.gif\" call=\"1\" select=\"1\">");
				sb.append("<userdata name=\"type\">1</userdata>");
				sb.append("<userdata name=\"position\">"+ spec.getPosition() +"</userdata>");
				sb.append("</item>");
		}
		
		sb.append("</item>");
		
		sb.append("</tree>");
		return new String(sb.toString());
	}  
	
	
	
	
	
	
	
	
	
	
}
