package com.vriche.adrm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.OaDocumentCatalogDao;
import com.vriche.adrm.model.OaDocumentCatalog;
import com.vriche.adrm.service.OaDocumentCatalogManager;
import com.vriche.adrm.service.OaDocumentFileManager;
import com.vriche.adrm.service.OaDocumentManager;
import com.vriche.adrm.util.ConvertUtil;

public class OaDocumentCatalogManagerImpl extends BaseManager implements OaDocumentCatalogManager {
	
	
	private final Log logger = LogFactory.getLog(getClass());

	private OaDocumentCatalogDao dao;

	private OaDocumentManager oaDocumentManager;
	
	private OaDocumentFileManager oaDocumentFileManager;

	/**
	 * Set the Dao for communication with the data layer.
	 * @param dao
	 */
	public void setOaDocumentCatalogDao(OaDocumentCatalogDao dao) {
		this.dao = dao;
	}

	public void setOaDocumentManager(OaDocumentManager documentManager) {
		this.oaDocumentManager = documentManager;
	}

	public void setOaDocumentFileManager(OaDocumentFileManager oaDocumentFileManager) {
		this.oaDocumentFileManager = oaDocumentFileManager;
	}	
	
	/**
	 * @see com.vriche.adrm.service.OaDocumentCatalogManager#getOaDocumentCatalogs(com.vriche.adrm.model.OaDocumentCatalog)
	 */
	public List getOaDocumentCatalogs(final OaDocumentCatalog oaDocumentCatalog) {
		return dao.getOaDocumentCatalogs(oaDocumentCatalog);
	}

//	public void right() {
//		SecurityContext ctx = SecurityContextHolder.getContext();
//		if (ctx.getAuthentication() != null) {
//			Authentication auth = ctx.getAuthentication();
//
//			System.out.println("auth>>>>>>>>>>" + auth.toString());
//
//			String currentUser;
//			if (auth.getPrincipal() instanceof UserDetails) {
//				currentUser = ((UserDetails) auth.getPrincipal()).getUsername();
//			} else {
//				currentUser = String.valueOf(auth.getPrincipal());
//			}
//			System.out.println("currentUser:>>>>>>>>>>" + currentUser);
//		}
//	}

	private void getOaDocumentCatalogsIdsByParent(String id, StringBuffer sb,String IdPrefix) {
		OaDocumentCatalog catalog = new OaDocumentCatalog();
		catalog.setParentId(id);
		Iterator it = this.getOaDocumentCatalogs(catalog).iterator();
		while (it.hasNext()) {
			OaDocumentCatalog dc = (OaDocumentCatalog) it.next();

			sb.append("<item id='" +IdPrefix
							+ dc.getId().toString()
							+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
							+ dc.getName().toString() + "\">");
			sb.append("<userdata name=\"id\">" + dc.getId().toString()
					+ "</userdata>");
			sb.append("<userdata name=\"type\">1</userdata>");
			getOaDocumentCatalogsIdsByParent(dc.getId().toString(), sb,IdPrefix);
			sb.append("</item>");

		}
	}
	
	private void getOaDocumentCatalogsIdsByParentDocument(String id, StringBuffer sb,String OaDocumentCatalogIdPrefix, String OaDocumentIdPrefix,String userId) {
		Map mp = new HashMap();
		mp.put("parentId",id);
		mp.put("userId",userId);
		System.out.println("getOaDocumentCatalogsIdsByParentDocument: parentId>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + id);
		System.out.println("getOaDocumentCatalogsIdsByParentDocument: userId>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + userId);
		
		Iterator it = this.getOaDocumentCatalogByUserId(mp).iterator();
		while (it.hasNext()) {
			OaDocumentCatalog dc = (OaDocumentCatalog) it.next();

			sb.append("<item id='" +OaDocumentCatalogIdPrefix
							+ dc.getId().toString()
							+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
							+ dc.getName().toString() + "\">");
			sb.append("<userdata name=\"id\">" + dc.getId().toString()
					+ "</userdata>");
			sb.append("<userdata name=\"type\">1</userdata>");
			oaDocumentManager.getOaDocumentsItemsByCatalogId(sb,dc.getId().toString(),OaDocumentIdPrefix);
			getOaDocumentCatalogsIdsByParentDocument(dc.getId().toString(), sb,OaDocumentCatalogIdPrefix,OaDocumentIdPrefix,userId);
			sb.append("</item>");

		}
	}
	
	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.OaDocumentCatalogManager#getOaDocumentCatalogsXML(com.vriche.adrm.model.OaDocumentCatalog)
	 */
	public String getOaDocumentCatalogsXML(OaDocumentCatalog oaDocumentCatalog,String IdPrefix) {
		StringBuffer sb = new StringBuffer("");
		sb.append("<?xml version=\"1.0\"?>");
		sb.append("<tree id=\"0\">");
		sb.append("<item text=\"文档目录\" id=\"root\" open=\"1\" im0=\"books_close.gif\" im1=\"tombs.gif\" im2=\"tombs.gif\" call=\"1\" select=\"1\">");
		sb.append("<userdata name=\"id\">0</userdata>");
		sb.append("<userdata name=\"type\">0</userdata>");
		getOaDocumentCatalogsIdsByParent(oaDocumentCatalog.getParentId(),sb,IdPrefix);
		sb.append("</item>");
		sb.append("</tree>");
//		System.out.println("getOaDocumentCatalogsXML:>>>>>>>>>>" + sb.toString());
		return sb.toString();
	}

	/**
	 * @see com.vriche.adrm.service.OaDocumentCatalogManager#getOaDocumentCatalogsCount(com.vriche.adrm.model.OaDocumentCatalog)
	 */
	public String getOaDocumentCatalogsCount(final OaDocumentCatalog oaDocumentCatalog) {
		return dao.getOaDocumentCatalogsCount(oaDocumentCatalog).toString();
	}

	/**
	 * @see com.vriche.adrm.service.OaDocumentCatalogManager#getOaDocumentCatalogsCount(com.vriche.adrm.model.OaDocumentCatalog)
	 */
	public PaginatedList getOaDocumentCatalogsPage(
			final OaDocumentCatalog oaDocumentCatalog, String pageIndex,
			String pageSize) {
		return dao.getOaDocumentCatalogsPage(oaDocumentCatalog, Integer
				.parseInt(pageIndex), Integer.parseInt(pageSize));
	}

	/**
	 * @see com.vriche.adrm.service.OaDocumentCatalogManager#getOaDocumentCatalog(String id)
	 */
	public OaDocumentCatalog getOaDocumentCatalog(final String id) {

		OaDocumentCatalog documentCatalog = dao.getOaDocumentCatalog(new Long(id));

		List lsPermitUsers = this.getOaDocumentCatalogPermitUsers(id);
		Set permitUsers = ConvertUtil.convertIdsFromListToArray(lsPermitUsers);
		documentCatalog.setPermitUsers(permitUsers);

		List lsPermitType = this.getOaDocumentCatalogPermits(id);
		Set permit = ConvertUtil.convertIdsFromListToArray(lsPermitType);
		documentCatalog.setPermitTypes(permit);

		return documentCatalog;

	}
	

	public String[] getPermitUsersColByCatalogId(String documentCatalogId,String propertyName) {
		List ls = dao.getOaDocumentCatalogPermitUsers(new Long(documentCatalogId));
		
		logger.info("ls.size" +ls.size());
		
		int size = ls.size();
		String[] s = new String[size];
		
		int j = 0;
		for (Iterator it = ls.iterator();it.hasNext();){
			try {
				s[j++] = ((Integer)it.next()).toString();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		for(int i = 0 ; i< s.length ; i++){
			logger.info("s" + s[i].toString());
		}	
		return s;
	}
	
	public String[] getCatalogPermitsColByCatalogId(String documentCatalogId,String propertyName) {
		List ls = dao.getOaDocumentCatalogPermits(new Long(documentCatalogId));
		int size = ls.size();
		String[] s = new String[size];
		
		int j = 0;
		for (Iterator it = ls.iterator();it.hasNext();){
			try {
				s[j++] =  ((Integer)it.next()).toString();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return s;
	}
	
	

	/**
	 * @see com.vriche.adrm.service.OaDocumentCatalogManager#getOaDocumentCatalogsByIdList(final Map idList)
	 */
	public List getOaDocumentCatalogsByIdList(final Map idList) {
		return dao.getOaDocumentCatalogsByIdList(idList);
	}

	/**
	 * @see com.vriche.adrm.service.OaDocumentCatalogManager#saveOaDocumentCatalog(OaDocumentCatalog oaDocumentCatalog)
	 */
	public String saveOaDocumentCatalog(OaDocumentCatalog oaDocumentCatalog) {
		
		String id = dao.saveOaDocumentCatalog(oaDocumentCatalog).toString();
		int permitTypeSize = oaDocumentCatalog.getPermitTypes().size();
		int permitUserSize = oaDocumentCatalog.getPermitUsers().size();
		
		//保存入口用户
		if(permitTypeSize > 0){
			this.saveOaDocumentCatalogPermits(oaDocumentCatalog, id);
		}
		if(permitUserSize > 0){
			this.saveOaDocumentCatalogPermitUsers(oaDocumentCatalog, id);
		}
		
		return id;
	}

	/**
	 * @see com.vriche.adrm.service.OaDocumentCatalogManager#removeOaDocumentCatalog(String id)
	 */
	public void removeOaDocumentCatalog(final String id) {
		List catalogIdList = getIdsCatalog(id);
		
		Map catalogIds = ConvertUtil.convertListToMap(
				"OaDocumentCatalogIdList", catalogIdList);
		
		List documentIdList = new ArrayList();
		for(Iterator it = catalogIdList.iterator();it.hasNext();){
			String catalogId = it.next().toString();
//			System.out.println(catalogId);
			CollectionUtils.addAll(documentIdList,oaDocumentManager.getDocumentIdsByCatalogId(catalogId).iterator());
		}
		
		
		
		Map documentIds = ConvertUtil.convertListToMap("OaDocumentIdList",
				documentIdList);

		//删除允许用户
		this.removeOaDocumentCatalogPermitUsers(catalogIds);
		//删除允许用户
		this.removeOaDocumentCatalogPermits(catalogIds);
		//删除文件		
		oaDocumentFileManager.removeOaDocumentFilesByDocumentId(documentIds);
		//删除文档
//		oaDocumentManager.removeOaDocuments(documentIds);
		oaDocumentManager.removeOaDocumentsByCatalogId(catalogIds);
		//删除目录
		this.removeOaDocumentCatalogs(catalogIds);
		//        dao.removeOaDocumentCatalog(new Long(id));
	}

	/**
	 * @see com.vriche.adrm.service.OaDocumentCatalogManager#removeOaDocumentCatalogs(String Map)
	 */
	public void removeOaDocumentCatalogs(final Map idList) {
		dao.removeOaDocumentCatalogs(idList);
	}

	private List getOaDocumentCatalogsByParent(String id, List idList) {
		OaDocumentCatalog oaDocumentCatalog = new OaDocumentCatalog();
		oaDocumentCatalog.setParentId(id.toString());
		Iterator it = this.getOaDocumentCatalogs(oaDocumentCatalog).iterator();
		while (it.hasNext()) {
			OaDocumentCatalog catalog = (OaDocumentCatalog) it.next();
			idList.add(catalog.getId());
			getOaDocumentCatalogsByParent(catalog.getId().toString(), idList);
		}
		return idList;
	}

	private List getIdsCatalog(String id) {
		List idList = new ArrayList();
		idList.add(id);
		idList = getOaDocumentCatalogsByParent(id, idList);
		return idList;
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.OaDocumentCatalogManager#getOaDocumentCatalogPermits(java.lang.String)
	 */
	public List getOaDocumentCatalogPermits(String id) {
		return dao.getOaDocumentCatalogPermits(new Long(id));
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.OaDocumentCatalogManager#getOaDocumentCatalogPermitUsers(java.lang.String)
	 */
	public List getOaDocumentCatalogPermitUsers(String id) {
		return dao.getOaDocumentCatalogPermitUsers(new Long(id));
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.OaDocumentCatalogManager#removeOaDocumentCatalogPermits(java.util.Map)
	 */
	public void removeOaDocumentCatalogPermits(Map idList) {
		dao.removeOaDocumentCatalogPermits(idList);

	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.OaDocumentCatalogManager#removeOaDocumentCatalogPermitUsers(java.util.Map)
	 */
	public void removeOaDocumentCatalogPermitUsers(Map idList) {
		dao.removeOaDocumentCatalogPermitUsers(idList);

	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.OaDocumentCatalogManager#saveOaDocumentCatalogPermits(com.vriche.adrm.model.OaDocumentCatalog, java.lang.String)
	 */
	public void saveOaDocumentCatalogPermits(OaDocumentCatalog oaDocumentCatalog, String id) {
		dao.saveOaDocumentCatalogPermits(oaDocumentCatalog, new Long(id));

	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.OaDocumentCatalogManager#saveOaDocumentCatalogPermitUsers(com.vriche.adrm.model.OaDocumentCatalog, java.lang.String)
	 */
	public void saveOaDocumentCatalogPermitUsers(OaDocumentCatalog oaDocumentCatalog, String id) {
		dao.saveOaDocumentCatalogPermitUsers(oaDocumentCatalog, new Long(id));

	}

	public String getOaDocumentCatalogDocumentXml(OaDocumentCatalog oaDocumentCatalog,String OaDocumentCatalogIdPrefix,String OaDocumentIdPrefix,String userId) {

		StringBuffer sb = new StringBuffer("");
		
		sb.append("<?xml version=\"1.0\"?>");
		sb.append("<tree id=\"0\">");
		sb.append("<item text=\"文档目录\" id=\"root\" open=\"1\" im0=\"books_close.gif\" im1=\"tombs.gif\" im2=\"tombs.gif\" call=\"1\" select=\"1\">");
		sb.append("<userdata name=\"id\">0</userdata>");
		sb.append("<userdata name=\"type\">0</userdata>");
		
		getOaDocumentCatalogsIdsByParentDocument(oaDocumentCatalog.getParentId(),sb,OaDocumentCatalogIdPrefix,OaDocumentIdPrefix,userId);
		sb.append("</item>");
		sb.append("</tree>");
		
		
		return sb.toString();
	}

	private List getOaDocumentCatalogByUserId(Map mp ) {
		return dao.getOaDocumentCatalogs(mp);
	}


}
