
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
import com.vriche.adrm.model.OaDocumentCatalog;
import com.vriche.adrm.service.OaDocumentCatalogManager;
import com.vriche.adrm.webapp.form.OaDocumentCatalogForm;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a OaDocumentCatalog object
 *
 * @struts.action name="oaDocumentCatalogForm" path="/oaDocumentCatalogs" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="oaDocumentCatalogForm" path="/editOaDocumentCatalog" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="oaDocumentCatalogForm" path="/saveOaDocumentCatalog" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/document/oaDocumentCatalogForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/document/oaDocumentCatalogList.jsp"
 * @struts.action-forward name="search" path="/oaDocumentCatalogs.html" redirect="true"
 */
public final class OaDocumentCatalogAction extends BaseAction {
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
        OaDocumentCatalogForm oaDocumentCatalogForm = (OaDocumentCatalogForm) form;

        // Exceptions are caught by ActionExceptionHandler
        OaDocumentCatalogManager mgr = (OaDocumentCatalogManager) getBean("oaDocumentCatalogManager");
        mgr.removeOaDocumentCatalog(oaDocumentCatalogForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("oaDocumentCatalog.deleted"));

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

        OaDocumentCatalogForm oaDocumentCatalogForm = (OaDocumentCatalogForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (oaDocumentCatalogForm.getId() != null) {
            OaDocumentCatalogManager mgr = (OaDocumentCatalogManager) getBean("oaDocumentCatalogManager");
            OaDocumentCatalog oaDocumentCatalog = mgr.getOaDocumentCatalog(oaDocumentCatalogForm.getId());
            oaDocumentCatalogForm = (OaDocumentCatalogForm) convert(oaDocumentCatalog);
            updateFormBean(mapping, request, oaDocumentCatalogForm);
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
        OaDocumentCatalogForm oaDocumentCatalogForm = (OaDocumentCatalogForm) form;
        boolean isNew = ("".equals(oaDocumentCatalogForm.getId()) || oaDocumentCatalogForm.getId() == null);

        OaDocumentCatalogManager mgr = (OaDocumentCatalogManager) getBean("oaDocumentCatalogManager");
        OaDocumentCatalog oaDocumentCatalog = (OaDocumentCatalog) convert(oaDocumentCatalogForm);
        mgr.saveOaDocumentCatalog(oaDocumentCatalog);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("oaDocumentCatalog.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("oaDocumentCatalog.updated"));
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

        OaDocumentCatalogForm oaDocumentCatalogForm = (OaDocumentCatalogForm) form;
        OaDocumentCatalog oaDocumentCatalog = (OaDocumentCatalog) convert(oaDocumentCatalogForm);
        OaDocumentCatalogManager mgr = (OaDocumentCatalogManager) getBean("oaDocumentCatalogManager");
        oaDocumentCatalog = null;
        int resultSize = Integer.parseInt(mgr.getOaDocumentCatalogsCount(oaDocumentCatalog));
        Page page = new Page(Constants.OADOCUMENTCATALOG_LIST,request);        
        PaginatedList pageList = mgr.getOaDocumentCatalogsPage(oaDocumentCatalog,page.getPageIndex().toString(),page.getPageSize().toString());
        pageList.gotoPage(page.getPageIndex().intValue());   
        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.OADOCUMENTCATALOG_LIST, pageList);                    
        //request.setAttribute(Constants.OADOCUMENTCATALOG_LIST, mgr.getOaDocumentCatalogs(oaDocumentCatalog));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
