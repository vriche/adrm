
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
import com.vriche.adrm.model.OaDocumentCatalogPermitType;
import com.vriche.adrm.service.OaDocumentCatalogPermitTypeManager;
import com.vriche.adrm.webapp.form.OaDocumentCatalogPermitTypeForm;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a OaDocumentCatalogPermitType object
 *
 * @struts.action name="oaDocumentCatalogPermitTypeForm" path="/oaDocumentCatalogPermitTypes" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="oaDocumentCatalogPermitTypeForm" path="/editOaDocumentCatalogPermitType" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="oaDocumentCatalogPermitTypeForm" path="/saveOaDocumentCatalogPermitType" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/document/oaDocumentCatalogPermitTypeForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/document/oaDocumentCatalogPermitTypeList.jsp"
 * @struts.action-forward name="search" path="/oaDocumentCatalogPermitTypes.html" redirect="true"
 */
public final class OaDocumentCatalogPermitTypeAction extends BaseAction {
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
        OaDocumentCatalogPermitTypeForm oaDocumentCatalogPermitTypeForm = (OaDocumentCatalogPermitTypeForm) form;

        // Exceptions are caught by ActionExceptionHandler
        OaDocumentCatalogPermitTypeManager mgr = (OaDocumentCatalogPermitTypeManager) getBean("oaDocumentCatalogPermitTypeManager");
        mgr.removeOaDocumentCatalogPermitType(oaDocumentCatalogPermitTypeForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("oaDocumentCatalogPermitType.deleted"));

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

        OaDocumentCatalogPermitTypeForm oaDocumentCatalogPermitTypeForm = (OaDocumentCatalogPermitTypeForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (oaDocumentCatalogPermitTypeForm.getId() != null) {
            OaDocumentCatalogPermitTypeManager mgr = (OaDocumentCatalogPermitTypeManager) getBean("oaDocumentCatalogPermitTypeManager");
            OaDocumentCatalogPermitType oaDocumentCatalogPermitType = mgr.getOaDocumentCatalogPermitType(oaDocumentCatalogPermitTypeForm.getId());
            oaDocumentCatalogPermitTypeForm = (OaDocumentCatalogPermitTypeForm) convert(oaDocumentCatalogPermitType);
            updateFormBean(mapping, request, oaDocumentCatalogPermitTypeForm);
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
        OaDocumentCatalogPermitTypeForm oaDocumentCatalogPermitTypeForm = (OaDocumentCatalogPermitTypeForm) form;
        boolean isNew = ("".equals(oaDocumentCatalogPermitTypeForm.getId()) || oaDocumentCatalogPermitTypeForm.getId() == null);

        OaDocumentCatalogPermitTypeManager mgr = (OaDocumentCatalogPermitTypeManager) getBean("oaDocumentCatalogPermitTypeManager");
        OaDocumentCatalogPermitType oaDocumentCatalogPermitType = (OaDocumentCatalogPermitType) convert(oaDocumentCatalogPermitTypeForm);
        mgr.saveOaDocumentCatalogPermitType(oaDocumentCatalogPermitType);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("oaDocumentCatalogPermitType.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("oaDocumentCatalogPermitType.updated"));
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

        OaDocumentCatalogPermitTypeForm oaDocumentCatalogPermitTypeForm = (OaDocumentCatalogPermitTypeForm) form;
        OaDocumentCatalogPermitType oaDocumentCatalogPermitType = (OaDocumentCatalogPermitType) convert(oaDocumentCatalogPermitTypeForm);
        OaDocumentCatalogPermitTypeManager mgr = (OaDocumentCatalogPermitTypeManager) getBean("oaDocumentCatalogPermitTypeManager");
        oaDocumentCatalogPermitType = null;
        int resultSize = Integer.parseInt(mgr.getOaDocumentCatalogPermitTypesCount(oaDocumentCatalogPermitType));
        Page page = new Page(Constants.OADOCUMENTCATALOGPERMITTYPE_LIST,request);        
        PaginatedList pageList = mgr.getOaDocumentCatalogPermitTypesPage(oaDocumentCatalogPermitType,page.getPageIndex().toString(),page.getPageSize().toString());
        pageList.gotoPage(page.getPageIndex().intValue());   
        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.OADOCUMENTCATALOGPERMITTYPE_LIST, pageList);                    
        //request.setAttribute(Constants.OADOCUMENTCATALOGPERMITTYPE_LIST, mgr.getOaDocumentCatalogPermitTypes(oaDocumentCatalogPermitType));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
