
package com.vriche.adrm.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.vriche.adrm.model.IncomePull;
import com.vriche.adrm.service.IncomePullManager;
import com.vriche.adrm.webapp.action.BaseAction;
import com.vriche.adrm.webapp.form.IncomePullForm;
import com.vriche.adrm.Constants;

/**
 * Action class to handle CRUD on a IncomePull object
 *
 * @struts.action name="incomePullForm" path="/incomePulls" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="incomePullForm" path="/editIncomePull" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="incomePullForm" path="/saveIncomePull" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/finance/incomePullForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/finance/incomePullList.jsp"
 * @struts.action-forward name="search" path="/incomePulls.html" redirect="true"
 */
public final class IncomePullAction extends BaseAction {
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
        IncomePullForm incomePullForm = (IncomePullForm) form;

        // Exceptions are caught by ActionExceptionHandler
        IncomePullManager mgr = (IncomePullManager) getBean("incomePullManager");
        mgr.removeIncomePull(incomePullForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("incomePull.deleted"));

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

        IncomePullForm incomePullForm = (IncomePullForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (incomePullForm.getId() != null) {
            IncomePullManager mgr = (IncomePullManager) getBean("incomePullManager");
            IncomePull incomePull = mgr.getIncomePull(incomePullForm.getId());
            incomePullForm = (IncomePullForm) convert(incomePull);
            updateFormBean(mapping, request, incomePullForm);
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
        IncomePullForm incomePullForm = (IncomePullForm) form;
        boolean isNew = ("".equals(incomePullForm.getId()) || incomePullForm.getId() == null);

        IncomePullManager mgr = (IncomePullManager) getBean("incomePullManager");
        IncomePull incomePull = (IncomePull) convert(incomePullForm);
        mgr.saveIncomePull(incomePull);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("incomePull.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("incomePull.updated"));
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

        IncomePullForm incomePullForm = (IncomePullForm) form;
        IncomePull incomePull = (IncomePull) convert(incomePullForm);

        IncomePullManager mgr = (IncomePullManager) getBean("incomePullManager");
        request.setAttribute(Constants.INCOMEPULL_LIST, mgr.getIncomePulls(incomePull));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
