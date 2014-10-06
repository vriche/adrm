
package com.vriche.adrm.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import java.util.List;

import com.vriche.adrm.webapp.action.BaseAction;
import com.vriche.adrm.Constants;
import com.vriche.adrm.model.FinanceTarget;
import com.vriche.adrm.service.FinanceTargetManager;
import com.vriche.adrm.webapp.form.FinanceTargetForm;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a FinanceTarget object
 *
 * @struts.action name="financeTargetForm" path="/financeTargets" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="financeTargetForm" path="/editFinanceTarget" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="financeTargetForm" path="/saveFinanceTarget" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/finance/financeTargetForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/finance/financeTargetList.jsp"
 * @struts.action-forward name="search" path="/financeTargets.html" redirect="true"
 */
public final class FinanceTargetAction extends BaseAction {
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
        FinanceTargetForm financeTargetForm = (FinanceTargetForm) form;

        // Exceptions are caught by ActionExceptionHandler
        FinanceTargetManager mgr = (FinanceTargetManager) getBean("financeTargetManager");
        mgr.removeFinanceTarget(financeTargetForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("financeTarget.deleted"));

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

        FinanceTargetForm financeTargetForm = (FinanceTargetForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (financeTargetForm.getId() != null) {
            FinanceTargetManager mgr = (FinanceTargetManager) getBean("financeTargetManager");
            FinanceTarget financeTarget = mgr.getFinanceTarget(financeTargetForm.getId());
            financeTargetForm = (FinanceTargetForm) convert(financeTarget);
            updateFormBean(mapping, request, financeTargetForm);
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
        FinanceTargetForm financeTargetForm = (FinanceTargetForm) form;
        boolean isNew = ("".equals(financeTargetForm.getId()) || financeTargetForm.getId() == null);

        FinanceTargetManager mgr = (FinanceTargetManager) getBean("financeTargetManager");
        FinanceTarget financeTarget = (FinanceTarget) convert(financeTargetForm);
        mgr.saveFinanceTarget(financeTarget);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("financeTarget.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("financeTarget.updated"));
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

        FinanceTargetForm financeTargetForm = (FinanceTargetForm) form;
        FinanceTarget financeTarget = (FinanceTarget) convert(financeTargetForm);
        FinanceTargetManager mgr = (FinanceTargetManager) getBean("financeTargetManager");
        financeTarget = null;
        int resultSize = Integer.parseInt(mgr.getFinanceTargetsCount(financeTarget));
        Page page = new Page(Constants.FINANCETARGET_LIST,request);        
        List list = mgr.getFinanceTargetsPage(financeTarget,page.getPageIndex().toString(),page.getPageSize().toString());

        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.FINANCETARGET_LIST, list);                    
        //request.setAttribute(Constants.FINANCETARGET_LIST, mgr.getFinanceTargets(financeTarget));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
