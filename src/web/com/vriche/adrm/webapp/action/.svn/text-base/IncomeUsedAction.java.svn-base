
package com.vriche.adrm.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.vriche.adrm.model.IncomeUsed;
import com.vriche.adrm.service.IncomeUsedManager;
import com.vriche.adrm.webapp.action.BaseAction;
import com.vriche.adrm.webapp.form.IncomeUsedForm;
import com.vriche.adrm.Constants;

/**
 * Action class to handle CRUD on a IncomeUsed object
 *
 * @struts.action name="incomeUsedForm" path="/incomeUseds" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="incomeUsedForm" path="/editIncomeUsed" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="incomeUsedForm" path="/saveIncomeUsed" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/finance/incomeUsedForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/finance/incomeUsedList.jsp"
 * @struts.action-forward name="search" path="/incomeUseds.html" redirect="true"
 */
public final class IncomeUsedAction extends BaseAction {
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
        IncomeUsedForm incomeUsedForm = (IncomeUsedForm) form;

        // Exceptions are caught by ActionExceptionHandler
        IncomeUsedManager mgr = (IncomeUsedManager) getBean("incomeUsedManager");
        mgr.removeIncomeUsed(incomeUsedForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("incomeUsed.deleted"));

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

        IncomeUsedForm incomeUsedForm = (IncomeUsedForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (incomeUsedForm.getId() != null) {
            IncomeUsedManager mgr = (IncomeUsedManager) getBean("incomeUsedManager");
            IncomeUsed incomeUsed = mgr.getIncomeUsed(incomeUsedForm.getId());
            incomeUsedForm = (IncomeUsedForm) convert(incomeUsed);
            updateFormBean(mapping, request, incomeUsedForm);
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
        IncomeUsedForm incomeUsedForm = (IncomeUsedForm) form;
        boolean isNew = ("".equals(incomeUsedForm.getId()) || incomeUsedForm.getId() == null);

        IncomeUsedManager mgr = (IncomeUsedManager) getBean("incomeUsedManager");
        IncomeUsed incomeUsed = (IncomeUsed) convert(incomeUsedForm);
        mgr.saveIncomeUsed(incomeUsed);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("incomeUsed.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("incomeUsed.updated"));
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

        IncomeUsedForm incomeUsedForm = (IncomeUsedForm) form;
        IncomeUsed incomeUsed = (IncomeUsed) convert(incomeUsedForm);

        IncomeUsedManager mgr = (IncomeUsedManager) getBean("incomeUsedManager");
        request.setAttribute(Constants.INCOMEUSED_LIST, mgr.getIncomeUseds(incomeUsed));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
