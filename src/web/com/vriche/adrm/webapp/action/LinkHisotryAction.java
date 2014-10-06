
package com.vriche.adrm.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.vriche.adrm.model.LinkHisotry;
import com.vriche.adrm.service.LinkHisotryManager;
import com.vriche.adrm.webapp.action.BaseAction;
import com.vriche.adrm.webapp.form.LinkHisotryForm;
import com.vriche.adrm.Constants;

/**
 * Action class to handle CRUD on a LinkHisotry object
 *
 * @struts.action name="linkHisotryForm" path="/linkHisotrys" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="linkHisotryForm" path="/editLinkHisotry" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="linkHisotryForm" path="/saveLinkHisotry" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/crm/linkHisotryForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/crm/linkHisotryList.jsp"
 * @struts.action-forward name="search" path="/linkHisotrys.html" redirect="true"
 */
public final class LinkHisotryAction extends BaseAction {
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
        LinkHisotryForm linkHisotryForm = (LinkHisotryForm) form;

        // Exceptions are caught by ActionExceptionHandler
        LinkHisotryManager mgr = (LinkHisotryManager) getBean("linkHisotryManager");
        mgr.removeLinkHisotry(linkHisotryForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("linkHisotry.deleted"));

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

        LinkHisotryForm linkHisotryForm = (LinkHisotryForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (linkHisotryForm.getId() != null) {
            LinkHisotryManager mgr = (LinkHisotryManager) getBean("linkHisotryManager");
            LinkHisotry linkHisotry = mgr.getLinkHisotry(linkHisotryForm.getId());
            linkHisotryForm = (LinkHisotryForm) convert(linkHisotry);
            updateFormBean(mapping, request, linkHisotryForm);
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
        LinkHisotryForm linkHisotryForm = (LinkHisotryForm) form;
        boolean isNew = ("".equals(linkHisotryForm.getId()) || linkHisotryForm.getId() == null);

        LinkHisotryManager mgr = (LinkHisotryManager) getBean("linkHisotryManager");
        LinkHisotry linkHisotry = (LinkHisotry) convert(linkHisotryForm);
        mgr.saveLinkHisotry(linkHisotry);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("linkHisotry.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("linkHisotry.updated"));
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

        LinkHisotryForm linkHisotryForm = (LinkHisotryForm) form;
        LinkHisotry linkHisotry = (LinkHisotry) convert(linkHisotryForm);

        LinkHisotryManager mgr = (LinkHisotryManager) getBean("linkHisotryManager");
        request.setAttribute(Constants.LINKHISOTRY_LIST, mgr.getLinkHisotrys(linkHisotry));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
