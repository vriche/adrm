
package com.vriche.adrm.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.vriche.adrm.model.IncomeMode;
import com.vriche.adrm.service.IncomeModeManager;
import com.vriche.adrm.webapp.action.BaseAction;
import com.vriche.adrm.webapp.form.IncomeModeForm;
import com.vriche.adrm.Constants;

/**
 * Action class to handle CRUD on a IncomeMode object
 *
 * @struts.action name="incomeModeForm" path="/incomeModes" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="incomeModeForm" path="/editIncomeMode" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="incomeModeForm" path="/saveIncomeMode" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/finance/incomeModeForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/finance/incomeModeList.jsp"
 * @struts.action-forward name="search" path="/incomeModes.html" redirect="true"
 */
public final class IncomeModeAction extends BaseAction {
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
        IncomeModeForm incomeModeForm = (IncomeModeForm) form;

        // Exceptions are caught by ActionExceptionHandler
        IncomeModeManager mgr = (IncomeModeManager) getBean("incomeModeManager");
        mgr.removeIncomeMode(incomeModeForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("incomeMode.deleted"));

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

        IncomeModeForm incomeModeForm = (IncomeModeForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (incomeModeForm.getId() != null) {
            IncomeModeManager mgr = (IncomeModeManager) getBean("incomeModeManager");
            IncomeMode incomeMode = mgr.getIncomeMode(incomeModeForm.getId());
            incomeModeForm = (IncomeModeForm) convert(incomeMode);
            updateFormBean(mapping, request, incomeModeForm);
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
        IncomeModeForm incomeModeForm = (IncomeModeForm) form;
        boolean isNew = ("".equals(incomeModeForm.getId()) || incomeModeForm.getId() == null);

        IncomeModeManager mgr = (IncomeModeManager) getBean("incomeModeManager");
        IncomeMode incomeMode = (IncomeMode) convert(incomeModeForm);
        mgr.saveIncomeMode(incomeMode);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("incomeMode.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("incomeMode.updated"));
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

        IncomeModeForm incomeModeForm = (IncomeModeForm) form;
        IncomeMode incomeMode = (IncomeMode) convert(incomeModeForm);

        IncomeModeManager mgr = (IncomeModeManager) getBean("incomeModeManager");
        request.setAttribute(Constants.INCOMEMODE_LIST, mgr.getIncomeModes(incomeMode));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
