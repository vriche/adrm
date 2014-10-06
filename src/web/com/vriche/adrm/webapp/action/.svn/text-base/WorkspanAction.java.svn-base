
package com.vriche.adrm.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.vriche.adrm.model.Workspan;
import com.vriche.adrm.service.WorkspanManager;
import com.vriche.adrm.webapp.action.BaseAction;
import com.vriche.adrm.webapp.form.WorkspanForm;
import com.vriche.adrm.Constants;

/**
 * Action class to handle CRUD on a Workspan object
 *
 * @struts.action name="workspanForm" path="/workspans" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="workspanForm" path="/editWorkspan" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="workspanForm" path="/saveWorkspan" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/adres/workspanForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/adres/workspanList.jsp"
 * @struts.action-forward name="search" path="/workspans.html" redirect="true"
 */
public final class WorkspanAction extends BaseAction {
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
        WorkspanForm workspanForm = (WorkspanForm) form;

        // Exceptions are caught by ActionExceptionHandler
        WorkspanManager mgr = (WorkspanManager) getBean("workspanManager");
        mgr.removeWorkspan(workspanForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("workspan.deleted"));

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

        WorkspanForm workspanForm = (WorkspanForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (workspanForm.getId() != null) {
            WorkspanManager mgr = (WorkspanManager) getBean("workspanManager");
            Workspan workspan = mgr.getWorkspan(workspanForm.getId());
            workspanForm = (WorkspanForm) convert(workspan);
            updateFormBean(mapping, request, workspanForm);
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
        WorkspanForm workspanForm = (WorkspanForm) form;
        boolean isNew = ("".equals(workspanForm.getId()) || workspanForm.getId() == null);

        WorkspanManager mgr = (WorkspanManager) getBean("workspanManager");
        Workspan workspan = (Workspan) convert(workspanForm);
        mgr.saveWorkspan(workspan);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("workspan.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("workspan.updated"));
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

        WorkspanForm workspanForm = (WorkspanForm) form;
        Workspan workspan = (Workspan) convert(workspanForm);

        WorkspanManager mgr = (WorkspanManager) getBean("workspanManager");
        request.setAttribute(Constants.WORKSPAN_LIST, mgr.getWorkspans(workspan));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
