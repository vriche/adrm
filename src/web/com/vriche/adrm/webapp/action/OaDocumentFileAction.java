
package com.vriche.adrm.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.webapp.action.BaseAction;
import com.vriche.adrm.Constants;
import com.vriche.adrm.model.OaDocumentFile;
import com.vriche.adrm.service.OaDocumentFileManager;
import com.vriche.adrm.webapp.form.OaDocumentFileForm;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a OaDocumentFile object
 *
 * @struts.action name="oaDocumentFileForm" path="/oaDocumentFiles" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="oaDocumentFileForm" path="/editOaDocumentFile" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="oaDocumentFileForm" path="/saveOaDocumentFile" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/document/oaDocumentFileForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/document/oaDocumentFileList.jsp"
 * @struts.action-forward name="search" path="/oaDocumentFiles.html" redirect="true"
 */
public final class OaDocumentFileAction extends BaseAction {
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
        OaDocumentFileForm oaDocumentFileForm = (OaDocumentFileForm) form;

        // Exceptions are caught by ActionExceptionHandler
        OaDocumentFileManager mgr = (OaDocumentFileManager) getBean("oaDocumentFileManager");
        mgr.removeOaDocumentFile(oaDocumentFileForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("oaDocumentFile.deleted"));

        // save messages in session, so they'll survive the redirect
        saveMessages(request.getSession(), messages);

        return mapping.findForward("search");
    }

    public ActionForward edit(ActionMapping mapping, ActionForm form,
                              HttpServletRequest request,
                              HttpServletResponse response)
    throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("Entering 'edit' method");
        }

        OaDocumentFileForm oaDocumentFileForm = (OaDocumentFileForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (oaDocumentFileForm.getId() != null) {
            OaDocumentFileManager mgr = (OaDocumentFileManager) getBean("oaDocumentFileManager");
            OaDocumentFile oaDocumentFile = mgr.getOaDocumentFile(oaDocumentFileForm.getId());
            oaDocumentFileForm = (OaDocumentFileForm) convert(oaDocumentFile);
            updateFormBean(mapping, request, oaDocumentFileForm);
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
        OaDocumentFileForm oaDocumentFileForm = (OaDocumentFileForm) form;
        boolean isNew = ("".equals(oaDocumentFileForm.getId()) || oaDocumentFileForm.getId() == null);

        OaDocumentFileManager mgr = (OaDocumentFileManager) getBean("oaDocumentFileManager");
        OaDocumentFile oaDocumentFile = (OaDocumentFile) convert(oaDocumentFileForm);
        mgr.saveOaDocumentFile(oaDocumentFile);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("oaDocumentFile.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("oaDocumentFile.updated"));
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

        OaDocumentFileForm oaDocumentFileForm = (OaDocumentFileForm) form;
        OaDocumentFile oaDocumentFile = (OaDocumentFile) convert(oaDocumentFileForm);
        OaDocumentFileManager mgr = (OaDocumentFileManager) getBean("oaDocumentFileManager");
        oaDocumentFile = null;
        int resultSize = Integer.parseInt(mgr.getOaDocumentFilesCount(oaDocumentFile));
        Page page = new Page(Constants.OADOCUMENTFILE_LIST,request);        
        PaginatedList pageList = mgr.getOaDocumentFilesPage(oaDocumentFile,page.getPageIndex().toString(),page.getPageSize().toString());
        pageList.gotoPage(page.getPageIndex().intValue());   
        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.OADOCUMENTFILE_LIST, pageList);                    
        //request.setAttribute(Constants.OADOCUMENTFILE_LIST, mgr.getOaDocumentFiles(oaDocumentFile));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
