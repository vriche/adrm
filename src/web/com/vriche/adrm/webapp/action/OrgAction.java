
package com.vriche.adrm.webapp.action;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.upload.FormFile;

import com.vriche.adrm.Constants;
import com.vriche.adrm.model.Org;
import com.vriche.adrm.service.OrgManager;
import com.vriche.adrm.util.Files;
import com.vriche.adrm.util.Page;
import com.vriche.adrm.util.SysParamUtil;
import com.vriche.adrm.webapp.form.OrgForm;

/**
 * Action class to handle CRUD on a Org object
 *
 * @struts.action name="orgForm" path="/orgs" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="orgForm" path="/editOrg" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="orgForm" path="/saveOrg" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/admin/orgForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/admin/orgList.jsp"
 * @struts.action-forward name="search" path="orgs.html" redirect="true"
 */
public final class OrgAction extends BaseAction {
    public ActionForward cancel(ActionMapping mapping, ActionForm form,
                                HttpServletRequest request,
                                HttpServletResponse response)
    throws Exception {
        return mapping.findForward("search");
    }

    public ActionForward delete(ActionMapping mapping, ActionForm form,
                                HttpServletRequest request,
                                HttpServletResponse response)
    throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("Entering 'delete' method");
        }

        ActionMessages messages = new ActionMessages();
        OrgForm orgForm = (OrgForm) form;

        // Exceptions are caught by ActionExceptionHandler
        OrgManager mgr = (OrgManager) getBean("orgManager");
        mgr.removeOrg(orgForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("org.deleted"));

        // save messages in session, so they'll survive the redirect
        saveMessages(request.getSession(), messages);

        return mapping.findForward("search");
    }

    public ActionForward edit(ActionMapping mapping, ActionForm form,
                              HttpServletRequest request,
                              HttpServletResponse response)
    throws Exception {

        OrgForm orgForm = (OrgForm) form;
        
        
		
//		orgForm.setLogFile(og.getLogFile());
		
        if (log.isDebugEnabled()) {
//            log.info("Entering 'edit' method getLogFile>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +og.getLogFile());
        }


        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (orgForm.getId() != null) {
        	OrgManager mgr = (OrgManager) getBean("orgManager");
        	Org og = SysParamUtil.getOrgFromMap(orgForm.getId().toLowerCase());	
            Org org = mgr.getOrg(orgForm.getId());
            org.setLogFile(og.getLogFile());
            
            orgForm = (OrgForm) convert(org);
            updateFormBean(mapping, request, orgForm);
        }

        return mapping.findForward("edit");
    }

    public ActionForward save(ActionMapping mapping, ActionForm form,
                              HttpServletRequest request,
                              HttpServletResponse response)
    throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("Entering 'save' method");
        }

        // Extract attributes and parameters we will need
        ActionMessages messages = new ActionMessages();
        OrgForm orgForm = (OrgForm) form;
        boolean isNew = ("".equals(orgForm.getId()) || orgForm.getId() == null);

        OrgManager mgr = (OrgManager) getBean("orgManager");
        Org org = (Org) convert(orgForm);

        FormFile file = orgForm.getImage();
        String fileName = file.getFileName();
        if(fileName != null && fileName != ""){
            byte[] fileData    = file.getFileData();
            org.setLogo(fileData);
            org.setLogoType(file.getContentType());
          }
        
        mgr.saveOrg(org);
        
        
//      FileInputStream in = new FileInputStream(file);
//      BufferedInputStream in = new BufferedInputStream(file);  
//      byte[] b = FileCopyUtils.copyToByteArray(in);  
//      org.setLogo(b);       
        
        if(fileName != null && fileName != ""){
          byte[] fileData    = file.getFileData();
          org.setLogo(fileData);
          org.setLogoType(file.getContentType());
          mgr.saveOrgLogo(org);
          
          String path =servlet.getServletContext().getRealPath("/")+"images"+ Constants.FILE_SEP +org.getId()+ Constants.FILE_SEP ;
          String file_name ="logo.jpg";
          Files  f = new Files();
          f.checkFile(path,path+file_name);
          
          String tarFile = path+file_name;
          OutputStream bos = new FileOutputStream(tarFile);
          bos.write(fileData);
          bos.close();
        }

//      InputStream stream = file2.getInputStream();
        //
//                    //write the file to the file specified
//                    OutputStream bos = new FileOutputStream(tarFile);
//                    int bytesRead = 0;
//                    byte[] buffer = new byte[8192];
        //
//                    while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) {
//                        bos.write(buffer, 0, bytesRead);
//                    }
        //
//                    bos.close();
//                    //close the stream
//                    stream.close();  
        
        

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("org.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("org.updated"));
            saveMessages(request, messages);

            return mapping.findForward("edit");
        }
    }

    public ActionForward search(ActionMapping mapping, ActionForm form,
                                HttpServletRequest request,
                                HttpServletResponse response)
    throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("Entering 'search' method");
        }

        OrgForm orgForm = (OrgForm) form;
        Org org = (Org) convert(orgForm);
        OrgManager mgr = (OrgManager) getBean("orgManager");
        org = null;
        int resultSize = Integer.parseInt(mgr.getOrgsCount(org));
        Page page = new Page(Constants.ORG_LIST,request);        
        List pageList = mgr.getOrgsPage(org,page.getPageIndex().toString(),page.getPageSize().toString());
//        pageList.gotoPage(page.getPageIndex().intValue());   
        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.ORG_LIST, pageList);                    
        //request.setAttribute(Constants.ORG_LIST, mgr.getOrgs(org));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
