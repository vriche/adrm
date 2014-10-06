
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
import com.vriche.adrm.model.OaDocument;
import com.vriche.adrm.service.OaDocumentManager;
import com.vriche.adrm.webapp.form.OaDocumentForm;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a OaDocument object
 *
 * @struts.action name="oaDocumentForm" path="/oaDocuments" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="oaDocumentForm" path="/editOaDocument" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="oaDocumentForm" path="/saveOaDocument" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/document/oaDocumentForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/document/oaDocumentList.jsp"
 * @struts.action-forward name="search" path="/oaDocuments.html" redirect="true"
 */
public final class OaDocumentAction extends BaseAction {
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
        OaDocumentForm oaDocumentForm = (OaDocumentForm) form;

        // Exceptions are caught by ActionExceptionHandler
        OaDocumentManager mgr = (OaDocumentManager) getBean("oaDocumentManager");
        mgr.removeOaDocument(oaDocumentForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("oaDocument.deleted"));

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

        OaDocumentForm oaDocumentForm = (OaDocumentForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (oaDocumentForm.getId() != null) {
            OaDocumentManager mgr = (OaDocumentManager) getBean("oaDocumentManager");
            OaDocument oaDocument = mgr.getOaDocument(oaDocumentForm.getId());
            oaDocumentForm = (OaDocumentForm) convert(oaDocument);
            updateFormBean(mapping, request, oaDocumentForm);
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
        OaDocumentForm oaDocumentForm = (OaDocumentForm) form;
        boolean isNew = ("".equals(oaDocumentForm.getId()) || oaDocumentForm.getId() == null);

        OaDocumentManager mgr = (OaDocumentManager) getBean("oaDocumentManager");
        OaDocument oaDocument = (OaDocument) convert(oaDocumentForm);
        mgr.saveOaDocument(oaDocument);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("oaDocument.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("oaDocument.updated"));
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

        OaDocumentForm oaDocumentForm = (OaDocumentForm) form;
        OaDocument oaDocument = (OaDocument) convert(oaDocumentForm);
        OaDocumentManager mgr = (OaDocumentManager) getBean("oaDocumentManager");
        oaDocument = null;
        int resultSize = Integer.parseInt(mgr.getOaDocumentsCount(oaDocument));
        Page page = new Page(Constants.OADOCUMENT_LIST,request);        
        PaginatedList pageList = mgr.getOaDocumentsPage(oaDocument,page.getPageIndex().toString(),page.getPageSize().toString());
        pageList.gotoPage(page.getPageIndex().intValue());   
        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.OADOCUMENT_LIST, pageList);                    
        //request.setAttribute(Constants.OADOCUMENT_LIST, mgr.getOaDocuments(oaDocument));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
