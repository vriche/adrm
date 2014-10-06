
package com.vriche.adrm.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.vriche.adrm.model.IncomePurpose;
import com.vriche.adrm.service.IncomePurposeManager;
import com.vriche.adrm.webapp.action.BaseAction;
import com.vriche.adrm.webapp.form.IncomePurposeForm;
import com.vriche.adrm.Constants;

/**
 * Action class to handle CRUD on a IncomePurpose object
 *
 * @struts.action name="incomePurposeForm" path="/incomePurposes" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="incomePurposeForm" path="/editIncomePurpose" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="incomePurposeForm" path="/saveIncomePurpose" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/finance/incomePurposeForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/finance/incomePurposeList.jsp"
 * @struts.action-forward name="search" path="/incomePurposes.html" redirect="true"
 */
public final class IncomePurposeAction extends BaseAction {
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
        IncomePurposeForm incomePurposeForm = (IncomePurposeForm) form;

        // Exceptions are caught by ActionExceptionHandler
        IncomePurposeManager mgr = (IncomePurposeManager) getBean("incomePurposeManager");
        mgr.removeIncomePurpose(incomePurposeForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("incomePurpose.deleted"));

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

        IncomePurposeForm incomePurposeForm = (IncomePurposeForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (incomePurposeForm.getId() != null) {
            IncomePurposeManager mgr = (IncomePurposeManager) getBean("incomePurposeManager");
            IncomePurpose incomePurpose = mgr.getIncomePurpose(incomePurposeForm.getId());
            incomePurposeForm = (IncomePurposeForm) convert(incomePurpose);
            updateFormBean(mapping, request, incomePurposeForm);
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
        IncomePurposeForm incomePurposeForm = (IncomePurposeForm) form;
        boolean isNew = ("".equals(incomePurposeForm.getId()) || incomePurposeForm.getId() == null);

        IncomePurposeManager mgr = (IncomePurposeManager) getBean("incomePurposeManager");
        IncomePurpose incomePurpose = (IncomePurpose) convert(incomePurposeForm);
        mgr.saveIncomePurpose(incomePurpose);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("incomePurpose.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("incomePurpose.updated"));
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

        IncomePurposeForm incomePurposeForm = (IncomePurposeForm) form;
        IncomePurpose incomePurpose = (IncomePurpose) convert(incomePurposeForm);

        IncomePurposeManager mgr = (IncomePurposeManager) getBean("incomePurposeManager");
        request.setAttribute(Constants.INCOMEPURPOSE_LIST, mgr.getIncomePurposes(incomePurpose));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
