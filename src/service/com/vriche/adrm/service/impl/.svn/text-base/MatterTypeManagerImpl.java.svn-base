
package com.vriche.adrm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.Constants;
import com.vriche.adrm.dao.MatterTypeDao;
import com.vriche.adrm.model.CarrierType;
import com.vriche.adrm.model.MatterType;
import com.vriche.adrm.model.SysParam;
import com.vriche.adrm.service.MatterManager;
import com.vriche.adrm.service.MatterTypeManager;

public class MatterTypeManagerImpl extends BaseManager implements MatterTypeManager {
    private MatterTypeDao dao;
    private MatterManager matterManager;
    public void setMatterManager(MatterManager matterManager) {
		this.matterManager = matterManager;
	}
	/**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setMatterTypeDao(MatterTypeDao dao) {
        this.dao = dao;
    }
   /**
     * @see com.vriche.adrm.service.MatterTypeManager#getMatterTypes(com.vriche.adrm.model.MatterType)
     */
    public List getMatterTypes(final MatterType matterType) {
        return dao.getMatterTypes(matterType);
    }
   /**
     * @see com.vriche.adrm.service.MatterTypeManager#getMatterTypesCount(com.vriche.adrm.model.MatterType)
     */
    public String getMatterTypesCount(final MatterType matterType) {
        return dao.getMatterTypesCount(matterType).toString();
    }    

   /**
     * @see com.vriche.adrm.service.MatterTypeManager#getMatterTypesCount(com.vriche.adrm.model.MatterType)
     */    
	public PaginatedList getMatterTypesPage(final MatterType matterType,String pageIndex, String pageSize) {
		return dao.getMatterTypesPage(matterType,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    

    /**
     * @see com.vriche.adrm.service.MatterTypeManager#getMatterType(String id)
     */
    public MatterType getMatterType(final String id) {
        return dao.getMatterType(new Long(id));
    }
    /**
     * @see com.vriche.adrm.service.MatterTypeManager#getMatterTypesByIdList(final Map idList)
     */
    public List getMatterTypesByIdList(final Map idList) {
        return dao.getMatterTypesByIdList(idList);
    }    

    /**
     * @see com.vriche.adrm.service.MatterTypeManager#saveMatterType(MatterType matterType)
     */
    public String saveMatterType(MatterType matterType) {
        return dao.saveMatterType(matterType).toString();
    }

    /**
     * @see com.vriche.adrm.service.MatterTypeManager#removeMatterType(String id)
     */
    public void removeMatterType(final String id) {
        dao.removeMatterType(new Long(id));
    }

     /**
     * @see com.vriche.adrm.service.MatterTypeManager#removeMatterTypes(String Map)
     */
    public void removeMatterTypes(final Map idList) {
        dao.removeMatterTypes(idList);
    }
	public Map getMatterTypeSelect(MatterType matterType) {
		// TODO Auto-generated method stub
		List ls = this.getMatterTypes(matterType);
				
			    Map reply = new LinkedHashMap();
			    Iterator it = ls.iterator();
			    
			    while(it.hasNext()){
			    	
			    	MatterType types =(MatterType)it.next();
			    	
			    	reply.put("","==广告类别==");
			    	
			    	reply.put(types.getId(),types.getName());
			    }
			   
				return reply;
	}
	public String getMatterTypeXML(MatterType matterType, String typeIdPrefix,String matterIdPrefix) {
//		System.out.println("fffffffffffff   "+typeIdPrefix+"  "+matterIdPrefix);
		StringBuffer sb = new StringBuffer("");
		sb.append("<?xml version=\"1.0\"?>");
		sb.append("<tree id=\"0\">");
		sb.append("<item text=\"素材信息\" id=\"root\" open=\"1\" im0=\"books_close.gif\" im1=\"tombs.gif\" im2=\"tombs.gif\" call=\"1\" select=\"1\">");
		sb.append("<userdata name=\"id\">0</userdata>");
		sb.append("<userdata name=\"type\">0</userdata>");
		getMatterTypeForTree(sb,typeIdPrefix,matterIdPrefix);
		sb.append("</item>");
		sb.append("</tree>");

		return sb.toString();
	}
	
		private void getMatterTypeForTree(StringBuffer sb,String typeIdPrefix,String matterIdPrefix){
			SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
			String matterTypeIds = sysParam.getDianpianParam()==null?"2,3":sysParam.getDianpianParam();
//			System.out.println("sssssssssss   "+matterTypeIds);
			String[] ids = matterTypeIds.split(",");
//			System.out.println("String[] ids   "+ids.length);
			List ls = new ArrayList();
			CollectionUtils.addAll(ls,ids);
//			ls.add("1");ls.add("2");ls.add("3");
			Map mp = new HashMap();
			mp.put("MatterTypeIdList",ls);
//			for(int i = 0;i<ls.size();i++){
//				System.out.println("sssss LIST ssssss   "+ls.get(i));
				
			Iterator it = this.getMatterTypesByIdList(mp).iterator();

//			System.out.println("sssss size() ssssss   "+it.hasNext());
			while(it.hasNext()) {
//				System.out.println("dddd  while  dddd   "+it.next());			
				MatterType mt = (MatterType) it.next();
				int id = mt.getId().intValue();
				sb.append("<item id='" +typeIdPrefix
								+ id
								+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
								+ mt.getName().toString() + "\">");
				sb.append("<userdata name=\"id\">" + id
						+ "</userdata>");
				sb.append("<userdata name=\"type\">1</userdata>");
//				System.out.println("HHHHHHHHHHHHHHH   ");		
//				+"<![CDATA["+ mt.getName().toString() +"]]>"+ "\">");
				matterManager.getMattersByAdvMatterType(new Integer(id), sb,matterIdPrefix);
				sb.append("</item>");
			}	
	}
}
